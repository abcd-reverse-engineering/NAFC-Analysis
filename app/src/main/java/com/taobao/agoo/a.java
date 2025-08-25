package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f8702a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseNotifyClick f8703b;

    a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f8703b = baseNotifyClick;
        this.f8702a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        Intent intent;
        Intent intent2 = null;
        try {
            if (this.f8702a != null) {
                String msgByThirdPush = this.f8703b.parseMsgByThirdPush(this.f8702a);
                if (TextUtils.isEmpty(msgByThirdPush) || TextUtils.isEmpty(this.f8703b.msgSource)) {
                    ALog.e("accs.BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", this.f8703b.msgSource);
                    intent = null;
                } else {
                    if (this.f8703b.notifyManager == null) {
                        this.f8703b.notifyManager = new NotifManager();
                    }
                    if (this.f8703b.agooFactory == null) {
                        this.f8703b.agooFactory = new AgooFactory();
                        this.f8703b.agooFactory.init(this.f8703b.context, this.f8703b.notifyManager, null);
                    }
                    Bundle bundleMsgReceiverPreHandler = this.f8703b.agooFactory.msgReceiverPreHandler(msgByThirdPush.getBytes("UTF-8"), this.f8703b.msgSource, null, false);
                    String string = bundleMsgReceiverPreHandler.getString("body");
                    ALog.i("accs.BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                    String encryptedMsg = AgooFactory.parseEncryptedMsg(string);
                    if (TextUtils.isEmpty(encryptedMsg)) {
                        ALog.e("accs.BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                    } else {
                        bundleMsgReceiverPreHandler.putString("body", encryptedMsg);
                    }
                    intent = new Intent();
                    try {
                        intent.putExtras(bundleMsgReceiverPreHandler);
                        this.f8703b.agooFactory.saveMsg(msgByThirdPush.getBytes("UTF-8"), "2");
                        this.f8703b.reportClickNotifyMsg(intent);
                    } catch (Throwable th) {
                        intent2 = intent;
                        th = th;
                        try {
                            ALog.e("accs.BaseNotifyClick", "buildMessage", th, new Object[0]);
                            try {
                                this.f8703b.onMessage(intent2);
                                return;
                            } catch (Throwable th2) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th2, new Object[0]);
                                return;
                            }
                        } catch (Throwable th3) {
                            try {
                                this.f8703b.onMessage(intent2);
                            } catch (Throwable th4) {
                                ALog.e("accs.BaseNotifyClick", "onMessage", th4, new Object[0]);
                            }
                            throw th3;
                        }
                    }
                }
            } else {
                intent = null;
            }
            try {
                this.f8703b.onMessage(intent);
            } catch (Throwable th5) {
                ALog.e("accs.BaseNotifyClick", "onMessage", th5, new Object[0]);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
