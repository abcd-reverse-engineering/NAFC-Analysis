package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.l;
import com.bumptech.glide.r.m.j;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class l<CHILD extends l<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.r.m.g<? super TranscodeType> f4234a = com.bumptech.glide.r.m.e.b();

    private CHILD c() {
        return this;
    }

    @NonNull
    public final CHILD a() {
        return (CHILD) a(com.bumptech.glide.r.m.e.b());
    }

    final com.bumptech.glide.r.m.g<? super TranscodeType> b() {
        return this.f4234a;
    }

    @NonNull
    public final CHILD a(int i2) {
        return (CHILD) a(new com.bumptech.glide.r.m.h(i2));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m37clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public final CHILD a(@NonNull j.a aVar) {
        return (CHILD) a(new com.bumptech.glide.r.m.i(aVar));
    }

    @NonNull
    public final CHILD a(@NonNull com.bumptech.glide.r.m.g<? super TranscodeType> gVar) {
        this.f4234a = (com.bumptech.glide.r.m.g) com.bumptech.glide.util.j.a(gVar);
        return (CHILD) c();
    }
}
