package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMQQMini extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f11726f;

    /* renamed from: g, reason: collision with root package name */
    private String f11727g;

    /* renamed from: h, reason: collision with root package name */
    private String f11728h;

    public UMQQMini(String str) {
        super(str);
        this.f11726f = "";
        this.f11727g = "";
        this.f11728h = "";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.WEBPAGE;
    }

    public String getMiniAppId() {
        return this.f11726f;
    }

    public String getPath() {
        return this.f11727g;
    }

    public String getType() {
        return this.f11728h;
    }

    public void setMiniAppId(String str) {
        this.f11726f = str;
    }

    public void setPath(String str) {
        this.f11727g = str;
    }

    public void setType(String str) {
        this.f11728h = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f11693e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f11689a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f11690b);
        }
        return map;
    }
}
