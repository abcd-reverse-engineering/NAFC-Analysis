package com.luozm.captcha;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.luozm.captcha.Captcha;

/* loaded from: classes.dex */
class PictureVertifyView extends AppCompatImageView {
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    private static final int v = 4;
    private static final int w = 5;
    private static final int x = 6;
    private static final int y = 20;

    /* renamed from: a, reason: collision with root package name */
    private int f7847a;

    /* renamed from: b, reason: collision with root package name */
    private f f7848b;

    /* renamed from: c, reason: collision with root package name */
    private f f7849c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f7850d;

    /* renamed from: e, reason: collision with root package name */
    private Path f7851e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f7852f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f7853g;

    /* renamed from: h, reason: collision with root package name */
    private long f7854h;

    /* renamed from: i, reason: collision with root package name */
    private long f7855i;

    /* renamed from: j, reason: collision with root package name */
    private int f7856j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f7857k;

    /* renamed from: l, reason: collision with root package name */
    private a f7858l;

    /* renamed from: m, reason: collision with root package name */
    private d f7859m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;

    interface a {
        void a();

        void a(long j2);
    }

    public PictureVertifyView(Context context) {
        this(context, null);
    }

    private void e() {
        try {
            if (Math.abs(this.f7849c.f7870a - this.f7848b.f7870a) >= 20 || Math.abs(this.f7849c.f7871b - this.f7848b.f7871b) >= 20) {
                d();
                if (this.f7858l != null) {
                    this.f7858l.a();
                }
            } else {
                a();
                if (this.f7858l != null) {
                    this.f7858l.a(this.f7855i - this.f7854h);
                }
            }
        } catch (Exception unused) {
            d();
            a aVar = this.f7858l;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private Bitmap f() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        getDrawable().setBounds(0, 0, getWidth(), getHeight());
        canvas.clipPath(this.f7851e);
        getDrawable().draw(canvas);
        this.f7859m.a(canvas, this.f7851e);
        return b(bitmapCreateBitmap);
    }

    private void g() {
        if (this.f7848b == null) {
            this.f7848b = this.f7859m.a(getWidth(), getHeight(), this.f7856j);
            if (this.n == 1) {
                this.f7849c = new f(0, this.f7848b.f7871b);
            } else {
                this.f7849c = this.f7859m.b(getWidth(), getHeight(), this.f7856j);
            }
        }
        if (this.f7851e == null) {
            this.f7851e = this.f7859m.a(this.f7856j);
            Path path = this.f7851e;
            f fVar = this.f7848b;
            path.offset(fVar.f7870a, fVar.f7871b);
        }
        if (this.f7850d == null) {
            this.f7850d = f();
        }
    }

    void a(int i2) {
        this.f7854h = System.currentTimeMillis();
        this.f7847a = 1;
        this.f7849c.f7870a = (int) ((i2 / 100.0f) * (getWidth() - this.f7856j));
        invalidate();
    }

    void b(int i2) {
        this.f7847a = 2;
        this.f7849c.f7870a = (int) ((i2 / 100.0f) * (getWidth() - this.f7856j));
        invalidate();
    }

    void c() {
        this.f7847a = 4;
        this.f7850d = null;
        this.f7848b = null;
        this.f7851e = null;
        invalidate();
    }

    void d() {
        this.f7847a = 6;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.n == 2 && (motionEvent.getX() < this.f7849c.f7870a || motionEvent.getX() > this.f7849c.f7870a + this.f7856j || motionEvent.getY() < this.f7849c.f7871b || motionEvent.getY() > this.f7849c.f7871b + this.f7856j)) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g();
        if (this.f7847a != 5) {
            canvas.drawPath(this.f7851e, this.f7853g);
        }
        int i2 = this.f7847a;
        if (i2 == 2 || i2 == 4 || i2 == 1 || i2 == 6) {
            Bitmap bitmap = this.f7850d;
            f fVar = this.f7849c;
            canvas.drawBitmap(bitmap, fVar.f7870a, fVar.f7871b, this.f7852f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n == 2 && this.f7850d != null && this.f7857k) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.q = x2;
                this.r = y2;
                a(x2, y2);
            } else if (action == 1) {
                b();
            } else if (action == 2) {
                b(x2 - this.o, y2 - this.p);
            }
            this.o = x2;
            this.p = y2;
        }
        return true;
    }

    public PictureVertifyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureVertifyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7847a = 4;
        this.f7856j = 50;
        this.f7857k = true;
        this.f7859m = new e(context);
        this.f7853g = this.f7859m.b();
        this.f7852f = this.f7859m.a();
        setLayerType(1, this.f7852f);
    }

    void d(@Captcha.g int i2) {
        this.n = i2;
        this.f7851e = null;
        this.f7849c = null;
        this.f7848b = null;
        this.f7850d = null;
        invalidate();
    }

    void b(float f2, float f3) {
        this.f7847a = 2;
        f fVar = this.f7849c;
        fVar.f7870a = (int) (fVar.f7870a + f2);
        fVar.f7871b = (int) (fVar.f7871b + f3);
        invalidate();
    }

    void a(float f2, float f3) {
        this.f7847a = 1;
        f fVar = this.f7849c;
        int i2 = this.f7856j;
        fVar.f7870a = (int) (f2 - (i2 / 2.0f));
        fVar.f7871b = (int) (f3 - (i2 / 2.0f));
        this.f7854h = System.currentTimeMillis();
        invalidate();
    }

    void c(int i2) {
        this.f7856j = i2;
        this.f7851e = null;
        this.f7849c = null;
        this.f7848b = null;
        this.f7850d = null;
        invalidate();
    }

    void b() {
        this.f7847a = 3;
        this.f7855i = System.currentTimeMillis();
        e();
        invalidate();
    }

    void a() {
        this.f7847a = 5;
        invalidate();
    }

    private Bitmap b(Bitmap bitmap) {
        f fVar = this.f7848b;
        int i2 = fVar.f7870a;
        int i3 = fVar.f7871b;
        int i4 = this.f7856j;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i4);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    void a(a aVar) {
        this.f7858l = aVar;
    }

    void a(d dVar) {
        this.f7859m = dVar;
    }

    public void a(Bitmap bitmap) {
        this.f7851e = null;
        this.f7849c = null;
        this.f7848b = null;
        this.f7850d.recycle();
        this.f7850d = null;
        setImageBitmap(bitmap);
    }

    void a(boolean z) {
        this.f7857k = z;
    }
}
