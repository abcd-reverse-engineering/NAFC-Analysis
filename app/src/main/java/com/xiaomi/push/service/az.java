package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gp;
import com.xiaomi.push.he;
import com.xiaomi.push.hp;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class az {

    /* renamed from: a, reason: collision with other field name */
    private static AtomicLong f1027a = new AtomicLong(0);

    /* renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f1026a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a, reason: collision with root package name */
    private static String f13402a = f1026a.format(Long.valueOf(System.currentTimeMillis()));

    public static synchronized String a() {
        String str;
        str = f1026a.format(Long.valueOf(System.currentTimeMillis()));
        if (!TextUtils.equals(f13402a, str)) {
            f1027a.set(0L);
            f13402a = str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f1027a.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.he> a(java.util.List<com.xiaomi.push.gj> r11, java.lang.String r12, java.lang.String r13, int r14) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L15
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            com.xiaomi.channel.commonutils.logger.b.d(r11)
            return r0
        L15:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.gi r2 = new com.xiaomi.push.gi
            r2.<init>()
            r3 = 0
            r4 = r2
            r2 = 0
            r5 = 0
        L23:
            int r6 = r11.size()
            if (r2 >= r6) goto Lae
            java.lang.Object r6 = r11.get(r2)
            com.xiaomi.push.gj r6 = (com.xiaomi.push.gj) r6
            if (r6 != 0) goto L33
            goto Laa
        L33:
            java.util.Map r7 = r6.m464a()
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m464a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L72
            java.util.Map r7 = r6.m464a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L5a
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L5a
            goto L5b
        L5a:
            r7 = 0
        L5b:
            java.util.Map r9 = r6.m464a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L6a
            r6.a(r0)
            goto L73
        L6a:
            java.util.Map r9 = r6.m464a()
            r9.remove(r8)
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 > 0) goto L7a
            byte[] r7 = com.xiaomi.push.hp.a(r6)
            int r7 = r7.length
        L7a:
            if (r7 <= r14) goto L95
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto Laa
        L95:
            int r8 = r5 + r7
            if (r8 <= r14) goto La6
            com.xiaomi.push.he r4 = a(r12, r13, r4)
            r1.add(r4)
            com.xiaomi.push.gi r4 = new com.xiaomi.push.gi
            r4.<init>()
            r5 = 0
        La6:
            r4.a(r6)
            int r5 = r5 + r7
        Laa:
            int r2 = r2 + 1
            goto L23
        Lae:
            int r11 = r4.a()
            if (r11 == 0) goto Lbb
            com.xiaomi.push.he r11 = a(r12, r13, r4)
            r1.add(r11)
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.az.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    private static he a(String str, String str2, gi giVar) {
        return new he("-1", false).d(str).b(str2).a(com.xiaomi.push.w.a(hp.a(giVar))).c(gp.UploadTinyData.f597a);
    }

    public static boolean a(gj gjVar, boolean z) {
        if (gjVar == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item is null, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!z && TextUtils.isEmpty(gjVar.f569a)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item.channel is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f576d)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item.category is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (TextUtils.isEmpty(gjVar.f575c)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item.name is null or empty, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m177a(gjVar.f576d)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item.category can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        if (!com.xiaomi.push.bb.m177a(gjVar.f575c)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("item.name can only contain ascii char, verfiy ClientUploadDataItem failed.");
            return true;
        }
        String str = gjVar.f574b;
        if (str == null || str.length() <= 30720) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("item.data is too large(" + gjVar.f574b.length() + "), max size for data is 30720 , verfiy ClientUploadDataItem failed.");
        return true;
    }

    public static void a(Context context, String str, String str2, long j2, String str3) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c(str2);
        gjVar.a(j2);
        gjVar.b(str3);
        gjVar.a("push_sdk_channel");
        gjVar.g(context.getPackageName());
        gjVar.e(context.getPackageName());
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.f(a());
        ba.a(context, gjVar);
    }

    public static boolean a(String str) {
        return !C0343r.m640b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
