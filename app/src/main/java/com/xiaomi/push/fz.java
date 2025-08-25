package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.af;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class fz {

    /* renamed from: a, reason: collision with other field name */
    private static af f543a = new af(true);

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f12908a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static long f542a = System.currentTimeMillis();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f545a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static List<a> f547a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private static String f546a = "";

    /* renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f544a = null;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f12910a;

        /* renamed from: a, reason: collision with other field name */
        public long f548a;

        /* renamed from: a, reason: collision with other field name */
        public String f549a;

        /* renamed from: b, reason: collision with root package name */
        public int f12911b;

        /* renamed from: b, reason: collision with other field name */
        public long f550b;

        /* renamed from: b, reason: collision with other field name */
        public String f551b;

        public a(String str, long j2, int i2, int i3, String str2, long j3) {
            this.f549a = "";
            this.f548a = 0L;
            this.f12910a = -1;
            this.f12911b = -1;
            this.f551b = "";
            this.f550b = 0L;
            this.f549a = str;
            this.f548a = j2;
            this.f12910a = i2;
            this.f12911b = i3;
            this.f551b = str2;
            this.f550b = j3;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f549a, this.f549a) && TextUtils.equals(aVar.f551b, this.f551b) && aVar.f12910a == this.f12910a && aVar.f12911b == this.f12911b && Math.abs(aVar.f548a - this.f548a) <= com.heytap.mcssdk.constant.a.r;
        }
    }

    private static int b(Context context) {
        av avVarM144a = au.m144a();
        if (avVarM144a == null) {
            return -1;
        }
        return avVarM144a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f918a) {
                SQLiteDatabase writableDatabase = m444a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f549a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f548a));
                        contentValues.put(com.umeng.analytics.pro.bh.T, Integer.valueOf(aVar.f12910a));
                        contentValues.put("bytes", Long.valueOf(aVar.f550b));
                        contentValues.put("rcv", Integer.valueOf(aVar.f12911b));
                        contentValues.put(Constants.KEY_IMSI, aVar.f551b);
                        writableDatabase.insert(com.umeng.analytics.pro.d.F, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m447a(Context context) {
        f12908a = b(context);
    }

    public static int a(Context context) {
        if (f12908a == -1) {
            f12908a = b(context);
        }
        return f12908a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized String m445a(Context context) {
        if (TextUtils.isEmpty(f546a)) {
            return "";
        }
        return f546a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized void m448a(String str) {
        if (!j.m632d() && !TextUtils.isEmpty(str)) {
            f546a = str;
        }
    }

    public static void a(Context context, String str, long j2, boolean z, boolean z2, long j3) {
        a(context, str, a(a(context), j2, z, j3, z2), z, j3);
    }

    private static void a(final Context context, String str, long j2, boolean z, long j3) {
        int iA;
        boolean zIsEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (iA = a(context))) {
            return;
        }
        synchronized (f545a) {
            zIsEmpty = f547a.isEmpty();
            a(new a(str, j3, iA, z ? 1 : 0, iA == 0 ? m445a(context) : "", j2));
        }
        if (zIsEmpty) {
            f543a.a(new af.b() { // from class: com.xiaomi.push.fz.1
                @Override // com.xiaomi.push.af.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (fz.f545a) {
                        arrayList = new ArrayList(fz.f547a);
                        fz.f547a.clear();
                    }
                    fz.b(context, arrayList);
                }
            }, com.heytap.mcssdk.constant.a.r);
        }
    }

    private static long a(int i2, long j2, boolean z, long j3, boolean z2) {
        if (z && z2) {
            long j4 = f542a;
            f542a = j3;
            if (j3 - j4 > 30000 && j2 > 1024) {
                return j2 * 2;
            }
        }
        return (j2 * (i2 == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m444a(Context context) {
        com.xiaomi.push.providers.a aVar = f544a;
        if (aVar != null) {
            return aVar;
        }
        f544a = new com.xiaomi.push.providers.a(context);
        return f544a;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f547a) {
            if (aVar2.a(aVar)) {
                aVar2.f550b += aVar.f550b;
                return;
            }
        }
        f547a.add(aVar);
    }
}
