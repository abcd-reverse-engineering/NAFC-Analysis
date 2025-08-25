package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f13417a = new CopyOnWriteArrayList();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13418a;

        /* renamed from: a, reason: collision with other field name */
        public final long f1039a;

        /* renamed from: a, reason: collision with other field name */
        public final String f1040a;

        /* renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f1041a;

        a(String str, long j2, int i2, Notification.Action[] actionArr) {
            this.f1040a = str;
            this.f1039a = j2;
            this.f13418a = i2;
            this.f1041a = actionArr;
        }
    }

    protected static void a(Context context, StatusBarNotification statusBarNotification, int i2) {
        if (!com.xiaomi.push.j.m627a(context) || i2 <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i2, ag.m690a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        f13417a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = f13417a.size() - 1; size >= 0; size--) {
            a aVar = f13417a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f1039a > com.heytap.mcssdk.constant.a.r) {
                f13417a.remove(aVar);
            }
        }
        if (f13417a.size() > 10) {
            f13417a.remove(0);
        }
    }
}
