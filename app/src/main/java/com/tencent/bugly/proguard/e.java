package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class e extends d {

    /* renamed from: h, reason: collision with root package name */
    static HashMap<String, byte[]> f9384h;

    /* renamed from: i, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f9385i;

    /* renamed from: g, reason: collision with root package name */
    protected g f9386g = new g();

    /* renamed from: j, reason: collision with root package name */
    private int f9387j = 0;

    public e() {
        this.f9386g.f9393a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    @Override // com.tencent.bugly.proguard.d
    public void b() {
        super.b();
        this.f9386g.f9393a = (short) 3;
    }

    public void c(String str) {
        this.f9386g.f9398f = str;
    }

    public void b(String str) {
        this.f9386g.f9397e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public byte[] a() {
        g gVar = this.f9386g;
        if (gVar.f9393a == 2) {
            if (!gVar.f9397e.equals("")) {
                if (this.f9386g.f9398f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f9397e == null) {
                gVar.f9397e = "";
            }
            g gVar2 = this.f9386g;
            if (gVar2.f9398f == null) {
                gVar2.f9398f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f9378c);
        if (this.f9386g.f9393a == 2) {
            lVar.a((Map) this.f9376a, 0);
        } else {
            lVar.a((Map) ((d) this).f9381e, 0);
        }
        this.f9386g.f9399g = n.a(lVar.a());
        l lVar2 = new l(0);
        lVar2.a(this.f9378c);
        a(lVar2);
        byte[] bArrA = n.a(lVar2.a());
        int length = bArrA.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, 4);
                kVar.a(this.f9378c);
                a(kVar);
                if (this.f9386g.f9393a == 3) {
                    k kVar2 = new k(this.f9386g.f9399g);
                    kVar2.a(this.f9378c);
                    if (f9384h == null) {
                        f9384h = new HashMap<>();
                        f9384h.put("", new byte[0]);
                    }
                    ((d) this).f9381e = kVar2.a((Map) f9384h, 0, false);
                    return;
                }
                k kVar3 = new k(this.f9386g.f9399g);
                kVar3.a(this.f9378c);
                if (f9385i == null) {
                    f9385i = new HashMap<>();
                    HashMap<String, byte[]> map = new HashMap<>();
                    map.put("", new byte[0]);
                    f9385i.put("", map);
                }
                this.f9376a = kVar3.a((Map) f9385i, 0, false);
                this.f9377b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void a(int i2) {
        this.f9386g.f9396d = i2;
    }

    public void a(l lVar) {
        this.f9386g.a(lVar);
    }

    public void a(k kVar) {
        this.f9386g.a(kVar);
    }
}
