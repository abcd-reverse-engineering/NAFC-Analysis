package com.heytap.mcssdk.g;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.constant.d;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private int f5874c;

    /* renamed from: d, reason: collision with root package name */
    private int f5875d;

    /* renamed from: f, reason: collision with root package name */
    private int f5877f;

    /* renamed from: g, reason: collision with root package name */
    private int f5878g;

    /* renamed from: h, reason: collision with root package name */
    private StatusBarNotification f5879h;

    /* renamed from: a, reason: collision with root package name */
    private int f5872a = 3;

    /* renamed from: b, reason: collision with root package name */
    private List<NotificationSortMessage> f5873b = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<String> f5876e = new ArrayList();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f5880a = new b();

        private a() {
        }
    }

    private int a(List<NotificationSortMessage> list, int i2) {
        int size = list == null ? 0 : list.size();
        if (i2 <= 0 || size == 0) {
            return i2;
        }
        if (size < i2) {
            int i3 = i2 - size;
            list.clear();
            return i3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            list.remove((size - 1) - i4);
        }
        return 0;
    }

    public static b a() {
        return a.f5880a;
    }

    private DataMessage a(Context context, NotificationSortMessage notificationSortMessage) throws JSONException {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.b.f5843a, a.a.u.a.f1254k);
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(d.b.f5844b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    private void a(int i2) {
        if (i2 == 7) {
            this.f5874c++;
        } else if (i2 == 5) {
            this.f5875d++;
        }
    }

    private void a(NotificationManager notificationManager, Context context, int i2) {
        a(com.heytap.mcssdk.g.a.a(notificationManager, context.getPackageName()), i2);
    }

    private void a(Context context, NotificationManager notificationManager, int i2) throws JSONException {
        a(this.f5873b, i2);
        a(context, notificationManager, this.f5873b);
    }

    private void a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) throws JSONException {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(d.b.f5845c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap map = new HashMap();
            map.put(c.a.f5839g, arrayList);
            StatisticUtils.statisticEvent(context, map);
        }
    }

    private void a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) throws JSONException {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            } else {
                list2.add(a(context, notificationSortMessage));
                this.f5876e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    private void a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.f5873b.size() != 0) {
            for (int size = this.f5873b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.f5873b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.f5873b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.f5873b.add(0, notificationSortMessage);
    }

    private void a(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.f5876e);
        }
    }

    private void a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        if (Build.VERSION.SDK_INT >= 20) {
            builder.addExtras(bundle);
            builder.setGroup(notificationSortMessage.getGroup());
        }
    }

    private void a(StatusBarNotification[] statusBarNotificationArr, int i2) {
        b();
        if (statusBarNotificationArr != null && statusBarNotificationArr.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                boolean z = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
                long j2 = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
                String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
                int i3 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
                int i4 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
                String string2 = bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
                int id = statusBarNotification.getId();
                if (i2 == id) {
                    this.f5879h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i4, i3, z, j2, id, string2);
                b(i3);
                a(i4);
                a(notificationSortMessage);
            }
        }
        if (g.g()) {
            g.b("initParams : notDelete:" + this.f5878g + " canDelete : " + this.f5877f + "\n highSize : " + this.f5874c + " normalSize :" + this.f5875d + '\n');
            StringBuilder sb = new StringBuilder();
            sb.append("canDeleteList size : ");
            sb.append(this.f5873b.size());
            g.b(sb.toString());
            for (int i5 = 0; i5 < this.f5873b.size(); i5++) {
                NotificationSortMessage notificationSortMessage2 = this.f5873b.get(i5);
                g.b("第" + i5 + "条消息 messageId : " + notificationSortMessage2.getMessageId() + " importanceLevel : " + notificationSortMessage2.getImportantLevel() + " autoDelete : " + notificationSortMessage2.getAutoDelete() + " notifyId: " + notificationSortMessage2.getNotifyId() + " postTime:" + notificationSortMessage2.getPostTime());
            }
        }
    }

    private boolean a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) throws JSONException {
        StringBuilder sb;
        if (g.g()) {
            g.b("dealCurrentMessage : deleteNumber" + (this.f5877f + this.f5878g) + " keepNumber : " + this.f5872a);
        }
        boolean zA = true;
        if (this.f5877f + this.f5878g < this.f5872a) {
            if (notificationSortMessage.getAutoDelete() == -1) {
                sb = new StringBuilder();
                sb.append(d.a.f5841b);
            } else {
                sb = new StringBuilder();
                sb.append(d.a.f5842c);
            }
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(d.a.f5841b + context.getPackageName());
            int i2 = this.f5872a - this.f5878g;
            if (g.g()) {
                g.b("dealCurrentMessage : allowDelete :" + i2);
            }
            if (i2 > 0) {
                a(context, notificationManager, i2 - 1);
            } else {
                Notification notificationA = com.heytap.mcssdk.g.a.a(context, notificationSortMessage.getGroup(), builder);
                if (notificationA != null) {
                    notificationManager.notify(4096, notificationA);
                }
            }
        } else {
            zA = a(context, notificationManager, notificationSortMessage);
        }
        if (g.g()) {
            g.b("dealCurrentMessage : needPost :" + zA);
        }
        if (zA) {
            a(builder, notificationSortMessage);
        } else {
            com.heytap.mcssdk.j.a.a(context, c.a.f5838f, a(context, notificationSortMessage));
        }
        return zA;
    }

    private boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) throws JSONException {
        int i2 = this.f5878g;
        int i3 = this.f5872a;
        boolean z = false;
        if (i2 >= i3) {
            return false;
        }
        int i4 = i3 - i2;
        if (g.g()) {
            g.b("judgeShowCurrentMessage : allowDelete" + i4);
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.f5874c + this.f5875d < i4 : this.f5874c < i4)) {
            z = true;
        }
        if (z) {
            a(context, notificationManager, i4 - 1);
        }
        return z;
    }

    private boolean a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        StringBuilder sb;
        String str;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.f5879h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        if (notificationSortMessage.getAutoDelete() == 1) {
            sb = new StringBuilder();
            str = d.a.f5842c;
        } else {
            sb = new StringBuilder();
            str = d.a.f5841b;
        }
        sb.append(str);
        sb.append(context.getPackageName());
        notificationSortMessage.setGroup(sb.toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        a(builder, notificationSortMessage);
        this.f5876e.add(string);
        return true;
    }

    private boolean a(PushNotification.Builder builder, int i2, int i3, String str, String str2) {
        Context contextK = com.heytap.mcssdk.a.w().k();
        if (builder == null || contextK == null) {
            return false;
        }
        NotificationManager notificationManagerA = com.heytap.mcssdk.g.a.a(contextK);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i3, i2, false, System.currentTimeMillis(), str2);
        if (!a(contextK, notificationManagerA, notificationSortMessage, builder)) {
            return true;
        }
        a(notificationManagerA, contextK, builder.getVerifyNotifyId());
        if (a(contextK, builder, notificationSortMessage)) {
            return true;
        }
        return a(notificationManagerA, contextK, builder, notificationSortMessage);
    }

    private void b() {
        this.f5877f = 0;
        this.f5878g = 0;
        this.f5874c = 0;
        this.f5875d = 0;
        this.f5873b.clear();
        this.f5876e.clear();
        this.f5879h = null;
    }

    private void b(int i2) {
        if (i2 == -1) {
            this.f5878g++;
        } else if (i2 == 1) {
            this.f5877f++;
        }
    }

    public void a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        a(iSortListener, a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    public boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        int i2;
        if (notificationSortMessage.getAutoDelete() == 0 || (i2 = Build.VERSION.SDK_INT) < 24 || i2 >= 30) {
            return false;
        }
        if (!com.heytap.mcssdk.g.a.a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(d.a.f5841b + context.getPackageName());
        a(builder, notificationSortMessage);
        return false;
    }
}
