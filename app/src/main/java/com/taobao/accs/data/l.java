package com.taobao.accs.data;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f8476a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MsgDistributeService f8477b;

    l(MsgDistributeService msgDistributeService, Intent intent) {
        this.f8477b = msgDistributeService;
        this.f8476a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.i("MsgDistributeService", "onStartCommand send message", new Object[0]);
        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) this.f8476a.getSerializableExtra(Constants.KEY_SEND_REQDATA);
        String stringExtra = this.f8476a.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = this.f8476a.getStringExtra("appKey");
        String stringExtra3 = this.f8476a.getStringExtra(Constants.KEY_CONFIG_TAG);
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra2;
        }
        ACCSManager.getAccsInstance(this.f8477b.getApplicationContext(), stringExtra2, stringExtra3).a(this.f8477b.getApplicationContext(), accsRequest, stringExtra, false);
    }
}
