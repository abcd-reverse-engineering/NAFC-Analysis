package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class aa extends m implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    static bk f9160c;

    /* renamed from: d, reason: collision with root package name */
    static y f9161d;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f9162e = !aa.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public bk f9163a = null;

    /* renamed from: b, reason: collision with root package name */
    public y f9164b = null;

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        bk bkVar = this.f9163a;
        if (bkVar != null) {
            lVar.a((m) bkVar, 0);
        }
        y yVar = this.f9164b;
        if (yVar != null) {
            lVar.a((m) yVar, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f9162e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        aa aaVar = (aa) obj;
        return n.a(this.f9163a, aaVar.f9163a) && n.a(this.f9164b, aaVar.f9164b);
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
    public void a(k kVar) {
        if (f9160c == null) {
            f9160c = new bk();
        }
        this.f9163a = (bk) kVar.a((m) f9160c, 0, false);
        if (f9161d == null) {
            f9161d = new y();
        }
        this.f9164b = (y) kVar.a((m) f9161d, 1, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
        i iVar = new i(sb, i2);
        iVar.a((m) this.f9163a, "baseStrategy");
        iVar.a((m) this.f9164b, "grayStrategy");
    }
}
