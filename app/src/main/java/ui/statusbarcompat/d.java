package ui.statusbarcompat;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* compiled from: StatusBarCompatLollipop.java */
@TargetApi(21)
/* loaded from: classes2.dex */
class d {

    /* compiled from: StatusBarCompatLollipop.java */
    static class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }
    }

    /* compiled from: StatusBarCompatLollipop.java */
    static class b implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f20263a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Window f20264b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20265c;

        /* compiled from: StatusBarCompatLollipop.java */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.f20264b.setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* compiled from: StatusBarCompatLollipop.java */
        /* renamed from: ui.statusbarcompat.d$b$b, reason: collision with other inner class name */
        class C0320b implements ValueAnimator.AnimatorUpdateListener {
            C0320b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.f20264b.setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        b(CollapsingToolbarLayout collapsingToolbarLayout, Window window, int i2) {
            this.f20263a = collapsingToolbarLayout;
            this.f20264b = window;
            this.f20265c = i2;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (Math.abs(i2) > appBarLayout.getHeight() - this.f20263a.getScrimVisibleHeightTrigger()) {
                if (this.f20264b.getStatusBarColor() == 0) {
                    ValueAnimator duration = ValueAnimator.ofArgb(0, this.f20265c).setDuration(this.f20263a.getScrimAnimationDuration());
                    duration.addUpdateListener(new a());
                    duration.start();
                    return;
                }
                return;
            }
            int statusBarColor = this.f20264b.getStatusBarColor();
            int i3 = this.f20265c;
            if (statusBarColor == i3) {
                ValueAnimator duration2 = ValueAnimator.ofArgb(i3, 0).setDuration(this.f20263a.getScrimAnimationDuration());
                duration2.addUpdateListener(new C0320b());
                duration2.start();
            }
        }
    }

    d() {
    }

    private static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    static void b(Activity activity, int i2, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof StatusBarView) {
            childAt.setBackgroundResource(i2);
        } else {
            childAt.setPadding(0, a(activity), 0, 0);
            childAt = new StatusBarView(activity);
            childAt.setLayoutParams(new LinearLayout.LayoutParams(-1, a(activity)));
            childAt.setBackgroundResource(i2);
            viewGroup.addView(childAt);
        }
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    static void a(Activity activity, int i2, boolean z) {
        Window window = activity.getWindow();
        window.clearFlags(c.c.a.b.a.a.B1);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i2);
        if (z && Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
        } else {
            window.getDecorView().setSystemUiVisibility(0);
        }
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    static void a(Activity activity, boolean z, boolean z2) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            if (z2 && Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(9216);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
            childAt.setPadding(0, 0, 0, 0);
            if (viewGroup.getChildAt(0) != null) {
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
    }

    static void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop() + a(activity), childAt.getPaddingRight(), childAt.getPaddingBottom());
        }
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    static void a(Activity activity, boolean z, View view, boolean z2) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            if (z2 && Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(9216);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.content);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(activity), view.getPaddingRight(), view.getPaddingBottom());
        }
        if (view != null) {
            ViewCompat.setFitsSystemWindows(view, false);
            ViewCompat.requestApplyInsets(view);
        }
    }

    static void a(Fragment fragment, boolean z) {
        Window window = fragment.getActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        View view = fragment.getView();
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    static void a(Fragment fragment, boolean z, View view) {
        Window window = fragment.getActivity().getWindow();
        window.addFlags(Integer.MIN_VALUE);
        if (z) {
            window.clearFlags(c.c.a.b.a.a.B1);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        } else {
            window.addFlags(c.c.a.b.a.a.B1);
            window.getDecorView().setSystemUiVisibility(0);
        }
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
    }

    static void a(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int i2) {
        Window window = activity.getWindow();
        window.clearFlags(c.c.a.b.a.a.B1);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.getDecorView().setSystemUiVisibility(0);
        ViewCompat.setOnApplyWindowInsetsListener(collapsingToolbarLayout, new a());
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
            ViewCompat.requestApplyInsets(childAt);
        }
        ((View) appBarLayout.getParent()).setFitsSystemWindows(false);
        appBarLayout.setFitsSystemWindows(false);
        toolbar.setFitsSystemWindows(false);
        if (toolbar.getTag() == null) {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
            int iA = a(activity);
            ((FrameLayout.LayoutParams) layoutParams).height += iA;
            toolbar.setLayoutParams(layoutParams);
            toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + iA, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            toolbar.setTag(true);
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
        if (behavior != null && (behavior instanceof AppBarLayout.Behavior) && Math.abs(((AppBarLayout.Behavior) behavior).getTopAndBottomOffset()) > appBarLayout.getHeight() - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) {
            window.setStatusBarColor(i2);
        } else {
            window.setStatusBarColor(0);
        }
        collapsingToolbarLayout.setFitsSystemWindows(false);
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(collapsingToolbarLayout, window, i2));
        collapsingToolbarLayout.getChildAt(0).setFitsSystemWindows(false);
        collapsingToolbarLayout.setStatusBarScrimColor(i2);
    }
}
