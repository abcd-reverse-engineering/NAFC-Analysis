package com.taobao.accs;

import android.app.Notification;
import com.taobao.accs.ChannelService;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChannelService.KernelService f8376a;

    a(ChannelService.KernelService kernelService) {
        this.f8376a = kernelService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ChannelService channelService = ChannelService.getInstance();
            int i2 = this.f8376a.f8375b.getPackageManager().getPackageInfo(this.f8376a.getPackageName(), 0).applicationInfo.icon;
            if (i2 != 0) {
                Notification.Builder builder = new Notification.Builder(this.f8376a.f8375b);
                builder.setSmallIcon(i2);
                builder.setContentText("正在运行…");
                channelService.startForeground(9371, builder.build());
                Notification.Builder builder2 = new Notification.Builder(this.f8376a.f8375b);
                builder2.setSmallIcon(i2);
                builder2.setContentText("正在运行…");
                ChannelService.KernelService.f8374a.startForeground(9371, builder2.build());
                ChannelService.KernelService.f8374a.stopForeground(true);
            }
            ChannelService.KernelService.f8374a.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
