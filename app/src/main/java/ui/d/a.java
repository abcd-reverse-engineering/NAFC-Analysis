package ui.d;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* compiled from: AppIntercepterDialog.java */
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public ImageView f19496a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f19497b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f19498c;

    /* renamed from: d, reason: collision with root package name */
    private Context f19499d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0287a f19500e;

    /* compiled from: AppIntercepterDialog.java */
    /* renamed from: ui.d.a$a, reason: collision with other inner class name */
    public interface InterfaceC0287a {
        void a();

        void a(TextView textView);
    }

    public a(Context context) {
        super(context, R.style.SmsIntercepteDilog);
        this.f19499d = context;
    }

    private void a() {
        this.f19496a = (ImageView) findViewById(R.id.iv_close);
        this.f19497b = (TextView) findViewById(R.id.tv_content);
        this.f19498c = (TextView) findViewById(R.id.tv_confirm);
        this.f19496a.setOnClickListener(this);
        this.f19498c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0287a interfaceC0287a;
        int id = view.getId();
        if (id != R.id.iv_close) {
            if (id == R.id.tv_confirm && (interfaceC0287a = this.f19500e) != null) {
                interfaceC0287a.a(this.f19498c);
                return;
            }
            return;
        }
        InterfaceC0287a interfaceC0287a2 = this.f19500e;
        if (interfaceC0287a2 != null) {
            interfaceC0287a2.a();
        }
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_intercepte_app);
        a();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 26) {
            window.setType(2038);
        } else {
            window.setType(2003);
        }
        setCanceledOnTouchOutside(false);
    }

    public void setOnBtnClickListener(InterfaceC0287a interfaceC0287a) {
        this.f19500e = interfaceC0287a;
    }

    public void a(String str) {
        this.f19497b.setText(str);
    }
}
