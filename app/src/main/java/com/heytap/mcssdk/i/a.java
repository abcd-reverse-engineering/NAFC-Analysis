package com.heytap.mcssdk.i;

import android.content.Context;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.f;
import com.heytap.mcssdk.k.g;
import com.heytap.mcssdk.k.i;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: com.heytap.mcssdk.i.a$a, reason: collision with other inner class name */
    class RunnableC0096a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.c f5882a;

        RunnableC0096a(f.c cVar) {
            this.f5882a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() throws NumberFormatException {
            a.this.a(this.f5882a, com.heytap.mcssdk.a.w());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.c cVar, com.heytap.mcssdk.a aVar) throws NumberFormatException {
        String str;
        if (cVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (aVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (aVar.n() != null) {
                int iE = cVar.e();
                if (iE == 12287) {
                    ICallBackResultService iCallBackResultServiceN = aVar.n();
                    if (iCallBackResultServiceN != null) {
                        iCallBackResultServiceN.onError(cVar.g(), cVar.f(), cVar.i(), cVar.h());
                        return;
                    }
                    return;
                }
                if (iE == 12298) {
                    aVar.n().onSetPushTime(cVar.g(), cVar.f());
                    return;
                }
                if (iE == 12306) {
                    aVar.n().onGetPushStatus(cVar.g(), com.heytap.mcssdk.k.c.a(cVar.f()));
                    return;
                }
                if (iE == 12309) {
                    aVar.n().onGetNotificationStatus(cVar.g(), com.heytap.mcssdk.k.c.a(cVar.f()));
                    return;
                }
                if (iE == 12289) {
                    if (cVar.g() == 0) {
                        aVar.a(cVar.f());
                    }
                    aVar.n().onRegister(cVar.g(), cVar.f(), cVar.i(), cVar.h());
                    return;
                }
                if (iE == 12290) {
                    aVar.n().onUnRegister(cVar.g(), cVar.i(), cVar.h());
                    return;
                }
                switch (iE) {
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        ISetAppNotificationCallBackService iSetAppNotificationCallBackServiceP = aVar.p();
                        if (iSetAppNotificationCallBackServiceP != null) {
                            iSetAppNotificationCallBackServiceP.onSetAppNotificationSwitch(cVar.g());
                            break;
                        }
                        break;
                    case MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        int i2 = 0;
                        try {
                            i2 = Integer.parseInt(cVar.f());
                        } catch (Exception unused) {
                        }
                        IGetAppNotificationCallBackService iGetAppNotificationCallBackServiceO = aVar.o();
                        if (iGetAppNotificationCallBackServiceO != null) {
                            iGetAppNotificationCallBackServiceO.onGetAppNotificationSwitch(cVar.g(), i2);
                            break;
                        }
                        break;
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        g.e(str);
    }

    @Override // com.heytap.mcssdk.i.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            f.c cVar = (f.c) baseMode;
            g.b("mcssdk-CallBackResultProcessor:" + cVar.toString());
            i.b(new RunnableC0096a(cVar));
        }
    }
}
