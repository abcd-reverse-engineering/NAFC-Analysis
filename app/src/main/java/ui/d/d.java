package ui.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* compiled from: SmsIntercepteDialog.java */
/* loaded from: classes2.dex */
public class d extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public TextView f19507a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f19508b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f19509c;

    /* renamed from: d, reason: collision with root package name */
    public Button f19510d;

    /* renamed from: e, reason: collision with root package name */
    public Button f19511e;

    /* renamed from: f, reason: collision with root package name */
    private String f19512f;

    /* renamed from: g, reason: collision with root package name */
    private String f19513g;

    /* renamed from: h, reason: collision with root package name */
    private Context f19514h;

    /* renamed from: i, reason: collision with root package name */
    private a f19515i;

    /* compiled from: SmsIntercepteDialog.java */
    public interface a {
        void a();

        void b();
    }

    public d(Context context, int i2) {
        super(context, R.style.SmsIntercepteDilog);
        this.f19514h = context;
    }

    private void a() {
        this.f19507a = (TextView) findViewById(R.id.txt_dialog_sms_address);
        this.f19508b = (TextView) findViewById(R.id.txt_dialog_sms_content);
        this.f19510d = (Button) findViewById(R.id.btn_dialog_sms_close);
        this.f19509c = (TextView) findViewById(R.id.txt_dialog_sms_warn);
        this.f19510d.setOnClickListener(this);
        this.f19511e = (Button) findViewById(R.id.btn_dialog_sms_report);
        this.f19511e.setOnClickListener(this);
    }

    public void b(String str) {
        this.f19507a.setText(str);
    }

    public void c(String str) {
        this.f19511e.setText(str);
    }

    public void d(String str) {
        this.f19509c.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog_sms_close /* 2131296397 */:
                a aVar = this.f19515i;
                if (aVar != null) {
                    aVar.a();
                }
                dismiss();
                break;
            case R.id.btn_dialog_sms_report /* 2131296398 */:
                a aVar2 = this.f19515i;
                if (aVar2 != null) {
                    aVar2.b();
                }
                dismiss();
                break;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_intercepte);
        a();
    }

    public void setOnBtnClickListener(a aVar) {
        this.f19515i = aVar;
    }

    public void a(String str) {
        this.f19508b.setText(str);
    }

    public void a(String str, String str2) {
        this.f19510d.setText(str);
        this.f19511e.setText(str2);
    }
}
