package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.e;
import com.tencent.open.SocialConstants;

/* loaded from: classes.dex */
public final class d extends c<Void, Void, String> {
    private Context Z;
    private com.sina.weibo.sdk.net.c<String> aa;
    private Throwable ab;
    private String ac;
    private String ad;
    private String ae;

    public d(Context context, String str, String str2, String str3, com.sina.weibo.sdk.net.c<String> cVar) {
        this.Z = context;
        this.ac = str;
        this.ad = str2;
        this.ae = str3;
        this.aa = cVar;
    }

    private String d(String str) {
        return HttpManager.a(this.Z, "", this.ae, this.ad, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.a.c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String l() {
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis() / 1000);
            e.a aVar = new e.a();
            aVar.f8368i = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.a("oauth_timestamp", strValueOf).a("oauth_sign", d(strValueOf)).b("appKey", this.ad).b("oauth_timestamp", strValueOf).b("oauth_sign", d(strValueOf)).b(SocialConstants.PARAM_IMG_URL, this.ac).e()).f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ab = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.a.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ab;
        if (th != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.aa;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.aa;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
