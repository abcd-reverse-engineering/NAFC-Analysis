package com.umeng.message.api;

import com.umeng.message.UmengMessageService;
import com.umeng.message.tag.TagManager;

/* loaded from: classes2.dex */
public interface UPushApi {
    void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback);

    void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback);

    void disable(UPushSettingCallback uPushSettingCallback);

    void enable(UPushSettingCallback uPushSettingCallback);

    int getDisplayNotificationNumber();

    String getMessageAppkey();

    String getMessageChannel();

    UPushMessageHandler getMessageHandler();

    UPushMessageNotifyApi getMessageNotifyApi();

    String getMessageSecret();

    int getMuteDurationSeconds();

    int getNoDisturbEndHour();

    int getNoDisturbEndMinute();

    int getNoDisturbStartHour();

    int getNoDisturbStartMinute();

    String getNotificationChannelName();

    UPushMessageHandler getNotificationClickHandler();

    boolean getNotificationOnForeground();

    int getNotificationPlayLights();

    int getNotificationPlaySound();

    int getNotificationPlayVibrate();

    String getNotificationSilenceChannelName();

    String getPushIntentServiceClass();

    UPushRegisterCallback getRegisterCallback();

    String getRegistrationId();

    String getResourcePackageName();

    UPushSettingCallback getSettingCallback();

    TagManager getTagManager();

    UPushThirdTokenCallback getThirdTokenCallback();

    boolean isPushCheck();

    void keepLowPowerMode(boolean z);

    void onAppStart();

    void register(UPushRegisterCallback uPushRegisterCallback);

    void setAccsHeartbeatEnable(boolean z);

    void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback);

    void setDisplayNotificationNumber(int i2);

    void setEnableAlarmHeartbeat(boolean z);

    void setEnableForeground(boolean z);

    void setEnableJobHeartbeat(boolean z);

    void setMessageHandler(UPushMessageHandler uPushMessageHandler);

    void setMuteDurationSeconds(int i2);

    void setNoDisturbMode(int i2, int i3, int i4, int i5);

    void setNotificationChannelName(String str);

    void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler);

    void setNotificationOnForeground(boolean z);

    void setNotificationPlayLights(int i2);

    void setNotificationPlaySound(int i2);

    void setNotificationPlayVibrate(int i2);

    void setNotificationSilenceChannelName(String str);

    void setPullUpEnable(boolean z);

    void setPushCheck(boolean z);

    <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls);

    void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback);

    void setResourcePackageName(String str);

    void setSettingCallback(UPushSettingCallback uPushSettingCallback);

    void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback);
}
