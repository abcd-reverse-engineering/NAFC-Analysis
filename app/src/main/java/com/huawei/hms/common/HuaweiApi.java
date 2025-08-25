package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    private Context f6678a;

    /* renamed from: b, reason: collision with root package name */
    private TOption f6679b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6680c;

    /* renamed from: d, reason: collision with root package name */
    private AbstractClientBuilder<?, TOption> f6681d;

    /* renamed from: e, reason: collision with root package name */
    private String f6682e;

    /* renamed from: f, reason: collision with root package name */
    private String f6683f;

    /* renamed from: g, reason: collision with root package name */
    private SubAppInfo f6684g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f6685h;

    /* renamed from: i, reason: collision with root package name */
    private int f6686i;

    /* renamed from: j, reason: collision with root package name */
    private int f6687j = 1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6688k = false;

    /* renamed from: l, reason: collision with root package name */
    private String f6689l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6690m;
    private RequestManager n;

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* renamed from: b, reason: collision with root package name */
        private final AnyClient f6695b;

        /* renamed from: d, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f6697d;

        /* renamed from: e, reason: collision with root package name */
        private ResolveClientBean f6698e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* renamed from: a, reason: collision with root package name */
        private final Queue<TaskApiCallbackWrapper> f6694a = new LinkedList();

        /* renamed from: c, reason: collision with root package name */
        private ConnectionResult f6696c = null;

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f6697d = huaweiApi;
            this.f6695b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f6695b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f6698e);
            this.f6698e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f6698e);
            this.f6698e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i2) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f6698e);
            this.f6698e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.a().getTaskApiCall().getTransactionId(), this);
            this.f6694a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f6697d).f6680c == null ? this.f6697d.getContext() : ((HuaweiApi) this.f6697d).f6680c).getPackageName();
            if (((HuaweiApi) this.f6697d).f6680c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f6697d;
                huaweiApi.b(((HuaweiApi) huaweiApi).f6680c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f6697d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f6697d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f6695b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.a().getTaskApiCall();
            requestHeader.setTransactionId(a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f6697d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f6697d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f6695b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack callBackB = taskApiCallbackWrapper.b();
                    if (callBackB != null) {
                        callBackB.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f6694a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        private TaskApiCallbackWrapper b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* renamed from: a, reason: collision with root package name */
                private AtomicBoolean f6699a = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.a();
                        HMSLog.i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f6699a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f6697d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f6697d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f6695b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.f6694a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.f6694a.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.f6694a.clear();
            this.f6696c = null;
            this.f6695b.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ConnectionResult connectionResult) {
            this.f6696c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                TaskApiCallWrapper taskApiCallWrapperA = it.next().a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f6697d.getContext(), responseHeader, String.valueOf(this.f6697d.getKitSdkVersion()));
                if (this.f6696c.getResolution() != null && z) {
                    responseHeader.setParcelable(this.f6696c.getResolution());
                    z = false;
                    if (Util.isAvailableLibExist(this.f6697d.getContext()) && this.f6696c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                }
                int errorCode = this.f6696c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                taskApiCallWrapperA.getTaskApiCall().onResponse(this.f6695b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f6694a.clear();
            this.f6696c = null;
            this.f6695b.disconnect();
        }

        void a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper taskApiCallbackWrapperB = b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f6697d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f6695b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f6697d).f6678a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f6695b.isConnected() && !((HuaweiApi) this.f6697d).f6690m && ((BaseHmsClient) this.f6695b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f6695b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f6695b.disconnect();
                }
            }
            if (this.f6695b.isConnected()) {
                HMSLog.i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter2 = ((BaseHmsClient) this.f6695b).getAdapter();
                adapter2.updateDelayTask();
                ((HmsClient) this.f6695b).setService(IAIDLInvoke.Stub.asInterface(adapter2.getServiceBinder()));
                postMessage(taskApiCallbackWrapperB);
                return;
            }
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(taskApiCallbackWrapperB);
            ConnectionResult connectionResult = this.f6696c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f6696c.getErrorCode());
                onConnectionFailed(this.f6696c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f6695b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), taskApiCallbackWrapperB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f6696c = null;
            this.f6694a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        private String a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f6697d.getAppID(), str2) : str;
        }

        synchronized void a(int i2, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f6695b.isConnected()) {
                HMSLog.d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f6695b.isConnecting()) {
                HMSLog.d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f6697d.getActivity() != null) {
                if (this.f6698e == null) {
                    this.f6698e = new ResolveClientBean(this.f6695b, i2);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f6698e)) {
                    HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f6698e);
            }
            this.f6695b.connect(i2);
        }

        void a() {
            this.f6695b.disconnect();
        }

        private void a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper taskApiCallWrapperA = taskApiCallbackWrapper.a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(taskApiCallWrapperA.getTaskApiCall().getTransactionId());
            taskApiCallWrapperA.getTaskApiCall().onResponse(this.f6695b, responseHeader, null, taskApiCallWrapperA.getTaskCompletionSource());
        }

        private String a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f6697d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                        return "application configuration error, please developer check configuration";
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                    return "application configuration error, please developer check configuration";
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
        }
    }

    public static class TaskApiCallbackWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final TaskApiCallWrapper f6710a;

        /* renamed from: b, reason: collision with root package name */
        private final AnyClient.CallBack f6711b;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f6710a = taskApiCallWrapper;
            this.f6711b = callBack;
        }

        TaskApiCallWrapper a() {
            return this.f6710a;
        }

        AnyClient.CallBack b() {
            return this.f6711b;
        }
    }

    private static class a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f6712a;

        /* renamed from: b, reason: collision with root package name */
        private final TaskApiCallWrapper f6713b;

        public a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f6712a = huaweiApi;
            this.f6713b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0056 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(com.huawei.hms.common.HuaweiApi.RequestHandler r9, java.lang.Throwable r10) {
            /*
                r8 = this;
                java.lang.String r0 = "HuaweiApi"
                r1 = 1
                r2 = 0
                com.huawei.hms.common.internal.AnyClient r9 = r9.getClient()     // Catch: java.lang.Throwable -> L36
                com.huawei.hms.common.internal.ResponseHeader r3 = new com.huawei.hms.common.internal.ResponseHeader     // Catch: java.lang.Throwable -> L33
                r4 = 907135001(0x3611c819, float:2.1723156E-6)
                java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L33
                r3.<init>(r1, r4, r10)     // Catch: java.lang.Throwable -> L33
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2f
                r10.<init>()     // Catch: java.lang.Throwable -> L2f
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L2f
                com.huawei.hms.common.internal.TaskApiCallWrapper r4 = r8.f6713b     // Catch: java.lang.Throwable -> L2c
                com.huawei.hmf.tasks.TaskCompletionSource r4 = r4.getTaskCompletionSource()     // Catch: java.lang.Throwable -> L2c
                com.huawei.hms.common.internal.TaskApiCallWrapper r5 = r8.f6713b     // Catch: java.lang.Throwable -> L2a
                com.huawei.hms.common.internal.TaskApiCall r2 = r5.getTaskApiCall()     // Catch: java.lang.Throwable -> L2a
                goto L54
            L2a:
                r5 = move-exception
                goto L3c
            L2c:
                r5 = move-exception
                r4 = r2
                goto L3c
            L2f:
                r5 = move-exception
                r10 = r2
                r4 = r10
                goto L3c
            L33:
                r10 = move-exception
                r5 = r10
                goto L39
            L36:
                r9 = move-exception
                r5 = r9
                r9 = r2
            L39:
                r10 = r2
                r3 = r10
                r4 = r3
            L3c:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "<notifyCpException> "
                r6.append(r7)
                java.lang.String r5 = r5.getMessage()
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                com.huawei.hms.support.log.HMSLog.e(r0, r5)
            L54:
                if (r9 == 0) goto L5f
                if (r3 == 0) goto L5f
                if (r10 == 0) goto L5f
                if (r4 == 0) goto L5f
                if (r2 == 0) goto L5f
                goto L60
            L5f:
                r1 = 0
            L60:
                if (r1 == 0) goto L66
                r2.onResponse(r9, r3, r10, r4)
                goto L6b
            L66:
                java.lang.String r9 = "<notifyCpException> isNotify is false, Can not notify CP."
                com.huawei.hms.support.log.HMSLog.e(r0, r9)
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.HuaweiApi.a.a(com.huawei.hms.common.HuaweiApi$RequestHandler, java.lang.Throwable):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f6712a);
            try {
                requestHandler.a(this.f6713b);
            } catch (Throwable th) {
                a(requestHandler, th);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f6685h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i2, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f6688k = true;
        if (taskApiCall == null) {
            HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f6678a, taskApiCall.getUri(), TextUtils.isEmpty(this.f6684g.getSubAppID()) ? this.f6683f : this.f6684g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.n == null) {
            this.n = RequestManager.getInstance();
        }
        return a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f6685h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f6687j;
    }

    public String getAppID() {
        return this.f6683f;
    }

    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f6681d.buildClient(this.f6678a, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f6678a.getPackageName(), this.f6678a.getClass().getName(), getScopes(), this.f6682e, null, this.f6684g);
        if (!this.f6690m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f6678a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f6689l = hMSPackageNameForMultiService;
            HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f6689l);
        }
        clientSettings.setInnerHmsPkg(this.f6689l);
        clientSettings.setUseInnerHms(this.f6690m);
        WeakReference<Activity> weakReference = this.f6685h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f6678a;
    }

    public int getKitSdkVersion() {
        return this.f6686i;
    }

    public TOption getOption() {
        return this.f6679b;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f6684g.getSubAppID();
    }

    public void setApiLevel(int i2) {
        this.f6687j = i2;
    }

    public void setHostContext(Context context) {
        this.f6680c = context;
    }

    public void setInnerHms() {
        this.f6689l = this.f6678a.getPackageName();
        this.f6690m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f6689l);
    }

    public void setKitSdkVersion(int i2) {
        this.f6686i = i2;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f6684g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f6682e)) {
            HMSLog.e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f6688k) {
            HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f6684g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        String appId = Util.getAppId(context);
        this.f6682e = appId;
        this.f6683f = appId;
    }

    private void a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        this.f6678a = context.getApplicationContext();
        this.f6679b = toption;
        this.f6681d = abstractClientBuilder;
        b(context);
        this.f6684g = new SubAppInfo("");
        this.f6686i = i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f6682e)) {
                HMSLog.e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.i("HuaweiApi", "subAppId is " + str);
                this.f6684g = new SubAppInfo(str);
            }
        }
        a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f6685h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, i2, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f6685h = new WeakReference<>(activity);
        a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e2) {
            HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e2.getMessage());
        }
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i2, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, i2, str);
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
