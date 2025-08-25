package com.umeng.analytics.pro;

/* compiled from: TMessage.java */
/* loaded from: classes2.dex */
public final class cn {

    /* renamed from: a, reason: collision with root package name */
    public final String f10271a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10272b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10273c;

    public cn() {
        this("", (byte) 0, 0);
    }

    public boolean a(cn cnVar) {
        return this.f10271a.equals(cnVar.f10271a) && this.f10272b == cnVar.f10272b && this.f10273c == cnVar.f10273c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof cn) {
            return a((cn) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f10271a + "' type: " + ((int) this.f10272b) + " seqid:" + this.f10273c + ">";
    }

    public cn(String str, byte b2, int i2) {
        this.f10271a = str;
        this.f10272b = b2;
        this.f10273c = i2;
    }
}
