package ui.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.hicorenational.antifraud.R;
import util.n1;

/* compiled from: CallIntercepterDialog.java */
/* loaded from: classes2.dex */
public class b extends ui.d.d {
    private static final int n = 1;
    private static final int o = 2;

    /* renamed from: j, reason: collision with root package name */
    private int f19501j;

    /* renamed from: k, reason: collision with root package name */
    private int f19502k;

    /* renamed from: l, reason: collision with root package name */
    public c f19503l;

    /* renamed from: m, reason: collision with root package name */
    public d f19504m;

    /* compiled from: CallIntercepterDialog.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f19503l != null) {
                if (bVar.f19502k != 1) {
                    b.this.f19503l.a();
                    return;
                }
                b.this.f19503l.b();
                b.this.f19502k = 2;
                b.this.f19511e.setText("停止录音");
            }
        }
    }

    /* compiled from: CallIntercepterDialog.java */
    /* renamed from: ui.d.b$b, reason: collision with other inner class name */
    class ViewOnClickListenerC0288b implements View.OnClickListener {
        ViewOnClickListenerC0288b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = b.this.f19504m;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    /* compiled from: CallIntercepterDialog.java */
    public interface c {
        void a();

        void b();
    }

    /* compiled from: CallIntercepterDialog.java */
    public interface d {
        void a();
    }

    public b(Context context) {
        super(context, R.style.SmsIntercepteDilog);
        this.f19501j = 1;
        this.f19502k = 1;
    }

    public void b() {
        this.f19510d.setVisibility(0);
        this.f19511e.setVisibility(0);
        this.f19509c.setVisibility(8);
        this.f19510d.setText("举报电话");
        this.f19511e.setText("开始录音");
        this.f19511e.setOnClickListener(new a());
        this.f19510d.setOnClickListener(new ViewOnClickListenerC0288b());
    }

    @Override // ui.d.d, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n1.c(a.a.u.a.n, "onCreate               mDialogType  " + this.f19501j);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        int i2 = this.f19501j;
        if (i2 == 1) {
            window.setFlags(40, 1024);
            a();
        } else {
            if (i2 != 2) {
                return;
            }
            b();
            setCanceledOnTouchOutside(false);
        }
    }

    public void setOnRecordClickListener(c cVar) {
        this.f19503l = cVar;
    }

    public void setOnReportPhoneListener(d dVar) {
        this.f19504m = dVar;
    }

    public void a(int i2) {
        this.f19501j = i2;
    }

    public void a() {
        this.f19511e.setVisibility(8);
        this.f19510d.setVisibility(8);
        this.f19509c.setVisibility(8);
    }
}
