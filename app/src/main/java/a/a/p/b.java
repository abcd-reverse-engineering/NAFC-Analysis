package a.a.p;

import anet.channel.request.Request;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: Taobao */
    public interface a {
        Future a(Request request, a.a.p.a aVar);

        a.a.p.a callback();

        Request request();
    }

    Future a(a aVar);
}
