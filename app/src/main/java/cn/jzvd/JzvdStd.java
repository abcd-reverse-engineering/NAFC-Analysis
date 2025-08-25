package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class JzvdStd extends Jzvd {
    public static long f1 = 0;
    public static int g1 = 70;
    protected static Timer h1;
    public ImageView A0;
    public ProgressBar B0;
    public ProgressBar C0;
    public TextView D0;
    public ImageView E0;
    public ImageView F0;
    public LinearLayout G0;
    public ImageView H0;
    public TextView I0;
    public TextView J0;
    public TextView K0;
    public PopupWindow L0;
    public TextView M0;
    public LinearLayout N0;
    protected b O0;
    protected Dialog P0;
    protected ProgressBar Q0;
    protected TextView R0;
    protected TextView S0;
    protected ImageView T0;
    protected Dialog U0;
    protected ProgressBar V0;
    protected TextView W0;
    protected ImageView X0;
    protected Dialog Y0;
    protected ProgressBar Z0;
    protected TextView a1;
    private long b1;
    private long c1;
    private ArrayDeque<Runnable> d1;
    private BroadcastReceiver e1;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                JzvdStd.g1 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                JzvdStd.this.U();
                try {
                    JzvdStd.this.getContext().unregisterReceiver(JzvdStd.this.e1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JzvdStd.this.P();
        }
    }

    public JzvdStd(Context context) {
        super(context);
        this.b1 = 0L;
        this.c1 = 200L;
        this.d1 = new ArrayDeque<>();
        this.e1 = new a();
    }

    public void G() {
        Timer timer = h1;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.O0;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void H() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 4, 0, 4, 0, 4, 4);
            X();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 0, 4, 4);
            X();
        }
    }

    public void I() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(4, 4, 0, 4, 4, 4, 0);
            X();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 4, 4, 0);
            X();
        }
    }

    public void J() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 4, 0, 4, 0, 4, 4);
            X();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 0, 4, 4);
            X();
        }
    }

    public void K() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void L() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 0, 0, 4, 4, 4, 4);
            X();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 0, 0, 4, 4, 4, 4);
            X();
        }
    }

    public void M() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            a(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void N() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 0, 0, 4, 4, 4, 4);
            X();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 0, 0, 4, 4, 4, 4);
            X();
        }
    }

    public void O() {
        int i2 = this.f3189b;
        if (i2 == 0 || i2 == 1) {
            a(4, 4, 4, 0, 0, 4, 4);
            X();
        }
    }

    public void P() {
        int i2 = this.f3188a;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: cn.jzvd.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f3234a.Q();
            }
        });
    }

    public /* synthetic */ void Q() {
        this.t.setVisibility(4);
        this.s.setVisibility(4);
        this.f3200m.setVisibility(4);
        PopupWindow popupWindow = this.L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.f3189b != 2) {
            this.B0.setVisibility(0);
        }
    }

    public /* synthetic */ void R() {
        if (this.E || this.D) {
            return;
        }
        T();
    }

    public void S() {
        int i2 = this.f3188a;
        if (i2 == 1) {
            if (this.t.getVisibility() == 0) {
                O();
            }
        } else if (i2 == 4) {
            if (this.t.getVisibility() == 0) {
                M();
            }
        } else if (i2 == 5) {
            if (this.t.getVisibility() == 0) {
                K();
            }
        } else if (i2 == 6 && this.t.getVisibility() == 0) {
            H();
        }
    }

    public void T() {
        if (this.t.getVisibility() != 0) {
            V();
            this.K0.setText(this.f3190c.b().toString());
        }
        int i2 = this.f3188a;
        if (i2 == 1) {
            O();
            if (this.t.getVisibility() == 0) {
                return;
            }
            V();
            return;
        }
        if (i2 == 4) {
            if (this.t.getVisibility() == 0) {
                M();
                return;
            } else {
                N();
                return;
            }
        }
        if (i2 == 5) {
            if (this.t.getVisibility() == 0) {
                K();
            } else {
                L();
            }
        }
    }

    public void U() {
        int i2 = g1;
        if (i2 < 15) {
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_10);
            return;
        }
        if (i2 >= 15 && i2 < 40) {
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_30);
            return;
        }
        if (i2 >= 40 && i2 < 60) {
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_50);
            return;
        }
        if (i2 >= 60 && i2 < 80) {
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_70);
            return;
        }
        if (i2 >= 80 && i2 < 95) {
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_90);
        } else {
            if (i2 < 95 || i2 > 100) {
                return;
            }
            this.H0.setBackgroundResource(R.drawable.jz_battery_level_100);
        }
    }

    public void V() {
        this.I0.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - f1 <= 30000) {
            U();
        } else {
            f1 = System.currentTimeMillis();
            getContext().registerReceiver(this.e1, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public void W() {
        G();
        h1 = new Timer();
        this.O0 = new b();
        h1.schedule(this.O0, 2500L);
    }

    public void X() {
        int i2 = this.f3188a;
        if (i2 == 4) {
            this.f3200m.setVisibility(0);
            this.f3200m.setImageResource(R.drawable.jz_click_pause_selector);
            this.J0.setVisibility(8);
        } else if (i2 == 7) {
            this.f3200m.setVisibility(4);
            this.J0.setVisibility(8);
        } else if (i2 != 6) {
            this.f3200m.setImageResource(R.drawable.jz_click_play_selector);
            this.J0.setVisibility(8);
        } else {
            this.f3200m.setVisibility(0);
            this.f3200m.setImageResource(R.drawable.jz_click_replay_selector);
            this.J0.setVisibility(0);
        }
    }

    public void b(int i2) {
        ViewGroup.LayoutParams layoutParams = this.f3200m.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i2;
    }

    @Override // cn.jzvd.Jzvd
    public void e() {
        super.e();
        Dialog dialog = this.Y0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void f() {
        super.f();
        Dialog dialog = this.P0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void g() {
        super.g();
        Dialog dialog = this.U0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    public void j() {
        super.j();
        G();
    }

    @Override // cn.jzvd.Jzvd
    public void m() {
        super.m();
        H();
        G();
        this.B0.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    public void n() {
        super.n();
        I();
    }

    @Override // cn.jzvd.Jzvd
    public void o() {
        super.o();
        J();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.thumb) {
            v vVar = this.f3190c;
            if (vVar == null || vVar.f3245b.isEmpty() || this.f3190c.c() == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            int i2 = this.f3188a;
            if (i2 != 0) {
                if (i2 == 6) {
                    T();
                    return;
                }
                return;
            } else if (this.f3190c.c().toString().startsWith("file") || this.f3190c.c().toString().startsWith("/") || y.e(getContext()) || Jzvd.u0) {
                A();
                return;
            } else {
                x();
                return;
            }
        }
        if (id == R.id.surface_container) {
            W();
            return;
        }
        if (id == R.id.back) {
            Jzvd.C();
            return;
        }
        if (id == R.id.back_tiny) {
            d();
            return;
        }
        if (id != R.id.clarity) {
            if (id == R.id.retry_btn) {
                if (this.f3190c.f3245b.isEmpty() || this.f3190c.c() == null) {
                    Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                    return;
                }
                if (!this.f3190c.c().toString().startsWith("file") && !this.f3190c.c().toString().startsWith("/") && !y.e(getContext()) && !Jzvd.u0) {
                    x();
                    return;
                } else {
                    a();
                    r();
                    return;
                }
            }
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.jz_layout_clarity, (ViewGroup) null);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.jzvd.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f3230a.a(linearLayout, view2);
            }
        };
        for (int i3 = 0; i3 < this.f3190c.f3245b.size(); i3++) {
            String strA = this.f3190c.a(i3);
            TextView textView = (TextView) View.inflate(getContext(), R.layout.jz_layout_clarity_item, null);
            textView.setText(strA);
            textView.setTag(Integer.valueOf(i3));
            linearLayout.addView(textView, i3);
            textView.setOnClickListener(onClickListener);
            if (i3 == this.f3190c.f3244a) {
                textView.setTextColor(Color.parseColor("#fff85959"));
            }
        }
        this.L0 = new PopupWindow((View) linearLayout, -2, -2, true);
        this.L0.setContentView(linearLayout);
        this.L0.showAsDropDown(this.K0);
        linearLayout.measure(0, 0);
        this.L0.update(this.K0, -(this.K0.getMeasuredWidth() / 3), -(this.K0.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        G();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        W();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action != 0 && action == 1) {
                W();
                if (this.E) {
                    long duration = getDuration();
                    long j2 = this.J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.B0.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: cn.jzvd.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3229a.R();
                    }
                };
                view.postDelayed(runnable, this.c1 + 20);
                this.d1.add(runnable);
                while (this.d1.size() > 2) {
                    this.d1.pollFirst();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.b1 < this.c1) {
                    Iterator<Runnable> it = this.d1.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.f3188a;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.f3200m.performClick();
                    }
                }
                this.b1 = jCurrentTimeMillis;
            }
        } else if (id == R.id.bottom_seek_progress) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                G();
            } else if (action2 == 1) {
                W();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // cn.jzvd.Jzvd
    public void p() {
        super.p();
        L();
        G();
    }

    @Override // cn.jzvd.Jzvd
    public void q() {
        super.q();
        M();
    }

    @Override // cn.jzvd.Jzvd
    public void r() {
        super.r();
        O();
    }

    @Override // cn.jzvd.Jzvd
    public void s() {
        super.s();
        G();
        PopupWindow popupWindow = this.L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i2) {
        super.setBufferProgress(i2);
        if (i2 != 0) {
            this.B0.setSecondaryProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void t() {
        super.t();
        this.B0.setProgress(0);
        this.B0.setSecondaryProgress(0);
    }

    @Override // cn.jzvd.Jzvd
    public void u() {
        super.u();
        this.o.setImageResource(R.drawable.jz_shrink);
        this.A0.setVisibility(0);
        this.F0.setVisibility(4);
        this.G0.setVisibility(0);
        if (this.f3190c.f3245b.size() == 1) {
            this.K0.setVisibility(8);
        } else {
            this.K0.setText(this.f3190c.b().toString());
            this.K0.setVisibility(0);
        }
        b((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        V();
    }

    @Override // cn.jzvd.Jzvd
    public void v() {
        super.v();
        this.o.setImageResource(R.drawable.jz_enlarge);
        this.A0.setVisibility(8);
        this.F0.setVisibility(4);
        b((int) getResources().getDimension(R.dimen.jz_start_button_w_h_normal));
        this.G0.setVisibility(8);
        this.K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void w() {
        super.w();
        this.F0.setVisibility(0);
        a(4, 4, 4, 4, 4, 4, 4);
        this.G0.setVisibility(8);
        this.K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void x() {
        super.x();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: cn.jzvd.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f3232a.a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: cn.jzvd.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f3233a.b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.jzvd.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // cn.jzvd.Jzvd
    public void a(Context context) {
        super.a(context);
        this.G0 = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.B0 = (ProgressBar) findViewById(R.id.bottom_progress);
        this.D0 = (TextView) findViewById(R.id.title);
        this.A0 = (ImageView) findViewById(R.id.back);
        this.E0 = (ImageView) findViewById(R.id.thumb);
        this.C0 = (ProgressBar) findViewById(R.id.loading);
        this.F0 = (ImageView) findViewById(R.id.back_tiny);
        this.H0 = (ImageView) findViewById(R.id.battery_level);
        this.I0 = (TextView) findViewById(R.id.video_current_time);
        this.J0 = (TextView) findViewById(R.id.replay_text);
        this.K0 = (TextView) findViewById(R.id.clarity);
        this.M0 = (TextView) findViewById(R.id.retry_btn);
        this.N0 = (LinearLayout) findViewById(R.id.retry_layout);
        this.E0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.K0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
    }

    public JzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b1 = 0L;
        this.c1 = 200L;
        this.d1 = new ArrayDeque<>();
        this.e1 = new a();
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        d();
    }

    @Override // cn.jzvd.Jzvd
    public void a(v vVar, int i2, Class cls) {
        super.a(vVar, i2, cls);
        this.D0.setText(vVar.f3246c);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    public void a(int i2, long j2) {
        super.a(i2, j2);
        this.f3200m.setVisibility(4);
        this.J0.setVisibility(8);
        this.N0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void a(v vVar, long j2) {
        super.a(vVar, j2);
        this.D0.setText(vVar.f3246c);
        this.f3200m.setVisibility(4);
        this.J0.setVisibility(8);
        this.N0.setVisibility(8);
    }

    public /* synthetic */ void a(LinearLayout linearLayout, View view) {
        a(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.K0.setText(this.f3190c.b().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.f3190c.f3244a) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.L0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        A();
        Jzvd.u0 = true;
    }

    @Override // cn.jzvd.Jzvd
    public void a(int i2, long j2, long j3) {
        super.a(i2, j2, j3);
        if (i2 != 0) {
            this.B0.setProgress(i2);
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.s.setVisibility(i2);
        this.t.setVisibility(i3);
        this.f3200m.setVisibility(i4);
        this.C0.setVisibility(i5);
        this.E0.setVisibility(i6);
        this.B0.setVisibility(i7);
        this.N0.setVisibility(i8);
    }

    @Override // cn.jzvd.Jzvd
    public void a(float f2, String str, long j2, String str2, long j3) {
        super.a(f2, str, j2, str2, j3);
        if (this.P0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.Q0 = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.R0 = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.S0 = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.T0 = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.P0 = a(viewInflate);
        }
        if (!this.P0.isShowing()) {
            this.P0.show();
        }
        this.R0.setText(str);
        this.S0.setText(" / " + str2);
        this.Q0.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.T0.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.T0.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        S();
    }

    @Override // cn.jzvd.Jzvd
    public void a(float f2, int i2) {
        super.a(f2, i2);
        if (this.U0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.X0 = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.W0 = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.V0 = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.U0 = a(viewInflate);
        }
        if (!this.U0.isShowing()) {
            this.U0.show();
        }
        if (i2 <= 0) {
            this.X0.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.X0.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.W0.setText(i2 + "%");
        this.V0.setProgress(i2);
        S();
    }

    @Override // cn.jzvd.Jzvd
    public void a(int i2) {
        super.a(i2);
        if (this.Y0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.a1 = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.Z0 = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.Y0 = a(viewInflate);
        }
        if (!this.Y0.isShowing()) {
            this.Y0.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.a1.setText(i2 + "%");
        this.Z0.setProgress(i2);
        S();
    }

    public Dialog a(View view) {
        Dialog dialog = new Dialog(getContext(), R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }
}
