package h.z2;

import h.n0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CharJVM.kt */
/* loaded from: classes2.dex */
public class d {
    @i.c.a.d
    public static final a a(char c2) {
        return a.Companion.a(Character.getType(c2));
    }

    @i.c.a.d
    public static final b b(char c2) {
        return b.Companion.a(Character.getDirectionality(c2));
    }

    @h.m2.f
    private static final boolean c(char c2) {
        return Character.isDefined(c2);
    }

    @h.m2.f
    private static final boolean d(char c2) {
        return Character.isDigit(c2);
    }

    @h.m2.f
    private static final boolean e(char c2) {
        return Character.isHighSurrogate(c2);
    }

    @h.m2.f
    private static final boolean f(char c2) {
        return Character.isISOControl(c2);
    }

    @h.m2.f
    private static final boolean g(char c2) {
        return Character.isIdentifierIgnorable(c2);
    }

    @h.m2.f
    private static final boolean h(char c2) {
        return Character.isJavaIdentifierPart(c2);
    }

    @h.m2.f
    private static final boolean i(char c2) {
        return Character.isJavaIdentifierStart(c2);
    }

    @h.m2.f
    private static final boolean j(char c2) {
        return Character.isLetter(c2);
    }

    @h.m2.f
    private static final boolean k(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    @h.m2.f
    private static final boolean l(char c2) {
        return Character.isLowSurrogate(c2);
    }

    @h.m2.f
    private static final boolean m(char c2) {
        return Character.isLowerCase(c2);
    }

    @h.m2.f
    private static final boolean n(char c2) {
        return Character.isTitleCase(c2);
    }

    @h.m2.f
    private static final boolean o(char c2) {
        return Character.isUpperCase(c2);
    }

    public static final boolean p(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    @h.m2.f
    private static final char q(char c2) {
        return Character.toLowerCase(c2);
    }

    @h.m2.f
    private static final char r(char c2) {
        return Character.toTitleCase(c2);
    }

    @h.m2.f
    private static final char s(char c2) {
        return Character.toUpperCase(c2);
    }

    public static final int a(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    @n0
    public static int a(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new h.v2.k(2, 36));
    }
}
