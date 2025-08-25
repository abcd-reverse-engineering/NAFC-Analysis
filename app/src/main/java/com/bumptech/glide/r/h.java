package com.bumptech.glide.r;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.r.d.p;

/* compiled from: RequestOptions.java */
/* loaded from: classes.dex */
public class h extends a<h> {

    @Nullable
    private static h h0;

    @Nullable
    private static h i0;

    @Nullable
    private static h j0;

    @Nullable
    private static h k0;

    @Nullable
    private static h l0;

    @Nullable
    private static h m0;

    @Nullable
    private static h n0;

    @Nullable
    private static h o0;

    @NonNull
    @CheckResult
    public static h R() {
        if (l0 == null) {
            l0 = new h().b().a();
        }
        return l0;
    }

    @NonNull
    @CheckResult
    public static h S() {
        if (k0 == null) {
            k0 = new h().c().a();
        }
        return k0;
    }

    @NonNull
    @CheckResult
    public static h T() {
        if (m0 == null) {
            m0 = new h().d().a();
        }
        return m0;
    }

    @NonNull
    @CheckResult
    public static h U() {
        if (j0 == null) {
            j0 = new h().h().a();
        }
        return j0;
    }

    @NonNull
    @CheckResult
    public static h V() {
        if (o0 == null) {
            o0 = new h().f().a();
        }
        return o0;
    }

    @NonNull
    @CheckResult
    public static h W() {
        if (n0 == null) {
            n0 = new h().g().a();
        }
        return n0;
    }

    @NonNull
    @CheckResult
    public static h b(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new h().a(f2);
    }

    @NonNull
    @CheckResult
    public static h c(@NonNull n<Bitmap> nVar) {
        return new h().b(nVar);
    }

    @NonNull
    @CheckResult
    public static h e(@Nullable Drawable drawable) {
        return new h().a(drawable);
    }

    @NonNull
    @CheckResult
    public static h f(@Nullable Drawable drawable) {
        return new h().c(drawable);
    }

    @NonNull
    @CheckResult
    public static h g(@IntRange(from = 0, to = 100) int i2) {
        return new h().a(i2);
    }

    @NonNull
    @CheckResult
    public static h h(@DrawableRes int i2) {
        return new h().b(i2);
    }

    @NonNull
    @CheckResult
    public static h i(int i2) {
        return b(i2, i2);
    }

    @NonNull
    @CheckResult
    public static h j(@DrawableRes int i2) {
        return new h().e(i2);
    }

    @NonNull
    @CheckResult
    public static h k(@IntRange(from = 0) int i2) {
        return new h().f(i2);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull com.bumptech.glide.load.p.j jVar) {
        return new h().a(jVar);
    }

    @NonNull
    @CheckResult
    public static h e(boolean z) {
        if (z) {
            if (h0 == null) {
                h0 = new h().b(true).a();
            }
            return h0;
        }
        if (i0 == null) {
            i0 = new h().b(false).a();
        }
        return i0;
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull com.bumptech.glide.h hVar) {
        return new h().a(hVar);
    }

    @NonNull
    @CheckResult
    public static h b(int i2, int i3) {
        return new h().a(i2, i3);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull com.bumptech.glide.load.g gVar) {
        return new h().a(gVar);
    }

    @NonNull
    @CheckResult
    public static <T> h b(@NonNull com.bumptech.glide.load.i<T> iVar, @NonNull T t) {
        return new h().a((com.bumptech.glide.load.i<com.bumptech.glide.load.i<T>>) iVar, (com.bumptech.glide.load.i<T>) t);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull Class<?> cls) {
        return new h().a(cls);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull com.bumptech.glide.load.b bVar) {
        return new h().a(bVar);
    }

    @NonNull
    @CheckResult
    public static h b(@IntRange(from = 0) long j2) {
        return new h().a(j2);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull p pVar) {
        return new h().a(pVar);
    }

    @NonNull
    @CheckResult
    public static h b(@NonNull Bitmap.CompressFormat compressFormat) {
        return new h().a(compressFormat);
    }
}
