package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a implements Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f9035a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f9036b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f9037c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9038d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9039e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f9040f = 0;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        long j2 = this.f9036b - aVar.f9036b;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }
}
