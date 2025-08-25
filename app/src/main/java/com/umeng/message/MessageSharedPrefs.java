package com.umeng.message;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.d;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.aq;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.x;
import com.umeng.socialize.a.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class MessageSharedPrefs {

    /* renamed from: d, reason: collision with root package name */
    private static volatile MessageSharedPrefs f11126d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11127a;

    /* renamed from: b, reason: collision with root package name */
    public final aq f11128b = new aq("push");

    /* renamed from: c, reason: collision with root package name */
    public Boolean f11129c = null;

    private MessageSharedPrefs(Context context) {
        this.f11127a = context.getApplicationContext();
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f11126d == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f11126d == null) {
                    f11126d = new MessageSharedPrefs(context);
                }
            }
        }
        return f11126d;
    }

    private void setMessageAppKey(String str) {
        if (f.b(this.f11127a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "appkey is empty!");
            } else {
                this.f11128b.a("appkey", str);
            }
        }
    }

    private void setMessageAppSecret(String str) {
        if (f.b(this.f11127a)) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Prefs", "message secret is empty!");
            } else {
                this.f11128b.a("message_secret", str);
            }
        }
    }

    private void setMessageChannel(String str) {
        if (f.b(this.f11127a)) {
            this.f11128b.a("channel", str);
        }
    }

    public final boolean a() {
        Throwable th;
        long jB;
        try {
            jB = this.f11128b.b(d.p, 0L);
            if (jB > 0) {
                try {
                    UPLog.d("Prefs", "today first start:", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(jB)));
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.e("Prefs", th);
                    return f.a(jB);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            jB = 0;
        }
        return f.a(jB);
    }

    public final int b() {
        return this.f11128b.b("notification_number", 1);
    }

    public final String c() {
        return this.f11128b.b("appkey", "");
    }

    public final int d() {
        return this.f11128b.b("tag_remain", 64);
    }

    public final String e() {
        String strB = this.f11128b.b("service_class", "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                Class.forName(strB);
                return strB;
            } catch (Throwable unused) {
                UPLog.e("Prefs", "custom service not exist:", strB, "if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    public final String f() {
        return this.f11128b.b("last_click_msg_id", "");
    }

    public final int g() {
        return this.f11128b.b("mute_duration", 60);
    }

    public final int h() {
        return this.f11128b.b("notification_vibrate", 0);
    }

    public final int i() {
        return this.f11128b.b("notification_light", 0);
    }

    public final int j() {
        return this.f11128b.b("notification_sound", 0);
    }

    public final String k() {
        return this.f11128b.b(RemoteMessageConst.DEVICE_TOKEN, "");
    }

    public final boolean l() {
        return this.f11128b.b("l_u_e", false);
    }

    public final long m() {
        return this.f11128b.b(a.f11538d, 0L);
    }

    public final int n() {
        return this.f11128b.b("re_pop_cfg", 0);
    }

    public final int o() {
        Calendar calendar = Calendar.getInstance();
        String str = String.format(Locale.getDefault(), "%d.%d.", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        String strB = this.f11128b.b("re_pop_times", "");
        if (strB.startsWith(str)) {
            try {
                return Integer.parseInt(strB.replace(str, ""));
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public final void b(String str) {
        this.f11128b.a(str + bh.aX);
        this.f11128b.a(str + "ts");
    }

    public final void c(String str) {
        this.f11128b.a("last_click_msg_id", str);
    }

    public final void a(String str, String str2, int i2, long j2) {
        Cursor cursorQuery = null;
        try {
            Application applicationA = x.a();
            try {
                this.f11127a.getContentResolver().delete(h.a(this.f11127a), "type=?", new String[]{str2});
            } catch (Exception e2) {
                UPLog.e("Prefs", e2);
            }
            String[] strArr = {str, str2, String.valueOf(i2)};
            cursorQuery = applicationA.getContentResolver().query(h.a(applicationA), null, "alias=? and type=? and exclusive=?", strArr, "time desc");
            ContentValues contentValues = new ContentValues();
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put(RemoteMessageConst.TTL, Long.valueOf(j2));
            contentValues.put("type", str2);
            contentValues.put("alias", str);
            contentValues.put("exclusive", Integer.valueOf(i2));
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                this.f11127a.getContentResolver().update(h.a(applicationA), contentValues, "alias=? and type=? and exclusive=?", strArr);
            } else {
                this.f11127a.getContentResolver().insert(h.a(applicationA), contentValues);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable th) {
                UPLog.e("Prefs", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(int r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "alias"
            java.lang.String r1 = "Prefs"
            r2 = 0
            java.lang.String r6 = "type=? and exclusive=?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3 = 0
            r7[r3] = r11     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r11 = 1
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r7[r11] = r10     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r8 = "time desc"
            android.content.Context r10 = r9.f11127a     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.content.Context r10 = r9.f11127a     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.net.Uri r4 = com.umeng.message.proguard.h.a(r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r10 == 0) goto L4b
            int r11 = r10.getCount()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            if (r11 > 0) goto L33
            goto L4b
        L33:
            r10.moveToFirst()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            int r11 = r10.getColumnIndex(r0)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            java.lang.String r11 = r10.getString(r11)     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L68
            if (r10 == 0) goto L48
            r10.close()     // Catch: java.lang.Throwable -> L44
            goto L48
        L44:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L48:
            return r11
        L49:
            r11 = move-exception
            goto L5a
        L4b:
            if (r10 == 0) goto L55
            r10.close()     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L55:
            return r2
        L56:
            r11 = move-exception
            goto L6a
        L58:
            r11 = move-exception
            r10 = r2
        L5a:
            com.umeng.message.common.UPLog.e(r1, r11)     // Catch: java.lang.Throwable -> L68
            if (r10 == 0) goto L67
            r10.close()     // Catch: java.lang.Throwable -> L63
            goto L67
        L63:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L67:
            return r2
        L68:
            r11 = move-exception
            r2 = r10
        L6a:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L70:
            r10 = move-exception
            com.umeng.message.common.UPLog.e(r1, r10)
        L74:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r25, java.lang.String r26, java.lang.String r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.a(int, java.lang.String, java.lang.String):boolean");
    }

    public final void a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        Set<String> setB = this.f11128b.b(SocializeProtocolConstants.TAGS, new HashSet());
        setB.addAll(Arrays.asList(strArr));
        this.f11128b.a(SocializeProtocolConstants.TAGS, setB);
    }

    public final void a(String str, long j2) {
        this.f11128b.a(str + bh.aX, j2);
        this.f11128b.a(str + "ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long jB = this.f11128b.b(str + bh.aX, 0L);
        if (jB <= 0) {
            return true;
        }
        aq aqVar = this.f11128b;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - aqVar.b(sb.toString(), 0L)) / 1000 >= jB;
    }

    public final void a(int i2) {
        this.f11128b.a("tag_remain", i2);
    }
}
