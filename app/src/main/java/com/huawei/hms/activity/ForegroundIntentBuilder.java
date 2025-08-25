package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;

/* loaded from: classes.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6526a;

    /* renamed from: b, reason: collision with root package name */
    private RequestHeader f6527b;

    /* renamed from: c, reason: collision with root package name */
    private String f6528c;

    /* renamed from: d, reason: collision with root package name */
    private ForegroundInnerHeader f6529d;

    /* renamed from: e, reason: collision with root package name */
    private String f6530e;

    /* renamed from: f, reason: collision with root package name */
    private Context f6531f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.f6526a = activity;
        RequestHeader requestHeader = new RequestHeader();
        this.f6527b = requestHeader;
        requestHeader.setSdkVersion(61100302);
        this.f6528c = "";
        ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
        this.f6529d = foregroundInnerHeader;
        foregroundInnerHeader.setApkVersion(30000000);
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f6526a, ForegroundBusDelegate.class.getName());
        Context context = this.f6531f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f6531f);
        } else {
            packageName = this.f6526a.getPackageName();
            appId = Util.getAppId(this.f6526a);
        }
        if (this.f6527b.getAppID() == null) {
            this.f6527b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            this.f6527b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f6527b.getAppID());
        }
        if (TextUtils.isEmpty(this.f6527b.getTransactionId())) {
            RequestHeader requestHeader = this.f6527b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f6527b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f6527b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f6528c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f6529d.toJson());
        if (!TextUtils.isEmpty(this.f6530e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f6530e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f6527b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i2) {
        this.f6527b.setApiLevel(i2);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f6531f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f6530e = this.f6526a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i2) {
        this.f6527b.setKitSdkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i2) {
        this.f6529d.setApkVersion(i2);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f6528c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f6529d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f6527b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f6527b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f6527b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f6529d.setResponseCallbackKey(str);
        return this;
    }
}
