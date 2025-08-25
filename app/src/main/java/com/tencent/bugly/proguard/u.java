package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class u extends m implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f9443f = !u.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public String f9444a;

    /* renamed from: b, reason: collision with root package name */
    public String f9445b;

    /* renamed from: c, reason: collision with root package name */
    public String f9446c;

    /* renamed from: d, reason: collision with root package name */
    public long f9447d;

    /* renamed from: e, reason: collision with root package name */
    public String f9448e;

    public u() {
        this.f9444a = "";
        this.f9445b = "";
        this.f9446c = "";
        this.f9447d = 0L;
        this.f9448e = "";
    }

    public String a() {
        return this.f9445b;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9443f) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        u uVar = (u) obj;
        return n.a(this.f9444a, uVar.f9444a) && n.a(this.f9445b, uVar.f9445b) && n.a(this.f9446c, uVar.f9446c) && n.a(this.f9447d, uVar.f9447d) && n.a(this.f9448e, uVar.f9448e);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.f9444a, 0);
        lVar.a(this.f9445b, 1);
        String str = this.f9446c;
        if (str != null) {
            lVar.a(str, 2);
        }
        lVar.a(this.f9447d, 3);
        String str2 = this.f9448e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
    }

    public u(String str, String str2, String str3, long j2, String str4) {
        this.f9444a = "";
        this.f9445b = "";
        this.f9446c = "";
        this.f9447d = 0L;
        this.f9448e = "";
        this.f9444a = str;
        this.f9445b = str2;
        this.f9446c = str3;
        this.f9447d = j2;
        this.f9448e = str4;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.f9444a = kVar.a(0, true);
        this.f9445b = kVar.a(1, true);
        this.f9446c = kVar.a(2, false);
        this.f9447d = kVar.a(this.f9447d, 3, true);
        this.f9448e = kVar.a(4, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a(this.f9444a, "apkMd5");
        iVar.a(this.f9445b, "apkUrl");
        iVar.a(this.f9446c, "manifestMd5");
        iVar.a(this.f9447d, "fileSize");
        iVar.a(this.f9448e, "signatureMd5");
    }
}
