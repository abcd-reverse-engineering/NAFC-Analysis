package util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import java.util.Calendar;
import receiver.AlarmReceiver;

/* compiled from: AlarmUtil.java */
/* loaded from: classes2.dex */
public class v0 {
    private void c(Context context, int i2) {
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setExact(0, a(i2), PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AlarmReceiver.class), 0));
    }

    public void a(Context context, int i2) {
        if (a()) {
            c(context, i2);
        }
    }

    public void b(Context context, int i2) {
        b();
        a();
        c(context, i2);
    }

    private boolean a() {
        long jA = u1.a(u1.J0, 0L);
        long jA2 = u1.a(u1.K0, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() - jA;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - jA2;
        if (jA != 0 && jA2 != 0 && Math.abs(jCurrentTimeMillis - jElapsedRealtime) <= 500) {
            return false;
        }
        u1.b(u1.J0, System.currentTimeMillis());
        u1.b(u1.K0, SystemClock.elapsedRealtime());
        return true;
    }

    private void b() {
        u1.b(u1.J0, 0L);
        u1.b(u1.K0, 0L);
    }

    private void c(Calendar calendar) {
        calendar.set(2, calendar.get(2) + 1);
        calendar.set(5, 1);
    }

    private void b(Calendar calendar) {
        int i2 = calendar.get(7);
        calendar.add(5, i2 != 1 ? 9 - i2 : 1);
    }

    private long a(int i2) {
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        if (i2 == 1) {
            calendar = Calendar.getInstance();
            if (i4 >= 9) {
                calendar.set(5, i3 + 1);
            }
        } else if (i2 != 2) {
            if (i2 == 3 && (i3 != 1 || i4 >= 9)) {
                c(calendar);
            }
        } else if (calendar.get(7) != 2 || i4 >= 9) {
            b(calendar);
        }
        return a(calendar);
    }

    private long a(Calendar calendar) {
        calendar.set(11, 9);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println("每天9点" + timeInMillis);
        calendar.clear();
        return timeInMillis;
    }
}
