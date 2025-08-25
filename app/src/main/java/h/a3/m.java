package h.a3;

import h.t0;
import java.util.concurrent.TimeUnit;

/* compiled from: MonoTimeSource.kt */
@j
@t0(version = "1.3")
/* loaded from: classes2.dex */
public final class m extends b implements p {

    /* renamed from: c, reason: collision with root package name */
    public static final m f16087c = new m();

    private m() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // h.a3.b
    protected long c() {
        return System.nanoTime();
    }

    @i.c.a.d
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
