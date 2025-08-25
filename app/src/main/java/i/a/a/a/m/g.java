package i.a.a.a.m;

/* compiled from: Metaphone.java */
/* loaded from: classes2.dex */
public class g implements i.a.a.a.i {

    /* renamed from: b, reason: collision with root package name */
    private static final String f16790b = "AEIOU";

    /* renamed from: c, reason: collision with root package name */
    private static final String f16791c = "EIY";

    /* renamed from: d, reason: collision with root package name */
    private static final String f16792d = "CSPTG";

    /* renamed from: a, reason: collision with root package name */
    private int f16793a = 4;

    private boolean a(int i2, int i3) {
        return i3 + 1 == i2;
    }

    private boolean a(StringBuffer stringBuffer, int i2) {
        return f16790b.indexOf(stringBuffer.charAt(i2)) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.a.a.m.g.b(java.lang.String):java.lang.String");
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    private boolean a(StringBuffer stringBuffer, int i2, char c2) {
        return i2 >= 0 && i2 < stringBuffer.length() - 1 && stringBuffer.charAt(i2 + 1) == c2;
    }

    private boolean a(StringBuffer stringBuffer, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i2, str.length() + i2).equals(str);
    }

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }

    public int a() {
        return this.f16793a;
    }

    public void a(int i2) {
        this.f16793a = i2;
    }

    private boolean b(StringBuffer stringBuffer, int i2, char c2) {
        return i2 > 0 && i2 < stringBuffer.length() && stringBuffer.charAt(i2 - 1) == c2;
    }
}
