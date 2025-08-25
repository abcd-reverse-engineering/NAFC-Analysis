package com.bumptech.glide.r.m;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.r.m.f;

/* compiled from: BitmapContainerTransitionFactory.java */
/* loaded from: classes.dex */
public abstract class a<R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    private final g<Drawable> f5325a;

    /* compiled from: BitmapContainerTransitionFactory.java */
    /* renamed from: com.bumptech.glide.r.m.a$a, reason: collision with other inner class name */
    private final class C0078a implements f<R> {

        /* renamed from: a, reason: collision with root package name */
        private final f<Drawable> f5326a;

        C0078a(f<Drawable> fVar) {
            this.f5326a = fVar;
        }

        @Override // com.bumptech.glide.r.m.f
        public boolean a(R r, f.a aVar) {
            return this.f5326a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.a(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f5325a = gVar;
    }

    protected abstract Bitmap a(R r);

    @Override // com.bumptech.glide.r.m.g
    public f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        return new C0078a(this.f5325a.a(aVar, z));
    }
}
