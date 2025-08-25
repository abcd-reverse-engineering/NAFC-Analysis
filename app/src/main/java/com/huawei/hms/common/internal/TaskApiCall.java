package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final String f6777a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6778b;

    /* renamed from: c, reason: collision with root package name */
    private Parcelable f6779c;

    /* renamed from: d, reason: collision with root package name */
    private String f6780d;

    /* renamed from: e, reason: collision with root package name */
    private CancellationToken f6781e;

    /* renamed from: f, reason: collision with root package name */
    private int f6782f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f6782f = 1;
        this.f6777a = str;
        this.f6778b = str2;
        this.f6779c = null;
        this.f6780d = null;
    }

    protected abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f6782f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f6779c;
    }

    public String getRequestJson() {
        return this.f6778b;
    }

    public CancellationToken getToken() {
        return this.f6781e;
    }

    public String getTransactionId() {
        return this.f6780d;
    }

    public String getUri() {
        return this.f6777a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f6781e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f6777a + ", transactionId:" + this.f6780d);
            return;
        }
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f6777a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f6780d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i2) {
        this.f6782f = i2;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f6779c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f6781e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f6780d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f6782f = 1;
        this.f6777a = str;
        this.f6778b = str2;
        this.f6779c = null;
        this.f6780d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i2) {
        this.f6777a = str;
        this.f6778b = str2;
        this.f6779c = null;
        this.f6780d = str3;
        this.f6782f = i2;
    }
}
