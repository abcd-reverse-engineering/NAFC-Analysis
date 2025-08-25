package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.ae;
import com.xiaomi.push.au;
import com.xiaomi.push.aw;
import com.xiaomi.push.ba;
import com.xiaomi.push.hb;
import com.xiaomi.push.s;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12372a = new int[d.values().length];

        static {
            try {
                f12372a[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12372a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m97a(Context context, d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iA = a(context, dVar, str);
        if (iA == 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : send token upload, check:" + iA);
        a(context, str);
        v vVarM101a = g.m101a(dVar);
        if (vVarM101a == null) {
            return;
        }
        u.a(context).a((String) null, vVarM101a, dVar, "upload");
    }

    public static void b(final Context context, final d dVar, final String str) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.f.1
            @Override // java.lang.Runnable
            public void run() {
                String strSubstring;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String[] strArrSplit = str.split(Constants.WAVE_SEPARATOR);
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        strSubstring = "";
                        break;
                    }
                    String str2 = strArrSplit[i2];
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                        strSubstring = str2.substring(str2.indexOf(Constants.COLON_SEPARATOR) + 1);
                        break;
                    }
                    i2++;
                }
                if (TextUtils.isEmpty(strSubstring)) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : receive incorrect token");
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : receive correct token");
                f.d(context, dVar, strSubstring);
                f.m95a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, d dVar, String str) {
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString(strA, str).putString("last_check_token", b.m75a(context).m83c());
        if (m100a(dVar)) {
            editorEdit.putInt(b(dVar), a());
        }
        editorEdit.putString("syncingToken", "");
        com.xiaomi.push.p.a(editorEdit);
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : update sp file success!  " + str);
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    public static String b(d dVar) {
        return a(dVar) + "_version";
    }

    public static String c(d dVar) {
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        if (i2 == 1) {
            return "hms_push_error";
        }
        if (i2 == 2) {
            return "fcm_push_error";
        }
        if (i2 == 3) {
            return "cos_push_error";
        }
        if (i2 != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    private static int a(Context context, d dVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String strA = a(dVar);
        String string = sharedPreferences.getString(strA, "");
        String strM83c = b.m75a(context).m83c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        }
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        if (!string.equals(str)) {
            return 2;
        }
        if (!TextUtils.equals(strM83c, string2)) {
            return 3;
        }
        if (m100a(dVar)) {
            if (a() != sharedPreferences.getInt(b(dVar), 0)) {
                return 4;
            }
        }
        return 0;
    }

    static String a(Context context, d dVar) {
        return a(context, dVar, false);
    }

    public static boolean a(hb hbVar, d dVar) {
        if (hbVar == null || hbVar.m529a() == null || hbVar.m529a().m496a() == null) {
            return false;
        }
        return (dVar == d.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase(hbVar.m529a().m496a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, hb hbVar, d dVar) {
        if (a(hbVar, dVar)) {
            return ba.m176a(a(context, dVar));
        }
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    static void m95a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String strA = a(d.ASSEMBLE_PUSH_HUAWEI);
        String strA2 = a(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(strA, "")) && TextUtils.isEmpty(sharedPreferences.getString(strA2, ""))) {
            z = true;
        }
        if (z) {
            u.a(context).a(2, strA);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m96a(Context context, d dVar) {
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        com.xiaomi.push.p.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(strA, ""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m99a(Context context, d dVar) {
        if (g.m102a(dVar) != null) {
            return ah.a(context).a(g.m102a(dVar).a(), true);
        }
        return false;
    }

    public static void a(String str, int i2) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m98a(Context context) {
        if (context == null) {
            return false;
        }
        return au.m151a(context);
    }

    private static synchronized void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_extra", 0).edit();
        editorEdit.putString("syncingToken", str);
        editorEdit.apply();
    }

    protected static synchronized String a(Context context, d dVar, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        if (z) {
            String string = sharedPreferences.getString("syncingToken", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strA = a(dVar);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        return sharedPreferences.getString(strA, "");
    }

    protected static PushMessageReceiver a(Context context) {
        ResolveInfo next;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    if (next.activityInfo != null && next.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
                next = null;
            } else {
                next = null;
            }
            if (next != null) {
                return (PushMessageReceiver) C0343r.a(context, next.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            return null;
        }
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    public static MiPushMessage a(String str) throws JSONException {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap map = new HashMap();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.getString(next));
                    }
                    if (map.size() > 0) {
                        miPushMessage.setExtra(map);
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
        }
        return miPushMessage;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m94a(Context context, d dVar) throws PackageManager.NameNotFoundException {
        HashMap<String, String> map = new HashMap<>();
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        String string = null;
        ApplicationInfo applicationInfo = null;
        if (i2 == 1) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            }
            string = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.HUAWEI.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).a("app_id", Integer.valueOf(applicationInfo != null ? applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID) : -1)).toString();
        } else if (i2 == 2) {
            s.a aVarA = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.FCM.name()).a("token", a(context, dVar, false)).a("package_name", context.getPackageName());
            int iA = a();
            if (iA != 0) {
                aVarA.a("version", Integer.valueOf(iA));
            } else {
                aVarA.a("version", Integer.valueOf(BuildConfig.VERSION_CODE));
            }
            string = aVarA.toString();
        } else if (i2 == 3) {
            string = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.OPPO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName()).toString();
        } else if (i2 == 4) {
            s.a aVarA2 = new s.a(Constants.COLON_SEPARATOR, Constants.WAVE_SEPARATOR).a("brand", q.VIVO.name()).a("token", a(context, dVar, true)).a("package_name", context.getPackageName());
            int iA2 = a();
            if (iA2 != 0) {
                aVarA2.a("version", Integer.valueOf(iA2));
            }
            string = aVarA2.toString();
        }
        map.put(Constants.ASSEMBLE_PUSH_REG_INFO, string);
        return map;
    }

    public static int a() {
        Integer num = (Integer) aw.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m100a(d dVar) {
        return dVar == d.ASSEMBLE_PUSH_FTOS || dVar == d.ASSEMBLE_PUSH_FCM;
    }

    public static String a(d dVar) {
        int i2 = AnonymousClass2.f12372a[dVar.ordinal()];
        if (i2 == 1) {
            return "hms_push_token";
        }
        if (i2 == 2) {
            return "fcm_push_token_v2";
        }
        if (i2 == 3) {
            return "cos_push_token";
        }
        if (i2 != 4) {
            return null;
        }
        return "ftos_push_token";
    }
}
