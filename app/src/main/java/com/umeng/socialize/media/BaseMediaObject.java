package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseMediaObject implements UMediaObject {

    /* renamed from: a, reason: collision with root package name */
    protected String f11689a;

    /* renamed from: b, reason: collision with root package name */
    protected String f11690b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<String, Object> f11691c;

    /* renamed from: d, reason: collision with root package name */
    protected String f11692d;

    /* renamed from: e, reason: collision with root package name */
    protected UMImage f11693e;
    public String mText;

    public BaseMediaObject() {
        this.mText = null;
        this.f11689a = "";
        this.f11690b = "";
        this.f11691c = new HashMap();
        this.f11692d = "";
    }

    public String getDescription() {
        return this.f11692d;
    }

    public UMImage getThumbImage() {
        return this.f11693e;
    }

    public String getTitle() {
        return this.f11690b;
    }

    public Map<String, Object> getmExtra() {
        return this.f11691c;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public boolean isUrlMedia() {
        return !TextUtils.isEmpty(this.f11689a);
    }

    public void setDescription(String str) {
        this.f11692d = str;
    }

    public void setThumb(UMImage uMImage) {
        this.f11693e = uMImage;
    }

    public void setTitle(String str) {
        this.f11690b = str;
    }

    public void setmExtra(String str, Object obj) {
        this.f11691c.put(str, obj);
    }

    public String toString() {
        return "BaseMediaObject [media_url=" + this.f11689a + ", qzone_title=" + this.f11690b + ", qzone_thumb=]";
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public String toUrl() {
        return this.f11689a;
    }

    public BaseMediaObject(String str) {
        this.mText = null;
        this.f11689a = "";
        this.f11690b = "";
        this.f11691c = new HashMap();
        this.f11692d = "";
        this.f11689a = str;
    }

    protected BaseMediaObject(Parcel parcel) {
        this.mText = null;
        this.f11689a = "";
        this.f11690b = "";
        this.f11691c = new HashMap();
        this.f11692d = "";
        if (parcel != null) {
            this.f11689a = parcel.readString();
            this.f11690b = parcel.readString();
        }
    }
}
