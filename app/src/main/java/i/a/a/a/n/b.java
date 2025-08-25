package i.a.a.a.n;

import i.a.a.a.g;
import i.a.a.a.h;
import i.a.a.a.i;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/* compiled from: QCodec.java */
/* loaded from: classes2.dex */
public class b extends d implements i, h {

    /* renamed from: f, reason: collision with root package name */
    private static final BitSet f16866f = new BitSet(256);

    /* renamed from: g, reason: collision with root package name */
    private static final byte f16867g = 32;

    /* renamed from: h, reason: collision with root package name */
    private static final byte f16868h = 95;

    /* renamed from: d, reason: collision with root package name */
    private final String f16869d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16870e;

    static {
        f16866f.set(32);
        f16866f.set(33);
        f16866f.set(34);
        f16866f.set(35);
        f16866f.set(36);
        f16866f.set(37);
        f16866f.set(38);
        f16866f.set(39);
        f16866f.set(40);
        f16866f.set(41);
        f16866f.set(42);
        f16866f.set(43);
        f16866f.set(44);
        f16866f.set(45);
        f16866f.set(46);
        f16866f.set(47);
        for (int i2 = 48; i2 <= 57; i2++) {
            f16866f.set(i2);
        }
        f16866f.set(58);
        f16866f.set(59);
        f16866f.set(60);
        f16866f.set(62);
        f16866f.set(64);
        for (int i3 = 65; i3 <= 90; i3++) {
            f16866f.set(i3);
        }
        f16866f.set(91);
        f16866f.set(92);
        f16866f.set(93);
        f16866f.set(94);
        f16866f.set(96);
        for (int i4 = 97; i4 <= 122; i4++) {
            f16866f.set(i4);
        }
        f16866f.set(123);
        f16866f.set(124);
        f16866f.set(125);
        f16866f.set(126);
    }

    public b() {
        this("UTF-8");
    }

    @Override // i.a.a.a.n.d
    protected String a() {
        return "Q";
    }

    @Override // i.a.a.a.n.d
    protected byte[] a(byte[] bArr) throws i.a.a.a.e {
        boolean z;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (bArr[i2] == 95) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return c.a(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3];
            if (b2 != 95) {
                bArr2[i3] = b2;
            } else {
                bArr2[i3] = f16867g;
            }
        }
        return c.a(bArr2);
    }

    @Override // i.a.a.a.n.d
    protected byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArrA = c.a(f16866f, bArr);
        if (this.f16870e) {
            for (int i2 = 0; i2 < bArrA.length; i2++) {
                if (bArrA[i2] == 32) {
                    bArrA[i2] = f16868h;
                }
            }
        }
        return bArrA;
    }

    public boolean c() {
        return this.f16870e;
    }

    @Override // i.a.a.a.h
    public String decode(String str) throws i.a.a.a.e {
        if (str == null) {
            return null;
        }
        try {
            return b(str);
        } catch (UnsupportedEncodingException e2) {
            throw new i.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new g("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
    }

    public b(String str) {
        this.f16870e = false;
        this.f16869d = str;
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws i.a.a.a.e {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new i.a.a.a.e("Objects of type " + obj.getClass().getName() + " cannot be decoded using Q codec");
    }

    public String b(String str, String str2) throws g {
        if (str == null) {
            return null;
        }
        try {
            return a(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new g(e2.getMessage(), e2);
        }
    }

    public String b() {
        return this.f16869d;
    }

    @Override // i.a.a.a.i
    public String a(String str) throws g {
        if (str == null) {
            return null;
        }
        return b(str, b());
    }

    public void a(boolean z) {
        this.f16870e = z;
    }
}
