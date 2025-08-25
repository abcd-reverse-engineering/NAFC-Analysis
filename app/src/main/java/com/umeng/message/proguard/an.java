package com.umeng.message.proguard;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.common.UPLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class an extends c {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f11288b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private final ac f11289c;

    /* renamed from: d, reason: collision with root package name */
    private long f11290d;

    public an(ac acVar) {
        this.f11289c = acVar;
    }

    private StatusBarNotification a(NotificationManager notificationManager) {
        ac acVar = this.f11289c;
        if (acVar == null || acVar.f11223b == null || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications != null && activeNotifications.length != 0) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (TextUtils.equals(statusBarNotification.getTag(), "um") && statusBarNotification.getId() == this.f11289c.f11222a) {
                        return statusBarNotification;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            UPLog.e("RePop", th);
            return null;
        }
    }

    @Override // com.umeng.message.proguard.c
    public final Future<?> b() {
        if (d()) {
            return this.f11339a;
        }
        ac acVar = this.f11289c;
        if (acVar == null) {
            return this.f11339a;
        }
        if (acVar.f11223b == null) {
            return this.f11339a;
        }
        boolean z = false;
        long j2 = this.f11290d;
        if (j2 == 0) {
            this.f11290d = System.currentTimeMillis();
            z = true;
        } else if (!f.a(j2)) {
            return this.f11339a;
        }
        Application applicationA = x.a();
        if (MessageSharedPrefs.getInstance(applicationA).o() >= MessageSharedPrefs.getInstance(applicationA).n()) {
            return this.f11339a;
        }
        this.f11339a = b.a(this, z ? r0.getRepostStart() : r0.getRepostInterval(), TimeUnit.MINUTES);
        return this.f11339a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            synchronized (f11288b) {
                if (Build.VERSION.SDK_INT < 18) {
                    this.f11339a = null;
                    UPLog.d("RePop", "not support sdk:", Integer.valueOf(Build.VERSION.SDK_INT));
                    return;
                }
                if (this.f11289c == null) {
                    this.f11339a = null;
                    return;
                }
                if (!f.a(this.f11290d)) {
                    this.f11339a = null;
                    return;
                }
                Application applicationA = x.a();
                NotificationManager notificationManager = (NotificationManager) applicationA.getSystemService("notification");
                if (notificationManager == null) {
                    this.f11339a = null;
                    UPLog.d("RePop", "mgr null!");
                    return;
                }
                StatusBarNotification statusBarNotificationA = a(notificationManager);
                if (statusBarNotificationA == null) {
                    this.f11339a = null;
                    UPLog.d("RePop", "sbn null! msgId:", this.f11289c.f11223b.getMsgId());
                    return;
                }
                int iN = MessageSharedPrefs.getInstance(applicationA).n();
                int iO = MessageSharedPrefs.getInstance(applicationA).o();
                UPLog.d("RePop", "task total times:", Integer.valueOf(iO), "config:", Integer.valueOf(iN));
                if (iO >= iN) {
                    return;
                }
                Notification notification = statusBarNotificationA.getNotification();
                if (notification != null) {
                    notificationManager.cancel("um", this.f11289c.f11222a);
                    notification.when = System.currentTimeMillis();
                    notificationManager.notify("um", this.f11289c.f11222a, notification);
                    this.f11339a = null;
                    this.f11289c.f11225d++;
                    MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(applicationA);
                    Calendar calendar = Calendar.getInstance();
                    messageSharedPrefs.f11128b.a("re_pop_times", String.format(Locale.getDefault(), "%d.%d.%d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)), Integer.valueOf(iO + 1)));
                    UTrack.getInstance().trackMsgRepost(this.f11289c.f11223b, notification);
                    UPLog.d("RePop", "show msgId:", this.f11289c.f11223b.getMsgId(), "count:", Integer.valueOf(this.f11289c.f11225d));
                    a();
                }
            }
        } catch (Throwable th) {
            UPLog.e("RePop", th);
        }
    }
}
