package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class d extends c {

    /* renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f9381e = null;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f9383g = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    k f9382f = new k();

    private void c(String str, Object obj) {
        this.f9383g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f9381e = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t) {
        if (this.f9381e == null) {
            super.a(str, (String) t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f9378c);
        lVar.a(t, 0);
        this.f9381e.put(str, n.a(lVar.a()));
    }

    public <T> T b(String str, T t) throws b {
        HashMap<String, byte[]> map = this.f9381e;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f9383g.containsKey(str)) {
                return (T) this.f9383g.get(str);
            }
            try {
                T t2 = (T) a(this.f9381e.get(str), t);
                if (t2 != null) {
                    c(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
        if (!this.f9376a.containsKey(str)) {
            return null;
        }
        if (this.f9383g.containsKey(str)) {
            return (T) this.f9383g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f9376a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f9382f.a(value);
            this.f9382f.a(this.f9378c);
            T t3 = (T) this.f9382f.a((k) t, 0, true);
            c(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new b(e3);
        }
    }

    private Object a(byte[] bArr, Object obj) {
        this.f9382f.a(bArr);
        this.f9382f.a(this.f9378c);
        return this.f9382f.a((k) obj, 0, true);
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f9381e != null) {
            l lVar = new l(0);
            lVar.a(this.f9378c);
            lVar.a((Map) this.f9381e, 0);
            return n.a(lVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f9382f.a(bArr);
            this.f9382f.a(this.f9378c);
            HashMap map = new HashMap(1);
            map.put("", new byte[0]);
            this.f9381e = this.f9382f.a((Map) map, 0, false);
        }
    }
}
