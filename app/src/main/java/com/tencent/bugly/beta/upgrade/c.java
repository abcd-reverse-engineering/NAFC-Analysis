package com.tencent.bugly.beta.upgrade;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.bj;
import com.tencent.bugly.proguard.bk;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;
import java.io.File;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static c f8860a = new c();

    /* renamed from: b, reason: collision with root package name */
    public BetaGrayStrategy f8861b;

    /* renamed from: c, reason: collision with root package name */
    public DownloadTask f8862c;

    /* renamed from: d, reason: collision with root package name */
    public DownloadListener f8863d;

    /* renamed from: e, reason: collision with root package name */
    public UpgradeListener f8864e;

    /* renamed from: f, reason: collision with root package name */
    public UpgradeStateListener f8865f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8866g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8867h;

    /* renamed from: i, reason: collision with root package name */
    public d f8868i;

    /* renamed from: j, reason: collision with root package name */
    public d f8869j;

    /* renamed from: k, reason: collision with root package name */
    public int f8870k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f8871l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private final Object f8872m = new Object();
    private DownloadListener n = new com.tencent.bugly.beta.download.a(3, this, 0);
    private a o = null;
    private d p;
    private boolean q;
    private int r;

    private DownloadTask b() {
        y yVarA = a();
        if (yVarA == null) {
            return null;
        }
        if (this.f8862c == null) {
            e eVar = e.G;
            this.f8862c = eVar.r.a(yVarA.f9480f.f9445b, eVar.v.getAbsolutePath(), null, this.f8861b.f8848a.f9480f.f9444a);
            this.f8862c.setDownloadType(1);
        }
        return this.f8862c;
    }

    private void c() {
        y yVarA = a();
        if (yVarA == null) {
            return;
        }
        if (this.f8862c == null) {
            this.f8862c = b();
        }
        if (this.f8862c == null) {
            return;
        }
        a(this.f8861b);
        BetaReceiver.addTask(this.f8862c);
        if (this.f8862c.getStatus() != 1 || this.f8867h) {
            this.f8862c.download();
        } else if (this.f8866g && com.tencent.bugly.beta.global.a.a(e.G.u, this.f8862c.getSaveFile(), yVarA.f9480f.f9444a)) {
            p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, yVarA.f9479e, yVarA.f9487m, yVarA.p, null));
        } else {
            a(this.f8866g);
        }
    }

    public BetaGrayStrategy a(y yVar) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        y yVar2 = yVar;
        synchronized (this.f8871l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f8848a == null) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f8848a != null && (betaGrayStrategy3.f8848a.f9479e.f9452c < e.G.y || ((betaGrayStrategy3.f8848a.f9479e.f9452c == e.G.y && betaGrayStrategy3.f8848a.f9479e.f9454e <= e.G.q) || betaGrayStrategy3.f8848a.n != 1 || (betaGrayStrategy3.f8848a.f9480f != null && TextUtils.equals(e.G.x, betaGrayStrategy3.f8848a.f9480f.f9444a))))) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                this.f8862c = null;
                betaGrayStrategy3 = null;
            }
            if (yVar2 != null && (yVar2.f9479e.f9452c < e.G.y || (yVar2.f9479e.f9452c == e.G.y && yVar2.f9479e.f9454e <= e.G.q))) {
                an.a("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(yVar2.f9479e.f9452c), Integer.valueOf(yVar2.f9479e.f9454e), Integer.valueOf(e.G.y), Integer.valueOf(e.G.q));
                yVar2 = null;
            }
            if (yVar2 != null) {
                if (yVar2.n == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f8848a != null && !TextUtils.isEmpty(yVar2.f9487m) && !TextUtils.isEmpty(betaGrayStrategy3.f8848a.f9487m) && TextUtils.equals(yVar2.f9487m, betaGrayStrategy3.f8848a.f9487m)) {
                    an.a("撤回 strategy: %s", yVar2.f9487m);
                    betaGrayStrategy3 = null;
                }
                if (yVar2.n != 1) {
                    an.a("invalid strategy: %s", yVar2.f9487m);
                    yVar2 = null;
                }
            }
            if (yVar2 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f8848a == null || TextUtils.isEmpty(yVar2.f9487m) || TextUtils.isEmpty(betaGrayStrategy3.f8848a.f9487m) || !TextUtils.equals(yVar2.f9487m, betaGrayStrategy3.f8848a.f9487m)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    BetaGrayStrategy betaGrayStrategy4 = new BetaGrayStrategy(aq.d(aq.a(betaGrayStrategy3)));
                    an.a("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", yVar2.f9487m, betaGrayStrategy3.f8848a.f9487m, Integer.valueOf(betaGrayStrategy4.f8849b), Long.valueOf(yVar2.f9483i));
                    betaGrayStrategy2 = betaGrayStrategy4;
                }
                betaGrayStrategy2.f8848a = yVar2;
                betaGrayStrategy2.f8852e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.f8848a.f9480f.f9445b.equals(yVar2.f9480f.f9445b)) {
                    if (this.f8862c == null) {
                        this.f8862c = e.G.r.a(betaGrayStrategy3.f8848a.f9480f.f9445b, e.G.v.getAbsolutePath(), null, null);
                        this.f8862c.setDownloadType(1);
                        this.f8862c.delete(true);
                        for (File file : e.G.v.listFiles()) {
                            if (!file.delete()) {
                                an.e("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                        this.f8862c = null;
                    } else {
                        BetaReceiver.netListeners.remove(this.f8862c.getDownloadUrl());
                        this.f8862c.delete(true);
                        this.f8862c = null;
                    }
                }
                a(betaGrayStrategy2);
                an.a("onUpgradeReceived: %s [type: %d]", yVar2, Integer.valueOf(yVar2.f9481g));
                p.f9423a.a(new w("rcv", System.currentTimeMillis(), (byte) 0, 0L, yVar2.f9479e, yVar2.f9487m, yVar2.p, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    public void a(boolean z, boolean z2, int i2, y yVar, String str) {
        synchronized (this.f8871l) {
            this.f8862c = null;
            this.f8861b = a(yVar);
            this.f8866g = z;
            this.f8867h = z2;
            if (this.f8864e != null) {
                an.a("你已放弃让SDK来处理策略", new Object[0]);
                this.f8870k = 3;
                if (this.f8861b == null) {
                    an.a("betaStrategy is null", new Object[0]);
                    com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
                    return;
                }
                if (this.f8861b.f8848a != null && !z && (this.f8861b.f8850c + this.f8861b.f8848a.f9483i > System.currentTimeMillis() || this.f8861b.f8848a.f9482h - this.f8861b.f8849b <= 0)) {
                    return;
                }
                if (this.f8861b != null && this.f8862c == null) {
                    this.f8862c = e.G.r.a(this.f8861b.f8848a.f9480f.f9445b, e.G.v.getAbsolutePath(), null, this.f8861b.f8848a.f9480f.f9444a);
                    this.f8862c.setDownloadType(1);
                }
                if (this.f8862c == null) {
                    an.a("用户自定义activity，创建task失败 [strategy:%s]", this.f8861b);
                    this.f8861b = null;
                    com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                } else {
                    this.f8862c.addListener(this.n);
                }
                com.tencent.bugly.beta.utils.e.a(new d(16, this.f8864e, Integer.valueOf(i2), this.f8861b, Boolean.valueOf(z), Boolean.valueOf(z2)));
            }
            if (i2 != 0 && z && !z2 && this.f8861b == null) {
                if (this.f8865f != null) {
                    com.tencent.bugly.beta.utils.e.a(new d(18, this.f8865f, -1, Boolean.valueOf(z)));
                } else {
                    com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastCheckUpgradeError));
                }
                return;
            }
            if (this.f8861b != null && this.f8861b.f8848a != null) {
                if (this.f8862c == null) {
                    this.f8862c = b();
                }
                this.f8862c.addListener(this.n);
                if (this.f8865f != null) {
                    com.tencent.bugly.beta.utils.e.a(new d(18, this.f8865f, 0, Boolean.valueOf(z)));
                }
                if (this.f8864e != null) {
                    return;
                }
                if (!z && this.f8861b.f8848a.f9481g != 2) {
                    if (this.f8861b.f8851d && e.G.f8797g) {
                        if ((com.tencent.bugly.beta.global.a.a(e.G.u) == 1 && e.G.U) || (com.tencent.bugly.beta.global.a.a(e.G.u) == 4 && e.G.V)) {
                            c();
                            return;
                        } else {
                            if (!z2) {
                                a(z);
                            }
                            return;
                        }
                    }
                    if (this.f8861b.f8850c + this.f8861b.f8848a.f9483i > System.currentTimeMillis() || this.f8861b.f8848a.f9482h - this.f8861b.f8849b <= 0 || this.f8861b.f8848a.f9481g == 3) {
                        return;
                    }
                }
                if (((com.tencent.bugly.beta.global.a.a(e.G.u) == 1 && e.G.U) || (com.tencent.bugly.beta.global.a.a(e.G.u) == 4 && e.G.V)) && !z) {
                    c();
                } else if (!z2) {
                    a(z);
                }
            } else if (this.f8865f != null) {
                com.tencent.bugly.beta.utils.e.a(new d(18, this.f8865f, 1, Boolean.valueOf(z)));
            } else if (z && !z2) {
                com.tencent.bugly.beta.utils.e.a(new d(5, Beta.strToastYourAreTheLatestVersion));
            }
        }
    }

    private y a() {
        BetaGrayStrategy betaGrayStrategy = this.f8861b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f8848a;
    }

    private void a(boolean z) {
        y yVarA = a();
        if (yVarA == null) {
            return;
        }
        if (System.currentTimeMillis() <= yVarA.a() - 86400000) {
            an.e(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        f.f8804a.a(e.G.r, yVarA.f9486l);
        if (this.f8862c == null) {
            this.f8862c = b();
        }
        DownloadTask downloadTask = this.f8862c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            an.a("Task is downloading %s %s", yVarA.f9487m, this.f8862c.getDownloadUrl());
            return;
        }
        this.f8862c.addListener(this.n);
        DownloadListener downloadListener = this.f8863d;
        if (downloadListener != null) {
            this.f8862c.addListener(downloadListener);
        }
        h hVar = h.v;
        hVar.a(yVarA, this.f8862c);
        hVar.r = new d(3, this.f8861b, this.f8862c);
        hVar.s = new d(4, this.f8861b, this.f8862c, Boolean.valueOf(z));
        this.f8861b.f8850c = System.currentTimeMillis();
        a(this.f8861b);
        if (z) {
            f.f8804a.a(new d(2, hVar, Boolean.valueOf(z)), PathInterpolatorCompat.MAX_NUM_POINTS);
            return;
        }
        f fVar = f.f8804a;
        Object[] objArr = new Object[2];
        objArr[0] = hVar;
        objArr[1] = Boolean.valueOf(z || yVarA.f9481g == 2);
        fVar.a(new d(2, objArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:4:0x001c, B:6:0x002d, B:37:0x0086, B:39:0x008b, B:41:0x0091, B:43:0x0095, B:46:0x009a, B:47:0x009c, B:50:0x00b2, B:82:0x0183, B:83:0x018f, B:78:0x0179, B:80:0x017d, B:54:0x00bc, B:55:0x00bd, B:57:0x00c5, B:58:0x00c9, B:72:0x016a, B:74:0x0170, B:8:0x003a, B:10:0x0050, B:13:0x0056, B:15:0x005a, B:30:0x0078, B:32:0x007c, B:19:0x0065, B:23:0x006c, B:61:0x00f9, B:63:0x00fd, B:65:0x010f, B:69:0x013a, B:48:0x009d, B:49:0x00b1), top: B:88:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5 A[Catch: all -> 0x0191, TryCatch #0 {, blocks: (B:4:0x001c, B:6:0x002d, B:37:0x0086, B:39:0x008b, B:41:0x0091, B:43:0x0095, B:46:0x009a, B:47:0x009c, B:50:0x00b2, B:82:0x0183, B:83:0x018f, B:78:0x0179, B:80:0x017d, B:54:0x00bc, B:55:0x00bd, B:57:0x00c5, B:58:0x00c9, B:72:0x016a, B:74:0x0170, B:8:0x003a, B:10:0x0050, B:13:0x0056, B:15:0x005a, B:30:0x0078, B:32:0x007c, B:19:0x0065, B:23:0x006c, B:61:0x00f9, B:63:0x00fd, B:65:0x010f, B:69:0x013a, B:48:0x009d, B:49:0x00b1), top: B:88:0x001c, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0177 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r20, boolean r21, int r22) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.c.a(boolean, boolean, int):void");
    }

    public void a(bk bkVar) {
        e eVar = e.G;
        if (eVar.H == null) {
            eVar.H = new BetaUploadStrategy();
        }
        if (bkVar != null) {
            BetaUploadStrategy betaUploadStrategy = e.G.H;
            long j2 = betaUploadStrategy.f8854b;
            long j3 = bkVar.f9355h;
            if (j2 == j3) {
                return;
            }
            betaUploadStrategy.f8854b = j3;
            bk bkVar2 = betaUploadStrategy.f8853a;
            bkVar2.f9349b = bkVar.f9349b;
            bkVar2.f9350c = bkVar.f9350c;
            bkVar2.f9355h = j3;
            if (aq.c(bkVar.f9351d)) {
                e.G.H.f8853a.f9351d = bkVar.f9351d;
            }
            if (aq.c(bkVar.f9352e)) {
                e.G.H.f8853a.f9352e = bkVar.f9352e;
            }
            bj bjVar = bkVar.f9353f;
            if (bjVar != null && !TextUtils.isEmpty(bjVar.f9345a)) {
                e.G.H.f8853a.f9353f.f9345a = bkVar.f9353f.f9345a;
            }
            Map<String, String> map = bkVar.f9354g;
            if (map != null && map.size() > 0) {
                e.G.H.f8853a.f9354g = bkVar.f9354g;
            }
            if (aq.c(bkVar.f9356i)) {
                e.G.H.f8853a.f9356i = bkVar.f9356i;
            }
            if (aq.c(bkVar.f9357j)) {
                e.G.H.f8853a.f9357j = bkVar.f9357j;
            }
            com.tencent.bugly.beta.global.a.a("us.bch", e.G.H);
        }
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        y yVar = betaGrayStrategy.f8848a;
        if (yVar == null || yVar.p != 1) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
