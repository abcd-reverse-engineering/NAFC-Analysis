package com.google.gson;

/* compiled from: ReflectionAccessFilter.java */
/* loaded from: classes.dex */
public interface v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f5754a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final v f5755b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final v f5756c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final v f5757d = new d();

    /* compiled from: ReflectionAccessFilter.java */
    class a implements v {
        a() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.c(cls) ? e.BLOCK_INACCESSIBLE : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    class b implements v {
        b() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.c(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    class c implements v {
        c() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.a(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    class d implements v {
        d() {
        }

        @Override // com.google.gson.v
        public e a(Class<?> cls) {
            return com.google.gson.b0.n.b(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    /* compiled from: ReflectionAccessFilter.java */
    public enum e {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    e a(Class<?> cls);
}
