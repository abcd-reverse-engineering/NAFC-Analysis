package com.umeng.socialize.net.dplus;

import a.a.u.a;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.hihonor.honorid.core.data.UserInfo;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UMAuthUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DplusApi {
    private static final String FULL = "false";
    private static final String SIMPLE = "true";
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructAuthContent(Map<String, String> map, boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            jSONObjectConstructBaseContent.put(CommonNetImpl.AM, share_media.getsharestyle(z));
            if (share_media.toString().equals("WEIXIN")) {
                jSONObjectConstructBaseContent.put("uid", map.get("openid"));
            } else {
                jSONObjectConstructBaseContent.put("uid", map.get("uid"));
            }
            jSONObjectConstructBaseContent.put("unionid", map.get("unionid"));
            jSONObjectConstructBaseContent.put(CommonNetImpl.AID, map.get(CommonNetImpl.AID));
            jSONObjectConstructBaseContent.put(CommonNetImpl.AS, map.get(CommonNetImpl.AS));
            if (TextUtils.isEmpty(map.get("access_token"))) {
                jSONObjectConstructBaseContent.put("at", map.get("accessToken"));
            } else {
                jSONObjectConstructBaseContent.put("at", map.get("access_token"));
            }
        }
        return jSONObjectConstructBaseContent;
    }

    private static JSONObject constructBaseContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String string = share_media.toString();
        jSONObject.put("pf", share_media.getName());
        if ((string.equals(SHARE_MEDIA.QQ.toString()) || string.equals(SHARE_MEDIA.QZONE.toString())) && Config.isUmengQQ.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, "true");
        } else if ((string.equals(SHARE_MEDIA.WEIXIN.toString()) || string.equals(SHARE_MEDIA.WEIXIN_CIRCLE.toString()) || string.equals(SHARE_MEDIA.WEIXIN_FAVORITE.toString())) && Config.isUmengWx.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, "true");
        } else {
            jSONObject.put(CommonNetImpl.SDKT, "false");
        }
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("tag", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructDauContent() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put(CommonNetImpl.SHARETYPE, Config.shareType);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructShareContent(ShareContent shareContent, boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        String strSubstring = shareContent.mText;
        jSONObjectConstructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        jSONObjectConstructBaseContent.put(CommonNetImpl.SM, share_media.getsharestyle(z));
        if (!TextUtils.isEmpty(strSubstring) && strSubstring.length() > 10240) {
            strSubstring = strSubstring.substring(0, 10240);
        }
        if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
            UMImage uMImage = (UMImage) shareContent.mMedia;
            if (uMImage != null) {
                if (uMImage.isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMImage.asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMImage.toByte())));
                }
            }
            jSONObjectConstructBaseContent.put("ct", strSubstring);
        } else if (shareContent.getShareType() == 1) {
            jSONObjectConstructBaseContent.put("ct", strSubstring);
        } else if (shareContent.getShareType() == 8) {
            UMVideo uMVideo = (UMVideo) shareContent.mMedia;
            if (uMVideo.getThumbImage() != null) {
                if (uMVideo.getThumbImage().isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMVideo.getThumbImage().asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMVideo.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                jSONObjectConstructBaseContent.put("ct", strSubstring);
            } else {
                jSONObjectConstructBaseContent.put("ct", uMVideo.getDescription());
            }
            jSONObjectConstructBaseContent.put("title", uMVideo.getTitle());
            jSONObjectConstructBaseContent.put("url", uMVideo.toUrl());
        } else if (shareContent.getShareType() == 4) {
            UMusic uMusic = (UMusic) shareContent.mMedia;
            if (uMusic.getThumbImage() != null) {
                if (uMusic.getThumbImage().isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMusic.getThumbImage().asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMusic.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                jSONObjectConstructBaseContent.put("ct", strSubstring);
            } else {
                jSONObjectConstructBaseContent.put("ct", uMusic.getDescription());
            }
            jSONObjectConstructBaseContent.put("title", uMusic.getTitle());
            jSONObjectConstructBaseContent.put(CommonNetImpl.DURL, uMusic.toUrl());
            jSONObjectConstructBaseContent.put("url", uMusic.getmTargetUrl());
        } else if (shareContent.getShareType() == 32) {
            jSONObjectConstructBaseContent.put("ct", strSubstring);
        } else if (shareContent.getShareType() == 64) {
            UMEmoji uMEmoji = (UMEmoji) shareContent.mMedia;
            if (uMEmoji != null) {
                if (uMEmoji.isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMEmoji.asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.md5(uMEmoji.toByte()));
                }
            }
            jSONObjectConstructBaseContent.put("ct", strSubstring);
        } else if (shareContent.getShareType() == 128) {
            UMMin uMMin = (UMMin) shareContent.mMedia;
            if (uMMin.getThumbImage() != null) {
                if (uMMin.getThumbImage().isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMMin.getThumbImage().asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMMin.getThumbImage().toByte())));
                }
            }
            jSONObjectConstructBaseContent.put("ct", uMMin.getDescription());
            jSONObjectConstructBaseContent.put("title", uMMin.getTitle());
            jSONObjectConstructBaseContent.put("url", uMMin.toUrl());
            jSONObjectConstructBaseContent.put(CommonNetImpl.M_P, uMMin.getPath());
            jSONObjectConstructBaseContent.put(CommonNetImpl.M_U, uMMin.getUserName());
        } else if (shareContent.getShareType() == 256) {
            UMQQMini uMQQMini = (UMQQMini) shareContent.mMedia;
            if (uMQQMini.getThumbImage() != null) {
                if (uMQQMini.getThumbImage().isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMQQMini.getThumbImage().asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMQQMini.getThumbImage().toByte())));
                }
            }
            jSONObjectConstructBaseContent.put("ct", uMQQMini.getDescription());
            jSONObjectConstructBaseContent.put("title", uMQQMini.getTitle());
            jSONObjectConstructBaseContent.put("url", uMQQMini.toUrl());
            jSONObjectConstructBaseContent.put(CommonNetImpl.M_P, uMQQMini.getPath());
            jSONObjectConstructBaseContent.put(CommonNetImpl.M_U, uMQQMini.getMiniAppId());
        } else if (shareContent.getShareType() == 16) {
            UMWeb uMWeb = (UMWeb) shareContent.mMedia;
            if (uMWeb.getThumbImage() != null) {
                if (uMWeb.getThumbImage().isUrlMedia()) {
                    jSONObjectConstructBaseContent.put("picurl", uMWeb.getThumbImage().asUrlImage());
                } else {
                    jSONObjectConstructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMWeb.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                jSONObjectConstructBaseContent.put("ct", strSubstring);
            } else {
                jSONObjectConstructBaseContent.put("ct", uMWeb.getDescription());
            }
            jSONObjectConstructBaseContent.put("title", uMWeb.getTitle());
            jSONObjectConstructBaseContent.put("url", uMWeb.toUrl());
        }
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_E);
        jSONObjectConstructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObjectConstructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthStartContent(boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_S);
        jSONObjectConstructBaseContent.put(CommonNetImpl.AM, share_media.getsharestyle(z));
        return jSONObjectConstructBaseContent;
    }

    private static JSONObject constructStatsDauContent(Map<String, String> map, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommonNetImpl.NAME, CommonNetImpl.S_DAU);
        jSONObject.put(CommonNetImpl.A_B, i2);
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(map.get("position")) && !TextUtils.isEmpty(map.get(CommonNetImpl.MENUBG))) {
                jSONObject2.put("position", map.get("position"));
                jSONObject2.put(CommonNetImpl.MENUBG, map.get(CommonNetImpl.MENUBG));
                jSONObject.put(CommonNetImpl.S_I, jSONObject2);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_E);
        jSONObjectConstructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObjectConstructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoStartContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_S);
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareContent(ShareContent shareContent, boolean z, SHARE_MEDIA share_media, boolean z2, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_S);
        jSONObjectConstructBaseContent.put(CommonNetImpl.U_C, z2 + "");
        jSONObjectConstructBaseContent.put(CommonNetImpl.SM, share_media.getsharestyle(z));
        jSONObjectConstructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_E);
        jSONObjectConstructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            jSONObjectConstructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return jSONObjectConstructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructUserInfoContent(Map<String, String> map, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            jSONObjectConstructBaseContent.put(CommonNetImpl.UN, map.get(CommonNetImpl.NAME));
            jSONObjectConstructBaseContent.put(CommonNetImpl.UP, map.get("iconurl"));
            jSONObjectConstructBaseContent.put(CommonNetImpl.SEX, map.get(UserInfo.GENDER));
            if (TextUtils.isEmpty(map.get("location"))) {
                jSONObjectConstructBaseContent.put(CommonNetImpl.REGION, map.get(UserInfo.CITY));
            } else {
                jSONObjectConstructBaseContent.put(CommonNetImpl.REGION, map.get("location"));
            }
            if (share_media.toString().equals("WEIXIN")) {
                jSONObjectConstructBaseContent.put("uid", map.get("openid"));
            } else {
                jSONObjectConstructBaseContent.put("uid", map.get("uid"));
            }
            if (SHARE_MEDIA.BYTEDANCE == share_media) {
                String str2 = map.get("encrypt_mobile");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObjectConstructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str2, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.BYTEDANCE)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else if (SHARE_MEDIA.HONOR == share_media) {
                String str3 = map.get("mobileNumber");
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        jSONObjectConstructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str3, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.HONOR)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            jSONObjectConstructBaseContent.put("unionid", map.get("unionid"));
            jSONObjectConstructBaseContent.put("ts", System.currentTimeMillis());
        }
        return jSONObjectConstructBaseContent;
    }

    public static JSONObject getFakeData() throws JSONException {
        JSONObject jSONObjectConstructBaseContent = constructBaseContent(SHARE_MEDIA.SINA, a.n);
        jSONObjectConstructBaseContent.put(CommonNetImpl.NAME, "testetstttttttttttttttttttttttttttttttt");
        jSONObjectConstructBaseContent.put(CommonNetImpl.U_C, true);
        jSONObjectConstructBaseContent.put(CommonNetImpl.SM, "sso");
        jSONObjectConstructBaseContent.put(CommonNetImpl.STYPE, 0);
        return jSONObjectConstructBaseContent;
    }

    public static void uploadAuth(final Context context, final Map<String, String> map, final boolean z, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.AUTH_EVENT, CommonNetImpl.get(context), DplusApi.constructAuthContent(map, z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadAuthStart(final Context context, final boolean z, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsAuthStartContent(z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadAuthend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsAuthEndContent(share_media, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadDAU(final Context context) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.DAU_EVENT, CommonNetImpl.get(context), DplusApi.constructDauContent());
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadInfoStart(final Context context, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsInfoStartContent(share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadInfoend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsInfoEndContent(share_media, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadShare(final Context context, final ShareContent shareContent, final boolean z, final SHARE_MEDIA share_media, final String str, final boolean z2) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SHARE_EVENT, CommonNetImpl.get(context), DplusApi.constructShareContent(shareContent, z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsShareContent(shareContent, z, share_media, z2, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadStatsDAU(Context context, Map<String, String> map, int i2) {
    }

    public static void uploadStatsShareEnd(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsShareEndContent(share_media, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadUserInfo(final Context context, final Map<String, String> map, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.GET_EVENT, CommonNetImpl.get(context), DplusApi.constructUserInfoContent(map, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }
}
