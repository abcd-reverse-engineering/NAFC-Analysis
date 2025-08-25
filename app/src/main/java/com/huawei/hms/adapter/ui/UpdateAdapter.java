package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f6600a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6601b;

    /* renamed from: c, reason: collision with root package name */
    private int f6602c;

    /* renamed from: d, reason: collision with root package name */
    private UpdateBean f6603d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6604e = false;

    private static Object a(String str, String str2, Object[] objArr) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("UpdateAdapter", "className is empty.");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            HMSLog.e("UpdateAdapter", "methodName is empty.");
            return null;
        }
        if (objArr == null) {
            HMSLog.e("UpdateAdapter", "args is null.");
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (objArr[i2] instanceof Activity) {
                clsArr[i2] = Activity.class;
            } else if (objArr[i2] instanceof Context) {
                clsArr[i2] = Context.class;
            } else if (objArr[i2] instanceof UpdateBean) {
                clsArr[i2] = UpdateBean.class;
            } else if (objArr[i2] instanceof Integer) {
                clsArr[i2] = Integer.TYPE;
            } else if (objArr[i2] instanceof Boolean) {
                clsArr[i2] = Boolean.TYPE;
            } else {
                HMSLog.e("UpdateAdapter", "not set args[" + i2 + "] type");
            }
        }
        Class<?> cls = Class.forName(str);
        return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
    }

    private Activity b() {
        WeakReference<Activity> weakReference = this.f6600a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        try {
            return a(str, str2, objArr);
        } catch (Throwable th) {
            HMSLog.e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + th.getMessage());
            return null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.i("UpdateAdapter", "activity == null");
            c();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.i("UpdateAdapter", "activity is finishing");
            c();
            return;
        }
        this.f6601b = activity.getApplicationContext();
        this.f6600a = new WeakReference<>(activity);
        if (c.f6653b.a(b())) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                c();
                return;
            }
            try {
                this.f6602c = intent.getIntExtra(CommonCode.MapKey.UPDATE_VERSION, 0);
            } catch (Throwable th) {
                HMSLog.e("UpdateAdapter", "get update_version:" + th.getMessage());
            }
            if (this.f6602c == 0) {
                c();
                return;
            }
            if (intent.hasExtra("installHMS")) {
                this.f6604e = true;
            }
            if (a(intent, activity)) {
                return;
            }
            try {
                if (AvailableUtil.isInstallerLibExist(this.f6601b)) {
                    UpdateBean updateBean = (UpdateBean) a("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f6602c), Boolean.valueOf(this.f6604e)});
                    this.f6603d = updateBean;
                    a("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                    this.f6603d = null;
                }
            } catch (Throwable th2) {
                HMSLog.e("UpdateAdapter", "InstallerAdapter.startUpdateHms is failed. message：" + th2.getMessage());
                c();
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        c.f6653b.b(b());
        this.f6600a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        int intExtra;
        if (i2 != getRequestCode()) {
            this.f6603d = null;
            return false;
        }
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i3);
        if (AvailableUtil.isInstallerLibExist(this.f6601b) && i3 == 1214) {
            HMSLog.i("UpdateAdapter", "Enter update escape route");
            Activity activityB = b();
            if (activityB == null) {
                HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.f6603d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{activityB, 1001, this.f6603d});
            this.f6603d = null;
        }
        if (i3 == -1) {
            if (intent != null) {
                try {
                    intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
                } catch (Throwable unused) {
                    HMSLog.w("UpdateAdapter", "get kit_update_result failed, throwable occur.");
                    intExtra = 0;
                }
                if (intExtra == 1) {
                    HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.f6603d = null;
                    a();
                    return true;
                }
                a(intent);
            }
        } else if (i3 == 0) {
            HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.f6603d = null;
            Activity activityB2 = b();
            if (activityB2 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(activityB2.getApplicationContext()).getHMSPackageName();
            if (TextUtils.isEmpty(hMSPackageName)) {
                hMSPackageName = "com.huawei.hwid";
            }
            if (this.f6604e || a(activityB2, hMSPackageName, this.f6602c)) {
                HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i3 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }

    private boolean a(Intent intent, Activity activity) {
        if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            return false;
        }
        HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        if (TextUtils.isEmpty(hMSPackageName)) {
            HMSLog.w("UpdateAdapter", "hmsPackageName is empty, update invalid.");
            c();
            return true;
        }
        ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        Intent intent2 = new Intent();
        intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
        intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
        intent2.setComponent(componentName);
        activity.startActivityForResult(intent2, 1001);
        return true;
    }

    private void a(Intent intent) {
        int intExtra = -1;
        try {
            intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        } catch (Throwable unused) {
            HMSLog.w("UpdateAdapter", "get extra_result failed, throwable occur.");
        }
        if (intExtra == 0) {
            HMSLog.i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (intExtra == 13) {
            HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (intExtra == 8) {
            HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(intExtra);
        }
    }

    private void a() {
        Activity activityB = b();
        if (activityB == null || activityB.isFinishing()) {
            return;
        }
        activityB.finish();
    }

    private boolean a(Context context, String str, int i2) {
        if (context != null && !TextUtils.isEmpty(str) && i2 != 0) {
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) || packageManagerHelper.getPackageVersionCode(str) < i2;
        }
        HMSLog.w("UpdateAdapter", "Please check your params, one of params is invalid.");
        return false;
    }
}
