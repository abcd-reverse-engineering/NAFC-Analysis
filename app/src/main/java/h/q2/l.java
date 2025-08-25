package h.q2;

/* compiled from: KotlinReflectionNotSupportedError.kt */
/* loaded from: classes2.dex */
public class l extends Error {
    public l() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public l(@i.c.a.e String str) {
        super(str);
    }

    public l(@i.c.a.e String str, @i.c.a.e Throwable th) {
        super(str, th);
    }

    public l(@i.c.a.e Throwable th) {
        super(th);
    }
}
