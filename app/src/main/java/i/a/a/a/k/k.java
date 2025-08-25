package i.a.a.a.k;

import com.umeng.analytics.pro.cw;
import java.io.UnsupportedEncodingException;

/* compiled from: Hex.java */
/* loaded from: classes2.dex */
public class k implements i.a.a.a.b, i.a.a.a.a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16766b = "UTF-8";

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f16767c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f16768d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    private final String f16769a;

    public k() {
        this.f16769a = "UTF-8";
    }

    public static byte[] a(char[] cArr) throws i.a.a.a.e {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new i.a.a.a.e("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int iA = a(cArr[i2], i2) << 4;
            int i4 = i2 + 1;
            int iA2 = iA | a(cArr[i4], i4);
            i2 = i4 + 1;
            bArr[i3] = (byte) (iA2 & 255);
            i3++;
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    @Override // i.a.a.a.a
    public byte[] decode(byte[] bArr) throws i.a.a.a.e {
        try {
            return a(new String(bArr, a()).toCharArray());
        } catch (UnsupportedEncodingException e2) {
            throw new i.a.a.a.e(e2.getMessage(), e2);
        }
    }

    @Override // i.a.a.a.b
    public byte[] encode(byte[] bArr) {
        return l.a(b(bArr), a());
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.f16769a + "]";
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        try {
            return a(obj instanceof String ? ((String) obj).getBytes(a()) : (byte[]) obj);
        } catch (UnsupportedEncodingException e2) {
            throw new i.a.a.a.g(e2.getMessage(), e2);
        } catch (ClassCastException e3) {
            throw new i.a.a.a.g(e3.getMessage(), e3);
        }
    }

    public k(String str) {
        this.f16769a = str;
    }

    @Override // i.a.a.a.d
    public Object decode(Object obj) throws i.a.a.a.e {
        try {
            return a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e2) {
            throw new i.a.a.a.e(e2.getMessage(), e2);
        }
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, true);
    }

    public static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? f16767c : f16768d);
    }

    protected static char[] a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & cw.f10303m];
        }
        return cArr2;
    }

    protected static int a(char c2, int i2) throws i.a.a.a.e {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new i.a.a.a.e("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public String a() {
        return this.f16769a;
    }
}
