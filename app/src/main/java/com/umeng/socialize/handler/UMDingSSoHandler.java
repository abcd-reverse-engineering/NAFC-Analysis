package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.dingtalk.share.ddsharemodule.DDShareApiFactory;
import com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler;
import com.android.dingtalk.share.ddsharemodule.IDDShareApi;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.BaseResp;
import com.android.dingtalk.share.ddsharemodule.message.SendMessageToDD;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.media.DDShareContent;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class UMDingSSoHandler extends UMSSOHandler {
    private PlatformConfig.APPIDPlatform config;
    private IDDShareApi iddShareApi;
    private UMShareListener listener;
    private Context mAppContext;
    protected String VERSION = "7.3.2";
    private String mFileProvider = "";

    public boolean checkAndroidNotBelowN() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public IDDShareApi getApi() {
        return this.iddShareApi;
    }

    public IDDAPIEventHandler getIDDAPIEventHandler() {
        return new IDDAPIEventHandler() { // from class: com.umeng.socialize.handler.UMDingSSoHandler.4
            @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
            public void onReq(BaseReq baseReq) {
            }

            @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
            public void onResp(BaseResp baseResp) {
                int i2 = baseResp.mErrCode;
                if (i2 == -2) {
                    UMDingSSoHandler.this.listener.onCancel(SHARE_MEDIA.DINGTALK);
                    return;
                }
                if (i2 == 0) {
                    UMDingSSoHandler.this.listener.onResult(SHARE_MEDIA.DINGTALK);
                    return;
                }
                UMDingSSoHandler.this.listener.onError(SHARE_MEDIA.DINGTALK, new Throwable(UmengErrorCode.ShareFailed.getMessage() + baseResp.mErrStr));
            }
        };
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return this.VERSION;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isInstall() {
        IDDShareApi iDDShareApi = this.iddShareApi;
        return iDDShareApi != null && iDDShareApi.isDDAppInstalled();
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isSupport() {
        try {
            if (this.iddShareApi != null) {
                return this.iddShareApi.isDDSupportAPI();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
        this.mAppContext = context.getApplicationContext();
        this.config = (PlatformConfig.APPIDPlatform) platform;
        if (TextUtils.isEmpty(this.config.getFileProvider())) {
            SLog.E(UmengText.DING.Ding_FILE_PROVIDER_ERROR);
        } else {
            this.mFileProvider = this.config.getFileProvider();
        }
        WeakReference<Activity> weakReference = this.mWeakAct;
        if (weakReference == null || this.config == null) {
            return;
        }
        this.iddShareApi = DDShareApiFactory.createDDShareApi(weakReference.get(), this.config.appId, true);
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void release() {
        this.iddShareApi = null;
    }

    public boolean sendReq(SendMessageToDD.Req req) {
        try {
            if (this.iddShareApi != null) {
                return this.iddShareApi.sendReq(req);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        boolean z = !this.mFileProvider.equals("") && checkAndroidNotBelowN();
        if (!isInstall() && !isSupport()) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMDingSSoHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    uMShareListener.onError(SHARE_MEDIA.DINGTALK, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                }
            });
            return false;
        }
        if (!isSupport()) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMDingSSoHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    uMShareListener.onError(SHARE_MEDIA.DINGTALK, new Throwable(UmengErrorCode.ShareFailed + UmengText.SHARE.VERSION_NOT_SUPPORT));
                }
            });
            return false;
        }
        this.listener = uMShareListener;
        DDShareContent dDShareContent = new DDShareContent(shareContent);
        SendMessageToDD.Req req = new SendMessageToDD.Req();
        req.mMediaMessage = dDShareContent.getMessage(this.mAppContext, z, this.mFileProvider);
        if (!sendReq(req)) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMDingSSoHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    uMShareListener.onError(SHARE_MEDIA.DINGTALK, new Throwable(UmengErrorCode.UnKnowCode.getMessage() + UmengText.SHARE.SHARE_CONTENT_FAIL));
                }
            });
        }
        return false;
    }
}
