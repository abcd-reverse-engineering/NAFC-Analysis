package com.lxj.xpopup.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: CustomGestureDetector.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: k, reason: collision with root package name */
    private static final int f8094k = -1;

    /* renamed from: a, reason: collision with root package name */
    private int f8095a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f8096b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final ScaleGestureDetector f8097c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f8098d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8099e;

    /* renamed from: f, reason: collision with root package name */
    private float f8100f;

    /* renamed from: g, reason: collision with root package name */
    private float f8101g;

    /* renamed from: h, reason: collision with root package name */
    private final float f8102h;

    /* renamed from: i, reason: collision with root package name */
    private final float f8103i;

    /* renamed from: j, reason: collision with root package name */
    private c f8104j;

    /* compiled from: CustomGestureDetector.java */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.f8104j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8103i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8102h = viewConfiguration.getScaledTouchSlop();
        this.f8104j = cVar;
        this.f8097c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f8096b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f8096b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f8095a = motionEvent.getPointerId(0);
            this.f8098d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f8098d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f8100f = b(motionEvent);
            this.f8101g = c(motionEvent);
            this.f8099e = false;
        } else if (action == 1) {
            this.f8095a = -1;
            if (this.f8099e && this.f8098d != null) {
                this.f8100f = b(motionEvent);
                this.f8101g = c(motionEvent);
                this.f8098d.addMovement(motionEvent);
                this.f8098d.computeCurrentVelocity(1000);
                float xVelocity = this.f8098d.getXVelocity();
                float yVelocity = this.f8098d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f8103i) {
                    this.f8104j.onFling(this.f8100f, this.f8101g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f8098d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f8098d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f2 = fB - this.f8100f;
            float f3 = fC - this.f8101g;
            if (!this.f8099e) {
                this.f8099e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f8102h);
            }
            if (this.f8099e) {
                this.f8104j.onDrag(f2, f3);
                this.f8100f = fB;
                this.f8101g = fC;
                VelocityTracker velocityTracker3 = this.f8098d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f8095a = -1;
            VelocityTracker velocityTracker4 = this.f8098d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f8098d = null;
            }
        } else if (action == 6) {
            int iA = l.a(motionEvent.getAction());
            if (motionEvent.getPointerId(iA) == this.f8095a) {
                int i2 = iA == 0 ? 1 : 0;
                this.f8095a = motionEvent.getPointerId(i2);
                this.f8100f = motionEvent.getX(i2);
                this.f8101g = motionEvent.getY(i2);
            }
        }
        int i3 = this.f8095a;
        if (i3 == -1) {
            i3 = 0;
        }
        this.f8096b = motionEvent.findPointerIndex(i3);
        return true;
    }

    public boolean a() {
        return this.f8099e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f8097c.onTouchEvent(motionEvent);
            }
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public boolean b() {
        return this.f8097c.isInProgress();
    }
}
