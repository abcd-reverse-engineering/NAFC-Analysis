package anet.channel;

import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface RequestCb {
    void onDataReceive(ByteArray byteArray, boolean z);

    void onFinish(int i2, String str, RequestStatistic requestStatistic);

    void onResponseCode(int i2, Map<String, List<String>> map);
}
