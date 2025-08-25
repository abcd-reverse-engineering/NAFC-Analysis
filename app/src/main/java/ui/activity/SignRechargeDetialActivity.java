package ui.activity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.Hicore;
import ui.callview.RechargeView;
import ui.presenter.RechargePresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignRechargeDetialActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0007J\u0006\u0010+\u001a\u00020'J\b\u0010,\u001a\u00020-H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lui/activity/SignRechargeDetialActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mEtRechargePhone", "Landroid/widget/EditText;", "getMEtRechargePhone", "()Landroid/widget/EditText;", "setMEtRechargePhone", "(Landroid/widget/EditText;)V", "mEtRechargePlat", "Landroid/widget/TextView;", "getMEtRechargePlat", "()Landroid/widget/TextView;", "setMEtRechargePlat", "(Landroid/widget/TextView;)V", "mEtRechargePlatName", "getMEtRechargePlatName", "setMEtRechargePlatName", "mEtRechargeSum", "getMEtRechargeSum", "setMEtRechargeSum", "mEtRechargeTime", "getMEtRechargeTime", "setMEtRechargeTime", "mPresenter", "Lui/presenter/RechargePresenter;", "mTvTitle", "getMTvTitle", "setMTvTitle", "rechargeBean", "Lbean/RechargeBean;", "initPage", "", "onViewClicked", "view", "Landroid/view/View;", "redisplayData", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignRechargeDetialActivity extends BaseActivity implements RechargeView {

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.et_recharge_phone)
    @i.c.a.d
    public EditText mEtRechargePhone;

    @BindView(R.id.et_recharge_plat)
    @i.c.a.d
    public TextView mEtRechargePlat;

    @BindView(R.id.et_recharge_name)
    @i.c.a.d
    public EditText mEtRechargePlatName;

    @BindView(R.id.et_recharge_sum)
    @i.c.a.d
    public EditText mEtRechargeSum;

    @BindView(R.id.tv_recharge_time)
    @i.c.a.d
    public TextView mEtRechargeTime;
    private RechargePresenter mPresenter;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private RechargeBean rechargeBean;

    @i.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @i.c.a.d
    public final EditText getMEtRechargePhone() {
        EditText editText = this.mEtRechargePhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargePhone");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMEtRechargePlat() {
        TextView textView = this.mEtRechargePlat;
        if (textView == null) {
            h.q2.t.i0.k("mEtRechargePlat");
        }
        return textView;
    }

    @i.c.a.d
    public final EditText getMEtRechargePlatName() {
        EditText editText = this.mEtRechargePlatName;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargePlatName");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtRechargeSum() {
        EditText editText = this.mEtRechargeSum;
        if (editText == null) {
            h.q2.t.i0.k("mEtRechargeSum");
        }
        return editText;
    }

    @i.c.a.d
    public final TextView getMEtRechargeTime() {
        TextView textView = this.mEtRechargeTime;
        if (textView == null) {
            h.q2.t.i0.k("mEtRechargeTime");
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
        this.mPresenter = new RechargePresenter(this, this);
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("充值类嫌疑人电话详情");
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        if (button == null) {
            h.q2.t.i0.f();
        }
        button.setVisibility(8);
        redisplayData();
    }

    @Override // ui.callview.RechargeView
    public void onItemDelet(int i2) {
        RechargeView.a.a(this, i2);
    }

    @Override // ui.callview.RechargeView
    public void onItemEdit(int i2) {
        RechargeView.a.b(this, i2);
    }

    @Override // ui.callview.RechargeView
    public void onSuccessList(@i.c.a.d List<? extends RechargeBean> list) {
        h.q2.t.i0.f(list, "list");
        RechargeView.a.a(this, list);
    }

    @Override // ui.callview.RechargeView
    public void onSuccessPlatList(@i.c.a.d List<? extends RechargePlatBean> list) {
        h.q2.t.i0.f(list, "list");
        RechargeView.a.b(this, list);
    }

    @Override // ui.callview.RechargeView
    public void onSuccessSave() {
        RechargeView.a.a(this);
    }

    @OnClick({R.id.iv_back})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    public final void redisplayData() {
        this.rechargeBean = (RechargeBean) getIntent().getSerializableExtra(util.k1.f20845c);
        if (this.rechargeBean != null) {
            TextView textView = this.mEtRechargePlat;
            if (textView == null) {
                h.q2.t.i0.k("mEtRechargePlat");
            }
            if (textView == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean = this.rechargeBean;
            if (rechargeBean == null) {
                h.q2.t.i0.f();
            }
            textView.setText(rechargeBean.getPlatformText());
            EditText editText = this.mEtRechargePhone;
            if (editText == null) {
                h.q2.t.i0.k("mEtRechargePhone");
            }
            if (editText == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean2 = this.rechargeBean;
            if (rechargeBean2 == null) {
                h.q2.t.i0.f();
            }
            editText.setText(rechargeBean2.getSuspectMobile());
            EditText editText2 = this.mEtRechargeSum;
            if (editText2 == null) {
                h.q2.t.i0.k("mEtRechargeSum");
            }
            if (editText2 == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean3 = this.rechargeBean;
            if (rechargeBean3 == null) {
                h.q2.t.i0.f();
            }
            editText2.setText(rechargeBean3.getAmount());
            TextView textView2 = this.mEtRechargeTime;
            if (textView2 == null) {
                h.q2.t.i0.k("mEtRechargeTime");
            }
            if (textView2 == null) {
                h.q2.t.i0.f();
            }
            RechargeBean rechargeBean4 = this.rechargeBean;
            if (rechargeBean4 == null) {
                h.q2.t.i0.f();
            }
            textView2.setText(rechargeBean4.getChargeTime());
            TextView textView3 = this.mEtRechargePlat;
            if (textView3 == null) {
                h.q2.t.i0.k("mEtRechargePlat");
            }
            if (textView3 == null) {
                h.q2.t.i0.f();
            }
            textView3.setEnabled(false);
            EditText editText3 = this.mEtRechargePlatName;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtRechargePlatName");
            }
            if (editText3 == null) {
                h.q2.t.i0.f();
            }
            editText3.setEnabled(false);
            EditText editText4 = this.mEtRechargePhone;
            if (editText4 == null) {
                h.q2.t.i0.k("mEtRechargePhone");
            }
            if (editText4 == null) {
                h.q2.t.i0.f();
            }
            editText4.setEnabled(false);
            EditText editText5 = this.mEtRechargeSum;
            if (editText5 == null) {
                h.q2.t.i0.k("mEtRechargeSum");
            }
            if (editText5 == null) {
                h.q2.t.i0.f();
            }
            editText5.setEnabled(false);
            TextView textView4 = this.mEtRechargeTime;
            if (textView4 == null) {
                h.q2.t.i0.k("mEtRechargeTime");
            }
            if (textView4 == null) {
                h.q2.t.i0.f();
            }
            textView4.setEnabled(false);
            TextView textView5 = this.mEtRechargePlat;
            if (textView5 == null) {
                h.q2.t.i0.k("mEtRechargePlat");
            }
            if (textView5 == null) {
                h.q2.t.i0.f();
            }
            textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView6 = this.mEtRechargeTime;
            if (textView6 == null) {
                h.q2.t.i0.k("mEtRechargeTime");
            }
            if (textView6 == null) {
                h.q2.t.i0.f();
            }
            textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_recharge_add;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMEtRechargePhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargePhone = editText;
    }

    public final void setMEtRechargePlat(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtRechargePlat = textView;
    }

    public final void setMEtRechargePlatName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargePlatName = editText;
    }

    public final void setMEtRechargeSum(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtRechargeSum = editText;
    }

    public final void setMEtRechargeTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtRechargeTime = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
