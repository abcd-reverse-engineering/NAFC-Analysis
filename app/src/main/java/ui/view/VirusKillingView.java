package ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class VirusKillingView extends View {
    private static final String u = "VirusKilling";
    private static final int v = 1000;

    /* renamed from: a, reason: collision with root package name */
    private float f20462a;

    /* renamed from: b, reason: collision with root package name */
    private float f20463b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20464c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f20465d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f20466e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f20467f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f20468g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f20469h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f20470i;

    /* renamed from: j, reason: collision with root package name */
    private float f20471j;

    /* renamed from: k, reason: collision with root package name */
    private float f20472k;

    /* renamed from: l, reason: collision with root package name */
    private float f20473l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f20474m;
    private Thread n;
    private int o;
    private Handler p;
    private float q;
    private float r;
    private float s;
    private int t;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            synchronized (this) {
                if (VirusKillingView.this.f20473l < 1.0f) {
                    VirusKillingView.this.f20473l = 360.0f;
                } else {
                    VirusKillingView.b(VirusKillingView.this);
                    VirusKillingView.this.invalidate();
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            while (true) {
                try {
                    Thread.sleep(VirusKillingView.this.t);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (!VirusKillingView.this.f20474m) {
                    return;
                } else {
                    VirusKillingView.this.p.sendEmptyMessage(1000);
                }
            }
        }
    }

    public VirusKillingView(Context context) {
        super(context);
        this.f20473l = 360.0f;
        this.f20474m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    static /* synthetic */ float b(VirusKillingView virusKillingView) {
        float f2 = virusKillingView.f20473l;
        virusKillingView.f20473l = f2 - 1.0f;
        return f2;
    }

    private void f(Canvas canvas) {
        String strValueOf = String.valueOf(this.o);
        this.q = this.f20466e.measureText(strValueOf);
        this.r = (getWidth() - this.q) / 2.0f;
        Paint.FontMetrics fontMetrics = this.f20466e.getFontMetrics();
        this.s = (getHeight() / 2) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        canvas.drawText(strValueOf, this.r, this.s, this.f20466e);
    }

    public int getSchedule() {
        return this.o;
    }

    public int getmScanSpeed() {
        return this.t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        d(canvas);
        c(canvas);
        f(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMin = Math.min(b(i2), a(i3));
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f20462a = getWidth();
        this.f20463b = getHeight();
        float f2 = this.f20462a;
        this.f20470i = new RectF((float) (f2 * 0.1d), (float) (f2 * 0.1d), (float) (f2 * 0.9d), (float) (f2 * 0.9d));
        float f3 = this.f20462a;
        this.f20468g.setShader(new LinearGradient((float) (f3 * 0.3d), (float) (f3 * 0.9d), (float) (f3 * 0.1d), (float) (f3 * 0.5d), new int[]{Color.parseColor("#B1D6FD"), 0}, (float[]) null, Shader.TileMode.CLAMP));
        float f4 = this.f20462a;
        this.f20472k = (float) (f4 * 0.4d);
        this.f20471j = (float) (f4 * 0.25d);
    }

    public void setSchedule(int i2) {
        if (i2 < 0 || i2 > 100) {
            return;
        }
        this.o = i2;
        postInvalidate();
    }

    public void setmScanSpeed(int i2) {
        if (i2 < 20 || i2 > 1000) {
            return;
        }
        this.t = i2;
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return i2;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(400, size);
        }
        return 400;
    }

    private void c(Canvas canvas) {
        canvas.drawCircle(this.f20462a / 2.0f, this.f20463b / 2.0f, this.f20471j, this.f20464c);
        canvas.drawCircle(this.f20462a / 2.0f, this.f20463b / 2.0f, this.f20472k, this.f20464c);
    }

    private void d(Canvas canvas) {
        float f2 = this.f20462a;
        float f3 = this.f20463b;
        canvas.drawLine((float) (f2 * 0.1d), (float) (f3 * 0.5d), (float) (f2 * 0.9d), (float) (f3 * 0.5d), this.f20465d);
        float f4 = this.f20462a;
        float f5 = this.f20463b;
        canvas.drawLine((float) (f4 * 0.5d), (float) (f5 * 0.1d), (float) (f4 * 0.5d), (float) (f5 * 0.9d), this.f20465d);
    }

    private void e() {
        this.f20464c = new Paint();
        this.f20464c.setStrokeWidth(4.0f);
        this.f20464c.setAntiAlias(true);
        this.f20464c.setStyle(Paint.Style.STROKE);
        this.f20464c.setColor(Color.parseColor("#E3F0FC"));
        this.f20465d = new Paint();
        this.f20465d.setStrokeWidth(4.0f);
        this.f20465d.setAntiAlias(true);
        this.f20465d.setStyle(Paint.Style.STROKE);
        this.f20465d.setColor(Color.parseColor("#E3F0FC"));
        this.f20466e = new Paint(1);
        this.f20466e.setTextSize(90.0f);
        this.f20466e.setColor(Color.parseColor("#000000"));
        this.f20467f = new Paint(1);
        this.f20467f.setTextSize(30.0f);
        this.f20467f.setColor(Color.parseColor("#000000"));
        this.f20468g = new Paint();
        this.f20468g.setStrokeWidth(1.0f);
        this.f20468g.setColor(Color.parseColor("#2E93FE"));
        this.f20469h = new Paint();
        this.f20469h.setStrokeWidth(1.0f);
        this.f20469h.setColor(Color.parseColor("#3B9BFE"));
    }

    private int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return i2;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(400, size);
        }
        return 400;
    }

    public void c() {
        this.f20474m = true;
        this.n = new Thread(new b());
        this.n.start();
    }

    public void d() {
        this.f20474m = false;
    }

    private void b(Canvas canvas) {
        canvas.drawArc(this.f20470i, this.f20473l, 2.0f, true, this.f20469h);
    }

    private void a(Canvas canvas) {
        canvas.drawArc(this.f20470i, this.f20473l, 100.0f, true, this.f20468g);
    }

    public void b() {
        this.f20474m = true;
    }

    public boolean a() {
        return this.f20474m;
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20473l = 360.0f;
        this.f20474m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    public VirusKillingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20473l = 360.0f;
        this.f20474m = true;
        this.o = 0;
        this.p = new a();
        this.t = 20;
        e();
    }

    private void e(Canvas canvas) {
        canvas.drawText("%", this.r + this.q + 5.0f, (getHeight() / 2) + 20, this.f20467f);
    }
}
