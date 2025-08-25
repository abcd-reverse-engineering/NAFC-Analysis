package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eg;
import com.xiaomi.push.eh;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, c> f13389a = new ConcurrentHashMap<>();

    public static class a extends XMPushService.j {
        public a() {
            super(17);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "RecordTimeManager clear";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo379a() {
            at.a().m704a();
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final at f13390a = new at();
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        long f13391a;

        /* renamed from: b, reason: collision with root package name */
        long f13392b;

        /* renamed from: c, reason: collision with root package name */
        long f13393c;

        /* renamed from: d, reason: collision with root package name */
        long f13394d;

        private c() {
        }

        public long a() {
            long j2 = this.f13393c;
            long j3 = this.f13392b;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }

        public long b() {
            long j2 = this.f13394d;
            long j3 = this.f13393c;
            if (j2 > j3) {
                return j2 - j3;
            }
            return 0L;
        }
    }

    public static at a() {
        return b.f13390a;
    }

    public void b(String str, long j2) {
        c cVarRemove = this.f13389a.remove(str);
        if (cVarRemove != null) {
            cVarRemove.f13394d = j2;
            a(str, cVarRemove);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m704a() {
        if (this.f13389a.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, c>> it = this.f13389a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (next == null || next.getValue() == null) {
                it.remove();
            } else {
                c value = next.getValue();
                if (Math.abs(SystemClock.elapsedRealtime() - value.f13392b) > com.heytap.mcssdk.constant.a.q) {
                    a(next.getKey(), value);
                    it.remove();
                }
            }
        }
    }

    public void a(String str, long j2, long j3) {
        c cVar = new c();
        cVar.f13391a = j3;
        cVar.f13392b = j2;
        this.f13389a.put(str, cVar);
    }

    public void a(String str, long j2) {
        c cVar = this.f13389a.get(str);
        if (cVar != null) {
            cVar.f13393c = j2;
        }
    }

    private void a(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("xmsfVC", Long.valueOf(cVar.f13391a));
        map.put("packetId", str);
        map.put("pTime", Long.valueOf(cVar.a()));
        map.put("bTime", Long.valueOf(cVar.b()));
        eh.a().a(new eg("msg_process_time", map));
    }
}
