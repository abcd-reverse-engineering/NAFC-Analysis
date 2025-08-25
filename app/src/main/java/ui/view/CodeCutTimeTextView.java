package ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CodeCutTimeTextView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public static final int f20302d = 60;

    /* renamed from: e, reason: collision with root package name */
    public static final int f20303e = 180;

    /* renamed from: f, reason: collision with root package name */
    public static int f20304f = 60;

    /* renamed from: a, reason: collision with root package name */
    private TextView f20305a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f20306b;

    /* renamed from: c, reason: collision with root package name */
    private p f20307c;

    class a extends p {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Activity f20308g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, Activity activity) {
            super(j2, j3);
            this.f20308g = activity;
        }

        @Override // ui.view.p
        public void a(long j2) {
            if (this.f20308g.isFinishing() || CodeCutTimeTextView.this.f20305a == null) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            CodeCutTimeTextView.this.f20305a.setText("重新获取(" + i2 + ")");
            CodeCutTimeTextView.this.f20305a.setTextColor(Color.parseColor("#666666"));
        }

        @Override // ui.view.p
        public void d() {
            if (this.f20308g.isFinishing() || CodeCutTimeTextView.this.f20305a == null) {
                return;
            }
            CodeCutTimeTextView.this.f20305a.setText("重新获取");
            CodeCutTimeTextView.this.f20305a.setTextColor(Color.parseColor("#2B4CFF"));
            CodeCutTimeTextView.this.f20306b = false;
            CodeCutTimeTextView.this.setEnabled(true);
        }
    }

    public CodeCutTimeTextView(Context context) {
        this(context, null);
    }

    public void b() {
        p pVar = this.f20307c;
        if (pVar != null) {
            pVar.a();
            a(false);
        }
    }

    public void c() {
        p pVar = this.f20307c;
        if (pVar != null) {
            pVar.a();
            a(true);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public CodeCutTimeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CodeCutTimeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20305a = (TextView) LayoutInflater.from(context).inflate(R.layout.code_cut_time, (ViewGroup) this, true).findViewById(R.id.tv_versf);
        a(false);
    }

    public void a(boolean z) {
        this.f20305a.setText("获取验证码");
        this.f20306b = false;
        if (z) {
            this.f20305a.setTextColor(Color.parseColor("#2B4CFF"));
            setEnabled(true);
        } else {
            this.f20305a.setTextColor(Color.parseColor("#666666"));
            setEnabled(false);
        }
    }

    public boolean a() {
        return this.f20306b;
    }

    public void a(Activity activity, int i2) {
        if (i2 <= 0) {
            f20304f = 180;
        } else {
            f20304f = i2;
        }
        a(activity);
    }

    private void a(Activity activity) {
        this.f20306b = true;
        setEnabled(false);
        p pVar = this.f20307c;
        if (pVar == null) {
            this.f20307c = new a(f20304f * 1000, 1000L, activity);
        } else {
            pVar.a(f20304f * 1000, 1000L);
        }
    }
}
