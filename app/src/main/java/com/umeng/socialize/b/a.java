package com.umeng.socialize.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.handler.UMMoreHandler;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.net.analytics.SocialAnalytics;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.dplus.cache1.DplusCacheApi;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.umeng.socialize.utils.UrlUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: SocialRouter.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f11579b = "umeng_share_platform";

    /* renamed from: c, reason: collision with root package name */
    private static final String f11580c = "share_action";

    /* renamed from: a, reason: collision with root package name */
    private SHARE_MEDIA f11581a;

    /* renamed from: d, reason: collision with root package name */
    private final Map<SHARE_MEDIA, UMSSOHandler> f11582d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<Pair<SHARE_MEDIA, String>> f11583e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final C0156a f11584f;

    /* renamed from: g, reason: collision with root package name */
    private Context f11585g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray<UMAuthListener> f11586h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray<UMShareListener> f11587i;

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<UMAuthListener> f11588j;

    public a(Context context) {
        List<Pair<SHARE_MEDIA, String>> list = this.f11583e;
        list.add(Pair.create(SHARE_MEDIA.SINA, "com.umeng.socialize.handler.SinaSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.QQ, "com.umeng.socialize.handler.UMQQSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.QZONE, "com.umeng.socialize.handler.QZoneSsoHandler"));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN, "com.umeng.socialize.handler.UMWXHandler"));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN_CIRCLE, ""));
        list.add(Pair.create(SHARE_MEDIA.WEIXIN_FAVORITE, ""));
        list.add(Pair.create(SHARE_MEDIA.PINTEREST, "com.umeng.socialize.handler.UMPinterestHandler"));
        list.add(Pair.create(SHARE_MEDIA.WXWORK, "com.umeng.socialize.handler.UMWXWorkHandler"));
        list.add(Pair.create(SHARE_MEDIA.YIXIN, "com.umeng.socialize.handler.UMYXHandler"));
        list.add(Pair.create(SHARE_MEDIA.YIXIN_CIRCLE, ""));
        list.add(Pair.create(SHARE_MEDIA.EMAIL, "com.umeng.socialize.handler.EmailHandler"));
        list.add(Pair.create(SHARE_MEDIA.EVERNOTE, "com.umeng.socialize.handler.UMEvernoteHandler"));
        list.add(Pair.create(SHARE_MEDIA.FACEBOOK, "com.umeng.socialize.handler.UMFacebookHandler"));
        list.add(Pair.create(SHARE_MEDIA.FACEBOOK_MESSAGER, ""));
        list.add(Pair.create(SHARE_MEDIA.FLICKR, "com.umeng.socialize.handler.UMFlickrHandler"));
        list.add(Pair.create(SHARE_MEDIA.FOURSQUARE, "com.umeng.socialize.handler.UMFourSquareHandler"));
        list.add(Pair.create(SHARE_MEDIA.INSTAGRAM, "com.umeng.socialize.handler.UMInstagramHandler"));
        list.add(Pair.create(SHARE_MEDIA.KAKAO, "com.umeng.socialize.handler.UMKakaoHandler"));
        list.add(Pair.create(SHARE_MEDIA.LINE, "com.umeng.socialize.handler.UMLineHandler"));
        list.add(Pair.create(SHARE_MEDIA.LINKEDIN, "com.umeng.socialize.handler.UMLinkedInHandler"));
        list.add(Pair.create(SHARE_MEDIA.POCKET, "com.umeng.socialize.handler.UMPocketHandler"));
        list.add(Pair.create(SHARE_MEDIA.WHATSAPP, "com.umeng.socialize.handler.UMWhatsAppHandler"));
        list.add(Pair.create(SHARE_MEDIA.YNOTE, "com.umeng.socialize.handler.UMYNoteHandler"));
        list.add(Pair.create(SHARE_MEDIA.SMS, "com.umeng.socialize.handler.SmsHandler"));
        list.add(Pair.create(SHARE_MEDIA.DOUBAN, "com.umeng.socialize.handler.DoubanHandler"));
        list.add(Pair.create(SHARE_MEDIA.TUMBLR, "com.umeng.socialize.handler.UMTumblrHandler"));
        list.add(Pair.create(SHARE_MEDIA.TWITTER, "com.umeng.socialize.handler.TwitterHandler"));
        list.add(Pair.create(SHARE_MEDIA.ALIPAY, "com.umeng.socialize.handler.AlipayHandler"));
        list.add(Pair.create(SHARE_MEDIA.MORE, "com.umeng.socialize.handler.UMMoreHandler"));
        list.add(Pair.create(SHARE_MEDIA.DINGTALK, "com.umeng.socialize.handler.UMDingSSoHandler"));
        list.add(Pair.create(SHARE_MEDIA.VKONTAKTE, "com.umeng.socialize.handler.UMVKHandler"));
        list.add(Pair.create(SHARE_MEDIA.DROPBOX, "com.umeng.socialize.handler.UMDropBoxHandler"));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE, "com.umeng.socialize.handler.UMDYHandler"));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE_PUBLISH, ""));
        list.add(Pair.create(SHARE_MEDIA.BYTEDANCE_FRIENDS, ""));
        list.add(Pair.create(SHARE_MEDIA.HONOR, "com.umeng.socialize.handler.UMHonorHandler"));
        this.f11584f = new C0156a(this.f11582d);
        this.f11586h = new SparseArray<>();
        this.f11587i = new SparseArray<>();
        this.f11588j = new SparseArray<>();
        this.f11585g = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMShareListener e(int i2) {
        UMShareListener uMShareListener;
        uMShareListener = this.f11587i.get(i2, null);
        if (uMShareListener != null) {
            this.f11587i.remove(i2);
        }
        return uMShareListener;
    }

    public boolean d(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f11584f.a(activity, share_media)) {
            return false;
        }
        this.f11582d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f11582d.get(share_media).isAuthorize();
    }

    private void b(Context context) throws PackageManager.NameNotFoundException {
        String appkey = SocializeUtils.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_NO_APPKEY));
        }
        if (SocializeNetUtils.isConSpeCharacters(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
        if (SocializeNetUtils.isSelfAppkey(appkey)) {
            throw new SocializeException(UmengText.errorWithUrl(UmengText.CHECK.APPKEY_NOT_FOUND, UrlUtil.ALL_ERROR_APPKEY));
        }
    }

    public String c(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f11584f.a(activity, share_media)) {
            return "";
        }
        this.f11582d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f11582d.get(share_media).getSDKVersion();
    }

    public void a(Context context) {
        if (context != null) {
            this.f11585g = context.getApplicationContext();
        }
    }

    private UMSSOHandler a(String str) {
        try {
            return (UMSSOHandler) Class.forName(str).newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener d(int i2) {
        UMAuthListener uMAuthListener;
        uMAuthListener = this.f11588j.get(i2, null);
        if (uMAuthListener != null) {
            this.f11588j.remove(i2);
        }
        return uMAuthListener;
    }

    public UMSSOHandler a(SHARE_MEDIA share_media) {
        UMSSOHandler uMSSOHandler = this.f11582d.get(share_media);
        if (uMSSOHandler != null) {
            uMSSOHandler.onCreate(this.f11585g, PlatformConfig.getPlatform(share_media));
        }
        return uMSSOHandler;
    }

    public void c(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f11584f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f11582d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.authstart(ContextUtil.getContext(), share_media, uMSSOHandler.getSDKVersion(), uMSSOHandler.isInstall(), strValueOf);
            }
            int iOrdinal = share_media.ordinal();
            a(iOrdinal, uMAuthListener);
            UMAuthListener uMAuthListenerA = a(iOrdinal, strValueOf, uMSSOHandler.isInstall());
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.authorize(uMAuthListenerA);
            this.f11581a = share_media;
        }
    }

    /* compiled from: SocialRouter.java */
    /* renamed from: com.umeng.socialize.b.a$a, reason: collision with other inner class name */
    private static class C0156a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<SHARE_MEDIA, UMSSOHandler> f11647a;

        public C0156a(Map<SHARE_MEDIA, UMSSOHandler> map) {
            this.f11647a = map;
        }

        private boolean a(Context context) {
            return context != null;
        }

        public boolean a(Context context, SHARE_MEDIA share_media) {
            if (CommonUtil.isSilentMode(context) || !a(context) || !a(share_media)) {
                return false;
            }
            if (this.f11647a.get(share_media).isSupportAuth()) {
                return true;
            }
            SLog.E(share_media.toString() + UmengText.AUTH.NOT_SUPPORT_PLATFROM);
            return false;
        }

        public boolean a(ShareAction shareAction, Activity activity) {
            SHARE_MEDIA platform;
            if (CommonUtil.isSilentMode(activity) || (platform = shareAction.getPlatform()) == null) {
                return false;
            }
            if ((platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ) && !PlatformConfig.configs.get(platform).isConfigured()) {
                SLog.E(UmengText.CHECK.noKey(platform));
                return false;
            }
            return a(platform);
        }

        private boolean a(SHARE_MEDIA share_media) {
            if (this.f11647a.get(share_media) != null) {
                return true;
            }
            SLog.mutlE(UmengText.CHECK.noJar(share_media), UrlUtil.ALL_NO_JAR);
            return false;
        }
    }

    public void a(int i2, int i3, Intent intent) {
        UMSSOHandler uMSSOHandlerA = a(i2);
        if (uMSSOHandlerA != null) {
            uMSSOHandlerA.onActivityResult(i2, i3, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        UMSSOHandler uMSSOHandlerA;
        for (Pair<SHARE_MEDIA, String> pair : this.f11583e) {
            Object obj = pair.first;
            if (obj == SHARE_MEDIA.WEIXIN_CIRCLE) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.WEIXIN_FAVORITE) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.WEIXIN);
            } else if (obj == SHARE_MEDIA.FACEBOOK_MESSAGER) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.FACEBOOK);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_PUBLISH) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.BYTEDANCE_FRIENDS) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.BYTEDANCE);
            } else if (obj == SHARE_MEDIA.YIXIN_CIRCLE) {
                uMSSOHandlerA = this.f11582d.get(SHARE_MEDIA.YIXIN);
            } else if (obj == SHARE_MEDIA.MORE) {
                uMSSOHandlerA = new UMMoreHandler();
            } else {
                uMSSOHandlerA = a((String) pair.second);
            }
            this.f11582d.put(pair.first, uMSSOHandlerA);
        }
    }

    @Deprecated
    public void a(Activity activity, int i2, UMAuthListener uMAuthListener) {
        UMSSOHandler uMSSOHandlerA = a(i2);
        if (uMSSOHandlerA != null) {
            if (i2 == 10103 || i2 == 11101) {
                uMSSOHandlerA.onCreate(activity, PlatformConfig.getPlatform(b(i2)));
                a(SHARE_MEDIA.QQ, uMAuthListener, uMSSOHandlerA, String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private UMSSOHandler a(int i2) {
        int i3 = 10103;
        if (i2 != 10103 && i2 != 11101) {
            i3 = i2;
        }
        if (i2 == 64207 || i2 == 64206 || i2 == 64208) {
            i3 = HandlerRequestCode.FACEBOOK_REQUEST_AUTH_CODE;
        }
        if (i2 == 32973 || i2 == 765) {
            i3 = 10001;
        }
        if (i2 == 5650) {
            i3 = HandlerRequestCode.SINA_REQUEST_CODE;
        }
        for (UMSSOHandler uMSSOHandler : this.f11582d.values()) {
            if (uMSSOHandler != null && i3 == uMSSOHandler.getRequestCode()) {
                return uMSSOHandler;
            }
        }
        return null;
    }

    public void a(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        if (this.f11584f.a(activity, share_media)) {
            if (uMAuthListener == null) {
                uMAuthListener = new UMAuthListener() { // from class: com.umeng.socialize.b.a.1
                    @Override // com.umeng.socialize.UMAuthListener
                    public void onCancel(SHARE_MEDIA share_media2, int i2) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onComplete(SHARE_MEDIA share_media2, int i2, Map<String, String> map) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onError(SHARE_MEDIA share_media2, int i2, Throwable th) {
                    }

                    @Override // com.umeng.socialize.UMAuthListener
                    public void onStart(SHARE_MEDIA share_media2) {
                    }
                };
            }
            this.f11582d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
            this.f11582d.get(share_media).deleteAuth(uMAuthListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized UMAuthListener c(int i2) {
        UMAuthListener uMAuthListener;
        this.f11581a = null;
        uMAuthListener = this.f11586h.get(i2, null);
        if (uMAuthListener != null) {
            this.f11586h.remove(i2);
        }
        return uMAuthListener;
    }

    public boolean a(Activity activity, SHARE_MEDIA share_media) {
        this.f11582d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f11582d.get(share_media).isInstall();
    }

    private synchronized void c() {
        this.f11586h.clear();
        this.f11587i.clear();
        this.f11588j.clear();
    }

    private UMAuthListener a(final int i2, final String str, final boolean z) {
        return new UMAuthListener() { // from class: com.umeng.socialize.b.a.5
            @Override // com.umeng.socialize.UMAuthListener
            public void onCancel(final SHARE_MEDIA share_media, final int i3) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener uMAuthListenerC = a.this.c(i2);
                            if (uMAuthListenerC != null) {
                                uMAuthListenerC.onCancel(share_media, i3);
                            }
                            if (ContextUtil.getContext() != null) {
                                SocialAnalytics.authendt(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, z, "", str, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onComplete(final SHARE_MEDIA share_media, final int i3, final Map<String, String> map) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener uMAuthListenerC = a.this.c(i2);
                            if (uMAuthListenerC != null) {
                                uMAuthListenerC.onComplete(share_media, i3, map);
                            }
                            if (ContextUtil.getContext() != null) {
                                SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "success", z, "", str, a.this.a(share_media, (Map<String, String>) map));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onError(final SHARE_MEDIA share_media, final int i3, final Throwable th) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener uMAuthListenerC = a.this.c(i2);
                            if (uMAuthListenerC != null) {
                                uMAuthListenerC.onError(share_media, i3, th);
                            }
                            if (th != null) {
                                SLog.E(th.getMessage());
                                SLog.runtimePrint(th.getMessage());
                            } else {
                                SLog.E(c.c.a.b.a.a.f3101h);
                                SLog.runtimePrint(c.c.a.b.a.a.f3101h);
                            }
                            if (ContextUtil.getContext() == null || th == null) {
                                return;
                            }
                            SocialAnalytics.authendt(ContextUtil.getContext(), share_media, "fail", z, th.getMessage(), str, null);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.umeng.socialize.UMAuthListener
            public void onStart(final SHARE_MEDIA share_media) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMAuthListener uMAuthListenerC = a.this.c(i2);
                            if (uMAuthListenerC != null) {
                                uMAuthListenerC.onStart(share_media);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(SHARE_MEDIA share_media, Map<String, String> map) {
        String click_key;
        String appSecret;
        String appid = "";
        if (PlatformConfig.getPlatform(share_media) != null) {
            appid = PlatformConfig.getPlatform(share_media).getAppid();
            appSecret = PlatformConfig.getPlatform(share_media).getAppSecret();
            click_key = PlatformConfig.getPlatform(share_media).getClick_key();
        } else {
            click_key = "";
            appSecret = click_key;
        }
        map.put(CommonNetImpl.AID, appid);
        map.put(CommonNetImpl.AS, appSecret);
        map.put("at", click_key);
        return map;
    }

    private SHARE_MEDIA b(int i2) {
        if (i2 == 10103 || i2 == 11101) {
            return SHARE_MEDIA.QQ;
        }
        if (i2 != 32973 && i2 != 765) {
            return SHARE_MEDIA.QQ;
        }
        return SHARE_MEDIA.SINA;
    }

    public void b(Activity activity, final SHARE_MEDIA share_media, final UMAuthListener uMAuthListener) {
        if (this.f11584f.a(activity, share_media)) {
            UMSSOHandler uMSSOHandler = this.f11582d.get(share_media);
            uMSSOHandler.onCreate(activity, PlatformConfig.getPlatform(share_media));
            final String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                SocialAnalytics.getInfostart(ContextUtil.getContext(), share_media, strValueOf);
            }
            final int iOrdinal = share_media.ordinal();
            b(iOrdinal, uMAuthListener);
            UMAuthListener uMAuthListener2 = new UMAuthListener() { // from class: com.umeng.socialize.b.a.2
                @Override // com.umeng.socialize.UMAuthListener
                public void onCancel(final SHARE_MEDIA share_media2, final int i2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                                if (uMAuthListenerD != null) {
                                    uMAuthListenerD.onCancel(share_media2, i2);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, CommonNetImpl.CANCEL, "", strValueOf, null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onComplete(final SHARE_MEDIA share_media2, final int i2, final Map<String, String> map) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                                if (uMAuthListenerD != null) {
                                    uMAuthListenerD.onComplete(share_media2, i2, map);
                                }
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "success", "", strValueOf, map);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onError(final SHARE_MEDIA share_media2, final int i2, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                                if (uMAuthListenerD != null) {
                                    uMAuthListenerD.onError(share_media2, i2, th);
                                }
                                if (th != null) {
                                    SLog.E(th.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                } else {
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_AUTHFAIL);
                                }
                                if (ContextUtil.getContext() == null || th == null) {
                                    return;
                                }
                                SocialAnalytics.getInfoendt(ContextUtil.getContext(), share_media2, "fail", th.getMessage(), strValueOf, null);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMAuthListener
                public void onStart(final SHARE_MEDIA share_media2) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMAuthListener uMAuthListenerD = a.this.d(iOrdinal);
                                if (uMAuthListenerD != null) {
                                    uMAuthListenerD.onStart(share_media2);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        uMAuthListener.onStart(share_media);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            uMSSOHandler.getPlatformInfo(uMAuthListener2);
        }
    }

    private void a(ShareAction shareAction) {
        ShareContent shareContent = shareAction.getShareContent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UmengText.SHARE.INFO);
        arrayList.add(UmengText.SHARE.SHAREPLAT + shareAction.getPlatform().toString());
        arrayList.add(UmengText.SHARE.SHARESTYLE + shareAction.getShareContent().getShareType());
        arrayList.add(UmengText.SHARE.SHARETEXT + shareContent.mText);
        UMediaObject uMediaObject = shareContent.mMedia;
        if (uMediaObject != null) {
            if (uMediaObject instanceof UMImage) {
                UMImage uMImage = (UMImage) uMediaObject;
                if (uMImage.isUrlMedia()) {
                    arrayList.add(UmengText.SHARE.URLIMAGE + uMImage.asUrlImage());
                } else {
                    byte[] bArrAsBinImage = uMImage.asBinImage();
                    StringBuilder sb = new StringBuilder();
                    sb.append(UmengText.SHARE.LOCALIMAGE);
                    sb.append(bArrAsBinImage == null ? 0 : bArrAsBinImage.length);
                    arrayList.add(sb.toString());
                }
                if (uMImage.getThumbImage() != null) {
                    UMImage thumbImage = uMImage.getThumbImage();
                    if (thumbImage.isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + thumbImage.asUrlImage());
                    } else {
                        byte[] bArrAsBinImage2 = thumbImage.asBinImage();
                        if (bArrAsBinImage2 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage2.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject2 = shareContent.mMedia;
            if (uMediaObject2 instanceof UMVideo) {
                UMVideo uMVideo = (UMVideo) uMediaObject2;
                arrayList.add(UmengText.SHARE.VIDEOURL + uMVideo.toUrl());
                arrayList.add(UmengText.SHARE.VIDEOTITLE + uMVideo.getTitle());
                arrayList.add(UmengText.SHARE.VIDEODES + uMVideo.getDescription());
                if (uMVideo.getThumbImage() != null) {
                    if (uMVideo.getThumbImage().isUrlMedia()) {
                        if (uMVideo.getThumbImage().asUrlImage() != null) {
                            arrayList.add(UmengText.SHARE.URLTHUMB + uMVideo.getThumbImage().asUrlImage());
                        }
                    } else {
                        byte[] bArrAsBinImage3 = uMVideo.getThumbImage().asBinImage();
                        if (bArrAsBinImage3 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage3.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject3 = shareContent.mMedia;
            if (uMediaObject3 instanceof UMusic) {
                UMusic uMusic = (UMusic) uMediaObject3;
                arrayList.add(UmengText.SHARE.MUSICURL + uMusic.toUrl() + "   " + uMusic.getmTargetUrl());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(UmengText.SHARE.MUSICTITLE);
                sb2.append(uMusic.getTitle());
                arrayList.add(sb2.toString());
                arrayList.add(UmengText.SHARE.MUSICDES + uMusic.getDescription());
                if (uMusic.getThumbImage() != null) {
                    if (uMusic.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMusic.getThumbImage().asUrlImage());
                    } else {
                        byte[] bArrAsBinImage4 = uMusic.getThumbImage().asBinImage();
                        if (bArrAsBinImage4 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage4.length);
                        }
                    }
                }
            }
            UMediaObject uMediaObject4 = shareContent.mMedia;
            if (uMediaObject4 instanceof UMWeb) {
                UMWeb uMWeb = (UMWeb) uMediaObject4;
                arrayList.add(UmengText.SHARE.URLURL + uMWeb.toUrl());
                arrayList.add(UmengText.SHARE.URLTITLE + uMWeb.getTitle());
                arrayList.add(UmengText.SHARE.URLDES + uMWeb.getDescription());
                if (uMWeb.getThumbImage() != null) {
                    if (uMWeb.getThumbImage().isUrlMedia()) {
                        arrayList.add(UmengText.SHARE.URLTHUMB + uMWeb.getThumbImage().asUrlImage());
                    } else {
                        byte[] bArrAsBinImage5 = uMWeb.getThumbImage().asBinImage();
                        if (bArrAsBinImage5 != null) {
                            arrayList.add(UmengText.SHARE.LOCALTHUMB + bArrAsBinImage5.length);
                        }
                    }
                }
            }
        }
        if (shareContent.file != null) {
            arrayList.add(UmengText.SHARE.FILENAME + shareContent.file.getName());
        }
        SLog.mutlI((String[]) arrayList.toArray(new String[1]));
    }

    public boolean b(Activity activity, SHARE_MEDIA share_media) {
        if (!this.f11584f.a(activity, share_media)) {
            return false;
        }
        this.f11582d.get(share_media).onCreate(activity, PlatformConfig.getPlatform(share_media));
        return this.f11582d.get(share_media).isSupport();
    }

    private synchronized void b(int i2, UMAuthListener uMAuthListener) {
        this.f11588j.put(i2, uMAuthListener);
    }

    public void a(Activity activity, final ShareAction shareAction, final UMShareListener uMShareListener) {
        b(activity);
        WeakReference weakReference = new WeakReference(activity);
        if (this.f11584f.a(shareAction, activity)) {
            if (SLog.isDebug()) {
                SLog.E(UmengText.SHARE.VERSION + "7.3.2");
                a(shareAction);
            }
            SHARE_MEDIA platform = shareAction.getPlatform();
            UMSSOHandler uMSSOHandler = this.f11582d.get(platform);
            uMSSOHandler.onCreate((Context) weakReference.get(), PlatformConfig.getPlatform(platform));
            final String strValueOf = String.valueOf(System.currentTimeMillis());
            if (ContextUtil.getContext() != null) {
                DplusApi.uploadShare(ContextUtil.getContext(), shareAction.getShareContent(), uMSSOHandler.isInstall(), platform, strValueOf, shareAction.getShareContent().mMedia instanceof UMImage ? ((UMImage) shareAction.getShareContent().mMedia).isHasWaterMark() : false);
            }
            final int iOrdinal = platform.ordinal();
            a(iOrdinal, uMShareListener);
            final UMShareListener uMShareListener2 = new UMShareListener() { // from class: com.umeng.socialize.b.a.6
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, CommonNetImpl.CANCEL, "", strValueOf);
                                }
                                UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                                if (uMShareListenerE != null) {
                                    uMShareListenerE.onCancel(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(final SHARE_MEDIA share_media, final Throwable th) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null && th != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "fail", th.getMessage(), strValueOf);
                                }
                                UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                                if (uMShareListenerE != null) {
                                    uMShareListenerE.onError(share_media, th);
                                }
                                if (th != null) {
                                    SLog.E(th.getMessage());
                                    SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                    SLog.runtimePrint(th.getMessage());
                                    return;
                                }
                                SLog.E(c.c.a.b.a.a.f3101h);
                                SLog.E(UmengText.SOLVE + UrlUtil.ALL_SHAREFAIL);
                                SLog.runtimePrint(c.c.a.b.a.a.f3101h);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ContextUtil.getContext() != null) {
                                    SocialAnalytics.shareend(ContextUtil.getContext(), share_media, "success", "", strValueOf);
                                }
                                UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                                if (uMShareListenerE != null) {
                                    uMShareListenerE.onResult(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(final SHARE_MEDIA share_media) {
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMShareListener uMShareListenerE = a.this.e(iOrdinal);
                                if (uMShareListenerE != null) {
                                    uMShareListenerE.onStart(share_media);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            };
            if (!shareAction.getUrlValid()) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            uMShareListener2.onError(shareAction.getPlatform(), new Throwable(UmengErrorCode.ShareFailed.getMessage() + UmengText.SHARE.WEB_HTTP));
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.b.a.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (uMShareListener != null) {
                            uMShareListener.onStart(shareAction.getPlatform());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            try {
                uMSSOHandler.share(shareAction.getShareContent(), uMShareListener2);
            } catch (Throwable th) {
                SLog.error(th);
            }
        }
    }

    private synchronized void a(int i2, UMAuthListener uMAuthListener) {
        this.f11586h.put(i2, uMAuthListener);
    }

    private synchronized void a(int i2, UMShareListener uMShareListener) {
        this.f11587i.put(i2, uMShareListener);
    }

    private void a(SHARE_MEDIA share_media, UMAuthListener uMAuthListener, UMSSOHandler uMSSOHandler, String str) {
        if (uMSSOHandler.isHasAuthListener()) {
            return;
        }
        int iOrdinal = share_media.ordinal();
        a(iOrdinal, uMAuthListener);
        uMSSOHandler.setAuthListener(a(iOrdinal, str, uMSSOHandler.isInstall()));
    }

    public void a() {
        c();
        DplusCacheApi.getInstance().cleanCache(ContextUtil.getContext());
        UMSSOHandler uMSSOHandler = this.f11582d.get(SHARE_MEDIA.SINA);
        if (uMSSOHandler != null) {
            uMSSOHandler.release();
        }
        UMSSOHandler uMSSOHandler2 = this.f11582d.get(SHARE_MEDIA.MORE);
        if (uMSSOHandler2 != null) {
            uMSSOHandler2.release();
        }
        UMSSOHandler uMSSOHandler3 = this.f11582d.get(SHARE_MEDIA.DINGTALK);
        if (uMSSOHandler3 != null) {
            uMSSOHandler3.release();
        }
        UMSSOHandler uMSSOHandler4 = this.f11582d.get(SHARE_MEDIA.WEIXIN);
        if (uMSSOHandler4 != null) {
            uMSSOHandler4.release();
        }
        UMSSOHandler uMSSOHandler5 = this.f11582d.get(SHARE_MEDIA.QQ);
        if (uMSSOHandler5 != null) {
            uMSSOHandler5.release();
        }
        this.f11581a = null;
        DplusCacheApi.getInstance().closeDBConnection(ContextUtil.getContext());
    }

    public void a(Bundle bundle) {
        String string;
        int i2;
        SHARE_MEDIA share_media = this.f11581a;
        if (share_media == null || !(share_media == SHARE_MEDIA.WEIXIN || share_media == SHARE_MEDIA.QQ || share_media == SHARE_MEDIA.SINA)) {
            string = "";
            i2 = -1;
        } else {
            string = this.f11581a.toString();
            i2 = 0;
        }
        bundle.putString(f11579b, string);
        bundle.putInt(f11580c, i2);
        this.f11581a = null;
    }

    public void a(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        SHARE_MEDIA share_mediaConvertToEmun;
        UMSSOHandler uMSSOHandlerA;
        if (bundle == null || uMAuthListener == null) {
            return;
        }
        String string = bundle.getString(f11579b, null);
        if (bundle.getInt(f11580c, -1) != 0 || TextUtils.isEmpty(string) || (share_mediaConvertToEmun = SHARE_MEDIA.convertToEmun(string)) == null) {
            return;
        }
        if (share_mediaConvertToEmun == SHARE_MEDIA.QQ) {
            uMSSOHandlerA = this.f11582d.get(share_mediaConvertToEmun);
            uMSSOHandlerA.onCreate(activity, PlatformConfig.getPlatform(share_mediaConvertToEmun));
        } else {
            uMSSOHandlerA = a(share_mediaConvertToEmun);
        }
        if (uMSSOHandlerA != null) {
            a(share_mediaConvertToEmun, uMAuthListener, uMSSOHandlerA, String.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(UMShareConfig uMShareConfig) {
        if (this.f11582d.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<SHARE_MEDIA, UMSSOHandler>> it = this.f11582d.entrySet().iterator();
        while (it.hasNext()) {
            UMSSOHandler value = it.next().getValue();
            if (value != null) {
                value.setShareConfig(uMShareConfig);
            }
        }
    }
}
