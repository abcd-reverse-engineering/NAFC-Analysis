package com.bumptech.glide.load.r.d;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class j0<T> implements com.bumptech.glide.load.l<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4881d = "VideoDecoder";

    /* renamed from: e, reason: collision with root package name */
    public static final long f4882e = -1;

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f4883f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Long> f4884g = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Integer> f4885h = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: i, reason: collision with root package name */
    private static final e f4886i = new e();

    /* renamed from: a, reason: collision with root package name */
    private final f<T> f4887a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.e f4888b;

    /* renamed from: c, reason: collision with root package name */
    private final e f4889c;

    /* compiled from: VideoDecoder.java */
    class a implements i.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4890a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f4890a) {
                this.f4890a.position(0);
                messageDigest.update(this.f4890a.putLong(l2.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    class b implements i.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4891a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f4891a) {
                this.f4891a.position(0);
                messageDigest.update(this.f4891a.putInt(num.intValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder.java */
    @RequiresApi(23)
    static final class d implements f<ByteBuffer> {

        /* compiled from: VideoDecoder.java */
        class a extends MediaDataSource {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f4892a;

            a(ByteBuffer byteBuffer) {
                this.f4892a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f4892a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= this.f4892a.limit()) {
                    return -1;
                }
                this.f4892a.position((int) j2);
                int iMin = Math.min(i3, this.f4892a.remaining());
                this.f4892a.get(bArr, i2, iMin);
                return iMin;
            }
        }

        d() {
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder.java */
    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.r.d.j0.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    j0(com.bumptech.glide.load.p.a0.e eVar, f<T> fVar) {
        this(eVar, fVar, f4886i);
    }

    public static com.bumptech.glide.load.l<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.l<ByteBuffer, Bitmap> b(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new d());
    }

    public static com.bumptech.glide.load.l<ParcelFileDescriptor, Bitmap> c(com.bumptech.glide.load.p.a0.e eVar) {
        return new j0(eVar, new g());
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull T t, @NonNull com.bumptech.glide.load.j jVar) {
        return true;
    }

    @VisibleForTesting
    j0(com.bumptech.glide.load.p.a0.e eVar, f<T> fVar, e eVar2) {
        this.f4888b = eVar;
        this.f4887a = fVar;
        this.f4889c = eVar2;
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, p pVar) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = pVar.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable unused) {
            Log.isLoggable(f4881d, 3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) throws IOException {
        long jLongValue = ((Long) jVar.a(f4884g)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) jVar.a(f4885h);
        if (num == null) {
            num = 2;
        }
        p pVar = (p) jVar.a(p.f4924h);
        if (pVar == null) {
            pVar = p.f4923g;
        }
        p pVar2 = pVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f4889c.a();
        try {
            try {
                this.f4887a.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapA = a(mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, pVar2);
                mediaMetadataRetrieverA.release();
                return com.bumptech.glide.load.r.d.g.a(bitmapA, this.f4888b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, p pVar) {
        Bitmap bitmapB = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || pVar == p.f4922f) ? null : b(mediaMetadataRetriever, j2, i2, i3, i4, pVar);
        return bitmapB == null ? a(mediaMetadataRetriever, j2, i2) : bitmapB;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }
}
