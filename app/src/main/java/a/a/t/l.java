package a.a.t;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    public final anetwork.channel.entity.k f1230a;

    /* renamed from: b, reason: collision with root package name */
    public a.a.p.a f1231b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1232c;

    /* renamed from: d, reason: collision with root package name */
    public volatile AtomicBoolean f1233d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public volatile a f1234e = null;

    /* renamed from: f, reason: collision with root package name */
    public volatile Future f1235f = null;

    public l(anetwork.channel.entity.k kVar, a.a.p.a aVar) {
        this.f1230a = kVar;
        this.f1232c = kVar.f2229i;
        this.f1231b = aVar;
    }

    public void a() {
        Future future = this.f1235f;
        if (future != null) {
            future.cancel(true);
            this.f1235f = null;
        }
    }

    public void b() {
        if (this.f1234e != null) {
            this.f1234e.cancel();
            this.f1234e = null;
        }
    }
}
