package i.e.b.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import bean.SurveyH5Bean;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: IdentifierIdClient.java */
/* loaded from: classes2.dex */
public class c {
    private static boolean A = false;
    private static int B = 13;
    private static d C = null;
    private static d D = null;
    private static d E = null;
    private static d F = null;
    private static HandlerThread G = null;
    private static Handler H = null;
    private static String I = null;
    private static String J = null;
    private static String K = null;
    private static String L = null;
    private static String M = null;
    private static String N = null;
    private static String O = null;
    private static volatile c P = null;
    private static volatile i.e.b.d.a.b Q = null;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;
    private static int a0 = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f16951b = "VMS_SDK_Client";
    private static int b0 = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final String f16952c = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static int c0 = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final String f16953d = "persist.sys.identifierid.supported";

    /* renamed from: e, reason: collision with root package name */
    public static final String f16954e = "persist.sys.identifierid";

    /* renamed from: f, reason: collision with root package name */
    private static final String f16955f = "com.vivo.vms";

    /* renamed from: g, reason: collision with root package name */
    private static final String f16956g = "appid";

    /* renamed from: h, reason: collision with root package name */
    private static final String f16957h = "type";

    /* renamed from: i, reason: collision with root package name */
    private static final String f16958i = "OAID";

    /* renamed from: j, reason: collision with root package name */
    private static final String f16959j = "VAID";

    /* renamed from: k, reason: collision with root package name */
    private static final String f16960k = "OAIDSTATUS";

    /* renamed from: l, reason: collision with root package name */
    private static Object f16961l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private static final int f16962m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 7;
    private static final int u = 8;
    private static final int v = 9;
    private static final int w = 10;
    private static final int x = 11;
    private static final int y = 2000;
    private static Context z;

    /* renamed from: a, reason: collision with root package name */
    private final int f16963a;

