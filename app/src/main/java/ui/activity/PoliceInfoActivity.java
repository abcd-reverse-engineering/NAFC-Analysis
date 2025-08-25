package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import bean.PolicStistBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import network.http.StatisticsHttp;
import ui.callview.PolicInfoView;
import ui.presenter.PolicInfoPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* compiled from: PoliceInfoActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0016J\u0006\u0010-\u001a\u00020,J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0007J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0006\u0010:\u001a\u00020,J\b\u0010;\u001a\u000204H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR\u001e\u0010(\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e¨\u0006<"}, d2 = {"Lui/activity/PoliceInfoActivity;", "Lui/activity/BaseActivity;", "Lui/callview/PolicInfoView;", "()V", "mBean", "Lbean/PolicBean;", "getMBean", "()Lbean/PolicBean;", "setMBean", "(Lbean/PolicBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mIvRight", "getMIvRight", "setMIvRight", "mPresenter", "Lui/presenter/PolicInfoPresenter;", "getMPresenter", "()Lui/presenter/PolicInfoPresenter;", "setMPresenter", "(Lui/presenter/PolicInfoPresenter;)V", "mTvDownApp", "Landroid/widget/TextView;", "getMTvDownApp", "()Landroid/widget/TextView;", "setMTvDownApp", "(Landroid/widget/TextView;)V", "mTvInviteNum", "getMTvInviteNum", "setMTvInviteNum", "mTvPhoneNum", "getMTvPhoneNum", "setMTvPhoneNum", "mTvRegistNum", "getMTvRegistNum", "setMTvRegistNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSuccessRequest", "bean", "Lbean/PolicStistBean;", "onkeyback", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class PoliceInfoActivity extends BaseActivity implements PolicInfoView {

    @i.c.a.e
    private PolicBean mBean;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_right)
    @i.c.a.d
    public ImageView mIvRight;

    @i.c.a.e
    private PolicInfoPresenter mPresenter;

    @BindView(R.id.tv_doapp_num)
    @i.c.a.d
    public TextView mTvDownApp;

    @BindView(R.id.tv_invite_num)
    @i.c.a.d
    public TextView mTvInviteNum;

    @BindView(R.id.tv_phone_num)
    @i.c.a.d
    public TextView mTvPhoneNum;

    @BindView(R.id.tv_regist_num)
    @i.c.a.d
    public TextView mTvRegistNum;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    /* compiled from: PoliceInfoActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            PolicInfoPresenter mPresenter = PoliceInfoActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.policUserLogout();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @i.c.a.e
    public final PolicBean getMBean() {
        return this.mBean;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final ImageView getMIvRight() {
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            h.q2.t.i0.k("mIvRight");
        }
        return imageView;
    }

    @i.c.a.e
    public final PolicInfoPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final TextView getMTvDownApp() {
        TextView textView = this.mTvDownApp;
        if (textView == null) {
            h.q2.t.i0.k("mTvDownApp");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvInviteNum() {
        TextView textView = this.mTvInviteNum;
        if (textView == null) {
            h.q2.t.i0.k("mTvInviteNum");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvPhoneNum() {
        TextView textView = this.mTvPhoneNum;
        if (textView == null) {
            h.q2.t.i0.k("mTvPhoneNum");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvRegistNum() {
        TextView textView = this.mTvRegistNum;
        if (textView == null) {
            h.q2.t.i0.k("mTvRegistNum");
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
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13591i);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        initView();
    }

    public final void initView() {
        ImageView imageView = this.mIvRight;
        if (imageView == null) {
            h.q2.t.i0.k("mIvRight");
        }
        imageView.setBackgroundResource(R.drawable.iv_polic_exit);
        this.mPresenter = new PolicInfoPresenter(this.mActivity, this);
        this.mBean = d.b.a();
        TextView textView = this.mTvPhoneNum;
        if (textView == null) {
            h.q2.t.i0.k("mTvPhoneNum");
        }
        PolicBean policBean = this.mBean;
        textView.setText(y1.l(String.valueOf(policBean != null ? policBean.getTelNumber() : null)));
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.tv_case_manger, R.id.tv_manual, R.id.tv_invite_qrcode})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case R.id.iv_right /* 2131296826 */:
                util.b1.b(this.mActivity, "退出当前账号", "", "确定", "取消", new a());
                break;
            case R.id.tv_case_manger /* 2131297455 */:
                startActivity(new Intent(this, (Class<?>) CaseActivity.class));
                break;
            case R.id.tv_invite_qrcode /* 2131297578 */:
                startActivity(new Intent(this, (Class<?>) InviteQrcodeActivity.class));
                break;
            case R.id.tv_manual /* 2131297589 */:
                startActivity(ManualActivity.class);
                break;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @i.c.a.d KeyEvent keyEvent) {
        h.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.PolicInfoView
    public void onSuccessRequest(@i.c.a.e PolicStistBean policStistBean) {
        TextView textView = this.mTvInviteNum;
        if (textView == null) {
            h.q2.t.i0.k("mTvInviteNum");
        }
        textView.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getQrCodeScanCount()) : null));
        TextView textView2 = this.mTvDownApp;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvDownApp");
        }
        textView2.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getDownloadCount()) : null));
        TextView textView3 = this.mTvRegistNum;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvRegistNum");
        }
        textView3.setText(String.valueOf(policStistBean != null ? Integer.valueOf(policStistBean.getRegisteCount()) : null));
    }

    public final void onkeyback() {
        onBackPressed();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_polic_info;
    }

    public final void setMBean(@i.c.a.e PolicBean policBean) {
        this.mBean = policBean;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvRight(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvRight = imageView;
    }

    public final void setMPresenter(@i.c.a.e PolicInfoPresenter policInfoPresenter) {
        this.mPresenter = policInfoPresenter;
    }

    public final void setMTvDownApp(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDownApp = textView;
    }

    public final void setMTvInviteNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvInviteNum = textView;
    }

    public final void setMTvPhoneNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPhoneNum = textView;
    }

    public final void setMTvRegistNum(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvRegistNum = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
