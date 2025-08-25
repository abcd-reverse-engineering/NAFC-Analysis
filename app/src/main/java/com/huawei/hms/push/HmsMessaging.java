package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import com.vivo.push.PushClientConstants;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f7159c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    private Context f7160a;

    /* renamed from: b, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f7161b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f7160a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f7161b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f7161b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f7161b.setKitSdkVersion(61200300);
    }

    private Task<Void> a(String str, String str2) throws ApiException {
        String strReportEntry = PushBiUtil.reportEntry(this.f7160a, PushNaming.SUBSCRIBE);
        if (str == null || !f7159c.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f7160a, PushNaming.SUBSCRIBE, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        }
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "use proxy subscribe.");
            return TextUtils.equals(str2, "Sub") ? ProxyCenter.getProxy().subscribe(this.f7160a, str, strReportEntry) : ProxyCenter.getProxy().unsubscribe(this.f7160a, str, strReportEntry);
        }
        try {
            ErrorEnum errorEnumA = v.a(this.f7160a);
            if (errorEnumA != ErrorEnum.SUCCESS) {
                throw errorEnumA.toApiException();
            }
            if (NetWorkUtil.getNetworkType(this.f7160a) == 0) {
                HMSLog.e("HmsMessaging", "no network");
                throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
            }
            SubscribeReq subscribeReq = new SubscribeReq(this.f7160a, str2, str);
            subscribeReq.setToken(BaseUtils.getLocalToken(this.f7160a, null));
            return d.b() ? this.f7161b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), strReportEntry)) : this.f7161b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), strReportEntry));
        } catch (ApiException e2) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(e2);
            PushBiUtil.reportExit(this.f7160a, PushNaming.SUBSCRIBE, strReportEntry, e2.getStatusCode());
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            PushBiUtil.reportExit(this.f7160a, PushNaming.SUBSCRIBE, strReportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
            return taskCompletionSource2.getTask();
        }
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        return new HmsMessaging(context);
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f7160a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
        HMSLog.i("HmsMessaging", "send upstream message");
        a(remoteMessage);
    }

    public void setAutoInitEnabled(boolean z) {
        AutoInitHelper.setAutoInitEnabled(this.f7160a, z);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f7160a, null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f7160a, null);
        }
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(str, "UnSub");
    }

    private void a(RemoteMessage remoteMessage) {
        String strReportEntry = PushBiUtil.reportEntry(this.f7160a, PushNaming.UPSEND_MSG);
        ErrorEnum errorEnumA = v.a(this.f7160a);
        if (errorEnumA == ErrorEnum.SUCCESS) {
            if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                    if (!TextUtils.isEmpty(remoteMessage.getData())) {
                        UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                        upSendMsgReq.setPackageName(this.f7160a.getPackageName());
                        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                        upSendMsgReq.setTo(remoteMessage.getTo());
                        upSendMsgReq.setData(remoteMessage.getData());
                        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                        upSendMsgReq.setTtl(remoteMessage.getTtl());
                        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                        if (d.b()) {
                            this.f7161b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), strReportEntry));
                            return;
                        } else {
                            a(upSendMsgReq, strReportEntry);
                            return;
                        }
                    }
                    HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
                    PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                }
                HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
            }
            HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, strReportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        HMSLog.e("HmsMessaging", "Message sent failed:" + errorEnumA.getExternalCode() + ':' + errorEnumA.getMessage());
        PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, strReportEntry, errorEnumA);
        throw new UnsupportedOperationException(errorEnumA.getMessage());
    }

    private Task<Void> a(boolean z) {
        String strReportEntry = PushBiUtil.reportEntry(this.f7160a, PushNaming.SET_NOTIFY_FLAG);
        if (d.d(this.f7160a) && !d.b()) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
                PushBiUtil.reportExit(this.f7160a, PushNaming.SET_NOTIFY_FLAG, strReportEntry, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
                return taskCompletionSource.getTask();
            }
            if (d.b(this.f7160a) < 90101310) {
                HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
                Intent intentPutExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f7160a, this.f7160a.getPackageName() + "#" + z));
                intentPutExtra.setPackage(DispatchConstants.ANDROID);
                return Tasks.callInBackground(new IntentCallable(this.f7160a, intentPutExtra, strReportEntry));
            }
            if (d.b(this.f7160a) < 110118300) {
                HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
                new PushPreferences(this.f7160a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
                Uri uri = Uri.parse("content://" + this.f7160a.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
                Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
                intent.putExtra("type", "enalbeFlag");
                intent.putExtra(PushClientConstants.TAG_PKG_NAME, this.f7160a.getPackageName());
                intent.putExtra("url", uri);
                intent.setPackage(DispatchConstants.ANDROID);
                return Tasks.callInBackground(new IntentCallable(this.f7160a, intent, strReportEntry));
            }
            HMSLog.i("HmsMessaging", "turn on/off with broadcast v3");
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f7160a, null))) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                return taskCompletionSource2.getTask();
            }
            new PushPreferences(this.f7160a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
            Intent intent2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
            intent2.putExtra("enalbeFlag", z);
            intent2.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f7160a, null));
            intent2.putExtra(PushClientConstants.TAG_PKG_NAME, this.f7160a.getPackageName());
            intent2.putExtra("uid", this.f7160a.getApplicationInfo().uid);
            intent2.setPackage(DispatchConstants.ANDROID);
            return Tasks.callInBackground(new IntentCallable(this.f7160a, intent2, strReportEntry));
        }
        HMSLog.i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(this.f7160a.getPackageName());
        enableNotifyReq.setEnable(z);
        return this.f7161b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), strReportEntry));
    }

    private void a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f7160a, null));
        try {
            this.f7161b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e2) {
            if (e2.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, str, ((ApiException) e2.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f7160a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
