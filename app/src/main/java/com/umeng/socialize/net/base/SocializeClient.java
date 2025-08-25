package com.umeng.socialize.net.base;

import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.UClient;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;

/* loaded from: classes2.dex */
public class SocializeClient extends UClient {
    public SocializeReseponse execute(URequest uRequest) throws InterruptedException {
        if (SocializeConstants.DEBUG_MODE) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e2) {
                SLog.error(e2);
            }
        }
        return (SocializeReseponse) super.execute(uRequest, uRequest.mResponseClz);
    }
}
