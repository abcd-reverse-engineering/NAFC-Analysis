package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.connect.common.Constants;
import java.net.URISyntaxException;

/* compiled from: SelfShowType.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f7238c = {"url", Constants.JumpUrlConstants.SRC_TYPE_APP, "cosa", "rp"};

    /* renamed from: a, reason: collision with root package name */
    private Context f7239a;

    /* renamed from: b, reason: collision with root package name */
    private o f7240b;

    public u(Context context, o oVar) {
        this.f7239a = context;
        this.f7240b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : f7238c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd A[PHI: r2 r3
  0x00cd: PHI (r2v22 android.content.Intent) = (r2v16 android.content.Intent), (r2v25 android.content.Intent) binds: [B:10:0x008b, B:17:0x00cb] A[DONT_GENERATE, DONT_INLINE]
  0x00cd: PHI (r3v5 boolean) = (r3v3 boolean), (r3v1 boolean) binds: [B:10:0x008b, B:17:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() throws java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.u.b():void");
    }

    public void c() throws URISyntaxException {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f7239a == null || (oVar = this.f7240b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if (Constants.JumpUrlConstants.SRC_TYPE_APP.equals(oVar.h())) {
            a();
            return;
        }
        if ("cosa".equals(this.f7240b.h())) {
            b();
            return;
        }
        if ("rp".equals(this.f7240b.h())) {
            HMSLog.w("PushSelfShowLog", this.f7240b.h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.f7240b.h())) {
            HMSLog.w("PushSelfShowLog", this.f7240b.h() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.f7240b.h() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f7240b.c());
            if (e.c(this.f7239a, this.f7240b.c())) {
                b();
            }
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e2.toString());
        }
    }
}
