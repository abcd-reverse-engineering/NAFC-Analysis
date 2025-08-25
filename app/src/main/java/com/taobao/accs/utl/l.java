package com.taobao.accs.utl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.agoo.TaobaoRegister;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static final int STATE_BACK = 0;
    public static final int STATE_FORE = 1;

    /* renamed from: b, reason: collision with root package name */
    private static volatile l f8681b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f8682c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<b> f8683d;

    /* renamed from: e, reason: collision with root package name */
    private static Application f8684e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8687g;

    /* renamed from: a, reason: collision with root package name */
    private static final String f8680a = l.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static boolean f8685j = false;

    /* renamed from: f, reason: collision with root package name */
    private int f8686f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f8688h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f8689i = 1;

    /* compiled from: Taobao */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private String f8690a;

        /* renamed from: b, reason: collision with root package name */
        private int f8691b;

        /* renamed from: c, reason: collision with root package name */
        private long f8692c = t.a(l.f8684e);

        public a(String str, int i2) {
            this.f8690a = str;
            this.f8691b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ALog.e(l.f8680a, "click report", "lastActiveTime", Long.valueOf(this.f8692c), "currentActiveTime", Long.valueOf(jCurrentTimeMillis));
            long j2 = this.f8692c;
            if (j2 == 0 || UtilityImpl.a(j2, jCurrentTimeMillis)) {
                this.f8691b |= 8;
            }
            TaobaoRegister.clickMessage(l.f8684e, this.f8690a, null, this.f8691b, this.f8692c);
        }
    }

    /* compiled from: Taobao */
    public interface b {
        void a();

        void b();
    }

    private l() {
        f8682c = new ArrayList<>();
        f8683d = new ArrayList<>();
    }

    public static l a() {
        if (f8681b == null) {
            synchronized (l.class) {
                if (f8681b == null) {
                    f8681b = new l();
                }
            }
        }
        return f8681b;
    }

    public void b() {
        ArrayList<a> arrayList = f8682c;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(it.next());
            }
            f8682c.clear();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int i2 = this.f8686f;
        if ((i2 & 1) != 1) {
            this.f8686f = i2 | 1;
            this.f8686f |= 2;
        } else if ((i2 & 2) == 2) {
            this.f8686f = i2 & (-3);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.f8687g) {
            t.a(f8684e, System.currentTimeMillis());
            if (!f8685j) {
                f8685j = true;
            }
        }
        this.f8687g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i2 = this.f8688h;
        this.f8688h = i2 + 1;
        if (i2 == 0) {
            ALog.i(f8680a, "onActivityStarted back to force", new Object[0]);
            this.f8687g = true;
            this.f8689i = 1;
            ThreadPoolExecutorFactory.execute(new m(this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f8688h - 1;
        this.f8688h = i2;
        if (i2 == 0) {
            this.f8689i = 0;
            ThreadPoolExecutorFactory.execute(new n(this));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            f8683d.add(bVar);
        }
    }
}
