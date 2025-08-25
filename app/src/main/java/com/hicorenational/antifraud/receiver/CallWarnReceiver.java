package com.hicorenational.antifraud.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.hicorenational.antifraud.service.CallIntercepeService;
import ui.Hicore;
import util.v1;
import util.y1;

/* loaded from: classes.dex */
public class CallWarnReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private Context f5949a = Hicore.getApp();

    public CallWarnReceiver() {
        y1.a(this.f5949a);
    }

    public void a() {
        try {
            Intent intent = new Intent(this.f5949a, (Class<?>) CallIntercepeService.class);
            if (!v1.b(this.f5949a, CallIntercepeService.class.getName())) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f5949a.startForegroundService(intent);
                } else {
                    this.f5949a.startService(intent);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            return;
        }
        a();
    }
}