    /* compiled from: IdentifierIdClient.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.R + c.S + c.X + c.a0 + c.T + c.U + c.Z + c.a0 + c.V + c.W + c.b0 + c.c0 > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", c.this.a(c.R, c.S, c.X, c.Y));
                contentValues.put("vaid", c.this.a(c.T, c.U, c.Z, c.a0));
                contentValues.put("aaid", c.this.a(c.V, c.W, c.b0, c.c0));
                c.Q.a(7, "vivo", new ContentValues[]{contentValues});
                int unused = c.R = c.S = c.T = c.U = c.V = c.W = 0;
                int unused2 = c.X = c.Y = c.Z = c.a0 = c.b0 = c.c0 = 0;
            }
        }
    }

    /* compiled from: IdentifierIdClient.java */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message.what == 11) {
                int i2 = message.getData().getInt("type");
                try {
                    String strA = c.Q.a(i2, message.getData().getString("appid"));
                    if (i2 == 0) {
                        String unused = c.I = strA;
                        c.c(8, c.I);
                    } else if (i2 == 1) {
                        if (strA != null) {
                            String unused2 = c.J = strA;
                        }
                        c.c(9, c.J);
                    } else if (i2 == 2) {
                        if (strA != null) {
                            String unused3 = c.K = strA;
                        }
                        c.c(10, c.K);
                    } else if (i2 != 3) {
                        if (i2 == 4) {
                            String unused4 = c.M = strA;
                        } else if (i2 == 5 && strA != null) {
                            String unused5 = c.N = strA;
                        }
                    } else if (strA != null) {
                        String unused6 = c.L = strA;
                    }
                } catch (Exception e2) {
                    String str = "readException:" + e2.toString();
                }
                synchronized (c.f16961l) {
                    c.f16961l.notify();
                }
            }
        }
    }

    private c() {
        n();
        Q = new i.e.b.d.a.b(z);
        this.f16963a = c(z);
    }

    private void m() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    private static void n() {
        G = new HandlerThread("SqlWorkThread");
        G.start();
        H = new b(G.getLooper());
    }

    private static void o() {
        A = "1".equals(a(f16953d, "0")) || "1".equals(a(f16954e, "0"));
    }

    static boolean p() {
        if (!A) {
            o();
        }
        return A;
    }

    String g() {
        String str = K;
        if (str != null) {
            c(2, str);
            return K;
        }
        d(2, "vivo");
        if (E == null) {
            a(z, 2, "vivo");
        }
        c(2, K);
        return K;
    }

    String h() {
        e(4, null);
        return M;
    }

    String i() {
        String str = N;
        if (str != null) {
            return str;
        }
        e(5, "vivo");
        return N;
    }

    String j() {
        String str = N;
        if (str != null) {
            return str;
        }
        d(5, "vivo");
        return N;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f16955f, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    String d() {
        String str = J;
        if (str != null) {
            c(1, str);
            return J;
        }
        e(1, "vivo");
        if (D == null) {
            a(z, 1, "vivo");
        }
        c(1, J);
        return J;
    }

    String e() {
        String str = J;
        if (str != null) {
            c(1, str);
            return J;
        }
        d(1, "vivo");
        if (D == null) {
            a(z, 1, "vivo");
        }
        c(1, J);
        return J;
    }

    String f() {
        String str = K;
        if (str != null) {
            c(2, str);
            return K;
        }
        e(2, "vivo");
        if (E == null) {
            a(z, 2, "vivo");
        }
        c(2, K);
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    static c b(Context context) {
        if (p()) {
            return a(context);
        }
        return null;
    }

    static c a(Context context) {
        if (z == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            z = context;
        }
        if (P == null) {
            synchronized (c.class) {
                if (P == null) {
                    P = new c();
                    P.m();
                }
            }
        }
        return P;
    }

    String b() {
        String str = I;
        if (str != null) {
            c(0, str);
            return I;
        }
        e(0, null);
        if (C == null) {
            a(z, 0, null);
        }
        c(0, I);
        return I;
    }

    String c() {
        String str = I;
        if (str != null) {
            c(0, str);
            return I;
        }
        d(0, null);
        if (C == null) {
            a(z, 0, null);
        }
        c(0, I);
        return I;
    }

    private void d(int i2, String str) {
        a(i2, str);
    }

    private void e(int i2, String str) {
        synchronized (f16961l) {
            a(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f16961l.wait(2000L);
            } catch (InterruptedException unused) {
            }
            int i3 = ((SystemClock.uptimeMillis() - jUptimeMillis) > 2000L ? 1 : ((SystemClock.uptimeMillis() - jUptimeMillis) == 2000L ? 0 : -1));
        }
    }

    List b(List<String> list) {
        if (this.f16963a >= B && list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String[] strArrSplit = list.get(i2).split(Constants.COLON_SEPARATOR);
                    if (strArrSplit.length == 2) {
                        arrayList.add(Boolean.valueOf(Q.a(6, "vivo", strArrSplit[0], strArrSplit[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                S++;
                return;
            } else {
                R++;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                U++;
                return;
            } else {
                T++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                W++;
                return;
            } else {
                V++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    X++;
                    break;
                } else {
                    Y++;
                    break;
                }
            case 9:
                if (str != null) {
                    Z++;
                    break;
                } else {
                    a0++;
                    break;
                }
            case 10:
                if (str != null) {
                    b0++;
                    break;
                } else {
                    c0++;
                    break;
                }
        }
    }

    String a() {
        String str = L;
        if (str != null) {
            return str;
        }
        e(3, null);
        return L;
    }

    boolean a(List<String> list) {
        if (this.f16963a >= B && list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ContentValues contentValues = new ContentValues();
                    String[] strArrSplit = list.get(i2).split(Constants.COLON_SEPARATOR);
                    if (strArrSplit.length != 2) {
                        return false;
                    }
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    contentValues.put(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, str2);
                    contentValues.put("uid", str3);
                    contentValues.put(SurveyH5Bean.VALUE, str);
                    contentValuesArr[i2] = contentValues;
                }
                return Q.a(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    void a(int i2, String str) {
        Message messageObtainMessage = H.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        H.sendMessage(messageObtainMessage);
    }

    private static String a(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                String str3 = "getProperty: invoke is error" + e2.getMessage();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static synchronized void a(Context context, int i2, String str) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (E == null) {
                        E = new d(P, 2, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, E);
                    }
                }
            } else if (D == null) {
                D = new d(P, 1, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, D);
            }
        } else if (C == null) {
            C = new d(P, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, C);
        }
    }
}
