package service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import b.a.a.g.d;
import manager.NotificationHelper;
import util.a2;

/* loaded from: classes2.dex */
public class AlarmService extends IntentService {
    public AlarmService() {
        super("UploadService");
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        d.b("本服务执行的业务->APP自查");
        new a2(this, a2.f20716f);
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("my_channel_virus", NotificationHelper.CHANEL_NAME, 4));
            startForeground(2, new Notification.Builder(getApplicationContext(), "my_channel_virus").build());
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
