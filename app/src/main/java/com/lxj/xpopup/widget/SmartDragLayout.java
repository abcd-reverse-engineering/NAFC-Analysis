package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import com.lxj.xpopup.c.e;

/* loaded from: classes.dex */
public class SmartDragLayout extends FrameLayout implements NestedScrollingParent {
    private static final String q = "SmartDragLayout";

    /* renamed from: a, reason: collision with root package name */
    private View f8188a;

    /* renamed from: b, reason: collision with root package name */
    OverScroller f8189b;

    /* renamed from: c, reason: collision with root package name */
    VelocityTracker f8190c;

    /* renamed from: d, reason: collision with root package name */
    e f8191d;

    /* renamed from: e, reason: collision with root package name */
    boolean f8192e;

    /* renamed from: f, reason: collision with root package name */
    boolean f8193f;

    /* renamed from: g, reason: collision with root package name */
    boolean f8194g;

    /* renamed from: h, reason: collision with root package name */
    boolean f8195h;

    /* renamed from: i, reason: collision with root package name */
    com.lxj.xpopup.d.b f8196i;

    /* renamed from: j, reason: collision with root package name */
    int f8197j;

    /* renamed from: k, reason: collision with root package name */
    int f8198k;

    /* renamed from: l, reason: collision with root package name */
    int f8199l;

    /* renamed from: m, reason: collision with root package name */
    float f8200m;
    float n;
    boolean o;
    private d p;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.a(smartDragLayout.f8197j - smartDragLayout.getScrollY());
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.a(smartDragLayout.f8198k - smartDragLayout.getScrollY());
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8203a;

