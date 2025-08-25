package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.e.d;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.photoview.k;

/* loaded from: classes.dex */
public class PhotoViewContainer extends FrameLayout {

    /* renamed from: k, reason: collision with root package name */
    private static final String f8160k = "PhotoViewContainer";

    /* renamed from: a, reason: collision with root package name */
    private ViewDragHelper f8161a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager f8162b;

    /* renamed from: c, reason: collision with root package name */
    private int f8163c;

    /* renamed from: d, reason: collision with root package name */
    private int f8164d;

    /* renamed from: e, reason: collision with root package name */
    private d f8165e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8166f;

    /* renamed from: g, reason: collision with root package name */
    boolean f8167g;

    /* renamed from: h, reason: collision with root package name */
    private float f8168h;

    /* renamed from: i, reason: collision with root package name */
    private float f8169i;

    /* renamed from: j, reason: collision with root package name */
    ViewDragHelper.Callback f8170j;

    class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int top = PhotoViewContainer.this.f8162b.getTop() + (i3 / 2);
            return top >= 0 ? Math.min(top, PhotoViewContainer.this.f8164d) : -Math.min(-top, PhotoViewContainer.this.f8164d);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            super.onViewPositionChanged(view, i2, i3, i4, i5);
            ViewPager viewPager = PhotoViewContainer.this.f8162b;
            if (view != viewPager) {
                viewPager.offsetTopAndBottom(i5);
            }
            float fAbs = (Math.abs(i3) * 1.0f) / PhotoViewContainer.this.f8164d;
            float f2 = 1.0f - (0.2f * fAbs);
            PhotoViewContainer.this.f8162b.setScaleX(f2);
            PhotoViewContainer.this.f8162b.setScaleY(f2);
            view.setScaleX(f2);
            view.setScaleY(f2);
            if (PhotoViewContainer.this.f8165e != null) {
                PhotoViewContainer.this.f8165e.a(i5, f2, fAbs);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            super.onViewReleased(view, f2, f3);
            if (Math.abs(view.getTop()) > PhotoViewContainer.this.f8163c) {
                if (PhotoViewContainer.this.f8165e != null) {
                    PhotoViewContainer.this.f8165e.a();
                }
            } else {
                PhotoViewContainer.this.f8161a.smoothSlideViewTo(PhotoViewContainer.this.f8162b, 0, 0);
                PhotoViewContainer.this.f8161a.smoothSlideViewTo(view, 0, 0);
                ViewCompat.postInvalidateOnAnimation(PhotoViewContainer.this);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            return !PhotoViewContainer.this.f8166f;
        }
    }

    public PhotoViewContainer(@NonNull Context context) {
        this(context, null);
    }

    private PhotoView getCurrentPhotoView() {
        ViewPager viewPager = this.f8162b;
        return (PhotoView) viewPager.getChildAt(viewPager.getCurrentItem());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f8161a.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            if (r0 == 0) goto L48
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L40
            r3 = 2
            if (r0 == r3) goto L11
            r2 = 3
            if (r0 == r2) goto L40
            goto L54
        L11:
            float r0 = r6.getX()
            float r3 = r5.f8168h
            float r0 = r0 - r3
            float r3 = r6.getY()
            float r4 = r5.f8169i
            float r3 = r3 - r4
            androidx.viewpager.widget.ViewPager r4 = r5.f8162b
            r4.dispatchTouchEvent(r6)
            float r3 = java.lang.Math.abs(r3)
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L31
            r1 = 1
        L31:
            r5.f8167g = r1
            float r0 = r6.getX()
            r5.f8168h = r0
            float r0 = r6.getY()
            r5.f8169i = r0
            goto L54
        L40:
            r0 = 0
            r5.f8168h = r0
            r5.f8169i = r0
            r5.f8167g = r1
            goto L54
        L48:
            float r0 = r6.getX()
            r5.f8168h = r0
            float r0 = r6.getY()
            r5.f8169i = r0
        L54:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.PhotoViewContainer.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8166f = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8162b = (ViewPager) getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean zShouldInterceptTouchEvent = this.f8161a.shouldInterceptTouchEvent(motionEvent);
        if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            return false;
        }
        if (b() && this.f8167g) {
            return true;
        }
        return zShouldInterceptTouchEvent && this.f8167g;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8164d = getHeight() / 3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.f8161a.processTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    public void setOnDragChangeListener(d dVar) {
        this.f8165e = dVar;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f8163c = a(this.f8163c);
        this.f8161a = ViewDragHelper.create(this, this.f8170j);
        setBackgroundColor(0);
    }

    private boolean b() {
        PhotoView currentPhotoView = getCurrentPhotoView();
        if (currentPhotoView != null) {
            k kVar = currentPhotoView.f8091a;
            if (kVar.C || kVar.D) {
                return true;
            }
        }
        return false;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8163c = 80;
        this.f8166f = false;
        this.f8167g = false;
        this.f8170j = new a();
        a();
    }

    public int a(float f2) {
        return (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
