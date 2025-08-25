package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.m<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Integer> f4851b = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Bitmap.CompressFormat> f4852c = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: d, reason: collision with root package name */
    private static final String f4853d = "BitmapEncoder";

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final com.bumptech.glide.load.p.a0.b f4854a;

    public e(@NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this.f4854a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {all -> 0x00b3, blocks: (B:3:0x0021, B:13:0x004d, B:25:0x0061, B:27:0x0067, B:31:0x00af, B:32:0x00b2), top: B:41:0x0021 }] */
    @Override // com.bumptech.glide.load.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(@androidx.annotation.NonNull com.bumptech.glide.load.p.v<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull com.bumptech.glide.load.j r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.a(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.n.b.a(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.f.a()     // Catch: java.lang.Throwable -> Lb3
            com.bumptech.glide.load.i<java.lang.Integer> r4 = com.bumptech.glide.load.r.d.e.f4851b     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r4 = r11.a(r4)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb3
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            com.bumptech.glide.load.p.a0.b r10 = r8.f4854a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            com.bumptech.glide.load.o.c r10 = new com.bumptech.glide.load.o.c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.bumptech.glide.load.p.a0.b r6 = r8.f4854a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r6.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L60 java.lang.Throwable -> Lb3
            goto L60
        L51:
            r9 = move-exception
            r6 = r7
            goto Lad
        L54:
            r6 = r7
            goto L58
        L56:
            r9 = move-exception
            goto Lad
        L58:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L60
            goto L4d
        L60:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb3
            if (r10 == 0) goto La9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r10.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            int r0 = com.bumptech.glide.util.l.a(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            double r0 = com.bumptech.glide.util.f.a(r2)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            com.bumptech.glide.load.i<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.r.d.e.f4852c     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r11 = r11.a(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb3
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.toString()     // Catch: java.lang.Throwable -> Lb3
        La9:
            com.bumptech.glide.util.n.b.a()
            return r5
        Lad:
            if (r6 == 0) goto Lb2
            r6.close()     // Catch: java.io.IOException -> Lb2 java.lang.Throwable -> Lb3
        Lb2:
            throw r9     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r9 = move-exception
            com.bumptech.glide.util.n.b.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.r.d.e.a(com.bumptech.glide.load.p.v, java.io.File, com.bumptech.glide.load.j):boolean");
    }

    @Deprecated
    public e() {
        this.f4854a = null;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.bumptech.glide.load.j jVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jVar.a(f4852c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.m
    @NonNull
    public com.bumptech.glide.load.c a(@NonNull com.bumptech.glide.load.j jVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }
}
