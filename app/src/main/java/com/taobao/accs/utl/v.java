package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class v {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a, reason: collision with root package name */
    static int f8699a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f8700b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static int f8701c = -1;

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (f8701c == -1) {
            f8701c = context.getApplicationInfo().targetSdkVersion;
        }
        return f8701c >= 26 && Build.VERSION.SDK_INT >= 26;
    }

    public static int b(Context context) {
        int i2;
        int i3 = f8699a;
        if (i3 != -1) {
            return i3;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            context = null;
        }
        synchronized (f8700b) {
            try {
                i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                return i2;
            } catch (Throwable th3) {
                th = th3;
                context = null;
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    ALog.e("Utils", "getMode", th, new Object[0]);
                    i2 = context;
                    return i2;
                }
            }
        }
    }

    public static void c(Context context) {
        try {
            synchronized (f8700b) {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                editorEdit.clear();
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static void d(Context context) {
        try {
            UtilityImpl.killService(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killService", th, new Object[0]);
        }
    }

    public static boolean e(Context context) {
        boolean zIsMainProcess;
        try {
            zIsMainProcess = UtilityImpl.isMainProcess(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killservice", th, new Object[0]);
            th.printStackTrace();
            zIsMainProcess = true;
        }
        ALog.i("Utils", "isMainProcess", "result", Boolean.valueOf(zIsMainProcess));
        return zIsMainProcess;
    }

    public static void f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AGOO_BIND", 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Exception e2) {
            ALog.e("Utils", "clearAgooBindCache", e2, new Object[0]);
        }
    }

    public static void a(Context context, int i2) {
        try {
            synchronized (f8700b) {
                f8699a = i2;
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                editorEdit.putInt(Constants.SP_KEY_DEBUG_MODE, i2);
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "setMode", th, new Object[0]);
        }
    }

    @Deprecated
    public static void a() {
        try {
            AccsConfig.build();
        } catch (Throwable th) {
            ALog.e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:15:0x0037
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            byte[] r2 = com.taobao.accs.utl.v.f8700b     // Catch: java.lang.Throwable -> L3a
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "ACCS_SDK"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r3, r1)     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = r4.getString(r5, r0)     // Catch: java.lang.Throwable -> L37
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "getSpValue"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "value"
            r2[r1] = r3     // Catch: java.lang.Throwable -> L32
            r3 = 1
            r2[r3] = r4     // Catch: java.lang.Throwable -> L32
            com.taobao.accs.utl.ALog.i(r5, r0, r2)     // Catch: java.lang.Throwable -> L32
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L45
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "getSpValue use default!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L32
            com.taobao.accs.utl.ALog.e(r5, r0, r2)     // Catch: java.lang.Throwable -> L32
            r4 = r6
            goto L45
        L32:
            r5 = move-exception
            goto L3c
        L34:
            r5 = move-exception
            r0 = r4
            goto L38
        L37:
            r5 = move-exception
        L38:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L37
            throw r5     // Catch: java.lang.Throwable -> L3a
        L3a:
            r5 = move-exception
            r4 = r0
        L3c:
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r0 = "Utils"
            java.lang.String r1 = "getSpValue fail"
            com.taobao.accs.utl.ALog.e(r0, r1, r5, r6)
        L45:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.v.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
