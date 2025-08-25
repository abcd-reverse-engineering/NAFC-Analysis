package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SocializeUtils;

/* loaded from: classes2.dex */
public class AnalyticsReqeust extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11748a = "/share/multi_add/";

    /* renamed from: b, reason: collision with root package name */
    private static final int f11749b = 9;

    /* renamed from: c, reason: collision with root package name */
    private String f11750c;

    /* renamed from: d, reason: collision with root package name */
    private String f11751d;

    /* renamed from: e, reason: collision with root package name */
    private String f11752e;

    /* renamed from: f, reason: collision with root package name */
    private String f11753f;

    /* renamed from: g, reason: collision with root package name */
    private String f11754g;

    /* renamed from: h, reason: collision with root package name */
    private String f11755h;

    /* renamed from: i, reason: collision with root package name */
    private String f11756i;

    /* renamed from: j, reason: collision with root package name */
    private UMediaObject f11757j;

    public AnalyticsReqeust(Context context, String str, String str2) {
        super(context, "", AnalyticsResponse.class, 9, URequest.RequestMethod.POST);
        this.mContext = context;
        this.f11751d = str;
        this.f11756i = str2;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f11748a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() throws PackageManager.NameNotFoundException {
        super.onPrepareRequest();
        Object[] objArr = new Object[2];
        objArr[0] = this.f11751d;
        String str = this.f11750c;
        if (str == null) {
            str = "";
        }
        objArr[1] = str;
        String str2 = String.format("{\"%s\":\"%s\"}", objArr);
        String appkey = SocializeUtils.getAppkey(this.mContext);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams("to", str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_SNS, str2);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, appkey);
        addStringParams("type", this.f11753f);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.f11750c);
        addStringParams("ct", this.f11756i);
        if (!TextUtils.isEmpty(this.f11755h)) {
            addStringParams("url", this.f11755h);
        }
        if (!TextUtils.isEmpty(this.f11754g)) {
            addStringParams("title", this.f11754g);
        }
        addMediaParams(this.f11757j);
    }

    public void setMedia(UMediaObject uMediaObject) {
        if (uMediaObject instanceof UMImage) {
            this.f11757j = uMediaObject;
            return;
        }
        if (uMediaObject instanceof UMusic) {
            UMusic uMusic = (UMusic) uMediaObject;
            this.f11754g = uMusic.getTitle();
            this.f11755h = uMusic.toUrl();
            this.f11756i = uMusic.getDescription();
            this.f11757j = uMusic.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMVideo) {
            UMVideo uMVideo = (UMVideo) uMediaObject;
            this.f11754g = uMVideo.getTitle();
            this.f11755h = uMVideo.toUrl();
            this.f11756i = uMVideo.getDescription();
            this.f11757j = uMVideo.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMWeb) {
            UMWeb uMWeb = (UMWeb) uMediaObject;
            this.f11754g = uMWeb.getTitle();
            this.f11755h = uMWeb.toUrl();
            this.f11756i = uMWeb.getDescription();
            this.f11757j = uMWeb.getThumbImage();
            return;
        }
        if (uMediaObject instanceof UMMin) {
            UMMin uMMin = (UMMin) uMediaObject;
            this.f11754g = uMMin.getTitle();
            this.f11755h = uMMin.toUrl();
            this.f11756i = uMMin.getDescription();
            this.f11757j = uMMin.getThumbImage();
        }
    }

    public void setPlatform(String str) {
        this.f11751d = str;
    }

    public void setText(String str) {
        this.f11756i = str;
    }

    public void setType(String str) {
        this.f11753f = str;
    }

    public void setUID(String str) {
        this.f11752e = str;
    }

    public void setmUsid(String str) {
        this.f11750c = str;
    }
}
