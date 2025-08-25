package i.e.b.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import bean.SurveyH5Bean;

/* loaded from: classes2.dex */
class f {

    /* renamed from: g, reason: collision with root package name */
    private static volatile f f16911g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f16912h = false;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f16918f;

    /* renamed from: a, reason: collision with root package name */
    a f16913a = new a("udid");

    /* renamed from: b, reason: collision with root package name */
    a f16914b = new a("oaid");

    /* renamed from: d, reason: collision with root package name */
    a f16916d = new a("vaid");

    /* renamed from: c, reason: collision with root package name */
    a f16915c = new a("aaid");

    /* renamed from: e, reason: collision with root package name */
    private c f16917e = new c();

    private f() {
    }

    private static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(SurveyH5Bean.VALUE);
                if (columnIndex >= 0) {
                    dVar.f16908a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f16909b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.f16910c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (f16911g == null) {
            synchronized (f.class) {
                if (f16911g == null) {
                    f16911g = new f();
                }
            }
        }
        return f16911g;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    static void a(String str) {
        boolean z = f16912h;
    }

    public static void a(boolean z) {
        f16912h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r7 == 0) goto L3b
            i.e.b.b.a.a.d r8 = a(r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.f16909b     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r1 != r2) goto L34
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f16908a     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r8 == 0) goto L35
        L34:
            r0 = 1
        L35:
            if (r7 == 0) goto L3a
            r7.close()
        L3a:
            return r0
        L3b:
            if (r7 == 0) goto L5c
        L3d:
            r7.close()
            goto L5c
        L41:
            r8 = move-exception
            goto L5d
        L43:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L41
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L41
            r1.append(r8)     // Catch: java.lang.Throwable -> L41
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L41
            a(r8)     // Catch: java.lang.Throwable -> L41
            if (r7 == 0) goto L5c
            goto L3d
        L5c:
            return r0
        L5d:
            if (r7 == 0) goto L62
            r7.close()
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.b.b.a.a.f.a(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v0, types: [i.e.b.b.a.a.a] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r10, i.e.b.b.a.a.a r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f16902c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r6 = r11.f16902c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r1 == 0) goto L7e
            i.e.b.b.a.a.d r2 = a(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r0 = r2.f16908a     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.a(r0)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            long r3 = r2.f16910c     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.a(r3)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r3 = r2.f16909b     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r11.a(r3)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r4 = r11.f16902c     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r11 = r11.f16903d     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r3.append(r11)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            a(r11)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            int r11 = r2.f16909b     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L93
            r9.b(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r11 != 0) goto L93
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
        L7a:
            a(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            goto L93
        L7e:
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r11 == 0) goto L93
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            goto L7a
        L93:
            if (r1 == 0) goto L98
            r1.close()
        L98:
            r11 = r0
            goto Lbf
        L9a:
            r10 = move-exception
            goto Lc0
        L9c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La5
        La0:
            r10 = move-exception
            r1 = r0
            goto Lc0
        La3:
            r10 = move-exception
            r11 = r0
        La5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r10)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> La0
            a(r10)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbf
            r0.close()
        Lbf:
            return r11
        Lc0:
            if (r1 == 0) goto Lc5
            r1.close()
        Lc5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.b.b.a.a.f.b(android.content.Context, i.e.b.b.a.a.a):java.lang.String");
    }

    private static String b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.f16918f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.f16918f = new e();
        context.registerReceiver(this.f16918f, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.f16901b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    final boolean a(Context context, boolean z) throws PackageManager.NameNotFoundException {
        if (this.f16917e.a() && !z) {
            return this.f16917e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.f16917e.a() && this.f16917e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.f16917e.b();
        }
        this.f16917e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.f16917e.a(zA);
        return zA;
    }
}
