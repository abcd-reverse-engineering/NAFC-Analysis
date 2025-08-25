package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f6892b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, com.huawei.hms.framework.network.grs.g.j.b> f6893c = new ConcurrentHashMap(16);

    /* renamed from: d, reason: collision with root package name */
    private static final Object f6894d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f6895a;

    class a implements Callable<d> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c f6896a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6897b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f6898c;

        a(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.f6896a = cVar;
            this.f6897b = str;
            this.f6898c = cVar2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.f6896a, g.this.f6895a).a(g.f6892b, this.f6897b, this.f6898c);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c f6900a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6901b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f6902c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f6903d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.huawei.hms.framework.network.grs.b f6904e;

        b(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2, com.huawei.hms.framework.network.grs.b bVar) {
            this.f6900a = cVar;
            this.f6901b = str;
            this.f6902c = cVar2;
            this.f6903d = i2;
            this.f6904e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.a(gVar.a(this.f6900a, this.f6901b, this.f6902c, this.f6903d), this.f6904e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(dVar);
            }
        }
    }

    public d a(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2) {
        Future<d> futureSubmit;
        String str2;
        String str3;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (f6894d) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a aVarA = com.huawei.hms.framework.network.grs.h.d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.j.b bVar = f6893c.get(grsParasKey);
            if (bVar == null || !bVar.b()) {
                if (aVarA != null && aVarA.a()) {
                    return null;
                }
                Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
                futureSubmit = f6892b.submit(new a(cVar, str, cVar2));
                f6893c.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.j.b(futureSubmit));
            } else {
                futureSubmit = bVar.a();
            }
            if (i2 == -1) {
                com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(cVar.a());
                i2 = dVarA != null ? dVarA.c() : 10;
            }
            Logger.i("RequestController", "use grsQueryTimeout %d", Integer.valueOf(i2));
            try {
                return futureSubmit.get(i2, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (CancellationException e3) {
                e = e3;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (ExecutionException e4) {
                e = e4;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "RequestController";
                str3 = "when check result, find TimeoutException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (Exception e6) {
                e = e6;
                str2 = "RequestController";
                str3 = "when check result, find Other Exception, check others";
                Logger.w(str2, str3, e);
                return null;
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f6895a = aVar;
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2) {
        f6892b.execute(new b(cVar, str, cVar2, i2, bVar));
    }

    public void a(String str) {
        synchronized (f6894d) {
            f6893c.remove(str);
        }
    }
}
