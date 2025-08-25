package com.bumptech.glide.load.r.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4973a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: com.bumptech.glide.load.r.e.a$a, reason: collision with other inner class name */
    public static class C0073a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.o.e.a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f4973a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.o.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.o.e
    @NonNull
    public ByteBuffer a() {
        this.f4973a.position(0);
        return this.f4973a;
    }
}
