package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.taobao.accs.AccsClientConfig;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class NotifyAdapterUtil {
    private static final String EXTRA_VPUSH_TYPE = "extra_vpush_type";
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static final String USER_ID = "sysUserId";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    private static boolean cancelNotify(Context context, int i2) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i2);
        return true;
    }

    private static synchronized void initAdapter(Context context) {
        if (sNotificationManager == null) {
            sNotificationManager = (NotificationManager) context.getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26 && sNotificationManager != null) {
            NotificationChannel notificationChannel = sNotificationManager.getNotificationChannel(AccsClientConfig.DEFAULT_CONFIGTAG);
            if (notificationChannel != null) {
                CharSequence name = notificationChannel.getName();
                if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                    sNotificationManager.deleteNotificationChannel(AccsClientConfig.DEFAULT_CONFIGTAG);
                }
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
            notificationChannel2.setLightColor(-16711936);
            notificationChannel2.enableVibration(true);
            notificationChannel2.setLockscreenVisibility(1);
            sNotificationManager.createNotificationChannel(notificationChannel2);
        }
    }

    private static boolean isPullService() {
        return n.f12281a ? Build.VERSION.SDK_INT < 31 : Build.VERSION.SDK_INT < 28;
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j2, int i2, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        u.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j2, i2, notifyArriveCallbackByUser, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j2, notifyArriveCallbackByUser, aVar);
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j2, NotifyArriveCallbackByUser notifyArriveCallbackByUser, u.a aVar) {
        Notification notification;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i2 = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong(PUSH_ID, j2);
        if (com.vivo.push.restructure.a.a().e().l().isOpenMultiUser()) {
            bundle.putInt(USER_ID, w.a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            notification = builder.build();
        } else if (i3 >= 19) {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            notification = builder2.build();
        } else {
            notification = new Notification();
        }
        Notification notification2 = notification;
        notification2.priority = 2;
        notification2.flags = 16;
        notification2.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i2;
        }
        notification2.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, 0);
        if (list == null || list.isEmpty() || (bitmap = list.get(0)) == null) {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i2;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        } else {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        }
        Bitmap bitmap2 = null;
        if (list != null && list.size() > 1) {
            bitmap2 = list.get(1);
        }
        if (bitmap2 == null) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        } else if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
            remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
            remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
        }
        notification2.contentView = remoteViews;
        if (Build.VERSION.SDK_INT >= 16 && TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification2.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        u.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification2.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification2.defaults |= 2;
                        notification2.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification2.defaults = 2;
                notification2.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification2.defaults = 1;
        }
        i iVar = new i();
        Intent intentA = iVar.a(context, packageName, j2, insideNotificationItem, notifyArriveCallbackByUser);
        if (intentA == null) {
            u.a(TAG, "make notify intent error  ");
            return;
        }
        if (isPullService()) {
            notification2.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), b.a(context, packageName, j2, intentA, insideNotificationItem), 201326592);
        } else {
            new com.vivo.push.b.p(packageName, j2, insideNotificationItem).b(intentA);
            notification2.contentIntent = iVar.a(context, intentA);
        }
        if (sNotificationManager != null) {
            int iJ = com.vivo.push.m.a().j();
            try {
                if (iJ == 0) {
                    sNotificationManager.notify(sNotifyId, notification2);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (iJ != 1) {
                    u.a(TAG, "unknow notify style ".concat(String.valueOf(iJ)));
                    return;
                }
                sNotificationManager.notify((int) j2, notification2);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e2) {
                u.a(TAG, e2);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void pushNotificationBySystem(android.content.Context r17, java.util.List<android.graphics.Bitmap> r18, com.vivo.push.model.InsideNotificationItem r19, long r20, int r22, com.vivo.push.model.NotifyArriveCallbackByUser r23, com.vivo.push.f.u.a r24) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.NotifyAdapterUtil.pushNotificationBySystem(android.content.Context, java.util.List, com.vivo.push.model.InsideNotificationItem, long, int, com.vivo.push.model.NotifyArriveCallbackByUser, com.vivo.push.f.u$a):void");
    }

    public static boolean repealNotifyById(Context context, long j2) {
        int iJ = com.vivo.push.m.a().j();
        if (iJ != 0) {
            if (iJ == 1) {
                return cancelNotify(context, (int) j2);
            }
            u.a(TAG, "unknow cancle notify style ".concat(String.valueOf(iJ)));
            return false;
        }
        long jB = ad.b().b("com.vivo.push.notify_key", -1L);
        if (jB == j2) {
            u.d(TAG, "undo showed message ".concat(String.valueOf(j2)));
            u.a(context, "回收已展示的通知： ".concat(String.valueOf(j2)));
            return cancelNotify(context, sNotifyId);
        }
        u.d(TAG, "current showing message id " + jB + " not match " + j2);
        u.a(context, "与已展示的通知" + jB + "与待回收的通知" + j2 + "不匹配");
        return false;
    }

    public static void setNotifyId(int i2) {
        sNotifyId = i2;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }
}
