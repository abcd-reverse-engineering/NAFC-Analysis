package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.a;
import com.heytap.mcssdk.f;
import com.heytap.mcssdk.k.g;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

/* loaded from: classes.dex */
public class DataMessageCallbackService extends Service implements IDataMessageCallBackService {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        a.w().c(getApplicationContext());
        f.a(getApplicationContext(), intent, this);
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context context, DataMessage dataMessage) {
        g.b("Receive DataMessageCallbackService:messageTitle: " + dataMessage.getTitle() + " ------content:" + dataMessage.getContent() + "------describe:" + dataMessage.getDescription());
    }
}
