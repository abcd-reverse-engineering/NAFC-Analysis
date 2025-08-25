package com.bumptech.glide.load.p;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f4570a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j f4571b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final j f4572c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final j f4573d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final j f4574e = new e();

    /* compiled from: DiskCacheStrategy.java */
    class a extends j {
        a() {
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(com.bumptech.glide.load.a aVar) {
            return aVar == com.bumptech.glide.load.a.REMOTE;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
            return (aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || aVar == com.bumptech.glide.load.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    class b extends j {
        b() {
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(com.bumptech.glide.load.a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    class c extends j {
        c() {
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(com.bumptech.glide.load.a aVar) {
            return (aVar == com.bumptech.glide.load.a.DATA_DISK_CACHE || aVar == com.bumptech.glide.load.a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    class d extends j {
        d() {
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(com.bumptech.glide.load.a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
            return (aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || aVar == com.bumptech.glide.load.a.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean b() {
            return true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    class e extends j {
        e() {
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(com.bumptech.glide.load.a aVar) {
            return aVar == com.bumptech.glide.load.a.REMOTE;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.p.j
        public boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
            return ((z && aVar == com.bumptech.glide.load.a.DATA_DISK_CACHE) || aVar == com.bumptech.glide.load.a.LOCAL) && cVar == com.bumptech.glide.load.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(com.bumptech.glide.load.a aVar);

    public abstract boolean a(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar);

    public abstract boolean b();
}
