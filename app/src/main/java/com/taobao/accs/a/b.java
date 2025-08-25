package com.taobao.accs.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f8377a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f8378b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f8379c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f8380d;

    b(Intent intent, Context context, Context context2, int i2) {
        this.f8377a = intent;
        this.f8378b = context;
        this.f8379c = context2;
        this.f8380d = i2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d(a.TAG, "bindService connected", "componentName", componentName.toString());
        try {
            Messenger messenger = new Messenger(iBinder);
            Message message = new Message();
            message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.f8377a);
            messenger.send(message);
            try {
                this.f8378b.unbindService(this);
            } catch (Throwable unused) {
            }
            if (!this.f8379c.getPackageName().equals(componentName.getPackageName())) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e(a.TAG, "dispatch intent with exception", th, new Object[0]);
                try {
                    this.f8378b.unbindService(this);
                } catch (Throwable unused2) {
                }
                if (!this.f8379c.getPackageName().equals(componentName.getPackageName())) {
                    return;
                }
            } finally {
            }
        }
        k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d(a.TAG, "bindService on disconnect", "componentName", componentName.toString());
        try {
            this.f8378b.unbindService(this);
        } catch (Throwable unused) {
        }
        if (this.f8379c.getPackageName().equals(componentName.getPackageName())) {
            k.a("accs", BaseMonitor.ALARM_POINT_BIND, componentName.getClassName(), UtilityImpl.a(this.f8380d - 3), "onServiceDisconnected");
        }
    }
}
