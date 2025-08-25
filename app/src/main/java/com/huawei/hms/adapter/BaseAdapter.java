package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import com.taobao.accs.common.Constants;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<ApiClient> f6548a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f6549b;

    /* renamed from: c, reason: collision with root package name */
    private BaseCallBack f6550c;

    /* renamed from: d, reason: collision with root package name */
    private String f6551d;

    /* renamed from: e, reason: collision with root package name */
    private String f6552e;

    /* renamed from: f, reason: collision with root package name */
    private Parcelable f6553f;

    /* renamed from: g, reason: collision with root package name */
    private BaseCallBack f6554g;

    /* renamed from: h, reason: collision with root package name */
    private String f6555h;

    /* renamed from: i, reason: collision with root package name */
    private Context f6556i;

    /* renamed from: j, reason: collision with root package name */
    private RequestHeader f6557j = new RequestHeader();

    /* renamed from: k, reason: collision with root package name */
    private ResponseHeader f6558k = new ResponseHeader();

    /* renamed from: l, reason: collision with root package name */
    private SystemObserver f6559l;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a, reason: collision with root package name */
        private AtomicBoolean f6563a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i2) {
            if (!CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                if (!"installHMS".equals(str)) {
                    BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                    return;
                } else {
                    HMSLog.i("BaseAdapter", "has resolutin: installHMS");
                    a(baseCallBack, coreBaseResponse);
                    return;
                }
            }
            Activity activityC = BaseAdapter.this.c();
            HMSLog.i("BaseAdapter", "activity is: " + activityC);
            if (activityC == null || activityC.isFinishing()) {
                HMSLog.e("BaseAdapter", "activity null");
                BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                return;
            }
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f6556i)) {
                    BaseAdapter.this.a(activityC, pendingIntent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.b(-9));
                    return;
                }
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f6556i)) {
                    BaseAdapter.this.a(activityC, intent, coreBaseResponse);
                    return;
                } else {
                    baseCallBack.onError(BaseAdapter.this.b(-9));
                    return;
                }
            }
            if (i2 == 2) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseCallBack.onError(baseAdapter.b(baseAdapter.f6558k.getErrorCode()));
            } else {
                HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                baseCallBack.onError(BaseAdapter.this.b(-4));
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) throws IllegalArgumentException {
            HMSLog.i("BaseAdapter", "BaseRequestResultCallback onResult");
            BaseCallBack baseCallBackB = BaseAdapter.this.b();
            if (baseCallBackB == null) {
                HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.e("BaseAdapter", "result null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.e("BaseAdapter", "response null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            if (TextUtils.isEmpty(value.getJsonHeader())) {
                HMSLog.e("BaseAdapter", "jsonHeader null");
                baseCallBackB.onError(BaseAdapter.this.b(-1));
                return;
            }
            JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f6558k);
            if (this.f6563a.compareAndSet(true, false)) {
                BaseAdapter baseAdapter = BaseAdapter.this;
                baseAdapter.a(baseAdapter.f6556i, BaseAdapter.this.f6558k);
            }
            String resolution = BaseAdapter.this.f6558k.getResolution();
            int statusCode = BaseAdapter.this.f6558k.getStatusCode();
            HMSLog.i("BaseAdapter", "api is: " + BaseAdapter.this.f6558k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
            a(resolution, baseCallBackB, value, statusCode);
        }

        private void a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (Util.isAvailableLibExist(BaseAdapter.this.f6556i)) {
                Activity activityC = BaseAdapter.this.c();
                if (activityC != null && !activityC.isFinishing()) {
                    HMSLog.i("BaseAdapter", "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(activityC, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i2) {
                            HMSLog.i("BaseAdapter", "complete handleSolutionForHMS, result: " + i2);
                            if (i2 != 0) {
                                BaseAdapter baseAdapter = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter.a(i2, baseAdapter.a(i2)).toJson());
                            } else {
                                HMSPackageManager.getInstance(BaseAdapter.this.f6556i).resetMultiServiceState();
                                BaseAdapter baseAdapter2 = BaseAdapter.this;
                                baseCallBack.onError(baseAdapter2.a(11, baseAdapter2.a(11)).toJson());
                                BaseAdapter.this.i();
                            }
                        }
                    });
                    return;
                }
                HMSLog.e("BaseAdapter", "activity is null");
                try {
                    if (BaseAdapter.this.f6556i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.f6556i)) {
                        HMSLog.i("BaseAdapter", "pass installHMS intent");
                        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f6556i, UpdateAdapter.class.getName());
                        intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, ExceptionCode.CRASH_EXCEPTION);
                        intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                        coreBaseResponse.setIntent(intentStartBridgeActivity);
                        BaseAdapter.this.a(baseCallBack, coreBaseResponse);
                    } else {
                        HMSLog.i("BaseAdapter", "pass ACTIVITY_NULL error");
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.a(-3, baseAdapter.a(-3)).toJson());
                    }
                    return;
                } catch (RuntimeException unused) {
                    HMSLog.e("BaseAdapter", "handleSolutionForHms pass result failed");
                    return;
                }
            }
            HMSLog.i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
            baseCallBack.onError(BaseAdapter.this.b(-9));
        }
    }

    private static class a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f6548a = new WeakReference<>(apiClient);
        if (apiClient == null) {
            HMSLog.w("BaseAdapter", "BaseAdapter constructor client is null");
            return;
        }
        this.f6556i = apiClient.getContext().getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, WeakReference is " + this.f6548a);
    }

    private void h() throws IllegalArgumentException {
        if (this.f6551d == null || this.f6554g == null) {
            return;
        }
        this.f6558k = null;
        this.f6558k = new ResponseHeader();
        baseRequest(d(), e(), f(), a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f6556i == null) {
            HMSLog.e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f6556i.getPackageName());
            this.f6556i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) throws IllegalArgumentException {
        a(str, str2, parcelable, baseCallBack);
        if (this.f6548a == null) {
            HMSLog.e("BaseAdapter", "client is null");
            baseCallBack.onError(b(-2));
            return;
        }
        this.f6550c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f6557j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f6557j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.e("BaseAdapter", "get uri null");
            baseCallBack.onError(b(-5));
            return;
        }
        String transactionId = this.f6557j.getTransactionId();
        this.f6555h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(b(-6));
            return;
        }
        HMSLog.i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f6555h);
        a(this.f6556i, this.f6557j);
        a(this.f6548a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    private String d() {
        return this.f6551d;
    }

    private String e() {
        return this.f6552e;
    }

    private Parcelable f() {
        return this.f6553f;
    }

    private void g() {
        this.f6559l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.2
            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i2) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) throws JSONException {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
                    BaseCallBack baseCallBackB = BaseAdapter.this.b();
                    if (baseCallBackB == null) {
                        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
                        return true;
                    }
                    baseCallBackB.onError(BaseAdapter.this.b(-6));
                    return true;
                }
                if (!str.equals(BaseAdapter.this.f6555h)) {
                    return false;
                }
                HMSLog.i("BaseAdapter", "onSolutionResult + id is :" + str);
                BaseCallBack baseCallBackB2 = BaseAdapter.this.b();
                if (baseCallBackB2 == null) {
                    HMSLog.e("BaseAdapter", "onResult baseCallBack null");
                    return true;
                }
                if (intent == null) {
                    HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
                    String strB = BaseAdapter.this.b(-7);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.a(baseAdapter.f6556i, BaseAdapter.this.f6558k, 0L);
                    baseCallBackB2.onError(strB);
                    return true;
                }
                if (BaseAdapter.this.b(intent, baseCallBackB2) || BaseAdapter.this.a(intent, baseCallBackB2)) {
                    return true;
                }
                HMSLog.e("BaseAdapter", "onComplete for on activity result");
                BaseAdapter.this.c(intent, baseCallBackB2);
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i2) {
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity c() {
        if (this.f6549b == null) {
            HMSLog.i("BaseAdapter", "activityWeakReference is " + this.f6549b);
            return null;
        }
        ApiClient apiClient = this.f6548a.get();
        if (apiClient == null) {
            HMSLog.i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.i("BaseAdapter", "activityWeakReference has " + this.f6549b.get());
        return Util.getActiveActivity(this.f6549b.get(), apiClient.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseCallBack b() {
        BaseCallBack baseCallBack = this.f6550c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.e("BaseAdapter", "callback null");
        return null;
    }

    private void b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f6548a = new WeakReference<>(apiClient);
        this.f6549b = new WeakReference<>(activity);
        if (activity == null) {
            HMSLog.w("BaseAdapter", "BaseAdapter constructor activity is null");
            return;
        }
        this.f6556i = activity.getApplicationContext();
        HMSLog.i("BaseAdapter", "In constructor, activityWeakReference is " + this.f6549b + ", activity is " + this.f6549b.get());
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new a(apiClient, str, coreBaseRequest);
    }

    private void c(int i2) {
        this.f6558k.setTransactionId(this.f6557j.getTransactionId());
        this.f6558k.setAppID(this.f6557j.getAppID());
        this.f6558k.setApiName(this.f6557j.getApiName());
        this.f6558k.setSrvName(this.f6557j.getSrvName());
        this.f6558k.setPkgName(this.f6557j.getPkgName());
        this.f6558k.setStatusCode(1);
        this.f6558k.setErrorCode(i2);
        this.f6558k.setErrorReason("Core error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent intentModifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (intentModifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intentModifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i2) {
        c(i2);
        return this.f6558k.toJson();
    }

    private void b(String str) {
        this.f6552e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Intent intent, BaseCallBack baseCallBack) throws IllegalArgumentException {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.e("BaseAdapter", "kit update success,replay request");
            h();
        } else {
            HMSLog.e("BaseAdapter", "kit update failed");
            baseCallBack.onError(a(-10, a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f6557j;
        if (requestHeader != null) {
            b(this.f6556i, requestHeader);
        }
        if (this.f6559l == null) {
            g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f6559l);
        if (Build.VERSION.SDK_INT >= 29) {
            a(coreBaseResponse);
        }
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("resolution", parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.f6555h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f6555h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Intent r7, com.huawei.hms.adapter.BaseAdapter.BaseCallBack r8) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "json_header"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "json_body"
            java.lang.String r1 = r7.getStringExtra(r1)
            java.lang.String r2 = "status_code"
            java.lang.Object r2 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r2)
            java.lang.String r3 = "error_code"
            java.lang.Object r3 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r0, r3)
            java.lang.String r4 = "HMS_FOREGROUND_RES_UI"
            boolean r5 = r7.hasExtra(r4)
            if (r5 == 0) goto L36
            java.lang.String r7 = r7.getStringExtra(r4)
            java.lang.String r4 = "uiDuration"
            java.lang.Object r7 = com.huawei.hms.utils.JsonUtil.getInfoFromJsonobject(r7, r4)
            boolean r4 = r7 instanceof java.lang.Long
            if (r4 == 0) goto L36
            java.lang.Long r7 = (java.lang.Long) r7
            long r4 = r7.longValue()
            goto L38
        L36:
            r4 = 0
        L38:
            boolean r7 = r2 instanceof java.lang.Integer
            if (r7 == 0) goto L5c
            boolean r7 = r3 instanceof java.lang.Integer
            if (r7 == 0) goto L5c
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r7 = r2.intValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r2 = r3.intValue()
            r6.b(r2)
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f6558k
            r2.setStatusCode(r7)
            android.content.Context r7 = r6.f6556i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f6558k
            r6.a(r7, r2, r4)
            goto L67
        L5c:
            r7 = -8
            r6.b(r7)
            android.content.Context r7 = r6.f6556i
            com.huawei.hms.common.internal.ResponseHeader r2 = r6.f6558k
            r6.a(r7, r2, r4)
        L67:
            r7 = 0
            r8.onComplete(r0, r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.BaseAdapter.c(android.content.Intent, com.huawei.hms.adapter.BaseAdapter$BaseCallBack):void");
    }

    private void a(final CoreBaseResponse coreBaseResponse) {
        HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f6555h, new Runnable() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                HMSLog.i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f6559l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f6555h);
                BaseCallBack baseCallBackB = BaseAdapter.this.b();
                if (baseCallBackB == null) {
                    HMSLog.e("BaseAdapter", "timeoutRunnable callBack is null");
                } else {
                    BaseAdapter.this.a(baseCallBackB, coreBaseResponse);
                }
            }
        });
    }

    private void a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f6557j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ResponseHeader responseHeader, long j2) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j2));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f6557j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseWrap a(int i2, String str) {
        c(i2);
        ResponseWrap responseWrap = new ResponseWrap(this.f6558k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_ERROR_CODE, i2);
        } catch (JSONException e2) {
            HMSLog.e("BaseAdapter", "buildBodyStr failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    private void a(String str) {
        this.f6551d = str;
    }

    private void a(Parcelable parcelable) {
        this.f6553f = parcelable;
    }

    private BaseCallBack a() {
        return this.f6554g;
    }

    private void a(BaseCallBack baseCallBack) {
        this.f6554g = baseCallBack;
    }

    private void a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        a(str);
        b(str2);
        a(parcelable);
        a(baseCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Intent intent, BaseCallBack baseCallBack) throws IllegalArgumentException {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            h();
            return true;
        }
        HMSLog.i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
