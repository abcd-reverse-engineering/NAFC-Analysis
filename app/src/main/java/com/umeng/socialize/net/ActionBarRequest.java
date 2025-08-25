package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* loaded from: classes2.dex */
public class ActionBarRequest extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11741a = "/bar/get/";

    /* renamed from: b, reason: collision with root package name */
    private static final int f11742b = 1;

    /* renamed from: c, reason: collision with root package name */
    private int f11743c;

    public ActionBarRequest(Context context, boolean z) {
        super(context, "", ActionBarResponse.class, 1, URequest.RequestMethod.GET);
        this.f11743c = 0;
        this.mContext = context;
        this.f11743c = z ? 1 : 0;
        this.mMethod = URequest.RequestMethod.GET;
    }

    @Override // com.umeng.socialize.net.utils.URequest
    public String getEcryptString(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f11741a + SocializeUtils.getAppkey(this.mContext) + "/android";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.f11743c));
        if (TextUtils.isEmpty(Config.EntityName)) {
            return;
        }
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
    }
}
