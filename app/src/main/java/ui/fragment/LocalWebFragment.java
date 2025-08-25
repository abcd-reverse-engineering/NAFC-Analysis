package ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import bean.AppInfoBean;
import bean.PolicBean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.just.agentweb.AbsAgentWebSettings;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebViewClient;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.analytics.pro.bh;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.OnWebListener;
import interfaces.PermissionsListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import manager.LoginManager;
import network.gson.ResponseDataTypeAdaptor;
import org.greenrobot.eventbus.ThreadMode;
import ui.activity.H5AppSelectedActivity;
import ui.callview.WebFullCallView;
import ui.presenter.WebFullPresenter;
import ui.view.x;
import util.b1;
import util.k1;
import util.n1;
import util.q1;
import util.y1;
import util.z1;
import zxing.android.CaptureActivity;

/* loaded from: classes2.dex */
public class LocalWebFragment extends BaseFragment implements WebFullCallView {
    private static WebView mWebview;
    private AgentWeb mAgentWeb;

    @BindView(R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;
    private WebFullPresenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.ll_progress)
    View mProgressLoad;
    private ValueCallback<Uri[]> mUploadMessage5;
    private String orginUrl;
    private x viewFrag;
    private String TAG = LocalWebFragment.class.getSimpleName();
    private int mMaxSelNum = 6;
    private HashMap<Object, String> mHashMap = null;
    private final String mEventTag = "event";
    private String backValue = "1";
    private ui.f.c mShareDialog = null;

