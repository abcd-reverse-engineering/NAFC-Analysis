package ui.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Arrays;
import manager.AccountManager;
import manager.LoginManager;
import network.account.AccountInfo;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* compiled from: LogoutSuccActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0013R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001a"}, d2 = {"Lui/activity/LogoutSuccActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mTvAccTips", "Landroid/widget/TextView;", "getMTvAccTips", "()Landroid/widget/TextView;", "setMTvAccTips", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "Landroid/view/View;", "setLayoutView", "", "unBindOuthLogin", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class LogoutSuccActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.tv_acc_tips)
    @i.c.a.d
    public TextView mTvAccTips;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.d
    public final TextView a() {
        TextView textView = this.mTvAccTips;
        if (textView == null) {
            h.q2.t.i0.k("mTvAccTips");
        }
        return textView;
    }

    public final void b() {
        if (AccountManager.getAccountInfo() != null) {
            AccountInfo accountInfo = AccountManager.getAccountInfo();
            h.q2.t.i0.a((Object) accountInfo, "AccountManager.getAccountInfo()");
            int loginType = accountInfo.getLoginType();
            if (loginType > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (loginType == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (loginType == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (loginType == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(this.mActivity).deleteOauth(this.mActivity, share_media, null);
            }
        }
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
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() throws Resources.NotFoundException {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("注销账号");
        TextView textView2 = this.mTvAccTips;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvAccTips");
        }
        h.q2.t.m1 m1Var = h.q2.t.m1.f16412a;
        String string = getResources().getString(R.string.succ_logout_tips);
        h.q2.t.i0.a((Object) string, "resources.getString(R.string.succ_logout_tips)");
        Object[] objArr = {y1.l(AccountManager.getAccountPhone())};
        String str = String.format(string, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) str, "java.lang.String.format(format, *args)");
        textView2.setText(str);
    }

    @OnClick({R.id.iv_back, R.id.btn_confirm})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_confirm) {
            b();
            LoginManager.getInstance().exitoLoginNoPhone();
        } else {
            if (id != R.id.iv_back) {
                return;
            }
            b();
            LoginManager.getInstance().exitoLoginNoPhone();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_logout_succ;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAccTips = textView;
    }
}
