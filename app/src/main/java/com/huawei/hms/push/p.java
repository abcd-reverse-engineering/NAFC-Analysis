package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import java.net.URISyntaxException;

/* compiled from: PushSelfShowThread.java */
/* loaded from: classes.dex */
public class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f7223a;

    /* renamed from: b, reason: collision with root package name */
    private o f7224b;

    public p(Context context, o oVar) {
        this.f7223a = context;
        this.f7224b = oVar;
    }

    private static Intent a(Context context, o oVar) throws URISyntaxException {
        if (oVar == null) {
            return null;
        }
        Intent intentB = e.b(context, oVar.c());
        if (oVar.m() == null) {
            if (oVar.a() != null) {
                Intent intent = new Intent(oVar.a());
                if (e.a(context, oVar.c(), intent).booleanValue()) {
                    intentB = intent;
                }
            }
            intentB.setPackage(oVar.c());
            return intentB;
        }
        try {
            Intent uri = Intent.parseUri(oVar.m(), 0);
            uri.setSelector(null);
            if (uri.getClipData() == null) {
                uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
            }
            HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
            return e.a(context, oVar.c(), uri).booleanValue() ? uri : intentB;
        } catch (Exception e2) {
            HMSLog.w("PushSelfShowLog", "intentUri error," + e2.toString());
            return intentB;
        }
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.f7224b.h())) {
            return a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.f7223a) || b(this.f7223a, this.f7224b)) {
                return;
            }
            n.a(this.f7223a, this.f7224b);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", e2.toString());
        }
    }

    private boolean b(Context context, o oVar) {
        if (!"cosa".equals(oVar.h()) || a(context, oVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return e.c(context, this.f7224b.c());
    }
}
