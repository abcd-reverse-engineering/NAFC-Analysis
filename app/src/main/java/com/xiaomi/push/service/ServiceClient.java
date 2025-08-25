package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.dy;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fq;
import com.xiaomi.push.fx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: classes2.dex */
public class ServiceClient {

    /* renamed from: a, reason: collision with other field name */
    private static ServiceClient f922a;

    /* renamed from: a, reason: collision with other field name */
    private static String f923a;

    /* renamed from: a, reason: collision with other field name */
    private Context f925a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f928a;

    /* renamed from: b, reason: collision with other field name */
    private Messenger f929b;

    /* renamed from: b, reason: collision with root package name */
    private static String f13269b = fx.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a, reason: collision with root package name */
    private static long f13268a = 0;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f926a = null;

    /* renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f924a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.m150a();
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f927a = new ArrayList();

    /* renamed from: b, reason: collision with other field name */
    private boolean f930b = false;

    private ServiceClient(Context context) {
        this.f928a = false;
        this.f925a = context.getApplicationContext();
        C0343r.a(this.f925a);
        a(this.f925a);
        if (m645a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f928a = true;
        }
    }

    private void b() {
        this.f925a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f925a, (Class<?>) XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f922a == null) {
            f922a = new ServiceClient(context);
        }
        return f922a;
    }

    public static String getSession() {
        return f923a;
    }

    public static void setSession(String str) {
        f923a = str;
    }

    public boolean batchSendMessage(fn[] fnVarArr, boolean z) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent intentA = a();
        Bundle[] bundleArr = new Bundle[fnVarArr.length];
        for (int i2 = 0; i2 < fnVarArr.length; i2++) {
            String strA = dy.a();
            if (!TextUtils.isEmpty(strA)) {
                fl flVar = new fl("pf", null, null, null);
                fl flVar2 = new fl("sent", null, null, null);
                flVar2.m429a(strA);
                flVar.a(flVar2);
                fnVarArr[i2].a(flVar);
            }
            com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVarArr[i2].mo431a());
            bundleArr[i2] = fnVarArr[i2].a();
        }
        if (bundleArr.length <= 0) {
            return false;
        }
        intentA.setAction(an.f13370g);
        intentA.putExtra(an.J, f923a);
        intentA.putExtra("ext_packets", bundleArr);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public void checkAlive() {
        Intent intentA = a();
        intentA.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(intentA);
    }

    public boolean closeChannel() {
        Intent intentA = a();
        intentA.setAction(an.f13372i);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f928a;
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent intentA = a();
        if (bundle == null) {
            return false;
        }
        intentA.setAction(an.o);
        intentA.putExtras(bundle);
        com.xiaomi.channel.commonutils.logger.b.e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(intentA);
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean sendIQ(fm fmVar) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = fmVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fmVar.mo431a());
        intentA.setAction(an.f13369f);
        intentA.putExtra(an.J, f923a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public boolean sendMessage(fn fnVar, boolean z) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent intentA = a();
        String strA = dy.a();
        if (!TextUtils.isEmpty(strA)) {
            fl flVar = new fl("pf", null, null, null);
            fl flVar2 = new fl("sent", null, null, null);
            flVar2.m429a(strA);
            flVar.a(flVar2);
            fnVar.a(flVar);
        }
        Bundle bundleA = fnVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fnVar.mo431a());
        intentA.setAction(an.f13368e);
        intentA.putExtra(an.J, f923a);
        intentA.putExtra("ext_packet", bundleA);
        intentA.putExtra("ext_encrypt", z);
        return startServiceSafely(intentA);
    }

    public boolean sendPresence(fq fqVar) {
        if (!com.xiaomi.push.au.m151a(this.f925a)) {
            return false;
        }
        Intent intentA = a();
        Bundle bundleA = fqVar.a();
        if (bundleA == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fqVar.mo431a());
        intentA.setAction(an.f13371h);
        intentA.putExtra(an.J, f923a);
        intentA.putExtra("ext_packet", bundleA);
        return startServiceSafely(intentA);
    }

    public void setMessenger(Messenger messenger) {
        this.f926a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (com.xiaomi.push.j.m626a() || Build.VERSION.SDK_INT < 26) {
                this.f925a.startService(intent);
                return true;
            }
            m644a(intent);
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.f13373j);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(intentA);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent intentA = a();
        intentA.setAction(an.f13367d);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.f13374k);
        a(intentA, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(intentA);
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent intentA = a();
        intentA.setAction(an.f13375l);
        if (map != null) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intentA.putExtra(an.D, strA);
            }
        }
        if (map2 != null) {
            String strA2 = a(map2);
            if (!TextUtils.isEmpty(strA2)) {
                intentA.putExtra(an.E, strA2);
            }
        }
        intentA.putExtra(an.v, str);
        startServiceSafely(intentA);
    }

    public boolean closeChannel(String str) {
        Intent intentA = a();
        intentA.setAction(an.f13372i);
        intentA.putExtra(an.v, str);
        return startServiceSafely(intentA);
    }

    private void a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                com.xiaomi.push.au.m146a(context);
            } else {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addCategory("android.intent.category.DEFAULT");
                com.xiaomi.push.m.a(context.getApplicationContext(), this.f924a, intentFilter, 2);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("add network status listener failed:" + th);
        }
    }

    public boolean closeChannel(String str, String str2) {
        Intent intentA = a();
        intentA.setAction(an.f13372i);
        intentA.putExtra(an.v, str);
        intentA.putExtra(an.s, str2);
        return startServiceSafely(intentA);
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap map = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    map.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return map;
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.s, str);
        intent.putExtra(an.v, str2);
        intent.putExtra(an.z, str3);
        intent.putExtra(an.B, str5);
        intent.putExtra(an.A, str4);
        intent.putExtra(an.C, z);
        intent.putExtra(an.J, f923a);
        intent.putExtra(an.N, this.f926a);
        if (map != null && map.size() > 0) {
            String strA = a(map);
            if (!TextUtils.isEmpty(strA)) {
                intent.putExtra(an.D, strA);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String strA2 = a(map2);
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        intent.putExtra(an.E, strA2);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String strSubstring;
        if (com.xiaomi.push.au.m151a(this.f925a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent intentA = a();
            if (bArr == null) {
                return false;
            }
            intentA.setAction(an.f13368e);
            intentA.putExtra(an.J, f923a);
            intentA.putExtra("ext_raw_packet", bArr);
            int iIndexOf = str.indexOf("@");
            String strSubstring2 = null;
            String strSubstring3 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring2 = str.substring(iIndexOf + 1, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf + 1);
            } else {
                strSubstring = null;
            }
            intentA.putExtra(an.s, strSubstring3);
            intentA.putExtra(an.t, strSubstring2);
            intentA.putExtra(an.u, strSubstring);
            StringBuilder sb = new StringBuilder();
            sb.append(f13269b);
            long j2 = f13268a;
            f13268a = 1 + j2;
            sb.append(j2);
            String string = sb.toString();
            intentA.putExtra("ext_pkt_id", string);
            intentA.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + string);
            return startServiceSafely(intentA);
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(entry.getValue());
            if (i2 < map.size()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i2++;
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m645a() throws PackageManager.NameNotFoundException {
        if (com.xiaomi.push.x.f1108a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f925a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m641a() {
        try {
            return this.f925a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m641a());
            intent.putExtra(an.F, this.f925a.getPackageName());
            m643a();
            return intent;
        }
        Intent intent2 = new Intent(this.f925a, (Class<?>) XMPushService.class);
        intent2.putExtra(an.F, this.f925a.getPackageName());
        b();
        return intent2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m643a() {
        this.f925a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f925a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* renamed from: a, reason: collision with other method in class */
    private synchronized void m644a(Intent intent) {
        if (this.f930b) {
            Message messageA = a(intent);
            if (this.f927a.size() >= 50) {
                this.f927a.remove(0);
            }
            this.f927a.add(messageA);
            return;
        }
        if (this.f929b == null) {
            this.f925a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f929b = new Messenger(iBinder);
                        ServiceClient.this.f930b = false;
                        Iterator it = ServiceClient.this.f927a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f929b.send((Message) it.next());
                            } catch (RemoteException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        ServiceClient.this.f927a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f929b = null;
                    ServiceClient.this.f930b = false;
                }
            }, 1);
            this.f930b = true;
            this.f927a.clear();
            this.f927a.add(a(intent));
        } else {
            try {
                this.f929b.send(a(intent));
            } catch (RemoteException unused) {
                this.f929b = null;
                this.f930b = false;
            }
        }
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }
}
