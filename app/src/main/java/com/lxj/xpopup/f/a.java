package com.lxj.xpopup.f;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageHeaderParser.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f8046a = 4671814;

    /* renamed from: b, reason: collision with root package name */
    private static final int f8047b = -1991225785;

    /* renamed from: c, reason: collision with root package name */
    static final int f8048c = 65496;

    /* renamed from: d, reason: collision with root package name */
    private static final int f8049d = 1380533830;

    /* renamed from: e, reason: collision with root package name */
    private static final int f8050e = 1464156752;

    /* renamed from: f, reason: collision with root package name */
    private static final int f8051f = 1448097792;

    /* renamed from: g, reason: collision with root package name */
    private static final int f8052g = -256;

    /* renamed from: h, reason: collision with root package name */
    private static final int f8053h = 255;

    /* renamed from: i, reason: collision with root package name */
    private static final int f8054i = 88;

    /* renamed from: j, reason: collision with root package name */
    private static final int f8055j = 76;

    /* renamed from: k, reason: collision with root package name */
    private static final int f8056k = 16;

    /* renamed from: l, reason: collision with root package name */
    private static final int f8057l = 8;

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.lxj.xpopup.f.a$a, reason: collision with other inner class name */
    private interface InterfaceC0114a {
        int a() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] bArr, int i2) throws IOException;

        long skip(long j2) throws IOException;
    }

    /* compiled from: ImageHeaderParser.java */
    private static final class b implements InterfaceC0114a {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f8058a;

        b(InputStream inputStream) {
            this.f8058a = inputStream;
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0114a
        public int a() throws IOException {
            return this.f8058a.read();
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0114a
        public int getUInt16() throws IOException {
            return ((this.f8058a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f8058a.read() & 255);
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0114a
        public short getUInt8() throws IOException {
            return (short) (this.f8058a.read() & 255);
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0114a
        public int read(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int i4 = this.f8058a.read(bArr, i2 - i3, i3);
                if (i4 == -1) {
                    break;
                }
                i3 -= i4;
            }
            return i2 - i3;
        }

        @Override // com.lxj.xpopup.f.a.InterfaceC0114a
        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0L;
            }
            long j3 = j2;
            while (j3 > 0) {
                long jSkip = this.f8058a.skip(j3);
                if (jSkip <= 0) {
                    if (this.f8058a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j3 -= jSkip;
            }
            return j2 - j3;
        }
    }

    static com.lxj.xpopup.d.a a(InputStream inputStream) throws IOException {
        b bVar = new b(inputStream);
        int uInt16 = bVar.getUInt16();
        if (uInt16 == f8048c) {
            return com.lxj.xpopup.d.a.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if (uInt162 == f8047b) {
            bVar.skip(21L);
            return bVar.a() >= 3 ? com.lxj.xpopup.d.a.PNG_A : com.lxj.xpopup.d.a.PNG;
        }
        if ((uInt162 >> 8) == f8046a) {
            return com.lxj.xpopup.d.a.GIF;
        }
        if (uInt162 != f8049d) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        bVar.skip(4L);
        if ((((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535)) != f8050e) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        int uInt163 = ((bVar.getUInt16() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.getUInt16() & 65535);
        if ((uInt163 & (-256)) != f8051f) {
            return com.lxj.xpopup.d.a.UNKNOWN;
        }
        int i2 = uInt163 & 255;
        if (i2 == 88) {
            bVar.skip(4L);
            return (bVar.a() & 16) != 0 ? com.lxj.xpopup.d.a.WEBP_A : com.lxj.xpopup.d.a.WEBP;
        }
        if (i2 == 76) {
            bVar.skip(4L);
            return (bVar.a() & 8) != 0 ? com.lxj.xpopup.d.a.WEBP_A : com.lxj.xpopup.d.a.WEBP;
        }
        inputStream.close();
        return com.lxj.xpopup.d.a.WEBP;
    }
}
