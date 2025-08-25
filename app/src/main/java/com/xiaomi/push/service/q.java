package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static p f13451a;

    /* renamed from: a, reason: collision with other field name */
    private static a f1068a;

    public interface a {
        void a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized p m741a(Context context) {
        if (f13451a != null) {
            return f13451a;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
        String string = sharedPreferences.getString("uuid", null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("security", null);
        String string4 = sharedPreferences.getString("app_id", null);
        String string5 = sharedPreferences.getString("app_token", null);
        String string6 = sharedPreferences.getString("package_name", null);
        String string7 = sharedPreferences.getString("device_id", null);
        int i2 = sharedPreferences.getInt("env_type", 1);
        if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.a(string7)) {
            string7 = com.xiaomi.push.i.g(context);
            sharedPreferences.edit().putString("device_id", string7).commit();
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return null;
        }
        String strG = com.xiaomi.push.i.g(context);
        if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(strG) && !TextUtils.isEmpty(string7) && !string7.equals(strG)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("read_phone_state permission changes.");
        }
        f13451a = new p(string, string2, string3, string4, string5, string6, i2);
        return f13451a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0319 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[Catch: all -> 0x032e, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.p a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }

    private static String a(Context context, boolean z) {
        String strA = b.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.x.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!com.xiaomi.push.n.China.name().equals(strA)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m744a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putInt("enc_req_fail_count", i2);
        editorEdit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putString("uuid", pVar.f1067a);
        editorEdit.putString("security", pVar.f13447c);
        editorEdit.putString("token", pVar.f13446b);
        editorEdit.putString("app_id", pVar.f13448d);
        editorEdit.putString("package_name", pVar.f13450f);
        editorEdit.putString("app_token", pVar.f13449e);
        editorEdit.putString("device_id", com.xiaomi.push.i.g(context));
        editorEdit.putInt("env_type", pVar.f13445a);
        editorEdit.commit();
        a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m743a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f13451a = null;
        a();
    }

    public static void a(a aVar) {
        f1068a = aVar;
    }

    public static void a() {
        a aVar = f1068a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m742a(Context context) {
        p pVarM741a = m741a(context);
        if (pVarM741a != null && !TextUtils.isEmpty(pVarM741a.f1067a)) {
            String[] strArrSplit = pVarM741a.f1067a.split("@");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return null;
    }
}
