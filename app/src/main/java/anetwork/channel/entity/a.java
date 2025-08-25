package anetwork.channel.entity;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a implements a.a.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f2185a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2186b;

    public a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f2185a = str;
        this.f2186b = str2;
    }

    @Override // a.a.a
    public String getName() {
        return this.f2185a;
    }

    @Override // a.a.a
    public String getValue() {
        return this.f2186b;
    }
}
