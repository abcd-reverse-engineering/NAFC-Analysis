package ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.PolicBean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.just.agentweb.AbsAgentWebSettings;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebViewClient;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.OnWebListener;
import interfaces.PermissionsListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import manager.LoginManager;
import network.gson.ResponseDataTypeAdaptor;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.activity.H5AppSelectedActivity;
import ui.activity.PromosWebDetActivity;
import ui.callview.WebFullCallView;
import ui.presenter.WebFrgPresenter;
import ui.presenter.WebFullPresenter;
import ui.view.x;
import util.b1;
import util.k1;
import util.n1;
import util.q1;
import util.v1;
import util.y1;
import util.z1;
import zxing.android.CaptureActivity;

/* loaded from: classes2.dex */
public class WebFragment extends BaseFragment implements WebFullCallView {
    private String articId;
    private boolean isSendLocation;
    private AgentWeb mAgentWeb;
    private WebFrgPresenter mHttpPresenter;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(R.id.net_tips)
    TextView mNetTips;
    private WebFullPresenter mPresenter;

    @BindView(R.id.pro_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.iv_back)
    ImageView mTIvBack;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private ValueCallback<Uri[]> mUploadMessage5;
    private WebView mWebview;
    private x viewFrag;
    private String TAG = WebFragment.class.getSimpleName();
    private String XCUrl = "";
    private String mShareBaseUrl = "";
    private int mMaxSelNum = 6;
    private HashMap<Object, String> mHashMap = null;
    private final String mEventTag = "event";
    private String backValue = "1";
    private ui.f.c mShareDialog = null;
    Handler mHandler = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (WebFragment.this.mActivity.isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                WebFragment.this.mRlTitle.setVisibility(0);
            } else {
                if (i2 != 1) {
                    return;
                }
                WebFragment.this.mRlTitle.setVisibility(8);
            }
        }
    }

    class b implements OnWebListener {
        b() {
        }

        public /* synthetic */ void a() {
            WebFragment.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.d2.a aVar) throws UnsupportedEncodingException {
            WebFragment.this.sendWebMsg(aVar);
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            WebFragment.this.mActivity.runOnUiThread(new Runnable() { // from class: ui.fragment.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19734a.a();
                }
            });
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebFragment.this.mPresenter.SurveyH5Param(str);
        }
    }

    class c implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebChromeClient.FileChooserParams f19691a;

        c(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f19691a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFragment.this.mActivity, list, z, true, this);
            WebFragment.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.f19691a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                j.e.a(WebFragment.this.mActivity, 200L, PictureMimeType.ofImage(), WebFragment.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                j.e.a(WebFragment.this.mActivity, 200L, PictureMimeType.ofAudio(), WebFragment.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(WebFragment.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", WebFragment.this.mMaxSelNum);
                WebFragment.this.startActivityForResult(intent, 1003);
            }
        }
    }

    class d implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19693a;

        d(boolean z) {
            this.f19693a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f19693a) {
                k1.j(WebFragment.this.mActivity);
            } else {
                WebFragment.this.varCamerPrims();
            }
        }
    }

    class e implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PermissionRequest f19695a;

        e(PermissionRequest permissionRequest) {
            this.f19695a = permissionRequest;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            if (this.f19695a == null) {
                WebFragment.this.camerPrimssDlg(z);
            } else {
                util.permissionutil.c.a(WebFragment.this.mActivity, list, z, false, this);
                this.f19695a.deny();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if ("vivo" != Build.BRAND || Build.VERSION.SDK_INT != 23) {
                PermissionRequest permissionRequest = this.f19695a;
                if (permissionRequest == null) {
                    WebFragment.this.goScan();
                    return;
                } else {
                    permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
                    return;
                }
            }
            if (!util.permissionutil.c.f()) {
                PermissionRequest permissionRequest2 = this.f19695a;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
                k1.j(WebFragment.this.mActivity);
                return;
            }
            PermissionRequest permissionRequest3 = this.f19695a;
            if (permissionRequest3 == null) {
                WebFragment.this.goScan();
            } else {
                permissionRequest3.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
            }
        }
    }

    private class f extends com.just.agentweb.WebChromeClient {
        private f() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        WebFragment.this.varCamerPrims(permissionRequest);
                        return;
                    }
                }
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            if (WebFragment.this.mProgressBar == null) {
                return;
            }
            String str = "----onProgressChanged-----------" + i2;
            if (i2 == 100) {
                WebFragment.this.mProgressBar.setVisibility(8);
            } else {
                WebFragment.this.mProgressBar.setVisibility(0);
                WebFragment.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebFragment.this.mUploadMessage5 = valueCallback;
            WebFragment.this.chooseFilePermission(fileChooserParams);
            return true;
        }

        /* synthetic */ f(WebFragment webFragment, a aVar) {
            this();
        }
    }

    public class g extends WebViewClient {
        public g() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!WebFragment.this.networkStateDeal()) {
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebFragment.this.onErrorView(true);
            if (Build.VERSION.SDK_INT < 23 || !webResourceError.getDescription().toString().contains("ERR_CONNECTION_REFUSED")) {
                return;
            }
            WebFragment.this.refreshPage();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AtomicReference atomicReference = new AtomicReference();
            if (Build.VERSION.SDK_INT >= 21) {
                atomicReference.set(webResourceRequest.getUrl().getPath());
            }
            if (webResourceRequest.getUrl().toString().startsWith("tel:")) {
                y1.e(WebFragment.this.mActivity, webResourceRequest.getUrl().toString());
                return true;
            }
            if (WebFragment.this.networkStateDeal()) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        b1.f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new d(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new c(fileChooserParams));
    }

    private String getUrl() {
        String str;
        String str2 = "";
        try {
            String accountId = AccountManager.getAccountId();
            String strL = v1.l();
            RegionMudelBean regionMudelBeanJ = d.a.j();
            if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getAndroidh5host())) {
                str = "";
            } else {
                str = regionMudelBeanJ.getH5Url() + regionMudelBeanJ.getAndroidh5host();
            }
            if (TextUtils.isEmpty(str)) {
                str = d.a.f13520f;
            }
            n1.a("getUrl()--------url-->>" + str);
            str2 = str + "?userid=" + accountId + "&imei=" + strL + "&" + d.a.m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        n1.a("getUrl()--------url+-->>" + str2);
        this.XCUrl = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new g()).setWebChromeClient(new f(this, null)).addJavascriptInterface("appjs", this.viewFrag.a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(R.layout.web_page_error, -1).createAgentWeb().ready().go(getUrl());
        this.mWebview = this.mAgentWeb.getWebCreator().getWebView();
        this.mAgentWeb.getWebCreator().getWebView().setHorizontalScrollBarEnabled(false);
        this.mWebview.getSettings().setTextZoom(100);
        this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean networkStateDeal() {
        if (this.mActivity.isFinishing()) {
            return false;
        }
        if (q1.f()) {
            return true;
        }
        onErrorView(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorView(boolean z) {
        if (z) {
            View view = this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            WebView webView = this.mWebview;
            if (webView != null) {
                webView.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mLlNetworkNo;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        WebView webView2 = this.mWebview;
        if (webView2 != null) {
            webView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveCleanData() {
        ValueCallback<Uri[]> valueCallback = this.mUploadMessage5;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mUploadMessage5 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPage() {
        if (this.mWebview == null || !networkStateDeal()) {
            return;
        }
        onErrorView(false);
        this.mWebview.reload();
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
                String strB2 = aVar.b("source");
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(k1.P, strDecode);
                intent.putExtra(k1.Q, strA);
                intent.putExtra(k1.T, this.articId);
                intent.putExtra(k1.S, strB2);
                intent.putExtra(k1.U, 2);
                startActivity(intent);
            }
            String strB3 = aVar.b("isOnlyFullScreen");
            String strB4 = aVar.b("isfullScreen");
            String strB5 = aVar.b("stylecolor");
            if (TextUtils.equals("yes", strB4)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(100, null));
                this.mHandler.sendEmptyMessage(0);
                return;
            }
            if (TextUtils.equals("no", strB4)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(101, null));
                this.mHandler.sendEmptyMessage(1);
                return;
            }
            if (TextUtils.equals("yes", strB3)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(100, null));
                this.mHandler.sendEmptyMessage(1);
            } else if (TextUtils.equals("no", strB3)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(101, null));
                this.mHandler.sendEmptyMessage(1);
            } else if (TextUtils.equals("black", strB5)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(102, null));
            } else if (TextUtils.equals("white", strB5)) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(103, null));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        varCamerPrims(null);
    }

    public /* synthetic */ void a(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void appCallH5(String str, String str2, boolean z) {
        String str3 = str.substring(0, str.lastIndexOf(125)) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + "}";
        if (this.mWebview != null) {
            if (!z) {
                final String str4 = "javascript:appCallH5(" + str3 + ")";
                n1.a(this.TAG, "js===" + str4);
                this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19741a.b(str4);
                    }
                }, 0L);
                return;
            }
            final String str5 = "javascript:appCallH5('" + str3 + "')";
            n1.a(this.TAG, "js===" + str5);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19735a.a(str5);
                }
            }, 0L);
        }
    }

    public void appCallH5Other(String str, String str2) {
        if (this.mWebview != null) {
            final String str3 = "javascript:" + str + "(" + str2 + ")";
            n1.a(str + " appCallH5Other-->", str3);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.fragment.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19739a.c(str3);
                }
            }, 0L);
        }
    }

    public /* synthetic */ void b(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public /* synthetic */ void c(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void clearH5localData() {
        this.mWebview.loadUrl("javascript:clearH5localData()");
    }

    public /* synthetic */ void d(String str) {
        appCallH5(str, "\"response\":{\"verifiedStatus\":\"1\"}", false);
    }

    @Override // ui.callview.WebFullCallView
    public void eventH5Action(final String str, Map<String, Object> map) {
        if (!map.containsKey("action") || map.get("action") == null) {
            return;
        }
        switch (Integer.parseInt(map.get("action").toString())) {
            case 2:
                if (map.containsKey(SurveyH5Bean.VALUE)) {
                    if (!TextUtils.equals("0", String.valueOf(map.get(SurveyH5Bean.VALUE)))) {
                        ui.statusbarcompat.b.a(this.mActivity, true, false);
                        break;
                    } else {
                        ui.statusbarcompat.b.a(this.mActivity, true, true);
                        break;
                    }
                }
                break;
            case 3:
                putActionMap("event3", str);
                varCamerPrims();
                break;
            case 4:
                appCallH5(str, "\"response\":" + x.b(), false);
                break;
            case 5:
                putActionMap("event5", str);
                z1.a(this.mActivity).a(17, new IVerifyListener() { // from class: ui.fragment.t
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        this.f19737a.d(str);
                    }
                });
                break;
            case 7:
                LoginManager.getInstance().exitToLogin();
                break;
            case 8:
                String strValueOf = String.valueOf(map.get(SurveyH5Bean.VALUE));
                PolicBean policBean = new PolicBean();
                policBean.setPoliceToken(strValueOf);
                d.b.a(policBean);
                break;
            case 9:
                d.b.e();
                break;
            case 10:
                this.mMaxSelNum = Integer.parseInt(map.get(SurveyH5Bean.VALUE).toString());
                break;
            case 11:
                ShareConfigBean shareConfigBean = (ShareConfigBean) ResponseDataTypeAdaptor.buildGson().a(map.get(SurveyH5Bean.VALUE).toString(), ShareConfigBean.class);
                if (shareConfigBean != null) {
                    if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                        shareConfigBean.downloadUrl = shareConfigBean.downloadUrl.replace("{0}", d.a.m() + "");
                    }
                    this.mShareDialog = new ui.f.c(this.mActivity, shareConfigBean, 2, null);
                    this.mShareDialog.show();
                    break;
                }
                break;
            case 12:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), d.b.c()) ? "1" : "0") + "\"}", false);
                break;
            case 13:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), d.b.b()) ? "1" : "0") + "\"}", false);
                break;
            case 15:
                onErrorView(false);
                break;
        }
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_web;
    }

    @Override // ui.fragment.BaseFragment
    protected void initPage() {
        this.mIvRight.setBackgroundResource(R.drawable.iv_share_white);
        this.mTIvBack.setVisibility(8);
        this.mRlTitle.setVisibility(8);
        this.mRlTitle.setBackgroundColor(0);
        this.mHttpPresenter = new WebFrgPresenter(this.mActivity);
        this.mPresenter = new WebFullPresenter(this.mActivity, this);
        this.viewFrag = new x();
        initWebViewListener();
        initAgentWeb();
    }

    protected void initWebViewListener() {
        this.viewFrag.a(this.mActivity, this.mWebview, new b());
    }

    public void jsShowPage() {
        WebView webView = this.mWebview;
        if (webView != null) {
            webView.loadUrl("javascript:showpage()");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        if (i2 == 0) {
            if (i3 != -1 || intent == null) {
                return;
            }
            String stringExtra = intent.getStringExtra(CaptureActivity.f21076l);
            n1.b("content-->" + stringExtra);
            appCallH5(this.mHashMap.get("event3"), "\"response\":{\"scanValue\":\"" + stringExtra + "\"}", false);
            this.mHashMap.remove("event3");
        }
        switch (i2) {
            case 1001:
            case 1002:
                List listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
                if (listObtainMultipleResult != null && listObtainMultipleResult.size() > 0) {
                    Uri[] uriArr = new Uri[listObtainMultipleResult.size()];
                    while (i4 < listObtainMultipleResult.size()) {
                        LocalMedia localMedia = (LocalMedia) listObtainMultipleResult.get(i4);
                        if (Build.VERSION.SDK_INT > 28) {
                            uriArr[i4] = y1.c(this.mActivity, localMedia.getRealPath());
                        } else {
                            uriArr[i4] = y1.c(this.mActivity, localMedia.getPath());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr);
                    this.mUploadMessage5 = null;
                }
                receiveCleanData();
                break;
            case 1003:
                List listObtainMultipleResult2 = PictureSelector.obtainMultipleResult(intent);
                if (listObtainMultipleResult2 != null && listObtainMultipleResult2.size() > 0) {
                    Uri[] uriArr2 = new Uri[listObtainMultipleResult2.size()];
                    while (i4 < listObtainMultipleResult2.size()) {
                        AppInfoBean appInfoBean = (AppInfoBean) listObtainMultipleResult2.get(i4);
                        if (!TextUtils.isEmpty(appInfoBean.getUri())) {
                            uriArr2[i4] = Uri.parse(appInfoBean.getUri());
                        }
                        i4++;
                    }
                    this.mUploadMessage5.onReceiveValue(uriArr2);
                    this.mUploadMessage5 = null;
                    appCallH5Other("getAppBackInfo", ResponseDataTypeAdaptor.buildGson().a(listObtainMultipleResult2));
                }
                receiveCleanData();
                break;
        }
    }

    public boolean onBackPressed() {
        WebView webView = this.mWebview;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.mWebview.goBack();
        return true;
    }

    @Override // ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroyView();
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 223) {
                org.greenrobot.eventbus.c.f().f(aVar);
                appCallH5(this.mHashMap.get("event5"), "\"response\":{\"verifiedStatus\":\"1\"}", false);
                this.mHashMap.remove("event5");
            } else {
                if (iA == 300) {
                    org.greenrobot.eventbus.c.f().f(aVar);
                    if (aVar.b() != null) {
                        appCallH5Other("getCallBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
                        return;
                    }
                    return;
                }
                if (iA != 302) {
                    return;
                }
                org.greenrobot.eventbus.c.f().f(aVar);
                if (aVar.b() != null) {
                    appCallH5Other("getSmsBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        jsShowPage();
    }

    @Override // ui.callview.WebFullCallView
    public void onSurveyBeanRequest(String str, String str2, boolean z) {
        appCallH5(str, str2, z);
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
            this.mHttpPresenter.requestAticleInfo(this.mShareBaseUrl, this.articId);
        } else {
            if (id != R.id.ll_network_no) {
                return;
            }
            this.mNetTips.setText("正在努力加载中...");
            refreshPage();
        }
    }

    public void putActionMap(Object obj, String str) {
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put(obj, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            StatisticsHttp.getInstance().pageOpenHttp(e.d.r);
            jsShowPage();
        }
    }

    public void turnPage() {
        RegionMudelBean regionMudelBeanJ = d.a.j();
        if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getAndroidh5host())) {
            this.mWebview.loadUrl(this.XCUrl + "#/case/caseList?time=" + d.a.m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims(PermissionRequest permissionRequest) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20909c}, new e(permissionRequest));
    }
}
