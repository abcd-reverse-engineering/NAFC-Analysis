package com.luozm.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.NonNull;
import java.util.Random;

/* compiled from: DefaultCaptchaStrategy.java */
/* loaded from: classes.dex */
public class e extends d {
    public e(Context context) {
        super(context);
    }

    @Override // com.luozm.captcha.d
    public Path a(int i2) {
        int i3 = (int) (i2 / 4.0f);
        Path path = new Path();
        float f2 = i3;
        path.moveTo(0.0f, f2);
        path.rLineTo(f2, 0.0f);
        int i4 = -i3;
        float f3 = i4 / 2;
        path.rLineTo(0.0f, f3);
        path.rLineTo(f2, 0.0f);
        float f4 = i3 / 2;
        path.rLineTo(0.0f, f4);
        path.rLineTo(f2, 0.0f);
        path.rLineTo(0.0f, f2);
        path.rLineTo(f4, 0.0f);
        path.rLineTo(0.0f, f2);
        path.rLineTo(f3, 0.0f);
        path.rLineTo(0.0f, f2);
        float f5 = i4;
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f3);
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f4);
        path.rLineTo(f5, 0.0f);
        path.rLineTo(0.0f, f5);
        path.rLineTo(f4, 0.0f);
        path.rLineTo(0.0f, f5);
        path.rLineTo(f3, 0.0f);
        path.rLineTo(0.0f, f5);
        path.close();
        return path;
    }

    @Override // com.luozm.captcha.d
    @NonNull
    public f b(int i2, int i3, int i4) {
        Random random = new Random();
        int iNextInt = random.nextInt((i2 - i4) + 1);
        int iNextInt2 = random.nextInt((i3 - i4) + 1);
        if (iNextInt2 < 0) {
            iNextInt2 = 0;
        }
        return new f(iNextInt, iNextInt2);
    }

    @Override // com.luozm.captcha.d
    public Paint b() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setAlpha(165);
        return paint;
    }

    @Override // com.luozm.captcha.d
    @NonNull
    public f a(int i2, int i3, int i4) {
        if (c.a(c(), 25.0f) + i2 >= c().getResources().getDisplayMetrics().widthPixels) {
            i2 -= i4;
        }
        Random random = new Random();
        int iNextInt = random.nextInt((i2 - i4) + 1);
        if (iNextInt < i4) {
            iNextInt = i4;
        }
        int iNextInt2 = random.nextInt((i3 - i4) + 1);
        if (iNextInt2 < 0) {
            iNextInt2 = 0;
        }
        return new f(iNextInt, iNextInt2);
    }

    @Override // com.luozm.captcha.d
    public Paint a() {
        return new Paint();
    }

    @Override // com.luozm.captcha.d
    public void a(Canvas canvas, Path path) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 2.0f, 1.5f));
        canvas.drawPath(new Path(path), paint);
    }
}
