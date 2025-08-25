package com.vivo.push.restructure.a.a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.util.u;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AbstractMessageNodeMonitor.java */
/* loaded from: classes2.dex */
abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected T f12141a;

    /* renamed from: b, reason: collision with root package name */
    private String f12142b;

    /* renamed from: e, reason: collision with root package name */
    private i f12145e;

    /* renamed from: g, reason: collision with root package name */
    private a f12147g;

    /* renamed from: c, reason: collision with root package name */
    private long f12143c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f12144d = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12146f = false;

    public a(String str, T t, i iVar) {
        this.f12142b = str;
        this.f12141a = t;
        this.f12145e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f12144d = a((a<T>) this.f12141a);
        this.f12143c = System.currentTimeMillis() - jCurrentTimeMillis;
        int i2 = this.f12144d;
        if (i2 != 0) {
            i iVar = this.f12145e;
            if (iVar != null) {
                iVar.a(this, this.f12141a, i2);
                return;
            }
            return;
        }
        a aVar = this.f12147g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.f12145e;
        if (iVar2 != null) {
            iVar2.a((i) this.f12141a);
        }
    }

    protected abstract int a(T t);

    public final void a(a aVar) {
        if (this != aVar) {
            this.f12147g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.f12147g) {
            try {
                jSONArray.put(aVar.b());
            } catch (Exception e2) {
                u.a("AbstractMessageNodeMoni", e2);
            }
        }
        return jSONArray;
    }

    public final void a(long j2) {
        this.f12143c = j2;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.NAME, this.f12142b);
            jSONObject.put("code", this.f12144d);
            jSONObject.put("cost", this.f12143c);
        } catch (Exception e2) {
            u.a("AbstractMessageNodeMoni", e2);
        }
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f12146f) {
            com.vivo.push.util.g.a().execute(new b(this));
        } else {
            d();
        }
    }
}
