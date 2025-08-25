package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f6929a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, d> f6930b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private List<b> f6931c = new ArrayList(16);

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f6930b.get(str);
        }
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public List<b> a() {
        return this.f6931c;
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        this.f6930b.put(str, dVar);
    }

    public void a(List<b> list) {
        this.f6931c = list;
    }

    public String b() {
        return this.f6929a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.f6929a = str;
    }
}
