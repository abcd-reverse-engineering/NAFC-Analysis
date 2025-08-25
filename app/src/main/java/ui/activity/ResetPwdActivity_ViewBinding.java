package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class ResetPwdActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ResetPwdActivity f18857a;

    /* renamed from: b, reason: collision with root package name */
    private View f18858b;

    /* renamed from: c, reason: collision with root package name */
    private View f18859c;

    /* renamed from: d, reason: collision with root package name */
    private View f18860d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPwdActivity f18861a;

        a(ResetPwdActivity resetPwdActivity) {
            this.f18861a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18861a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPwdActivity f18863a;

        b(ResetPwdActivity resetPwdActivity) {
            this.f18863a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18863a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPwdActivity f18865a;

        c(ResetPwdActivity resetPwdActivity) {
            this.f18865a = resetPwdActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18865a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity) {
        this(resetPwdActivity, resetPwdActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPwdActivity resetPwdActivity = this.f18857a;
        if (resetPwdActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18857a = null;
        resetPwdActivity.mTvTitle = null;
        resetPwdActivity.mPhoneCode = null;
        resetPwdActivity.mConfim = null;
        resetPwdActivity.mPhoneLable = null;
        resetPwdActivity.mIvClean = null;
        this.f18858b.setOnClickListener(null);
        this.f18858b = null;
        this.f18859c.setOnClickListener(null);
        this.f18859c = null;
        this.f18860d.setOnClickListener(null);
        this.f18860d = null;
    }

    @UiThread
    public ResetPwdActivity_ViewBinding(ResetPwdActivity resetPwdActivity, View view) {
        this.f18857a = resetPwdActivity;
        resetPwdActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPwdActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPwdActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f18858b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(resetPwdActivity));
        resetPwdActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPwdActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18859c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(resetPwdActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18860d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(resetPwdActivity));
    }
}
