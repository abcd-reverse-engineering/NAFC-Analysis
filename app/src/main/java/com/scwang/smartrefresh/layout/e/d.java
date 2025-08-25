package com.scwang.smartrefresh.layout.e;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.annotation.NonNull;

/* compiled from: ScrollBoundaryUtil.java */
/* loaded from: classes.dex */
public class d {
    public static boolean a(@NonNull View view, PointF pointF) {
        if (b(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                if ("fixed".equals(childAt.getTag())) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zA = a(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zA;
            }
        }
        return true;
    }

    public static boolean b(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.canScrollVertically(-1);
        }
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() > 0;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        return viewGroup.getChildCount() > 0 && (((AbsListView) view).getFirstVisiblePosition() > 0 || viewGroup.getChildAt(0).getTop() < view.getPaddingTop());
    }

    public static boolean a(@NonNull View view, PointF pointF, boolean z) {
        if (a(view) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !e.b(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ("fixed".equals(childAt.getTag())) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zA = a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zA;
                }
            }
        }
        return z || b(view);
    }

    public static boolean a(@NonNull View view) {
        int i2;
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() < 0;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            AbsListView absListView = (AbsListView) view;
            int childCount = viewGroup.getChildCount();
            return childCount > 0 && (absListView.getLastVisiblePosition() < (i2 = childCount - 1) || viewGroup.getChildAt(i2).getBottom() > view.getPaddingBottom());
        }
        return view.canScrollVertically(1);
    }

    public static boolean a(@NonNull View view, @NonNull View view2, float f2, float f3, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z;
    }
}
