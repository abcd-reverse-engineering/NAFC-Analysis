package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.c.e;

/* loaded from: classes.dex */
public class PopupDrawerLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    com.lxj.xpopup.d.b f8172a;

    /* renamed from: b, reason: collision with root package name */
    ViewDragHelper f8173b;

    /* renamed from: c, reason: collision with root package name */
    View f8174c;

    /* renamed from: d, reason: collision with root package name */
    View f8175d;

    /* renamed from: e, reason: collision with root package name */
    public com.lxj.xpopup.d.d f8176e;

    /* renamed from: f, reason: collision with root package name */
    e f8177f;

    /* renamed from: g, reason: collision with root package name */
    ArgbEvaluator f8178g;

    /* renamed from: h, reason: collision with root package name */
    int f8179h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8180i;

    /* renamed from: j, reason: collision with root package name */
    float f8181j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8182k;

    /* renamed from: l, reason: collision with root package name */
    float f8183l;

    /* renamed from: m, reason: collision with root package name */
    boolean f8184m;
    boolean n;
    float o;
    float p;
    boolean q;
    boolean r;
    ViewDragHelper.Callback s;
    Paint t;
    Rect u;
    private d v;

    class a extends ViewDragHelper.Callback {
        a() {
        }

        private void a(int i2) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            com.lxj.xpopup.d.d dVar = popupDrawerLayout.f8176e;
            if (dVar == com.lxj.xpopup.d.d.Left) {
                popupDrawerLayout.f8181j = ((popupDrawerLayout.f8175d.getMeasuredWidth() + i2) * 1.0f) / PopupDrawerLayout.this.f8175d.getMeasuredWidth();
                if (i2 == (-PopupDrawerLayout.this.f8175d.getMeasuredWidth()) && PopupDrawerLayout.this.v != null) {
                    PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                    com.lxj.xpopup.d.b bVar = popupDrawerLayout2.f8172a;
                    com.lxj.xpopup.d.b bVar2 = com.lxj.xpopup.d.b.Close;
                    if (bVar != bVar2) {
                        popupDrawerLayout2.f8172a = bVar2;
                        popupDrawerLayout2.v.onClose();
                    }
                }
            } else if (dVar == com.lxj.xpopup.d.d.Right) {
                popupDrawerLayout.f8181j = ((popupDrawerLayout.getMeasuredWidth() - i2) * 1.0f) / PopupDrawerLayout.this.f8175d.getMeasuredWidth();
                if (i2 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.v != null) {
                    PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                    com.lxj.xpopup.d.b bVar3 = popupDrawerLayout3.f8172a;
                    com.lxj.xpopup.d.b bVar4 = com.lxj.xpopup.d.b.Close;
                    if (bVar3 != bVar4) {
                        popupDrawerLayout3.f8172a = bVar4;
                        popupDrawerLayout3.v.onClose();
                    }
                }
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            if (popupDrawerLayout4.f8182k) {
                popupDrawerLayout4.setBackgroundColor(popupDrawerLayout4.f8177f.a(popupDrawerLayout4.f8181j));
            }
            if (PopupDrawerLayout.this.v != null) {
                PopupDrawerLayout.this.v.a(PopupDrawerLayout.this.f8181j);
                PopupDrawerLayout popupDrawerLayout5 = PopupDrawerLayout.this;
                if (popupDrawerLayout5.f8181j == 1.0f) {
                    com.lxj.xpopup.d.b bVar5 = popupDrawerLayout5.f8172a;
                    com.lxj.xpopup.d.b bVar6 = com.lxj.xpopup.d.b.Open;
                    if (bVar5 != bVar6) {
                        popupDrawerLayout5.f8172a = bVar6;
                        popupDrawerLayout5.v.a();
                    }
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            return view == popupDrawerLayout.f8174c ? i2 : popupDrawerLayout.a(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            View view2 = PopupDrawerLayout.this.f8174c;
            if (view != view2) {
                a(i2);
                return;
            }
            view2.layout(0, 0, view2.getMeasuredWidth(), PopupDrawerLayout.this.f8174c.getMeasuredHeight());
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            int iA = popupDrawerLayout.a(popupDrawerLayout.f8175d.getLeft() + i4);
            View view3 = PopupDrawerLayout.this.f8175d;
            view3.layout(iA, view3.getTop(), PopupDrawerLayout.this.f8175d.getMeasuredWidth() + iA, PopupDrawerLayout.this.f8175d.getBottom());
            a(iA);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int measuredWidth;
            int measuredWidth2;
            super.onViewReleased(view, f2, f3);
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            if (view == popupDrawerLayout.f8174c && f2 == 0.0f) {
                popupDrawerLayout.a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
            if (view == popupDrawerLayout2.f8175d && popupDrawerLayout2.q && !popupDrawerLayout2.r && f2 < -500.0f) {
                popupDrawerLayout2.a();
                return;
            }
            PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
            if (popupDrawerLayout3.f8176e == com.lxj.xpopup.d.d.Left) {
                if (f2 < -1000.0f) {
                    measuredWidth2 = popupDrawerLayout3.f8175d.getMeasuredWidth();
                } else {
                    if (PopupDrawerLayout.this.f8175d.getLeft() < (-popupDrawerLayout3.f8175d.getMeasuredWidth()) / 2) {
                        measuredWidth2 = PopupDrawerLayout.this.f8175d.getMeasuredWidth();
                    } else {
                        measuredWidth = 0;
                    }
                }
                measuredWidth = -measuredWidth2;
            } else if (f2 > 1000.0f) {
                measuredWidth = popupDrawerLayout3.getMeasuredWidth();
            } else {
                measuredWidth = view.getLeft() < popupDrawerLayout3.getMeasuredWidth() - (PopupDrawerLayout.this.f8175d.getMeasuredWidth() / 2) ? PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.f8175d.getMeasuredWidth() : PopupDrawerLayout.this.getMeasuredWidth();
            }
            PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
            popupDrawerLayout4.f8173b.smoothSlideViewTo(popupDrawerLayout4.f8175d, measuredWidth, view.getTop());
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PopupDrawerLayout.this.f8173b.continueSettling(true);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f8173b;
            View view = popupDrawerLayout.f8175d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f8176e == com.lxj.xpopup.d.d.Left ? 0 : view.getLeft() - PopupDrawerLayout.this.f8175d.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
            ViewDragHelper viewDragHelper = popupDrawerLayout.f8173b;
            View view = popupDrawerLayout.f8175d;
            viewDragHelper.smoothSlideViewTo(view, popupDrawerLayout.f8176e == com.lxj.xpopup.d.d.Left ? -view.getMeasuredWidth() : popupDrawerLayout.getMeasuredWidth(), 0);
            ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
        }
    }

    public interface d {
        void a();

        void a(float f2);

        void onClose();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    public void b() {
        post(new b());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8173b.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f8180i) {
            if (this.t == null) {
                this.t = new Paint();
                this.u = new Rect(0, 0, getMeasuredHeight(), com.lxj.xpopup.f.c.c());
            }
            this.t.setColor(((Integer) this.f8178g.evaluate(this.f8181j, Integer.valueOf(this.f8179h), Integer.valueOf(com.lxj.xpopup.b.f7945c))).intValue());
            canvas.drawRect(this.u, this.t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8183l = getTranslationY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8172a = null;
        this.f8181j = 0.0f;
        setTranslationY(this.f8183l);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8174c = getChildAt(0);
        this.f8175d = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.q = motionEvent.getX() < this.o;
        this.o = motionEvent.getX();
        this.p = motionEvent.getY();
        this.r = a(this, motionEvent.getX(), motionEvent.getY(), 1);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.o = 0.0f;
            this.p = 0.0f;
        }
        this.n = this.f8173b.shouldInterceptTouchEvent(motionEvent);
        return (!this.q || this.r) ? !a(this, motionEvent.getX(), motionEvent.getY()) ? this.n : super.onInterceptTouchEvent(motionEvent) : this.n;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view = this.f8174c;
        view.layout(0, 0, view.getMeasuredWidth(), this.f8174c.getMeasuredHeight());
        if (this.f8184m) {
            View view2 = this.f8175d;
            view2.layout(view2.getLeft(), this.f8175d.getTop(), this.f8175d.getRight(), this.f8175d.getBottom());
            return;
        }
        if (this.f8176e == com.lxj.xpopup.d.d.Left) {
            View view3 = this.f8175d;
            view3.layout(-view3.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else {
            this.f8175d.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.f8175d.getMeasuredWidth(), getMeasuredHeight());
        }
        this.f8184m = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8173b.continueSettling(true)) {
            return true;
        }
        this.f8173b.processTouchEvent(motionEvent);
        return true;
    }

    public void setDrawerPosition(com.lxj.xpopup.d.d dVar) {
        this.f8176e = dVar;
    }

    public void setOnCloseListener(d dVar) {
        this.v = dVar;
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8172a = null;
        this.f8176e = com.lxj.xpopup.d.d.Left;
        this.f8177f = new e();
        this.f8178g = new ArgbEvaluator();
        this.f8179h = 0;
        this.f8180i = false;
        this.f8181j = 0.0f;
        this.f8182k = true;
        this.f8184m = false;
        this.n = false;
        this.s = new a();
        this.f8173b = ViewDragHelper.create(this, this.s);
    }

    private boolean a(ViewGroup viewGroup, float f2, float f3, int i2) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            if (com.lxj.xpopup.f.c.a(f2, f3, new Rect(iArr[0], iArr[1], iArr[0] + childAt.getWidth(), iArr[1] + childAt.getHeight())) && (childAt instanceof ViewGroup)) {
                if (childAt instanceof ViewPager) {
                    ViewPager viewPager = (ViewPager) childAt;
                    if (i2 == 0) {
                        return viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1);
                    }
                    return viewPager.canScrollHorizontally(i2);
                }
                if (childAt instanceof HorizontalScrollView) {
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) childAt;
                    if (i2 == 0) {
                        return horizontalScrollView.canScrollHorizontally(-1) || horizontalScrollView.canScrollHorizontally(1);
                    }
                    return horizontalScrollView.canScrollHorizontally(i2);
                }
                return a((ViewGroup) childAt, f2, f3, i2);
            }
        }
        return false;
    }

    private boolean a(ViewGroup viewGroup, float f2, float f3) {
        return a(viewGroup, f2, f3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        com.lxj.xpopup.d.d dVar = this.f8176e;
        if (dVar == com.lxj.xpopup.d.d.Left) {
            if (i2 < (-this.f8175d.getMeasuredWidth())) {
                i2 = -this.f8175d.getMeasuredWidth();
            }
            if (i2 > 0) {
                return 0;
            }
            return i2;
        }
        if (dVar != com.lxj.xpopup.d.d.Right) {
            return i2;
        }
        if (i2 < getMeasuredWidth() - this.f8175d.getMeasuredWidth()) {
            i2 = getMeasuredWidth() - this.f8175d.getMeasuredWidth();
        }
        return i2 > getMeasuredWidth() ? getMeasuredWidth() : i2;
    }

    public void a() {
        if (this.f8173b.continueSettling(true)) {
            return;
        }
        post(new c());
    }
}
