package com.heytap.msp.push.callback;

/* loaded from: classes.dex */
public interface ICallBackResultService {
    void onError(int i2, String str, String str2, String str3);

    void onGetNotificationStatus(int i2, int i3);

    void onGetPushStatus(int i2, int i3);

    void onRegister(int i2, String str, String str2, String str3);

    void onSetPushTime(int i2, String str);

    void onUnRegister(int i2, String str, String str2);
}
