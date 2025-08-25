package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.b.e;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.k;
import com.scwang.smartrefresh.layout.e.c;
import com.scwang.smartrefresh.layout.e.d;
import java.util.Collections;
import java.util.LinkedList;

/* compiled from: RefreshContentWrapper.java */
/* loaded from: classes.dex */
public class a implements e, com.scwang.smartrefresh.layout.d.a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    protected View f8321a;

    /* renamed from: b, reason: collision with root package name */
    protected View f8322b;

    /* renamed from: c, reason: collision with root package name */
    protected View f8323c;

    /* renamed from: d, reason: collision with root package name */
    protected View f8324d;

    /* renamed from: e, reason: collision with root package name */
    protected View f8325e;

    /* renamed from: f, reason: collision with root package name */
    protected int f8326f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f8327g = true;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f8328h = true;

    /* renamed from: i, reason: collision with root package name */
    protected b f8329i = new b();

    public a(@NonNull View view) {
        this.f8323c = view;
        this.f8322b = view;
        this.f8321a = view;
    }

    protected void a(View view, i iVar) {
        boolean zIsInEditMode = this.f8321a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = a(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                c.a(view, iVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f8323c = view2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public boolean b() {
        return this.f8328h && this.f8329i.b(this.f8321a);
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    @NonNull
    public View c() {
        return this.f8323c;
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    @NonNull
    public View getView() {
        return this.f8321a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.f8323c instanceof AbsListView) {
                com.scwang.smartrefresh.layout.e.e.a((AbsListView) this.f8323c, iIntValue - this.f8326f);
            } else {
                this.f8323c.scrollBy(0, iIntValue - this.f8326f);
            }
        } catch (Throwable unused) {
        }
        this.f8326f = iIntValue;
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public void b(boolean z) {
        this.f8329i.f8332c = z;
    }

    @Override // com.scwang.smartrefresh.layout.d.a
    public void a(boolean z, boolean z2) {
        this.f8327g = z;
        this.f8328h = z2;
    }

    protected View a(View view, boolean z) {
        LinkedList linkedList = new LinkedList(Collections.singletonList(view));
        View view2 = null;
        while (!linkedList.isEmpty() && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && com.scwang.smartrefresh.layout.e.e.a(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        linkedList.add(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    protected View a(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (d.a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && com.scwang.smartrefresh.layout.e.e.a(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewA = a(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewA;
                }
            }
        }
        return view2;
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public void a(int i2, int i3, int i4) {
        boolean z;
        View viewFindViewById;
        View viewFindViewById2;
        if (i3 == -1 || (viewFindViewById2 = this.f8322b.findViewById(i3)) == null) {
            z = false;
        } else if (i2 > 0) {
            viewFindViewById2.setTranslationY(i2);
            z = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z = false;
        }
        if (i4 != -1 && (viewFindViewById = this.f8322b.findViewById(i4)) != null) {
            if (i2 < 0) {
                viewFindViewById.setTranslationY(i2);
                z = true;
            } else if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
        }
        if (!z) {
            this.f8322b.setTranslationY(i2);
        } else {
            this.f8322b.setTranslationY(0.0f);
        }
        View view = this.f8324d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i2));
        }
        View view2 = this.f8325e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i2));
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public boolean a() {
        return this.f8327g && this.f8329i.a(this.f8321a);
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f8321a.getLeft(), -this.f8321a.getTop());
        View view = this.f8323c;
        View view2 = this.f8321a;
        if (view != view2) {
            this.f8323c = a(view2, pointF, view);
        }
        if (this.f8323c == this.f8321a) {
            this.f8329i.f8330a = null;
        } else {
            this.f8329i.f8330a = pointF;
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public void a(i iVar, View view, View view2) {
        a(this.f8321a, iVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f8324d = view;
        this.f8325e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f8321a.getContext());
        iVar.c().getLayout().removeView(this.f8321a);
        ViewGroup.LayoutParams layoutParams = this.f8321a.getLayoutParams();
        frameLayout.addView(this.f8321a, -1, -1);
        iVar.c().getLayout().addView(frameLayout, layoutParams);
        this.f8321a = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = com.scwang.smartrefresh.layout.e.e.c(view);
            viewGroup.addView(new Space(this.f8321a.getContext()), iIndexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = com.scwang.smartrefresh.layout.e.e.c(view2);
            viewGroup2.addView(new Space(this.f8321a.getContext()), iIndexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public void a(k kVar) {
        if (kVar instanceof b) {
            this.f8329i = (b) kVar;
        } else {
            this.f8329i.f8331b = kVar;
        }
    }

    @Override // com.scwang.smartrefresh.layout.b.e
    public ValueAnimator.AnimatorUpdateListener a(int i2) {
        View view = this.f8323c;
        if (view == null || i2 == 0) {
            return null;
        }
        if ((i2 >= 0 || !d.a(view)) && (i2 <= 0 || !d.b(this.f8323c))) {
            return null;
        }
        this.f8326f = i2;
        return this;
    }
}
