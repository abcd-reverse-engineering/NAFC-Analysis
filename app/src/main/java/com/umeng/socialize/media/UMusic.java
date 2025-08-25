package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMusic extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f11735f;

    /* renamed from: g, reason: collision with root package name */
    private String f11736g;

    /* renamed from: h, reason: collision with root package name */
    private String f11737h;

    /* renamed from: i, reason: collision with root package name */
    private String f11738i;

    /* renamed from: j, reason: collision with root package name */
    private int f11739j;

    /* renamed from: k, reason: collision with root package name */
    private String f11740k;

    public UMusic(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f11739j;
    }

    public String getH5Url() {
        return this.f11737h;
    }

    public String getHighBandDataUrl() {
        return this.f11736g;
    }

    public String getLowBandDataUrl() {
        return this.f11735f;
    }

    public String getLowBandUrl() {
        return this.f11738i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.MUSIC;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f11693e;
    }

    public String getmTargetUrl() {
        return this.f11740k;
    }

    public void setDuration(int i2) {
        this.f11739j = i2;
    }

    public void setH5Url(String str) {
        this.f11737h = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f11736g = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f11735f = str;
    }

    public void setLowBandUrl(String str) {
        this.f11738i = str;
    }

    public void setmTargetUrl(String str) {
        this.f11740k = str;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        UMImage uMImage = this.f11693e;
        if (uMImage != null) {
            return uMImage.toByte();
        }
        return null;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public String toString() {
        return "UMusic [title=" + this.f11690b + "media_url=" + this.f11689a + ", qzone_title=" + this.f11690b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f11689a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_TITLE, this.f11690b);
        }
        return map;
    }

    protected UMusic(Parcel parcel) {
        super(parcel);
    }
}
