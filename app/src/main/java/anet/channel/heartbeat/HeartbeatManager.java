package anet.channel.heartbeat;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeartbeatManager {
    public static IHeartbeat getDefaultBackgroundAccsHeartbeat() {
        return new a();
    }

    public static IHeartbeat getDefaultHeartbeat() {
        return new b();
    }
}
