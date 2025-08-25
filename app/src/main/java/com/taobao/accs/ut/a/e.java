package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f8604a;

    /* renamed from: b, reason: collision with root package name */
    public String f8605b;

    /* renamed from: c, reason: collision with root package name */
    public String f8606c;

    /* renamed from: d, reason: collision with root package name */
    public String f8607d;

    /* renamed from: e, reason: collision with root package name */
    public String f8608e;

    /* renamed from: f, reason: collision with root package name */
    public String f8609f;

    /* renamed from: g, reason: collision with root package name */
    private final String f8610g = "sendAck";

    /* renamed from: h, reason: collision with root package name */
    private boolean f8611h = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f8611h) {
            return;
        }
        this.f8611h = true;
        HashMap map = new HashMap();
        try {
            str = this.f8604a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.f8604a);
            map.put("session_id", this.f8605b);
            map.put("data_id", this.f8606c);
            map.put("ack_date", this.f8607d);
            map.put("service_id", this.f8608e);
            map.put("fail_reasons", this.f8609f);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
        }
    }
}
