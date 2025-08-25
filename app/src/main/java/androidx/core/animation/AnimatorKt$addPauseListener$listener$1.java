package androidx.core.animation;

import android.animation.Animator;
import h.q2.s.l;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Animator.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ l $onPause;
    final /* synthetic */ l $onResume;

    public AnimatorKt$addPauseListener$listener$1(l lVar, l lVar2) {
        this.$onPause = lVar;
        this.$onResume = lVar2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@d Animator animator) {
        i0.f(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@d Animator animator) {
        i0.f(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
