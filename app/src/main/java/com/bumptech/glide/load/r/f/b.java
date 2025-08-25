package com.bumptech.glide.load.r.f;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.r;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.j;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements v<T>, r {

    /* renamed from: a, reason: collision with root package name */
    protected final T f4976a;

    public b(T t) {
        this.f4976a = (T) j.a(t);
    }

    public void c() {
        T t = this.f4976a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.f4976a.getConstantState();
        return constantState == null ? this.f4976a : (T) constantState.newDrawable();
    }
}
