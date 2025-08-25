package h.l2;

import h.m2.f;
import h.t0;

/* compiled from: bitwiseOperations.kt */
/* loaded from: classes2.dex */
public final class a {
    @f
    @t0(version = "1.1")
    private static final byte a(byte b2) {
        return (byte) (~b2);
    }

    @f
    @t0(version = "1.1")
    private static final byte a(byte b2, byte b3) {
        return (byte) (b2 & b3);
    }

    @f
    @t0(version = "1.1")
    private static final short a(short s) {
        return (short) (~s);
    }

    @f
    @t0(version = "1.1")
    private static final short a(short s, short s2) {
        return (short) (s & s2);
    }

    @f
    @t0(version = "1.1")
    private static final byte b(byte b2, byte b3) {
        return (byte) (b2 | b3);
    }

    @f
    @t0(version = "1.1")
    private static final short b(short s, short s2) {
        return (short) (s | s2);
    }

    @f
    @t0(version = "1.1")
    private static final byte c(byte b2, byte b3) {
        return (byte) (b2 ^ b3);
    }

    @f
    @t0(version = "1.1")
    private static final short c(short s, short s2) {
        return (short) (s ^ s2);
    }
}
