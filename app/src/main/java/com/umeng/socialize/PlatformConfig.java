package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PlatformConfig {
    public static Map<SHARE_MEDIA, Platform> configs = new HashMap();
    private static String sFileProvider;

    public static class APPIDPlatform implements Platform {
        private SHARE_MEDIA p;
        public String appId = null;
        public String appkey = null;
        public String redirectUrl = null;
        public String fileProvider = null;
        public String click_key = null;
        public String agentId = null;
        public String schema = null;

        public APPIDPlatform(SHARE_MEDIA share_media) {
            this.p = share_media;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppSecret() {
            return this.appkey;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppid() {
            return this.appId;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getClick_key() {
            return this.click_key;
        }

        public String getFileProvider() {
            String str = this.fileProvider;
            return str != null ? str : PlatformConfig.sFileProvider;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public SHARE_MEDIA getName() {
            return this.p;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public boolean isConfigured() {
            return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appkey)) ? false : true;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public void parse(JSONObject jSONObject) {
        }

        public void setFileProvider(String str) {
            this.fileProvider = str;
        }
    }

    public static class CustomPlatform implements Platform {
        public static final String Name = "g+";
        public String appId = null;
        public String appkey = null;
        public String click_key = null;
        private SHARE_MEDIA p;

        public CustomPlatform(SHARE_MEDIA share_media) {
            this.p = share_media;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppSecret() {
            return this.appkey;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getAppid() {
            return this.appId;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public String getClick_key() {
            return this.click_key;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public SHARE_MEDIA getName() {
            return this.p;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public boolean isConfigured() {
            return true;
        }

        @Override // com.umeng.socialize.PlatformConfig.Platform
        public void parse(JSONObject jSONObject) {
        }
    }

    public interface Platform {
        String getAppSecret();

        String getAppid();

        String getClick_key();

        SHARE_MEDIA getName();

        boolean isConfigured();

        void parse(JSONObject jSONObject);
    }

    static {
        Map<SHARE_MEDIA, Platform> map = configs;
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        map.put(share_media, new APPIDPlatform(share_media));
        Map<SHARE_MEDIA, Platform> map2 = configs;
        SHARE_MEDIA share_media2 = SHARE_MEDIA.QZONE;
        map2.put(share_media2, new APPIDPlatform(share_media2));
        Map<SHARE_MEDIA, Platform> map3 = configs;
        SHARE_MEDIA share_media3 = SHARE_MEDIA.WEIXIN;
        map3.put(share_media3, new APPIDPlatform(share_media3));
        configs.put(SHARE_MEDIA.VKONTAKTE, new APPIDPlatform(SHARE_MEDIA.WEIXIN));
        Map<SHARE_MEDIA, Platform> map4 = configs;
        SHARE_MEDIA share_media4 = SHARE_MEDIA.WEIXIN_CIRCLE;
        map4.put(share_media4, new APPIDPlatform(share_media4));
        Map<SHARE_MEDIA, Platform> map5 = configs;
        SHARE_MEDIA share_media5 = SHARE_MEDIA.WEIXIN_FAVORITE;
        map5.put(share_media5, new APPIDPlatform(share_media5));
        Map<SHARE_MEDIA, Platform> map6 = configs;
        SHARE_MEDIA share_media6 = SHARE_MEDIA.WXWORK;
        map6.put(share_media6, new APPIDPlatform(share_media6));
        Map<SHARE_MEDIA, Platform> map7 = configs;
        SHARE_MEDIA share_media7 = SHARE_MEDIA.FACEBOOK_MESSAGER;
        map7.put(share_media7, new CustomPlatform(share_media7));
        Map<SHARE_MEDIA, Platform> map8 = configs;
        SHARE_MEDIA share_media8 = SHARE_MEDIA.DOUBAN;
        map8.put(share_media8, new CustomPlatform(share_media8));
        Map<SHARE_MEDIA, Platform> map9 = configs;
        SHARE_MEDIA share_media9 = SHARE_MEDIA.YIXIN;
        map9.put(share_media9, new APPIDPlatform(share_media9));
        Map<SHARE_MEDIA, Platform> map10 = configs;
        SHARE_MEDIA share_media10 = SHARE_MEDIA.YIXIN_CIRCLE;
        map10.put(share_media10, new APPIDPlatform(share_media10));
        Map<SHARE_MEDIA, Platform> map11 = configs;
        SHARE_MEDIA share_media11 = SHARE_MEDIA.SINA;
        map11.put(share_media11, new APPIDPlatform(share_media11));
        Map<SHARE_MEDIA, Platform> map12 = configs;
        SHARE_MEDIA share_media12 = SHARE_MEDIA.ALIPAY;
        map12.put(share_media12, new APPIDPlatform(share_media12));
        Map<SHARE_MEDIA, Platform> map13 = configs;
        SHARE_MEDIA share_media13 = SHARE_MEDIA.DROPBOX;
        map13.put(share_media13, new APPIDPlatform(share_media13));
        Map<SHARE_MEDIA, Platform> map14 = configs;
        SHARE_MEDIA share_media14 = SHARE_MEDIA.FACEBOOK;
        map14.put(share_media14, new CustomPlatform(share_media14));
        Map<SHARE_MEDIA, Platform> map15 = configs;
        SHARE_MEDIA share_media15 = SHARE_MEDIA.TWITTER;
        map15.put(share_media15, new APPIDPlatform(share_media15));
        Map<SHARE_MEDIA, Platform> map16 = configs;
        SHARE_MEDIA share_media16 = SHARE_MEDIA.TUMBLR;
        map16.put(share_media16, new CustomPlatform(share_media16));
        Map<SHARE_MEDIA, Platform> map17 = configs;
        SHARE_MEDIA share_media17 = SHARE_MEDIA.PINTEREST;
        map17.put(share_media17, new APPIDPlatform(share_media17));
        Map<SHARE_MEDIA, Platform> map18 = configs;
        SHARE_MEDIA share_media18 = SHARE_MEDIA.POCKET;
        map18.put(share_media18, new CustomPlatform(share_media18));
        Map<SHARE_MEDIA, Platform> map19 = configs;
        SHARE_MEDIA share_media19 = SHARE_MEDIA.WHATSAPP;
        map19.put(share_media19, new CustomPlatform(share_media19));
        Map<SHARE_MEDIA, Platform> map20 = configs;
        SHARE_MEDIA share_media20 = SHARE_MEDIA.EMAIL;
        map20.put(share_media20, new CustomPlatform(share_media20));
        Map<SHARE_MEDIA, Platform> map21 = configs;
        SHARE_MEDIA share_media21 = SHARE_MEDIA.SMS;
        map21.put(share_media21, new CustomPlatform(share_media21));
        Map<SHARE_MEDIA, Platform> map22 = configs;
        SHARE_MEDIA share_media22 = SHARE_MEDIA.LINKEDIN;
        map22.put(share_media22, new CustomPlatform(share_media22));
        Map<SHARE_MEDIA, Platform> map23 = configs;
        SHARE_MEDIA share_media23 = SHARE_MEDIA.LINE;
        map23.put(share_media23, new CustomPlatform(share_media23));
        Map<SHARE_MEDIA, Platform> map24 = configs;
        SHARE_MEDIA share_media24 = SHARE_MEDIA.FLICKR;
        map24.put(share_media24, new CustomPlatform(share_media24));
        Map<SHARE_MEDIA, Platform> map25 = configs;
        SHARE_MEDIA share_media25 = SHARE_MEDIA.EVERNOTE;
        map25.put(share_media25, new CustomPlatform(share_media25));
        Map<SHARE_MEDIA, Platform> map26 = configs;
        SHARE_MEDIA share_media26 = SHARE_MEDIA.FOURSQUARE;
        map26.put(share_media26, new CustomPlatform(share_media26));
        Map<SHARE_MEDIA, Platform> map27 = configs;
        SHARE_MEDIA share_media27 = SHARE_MEDIA.YNOTE;
        map27.put(share_media27, new CustomPlatform(share_media27));
        Map<SHARE_MEDIA, Platform> map28 = configs;
        SHARE_MEDIA share_media28 = SHARE_MEDIA.KAKAO;
        map28.put(share_media28, new APPIDPlatform(share_media28));
        Map<SHARE_MEDIA, Platform> map29 = configs;
        SHARE_MEDIA share_media29 = SHARE_MEDIA.INSTAGRAM;
        map29.put(share_media29, new CustomPlatform(share_media29));
        Map<SHARE_MEDIA, Platform> map30 = configs;
        SHARE_MEDIA share_media30 = SHARE_MEDIA.MORE;
        map30.put(share_media30, new CustomPlatform(share_media30));
        configs.put(SHARE_MEDIA.DINGTALK, new APPIDPlatform(SHARE_MEDIA.MORE));
        Map<SHARE_MEDIA, Platform> map31 = configs;
        SHARE_MEDIA share_media31 = SHARE_MEDIA.BYTEDANCE;
        map31.put(share_media31, new APPIDPlatform(share_media31));
        Map<SHARE_MEDIA, Platform> map32 = configs;
        SHARE_MEDIA share_media32 = SHARE_MEDIA.BYTEDANCE_PUBLISH;
        map32.put(share_media32, new APPIDPlatform(share_media32));
        Map<SHARE_MEDIA, Platform> map33 = configs;
        SHARE_MEDIA share_media33 = SHARE_MEDIA.BYTEDANCE_FRIENDS;
        map33.put(share_media33, new APPIDPlatform(share_media33));
        Map<SHARE_MEDIA, Platform> map34 = configs;
        SHARE_MEDIA share_media34 = SHARE_MEDIA.HONOR;
        map34.put(share_media34, new APPIDPlatform(share_media34));
    }

    public static void disableAndroidId() {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("disableAidCollect", new Class[0])) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getFileProvider() {
        return sFileProvider;
    }

    public static Platform getPlatform(SHARE_MEDIA share_media) {
        return configs.get(share_media);
    }

    public static void setAlipay(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.ALIPAY)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setBytedance(String str, String str2, String str3, String str4) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.click_key = str2.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str3.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.setFileProvider(str4.replace(c.c.a.b.a.a.f3100g, ""));
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE_PUBLISH);
        aPPIDPlatform2.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform2.click_key = str2.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform2.appkey = str3.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform2.setFileProvider(str4.replace(c.c.a.b.a.a.f3100g, ""));
        APPIDPlatform aPPIDPlatform3 = (APPIDPlatform) configs.get(SHARE_MEDIA.BYTEDANCE_FRIENDS);
        aPPIDPlatform3.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform3.click_key = str2.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform3.appkey = str3.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform3.setFileProvider(str4.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str4);
    }

    public static void setDing(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.DINGTALK)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
    }

    @Deprecated
    public static void setDingFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.DINGTALK)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str);
    }

    public static void setDropbox(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.DROPBOX);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setFileProvider(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sFileProvider = str;
    }

    public static void setHonor(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.HONOR);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setHonorRedirectUrl(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.HONOR)).redirectUrl = str;
    }

    public static void setKakao(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.KAKAO)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setPinterest(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.PINTEREST)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
    }

    @Deprecated
    public static void setQQFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.QZONE)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.QQ)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str);
    }

    public static void setQQZone(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.QZONE);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.QQ);
        aPPIDPlatform2.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform2.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    @Deprecated
    public static void setSinaFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.SINA)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str);
    }

    public static void setSinaWeibo(String str, String str2, String str3) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.SINA);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.redirectUrl = str3;
    }

    public static void setTwitter(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.TWITTER);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setVKontakte(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.VKONTAKTE);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    @Deprecated
    public static void setWXFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_CIRCLE)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_FAVORITE)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str);
    }

    public static void setWXWork(String str, String str2, String str3, String str4) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WXWORK);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.agentId = str3.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.schema = str4.replace(c.c.a.b.a.a.f3100g, "");
    }

    @Deprecated
    public static void setWXWorkFileProvider(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.WXWORK)).setFileProvider(str.replace(c.c.a.b.a.a.f3100g, ""));
        setFileProvider(str);
    }

    public static void setWeixin(String str, String str2) {
        APPIDPlatform aPPIDPlatform = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN);
        aPPIDPlatform.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
        APPIDPlatform aPPIDPlatform2 = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_CIRCLE);
        aPPIDPlatform2.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform2.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
        APPIDPlatform aPPIDPlatform3 = (APPIDPlatform) configs.get(SHARE_MEDIA.WEIXIN_FAVORITE);
        aPPIDPlatform3.appId = str.replace(c.c.a.b.a.a.f3100g, "");
        aPPIDPlatform3.appkey = str2.replace(c.c.a.b.a.a.f3100g, "");
    }

    public static void setYixin(String str) {
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
        ((APPIDPlatform) configs.get(SHARE_MEDIA.YIXIN_CIRCLE)).appId = str.replace(c.c.a.b.a.a.f3100g, "");
    }
}
