package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class m implements ConfigReader {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f6413a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final k f6414b;

    m(Context context, String str) {
        this.f6414b = new k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.f6413a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strA = this.f6414b.a(str, str2);
        if (strA == null) {
            return str2;
        }
        this.f6413a.put(str, strA);
        return strA;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
