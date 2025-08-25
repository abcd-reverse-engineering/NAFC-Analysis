package anet.channel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import anet.channel.util.ALog;
import com.huawei.hms.support.api.entity.core.CommonCode;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class h implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f1787a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f1788b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f1789c;

    h(SessionRequest sessionRequest, Intent intent, Context context) {
        this.f1789c = sessionRequest;
        this.f1787a = intent;
        this.f1788b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ALog.d("awcn.SessionRequest", "onServiceConnected", null, new Object[0]);
        try {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message message = new Message();
                message.getData().putParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.f1787a);
                messenger.send(message);
            } catch (Exception e2) {
                ALog.e("awcn.SessionRequest", "onServiceConnected sendMessage error.", null, e2, new Object[0]);
            }
        } finally {
            this.f1788b.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("awcn.SessionRequest", "onServiceDisconnected", null, new Object[0]);
        this.f1788b.unbindService(this);
    }
}
