package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f6591a;

    /* renamed from: b, reason: collision with root package name */
    private String f6592b = "";

    /* renamed from: c, reason: collision with root package name */
    private long f6593c = 0;

    private void a(long j2) {
        if (!RegionUtils.isChinaROM(c())) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity activityC = c();
        if (activityC == null || activityC.isFinishing()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("package", activityC.getPackageName());
        map.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f6593c + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j2);
        HiAnalyticsUtils.getInstance().onEvent(activityC, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, map);
        HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f6592b + ", carriedTimeStamp: " + this.f6593c + ", savedTimeStamp: " + j2);
    }

    private void b() {
        Activity activityC = c();
        if (activityC == null || activityC.isFinishing()) {
            return;
        }
        activityC.finish();
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.f6591a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f6592b);
        b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) throws IntentSender.SendIntentException {
        if (activity == null) {
            HMSLog.e("BaseResolutionAdapter", "activity is null");
            d();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.e("BaseResolutionAdapter", "activity is finishing");
            return;
        }
        this.f6591a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            d();
            return;
        }
        Bundle extras = null;
        try {
            extras = intent.getExtras();
            this.f6592b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            this.f6593c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0L);
        } catch (Throwable th) {
            HMSLog.e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th.getClass().getSimpleName());
        }
        if (!a()) {
            d();
            return;
        }
        if (this.f6592b != null && Build.VERSION.SDK_INT >= 29) {
            HMSLog.i("BaseResolutionAdapter", "remove apk resolution failed task.");
            ApkResolutionFailedManager.getInstance().removeTask(this.f6592b);
        }
        if (extras == null) {
            d();
            return;
        }
        Parcelable parcelable = extras.getParcelable("resolution");
        if (parcelable == null) {
            d();
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                return;
            } catch (Throwable unused) {
                d();
                HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                d();
                HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f6591a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i2, int i3, Intent intent) {
        if (i2 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i3);
        if (i3 == 1001 || i3 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i3);
        }
        if (i3 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f6592b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(null, this.f6592b);
        }
        b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i2, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f6592b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f6592b);
        if (resolutionFlag != 0 && resolutionFlag == this.f6593c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}
