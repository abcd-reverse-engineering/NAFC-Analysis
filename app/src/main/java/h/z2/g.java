package h.z2;

import java.nio.charset.Charset;

/* compiled from: Charsets.kt */
@h.q2.e(name = "CharsetsKt")
/* loaded from: classes2.dex */
public final class g {
    @h.m2.f
    private static final Charset a(String str) {
        Charset charsetForName = Charset.forName(str);
        h.q2.t.i0.a((Object) charsetForName, "Charset.forName(charsetName)");
        return charsetForName;
    }
}
