package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3479a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final String f3480b = "LOTTIE";

    /* renamed from: c, reason: collision with root package name */
    private static final int f3481c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f3482d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f3483e;

    /* renamed from: f, reason: collision with root package name */
    private static long[] f3484f;

    /* renamed from: g, reason: collision with root package name */
    private static int f3485g;

    /* renamed from: h, reason: collision with root package name */
    private static int f3486h;

    /* renamed from: i, reason: collision with root package name */
    private static com.airbnb.lottie.z.f f3487i;

    /* renamed from: j, reason: collision with root package name */
    private static com.airbnb.lottie.z.e f3488j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile com.airbnb.lottie.z.h f3489k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile com.airbnb.lottie.z.g f3490l;

    /* compiled from: L.java */
    class a implements com.airbnb.lottie.z.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3491a;

        a(Context context) {
            this.f3491a = context;
        }

        @Override // com.airbnb.lottie.z.e
        @NonNull
        public File a() {
            return new File(this.f3491a.getCacheDir(), "lottie_network_cache");
        }
    }

    private e() {
    }

    public static void a(boolean z) {
        if (f3482d == z) {
            return;
        }
        f3482d = z;
        if (f3482d) {
            f3483e = new String[20];
            f3484f = new long[20];
        }
    }

    public static float b(String str) {
        int i2 = f3486h;
        if (i2 > 0) {
            f3486h = i2 - 1;
            return 0.0f;
        }
        if (!f3482d) {
            return 0.0f;
        }
        f3485g--;
        int i3 = f3485g;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f3483e[i3])) {
            TraceCompat.endSection();
            return (System.nanoTime() - f3484f[f3485g]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3483e[f3485g] + ".");
    }

    public static void a(String str) {
        if (f3482d) {
            int i2 = f3485g;
            if (i2 == 20) {
                f3486h++;
                return;
            }
            f3483e[i2] = str;
            f3484f[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f3485g++;
        }
    }

    @NonNull
    public static com.airbnb.lottie.z.h b(@NonNull Context context) {
        com.airbnb.lottie.z.h hVar = f3489k;
        if (hVar == null) {
            synchronized (com.airbnb.lottie.z.h.class) {
                hVar = f3489k;
                if (hVar == null) {
                    hVar = new com.airbnb.lottie.z.h(a(context), f3487i != null ? f3487i : new com.airbnb.lottie.z.b());
                    f3489k = hVar;
                }
            }
        }
        return hVar;
    }

    public static void a(com.airbnb.lottie.z.f fVar) {
        f3487i = fVar;
    }

    public static void a(com.airbnb.lottie.z.e eVar) {
        f3488j = eVar;
    }

    @NonNull
    public static com.airbnb.lottie.z.g a(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        com.airbnb.lottie.z.g gVar = f3490l;
        if (gVar == null) {
            synchronized (com.airbnb.lottie.z.g.class) {
                gVar = f3490l;
                if (gVar == null) {
                    gVar = new com.airbnb.lottie.z.g(f3488j != null ? f3488j : new a(applicationContext));
                    f3490l = gVar;
                }
            }
        }
        return gVar;
    }
}
