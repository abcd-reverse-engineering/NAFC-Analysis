package com.umeng.socialize.media;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.BaseResp;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.handler.UMDingSSoHandler;
import com.umeng.socialize.utils.SLog;

/* loaded from: classes2.dex */
public class DingCallBack extends Activity implements IDDAPIEventHandler {
    protected UMDingSSoHandler dingSSoHandler = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dingSSoHandler = (UMDingSSoHandler) UMShareAPI.get(this).getHandler(SHARE_MEDIA.DINGTALK);
        this.dingSSoHandler.onCreate(this, PlatformConfig.getPlatform(SHARE_MEDIA.DINGTALK));
        if (getIntent() != null) {
            try {
                this.dingSSoHandler.getApi().handleIntent(getIntent(), this);
            } catch (Throwable th) {
                SLog.error("Activity可能正在被攻击", th);
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.dingSSoHandler = (UMDingSSoHandler) UMShareAPI.get(this).getHandler(SHARE_MEDIA.DINGTALK);
        this.dingSSoHandler.onCreate(this, PlatformConfig.getPlatform(SHARE_MEDIA.DINGTALK));
        try {
            this.dingSSoHandler.getApi().handleIntent(intent, this);
        } catch (Throwable th) {
            SLog.error("Activity可能正在被攻击", th);
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onReq(BaseReq baseReq) {
        UMDingSSoHandler uMDingSSoHandler = this.dingSSoHandler;
        if (uMDingSSoHandler != null) {
            uMDingSSoHandler.getIDDAPIEventHandler().onReq(baseReq);
        }
        finish();
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onResp(BaseResp baseResp) {
        UMDingSSoHandler uMDingSSoHandler = this.dingSSoHandler;
        if (uMDingSSoHandler != null) {
            uMDingSSoHandler.getIDDAPIEventHandler().onResp(baseResp);
        }
        finish();
    }
}
