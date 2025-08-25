package anet.channel.monitor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* renamed from: a, reason: collision with root package name */
    private final String f1802a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1803b;

    NetworkSpeed(String str, int i2) {
        this.f1802a = str;
        this.f1803b = i2;
    }

    public static NetworkSpeed valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f1803b;
    }

    public String getDesc() {
        return this.f1802a;
    }
}
