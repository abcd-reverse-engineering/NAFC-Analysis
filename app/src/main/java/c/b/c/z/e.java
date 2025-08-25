package c.b.c.z;

import java.util.List;

/* compiled from: DecoderResult.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f3012a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3013b;

    /* renamed from: c, reason: collision with root package name */
    private final List<byte[]> f3014c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3015d;

    /* renamed from: e, reason: collision with root package name */
    private Integer f3016e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f3017f;

    /* renamed from: g, reason: collision with root package name */
    private Object f3018g;

    /* renamed from: h, reason: collision with root package name */
    private final int f3019h;

    /* renamed from: i, reason: collision with root package name */
    private final int f3020i;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f3014c;
    }

    public String b() {
        return this.f3015d;
    }

    public Integer c() {
        return this.f3017f;
    }

    public Integer d() {
        return this.f3016e;
    }

    public Object e() {
        return this.f3018g;
    }

    public byte[] f() {
        return this.f3012a;
    }

    public int g() {
        return this.f3019h;
    }

    public int h() {
        return this.f3020i;
    }

    public String i() {
        return this.f3013b;
    }

    public boolean j() {
        return this.f3019h >= 0 && this.f3020i >= 0;
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this.f3012a = bArr;
        this.f3013b = str;
        this.f3014c = list;
        this.f3015d = str2;
        this.f3019h = i3;
        this.f3020i = i2;
    }

    public void a(Integer num) {
        this.f3017f = num;
    }

    public void b(Integer num) {
        this.f3016e = num;
    }

    public void a(Object obj) {
        this.f3018g = obj;
    }
}
