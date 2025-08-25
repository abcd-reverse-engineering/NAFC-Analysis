package anetwork.channel.entity;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d implements a.a.g {

    /* renamed from: a, reason: collision with root package name */
    private String f2200a;

    /* renamed from: b, reason: collision with root package name */
    private String f2201b;

    public d(String str, String str2) {
        this.f2200a = str;
        this.f2201b = str2;
    }

    @Override // a.a.g
    public String getKey() {
        return this.f2200a;
    }

    @Override // a.a.g
    public String getValue() {
        return this.f2201b;
    }
}
