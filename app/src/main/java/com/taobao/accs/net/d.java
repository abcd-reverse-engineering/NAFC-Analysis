package com.taobao.accs.net;

import android.content.Intent;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8517a;

    d(a aVar) {
        this.f8517a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ALog.d(this.f8517a.d(), "startChannelService", new Object[0]);
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra("appKey", this.f8517a.i());
        intent.putExtra(Constants.KEY_TTID, this.f8517a.f8500a);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, GlobalClientInfo.getContext().getPackageName());
        intent.putExtra("app_sercet", this.f8517a.f8508i.getAppSecret());
        intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
        intent.putExtra(Config.PROPERTY_APP_KEY, Config.a(GlobalClientInfo.getContext()));
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f8517a.f8512m);
        intent.setClassName(GlobalClientInfo.getContext().getPackageName(), com.taobao.accs.utl.j.channelService);
        com.taobao.accs.a.a.a(GlobalClientInfo.getContext(), intent);
        Intent intent2 = new Intent();
        intent2.setAction(AgooConstants.INTENT_FROM_AGOO_REPORT);
        intent2.setPackage(GlobalClientInfo.getContext().getPackageName());
        String packageName = GlobalClientInfo.getContext().getPackageName();
        GlobalClientInfo.getContext().getPackageName();
        intent2.setClassName(packageName, com.taobao.accs.client.a.b());
        com.taobao.accs.a.a.a(GlobalClientInfo.getContext(), intent2);
    }
}
