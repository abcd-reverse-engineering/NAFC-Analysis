package util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.HashMap;

/* compiled from: EncodingUtils.java */
/* loaded from: classes2.dex */
public class e1 {
    public static Bitmap a(String str, int i2, int i3, Bitmap bitmap) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    HashMap map = new HashMap();
                    map.put(c.b.c.g.CHARACTER_SET, "utf-8");
                    map.put(c.b.c.g.ERROR_CORRECTION, c.b.c.f0.c.f.H);
                    c.b.c.z.b bVarA = new c.b.c.f0.b().a(str, c.b.c.a.QR_CODE, i2, i3, map);
                    int[] iArr = new int[i2 * i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        for (int i5 = 0; i5 < i2; i5++) {
                            if (bVarA.b(i5, i4)) {
                                iArr[(i4 * i2) + i5] = -16777216;
                            } else {
                                iArr[(i4 * i2) + i5] = -1;
                            }
                        }
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                    bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                    return bitmap != null ? a(bitmapCreateBitmap, bitmap) : bitmapCreateBitmap;
                }
            } catch (c.b.c.w e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        if (width2 == 0 || height2 == 0) {
            return bitmap;
        }
        float f2 = ((width * 1.0f) / 5.0f) / width2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.scale(f2, f2, width / 2, height / 2);
            canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
            canvas.save();
            canvas.restore();
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            e2.getStackTrace();
            return null;
        }
    }
}
