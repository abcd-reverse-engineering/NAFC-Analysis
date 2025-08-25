package cn.jzvd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public abstract class Jzvd extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    public static final String L = "JZVD";
    public static Jzvd M = null;
    public static final int O = 0;
    public static final int b0 = 1;
    public static final int c0 = 2;
    public static final int d0 = -1;
    public static final int e0 = 0;
    public static final int f0 = 1;
    public static final int g0 = 2;
    public static final int h0 = 3;
    public static final int i0 = 4;
    public static final int j0 = 5;
    public static final int k0 = 6;
    public static final int l0 = 7;
    public static final int m0 = 0;
    public static final int n0 = 1;
    public static final int o0 = 2;
    public static final int p0 = 3;
    public static final int x0 = 80;
    protected boolean A;
    protected float B;
    protected float C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected long G;
    protected int H;
    protected float I;
    protected long J;
    public boolean K;

    /* renamed from: a, reason: collision with root package name */
    public int f3188a;

    /* renamed from: b, reason: collision with root package name */
    public int f3189b;

    /* renamed from: c, reason: collision with root package name */
    public v f3190c;

    /* renamed from: d, reason: collision with root package name */
    public int f3191d;

    /* renamed from: e, reason: collision with root package name */
    public int f3192e;

    /* renamed from: f, reason: collision with root package name */
    public Class f3193f;

    /* renamed from: g, reason: collision with root package name */
    public w f3194g;

    /* renamed from: h, reason: collision with root package name */
    public int f3195h;

    /* renamed from: i, reason: collision with root package name */
    public int f3196i;

    /* renamed from: j, reason: collision with root package name */
    protected long f3197j;

    /* renamed from: k, reason: collision with root package name */
    public int f3198k;

    /* renamed from: l, reason: collision with root package name */
    public long f3199l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f3200m;
    public SeekBar n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public JZTextureView u;
    protected Timer v;
    protected int w;
    protected int x;
    protected AudioManager y;
    protected c z;
    public static LinkedList<ViewGroup> N = new LinkedList<>();
    public static boolean q0 = true;
    public static int r0 = 6;
    public static int s0 = 1;
    public static boolean t0 = false;
    public static boolean u0 = false;
    public static int v0 = 0;
    public static long w0 = 0;
    public static int y0 = 0;
    public static AudioManager.OnAudioFocusChangeListener z0 = new a();

    static class a implements AudioManager.OnAudioFocusChangeListener {
        a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (i2 != -2) {
                if (i2 != -1) {
                    return;
                }
                Jzvd.F();
                String str = "AUDIOFOCUS_LOSS [" + hashCode() + "]";
                return;
            }
            try {
                Jzvd jzvd = Jzvd.M;
                if (jzvd != null && jzvd.f3188a == 4) {
                    jzvd.f3200m.performClick();
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            String str2 = "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]";
        }
    }

    public static class b implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if ((f2 < -12.0f || f2 > 12.0f) && System.currentTimeMillis() - Jzvd.w0 > 2000) {
                Jzvd jzvd = Jzvd.M;
                if (jzvd != null) {
                    jzvd.a(f2);
                }
                Jzvd.w0 = System.currentTimeMillis();
            }
        }
    }

    public class c extends TimerTask {
        public c() {
        }

        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = Jzvd.this.getCurrentPositionWhenPlaying();
            long duration = Jzvd.this.getDuration();
            Jzvd.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2 = Jzvd.this.f3188a;
            if (i2 == 4 || i2 == 5) {
                Jzvd.this.post(new Runnable() { // from class: cn.jzvd.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3228a.a();
                    }
                });
            }
        }
    }

    public Jzvd(Context context) {
        super(context);
        this.f3188a = -1;
        this.f3189b = -1;
        this.f3191d = 0;
        this.f3192e = 0;
        this.f3195h = -1;
        this.f3196i = 0;
        this.f3197j = 0L;
        this.f3198k = -1;
        this.f3199l = 0L;
        this.K = false;
        a(context);
    }

    public static boolean C() {
        Jzvd jzvd;
        Jzvd jzvd2;
        if (N.size() != 0 && (jzvd2 = M) != null) {
            jzvd2.i();
            return true;
        }
        if (N.size() != 0 || (jzvd = M) == null || jzvd.f3189b == 0) {
            return false;
        }
        jzvd.d();
        return true;
    }

    public static void D() {
        Jzvd jzvd = M;
        if (jzvd != null) {
            int i2 = jzvd.f3188a;
            if (i2 == 6 || i2 == 0 || i2 == 1 || i2 == 7) {
                F();
                return;
            }
            y0 = i2;
            jzvd.p();
            M.f3194g.d();
        }
    }

    public static void E() {
        Jzvd jzvd = M;
        if (jzvd == null || jzvd.f3188a != 5) {
            return;
        }
        if (y0 == 5) {
            jzvd.p();
            M.f3194g.d();
        } else {
            jzvd.q();
            M.f3194g.g();
        }
        y0 = 0;
    }

    public static void F() {
        Jzvd jzvd = M;
        if (jzvd != null) {
            jzvd.s();
            M = null;
        }
    }

    public static void setCurrentJzvd(Jzvd jzvd) {
        Jzvd jzvd2 = M;
        if (jzvd2 != null) {
            jzvd2.s();
        }
        M = jzvd;
    }

    public static void setTextureViewRotation(int i2) {
        JZTextureView jZTextureView;
        Jzvd jzvd = M;
        if (jzvd == null || (jZTextureView = jzvd.u) == null) {
            return;
        }
        jZTextureView.setRotation(i2);
    }

    public static void setVideoImageDisplayType(int i2) {
        JZTextureView jZTextureView;
        v0 = i2;
        Jzvd jzvd = M;
        if (jzvd == null || (jZTextureView = jzvd.u) == null) {
            return;
        }
        jZTextureView.requestLayout();
    }

    public void A() {
        String str = "startVideo [" + hashCode() + "] ";
        setCurrentJzvd(this);
        try {
            this.f3194g = (w) this.f3193f.getConstructor(Jzvd.class).newInstance(this);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        a();
        this.y = (AudioManager) getApplicationContext().getSystemService("audio");
        this.y.requestAudioFocus(z0, 3, 2);
        y.f(getContext()).getWindow().addFlags(128);
        r();
    }

    public void B() {
        if (this.f3188a == 3) {
            this.f3194g.g();
        } else {
            this.K = false;
            A();
        }
    }

    public void a(float f2, int i2) {
    }

    public void a(float f2, String str, long j2, String str2, long j3) {
    }

    public void a(int i2) {
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f3200m = (ImageView) findViewById(R.id.start);
        this.o = (ImageView) findViewById(R.id.fullscreen);
        this.n = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.p = (TextView) findViewById(R.id.current);
        this.q = (TextView) findViewById(R.id.total);
        this.t = (ViewGroup) findViewById(R.id.layout_bottom);
        this.r = (ViewGroup) findViewById(R.id.surface_container);
        this.s = (ViewGroup) findViewById(R.id.layout_top);
        this.f3200m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.n.setOnSeekBarChangeListener(this);
        this.t.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setOnTouchListener(this);
        this.w = getContext().getResources().getDisplayMetrics().widthPixels;
        this.x = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f3188a = -1;
    }

    public void b(int i2, int i3) {
        String str = "onInfo what - " + i2 + " extra - " + i3;
        if (i2 == 3) {
            int i4 = this.f3188a;
            if (i4 == 3 || i4 == 2) {
                q();
            }
        }
    }

    public void c(int i2, int i3) {
        String str = "onVideoSizeChanged  [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.u;
        if (jZTextureView != null) {
            int i4 = this.f3196i;
            if (i4 != 0) {
                jZTextureView.setRotation(i4);
            }
            this.u.a(i2, i3);
        }
    }

    public void d() {
        y.g(getContext());
        y.a(getContext(), s0);
        y.h(getContext());
        ((ViewGroup) y.f(getContext()).getWindow().getDecorView()).removeView(this);
        w wVar = this.f3194g;
        if (wVar != null) {
            wVar.f();
        }
        M = null;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.f3188a;
        if (i2 != 4 && i2 != 5) {
            return 0L;
        }
        try {
            return this.f3194g.a();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return this.f3194g.b();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public void h() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeView(this);
        a(viewGroup);
        N.add(viewGroup);
        ((ViewGroup) y.f(getContext()).getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
        u();
        y.c(getContext());
        y.a(getContext(), r0);
        y.d(getContext());
    }

    public void i() {
        this.f3197j = System.currentTimeMillis();
        ((ViewGroup) y.f(getContext()).getWindow().getDecorView()).removeView(this);
        N.getLast().removeAllViews();
        N.getLast().addView(this, new FrameLayout.LayoutParams(-1, -1));
        N.pop();
        v();
        y.g(getContext());
        y.a(getContext(), s0);
        y.h(getContext());
    }

    public void j() {
        Runtime.getRuntime().gc();
        String str = "onAutoCompletion  [" + hashCode() + "] ";
        c();
        e();
        f();
        g();
        m();
        this.f3194g.f();
        y.f(getContext()).getWindow().clearFlags(128);
        y.a(getContext(), this.f3190c.c(), 0L);
    }

    public void k() {
        String str = "onPrepared  [" + hashCode() + "] ";
        this.f3188a = 3;
        if (!this.K) {
            this.f3194g.g();
            this.K = false;
        }
        if (this.f3190c.c().toString().toLowerCase().contains("mp3") || this.f3190c.c().toString().toLowerCase().contains("wma") || this.f3190c.c().toString().toLowerCase().contains("aac") || this.f3190c.c().toString().toLowerCase().contains("m4a") || this.f3190c.c().toString().toLowerCase().contains("wav")) {
            q();
        }
    }

    public void l() {
    }

    public void m() {
        String str = "onStateAutoComplete  [" + hashCode() + "] ";
        this.f3188a = 6;
        c();
        this.n.setProgress(100);
        this.p.setText(this.q.getText());
    }

    public void n() {
        String str = "onStateError  [" + hashCode() + "] ";
        this.f3188a = 7;
        c();
    }

    public void o() {
        String str = "onStateNormal  [" + hashCode() + "] ";
        this.f3188a = 0;
        c();
        w wVar = this.f3194g;
        if (wVar != null) {
            wVar.f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.start) {
            if (id == R.id.fullscreen) {
                String str = "onClick fullscreen [" + hashCode() + "] ";
                if (this.f3188a == 6) {
                    return;
                }
                if (this.f3189b == 1) {
                    C();
                    return;
                }
                String str2 = "toFullscreenActivity [" + hashCode() + "] ";
                h();
                return;
            }
            return;
        }
        String str3 = "onClick start [" + hashCode() + "] ";
        v vVar = this.f3190c;
        if (vVar == null || vVar.f3245b.isEmpty() || this.f3190c.c() == null) {
            Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i2 = this.f3188a;
        if (i2 == 0) {
            if (this.f3190c.c().toString().startsWith("file") || this.f3190c.c().toString().startsWith("/") || y.e(getContext()) || u0) {
                A();
                return;
            } else {
                x();
                return;
            }
        }
        if (i2 == 4) {
            String str4 = "pauseVideo [" + hashCode() + "] ";
            this.f3194g.d();
            p();
            return;
        }
        if (i2 == 5) {
            this.f3194g.g();
            q();
        } else if (i2 == 6) {
            A();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = this.f3189b;
        if (i4 == 1 || i4 == 2) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.f3191d == 0 || this.f3192e == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = (int) ((size * this.f3192e) / this.f3191d);
        setMeasuredDimension(size, i5);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (z) {
            this.p.setText(y.a((i2 * getDuration()) / 100));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStartTrackingTouch [" + hashCode() + "] ";
        c();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStopTrackingTouch [" + hashCode() + "] ";
        z();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.f3188a;
        if (i2 == 4 || i2 == 5) {
            long progress = (seekBar.getProgress() * getDuration()) / 100;
            this.f3198k = seekBar.getProgress();
            this.f3194g.a(progress);
            String str2 = "seekTo " + progress + " [" + hashCode() + "] ";
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                String str = "onTouch surfaceContainer actionDown [" + hashCode() + "] ";
                this.A = true;
                this.B = x;
                this.C = y;
                this.D = false;
                this.E = false;
                this.F = false;
            } else if (action == 1) {
                String str2 = "onTouch surfaceContainer actionUp [" + hashCode() + "] ";
                this.A = false;
                f();
                g();
                e();
                if (this.E) {
                    this.f3194g.a(this.J);
                    long duration = getDuration();
                    long j2 = this.J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.n.setProgress((int) (j2 / duration));
                }
                z();
            } else if (action == 2) {
                String str3 = "onTouch surfaceContainer actionMove [" + hashCode() + "] ";
                float f2 = x - this.B;
                float f3 = y - this.C;
                float fAbs = Math.abs(f2);
                float fAbs2 = Math.abs(f3);
                if (this.f3189b == 1 && !this.E && !this.D && !this.F && (fAbs > 80.0f || fAbs2 > 80.0f)) {
                    c();
                    if (fAbs >= 80.0f) {
                        if (this.f3188a != 7) {
                            this.E = true;
                            this.G = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.B < this.w * 0.5f) {
                        this.F = true;
                        float f4 = y.b(getContext()).getAttributes().screenBrightness;
                        if (f4 < 0.0f) {
                            try {
                                this.I = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                String str4 = "current system brightness: " + this.I;
                            } catch (Settings.SettingNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            this.I = f4 * 255.0f;
                            String str5 = "current activity brightness: " + this.I;
                        }
                    } else {
                        this.D = true;
                        this.H = this.y.getStreamVolume(3);
                    }
                }
                if (this.E) {
                    long duration2 = getDuration();
                    this.J = (int) (this.G + ((duration2 * f2) / this.w));
                    if (this.J > duration2) {
                        this.J = duration2;
                    }
                    a(f2, y.a(this.J), this.J, y.a(duration2), duration2);
                }
                if (this.D) {
                    f3 = -f3;
                    this.y.setStreamVolume(3, this.H + ((int) (((this.y.getStreamMaxVolume(3) * f3) * 3.0f) / this.x)), 0);
                    a(-f3, (int) (((this.H * 100) / r0) + (((f3 * 3.0f) * 100.0f) / this.x)));
                }
                if (this.F) {
                    float f5 = -f3;
                    WindowManager.LayoutParams attributes = y.b(getContext()).getAttributes();
                    float f6 = this.I;
                    float f7 = (int) (((f5 * 255.0f) * 3.0f) / this.x);
                    if ((f6 + f7) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f6 + f7) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f6 + f7) / 255.0f;
                    }
                    y.b(getContext()).setAttributes(attributes);
                    a((int) (((this.I * 100.0f) / 255.0f) + (((f5 * 3.0f) * 100.0f) / this.x)));
                }
            }
        }
        return false;
    }

    public void p() {
        String str = "onStatePause  [" + hashCode() + "] ";
        this.f3188a = 5;
        z();
    }

    public void q() {
        String str = "onStatePlaying  [" + hashCode() + "] ";
        if (this.f3188a == 3) {
            long j2 = this.f3199l;
            if (j2 != 0) {
                this.f3194g.a(j2);
                this.f3199l = 0L;
            } else {
                long jB = y.b(getContext(), this.f3190c.c());
                if (jB != 0) {
                    this.f3194g.a(jB);
                }
            }
        }
        this.f3188a = 4;
        z();
    }

    public void r() {
        String str = "onStatePreparing  [" + hashCode() + "] ";
        this.f3188a = 1;
        t();
    }

    public void s() {
        String str = "reset  [" + hashCode() + "] ";
        int i2 = this.f3188a;
        if (i2 == 4 || i2 == 5) {
            y.a(getContext(), this.f3190c.c(), getCurrentPositionWhenPlaying());
        }
        c();
        e();
        f();
        g();
        o();
        this.r.removeAllViews();
        ((AudioManager) getApplicationContext().getSystemService("audio")).abandonAudioFocus(z0);
        y.f(getContext()).getWindow().clearFlags(128);
        w wVar = this.f3194g;
        if (wVar != null) {
            wVar.f();
        }
    }

    public void setBufferProgress(int i2) {
        if (i2 != 0) {
            this.n.setSecondaryProgress(i2);
        }
    }

    public void setMediaInterface(Class cls) {
        s();
        this.f3193f = cls;
    }

    public void setScreen(int i2) {
        if (i2 == 0) {
            v();
        } else if (i2 == 1) {
            u();
        } else {
            if (i2 != 2) {
                return;
            }
            w();
        }
    }

    public void setState(int i2) {
        a(i2, 0, 0);
    }

    public void t() {
        this.n.setProgress(0);
        this.n.setSecondaryProgress(0);
        this.p.setText(y.a(0L));
        this.q.setText(y.a(0L));
    }

    public void u() {
        this.f3189b = 1;
    }

    public void v() {
        this.f3189b = 0;
    }

    public void w() {
        this.f3189b = 2;
    }

    public void x() {
    }

    public void y() {
        this.K = true;
        A();
    }

    public void z() {
        String str = "startProgressTimer:  [" + hashCode() + "] ";
        c();
        this.v = new Timer();
        this.z = new c();
        this.v.schedule(this.z, 0L, 300L);
    }

    public void b() {
        if (System.currentTimeMillis() - w0 > 2000 && this.f3188a == 4 && this.f3189b == 1) {
            w0 = System.currentTimeMillis();
            C();
        }
    }

    public void c() {
        Timer timer = this.v;
        if (timer != null) {
            timer.cancel();
        }
        c cVar = this.z;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    public Jzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3188a = -1;
        this.f3189b = -1;
        this.f3191d = 0;
        this.f3192e = 0;
        this.f3195h = -1;
        this.f3196i = 0;
        this.f3197j = 0L;
        this.f3198k = -1;
        this.f3199l = 0L;
        this.K = false;
        a(context);
    }

    public void a(String str, String str2) {
        a(new v(str, str2), 0);
    }

    public void a(String str, String str2, int i2) {
        a(new v(str, str2), i2);
    }

    public void a(v vVar, int i2) {
        a(vVar, i2, x.class);
    }

    public void a(String str, String str2, int i2, Class cls) {
        a(new v(str, str2), i2, cls);
    }

    public void a(v vVar, int i2, Class cls) {
        if (System.currentTimeMillis() - this.f3197j < 200) {
            return;
        }
        this.f3190c = vVar;
        this.f3189b = i2;
        o();
        this.f3193f = cls;
    }

    public void a(int i2, int i3) {
        String str = "onError " + i2 + " - " + i3 + " [" + hashCode() + "] ";
        if (i2 == 38 || i3 == -38 || i2 == -38 || i3 == 38 || i3 == -19) {
            return;
        }
        n();
        this.f3194g.f();
    }

    public void a(int i2, int i3, int i4) {
        if (i2 == 0) {
            o();
            return;
        }
        if (i2 == 1) {
            r();
            return;
        }
        if (i2 == 2) {
            a(i3, i4);
            return;
        }
        if (i2 == 4) {
            q();
            return;
        }
        if (i2 == 5) {
            p();
        } else if (i2 == 6) {
            m();
        } else {
            if (i2 != 7) {
                return;
            }
            n();
        }
    }

    public void a(String str, String str2, long j2) {
        a(new v(str, str2), j2);
    }

    public void a(int i2, long j2) {
        this.f3188a = 2;
        this.f3199l = j2;
        this.f3190c.f3244a = i2;
        this.f3194g.a((Surface) null);
        this.f3194g.f();
        this.f3194g.e();
    }

    public void a(v vVar, long j2) {
        this.f3188a = 2;
        this.f3199l = j2;
        this.f3190c = vVar;
        this.f3194g.a((Surface) null);
        this.f3194g.f();
        this.f3194g.e();
    }

    public void a() {
        String str = "addTextureView [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.u;
        if (jZTextureView != null) {
            this.r.removeView(jZTextureView);
        }
        this.u = new JZTextureView(getContext().getApplicationContext());
        this.u.setSurfaceTextureListener(this.f3194g);
        this.r.addView(this.u, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void a(int i2, long j2, long j3) {
        if (!this.A) {
            int i3 = this.f3198k;
            if (i3 != -1) {
                if (i3 > i2) {
                    return;
                } else {
                    this.f3198k = -1;
                }
            } else if (i2 != 0) {
                this.n.setProgress(i2);
            }
        }
        if (j2 != 0) {
            this.p.setText(y.a(j2));
        }
        this.q.setText(y.a(j3));
    }

    public void a(ViewGroup viewGroup) {
        try {
            Jzvd jzvd = (Jzvd) getClass().getConstructor(Context.class).newInstance(getContext());
            jzvd.setId(getId());
            viewGroup.addView(jzvd);
            jzvd.a(this.f3190c.a(), 0, this.f3193f);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public void a(float f2) {
        int i2;
        if (M != null) {
            int i3 = this.f3188a;
            if ((i3 != 4 && i3 != 5) || (i2 = this.f3189b) == 1 || i2 == 2) {
                return;
            }
            if (f2 > 0.0f) {
                y.a(getContext(), 0);
            } else {
                y.a(getContext(), 8);
            }
            h();
        }
    }

    public static void a(Context context, Class cls, String str, String str2) {
        a(context, cls, new v(str, str2));
    }

    public static void a(Context context, Class cls, v vVar) {
        y.c(context);
        y.a(context, r0);
        y.d(context);
        ViewGroup viewGroup = (ViewGroup) y.f(context).getWindow().getDecorView();
        try {
            Jzvd jzvd = (Jzvd) cls.getConstructor(Context.class).newInstance(context);
            viewGroup.addView(jzvd, new FrameLayout.LayoutParams(-1, -1));
            jzvd.a(vVar, 1);
            jzvd.A();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        y.a(context, str);
    }
}
