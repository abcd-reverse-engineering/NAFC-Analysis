package com.airbnb.lottie.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

/* compiled from: MutablePair.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class i<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    T f3836a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    T f3837b;

    private static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(T t, T t2) {
        this.f3836a = t;
        this.f3837b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return b(pair.first, this.f3836a) && b(pair.second, this.f3837b);
    }

    public int hashCode() {
        T t = this.f3836a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f3837b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f3836a) + c.c.a.b.a.a.f3100g + String.valueOf(this.f3837b) + "}";
    }
}
