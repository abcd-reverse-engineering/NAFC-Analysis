package com.bumptech.glide.load.p.b0;

import com.bumptech.glide.load.p.b0.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0059a {

    /* renamed from: c, reason: collision with root package name */
    private final long f4401c;

    /* renamed from: d, reason: collision with root package name */
    private final c f4402d;

    /* compiled from: DiskLruCacheFactory.java */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4403a;

        a(String str) {
            this.f4403a = str;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            return new File(this.f4403a);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4404a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4405b;

        b(String str, String str2) {
            this.f4404a = str;
            this.f4405b = str2;
        }

        @Override // com.bumptech.glide.load.p.b0.d.c
        public File a() {
            return new File(this.f4404a, this.f4405b);
        }
    }

    /* compiled from: DiskLruCacheFactory.java */
    public interface c {
        File a();
    }

    public d(String str, long j2) {
        this(new a(str), j2);
    }

    @Override // com.bumptech.glide.load.p.b0.a.InterfaceC0059a
    public com.bumptech.glide.load.p.b0.a build() {
        File fileA = this.f4402d.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.a(fileA, this.f4401c);
        }
        return null;
    }

    public d(String str, String str2, long j2) {
        this(new b(str, str2), j2);
    }

    public d(c cVar, long j2) {
        this.f4401c = j2;
        this.f4402d = cVar;
    }
}
