package com.umeng.socialize;

/* loaded from: classes2.dex */
public class SocializeException extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    private static final long f11512b = 1;

    /* renamed from: a, reason: collision with root package name */
    protected int f11513a;

    /* renamed from: c, reason: collision with root package name */
    private String f11514c;

    public SocializeException(int i2, String str) {
        super(str);
        this.f11513a = 5000;
        this.f11514c = "";
        this.f11513a = i2;
        this.f11514c = str;
    }

    public int getErrorCode() {
        return this.f11513a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f11514c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.f11513a = 5000;
        this.f11514c = "";
        this.f11514c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f11513a = 5000;
        this.f11514c = "";
        this.f11514c = str;
    }
}
