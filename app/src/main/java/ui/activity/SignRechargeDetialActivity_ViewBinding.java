package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class SignRechargeDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignRechargeDetialActivity f18969a;

    /* renamed from: b, reason: collision with root package name */
    private View f18970b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignRechargeDetialActivity f18971a;

        a(SignRechargeDetialActivity signRechargeDetialActivity) {
            this.f18971a = signRechargeDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18971a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity) {
        this(signRechargeDetialActivity, signRechargeDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRechargeDetialActivity signRechargeDetialActivity = this.f18969a;
        if (signRechargeDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18969a = null;
        signRechargeDetialActivity.mTvTitle = null;
        signRechargeDetialActivity.mBtnConfirm = null;
        signRechargeDetialActivity.mEtRechargePlat = null;
        signRechargeDetialActivity.mEtRechargePlatName = null;
        signRechargeDetialActivity.mEtRechargePhone = null;
        signRechargeDetialActivity.mEtRechargeSum = null;
        signRechargeDetialActivity.mEtRechargeTime = null;
        this.f18970b.setOnClickListener(null);
        this.f18970b = null;
    }

    @UiThread
    public SignRechargeDetialActivity_ViewBinding(SignRechargeDetialActivity signRechargeDetialActivity, View view) {
        this.f18969a = signRechargeDetialActivity;
        signRechargeDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRechargeDetialActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signRechargeDetialActivity.mEtRechargePlat = (TextView) Utils.findRequiredViewAsType(view, R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        signRechargeDetialActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        signRechargeDetialActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        signRechargeDetialActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        signRechargeDetialActivity.mEtRechargeTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18970b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signRechargeDetialActivity));
    }
}
