package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class e {
    public static e G = new e();

    /* renamed from: a, reason: collision with root package name */
    public static int f8791a;
    public PackageInfo B;
    public SharedPreferences C;
    public DisplayMetrics D;
    public BetaUploadStrategy H;
    public File I;
    public File J;
    public File K;
    public BetaPatchListener Y;
    public boolean af;

    /* renamed from: h, reason: collision with root package name */
    public int f8798h;

    /* renamed from: i, reason: collision with root package name */
    public int f8799i;

    /* renamed from: j, reason: collision with root package name */
    public int f8800j;

    /* renamed from: k, reason: collision with root package name */
    public int f8801k;

    /* renamed from: l, reason: collision with root package name */
    public int f8802l;

    /* renamed from: m, reason: collision with root package name */
    public UILifecycleListener<UpgradeInfo> f8803m;
    public File n;
    public int q;
    public com.tencent.bugly.beta.download.b r;
    public DownloadListener s;
    public File t;
    public Context u;
    public File v;
    public String w;
    public String x;

    /* renamed from: b, reason: collision with root package name */
    public long f8792b = 3000;

    /* renamed from: c, reason: collision with root package name */
    public long f8793c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8794d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8795e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8796f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8797g = true;
    public final List<Class<? extends Activity>> o = new ArrayList();
    public final List<Class<? extends Activity>> p = new ArrayList();
    public int y = Integer.MIN_VALUE;
    public String z = "";
    public String A = "";
    public boolean E = true;
    public boolean F = false;
    public String L = "";
    public String M = "";
    public String N = "";
    public String O = "";
    public boolean P = false;
    public int Q = 0;
    public String R = "";
    public boolean S = false;
    public boolean T = true;
    public boolean U = false;
    public boolean V = false;
    public boolean W = true;
    public boolean X = true;
    public boolean Z = false;
    public boolean aa = true;
    public boolean ab = false;
    public final List<String> ac = new ArrayList();
    public boolean ad = false;
    public boolean ae = false;

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f1 A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0029, B:9:0x0031, B:10:0x0037, B:12:0x004b, B:13:0x0055, B:15:0x0063, B:21:0x0074, B:23:0x0085, B:25:0x008b, B:26:0x0094, B:28:0x00af, B:31:0x00b8, B:33:0x0114, B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:64:0x019f, B:66:0x01df, B:67:0x01e4, B:69:0x01ea, B:70:0x01f2, B:72:0x0202, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180, B:61:0x0196, B:63:0x019c, B:32:0x00f1, B:18:0x006b, B:20:0x0071), top: B:82:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0154 A[Catch: Exception -> 0x0195, all -> 0x020b, TryCatch #1 {Exception -> 0x0195, blocks: (B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180), top: B:80:0x0128, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0029, B:9:0x0031, B:10:0x0037, B:12:0x004b, B:13:0x0055, B:15:0x0063, B:21:0x0074, B:23:0x0085, B:25:0x008b, B:26:0x0094, B:28:0x00af, B:31:0x00b8, B:33:0x0114, B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:64:0x019f, B:66:0x01df, B:67:0x01e4, B:69:0x01ea, B:70:0x01f2, B:72:0x0202, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180, B:61:0x0196, B:63:0x019c, B:32:0x00f1, B:18:0x006b, B:20:0x0071), top: B:82:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0029, B:9:0x0031, B:10:0x0037, B:12:0x004b, B:13:0x0055, B:15:0x0063, B:21:0x0074, B:23:0x0085, B:25:0x008b, B:26:0x0094, B:28:0x00af, B:31:0x00b8, B:33:0x0114, B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:64:0x019f, B:66:0x01df, B:67:0x01e4, B:69:0x01ea, B:70:0x01f2, B:72:0x0202, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180, B:61:0x0196, B:63:0x019c, B:32:0x00f1, B:18:0x006b, B:20:0x0071), top: B:82:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ea A[Catch: all -> 0x020b, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0029, B:9:0x0031, B:10:0x0037, B:12:0x004b, B:13:0x0055, B:15:0x0063, B:21:0x0074, B:23:0x0085, B:25:0x008b, B:26:0x0094, B:28:0x00af, B:31:0x00b8, B:33:0x0114, B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:64:0x019f, B:66:0x01df, B:67:0x01e4, B:69:0x01ea, B:70:0x01f2, B:72:0x0202, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180, B:61:0x0196, B:63:0x019c, B:32:0x00f1, B:18:0x006b, B:20:0x0071), top: B:82:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0202 A[Catch: all -> 0x020b, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0023, B:7:0x0029, B:9:0x0031, B:10:0x0037, B:12:0x004b, B:13:0x0055, B:15:0x0063, B:21:0x0074, B:23:0x0085, B:25:0x008b, B:26:0x0094, B:28:0x00af, B:31:0x00b8, B:33:0x0114, B:40:0x0128, B:42:0x0134, B:44:0x013c, B:46:0x0144, B:48:0x014c, B:64:0x019f, B:66:0x01df, B:67:0x01e4, B:69:0x01ea, B:70:0x01f2, B:72:0x0202, B:50:0x0154, B:52:0x016c, B:54:0x0174, B:56:0x0178, B:58:0x0180, B:61:0x0196, B:63:0x019c, B:32:0x00f1, B:18:0x006b, B:20:0x0071), top: B:82:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.e.a(android.content.Context):void");
    }
}
