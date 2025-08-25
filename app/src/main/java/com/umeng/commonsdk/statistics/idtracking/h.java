package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.config.FieldManager;

/* compiled from: OaidTracking.java */
/* loaded from: classes2.dex */
public class h extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10946a = at.b().b(at.f10078l);

    /* renamed from: b, reason: collision with root package name */
    public static final String f10947b = "key_umeng_sp_oaid";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10948c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10949d = "oaid";

    /* renamed from: e, reason: collision with root package name */
    private Context f10950e;

    public h(Context context) {
        super(f10949d);
        this.f10950e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f10950e.getSharedPreferences(f10946a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f10947b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
