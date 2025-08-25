package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g, reason: collision with root package name */
    private static SharedPreferences f9535g;

    /* renamed from: a, reason: collision with root package name */
    private String f9536a;

    /* renamed from: b, reason: collision with root package name */
    private String f9537b;

    /* renamed from: c, reason: collision with root package name */
    private String f9538c;

    /* renamed from: d, reason: collision with root package name */
    private int f9539d = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f9540e = -1;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.open.utils.a f9541f;

    public QQToken(String str) {
        this.f9536a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        if (f9535g == null) {
            f9535g = g.a().getSharedPreferences("token_info_file", 0);
        }
        return f9535g;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f9537b;
    }

    public String getAppId() {
        return this.f9536a;
    }

    public int getAuthSource() {
        return this.f9539d;
    }

    public long getExpireTimeInSecond() {
        return this.f9540e;
    }

    public String getOpenId() {
        return this.f9538c;
    }

    public String getOpenIdWithCache() throws JSONException {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject jSONObjectLoadSession = loadSession(this.f9536a);
                if (jSONObjectLoadSession != null) {
                    openId = jSONObjectLoadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f9536a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f9536a);
            }
        } catch (Exception e2) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e2.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.f9537b != null && System.currentTimeMillis() < this.f9540e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f9541f == null) {
                this.f9541f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f9541f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login loadSession" + e2.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor editorEdit = a().edit();
        editorEdit.remove(c(str));
        editorEdit.remove(c(str));
        editorEdit.remove(a(str));
        editorEdit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f9541f == null) {
                this.f9541f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.f9536a, jSONObject, this.f9541f);
        } catch (Exception e2) {
            SLog.i("QQToken", "login saveSession" + e2.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f9537b = str;
        this.f9540e = 0L;
        if (str2 != null) {
            this.f9540e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f9536a = str;
    }

    public void setAuthSource(int i2) {
        this.f9539d = i2;
    }

    public void setOpenId(String str) {
        this.f9538c = str;
        com.tencent.open.b.b.a().a(str);
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String strB;
        if (g.a() == null) {
            SLog.i("QQToken", "loadJsonPreference context null");
            return null;
        }
        if (str == null) {
            SLog.i("QQToken", "loadJsonPreference prefKey is null");
            return null;
        }
        String string = a().getString(a(str), "");
        if (TextUtils.isEmpty(string)) {
            if (!JniInterface.isJniOk) {
                k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
            }
            if (!JniInterface.isJniOk) {
                SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                return null;
            }
            String strC = c(str);
            String string2 = a().getString(strC, "");
            try {
                if (TextUtils.isEmpty(string2)) {
                    String strB2 = b(str);
                    String string3 = a().getString(strB2, "");
                    try {
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        strB = JniInterface.d1(string3);
                        if (TextUtils.isEmpty(strB)) {
                            SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                            return null;
                        }
                        a(str, new JSONObject(strB), aVar);
                    } catch (Exception e2) {
                        SLog.e("QQToken", "Catch Exception", e2);
                        return null;
                    } finally {
                        a().edit().remove(strB2).apply();
                    }
                } else {
                    strB = JniInterface.d2(string2);
                    a(str, new JSONObject(strB), aVar);
                }
            } catch (Exception e3) {
                SLog.e("QQToken", "Catch Exception", e3);
                return null;
            } finally {
                a().edit().remove(strC).apply();
            }
        }
        strB = aVar.b(string);
        try {
            JSONObject jSONObject = new JSONObject(strB);
            SLog.i("QQToken", "loadJsonPreference sucess");
            return jSONObject;
        } catch (Exception e4) {
            SLog.i("QQToken", "loadJsonPreference decode " + e4.toString());
            return null;
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        if (g.a() == null) {
            SLog.i("QQToken", "saveJsonPreference context null");
            return false;
        }
        if (str != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("expires_in");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                    String strA = a(str);
                    String strA2 = aVar.a(jSONObject.toString());
                    if (strA.length() > 6 && strA2 != null) {
                        a().edit().putString(strA, strA2).commit();
                        SLog.i("QQToken", "saveJsonPreference sucess");
                        return true;
                    }
                    SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                    return false;
                }
                SLog.i("QQToken", "expires is null");
                return false;
            } catch (Exception e2) {
                SLog.e("QQToken", "saveJsonPreference exception:" + e2.toString());
                return false;
            }
        }
        SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
        return false;
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }
}
