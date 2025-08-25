package com.hicorenational.antifraud.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import bean.CallWarnBean;
import ui.callview.CallWarnCallView;

/* loaded from: classes.dex */
public class CallIntercepeService extends Service implements CallWarnCallView {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // ui.callview.CallWarnCallView
    public void onSuccRequest(CallWarnBean callWarnBean) {
    }
}
