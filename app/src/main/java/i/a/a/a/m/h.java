package i.a.a.a.m;

/* compiled from: RefinedSoundex.java */
/* loaded from: classes2.dex */
public class h implements i.a.a.a.i {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16794b = "01360240043788015936020505";

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f16795c = f16794b.toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final h f16796d = new h();

    /* renamed from: a, reason: collision with root package name */
    private final char[] f16797a;

    public h() {
        this.f16797a = f16795c;
    }

    public int a(String str, String str2) throws i.a.a.a.g {
        return j.a(this, str, str2);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        String strA = j.a(str);
        if (strA.length() == 0) {
            return strA;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strA.charAt(0));
        char c2 = '*';
        for (int i2 = 0; i2 < strA.length(); i2++) {
            char cA = a(strA.charAt(i2));
            if (cA != c2) {
                if (cA != 0) {
                    stringBuffer.append(cA);
                }
                c2 = cA;
            }
        }
        return stringBuffer.toString();
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public h(char[] cArr) {
        this.f16797a = new char[cArr.length];
        System.arraycopy(cArr, 0, this.f16797a, 0, cArr.length);
    }

    char a(char c2) {
        if (Character.isLetter(c2)) {
            return this.f16797a[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public h(String str) {
        this.f16797a = str.toCharArray();
    }
}
