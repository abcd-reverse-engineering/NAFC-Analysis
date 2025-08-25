package com.heytap.mcssdk.i;

import android.app.NotificationManager;
import android.content.Context;
import com.heytap.mcssdk.k.g;
import com.heytap.mcssdk.k.i;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f5884a = 1;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataMessage f5885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5886b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IDataMessageCallBackService f5887c;

        a(DataMessage dataMessage, Context context, IDataMessageCallBackService iDataMessageCallBackService) {
            this.f5885a = dataMessage;
            this.f5886b = context;
            this.f5887c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5885a.getMsgCommand() == 1) {
                b.this.a(this.f5886b, this.f5885a);
            } else {
                this.f5887c.processMessage(this.f5886b, this.f5885a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, DataMessage dataMessage) {
        if (context == null) {
            g.b("context is null");
            return;
        }
        g.b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((NotificationManager) context.getSystemService("notification")).cancel(dataMessage.getNotifyID());
        b(context, dataMessage);
    }

    private void b(Context context, DataMessage dataMessage) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(dataMessage);
        map.put(dataMessage.getEventId(), arrayList);
        StatisticUtils.statisticEvent(context, map);
    }

    @Override // com.heytap.mcssdk.i.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            DataMessage dataMessage = (DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                i.b(new a(dataMessage, context, iDataMessageCallBackService));
            }
        }
    }
}
