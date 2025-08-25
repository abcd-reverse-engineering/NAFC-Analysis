package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import c.e.a.a;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.f;
import com.heytap.mcssdk.h.d;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.statis.StatisticUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements e {
    private static final String A = "globalID";
    private static final String B = "supportOpenPush";
    private static final String C = "versionName";
    private static final String D = "versionCode";
    private static final String E = "pushSdkVersion";
    public static final String F = "miniProgramPkg";
    private static final int G = 23;
    private static final int H = 59;
    private static final int I = 24;
    private static final int J = 1000;
    private static final int K = 2;
    private static String M = null;
    private static boolean N = false;

    /* renamed from: l, reason: collision with root package name */
    private static final String f5761l = "a";

    /* renamed from: m, reason: collision with root package name */
    private static final int f5762m = 32;
    private static final String r = "Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ==";
    private static final String s = "type";
    private static final int t = 1019;
    private static final String u = "eventID";
    private static final String v = "taskID";
    private static final String w = "appPackage";
    private static final String x = "extra";
    private static final String y = "messageType";
    private static final String z = "messageID";

    /* renamed from: a, reason: collision with root package name */
    private Context f5763a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.heytap.mcssdk.i.c> f5764b;

    /* renamed from: c, reason: collision with root package name */
    private List<d> f5765c;

    /* renamed from: d, reason: collision with root package name */
    private String f5766d;

    /* renamed from: e, reason: collision with root package name */
    private String f5767e;

    /* renamed from: f, reason: collision with root package name */
    private String f5768f;

    /* renamed from: g, reason: collision with root package name */
    private ICallBackResultService f5769g;

    /* renamed from: h, reason: collision with root package name */
    private ISetAppNotificationCallBackService f5770h;

    /* renamed from: i, reason: collision with root package name */
    private IGetAppNotificationCallBackService f5771i;

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<Integer, f.b> f5772j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5773k;
    private static final int[] n = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] o = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static final int[] p = {99, 111, 109, 46, 104, 101, 121, 116, 97, 112, 46, 109, 99, 115};
    private static String q = "";
    private static int L = 0;

    /* renamed from: com.heytap.mcssdk.a$a, reason: collision with other inner class name */
    class ServiceConnectionC0093a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f5774a;

        ServiceConnectionC0093a(Intent intent) {
            this.f5774a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.f5774a.getExtras());
            try {
                a.b.a(iBinder).a(bundle);
            } catch (Exception e2) {
                g.b("bindMcsService exception:" + e2);
            }
            a.this.f5763a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f5776a = new a(null);

        private b() {
        }
    }

    private a() {
        this.f5764b = new ArrayList();
        this.f5765c = new ArrayList();
        this.f5768f = null;
        this.f5773k = true;
        synchronized (a.class) {
            if (L > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            L++;
        }
        a(new com.heytap.mcssdk.h.b());
        a(new com.heytap.mcssdk.h.a());
        a(new com.heytap.mcssdk.i.b());
        a(new com.heytap.mcssdk.i.a());
        this.f5772j = new ConcurrentHashMap<>();
    }

    /* synthetic */ a(ServiceConnectionC0093a serviceConnectionC0093a) {
        this();
    }

    private Intent a(int i2, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(b(this.f5763a));
        intent.setPackage(a(this.f5763a));
        intent.putExtra("type", i2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt(C, com.heytap.mcssdk.k.c.b(this.f5763a, this.f5763a.getPackageName()));
            jSONObject2.putOpt(D, Integer.valueOf(com.heytap.mcssdk.k.c.a(this.f5763a, this.f5763a.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra(x, jSONObject2.toString());
            throw th;
        }
        intent.putExtra(x, jSONObject2.toString());
        intent.putExtra(com.heytap.mcssdk.constant.b.D, str);
        intent.putExtra("appPackage", this.f5763a.getPackageName());
        intent.putExtra("appKey", this.f5766d);
        intent.putExtra(com.heytap.mcssdk.constant.b.A, this.f5767e);
        intent.putExtra(com.heytap.mcssdk.constant.b.B, this.f5768f);
        intent.putExtra("sdkVersion", y());
        return intent;
    }

    private synchronized void a(d dVar) {
        if (dVar != null) {
            this.f5765c.add(dVar);
        }
    }

    private synchronized void a(com.heytap.mcssdk.i.c cVar) {
        if (cVar != null) {
            this.f5764b.add(cVar);
        }
    }

    private boolean a(f.b bVar) {
        long jA = bVar.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        g.b("checkTimeNeedUpdate : lastedTime " + jA + " currentTime:" + jCurrentTimeMillis);
        return jCurrentTimeMillis - jA > 1000;
    }

    private void b(int i2, String str, JSONObject jSONObject) {
        if (c(i2)) {
            if (this.f5769g != null) {
                this.f5769g.onError(d(i2), "api_call_too_frequently", this.f5763a.getPackageName(), j(jSONObject));
                return;
            }
            return;
        }
        try {
            this.f5763a.startService(a(i2, str, jSONObject));
        } catch (Exception e2) {
            g.e("startMcsService--Exception" + e2.getMessage());
        }
    }

    private void b(int i2, JSONObject jSONObject) {
        b(i2, "", jSONObject);
    }

    private f.b e(int i2) {
        String str;
        if (!this.f5772j.containsKey(Integer.valueOf(i2))) {
            f.b bVar = new f.b(System.currentTimeMillis(), 1);
            this.f5772j.put(Integer.valueOf(i2), bVar);
            g.b("addCommandToMap :appBean is null");
            return bVar;
        }
        f.b bVar2 = this.f5772j.get(Integer.valueOf(i2));
        if (a(bVar2)) {
            bVar2.a(1);
            bVar2.a(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            bVar2.a(bVar2.b() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        g.b(str);
        return bVar2;
    }

    private String e(Context context) {
        g.b(f5761l, "getMcsPackageNameInner -- ");
        if (Build.VERSION.SDK_INT >= 24) {
            PackageManager packageManager = context.getPackageManager();
            try {
                try {
                    String strA = com.heytap.mcssdk.k.c.a(p);
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(strA, 0);
                    if (applicationInfo != null) {
                        boolean z2 = (applicationInfo.flags & 1) == 1;
                        boolean z3 = packageManager.getPackageUid(strA, 0) == packageManager.getPackageUid(DispatchConstants.ANDROID, 0);
                        if (z2 || z3) {
                            return strA;
                        }
                    }
                    return null;
                } catch (PackageManager.NameNotFoundException e2) {
                    g.e(f5761l, "NameNotFoundException in get mcs package name:" + e2.getMessage());
                } catch (Exception e3) {
                    g.e(f5761l, "Error in get mcs package name:" + e3.getMessage());
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private boolean f(Context context) {
        if (this.f5763a == null) {
            this.f5763a = context.getApplicationContext();
        }
        String strA = a(this.f5763a);
        boolean z2 = com.heytap.mcssdk.k.c.c(this.f5763a, strA) && com.heytap.mcssdk.k.c.a(this.f5763a, strA) >= 1019 && com.heytap.mcssdk.k.c.a(this.f5763a, strA, B);
        g.b(f5761l, "isSupportPushInner -- " + z2);
        return z2;
    }

    @Deprecated
    private static void g(Context context) {
        com.heytap.mcssdk.k.b.a(context, new MessageStat(context.getPackageName(), "app_start", null));
    }

    private boolean t() {
        return u() && v();
    }

    private boolean u() {
        return this.f5763a != null;
    }

    private boolean v() {
        return this.f5768f != null;
    }

    public static a w() {
        return b.f5776a;
    }

    public static int x() {
        return c.f5794e;
    }

    public static String y() {
        return c.f5795f;
    }

    public a a(Context context, boolean z2) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        c(context);
        new com.heytap.mcssdk.d.a().a(this.f5763a);
        g.f(z2);
        return this;
    }

    public String a(Context context) {
        boolean z2;
        if (M == null) {
            String strE = e(context);
            if (strE == null) {
                M = com.heytap.mcssdk.k.c.a(n);
                z2 = false;
            } else {
                M = strE;
                z2 = true;
            }
            N = z2;
        }
        return M;
    }

    @Override // com.heytap.mcssdk.e
    public void a() {
        g((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(int i2) {
        a(i2, (JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(int i2, JSONObject jSONObject) {
        if (!t()) {
            g.e(g.f5899a, "please call the register first!");
            return;
        }
        b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE, i2 + "", jSONObject);
    }

    @Override // com.heytap.mcssdk.e
    public void a(Context context, String str, String str2, ICallBackResultService iCallBackResultService) throws JSONException {
        a(context, str, str2, (JSONObject) null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.e
    public void a(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) throws JSONException {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.f5763a == null) {
            this.f5763a = context.getApplicationContext();
        }
        if (!com.heytap.mcssdk.k.c.c(this.f5763a)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null, null, null);
                return;
            }
            return;
        }
        if (this.f5773k) {
            g.b("registerAction:", "Will static push_register event :");
            StatisticUtils.statisticEvent(this.f5763a, "push_register");
            this.f5773k = false;
        }
        this.f5766d = str;
        this.f5767e = str2;
        this.f5769g = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt(Constants.KEY_APP_VERSION_CODE, Integer.valueOf(com.heytap.mcssdk.k.c.a(context)));
            jSONObject.putOpt(Constants.KEY_APP_VERSION_NAME, com.heytap.mcssdk.k.c.b(context));
        } catch (JSONException e2) {
            g.e("register-Exception:" + e2.getMessage());
        }
        b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
    }

    public void a(ICallBackResultService iCallBackResultService) {
        this.f5769g = iCallBackResultService;
    }

    @Override // com.heytap.mcssdk.e
    public void a(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (u()) {
            this.f5771i = iGetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET, null);
        } else {
            IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.f5771i;
            if (iGetAppNotificationCallBackService2 != null) {
                iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
            }
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (u()) {
            this.f5770h = iSetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (n() != null) {
            this.f5770h.onSetAppNotificationSwitch(-2);
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(String str) {
        this.f5768f = str;
    }

    public void a(String str, String str2) {
        this.f5766d = str;
        this.f5767e = str2;
    }

    @Override // com.heytap.mcssdk.e
    public void a(List<Integer> list, int i2, int i3, int i4, int i5) throws JSONException {
        a(list, i2, i3, i4, i5, null);
    }

    @Override // com.heytap.mcssdk.e
    public void a(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) throws JSONException {
        if (!t()) {
            if (n() != null) {
                n().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i2 < 0 || i3 < 0 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", f.c.a(list));
            jSONObject2.put("startHour", i2);
            jSONObject2.put("startMin", i3);
            jSONObject2.put("endHour", i4);
            jSONObject2.put("endMin", i5);
            b(MessageConstant.CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
        } catch (JSONException e2) {
            g.e(g.f5899a, e2.getLocalizedMessage());
        }
    }

    @Override // com.heytap.mcssdk.e
    public void a(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    public String b(Context context) {
        if (M == null) {
            e(context);
        }
        if (!N) {
            return com.heytap.mcssdk.k.c.a(o);
        }
        if (TextUtils.isEmpty(q)) {
            q = new String(com.heytap.mcssdk.b.a.d(r));
        }
        return q;
    }

    @Override // com.heytap.mcssdk.e
    public void b() {
        e((JSONObject) null);
    }

    public void b(int i2) {
        if (!c(i2)) {
            Intent intentA = a(i2, "", null);
            this.f5763a.bindService(intentA, new ServiceConnectionC0093a(intentA), 1);
        } else {
            ICallBackResultService iCallBackResultService = this.f5769g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(d(i2), "api_call_too_frequently", this.f5763a.getPackageName(), "");
            }
        }
    }

    public void b(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.f5766d = str;
        this.f5767e = str2;
        this.f5763a = context.getApplicationContext();
        this.f5769g = iCallBackResultService;
        h(jSONObject);
    }

    @Override // com.heytap.mcssdk.e
    public void b(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (u()) {
            this.f5770h = iSetAppNotificationCallBackService;
            b(MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
        } else {
            ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.f5770h;
            if (iSetAppNotificationCallBackService2 != null) {
                iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.e
    public void b(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void c() {
        f((JSONObject) null);
    }

    public void c(Context context) {
        boolean z2;
        this.f5763a = context.getApplicationContext();
        if (M == null) {
            String strE = e(context);
            if (strE == null) {
                M = com.heytap.mcssdk.k.c.a(n);
                z2 = false;
            } else {
                M = strE;
                z2 = true;
            }
            N = z2;
        }
    }

    @Override // com.heytap.mcssdk.e
    public void c(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    public boolean c(int i2) {
        return (i2 == 12291 || i2 == 12312 || e(i2).b() <= 2) ? false : true;
    }

    public int d(int i2) {
        switch (i2) {
            case MessageConstant.CommandId.COMMAND_REGISTER /* 12289 */:
                return -1;
            case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i2) {
                    case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case MessageConstant.CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i2) {
                            case MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant.CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i2) {
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    @Override // com.heytap.mcssdk.e
    public String d() {
        return this.f5768f;
    }

    @Override // com.heytap.mcssdk.e
    public void d(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_CANCEL_NOTIFICATION, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    public boolean d(Context context) {
        return f(context);
    }

    @Override // com.heytap.mcssdk.e
    public void e() {
        if (Build.VERSION.SDK_INT < 32) {
            if (u()) {
                b(MessageConstant.CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
                return;
            } else {
                g.e(g.f5899a, "please call the register first!");
                return;
            }
        }
        g.b(f5761l, "requestNotificationPermission() will return due to Android T device , current device Android SDK version code is :" + Build.VERSION.SDK_INT);
    }

    @Override // com.heytap.mcssdk.e
    public void e(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (n() != null) {
            n().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.e
    public void f() {
        a((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void f(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void g() {
        b((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void g(JSONObject jSONObject) {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            g.e(g.f5899a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.e
    public void h() {
        i(null);
    }

    @Override // com.heytap.mcssdk.e
    public void h(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (n() != null) {
            n().onUnRegister(-2, this.f5763a.getPackageName(), j(jSONObject));
        }
    }

    @Override // com.heytap.mcssdk.e
    public void i() {
        c((JSONObject) null);
    }

    @Override // com.heytap.mcssdk.e
    public void i(JSONObject jSONObject) {
        if (u()) {
            b(MessageConstant.CommandId.COMMAND_REGISTER, jSONObject);
        } else if (n() != null) {
            n().onRegister(-2, null, null, null);
        }
    }

    public String j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            try {
                return jSONObject.optString("miniProgramPkg");
            } catch (Exception e2) {
                g.b("Error happened in getMiniProgramPkgFromJSON() :" + e2.getMessage());
                return "";
            }
        } catch (Throwable unused) {
            return "";
        }
    }

    public Map<Integer, f.b> j() {
        return this.f5772j;
    }

    public Context k() {
        return this.f5763a;
    }

    public List<d> l() {
        return this.f5765c;
    }

    public List<com.heytap.mcssdk.i.c> m() {
        return this.f5764b;
    }

    public ICallBackResultService n() {
        return this.f5769g;
    }

    public IGetAppNotificationCallBackService o() {
        return this.f5771i;
    }

    public ISetAppNotificationCallBackService p() {
        return this.f5770h;
    }

    public void q() {
        if (t()) {
            b(MessageConstant.CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (n() != null) {
            n().onGetPushStatus(-2, 0);
        }
    }

    public int r() {
        if (!u()) {
            return 0;
        }
        Context context = this.f5763a;
        return com.heytap.mcssdk.k.c.a(context, a(context));
    }

    public String s() {
        if (!u()) {
            return "";
        }
        Context context = this.f5763a;
        return com.heytap.mcssdk.k.c.b(context, a(context));
    }

    @Override // com.heytap.mcssdk.e
    public void unRegister() {
        h(null);
    }
}
