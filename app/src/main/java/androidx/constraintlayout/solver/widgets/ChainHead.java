package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight = 0.0f;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int i2, boolean z) {
        this.mIsRtl = false;
        this.mFirst = constraintWidget;
        this.mOrientation = i2;
        this.mIsRtl = z;
    }

    private void defineChainProperties() {
        int i2 = this.mOrientation * 2;
        ConstraintWidget constraintWidget = this.mFirst;
        this.mOptimizable = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        ConstraintWidget constraintWidget3 = constraintWidget2;
        boolean z = false;
        while (!z) {
            this.mWidgetsCount++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget2.mNextChainWidget;
            int i3 = this.mOrientation;
            ConstraintWidget constraintWidget4 = null;
            constraintWidgetArr[i3] = null;
            constraintWidget2.mListNextMatchConstraintsWidget[i3] = null;
            if (constraintWidget2.getVisibility() != 8) {
                this.mVisibleWidgets++;
                if (constraintWidget2.getDimensionBehaviour(this.mOrientation) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mTotalSize += constraintWidget2.getLength(this.mOrientation);
                }
                this.mTotalSize += constraintWidget2.mListAnchors[i2].getMargin();
                int i4 = i2 + 1;
                this.mTotalSize += constraintWidget2.mListAnchors[i4].getMargin();
                this.mTotalMargins += constraintWidget2.mListAnchors[i2].getMargin();
                this.mTotalMargins += constraintWidget2.mListAnchors[i4].getMargin();
                if (this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = constraintWidget2;
                }
                this.mLastVisibleWidget = constraintWidget2;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget2.mListDimensionBehaviors;
                int i5 = this.mOrientation;
                if (dimensionBehaviourArr[i5] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget2.mResolvedMatchConstraintDefault;
                    if (iArr[i5] == 0 || iArr[i5] == 3 || iArr[i5] == 2) {
                        this.mWidgetsMatchCount++;
                        float[] fArr = constraintWidget2.mWeight;
                        int i6 = this.mOrientation;
                        float f2 = fArr[i6];
                        if (f2 > 0.0f) {
                            this.mTotalWeight += fArr[i6];
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget2, this.mOrientation)) {
                            if (f2 < 0.0f) {
                                this.mHasUndefinedWeights = true;
                            } else {
                                this.mHasDefinedWeights = true;
                            }
                            if (this.mWeightedMatchConstraintsWidgets == null) {
                                this.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                            }
                            this.mWeightedMatchConstraintsWidgets.add(constraintWidget2);
                        }
                        if (this.mFirstMatchConstraintWidget == null) {
                            this.mFirstMatchConstraintWidget = constraintWidget2;
                        }
                        ConstraintWidget constraintWidget5 = this.mLastMatchConstraintWidget;
                        if (constraintWidget5 != null) {
                            constraintWidget5.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget2;
                        }
                        this.mLastMatchConstraintWidget = constraintWidget2;
                    }
                    if (this.mOrientation == 0) {
                        if (constraintWidget2.mMatchConstraintDefaultWidth != 0 || constraintWidget2.mMatchConstraintMinWidth != 0 || constraintWidget2.mMatchConstraintMaxWidth != 0) {
                            this.mOptimizable = false;
                        }
                    } else if (constraintWidget2.mMatchConstraintDefaultHeight != 0 || constraintWidget2.mMatchConstraintMinHeight != 0 || constraintWidget2.mMatchConstraintMaxHeight != 0) {
                        this.mOptimizable = false;
                    }
                    if (constraintWidget2.mDimensionRatio != 0.0f) {
                        this.mOptimizable = false;
                        this.mHasRatio = true;
                    }
                }
            }
            if (constraintWidget3 != constraintWidget2) {
                constraintWidget3.mNextChainWidget[this.mOrientation] = constraintWidget2;
            }
            ConstraintAnchor constraintAnchor = constraintWidget2.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor.mOwner;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget6.mListAnchors;
                if (constraintAnchorArr[i2].mTarget != null && constraintAnchorArr[i2].mTarget.mOwner == constraintWidget2) {
                    constraintWidget4 = constraintWidget6;
                }
            }
            if (constraintWidget4 == null) {
                constraintWidget4 = constraintWidget2;
                z = true;
            }
            constraintWidget3 = constraintWidget2;
            constraintWidget2 = constraintWidget4;
        }
        ConstraintWidget constraintWidget7 = this.mFirstVisibleWidget;
        if (constraintWidget7 != null) {
            this.mTotalSize -= constraintWidget7.mListAnchors[i2].getMargin();
        }
        ConstraintWidget constraintWidget8 = this.mLastVisibleWidget;
        if (constraintWidget8 != null) {
            this.mTotalSize -= constraintWidget8.mListAnchors[i2 + 1].getMargin();
        }
        this.mLast = constraintWidget2;
        if (this.mOrientation == 0 && this.mIsRtl) {
            this.mHead = this.mLast;
        } else {
            this.mHead = this.mFirst;
        }
        this.mHasComplexMatchWeights = this.mHasDefinedWeights && this.mHasUndefinedWeights;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.mResolvedMatchConstraintDefault;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
