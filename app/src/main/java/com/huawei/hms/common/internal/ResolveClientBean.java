package com.huawei.hms.common.internal;

/* loaded from: classes.dex */
public class ResolveClientBean {

    /* renamed from: a, reason: collision with root package name */
    private final int f6772a;

    /* renamed from: b, reason: collision with root package name */
    private final AnyClient f6773b;

    /* renamed from: c, reason: collision with root package name */
    private int f6774c;

    public ResolveClientBean(AnyClient anyClient, int i2) {
        this.f6773b = anyClient;
        this.f6772a = Objects.hashCode(anyClient);
        this.f6774c = i2;
    }

    public void clientReconnect() {
        this.f6773b.connect(this.f6774c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.f6773b.equals(((ResolveClientBean) obj).f6773b);
    }

    public AnyClient getClient() {
        return this.f6773b;
    }

    public int hashCode() {
        return this.f6772a;
    }
}
