package i.a.a.a.n;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
class f {
    f() {
    }

    static int a(byte b2) throws i.a.a.a.e {
        int iDigit = Character.digit((char) b2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new i.a.a.a.e("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b2));
    }
}
