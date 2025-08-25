package anetwork.channel.entity;

import android.text.TextUtils;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c implements a.a.h {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private URI f2187a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private URL f2188b;

    /* renamed from: c, reason: collision with root package name */
    private String f2189c;

    /* renamed from: e, reason: collision with root package name */
    private List<a.a.a> f2191e;

    /* renamed from: g, reason: collision with root package name */
    private List<a.a.g> f2193g;

    /* renamed from: k, reason: collision with root package name */
    private int f2197k;

    /* renamed from: l, reason: collision with root package name */
    private int f2198l;

    /* renamed from: m, reason: collision with root package name */
    private String f2199m;
    private String n;
    private Map<String, String> o;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2190d = true;

    /* renamed from: f, reason: collision with root package name */
    private String f2192f = "GET";

    /* renamed from: h, reason: collision with root package name */
    private int f2194h = 2;

    /* renamed from: i, reason: collision with root package name */
    private String f2195i = "utf-8";

    /* renamed from: j, reason: collision with root package name */
    private BodyEntry f2196j = null;

    public c() {
    }

    @Override // a.a.h
    @Deprecated
    public void a(URI uri) {
        this.f2187a = uri;
    }

    @Override // a.a.h
    public String b() {
        return this.f2189c;
    }

    @Override // a.a.h
    @Deprecated
    public a.a.b c() {
        return null;
    }

    @Override // a.a.h
    public a.a.a[] c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f2191e == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f2191e.size(); i2++) {
            if (this.f2191e.get(i2) != null && this.f2191e.get(i2).getName() != null && this.f2191e.get(i2).getName().equalsIgnoreCase(str)) {
                arrayList.add(this.f2191e.get(i2));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        a.a.a[] aVarArr = new a.a.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    @Override // a.a.h
    public void d(int i2) {
        this.f2194h = i2;
    }

    @Override // a.a.h
    public void e(String str) {
        this.f2192f = str;
    }

    @Override // a.a.h
    public String f() {
        return this.f2192f;
    }

    @Override // a.a.h
    public String g() {
        return this.f2195i;
    }

    @Override // a.a.h
    public int getConnectTimeout() {
        return this.f2197k;
    }

    @Override // a.a.h
    public List<a.a.g> getParams() {
        return this.f2193g;
    }

    @Override // a.a.h
    public int getReadTimeout() {
        return this.f2198l;
    }

    @Override // a.a.h
    public boolean h() {
        return this.f2190d;
    }

    @Override // a.a.h
    public BodyEntry i() {
        return this.f2196j;
    }

    @Override // a.a.h
    @Deprecated
    public URL j() {
        URL url = this.f2188b;
        if (url != null) {
            return url;
        }
        String str = this.f2189c;
        if (str != null) {
            try {
                this.f2188b = new URL(str);
            } catch (Exception e2) {
                ALog.e("anet.RequestImpl", "url error", this.n, e2, new Object[0]);
            }
        }
        return this.f2188b;
    }

    @Override // a.a.h
    public int k() {
        return this.f2194h;
    }

    @Override // a.a.h
    public String l() {
        return this.n;
    }

    @Override // a.a.h
    @Deprecated
    public URI m() {
        URI uri = this.f2187a;
        if (uri != null) {
            return uri;
        }
        String str = this.f2189c;
        if (str != null) {
            try {
                this.f2187a = new URI(str);
            } catch (Exception e2) {
                ALog.e("anet.RequestImpl", "uri error", this.n, e2, new Object[0]);
            }
        }
        return this.f2187a;
    }

    @Override // a.a.h
    public String n() {
        return this.f2199m;
    }

    @Deprecated
    public void a(URL url) {
        this.f2188b = url;
        this.f2189c = url.toString();
    }

    @Override // a.a.h
    public void b(boolean z) {
        this.f2190d = z;
    }

    @Override // a.a.h
    public void d(String str) {
        this.f2199m = str;
    }

    @Override // a.a.h
    @Deprecated
    public boolean e() {
        return !a.a.u.a.f1254k.equals(f(a.a.u.a.f1247d));
    }

    @Override // a.a.h
    public String f(String str) {
        Map<String, String> map = this.o;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // a.a.h
    public void b(List<a.a.a> list) {
        this.f2191e = list;
    }

    @Override // a.a.h
    public Map<String, String> d() {
        return this.o;
    }

    @Override // a.a.h
    public List<a.a.a> a() {
        return this.f2191e;
    }

    @Override // a.a.h
    public void b(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (this.f2191e == null) {
            this.f2191e = new ArrayList();
        }
        this.f2191e.add(new a(str, str2));
    }

    @Override // a.a.h
    public void a(a.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f2191e == null) {
            this.f2191e = new ArrayList();
        }
        int i2 = 0;
        int size = this.f2191e.size();
        while (true) {
            if (i2 >= size) {
                break;
            }
            if (aVar.getName().equalsIgnoreCase(this.f2191e.get(i2).getName())) {
                this.f2191e.set(i2, aVar);
                break;
            }
            i2++;
        }
        if (i2 < this.f2191e.size()) {
            this.f2191e.add(aVar);
        }
    }

    @Deprecated
    public c(URI uri) {
        this.f2187a = uri;
        this.f2189c = uri.toString();
    }

    @Override // a.a.h
    public void b(a.a.a aVar) {
        List<a.a.a> list = this.f2191e;
        if (list != null) {
            list.remove(aVar);
        }
    }

    @Override // a.a.h
    public void c(int i2) {
        this.f2198l = i2;
    }

    @Override // a.a.h
    public void b(String str) {
        this.f2195i = str;
    }

    @Override // a.a.h
    @Deprecated
    public void b(int i2) {
        this.f2199m = String.valueOf(i2);
    }

    @Override // a.a.h
    public void a(List<a.a.g> list) {
        this.f2193g = list;
    }

    @Override // a.a.h
    public void a(BodyEntry bodyEntry) {
        this.f2196j = bodyEntry;
    }

    @Deprecated
    public c(URL url) {
        this.f2188b = url;
        this.f2189c = url.toString();
    }

    @Override // a.a.h
    public void a(a.a.b bVar) {
        this.f2196j = new BodyHandlerEntry(bVar);
    }

    @Override // a.a.h
    public void a(int i2) {
        this.f2197k = i2;
    }

    @Override // a.a.h
    public void a(String str) {
        this.n = str;
    }

    @Override // a.a.h
    @Deprecated
    public void a(boolean z) {
        a(a.a.u.a.f1247d, z ? a.a.u.a.f1253j : a.a.u.a.f1254k);
    }

    @Override // a.a.h
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.o == null) {
            this.o = new HashMap();
        }
        this.o.put(str, str2);
    }

    public c(String str) {
        this.f2189c = str;
    }
}
