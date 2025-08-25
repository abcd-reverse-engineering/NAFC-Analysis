package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.callview.CriminalPhoneView;
import ui.presenter.CriminalPhonePresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: AddCrimePhoneActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020)J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020)H\u0014J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u00064"}, d2 = {"Lui/activity/AddCrimePhoneActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mCallNum", "Landroid/widget/TextView;", "getMCallNum", "()Landroid/widget/TextView;", "setMCallNum", "(Landroid/widget/TextView;)V", "mDelivery", "getMDelivery", "setMDelivery", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "getMPresenter", "()Lui/presenter/CriminalPhonePresenter;", "setMPresenter", "(Lui/presenter/CriminalPhonePresenter;)V", "mRecharge", "getMRecharge", "setMRecharge", "mRelation", "getMRelation", "setMRelation", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccessPhoneNum", "bean", "Lbean/CriminalPhoneNumBean;", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AddCrimePhoneActivity extends BaseActivity implements CriminalPhoneView {

    @i.c.a.d
    private String caseInfoId = "";

    @BindView(R.id.tv_call_num)
    @i.c.a.d
    public TextView mCallNum;

    @BindView(R.id.tv_delivery_num)
    @i.c.a.d
    public TextView mDelivery;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private CriminalPhonePresenter mPresenter;

    @BindView(R.id.tv_recharge_num)
    @i.c.a.d
    public TextView mRecharge;

    @BindView(R.id.tv_relation_num)
    @i.c.a.d
    public TextView mRelation;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @i.c.a.d
    public final TextView getMCallNum() {
        TextView textView = this.mCallNum;
        if (textView == null) {
            h.q2.t.i0.k("mCallNum");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMDelivery() {
        TextView textView = this.mDelivery;
        if (textView == null) {
            h.q2.t.i0.k("mDelivery");
        }
        return textView;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final CriminalPhonePresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final TextView getMRecharge() {
        TextView textView = this.mRecharge;
        if (textView == null) {
            h.q2.t.i0.k("mRecharge");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMRelation() {
        TextView textView = this.mRelation;
        if (textView == null) {
            h.q2.t.i0.k("mRelation");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("添加嫌疑人电话");
        initView();
    }

    public final void initView() {
        Activity activity = this.mActivity;
        h.q2.t.i0.a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
    }

    @OnClick({R.id.iv_back, R.id.rl_type_phone, R.id.rl_type_recharge, R.id.rl_type_relation, R.id.rl_type_delivery, R.id.btn_commit})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        switch (id) {
            case R.id.rl_type_delivery /* 2131297203 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) DeliveryActivity.class);
                intent.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent);
                break;
            case R.id.rl_type_phone /* 2131297204 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) CallActivity.class);
                intent2.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent2);
                break;
            case R.id.rl_type_recharge /* 2131297205 */:
                Intent intent3 = new Intent(this.mActivity, (Class<?>) ReChargeActivity.class);
                intent3.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent3);
                break;
            case R.id.rl_type_relation /* 2131297206 */:
                Intent intent4 = new Intent(this.mActivity, (Class<?>) RelationActivity.class);
                intent4.putExtra(util.k1.C0, this.caseInfoId);
                startActivity(intent4);
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter != null) {
            criminalPhonePresenter.getCriminalCallNum(this.caseInfoId);
        }
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccess(@i.c.a.d List<String> list) {
        h.q2.t.i0.f(list, "CNATelList");
        CriminalPhoneView.a.a(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessList(@i.c.a.d List<? extends CallBean> list) {
        h.q2.t.i0.f(list, "callBeans");
        CriminalPhoneView.a.b(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@i.c.a.d CriminalPhoneNumBean criminalPhoneNumBean) {
        h.q2.t.i0.f(criminalPhoneNumBean, "bean");
        TextView textView = this.mCallNum;
        if (textView == null) {
            h.q2.t.i0.k("mCallNum");
        }
        textView.setText("");
        TextView textView2 = this.mRecharge;
        if (textView2 == null) {
            h.q2.t.i0.k("mRecharge");
        }
        textView2.setText("");
        TextView textView3 = this.mRelation;
        if (textView3 == null) {
            h.q2.t.i0.k("mRelation");
        }
        textView3.setText("");
        TextView textView4 = this.mDelivery;
        if (textView4 == null) {
            h.q2.t.i0.k("mDelivery");
        }
        textView4.setText("");
        if (criminalPhoneNumBean.getCallTelCount() > 0) {
            TextView textView5 = this.mCallNum;
            if (textView5 == null) {
                h.q2.t.i0.k("mCallNum");
            }
            textView5.setText(String.valueOf(criminalPhoneNumBean.getCallTelCount()));
        }
        if (criminalPhoneNumBean.getChargeTelCount() > 0) {
            TextView textView6 = this.mRecharge;
            if (textView6 == null) {
                h.q2.t.i0.k("mRecharge");
            }
            textView6.setText(String.valueOf(criminalPhoneNumBean.getChargeTelCount()));
        }
        if (criminalPhoneNumBean.getLinkTelCount() > 0) {
            TextView textView7 = this.mRelation;
            if (textView7 == null) {
                h.q2.t.i0.k("mRelation");
            }
            textView7.setText(String.valueOf(criminalPhoneNumBean.getLinkTelCount()));
        }
        if (criminalPhoneNumBean.getMailingTelCount() > 0) {
            TextView textView8 = this.mDelivery;
            if (textView8 == null) {
                h.q2.t.i0.k("mDelivery");
            }
            textView8.setText(String.valueOf(criminalPhoneNumBean.getMailingTelCount()));
        }
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.a.a(this);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessSave(@i.c.a.d CallBean callBean) {
        h.q2.t.i0.f(callBean, "callBeans");
        CriminalPhoneView.a.a(this, callBean);
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_add_crime_phone;
    }

    public final void setMCallNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mCallNum = textView;
    }

    public final void setMDelivery(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mDelivery = textView;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e CriminalPhonePresenter criminalPhonePresenter) {
        this.mPresenter = criminalPhonePresenter;
    }

    public final void setMRecharge(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mRecharge = textView;
    }

    public final void setMRelation(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mRelation = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
