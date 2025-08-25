package anet.channel.strategy.dispatch;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static Random f1966b = new Random();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1967a;

    a() {
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.dispatch.a$a, reason: collision with other inner class name */
    private class RunnableC0015a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f1969b;

        RunnableC0015a(Map<String, Object> map) {
            this.f1969b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.f1969b;
                if (map2 == null) {
                    synchronized (a.class) {
                        map = a.this.f1967a;
                        a.this.f1967a = null;
                    }
                    map2 = map;
                }
                if (NetworkStatusHelper.isConnected()) {
                    if (GlobalAppRuntimeInfo.getEnv() != map2.get("Env")) {
                        ALog.w(a.TAG, "task's env changed", null, new Object[0]);
                    } else {
                        b.a(d.a(map2));
                    }
                }
            } catch (Exception e2) {
                ALog.e(a.TAG, "exec amdc task failed.", null, e2, new Object[0]);
            }
        }

        RunnableC0015a() {
        }
    }

    public void a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                if (this.f1967a == null) {
                    this.f1967a = map;
                    int iNextInt = f1966b.nextInt(PathInterpolatorCompat.MAX_NUM_POINTS) + 2000;
                    ALog.i(TAG, "merge amdc request", null, "delay", Integer.valueOf(iNextInt));
                    anet.channel.strategy.utils.a.a(new RunnableC0015a(), iNextInt);
                } else {
                    Set set = (Set) this.f1967a.get(DispatchConstants.HOSTS);
                    Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                    if (map.get("Env") != this.f1967a.get("Env")) {
                        this.f1967a = map;
                    } else if (set.size() + set2.size() <= 40) {
                        set2.addAll(set);
                        this.f1967a = map;
                    } else {
                        anet.channel.strategy.utils.a.a(new RunnableC0015a(map));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
