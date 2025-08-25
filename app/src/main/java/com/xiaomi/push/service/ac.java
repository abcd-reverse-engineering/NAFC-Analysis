package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.push.gs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f13314a = Log.isLoggable("NCHelper", 3);

    @TargetApi(26)
    private static void a(af afVar, NotificationChannel notificationChannel, String str) {
        int iA;
        char c2;
        int iA2;
        char c3;
        Context contextM682a = afVar.m682a();
        String id = notificationChannel.getId();
        String strA = af.a(id, afVar.m683a());
        if (f13314a) {
            a("appChannelId:" + id + " oldChannelId:" + strA);
        }
        boolean z = true;
        if (com.xiaomi.push.j.m627a(contextM682a) && !TextUtils.equals(id, strA)) {
            NotificationManager notificationManager = (NotificationManager) contextM682a.getSystemService("notification");
            NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(strA);
            NotificationChannel notificationChannelM681a = afVar.m681a(id);
            if (f13314a) {
                a("xmsfChannel:" + notificationChannel2);
                a("appChannel:" + notificationChannelM681a);
            }
            if (notificationChannel2 != null) {
                NotificationChannel notificationChannelA = a(id, notificationChannel2);
                if (f13314a) {
                    a("copyXmsf copyXmsfChannel:" + notificationChannelA);
                }
                if (notificationChannelM681a != null) {
                    iA2 = a(notificationChannelM681a);
                    afVar.a(notificationChannelA, iA2 == 0);
                    c3 = 3;
                } else {
                    int iA3 = a(notificationChannel2);
                    a(contextM682a, afVar, notificationChannelA, iA3, notificationChannel2.getId());
                    iA2 = iA3;
                    c3 = 4;
                }
                b(contextM682a, id);
                notificationManager.deleteNotificationChannel(strA);
                iA = iA2;
                c2 = c3;
            } else if (notificationChannelM681a == null) {
                if (f13314a) {
                    a("appHack createNotificationChannel:" + notificationChannel);
                }
                afVar.a(notificationChannel);
                iA = 0;
                c2 = 1;
            } else if (!m671a(contextM682a, id) && a(notificationChannel, notificationChannelM681a)) {
                if (f13314a) {
                    a("appHack updateNotificationChannel:" + notificationChannel);
                }
                iA = a(notificationChannelM681a);
                afVar.a(notificationChannel, iA == 0);
                c2 = 2;
            }
            if (c2 != 1 && c2 != 4 && c2 != 3) {
                z = false;
            }
            f.a(afVar.m682a(), afVar.m683a(), id, notificationChannel.getImportance(), str, z, iA);
        }
        NotificationChannel notificationChannelM681a2 = afVar.m681a(id);
        if (f13314a) {
            a("elseLogic getNotificationChannel:" + notificationChannelM681a2);
        }
        if (notificationChannelM681a2 == null) {
            afVar.a(notificationChannel);
        }
        iA = 0;
        c2 = 0;
        if (c2 != 1) {
            z = false;
        }
        f.a(afVar.m682a(), afVar.m683a(), id, notificationChannel.getImportance(), str, z, iA);
    }

    private static void b(Context context, String str) {
        if (f13314a) {
            a("recordCopiedChannel:" + str);
        }
        a(context).edit().putBoolean(str, true).apply();
    }

    private static void c(Context context, String str) {
        try {
            af afVarA = af.a(context, str);
            Set<String> setKeySet = a(context).getAll().keySet();
            ArrayList arrayList = new ArrayList();
            for (String str2 : setKeySet) {
                if (afVarA.m686a(str2)) {
                    arrayList.add(str2);
                    if (f13314a) {
                        a("delete channel copy record:" + str2);
                    }
                }
            }
            a(context, arrayList);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    private static boolean a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        if (TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            z = false;
        } else {
            if (f13314a) {
                a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f13314a) {
                a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f13314a) {
                a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + c.c.a.b.a.a.f3100g + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f13314a) {
                a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f13314a) {
                a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        if ((notificationChannel.getSound() != null) != (notificationChannel2.getSound() != null)) {
            notificationChannel.setSound(null, null);
            if (f13314a) {
                a("appHack channelConfigLowerCompare:setSound");
            }
            z = true;
        }
        if (f13314a) {
            a("appHack channelConfigLowerCompare:isDifferent:" + z);
        }
        return z;
    }

    private static int a(NotificationChannel notificationChannel) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) com.xiaomi.push.aw.b((Object) notificationChannel, "getUserLockedFields", new Object[0])).intValue();
            if (f13314a) {
                a("isUserLockedChannel:" + iIntValue + c.c.a.b.a.a.f3100g + notificationChannel);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("NCHelper", "is user locked error" + e2);
        }
        return iIntValue;
    }

    @TargetApi(26)
    private static NotificationChannel a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m671a(Context context, String str) {
        if (f13314a) {
            a("checkCopeidChannel:newFullChannelId:" + str + "  " + a(context).getBoolean(str, false));
        }
        return a(context).getBoolean(str, false);
    }

    private static void a(Context context, List<String> list) {
        if (f13314a) {
            a("deleteCopiedChannelRecord:" + list);
        }
        if (list.isEmpty()) {
            return;
        }
        SharedPreferences.Editor editorEdit = a(context).edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            editorEdit.remove(it.next());
        }
        editorEdit.apply();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    @TargetApi(26)
    public static String a(af afVar, String str, CharSequence charSequence, String str2, int i2, int i3, String str3, String str4) {
        String strM684a = afVar.m684a(str);
        if (f13314a) {
            a("createChannel: appChannelId:" + strM684a + " serverChannelId:" + str + " serverChannelName:" + ((Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i2 + " serverChannelName:" + ((Object) charSequence) + " serverChannelImportance:" + i3 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        NotificationChannel notificationChannel = new NotificationChannel(strM684a, charSequence, i3);
        notificationChannel.setDescription(str2);
        notificationChannel.enableVibration((i2 & 2) != 0);
        notificationChannel.enableLights((i2 & 4) != 0);
        if ((i2 & 1) != 0) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + afVar.m683a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
        } else {
            notificationChannel.setSound(null, null);
        }
        if (f13314a) {
            a("create channel:" + notificationChannel);
        }
        a(afVar, notificationChannel, str4);
        return strM684a;
    }

    private static void a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m51a("NCHelper", str);
    }

    public static void a(Context context, String str) {
        if (!com.xiaomi.push.j.m627a(context) || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, str);
        f.a(context, str);
    }

    static void a(gs gsVar) {
        Map<String, String> map;
        if (gsVar == null || (map = gsVar.f632a) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        gsVar.f628a = 0;
        gsVar.f632a.remove("channel_id");
        gsVar.f632a.remove("channel_importance");
        gsVar.f632a.remove("channel_name");
        gsVar.f632a.remove("channel_description");
        gsVar.f632a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m50a("delete channel info by:" + gsVar.f632a.get("REMOVE_CHANNEL_MARK"));
        gsVar.f632a.remove("REMOVE_CHANNEL_MARK");
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(26)
    static void a(Context context, af afVar, NotificationChannel notificationChannel, int i2, String str) {
        if (i2 > 0) {
            int iA = com.xiaomi.push.g.a(context) >= 2 ? f.a(context.getPackageName(), str) : 0;
            NotificationChannel notificationChannelA = a(notificationChannel.getId(), notificationChannel);
            if ((i2 & 32) != 0) {
                if (notificationChannel.getSound() != null) {
                    notificationChannelA.setSound(null, null);
                } else {
                    notificationChannelA.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if ((i2 & 16) != 0) {
                if (notificationChannel.shouldVibrate()) {
                    notificationChannelA.enableVibration(false);
                } else {
                    notificationChannelA.enableVibration(true);
                }
            }
            if ((i2 & 8) != 0) {
                if (notificationChannel.shouldShowLights()) {
                    notificationChannelA.enableLights(false);
                } else {
                    notificationChannelA.enableLights(true);
                }
            }
            if ((i2 & 4) != 0) {
                int importance = notificationChannel.getImportance() - 1;
                if (importance <= 0) {
                    importance = 2;
                }
                notificationChannelA.setImportance(importance);
            }
            if ((i2 & 2) != 0) {
                notificationChannelA.setLockscreenVisibility(notificationChannel.getLockscreenVisibility() - 1);
            }
            afVar.a(notificationChannelA);
            afVar.a(notificationChannel, true);
            f.a(afVar.m683a(), notificationChannel.getId(), iA, 0);
            return;
        }
        afVar.a(notificationChannel);
    }
}
