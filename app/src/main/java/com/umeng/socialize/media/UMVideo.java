package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UMVideo extends BaseMediaObject {

    /* renamed from: f, reason: collision with root package name */
    private String f11729f;

    /* renamed from: g, reason: collision with root package name */
    private String f11730g;

    /* renamed from: h, reason: collision with root package name */
    private String f11731h;

    /* renamed from: i, reason: collision with root package name */
    private String f11732i;

    /* renamed from: j, reason: collision with root package name */
    private int f11733j;

    /* renamed from: k, reason: collision with root package name */
    private File f11734k;

    public UMVideo(String str) {
        super(str);
    }

    public int getDuration() {
        return this.f11733j;
    }

    public String getH5Url() {
        return this.f11732i;
    }

    public String getHighBandDataUrl() {
        return this.f11731h;
    }

    public File getLocalVideoFile() {
        return this.f11734k;
    }

    public String getLowBandDataUrl() {
        return this.f11730g;
    }

    public String getLowBandUrl() {
        return this.f11729f;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.VEDIO;
    }

    public void setDuration(int i2) {
        this.f11733j = i2;
    }

    public void setH5Url(String str) {
        this.f11732i = str;
    }

    public void setHighBandDataUrl(String str) {
        this.f11731h = str;
    }

    public void setLowBandDataUrl(String str) {
        this.f11730g = str;
    }

    public void setLowBandUrl(String str) {
        this.f11729f = str;
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
        return "UMVedio [media_url=" + this.f11689a + ", qzone_title=" + this.f11690b + ", qzone_thumb=media_url=" + this.f11689a + ", qzone_title=" + this.f11690b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap map = new HashMap();
        if (isUrlMedia()) {
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f11689a);
            map.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return map;
    }

    public UMVideo(File file) {
        this.f11734k = file;
    }
}
