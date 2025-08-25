package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a, reason: collision with root package name */
    private Context f6505a;

    /* renamed from: b, reason: collision with root package name */
    private PushPreferences f6506b;

    /* renamed from: c, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f6507c;

    private HmsInstanceId(Context context) {
        this.f6505a = context.getApplicationContext();
        this.f6506b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f6507c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f6507c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f6507c.setKitSdkVersion(61200300);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!e.e(this.f6505a)) {
            i.a(this.f6505a).removeKey("subjectId");
            return;
        }
        String string = i.a(this.f6505a).getString("subjectId");
        if (TextUtils.isEmpty(string)) {
            i.a(this.f6505a).saveString("subjectId", str);
            return;
        }
        if (string.contains(str)) {
            return;
        }
        i.a(this.f6505a).saveString("subjectId", string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        l.c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        b();
        try {
            if (this.f6506b.containsKey("aaid")) {
                this.f6506b.removeKey("aaid");
                this.f6506b.removeKey("creationTime");
                if (b.d(this.f6505a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f6505a);
                        return;
                    }
                    DeleteTokenReq deleteTokenReqA = b.a(this.f6505a);
                    deleteTokenReqA.setDeleteType(1);
                    deleteTokenReqA.setMultiSender(false);
                    a(deleteTokenReqA, 1);
                    BaseUtils.deleteAllTokenCache(this.f6505a);
                }
            }
        } catch (ApiException e2) {
            throw e2;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        b();
        a();
        DeleteTokenReq deleteTokenReqA = b.a(this.f6505a, str, str2);
        deleteTokenReqA.setMultiSender(false);
        a(deleteTokenReqA, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new a(this.f6505a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f6506b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f6506b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return b.b(this.f6505a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        b();
        a();
        TokenReq tokenReqB = b.b(this.f6505a, null, str2);
        tokenReqB.setAaid(getId());
        tokenReqB.setMultiSender(false);
        i.a(this.f6505a).saveString(this.f6505a.getPackageName(), "1");
        return a(tokenReqB, 1);
    }

    public void deleteToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String strC = b.c(this.f6505a);
            if (!TextUtils.isEmpty(strC)) {
                if (str.equals(strC)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq deleteTokenReqA = b.a(this.f6505a, str);
                deleteTokenReqA.setMultiSender(true);
                a(deleteTokenReqA, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        b();
        a();
        if (!TextUtils.isEmpty(str)) {
            String strC = b.c(this.f6505a);
            if (!TextUtils.isEmpty(strC)) {
                if (str.equals(strC)) {
                    return getToken(null, null);
                }
                TokenReq tokenReqB = b.b(this.f6505a, str);
                tokenReqB.setAaid(getId());
                tokenReqB.setMultiSender(true);
                return a(tokenReqB, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    private String a(TokenReq tokenReq, int i2) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f6505a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        String strA = h.a(this.f6505a, "push.gettoken");
        try {
            HMSLog.d(TAG, "getToken req :" + tokenReq.toString());
            g gVar = new g("push.gettoken", tokenReq, this.f6505a, strA);
            gVar.setApiLevel(i2);
            return ((TokenResult) Tasks.await(this.f6507c.doWrite(gVar))).getToken();
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                h.a(this.f6505a, "push.gettoken", strA, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f6505a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.gettoken", strA, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a(DeleteTokenReq deleteTokenReq, int i2) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f6505a, subjectId, null);
            return;
        }
        String strA = h.a(this.f6505a, "push.deletetoken");
        try {
            String strB = i.a(this.f6505a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(strB) || strB.equals(i.a(this.f6505a).b(null)))) {
                i.a(this.f6505a).removeKey(subjectId);
                HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(strB);
            f fVar = new f("push.deletetoken", deleteTokenReq, strA);
            fVar.setApiLevel(i2);
            Tasks.await(this.f6507c.doWrite(fVar));
            i.a(this.f6505a).c(subjectId);
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e2.getCause();
                h.a(this.f6505a, "push.deletetoken", strA, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f6505a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            h.a(context, "push.deletetoken", strA, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f6505a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f6505a)) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
