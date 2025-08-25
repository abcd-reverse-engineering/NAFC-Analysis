package com.bumptech.glide.r.l;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: PreloadTarget.java */
/* loaded from: classes.dex */
public final class m<Z> extends e<Z> {

    /* renamed from: e, reason: collision with root package name */
    private static final int f5304e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final Handler f5305f = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.k f5306d;

    /* compiled from: PreloadTarget.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((m) message.obj).b();
            return true;
        }
    }

    private m(com.bumptech.glide.k kVar, int i2, int i3) {
        super(i2, i3);
        this.f5306d = kVar;
    }

    public static <Z> m<Z> a(com.bumptech.glide.k kVar, int i2, int i3) {
        return new m<>(kVar, i2, i3);
    }

    void b() {
        this.f5306d.a((p<?>) this);
    }

    @Override // com.bumptech.glide.r.l.p
    public void c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull Z z, @Nullable com.bumptech.glide.r.m.f<? super Z> fVar) {
        f5305f.obtainMessage(1, this).sendToTarget();
    }
}
