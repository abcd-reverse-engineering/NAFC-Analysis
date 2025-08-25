package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class c extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    final String f9609a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9610b;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f9611c;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f9612d;

    /* renamed from: e, reason: collision with root package name */
    private int f9613e;

    /* renamed from: f, reason: collision with root package name */
    private float f9614f;

    /* renamed from: g, reason: collision with root package name */
    private float f9615g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f9616h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9617i;

    /* renamed from: j, reason: collision with root package name */
    private float f9618j;

    /* renamed from: k, reason: collision with root package name */
    private float f9619k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f9620l;

    /* renamed from: m, reason: collision with root package name */
    private PointF f9621m;
    private float n;
    private float o;
    private Rect p;

    public c(Context context) {
        super(context);
        this.f9611c = new Matrix();
        this.f9612d = new Matrix();
        this.f9613e = 0;
        this.f9614f = 1.0f;
        this.f9615g = 1.0f;
        this.f9617i = false;
        this.f9609a = "TouchView";
        this.f9620l = new PointF();
        this.f9621m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.f9610b = false;
        this.p = new Rect();
        getDrawingRect(this.p);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        Animation scaleAnimation;
        if (this.f9616h == null) {
            return;
        }
        float fWidth = this.p.width();
        float fHeight = this.p.height();
        float[] fArr = new float[9];
        this.f9611c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        TranslateAnimation translateAnimation = null;
        float f5 = this.f9614f;
        if (f4 > f5) {
            this.o = f5 / f4;
            Matrix matrix = this.f9611c;
            float f6 = this.o;
            PointF pointF = this.f9621m;
            matrix.postScale(f6, f6, pointF.x, pointF.y);
            setImageMatrix(this.f9611c);
            float f7 = this.o;
            float f8 = 1.0f / f7;
            float f9 = 1.0f / f7;
            PointF pointF2 = this.f9621m;
            scaleAnimation = new ScaleAnimation(f8, 1.0f, f9, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f10 = this.f9615g;
            if (f4 < f10) {
                this.o = f10 / f4;
                Matrix matrix2 = this.f9611c;
                float f11 = this.o;
                PointF pointF3 = this.f9621m;
                matrix2.postScale(f11, f11, pointF3.x, pointF3.y);
                float f12 = this.o;
                PointF pointF4 = this.f9621m;
                scaleAnimation = new ScaleAnimation(1.0f, f12, 1.0f, f12, pointF4.x, pointF4.y);
            } else {
                float width = this.f9616h.getWidth() * f4;
                float height = this.f9616h.getHeight() * f4;
                int i2 = this.p.left;
                float f13 = i2 - f2;
                float f14 = r9.top - f3;
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (f14 < 0.0f) {
                    f3 = this.p.top;
                    z = true;
                }
                float f15 = height - f14;
                if (width - f13 < fWidth) {
                    f2 = this.p.left - (width - fWidth);
                    z = true;
                }
                if (f15 < fHeight) {
                    f3 = this.p.top - (height - fHeight);
                    z = true;
                }
                if (z) {
                    float f16 = fArr[2] - f2;
                    float f17 = fArr[5] - f3;
                    fArr[2] = f2;
                    fArr[5] = f3;
                    this.f9611c.setValues(fArr);
                    setImageMatrix(this.f9611c);
                    translateAnimation = new TranslateAnimation(f16, 0.0f, f17, 0.0f);
                } else {
                    setImageMatrix(this.f9611c);
                }
                scaleAnimation = translateAnimation;
            }
        }
        if (scaleAnimation != null) {
            this.f9617i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f9617i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f9616h == null) {
            return;
        }
        float[] fArr = {fMax, 0.0f, this.f9618j, 0.0f, fMax, this.f9619k, 0.0f, 0.0f, 0.0f};
        this.f9611c.getValues(fArr);
        float fMax = Math.max(this.p.width() / this.f9616h.getWidth(), this.p.height() / this.f9616h.getHeight());
        this.f9618j = this.p.left - (((this.f9616h.getWidth() * fMax) - this.p.width()) / 2.0f);
        this.f9619k = this.p.top - (((this.f9616h.getHeight() * fMax) - this.p.height()) / 2.0f);
        this.f9611c.setValues(fArr);
        this.f9614f = Math.min(2048.0f / this.f9616h.getWidth(), 2048.0f / this.f9616h.getHeight());
        this.f9615g = fMax;
        float f2 = this.f9614f;
        float f3 = this.f9615g;
        if (f2 < f3) {
            this.f9614f = f3;
        }
        setImageMatrix(this.f9611c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f9617i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L92
            if (r0 == r1) goto L8b
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L39
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L8b
            goto Lb1
        L1d:
            float r6 = r5.a(r6)
            r5.n = r6
            float r6 = r5.n
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Lb1
            android.graphics.Matrix r6 = r5.f9612d
            android.graphics.Matrix r0 = r5.f9611c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f9621m
            r5.a(r6)
            r5.f9613e = r3
            goto Lb1
        L39:
            int r0 = r5.f9613e
            if (r0 != r1) goto L61
            android.graphics.Matrix r0 = r5.f9611c
            android.graphics.Matrix r2 = r5.f9612d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f9620l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f9620l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f9611c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f9611c
            r5.setImageMatrix(r6)
            goto Lb1
        L61:
            if (r0 != r3) goto Lb1
            android.graphics.Matrix r0 = r5.f9611c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L85
            android.graphics.Matrix r0 = r5.f9611c
            android.graphics.Matrix r2 = r5.f9612d
            r0.set(r2)
            float r0 = r5.n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f9611c
            android.graphics.PointF r2 = r5.f9621m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L85:
            android.graphics.Matrix r6 = r5.f9611c
            r5.setImageMatrix(r6)
            goto Lb1
        L8b:
            r5.b()
            r6 = 0
            r5.f9613e = r6
            goto Lb1
        L92:
            android.graphics.Matrix r0 = r5.f9611c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f9612d
            android.graphics.Matrix r2 = r5.f9611c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f9620l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f9613e = r1
        Lb1:
            r5.f9610b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f9616h = bitmap;
        if (bitmap != null) {
            this.f9616h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void a(Rect rect) {
        this.p = rect;
        if (this.f9616h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f9616h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f9611c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = this.f9616h.getWidth() * f4;
        float height = this.f9616h.getHeight() * f4;
        float f5 = this.p.left - f2;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f2 + width) - this.p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float fWidth = (this.p.width() * f5) / (f6 + f5);
        Rect rect = this.p;
        float f7 = fWidth + rect.left;
        float f8 = rect.top - f3;
        float f9 = (f3 + height) - rect.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        if (f9 <= 1.0f) {
            f9 = 1.0f;
        }
        pointF.set(f7, ((this.p.height() * f8) / (f9 + f8)) + this.p.top);
    }
}
