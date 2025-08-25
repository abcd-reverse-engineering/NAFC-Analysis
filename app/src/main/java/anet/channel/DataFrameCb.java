package anet.channel;

import anet.channel.session.TnetSpdySession;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface DataFrameCb {
    void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3);

    void onException(int i2, int i3, boolean z, String str);
}
