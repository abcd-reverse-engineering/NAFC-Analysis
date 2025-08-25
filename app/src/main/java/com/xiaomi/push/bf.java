package com.xiaomi.push;

import org.json.JSONArray;

/* loaded from: classes2.dex */
public class bf extends JSONArray implements be {

    /* renamed from: a, reason: collision with root package name */
    private int f12496a = 2;

    @Override // com.xiaomi.push.be
    public int a() {
        return this.f12496a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof be) {
            this.f12496a += ((be) obj).a();
        }
        return super.put(obj);
    }
}
