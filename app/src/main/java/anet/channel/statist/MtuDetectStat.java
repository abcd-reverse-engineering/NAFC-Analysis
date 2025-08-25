package anet.channel.statist;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
@Monitor(module = "networkPrefer", monitorPoint = "mtuDetect")
/* loaded from: classes.dex */
public class MtuDetectStat extends StatObject {

    @Dimension
    public int errCode;

    @Dimension
    public int mtu;

    @Dimension
    public int pingSuccessCount;

    @Dimension
    public int pingTimeoutCount;

    @Dimension
    public String rtt;

    @Dimension
    public String nettype = NetworkStatusHelper.getNetworkSubType();

    @Dimension
    public String mnc = NetworkStatusHelper.getSimOp();

    @Dimension
    public String bssid = NetworkStatusHelper.getWifiBSSID();
}
