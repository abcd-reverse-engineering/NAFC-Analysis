package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    static class AlphaSet extends KeyCycleOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setAlpha(get(f2));
        }
    }

    static class CustomSet extends KeyCycleOscillator {
        float[] value = new float[1];

        CustomSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            this.value[0] = get(f2);
            this.mCustom.setInterpolatedValue(view, this.value);
        }
    }

    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffset;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;
        Oscillator mOscillator = new Oscillator();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        CycleOscillator(int i2, int i3, int i4) {
            this.mWaveShape = i2;
            this.mVariesBy = i3;
            this.mOscillator.setType(i2);
            this.mValues = new float[i4];
            this.mPosition = new double[i4];
            this.mPeriod = new float[i4];
            this.mOffset = new float[i4];
            this.mScale = new float[i4];
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        public double getSlope(float f2) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d2 = f2;
                curveFit.getSlope(d2, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d2, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d3 = f2;
            double value = this.mOscillator.getValue(d3);
            double slope = this.mOscillator.getSlope(d3);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[1]) + (slope * this.mSplineValueCache[1]);
        }

        public double getValues(float f2) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f2, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mValues[0];
            }
            return this.mSplineValueCache[0] + (this.mOscillator.getValue(f2) * this.mSplineValueCache[1]);
        }

        public void setPoint(int i2, int i3, float f2, float f3, float f4) {
            this.mPosition[i2] = i3 / 100.0d;
            this.mPeriod[i2] = f2;
            this.mOffset[i2] = f3;
            this.mValues[i2] = f4;
        }

        public void setup(float f2) {
            this.mPathLength = f2;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, this.mPosition.length, 2);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 1];
            this.mSplineSlopeCache = new double[fArr.length + 1];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2][0] = this.mOffset[i2];
                int i3 = 0;
                while (true) {
                    if (i3 < this.mValues.length) {
                        dArr[i3][1] = r4[i3];
                        i3++;
                    }
                }
                this.mOscillator.addPoint(this.mPosition[i2], this.mPeriod[i2]);
            }
            this.mOscillator.normalize();
            double[] dArr3 = this.mPosition;
            if (dArr3.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr3, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    static class ElevationSet extends KeyCycleOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f2));
            }
        }
    }

    private static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int partition(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, i5, i3);
            return i5;
        }

        static void sort(int[] iArr, float[] fArr, int i2, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int iPartition = partition(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = iPartition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = iPartition + 1;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    private static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    swap(iArr, fArr, fArr2, i5, i2);
                    i5++;
                }
                i2++;
            }
            swap(iArr, fArr, fArr2, i5, i3);
            return i5;
        }

        static void sort(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int iPartition = partition(iArr, fArr, fArr2, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = iPartition - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = iPartition + 1;
                }
            }
        }

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
            float f3 = fArr2[i2];
            fArr2[i2] = fArr2[i3];
            fArr2[i3] = f3;
        }
    }

    static class PathRotateSet extends KeyCycleOscillator {
        PathRotateSet() {
        }

        public void setPathRotate(View view, float f2, double d2, double d3) {
            view.setRotation(get(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
        }
    }

    static class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(f2)));
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            }
        }
    }

    static class RotationSet extends KeyCycleOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setRotation(get(f2));
        }
    }

    static class RotationXset extends KeyCycleOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setRotationX(get(f2));
        }
    }

    static class RotationYset extends KeyCycleOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setRotationY(get(f2));
        }
    }

    static class ScaleXset extends KeyCycleOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setScaleX(get(f2));
        }
    }

    static class ScaleYset extends KeyCycleOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setScaleY(get(f2));
        }
    }

    static class TranslationXset extends KeyCycleOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setTranslationX(get(f2));
        }
    }

    static class TranslationYset extends KeyCycleOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            view.setTranslationY(get(f2));
        }
    }

    static class TranslationZset extends KeyCycleOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.KeyCycleOscillator
        public void setProperty(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f2));
            }
        }
    }

    static class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int i2, float f2, float f3, float f4) {
            this.mPosition = i2;
            this.mValue = f4;
            this.mOffset = f3;
            this.mPeriod = f2;
        }
    }

    static KeyCycleOscillator makeSpline(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        switch (str) {
            case "alpha":
                return new AlphaSet();
            case "elevation":
                return new ElevationSet();
            case "rotation":
                return new RotationSet();
            case "rotationX":
                return new RotationXset();
            case "rotationY":
                return new RotationYset();
            case "transitionPathRotate":
                return new PathRotateSet();
            case "scaleX":
                return new ScaleXset();
            case "scaleY":
                return new ScaleYset();
            case "waveOffset":
                return new AlphaSet();
            case "waveVariesBy":
                return new AlphaSet();
            case "translationX":
                return new TranslationXset();
            case "translationY":
                return new TranslationYset();
            case "translationZ":
                return new TranslationZset();
            case "progress":
                return new ProgressSet();
            default:
                return null;
        }
    }

    public float get(float f2) {
        return (float) this.mCycleOscillator.getValues(f2);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f2) {
        return (float) this.mCycleOscillator.getSlope(f2);
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new WavePoint(i2, f2, f3, f4));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View view, float f2);

    public void setType(String str) {
        this.mType = str;
    }

    @TargetApi(19)
    public void setup(float f2) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.motion.widget.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, 2);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f3 = next.mPeriod;
            dArr[i2] = f3 * 0.01d;
            double[] dArr3 = dArr2[i2];
            float f4 = next.mValue;
            dArr3[0] = f4;
            double[] dArr4 = dArr2[i2];
            float f5 = next.mOffset;
            dArr4[1] = f5;
            this.mCycleOscillator.setPoint(i2, next.mPosition, f3, f5, f4);
            i2++;
        }
        this.mCycleOscillator.setup(f2);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i2, int i3, int i4, float f2, float f3, float f4) {
        this.mWavePoints.add(new WavePoint(i2, f2, f3, f4));
        if (i4 != -1) {
            this.mVariesBy = i4;
        }
        this.mWaveShape = i3;
    }
}
