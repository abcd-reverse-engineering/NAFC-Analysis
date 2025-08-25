package k.a.a.a.j;

import android.content.Context;

/* compiled from: LogX.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static b f17041a;

    public static synchronized void a(Context context) {
        f17041a = d.b(context);
    }

    public static void b(String str, String str2, boolean z) {
        b bVar = f17041a;
        if (bVar == null || !z) {
            return;
        }
        bVar.c(str, str2);
    }

    public static void c(String str, String str2, boolean z) {
        b bVar = f17041a;
        if (bVar == null || !z) {
            return;
        }
        bVar.a(str, str2);
    }

    public static void d(String str, String str2, boolean z) {
        b bVar = f17041a;
        if (bVar == null || !z) {
            return;
        }
        bVar.c(str, str2);
    }

    public static void a(String str, String str2, boolean z) {
        b bVar = f17041a;
        if (bVar == null || !z) {
            return;
        }
        bVar.b(str, str2);
    }
}
