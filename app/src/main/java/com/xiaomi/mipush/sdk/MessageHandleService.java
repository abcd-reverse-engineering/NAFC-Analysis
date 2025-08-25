package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.ae;
import com.xiaomi.push.dt;
import com.xiaomi.push.ed;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f12340a = new ConcurrentLinkedQueue<>();

    /* renamed from: a, reason: collision with other field name */
    private static ExecutorService f90a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Intent f12343a;

        /* renamed from: a, reason: collision with other field name */
        private PushMessageReceiver f92a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f92a = pushMessageReceiver;
            this.f12343a = intent;
        }

        /* renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m68a() {
            return this.f92a;
        }

        public Intent a() {
            return this.f12343a;
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f12340a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(final Context context) {
        if (f90a.isShutdown()) {
            return;
        }
        f90a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.2
            @Override // java.lang.Runnable
            public void run() {
                MessageHandleService.c(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f12340a.poll());
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MessageHandleService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a(e2.getMessage());
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }

    protected static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar == null) {
            return;
        }
        try {
            PushMessageReceiver pushMessageReceiverM68a = aVar.m68a();
            Intent intentA = aVar.a();
            int intExtra = intentA.getIntExtra("message_type", 1);
            if (intExtra != 1) {
                if (intExtra != 3) {
                    if (intExtra == 4 || intExtra != 5 || !PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(intentA.getStringExtra(PushMessageHelper.ERROR_TYPE)) || (stringArrayExtra = intentA.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");
                    pushMessageReceiverM68a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) intentA.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                pushMessageReceiverM68a.onCommandResult(context, miPushCommandMessage);
                if (TextUtils.equals(miPushCommandMessage.getCommand(), ed.COMMAND_REGISTER.f424a)) {
                    pushMessageReceiverM68a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() == 0) {
                        f.b(context);
                        return;
                    }
                    return;
                }
                return;
            }
            PushMessageHandler.a aVarA = t.a(context).a(intentA);
            int intExtra2 = intentA.getIntExtra("eventMessageType", -1);
            if (aVarA != null) {
                if (aVarA instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) aVarA;
                    if (!miPushMessage.isArrivedMessage()) {
                        pushMessageReceiverM68a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        dt.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 2004, (String) null);
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        pushMessageReceiverM68a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (miPushMessage.isNotified()) {
                        if (intExtra2 == 1000) {
                            dt.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 1007, (String) null);
                        } else {
                            dt.a(context.getApplicationContext()).a(context.getPackageName(), intentA, 3007, (String) null);
                        }
                        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        pushMessageReceiverM68a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                    pushMessageReceiverM68a.onNotificationMessageArrived(context, miPushMessage);
                    return;
                }
                if (aVarA instanceof MiPushCommandMessage) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) aVarA;
                    com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    pushMessageReceiverM68a.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ed.COMMAND_REGISTER.f424a)) {
                        pushMessageReceiverM68a.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            f.b(context);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "unknown raw message: " + aVarA);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "no message from raw for receiver");
        } catch (RuntimeException e2) {
            com.xiaomi.channel.commonutils.logger.b.a("MessageHandleService", e2);
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo74a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f12340a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
