package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bean.APIH5Bean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IHandler;
import interfaces.OnWebListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import network.gson.ObjectTypeAdapter;
import network.http.RegionConfigHttp;
import network.http.StatisticsShareHttp;
import ui.callview.WebShareView;
import ui.f.c;
import ui.presenter.WebPresenter;
import ui.view.MyWebView;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class WebActivity extends BaseActivity implements WebShareView, IHandler.HandleWebActListener {
    private String articId;
    private int caragyCode;

    @BindView(R.id.fl_mask)
    View mFlmask;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;
    private String mOrginUrl;
    private String mPersonalize;
    private WebPresenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.ll_progress)
    View mProgressLoad;

    @BindView(R.id.rl_title)
    View mRlTitle;

    @BindView(R.id.iv_back)
    ImageView mTIvBack;

    @BindView(R.id.iv_right)
    ImageView mTIvShare;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.webview)
    MyWebView mWebview;
    private ShareConfigBean shareBean;
    private boolean shareFullScreen;
    private SwipBackLayout swipBackLayout;
    private int toPage;
    private String mTitle = "";
    private String mShareBaseUrl = "";

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            WebActivity webActivity = WebActivity.this;
            webActivity.mWebview.loadUrl(webActivity.mOrginUrl);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class b implements OnWebListener {
        b() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.d2.a aVar) throws UnsupportedEncodingException {
            WebActivity.this.sendWebMsg(aVar);
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
                WebActivity webActivity = WebActivity.this;
                if (TextUtils.equals(string, "0")) {
                    str2 = d.a.f13522h + d.a.a(8);
                } else {
                    str2 = d.a.f13517c;
                }
                webActivity.mShareBaseUrl = str2;
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
            WebActivity webActivity = WebActivity.this;
            ProgressBar progressBar = webActivity.mProgressBar;
            if (progressBar == null || webActivity.mProgressLoad == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
                WebActivity.this.mProgressLoad.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                WebActivity.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            WebActivity webActivity;
            TextView textView;
            super.onReceivedTitle(webView, str);
            if (!TextUtils.isEmpty(WebActivity.this.mTitle) || TextUtils.isEmpty(str) || (textView = (webActivity = WebActivity.this).mTvTitle) == null) {
                return;
            }
            textView.setText(webActivity.mTitle);
        }
    }

    private void initView() {
        this.shareFullScreen = false;
        this.mRlTitle.setBackgroundResource(R.drawable.status_bar_bg);
        this.mTvTitle.setText(this.mTitle);
        this.swipBackLayout.setInterEvent(false);
        this.mTIvBack.setVisibility(0);
        this.mTIvShare.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWebMsg(util.d2.a aVar) throws UnsupportedEncodingException {
        if (aVar.c()) {
            return;
        }
        try {
            String strB = aVar.b("id");
            if (!TextUtils.isEmpty(strB)) {
                this.articId = strB;
            }
            String strA = util.d2.b.a(aVar.b("url"));
            if (!TextUtils.isEmpty(strA)) {
                String strDecode = URLDecoder.decode(aVar.b("title"), "UTF-8");
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(util.k1.P, strDecode);
                intent.putExtra(util.k1.Q, strA);
                intent.putExtra(util.k1.T, this.articId);
                startActivity(intent);
            }
            String strB2 = aVar.b("isfullScreen");
            String strB3 = aVar.b("stylecolor");
            String strB4 = aVar.b("toPage");
            if (TextUtils.equals("yes", strB2)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(2);
            } else if (TextUtils.equals("no", strB2)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(3);
            } else if (TextUtils.equals("black", strB3)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(4);
            } else if (TextUtils.equals("white", strB3)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(5);
            } else if (TextUtils.equals("1", strB4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(8);
            } else if (TextUtils.equals("2", strB4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(9);
            } else if (TextUtils.equals("3", strB4)) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(10);
            }
            if (TextUtils.equals(aVar.b("appBack"), "1")) {
                IHandler.HandleListener.mHandler.sendEmptyMessage(11);
            }
        } catch (Exception unused) {
        }
    }

    private void testPage(int i2) {
        this.toPage = i2;
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.mRlTitle.setBackgroundResource(R.drawable.transparent);
        this.mTvTitle.setText(this.mTitle + "人群防诈骗指数测试");
        this.swipBackLayout.setInterEvent(true);
        this.mFlmask.setVisibility(8);
        this.mTIvBack.setImageResource(R.mipmap.iv_white_back);
        this.mTvTitle.setTextColor(Color.parseColor("#ffffff"));
        this.mTIvShare.setBackgroundResource(R.drawable.iv_share_white);
    }

    private void turnPage() {
        Intent intent = new Intent();
        if (!RegionConfigHttp.existNodeRegion()) {
            intent.setClass(this, AddressActivity.class);
        } else if (AccountManager.isLogin()) {
            intent.setClass(this, MainActivity.class);
        } else {
            intent.setClass(this, LoginActivity.class);
        }
        startActivity(intent);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    public /* synthetic */ void a() {
        StatisticsShareHttp.getInstance().shareArticleHttp(this.articId);
    }

    @Override // interfaces.IHandler.HandleListener
    public void handleMsg(Message message) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        initView();
        switch (message.what) {
            case 2:
                ui.statusbarcompat.b.a((Activity) this, true, false);
                this.mRlTitle.setVisibility(0);
                this.mFlmask.setVisibility(8);
                this.mRlTitle.setBackgroundResource(R.drawable.transparent);
                this.swipBackLayout.setInterEvent(true);
                this.mTvTitle.setText("");
                this.mTIvBack.setVisibility(8);
                this.mTIvShare.setBackgroundResource(R.drawable.iv_share_white);
                this.shareFullScreen = true;
                break;
            case 3:
                ui.statusbarcompat.b.a((Activity) this, true, true);
                this.mRlTitle.setVisibility(0);
                this.mFlmask.setVisibility(0);
                this.swipBackLayout.setInterEvent(false);
                break;
            case 4:
                ui.statusbarcompat.b.a((Activity) this, true, true);
                this.mRlTitle.setVisibility(8);
                this.mFlmask.setVisibility(8);
                this.swipBackLayout.setInterEvent(true);
                break;
            case 5:
                ui.statusbarcompat.b.a((Activity) this, true, false);
                this.mRlTitle.setVisibility(8);
                this.mFlmask.setVisibility(8);
                this.swipBackLayout.setInterEvent(true);
                break;
            case 8:
                this.toPage = 1;
                ui.statusbarcompat.b.a((Activity) this, true, true);
                this.mRlTitle.setBackgroundResource(R.drawable.status_bar_bg);
                this.mTvTitle.setText(this.mTitle);
                this.swipBackLayout.setInterEvent(false);
                this.mFlmask.setVisibility(0);
                this.mTIvBack.setImageResource(R.drawable.back_bla_arrow);
                this.mTvTitle.setTextColor(Color.parseColor("#1D1A33"));
                this.mTIvShare.setBackgroundResource(0);
                break;
            case 9:
                testPage(2);
                break;
            case 10:
                testPage(3);
                break;
            case 11:
                onBackPressed();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.swipBackLayout = SwipBackLayout.a(this.mActivity);
        this.swipBackLayout.a();
        IHandler.setHandleMsgListener(this);
        this.mTitle = getIntent().getStringExtra(util.k1.P);
        this.mOrginUrl = getIntent().getStringExtra(util.k1.Q);
        this.caragyCode = getIntent().getIntExtra(util.k1.V, -9);
        this.mPersonalize = getIntent().getStringExtra(util.k1.Z);
        this.mTvTitle.setText(this.mTitle);
        initWebView(this.mWebview);
        this.mWebview.loadUrl(this.mOrginUrl);
        this.mProgressLoad.setVisibility(0);
        this.mPresenter = new WebPresenter(this.mActivity, this);
        if (TextUtils.equals(this.mPersonalize, util.k1.a0)) {
            this.swipBackLayout.setInterEvent(true);
        }
    }

    protected void initWebView(MyWebView myWebView) {
        myWebView.setListener(this.mActivity, new b());
        myWebView.setWebChromeClient(new c());
        myWebView.setWebViewClient(new d());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.mWebview.canGoBack()) {
            if (TextUtils.equals(this.mPersonalize, util.k1.a0)) {
                turnPage();
            }
            super.onBackPressed();
            return;
        }
        int i2 = this.toPage;
        if (i2 == 3) {
            util.b1.b(this.mActivity, "确定要退出答题?", "退出后已作答题目将不会保存", "退出", "继续", new a());
        } else if (i2 == 2) {
            this.mWebview.loadUrl(this.mOrginUrl);
        } else {
            super.onBackPressed();
        }
    }

    @Override // ui.callview.WebShareView
    public void onSuccessShareConfig(APIH5Bean aPIH5Bean) {
        if (aPIH5Bean != null) {
            try {
                if (!TextUtils.isEmpty(aPIH5Bean.getValue())) {
                    this.shareBean = (ShareConfigBean) new com.google.gson.e().a(aPIH5Bean.getValue(), ShareConfigBean.class);
                    String strReplace = this.shareBean.title.replace("{0}", this.mTitle);
                    String strReplace2 = this.shareBean.downloadUrl.replace("{1}", d.a.m() + "").replace("{2}", this.caragyCode + "");
                    this.shareBean.title = strReplace;
                    this.shareBean.downloadUrl = strReplace2;
                }
            } catch (Exception unused) {
            }
        }
        ShareConfigBean shareConfigBean = this.shareBean;
        if (shareConfigBean != null) {
            new ui.f.c(this.mActivity, shareConfigBean, 2, new c.b() { // from class: ui.activity.o1
                @Override // ui.f.c.b
                public final void a() {
                    this.f19452a.a();
                }
            }).show();
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id == R.id.iv_right) {
            if (this.shareFullScreen) {
                this.mPresenter.requestAticleInfo(this.mShareBaseUrl, this.articId);
                return;
            } else {
                this.mPresenter.requestShareConfig();
                return;
            }
        }
        if (id != R.id.ll_network_no) {
            return;
        }
        this.mWebview.reload();
        this.mWebview.setVisibility(0);
        this.mLlNetworkNo.setVisibility(8);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_web;
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
            View view = WebActivity.this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            MyWebView myWebView = WebActivity.this.mWebview;
            if (myWebView != null) {
                myWebView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
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
            if (str == null) {
                return false;
            }
            try {
                if (!str.startsWith("http:") && !str.startsWith("https:")) {
                    WebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                webView.loadUrl(str);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
