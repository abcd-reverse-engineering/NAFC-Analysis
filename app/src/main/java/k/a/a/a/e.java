package k.a.a.a;

import android.content.Context;

/* compiled from: HonorPackageManager.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f17027a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f17028b = new Object();

    private e(Context context) {
        new f(context);
    }

    public static e a(Context context) {
        synchronized (f17028b) {
            if (f17027a == null) {
                if (context.getApplicationContext() != null) {
                    f17027a = new e(context.getApplicationContext());
                } else {
                    f17027a = new e(context);
                }
            }
        }
        return f17027a;
    }

    public String a() {
        return "com.hihonor.id";
    }
}
