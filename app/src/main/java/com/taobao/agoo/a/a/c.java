package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";

    /* renamed from: a, reason: collision with root package name */
    public String f8713a;

    /* renamed from: b, reason: collision with root package name */
    public String f8714b;

    /* renamed from: c, reason: collision with root package name */
    public String f8715c;

    /* renamed from: d, reason: collision with root package name */
    public String f8716d = String.valueOf(221);

    /* renamed from: f, reason: collision with root package name */
    public String f8717f;

    /* renamed from: g, reason: collision with root package name */
    public String f8718g;

    /* renamed from: h, reason: collision with root package name */
    public String f8719h;

    /* renamed from: i, reason: collision with root package name */
    public String f8720i;

    /* renamed from: j, reason: collision with root package name */
    public String f8721j;

    /* renamed from: k, reason: collision with root package name */
    public String f8722k;

    /* renamed from: l, reason: collision with root package name */
    public String f8723l;

    /* renamed from: m, reason: collision with root package name */
    public String f8724m;
    public String n;
    public String o;
    public String p;

    public byte[] a() {
        try {
            String string = new p.a().a(b.JSON_CMD, this.f8712e).a("appKey", this.f8713a).a("utdid", this.f8714b).a("appVersion", this.f8715c).a("sdkVersion", this.f8716d).a(Constants.KEY_TTID, this.f8717f).a(Constants.KEY_PACKAGE_NAME, this.f8718g).a("notifyEnable", this.f8719h).a("romInfo", this.f8720i).a("c0", this.f8721j).a("c1", this.f8722k).a("c2", this.f8723l).a("c3", this.f8724m).a("c4", this.n).a("c5", this.o).a("c6", this.p).a().toString();
            ALog.i("RegisterDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String strJ;
        String packageName;
        String str3;
        try {
            strJ = UtilityImpl.j(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strJ) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.f8712e = "register";
                cVar.f8713a = str;
                cVar.f8714b = strJ;
                cVar.f8715c = str3;
                cVar.f8717f = str2;
                cVar.f8718g = packageName;
                cVar.f8721j = Build.BRAND;
                cVar.f8722k = Build.MODEL;
                cVar.f8719h = j.c(context);
                UtilityImpl.a(context, Constants.SP_CHANNEL_FILE_NAME, cVar.f8719h);
                cVar.f8720i = new o().a();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                    return cVar.a();
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", "appKey", str, "utdid", strJ, "appVersion", str3);
        return null;
    }
}
