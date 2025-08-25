package anet.channel.request;

import anet.channel.util.ALog;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b implements Cancelable {
    public static final b NULL = new b(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Future<?> f1867a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1868b;

    public b(Future<?> future, String str) {
        this.f1867a = future;
        this.f1868b = str;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        if (this.f1867a != null) {
            ALog.i("awcn.FutureCancelable", "cancel request", this.f1868b, new Object[0]);
            this.f1867a.cancel(true);
        }
    }
}
