package util.d2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Parameters.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<Integer, Object>> f20798a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f20799b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f20800c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f20801d = 0;

    public void a(String str, Object obj) throws IllegalStateException {
        if (str == null) {
            return;
        }
        if (!a(obj)) {
            throw new IllegalArgumentException("Please use value which is primitive type like: String,Integer,Long and so on. But not Collection !");
        }
        this.f20800c++;
        int i2 = this.f20799b;
        if (i2 > -1 && this.f20800c > i2) {
            throw new IllegalStateException("parameters.maxCountFail: " + this.f20799b);
        }
        Map<Integer, Object> linkedHashMap = this.f20798a.get(str);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>(1);
            this.f20798a.put(str, linkedHashMap);
        }
        int i3 = this.f20801d;
        this.f20801d = i3 + 1;
        Integer numValueOf = Integer.valueOf(i3);
        if (obj == null) {
            obj = "";
        }
        linkedHashMap.put(numValueOf, obj);
    }

    public String b(String str) {
        Map<Integer, Object> map = this.f20798a.get(str);
        if (map == null || map.size() == 0) {
            return "";
        }
        String string = map.values().iterator().next().toString();
        return (string == null || c.c.a.b.a.a.f3101h.equals(string)) ? "" : string;
    }

    public boolean c() {
        return this.f20798a.isEmpty();
    }

    public Set<String> b() {
        return this.f20798a.keySet();
    }

    private boolean a(Object obj) {
        return obj == null || (obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short);
    }

    public String[] a(String str) {
        Map<Integer, Object> map = this.f20798a.get(str);
        if (map == null) {
            return null;
        }
        return (String[]) map.values().toArray(new String[map.size()]);
    }

    public int a() {
        return this.f20799b;
    }

    public void a(int i2) {
        this.f20799b = i2;
    }
}