    class a implements OnWebListener {
        a() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.d2.a aVar) {
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            LocalWebFragment.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            LocalWebFragment.this.mPresenter.SurveyH5Param(str);
        }
    }

    class b implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebChromeClient.FileChooserParams f19625a;

        b(WebChromeClient.FileChooserParams fileChooserParams) {
            this.f19625a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(LocalWebFragment.this.mActivity, list, z, true, this);
            LocalWebFragment.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.f19625a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                j.e.a(LocalWebFragment.this.mActivity, 200L, PictureMimeType.ofImage(), LocalWebFragment.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                j.e.a(LocalWebFragment.this.mActivity, 200L, PictureMimeType.ofAudio(), LocalWebFragment.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(LocalWebFragment.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", LocalWebFragment.this.mMaxSelNum);
                LocalWebFragment.this.startActivityForResult(intent, 1003);
            }
        }
    }

    class c implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19627a;

        c(boolean z) {
            this.f19627a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f19627a) {
                k1.j(LocalWebFragment.this.mActivity);
            } else {
                LocalWebFragment.this.varCamerPrims();
            }
        }
    }

    class d implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PermissionRequest f19629a;

        d(PermissionRequest permissionRequest) {
            this.f19629a = permissionRequest;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            if (this.f19629a == null) {
                LocalWebFragment.this.camerPrimssDlg(z);
            } else {
                util.permissionutil.c.a(LocalWebFragment.this.mActivity, list, z, false, this);
                this.f19629a.deny();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if ("vivo" != Build.BRAND || Build.VERSION.SDK_INT != 23) {
                PermissionRequest permissionRequest = this.f19629a;
                if (permissionRequest == null) {
                    LocalWebFragment.this.goScan();
                    return;
                } else {
                    permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
                    return;
                }
            }
            if (!util.permissionutil.c.f()) {
                PermissionRequest permissionRequest2 = this.f19629a;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
                k1.j(LocalWebFragment.this.mActivity);
                return;
            }
            PermissionRequest permissionRequest3 = this.f19629a;
            if (permissionRequest3 == null) {
                LocalWebFragment.this.goScan();
            } else {
                permissionRequest3.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
            }
        }
    }

    private class e extends com.just.agentweb.WebChromeClient {
        private e() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        LocalWebFragment.this.varCamerPrims(permissionRequest);
                        return;
                    }
                }
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            LocalWebFragment localWebFragment = LocalWebFragment.this;
            ProgressBar progressBar = localWebFragment.mProgressBar;
            if (progressBar == null || localWebFragment.mProgressLoad == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
                LocalWebFragment.this.mProgressLoad.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                LocalWebFragment.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LocalWebFragment.this.mUploadMessage5 = valueCallback;
            LocalWebFragment.this.chooseFilePermission(fileChooserParams);
            return true;
        }

        /* synthetic */ e(LocalWebFragment localWebFragment, a aVar) {
            this();
        }
    }

    public class f extends WebViewClient {
        public f() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!LocalWebFragment.this.networkStateDeal()) {
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            LocalWebFragment.this.onErrorView(true);
            if (Build.VERSION.SDK_INT < 23 || !webResourceError.getDescription().toString().contains("ERR_CONNECTION_REFUSED")) {
                return;
            }
            LocalWebFragment.this.refreshPage();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!webResourceRequest.getUrl().toString().startsWith("tel:")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            y1.e(LocalWebFragment.this.mActivity, webResourceRequest.getUrl().toString());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        b1.f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new c(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new b(fileChooserParams));
    }

    public static LocalWebFragment getInstance(String str) {
        LocalWebFragment localWebFragment = new LocalWebFragment();
        Bundle bundle = new Bundle();
        bundle.putString(bh.f10120e, str);
        localWebFragment.setArguments(bundle);
        return localWebFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new f()).setWebChromeClient(new e(this, null)).addJavascriptInterface("appjs", this.viewFrag.a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(R.layout.web_page_error, -1).createAgentWeb().ready().go(this.orginUrl);
        mWebview = this.mAgentWeb.getWebCreator().getWebView();
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.getSettings().setTextZoom(100);
        mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
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
            WebView webView = mWebview;
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
        WebView webView2 = mWebview;
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
        if (mWebview == null || !networkStateDeal()) {
            return;
        }
        onErrorView(false);
        mWebview.reload();
    }

    public static void setPushUrl(String str) {
        WebView webView = mWebview;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        varCamerPrims(null);
    }

    public /* synthetic */ void a(String str) {
        appCallH5(str, "\"response\":{\"verifiedStatus\":\"1\"}", false);
    }

    public void appCallH5(String str, String str2, boolean z) {
        String str3 = str.substring(0, str.lastIndexOf(125)) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + "}";
        if (mWebview != null) {
            if (!z) {
                final String str4 = "javascript:appCallH5(" + str3 + ")";
                n1.a(this.TAG, "js===" + str4);
                mWebview.postDelayed(new Runnable() { // from class: ui.fragment.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalWebFragment.mWebview.evaluateJavascript(str4, null);
                    }
                }, 0L);
                return;
            }
            final String str5 = "javascript:appCallH5('" + str3 + "')";
            n1.a(this.TAG, "js===" + str5);
            mWebview.postDelayed(new Runnable() { // from class: ui.fragment.m
                @Override // java.lang.Runnable
                public final void run() {
                    LocalWebFragment.mWebview.evaluateJavascript(str5, null);
                }
            }, 0L);
        }
    }

    public void appCallH5Other(String str, String str2) {
        if (mWebview != null) {
            final String str3 = "javascript:" + str + "(" + str2 + ")";
            n1.a(str + " appCallH5Other-->", str3);
            mWebview.postDelayed(new Runnable() { // from class: ui.fragment.n
                @Override // java.lang.Runnable
                public final void run() {
                    LocalWebFragment.mWebview.evaluateJavascript(str3, null);
                }
            }, 0L);
        }
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
                z1.a(this.mActivity).a(17, new IVerifyListener() { // from class: ui.fragment.l
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        this.f19727a.a(str);
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
        return R.layout.activity_web_local;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.orginUrl = getArguments().getString(bh.f10120e);
        this.mPresenter = new WebFullPresenter(this.mActivity, this);
        this.viewFrag = new x();
        initAgentWeb();
        initWebViewListener();
    }

    protected void initWebViewListener() {
        this.viewFrag.a(this.mActivity, mWebview, new a());
    }

    public void jsShowPage() {
        WebView webView = mWebview;
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
        WebView webView = mWebview;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        mWebview.goBack();
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

    @OnClick({R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.ll_network_no) {
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
            jsShowPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims(PermissionRequest permissionRequest) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20909c}, new d(permissionRequest));
    }
}
