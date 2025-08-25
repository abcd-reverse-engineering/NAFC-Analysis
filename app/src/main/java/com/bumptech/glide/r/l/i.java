package com.bumptech.glide.r.l;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: FixedSizeDrawable.java */
/* loaded from: classes.dex */
public class i extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f5288a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f5289b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f5290c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f5291d;

    /* renamed from: e, reason: collision with root package name */
    private a f5292e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5293f;

    /* compiled from: FixedSizeDrawable.java */
    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f5294a;

        /* renamed from: b, reason: collision with root package name */
        final int f5295b;

        /* renamed from: c, reason: collision with root package name */
        final int f5296c;

        a(a aVar) {
            this(aVar.f5294a, aVar.f5295b, aVar.f5296c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new i(this, this.f5294a.newDrawable());
        }

        a(Drawable.ConstantState constantState, int i2, int i3) {
            this.f5294a = constantState;
            this.f5295b = i2;
            this.f5296c = i3;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new i(this, this.f5294a.newDrawable(resources));
        }
    }

    public i(Drawable drawable, int i2, int i3) {
        this(new a(drawable.getConstantState(), i2, i3), drawable);
    }

    private void a() {
        this.f5288a.setRectToRect(this.f5289b, this.f5290c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f5291d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f5288a);
        this.f5291d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(19)
    public int getAlpha() {
        return this.f5291d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f5291d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f5291d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5292e;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f5291d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5292e.f5296c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5292e.f5295b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f5291d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f5291d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5291d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        return this.f5291d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f5291d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f5293f && super.mutate() == this) {
            this.f5291d = this.f5291d.mutate();
            this.f5292e = new a(this.f5292e);
            this.f5293f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@NonNull Runnable runnable, long j2) {
        super.scheduleSelf(runnable, j2);
        this.f5291d.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f5291d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f5290c.set(i2, i3, i4, i5);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i2) {
        this.f5291d.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        this.f5291d.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f5291d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f5291d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f5291d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f5291d.unscheduleSelf(runnable);
    }

    i(a aVar, Drawable drawable) {
        this.f5292e = (a) com.bumptech.glide.util.j.a(aVar);
        this.f5291d = (Drawable) com.bumptech.glide.util.j.a(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f5288a = new Matrix();
        this.f5289b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f5290c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5291d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f5290c.set(rect);
        a();
    }
}
