package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class bl {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] bArrCopyOf = Arrays.copyOf(ay.m161a(str), 16);
        bArrCopyOf[0] = 68;
        bArrCopyOf[15] = 84;
        return bArrCopyOf;
    }

    public static String a(Context context) {
        String strA = bm.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String strA2 = bb.a(20);
        bm.a(context).m188a("sp_client_report_status", "sp_client_report_key", strA2);
        return strA2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m184a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra(c.c.a.b.a.a.j1, context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra(CommonNetImpl.NAME, "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m184a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bl.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m185a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m59a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return false;
            }
        } else {
            w.m765a(file);
        }
        return true;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static File[] m186a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() { // from class: com.xiaomi.push.bl.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return (TextUtils.isEmpty(str2) || str2.toLowerCase().endsWith(".lock")) ? false : true;
            }
        });
    }
}
