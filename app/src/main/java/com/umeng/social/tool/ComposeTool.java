package com.umeng.social.tool;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class ComposeTool {
    public static ComposeDirection direction = ComposeDirection.CUSTOM;
    public static int textColor = ViewCompat.MEASURED_STATE_MASK;
    public static int textsize = 18;
    public static int backgroundColor = -1;
    public static Typeface typeface = Typeface.DEFAULT;

    public enum ComposeDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        LEFTUP,
        LEFTDOWN,
        RIGHTUP,
        RIGHTDOWN,
        CUSTOM
    }

    public static Bitmap createCompose(Bitmap bitmap, Bitmap bitmap2, boolean z, int i2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(z ? Math.max(width, width2) : width2 + width + i2, z ? height2 + height + i2 : Math.max(height, height2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (z) {
            canvas.drawBitmap(bitmap2, 0.0f, height + i2, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap2, width + i2, 0.0f, (Paint) null);
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap createTextImage(String str, Bitmap bitmap, int i2, int i3) {
        Bitmap.Config config = bitmap.getConfig();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textsize);
        textPaint.setDither(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(typeface);
        StaticLayout staticLayout = new StaticLayout(str, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        textPaint.getTextBounds(str, 0, str.length(), new Rect());
        Bitmap bitmapCopy = bitmap.copy(config, true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width + (i2 * 2), height + staticLayout.getHeight() + (i3 * 4), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(backgroundColor);
        float f2 = i2;
        canvas.drawBitmap(bitmapCopy, f2, staticLayout.getHeight() + (i3 * 3), (Paint) null);
        canvas.translate(f2, i3);
        staticLayout.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap createWaterMask(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int i4 = (width / 2) - (width2 / 2);
        int height2 = (height / 2) - (bitmap2.getHeight() / 2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (direction == ComposeDirection.CUSTOM) {
            canvas.drawBitmap(bitmap2, i2, i3, (Paint) null);
        } else if (direction == ComposeDirection.UP) {
            canvas.drawBitmap(bitmap2, i4, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.DOWN) {
            canvas.drawBitmap(bitmap2, i4, height - r4, (Paint) null);
        } else if (direction == ComposeDirection.LEFT) {
            canvas.drawBitmap(bitmap2, 0.0f, height2, (Paint) null);
        } else if (direction == ComposeDirection.RIGHT) {
            canvas.drawBitmap(bitmap2, width - width2, height2, (Paint) null);
        } else if (direction == ComposeDirection.LEFTUP) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.LEFTDOWN) {
            canvas.drawBitmap(bitmap2, 0.0f, height - r4, (Paint) null);
        } else if (direction == ComposeDirection.RIGHTUP) {
            canvas.drawBitmap(bitmap2, width - width2, 0.0f, (Paint) null);
        } else if (direction == ComposeDirection.RIGHTDOWN) {
            canvas.drawBitmap(bitmap2, width - width2, height - r4, (Paint) null);
        }
        return bitmapCreateBitmap;
    }
}
