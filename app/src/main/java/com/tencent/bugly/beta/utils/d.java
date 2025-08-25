package com.tencent.bugly.beta.utils;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    a f8918a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f8919b;

    /* renamed from: c, reason: collision with root package name */
    private long f8920c;

    /* renamed from: d, reason: collision with root package name */
    private long f8921d;

    public d(String str, long j2, long j3) {
        this.f8919b = null;
        this.f8920c = 0L;
        this.f8921d = 0L;
        this.f8919b = str;
        this.f8920c = j2;
        this.f8921d = j3;
    }

    private boolean b() {
        return (this.f8920c == 0 || this.f8921d == 0) ? false : true;
    }

    private synchronized boolean c() {
        if (!b()) {
            return false;
        }
        if (this.f8918a == null) {
            try {
                this.f8918a = new a(this.f8919b);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public synchronized void a() {
        if (this.f8918a == null) {
            return;
        }
        this.f8918a.a();
        this.f8918a = null;
    }

    private synchronized String b(long j2) {
        if (this.f8918a == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            this.f8918a.b(this.f8920c);
            this.f8918a.b(j2);
            while (true) {
                byte b2 = this.f8918a.b();
                if (b2 == 0) {
                    break;
                }
                stringBuffer.append((char) b2);
            }
            this.f8918a.a();
            this.f8918a = new a(this.f8919b);
        } catch (Exception e2) {
            this.f8918a = null;
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public synchronized String a(long j2) {
        if (j2 >= 0) {
            if (j2 < this.f8921d) {
                if (this.f8918a == null && !c()) {
                    return null;
                }
                return b(j2);
            }
        }
        return null;
    }
}
