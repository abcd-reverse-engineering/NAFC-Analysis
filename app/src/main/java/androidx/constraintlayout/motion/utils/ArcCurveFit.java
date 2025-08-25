package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            this.linear = false;
            this.mVertical = i2 == 1;
            this.mTime1 = d2;
            this.mTime2 = d3;
            this.mOneOverDeltaTime = 1.0d / (this.mTime2 - this.mTime1);
            if (3 == i2) {
                this.linear = true;
            }
            double d8 = d6 - d4;
            double d9 = d7 - d5;
            if (!this.linear && Math.abs(d8) >= EPSILON && Math.abs(d9) >= EPSILON) {
                this.mLut = new double[101];
                this.mEllipseA = d8 * (this.mVertical ? -1 : 1);
                this.mEllipseB = d9 * (this.mVertical ? 1 : -1);
                this.mEllipseCenterX = this.mVertical ? d6 : d4;
                this.mEllipseCenterY = this.mVertical ? d5 : d7;
                buildTable(d4, d5, d6, d7);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d4;
            this.mX2 = d6;
            this.mY1 = d5;
            this.mY2 = d7;
            this.mArcDistance = Math.hypot(d9, d8);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            double d10 = this.mTime2;
            double d11 = this.mTime1;
            this.mEllipseCenterX = d8 / (d10 - d11);
            this.mEllipseCenterY = d9 / (d10 - d11);
        }

        private void buildTable(double d2, double d3, double d4, double d5) {
            double dHypot;
            double d6 = d4 - d2;
            double d7 = d3 - d5;
            int i2 = 0;
            double d8 = 0.0d;
            double d9 = 0.0d;
            double d10 = 0.0d;
            while (true) {
                if (i2 >= ourPercent.length) {
                    break;
                }
                double d11 = d8;
                double radians = Math.toRadians((i2 * 90.0d) / (r15.length - 1));
                double dSin = Math.sin(radians) * d6;
                double dCos = Math.cos(radians) * d7;
                if (i2 > 0) {
                    dHypot = d11 + Math.hypot(dSin - d9, dCos - d10);
                    ourPercent[i2] = dHypot;
                } else {
                    dHypot = d11;
                }
                i2++;
                d10 = dCos;
                d8 = dHypot;
                d9 = dSin;
            }
            double d12 = d8;
            this.mArcDistance = d12;
            int i3 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i3 >= dArr.length) {
                    break;
                }
                dArr[i3] = dArr[i3] / d12;
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.mLut.length) {
                    return;
                }
                double length = i4 / (r2.length - 1);
                int iBinarySearch = Arrays.binarySearch(ourPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i4] = iBinarySearch / (ourPercent.length - 1);
                } else if (iBinarySearch == -1) {
                    this.mLut[i4] = 0.0d;
                } else {
                    int i5 = -iBinarySearch;
                    int i6 = i5 - 2;
                    double[] dArr2 = ourPercent;
                    this.mLut[i4] = (i6 + ((length - dArr2[i6]) / (dArr2[i5 - 1] - dArr2[i6]))) / (dArr2.length - 1);
                }
                i4++;
            }
        }

        double getDX() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d2, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d2 = -d2;
            }
            return d2 * dHypot;
        }

        double getDY() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double d3 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d2, d3);
            return this.mVertical ? (-d3) * dHypot : d3 * dHypot;
        }

        public double getLinearDX(double d2) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d2) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mX1;
            return d4 + (d3 * (this.mX2 - d4));
        }

        public double getLinearY(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mY1;
            return d4 + (d3 * (this.mY2 - d4));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d2 * (dArr.length - 1);
            int i2 = (int) length;
            return dArr[i2] + ((length - i2) * (dArr[i2 + 1] - dArr[i2]));
        }

        void setPoint(double d2) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d2 : d2 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < this.mArcs.length) {
            int i5 = iArr[i2];
            if (i5 == 0) {
                i = 3;
            } else if (i5 == 1) {
                i3 = 1;
                i = 1;
            } else if (i5 == 2) {
                i3 = 2;
            } else if (i5 != 3) {
                i = i4;
            } else {
                i = i3 != 1 ? 1 : 2;
                i3 = i;
            }
            int i6 = i2 + 1;
            this.mArcs[i2] = new Arc(i, dArr[i2], dArr[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
            i2 = i6;
            i4 = i;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
            d2 = arcArr2[arcArr2.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return;
            }
            if (d2 <= arcArr3[i2].mTime2) {
                if (arcArr3[i2].linear) {
                    dArr[0] = arcArr3[i2].getLinearX(d2);
                    dArr[1] = this.mArcs[i2].getLinearY(d2);
                    return;
                } else {
                    arcArr3[i2].setPoint(d2);
                    dArr[0] = this.mArcs[i2].getX();
                    dArr[1] = this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d2, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    dArr[0] = arcArr2[i2].getLinearDX(d2);
                    dArr[1] = this.mArcs[i2].getLinearDY(d2);
                    return;
                } else {
                    arcArr2[i2].setPoint(d2);
                    dArr[0] = this.mArcs[i2].getDX();
                    dArr[1] = this.mArcs[i2].getDY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d2, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i2 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i2 >= arcArr2.length) {
                return;
            }
            if (d2 <= arcArr2[i2].mTime2) {
                if (arcArr2[i2].linear) {
                    fArr[0] = (float) arcArr2[i2].getLinearX(d2);
                    fArr[1] = (float) this.mArcs[i2].getLinearY(d2);
                    return;
                } else {
                    arcArr2[i2].setPoint(d2);
                    fArr[0] = (float) this.mArcs[i2].getX();
                    fArr[1] = (float) this.mArcs[i2].getY();
                    return;
                }
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d2, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
            d2 = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i3 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr3[i3].mTime2) {
                if (arcArr3[i3].linear) {
                    if (i2 == 0) {
                        return arcArr3[i3].getLinearDX(d2);
                    }
                    return arcArr3[i3].getLinearDY(d2);
                }
                arcArr3[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getDX();
                }
                return this.mArcs[i3].getDY();
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d2, int i2) {
        Arc[] arcArr = this.mArcs;
        int i3 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr2[i3].mTime2) {
                if (arcArr2[i3].linear) {
                    if (i2 == 0) {
                        return arcArr2[i3].getLinearX(d2);
                    }
                    return arcArr2[i3].getLinearY(d2);
                }
                arcArr2[i3].setPoint(d2);
                if (i2 == 0) {
                    return this.mArcs[i3].getX();
                }
                return this.mArcs[i3].getY();
            }
            i3++;
        }
    }
}
