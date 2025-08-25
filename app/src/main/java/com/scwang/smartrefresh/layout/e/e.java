package com.scwang.smartrefresh.layout.e;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/* compiled from: SmartUtil.java */
/* loaded from: classes.dex */
public abstract class e {
    public static int a(@NonNull Context context, @ColorRes int i2) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i2) : context.getResources().getColor(i2);
    }

    public static boolean b(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static int c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        view.measure(childMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static void a(@NonNull AbsListView absListView, int i2) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i2);
            return;
        }
        if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null) {
                return;
            }
            ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
            return;
        }
        absListView.smoothScrollBy(i2, 0);
    }

    public static boolean a(View view) {
        return b(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static void a(View view, int i2) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i2);
            return;
        }
        if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i2);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i2);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i2);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i2);
        }
    }
}
