package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a, reason: collision with root package name */
    private String f9682a;

    /* renamed from: b, reason: collision with root package name */
    private String f9683b;

    /* renamed from: c, reason: collision with root package name */
    private String f9684c;

    /* renamed from: d, reason: collision with root package name */
    private String f9685d;

    /* renamed from: e, reason: collision with root package name */
    private String f9686e;

    /* renamed from: f, reason: collision with root package name */
    private OAuthListener f9687f;

    /* renamed from: g, reason: collision with root package name */
    private c f9688g;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public OAuthErrCode f9689a;

        /* renamed from: b, reason: collision with root package name */
        public String f9690b;

        /* renamed from: c, reason: collision with root package name */
        public String f9691c;

        /* renamed from: d, reason: collision with root package name */
        public String f9692d;

        /* renamed from: e, reason: collision with root package name */
        public byte[] f9693e;

        private a() {
        }

        public static a a(byte[] bArr) throws JSONException {
            OAuthErrCode oAuthErrCode;
            String str;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i2 = jSONObject.getInt("errcode");
                        if (i2 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                            aVar.f9689a = OAuthErrCode.WechatAuth_Err_NormalErr;
                            jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string != null && string.length() != 0) {
                            byte[] bArrDecode = Base64.decode(string, 0);
                            if (bArrDecode != null && bArrDecode.length != 0) {
                                aVar.f9689a = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f9693e = bArrDecode;
                                aVar.f9690b = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                aVar.f9691c = string2;
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f9690b, string2, Integer.valueOf(aVar.f9693e.length)));
                                return aVar;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.f9689a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.f9689a = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e2) {
                        str = String.format("parse json fail, ex = %s", e2.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", str);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f9689a = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e3) {
                    str = String.format("parse fail, build String fail, ex = %s", e3.getMessage());
                }
            }
            aVar.f9689a = oAuthErrCode;
            return aVar;
        }
    }

    public b(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.f9682a = str;
        this.f9683b = str2;
        this.f9684c = str3;
        this.f9685d = str4;
        this.f9686e = str5;
        this.f9687f = oAuthListener;
    }

    public boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        c cVar = this.f9688g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected a doInBackground(Void[] voidArr) throws Throwable {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String str = String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.f9682a, this.f9684c, this.f9685d, this.f9683b, this.f9686e);
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrA = com.tencent.mm.opensdk.channel.a.a.a(str, 60000);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", str, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return a.a(bArrA);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f9689a;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f9687f.onAuthFinish(aVar2.f9689a, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f9693e.length);
        this.f9687f.onAuthGotQrcode(aVar2.f9692d, aVar2.f9693e);
        c cVar = new c(aVar2.f9690b, this.f9687f);
        this.f9688g = cVar;
        if (Build.VERSION.SDK_INT >= 11) {
            cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            cVar.execute(new Void[0]);
        }
    }
}
