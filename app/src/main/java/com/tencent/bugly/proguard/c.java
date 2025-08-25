package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f9376a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, Object> f9377b = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f9380e = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected String f9378c = "GBK";

    /* renamed from: d, reason: collision with root package name */
    k f9379d = new k();

    c() {
    }

    public void a(String str) {
        this.f9378c = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f9378c);
        lVar.a(t, 0);
        byte[] bArrA = n.a(lVar.a());
        HashMap<String, byte[]> map = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        map.put(a.a(arrayList), bArrA);
        this.f9380e.remove(str);
        this.f9376a.put(str, map);
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add("?");
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.f9378c);
        lVar.a((Map) this.f9376a, 0);
        return n.a(lVar.a());
    }

    public void a(byte[] bArr) {
        this.f9379d.a(bArr);
        this.f9379d.a(this.f9378c);
        HashMap map = new HashMap(1);
        HashMap map2 = new HashMap(1);
        map2.put("", new byte[0]);
        map.put("", map2);
        this.f9376a = this.f9379d.a((Map) map, 0, false);
    }
}
