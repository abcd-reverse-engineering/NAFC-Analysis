package ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class VerifyCodeView extends RelativeLayout {

    /* renamed from: e, reason: collision with root package name */
    private static int f20456e = 4;

    /* renamed from: a, reason: collision with root package name */
    private EditText f20457a;

    /* renamed from: b, reason: collision with root package name */
    private TextView[] f20458b;

    /* renamed from: c, reason: collision with root package name */
    private String f20459c;

    /* renamed from: d, reason: collision with root package name */
    private b f20460d;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            VerifyCodeView verifyCodeView = VerifyCodeView.this;
            verifyCodeView.f20459c = verifyCodeView.f20457a.getText().toString();
            if (VerifyCodeView.this.f20460d != null) {
                if (VerifyCodeView.this.f20459c.length() >= VerifyCodeView.f20456e) {
                    VerifyCodeView.this.f20460d.a();
                } else {
                    VerifyCodeView.this.f20460d.a(VerifyCodeView.this.f20459c.length());
                }
            }
            for (int i2 = 0; i2 < VerifyCodeView.f20456e; i2++) {
                if (i2 < VerifyCodeView.this.f20459c.length()) {
                    VerifyCodeView.this.f20458b[i2].setText(String.valueOf(VerifyCodeView.this.f20459c.charAt(i2)));
                } else {
                    VerifyCodeView.this.f20458b[i2].setText("");
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public interface b {
        void a();

        void a(int i2);
    }

    public VerifyCodeView(Context context) {
        this(context, null);
    }

    public String getEditContent() {
        return this.f20459c;
    }

    public EditText getEditText() {
        return this.f20457a;
    }

    public void setInputCompleteListener(b bVar) {
        this.f20460d = bVar;
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        this.f20457a.addTextChangedListener(new a());
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20459c = "";
        View.inflate(context, R.layout.view_verify_code, this);
        this.f20458b = new TextView[f20456e];
        this.f20458b[0] = (TextView) findViewById(R.id.tv_0);
        this.f20458b[1] = (TextView) findViewById(R.id.tv_1);
        this.f20458b[2] = (TextView) findViewById(R.id.tv_2);
        this.f20458b[3] = (TextView) findViewById(R.id.tv_3);
        this.f20457a = (EditText) findViewById(R.id.edit_text_view);
        this.f20457a.setCursorVisible(false);
        b();
    }
}
