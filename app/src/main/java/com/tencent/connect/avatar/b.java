package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import cn.cloudwalk.libproject.Contants;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class b extends View {

    /* renamed from: a, reason: collision with root package name */
    private Rect f9607a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f9608b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f9608b = new Paint();
    }

    public Rect a() {
        if (this.f9607a == null) {
            this.f9607a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int iMin = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), Contants.PREVIEW_W);
            int i2 = (measuredWidth - iMin) / 2;
            int i3 = (measuredHeight - iMin) / 2;
            this.f9607a.set(i2, i3, i2 + iMin, iMin + i3);
        }
        return this.f9607a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rectA = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f9608b.setStyle(Paint.Style.FILL);
        this.f9608b.setColor(Color.argb(100, 0, 0, 0));
        float f2 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f2, rectA.top, this.f9608b);
        canvas.drawRect(0.0f, rectA.bottom, f2, measuredHeight, this.f9608b);
        canvas.drawRect(0.0f, rectA.top, rectA.left, rectA.bottom, this.f9608b);
        canvas.drawRect(rectA.right, rectA.top, f2, rectA.bottom, this.f9608b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f9608b.setStyle(Paint.Style.STROKE);
        this.f9608b.setColor(-1);
        canvas.drawRect(rectA.left, rectA.top, rectA.right - 1, rectA.bottom, this.f9608b);
    }
}
