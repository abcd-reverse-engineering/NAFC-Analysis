package a.a.r;

import anet.channel.util.StringUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class d implements a.a.r.a {

    /* renamed from: b, reason: collision with root package name */
    private static final int f1177b = 100;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1178c = "{\"oneWayTime\" : 0, \"totalSize\" : 0}";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f1179a;

    /* compiled from: Taobao */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static d f1180a = new d(null);

        private a() {
        }
    }

    /* synthetic */ d(c cVar) {
        this();
    }

    public static d a() {
        return a.f1180a;
    }

    @Override // a.a.r.a
    public String get(String str) {
        return this.f1179a.get(str);
    }

    private d() {
        this.f1179a = Collections.synchronizedMap(new c(this));
    }

    @Override // a.a.r.a
    public void a(String str, a.a.s.a aVar) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(aVar.oneWayTime_ANet);
        sb.append(", \"totalSize\" : ");
        sb.append(aVar.totalSize);
        sb.append("}");
        this.f1179a.put(str, sb.toString());
    }

    @Override // a.a.r.a
    public void a(String str) {
        if (this.f1179a.containsKey(str)) {
            this.f1179a.put(str, f1178c);
        }
    }
}
