package ui.e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import i.c.a.e;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import network.http.SearchVirusAppArrayHttp;
import ui.Hicore;
import ui.activity.VirusKillingActivity;
import util.n1;
import util.o1;
import util.r1;
import util.w1;

/* compiled from: ScanAppEngine.java */
/* loaded from: classes2.dex */
public final class b {
    public static final int t = 0;
    public static final int u = 1;
    private static b v;

    /* renamed from: a, reason: collision with root package name */
    private final int f19517a = 1;

    /* renamed from: b, reason: collision with root package name */
    private final int f19518b = 2;

    /* renamed from: c, reason: collision with root package name */
    private int f19519c = 200;

    /* renamed from: d, reason: collision with root package name */
    private final int f19520d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final int f19521e = 1;

    /* renamed from: f, reason: collision with root package name */
    private final int f19522f = 2;

    /* renamed from: g, reason: collision with root package name */
    private final int f19523g = 3;

    /* renamed from: h, reason: collision with root package name */
    private List<AppInfoBean> f19524h = null;

    /* renamed from: i, reason: collision with root package name */
    private List<AppInfoBean> f19525i = null;

    /* renamed from: j, reason: collision with root package name */
    private List<AppInfoBean> f19526j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f19527k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f19528l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f19529m = 0;
    private int n = 0;
    private int o = 0;
    private ui.e.c p = null;
    private WeakReference<Context> q = null;
    private Handler r = null;
    private Runnable s = new RunnableC0289b();

