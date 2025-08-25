package i.e.b.a.a.a;

import android.content.Context;
import i.e.a.a.a.a;

/* compiled from: OpenIDSDK.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(Context context) {
        a.b.f16892b = a.c.b.f16899a.a(context.getApplicationContext());
        a.b.f16891a = true;
    }

    public static String b(Context context) {
        if (a.b.f16891a) {
            return a.c.b.f16899a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.b.f16891a) {
            return a.c.b.f16899a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.b.f16891a) {
            return a.c.b.f16899a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.b.f16891a) {
            return a.c.b.f16899a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.b.f16891a) {
            return a.b.f16892b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
