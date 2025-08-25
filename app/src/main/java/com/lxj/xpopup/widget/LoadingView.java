package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f8142a;

    /* renamed from: b, reason: collision with root package name */
    private float f8143b;

    /* renamed from: c, reason: collision with root package name */
    private float f8144c;

    /* renamed from: d, reason: collision with root package name */
    private float f8145d;

    /* renamed from: e, reason: collision with root package name */
    private ArgbEvaluator f8146e;

    /* renamed from: f, reason: collision with root package name */
    private int f8147f;

    /* renamed from: g, reason: collision with root package name */
    private int f8148g;

    /* renamed from: h, reason: collision with root package name */
    int f8149h;

    /* renamed from: i, reason: collision with root package name */
    float f8150i;

    /* renamed from: j, reason: collision with root package name */
    int f8151j;

    /* renamed from: k, reason: collision with root package name */
    float f8152k;

    /* renamed from: l, reason: collision with root package name */
    float f8153l;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f8154m;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView = LoadingView.this;
            loadingView.f8151j++;
            loadingView.invalidate();
        }
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8154m);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = this.f8149h - 1; i2 >= 0; i2--) {
            int iAbs = Math.abs(this.f8151j + i2);
            this.f8142a.setColor(((Integer) this.f8146e.evaluate((((iAbs % r2) + 1) * 1.0f) / this.f8149h, Integer.valueOf(this.f8147f), Integer.valueOf(this.f8148g))).intValue());
            float f2 = this.f8152k + this.f8144c;
            float f3 = (this.f8143b / 3.0f) + f2;
            float f4 = this.f8153l;
            canvas.drawLine(f2, f4, f3, f4, this.f8142a);
            canvas.drawCircle(f2, this.f8153l, this.f8145d / 2.0f, this.f8142a);
            canvas.drawCircle(f3, this.f8153l, this.f8145d / 2.0f, this.f8142a);
            canvas.rotate(this.f8150i, this.f8152k, this.f8153l);
        }
        postDelayed(this.f8154m, 80L);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8143b = getMeasuredWidth() / 2;
        this.f8144c = this.f8143b / 2.5f;
        this.f8152k = getMeasuredWidth() / 2;
        this.f8153l = getMeasuredHeight() / 2;
        this.f8145d *= (getMeasuredWidth() * 1.0f) / c.a(getContext(), 30.0f);
        this.f8142a.setStrokeWidth(this.f8145d);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8145d = 2.0f;
        this.f8146e = new ArgbEvaluator();
        this.f8147f = Color.parseColor("#CCCCCC");
        this.f8148g = Color.parseColor("#333333");
        this.f8149h = 12;
        this.f8150i = 360.0f / this.f8149h;
        this.f8151j = 0;
        this.f8154m = new a();
        this.f8142a = new Paint(1);
        this.f8145d = c.a(context, this.f8145d);
        this.f8142a.setStrokeWidth(this.f8145d);
    }
}
