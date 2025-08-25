package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.dz;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
class ea implements dz.a {

    /* renamed from: a, reason: collision with other field name */
    protected Context f420a;

    /* renamed from: a, reason: collision with other field name */
    private PendingIntent f419a = null;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f12727a = 0;

    public ea(Context context) {
        this.f420a = null;
        this.f420a = context;
    }

    public void a(Intent intent, long j2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AlarmManager alarmManager = (AlarmManager) this.f420a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (Build.VERSION.SDK_INT >= 31) {
            this.f419a = PendingIntent.getBroadcast(this.f420a, 0, intent, CommonNetImpl.FLAG_SHARE_JUMP);
        } else {
            this.f419a = PendingIntent.getBroadcast(this.f420a, 0, intent, 0);
        }
        if (Build.VERSION.SDK_INT >= 31 && !j.m627a(this.f420a)) {
            alarmManager.set(2, j2, this.f419a);
        } else if (Build.VERSION.SDK_INT >= 23) {
            aw.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j2), this.f419a);
        } else {
            a(alarmManager, j2, this.f419a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j2);
    }

    private void a(AlarmManager alarmManager, long j2, PendingIntent pendingIntent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j2), pendingIntent);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e2);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long jM723a = com.xiaomi.push.service.m.a(this.f420a).m723a();
        if (z || this.f12727a != 0) {
            if (z) {
                a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (z || this.f12727a == 0) {
                this.f12727a = jElapsedRealtime + (jM723a - (jElapsedRealtime % jM723a));
            } else if (this.f12727a <= jElapsedRealtime) {
                this.f12727a += jM723a;
                if (this.f12727a < jElapsedRealtime) {
                    this.f12727a = jElapsedRealtime + jM723a;
                }
            }
            Intent intent = new Intent(com.xiaomi.push.service.an.q);
            intent.setPackage(this.f420a.getPackageName());
            a(intent, this.f12727a);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a() {
        if (this.f419a != null) {
            try {
                ((AlarmManager) this.f420a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f419a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f419a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.f12727a = 0L;
                throw th;
            }
            this.f419a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.f12727a = 0L;
        }
        this.f12727a = 0L;
    }

    @Override // com.xiaomi.push.dz.a
    /* renamed from: a */
    public boolean mo372a() {
        return this.f12727a != 0;
    }
}
