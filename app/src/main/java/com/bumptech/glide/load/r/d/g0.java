package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4866a = "TransformationUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final int f4867b = 6;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4869d = 7;

    /* renamed from: f, reason: collision with root package name */
    private static final Paint f4871f;

    /* renamed from: h, reason: collision with root package name */
    private static final Lock f4873h;

    /* renamed from: c, reason: collision with root package name */
    private static final Paint f4868c = new Paint(6);

    /* renamed from: e, reason: collision with root package name */
    private static final Paint f4870e = new Paint(7);

    /* renamed from: g, reason: collision with root package name */
    private static final Set<String> f4872g = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));

    /* compiled from: TransformationUtils.java */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4874a;

        a(int i2) {
            this.f4874a = i2;
        }

        @Override // com.bumptech.glide.load.r.d.g0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i2 = this.f4874a;
            canvas.drawRoundRect(rectF, i2, i2, paint);
        }
    }

    /* compiled from: TransformationUtils.java */
    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f4875a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f4876b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f4877c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f4878d;

        b(float f2, float f3, float f4, float f5) {
            this.f4875a = f2;
            this.f4876b = f3;
            this.f4877c = f4;
            this.f4878d = f5;
        }

        @Override // com.bumptech.glide.load.r.d.g0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f2 = this.f4875a;
            float f3 = this.f4876b;
            float f4 = this.f4877c;
            float f5 = this.f4878d;
            path.addRoundRect(rectF, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    /* compiled from: TransformationUtils.java */
    private interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* compiled from: TransformationUtils.java */
    private static final class d implements Lock {
        d() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        f4873h = f4872g.contains(Build.MODEL) ? new ReentrantLock() : new d();
        f4871f = new Paint(7);
        f4871f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private g0() {
    }

    public static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    public static Lock a() {
        return f4873h;
    }

    public static Bitmap b(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            Log.isLoggable(f4866a, 2);
            return d(eVar, bitmap, i2, i3);
        }
        Log.isLoggable(f4866a, 2);
        return bitmap;
    }

    public static boolean b(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap c(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        int iMin = Math.min(i2, i3);
        float f2 = iMin;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f2 / width, f2 / height);
        float f4 = width * fMax;
        float f5 = fMax * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapA2 = eVar.a(iMin, iMin, a(bitmap));
        bitmapA2.setHasAlpha(true);
        f4873h.lock();
        try {
            Canvas canvas = new Canvas(bitmapA2);
            canvas.drawCircle(f3, f3, f3, f4870e);
            canvas.drawBitmap(bitmapA, (Rect) null, rectF, f4871f);
            a(canvas);
            f4873h.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.a(bitmapA);
            }
            return bitmapA2;
        } catch (Throwable th) {
            f4873h.unlock();
            throw th;
        }
    }

    public static Bitmap d(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            Log.isLoggable(f4866a, 2);
            return bitmap;
        }
        float fMin = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            Log.isLoggable(f4866a, 2);
            return bitmap;
        }
        Bitmap bitmapA = eVar.a((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), b(bitmap));
        a(bitmap, bitmapA);
        if (Log.isLoggable(f4866a, 2)) {
            String str = "request: " + i2 + "x" + i3;
            String str2 = "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight();
            String str3 = "toReuse: " + bitmapA.getWidth() + "x" + bitmapA.getHeight();
            String str4 = "minPct:   " + fMin;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    public static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        float width;
        float width2;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float height = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            width = i3 / bitmap.getHeight();
            width2 = (i2 - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i2 / bitmap.getWidth();
            height = (i3 - (bitmap.getHeight() * width)) * 0.5f;
            width2 = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapA = eVar.a(i2, i3, b(bitmap));
        a(bitmap, bitmapA);
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    public static Bitmap b(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2) {
        com.bumptech.glide.util.j.a(i2 > 0, "roundingRadius must be greater than 0.");
        return a(eVar, bitmap, new a(i2));
    }

    @NonNull
    private static Bitmap.Config b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(@NonNull Bitmap bitmap, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            Log.isLoggable(f4866a, 6);
            return bitmap;
        }
    }

    public static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2) {
        if (!b(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapA = eVar.a(Math.round(rectF.width()), Math.round(rectF.height()), b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapA.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    private static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config configA = a(bitmap);
        if (configA.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapA = eVar.a(bitmap.getWidth(), bitmap.getHeight(), configA);
        new Canvas(bitmapA).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapA;
    }

    @NonNull
    private static Bitmap.Config a(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @Deprecated
    public static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3, int i4) {
        return b(eVar, bitmap, i4);
    }

    public static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return a(eVar, bitmap, new b(f2, f3, f4, f5));
    }

    private static Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, c cVar) {
        Bitmap.Config configA = a(bitmap);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapA2 = eVar.a(bitmapA.getWidth(), bitmapA.getHeight(), configA);
        bitmapA2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapA, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapA2.getWidth(), bitmapA2.getHeight());
        f4873h.lock();
        try {
            Canvas canvas = new Canvas(bitmapA2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            a(canvas);
            f4873h.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.a(bitmapA);
            }
            return bitmapA2;
        } catch (Throwable th) {
            f4873h.unlock();
            throw th;
        }
    }

    private static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        f4873h.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f4868c);
            a(canvas);
        } finally {
            f4873h.unlock();
        }
    }

    @VisibleForTesting
    static void a(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
