package com.umeng.socialize.net.dplus.cache1;

/* loaded from: classes2.dex */
public abstract class IReader<T> {

    /* renamed from: a, reason: collision with root package name */
    private String f11804a;
    public T result;

    public IReader(String str) {
        this.f11804a = str;
    }

    public static double formatSize(long j2) {
        return (j2 / 1024.0d) / 1024.0d;
    }

    public abstract void create(String str);

    public String getLogFileName() {
        return this.f11804a;
    }
}
