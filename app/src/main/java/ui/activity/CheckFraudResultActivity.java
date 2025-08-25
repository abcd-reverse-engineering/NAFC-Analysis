package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CheckFraudBean;
import bean.ShareConfigBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import network.http.StatisticsShareHttp;
import ui.callview.CheckFraudResultCallView;
import ui.f.c;
import ui.presenter.CheckFraudResultPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class CheckFraudResultActivity extends BaseActivity implements CheckFraudResultCallView {

    @BindView(R.id.tv_check_result)
    TextView mCheckResult;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_picture)
    ImageView mIvPicture;

    @BindView(R.id.iv_right)
    ImageView mIvRight;
    CheckFraudResultPresenter mPresent;
    private ui.f.c mShareDialog;

    @BindView(R.id.tv_appeal)
    TextView mTvAppeal;

    @BindView(R.id.tv_cotent)
    TextView mTvCotent;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_type)
    TextView mTvType;

    @BindView(R.id.warn_txt)
    TextView mWarnTxt;
    private ShareConfigBean shareBean = null;
    public CheckFraudBean mCheckFraudBean = null;
    private int model = 0;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CheckFraudResultActivity checkFraudResultActivity = CheckFraudResultActivity.this;
            checkFraudResultActivity.mPresent.reportFraudIpUrlHttp(checkFraudResultActivity.mCheckFraudBean);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showResultData() {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.CheckFraudResultActivity.showResultData():void");
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mIvRight.setBackgroundResource(R.drawable.iv_share_dot);
        this.mPresent = new CheckFraudResultPresenter(this, this);
        this.model = getIntent().getIntExtra(util.k1.o0, 0);
        this.mCheckFraudBean = (CheckFraudBean) getIntent().getSerializableExtra(util.k1.m0);
        this.shareBean = (ShareConfigBean) getIntent().getSerializableExtra(util.k1.n0);
        int i2 = this.model;
        if (i2 == 1) {
            this.mTvTitle.setText("IP网址查询");
        } else if (i2 == 2) {
            this.mTvTitle.setText("QQ/微信查询");
        } else {
            this.mTvTitle.setText("支付风险查询");
        }
        showResultData();
    }

    @Override // ui.callview.CheckFraudResultCallView
    public void onSuccessRequest() {
        util.w1.a("错误信息上报成功");
        this.mTvAppeal.setTextColor(Color.parseColor("#999999"));
        this.mTvAppeal.setEnabled(false);
    }

    @OnClick({R.id.iv_back, R.id.tv_report, R.id.tv_appeal, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.iv_right /* 2131296826 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl) && this.shareBean.downloadUrl.contains("{0}")) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", d.a.m() + "");
                }
                this.mShareDialog = new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.activity.n
                    @Override // ui.f.c.b
                    public final void a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case R.id.tv_appeal /* 2131297426 */:
                util.b1.a(this.mActivity, "确定上报查询错误信息吗？", "", "取消", "确定", -1, -1, true, (IClickListener) new a());
                break;
            case R.id.tv_report /* 2131297687 */:
                Intent intent = new Intent();
                int i2 = this.model;
                if (i2 == 1) {
                    intent.setClass(this, UrlFraudActivity.class);
                } else if (i2 == 2) {
                    intent.setClass(this, ChatFraudActivity.class);
                } else {
                    intent.setClass(this, TradFraudActivity.class);
                }
                intent.putExtra(util.k1.m0, this.mCheckFraudBean);
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_check_fraud_result;
    }
}
