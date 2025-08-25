package com.xiaomi.push;

import com.xiaomi.push.hw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ig extends hw {

    /* renamed from: b, reason: collision with root package name */
    private static int f13239b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private static int f13240c = 10000;

    /* renamed from: d, reason: collision with root package name */
    private static int f13241d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private static int f13242e = 10485760;

    /* renamed from: f, reason: collision with root package name */
    private static int f13243f = 104857600;

    public static class a extends hw.a {
        public a() {
            super(false, true);
        }

        @Override // com.xiaomi.push.hw.a, com.xiaomi.push.ic
        public ia a(ik ikVar) {
            ig igVar = new ig(ikVar, ((hw.a) this).f896a, this.f13223b);
            int i2 = ((hw.a) this).f13222a;
            if (i2 != 0) {
                igVar.b(i2);
            }
            return igVar;
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }
    }

    public ig(ik ikVar, boolean z, boolean z2) {
        super(ikVar, z, z2);
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* renamed from: a */
    public hz mo605a() throws hu {
        byte bA = a();
        byte bA2 = a();
        int iMo601a = mo601a();
        if (iMo601a <= f13239b) {
            return new hz(bA, bA2, iMo601a);
        }
        throw new ib(3, "Thrift map size " + iMo601a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* renamed from: a */
    public hy mo604a() throws hu {
        byte bA = a();
        int iMo601a = mo601a();
        if (iMo601a <= f13240c) {
            return new hy(bA, iMo601a);
        }
        throw new ib(3, "Thrift list size " + iMo601a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* renamed from: a */
    public ie mo606a() throws hu {
        byte bA = a();
        int iMo601a = mo601a();
        if (iMo601a <= f13241d) {
            return new ie(bA, iMo601a);
        }
        throw new ib(3, "Thrift set size " + iMo601a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* renamed from: a */
    public String mo608a() throws hu {
        int iMo601a = mo601a();
        if (iMo601a <= f13242e) {
            if (((ia) this).f13234a.b() >= iMo601a) {
                try {
                    String str = new String(((ia) this).f13234a.a(), ((ia) this).f13234a.a_(), iMo601a, "UTF-8");
                    ((ia) this).f13234a.a(iMo601a);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new hu("JVM DOES NOT SUPPORT UTF-8");
                }
            }
            return a(iMo601a);
        }
        throw new ib(3, "Thrift string size " + iMo601a + " out of range!");
    }

    @Override // com.xiaomi.push.hw, com.xiaomi.push.ia
    /* renamed from: a */
    public ByteBuffer mo609a() throws hu {
        int iMo601a = mo601a();
        if (iMo601a <= f13243f) {
            c(iMo601a);
            if (((ia) this).f13234a.b() >= iMo601a) {
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ia) this).f13234a.a(), ((ia) this).f13234a.a_(), iMo601a);
                ((ia) this).f13234a.a(iMo601a);
                return byteBufferWrap;
            }
            byte[] bArr = new byte[iMo601a];
            ((ia) this).f13234a.b(bArr, 0, iMo601a);
            return ByteBuffer.wrap(bArr);
        }
        throw new ib(3, "Thrift binary size " + iMo601a + " out of range!");
    }
}
