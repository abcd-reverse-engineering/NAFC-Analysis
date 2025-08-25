package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f9797a;

    public c(Bundle bundle) {
        this.f9797a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f9797a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f9797a.get("time") + ", name=" + this.f9797a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> map) {
        this.f9797a = new HashMap<>(map);
    }
}
