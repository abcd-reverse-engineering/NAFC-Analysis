package com.hihonor.honorid.d.b;

/* compiled from: TokenInvalidatedException.java */
/* loaded from: classes.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private String f6223a;

    public a(String str) {
        super(str);
        this.f6223a = str;
    }

    public String getErrorDesc() {
        return this.f6223a;
    }

    public void setErrorDesc(String str) {
        this.f6223a = str;
    }
}
