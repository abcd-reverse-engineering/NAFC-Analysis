package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* loaded from: classes2.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    int f12383a = 0;

    /* renamed from: a, reason: collision with other field name */
    String f125a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return !TextUtils.isEmpty(nVar.f125a) && nVar.f125a.equals(this.f125a);
    }
}
