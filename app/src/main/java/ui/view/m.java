package ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.xiaomi.mipush.sdk.Constants;
import util.n1;

/* compiled from: ColorPickerDialog.java */
/* loaded from: classes2.dex */
public class m extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f20554a;

    /* renamed from: b, reason: collision with root package name */
    private final String f20555b;

    /* renamed from: c, reason: collision with root package name */
    Context f20556c;

    /* renamed from: d, reason: collision with root package name */
    private String f20557d;

    /* renamed from: e, reason: collision with root package name */
    private int f20558e;

    /* renamed from: f, reason: collision with root package name */
    private b f20559f;

    /* compiled from: ColorPickerDialog.java */
    private class a extends View {

        /* renamed from: a, reason: collision with root package name */
        private Paint f20560a;

        /* renamed from: b, reason: collision with root package name */
        private Paint f20561b;

        /* renamed from: c, reason: collision with root package name */
        private Paint f20562c;

        /* renamed from: d, reason: collision with root package name */
        private Paint f20563d;

        /* renamed from: e, reason: collision with root package name */
        private Shader f20564e;

        /* renamed from: f, reason: collision with root package name */
        private float f20565f;

        /* renamed from: g, reason: collision with root package name */
        private float f20566g;

        /* renamed from: h, reason: collision with root package name */
        private float f20567h;

        /* renamed from: i, reason: collision with root package name */
        private float f20568i;

        /* renamed from: j, reason: collision with root package name */
        private final int[] f20569j;

        /* renamed from: k, reason: collision with root package name */
        private final int[] f20570k;

        /* renamed from: l, reason: collision with root package name */
        private int f20571l;

        /* renamed from: m, reason: collision with root package name */
        private int f20572m;
        private float n;
        private float o;
        private boolean p;
        private boolean q;
        private boolean r;
        private boolean s;

        public a(Context context, int i2, int i3) {
            super(context);
            this.p = true;
            int i4 = i2 - 36;
            this.f20571l = i4;
            this.f20572m = i3;
            setMinimumHeight(i4);
            setMinimumWidth(i3);
            this.f20569j = new int[]{SupportMenu.CATEGORY_MASK, -65281, -16776961, -16711681, -16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
            SweepGradient sweepGradient = new SweepGradient(0.0f, 0.0f, this.f20569j, (float[]) null);
            this.f20560a = new Paint(1);
            this.f20560a.setShader(sweepGradient);
            this.f20560a.setStyle(Paint.Style.STROKE);
            this.f20560a.setStrokeWidth(50.0f);
            this.n = ((i3 / 2) * 0.7f) - (this.f20560a.getStrokeWidth() * 0.5f);
            this.f20561b = new Paint(1);
            this.f20561b.setColor(m.this.f20558e);
            this.f20561b.setStrokeWidth(5.0f);
            this.o = (this.n - (this.f20560a.getStrokeWidth() / 2.0f)) * 0.7f;
            this.f20562c = new Paint(1);
            this.f20562c.setColor(Color.parseColor("#72A1D1"));
            this.f20562c.setStrokeWidth(4.0f);
            this.f20570k = new int[]{ViewCompat.MEASURED_STATE_MASK, this.f20561b.getColor(), -1};
            this.f20563d = new Paint(1);
            this.f20563d.setStrokeWidth(5.0f);
            this.f20565f = (-this.n) - (this.f20560a.getStrokeWidth() * 0.5f);
            this.f20566g = this.n + (this.f20560a.getStrokeWidth() * 0.5f) + (this.f20562c.getStrokeMiter() * 0.5f) + 15.0f;
            this.f20567h = this.n + (this.f20560a.getStrokeWidth() * 0.5f);
            this.f20568i = this.f20566g + 50.0f;
        }

        private boolean a(float f2, float f3) {
            return f2 <= this.f20567h && f2 >= this.f20565f && f3 <= this.f20568i && f3 >= this.f20566g;
        }

        private boolean a(float f2, float f3, float f4) {
            double d2 = f4;
            return ((double) ((f2 * f2) + (f3 * f3))) * 3.141592653589793d < (d2 * 3.141592653589793d) * d2;
        }

        private boolean a(float f2, float f3, float f4, float f5) {
            double d2 = f4;
            double d3 = f5;
            double d4 = ((f2 * f2) + (f3 * f3)) * 3.141592653589793d;
            return d4 < (d2 * 3.141592653589793d) * d2 && d4 > (d3 * 3.141592653589793d) * d3;
        }

        private int b(int[] iArr, float f2) {
            int i2;
            int i3;
            float f3;
            if (f2 < 0.0f) {
                i2 = iArr[0];
                i3 = iArr[1];
                f3 = this.f20567h;
                f2 += f3;
            } else {
                i2 = iArr[1];
                i3 = iArr[2];
                f3 = this.f20567h;
            }
            float f4 = f2 / f3;
            return Color.argb(a(Color.alpha(i2), Color.alpha(i3), f4), a(Color.red(i2), Color.red(i3), f4), a(Color.green(i2), Color.green(i3), f4), a(Color.blue(i2), Color.blue(i3), f4));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.translate(this.f20572m / 2, (this.f20571l / 2) - 50);
            canvas.drawCircle(0.0f, 0.0f, this.o, this.f20561b);
            if (this.r || this.s) {
                int color = this.f20561b.getColor();
                this.f20561b.setStyle(Paint.Style.STROKE);
                if (this.r) {
                    this.f20561b.setAlpha(255);
                } else if (this.s) {
                    this.f20561b.setAlpha(144);
                }
                canvas.drawCircle(0.0f, 0.0f, this.o + this.f20561b.getStrokeWidth(), this.f20561b);
                this.f20561b.setStyle(Paint.Style.FILL);
                this.f20561b.setColor(color);
            }
            float f2 = this.n;
            canvas.drawOval(new RectF(-f2, -f2, f2, f2), this.f20560a);
            if (this.p) {
                this.f20570k[1] = this.f20561b.getColor();
            }
            this.f20564e = new LinearGradient(this.f20565f, 0.0f, this.f20567h, 0.0f, this.f20570k, (float[]) null, Shader.TileMode.MIRROR);
            this.f20563d.setShader(this.f20564e);
            canvas.drawRect(this.f20565f, this.f20566g, this.f20567h, this.f20568i, this.f20563d);
            float strokeWidth = this.f20562c.getStrokeWidth() / 2.0f;
            float f3 = this.f20565f;
            float f4 = 2.0f * strokeWidth;
            canvas.drawLine(f3 - strokeWidth, this.f20566g - f4, f3 - strokeWidth, this.f20568i + f4, this.f20562c);
            float f5 = this.f20565f - f4;
            float f6 = this.f20566g;
            canvas.drawLine(f5, f6 - strokeWidth, this.f20567h + f4, f6 - strokeWidth, this.f20562c);
            float f7 = this.f20567h;
            canvas.drawLine(f7 + strokeWidth, this.f20566g - f4, f7 + strokeWidth, this.f20568i + f4, this.f20562c);
            float f8 = this.f20565f - f4;
            float f9 = this.f20568i;
            canvas.drawLine(f8, f9 + strokeWidth, this.f20567h + f4, f9 + strokeWidth, this.f20562c);
            super.onDraw(canvas);
        }

        @Override // android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(this.f20572m, this.f20571l);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX() - (this.f20572m / 2);
            float y = (motionEvent.getY() - (this.f20571l / 2)) + 50.0f;
            boolean zA = a(x, y, this.n + (this.f20560a.getStrokeWidth() / 2.0f), this.n - (this.f20560a.getStrokeWidth() / 2.0f));
            boolean zA2 = a(x, y, this.o);
            boolean zA3 = a(x, y);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (this.r && zA2 && m.this.f20559f != null) {
                        m.this.f20559f.a(this.f20561b.getColor());
                        m.this.dismiss();
                    }
                    if (this.p) {
                        this.p = false;
                    }
                    if (this.q) {
                        this.q = false;
                    }
                    if (this.r) {
                        this.r = false;
                    }
                    if (this.s) {
                        this.s = false;
                    }
                    invalidate();
                } else if (action == 2) {
                }
                return true;
            }
            this.p = zA;
            this.q = zA3;
            this.r = zA2;
            if (this.p && zA) {
                float fAtan2 = (float) (((float) Math.atan2(y, x)) / 6.283185307179586d);
                if (fAtan2 < 0.0f) {
                    fAtan2 += 1.0f;
                }
                this.f20561b.setColor(a(this.f20569j, fAtan2));
                n1.e("ColorPicker", "色环内, 坐标: " + x + Constants.ACCEPT_TIME_SEPARATOR_SP + y);
            } else if (this.q && zA3) {
                this.f20561b.setColor(b(this.f20570k, x));
            }
            n1.e("ColorPicker", "[MOVE] 高亮: " + this.r + "微亮: " + this.s + " 中心: " + zA2);
            if ((this.r && zA2) || (this.s && zA2)) {
                this.r = true;
                this.s = false;
            } else if (this.r || this.s) {
                this.r = false;
                this.s = true;
            } else {
                this.r = false;
                this.s = false;
            }
            invalidate();
            return true;
        }

        private int a(int[] iArr, float f2) {
            if (f2 <= 0.0f) {
                return iArr[0];
            }
            if (f2 >= 1.0f) {
                return iArr[iArr.length - 1];
            }
            float length = f2 * (iArr.length - 1);
            int i2 = (int) length;
            float f3 = length - i2;
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 1];
            return Color.argb(a(Color.alpha(i3), Color.alpha(i4), f3), a(Color.red(i3), Color.red(i4), f3), a(Color.green(i3), Color.green(i4), f3), a(Color.blue(i3), Color.blue(i4), f3));
        }

        private int a(int i2, int i3, float f2) {
            return i2 + Math.round(f2 * (i3 - i2));
        }
    }

    /* compiled from: ColorPickerDialog.java */
    public interface b {
        void a(int i2);
    }

    public m(Context context, String str, b bVar) {
        this(context, ViewCompat.MEASURED_STATE_MASK, str, bVar);
    }

    public b c() {
        return this.f20559f;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager windowManager = getWindow().getWindowManager();
        setContentView(new a(this.f20556c, (int) (windowManager.getDefaultDisplay().getHeight() * 0.5f), (int) (windowManager.getDefaultDisplay().getWidth() * 0.7f)));
        a(this.f20557d);
    }

    public void setmListener(b bVar) {
        this.f20559f = bVar;
    }

    public m(Context context, int i2, String str, b bVar) {
        super(context);
        this.f20554a = true;
        this.f20555b = "ColorPicker";
        this.f20556c = context;
        this.f20559f = bVar;
        this.f20558e = i2;
        this.f20557d = str;
    }

    public String a() {
        return this.f20557d;
    }

    public int b() {
        return this.f20558e;
    }

    public void a(String str) {
        this.f20557d = str;
    }

    public void a(int i2) {
        this.f20558e = i2;
    }
}
