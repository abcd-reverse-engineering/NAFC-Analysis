package c.b.c;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String f2843a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2844b;

    /* renamed from: c, reason: collision with root package name */
    private t[] f2845c;

    /* renamed from: d, reason: collision with root package name */
    private final a f2846d;

    /* renamed from: e, reason: collision with root package name */
    private Map<s, Object> f2847e;

    /* renamed from: f, reason: collision with root package name */
    private final long f2848f;

    public r(String str, byte[] bArr, t[] tVarArr, a aVar) {
        this(str, bArr, tVarArr, aVar, System.currentTimeMillis());
    }

    public a a() {
        return this.f2846d;
    }

    public byte[] b() {
        return this.f2844b;
    }

    public Map<s, Object> c() {
        return this.f2847e;
    }

    public t[] d() {
        return this.f2845c;
    }

    public String e() {
        return this.f2843a;
    }

    public long f() {
        return this.f2848f;
    }

    public String toString() {
        return this.f2843a;
    }

    public r(String str, byte[] bArr, t[] tVarArr, a aVar, long j2) {
        this.f2843a = str;
        this.f2844b = bArr;
        this.f2845c = tVarArr;
        this.f2846d = aVar;
        this.f2847e = null;
        this.f2848f = j2;
    }

    public void a(s sVar, Object obj) {
        if (this.f2847e == null) {
            this.f2847e = new EnumMap(s.class);
        }
        this.f2847e.put(sVar, obj);
    }

    public void a(Map<s, Object> map) {
        if (map != null) {
            Map<s, Object> map2 = this.f2847e;
            if (map2 == null) {
                this.f2847e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void a(t[] tVarArr) {
        t[] tVarArr2 = this.f2845c;
        if (tVarArr2 == null) {
            this.f2845c = tVarArr;
            return;
        }
        if (tVarArr == null || tVarArr.length <= 0) {
            return;
        }
        t[] tVarArr3 = new t[tVarArr2.length + tVarArr.length];
        System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
        System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
        this.f2845c = tVarArr3;
    }
}
