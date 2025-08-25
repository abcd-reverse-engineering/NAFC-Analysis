package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    View mView;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[this.MAX_DIMENSION];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;

    MotionController(View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (this.mStaggerScale != 1.0d) {
            if (f2 < this.mStaggerOffset) {
                f2 = 0.0f;
            }
            float f4 = this.mStaggerOffset;
            if (f2 > f4 && f2 < 1.0d) {
                f2 = (f2 - f4) * this.mStaggerScale;
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f5 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f6 = next.time;
                if (f6 < f2) {
                    easing = easing2;
                    f3 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = next.time;
                }
            }
        }
        if (easing != null) {
            float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f3;
            double d2 = (f2 - f3) / f7;
            f2 = (((float) easing.get(d2)) * f7) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d2);
            }
        }
        return f2;
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f2 = 1.0f / 99;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        float fHypot = 0.0f;
        while (i2 < 100) {
            float f3 = i2 * f2;
            double d4 = f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f4 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f5 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                float f6 = f2;
                if (easing2 != null) {
                    float f7 = next.time;
                    if (f7 < f3) {
                        f5 = f7;
                        easing = easing2;
                    } else if (Float.isNaN(f4)) {
                        f4 = next.time;
                    }
                }
                f2 = f6;
            }
            float f8 = f2;
            if (easing != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                d4 = (((float) easing.get((f3 - f5) / r16)) * (f4 - f5)) + f5;
            }
            this.mSpline[0].getPos(d4, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i2 > 0) {
                fHypot = (float) (fHypot + Math.hypot(d3 - fArr[1], d2 - fArr[0]));
            }
            d2 = fArr[0];
            d3 = fArr[1];
            i2++;
            f2 = f8;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            String str = " KeyPath positon \"" + motionPaths.position + "\" outside of range";
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    void addKey(Key key) {
        this.mKeyList.add(key);
    }

    void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f3 = i3 * f2;
            float f4 = 0.0f;
            if (this.mStaggerScale != 1.0f) {
                if (f3 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                float f5 = this.mStaggerOffset;
                if (f3 > f5 && f3 < 1.0d) {
                    f3 = (f3 - f5) * this.mStaggerScale;
                }
            }
            double d2 = f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f6 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f7 = next.time;
                    if (f7 < f3) {
                        easing = easing2;
                        f4 = f7;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                d2 = (((float) easing.get((f3 - f4) / r11)) * (f6 - f4)) + f4;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
        }
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().mMode;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : timePoints) {
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().mMode;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : timePoints) {
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    void buildPath(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / (i3 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i4 = 0;
        while (i4 < i3) {
            float f4 = i4 * f3;
            float f5 = 0.0f;
            if (this.mStaggerScale != f2) {
                if (f4 < this.mStaggerOffset) {
                    f4 = 0.0f;
                }
                float f6 = this.mStaggerOffset;
                if (f4 > f6 && f4 < 1.0d) {
                    f4 = (f4 - f6) * this.mStaggerScale;
                }
            }
            double d2 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f7 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f8 = next.time;
                    if (f8 < f4) {
                        f5 = f8;
                        easing = easing2;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d2 = (((float) easing.get((f4 - f5) / r16)) * (f7 - f5)) + f5;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            int i5 = i4 * 2;
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            if (keyCycleOscillator != null) {
                fArr[i5] = fArr[i5] + keyCycleOscillator.get(f4);
            } else if (splineSet != null) {
                fArr[i5] = fArr[i5] + splineSet.get(f4);
            }
            if (keyCycleOscillator2 != null) {
                int i6 = i5 + 1;
                fArr[i6] = fArr[i6] + keyCycleOscillator2.get(f4);
            } else if (splineSet2 != null) {
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] + splineSet2.get(f4);
            }
            i4++;
            i3 = i2;
            f2 = 1.0f;
        }
    }

    void buildRect(float f2, float[] fArr, int i2) {
        this.mSpline[0].getPos(getAdjustedPosition(f2, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    void buildRectangles(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            this.mSpline[0].getPos(getAdjustedPosition(i3 * f2, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
        }
    }

    int getAttributeValues(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.get(i3 / (fArr.length - 1));
        }
        return fArr.length;
    }

    void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f5 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.x;
            float f7 = motionPaths.y - motionPaths2.y;
            float f8 = (motionPaths.width - motionPaths2.width) + f6;
            float f9 = (motionPaths.height - motionPaths2.height) + f7;
            fArr[0] = (f6 * (1.0f - f3)) + (f8 * f3);
            fArr[1] = (f7 * (1.0f - f4)) + (f9 * f4);
            return;
        }
        double d2 = adjustedPosition;
        curveFitArr[0].getSlope(d2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d2, this.mInterpolateData);
        float f10 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i2 >= dArr.length) {
                break;
            }
            dArr[i2] = dArr[i2] * f10;
            i2++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d2, dArr2);
            this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    float getFinalX() {
        return this.mEndMotionPath.x;
    }

    float getFinalY() {
        return this.mEndMotionPath.y;
    }

    MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            if (next.mType == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i5 = i4 + 1;
                iArr[i5] = next.mType;
                int i6 = i5 + 1;
                iArr[i6] = next.mFramePosition;
                this.mSpline[0].getPos(r8 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i7 = i6 + 1;
                iArr[i7] = Float.floatToIntBits(fArr[0]);
                int i8 = i7 + 1;
                iArr[i8] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i9 = i8 + 1;
                    iArr[i9] = keyPosition.mPositionType;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(keyPosition.mPercentX);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i11 = i8 + 1;
                iArr[i4] = i11 - i4;
                i3++;
                i4 = i11;
            }
        }
        return i3;
    }

    float getKeyFrameParameter(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f4 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f5 = motionPaths2.x;
        float f6 = f4 - f5;
        float f7 = motionPaths.y;
        float f8 = motionPaths2.y;
        float f9 = f7 - f8;
        float f10 = f5 + (motionPaths2.width / 2.0f);
        float f11 = f8 + (motionPaths2.height / 2.0f);
        float fHypot = (float) Math.hypot(f6, f9);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot(f12, f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f12 * f6) + (f13 * f9);
        if (i2 == 0) {
            return f14 / fHypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f14 * f14));
        }
        if (i2 == 2) {
            return f12 / f6;
        }
        if (i2 == 3) {
            return f13 / f6;
        }
        if (i2 == 4) {
            return f12 / f9;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f13 / f9;
    }

    KeyPositionBase getPositionKeyframe(int i2, int i3, float f2, float f3) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        rectF.left = motionPaths.x;
        rectF.top = motionPaths.y;
        rectF.right = rectF.left + motionPaths.width;
        rectF.bottom = rectF.top + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        rectF2.left = motionPaths2.x;
        rectF2.top = motionPaths2.y;
        rectF2.right = rectF2.left + motionPaths2.width;
        rectF2.bottom = rectF2.top + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i2, i3, rectF, rectF2, f2, f3)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    void getPostLayoutDvDp(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, SplineSet> map3 = this.mAttributesMap;
        SplineSet splineSet3 = map3 == null ? null : map3.get("rotation");
        HashMap<String, SplineSet> map4 = this.mAttributesMap;
        SplineSet splineSet4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, SplineSet> map5 = this.mAttributesMap;
        SplineSet splineSet5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, KeyCycleOscillator> map6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, KeyCycleOscillator> map7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, KeyCycleOscillator> map8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = map8 == null ? null : map8.get("rotation");
        HashMap<String, KeyCycleOscillator> map9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, KeyCycleOscillator> map10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d2 = adjustedPosition;
                curveFit.getPos(d2, dArr);
                this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f5 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.x;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f7 = motionPaths.y - motionPaths2.y;
            KeyCycleOscillator keyCycleOscillator7 = keyCycleOscillator4;
            float f8 = (motionPaths.width - motionPaths2.width) + f6;
            float f9 = (motionPaths.height - motionPaths2.height) + f7;
            fArr[0] = (f6 * (1.0f - f3)) + (f8 * f3);
            fArr[1] = (f7 * (1.0f - f4)) + (f9 * f4);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator7, keyCycleOscillator6, adjustedPosition);
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f10 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i4 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
                return;
            } else {
                dArr2[i4] = dArr2[i4] * f10;
                i4++;
            }
        }
    }

    float getStartX() {
        return this.mStartMotionPath.x;
    }

    float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            iArr[i2] = (next.mType * 1000) + next.mFramePosition;
            this.mSpline[0].getPos(r6 / 100.0f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    boolean interpolate(View view, float f2, long j2, KeyCache keyCache) {
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean pathRotate2;
        double d2;
        float adjustedPosition = getAdjustedPosition(f2, null);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            Iterator<SplineSet> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view, adjustedPosition);
            }
        }
        HashMap<String, TimeCycleSplineSet> map2 = this.mTimeCycleAttributesMap;
        if (map2 != null) {
            pathRotate = null;
            boolean property = false;
            for (TimeCycleSplineSet timeCycleSplineSet : map2.values()) {
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                    pathRotate = (TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                } else {
                    property |= timeCycleSplineSet.setProperty(view, adjustedPosition, j2, keyCache);
                }
            }
            pathRotate2 = property;
        } else {
            pathRotate = null;
            pathRotate2 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d3 = adjustedPosition;
            curveFitArr[0].getPos(d3, this.mInterpolateData);
            this.mSpline[0].getSlope(d3, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d3, dArr);
                    this.mArcSpline.getSlope(d3, this.mInterpolateVelocity);
                }
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            HashMap<String, SplineSet> map3 = this.mAttributesMap;
            if (map3 != null) {
                for (SplineSet splineSet : map3.values()) {
                    if (splineSet instanceof SplineSet.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        d2 = d3;
                        ((SplineSet.PathRotate) splineSet).setPathRotate(view, adjustedPosition, dArr2[0], dArr2[1]);
                    } else {
                        d2 = d3;
                    }
                    d3 = d2;
                }
            }
            double d4 = d3;
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                pathRotate2 = pathRotate.setPathRotate(view, keyCache, adjustedPosition, j2, dArr3[0], dArr3[1]) | pathRotate2;
            }
            int i2 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i2 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i2].getPos(d4, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i2 - 1]).setInterpolatedValue(view, this.mValuesBuff);
                i2++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.visibility);
                } else if (adjustedPosition >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i3 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i3 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i3].conditionallyFire(adjustedPosition, view);
                    i3++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f3 = motionPaths.x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f4 = f3 + ((motionPaths2.x - f3) * adjustedPosition);
            float f5 = motionPaths.y;
            float f6 = f5 + ((motionPaths2.y - f5) * adjustedPosition);
            float f7 = motionPaths.width;
            float f8 = motionPaths2.width;
            float f9 = motionPaths.height;
            float f10 = motionPaths2.height;
            float f11 = f4 + 0.5f;
            int i4 = (int) f11;
            float f12 = f6 + 0.5f;
            int i5 = (int) f12;
            int i6 = (int) (f11 + ((f8 - f7) * adjustedPosition) + f7);
            int i7 = (int) (f12 + ((f10 - f9) * adjustedPosition) + f9);
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (f8 != f7 || f10 != f9) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            }
            view.layout(i4, i5, i6, i7);
        }
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            for (KeyCycleOscillator keyCycleOscillator : map4.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    keyCycleOscillator.setProperty(view, adjustedPosition);
                }
            }
        }
        return pathRotate2;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f2, float f3, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        rectF.left = motionPaths.x;
        rectF.top = motionPaths.y;
        rectF.right = rectF.left + motionPaths.width;
        rectF.bottom = rectF.top + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        rectF2.left = motionPaths2.x;
        rectF2.top = motionPaths2.y;
        rectF2.right = rectF2.left + motionPaths2.width;
        rectF2.bottom = rectF2.top + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        TimeCycleSplineSet timeCycleSplineSetMakeSpline;
        ConstraintAttribute constraintAttribute;
        SplineSet splineSetMakeSpline;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i4 = this.mPathMotionArc;
        if (i4 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i4;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i2, i3, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i5 = keyPosition.mCurveFit;
                    if (i5 != Key.UNSET) {
                        this.mCurveFitType = i5;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(map);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[c2];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next3 = it3.next();
                        HashMap<String, ConstraintAttribute> map2 = next3.mCustomConstraints;
                        if (map2 != null && (constraintAttribute2 = map2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute2);
                        }
                    }
                    splineSetMakeSpline = SplineSet.makeCustomSpline(next2, sparseArray);
                } else {
                    splineSetMakeSpline = SplineSet.makeSpline(next2);
                }
                if (splineSetMakeSpline != null) {
                    splineSetMakeSpline.setType(next2);
                    this.mAttributesMap.put(next2, splineSetMakeSpline);
                }
                c2 = 1;
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next4 = it4.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                this.mAttributesMap.get(str2).setup(map.containsKey(str2) ? map.get(str2).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next6 = it6.next();
                            HashMap<String, ConstraintAttribute> map3 = next6.mCustomConstraints;
                            if (map3 != null && (constraintAttribute = map3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute);
                            }
                        }
                        timeCycleSplineSetMakeSpline = TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                    } else {
                        timeCycleSplineSetMakeSpline = TimeCycleSplineSet.makeSpline(next5, j2);
                    }
                    if (timeCycleSplineSetMakeSpline != null) {
                        timeCycleSplineSetMakeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, timeCycleSplineSetMakeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next7 = it7.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(map.containsKey(str4) ? map.get(str4).intValue() : 0);
            }
        }
        MotionPaths[] motionPathsArr = new MotionPaths[this.mMotionPaths.size() + 2];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[motionPathsArr.length - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i6 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i6] = it8.next();
            i6++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        this.mAttributeNames = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeInterpCount = new int[this.mAttributeNames.length];
        int i7 = 0;
        while (true) {
            String[] strArr = this.mAttributeNames;
            if (i7 >= strArr.length) {
                break;
            }
            String str6 = strArr[i7];
            this.mAttributeInterpCount[i7] = 0;
            int i8 = 0;
            while (true) {
                if (i8 >= motionPathsArr.length) {
                    break;
                }
                if (motionPathsArr[i8].attributes.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i7] = iArr[i7] + motionPathsArr[i8].attributes.get(str6).noOfInterpValues();
                    break;
                }
                i8++;
            }
            i7++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != Key.UNSET;
        boolean[] zArr = new boolean[18 + this.mAttributeNames.length];
        for (int i9 = 1; i9 < motionPathsArr.length; i9++) {
            motionPathsArr[i9].different(motionPathsArr[i9 - 1], zArr, this.mAttributeNames, z);
        }
        int i10 = 0;
        for (int i11 = 1; i11 < zArr.length; i11++) {
            if (zArr[i11]) {
                i10++;
            }
        }
        this.mInterpolateVariables = new int[i10];
        int[] iArr2 = this.mInterpolateVariables;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i12 = 0;
        for (int i13 = 1; i13 < zArr.length; i13++) {
            if (zArr[i13]) {
                this.mInterpolateVariables[i12] = i13;
                i12++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, motionPathsArr.length, this.mInterpolateVariables.length);
        double[] dArr2 = new double[motionPathsArr.length];
        for (int i14 = 0; i14 < motionPathsArr.length; i14++) {
            motionPathsArr[i14].fillStandard(dArr[i14], this.mInterpolateVariables);
            dArr2[i14] = motionPathsArr[i14].time;
        }
        int i15 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i15 >= iArr3.length) {
                break;
            }
            if (iArr3[i15] < MotionPaths.names.length) {
                String str7 = MotionPaths.names[this.mInterpolateVariables[i15]] + " [";
                for (int i16 = 0; i16 < motionPathsArr.length; i16++) {
                    str7 = str7 + dArr[i16][i15];
                }
            }
            i15++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i17 = 0;
        while (true) {
            String[] strArr2 = this.mAttributeNames;
            if (i17 >= strArr2.length) {
                break;
            }
            String str8 = strArr2[i17];
            double[] dArr3 = null;
            int i18 = 0;
            double[][] dArr4 = null;
            for (int i19 = 0; i19 < motionPathsArr.length; i19++) {
                if (motionPathsArr[i19].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[motionPathsArr.length];
                        dArr4 = (double[][]) Array.newInstance((Class<?>) double.class, motionPathsArr.length, motionPathsArr[i19].getCustomDataCount(str8));
                    }
                    dArr3[i18] = motionPathsArr[i19].time;
                    motionPathsArr[i19].getCustomData(str8, dArr4[i18], 0);
                    i18++;
                }
            }
            i17++;
            this.mSpline[i17] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i18), (double[][]) Arrays.copyOf(dArr4, i18));
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int length = motionPathsArr.length;
            int[] iArr4 = new int[length];
            double[] dArr5 = new double[length];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) double.class, length, 2);
            for (int i20 = 0; i20 < length; i20++) {
                iArr4[i20] = motionPathsArr[i20].mPathMotionArc;
                dArr5[i20] = motionPathsArr[i20].time;
                dArr6[i20][0] = motionPathsArr[i20].x;
                dArr6[i20][1] = motionPathsArr[i20].y;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        float preCycleDistance = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next8 = it9.next();
                KeyCycleOscillator keyCycleOscillatorMakeSpline = KeyCycleOscillator.makeSpline(next8);
                if (keyCycleOscillatorMakeSpline != null) {
                    if (keyCycleOscillatorMakeSpline.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    keyCycleOscillatorMakeSpline.setType(next8);
                    this.mCycleMap.put(next8, keyCycleOscillatorMakeSpline);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it11 = this.mCycleMap.values().iterator();
            while (it11.hasNext()) {
                it11.next().setup(preCycleDistance);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
