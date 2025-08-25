package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;

    /* renamed from: a, reason: collision with root package name */
    volatile int f1917a = 1;

    /* renamed from: b, reason: collision with root package name */
    volatile int f1918b = 1;

    /* renamed from: c, reason: collision with root package name */
    transient boolean f1919c;
    public volatile int cto;
    public volatile int heartbeat;
    public final String ip;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;

    private IPConnStrategy(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        this.ip = str;
        this.port = i2;
        this.protocol = connProtocol;
        this.cto = i3;
        this.rto = i4;
        this.retry = i5;
        this.heartbeat = i6;
    }

    static IPConnStrategy a(String str, l.a aVar) {
        ConnProtocol connProtocolValueOf = ConnProtocol.valueOf(aVar);
        if (connProtocolValueOf == null) {
            return null;
        }
        return a(str, aVar.f1989a, connProtocolValueOf, aVar.f1991c, aVar.f1992d, aVar.f1993e, aVar.f1994f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        return this.port == iPConnStrategy.port && this.ip.equals(iPConnStrategy.ip) && this.protocol.equals(iPConnStrategy.protocol);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.cto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.heartbeat;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.ip;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f1918b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f1917a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.port;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.rto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.retry;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        sb.append(this.ip);
        if (this.f1917a == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    static IPConnStrategy a(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i2 <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i2, connProtocol, i3, i4, i5, i6);
    }
}
