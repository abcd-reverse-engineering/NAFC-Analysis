package cn.jzvd;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* compiled from: JZDataSource.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: g, reason: collision with root package name */
    public static final String f3243g = "URL_KEY_DEFAULT";

    /* renamed from: a, reason: collision with root package name */
    public int f3244a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap f3245b;

    /* renamed from: c, reason: collision with root package name */
    public String f3246c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, String> f3247d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3248e;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f3249f;

    public v(String str) {
        this.f3245b = new LinkedHashMap();
        this.f3246c = "";
        this.f3247d = new HashMap<>();
        this.f3248e = false;
        this.f3245b.put(f3243g, str);
        this.f3244a = 0;
    }

    public String a(int i2) {
        int i3 = 0;
        for (Object obj : this.f3245b.keySet()) {
            if (i3 == i2) {
                return obj.toString();
            }
            i3++;
        }
        return null;
    }

    public Object b() {
        return a(this.f3244a);
    }

    public Object c() {
        return b(this.f3244a);
    }

    public Object b(int i2) {
        int i3 = 0;
        for (Object obj : this.f3245b.keySet()) {
            if (i3 == i2) {
                return this.f3245b.get(obj);
            }
            i3++;
        }
        return null;
    }

    public boolean a(Object obj) {
        if (obj != null) {
            return this.f3245b.containsValue(obj);
        }
        return false;
    }

    public v a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.f3245b);
        return new v(linkedHashMap, this.f3246c);
    }

    public v(String str, String str2) {
        this.f3245b = new LinkedHashMap();
        this.f3246c = "";
        this.f3247d = new HashMap<>();
        this.f3248e = false;
        this.f3245b.put(f3243g, str);
        this.f3246c = str2;
        this.f3244a = 0;
    }

    public v(Object obj) {
        this.f3245b = new LinkedHashMap();
        this.f3246c = "";
        this.f3247d = new HashMap<>();
        this.f3248e = false;
        this.f3245b.put(f3243g, obj);
        this.f3244a = 0;
    }

    public v(LinkedHashMap linkedHashMap) {
        this.f3245b = new LinkedHashMap();
        this.f3246c = "";
        this.f3247d = new HashMap<>();
        this.f3248e = false;
        this.f3245b.clear();
        this.f3245b.putAll(linkedHashMap);
        this.f3244a = 0;
    }

    public v(LinkedHashMap linkedHashMap, String str) {
        this.f3245b = new LinkedHashMap();
        this.f3246c = "";
        this.f3247d = new HashMap<>();
        this.f3248e = false;
        this.f3245b.clear();
        this.f3245b.putAll(linkedHashMap);
        this.f3246c = str;
        this.f3244a = 0;
    }
}
