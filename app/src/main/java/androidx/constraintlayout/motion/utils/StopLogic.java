package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f2) {
        float f3 = this.mStage1Duration;
        if (f2 <= f3) {
            float f4 = this.mStage1Velocity;
            return (f4 * f2) + ((((this.mStage2Velocity - f4) * f2) * f2) / (f3 * 2.0f));
        }
        int i2 = this.mNumberOfStages;
        if (i2 == 1) {
            return this.mStage1EndPosition;
        }
        float f5 = f2 - f3;
        float f6 = this.mStage2Duration;
        if (f5 < f6) {
            float f7 = this.mStage1EndPosition;
            float f8 = this.mStage2Velocity;
            return f7 + (f8 * f5) + ((((this.mStage3Velocity - f8) * f5) * f5) / (f6 * 2.0f));
        }
        if (i2 == 2) {
            return this.mStage2EndPosition;
        }
        float f9 = f5 - f6;
        float f10 = this.mStage3Duration;
        if (f9 >= f10) {
            return this.mStage3EndPosition;
        }
        float f11 = this.mStage2EndPosition;
        float f12 = this.mStage3Velocity;
        return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
    }

    private void setup(float f2, float f3, float f4, float f5, float f6) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.mStage1Velocity = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4);
            if (fSqrt < f5) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = (fSqrt - f2) / f4;
                this.mStage2Duration = fSqrt / f4;
                this.mStage1EndPosition = ((f2 + fSqrt) * this.mStage1Duration) / 2.0f;
                this.mStage2EndPosition = f3;
                this.mStage3EndPosition = f3;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = f5;
            this.mStage3Velocity = f5;
            this.mStage1Duration = (f5 - f2) / f4;
            this.mStage3Duration = f5 / f4;
            float f9 = ((f2 + f5) * this.mStage1Duration) / 2.0f;
            float f10 = (this.mStage3Duration * f5) / 2.0f;
            this.mStage2Duration = ((f3 - f9) - f10) / f5;
            this.mStage1EndPosition = f9;
            this.mStage2EndPosition = f3 - f10;
            this.mStage3EndPosition = f3;
            return;
        }
        if (f8 >= f3) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f3;
            this.mStage1Duration = (2.0f * f3) / f2;
            return;
        }
        float f11 = f3 - f8;
        float f12 = f11 / f2;
        if (f12 + f7 < f6) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = f2;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f11;
            this.mStage2EndPosition = f3;
            this.mStage1Duration = f12;
            this.mStage2Duration = f7;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f4 * f3) + ((f2 * f2) / 2.0f));
        float f13 = (fSqrt2 - f2) / f4;
        this.mStage1Duration = f13;
        float f14 = fSqrt2 / f4;
        this.mStage2Duration = f14;
        if (fSqrt2 < f5) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f13;
            this.mStage2Duration = f14;
            this.mStage1EndPosition = ((f2 + fSqrt2) * this.mStage1Duration) / 2.0f;
            this.mStage2EndPosition = f3;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f2;
        this.mStage2Velocity = f5;
        this.mStage3Velocity = f5;
        this.mStage1Duration = (f5 - f2) / f4;
        this.mStage3Duration = f5 / f4;
        float f15 = ((f2 + f5) * this.mStage1Duration) / 2.0f;
        float f16 = (this.mStage3Duration * f5) / 2.0f;
        this.mStage2Duration = ((f3 - f15) - f16) / f5;
        this.mStage1EndPosition = f15;
        this.mStage2EndPosition = f3 - f16;
        this.mStage3EndPosition = f3;
    }

    public void config(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.mStartPosition = f2;
        this.mBackwards = f2 > f3;
        if (this.mBackwards) {
            setup(-f4, f2 - f3, f6, f7, f5);
        } else {
            setup(f4, f3 - f2, f6, f7, f5);
        }
    }

    public void debug(String str, String str2, float f2) {
        String str3 = str2 + " ===== " + this.mType;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(this.mBackwards ? "backwards" : "forward ");
        sb.append(" time = ");
        sb.append(f2);
        sb.append("  stages ");
        sb.append(this.mNumberOfStages);
        sb.toString();
        String str4 = str2 + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition;
        if (this.mNumberOfStages > 1) {
            String str5 = str2 + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition;
        }
        if (this.mNumberOfStages > 2) {
            String str6 = str2 + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition;
        }
        float f3 = this.mStage1Duration;
        if (f2 <= f3) {
            String str7 = str2 + "stage 0";
            return;
        }
        int i2 = this.mNumberOfStages;
        if (i2 == 1) {
            String str8 = str2 + "end stage 0";
            return;
        }
        float f4 = f2 - f3;
        float f5 = this.mStage2Duration;
        if (f4 < f5) {
            String str9 = str2 + " stage 1";
            return;
        }
        if (i2 == 2) {
            String str10 = str2 + "end stage 1";
            return;
        }
        if (f4 - f5 < this.mStage3Duration) {
            String str11 = str2 + " stage 2";
            return;
        }
        String str12 = str2 + " end stage 2";
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float fCalcY = calcY(f2);
        this.mLastPosition = f2;
        return this.mBackwards ? this.mStartPosition - fCalcY : this.mStartPosition + fCalcY;
    }

    public float getVelocity(float f2) {
        float f3 = this.mStage1Duration;
        if (f2 <= f3) {
            float f4 = this.mStage1Velocity;
            return f4 + (((this.mStage2Velocity - f4) * f2) / f3);
        }
        int i2 = this.mNumberOfStages;
        if (i2 == 1) {
            return 0.0f;
        }
        float f5 = f2 - f3;
        float f6 = this.mStage2Duration;
        if (f5 < f6) {
            float f7 = this.mStage2Velocity;
            return f7 + (((this.mStage3Velocity - f7) * f5) / f6);
        }
        if (i2 == 2) {
            return this.mStage2EndPosition;
        }
        float f8 = f5 - f6;
        float f9 = this.mStage3Duration;
        if (f8 >= f9) {
            return this.mStage3EndPosition;
        }
        float f10 = this.mStage3Velocity;
        return f10 - ((f8 * f10) / f9);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
