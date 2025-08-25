package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bz;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IdTracker.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final long f10930a = 86400000;

    /* renamed from: b, reason: collision with root package name */
    public static e f10931b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f10932c = at.b().b("id");

    /* renamed from: j, reason: collision with root package name */
    private static Object f10933j = new Object();

    /* renamed from: d, reason: collision with root package name */
    private File f10934d;

    /* renamed from: f, reason: collision with root package name */
    private long f10936f;

    /* renamed from: i, reason: collision with root package name */
    private a f10939i;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f10935e = null;

    /* renamed from: h, reason: collision with root package name */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f10938h = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private long f10937g = 86400000;

    /* compiled from: IdTracker.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f10940a;

        /* renamed from: b, reason: collision with root package name */
        private Set<String> f10941b = new HashSet();

        public a(Context context) {
            this.f10940a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f10941b.contains(str);
        }

        public synchronized void b(String str) {
            this.f10941b.add(str);
        }

        public void c(String str) {
            this.f10941b.remove(str);
        }

        public synchronized void a() {
            if (!this.f10941b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f10941b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f10940a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.f10940a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f10941b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.f10939i = null;
        this.f10934d = new File(context.getFilesDir(), f10932c);
        this.f10939i = new a(context);
        this.f10939i.b();
    }

    public static synchronized void a() {
        if (f10931b != null) {
            f10931b.e();
            f10931b = null;
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f10938h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.f10935e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f10933j) {
            if (!this.f10934d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f10934d);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new bt().a(cVar, streamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f10936f >= this.f10937g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f10938h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.f10939i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.f10939i.a();
                g();
            }
            this.f10936f = jCurrentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f10935e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f10931b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f10938h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f10935e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c cVarI = i();
        if (cVarI == null) {
            return;
        }
        a(cVarI);
        ArrayList arrayList = new ArrayList(this.f10938h.size());
        synchronized (this) {
            this.f10935e = cVarI;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f10938h) {
                aVar.a(this.f10935e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f10938h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        if (this.f10935e != null) {
            b(this.f10935e);
        }
    }

    public static synchronized e a(Context context) {
        if (f10931b == null) {
            f10931b = new e(context);
            f10931b.a(new f(context));
            f10931b.a(new b(context));
            f10931b.a(new j(context));
            f10931b.a(new d(context));
            f10931b.a(new c(context));
            f10931b.a(new g(context));
            f10931b.a(new i());
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                f10931b.a(new h(context));
            }
            f10931b.f();
        }
        return f10931b;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (f10933j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new bz().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.f10934d, bArrA);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f10939i.a(aVar.b())) {
            return this.f10938h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.f10937g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f11024a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11104h)) {
            cVar.f11024a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (cVar.f11024a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11103g)) {
            cVar.f11024a.remove("imei");
        }
        if (cVar.f11024a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11105i)) {
            cVar.f11024a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (cVar.f11024a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f11106j)) {
            cVar.f11024a.remove("serial");
        }
        if (cVar.f11024a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.f11024a.remove("idfa");
        }
        if (!cVar.f11024a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f11024a.remove("oaid");
    }
}
