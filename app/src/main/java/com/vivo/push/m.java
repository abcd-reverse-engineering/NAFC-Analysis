package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.cloudwalk.FaceInterface;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushClientManager.java */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f12094a;

    /* renamed from: h, reason: collision with root package name */
    private Context f12101h;

    /* renamed from: j, reason: collision with root package name */
    private String f12103j;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f12106m;
    private Long n;
    private boolean o;
    private int q;

    /* renamed from: b, reason: collision with root package name */
    private long f12095b = -1;

    /* renamed from: c, reason: collision with root package name */
    private long f12096c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f12097d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f12098e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f12099f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f12100g = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12102i = true;

    /* renamed from: k, reason: collision with root package name */
    private SparseArray<a> f12104k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private int f12105l = 0;
    private IPushClientFactory p = new l();

    private m() {
    }

    public static List<String> c() {
        String strG = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.u.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(strG)) {
            return arrayList;
        }
        Iterator<String> itKeys = new JSONObject(strG).keys();
        while (itKeys.hasNext()) {
            arrayList.add(itKeys.next());
        }
        return arrayList;
    }

    private boolean l() {
        if (this.f12106m == null) {
            this.f12106m = Boolean.valueOf(k() >= 1230 && ag.d(this.f12101h));
        }
        return this.f12106m.booleanValue();
    }

    public final boolean d() {
        if (this.f12101h == null) {
            com.vivo.push.util.u.d("PushClientManager", "support:context is null");
            return false;
        }
        this.f12106m = Boolean.valueOf(l());
        return this.f12106m.booleanValue();
    }

    public final void e() {
        this.f12103j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.o;
    }

    public final boolean g() {
        return this.f12102i;
    }

    public final Context h() {
        return this.f12101h;
    }

    public final String i() {
        return this.f12103j;
    }

    public final int j() {
        return this.q;
    }

    public final long k() {
        Context context = this.f12101h;
        if (context == null) {
            return -1L;
        }
        if (this.n == null) {
            this.n = Long.valueOf(ag.a(context));
        }
        return this.n.longValue();
    }

    public static synchronized m a() {
        if (f12094a == null) {
            f12094a = new m();
        }
        return f12094a;
    }

    protected final void b() throws PackageManager.NameNotFoundException, VivoPushException {
        Context context = this.f12101h;
        if (context != null) {
            ag.b(context);
        }
    }

    public static void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    /* compiled from: PushClientManager.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private IPushActionListener f12107a;

        /* renamed from: b, reason: collision with root package name */
        private com.vivo.push.b.c f12108b;

        /* renamed from: c, reason: collision with root package name */
        private IPushActionListener f12109c;

        /* renamed from: d, reason: collision with root package name */
        private Runnable f12110d;

        /* renamed from: e, reason: collision with root package name */
        private Object[] f12111e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f12108b = cVar;
            this.f12107a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            this.f12111e = objArr;
            IPushActionListener iPushActionListener = this.f12109c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.f12107a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f12111e;
        }

        public final void a(Runnable runnable) {
            this.f12110d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f12110d;
            if (runnable == null) {
                com.vivo.push.util.u.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f12109c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f12101h == null) {
            this.f12101h = ContextDelegate.getContext(context);
            this.o = com.vivo.push.util.aa.c(context, context.getPackageName());
            ad.b().a(this.f12101h);
            a(new com.vivo.push.b.g());
            this.f12103j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f12103j)) {
            e();
        }
    }

    public static void a(List<String> list) throws JSONException {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String strG = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(string);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new RunnableC0342r(this, str));
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f12103j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f12098e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f12101h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f12098e = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    protected final void a(boolean z) {
        this.f12102i = z;
    }

    final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.f12095b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f12095b = SystemClock.elapsedRealtime();
        String packageName = this.f12101h.getPackageName();
        a aVarA = null;
        if (this.f12101h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.e();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (!this.o || l()) {
                aVarA = a(bVar, iPushActionListener);
            } else if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVarA == null) {
            return;
        }
        aVarA.a(new n(this, aVarA, str, str2));
        aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int i2 = Integer.parseInt(str);
                a aVar = this.f12104k.get(i2);
                this.f12104k.delete(i2);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f12100g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f12100g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_NO_FACE);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_ROI_ERR);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.f12101h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String strA = a(aVar);
        bVar.b(strA);
        aVar.a(new o(this, bVar, strA));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i2) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.f12096c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f12096c = SystemClock.elapsedRealtime();
            a aVarA = a(iPushActionListener, this.f12101h.getPackageName(), str, str2, i2);
            if (aVarA == null) {
                return;
            }
            aVarA.a(new p(this));
            aVarA.a();
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i2) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i2 > 0) {
            bVar.a(i2);
        }
        bVar.e();
        bVar.b(100);
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String strA = a(aVar);
            bVar.b(strA);
            aVar.a(new q(this, bVar, strA));
            return aVar;
        }
        if (bVar.a(this.f12101h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    public final void a(String str, int i2, Object... objArr) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i2, objArr);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyApp token is null");
        }
    }

    final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f12103j) && this.f12103j.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f12097d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f12101h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f12097d = SystemClock.elapsedRealtime();
        String strA = a(new a(aVar, iPushActionListener));
        aVar.b(strA);
        a(aVar);
        c(strA);
    }

    private static boolean a(long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || jElapsedRealtime <= j2 || jElapsedRealtime >= j2 + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.f12103j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i2) {
        a aVarB = b(str);
        if (aVarB != null) {
            aVarB.a(i2, new Object[0]);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.f12104k.put(this.f12105l, aVar);
        i2 = this.f12105l;
        this.f12105l = i2 + 1;
        return Integer.toString(i2);
    }

    final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f12101h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f12099f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f12099f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_NO_FACE);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_MINMAX_ERR);
                return;
            }
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_ROI_ERR);
                    return;
                }
                return;
            }
        }
        if (this.o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(FaceInterface.CW_FaceDETCode.CW_FACE_UNSUPPORT_FORMAT_ERR);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.f12101h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String strA = a(new a(zVar, iPushActionListener));
        zVar.b(strA);
        a(zVar);
        c(strA);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v vVarCreateReceiverCommand = this.p.createReceiverCommand(intent);
        Context context = a().f12101h;
        if (vVarCreateReceiverCommand == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.u.c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        com.vivo.push.f.aa aaVarCreateReceiveTask = this.p.createReceiveTask(vVarCreateReceiverCommand);
        if (aaVarCreateReceiveTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVarCreateReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.u.c(context, "[执行指令失败]指令" + vVarCreateReceiverCommand + "任务空！");
            return 2806;
        }
        if (context != null && !(vVarCreateReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[接收指令]".concat(String.valueOf(vVarCreateReceiverCommand)));
        }
        aaVarCreateReceiveTask.a(pushMessageCallback);
        aaVarCreateReceiveTask.run();
        return aaVarCreateReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().f12101h;
        if (vVar == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.u.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        s sVarCreateTask = this.p.createTask(vVar);
        if (sVarCreateTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.u.c(context, "[执行指令失败]指令" + vVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.u.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(sVarCreateTask);
    }
}
