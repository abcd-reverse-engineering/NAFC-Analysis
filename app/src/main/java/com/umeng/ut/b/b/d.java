package com.umeng.ut.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.Config;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f11919a;

    /* renamed from: a, reason: collision with other field name */
    private Context f65a;

    /* renamed from: c, reason: collision with root package name */
    private String f11921c = null;

    /* renamed from: d, reason: collision with root package name */
    private long f11922d = -1;

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f11920b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a, reason: collision with other field name */
    private static final Object f64a = new Object();

    private d(Context context) {
        this.f65a = context.getApplicationContext();
        com.umeng.ut.a.a.a().a(this.f65a);
    }

    public static d a(Context context) {
        if (context != null && f11919a == null) {
            synchronized (f64a) {
                if (f11919a == null) {
                    f11919a = new d(context);
                }
            }
        }
        return f11919a;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !f11920b.matcher(str).find();
        }
        return false;
    }

    private long c() {
        long j2;
        try {
            j2 = a("um_push_ut").getLong("v_i", 604800L);
        } catch (Throwable unused) {
            j2 = 0;
        }
        if (j2 < 600) {
            j2 = 600;
        } else if (j2 > 7776000) {
            j2 = 7776000;
        }
        return j2 * 1000;
    }

    @SuppressLint({"ApplySharedPref"})
    private void e() {
        try {
            a("um_push_ut").edit().remove("v_r").commit();
        } catch (Throwable unused) {
        }
    }

    private synchronized String j() {
        boolean z = m47c() || !com.umeng.ut.a.c.a.a(this.f65a);
        if (z) {
            this.f11921c = l();
            if (!com.umeng.ut.b.a.a.d.isEmpty(this.f11921c) && b(this.f11921c)) {
                return this.f11921c;
            }
            this.f11921c = k();
            if (!com.umeng.ut.b.a.a.d.isEmpty(this.f11921c) && b(this.f11921c)) {
                a(this.f11921c, false);
                return this.f11921c;
            }
        }
        try {
            byte[] bArrA = a();
            if (bArrA != null) {
                this.f11921c = com.umeng.ut.b.a.a.a.a(bArrA, 2);
                a(this.f11921c, true);
                if (!z) {
                    e();
                }
                return this.f11921c;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private String k() {
        try {
            SharedPreferences sharedPreferencesA = a(Config.PREFERENCES);
            String string = sharedPreferencesA.getString("deviceId", null);
            if (string == null || string.length() <= 0) {
                return null;
            }
            String string2 = sharedPreferencesA.getString("utdid", null);
            if (string2 != null) {
                try {
                    if (string2.length() == 0) {
                    }
                } catch (Throwable unused) {
                }
                return string2;
            }
            return a(Constants.SP_FILE_NAME).getString("utdid", null);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String l() {
        try {
            return a("um_push_ut").getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    boolean d() {
        try {
            return a("um_push_ut").getBoolean("t_f", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    void f() {
        try {
            a("um_push_ut").edit().remove("t_id").remove("t_f").commit();
        } catch (Throwable unused) {
        }
    }

    synchronized String getValue() {
        if (this.f11921c != null) {
            return this.f11921c;
        }
        return j();
    }

    String m() {
        String string;
        try {
            string = a("um_push_ut").getString("t_id", null);
        } catch (Throwable unused) {
            string = null;
        }
        if (string != null && !"-1".equals(string) && string.length() >= 2 && string.length() <= 128) {
            return string;
        }
        return null;
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m47c() {
        try {
            return a("um_push_ut").getBoolean("v_r", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    private void a(String str, boolean z) {
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                b(str, z);
            }
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean b() {
        try {
            SharedPreferences sharedPreferencesA = a("um_push_ut");
            if (this.f11922d == -1) {
                this.f11922d = sharedPreferencesA.getLong("v_ts", 0L);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - this.f11922d) >= c()) {
                this.f11922d = jCurrentTimeMillis;
                sharedPreferencesA.edit().putLong("v_ts", jCurrentTimeMillis).commit();
                com.umeng.ut.a.c.e.m44a("UTUtdid", "req valid");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private byte[] a() throws Exception {
        String strF;
        com.umeng.ut.a.c.e.m44a("UTUtdid", "generate UTDid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bytes = com.umeng.ut.b.a.a.b.getBytes(iCurrentTimeMillis);
        byte[] bytes2 = com.umeng.ut.b.a.a.b.getBytes(iNextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strF = com.umeng.ut.b.a.a.c.f();
        } catch (Exception unused) {
            strF = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(strF)), 0, 4);
        byteArrayOutputStream.write(com.umeng.ut.b.a.a.b.getBytes(com.umeng.ut.b.a.a.d.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    @SuppressLint({"ApplySharedPref"})
    private void b(String str, boolean z) {
        try {
            a("um_push_ut").edit().putString("d_id", str).putBoolean("t_f", z).commit();
        } catch (Throwable unused) {
        }
    }

    private static String a(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.umeng.ut.a.c.d.b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.umeng.ut.b.a.a.a.a(mac.doFinal(bArr), 2);
    }

    @SuppressLint({"ApplySharedPref"})
    void a(String str, long j2) {
        boolean z;
        try {
            SharedPreferences.Editor editorEdit = a("um_push_ut").edit();
            if (j2 > 0) {
                editorEdit.putLong("v_i", j2);
                editorEdit.putLong("v_ts", System.currentTimeMillis());
                z = true;
            } else {
                z = false;
            }
            if (str != null && !"-1".equals(str) && str.length() >= 2 && str.length() <= 128) {
                editorEdit.putString("t_id", str);
                editorEdit.putBoolean("v_r", false);
                z = true;
            }
            if (z) {
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private SharedPreferences a(String str) {
        return this.f65a.getSharedPreferences(str, 0);
    }
}
