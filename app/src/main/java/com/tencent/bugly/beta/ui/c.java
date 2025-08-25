package com.tencent.bugly.beta.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static c f8829a = new c();

    /* renamed from: b, reason: collision with root package name */
    public DownloadTask f8830b;

    /* renamed from: d, reason: collision with root package name */
    public y f8832d;

    /* renamed from: e, reason: collision with root package name */
    public b f8833e;

    /* renamed from: g, reason: collision with root package name */
    private Notification f8835g;

    /* renamed from: j, reason: collision with root package name */
    private long f8838j;

    /* renamed from: k, reason: collision with root package name */
    private NotificationCompat.Builder f8839k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8837i = true;

    /* renamed from: h, reason: collision with root package name */
    private Context f8836h = com.tencent.bugly.beta.global.e.G.u;

    /* renamed from: c, reason: collision with root package name */
    public String f8831c = this.f8836h.getPackageName() + ".beta.DOWNLOAD_NOTIFY";

    /* renamed from: f, reason: collision with root package name */
    private NotificationManager f8834f = (NotificationManager) this.f8836h.getSystemService("notification");

    private c() {
        this.f8836h.registerReceiver(new BetaReceiver(), new IntentFilter(this.f8831c));
        b();
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("001", "bugly_upgrade", 2);
            notificationChannel.setDescription("bugly upgrade");
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            this.f8834f.createNotificationChannel(notificationChannel);
        }
    }

    public void a(DownloadTask downloadTask) {
        ApplicationInfo applicationInfo;
        this.f8830b = downloadTask;
        this.f8838j = this.f8830b.getSavedLength();
        this.f8837i = downloadTask.isNeededNotify();
        if (this.f8837i && com.tencent.bugly.beta.global.e.G.T) {
            this.f8834f.cancel(1000);
            Intent intent = new Intent(this.f8831c);
            intent.putExtra(SocialConstants.TYPE_REQUEST, 1);
            if (this.f8839k == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        this.f8839k = new NotificationCompat.Builder(this.f8836h, "001");
                    } catch (Throwable unused) {
                        this.f8839k = new NotificationCompat.Builder(this.f8836h);
                    }
                } else {
                    this.f8839k = new NotificationCompat.Builder(this.f8836h);
                }
            }
            NotificationCompat.Builder contentTitle = this.f8839k.setTicker(Beta.strNotificationDownloading + com.tencent.bugly.beta.global.e.G.A).setContentTitle(com.tencent.bugly.beta.global.e.G.A);
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Beta.strNotificationDownloading;
            objArr[1] = Integer.valueOf((int) (this.f8830b.getTotalLength() != 0 ? (this.f8830b.getSavedLength() * 100) / this.f8830b.getTotalLength() : 0L));
            contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setContentIntent(PendingIntent.getBroadcast(this.f8836h, 1, intent, CommonNetImpl.FLAG_AUTH)).setAutoCancel(false);
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
            int i2 = eVar.f8798h;
            if (i2 > 0) {
                this.f8839k.setSmallIcon(i2);
            } else {
                PackageInfo packageInfo = eVar.B;
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    this.f8839k.setSmallIcon(applicationInfo.icon);
                }
            }
            try {
                if (com.tencent.bugly.beta.global.e.G.f8799i > 0 && this.f8836h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f8799i) != null) {
                    this.f8839k.setLargeIcon(com.tencent.bugly.beta.global.a.a(this.f8836h.getResources().getDrawable(com.tencent.bugly.beta.global.e.G.f8799i)));
                }
            } catch (Resources.NotFoundException e2) {
                an.c(c.class, "[initNotify] " + e2.getMessage(), new Object[0]);
            }
            this.f8835g = this.f8839k.build();
            this.f8834f.notify(1000, this.f8835g);
        }
    }

    public void a() {
        DownloadTask downloadTask;
        if (this.f8837i && (downloadTask = this.f8830b) != null && com.tencent.bugly.beta.global.e.G.T) {
            if (downloadTask.getSavedLength() - this.f8838j > 307200 || this.f8830b.getStatus() == 1 || this.f8830b.getStatus() == 5 || this.f8830b.getStatus() == 3) {
                this.f8838j = this.f8830b.getSavedLength();
                if (this.f8830b.getStatus() == 1) {
                    this.f8839k.setAutoCancel(true).setContentText(Beta.strNotificationClickToInstall).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationDownloadSucc));
                } else if (this.f8830b.getStatus() == 5) {
                    this.f8839k.setAutoCancel(false).setContentText(Beta.strNotificationClickToRetry).setContentTitle(String.format("%s %s", com.tencent.bugly.beta.global.e.G.A, Beta.strNotificationDownloadError));
                } else {
                    if (this.f8830b.getStatus() == 2) {
                        NotificationCompat.Builder contentTitle = this.f8839k.setContentTitle(com.tencent.bugly.beta.global.e.G.A);
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[2];
                        objArr[0] = Beta.strNotificationDownloading;
                        objArr[1] = Integer.valueOf((int) (this.f8830b.getTotalLength() != 0 ? (this.f8830b.getSavedLength() * 100) / this.f8830b.getTotalLength() : 0L));
                        contentTitle.setContentText(String.format(locale, "%s %d%%", objArr)).setAutoCancel(false);
                    } else if (this.f8830b.getStatus() == 3) {
                        NotificationCompat.Builder contentTitle2 = this.f8839k.setContentTitle(com.tencent.bugly.beta.global.e.G.A);
                        Locale locale2 = Locale.getDefault();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Beta.strNotificationClickToContinue;
                        objArr2[1] = Integer.valueOf((int) (this.f8830b.getTotalLength() != 0 ? (this.f8830b.getSavedLength() * 100) / this.f8830b.getTotalLength() : 0L));
                        contentTitle2.setContentText(String.format(locale2, "%s %d%%", objArr2)).setAutoCancel(false);
                    }
                }
                this.f8835g = this.f8839k.build();
                this.f8834f.notify(1000, this.f8835g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a6 A[Catch: all -> 0x0109, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:11:0x0039, B:10:0x002f, B:12:0x0042, B:14:0x00a6, B:20:0x00cb, B:22:0x00d1, B:24:0x00e1, B:25:0x00f8, B:15:0x00b0, B:17:0x00b6, B:19:0x00be, B:8:0x0023), top: B:31:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0 A[Catch: all -> 0x0109, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:11:0x0039, B:10:0x002f, B:12:0x0042, B:14:0x00a6, B:20:0x00cb, B:22:0x00d1, B:24:0x00e1, B:25:0x00f8, B:15:0x00b0, B:17:0x00b6, B:19:0x00be, B:8:0x0023), top: B:31:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.tencent.bugly.proguard.y r9, com.tencent.bugly.beta.ui.b r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.c.a(com.tencent.bugly.proguard.y, com.tencent.bugly.beta.ui.b):void");
    }
}
