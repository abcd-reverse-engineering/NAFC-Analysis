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
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public final class SignRelationDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignRelationDetialActivity f18980a;

    /* renamed from: b, reason: collision with root package name */
    private View f18981b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignRelationDetialActivity f18982a;

        a(SignRelationDetialActivity signRelationDetialActivity) {
            this.f18982a = signRelationDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18982a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRelationDetialActivity_ViewBinding(SignRelationDetialActivity signRelationDetialActivity) {
        this(signRelationDetialActivity, signRelationDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRelationDetialActivity signRelationDetialActivity = this.f18980a;
        if (signRelationDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18980a = null;
        signRelationDetialActivity.mTvTitle = null;
        signRelationDetialActivity.mBtnConfirm = null;
        signRelationDetialActivity.mFlowLayout = null;
        signRelationDetialActivity.mTvAccName = null;
        signRelationDetialActivity.mEtAccount = null;
        signRelationDetialActivity.mLlAccNorm = null;
        signRelationDetialActivity.mTvOtherTips = null;
        signRelationDetialActivity.mEtOtherName = null;
        signRelationDetialActivity.mLlAccOther = null;
        this.f18981b.setOnClickListener(null);
        this.f18981b = null;
    }

    @UiThread
    public SignRelationDetialActivity_ViewBinding(SignRelationDetialActivity signRelationDetialActivity, View view) {
        this.f18980a = signRelationDetialActivity;
        signRelationDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRelationDetialActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, R.id.btn_commit, "field 'mBtnConfirm'", Button.class);
        signRelationDetialActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        signRelationDetialActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        signRelationDetialActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, R.id.et_account, "field 'mEtAccount'", TextView.class);
        signRelationDetialActivity.mLlAccNorm = Utils.findRequiredView(view, R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        signRelationDetialActivity.mTvOtherTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_other_name, "field 'mTvOtherTips'", TextView.class);
        signRelationDetialActivity.mEtOtherName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_other_name, "field 'mEtOtherName'", EditText.class);
        signRelationDetialActivity.mLlAccOther = Utils.findRequiredView(view, R.id.ll_acc_other, "field 'mLlAccOther'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18981b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signRelationDetialActivity));
    }
}
