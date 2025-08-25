package cn.qqtheme.framework.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import b.a.a.d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WheelView extends View {
    public static final float e0 = 2.0f;
    public static final int f0 = -1;
    public static final int g0 = 16;
    public static final int h0 = -16611122;
    public static final int i0 = -4473925;
    public static final int j0 = -8139290;
    public static final int k0 = 220;
    public static final float l0 = 2.0f;
    public static final int m0 = 3;
    private static final float n0 = 13.0f;
    private static final int o0 = 1;
    private static final int p0 = 2;
    private static final int q0 = 3;
    private static final int r0 = 5;
    private static final float s0 = 0.8f;
    private float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private float J;
    private long K;
    private int L;
    private int M;
    private int N;
    private int O;

    /* renamed from: a, reason: collision with root package name */
    private f f3258a;

    /* renamed from: b, reason: collision with root package name */
    private GestureDetector f3259b;
    private float b0;

    /* renamed from: c, reason: collision with root package name */
    private g f3260c;
    private boolean c0;

    /* renamed from: d, reason: collision with root package name */
    private h f3261d;
    private boolean d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3262e;

    /* renamed from: f, reason: collision with root package name */
    private ScheduledFuture<?> f3263f;

    /* renamed from: g, reason: collision with root package name */
    private Paint f3264g;

    /* renamed from: h, reason: collision with root package name */
    private Paint f3265h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f3266i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f3267j;

    /* renamed from: k, reason: collision with root package name */
    private List<l> f3268k;

    /* renamed from: l, reason: collision with root package name */
    private String f3269l;

    /* renamed from: m, reason: collision with root package name */
    private int f3270m;
    private int n;
    private int o;
    private int p;
    private float q;
    private Typeface r;
    private int s;
    private int t;
    private c u;
    private float v;
    private int w;
    private boolean x;
    private float y;
    private float z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelView.this.a(f3);
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelView.this.f3260c != null) {
                WheelView.this.f3260c.a(WheelView.this.C);
            }
            if (WheelView.this.f3261d != null) {
                WheelView.this.f3261d.a(true, WheelView.this.C, ((l) WheelView.this.f3268k.get(WheelView.this.C)).getName());
            }
        }
    }

    public static class c {

        /* renamed from: i, reason: collision with root package name */
        public static final float f3273i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public static final float f3274j = 1.0f;

        /* renamed from: a, reason: collision with root package name */
        protected boolean f3275a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f3276b;

        /* renamed from: c, reason: collision with root package name */
        protected int f3277c;

        /* renamed from: d, reason: collision with root package name */
        protected int f3278d;

        /* renamed from: e, reason: collision with root package name */
        protected int f3279e;

        /* renamed from: f, reason: collision with root package name */
        protected int f3280f;

        /* renamed from: g, reason: collision with root package name */
        protected float f3281g;

        /* renamed from: h, reason: collision with root package name */
        protected float f3282h;

        public c() {
            this.f3275a = true;
            this.f3276b = false;
            this.f3277c = WheelView.j0;
            this.f3278d = WheelView.i0;
            this.f3279e = 100;
            this.f3280f = 220;
            this.f3281g = 0.1f;
            this.f3282h = 2.0f;
        }

        public c a(boolean z) {
            this.f3276b = z;
            if (z && this.f3277c == -8139290) {
                this.f3277c = this.f3278d;
                this.f3280f = 255;
            }
            return this;
        }

        public c b(boolean z) {
            this.f3275a = z;
            return this;
        }

        public c c(@IntRange(from = 1, to = 255) int i2) {
            this.f3279e = i2;
            return this;
        }

        public c d(@ColorInt int i2) {
            this.f3276b = true;
            this.f3278d = i2;
            return this;
        }

        public String toString() {
            return "visible=" + this.f3275a + ",color=" + this.f3277c + ",alpha=" + this.f3280f + ",thick=" + this.f3282h;
        }

        public c b(@ColorInt int i2) {
            this.f3277c = i2;
            return this;
        }

        public c b(float f2) {
            this.f3282h = f2;
            return this;
        }

        public c a(@IntRange(from = 1, to = 255) int i2) {
            this.f3280f = i2;
            return this;
        }

        public c a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f3281g = f2;
            return this;
        }

        public c(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f3275a = true;
            this.f3276b = false;
            this.f3277c = WheelView.j0;
            this.f3278d = WheelView.i0;
            this.f3279e = 100;
            this.f3280f = 220;
            this.f3281g = 0.1f;
            this.f3282h = 2.0f;
            this.f3281g = f2;
        }
    }

    private static class d extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        float f3283a = 2.1474836E9f;

        /* renamed from: b, reason: collision with root package name */
        final float f3284b;

        /* renamed from: c, reason: collision with root package name */
        final WheelView f3285c;

        d(WheelView wheelView, float f2) {
            this.f3285c = wheelView;
            this.f3284b = f2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (this.f3283a == 2.1474836E9f) {
                if (Math.abs(this.f3284b) <= 2000.0f) {
                    this.f3283a = this.f3284b;
                } else if (this.f3284b > 0.0f) {
                    this.f3283a = 2000.0f;
                } else {
                    this.f3283a = -2000.0f;
                }
            }
            if (Math.abs(this.f3283a) >= 0.0f && Math.abs(this.f3283a) <= 20.0f) {
                this.f3285c.a();
                this.f3285c.f3258a.sendEmptyMessage(2000);
                return;
            }
            int i2 = (int) ((this.f3283a * 10.0f) / 1000.0f);
            float f2 = i2;
            this.f3285c.A -= f2;
            if (!this.f3285c.x) {
                float f3 = this.f3285c.q;
                float f4 = (-this.f3285c.B) * f3;
                float itemCount = ((this.f3285c.getItemCount() - 1) - this.f3285c.B) * f3;
                double d2 = f3 * 0.25d;
                if (this.f3285c.A - d2 < f4) {
                    f4 = this.f3285c.A + f2;
                } else if (this.f3285c.A + d2 > itemCount) {
                    itemCount = this.f3285c.A + f2;
                }
                if (this.f3285c.A <= f4) {
                    this.f3283a = 40.0f;
                    this.f3285c.A = (int) f4;
                } else if (this.f3285c.A >= itemCount) {
                    this.f3285c.A = (int) itemCount;
                    this.f3283a = -40.0f;
                }
            }
            float f5 = this.f3283a;
            if (f5 < 0.0f) {
                this.f3283a = f5 + 20.0f;
            } else {
                this.f3283a = f5 - 20.0f;
            }
            this.f3285c.f3258a.sendEmptyMessage(1000);
        }
    }

    @Deprecated
    public static class e extends c {
    }

    private static class f extends Handler {

        /* renamed from: b, reason: collision with root package name */
        static final int f3286b = 1000;

        /* renamed from: c, reason: collision with root package name */
        static final int f3287c = 2000;

        /* renamed from: d, reason: collision with root package name */
        static final int f3288d = 3000;

        /* renamed from: a, reason: collision with root package name */
        final WheelView f3289a;

        f(WheelView wheelView) {
            this.f3289a = wheelView;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                this.f3289a.invalidate();
            } else if (i2 == 2000) {
                this.f3289a.b(2);
            } else {
                if (i2 != 3000) {
                    return;
                }
                this.f3289a.d();
            }
        }
    }

    public interface g {
        void a(int i2);
    }

    @Deprecated
    public interface h {
        void a(boolean z, int i2, String str);
    }

    @Deprecated
    public interface i extends h {
    }

    private static class j extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        int f3290a = Integer.MAX_VALUE;

        /* renamed from: b, reason: collision with root package name */
        int f3291b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f3292c;

        /* renamed from: d, reason: collision with root package name */
        final WheelView f3293d;

        j(WheelView wheelView, int i2) {
            this.f3293d = wheelView;
            this.f3292c = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f3290a == Integer.MAX_VALUE) {
                this.f3290a = this.f3292c;
            }
            int i2 = this.f3290a;
            this.f3291b = (int) (i2 * 0.1f);
            if (this.f3291b == 0) {
                if (i2 < 0) {
                    this.f3291b = -1;
                } else {
                    this.f3291b = 1;
                }
            }
            if (Math.abs(this.f3290a) <= 1) {
                this.f3293d.a();
                this.f3293d.f3258a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            this.f3293d.A += this.f3291b;
            if (!this.f3293d.x) {
                float f2 = this.f3293d.q;
                float itemCount = ((this.f3293d.getItemCount() - 1) - this.f3293d.B) * f2;
                if (this.f3293d.A <= (-this.f3293d.B) * f2 || this.f3293d.A >= itemCount) {
                    this.f3293d.A -= this.f3291b;
                    this.f3293d.a();
                    this.f3293d.f3258a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                    return;
                }
            }
            this.f3293d.f3258a.sendEmptyMessage(1000);
            this.f3290a -= this.f3291b;
        }
    }

    private static class k implements l {
        private String name;

        /* synthetic */ k(String str, a aVar) {
            this(str);
        }

        @Override // b.a.a.d.l
        public String getName() {
            return this.name;
        }

        private k(String str) {
            this.name = str;
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    protected int getItemCount() {
        List<l> list = this.f3268k;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getSelectedIndex() {
        return this.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x02d1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.qqtheme.framework.widget.WheelView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.L = i2;
        g();
        setMeasuredDimension(this.G, this.F);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f3259b.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K = System.currentTimeMillis();
            a();
            this.J = motionEvent.getRawY();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.H;
                double dAcos = Math.acos((i2 - y) / i2) * this.H;
                float f2 = this.q;
                int i3 = (int) ((dAcos + (f2 / 2.0f)) / f2);
                this.I = (int) (((i3 - (this.E / 2)) * f2) - (((this.A % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.K > 120) {
                    b(3);
                } else {
                    b(1);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.J - motionEvent.getRawY();
            this.J = motionEvent.getRawY();
            this.A += rawY;
            if (!this.x) {
                float f3 = (-this.B) * this.q;
                float size = (this.f3268k.size() - 1) - this.B;
                float f4 = this.q;
                float f5 = size * f4;
                float f6 = this.A;
                if (f6 - (f4 * 0.25d) < f3) {
                    f3 = f6 - rawY;
                } else if (f6 + (f4 * 0.25d) > f5) {
                    f5 = f6 - rawY;
                }
                float f7 = this.A;
                if (f7 < f3) {
                    this.A = (int) f3;
                } else if (f7 > f5) {
                    this.A = (int) f5;
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setCycleDisable(boolean z) {
        this.x = !z;
    }

    public void setDividerColor(@ColorInt int i2) {
        this.u.b(i2);
        this.f3266i.setColor(i2);
    }

    public void setDividerConfig(c cVar) {
        if (cVar == null) {
            this.u.b(false);
            this.u.a(false);
            return;
        }
        this.u = cVar;
        this.f3266i.setColor(cVar.f3277c);
        this.f3266i.setStrokeWidth(cVar.f3282h);
        this.f3266i.setAlpha(cVar.f3280f);
        this.f3267j.setColor(cVar.f3278d);
        this.f3267j.setAlpha(cVar.f3279e);
    }

    public final void setGravity(int i2) {
        this.M = i2;
    }

    public final void setItems(List<?> list) {
        this.f3268k.clear();
        for (Object obj : list) {
            if (obj instanceof l) {
                this.f3268k.add((l) obj);
            } else {
                if (!(obj instanceof CharSequence) && !(obj instanceof Number)) {
                    throw new IllegalArgumentException("please implements " + l.class.getName());
                }
                this.f3268k.add(new k(obj.toString(), null));
            }
        }
        g();
        invalidate();
    }

    public final void setLabel(String str) {
        a(str, true);
    }

    @Deprecated
    public void setLineConfig(c cVar) {
        setDividerConfig(cVar);
    }

    public final void setLineSpaceMultiplier(@FloatRange(from = 2.0d, to = 4.0d) float f2) {
        this.v = f2;
        e();
    }

    public final void setOffset(@IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_PLAYLISTS) int i2) {
        if (i2 < 1 || i2 > 5) {
            throw new IllegalArgumentException("must between 1 and 5");
        }
        int i3 = (i2 * 2) + 1;
        if (i2 % 2 != 0) {
            i2--;
        }
        setVisibleItemCount(i3 + i2);
    }

    public final void setOnItemSelectListener(g gVar) {
        this.f3260c = gVar;
    }

    @Deprecated
    public final void setOnWheelListener(h hVar) {
        this.f3261d = hVar;
    }

    @Deprecated
    public void setPadding(int i2) {
        setTextPadding(i2);
    }

    public final void setSelectedIndex(int i2) {
        List<l> list = this.f3268k;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f3268k.size();
        if (i2 == 0 || (i2 > 0 && i2 < size && i2 != this.C)) {
            this.B = i2;
            this.A = 0.0f;
            this.I = 0;
            invalidate();
        }
    }

    public void setTextColor(@ColorInt int i2) {
        this.s = i2;
        this.t = i2;
        this.f3264g.setColor(i2);
        this.f3265h.setColor(i2);
    }

    public void setTextPadding(int i2) {
        this.w = b.a.a.g.b.b(getContext(), i2);
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            this.p = (int) (getContext().getResources().getDisplayMetrics().density * f2);
            this.f3264g.setTextSize(this.p);
            this.f3265h.setTextSize(this.p);
        }
    }

    public void setTextSizeAutoFit(boolean z) {
        this.d0 = z;
    }

    public void setTextSkewXOffset(int i2) {
        this.o = i2;
        if (i2 != 0) {
            this.f3265h.setTextScaleX(1.0f);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.r = typeface;
        this.f3264g.setTypeface(this.r);
        this.f3265h.setTypeface(this.r);
    }

    public void setUseWeight(boolean z) {
        this.c0 = z;
    }

    public final void setVisibleItemCount(int i2) {
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("must be odd");
        }
        if (i2 != this.E) {
            this.E = i2;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3262e = true;
        this.f3268k = new ArrayList();
        this.o = 0;
        this.p = 16;
        this.r = Typeface.DEFAULT;
        this.s = i0;
        this.t = h0;
        this.u = new c();
        this.v = 2.0f;
        this.w = -1;
        this.x = true;
        this.A = 0.0f;
        this.B = -1;
        this.E = 7;
        this.I = 0;
        this.J = 0.0f;
        this.K = 0L;
        this.M = 17;
        this.N = 0;
        this.O = 0;
        this.c0 = false;
        this.d0 = true;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.b0 = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.b0 = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.b0 = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.b0 = 6.0f;
        } else if (f2 >= 3.0f) {
            this.b0 = f2 * 2.5f;
        }
        e();
        a(context);
    }

    private void c() {
        this.f3264g = new Paint();
        this.f3264g.setAntiAlias(true);
        this.f3264g.setColor(this.s);
        this.f3264g.setTypeface(this.r);
        this.f3264g.setTextSize(this.p);
        this.f3265h = new Paint();
        this.f3265h.setAntiAlias(true);
        this.f3265h.setColor(this.t);
        this.f3265h.setTextScaleX(1.0f);
        this.f3265h.setTypeface(this.r);
        this.f3265h.setTextSize(this.p);
        this.f3266i = new Paint();
        this.f3266i.setAntiAlias(true);
        this.f3266i.setColor(this.u.f3277c);
        this.f3266i.setStrokeWidth(this.u.f3282h);
        this.f3266i.setAlpha(this.u.f3280f);
        this.f3267j = new Paint();
        this.f3267j.setAntiAlias(true);
        this.f3267j.setColor(this.u.f3278d);
        this.f3267j.setAlpha(this.u.f3279e);
        setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f3260c == null && this.f3261d == null) {
            return;
        }
        postDelayed(new b(), 200L);
    }

    private void e() {
        float f2 = this.v;
        if (f2 < 1.5f) {
            this.v = 1.5f;
        } else if (f2 > 4.0f) {
            this.v = 4.0f;
        }
    }

    private void f() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.f3268k.size(); i2++) {
            String strA = a(this.f3268k.get(i2));
            this.f3265h.getTextBounds(strA, 0, strA.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f3270m) {
                this.f3270m = iWidth;
            }
            this.f3265h.getTextBounds("测试", 0, 2, rect);
            this.n = rect.height() + 2;
        }
        this.q = this.v * this.n;
    }

    private void g() {
        int i2;
        if (this.f3268k == null) {
            return;
        }
        f();
        int i3 = (int) (this.q * (this.E - 1));
        this.F = (int) ((i3 * 2) / 3.141592653589793d);
        this.H = (int) (i3 / 3.141592653589793d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.c0) {
            this.G = View.MeasureSpec.getSize(this.L);
        } else if (layoutParams == null || (i2 = layoutParams.width) <= 0) {
            this.G = this.f3270m;
            if (this.w < 0) {
                this.w = b.a.a.g.b.b(getContext(), n0);
            }
            this.G += this.w * 2;
            if (!TextUtils.isEmpty(this.f3269l)) {
                this.G += a(this.f3265h, this.f3269l);
            }
        } else {
            this.G = i2;
        }
        b.a.a.g.d.b("measuredWidth=" + this.G + ",measuredHeight=" + this.F);
        int i4 = this.F;
        float f2 = this.q;
        this.y = (((float) i4) - f2) / 2.0f;
        this.z = (((float) i4) + f2) / 2.0f;
        if (this.B == -1) {
            if (this.x) {
                this.B = (this.f3268k.size() + 1) / 2;
            } else {
                this.B = 0;
            }
        }
        this.D = this.B;
    }

    private void b() {
        if (isInEditMode()) {
            setItems(new String[]{"李玉江", "男", "贵州", "穿青人"});
        }
    }

    public final void a(List<?> list, int i2) {
        setItems(list);
        setSelectedIndex(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        a();
        if (i2 == 2 || i2 == 3) {
            float f2 = this.A;
            float f3 = this.q;
            this.I = (int) (((f2 % f3) + f3) % f3);
            int i3 = this.I;
            if (i3 > f3 / 2.0f) {
                this.I = (int) (f3 - i3);
            } else {
                this.I = -i3;
            }
        }
        this.f3263f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new j(this, this.I), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void a(List<String> list, String str) {
        int iIndexOf = list.indexOf(str);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        a(list, iIndexOf);
    }

    public final void a(String[] strArr, int i2) {
        a(Arrays.asList(strArr), i2);
    }

    public final void a(String[] strArr, String str) {
        a(Arrays.asList(strArr), str);
    }

    public final void a(String str, boolean z) {
        this.f3269l = str;
        this.f3262e = z;
    }

    public final void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr));
    }

    public void a(@ColorInt int i2, @ColorInt int i3) {
        this.s = i2;
        this.t = i3;
        this.f3264g.setColor(i2);
        this.f3265h.setColor(i3);
    }

    private void b(String str) {
        Rect rect = new Rect();
        this.f3264g.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.M;
        if (i2 == 3) {
            this.O = b.a.a.g.b.b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.O = (this.G - rect.width()) - ((int) this.b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.O = (int) ((this.G - rect.width()) * 0.5d);
        }
    }

    private void a(Context context) {
        this.f3258a = new f(this);
        this.f3259b = new GestureDetector(context, new a());
        this.f3259b.setIsLongpressEnabled(false);
        c();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        a();
        this.f3263f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new d(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    private void c(String str) {
        Rect rect = new Rect();
        this.f3265h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.p;
        for (int iWidth = rect.width(); iWidth > this.G; iWidth = rect.width()) {
            i2--;
            this.f3265h.setTextSize(i2);
            this.f3265h.getTextBounds(str, 0, str.length(), rect);
        }
        this.f3264g.setTextSize(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ScheduledFuture<?> scheduledFuture = this.f3263f;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f3263f.cancel(true);
        this.f3263f = null;
    }

    private int a(int i2) {
        if (i2 < 0) {
            return a(i2 + this.f3268k.size());
        }
        return i2 > this.f3268k.size() + (-1) ? a(i2 - this.f3268k.size()) : i2;
    }

    private String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof l) {
            return ((l) obj).getName();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void a(String str) {
        Rect rect = new Rect();
        this.f3265h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.M;
        if (i2 == 3) {
            this.N = b.a.a.g.b.b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.N = (this.G - rect.width()) - ((int) this.b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.N = (int) ((this.G - rect.width()) * 0.5d);
        }
    }

    private int a(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCeil += (int) Math.ceil(r2[i2]);
        }
        return iCeil;
    }
}
