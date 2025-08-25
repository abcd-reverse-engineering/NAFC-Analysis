package com.scwang.smartrefresh.layout.e;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.b.i;

/* compiled from: DesignUtil.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: DesignUtil.java */
    static class a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.scwang.smartrefresh.layout.d.a f8275a;

        a(com.scwang.smartrefresh.layout.d.a aVar) {
            this.f8275a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            this.f8275a.a(i2 >= 0, appBarLayout.getTotalScrollRange() + i2 <= 0);
        }
    }

    public static void a(View view, i iVar, com.scwang.smartrefresh.layout.d.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.c().u(false);
                a((ViewGroup) view, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(ViewGroup viewGroup, com.scwang.smartrefresh.layout.d.a aVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(aVar));
            }
        }
    }
}
