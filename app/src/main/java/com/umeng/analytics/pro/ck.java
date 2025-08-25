package com.umeng.analytics.pro;

/* compiled from: TField.java */
/* loaded from: classes2.dex */
public class ck {

    /* renamed from: a, reason: collision with root package name */
    public final String f10263a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10264b;

    /* renamed from: c, reason: collision with root package name */
    public final short f10265c;

    public ck() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(ck ckVar) {
        return this.f10264b == ckVar.f10264b && this.f10265c == ckVar.f10265c;
    }

    public String toString() {
        return "<TField name:'" + this.f10263a + "' type:" + ((int) this.f10264b) + " field-id:" + ((int) this.f10265c) + ">";
    }

    public ck(String str, byte b2, short s) {
        this.f10263a = str;
        this.f10264b = b2;
        this.f10265c = s;
    }
}
