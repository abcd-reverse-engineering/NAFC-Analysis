package a.a.p;

import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface a {
    void a(int i2, int i3, ByteArray byteArray);

    void a(DefaultFinishEvent defaultFinishEvent);

    void onResponseCode(int i2, Map<String, List<String>> map);
}
