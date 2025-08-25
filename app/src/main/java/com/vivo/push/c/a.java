package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.u;
import java.util.HashMap;

/* compiled from: CoreConfigManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f11988a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f11989b = new HashMap<>();

    public a(Context context) {
        this.f11988a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.e():int");
    }

    public final int a() throws Throwable {
        int iA = a(1);
        u.d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(iA)));
        return iA;
    }

    public final int b() throws Throwable {
        int iA = a(4);
        u.d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(iA)));
        return iA;
    }

    public final boolean c() throws Throwable {
        int iA = a(8);
        u.d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(iA)));
        return iA == 0;
    }

    public final boolean d() throws Throwable {
        int iA = a(16);
        u.d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(iA)));
        return iA == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2 A[Catch: Exception -> 0x008d, TRY_ENTER, TryCatch #0 {Exception -> 0x008d, blocks: (B:41:0x0089, B:45:0x0091, B:47:0x0095, B:60:0x00b2, B:62:0x00b7, B:64:0x00bb), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:41:0x0089, B:45:0x0091, B:47:0x0095, B:60:0x00b2, B:62:0x00b7, B:64:0x00bb), top: B:79:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb A[Catch: Exception -> 0x00c7, TryCatch #5 {Exception -> 0x00c7, blocks: (B:69:0x00c3, B:73:0x00cb, B:75:0x00cf), top: B:80:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.c.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private int a(int i2) throws Throwable {
        int iE = e();
        if (iE != 0) {
            return iE;
        }
        HashMap<String, String> map = this.f11989b;
        if (map == null || map.size() == 0) {
            return 8006;
        }
        String str = this.f11989b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i2 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }
}
