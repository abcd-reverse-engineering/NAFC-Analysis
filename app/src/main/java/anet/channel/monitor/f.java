package anet.channel.monitor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    protected long f1838b;

    /* renamed from: c, reason: collision with root package name */
    private final double f1839c = 40.0d;

    /* renamed from: a, reason: collision with root package name */
    boolean f1837a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1840d = true;

    public int a() {
        return 0;
    }

    public boolean a(double d2) {
        return d2 < 40.0d;
    }

    protected final boolean b() {
        if (!this.f1840d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f1838b <= a() * 1000) {
            return true;
        }
        this.f1840d = false;
        return false;
    }
}
