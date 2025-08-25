package androidx.core.util;

import androidx.exifinterface.media.ExifInterface;
import h.q2.t.i0;
import h.y;
import i.c.a.d;

/* compiled from: Pair.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\n¢\u0006\u0002\u0010\u0005\u001a2\u0010\u0006\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\n¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\bH\u0086\b\u001aA\u0010\t\u001a\u001e\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0003H\u00030\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\b¨\u0006\n"}, d2 = {"component1", "F", "kotlin.jvm.PlatformType", ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "toAndroidPair", "Lkotlin/Pair;", "toKotlinPair", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class PairKt {
    public static final <F, S> F component1(@d android.util.Pair<F, S> pair) {
        i0.f(pair, "$receiver");
        return (F) pair.first;
    }

    public static final <F, S> S component2(@d android.util.Pair<F, S> pair) {
        i0.f(pair, "$receiver");
        return (S) pair.second;
    }

    @d
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@d h.i0<? extends F, ? extends S> i0Var) {
        i0.f(i0Var, "$receiver");
        return new android.util.Pair<>(i0Var.getFirst(), i0Var.getSecond());
    }

    @d
    public static final <F, S> h.i0<F, S> toKotlinPair(@d android.util.Pair<F, S> pair) {
        i0.f(pair, "$receiver");
        return new h.i0<>(pair.first, pair.second);
    }
}
