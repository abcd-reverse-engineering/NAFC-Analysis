package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.b.b;
import com.taobao.accs.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends b {
    public WeiboMultiMessage aE;
    private byte[] aF;
    String aG;
    public String ae;
    public String packageName;
    private String text;

    public d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.aE;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.ae);
        bundle.putString(Constants.KEY_PACKAGE_NAME, this.packageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    @Override // com.sina.weibo.sdk.web.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void b(android.os.Bundle r8) throws java.lang.Throwable {
        /*
            r7 = this;
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = new com.sina.weibo.sdk.api.WeiboMultiMessage
            r0.<init>()
            r7.aE = r0
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = r7.aE
            r0.readFromBundle(r8)
            java.lang.String r0 = "token"
            java.lang.String r0 = r8.getString(r0)
            r7.ae = r0
            java.lang.String r0 = "packageName"
            java.lang.String r8 = r8.getString(r0)
            r7.packageName = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = r7.aE
            com.sina.weibo.sdk.api.TextObject r0 = r0.textObject
            if (r0 == 0) goto L2c
            java.lang.String r0 = r0.text
            r8.append(r0)
        L2c:
            com.sina.weibo.sdk.api.WeiboMultiMessage r0 = r7.aE
            com.sina.weibo.sdk.api.ImageObject r0 = r0.imageObject
            if (r0 == 0) goto La3
            java.lang.String r1 = r0.imagePath
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L96
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L96
            boolean r1 = r2.canRead()
            if (r1 == 0) goto L96
            long r3 = r2.length()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L96
            long r3 = r2.length()
            int r1 = (int) r3
            byte[] r1 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            r4.read(r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            byte[] r1 = com.sina.weibo.sdk.b.e.b(r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r7.aF = r1     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L77
            r4.close()     // Catch: java.io.IOException -> L6f
            goto La3
        L6f:
            r0 = move-exception
            r0.printStackTrace()
            goto La3
        L74:
            r8 = move-exception
            r3 = r4
            goto L8b
        L77:
            r1 = move-exception
            r3 = r4
            goto L7d
        L7a:
            r8 = move-exception
            goto L8b
        L7c:
            r1 = move-exception
        L7d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7a
            if (r3 == 0) goto L96
            r3.close()     // Catch: java.io.IOException -> L86
            goto L96
        L86:
            r1 = move-exception
            r1.printStackTrace()
            goto L96
        L8b:
            if (r3 == 0) goto L95
            r3.close()     // Catch: java.io.IOException -> L91
            goto L95
        L91:
            r0 = move-exception
            r0.printStackTrace()
        L95:
            throw r8
        L96:
            byte[] r0 = r0.imageData
            if (r0 == 0) goto La3
            int r1 = r0.length
            if (r1 <= 0) goto La3
            byte[] r0 = com.sina.weibo.sdk.b.e.b(r0)
            r7.aF = r0
        La3:
            java.lang.String r8 = r8.toString()
            r7.text = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.b.d.b(android.os.Bundle):void");
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final String getUrl() {
        Uri.Builder builderBuildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        builderBuildUpon.appendQueryParameter("title", this.text);
        builderBuildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.aC.a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            builderBuildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.ae)) {
            builderBuildUpon.appendQueryParameter("access_token", this.ae);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            builderBuildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.aG)) {
            builderBuildUpon.appendQueryParameter("picinfo", this.aG);
        }
        builderBuildUpon.appendQueryParameter("luicode", "10000360");
        builderBuildUpon.appendQueryParameter("lfid", "OP_".concat(String.valueOf(appKey)));
        return builderBuildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final boolean t() {
        byte[] bArr = this.aF;
        if (bArr == null || bArr.length <= 0) {
            return super.t();
        }
        return true;
    }

    public d(Context context) {
        this.Z = context;
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(final b.a aVar) {
        b.a.K.a(new com.sina.weibo.sdk.a.d(this.Z, new String(this.aF), this.aC.a().getAppKey(), this.ae, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            @Override // com.sina.weibo.sdk.net.c
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                com.sina.weibo.sdk.b.c.a("WbShareTag", "handle image result :".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onError("处理图片，服务端返回null!");
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int iOptInt = jSONObject.optInt("code");
                    String strOptString = jSONObject.optString("data");
                    if (iOptInt != 1 || TextUtils.isEmpty(strOptString)) {
                        if (aVar != null) {
                            aVar.onError("图片内容不合适，禁止上传！");
                        }
                    } else {
                        d.this.aG = strOptString;
                        if (aVar != null) {
                            aVar.onComplete();
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    b.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.onError("解析服务端返回的字符串时发生异常！");
                    }
                }
            }

            @Override // com.sina.weibo.sdk.net.c
            public final void onError(Throwable th) {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(th.getMessage());
                }
            }
        }));
    }
}
