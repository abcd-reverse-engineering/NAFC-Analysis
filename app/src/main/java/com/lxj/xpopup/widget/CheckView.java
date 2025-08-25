package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class CheckView extends View {

    /* renamed from: a, reason: collision with root package name */
    Paint f8139a;

    /* renamed from: b, reason: collision with root package name */
    int f8140b;

    /* renamed from: c, reason: collision with root package name */
    Path f8141c;

    public CheckView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8140b == 0) {
            return;
        }
        this.f8141c.moveTo(getMeasuredWidth() / 4, getMeasuredHeight() / 2);
        this.f8141c.lineTo(getMeasuredWidth() / 2, (getMeasuredHeight() * 3) / 4);
        this.f8141c.lineTo(getMeasuredWidth(), getMeasuredHeight() / 4);
        canvas.drawPath(this.f8141c, this.f8139a);
    }

    public void setColor(int i2) {
        this.f8140b = i2;
        this.f8139a.setColor(i2);
        postInvalidate();
    }

    public CheckView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8140b = 0;
        this.f8141c = new Path();
        this.f8139a = new Paint(1);
        this.f8139a.setStrokeWidth(c.a(context, 2.0f));
        this.f8139a.setStyle(Paint.Style.STROKE);
    }
}
