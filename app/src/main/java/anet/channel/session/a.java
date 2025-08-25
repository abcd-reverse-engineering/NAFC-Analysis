package anet.channel.session;

import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdySession;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseData;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a implements Spdycb {
    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j2, SpdyByteArray spdyByteArray, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j2, int i2, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j2, Map<String, List<String>> map, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j2, Object obj) {
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j2, int i2, Object obj, SuperviseData superviseData) {
    }
}
