package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LinkcardRequest extends SocializeRequest {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11744a = "/share/linkcard/";

    /* renamed from: b, reason: collision with root package name */
    private String f11745b;

    /* renamed from: c, reason: collision with root package name */
    private BaseMediaObject f11746c;

    public LinkcardRequest(Context context) {
        super(context, "", LinkCardResponse.class, 0, URequest.RequestMethod.POST);
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("display_name", this.f11746c.getTitle());
            jSONObject.put("image", f());
            jSONObject.put("summary", d());
            jSONObject.put(SocializeProtocolConstants.FULL_IMAGE, h());
            jSONObject.put("url", this.f11746c.toUrl());
            jSONObject.put(SocializeProtocolConstants.LINKS, i());
            jSONObject.put(SocializeProtocolConstants.TAGS, e());
            jSONObject.put(SocializeProtocolConstants.CREATE_AT, c());
            jSONObject.put(SocializeProtocolConstants.OBJECT_TYPE, b());
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    private String b() {
        BaseMediaObject baseMediaObject = this.f11746c;
        return baseMediaObject instanceof UMWeb ? "webpage" : baseMediaObject instanceof UMVideo ? "video" : baseMediaObject instanceof UMusic ? "audio" : "webpage";
    }

    private String c() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    private String d() {
        return (TextUtils.isEmpty(this.f11746c.getDescription()) || this.f11746c.getDescription().length() <= 300) ? this.f11746c.getDescription() : this.f11746c.getDescription().substring(0, 300);
    }

    private JSONArray e() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("display_name", Config.Descriptor);
            jSONArray.put(jSONObject);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONArray;
    }

    private JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f11746c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] iArrG = g();
            jSONObject.put(SocializeProtocolConstants.WIDTH, iArrG[0]);
            jSONObject.put(SocializeProtocolConstants.HEIGHT, iArrG[1]);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    private int[] g() {
        int[] iArr = {120, 120};
        BaseMediaObject baseMediaObject = this.f11746c;
        if (baseMediaObject != null && baseMediaObject.getmExtra() != null) {
            Map<String, Object> map = this.f11746c.getmExtra();
            if (map.containsKey(SocializeProtocolConstants.WIDTH)) {
                iArr[0] = ((Integer) map.get(SocializeProtocolConstants.WIDTH)).intValue();
            }
            if (map.containsKey(SocializeProtocolConstants.HEIGHT)) {
                iArr[1] = ((Integer) map.get(SocializeProtocolConstants.HEIGHT)).intValue();
            }
        }
        return iArr;
    }

    private JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            UMImage thumbImage = this.f11746c.getThumbImage();
            if (thumbImage == null || !thumbImage.isUrlMedia()) {
                jSONObject.put("url", "https://mobile.umeng.com/images/pic/home/social/img-1.png");
            } else {
                jSONObject.put("url", thumbImage.asUrlImage());
            }
            int[] iArrG = g();
            jSONObject.put(SocializeProtocolConstants.WIDTH, iArrG[0]);
            jSONObject.put(SocializeProtocolConstants.HEIGHT, iArrG[1]);
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    private JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f11746c.toUrl());
        } catch (JSONException e2) {
            SLog.error(e2);
        }
        return jSONObject;
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest
    protected String getPath() {
        return f11744a + SocializeUtils.getAppkey(this.mContext) + "/" + Config.EntityKey + "/";
    }

    @Override // com.umeng.socialize.net.base.SocializeRequest, com.umeng.socialize.net.utils.URequest
    public void onPrepareRequest() {
        super.onPrepareRequest();
        addStringParams("linkcard_info", a().toString());
    }

    public void setMedia(BaseMediaObject baseMediaObject) {
        this.f11746c = baseMediaObject;
    }
}
