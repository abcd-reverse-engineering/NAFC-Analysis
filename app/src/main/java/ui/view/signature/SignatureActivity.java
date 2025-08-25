package ui.view.signature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class SignatureActivity extends Activity {

    /* renamed from: e, reason: collision with root package name */
    public static final int f20654e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f20655f = 2;

    /* renamed from: a, reason: collision with root package name */
    private GestureSignatureView f20656a;

    /* renamed from: b, reason: collision with root package name */
    private String f20657b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f20658c;

    /* renamed from: d, reason: collision with root package name */
    private int f20659d;

    public /* synthetic */ void a(View view) {
        this.f20656a.a();
    }

    public /* synthetic */ void b(View view) {
        try {
            if (!this.f20656a.getTouched()) {
                w1.a("您还未签名");
            } else {
                this.f20656a.a(this.f20657b);
                finish();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.full_height_dlg);
        setContentView(R.layout.dlg_signature);
        getWindow().setLayout(-1, -1);
        this.f20656a = (GestureSignatureView) findViewById(R.id.gsv_signature);
        this.f20658c = (TextView) findViewById(R.id.tv_sign);
        this.f20657b = getIntent().getStringExtra(k1.f20846d);
        this.f20659d = getIntent().getIntExtra(k1.f20847e, 0);
        if (this.f20659d == 2) {
            this.f20658c.setText("民警签名");
        }
        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20670a.a(view);
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() { // from class: ui.view.signature.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20669a.b(view);
            }
        });
    }
}