    /* compiled from: ScanAppEngine.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 != 1 && i2 != 2) {
                return false;
            }
            if (b.this.f19524h == null || b.this.f19524h.size() <= 0) {
                b.this.g();
                return false;
            }
            b.this.p.a(b.this.f19524h.size());
            b.this.f();
            return false;
        }
    }

    /* compiled from: ScanAppEngine.java */
    /* renamed from: ui.e.b$b, reason: collision with other inner class name */
    class RunnableC0289b implements Runnable {
        RunnableC0289b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f19526j != null && b.this.f19526j.size() > 0) {
                if (b.this.o != 1 && b.this.o != 3) {
                    b.this.p.a(null, (AppInfoBean) b.this.f19526j.get(0));
                    b.this.f19526j.remove(0);
                }
                b.this.r.postDelayed(b.this.s, b.this.f19519c);
                return;
            }
            if (b.this.p == null || b.this.o != 2) {
                b.this.r.postDelayed(b.this.s, b.this.f19519c);
            } else {
                b.this.o = 3;
                b.this.p.a();
            }
        }
    }

    /* compiled from: ScanAppEngine.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19532a;

        c(List list) {
            this.f19532a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < this.f19532a.size(); i2++) {
                try {
                    if (b.this.o == 3) {
                        return;
                    }
                    AppInfoBean appInfoBean = (AppInfoBean) this.f19532a.get(i2);
                    if (TextUtils.isEmpty(appInfoBean.getAppMD5())) {
                        appInfoBean.setAppMD5(o1.a(new File(appInfoBean.getPkgPath())));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (b.this.o == 3) {
                return;
            }
            b.this.a((List<AppInfoBean>) this.f19532a);
        }
    }

    /* compiled from: ScanAppEngine.java */
    class d implements SearchVirusAppArrayHttp.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19534a;

        d(List list) {
            this.f19534a = list;
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalFail(@e String str) {
            if (b.this.o == 3) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = Hicore.getApp().getString(R.string.err_timeout);
            }
            w1.a(str);
            b.this.f19525i = this.f19534a;
            b.this.o = 1;
            b.this.p.b();
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRequestFinish(int i2, boolean z) {
            if (b.this.o == 3) {
                return;
            }
            if (z) {
                b bVar = b.this;
                bVar.a((List<AppInfoBean>) this.f19534a, bVar.p);
                return;
            }
            n1.b("Finish mNextPosition-->" + b.this.f19528l);
            n1.b("Finish finalSubList-->" + new com.google.gson.e().a(this.f19534a));
        }

        @Override // network.http.SearchVirusAppArrayHttp.Callback
        public void principalRiskResult(boolean z) {
            if (b.this.o == 3) {
                return;
            }
            n1.b("Risk mNextPosition-->" + b.this.f19528l);
            n1.b("Risk finalSubList-->" + new com.google.gson.e().a(this.f19534a));
            b bVar = b.this;
            bVar.a((List<AppInfoBean>) this.f19534a, bVar.p);
        }
    }

    private void d() {
        this.f19527k = -1;
        this.f19528l = -1;
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<AppInfoBean> list = this.f19524h;
        if (list != null) {
            list.clear();
        }
        this.f19524h = null;
        List<AppInfoBean> list2 = this.f19526j;
        if (list2 != null) {
            list2.clear();
        }
        this.f19526j = null;
        List<AppInfoBean> list3 = this.f19525i;
        if (list3 != null) {
            list3.clear();
        }
        this.f19525i = null;
        WeakReference<Context> weakReference = this.q;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.q = null;
        this.p = null;
    }

    public static b e() {
        if (v == null) {
            synchronized (b.class) {
                if (v == null) {
                    v = new b();
                }
            }
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.p == null) {
            throw new NullPointerException("listener 不能为空");
        }
        List<AppInfoBean> list = this.f19524h;
        if (list == null || list.size() <= 0) {
            g();
            return;
        }
        List<AppInfoBean> list2 = this.f19525i;
        if (list2 != null && list2.size() > 0) {
            ArrayList arrayList = new ArrayList(this.f19525i);
            this.f19525i.clear();
            if (this.o != 3) {
                a(arrayList);
                return;
            }
            return;
        }
        int i2 = this.f19527k;
        if (i2 == -1) {
            this.f19527k = 0;
        } else if (i2 != this.f19528l) {
            return;
        }
        this.f19528l = this.f19527k + Math.min(this.f19524h.size() - this.f19527k, 30);
        ArrayList arrayList2 = new ArrayList(this.f19524h.subList(this.f19527k, this.f19528l));
        if (this.f19529m == 1) {
            if (this.f19526j == null) {
                this.f19526j = new ArrayList();
            }
            n1.b("scanSingleIng-->", "mQueueList1 " + this.f19526j.size());
            this.f19526j.addAll(arrayList2);
            n1.b("scanSingleIng-->", "mQueueList2 " + this.f19526j.size());
            if (this.f19527k == 0) {
                this.r.postDelayed(this.s, this.f19519c);
            }
        } else {
            this.p.a(arrayList2, null);
        }
        new Thread(new c(arrayList2)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.o = 2;
        if (this.p != null) {
            List<AppInfoBean> list = this.f19526j;
            if (list == null || list.size() <= 0) {
                this.o = 3;
                this.p.a();
            }
        }
    }

    public void c() {
        this.o = 1;
    }

    public void b(Context context, ui.e.c cVar) {
        a(context, 0, 2, cVar);
    }

    public void b(Context context, int i2, ui.e.c cVar) {
        a(context, i2, 2, cVar);
    }

    public void a(Context context, ui.e.c cVar) {
        a(context, 0, 1, cVar);
    }

    public void b() {
        this.o = 3;
        this.f19529m = 0;
        this.n = 0;
        d();
    }

    public void a(Context context, int i2, ui.e.c cVar) {
        a(context, i2, 1, cVar);
    }

    private void a(Context context, int i2, int i3, ui.e.c cVar) {
        WeakReference<Context> weakReference;
        List<AppInfoBean> list;
        if (context != null) {
            if (this.n == i3 && (weakReference = this.q) != null && weakReference.get() == context) {
                int i4 = this.o;
                if (i4 == 2) {
                    g();
                    return;
                }
                if (i4 == 1) {
                    if (this.f19528l > 0 && (list = this.f19524h) != null && list.size() > 0 && this.f19528l < this.f19524h.size()) {
                        this.o = 0;
                        f();
                        return;
                    } else {
                        g();
                        return;
                    }
                }
                if (i4 != 3 || this.p == null) {
                    return;
                }
                List<AppInfoBean> list2 = this.f19526j;
                if (list2 == null || list2.size() <= 0) {
                    this.p.a();
                    return;
                }
                return;
            }
            WeakReference<Context> weakReference2 = this.q;
            if (weakReference2 == null || !(weakReference2.get() instanceof VirusKillingActivity) || (context instanceof VirusKillingActivity)) {
                this.f19529m = i2;
                this.n = i3;
                this.o = 0;
                d();
                this.q = new WeakReference<>(context);
                if (cVar != null) {
                    this.p = cVar;
                    if (this.r == null) {
                        this.r = new Handler((Handler.Callback) new WeakReference(new a()).get());
                    }
                    this.p.c();
                    List<AppInfoBean> list3 = this.f19524h;
                    if (list3 != null && list3.size() > 0) {
                        f();
                        return;
                    } else {
                        new Thread(new Runnable() { // from class: ui.e.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f19516a.a();
                            }
                        }).start();
                        return;
                    }
                }
                throw new NullPointerException("listener 不能为空");
            }
            return;
        }
        throw new NullPointerException("context 不能为空");
    }

    public /* synthetic */ void a() {
        int i2 = this.n;
        if (i2 == 1) {
            this.f19524h = new r1(Hicore.getApp()).a();
        } else if (i2 == 2) {
            this.f19524h = r1.a(new String[]{r1.f20958d});
        }
        this.r.sendEmptyMessage(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AppInfoBean> list) {
        SearchVirusAppArrayHttp.Companion.getInstance().principalHttp(list, new d(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AppInfoBean> list, ui.e.c cVar) {
        cVar.a(list);
        int i2 = this.f19528l;
        if (i2 > 0 && i2 < this.f19524h.size()) {
            this.f19527k = this.f19528l;
            if (this.o == 0) {
                f();
                return;
            }
            return;
        }
        g();
    }
}
