package com.google.gson.b0.t;

import com.google.gson.b0.q.d;
import com.google.gson.z;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: SqlTypesSupport.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f5676a;

    /* renamed from: b, reason: collision with root package name */
    public static final d.b<? extends Date> f5677b;

    /* renamed from: c, reason: collision with root package name */
    public static final d.b<? extends Date> f5678c;

    /* renamed from: d, reason: collision with root package name */
    public static final z f5679d;

    /* renamed from: e, reason: collision with root package name */
    public static final z f5680e;

    /* renamed from: f, reason: collision with root package name */
    public static final z f5681f;

    /* compiled from: SqlTypesSupport.java */
    class a extends d.b<java.sql.Date> {
        a(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.gson.b0.q.d.b
        public java.sql.Date a(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    /* compiled from: SqlTypesSupport.java */
    class b extends d.b<Timestamp> {
        b(Class cls) {
            super(cls);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.gson.b0.q.d.b
        public Timestamp a(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f5676a = z;
        if (f5676a) {
            f5677b = new a(java.sql.Date.class);
            f5678c = new b(Timestamp.class);
            f5679d = com.google.gson.b0.t.a.f5670b;
            f5680e = com.google.gson.b0.t.b.f5672b;
            f5681f = c.f5674b;
            return;
        }
        f5677b = null;
        f5678c = null;
        f5679d = null;
        f5680e = null;
        f5681f = null;
    }

    private d() {
    }
}
