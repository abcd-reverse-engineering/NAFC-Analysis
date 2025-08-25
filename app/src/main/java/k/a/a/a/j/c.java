package k.a.a.a.j;

import k.a.a.a.j.f.a;

/* compiled from: LogFile.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f17036a;

    /* compiled from: LogFile.java */
    public interface a {
        void a(String str);
    }

    public static void a(a aVar) {
        f17036a = aVar;
    }

    private static boolean a(int i2) {
        return true;
    }

    public static void b(String str, String str2) {
        if (a(4)) {
            a.b bVarA = k.a.a.a.j.f.a.a(4, str);
            bVarA.a(str2);
            a(bVarA.a());
        }
    }

    private static void b(k.a.a.a.j.f.a aVar) {
    }

    public static void a(String str, String str2) {
        if (a(6)) {
            a.b bVarA = k.a.a.a.j.f.a.a(6, str);
            bVarA.a(str2);
            a(bVarA.a());
        }
    }

    private static void a(k.a.a.a.j.f.a aVar) {
        b(aVar);
        a aVar2 = f17036a;
        if (aVar2 != null) {
            aVar2.a(aVar.toString());
        }
    }
}
