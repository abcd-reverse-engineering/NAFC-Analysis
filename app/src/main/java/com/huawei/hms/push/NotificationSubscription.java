package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d, reason: collision with root package name */
    private static final String f7165d = "NotificationSubscription";

    /* renamed from: a, reason: collision with root package name */
    private Activity f7166a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7167b;

    /* renamed from: c, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7168c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f7167b = activity.getApplicationContext();
        this.f7166a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f7168c = huaweiApi;
        huaweiApi.setKitSdkVersion(61200300);
    }

    private Task<SubscribeResult> a(List<String> list) {
        String strReportEntry = PushBiUtil.reportEntry(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list == null || list.isEmpty() || list.size() > 3) {
            PushBiUtil.reportExit(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e(f7165d, "Invalid entityIds: entityId list should not be empty or more than max size");
            return a(ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException());
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            PushBiUtil.reportExit(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, ErrorEnum.ERROR_MAIN_THREAD);
            return a(ErrorEnum.ERROR_MAIN_THREAD.toApiException());
        }
        if (!((NotificationManager) this.f7167b.getSystemService("notification")).areNotificationsEnabled()) {
            HMSLog.i(f7165d, "App disabled notification");
            PushBiUtil.reportExit(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, ErrorEnum.ERROR_NOTIFICATION_DISABLED);
            return a(ErrorEnum.ERROR_NOTIFICATION_DISABLED.toApiException());
        }
        try {
            if (v.a(this.f7167b) != ErrorEnum.SUCCESS) {
                return a(ErrorEnum.ERROR_NO_TOKEN.toApiException());
            }
            if (-1 != this.f7167b.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f7167b.getPackageName()) && g.a(this.f7167b) == -1) {
                HMSLog.e(f7165d, "no network");
                return a(ErrorEnum.ERROR_NO_NETWORK.toApiException());
            }
            Task taskDoWrite = this.f7168c.doWrite(new SubscribeNotificationTask(this.f7166a, PushNaming.SUBSCRIBE_NOTIFICATION, b(list), strReportEntry));
            Tasks.await(taskDoWrite);
            return taskDoWrite;
        } catch (Exception e2) {
            if (!(e2.getCause() instanceof ApiException)) {
                PushBiUtil.reportExit(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                return a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
            ApiException apiException = (ApiException) e2.getCause();
            PushBiUtil.reportExit(this.f7167b, PushNaming.SUBSCRIBE_NOTIFICATION, strReportEntry, apiException.getStatusCode());
            return a(apiException);
        }
    }

    private SubscribeNotificationReq b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f7167b, null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra("errorMsg");
        } catch (Throwable unused) {
            HMSLog.e(f7165d, "get subscribe result occurs exception");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("subscribedItems");
            if (!TextUtils.isEmpty(stringExtra2)) {
                List<SubscribedItem> listA = b.a(stringExtra2);
                SubscribeResult subscribeResult = new SubscribeResult();
                subscribeResult.setSubscribedItems(listA);
                return subscribeResult;
            }
            return null;
        }
        SubscribeResult subscribeResult2 = new SubscribeResult();
        subscribeResult2.setErrorMsg(stringExtra);
        HMSLog.e(f7165d, "get subscribe error msg:" + stringExtra);
        return subscribeResult2;
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.i(f7165d, "invoke request subscribe notification");
        return a(list);
    }

    private Task<SubscribeResult> a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
