package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "pathRotate"};
    private float height;
    private Easing mKeyFrameEasing;
    private float position;
    int visibility;
    private float width;
    private float x;
    private float y;
    private float alpha = 1.0f;
    int mVisibilityMode = 0;
    private boolean applyElevation = false;
    private float elevation = 0.0f;
    private float rotation = 0.0f;
    private float rotationX = 0.0f;
    public float rotationY = 0.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float translationX = 0.0f;
    private float translationY = 0.0f;
    private float translationZ = 0.0f;
    private int mDrawPath = 0;
    private float mPathRotate = Float.NaN;
    private float mProgress = Float.NaN;
    LinkedHashMap<String, ConstraintAttribute> attributes = new LinkedHashMap<>();
    int mMode = 0;
    double[] mTempValue = new double[18];
    double[] mTempDelta = new double[18];

    private boolean diff(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void addValues(HashMap<String, SplineSet> map, int i2) {
        for (String str : map.keySet()) {
            SplineSet splineSet = map.get(str);
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    splineSet.setPoint(i2, Float.isNaN(this.alpha) ? 1.0f : this.alpha);
                    break;
                case 1:
                    splineSet.setPoint(i2, Float.isNaN(this.elevation) ? 0.0f : this.elevation);
                    break;
                case 2:
                    splineSet.setPoint(i2, Float.isNaN(this.rotation) ? 0.0f : this.rotation);
                    break;
                case 3:
                    splineSet.setPoint(i2, Float.isNaN(this.rotationX) ? 0.0f : this.rotationX);
                    break;
                case 4:
                    splineSet.setPoint(i2, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case 5:
                    splineSet.setPoint(i2, Float.isNaN(this.mPivotX) ? 0.0f : this.mPivotX);
                    break;
                case 6:
                    splineSet.setPoint(i2, Float.isNaN(this.mPivotY) ? 0.0f : this.mPivotY);
                    break;
                case 7:
                    splineSet.setPoint(i2, Float.isNaN(this.mPathRotate) ? 0.0f : this.mPathRotate);
                    break;
                case '\b':
                    splineSet.setPoint(i2, Float.isNaN(this.mProgress) ? 0.0f : this.mProgress);
                    break;
                case '\t':
                    splineSet.setPoint(i2, Float.isNaN(this.scaleX) ? 1.0f : this.scaleX);
                    break;
                case '\n':
                    splineSet.setPoint(i2, Float.isNaN(this.scaleY) ? 1.0f : this.scaleY);
                    break;
                case 11:
                    splineSet.setPoint(i2, Float.isNaN(this.translationX) ? 0.0f : this.translationX);
                    break;
                case '\f':
                    splineSet.setPoint(i2, Float.isNaN(this.translationY) ? 0.0f : this.translationY);
                    break;
                case '\r':
                    splineSet.setPoint(i2, Float.isNaN(this.translationZ) ? 0.0f : this.translationZ);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)[1];
                        if (this.attributes.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.attributes.get(str2);
                            if (splineSet instanceof SplineSet.CustomSet) {
                                ((SplineSet.CustomSet) splineSet).setPoint(i2, constraintAttribute);
                                break;
                            } else {
                                String str3 = str + " splineSet not a CustomSet frame = " + i2 + ", value" + constraintAttribute.getValueToInterpolate() + splineSet;
                                break;
                            }
                        } else {
                            String str4 = "UNKNOWN customName " + str2;
                            break;
                        }
                    } else {
                        String str5 = "UNKNOWN spline " + str;
                        break;
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.visibility = view.getVisibility();
        this.alpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.applyElevation = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = view.getElevation();
        }
        this.rotation = view.getRotation();
        this.rotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.scaleX = view.getScaleX();
        this.scaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.translationX = view.getTranslationX();
        this.translationY = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.translationZ = view.getTranslationZ();
        }
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.alpha, motionConstrainedPoint.alpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.elevation, motionConstrainedPoint.elevation)) {
            hashSet.add("elevation");
        }
        int i2 = this.visibility;
        int i3 = motionConstrainedPoint.visibility;
        if (i2 != i3 && this.mVisibilityMode == 0 && (i2 == 0 || i3 == 0)) {
            hashSet.add("alpha");
        }
        if (diff(this.rotation, motionConstrainedPoint.rotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add(NotificationCompat.CATEGORY_PROGRESS);
        }
        if (diff(this.rotationX, motionConstrainedPoint.rotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add("transformPivotY");
        }
        if (diff(this.scaleX, motionConstrainedPoint.scaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.scaleY, motionConstrainedPoint.scaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.translationX, motionConstrainedPoint.translationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.translationY, motionConstrainedPoint.translationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.translationZ, motionConstrainedPoint.translationZ)) {
            hashSet.add("translationZ");
        }
    }

    void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.alpha, this.elevation, this.rotation, this.rotationX, this.rotationY, this.scaleX, this.scaleY, this.mPivotX, this.mPivotY, this.translationX, this.translationY, this.translationZ, this.mPathRotate};
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < fArr.length) {
                dArr[i2] = fArr[iArr[i3]];
                i2++;
            }
        }
    }

    int getCustomData(String str, double[] dArr, int i2) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i2] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNoOfInterpValues = constraintAttribute.noOfInterpValues();
        constraintAttribute.getValuesToInterpolate(new float[iNoOfInterpValues]);
        int i3 = 0;
        while (i3 < iNoOfInterpValues) {
            dArr[i2] = r1[i3];
            i3++;
            i2++;
        }
        return iNoOfInterpValues;
    }

    int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.position, motionConstrainedPoint.position);
    }

    public void setState(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i2) {
        setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        applyParameters(constraintSet.getParameters(i2));
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        this.mVisibilityMode = propertySet.mVisibilityMode;
        int i2 = propertySet.visibility;
        this.visibility = i2;
        this.alpha = (i2 == 0 || this.mVisibilityMode != 0) ? constraint.propertySet.alpha : 0.0f;
        ConstraintSet.Transform transform = constraint.transform;
        this.applyElevation = transform.applyElevation;
        this.elevation = transform.elevation;
        this.rotation = transform.rotation;
        this.rotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.scaleX = transform.scaleX;
        this.scaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.translationX = transform.translationX;
        this.translationY = transform.translationY;
        this.translationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.position, motionConstrainedPoint.position);
        zArr[1] = zArr[1] | diff(this.x, motionConstrainedPoint.x);
        zArr[2] = zArr[2] | diff(this.y, motionConstrainedPoint.y);
        zArr[3] = zArr[3] | diff(this.width, motionConstrainedPoint.width);
        zArr[4] = diff(this.height, motionConstrainedPoint.height) | zArr[4];
    }
}
