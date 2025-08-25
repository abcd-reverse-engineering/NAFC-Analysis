package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import bean.WebArticleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import interfaces.IVerifyListener;
import interfaces.OnWebListener;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import network.gson.ObjectTypeAdapter;
import network.http.ReportNumHttp;
import network.http.StatisticsShareHttp;
import ui.callview.PromosWebView;
import ui.f.c;
import ui.presenter.PromosWebPresenter;
import ui.view.MyWebView;
import ui.view.swip.SwipBackLayout;
import util.z1;

/* loaded from: classes2.dex */
public class PromosWebDetActivity extends BaseActivity implements PromosWebView {
    private boolean isVideo;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.iv_right2)
    ImageView mIvRight2;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(R.id.ll_to_report)
    LinearLayout mLlToReport;
    private PromosWebPresenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.rl_title)
    View mRlTitle;

    @BindView(R.id.fl_tit_white)
    View mRlTitleWhite;

    @BindView(R.id.tv_help)
    TextView mTvHelp;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.webview)
    MyWebView mWebview;
    private ShareConfigBean shareBean;
    SwipBackLayout swipBackLayout;
    private String mArticleId = "";
    private String mSource = "";
    private String mShareBaseUrl = "";
    Handler mHandler = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Activity activity = PromosWebDetActivity.this.mActivity;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 6) {
                PromosWebDetActivity.this.mRlTitle.setVisibility(8);
                PromosWebDetActivity.this.mLlToReport.setVisibility(8);
                if (!PromosWebDetActivity.this.isVideo) {
                    ui.statusbarcompat.b.a(PromosWebDetActivity.this.mActivity, true, false);
                    return;
                }
                PromosWebDetActivity.this.mRlTitleWhite.setVisibility(8);
                PromosWebDetActivity.this.mTvHelp.setVisibility(0);
                ui.statusbarcompat.b.a(PromosWebDetActivity.this.mActivity, true, false);
                return;
            }
            if (i2 != 7) {
                return;
            }
            PromosWebDetActivity.this.mLlToReport.setVisibility(0);
            if (!PromosWebDetActivity.this.isVideo) {
                PromosWebDetActivity.this.mRlTitle.setVisibility(0);
                ui.statusbarcompat.b.a(PromosWebDetActivity.this.mActivity, true, true);
            } else {
                PromosWebDetActivity.this.mRlTitle.setVisibility(8);
                PromosWebDetActivity.this.mRlTitleWhite.setVisibility(0);
                PromosWebDetActivity.this.mTvHelp.setVisibility(0);
                ui.statusbarcompat.b.a(PromosWebDetActivity.this.mActivity, true, false);
            }
        }
    }

    class b implements OnWebListener {
        b() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.d2.a aVar) {
            PromosWebDetActivity.this.sendWebMsg(aVar);
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) throws NumberFormatException {
            SurveyH5Bean surveyH5Bean;
            String str2;
            if (TextUtils.isEmpty(str) || (surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().a(str, SurveyH5Bean.class)) == null || surveyH5Bean.getParams() == null) {
                return;
            }
            try {
                Map<String, Object> params = surveyH5Bean.getParams();
                int i2 = Integer.parseInt(params.get("action").toString());
                if (i2 != 17) {
                    if (i2 == 16) {
                        MyWebView.cleanCache();
                        return;
                    }
                    return;
                }
                String string = params.get(SurveyH5Bean.VALUE).toString();
                PromosWebDetActivity promosWebDetActivity = PromosWebDetActivity.this;
                if (TextUtils.equals(string, "0")) {
                    str2 = d.a.f13522h + d.a.a(8);
                } else {
                    str2 = d.a.f13517c;
                }
                promosWebDetActivity.mShareBaseUrl = str2;
                PromosWebDetActivity.this.mPresenter.requestAticleInfo(PromosWebDetActivity.this.mShareBaseUrl, PromosWebDetActivity.this.mArticleId);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class c extends WebChromeClient {
        c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            ProgressBar progressBar = PromosWebDetActivity.this.mProgressBar;
            if (progressBar == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                PromosWebDetActivity.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    private void deleteChildWebview() {
        try {
            this.mWebview.clearHistory();
            this.mWebview.removeAllViews();
            this.mWebview.destroy();
            this.mWebview = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWebMsg(util.d2.a aVar) {
        if (aVar.c()) {
            return;
        }
        try {
            String strB = aVar.b("id");
            String strB2 = aVar.b("url");
            String string = this.mTvTitle.getText().toString();
            if (!TextUtils.isEmpty(strB2)) {
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(util.k1.P, string);
                intent.putExtra(util.k1.Q, strB2);
                intent.putExtra(util.k1.T, strB);
                intent.putExtra(util.k1.U, 3);
                startActivity(intent);
            }
            String strB3 = aVar.b("isOnlyFullScreen");
            String strB4 = aVar.b("isfullScreen");
            if (TextUtils.equals("yes", strB4)) {
                this.mHandler.sendEmptyMessage(6);
                return;
            }
            if (TextUtils.equals("no", strB4)) {
                this.mHandler.sendEmptyMessage(7);
            } else if (TextUtils.equals("yes", strB3)) {
                this.mHandler.sendEmptyMessage(6);
            } else if (TextUtils.equals("no", strB3)) {
                this.mHandler.sendEmptyMessage(7);
            }
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void a() {
        StatisticsShareHttp.getInstance().shareArticleHttp(this.mArticleId);
    }

    public /* synthetic */ void b() {
        ReportNumHttp.getInstance().principalHttp(new w1(this));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.swipBackLayout = SwipBackLayout.a(this.mActivity);
        this.swipBackLayout.a();
        this.mWebview.setSwipLayout(this.mActivity, this.swipBackLayout);
        this.mIvRight.setBackgroundResource(R.drawable.iv_share_dot);
        this.mArticleId = getIntent().getStringExtra(util.k1.T);
        String stringExtra = getIntent().getStringExtra(util.k1.Q);
        String stringExtra2 = getIntent().getStringExtra(util.k1.P);
        this.mSource = getIntent().getStringExtra(util.k1.S);
        int intExtra = getIntent().getIntExtra(util.k1.U, 0);
        this.mPresenter = new PromosWebPresenter(this, this);
        this.mTvTitle.setText(stringExtra2);
        this.shareBean = new ShareConfigBean();
        initWebView(this.mWebview);
        this.mWebview.loadUrl(stringExtra + "#app=1");
        util.n1.a("PromosWeb--------url+-->>" + stringExtra);
        if (stringExtra.contains("shareVideo")) {
            this.isVideo = true;
            this.mRlTitle.setVisibility(8);
            this.mRlTitleWhite.setVisibility(0);
            this.mTvHelp.setVisibility(0);
            ui.statusbarcompat.b.a((Activity) this, true, false);
        } else {
            this.mRlTitle.setVisibility(0);
            this.mRlTitleWhite.setVisibility(8);
            ui.statusbarcompat.b.a((Activity) this, true, true);
        }
        if (intExtra == 3) {
            this.mIvRight.setVisibility(8);
            this.mLlToReport.setVisibility(8);
        }
    }

    protected void initWebView(MyWebView myWebView) {
        myWebView.setListener(this.mActivity, new b());
        myWebView.setWebChromeClient(new c());
        myWebView.setWebViewClient(new d());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MyWebView myWebView = this.mWebview;
        if (myWebView != null && myWebView.canGoBack()) {
            this.mWebview.goBack();
        } else {
            super.onBackPressed();
            deleteChildWebview();
        }
    }

    @Override // ui.callview.PromosWebView
    public void onSuccRequest(APIresult<WebArticleBean> aPIresult) {
        WebArticleBean data = aPIresult.getData();
        if (data != null) {
            this.shareBean.downloadUrl = data.getContent();
            this.shareBean.title = data.getTitle();
            this.shareBean.iconUrl = data.getIcon();
            this.shareBean.description = data.getDescription();
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_back2, R.id.ll_to_report, R.id.iv_right, R.id.iv_right2, R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
            case R.id.iv_back2 /* 2131296763 */:
                onBackPressed();
                break;
            case R.id.iv_right /* 2131296826 */:
            case R.id.iv_right2 /* 2131296827 */:
                new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.activity.s0
                    @Override // ui.f.c.b
                    public final void a() {
                        this.f19467a.a();
                    }
                }).show();
                break;
            case R.id.ll_network_no /* 2131296957 */:
                this.mWebview.reload();
                this.mWebview.setVisibility(0);
                this.mLlNetworkNo.setVisibility(8);
                break;
            case R.id.ll_to_report /* 2131296994 */:
                if (!AccountManager.isLogin()) {
                    LoginManager.getInstance().exitToLogin();
                    break;
                } else {
                    z1.a(this.mActivity).a(1011, new IVerifyListener() { // from class: ui.activity.r0
                        @Override // interfaces.IVerifyListener
                        public final void onSuccessVerify() {
                            this.f19462a.b();
                        }
                    });
                    break;
                }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_prom_web_det;
    }

    class d extends WebViewClient {
        d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            View view = PromosWebDetActivity.this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            MyWebView myWebView = PromosWebDetActivity.this.mWebview;
            if (myWebView != null) {
                myWebView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            webResourceRequest.getUrl().toString();
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AtomicReference atomicReference = new AtomicReference();
            if (Build.VERSION.SDK_INT >= 21) {
                atomicReference.set(webResourceRequest.getUrl().getPath());
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
