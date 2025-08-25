package ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import cn.jzvd.Jzvd;
import cn.jzvd.y;
import com.hicorenational.antifraud.R;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class RecordItemJzvd extends Jzvd {
    protected static Timer b1;
    public ImageView A0;
    public ProgressBar B0;
    public ProgressBar C0;
    public TextView D0;
    public ImageView E0;
    public ImageView F0;
    public TextView G0;
    public TextView H0;
    public PopupWindow I0;
    public TextView J0;
    public LinearLayout K0;
    protected a L0;
    protected Dialog M0;
    protected ProgressBar N0;
    protected TextView O0;
    protected TextView P0;
    protected ImageView Q0;
    protected Dialog R0;
    protected ProgressBar S0;
    protected TextView T0;
    protected ImageView U0;
    protected Dialog V0;
    protected ProgressBar W0;
    protected TextView X0;
    private long Y0;
    private long Z0;
    private ArrayDeque<Runnable> a1;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RecordItemJzvd.this.P();
        }
    }

    public RecordItemJzvd(Context context) {
        this(context, null);
    }

    public void G() {
        Timer timer = b1;
        if (timer != null) {
            timer.cancel();
        }
        a aVar = this.L0;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void H() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 4, 0, 4, 0, 4, 4);
            V();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 0, 4, 4);
            V();
        }
    }

    public void I() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(4, 4, 0, 4, 4, 4, 0);
            V();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 4, 4, 0);
            V();
        }
    }

    public void J() {
        int i2 = this.f3189b;
        if (i2 == 0) {
            a(0, 4, 0, 4, 0, 4, 4);
            V();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 4, 0, 4, 0, 4, 4);
            V();
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
            V();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 0, 0, 4, 4, 4, 4);
            V();
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
            a(0, 0, 0, 4, 4, 0, 4);
            V();
        } else {
            if (i2 != 1) {
                return;
            }
            a(0, 0, 0, 4, 4, 4, 4);
            V();
        }
    }

    public void O() {
        int i2 = this.f3189b;
        if (i2 == 0 || i2 == 1) {
            a(4, 4, 4, 0, 0, 4, 4);
            V();
        }
    }

    public void P() {
        int i2 = this.f3188a;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: ui.view.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f20547a.Q();
            }
        });
    }

    public /* synthetic */ void Q() {
        this.t.setVisibility(4);
        this.s.setVisibility(4);
        this.f3200m.setVisibility(4);
        PopupWindow popupWindow = this.I0;
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
        int i2 = this.f3188a;
        if (i2 == 1) {
            O();
            this.t.getVisibility();
        } else if (i2 == 4) {
            N();
        } else if (i2 == 5) {
            if (this.t.getVisibility() == 0) {
                K();
            } else {
                L();
            }
        }
    }

    public void U() {
        G();
        b1 = new Timer();
        this.L0 = new a();
        b1.schedule(this.L0, 2500L);
    }

    public void V() {
        int i2 = this.f3188a;
        if (i2 == 4) {
            this.f3200m.setVisibility(0);
            this.f3200m.setImageResource(R.drawable.jz_click_pause_selector);
            this.G0.setVisibility(8);
        } else if (i2 == 7) {
            this.f3200m.setVisibility(4);
            this.G0.setVisibility(8);
        } else if (i2 != 6) {
            this.f3200m.setImageResource(R.drawable.jz_click_play_selector);
            this.G0.setVisibility(8);
        } else {
            this.f3200m.setVisibility(0);
            this.f3200m.setImageResource(R.drawable.jz_click_replay_selector);
            this.G0.setVisibility(0);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void a(Context context) {
        super.a(context);
        this.B0 = (ProgressBar) findViewById(R.id.bottom_progress);
        this.D0 = (TextView) findViewById(R.id.title);
        this.A0 = (ImageView) findViewById(R.id.back);
        this.E0 = (ImageView) findViewById(R.id.thumb);
        this.C0 = (ProgressBar) findViewById(R.id.loading);
        this.F0 = (ImageView) findViewById(R.id.back_tiny);
        this.G0 = (TextView) findViewById(R.id.replay_text);
        this.H0 = (TextView) findViewById(R.id.clarity);
        this.J0 = (TextView) findViewById(R.id.retry_btn);
        this.K0 = (LinearLayout) findViewById(R.id.retry_layout);
        this.E0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
        this.J0.setOnClickListener(this);
        this.G0.setOnClickListener(this);
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        d();
    }

    @Override // cn.jzvd.Jzvd
    public void e() {
        super.e();
        Dialog dialog = this.V0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void f() {
        super.f();
        Dialog dialog = this.M0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void g() {
        super.g();
        Dialog dialog = this.R0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.record_layout_item;
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
            cn.jzvd.v vVar = this.f3190c;
            if (vVar == null || vVar.f3245b.isEmpty() || this.f3190c.c() == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            int i2 = this.f3188a;
            if (i2 != 0) {
                if (i2 == 6) {
                    T();
                    A();
                    return;
                }
                return;
            }
            if (this.f3190c.c().toString().startsWith("file") || this.f3190c.c().toString().startsWith("/") || y.e(getContext()) || Jzvd.u0) {
                A();
                return;
            } else {
                x();
                return;
            }
        }
        if (id == R.id.surface_container) {
            U();
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
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ui.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f20548a.a(linearLayout, view2);
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
        this.I0 = new PopupWindow((View) linearLayout, -2, -2, true);
        this.I0.setContentView(linearLayout);
        this.I0.showAsDropDown(this.H0);
        linearLayout.measure(0, 0);
        this.I0.update(this.H0, -(this.H0.getMeasuredWidth() / 3), -(this.H0.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        G();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        U();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action != 0 && action == 1) {
                U();
                if (this.E) {
                    long duration = getDuration();
                    long j2 = this.J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.B0.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: ui.view.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20545a.R();
                    }
                };
                view.postDelayed(runnable, this.Z0 + 20);
                this.a1.add(runnable);
                while (this.a1.size() > 2) {
                    this.a1.pollFirst();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.Y0 < this.Z0) {
                    Iterator<Runnable> it = this.a1.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.f3188a;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.f3200m.performClick();
                    }
                }
                this.Y0 = jCurrentTimeMillis;
            }
        } else if (id == R.id.bottom_seek_progress) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                G();
            } else if (action2 == 1) {
                U();
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
        PopupWindow popupWindow = this.I0;
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
        if (this.f3190c.f3245b.size() == 1) {
            this.H0.setVisibility(8);
        } else {
            this.H0.setText(this.f3190c.b().toString());
            this.H0.setVisibility(0);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void v() {
        super.v();
        this.o.setImageResource(R.drawable.jz_enlarge);
        this.A0.setVisibility(8);
        this.F0.setVisibility(4);
        this.H0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void w() {
        super.w();
        this.F0.setVisibility(0);
        a(4, 4, 4, 4, 4, 4, 4);
        this.H0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void x() {
        super.x();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: ui.view.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f20550a.a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: ui.view.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f20546a.b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ui.view.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public RecordItemJzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Y0 = 0L;
        this.Z0 = 200L;
        this.a1 = new ArrayDeque<>();
    }

    @Override // cn.jzvd.Jzvd
    public void a(cn.jzvd.v vVar, int i2, Class cls) {
        super.a(vVar, i2, cls);
        this.D0.setText(vVar.f3246c);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    public void a(int i2, long j2) {
        super.a(i2, j2);
        this.f3200m.setVisibility(4);
        this.G0.setVisibility(8);
        this.K0.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void a(cn.jzvd.v vVar, long j2) {
        super.a(vVar, j2);
        this.D0.setText(vVar.f3246c);
        this.f3200m.setVisibility(4);
        this.G0.setVisibility(8);
        this.K0.setVisibility(8);
    }

    public /* synthetic */ void a(LinearLayout linearLayout, View view) {
        a(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.H0.setText(this.f3190c.b().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.f3190c.f3244a) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.I0;
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
        this.K0.setVisibility(i8);
    }

    @Override // cn.jzvd.Jzvd
    public void a(float f2, String str, long j2, String str2, long j3) {
        super.a(f2, str, j2, str2, j3);
        if (this.M0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.N0 = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.O0 = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.P0 = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.Q0 = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.M0 = a(viewInflate);
        }
        if (!this.M0.isShowing()) {
            this.M0.show();
        }
        this.O0.setText(str);
        this.P0.setText(" / " + str2);
        this.N0.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.Q0.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.Q0.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        S();
    }

    @Override // cn.jzvd.Jzvd
    public void a(float f2, int i2) {
        super.a(f2, i2);
        if (this.R0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.U0 = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.T0 = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.S0 = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.R0 = a(viewInflate);
        }
        if (!this.R0.isShowing()) {
            this.R0.show();
        }
        if (i2 <= 0) {
            this.U0.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.U0.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.T0.setText(i2 + "%");
        this.S0.setProgress(i2);
        S();
    }

    @Override // cn.jzvd.Jzvd
    public void a(int i2) {
        super.a(i2);
        if (this.V0 == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.X0 = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.W0 = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.V0 = a(viewInflate);
        }
        if (!this.V0.isShowing()) {
            this.V0.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.X0.setText(i2 + "%");
        this.W0.setProgress(i2);
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
