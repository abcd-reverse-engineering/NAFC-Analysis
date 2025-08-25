package com.bumptech.glide.load.r.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import h.f1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: classes.dex */
public final class o implements ImageHeaderParser {

    /* renamed from: b, reason: collision with root package name */
    private static final String f4902b = "DfltImageHeaderParser";

    /* renamed from: c, reason: collision with root package name */
    private static final int f4903c = 4671814;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4904d = -1991225785;

    /* renamed from: e, reason: collision with root package name */
    static final int f4905e = 65496;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4906f = 19789;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4907g = 18761;

    /* renamed from: j, reason: collision with root package name */
    private static final int f4910j = 218;

    /* renamed from: k, reason: collision with root package name */
    private static final int f4911k = 217;

    /* renamed from: l, reason: collision with root package name */
    static final int f4912l = 255;

    /* renamed from: m, reason: collision with root package name */
    static final int f4913m = 225;
    private static final int n = 274;
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = -256;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final String f4908h = "Exif\u0000\u0000";

    /* renamed from: i, reason: collision with root package name */
    static final byte[] f4909i = f4908h.getBytes(Charset.forName("UTF-8"));
    private static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4914a;

        a(ByteBuffer byteBuffer) {
            this.f4914a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int getUInt16() throws c.a {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public short getUInt8() throws c.a {
            if (this.f4914a.remaining() >= 1) {
                return (short) (this.f4914a.get() & f1.f16099c);
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int read(byte[] bArr, int i2) {
            int iMin = Math.min(i2, this.f4914a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f4914a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public long skip(long j2) {
            int iMin = (int) Math.min(this.f4914a.remaining(), j2);
            ByteBuffer byteBuffer = this.f4914a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4915a;

        b(byte[] bArr, int i2) {
            this.f4915a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        void a(ByteOrder byteOrder) {
            this.f4915a.order(byteOrder);
        }

        int b(int i2) {
            if (a(i2, 4)) {
                return this.f4915a.getInt(i2);
            }
            return -1;
        }

        int a() {
            return this.f4915a.remaining();
        }

        short a(int i2) {
            if (a(i2, 2)) {
                return this.f4915a.getShort(i2);
            }
            return (short) -1;
        }

        private boolean a(int i2, int i3) {
            return this.f4915a.remaining() - i2 >= i3;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    private interface c {

        /* compiled from: DefaultImageHeaderParser.java */
        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser.java */
    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f4916a;

        d(InputStream inputStream) {
            this.f4916a = inputStream;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public short getUInt8() throws IOException {
            int i2 = this.f4916a.read();
            if (i2 != -1) {
                return (short) i2;
            }
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f4916a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 == 0 && i4 == -1) {
                throw new c.a();
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.r.d.o.c
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.f4916a.skip(j3);
                if (jSkip <= 0) {
                    if (this.f4916a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }
    }

    private static int a(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private static boolean a(int i2) {
        return (i2 & f4905e) == f4905e || i2 == f4906f || i2 == f4907g;
    }

    private int b(c cVar) throws IOException {
        short uInt8;
        int uInt16;
        long j2;
        long jSkip;
        do {
            short uInt82 = cVar.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(f4902b, 3)) {
                    String str = "Unknown segmentId=" + ((int) uInt82);
                }
                return -1;
            }
            uInt8 = cVar.getUInt8();
            if (uInt8 == f4910j) {
                return -1;
            }
            if (uInt8 == f4911k) {
                Log.isLoggable(f4902b, 3);
                return -1;
            }
            uInt16 = cVar.getUInt16() - 2;
            if (uInt8 == f4913m) {
                return uInt16;
            }
            j2 = uInt16;
            jSkip = cVar.skip(j2);
        } while (jSkip == j2);
        if (Log.isLoggable(f4902b, 3)) {
            String str2 = "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + jSkip;
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) throws IOException {
        return a(new d((InputStream) com.bumptech.glide.util.j.a(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return a(new a((ByteBuffer) com.bumptech.glide.util.j.a(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(new d((InputStream) com.bumptech.glide.util.j.a(inputStream)), (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        return a(new a((ByteBuffer) com.bumptech.glide.util.j.a(byteBuffer)), (com.bumptech.glide.load.p.a0.b) com.bumptech.glide.util.j.a(bVar));
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (uInt16 == f4905e) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | cVar.getUInt8();
            if (uInt8 == f4903c) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | cVar.getUInt8();
            if (uInt82 == f4904d) {
                cVar.skip(21L);
                try {
                    return cVar.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != p) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.getUInt16() << 16) | cVar.getUInt16()) != q) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (cVar.getUInt16() << 16) | cVar.getUInt16();
            if ((uInt162 & (-256)) != r) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = uInt162 & 255;
            if (i2 == 88) {
                cVar.skip(4L);
                return (cVar.getUInt8() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i2 == 76) {
                cVar.skip(4L);
                return (cVar.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private int a(c cVar, com.bumptech.glide.load.p.a0.b bVar) throws IOException {
        try {
            int uInt16 = cVar.getUInt16();
            if (!a(uInt16)) {
                if (Log.isLoggable(f4902b, 3)) {
                    String str = "Parser doesn't handle magic number: " + uInt16;
                }
                return -1;
            }
            int iB = b(cVar);
            if (iB == -1) {
                Log.isLoggable(f4902b, 3);
                return -1;
            }
            byte[] bArr = (byte[]) bVar.b(iB, byte[].class);
            try {
                return a(cVar, bArr, iB);
            } finally {
                bVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    private int a(c cVar, byte[] bArr, int i2) throws IOException {
        int i3 = cVar.read(bArr, i2);
        if (i3 != i2) {
            if (Log.isLoggable(f4902b, 3)) {
                String str = "Unable to read exif segment data, length: " + i2 + ", actually read: " + i3;
            }
            return -1;
        }
        if (a(bArr, i2)) {
            return a(new b(bArr, i2));
        }
        Log.isLoggable(f4902b, 3);
        return -1;
    }

    private boolean a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f4909i.length;
        if (!z) {
            return z;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f4909i;
            if (i3 >= bArr2.length) {
                return z;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != f4907g) {
            if (sA != f4906f && Log.isLoggable(f4902b, 3)) {
                String str = "Unknown endianness = " + ((int) sA);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i2 = 0; i2 < sA2; i2++) {
            int iA = a(iB, i2);
            short sA3 = bVar.a(iA);
            if (sA3 == n) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 < 0) {
                        Log.isLoggable(f4902b, 3);
                    } else {
                        if (Log.isLoggable(f4902b, 3)) {
                            String str2 = "Got tagIndex=" + i2 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2;
                        }
                        int i3 = iB2 + o[sA4];
                        if (i3 > 4) {
                            if (Log.isLoggable(f4902b, 3)) {
                                String str3 = "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4);
                            }
                        } else {
                            int i4 = iA + 8;
                            if (i4 >= 0 && i4 <= bVar.a()) {
                                if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                    return bVar.a(i4);
                                }
                                if (Log.isLoggable(f4902b, 3)) {
                                    String str4 = "Illegal number of bytes for TI tag data tagType=" + ((int) sA3);
                                }
                            } else if (Log.isLoggable(f4902b, 3)) {
                                String str5 = "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) sA3);
                            }
                        }
                    }
                } else if (Log.isLoggable(f4902b, 3)) {
                    String str6 = "Got invalid format code = " + ((int) sA4);
                }
            }
        }
        return -1;
    }
}
