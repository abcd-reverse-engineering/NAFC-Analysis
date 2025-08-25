package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;
import ui.view.VerifyCodeView;

/* loaded from: classes2.dex */
public class VerifyPhoneCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VerifyPhoneCodeActivity f19188a;

    /* renamed from: b, reason: collision with root package name */
    private View f19189b;

    /* renamed from: c, reason: collision with root package name */
    private View f19190c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyPhoneCodeActivity f19191a;

        a(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.f19191a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19191a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyPhoneCodeActivity f19193a;

        b(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
            this.f19193a = verifyPhoneCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19193a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity) {
        this(verifyPhoneCodeActivity, verifyPhoneCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyPhoneCodeActivity verifyPhoneCodeActivity = this.f19188a;
        if (verifyPhoneCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19188a = null;
        verifyPhoneCodeActivity.mTvTitle = null;
        verifyPhoneCodeActivity.tvPhoneTip = null;
        verifyPhoneCodeActivity.mPhoneCode = null;
        verifyPhoneCodeActivity.mTvReset = null;
        verifyPhoneCodeActivity.mPhoneLable = null;
        this.f19189b.setOnClickListener(null);
        this.f19189b = null;
        this.f19190c.setOnClickListener(null);
        this.f19190c = null;
    }

    @UiThread
    public VerifyPhoneCodeActivity_ViewBinding(VerifyPhoneCodeActivity verifyPhoneCodeActivity, View view) {
        this.f19188a = verifyPhoneCodeActivity;
        verifyPhoneCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        verifyPhoneCodeActivity.tvPhoneTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'tvPhoneTip'", TextView.class);
        verifyPhoneCodeActivity.mPhoneCode = (VerifyCodeView) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", VerifyCodeView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_reSend, "field 'mTvReset' and method 'onViewClicked'");
        verifyPhoneCodeActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView, R.id.tv_reSend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f19189b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(verifyPhoneCodeActivity));
        verifyPhoneCodeActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19190c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(verifyPhoneCodeActivity));
    }
}
