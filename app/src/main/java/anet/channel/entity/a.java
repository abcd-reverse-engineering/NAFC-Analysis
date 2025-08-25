package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final IConnStrategy f1761a;

    /* renamed from: b, reason: collision with root package name */
    public int f1762b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1763c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f1764d;

    /* renamed from: e, reason: collision with root package name */
    private String f1765e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f1761a = iConnStrategy;
        this.f1764d = str;
        this.f1765e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.f1761a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.f1761a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.f1761a;
        return iConnStrategy != null ? ConnType.valueOf(iConnStrategy.getProtocol()) : ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.f1761a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.f1761a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.f1761a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.f1761a.getReadTimeout();
    }

    public String f() {
        return this.f1764d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.f1761a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f1765e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
