package com.heytap.msp.push;

import android.content.Context;
import com.heytap.mcssdk.a;
import com.heytap.mcssdk.k.b;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.heytap.msp.push.notification.PushNotificationManager;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HeytapPushManager {
    public static void cancelNotification(JSONObject jSONObject) {
        a.w().d(jSONObject);
    }

    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(JSONObject jSONObject) {
        a.w().b(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(JSONObject jSONObject) {
        a.w().a(jSONObject);
    }

    public static void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        a.w().a(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        a.w().b(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        a.w().a(iGetAppNotificationCallBackService);
    }

    public static String getMcsPackageName(Context context) {
        return a.w().a(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(JSONObject jSONObject) {
        a.w().e(jSONObject);
    }

    public static ICallBackResultService getPushCallback() {
        return a.w().n();
    }

    public static PushNotificationManager getPushNotificationManager() {
        return PushNotificationManager.getInstance();
    }

    public static void getPushStatus() {
        a.w().q();
    }

    public static int getPushVersionCode() {
        return a.w().r();
    }

    public static String getPushVersionName() {
        return a.w().s();
    }

    public static String getReceiveSdkAction(Context context) {
        return a.w().b(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(JSONObject jSONObject) {
        a.w().i(jSONObject);
    }

    public static String getRegisterID() {
        return a.w().d();
    }

    public static int getSDKVersionCode() {
        return a.x();
    }

    public static String getSDKVersionName() {
        return a.y();
    }

    public static void init(Context context, boolean z) {
        a.w().a(context, z);
    }

    public static boolean isSupportPush(Context context) {
        return a.w().d(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(JSONObject jSONObject) {
        a.w().f(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(JSONObject jSONObject) {
        a.w().g(jSONObject);
    }

    public static void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) throws JSONException {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) throws JSONException {
        a.w().a(context, str, str2, jSONObject, iCallBackResultService);
    }

    @Deprecated
    public static void requestNotificationPermission() {
        a.w().e();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(JSONObject jSONObject) {
        a.w().c(jSONObject);
    }

    public static void setAppKeySecret(String str, String str2) {
        a.w().a(str, str2);
    }

    public static void setNotificationType(int i2) {
        setNotificationType(i2, null);
    }

    public static void setNotificationType(int i2, JSONObject jSONObject) {
        a.w().a(i2, jSONObject);
    }

    public static void setPushCallback(ICallBackResultService iCallBackResultService) {
        a.w().a(iCallBackResultService);
    }

    public static void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5) throws JSONException {
        setPushTime(list, i2, i3, i4, i5, null);
    }

    public static void setPushTime(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) throws JSONException {
        a.w().a(list, i2, i3, i4, i5, jSONObject);
    }

    public static void setRegisterID(String str) {
        a.w().a(str);
    }

    public static void statisticEvent(Context context, String str, DataMessage dataMessage) {
        StatisticUtils.statisticEvent(context, str, dataMessage);
    }

    @Deprecated
    public static void statisticMessage(Context context, MessageStat messageStat) {
        b.a(context, messageStat);
    }

    @Deprecated
    public static void statisticMessage(Context context, List<MessageStat> list) {
        b.a(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        a.w().b(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(JSONObject jSONObject) {
        a.w().h(jSONObject);
    }
}
