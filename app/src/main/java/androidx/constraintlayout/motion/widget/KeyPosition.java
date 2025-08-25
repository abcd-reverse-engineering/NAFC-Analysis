package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public class KeyPosition extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    String mTransitionEasing = null;
    int mPathMotionArc = Key.UNSET;
    int mDrawPath = 0;
    float mPercentWidth = Float.NaN;
    float mPercentHeight = Float.NaN;
    float mPercentX = Float.NaN;
    float mPercentY = Float.NaN;
    float mAltPercentX = Float.NaN;
    float mAltPercentY = Float.NaN;
    int mPositionType = 0;
    private float mCalculatedPositionX = Float.NaN;
    private float mCalculatedPositionY = Float.NaN;

    private static class Loader {
        private static final int CURVE_FIT = 4;
        private static final int DRAW_PATH = 5;
        private static final int FRAME_POSITION = 2;
        private static final int PATH_MOTION_ARC = 10;
        private static final int PERCENT_HEIGHT = 12;
        private static final int PERCENT_WIDTH = 11;
        private static final int PERCENT_X = 6;
        private static final int PERCENT_Y = 7;
        private static final int SIZE_PERCENT = 8;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TYPE = 9;
        private static SparseIntArray mAttrMap = new SparseIntArray();

        static {
            mAttrMap.append(R.styleable.KeyPosition_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyPosition_framePosition, 2);
            mAttrMap.append(R.styleable.KeyPosition_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyPosition_curveFit, 4);
            mAttrMap.append(R.styleable.KeyPosition_drawPath, 5);
            mAttrMap.append(R.styleable.KeyPosition_percentX, 6);
            mAttrMap.append(R.styleable.KeyPosition_percentY, 7);
            mAttrMap.append(R.styleable.KeyPosition_keyPositionType, 9);
            mAttrMap.append(R.styleable.KeyPosition_sizePercent, 8);
            mAttrMap.append(R.styleable.KeyPosition_percentWidth, 11);
            mAttrMap.append(R.styleable.KeyPosition_percentHeight, 12);
            mAttrMap.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            if (keyPosition.mTargetId == -1) {
                                keyPosition.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTargetId = typedArray.getResourceId(index, keyPosition.mTargetId);
                            break;
                        }
                    case 2:
                        keyPosition.mFramePosition = typedArray.getInt(index, keyPosition.mFramePosition);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.mTransitionEasing = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        keyPosition.mCurveFit = typedArray.getInteger(index, keyPosition.mCurveFit);
                        break;
                    case 5:
                        keyPosition.mDrawPath = typedArray.getInt(index, keyPosition.mDrawPath);
                        break;
                    case 6:
                        keyPosition.mPercentX = typedArray.getFloat(index, keyPosition.mPercentX);
                        break;
                    case 7:
                        keyPosition.mPercentY = typedArray.getFloat(index, keyPosition.mPercentY);
                        break;
                    case 8:
                        float f2 = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        keyPosition.mPercentWidth = f2;
                        keyPosition.mPercentHeight = f2;
                        break;
                    case 9:
                        keyPosition.mPositionType = typedArray.getInt(index, keyPosition.mPositionType);
                        break;
                    case 10:
                        keyPosition.mPathMotionArc = typedArray.getInt(index, keyPosition.mPathMotionArc);
                        break;
                    case 11:
                        keyPosition.mPercentWidth = typedArray.getFloat(index, keyPosition.mPercentWidth);
                        break;
                    case 12:
                        keyPosition.mPercentHeight = typedArray.getFloat(index, keyPosition.mPercentHeight);
                        break;
                    default:
                        String str = "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index);
                        break;
                }
            }
            int i3 = keyPosition.mFramePosition;
        }
    }

    public KeyPosition() {
        this.mType = 2;
    }

    private void calcCartesianPosition(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f9 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f10 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (f2 + (f8 * f6) + ((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f7));
        this.mCalculatedPositionY = (int) (f3 + (f6 * f9) + (f7 * f10));
    }

    private void calcPathPosition(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = this.mPercentX;
        float f9 = this.mPercentY;
        this.mCalculatedPositionX = f2 + (f6 * f8) + ((-f7) * f9);
        this.mCalculatedPositionY = f3 + (f7 * f8) + (f6 * f9);
    }

    private void calcScreenPosition(int i2, int i3) {
        float f2 = this.mPercentX;
        float f3 = 0;
        this.mCalculatedPositionX = ((i2 - 0) * f2) + f3;
        this.mCalculatedPositionY = ((i3 - 0) * f2) + f3;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void calcPosition(int i2, int i3, float f2, float f3, float f4, float f5) {
        int i4 = this.mPositionType;
        if (i4 == 1) {
            calcPathPosition(f2, f3, f4, f5);
        } else if (i4 != 2) {
            calcCartesianPosition(f2, f3, f4, f5);
        } else {
            calcScreenPosition(i2, i3);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i2, int i3, RectF rectF, RectF rectF2, float f2, float f3) {
        calcPosition(i2, i3, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f2 - this.mCalculatedPositionX) < 20.0f && Math.abs(f3 - this.mCalculatedPositionY) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        int i2 = this.mPositionType;
        if (i2 == 1) {
            positionPathAttributes(rectF, rectF2, f2, f3, strArr, fArr);
        } else if (i2 != 2) {
            positionCartAttributes(rectF, rectF2, f2, f3, strArr, fArr);
        } else {
            positionScreenAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
        }
    }

    void positionCartAttributes(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = (f2 - fCenterX) / fCenterX2;
            strArr[1] = PERCENT_Y;
            fArr[1] = (f3 - fCenterY) / fCenterY2;
            return;
        }
        if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = (f2 - fCenterX) / fCenterX2;
            fArr[1] = (f3 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f2 - fCenterX) / fCenterX2;
            fArr[0] = (f3 - fCenterY) / fCenterY2;
        }
    }

    void positionPathAttributes(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f4 = fCenterX2 / fHypot;
        float f5 = fCenterY2 / fHypot;
        float f6 = f3 - fCenterY;
        float f7 = f2 - fCenterX;
        float f8 = ((f4 * f6) - (f7 * f5)) / fHypot;
        float f9 = ((f4 * f7) + (f5 * f6)) / fHypot;
        if (strArr[0] != null) {
            if (PERCENT_X.equals(strArr[0])) {
                fArr[0] = f9;
                fArr[1] = f8;
                return;
            }
            return;
        }
        strArr[0] = PERCENT_X;
        strArr[1] = PERCENT_Y;
        fArr[0] = f9;
        fArr[1] = f8;
    }

    void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (strArr[0] == null) {
            strArr[0] = PERCENT_X;
            fArr[0] = f2 / width;
            strArr[1] = PERCENT_Y;
            fArr[1] = f3 / height;
            return;
        }
        if (PERCENT_X.equals(strArr[0])) {
            fArr[0] = f2 / width;
            fArr[1] = f3 / height;
        } else {
            fArr[1] = f2 / width;
            fArr[0] = f3 / height;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setValue(java.lang.String r2, java.lang.Object r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1812823328: goto L44;
                case -1127236479: goto L3a;
                case -1017587252: goto L30;
                case -827014263: goto L26;
                case -200259324: goto L1c;
                case 428090547: goto L12;
                case 428090548: goto L8;
                default: goto L7;
            }
        L7:
            goto L4e
        L8:
            java.lang.String r0 = "percentY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 6
            goto L4f
        L12:
            java.lang.String r0 = "percentX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 5
            goto L4f
        L1c:
            java.lang.String r0 = "sizePercent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 4
            goto L4f
        L26:
            java.lang.String r0 = "drawPath"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 1
            goto L4f
        L30:
            java.lang.String r0 = "percentHeight"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 3
            goto L4f
        L3a:
            java.lang.String r0 = "percentWidth"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 2
            goto L4f
        L44:
            java.lang.String r0 = "transitionEasing"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L4e
            r2 = 0
            goto L4f
        L4e:
            r2 = -1
        L4f:
            switch(r2) {
                case 0: goto L7f;
                case 1: goto L78;
                case 2: goto L71;
                case 3: goto L6a;
                case 4: goto L61;
                case 5: goto L5a;
                case 6: goto L53;
                default: goto L52;
            }
        L52:
            goto L85
        L53:
            float r2 = r1.toFloat(r3)
            r1.mPercentY = r2
            goto L85
        L5a:
            float r2 = r1.toFloat(r3)
            r1.mPercentX = r2
            goto L85
        L61:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            r1.mPercentHeight = r2
            goto L85
        L6a:
            float r2 = r1.toFloat(r3)
            r1.mPercentHeight = r2
            goto L85
        L71:
            float r2 = r1.toFloat(r3)
            r1.mPercentWidth = r2
            goto L85
        L78:
            int r2 = r1.toInt(r3)
            r1.mDrawPath = r2
            goto L85
        L7f:
            java.lang.String r2 = r3.toString()
            r1.mTransitionEasing = r2
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyPosition.setValue(java.lang.String, java.lang.Object):void");
    }
}
