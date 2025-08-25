package i.a.a.a.m;

/* compiled from: Soundex.java */
/* loaded from: classes2.dex */
public class i implements i.a.a.a.i {

    /* renamed from: c, reason: collision with root package name */
    public static final String f16798c = "01230120022455012623010202";

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f16799d = f16798c.toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final i f16800e = new i();

    /* renamed from: a, reason: collision with root package name */
    private int f16801a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f16802b;

    public i() {
        this.f16801a = 4;
        this.f16802b = f16799d;
    }

    private char[] b() {
        return this.f16802b;
    }

    public int a(String str, String str2) throws i.a.a.a.g {
        return j.a(this, str, str2);
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        String strA = j.a(str);
        if (strA.length() == 0) {
            return strA;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = strA.charAt(0);
        int i2 = 1;
        char cA = a(strA, 0);
        int i3 = 1;
        while (i2 < strA.length() && i3 < cArr.length) {
            int i4 = i2 + 1;
            char cA2 = a(strA, i2);
            if (cA2 != 0) {
                if (cA2 != '0' && cA2 != cA) {
                    cArr[i3] = cA2;
                    i3++;
                }
                cA = cA2;
            }
            i2 = i4;
        }
        return new String(cArr);
    }

    private char a(String str, int i2) {
        char cCharAt;
        char cA = a(str.charAt(i2));
        if (i2 > 1 && cA != '0' && ('H' == (cCharAt = str.charAt(i2 - 1)) || 'W' == cCharAt)) {
            char cCharAt2 = str.charAt(i2 - 2);
            if (a(cCharAt2) == cA || 'H' == cCharAt2 || 'W' == cCharAt2) {
                return (char) 0;
            }
        }
        return cA;
    }

    public i(char[] cArr) {
        this.f16801a = 4;
        this.f16802b = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f16802b, 0, cArr.length);
    }

    public int a() {
        return this.f16801a;
    }

    public i(String str) {
        this.f16801a = 4;
        this.f16802b = str.toCharArray();
    }

    private char a(char c2) {
        int i2 = c2 - 'A';
        if (i2 >= 0 && i2 < b().length) {
            return b()[i2];
        }
        throw new IllegalArgumentException("The character is not mapped: " + c2);
    }

    public void a(int i2) {
        this.f16801a = i2;
    }
}
