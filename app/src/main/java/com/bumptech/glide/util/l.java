package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h.f1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final int f5386a = 31;

    /* renamed from: b, reason: collision with root package name */
    private static final int f5387b = 17;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f5388c = "0123456789abcdef".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f5389d = new char[64];

    /* compiled from: Util.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5390a = new int[Bitmap.Config.values().length];

        static {
            try {
                f5390a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5390a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5390a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5390a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5390a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private l() {
    }

    public static int a(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        String strA;
        synchronized (f5389d) {
            strA = a(bArr, f5389d);
        }
        return strA;
    }

    @Deprecated
    public static int b(@NonNull Bitmap bitmap) {
        return a(bitmap);
    }

    public static boolean c() {
        return !d();
    }

    private static boolean c(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(int i2, int i3) {
        return c(i2) && c(i3);
    }

    public static void b() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    @NonNull
    private static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & f1.f16099c;
            int i4 = i2 * 2;
            char[] cArr2 = f5388c;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static boolean b(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(int i2) {
        return a(i2, 17);
    }

    @TargetApi(19)
    public static int a(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int a(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * a(config);
    }

    private static int a(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.f5390a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    @NonNull
    public static <T> Queue<T> a(int i2) {
        return new ArrayDeque(i2);
    }

    @NonNull
    public static <T> List<T> a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof com.bumptech.glide.load.q.l) {
            return ((com.bumptech.glide.load.q.l) obj).a(obj2);
        }
        return obj.equals(obj2);
    }

    public static int a(float f2) {
        return a(f2, 17);
    }

    public static int a(float f2, int i2) {
        return a(Float.floatToIntBits(f2), i2);
    }

    public static int a(@Nullable Object obj, int i2) {
        return a(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int a(boolean z, int i2) {
        return a(z ? 1 : 0, i2);
    }

    public static int a(boolean z) {
        return a(z, 17);
    }
}