        c(int i2) {
            this.f8203a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartDragLayout smartDragLayout = SmartDragLayout.this;
            smartDragLayout.f8189b.startScroll(smartDragLayout.getScrollX(), SmartDragLayout.this.getScrollY(), 0, this.f8203a, com.lxj.xpopup.b.a());
            ViewCompat.postInvalidateOnAnimation(SmartDragLayout.this);
        }
    }

    public interface d {
        void a();

        void onClose();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    private void c() {
        if (this.f8192e) {
            this.f8189b.startScroll(getScrollX(), getScrollY(), 0, (getScrollY() > (this.o ? this.f8197j - this.f8198k : (this.f8197j - this.f8198k) * 2) / 3 ? this.f8197j : this.f8198k) - getScrollY(), com.lxj.xpopup.b.a());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void a() {
        this.f8195h = true;
        this.f8196i = com.lxj.xpopup.d.b.Closing;
        post(new b());
    }

    public void b() {
        this.f8196i = com.lxj.xpopup.d.b.Opening;
        post(new a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8189b.computeScrollOffset()) {
            scrollTo(this.f8189b.getCurrX(), this.f8189b.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f8195h = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o = false;
        this.f8195h = false;
        setTranslationY(0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f8197j = this.f8188a.getMeasuredHeight();
        this.f8198k = 0;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f8188a.getMeasuredWidth() / 2);
        if (this.f8192e) {
            this.f8188a.layout(measuredWidth, getMeasuredHeight(), this.f8188a.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.f8197j);
            if (this.f8196i == com.lxj.xpopup.d.b.Open) {
                scrollTo(getScrollX(), getScrollY() - (this.f8199l - this.f8197j));
            }
        } else {
            this.f8188a.layout(measuredWidth, getMeasuredHeight() - this.f8188a.getMeasuredHeight(), this.f8188a.getMeasuredWidth() + measuredWidth, getMeasuredHeight());
        }
        this.f8199l = this.f8197j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if ((getScrollY() > this.f8198k && getScrollY() < this.f8197j) && f3 < -1500.0f) {
            a();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            int scrollY = getScrollY() + i3;
            if (scrollY < this.f8197j) {
                iArr[1] = i3;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        scrollTo(getScrollX(), getScrollY() + i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f8189b.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return i2 == 2 && this.f8192e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.widget.OverScroller r0 = r8.f8189b
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto Lf
            r9 = 0
            r8.f8200m = r9
            r8.n = r9
            r9 = 0
            return r9
        Lf:
            int r0 = r9.getAction()
            r1 = 1
            if (r0 == 0) goto Lbf
            if (r0 == r1) goto L4c
            r2 = 2
            if (r0 == r2) goto L20
            r2 = 3
            if (r0 == r2) goto L4c
            goto Ld5
        L20:
            boolean r0 = r8.f8192e
            if (r0 == 0) goto Ld5
            android.view.VelocityTracker r0 = r8.f8190c
            r0.addMovement(r9)
            android.view.VelocityTracker r0 = r8.f8190c
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2)
            float r0 = r9.getY()
            float r2 = r8.n
            float r0 = r0 - r2
            int r0 = (int) r0
            int r2 = r8.getScrollX()
            int r3 = r8.getScrollY()
            int r3 = r3 - r0
            r8.scrollTo(r2, r3)
            float r9 = r9.getY()
            r8.n = r9
            goto Ld5
        L4c:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.View r2 = r8.f8188a
            r2.getGlobalVisibleRect(r0)
            float r2 = r9.getRawX()
            float r3 = r9.getRawY()
            boolean r0 = com.lxj.xpopup.f.c.a(r2, r3, r0)
            if (r0 != 0) goto L9c
            boolean r0 = r8.f8193f
            if (r0 == 0) goto L9c
            float r0 = r9.getX()
            float r2 = r8.f8200m
            float r0 = r0 - r2
            double r2 = (double) r0
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = java.lang.Math.pow(r2, r4)
            float r9 = r9.getY()
            float r0 = r8.n
            float r9 = r9 - r0
            double r6 = (double) r9
            double r4 = java.lang.Math.pow(r6, r4)
            double r2 = r2 + r4
            double r2 = java.lang.Math.sqrt(r2)
            float r9 = (float) r2
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            float r0 = (float) r0
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 >= 0) goto L9c
            r8.performClick()
        L9c:
            boolean r9 = r8.f8192e
            if (r9 == 0) goto Ld5
            android.view.VelocityTracker r9 = r8.f8190c
            float r9 = r9.getYVelocity()
            r0 = 1153138688(0x44bb8000, float:1500.0)
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto Lb1
            r8.a()
            goto Lb4
        Lb1:
            r8.c()
        Lb4:
            android.view.VelocityTracker r9 = r8.f8190c
            r9.clear()
            android.view.VelocityTracker r9 = r8.f8190c
            r9.recycle()
            goto Ld5
        Lbf:
            boolean r0 = r8.f8192e
            if (r0 == 0) goto Lc9
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r8.f8190c = r0
        Lc9:
            float r0 = r9.getX()
            r8.f8200m = r0
            float r9 = r9.getY()
            r8.n = r9
        Ld5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.SmartDragLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.f8188a = view;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scrollTo(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.f8197j
            if (r7 <= r0) goto L5
            r7 = r0
        L5:
            int r0 = r5.f8198k
            if (r7 >= r0) goto La
            r7 = r0
        La:
            int r0 = r5.f8198k
            int r1 = r7 - r0
            float r1 = (float) r1
            r2 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 * r2
            int r3 = r5.f8197j
            int r3 = r3 - r0
            float r0 = (float) r3
            float r1 = r1 / r0
            int r0 = r5.getScrollY()
            if (r7 <= r0) goto L20
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            r5.o = r0
            boolean r0 = r5.f8194g
            if (r0 == 0) goto L30
            com.lxj.xpopup.c.e r0 = r5.f8191d
            int r0 = r0.a(r1)
            r5.setBackgroundColor(r0)
        L30:
            com.lxj.xpopup.widget.SmartDragLayout$d r0 = r5.p
            if (r0 == 0) goto L5a
            boolean r3 = r5.f8195h
            if (r3 == 0) goto L49
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L49
            com.lxj.xpopup.d.b r3 = r5.f8196i
            com.lxj.xpopup.d.b r4 = com.lxj.xpopup.d.b.Close
            if (r3 == r4) goto L49
            r5.f8196i = r4
            r0.onClose()
            goto L5a
        L49:
            int r0 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r0 != 0) goto L5a
            com.lxj.xpopup.d.b r0 = r5.f8196i
            com.lxj.xpopup.d.b r1 = com.lxj.xpopup.d.b.Open
            if (r0 == r1) goto L5a
            r5.f8196i = r1
            com.lxj.xpopup.widget.SmartDragLayout$d r0 = r5.p
            r0.a()
        L5a:
            super.scrollTo(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.SmartDragLayout.scrollTo(int, int):void");
    }

    public void setOnCloseListener(d dVar) {
        this.p = dVar;
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8191d = new e();
        this.f8192e = true;
        this.f8193f = true;
        this.f8194g = true;
        this.f8195h = false;
        this.f8196i = com.lxj.xpopup.d.b.Close;
        if (this.f8192e) {
            this.f8189b = new OverScroller(context);
        }
    }

    public void b(boolean z) {
        this.f8192e = z;
    }

    public void a(int i2) {
        post(new c(i2));
    }

    public void a(boolean z) {
        this.f8193f = z;
    }

    public void c(boolean z) {
        this.f8194g = z;
    }
}
