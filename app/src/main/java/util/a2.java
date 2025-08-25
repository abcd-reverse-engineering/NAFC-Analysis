package util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import bean.AppBean;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import manager.NotificationHelper;
import ui.activity.VirusKillingActivity;

/* compiled from: VirusKillUtil.java */
/* loaded from: classes2.dex */
public class a2 {

    /* renamed from: e, reason: collision with root package name */
    public static final String f20715e = "virus_kill_type_first";

    /* renamed from: f, reason: collision with root package name */
    public static final String f20716f = "virus_kill_type_alarm";

    /* renamed from: g, reason: collision with root package name */
    public static final String f20717g = "alarm_virus";

    /* renamed from: h, reason: collision with root package name */
    public static final String f20718h = "定时APP自检";

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ArrayList<AppInfoBean>> f20719a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<ArrayList<AppInfoBean>> f20720b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f20721c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20722d;

    /* compiled from: VirusKillUtil.java */
    class a implements ui.e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f20723a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f20724b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f20725c;

        a(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f20723a = arrayList;
            this.f20724b = arrayList2;
            this.f20725c = arrayList3;
        }

        @Override // ui.e.c
        public void a(int i2) {
            n1.c("Scanner", "APP总数=" + i2);
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // ui.e.c
        public void b() {
            n1.c("Scanner", "检测应用-----------------scanStop");
        }

        @Override // ui.e.c
        public void c() {
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(true);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.f20723a.add(appInfoBean);
                    a2.this.f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    this.f20725c.add(appInfoBean);
                } else {
                    this.f20724b.add(appInfoBean);
                    a2.this.f();
                }
                n1.c("Scanner", "检测完成应用=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // ui.e.c
        public void a() {
            n1.c("Scanner", "检测完成");
            if (a2.this.f20722d) {
                if (a2.this.a()) {
                    a2.this.d();
                    return;
                }
                return;
            }
            a2.this.d();
        }
    }

    /* compiled from: VirusKillUtil.java */
    class b implements ui.e.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f20727a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f20728b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f20729c;

        b(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f20727a = arrayList;
            this.f20728b = arrayList2;
            this.f20729c = arrayList3;
        }

        @Override // ui.e.c
        public void a(int i2) {
            n1.c("Scanner", "开始检测安装包个数=====" + i2);
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        }

        @Override // ui.e.c
        public void b() {
            n1.c("Scanner", "检测安装包       scanStop=====");
        }

        @Override // ui.e.c
        public void c() {
            n1.c("Scanner", "开始检测安装包=====");
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AppInfoBean appInfoBean = list.get(i2);
                appInfoBean.setFlag(1);
                appInfoBean.setSelect(false);
                appInfoBean.setTypeIsApp(false);
                int virusLevel = appInfoBean.getVirusLevel();
                if (virusLevel == 1) {
                    this.f20727a.add(appInfoBean);
                    a2.this.f();
                } else if (virusLevel != 2) {
                    appInfoBean.setVirusLevel(0);
                    if (appInfoBean.getAppIcon() != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                        this.f20729c.add(appInfoBean);
                    }
                } else {
                    this.f20728b.add(appInfoBean);
                    a2.this.f();
                }
                n1.c("Scanner", "检测完成安装包=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
            }
        }

        @Override // ui.e.c
        @SuppressLint({"RestrictedApi"})
        public void a() {
            a2.this.e();
        }
    }

    public a2(Context context, String str) {
        this.f20721c = null;
        this.f20721c = new WeakReference<>(context);
        this.f20722d = TextUtils.equals(f20715e, str);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!this.f20722d) {
            g();
            a(this.f20721c.get());
        } else if (a()) {
            u1.b(u1.B0, true);
            org.greenrobot.eventbus.c.f().d(new util.c2.a(153, null));
        }
    }

    private void g() {
        ui.e.b.e().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return !u1.a(u1.z0, false);
    }

    private void b() {
        a(this.f20719a, u1.C0, u1.D0, u1.E0);
        a(this.f20720b, u1.F0, u1.G0, u1.H0);
    }

    private void c() {
        this.f20719a.clear();
        this.f20720b.clear();
        a(this.f20719a, "应用");
        ui.e.b.e().a(this.f20721c.get(), new a(this.f20719a.get(0), this.f20719a.get(1), this.f20719a.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a(this.f20720b, "安装包");
        ui.e.b.e().b(this.f20721c.get(), new b(this.f20720b.get(0), this.f20720b.get(1), this.f20720b.get(2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f20722d && a()) {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(154, null));
            b();
            u1.b(u1.A0, true);
            u1.b(u1.z0, true);
            g();
        }
    }

    private void a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str) {
        try {
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
            arrayList.add(new ArrayList<>());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ArrayList<ArrayList<AppInfoBean>> arrayList, String str, String str2, String str3) {
        if (arrayList == null || arrayList.size() <= 2) {
            return;
        }
        ArrayList<AppInfoBean> arrayList2 = arrayList.get(0);
        ArrayList<AppInfoBean> arrayList3 = arrayList.get(1);
        ArrayList<AppInfoBean> arrayList4 = arrayList.get(2);
        a(arrayList2, str, true);
        a(arrayList3, str2, true);
        a(arrayList4, str3, false);
    }

    private void a(List<AppInfoBean> list, String str, boolean z) {
        Drawable drawableB;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AppInfoBean appInfoBean = list.get(i2);
            if (z && (drawableB = r1.b(appInfoBean.getPkgPath())) != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                appInfoBean.setAppIcon(drawableB);
                j.c.a(j.c.a(appInfoBean.getAppIcon()), appInfoBean.getName(), appInfoBean.getVersionName(), j.c.f17005c);
            }
            arrayList.add(AppBean.AppInfoBean2AppBean(appInfoBean));
            u1.a((List) arrayList, str);
        }
    }

    public void a(Context context) {
        Notification.Builder builder;
        Intent intent = new Intent(context, (Class<?>) VirusKillingActivity.class);
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        PendingIntent activity = PendingIntent.getActivity(context, 101, intent, c.c.a.b.a.a.C1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(f20717g, f20718h, 4));
            builder = new Notification.Builder(context, f20717g);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setContentTitle(f20718h).setContentText("检测到您的手机有可疑应用").setWhen(System.currentTimeMillis()).setAutoCancel(true).setShowWhen(true).setContentIntent(activity).setSmallIcon(R.drawable.logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.logo)).setTicker(NotificationHelper.CHANEL_NAME).build();
        notificationManager.notify(3, builder.build());
    }
}
