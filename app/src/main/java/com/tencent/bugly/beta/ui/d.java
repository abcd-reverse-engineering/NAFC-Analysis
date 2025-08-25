package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final int f8840a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f8841b;

    /* renamed from: c, reason: collision with root package name */
    long f8842c;

    /* renamed from: d, reason: collision with root package name */
    StringBuilder f8843d;

    public d(int i2, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("loading");
        this.f8843d = sb;
        this.f8840a = i2;
        this.f8841b = objArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i2;
        int i3;
        try {
            int i4 = this.f8840a;
            if (i4 == 1) {
                h hVar = (h) this.f8841b[0];
                TextView textView = (TextView) this.f8841b[1];
                Bitmap bitmap = (Bitmap) this.f8841b[2];
                int iIntValue = ((Integer) this.f8841b[3]).intValue();
                int measuredWidth = textView.getMeasuredWidth();
                int i5 = (int) (measuredWidth * 0.42857142857142855d);
                textView.setHeight(i5);
                if (hVar.u == null) {
                    if (iIntValue == 2) {
                        hVar.u = com.tencent.bugly.beta.global.a.a(bitmap, measuredWidth, i5, com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, 6.0f));
                    } else {
                        hVar.u = com.tencent.bugly.beta.global.a.a(bitmap, measuredWidth, i5, com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, 0.0f));
                    }
                    if (hVar.u != null) {
                        textView.setText("");
                        textView.setBackgroundDrawable(hVar.u);
                        textView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f8842c <= 300) {
                    return true;
                }
                this.f8842c = jCurrentTimeMillis;
                if (this.f8843d.length() > 9) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("loading");
                    this.f8843d = sb;
                } else {
                    this.f8843d.append(".");
                }
                textView.setText(this.f8843d.toString());
                return true;
            }
            if (i4 != 2) {
                if (i4 != 3) {
                    return false;
                }
                ViewGroup viewGroup = (ViewGroup) this.f8841b[0];
                if (viewGroup.getMeasuredHeight() > com.tencent.bugly.beta.global.a.a((Context) this.f8841b[1], 158.0f)) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = com.tencent.bugly.beta.global.a.a((Context) this.f8841b[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            }
            if (((Integer) this.f8841b[2]).intValue() <= 0) {
                return true;
            }
            int iIntValue2 = ((Integer) this.f8841b[0]).intValue();
            TextView textView2 = (TextView) this.f8841b[1];
            int measuredWidth2 = textView2.getMeasuredWidth();
            int measuredHeight = textView2.getMeasuredHeight();
            int i6 = (int) (com.tencent.bugly.beta.global.e.G.D.widthPixels * com.tencent.bugly.beta.global.e.G.D.heightPixels * 0.4f);
            if (measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i6) {
                return true;
            }
            this.f8841b[2] = 0;
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            if (iIntValue2 == 2) {
                i2 = 8;
                i3 = 7;
            } else {
                i2 = 0;
                i3 = 0;
            }
            paint.setColor(-3355444);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            float f2 = measuredWidth2;
            float f3 = measuredHeight;
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            float f4 = i2;
            canvas.drawRoundRect(rectF, f4, f4, paint);
            paint.setColor(-1);
            float f5 = i3;
            canvas.drawRoundRect(new RectF(2.0f, 2.0f, f2 - 2.0f, f3 - 2.0f), f5, f5, paint);
            paint.setColor(-3355444);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap2).drawRoundRect(rectF, f4, f4, paint);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap2);
            textView2.setBackgroundDrawable(bitmapDrawable);
            textView2.setOnTouchListener(new com.tencent.bugly.beta.global.c(1, bitmapDrawable2, bitmapDrawable));
            return true;
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
            return false;
        }
    }
}
