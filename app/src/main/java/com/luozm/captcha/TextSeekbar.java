package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: classes.dex */
class TextSeekbar extends AppCompatSeekBar {

    /* renamed from: a, reason: collision with root package name */
    private Paint f7860a;

    public TextSeekbar(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint.FontMetrics fontMetrics = this.f7860a.getFontMetrics();
        float f2 = fontMetrics.top;
        float f3 = fontMetrics.bottom;
        int height = getHeight() / 2;
    }

    public TextSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.style.seekbarSytle);
    }

    public TextSeekbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7860a = new Paint();
        this.f7860a.setTextAlign(Paint.Align.CENTER);
        this.f7860a.setTextSize(c.a(context, 14.0f));
        this.f7860a.setAntiAlias(true);
        this.f7860a.setColor(Color.parseColor("#545454"));
    }
}
