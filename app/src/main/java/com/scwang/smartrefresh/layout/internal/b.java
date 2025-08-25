package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: PaintDrawable.java */
/* loaded from: classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    protected Paint f8349a = new Paint();

    protected b() {
        this.f8349a.setStyle(Paint.Style.FILL);
        this.f8349a.setAntiAlias(true);
        this.f8349a.setColor(-5592406);
    }

    public void a(int i2) {
        this.f8349a.setColor(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f8349a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f8349a.setColorFilter(colorFilter);
    }
}
