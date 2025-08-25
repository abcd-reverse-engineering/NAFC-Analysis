package com.umeng.analytics.pro;

import android.content.Context;

/* compiled from: MeizuDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class ba implements au {
    ba() {
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) throws NoSuchMethodException, SecurityException {
        if (context == null) {
            return null;
        }
        boolean zA = i.e.b.b.a.a.b.a();
        bg.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return i.e.b.b.a.a.b.b(context);
        }
        return null;
    }
}
