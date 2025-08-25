package com.heytap.mcssdk.g;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.heytap.msp.push.notification.PushNotification;

/* loaded from: classes.dex */
public class a {
    public static Notification a(Context context, String str, PushNotification.Builder builder) {
        Notification.Builder builder2 = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder2.setChannelId(com.heytap.mcssdk.d.a.f5852a);
        }
        if (Build.VERSION.SDK_INT >= 20) {
            builder2.setGroup(str);
            builder2.setGroupSummary(true);
        }
        if (a(builder2, builder)) {
            return builder2.build();
        }
        return null;
    }

    public static NotificationManager a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (NotificationManager) context.getSystemService("notification");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a(Notification.Builder builder, PushNotification.Builder builder2) {
        int iconRes = builder2.getIconRes();
        int iconLevel = builder2.getIconLevel();
        Icon icon = builder2.getIcon();
        if (icon != null && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(icon);
            return true;
        }
        if (iconRes != 0 && iconLevel != 0) {
            builder.setSmallIcon(iconRes, iconLevel);
            return true;
        }
        if (iconRes == 0) {
            return false;
        }
        builder.setSmallIcon(iconRes);
        return true;
    }

    public static boolean a(NotificationManager notificationManager, String str, int i2) {
        StatusBarNotification[] statusBarNotificationArrA = a(notificationManager, str);
        if (statusBarNotificationArrA != null && statusBarNotificationArrA.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArrA) {
                if (statusBarNotification.getId() == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static StatusBarNotification[] a(NotificationManager notificationManager, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return notificationManager.getActiveNotifications();
        }
        return null;
    }
}
