package ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import ui.Hicore;

/* compiled from: ConfirmCancelDialog.java */
/* loaded from: classes2.dex */
public class n extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Activity f20595a;

    /* renamed from: b, reason: collision with root package name */
    private Context f20596b;

    /* renamed from: c, reason: collision with root package name */
    private Button f20597c;

    /* renamed from: d, reason: collision with root package name */
    private Button f20598d;

    /* renamed from: e, reason: collision with root package name */
    private String f20599e;

    /* renamed from: f, reason: collision with root package name */
    private String f20600f;

    /* renamed from: g, reason: collision with root package name */
    private a f20601g;

    /* renamed from: h, reason: collision with root package name */
    private String f20602h;

    /* renamed from: i, reason: collision with root package name */
    private String f20603i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f20604j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f20605k;

    /* renamed from: l, reason: collision with root package name */
    private int f20606l;

    /* renamed from: m, reason: collision with root package name */
    private int f20607m;

    /* compiled from: ConfirmCancelDialog.java */
    public interface a {
        void a();

        void b();
    }

    public n(Activity activity, String str, String str2, String str3, String str4) {
        super(activity, R.style.myStyle);
        this.f20605k = false;
        this.f20606l = -1;
        this.f20607m = -1;
        this.f20595a = activity;
        this.f20599e = str;
        this.f20600f = str2;
        this.f20602h = str3;
        this.f20603i = str4;
    }

    public a a() {
        return this.f20601g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        dismiss();
        int id = view.getId();
        if (id != R.id.cancel_btn) {
            if (id == R.id.confirm_btn && (aVar = this.f20601g) != null) {
                aVar.b();
                return;
            }
            return;
        }
        a aVar2 = this.f20601g;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.custom_dialog);
        setCanceledOnTouchOutside(false);
        ((TextView) findViewById(R.id.customdialog_title)).setText(this.f20599e);
        TextView textView = (TextView) findViewById(R.id.customdialog_subtitle);
        if (this.f20605k) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f20604j);
        } else {
            textView.setText(this.f20600f);
        }
        this.f20597c = (Button) findViewById(R.id.confirm_btn);
        this.f20598d = (Button) findViewById(R.id.cancel_btn);
        if (!TextUtils.isEmpty(this.f20602h)) {
            this.f20597c.setText(this.f20602h);
        }
        if (!TextUtils.isEmpty(this.f20603i)) {
            this.f20598d.setText(this.f20603i);
        }
        if (this.f20606l == -1) {
            this.f20597c.setTextColor(-14072090);
        } else {
            this.f20597c.setTextColor(Hicore.getApp().getResources().getColor(this.f20606l));
        }
        if (this.f20607m == -1) {
            this.f20598d.setTextColor(-14072090);
        } else {
            this.f20598d.setTextColor(Hicore.getApp().getResources().getColor(this.f20607m));
        }
        this.f20597c.setOnClickListener(this);
        this.f20598d.setOnClickListener(this);
    }

    public void a(a aVar) {
        this.f20601g = aVar;
    }

    public n(Activity activity, String str, CharSequence charSequence, boolean z, int i2, int i3, String str2, String str3) {
        super(activity, R.style.myStyle);
        this.f20605k = false;
        this.f20606l = -1;
        this.f20607m = -1;
        this.f20595a = activity;
        this.f20599e = str;
        this.f20604j = charSequence;
        this.f20602h = str2;
        this.f20603i = str3;
        this.f20605k = z;
        this.f20606l = i2;
        this.f20607m = i3;
    }

    public n(Context context, String str, String str2, String str3, String str4) {
        super(context, R.style.myStyle);
        this.f20605k = false;
        this.f20606l = -1;
        this.f20607m = -1;
        this.f20596b = context;
        this.f20599e = str;
        this.f20600f = str2;
        this.f20602h = str3;
        this.f20603i = str4;
    }
}
