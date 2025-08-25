package anet.channel.monitor;

import anet.channel.util.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f1822a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1823b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f1824c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f1825d;

    d(b bVar, long j2, long j3, long j4) {
        this.f1825d = bVar;
        this.f1822a = j2;
        this.f1823b = j3;
        this.f1824c = j4;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.f1807a++;
        b.f1811e += this.f1822a;
        if (b.f1807a == 1) {
            b.f1810d = this.f1823b - this.f1824c;
        }
        int i2 = b.f1807a;
        if (i2 >= 2 && i2 <= 3) {
            long j2 = this.f1824c;
            long j3 = b.f1809c;
            if (j2 >= j3) {
                b.f1810d += this.f1823b - j2;
            } else if (j2 < j3) {
                long j4 = this.f1823b;
                if (j4 >= j3) {
                    b.f1810d += j4 - j2;
                    b.f1810d -= b.f1809c - j2;
                }
            }
        }
        b.f1808b = this.f1824c;
        b.f1809c = this.f1823b;
        if (b.f1807a == 3) {
            b.f1815i = (long) this.f1825d.n.a(b.f1811e, b.f1810d);
            b.f1812f++;
            b.b(this.f1825d);
            if (b.f1812f > 30) {
                this.f1825d.n.a();
                b.f1812f = 3L;
            }
            double d2 = (b.f1815i * 0.68d) + (b.f1814h * 0.27d) + (b.f1813g * 0.05d);
            b.f1813g = b.f1814h;
            b.f1814h = b.f1815i;
            if (b.f1815i < b.f1813g * 0.65d || b.f1815i > b.f1813g * 2.0d) {
                b.f1815i = d2;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f1811e), "mKalmanTimeUsed", Long.valueOf(b.f1810d), "speed", Double.valueOf(b.f1815i), "mSpeedKalmanCount", Long.valueOf(b.f1812f));
            }
            if (this.f1825d.f1819m > 5 || b.f1812f == 2) {
                a.a().a(b.f1815i);
                this.f1825d.f1819m = 0;
                this.f1825d.f1818l = b.f1815i < b.f1816j ? 1 : 5;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f1810d = 0L;
            b.f1811e = 0L;
            b.f1807a = 0;
        }
    }
}
