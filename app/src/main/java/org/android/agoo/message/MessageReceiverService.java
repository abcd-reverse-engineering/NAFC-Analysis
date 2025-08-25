package org.android.agoo.message;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.BaseIntentService;
import org.android.agoo.service.SendMessage;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class MessageReceiverService extends Service {

    /* renamed from: a, reason: collision with root package name */
    SendMessage.Stub f17353a = new SendMessage.Stub() { // from class: org.android.agoo.message.MessageReceiverService.1
        @Override // org.android.agoo.service.SendMessage
        public int doSend(Intent intent) throws RemoteException {
            Context applicationContext = MessageReceiverService.this.getApplicationContext();
            MessageReceiverService messageReceiverService = MessageReceiverService.this;
            BaseIntentService.runIntentInService(applicationContext, intent, messageReceiverService.getIntentServiceClassName(messageReceiverService.getApplicationContext()));
            return 0;
        }
    };

    public abstract String getIntentServiceClassName(Context context);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        ALog.d("MessageReceiverService", "Message receiver aidl was binded {}", intent.getAction());
        return AgooConstants.BINDER_MSGRECEIVER_ACTION.equals(intent.getAction()) ? this.f17353a : this.f17353a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
