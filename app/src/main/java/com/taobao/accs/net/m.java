package com.taobao.accs.net;

import android.content.Intent;
import anet.channel.ISessionListener;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class m implements ISessionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f8538a;

    m(k kVar) {
        this.f8538a = kVar;
    }

    @Override // anet.channel.ISessionListener
    public void onConnectionChanged(Intent intent) {
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
            ALog.e(this.f8538a.d(), "onConnectionChanged", "currentHost", DefaultWebClient.HTTPS_SCHEME + this.f8538a.f8508i.getInappHost(), "changeHost", stringExtra, "state", Boolean.valueOf(booleanExtra));
            if ((DefaultWebClient.HTTPS_SCHEME + this.f8538a.f8508i.getInappHost()).equals(stringExtra)) {
                g.a(GlobalClientInfo.getContext()).a();
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, -1);
                String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                boolean booleanExtra3 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                TaoBaseService.ConnectInfo connectInfo = booleanExtra ? new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3) : new TaoBaseService.ConnectInfo(stringExtra, booleanExtra2, booleanExtra3, intExtra, stringExtra2);
                connectInfo.connected = booleanExtra;
                Iterator<AccsConnectStateListener> it = this.f8538a.n().iterator();
                while (it.hasNext()) {
                    this.f8538a.r.post(new n(this, connectInfo, it.next()));
                }
            }
        }
    }
}
