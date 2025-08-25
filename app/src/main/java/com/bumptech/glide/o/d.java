package com.bumptech.glide.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import h.f1;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e, reason: collision with root package name */
    private static final String f5171e = "GifHeaderParser";

    /* renamed from: f, reason: collision with root package name */
    private static final int f5172f = 255;

    /* renamed from: g, reason: collision with root package name */
    private static final int f5173g = 44;

    /* renamed from: h, reason: collision with root package name */
    private static final int f5174h = 33;

    /* renamed from: i, reason: collision with root package name */
    private static final int f5175i = 59;

    /* renamed from: j, reason: collision with root package name */
    private static final int f5176j = 249;

    /* renamed from: k, reason: collision with root package name */
    private static final int f5177k = 255;

    /* renamed from: l, reason: collision with root package name */
    private static final int f5178l = 254;

    /* renamed from: m, reason: collision with root package name */
    private static final int f5179m = 1;
    private static final int n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    static final int v = 2;
    static final int w = 10;
    private static final int x = 256;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f5181b;

    /* renamed from: c, reason: collision with root package name */
    private c f5182c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f5180a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f5183d = 0;

    private boolean d() {
        return this.f5182c.f5159b != 0;
    }

    private int e() {
        try {
            return this.f5181b.get() & f1.f16099c;
        } catch (Exception unused) {
            this.f5182c.f5159b = 1;
            return 0;
        }
    }

    private void f() {
        this.f5182c.f5161d.f5147a = m();
        this.f5182c.f5161d.f5148b = m();
        this.f5182c.f5161d.f5149c = m();
        this.f5182c.f5161d.f5150d = m();
        int iE = e();
        boolean z = (iE & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iE & 7) + 1);
        this.f5182c.f5161d.f5151e = (iE & 64) != 0;
        if (z) {
            this.f5182c.f5161d.f5157k = a(iPow);
        } else {
            this.f5182c.f5161d.f5157k = null;
        }
        this.f5182c.f5161d.f5156j = this.f5181b.position();
        p();
        if (d()) {
            return;
        }
        c cVar = this.f5182c;
        cVar.f5160c++;
        cVar.f5162e.add(cVar.f5161d);
    }

    private void g() {
        this.f5183d = e();
        if (this.f5183d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f5183d) {
                try {
                    i3 = this.f5183d - i2;
                    this.f5181b.get(this.f5180a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable(f5171e, 3)) {
                        String str = "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f5183d;
                    }
                    this.f5182c.f5159b = 1;
                    return;
                }
            }
        }
    }

    private void h() {
        b(Integer.MAX_VALUE);
    }

    private void i() {
        e();
        int iE = e();
        b bVar = this.f5182c.f5161d;
        bVar.f5153g = (iE & 28) >> 2;
        if (bVar.f5153g == 0) {
            bVar.f5153g = 1;
        }
        this.f5182c.f5161d.f5152f = (iE & 1) != 0;
        int iM = m();
        if (iM < 2) {
            iM = 10;
        }
        b bVar2 = this.f5182c.f5161d;
        bVar2.f5155i = iM * 10;
        bVar2.f5154h = e();
        e();
    }

    private void j() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f5182c.f5159b = 1;
            return;
        }
        k();
        if (!this.f5182c.f5165h || d()) {
            return;
        }
        c cVar = this.f5182c;
        cVar.f5158a = a(cVar.f5166i);
        c cVar2 = this.f5182c;
        cVar2.f5169l = cVar2.f5158a[cVar2.f5167j];
    }

    private void k() {
        this.f5182c.f5163f = m();
        this.f5182c.f5164g = m();
        this.f5182c.f5165h = (e() & 128) != 0;
        this.f5182c.f5166i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f5182c.f5167j = e();
        this.f5182c.f5168k = e();
    }

    private void l() {
        do {
            g();
            byte[] bArr = this.f5180a;
            if (bArr[0] == 1) {
                this.f5182c.f5170m = ((bArr[2] & f1.f16099c) << 8) | (bArr[1] & f1.f16099c);
            }
            if (this.f5183d <= 0) {
                return;
            }
        } while (!d());
    }

    private int m() {
        return this.f5181b.getShort();
    }

    private void n() {
        this.f5181b = null;
        Arrays.fill(this.f5180a, (byte) 0);
        this.f5182c = new c();
        this.f5183d = 0;
    }

    private void o() {
        int iE;
        do {
            iE = e();
            this.f5181b.position(Math.min(this.f5181b.position() + iE, this.f5181b.limit()));
        } while (iE > 0);
    }

    private void p() {
        e();
        o();
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        n();
        this.f5181b = byteBuffer.asReadOnlyBuffer();
        this.f5181b.position(0);
        this.f5181b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public boolean b() {
        j();
        if (!d()) {
            b(2);
        }
        return this.f5182c.f5160c > 1;
    }

    @NonNull
    public c c() {
        if (this.f5181b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (d()) {
            return this.f5182c;
        }
        j();
        if (!d()) {
            h();
            c cVar = this.f5182c;
            if (cVar.f5160c < 0) {
                cVar.f5159b = 1;
            }
        }
        return this.f5182c;
    }

    private void b(int i2) {
        boolean z = false;
        while (!z && !d() && this.f5182c.f5160c <= i2) {
            int iE = e();
            if (iE == 33) {
                int iE2 = e();
                if (iE2 == 1) {
                    o();
                } else if (iE2 == f5176j) {
                    this.f5182c.f5161d = new b();
                    i();
                } else if (iE2 == 254) {
                    o();
                } else if (iE2 != 255) {
                    o();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f5180a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        o();
                    }
                }
            } else if (iE == 44) {
                c cVar = this.f5182c;
                if (cVar.f5161d == null) {
                    cVar.f5161d = new b();
                }
                f();
            } else if (iE != 59) {
                this.f5182c.f5159b = 1;
            } else {
                z = true;
            }
        }
    }

    public d a(@Nullable byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
        } else {
            this.f5181b = null;
            this.f5182c.f5159b = 2;
        }
        return this;
    }

    public void a() {
        this.f5181b = null;
        this.f5182c = null;
    }

    @Nullable
    private int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f5181b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = bArr[i4] & f1.f16099c;
                int i7 = i5 + 1;
                int i8 = bArr[i5] & f1.f16099c;
                int i9 = i7 + 1;
                int i10 = i3 + 1;
                iArr[i3] = (i6 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8) | (bArr[i7] & f1.f16099c);
                i4 = i9;
                i3 = i10;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(f5171e, 3);
            this.f5182c.f5159b = 1;
        }
        return iArr;
    }
}
