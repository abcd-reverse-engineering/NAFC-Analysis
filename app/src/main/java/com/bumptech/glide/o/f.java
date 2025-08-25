package com.bumptech.glide.o;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.o.a;
import h.f1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class f implements a {
    private static final String A = "f";
    private static final int B = 4096;
    private static final int C = -1;
    private static final int D = -1;
    private static final int E = 4;
    private static final int F = 255;

    @ColorInt
    private static final int G = 0;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    private int[] f5184f;

    /* renamed from: g, reason: collision with root package name */
    @ColorInt
    private final int[] f5185g;

    /* renamed from: h, reason: collision with root package name */
    private final a.InterfaceC0076a f5186h;

    /* renamed from: i, reason: collision with root package name */
    private ByteBuffer f5187i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f5188j;

    /* renamed from: k, reason: collision with root package name */
    private d f5189k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f5190l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f5191m;
    private byte[] n;
    private byte[] o;

    @ColorInt
    private int[] p;
    private int q;
    private c r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;

    @Nullable
    private Boolean y;

    @NonNull
    private Bitmap.Config z;

    public f(@NonNull a.InterfaceC0076a interfaceC0076a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0076a, cVar, byteBuffer, 1);
    }

    @NonNull
    private d m() {
        if (this.f5189k == null) {
            this.f5189k = new d();
        }
        return this.f5189k;
    }

    private Bitmap n() {
        Boolean bool = this.y;
        Bitmap bitmapA = this.f5186h.a(this.x, this.w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.z);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.f5187i;
        byteBuffer.get(this.f5188j, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    private int p() {
        return this.f5187i.get() & f1.f16099c;
    }

    @Override // com.bumptech.glide.o.a
    public int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.r;
            if (i2 < cVar.f5160c) {
                return cVar.f5162e.get(i2).f5155i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.o.a
    public void b() {
        this.q = (this.q + 1) % this.r.f5160c;
    }

    @Override // com.bumptech.glide.o.a
    public int c() {
        return this.r.f5160c;
    }

    @Override // com.bumptech.glide.o.a
    public void clear() {
        this.r = null;
        byte[] bArr = this.o;
        if (bArr != null) {
            this.f5186h.a(bArr);
        }
        int[] iArr = this.p;
        if (iArr != null) {
            this.f5186h.a(iArr);
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.f5186h.a(bitmap);
        }
        this.s = null;
        this.f5187i = null;
        this.y = null;
        byte[] bArr2 = this.f5188j;
        if (bArr2 != null) {
            this.f5186h.a(bArr2);
        }
    }

    @Override // com.bumptech.glide.o.a
    public int d() {
        int i2;
        if (this.r.f5160c <= 0 || (i2 = this.q) < 0) {
            return 0;
        }
        return a(i2);
    }

    @Override // com.bumptech.glide.o.a
    @NonNull
    public ByteBuffer e() {
        return this.f5187i;
    }

    @Override // com.bumptech.glide.o.a
    public void f() {
        this.q = -1;
    }

    @Override // com.bumptech.glide.o.a
    public int g() {
        return this.q;
    }

    @Override // com.bumptech.glide.o.a
    public int getHeight() {
        return this.r.f5164g;
    }

    @Override // com.bumptech.glide.o.a
    public int getWidth() {
        return this.r.f5163f;
    }

    @Override // com.bumptech.glide.o.a
    public int h() {
        return this.r.f5170m;
    }

    @Override // com.bumptech.glide.o.a
    public int i() {
        return this.u;
    }

    @Override // com.bumptech.glide.o.a
    public int j() {
        return this.f5187i.limit() + this.o.length + (this.p.length * 4);
    }

    @Override // com.bumptech.glide.o.a
    public int k() {
        int i2 = this.r.f5170m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.bumptech.glide.o.a
    @Deprecated
    public int l() {
        int i2 = this.r.f5170m;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.bumptech.glide.o.a
    public synchronized int read(@Nullable byte[] bArr) {
        this.r = m().a(bArr).c();
        if (bArr != null) {
            a(this.r, bArr);
        }
        return this.u;
    }

    public f(@NonNull a.InterfaceC0076a interfaceC0076a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0076a);
        a(cVar, byteBuffer, i2);
    }

    private void b(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.p;
        int i2 = bVar2.f5150d;
        int i3 = bVar2.f5148b;
        int i4 = bVar2.f5149c;
        int i5 = bVar2.f5147a;
        boolean z = this.q == 0;
        int i6 = this.x;
        byte[] bArr = this.o;
        int[] iArr2 = this.f5184f;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f5149c * i7;
            for (int i13 = i9; i13 < i10; i13++) {
                byte b3 = bArr[i12];
                int i14 = b3 & f1.f16099c;
                if (i14 != b2) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
            }
            i7++;
            bVar2 = bVar;
        }
        Boolean bool = this.y;
        this.y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.y == null && z && b2 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17, types: [short] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void c(b bVar) {
        int i2;
        int i3;
        short s;
        f fVar = this;
        if (bVar != null) {
            fVar.f5187i.position(bVar.f5156j);
        }
        if (bVar == null) {
            c cVar = fVar.r;
            i2 = cVar.f5163f;
            i3 = cVar.f5164g;
        } else {
            i2 = bVar.f5149c;
            i3 = bVar.f5150d;
        }
        int i4 = i2 * i3;
        byte[] bArr = fVar.o;
        if (bArr == null || bArr.length < i4) {
            fVar.o = fVar.f5186h.b(i4);
        }
        byte[] bArr2 = fVar.o;
        if (fVar.f5190l == null) {
            fVar.f5190l = new short[4096];
        }
        short[] sArr = fVar.f5190l;
        if (fVar.f5191m == null) {
            fVar.f5191m = new byte[4096];
        }
        byte[] bArr3 = fVar.f5191m;
        if (fVar.n == null) {
            fVar.n = new byte[4097];
        }
        byte[] bArr4 = fVar.n;
        int iP = p();
        int i5 = 1 << iP;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iP + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = fVar.f5188j;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int iO = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (iO == 0) {
                iO = o();
                if (iO <= 0) {
                    fVar.u = 3;
                    break;
                }
                i17 = 0;
            }
            i16 += (bArr5[i17] & f1.f16099c) << i15;
            i17++;
            iO--;
            int i22 = i15 + 8;
            int i23 = i19;
            int i24 = i20;
            int i25 = i13;
            int i26 = i18;
            int i27 = i10;
            int i28 = i12;
            while (true) {
                if (i22 < i28) {
                    i12 = i28;
                    i20 = i24;
                    i10 = i27;
                    i18 = i26;
                    i15 = i22;
                    i13 = i25;
                    i19 = i23;
                    fVar = this;
                    break;
                }
                int i29 = i16 & i14;
                i16 >>= i28;
                i22 -= i28;
                if (i29 == i5) {
                    i28 = i8;
                    i25 = i7;
                    i14 = i9;
                    i23 = -1;
                } else {
                    if (i29 == i6) {
                        i15 = i22;
                        i12 = i28;
                        i10 = i27;
                        i18 = i26;
                        i13 = i25;
                        i20 = i24;
                        i19 = i23;
                        break;
                    }
                    if (i23 == -1) {
                        bArr2[i26] = bArr3[i29];
                        i26++;
                        i27++;
                        fVar = this;
                        i23 = i29;
                        i24 = i23;
                    } else {
                        int i30 = i25;
                        if (i29 >= i30) {
                            bArr4[i21] = (byte) i24;
                            i21++;
                            s = i23;
                        } else {
                            s = i29;
                        }
                        while (s >= i5) {
                            bArr4[i21] = bArr3[s];
                            i21++;
                            s = sArr[s];
                        }
                        int i31 = bArr3[s] & f1.f16099c;
                        int i32 = i8;
                        byte b2 = (byte) i31;
                        bArr2[i26] = b2;
                        while (true) {
                            i26++;
                            i27++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i26] = bArr4[i21];
                        }
                        if (i30 < 4096) {
                            sArr[i30] = (short) i23;
                            bArr3[i30] = b2;
                            i30++;
                            if ((i30 & i14) == 0 && i30 < 4096) {
                                i28++;
                                i14 += i30;
                            }
                        }
                        i23 = i29;
                        i22 = i22;
                        i8 = i32;
                        i24 = i31;
                        i25 = i30;
                        fVar = this;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i18, i4, (byte) 0);
    }

    @Override // com.bumptech.glide.o.a
    @Nullable
    public synchronized Bitmap a() {
        if (this.r.f5160c <= 0 || this.q < 0) {
            if (Log.isLoggable(A, 3)) {
                String str = "Unable to decode frame, frameCount=" + this.r.f5160c + ", framePointer=" + this.q;
            }
            this.u = 1;
        }
        if (this.u != 1 && this.u != 2) {
            this.u = 0;
            if (this.f5188j == null) {
                this.f5188j = this.f5186h.b(255);
            }
            b bVar = this.r.f5162e.get(this.q);
            int i2 = this.q - 1;
            b bVar2 = i2 >= 0 ? this.r.f5162e.get(i2) : null;
            this.f5184f = bVar.f5157k != null ? bVar.f5157k : this.r.f5158a;
            if (this.f5184f == null) {
                if (Log.isLoggable(A, 3)) {
                    String str2 = "No valid color table found for frame #" + this.q;
                }
                this.u = 1;
                return null;
            }
            if (bVar.f5152f) {
                System.arraycopy(this.f5184f, 0, this.f5185g, 0, this.f5184f.length);
                this.f5184f = this.f5185g;
                this.f5184f[bVar.f5154h] = 0;
                if (bVar.f5153g == 2 && this.q == 0) {
                    this.y = true;
                }
            }
            return a(bVar, bVar2);
        }
        if (Log.isLoggable(A, 3)) {
            String str3 = "Unable to decode frame, status=" + this.u;
        }
        return null;
    }

    public f(@NonNull a.InterfaceC0076a interfaceC0076a) {
        this.f5185g = new int[256];
        this.z = Bitmap.Config.ARGB_8888;
        this.f5186h = interfaceC0076a;
        this.r = new c();
    }

    @Override // com.bumptech.glide.o.a
    public int a(@Nullable InputStream inputStream, int i2) throws IOException {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i3 = inputStream.read(bArr, 0, bArr.length);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.u;
    }

    @Override // com.bumptech.glide.o.a
    public synchronized void a(@NonNull c cVar, @NonNull byte[] bArr) {
        a(cVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.o.a
    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer) {
        a(cVar, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.o.a
    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int iHighestOneBit = Integer.highestOneBit(i2);
            this.u = 0;
            this.r = cVar;
            this.q = -1;
            this.f5187i = byteBuffer.asReadOnlyBuffer();
            this.f5187i.position(0);
            this.f5187i.order(ByteOrder.LITTLE_ENDIAN);
            this.t = false;
            Iterator<b> it = cVar.f5162e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f5153g == 3) {
                    this.t = true;
                    break;
                }
            }
            this.v = iHighestOneBit;
            this.x = cVar.f5163f / iHighestOneBit;
            this.w = cVar.f5164g / iHighestOneBit;
            this.o = this.f5186h.b(cVar.f5163f * cVar.f5164g);
            this.p = this.f5186h.a(this.x * this.w);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    @Override // com.bumptech.glide.o.a
    public void a(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.z = config;
    }

    private Bitmap a(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.p;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                this.f5186h.a(bitmap2);
            }
            this.s = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f5153g == 3 && this.s == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.f5153g) > 0) {
            if (i3 == 2) {
                if (!bVar.f5152f) {
                    c cVar = this.r;
                    int i5 = cVar.f5169l;
                    if (bVar.f5157k == null || cVar.f5167j != bVar.f5154h) {
                        i4 = i5;
                    }
                }
                int i6 = bVar2.f5150d;
                int i7 = this.v;
                int i8 = i6 / i7;
                int i9 = bVar2.f5148b / i7;
                int i10 = bVar2.f5149c / i7;
                int i11 = bVar2.f5147a / i7;
                int i12 = this.x;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.x;
                }
            } else if (i3 == 3 && (bitmap = this.s) != null) {
                int i17 = this.x;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.w);
            }
        }
        c(bVar);
        if (!bVar.f5151e && this.v == 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.t && ((i2 = bVar.f5153g) == 0 || i2 == 1)) {
            if (this.s == null) {
                this.s = n();
            }
            Bitmap bitmap3 = this.s;
            int i18 = this.x;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.w);
        }
        Bitmap bitmapN = n();
        int i19 = this.x;
        bitmapN.setPixels(iArr, 0, i19, 0, 0, i19, this.w);
        return bitmapN;
    }

    private void a(b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.p;
        int i7 = bVar.f5150d;
        int i8 = this.v;
        int i9 = i7 / i8;
        int i10 = bVar.f5148b / i8;
        int i11 = bVar.f5149c / i8;
        int i12 = bVar.f5147a / i8;
        Boolean bool = true;
        boolean z = this.q == 0;
        int i13 = this.v;
        int i14 = this.x;
        int i15 = this.w;
        byte[] bArr = this.o;
        int[] iArr2 = this.f5184f;
        Boolean bool2 = this.y;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 8;
        while (i16 < i9) {
            Boolean bool3 = bool;
            if (bVar.f5151e) {
                if (i17 >= i9) {
                    i2 = i9;
                    i6 = i18 + 1;
                    if (i6 == 2) {
                        i17 = 4;
                    } else if (i6 == 3) {
                        i17 = 2;
                        i19 = 4;
                    } else if (i6 == 4) {
                        i17 = 1;
                        i19 = 2;
                    }
                } else {
                    i2 = i9;
                    i6 = i18;
                }
                i3 = i17 + i19;
                i18 = i6;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z2 = i13 == 1;
            if (i20 < i15) {
                int i21 = i20 * i14;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i14;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i10;
                int i25 = i16 * i13 * bVar.f5149c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i11;
                        int i28 = iArr2[bArr[i25] & f1.f16099c];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i26++;
                        i11 = i27;
                    }
                } else {
                    i5 = i11;
                    int i29 = ((i23 - i22) * i13) + i25;
                    int i30 = i22;
                    while (i30 < i23) {
                        int i31 = i23;
                        int iA = a(i25, i29, bVar.f5149c);
                        if (iA != 0) {
                            iArr[i30] = iA;
                        } else if (z && bool2 == null) {
                            bool2 = bool3;
                        }
                        i25 += i13;
                        i30++;
                        i23 = i31;
                    }
                    i16++;
                    i17 = i3;
                    i11 = i5;
                    bool = bool3;
                    i9 = i2;
                    i10 = i4;
                }
            } else {
                i4 = i10;
            }
            i5 = i11;
            i16++;
            i17 = i3;
            i11 = i5;
            bool = bool3;
            i9 = i2;
            i10 = i4;
        }
        if (this.y == null) {
            this.y = Boolean.valueOf(bool2 == null ? false : bool2.booleanValue());
        }
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.v + i2; i10++) {
            byte[] bArr = this.o;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f5184f[bArr[i10] & f1.f16099c];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.v + i12; i13++) {
            byte[] bArr2 = this.o;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f5184f[bArr2[i13] & f1.f16099c];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }
}
