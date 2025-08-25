package com.airbnb.lottie.b0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.b.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3442a = 1000000000;

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f3443b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<Path> f3444c = new b();

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<Path> f3445d = new c();

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadLocal<float[]> f3446e = new d();

    /* renamed from: f, reason: collision with root package name */
    private static final float f3447f = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: g, reason: collision with root package name */
    private static float f3448g = -1.0f;

    /* compiled from: Utils.java */
    class a extends ThreadLocal<PathMeasure> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* compiled from: Utils.java */
    class b extends ThreadLocal<Path> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* compiled from: Utils.java */
    class c extends ThreadLocal<Path> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* compiled from: Utils.java */
    class d extends ThreadLocal<float[]> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public float[] initialValue() {
            return new float[4];
        }
    }

    private h() {
    }

    public static int a(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (i2 * 31 * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (i2 * 31 * f4);
        }
        return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF3.x + pointF.x;
            float f3 = pointF.y + pointF3.y;
            float f4 = pointF2.x;
            float f5 = f4 + pointF4.x;
            float f6 = pointF2.y;
            path.cubicTo(f2, f3, f5, f6 + pointF4.y, f4, f6);
        }
        return path;
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 < i6) {
            return false;
        }
        return i3 > i6 || i4 >= i7;
    }

    public static boolean b(Matrix matrix) {
        float[] fArr = f3446e.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = f3446e.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f3447f;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void a(Path path, @Nullable t tVar) {
        if (tVar == null || tVar.f()) {
            return;
        }
        a(path, ((com.airbnb.lottie.w.c.c) tVar.d()).i() / 100.0f, ((com.airbnb.lottie.w.c.c) tVar.b()).i() / 100.0f, ((com.airbnb.lottie.w.c.c) tVar.c()).i() / 360.0f);
    }

    public static void a(Path path, float f2, float f3, float f4) {
        com.airbnb.lottie.e.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f3443b.get();
        Path path2 = f3444c.get();
        Path path3 = f3445d.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float fMin = Math.min(f5, f6) + f7;
            float fMax = Math.max(f5, f6) + f7;
            if (fMin >= length && fMax >= length) {
                fMin = g.a(fMin, length);
                fMax = g.a(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = g.a(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = g.a(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
            return;
        }
        com.airbnb.lottie.e.b("applyTrimPathIfNeeded");
    }

    public static float a() {
        if (f3448g == -1.0f) {
            f3448g = Resources.getSystem().getDisplayMetrics().density;
        }
        return f3448g;
    }

    public static float a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean a(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void a(Canvas canvas, RectF rectF, Paint paint) {
        a(canvas, rectF, paint, 31);
    }

    public static void a(Canvas canvas, RectF rectF, Paint paint, int i2) {
        com.airbnb.lottie.e.a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.airbnb.lottie.e.b("Utils#saveLayer");
    }

    public static Bitmap a(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        com.airbnb.lottie.w.a aVar = new com.airbnb.lottie.w.a();
        aVar.setAntiAlias(true);
        aVar.setColor(-16776961);
        canvas.drawPath(path, aVar);
        return bitmapCreateBitmap;
    }
}
