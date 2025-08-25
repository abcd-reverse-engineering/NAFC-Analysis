package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;

/* compiled from: ProgressDrawable.java */
/* loaded from: classes.dex */
public class c extends b implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    protected int f8350b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int f8351c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected int f8352d = 0;

    /* renamed from: f, reason: collision with root package name */
    protected Path f8354f = new Path();

    /* renamed from: e, reason: collision with root package name */
    protected ValueAnimator f8353e = ValueAnimator.ofInt(30, 3600);

    public c() {
        this.f8353e.setDuration(com.heytap.mcssdk.constant.a.q);
        this.f8353e.setInterpolator(new LinearInterpolator());
        this.f8353e.setRepeatCount(-1);
        this.f8353e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int iMax = Math.max(1, iWidth / 20);
        if (this.f8350b != iWidth || this.f8351c != iHeight) {
            this.f8354f.reset();
            float f2 = iWidth - iMax;
            float f3 = iHeight / 2;
            float f4 = iMax;
            this.f8354f.addCircle(f2, f3, f4, Path.Direction.CW);
            float f5 = iWidth - (iMax * 5);
            this.f8354f.addRect(f5, r4 - iMax, f2, r4 + iMax, Path.Direction.CW);
            this.f8354f.addCircle(f5, f3, f4, Path.Direction.CW);
            this.f8350b = iWidth;
            this.f8351c = iHeight;
        }
        canvas.save();
        float f6 = iWidth / 2;
        float f7 = iHeight / 2;
        canvas.rotate(this.f8352d, f6, f7);
        for (int i2 = 0; i2 < 12; i2++) {
            this.f8349a.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f8354f, this.f8349a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f8353e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8352d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f8353e.isRunning()) {
            return;
        }
        this.f8353e.addUpdateListener(this);
        this.f8353e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f8353e.isRunning()) {
            this.f8353e.removeAllListeners();
            this.f8353e.removeAllUpdateListeners();
            this.f8353e.cancel();
        }
    }
}
