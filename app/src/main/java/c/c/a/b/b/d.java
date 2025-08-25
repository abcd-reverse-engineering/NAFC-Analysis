package c.c.a.b.b;

/* compiled from: IntentType.java */
/* loaded from: classes.dex */
public enum d {
    REAL_NAME_VERIFY(c.c.a.b.a.a.K0, c.REAL_NAME_VERIFY),
    BIND_MOBILE_PHONE("BindMobilePhoneIntent", c.BIND_MOBILE_PHONE),
    BIND_EMAIL("BindEmailIntent", c.BIND_EMAIL);


    /* renamed from: a, reason: collision with root package name */
    private final String f3114a;

    /* renamed from: b, reason: collision with root package name */
    private final c f3115b;

    d(String str, c cVar) {
        this.f3114a = str;
        this.f3115b = cVar;
    }

    public c getFeatureType() {
        return this.f3115b;
    }

    public String getType() {
        return this.f3114a;
    }
}
