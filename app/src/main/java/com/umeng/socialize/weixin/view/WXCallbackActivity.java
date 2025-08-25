package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.SLog;

/* loaded from: classes2.dex */
public abstract class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    private final String TAG = "WXCallbackActivity";
    protected UMWXHandler mWxHandler = null;

    protected void handleIntent(Intent intent) {
        this.mWxHandler.getWXApi().handleIntent(intent, this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SLog.I("WXCallbackActivity onCreate");
        this.mWxHandler = (UMWXHandler) UMShareAPI.get(getApplicationContext()).getHandler(SHARE_MEDIA.WEIXIN);
        SLog.I("WXCallbackActivity mWxHandler：" + this.mWxHandler);
        this.mWxHandler.onCreate(getApplicationContext(), PlatformConfig.getPlatform(SHARE_MEDIA.WEIXIN));
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SLog.I("WXCallbackActivity onNewIntent");
        setIntent(intent);
        this.mWxHandler = (UMWXHandler) UMShareAPI.get(getApplicationContext()).getHandler(SHARE_MEDIA.WEIXIN);
        this.mWxHandler.onCreate(getApplicationContext(), PlatformConfig.getPlatform(SHARE_MEDIA.WEIXIN));
        handleIntent(intent);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null) {
            uMWXHandler.getWXEventHandler().onReq(baseReq);
        }
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        SLog.I("WXCallbackActivity 分发回调");
        UMWXHandler uMWXHandler = this.mWxHandler;
        if (uMWXHandler != null && baseResp != null) {
            try {
                uMWXHandler.getWXEventHandler().onResp(baseResp);
            } catch (Exception e2) {
                SLog.error(e2);
            }
        }
        finish();
    }
}
