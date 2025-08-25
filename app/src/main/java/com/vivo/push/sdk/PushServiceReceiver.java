package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.m;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.u;
import com.vivo.push.util.x;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f12210a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f12211b;

    /* renamed from: c, reason: collision with root package name */
    private static a f12212c = new a();

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f12213a;

        /* renamed from: b, reason: collision with root package name */
        private String f12214b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f12213a = ContextDelegate.getContext(context);
            aVar.f12214b = str;
        }

        @Override // java.lang.Runnable
        public final void run() throws PackageManager.NameNotFoundException {
            NetworkInfo networkInfoA = x.a(this.f12213a);
            if (!(networkInfoA != null ? networkInfoA.isConnectedOrConnecting() : false)) {
                u.d("PushServiceReceiver", this.f12213a.getPackageName() + ": 无网络  by " + this.f12214b);
                u.a(this.f12213a, "触发静态广播:无网络(" + this.f12214b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f12213a.getPackageName() + ")");
                return;
            }
            u.d("PushServiceReceiver", this.f12213a.getPackageName() + ": 执行开始出发动作: " + this.f12214b);
            u.a(this.f12213a, "触发静态广播(" + this.f12214b + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f12213a.getPackageName() + ")");
            m.a().a(this.f12213a);
            if (ClientConfigManagerImpl.getInstance(this.f12213a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f12213a).initialize(com.vivo.push.restructure.a.a().e().l());
            } catch (VivoPushException e2) {
                e2.printStackTrace();
                u.a(this.f12213a, " 初始化异常 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f12210a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f12210a = handlerThread;
                handlerThread.start();
                f12211b = new Handler(f12210a.getLooper());
            }
            u.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f12211b);
            a.a(f12212c, context2, action);
            f12211b.removeCallbacks(f12212c);
            f12211b.postDelayed(f12212c, 2000L);
        }
    }
}
