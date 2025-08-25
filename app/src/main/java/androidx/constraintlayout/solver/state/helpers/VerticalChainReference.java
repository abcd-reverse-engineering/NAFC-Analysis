package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    /* renamed from: androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = new int[State.Chain.values().length];

        static {
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraintReferenceConstraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = this.mTopToTop;
                if (obj != null) {
                    constraintReferenceConstraints.topToTop(obj);
                } else {
                    Object obj2 = this.mTopToBottom;
                    if (obj2 != null) {
                        constraintReferenceConstraints.topToBottom(obj2);
                    } else {
                        constraintReferenceConstraints.topToTop(State.PARENT);
                    }
                }
                constraintReference2 = constraintReferenceConstraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraintReferenceConstraints.getKey());
                constraintReferenceConstraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraintReferenceConstraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.mBottomToTop;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3);
            } else {
                Object obj4 = this.mBottomToBottom;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4);
                } else {
                    constraintReference.bottomToBottom(State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f2 = this.mBias;
            if (f2 != 0.5f) {
                constraintReference2.verticalBias(f2);
            }
        }
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()];
        if (i2 == 1) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (i2 == 2) {
            constraintReference2.setVerticalChainStyle(1);
        } else {
            if (i2 != 3) {
                return;
            }
            constraintReference2.setVerticalChainStyle(2);
        }
    }

    public void bottomToBottom(Object obj) {
        this.mBottomToBottom = obj;
    }

    public void bottomToTop(Object obj) {
        this.mBottomToTop = obj;
    }

    public void topToBottom(Object obj) {
        this.mTopToBottom = obj;
    }

    public void topToTop(Object obj) {
        this.mTopToTop = obj;
    }
}
