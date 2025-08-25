package ui;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.CameraXConfig;
import androidx.multidex.MultiDex;
import bean.CheckTimeBean;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.hicorenational.antifraud.service.CallIntercepeUtil;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.mmkv.MMKV;
import com.tencent.tauth.Tencent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.PlatformConfig;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import java.util.Calendar;
import network.http.AddressHttp;
import receiver.e;
import util.m1;
import util.p1;
import util.u1;
import util.v0;
import util.v1;
import util.y1;

/* loaded from: classes2.dex */
public class Hicore extends Application implements CameraXConfig.Provider {
    private static Hicore app = null;
    public static boolean fromPageReport = false;
    private static CallIntercepeUtil mCallIntercepeUtile;
    public static String schemeString;
    public final int MIN_CLICK_DELAY_TIME = BannerConfig.DURATION;
    private long mLastClickTime = 0;

    private void compatibleWarn160() {
        if (u1.a(u1.D, false)) {
            u1.a(u1.F, true);
            u1.a(u1.G, true);
            u1.a(u1.H, true);
        }
    }

    public static Hicore getApp() {
        return app;
    }

    private void initBugly() {
        Bugly.setAppChannel(TinkerManager.getApplication(), getChannel());
        Bugly.init(app, m1.u.b(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAddressData, reason: merged with bridge method [inline-methods] */
    public void b() {
        AddressHttp.initAddressJson();
    }

    private void startAlarm() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) u1.a(u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null) {
            new v0().a(app, checkTimeBean.getCode());
        }
    }

    public /* synthetic */ void a() {
        e.a((Application) app, getChannel());
        initBugly();
        Tencent.setIsPermissionGranted(true);
        PlatformConfig.setWeixin(m1.u.r(), m1.u.s());
        PlatformConfig.setSinaWeibo(m1.u.g(), m1.u.h(), m1.u.i());
        PlatformConfig.setQQZone(m1.u.e(), m1.u.f());
        PlatformConfig.setDing(m1.u.c());
        PlatformConfig.setWXFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setSinaFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setQQFileProvider(getPackageName() + ".fileprovider");
        PlatformConfig.setDingFileProvider(getPackageName() + ".fileprovider");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
        startAlarm();
        compatibleWarn160();
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override // androidx.camera.core.CameraXConfig.Provider
    @NonNull
    public CameraXConfig getCameraXConfig() {
        return Camera2Config.defaultConfig();
    }

    public String getChannel() {
        String strC;
        try {
            strC = com.leon.channel.helper.b.c(getApp());
        } catch (Exception unused) {
            strC = "";
        }
        return !TextUtils.isEmpty(strC) ? strC : OSSConstants.RESOURCE_NAME_OSS;
    }

    public String getCurActivityName() {
        return c.i().h().getLocalClassName();
    }

    public void initSDK() {
        new Thread(new Runnable() { // from class: ui.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f19492a.a();
            }
        }).start();
    }

    public boolean isDouble() {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j2 = timeInMillis - this.mLastClickTime;
        if (j2 <= 800 && j2 >= 0) {
            return true;
        }
        this.mLastClickTime = timeInMillis;
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        app = this;
        MMKV.initialize(this);
        d.a.l();
        registerActivityLifecycleCallbacks(c.i());
        v1.l(app);
        e.b(this, getChannel());
        if (p1.a(p1.n, false)) {
            initSDK();
        }
        new Thread(new Runnable() { // from class: ui.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17552a.b();
            }
        }).start();
        registerPhoneStateListener();
        y1.a(this, 0);
        y1.b(this, 0);
    }

    public void registerPhoneStateListener() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.f20916j);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(util.permissionutil.a.r);
        }
        if (util.permissionutil.c.a(this, (String[]) arrayList.toArray(new String[arrayList.size()]))) {
            mCallIntercepeUtile = new CallIntercepeUtil();
            CallIntercepeUtil callIntercepeUtil = mCallIntercepeUtile;
            if (callIntercepeUtil != null) {
                callIntercepeUtil.getIncomingCall(this);
            }
        }
    }
}
