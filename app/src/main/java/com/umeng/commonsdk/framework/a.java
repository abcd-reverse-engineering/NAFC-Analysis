package com.umeng.commonsdk.framework;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: UMNetWorkSender.java */
/* loaded from: classes2.dex */
public class a implements UMImprintChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f10740a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f10741b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f10742c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10743d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static final int f10744e = 273;

    /* renamed from: f, reason: collision with root package name */
    private static final int f10745f = 274;

    /* renamed from: g, reason: collision with root package name */
    private static final int f10746g = 512;

    /* renamed from: h, reason: collision with root package name */
    private static final int f10747h = 769;

    /* renamed from: i, reason: collision with root package name */
    private static FileObserverC0141a f10748i = null;

    /* renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f10749j = null;

    /* renamed from: k, reason: collision with root package name */
    private static IntentFilter f10750k = null;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f10751l = false;

    /* renamed from: m, reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f10752m = null;
    private static final String p = "report_policy";
    private static final String q = "report_interval";
    private static final int s = 15;
    private static final int t = 3;
    private static final int u = 90;
    private static BroadcastReceiver x;
    private static Object n = new Object();
    private static ReentrantLock o = new ReentrantLock();
    private static boolean r = false;
    private static int v = 15;
    private static Object w = new Object();

    /* compiled from: UMNetWorkSender.java */
    /* renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    static class FileObserverC0141a extends FileObserver {
        public FileObserverC0141a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f10749j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f10749j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f10749j != null) {
                f10749j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f10742c = handler;
        try {
            if (f10740a == null) {
                f10740a = new HandlerThread("NetWorkSender");
                f10740a.start();
                if (f10748i == null) {
                    f10748i = new FileObserverC0141a(UMFrUtils.getEnvelopeDirPath(context));
                    f10748i.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f10741b == null) {
                    f10741b = new Handler(f10740a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.3
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == a.f10745f) {
                                a.l();
                            } else {
                                if (i2 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i2;
        synchronized (w) {
            i2 = v;
        }
        return i2;
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        Handler handler;
        if (!f10751l || (handler = f10741b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        f10741b.sendMessage(messageObtainMessage);
    }

    public static void d() {
        if (o.tryLock()) {
            try {
                b(273);
            } finally {
                o.unlock();
            }
        }
    }

    public static void e() {
        a(f10745f, PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    private void j() {
        synchronized (w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = 15;
                int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, "15")).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    v = 15;
                } else {
                    v = iIntValue * 1000;
                }
            } else {
                r = false;
            }
        }
    }

    private static void k() {
        if (f10740a != null) {
            f10740a = null;
        }
        if (f10741b != null) {
            f10741b = null;
        }
        if (f10742c != null) {
            f10742c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (n) {
            if (f10752m != null && (size = f10752m.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    f10752m.get(i2).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f10751l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    v = 15000;
                } else {
                    v = iIntValue * 1000;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
            }
        }
    }

    public static void a(Context context) {
        if (f10749j != null || context == null) {
            return;
        }
        f10749j = (ConnectivityManager) context.getSystemService("connectivity");
        if (f10749j != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void b(Context context) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f10749j != null) {
                    final Context applicationContext = context.getApplicationContext();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f10749j.registerNetworkCallback(networkRequestBuild, new ConnectivityManager.NetworkCallback() { // from class: com.umeng.commonsdk.framework.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onAvailable(Network network2) {
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onCapabilitiesChanged(Network network2, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network2, networkCapabilities);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public void onLost(Network network2) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context2 = applicationContext;
                            UMWorkDispatch.sendEvent(context2, com.umeng.commonsdk.internal.a.E, b.a(context2).a(), null, 2000L);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
            return;
        }
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (f10749j == null || f10750k != null) {
                return;
            }
            f10750k = new IntentFilter();
            f10750k.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(x, f10750k);
                return;
            }
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (n) {
            try {
                if (f10752m == null) {
                    f10752m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < f10752m.size(); i2++) {
                        if (uMSenderStateNotify == f10752m.get(i2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f10752m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static void a(boolean z) {
        int size;
        f10751l = z;
        if (z) {
            synchronized (n) {
                if (f10752m != null && (size = f10752m.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        f10752m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f10751l = false;
    }

    private static void b(int i2) {
        Handler handler;
        if (!f10751l || (handler = f10741b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message messageObtainMessage = f10741b.obtainMessage();
        messageObtainMessage.what = i2;
        f10741b.sendMessage(messageObtainMessage);
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!f10751l || (handler = f10741b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        f10741b.sendMessageDelayed(messageObtainMessage, j2);
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!f10751l || (handler = f10741b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message messageObtainMessage = f10741b.obtainMessage();
        messageObtainMessage.what = i2;
        f10741b.sendMessageDelayed(messageObtainMessage, i3);
    }
}
