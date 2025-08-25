package i.a.a.a.n;

import i.a.a.a.g;
import i.a.a.a.h;
import i.a.a.a.i;
import i.a.a.a.k.l;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/* compiled from: QuotedPrintableCodec.java */
/* loaded from: classes2.dex */
public class c implements i.a.a.a.b, i.a.a.a.a, i, h {

    /* renamed from: b, reason: collision with root package name */
    private static final BitSet f16871b = new BitSet(256);

    /* renamed from: c, reason: collision with root package name */
    private static final byte f16872c = 61;

    /* renamed from: d, reason: collision with root package name */
    private static final byte f16873d = 9;

    /* renamed from: e, reason: collision with root package name */
    private static final byte f16874e = 32;

    /* renamed from: a, reason: collision with root package name */
    private final String f16875a;

    static {
        for (int i2 = 33; i2 <= 60; i2++) {
            f16871b.set(i2);
        }
        for (int i3 = 62; i3 <= 126; i3++) {
            f16871b.set(i3);
        }
        f16871b.set(9);
        f16871b.set(32);
    }

    public c() {
        this("UTF-8");
    }

    private static final void a(int i2, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = Character.toUpperCase(Character.forDigit((i2 >> 4) & 15, 16));
        char upperCase2 = Character.toUpperCase(Character.forDigit(i2 & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    public String b(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return l.b(encode(str.getBytes(str2)));
    }

    @Override // i.a.a.a.a
    public byte[] decode(byte[] bArr) throws i.a.a.a.e {
        return a(bArr);
    }

    @Override // i.a.a.a.b
    public byte[] encode(byte[] bArr) {
        return a(f16871b, bArr);
    }

    public c(String str) {
        this.f16875a = str;
    }

    @Override // i.a.a.a.h
    public String decode(String str) throws i.a.a.a.e {
        if (str == null) {
            return null;
        }
        try {
            return a(str, a());
        } catch (UnsupportedEncodingException e2) {
            throw new i.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new g("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws i.a.a.a.e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new i.a.a.a.e("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
    }

    public static final byte[] a(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = f16871b;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = bArr[i2];
            if (i3 < 0) {
                i3 += 256;
            }
            if (bitSet.get(i3)) {
                byteArrayOutputStream.write(i3);
            } else {
                a(i3, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] a(byte[] bArr) throws i.a.a.a.e {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 61) {
                int i3 = i2 + 1;
                try {
                    int iA = f.a(bArr[i3]);
                    i2 = i3 + 1;
                    byteArrayOutputStream.write((char) ((iA << 4) + f.a(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new i.a.a.a.e("Invalid quoted-printable encoding", e2);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // i.a.a.a.i
    public String a(String str) throws g {
        if (str == null) {
            return null;
        }
        try {
            return b(str, a());
        } catch (UnsupportedEncodingException e2) {
            throw new g(e2.getMessage(), e2);
        }
    }

    public String a(String str, String str2) throws i.a.a.a.e, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(l.b(str)), str2);
    }

    public String a() {
        return this.f16875a;
    }
}
