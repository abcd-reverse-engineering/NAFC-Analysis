package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.r.d.p;
import com.bumptech.glide.load.r.d.x;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: f, reason: collision with root package name */
    static final String f4927f = "Downsampler";

    /* renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<com.bumptech.glide.load.b> f4928g = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.DEFAULT);

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<com.bumptech.glide.load.k> f4929h = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", com.bumptech.glide.load.k.SRGB);

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.i<p> f4930i = p.f4924h;

    /* renamed from: j, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Boolean> f4931j = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: k, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Boolean> f4932k = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* renamed from: l, reason: collision with root package name */
    private static final String f4933l = "image/vnd.wap.wbmp";

    /* renamed from: m, reason: collision with root package name */
    private static final String f4934m = "image/x-ico";
    private static final Set<String> n = Collections.unmodifiableSet(new HashSet(Arrays.asList(f4933l, f4934m)));
    private static final b o = new a();
    private static final Set<ImageHeaderParser.ImageType> p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> q = com.bumptech.glide.util.l.a(0);

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4935a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f4936b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f4937c;

    /* renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f4938d;

    /* renamed from: e, reason: collision with root package name */
    private final w f4939e = w.a();

    /* compiled from: Downsampler.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a() {
        }

        @Override // com.bumptech.glide.load.r.d.q.b
        public void a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) {
        }
    }

    /* compiled from: Downsampler.java */
    public interface b {
        void a();

        void a(com.bumptech.glide.load.p.a0.e eVar, Bitmap bitmap) throws IOException;
    }

    public q(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.p.a0.e eVar, com.bumptech.glide.load.p.a0.b bVar) {
        this.f4938d = list;
        this.f4936b = (DisplayMetrics) com.bumptech.glide.util.j.a(displayMetrics);
        this.f4935a = (com.bumptech.glide.load.p.a0.e) com.bumptech.glide.util.j.a(eVar);
        this.f4937c = (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar);
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (q) {
            q.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return com.bumptech.glide.load.o.m.c();
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private static int[] b(x xVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.p.a0.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(xVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public com.bumptech.glide.load.p.v<Bitmap> a(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.j jVar) throws IOException {
        return a(inputStream, i2, i3, jVar, o);
    }

    public com.bumptech.glide.load.p.v<Bitmap> a(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.j jVar, b bVar) throws IOException {
        return a(new x.a(inputStream, this.f4938d, this.f4937c), i2, i3, jVar, bVar);
    }

    @RequiresApi(21)
    public com.bumptech.glide.load.p.v<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.bumptech.glide.load.j jVar) throws IOException {
        return a(new x.b(parcelFileDescriptor, this.f4938d, this.f4937c), i2, i3, jVar, o);
    }

    private com.bumptech.glide.load.p.v<Bitmap> a(x xVar, int i2, int i3, com.bumptech.glide.load.j jVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f4937c.b(65536, byte[].class);
        BitmapFactory.Options optionsA = a();
        optionsA.inTempStorage = bArr;
        com.bumptech.glide.load.b bVar2 = (com.bumptech.glide.load.b) jVar.a(f4928g);
        com.bumptech.glide.load.k kVar = (com.bumptech.glide.load.k) jVar.a(f4929h);
        try {
            return g.a(a(xVar, optionsA, (p) jVar.a(p.f4924h), bVar2, kVar, jVar.a(f4932k) != null && ((Boolean) jVar.a(f4932k)).booleanValue(), i2, i3, ((Boolean) jVar.a(f4931j)).booleanValue(), bVar), this.f4935a);
        } finally {
            c(optionsA);
            this.f4937c.put(bArr);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private Bitmap a(x xVar, BitmapFactory.Options options, p pVar, com.bumptech.glide.load.b bVar, com.bumptech.glide.load.k kVar, boolean z, int i2, int i3, boolean z2, b bVar2) throws IOException {
        int i4;
        int i5;
        int i6;
        q qVar;
        int iRound;
        int iRound2;
        int i7;
        ColorSpace colorSpace;
        long jA = com.bumptech.glide.util.f.a();
        int[] iArrB = b(xVar, options, bVar2, this.f4935a);
        boolean z3 = false;
        int i8 = iArrB[0];
        int i9 = iArrB[1];
        String str = options.outMimeType;
        boolean z4 = (i8 == -1 || i9 == -1) ? false : z;
        int iA = xVar.a();
        int iA2 = g0.a(iA);
        boolean zB = g0.b(iA);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = a(iA2) ? i9 : i8;
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = a(iA2) ? i8 : i9;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType imageTypeC = xVar.c();
        a(imageTypeC, xVar, bVar2, this.f4935a, pVar, iA2, i8, i9, i5, i6, options);
        a(xVar, bVar, z4, zB, options, i5, i6);
        boolean z5 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z5) {
            qVar = this;
            if (qVar.a(imageTypeC)) {
                if (i8 < 0 || i9 < 0 || !z2 || !z5) {
                    float f2 = b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i10 = options.inSampleSize;
                    float f3 = i10;
                    int iCeil = (int) Math.ceil(i8 / f3);
                    int iCeil2 = (int) Math.ceil(i9 / f3);
                    iRound = Math.round(iCeil * f2);
                    iRound2 = Math.round(iCeil2 * f2);
                    if (Log.isLoggable(f4927f, 2)) {
                        String str2 = "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i8 + "x" + i9 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2;
                    }
                } else {
                    iRound = i5;
                    iRound2 = i6;
                }
                if (iRound > 0 && iRound2 > 0) {
                    a(options, qVar.f4935a, iRound, iRound2);
                }
            }
        } else {
            qVar = this;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            if (kVar == com.bumptech.glide.load.k.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i11 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapA = a(xVar, options, bVar2, qVar.f4935a);
        bVar2.a(qVar.f4935a, bitmapA);
        if (Log.isLoggable(f4927f, 2)) {
            i7 = iA;
            a(i8, i9, str, options, bitmapA, i2, i3, jA);
        } else {
            i7 = iA;
        }
        Bitmap bitmapA2 = null;
        if (bitmapA != null) {
            bitmapA.setDensity(qVar.f4936b.densityDpi);
            bitmapA2 = g0.a(qVar.f4935a, bitmapA, i7);
            if (!bitmapA.equals(bitmapA2)) {
                qVar.f4935a.a(bitmapA);
            }
        }
        return bitmapA2;
    }

    private static void a(ImageHeaderParser.ImageType imageType, x xVar, b bVar, com.bumptech.glide.load.p.a0.e eVar, p pVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int iMin;
        int iMax;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 > 0 && i4 > 0) {
            if (a(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float fB = pVar.b(i7, i8, i5, i6);
            if (fB > 0.0f) {
                p.g gVarA = pVar.a(i7, i8, i5, i6);
                if (gVarA != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int iC = i7 / c(fB * f2);
                    int iC2 = i8 / c(fB * f3);
                    if (gVarA == p.g.MEMORY) {
                        iMin = Math.max(iC, iC2);
                    } else {
                        iMin = Math.min(iC, iC2);
                    }
                    if (Build.VERSION.SDK_INT > 23 || !n.contains(options.outMimeType)) {
                        iMax = Math.max(1, Integer.highestOneBit(iMin));
                        if (gVarA == p.g.MEMORY && iMax < 1.0f / fB) {
                            iMax <<= 1;
                        }
                    } else {
                        iMax = 1;
                    }
                    options.inSampleSize = iMax;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float fMin = Math.min(iMax, 8);
                        iFloor = (int) Math.ceil(f2 / fMin);
                        iRound = (int) Math.ceil(f3 / fMin);
                        int i9 = iMax / 8;
                        if (i9 > 0) {
                            iFloor /= i9;
                            iRound /= i9;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                                if (i7 % iMax == 0 && i8 % iMax == 0) {
                                    iFloor = i7 / iMax;
                                    iRound = i8 / iMax;
                                } else {
                                    int[] iArrB = b(xVar, options, bVar, eVar);
                                    iFloor = iArrB[0];
                                    iRound = iArrB[1];
                                }
                            } else if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = iMax;
                                iFloor = Math.round(f2 / f4);
                                iRound = Math.round(f3 / f4);
                            } else {
                                float f5 = iMax;
                                iFloor = (int) Math.floor(f2 / f5);
                                dFloor = Math.floor(f3 / f5);
                            }
                        } else {
                            float f6 = iMax;
                            iFloor = (int) Math.floor(f2 / f6);
                            dFloor = Math.floor(f3 / f6);
                        }
                        iRound = (int) dFloor;
                    }
                    double dB = pVar.b(iFloor, iRound, i5, i6);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options.inTargetDensity = a(dB);
                        options.inDensity = b(dB);
                    }
                    if (b(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable(f4927f, 2)) {
                        String str = "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + pVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        if (Log.isLoggable(f4927f, 3)) {
            String str2 = "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]";
        }
    }

    private static int a(double d2) {
        return c((d2 / (r1 / r0)) * c(b(d2) * d2));
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return p.contains(imageType);
    }

    private void a(x xVar, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.f4939e.a(i2, i3, options, z, z2)) {
            return;
        }
        if (bVar != com.bumptech.glide.load.b.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean zHasAlpha = false;
            try {
                zHasAlpha = xVar.c().hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable(f4927f, 3)) {
                    String str = "Cannot determine whether the image has alpha or not from header, format " + bVar;
                }
            }
            options.inPreferredConfig = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(com.bumptech.glide.load.r.d.x r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.r.d.q.b r6, com.bumptech.glide.load.p.a0.e r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.a()
            r4.b()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.r.d.g0.a()
            r3.lock()
            android.graphics.Bitmap r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalArgumentException -> L25
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.r.d.g0.a()
            r5.unlock()
            return r4
        L23:
            r4 = move-exception
            goto L4b
        L25:
            r3 = move-exception
            java.io.IOException r0 = a(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L23
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L4a
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r7.a(r1)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            android.graphics.Bitmap r4 = a(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.r.d.g0.a()
            r5.unlock()
            return r4
        L49:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4a:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4b:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.r.d.g0.a()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.r.d.q.a(com.bumptech.glide.load.r.d.x, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.r.d.q$b, com.bumptech.glide.load.p.a0.e):android.graphics.Bitmap");
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        String str2 = "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.f.a(j2);
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @Nullable
    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.bumptech.glide.load.p.a0.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options optionsPoll;
        synchronized (q) {
            optionsPoll = q.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            d(optionsPoll);
        }
        return optionsPoll;
    }
}
