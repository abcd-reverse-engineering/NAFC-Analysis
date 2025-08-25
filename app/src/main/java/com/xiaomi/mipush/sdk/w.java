package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ae;
import com.xiaomi.push.an;
import com.xiaomi.push.bb;
import com.xiaomi.push.gf;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.he;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.z;
import java.security.NoSuchAlgorithmException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class w {
    /* JADX INFO: Access modifiers changed from: private */
    public static String c(List<String> list) throws NoSuchAlgorithmException {
        String strA = bb.a(d(list));
        return (TextUtils.isEmpty(strA) || strA.length() <= 4) ? "" : strA.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(List<String> list) {
        String str = "";
        if (z.a(list)) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j2 = sharedPreferences.getLong("last_sync_info", -1L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        long jA = ah.a(context).a(gk.SyncInfoFrequency.a(), 1209600);
        if (j2 == -1) {
            sharedPreferences.edit().putLong("last_sync_info", jCurrentTimeMillis).commit();
        } else if (Math.abs(jCurrentTimeMillis - j2) > jA) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", jCurrentTimeMillis).commit();
        }
    }

    public static void a(final Context context, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.w.1
            @Override // java.lang.Runnable
            public void run() throws NoSuchAlgorithmException {
                com.xiaomi.channel.commonutils.logger.b.m50a("do sync info");
                he heVar = new he(aj.a(), false);
                b bVarM75a = b.m75a(context);
                heVar.c(gp.SyncInfo.f597a);
                heVar.b(bVarM75a.m76a());
                heVar.d(context.getPackageName());
                heVar.f736a = new HashMap();
                Map<String, String> map = heVar.f736a;
                Context context2 = context;
                com.xiaomi.push.l.a(map, "app_version", com.xiaomi.push.g.m451a(context2, context2.getPackageName()));
                Map<String, String> map2 = heVar.f736a;
                Context context3 = context;
                com.xiaomi.push.l.a(map2, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(context3, context3.getPackageName())));
                com.xiaomi.push.l.a(heVar.f736a, "push_sdk_vn", BuildConfig.VERSION_NAME);
                com.xiaomi.push.l.a(heVar.f736a, "push_sdk_vc", Integer.toString(BuildConfig.VERSION_CODE));
                com.xiaomi.push.l.a(heVar.f736a, "token", bVarM75a.b());
                if (!com.xiaomi.push.j.m632d()) {
                    String strA = bb.a(com.xiaomi.push.i.c(context));
                    String strE = com.xiaomi.push.i.e(context);
                    if (!TextUtils.isEmpty(strE)) {
                        strA = strA + Constants.ACCEPT_TIME_SEPARATOR_SP + strE;
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_IMEI_MD5, strA);
                    }
                }
                an.a(context).a(heVar.f736a);
                com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_REG_ID, bVarM75a.m83c());
                com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_REG_SECRET, bVarM75a.d());
                com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(context).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                if (z) {
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_ALIASES_MD5, w.c(MiPushClient.getAllAlias(context)));
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_TOPICS_MD5, w.c(MiPushClient.getAllTopic(context)));
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_ACCOUNTS_MD5, w.c(MiPushClient.getAllUserAccount(context)));
                } else {
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_ALIASES, w.d(MiPushClient.getAllAlias(context)));
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_TOPICS, w.d(MiPushClient.getAllTopic(context)));
                    com.xiaomi.push.l.a(heVar.f736a, Constants.EXTRA_KEY_ACCOUNTS, w.d(MiPushClient.getAllUserAccount(context)));
                }
                u.a(context).a((u) heVar, gf.Notification, false, (gs) null);
            }
        });
    }

    public static void a(Context context, he heVar) {
        com.xiaomi.channel.commonutils.logger.b.m50a("need to update local info with: " + heVar.m545a());
        String str = heVar.m545a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (strArrSplit.length == 2) {
                MiPushClient.addAcceptTime(context, strArrSplit[0], strArrSplit[1]);
                if ("00:00".equals(strArrSplit[0]) && "00:00".equals(strArrSplit[1])) {
                    b.m75a(context).a(true);
                } else {
                    b.m75a(context).a(false);
                }
            }
        }
        String str2 = heVar.m545a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String str3 : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, str3);
                }
            }
        }
        String str4 = heVar.m545a().get(Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (String str5 : str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, str5);
                }
            }
        }
        String str6 = heVar.m545a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            for (String str7 : str6.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                MiPushClient.addAccount(context, str7);
            }
        }
    }
}
