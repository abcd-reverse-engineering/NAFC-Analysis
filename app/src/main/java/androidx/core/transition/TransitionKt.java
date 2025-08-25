package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.t.i0;
import h.q2.t.j0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Transition.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class TransitionKt {

    /* compiled from: Transition.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends j0 implements l<Transition, y1> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(Transition transition) {
            invoke2(transition);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@d Transition transition) {
            i0.f(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends j0 implements l<Transition, y1> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(Transition transition) {
            invoke2(transition);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@d Transition transition) {
            i0.f(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends j0 implements l<Transition, y1> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(Transition transition) {
            invoke2(transition);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@d Transition transition) {
            i0.f(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends j0 implements l<Transition, y1> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(Transition transition) {
            invoke2(transition);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@d Transition transition) {
            i0.f(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/transition/Transition;", "invoke"}, k = 3, mv = {1, 1, 10})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    public static final class AnonymousClass5 extends j0 implements l<Transition, y1> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ y1 invoke(Transition transition) {
            invoke2(transition);
            return y1.f16671a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@d Transition transition) {
            i0.f(transition, "it");
        }
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener addListener(@d Transition transition, @d l<? super Transition, y1> lVar, @d l<? super Transition, y1> lVar2, @d l<? super Transition, y1> lVar3, @d l<? super Transition, y1> lVar4, @d l<? super Transition, y1> lVar5) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "onEnd");
        i0.f(lVar2, "onStart");
        i0.f(lVar3, "onCancel");
        i0.f(lVar4, "onResume");
        i0.f(lVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar3, lVar2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @d
    public static /* bridge */ /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            lVar2 = AnonymousClass2.INSTANCE;
        }
        l lVar6 = lVar2;
        if ((i2 & 4) != 0) {
            lVar3 = AnonymousClass3.INSTANCE;
        }
        l lVar7 = lVar3;
        if ((i2 & 8) != 0) {
            lVar4 = AnonymousClass4.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            lVar5 = AnonymousClass5.INSTANCE;
        }
        i0.f(transition, "$receiver");
        i0.f(lVar, "onEnd");
        i0.f(lVar6, "onStart");
        i0.f(lVar7, "onCancel");
        i0.f(lVar4, "onResume");
        i0.f(lVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar7, lVar6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnCancel(@d Transition transition, @d final l<? super Transition, y1> lVar) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                i0.f(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                i0.f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnEnd(@d Transition transition, @d final l<? super Transition, y1> lVar) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                i0.f(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                i0.f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnPause(@d Transition transition, @d final l<? super Transition, y1> lVar) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                i0.f(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                i0.f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnResume(@d Transition transition, @d final l<? super Transition, y1> lVar) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                i0.f(transition2, "transition");
                lVar.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                i0.f(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnStart(@d Transition transition, @d final l<? super Transition, y1> lVar) {
        i0.f(transition, "$receiver");
        i0.f(lVar, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                i0.f(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                i0.f(transition2, "transition");
                lVar.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
