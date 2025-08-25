package com.bumptech.glide.load.p.b0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.n.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.g<com.bumptech.glide.load.g, String> f4444a = new com.bumptech.glide.util.g<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f4445b = com.bumptech.glide.util.n.a.b(10, new a());

    /* compiled from: SafeKeyGenerator.java */
    class a implements a.d<b> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.n.a.d
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    private static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        final MessageDigest f4447a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.n.c f4448b = com.bumptech.glide.util.n.c.b();

        b(MessageDigest messageDigest) {
            this.f4447a = messageDigest;
        }

        @Override // com.bumptech.glide.util.n.a.f
        @NonNull
        public com.bumptech.glide.util.n.c c() {
            return this.f4448b;
        }
    }

    private String b(com.bumptech.glide.load.g gVar) {
        b bVar = (b) com.bumptech.glide.util.j.a(this.f4445b.acquire());
        try {
            gVar.a(bVar.f4447a);
            return com.bumptech.glide.util.l.a(bVar.f4447a.digest());
        } finally {
            this.f4445b.release(bVar);
        }
    }

    public String a(com.bumptech.glide.load.g gVar) {
        String strB;
        synchronized (this.f4444a) {
            strB = this.f4444a.b(gVar);
        }
        if (strB == null) {
            strB = b(gVar);
        }
        synchronized (this.f4444a) {
            this.f4444a.b(gVar, strB);
        }
        return strB;
    }
}
