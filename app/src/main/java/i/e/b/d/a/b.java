package i.e.b.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* compiled from: DataBaseOperation.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f16938b = "VMS_SDK_DB";

    /* renamed from: c, reason: collision with root package name */
    private static final String f16939c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d, reason: collision with root package name */
    private static final String f16940d = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: e, reason: collision with root package name */
    private static final String f16941e = "value";

    /* renamed from: f, reason: collision with root package name */
    private static final String f16942f = "OAID";

    /* renamed from: g, reason: collision with root package name */
    private static final String f16943g = "AAID";

    /* renamed from: h, reason: collision with root package name */
    private static final String f16944h = "VAID";

    /* renamed from: i, reason: collision with root package name */
    private static final String f16945i = "OAIDBLACK";

    /* renamed from: j, reason: collision with root package name */
    private static final String f16946j = "OAIDSTATUS";

    /* renamed from: k, reason: collision with root package name */
    private static final String f16947k = "STATISTICS";

    /* renamed from: l, reason: collision with root package name */
    private static final int f16948l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static final int f16949m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 6;
    private static final int s = 7;
    private static final String t = "UDID";

    /* renamed from: a, reason: collision with root package name */
    private Context f16950a;

    b(Context context) {
        this.f16950a = context;
    }

    boolean a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        int iBulkInsert;
        if (i2 == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i2 != 7) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iBulkInsert = this.f16950a.getContentResolver().bulkInsert(uri, contentValuesArr);
            String str2 = "insert:" + iBulkInsert;
        } catch (Exception unused) {
        }
        return iBulkInsert != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[PHI: r0 r8
  0x0094: PHI (r0v2 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:40:0x00a1, B:32:0x0092] A[DONT_GENERATE, DONT_INLINE]
  0x0094: PHI (r8v8 android.database.Cursor) = (r8v7 android.database.Cursor), (r8v10 android.database.Cursor) binds: [B:40:0x00a1, B:32:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L64
            r1 = 1
            if (r8 == r1) goto L4e
            r1 = 2
            if (r8 == r1) goto L38
            r1 = 3
            if (r8 == r1) goto L31
            r1 = 4
            if (r8 == r1) goto L1b
            r9 = 5
            if (r8 == r9) goto L14
            r2 = r0
            goto L6b
        L14:
            java.lang.String r8 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L1b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L31:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L38:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L4e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L64:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L6a:
            r2 = r8
        L6b:
            if (r2 != 0) goto L6e
            return r0
        L6e:
            android.content.Context r8 = r7.f16950a     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            if (r8 == 0) goto L92
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            if (r9 == 0) goto L92
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            r0 = r9
            goto L92
        L90:
            r9 = move-exception
            goto L9a
        L92:
            if (r8 == 0) goto La4
        L94:
            r8.close()
            goto La4
        L98:
            r9 = move-exception
            r8 = r0
        L9a:
            if (r8 == 0) goto L9f
            r8.close()
        L9f:
            throw r9
        La0:
            r8 = r0
        La1:
            if (r8 == 0) goto La4
            goto L94
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.b.d.a.b.a(int, java.lang.String):java.lang.String");
    }

    boolean a(int i2, String str, String str2, String str3) {
        Uri uri;
        int iDelete;
        if (i2 != 6) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iDelete = this.f16950a.getContentResolver().delete(uri, "packageName=? and uid=?", new String[]{str2, str3});
            String str4 = "delete:" + iDelete;
        } catch (Exception unused) {
        }
        return iDelete != 0;
    }
}
