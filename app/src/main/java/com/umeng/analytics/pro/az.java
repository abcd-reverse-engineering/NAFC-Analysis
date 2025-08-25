package com.umeng.analytics.pro;

import android.content.Context;
import i.e.b.e.b.b;

/* compiled from: LenovoDeviceIdSupplier.java */
/* loaded from: classes2.dex */
public class az implements au {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10100a = 1;

    /* renamed from: b, reason: collision with root package name */
    private i.e.b.e.b.b f10101b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10102c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10103d = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f10102c) {
            this.f10101b = new i.e.b.e.b.b();
            this.f10103d = this.f10101b.a(context, (b.InterfaceC0262b<String>) null) == 1;
            this.f10102c = true;
        }
        bg.a("getOAID", "isSupported", Boolean.valueOf(this.f10103d));
        if (this.f10103d && this.f10101b.c()) {
            return this.f10101b.a();
        }
        return null;
    }
}
