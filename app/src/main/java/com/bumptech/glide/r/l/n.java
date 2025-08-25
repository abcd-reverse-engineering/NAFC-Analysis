package com.bumptech.glide.r.l;

import androidx.annotation.NonNull;

/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class n<Z> extends b<Z> {

    /* renamed from: b, reason: collision with root package name */
    private final int f5307b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5308c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.r.l.p
    public void a(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.r.l.p
    public final void b(@NonNull o oVar) {
        if (com.bumptech.glide.util.l.b(this.f5307b, this.f5308c)) {
            oVar.a(this.f5307b, this.f5308c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f5307b + " and height: " + this.f5308c + ", either provide dimensions in the constructor or call override()");
    }

    public n(int i2, int i3) {
        this.f5307b = i2;
        this.f5308c = i3;
    }
}
