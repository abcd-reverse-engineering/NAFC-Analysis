package i.a.a.a.m;

/* compiled from: Caverphone.java */
/* loaded from: classes2.dex */
public class d implements i.a.a.a.i {

    /* renamed from: a, reason: collision with root package name */
    private final c f16773a = new c();

    @Override // i.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public String b(String str) {
        return this.f16773a.a(str);
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }
}
