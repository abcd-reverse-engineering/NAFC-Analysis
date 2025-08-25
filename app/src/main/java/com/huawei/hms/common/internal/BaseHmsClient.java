package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import c.c.a.b.a.a;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f6724i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f6725j = new AtomicInteger(1);

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f6726k = new AtomicInteger(1);

    /* renamed from: l, reason: collision with root package name */
    private static BinderAdapter f6727l;

    /* renamed from: m, reason: collision with root package name */
    private static BinderAdapter f6728m;

    /* renamed from: a, reason: collision with root package name */
    private final Context f6729a;

    /* renamed from: b, reason: collision with root package name */
    private String f6730b;

    /* renamed from: c, reason: collision with root package name */
    private final ClientSettings f6731c;

    /* renamed from: d, reason: collision with root package name */
    private volatile IAIDLInvoke f6732d;

    /* renamed from: e, reason: collision with root package name */
    private final ConnectionCallbacks f6733e;

    /* renamed from: f, reason: collision with root package name */
    private final OnConnectionFailedListener f6734f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f6735g = null;

    /* renamed from: h, reason: collision with root package name */
    private HuaweiApi.RequestHandler f6736h;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i2);
    }

    public static final class ConnectionResultWrapper {

        /* renamed from: a, reason: collision with root package name */
        private HuaweiApi.RequestHandler f6741a;

        /* renamed from: b, reason: collision with root package name */
        private ConnectionResult f6742b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f6741a = requestHandler;
            this.f6742b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f6742b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f6741a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f6729a = context;
        this.f6731c = clientSettings;
        if (clientSettings != null) {
            this.f6730b = clientSettings.getAppID();
        }
        this.f6734f = onConnectionFailedListener;
        this.f6733e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2) {
                onBinderFailed(i2, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f6733e == null || (BaseHmsClient.this.f6733e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f6733e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f6733e == null || (BaseHmsClient.this.f6733e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f6733e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i2, Intent intent) {
                if (intent == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                    BaseHmsClient.this.f6732d = null;
                    return;
                }
                Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                if (activeActivity == null) {
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f6729a, 11, intent, a.B1)));
                    BaseHmsClient.this.f6732d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                long time = new Timestamp(System.currentTimeMillis()).getTime();
                FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                    @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                    public void binderCallBack(int i3) {
                        if (i3 != 0) {
                            BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                            BaseHmsClient.this.f6732d = null;
                        }
                    }
                });
                intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                activeActivity.startActivity(intent);
            }
        };
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f6731c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f6728m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f6727l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void f() {
        if (this.f6731c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f6728m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f6727l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i2) {
        a(i2, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f6732d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f6732d != null) {
            onConnecting();
        } else {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            e();
        }
    }

    protected final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f6733e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i2 = (this.f6731c.isUseInnerHms() ? f6726k : f6725j).get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i2);
        if (i2 == 3) {
            f();
            b(1);
        } else {
            if (i2 != 5) {
                return;
            }
            b();
            b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f6731c.isUseInnerHms() + ", mInnerBinderAdapter:" + f6728m + ", mOuterBinderAdapter:" + f6727l);
        return this.f6731c.isUseInnerHms() ? f6728m : f6727l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f6731c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f6730b;
    }

    protected ClientSettings getClientSettings() {
        return this.f6731c;
    }

    public int getConnectionStatus() {
        return (this.f6731c.isUseInnerHms() ? f6726k : f6725j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f6729a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f6731c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f6731c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f6732d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f6729a);
        return this.f6731c.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f6731c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.f6731c.isUseInnerHms() ? f6725j.get() != 3 : f6726k.get() != 3;
    }

    public boolean isConnecting() {
        return (this.f6731c.isUseInnerHms() ? f6726k : f6725j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f6736h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f6732d = iAIDLInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return HMSPackageManager.getInstance(this.f6729a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    void b(int i2) {
        if (this.f6731c.isUseInnerHms()) {
            f6726k.set(i2);
        } else {
            f6725j.set(i2);
        }
    }

    public void connect(int i2, boolean z) {
        a(i2, z);
    }

    private void b() {
        synchronized (f6724i) {
            Handler handler = this.f6735g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f6735g = null;
            }
        }
    }

    void a() {
        String innerHmsPkg = this.f6731c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f6731c.isUseInnerHms()) {
            f6728m = InnerBinderAdapter.getInstance(this.f6729a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                b(5);
                f6728m.binder(d());
                return;
            }
        }
        f6727l = OuterBinderAdapter.getInstance(this.f6729a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            b(5);
            f6727l.binder(d());
        }
    }

    private void b(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f6729a, i2, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i3) {
                    if (i3 == 0 && BaseHmsClient.this.c()) {
                        BaseHmsClient.this.a();
                    } else {
                        BaseHmsClient.this.a(i3);
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i2, boolean z) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61100302 ======");
        int i3 = (this.f6731c.isUseInnerHms() ? f6726k : f6725j).get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i3);
        if (z || !(i3 == 3 || i3 == 5)) {
            if (getMinApkVersion() > i2) {
                i2 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i2 + " packageName:" + this.f6731c.getInnerHmsPkg());
            if (this.f6729a.getPackageName().equals(this.f6731c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
                return;
            }
            if (Util.isAvailableLibExist(this.f6729a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i2);
                int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f6729a);
                HMSLog.i("BaseHmsClient", "check available result: " + iIsHuaweiMobileServicesAvailable);
                if (iIsHuaweiMobileServicesAvailable == 0) {
                    a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(iIsHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, iIsHuaweiMobileServicesAvailable);
                    return;
                } else {
                    if (availableAdapter.isUserNoticeError(iIsHuaweiMobileServicesAvailable)) {
                        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                        a(availableAdapter, iIsHuaweiMobileServicesAvailable);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + iIsHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(iIsHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int iIsHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f6729a, i2);
            HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + iIsHuaweiMobileServicesAvailable2);
            if (iIsHuaweiMobileServicesAvailable2 == 0) {
                a();
            } else {
                a(iIsHuaweiMobileServicesAvailable2);
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i2) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i2 == 29) {
                i2 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f6729a, i2, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i3) {
                        BaseHmsClient.this.a(i3);
                    }
                });
            } else {
                a(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i2);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f6736h, new ConnectionResult(i2));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f6734f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f6736h;
        this.f6736h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f6734f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
