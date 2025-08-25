package c.b.c.d0;

import java.util.Map;

/* compiled from: UPCAWriter.java */
/* loaded from: classes.dex */
public final class t implements c.b.c.v {

    /* renamed from: a, reason: collision with root package name */
    private final i f2591a = new i();

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws c.b.c.w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<c.b.c.g, ?> map) throws c.b.c.w {
        if (aVar == c.b.c.a.UPC_A) {
            return this.f2591a.a(a(str), c.b.c.a.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + aVar);
    }

    private static String a(String str) {
        int length = str.length();
        if (length == 11) {
            int iCharAt = 0;
            for (int i2 = 0; i2 < 11; i2++) {
                iCharAt += (str.charAt(i2) - '0') * (i2 % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - iCharAt) % 10);
        } else if (length != 12) {
            throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return '0' + str;
    }
}
