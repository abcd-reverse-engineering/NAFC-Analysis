package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private PendingIntent f8518c;

    /* renamed from: d, reason: collision with root package name */
    private AlarmManager f8519d;

    e(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    protected void a(int i2) {
        if (GlobalConfig.isAlarmHeartbeatEnable()) {
            if (this.f8519d == null) {
                this.f8519d = (AlarmManager) this.f8523a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
            if (this.f8519d == null) {
                ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
                return;
            }
            if (this.f8518c == null) {
                Intent intent = new Intent();
                intent.setPackage(this.f8523a.getPackageName());
                intent.addFlags(32);
                intent.setAction(Constants.ACTION_COMMAND);
                intent.putExtra("command", 201);
                this.f8518c = PendingIntent.getBroadcast(this.f8523a, 0, intent, Build.VERSION.SDK_INT >= 23 ? c.c.a.b.a.a.B1 : 0);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.add(13, i2);
            this.f8519d.set(0, calendar.getTimeInMillis(), this.f8518c);
        }
    }
}
