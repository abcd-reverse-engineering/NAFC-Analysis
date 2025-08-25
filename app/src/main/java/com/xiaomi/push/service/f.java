package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.service.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f13419a;

    /* renamed from: a, reason: collision with other field name */
    private static final int[] f1042a = {1, 2, 4, 8, 16};

    /* renamed from: b, reason: collision with root package name */
    private static final SparseArray<Integer> f13420b;

    static {
        int i2 = 5;
        f13419a = new SparseArray<ag.a<String, String, String>>(i2) { // from class: com.xiaomi.push.service.f.1
            {
                put(1, ag.f13326b);
                put(2, ag.f13327c);
                put(4, ag.f13328d);
                put(8, ag.f13330f);
                put(16, ag.f13329e);
            }
        };
        f13420b = new SparseArray<Integer>(i2) { // from class: com.xiaomi.push.service.f.2
            {
                put(1, 32);
                put(2, 16);
                put(4, 8);
                put(8, 4);
                put(16, 2);
            }
        };
    }

    static int a(String str, String str2) {
        int i2 = m716a(str, str2, 8) ? 8 : 0;
        if (m716a(str, str2, 16)) {
            i2 |= 16;
        }
        if (m716a(str, str2, 1)) {
            i2 |= 1;
        }
        if (m716a(str, str2, 2)) {
            i2 |= 2;
        }
        return m716a(str, str2, 4) ? i2 | 4 : i2;
    }

    private static boolean a(int i2, int i3) {
        return i2 >= 4 || (i3 & 2) > 0 || (i3 & 1) > 0 || (i3 & 8) > 0 || (i3 & 16) > 0;
    }

    static void a(Context context, String str, String str2, int i2, String str3, boolean z, int i3) {
        if (com.xiaomi.push.j.m627a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int iA = com.xiaomi.push.s.a(str3, 0);
            boolean zA = a(i2, iA);
            if (z) {
                a(str, str2, iA, i3);
                if (zA) {
                    synchronized (f.class) {
                        a(a(context), iA, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (f.class) {
                SharedPreferences sharedPreferencesA = a(context);
                if (zA || sharedPreferencesA.contains(str2)) {
                    a(sharedPreferencesA, iA, str, str2, i3);
                    if (zA) {
                        a(sharedPreferencesA, iA, str2);
                    } else {
                        a(sharedPreferencesA, str2);
                    }
                }
            }
            return;
        }
        if (com.xiaomi.push.j.m627a(context)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
        }
    }

    static void a(Context context, String str) {
        List<NotificationChannel> listM685a;
        if (!com.xiaomi.push.j.m627a(context) || TextUtils.isEmpty(str) || (listM685a = af.a(context, str).m685a()) == null) {
            return;
        }
        synchronized (f.class) {
            SharedPreferences sharedPreferencesA = a(context);
            ArrayList arrayList = new ArrayList();
            Iterator<NotificationChannel> it = listM685a.iterator();
            while (it.hasNext()) {
                String str2 = (String) com.xiaomi.push.aw.a(it.next(), "mId");
                if (!TextUtils.isEmpty(str2) && sharedPreferencesA.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(sharedPreferencesA, arrayList);
            }
        }
    }

    static void a(String str, String str2, int i2, int i3) {
        for (int i4 : f1042a) {
            if ((f13420b.get(i4).intValue() & i3) == 0) {
                a(str, str2, i4, (i2 & i4) > 0);
            } else {
                com.xiaomi.channel.commonutils.logger.b.m50a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i4 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i2, boolean z) {
        com.xiaomi.channel.commonutils.logger.b.m50a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + "> :" + ag.a(C0343r.m636a(), str, str2, f13419a.get(i2), z));
    }

    public static int a(String str, String str2, int i2) {
        return ag.a(C0343r.m636a(), str, str2, f13419a.get(i2));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Bundle m715a(String str, String str2) {
        return ag.a(C0343r.m636a(), str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m716a(String str, String str2, int i2) {
        boolean z = ag.a(C0343r.m636a(), str, str2, f13419a.get(i2)) == 1;
        com.xiaomi.channel.commonutils.logger.b.m50a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + ContainerUtils.KEY_VALUE_DELIMITER + z + ">");
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r5, java.lang.String r6, android.app.NotificationChannel r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto Laf
            if (r5 == 0) goto Laf
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto Laf
            if (r7 == 0) goto Laf
            int r5 = r7.getImportance()
            r0 = 1
            if (r5 == 0) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 2
        L1b:
            r5 = r5 | r1
            boolean r1 = com.xiaomi.push.service.ag.a()
            r2 = 16
            r3 = 4
            r4 = 8
            if (r1 == 0) goto L6e
            java.lang.String r0 = r7.getId()
            android.os.Bundle r6 = m715a(r6, r0)
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f13330f
            T r0 = r0.f13335c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L51
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f13330f
            T r0 = r0.f13335c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.getBoolean(r0)
            if (r0 == 0) goto L4e
            int r0 = r7.getImportance()
            if (r0 < r3) goto L4e
            goto L50
        L4e:
            r3 = 8
        L50:
            r5 = r5 | r3
        L51:
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f13329e
            T r0 = r0.f13335c
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r6.containsKey(r0)
            if (r0 == 0) goto L96
            com.xiaomi.push.service.ag$a<java.lang.String, java.lang.String, java.lang.String> r0 = com.xiaomi.push.service.ag.f13329e
            T r0 = r0.f13335c
            java.lang.String r0 = (java.lang.String) r0
            boolean r6 = r6.getBoolean(r0)
            if (r6 == 0) goto L6a
            goto L6c
        L6a:
            r2 = 32
        L6c:
            r5 = r5 | r2
            goto L96
        L6e:
            java.lang.String r1 = r7.getId()
            int r1 = a(r6, r1, r4)
            if (r1 != r0) goto L81
            int r1 = r7.getImportance()
            if (r1 < r3) goto L83
            r5 = r5 | 4
            goto L85
        L81:
            if (r1 != 0) goto L85
        L83:
            r5 = r5 | 8
        L85:
            java.lang.String r1 = r7.getId()
            int r6 = a(r6, r1, r2)
            if (r6 != r0) goto L92
            r5 = r5 | 16
            goto L96
        L92:
            if (r6 != 0) goto L96
            r5 = r5 | 32
        L96:
            android.net.Uri r6 = r7.getSound()
            if (r6 == 0) goto L9f
            r5 = r5 | 64
            goto La1
        L9f:
            r5 = r5 | 128(0x80, float:1.8E-43)
        La1:
            boolean r6 = r7.shouldVibrate()
            if (r6 == 0) goto Laa
            r6 = 256(0x100, float:3.59E-43)
            goto Lac
        Laa:
            r6 = 512(0x200, float:7.17E-43)
        Lac:
            r1 = r5 | r6
            goto Lb4
        Laf:
            java.lang.String r5 = "context|packageName|channel must not be null "
            com.xiaomi.channel.commonutils.logger.b.m50a(r5)
        Lb4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, android.app.NotificationChannel):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 26
            if (r0 < r2) goto L67
            if (r3 == 0) goto L67
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L67
            com.xiaomi.push.service.af r3 = com.xiaomi.push.service.af.a(r3, r4)
            if (r3 == 0) goto L61
            java.lang.String r5 = r3.m684a(r5)
            android.app.NotificationChannel r3 = r3.m681a(r5)
            if (r3 == 0) goto L5b
            int r5 = r3.getImportance()
            r0 = 1
            if (r5 == 0) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 2
        L29:
            r5 = r5 | r1
            java.lang.String r1 = r3.getId()
            r2 = 8
            int r1 = a(r4, r1, r2)
            if (r1 != r0) goto L40
            int r1 = r3.getImportance()
            r2 = 4
            if (r1 < r2) goto L42
            r5 = r5 | 4
            goto L44
        L40:
            if (r1 != 0) goto L44
        L42:
            r5 = r5 | 8
        L44:
            java.lang.String r3 = r3.getId()
            r1 = 16
            int r3 = a(r4, r3, r1)
            if (r3 != r0) goto L54
            r3 = r5 | 16
        L52:
            r1 = r3
            goto L6c
        L54:
            if (r3 != 0) goto L59
            r3 = r5 | 32
            goto L52
        L59:
            r1 = r5
            goto L6c
        L5b:
            java.lang.String r3 = "Channel must not be null"
            com.xiaomi.channel.commonutils.logger.b.m50a(r3)
            goto L6c
        L61:
            java.lang.String r3 = "create NMHelper error"
            com.xiaomi.channel.commonutils.logger.b.m50a(r3)
            goto L6c
        L67:
            java.lang.String r3 = "Must greater than or equal android O and context|packageName not be null"
            com.xiaomi.channel.commonutils.logger.b.m50a(r3)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.f.a(android.content.Context, java.lang.String, java.lang.String):int");
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str, String str2, int i3) {
        if (sharedPreferences.getInt(str2, 0) != i2) {
            a(str, str2, i2, i3);
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str) {
        sharedPreferences.edit().putInt(str, i2).commit();
    }

    private static void a(SharedPreferences sharedPreferences, final String str) {
        a(sharedPreferences, new ArrayList<String>() { // from class: com.xiaomi.push.service.f.3
            {
                add(str);
            }
        });
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }
}
