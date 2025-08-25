package com.umeng.message;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.component.UmengNotificationClickActivity;
import com.umeng.message.component.UmengNotificationReceiver;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.a;
import com.umeng.message.proguard.ac;
import com.umeng.message.proguard.am;
import com.umeng.message.proguard.an;
import com.umeng.message.proguard.aw;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.t;
import com.umeng.message.proguard.w;
import com.umeng.message.proguard.x;
import com.umeng.message.proguard.y;
import com.umeng.message.push.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class UmengMessageHandler implements UPushMessageHandler {

    /* renamed from: a, reason: collision with root package name */
    private static Date f11130a;

    /* renamed from: b, reason: collision with root package name */
    private int f11131b;

    /* JADX WARN: Multi-variable type inference failed */
    private Notification a(Context context, UMessage uMessage) {
        String str;
        String str2;
        Bitmap bitmap;
        String str3;
        String str4;
        int i2;
        Notification.Builder builder = new Notification.Builder(context);
        String category = uMessage.getCategory();
        if (Build.VERSION.SDK_INT >= 21 && !TextUtils.isEmpty(category)) {
            builder.setCategory(category);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = getNotificationChannel(context, uMessage);
            if (notificationChannel == null) {
                notificationChannel = ((uMessage.getImportance() == 1 && d.g()) || isInNoDisturbTime(context)) ? UPushNotificationChannel.getSilenceMode(context) : UPushNotificationChannel.getDefaultMode(context);
            }
            if (notificationChannel == null) {
                UPLog.e("MsgHandler", "notification channel null!");
                return null;
            }
            builder.setChannelId(notificationChannel.getId());
        }
        int smallIconId = getSmallIconId(context, uMessage);
        if (smallIconId < 0) {
            UPLog.e("MsgHandler", "notification small icon error!");
            return null;
        }
        Bitmap largeIcon = getLargeIcon(context, uMessage);
        Bitmap expandImage = getExpandImage(context, uMessage);
        String title = uMessage.getTitle();
        String content = uMessage.getContent();
        String titleColor = uMessage.getTitleColor();
        if (TextUtils.isEmpty(titleColor) || TextUtils.isEmpty(title)) {
            str = title;
        } else {
            try {
                int color = Color.parseColor(titleColor);
                SpannableString spannableString = new SpannableString(title);
                spannableString.setSpan(new ForegroundColorSpan(color), 0, title.length(), 34);
                str = spannableString;
            } catch (Exception unused) {
            }
        }
        String textColor = uMessage.getTextColor();
        if (TextUtils.isEmpty(textColor) || TextUtils.isEmpty(content)) {
            str2 = content;
        } else {
            try {
                int color2 = Color.parseColor(textColor);
                SpannableString spannableString2 = new SpannableString(content);
                spannableString2.setSpan(new ForegroundColorSpan(color2), 0, content.length(), 34);
                str2 = spannableString2;
            } catch (Exception unused2) {
            }
        }
        builder.setTicker(uMessage.getTicker());
        builder.setSmallIcon(smallIconId);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setAutoCancel(true);
        Bitmap backgroundImage = (Build.VERSION.SDK_INT < 26 || !uMessage.hasBackgroundImage()) ? null : getBackgroundImage(context, uMessage);
        if (Build.VERSION.SDK_INT < 26 || backgroundImage == null) {
            bitmap = expandImage;
            str3 = textColor;
            str4 = titleColor;
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.upush_notification_banner_layout);
                remoteViews.setImageViewBitmap(R.id.upush_notification_banner, getBarImage(context, uMessage));
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.setCustomContentView(remoteViews);
                } else {
                    builder.setContent(remoteViews);
                }
            } else if (largeIcon != null) {
                builder.setLargeIcon(largeIcon);
            }
        } else {
            builder.setGroupSummary(d.h());
            builder.setGroup(uMessage.msg_id);
            int i3 = R.layout.upush_notification_shade_layout;
            int i4 = R.id.upush_notification_small_icon;
            int i5 = R.id.upush_notification_app_name;
            int i6 = R.id.upush_notification_date;
            int i7 = R.id.upush_notification_title;
            int i8 = R.id.upush_notification_content;
            int i9 = R.id.upush_notification_shade_iv;
            str3 = textColor;
            int i10 = R.id.upush_notification_large_iv;
            str4 = titleColor;
            bitmap = expandImage;
            RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), i3);
            remoteViews2.setImageViewResource(i4, smallIconId);
            remoteViews2.setTextViewText(i5, UMUtils.getAppName(context));
            long msgTime = uMessage.getMsgTime();
            remoteViews2.setTextViewText(i6, (f.a(msgTime) ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())).format(Long.valueOf(msgTime)));
            remoteViews2.setTextViewText(i7, str);
            if (TextUtils.isEmpty(str2)) {
                remoteViews2.setViewVisibility(i8, 8);
                i2 = 0;
            } else {
                i2 = 0;
                remoteViews2.setViewVisibility(i8, 0);
                remoteViews2.setTextViewText(i8, str2);
            }
            if (largeIcon != null) {
                remoteViews2.setViewVisibility(i10, i2);
                remoteViews2.setImageViewBitmap(i10, largeIcon);
            } else {
                remoteViews2.setViewVisibility(i10, 8);
            }
            remoteViews2.setViewVisibility(i9, i2);
            remoteViews2.setImageViewBitmap(i9, backgroundImage);
            builder.setCustomContentView(remoteViews2);
        }
        if (bitmap != null && Build.VERSION.SDK_INT >= 16) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.bigPicture(bitmap);
            bigPictureStyle.bigLargeIcon(largeIcon);
            builder.setStyle(bigPictureStyle);
        } else if (!TextUtils.isEmpty(uMessage.getBigBody()) && Build.VERSION.SDK_INT >= 16) {
            String bigTitle = uMessage.getBigTitle();
            String str5 = str;
            if (bigTitle != null) {
                str5 = str;
                if (bigTitle.length() != 0) {
                    str5 = bigTitle;
                }
            }
            String bigBody = uMessage.getBigBody();
            String str6 = str5;
            if (!TextUtils.isEmpty(str4)) {
                boolean zIsEmpty = TextUtils.isEmpty(str5);
                str6 = str5;
                if (!zIsEmpty) {
                    try {
                        int color3 = Color.parseColor(str4);
                        SpannableString spannableString3 = new SpannableString(str5);
                        spannableString3.setSpan(new ForegroundColorSpan(color3), 0, str5.length(), 34);
                        str6 = spannableString3;
                    } catch (Exception unused3) {
                        str6 = str5;
                    }
                }
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(bigBody)) {
                try {
                    int color4 = Color.parseColor(str3);
                    SpannableString spannableString4 = new SpannableString(bigBody);
                    spannableString4.setSpan(new ForegroundColorSpan(color4), 0, bigBody.length(), 34);
                    bigBody = spannableString4;
                } catch (Exception unused4) {
                }
            }
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(str6);
            bigTextStyle.bigText(bigBody);
            builder.setStyle(bigTextStyle);
        }
        return builder.getNotification();
    }

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        UMessage uMessage2;
        UPLog.i("MsgHandler", "notification:", uMessage.getRaw());
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        boolean z = uMessage.getMsgTime() >= messageSharedPrefs.f11128b.b("last_msg_time", 0L);
        messageSharedPrefs.f11128b.a("last_msg_time", uMessage.getMsgTime());
        Notification notification = getNotification(context, uMessage);
        int notificationDefaults = getNotificationDefaults(context, uMessage);
        if (notification == null) {
            notification = a(context, uMessage);
        }
        if (notification == null) {
            UPLog.e("MsgHandler", "notification null");
            return;
        }
        int i2 = this.f11131b;
        if (i2 == 0) {
            this.f11131b = (int) SystemClock.elapsedRealtime();
        } else {
            this.f11131b = i2 + 1;
        }
        notification.deleteIntent = getDismissPendingIntent(context, uMessage);
        notification.contentIntent = getClickPendingIntent(context, uMessage);
        if ((notificationDefaults & 1) != 0) {
            Uri sound = getSound(context, uMessage);
            if (sound != null) {
                notification.sound = getSound(context, uMessage);
            }
            if (sound != null) {
                notificationDefaults ^= 1;
            }
        }
        notification.defaults = notificationDefaults;
        int i3 = this.f11131b;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (PushAgent.getInstance(context).getNotificationOnForeground() || !t.c()) {
                int iB = MessageSharedPrefs.getInstance(context).b();
                if (iB != 1 || z) {
                    w wVarA = w.a();
                    if (iB > 0) {
                        while (wVarA.c() >= iB) {
                            ac acVarB = wVarA.b();
                            if (acVarB != null) {
                                if (notificationManager != null) {
                                    notificationManager.cancel("um", acVarB.f11222a);
                                }
                                UTrack.getInstance().trackMsgDismissed(acVarB.f11223b);
                                am.a(acVarB);
                            }
                        }
                    }
                    ac acVar = new ac(i3, uMessage);
                    wVarA.a(acVar);
                    if (notificationManager != null) {
                        notificationManager.notify("um", i3, notification);
                        UTrack.getInstance().trackMsgShow(uMessage, notification);
                    }
                    if (Build.VERSION.SDK_INT >= 23 && (uMessage2 = acVar.f11223b) != null && acVar.f11224c == null && uMessage2.isRepost()) {
                        MessageSharedPrefs.getInstance(x.a()).f11128b.a("re_pop_cfg", uMessage2.getRepostCount());
                        acVar.f11224c = new an(acVar).a();
                    }
                } else {
                    UTrack.getInstance().trackMsgDismissed(uMessage);
                }
            } else {
                UPLog.i("MsgHandler", "foreground notification dismiss. msgId:", uMessage.getMsgId());
                UTrack.getInstance().trackMsgDismissed(uMessage);
            }
        } catch (Exception e2) {
            UPLog.e("MsgHandler", e2);
        }
        setBadgeNum(context, uMessage);
    }

    public Bitmap getBackgroundImage(Context context, UMessage uMessage) {
        try {
            String backgroundImageUrl = uMessage.getBackgroundImageUrl();
            if (TextUtils.isEmpty(backgroundImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(backgroundImageUrl)), bb.a(), bb.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getBarImage(Context context, UMessage uMessage) {
        try {
            String barImageUrl = uMessage.getBarImageUrl();
            if (TextUtils.isEmpty(barImageUrl)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(barImageUrl)), bb.a(), bb.a(64.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setFlags(335544320);
        intent.setClass(context, UmengNotificationClickActivity.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("NOTIFICATION_ID", this.f11131b);
        return PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, Build.VERSION.SDK_INT < 23 ? CommonNetImpl.FLAG_AUTH : 335544320);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, UmengNotificationReceiver.class);
        intent.putExtra("MSG", uMessage.getRaw().toString());
        intent.putExtra("ACTION", 11);
        intent.putExtra("NOTIFICATION_ID", this.f11131b);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : CommonNetImpl.FLAG_AUTH);
    }

    public Bitmap getExpandImage(Context context, UMessage uMessage) {
        try {
            String bigImage = uMessage.getBigImage();
            if (TextUtils.isEmpty(bigImage)) {
                return null;
            }
            return f.a(new File(f.g(context), UMUtils.MD5(bigImage)), bb.a(), bb.a(256.0f));
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Bitmap getLargeIcon(Context context, UMessage uMessage) {
        Bitmap bitmapA;
        try {
            if (uMessage.isLargeIconFromInternet()) {
                String largeIconUrl = uMessage.getLargeIconUrl();
                if (TextUtils.isEmpty(largeIconUrl)) {
                    return null;
                }
                bitmapA = f.a(new File(f.g(context), UMUtils.MD5(largeIconUrl)), bb.a(48.0f), bb.a(48.0f));
            } else {
                bitmapA = null;
            }
            if (bitmapA != null) {
                return bitmapA;
            }
            int iB = -1;
            String largeIconDrawableName = uMessage.getLargeIconDrawableName();
            if (TextUtils.isEmpty(largeIconDrawableName)) {
                try {
                    iB = a.a().b("umeng_push_notification_default_large_icon");
                } catch (Exception e2) {
                    UPLog.w("MsgHandler", e2);
                }
            } else {
                try {
                    iB = a.a().b(largeIconDrawableName);
                } catch (Exception e3) {
                    UPLog.e("MsgHandler", e3);
                }
            }
            return iB > 0 ? BitmapFactory.decodeResource(context.getResources(), iB) : bitmapA;
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
            return null;
        }
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        return null;
    }

    public NotificationChannel getNotificationChannel() {
        return null;
    }

    public NotificationChannel getNotificationChannel(Context context, UMessage uMessage) {
        return getNotificationChannel();
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        Calendar calendar = Calendar.getInstance();
        if (isInNoDisturbTime(context)) {
            return 0;
        }
        MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(context);
        long jG = messageSharedPrefs.g() * 1000;
        if (f11130a != null && calendar.getTimeInMillis() - f11130a.getTime() < jG) {
            return 0;
        }
        int iH = messageSharedPrefs.h();
        UPLog.i("MsgHandler", "vibrate:", Integer.valueOf(iH));
        int i2 = (iH != 1 && (iH == 2 || !uMessage.isVibrate())) ? 0 : 2;
        int i3 = messageSharedPrefs.i();
        UPLog.i("MsgHandler", "lights:", Integer.valueOf(i3));
        if (i3 == 1 || (i3 != 2 && uMessage.isLights())) {
            i2 |= 4;
        }
        int iJ = messageSharedPrefs.j();
        UPLog.i("MsgHandler", "sound:", Integer.valueOf(iJ));
        if (iJ == 1 || (iJ != 2 && uMessage.isSound())) {
            i2 |= 1;
        }
        f11130a = calendar.getTime();
        if (uMessage.isScreenOn()) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                boolean zIsScreenOn = powerManager.isScreenOn();
                UPLog.i("MsgHandler", "screen on:".concat(String.valueOf(zIsScreenOn)));
                if (!zIsScreenOn) {
                    powerManager.newWakeLock(805306374, "UPush:NTF").acquire(com.heytap.mcssdk.constant.a.q);
                }
            } catch (Throwable th) {
                UPLog.e("MsgHandler", th);
            }
        }
        return i2;
    }

    public int getSmallIconId(Context context, UMessage uMessage) {
        int iB = -1;
        try {
            String smallIconDrawableName = uMessage.getSmallIconDrawableName();
            if (TextUtils.isEmpty(smallIconDrawableName)) {
                try {
                    iB = a.a().b("umeng_push_notification_default_small_icon");
                } catch (Exception e2) {
                    UPLog.w("MsgHandler", e2);
                }
            } else {
                try {
                    iB = a.a().b(smallIconDrawableName);
                } catch (Exception e3) {
                    UPLog.e("MsgHandler", e3);
                }
            }
            if (iB < 0) {
                UPLog.i("MsgHandler", "no custom notification small icon! change to use app icon");
                iB = context.getApplicationInfo().icon;
            }
            if (iB < 0) {
                UPLog.e("MsgHandler", "can't find notification small icon");
            }
        } catch (Throwable th) {
            UPLog.e("MsgHandler", th);
        }
        return iB;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r6.isSoundFromInternet()     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L22
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6b
            java.io.File r2 = com.umeng.message.proguard.f.g(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.MD5(r3)     // Catch: java.lang.Throwable -> L6b
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = r1.getPath()     // Catch: java.lang.Throwable -> L6b
            boolean r1 = r1.exists()     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L23
        L22:
            r2 = r0
        L23:
            if (r2 != 0) goto L64
            r1 = -1
            java.lang.String r3 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L6b
            if (r3 != 0) goto L3c
            java.lang.String r6 = r6.getSoundUri()     // Catch: java.lang.Throwable -> L6b
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.c(r6)     // Catch: java.lang.Throwable -> L6b
        L3c:
            if (r1 >= 0) goto L48
            java.lang.String r6 = "umeng_push_notification_default_sound"
            com.umeng.message.proguard.a r1 = com.umeng.message.proguard.a.a()     // Catch: java.lang.Throwable -> L6b
            int r1 = r1.c(r6)     // Catch: java.lang.Throwable -> L6b
        L48:
            if (r1 <= 0) goto L64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = "android.resource://"
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L6b
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = "/"
            r6.append(r5)     // Catch: java.lang.Throwable -> L6b
            r6.append(r1)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L6b
        L64:
            if (r2 == 0) goto L71
            android.net.Uri r5 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L6b
            return r5
        L6b:
            r5 = move-exception
            java.lang.String r6 = "MsgHandler"
            com.umeng.message.common.UPLog.w(r6, r5)
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengMessageHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    @Override // com.umeng.message.api.UPushMessageHandler
    public void handleMessage(Context context, UMessage uMessage) {
        if ("notification".equals(uMessage.getDisplayType())) {
            dealWithNotificationMessage(context, uMessage);
            return;
        }
        if ("custom".equals(uMessage.getDisplayType())) {
            if (TextUtils.isEmpty(uMessage.getRecallMsgId())) {
                dealWithCustomMessage(context, uMessage);
                return;
            }
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return;
                }
                w wVarA = w.a();
                ac acVarA = wVarA.a(uMessage.getRecallMsgId());
                if (acVarA == null) {
                    y.a().a(uMessage.getRecallMsgId(), 5);
                    return;
                }
                notificationManager.cancel("um", acVarA.f11222a);
                wVarA.b(acVarA);
                am.a(acVarA);
                y.a().a(uMessage.getRecallMsgId(), 4);
            } catch (Throwable th) {
                UPLog.e("MsgHandler", th);
            }
        }
    }

    public boolean isInNoDisturbTime(Context context) {
        Calendar calendar = Calendar.getInstance();
        int i2 = (calendar.get(11) * 60) + calendar.get(12);
        boolean z = i2 >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = i2 <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        return (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute() ? z && z2 : z || z2;
    }

    public void setBadgeNum(Context context, UMessage uMessage) {
        if (uMessage.getBadgeSet() >= 0) {
            aw.a(context, uMessage.getBadgeSet());
            UPLog.d("MsgHandler", "setBadgeNum:", Integer.valueOf(uMessage.getBadgeSet()));
        } else if (uMessage.getBadgeAdd() != 0) {
            aw.b(context, uMessage.getBadgeAdd());
            UPLog.d("MsgHandler", "changeBadgeNum:", Integer.valueOf(uMessage.getBadgeAdd()));
        }
    }
}
