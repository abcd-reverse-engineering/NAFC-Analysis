package i.a.a.a.m;

/* compiled from: AbstractCaverphone.java */
/* loaded from: classes2.dex */
public abstract class a implements i.a.a.a.i {
    public boolean a(String str, String str2) throws i.a.a.a.g {
        return a(str).equals(a(str2));
    }

    @Override // i.a.a.a.f
    public Object encode(Object obj) throws i.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new i.a.a.a.g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
}
