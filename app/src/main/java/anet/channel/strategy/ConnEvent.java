package anet.channel.strategy;

import h.q2.t.m0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnEvent {
    public boolean isSuccess = false;
    public long connTime = m0.f16408b;
    public boolean isAccs = false;

    public String toString() {
        return this.isSuccess ? "ConnEvent#Success" : "ConnEvent#Fail";
    }
}
