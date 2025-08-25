package anet.channel.util;

import java.net.Inet6Address;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f2055a;

    /* renamed from: b, reason: collision with root package name */
    public Inet6Address f2056b;

    public f(Inet6Address inet6Address, int i2) {
        this.f2055a = i2;
        this.f2056b = inet6Address;
    }

    public String toString() {
        return this.f2056b.getHostAddress() + "/" + this.f2055a;
    }
}
