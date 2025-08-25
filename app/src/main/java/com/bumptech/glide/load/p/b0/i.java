package com.bumptech.glide.load.p.b0;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.load.p.v;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class i extends com.bumptech.glide.util.g<com.bumptech.glide.load.g, v<?>> implements j {

    /* renamed from: e, reason: collision with root package name */
    private j.a f4421e;

    public i(long j2) {
        super(j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull com.bumptech.glide.load.g gVar, @Nullable v<?> vVar) {
        j.a aVar = this.f4421e;
        if (aVar == null || vVar == null) {
            return;
        }
        aVar.a(vVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p.b0.j
    @Nullable
    public /* bridge */ /* synthetic */ v a(@NonNull com.bumptech.glide.load.g gVar, @Nullable v vVar) {
        return (v) super.b((i) gVar, (com.bumptech.glide.load.g) vVar);
    }

    @Override // com.bumptech.glide.load.p.b0.j
    @Nullable
    public /* bridge */ /* synthetic */ v a(@NonNull com.bumptech.glide.load.g gVar) {
        return (v) super.d(gVar);
    }

    @Override // com.bumptech.glide.load.p.b0.j
    public void a(@NonNull j.a aVar) {
        this.f4421e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int c(@Nullable v<?> vVar) {
        if (vVar == null) {
            return super.c(null);
        }
        return vVar.a();
    }

    @Override // com.bumptech.glide.load.p.b0.j
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }
}
