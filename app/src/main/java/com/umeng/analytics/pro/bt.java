package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: classes2.dex */
public class bt {

    /* renamed from: a, reason: collision with root package name */
    private final cp f10196a;

    /* renamed from: b, reason: collision with root package name */
    private final dc f10197b;

    public bt() {
        this(new cj.a());
    }

    private ck j(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        this.f10197b.a(bArr);
        bx[] bxVarArr2 = new bx[bxVarArr.length + 1];
        int i2 = 0;
        bxVarArr2[0] = bxVar;
        int i3 = 0;
        while (i3 < bxVarArr.length) {
            int i4 = i3 + 1;
            bxVarArr2[i4] = bxVarArr[i3];
            i3 = i4;
        }
        this.f10196a.j();
        ck ckVarL = null;
        while (i2 < bxVarArr2.length) {
            ckVarL = this.f10196a.l();
            if (ckVarL.f10264b == 0 || ckVarL.f10265c > bxVarArr2[i2].a()) {
                return null;
            }
            if (ckVarL.f10265c != bxVarArr2[i2].a()) {
                cs.a(this.f10196a, ckVarL.f10264b);
                this.f10196a.m();
            } else {
                i2++;
                if (i2 < bxVarArr2.length) {
                    this.f10196a.j();
                }
            }
        }
        return ckVarL;
    }

    public void a(bq bqVar, byte[] bArr) throws bw {
        try {
            this.f10197b.a(bArr);
            bqVar.read(this.f10196a);
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public Byte b(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Byte) a((byte) 3, bArr, bxVar, bxVarArr);
    }

    public Double c(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Double) a((byte) 4, bArr, bxVar, bxVarArr);
    }

    public Short d(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Short) a((byte) 6, bArr, bxVar, bxVarArr);
    }

    public Integer e(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Integer) a((byte) 8, bArr, bxVar, bxVarArr);
    }

    public Long f(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Long) a((byte) 10, bArr, bxVar, bxVarArr);
    }

    public String g(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (String) a((byte) 11, bArr, bxVar, bxVarArr);
    }

    public ByteBuffer h(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (ByteBuffer) a((byte) 100, bArr, bxVar, bxVarArr);
    }

    public Short i(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        Short shValueOf;
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    this.f10196a.j();
                    shValueOf = Short.valueOf(this.f10196a.l().f10265c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public bt(cr crVar) {
        this.f10197b = new dc();
        this.f10196a = crVar.a(this.f10197b);
    }

    public void a(bq bqVar, String str, String str2) throws bw {
        try {
            try {
                a(bqVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f10196a.B();
        }
    }

    public void a(bq bqVar, byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        try {
            try {
                if (j(bArr, bxVar, bxVarArr) != null) {
                    bqVar.read(this.f10196a);
                }
            } catch (Exception e2) {
                throw new bw(e2);
            }
        } finally {
            this.f10197b.e();
            this.f10196a.B();
        }
    }

    public Boolean a(byte[] bArr, bx bxVar, bx... bxVarArr) throws bw {
        return (Boolean) a((byte) 2, bArr, bxVar, bxVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(byte r1, byte[] r2, com.umeng.analytics.pro.bx r3, com.umeng.analytics.pro.bx... r4) throws com.umeng.analytics.pro.bw {
        /*
            r0 = this;
            com.umeng.analytics.pro.ck r2 = r0.j(r2, r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r2 == 0) goto L9e
            r3 = 2
            if (r1 == r3) goto L8f
            r3 = 3
            if (r1 == r3) goto L80
            r3 = 4
            if (r1 == r3) goto L71
            r3 = 6
            if (r1 == r3) goto L62
            r3 = 8
            if (r1 == r3) goto L53
            r3 = 100
            r4 = 11
            if (r1 == r3) goto L48
            r3 = 10
            if (r1 == r3) goto L39
            if (r1 == r4) goto L24
            goto L9e
        L24:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r1 = r1.z()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
        L2e:
            com.umeng.analytics.pro.dc r2 = r0.f10197b
            r2.e()
            com.umeng.analytics.pro.cp r2 = r0.f10196a
            r2.B()
            return r1
        L39:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            long r1 = r1.x()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L48:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.ByteBuffer r1 = r1.A()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L53:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            int r1 = r1.w()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L62:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            short r1 = r1.v()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L71:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            double r1 = r1.y()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L80:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            byte r1 = r1.u()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L8f:
            byte r1 = r2.f10264b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.cp r1 = r0.f10196a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L9e:
            r1 = 0
            goto L2e
        La0:
            r1 = move-exception
            goto La9
        La2:
            r1 = move-exception
            com.umeng.analytics.pro.bw r2 = new com.umeng.analytics.pro.bw     // Catch: java.lang.Throwable -> La0
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La9:
            com.umeng.analytics.pro.dc r2 = r0.f10197b
            r2.e()
            com.umeng.analytics.pro.cp r2 = r0.f10196a
            r2.B()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.bt.a(byte, byte[], com.umeng.analytics.pro.bx, com.umeng.analytics.pro.bx[]):java.lang.Object");
    }

    public void a(bq bqVar, String str) throws bw {
        a(bqVar, str.getBytes());
    }
}
