package ui.statusbarcompat;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* compiled from: StatusBarCompatKitKat.java */
@TargetApi(19)
/* loaded from: classes2.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f20259a = "statusBarView";

    /* renamed from: b, reason: collision with root package name */
    private static final String f20260b = "marginAdded";

    /* compiled from: StatusBarCompatKitKat.java */
    static class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CollapsingToolbarLayout f20261a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20262b;

        a(CollapsingToolbarLayout collapsingToolbarLayout, View view) {
            this.f20261a = collapsingToolbarLayout;
            this.f20262b = view;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (Math.abs(i2) > appBarLayout.getHeight() - this.f20261a.getScrimVisibleHeightTrigger()) {
                if (this.f20262b.getAlpha() == 0.0f) {
                    this.f20262b.animate().cancel();
                    this.f20262b.animate().alpha(1.0f).setDuration(this.f20261a.getScrimAnimationDuration()).start();
                    return;
                }
                return;
            }
            if (this.f20262b.getAlpha() == 1.0f) {
                this.f20262b.animate().cancel();
                this.f20262b.animate().alpha(0.0f).setDuration(this.f20261a.getScrimAnimationDuration()).start();
            }
        }
    }

    c() {
    }

    private static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    private static void b(View view, int i2) {
        if (view != null && f20260b.equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i2;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    static void c(Activity activity) {
        activity.getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
            childAt.setPadding(0, 0, 0, 0);
        }
        a(activity);
        b(childAt, a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    private static View a(Activity activity, int i2, int i3) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i3);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i2);
        view.setTag(f20259a);
        viewGroup.addView(view);
        return view;
    }

    static void b(Activity activity, int i2) {
        activity.getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof StatusBarView) {
            childAt.setBackgroundResource(i2);
        } else {
            childAt.setPadding(0, a((Context) activity), 0, 0);
            childAt = new StatusBarView(activity);
            childAt.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
            childAt.setBackgroundResource(i2);
            viewGroup.addView(childAt);
        }
        a(activity);
        b(childAt, a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    private static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View viewFindViewWithTag = viewGroup.findViewWithTag(f20259a);
        if (viewFindViewWithTag != null) {
            viewGroup.removeView(viewFindViewWithTag);
        }
    }

    private static void a(View view, int i2) {
        if (view == null || f20260b.equals(view.getTag())) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += i2;
        view.setLayoutParams(layoutParams);
        view.setTag(f20260b);
    }

    static void a(Activity activity, int i2) {
        Window window = activity.getWindow();
        window.addFlags(c.c.a.b.a.a.B1);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        int iA = a((Context) activity);
        a(activity);
        a(activity, i2, iA);
        a(childAt, iA);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    static void b(Activity activity) {
        activity.getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View childAt = viewGroup.getChildAt(0);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            childAt.setPadding(childAt.getPaddingLeft(), childAt.getPaddingTop() + a((Context) activity), childAt.getPaddingRight(), childAt.getPaddingBottom());
        }
        a(activity);
        b(childAt, a((Context) activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    static void a(Activity activity, View view) {
        activity.getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        if (viewGroup.getChildAt(viewGroup.getChildCount() - 1) instanceof StatusBarView) {
            viewGroup.removeView(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a((Context) activity), view.getPaddingRight(), view.getPaddingBottom());
        }
        a(activity);
        b(view, a((Context) activity));
        if (view != null) {
            ViewCompat.setFitsSystemWindows(view, false);
        }
    }

    static void a(Fragment fragment) {
        fragment.getActivity().getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.setPadding(0, 0, 0, 0);
            }
            if (viewGroup.getChildAt(0) != null) {
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        a((Activity) fragment.getActivity());
        b(viewGroup, a((Context) fragment.getActivity()));
        View view = fragment.getView();
        if (view != null) {
            if (view instanceof ScrollView) {
                View childAt2 = ((ViewGroup) view).getChildAt(0);
                if (childAt2 != null) {
                    childAt2.setPadding(childAt2.getPaddingLeft(), childAt2.getPaddingTop() + a(fragment.getContext()), childAt2.getPaddingRight(), childAt2.getPaddingBottom());
                }
            } else {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
            }
            ViewCompat.setFitsSystemWindows(view, false);
        }
    }

    static void a(Fragment fragment, View view) {
        fragment.getActivity().getWindow().addFlags(c.c.a.b.a.a.B1);
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().findViewById(R.id.content);
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (childAt instanceof StatusBarView) {
                viewGroup.removeView(childAt);
                viewGroup.setPadding(0, 0, 0, 0);
            }
            if (viewGroup.getChildAt(0) != null) {
                viewGroup.getChildAt(0).setPadding(0, 0, 0, 0);
            }
        }
        a((Activity) fragment.getActivity());
        b(viewGroup, a((Context) fragment.getActivity()));
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(fragment.getContext()), view.getPaddingRight(), view.getPaddingBottom());
        ViewCompat.setFitsSystemWindows(view, false);
    }

    static void a(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int i2) {
        Window window = activity.getWindow();
        window.addFlags(c.c.a.b.a.a.B1);
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        childAt.setFitsSystemWindows(false);
        ((View) appBarLayout.getParent()).setFitsSystemWindows(false);
        appBarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.setFitsSystemWindows(false);
        collapsingToolbarLayout.getChildAt(0).setFitsSystemWindows(false);
        toolbar.setFitsSystemWindows(false);
        if (toolbar.getTag() == null) {
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
            int iA = a((Context) activity);
            ((FrameLayout.LayoutParams) layoutParams).height += iA;
            toolbar.setLayoutParams(layoutParams);
            toolbar.setPadding(toolbar.getPaddingLeft(), toolbar.getPaddingTop() + iA, toolbar.getPaddingRight(), toolbar.getPaddingBottom());
            toolbar.setTag(true);
        }
        int iA2 = a((Context) activity);
        a(activity);
        b(childAt, iA2);
        View viewA = a(activity, i2, iA2);
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
        if (behavior != null && (behavior instanceof AppBarLayout.Behavior) && Math.abs(((AppBarLayout.Behavior) behavior).getTopAndBottomOffset()) > appBarLayout.getHeight() - collapsingToolbarLayout.getScrimVisibleHeightTrigger()) {
            viewA.setAlpha(1.0f);
        } else {
            viewA.setAlpha(0.0f);
        }
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(collapsingToolbarLayout, viewA));
    }
}
