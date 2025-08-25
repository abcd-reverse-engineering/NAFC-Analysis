package anet.channel.request;

import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c implements Cancelable {
    public static final c NULL = new c(null, 0, null);

    /* renamed from: a, reason: collision with root package name */
    private final int f1869a;

    /* renamed from: b, reason: collision with root package name */
    private final SpdySession f1870b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1871c;

    public c(SpdySession spdySession, int i2, String str) {
        this.f1870b = spdySession;
        this.f1869a = i2;
        this.f1871c = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        try {
            if (this.f1870b == null || this.f1869a == 0) {
                return;
            }
            ALog.i("awcn.TnetCancelable", "cancel tnet request", this.f1871c, "streamId", Integer.valueOf(this.f1869a));
            this.f1870b.streamReset(this.f1869a, 5);
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetCancelable", "request cancel failed.", this.f1871c, e2, Constants.KEY_ERROR_CODE, Integer.valueOf(e2.SpdyErrorGetCode()));
        }
    }
}
