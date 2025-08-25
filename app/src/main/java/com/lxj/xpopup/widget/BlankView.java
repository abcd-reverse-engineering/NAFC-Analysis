package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class BlankView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f8134a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f8135b;

    /* renamed from: c, reason: collision with root package name */
    public int f8136c;

    /* renamed from: d, reason: collision with root package name */
    public int f8137d;

    /* renamed from: e, reason: collision with root package name */
    public int f8138e;

    public BlankView(Context context) {
        super(context);
        this.f8134a = new Paint();
        this.f8135b = null;
        this.f8136c = 0;
        this.f8137d = -1;
        this.f8138e = Color.parseColor("#DDDDDD");
    }

    private void a() {
        this.f8134a.setAntiAlias(true);
        this.f8134a.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8134a.setColor(this.f8137d);
        RectF rectF = this.f8135b;
        int i2 = this.f8136c;
        canvas.drawRoundRect(rectF, i2, i2, this.f8134a);
        this.f8134a.setStyle(Paint.Style.STROKE);
        this.f8134a.setColor(this.f8138e);
        RectF rectF2 = this.f8135b;
        int i3 = this.f8136c;
        canvas.drawRoundRect(rectF2, i3, i3, this.f8134a);
        this.f8134a.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8135b = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8134a = new Paint();
        this.f8135b = null;
        this.f8136c = 0;
        this.f8137d = -1;
        this.f8138e = Color.parseColor("#DDDDDD");
        a();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8134a = new Paint();
        this.f8135b = null;
        this.f8136c = 0;
        this.f8137d = -1;
        this.f8138e = Color.parseColor("#DDDDDD");
        a();
    }
}
