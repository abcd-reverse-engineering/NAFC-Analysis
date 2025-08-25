package anet.channel.strategy;

import h.f1;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class ConnHistoryItem implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    byte f1914a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f1915b = 0;

    /* renamed from: c, reason: collision with root package name */
    long f1916c = 0;

    ConnHistoryItem() {
    }

    void a(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - (z ? this.f1915b : this.f1916c) > com.heytap.mcssdk.constant.a.q) {
            this.f1914a = (byte) ((this.f1914a << 1) | (!z ? 1 : 0));
            if (z) {
                this.f1915b = jCurrentTimeMillis;
            } else {
                this.f1916c = jCurrentTimeMillis;
            }
        }
    }

    boolean b() {
        return (this.f1914a & 1) == 1;
    }

    boolean c() {
        return a() >= 3 && System.currentTimeMillis() - this.f1916c <= 300000;
    }

    boolean d() {
        long j2 = this.f1915b;
        long j3 = this.f1916c;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j2 != 0 && System.currentTimeMillis() - j2 > 86400000;
    }

    int a() {
        int i2 = 0;
        for (int i3 = this.f1914a & f1.f16099c; i3 > 0; i3 >>= 1) {
            i2 += i3 & 1;
        }
        return i2;
    }
}
