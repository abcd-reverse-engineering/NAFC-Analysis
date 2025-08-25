package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.a;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: classes.dex */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6567a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6568b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6569c;

    /* renamed from: d, reason: collision with root package name */
    private BinderCallBack f6570d;

    /* renamed from: e, reason: collision with root package name */
    private IBinder f6571e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f6572f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f6573g = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler f6574h = null;

    /* renamed from: i, reason: collision with root package name */
    private Handler f6575i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i2);

        void onBinderFailed(int i2, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f6567a = context;
        this.f6568b = str;
        this.f6569c = str2;
    }

    private void c() {
        synchronized (this.f6572f) {
            Handler handler = this.f6574h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f6574h = null;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack binderCallBackF = BinderAdapter.this.f();
                if (binderCallBackF == null) {
                    return true;
                }
                binderCallBackF.onTimedDisconnected();
                return true;
            }
        });
        this.f6575i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f6567a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack binderCallBackF = f();
            if (binderCallBackF != null) {
                binderCallBackF.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e2) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f6570d;
    }

    private void g() {
        Handler handler = this.f6574h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f6574h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.b();
                    return true;
                }
            });
        }
        this.f6574h.sendEmptyMessageDelayed(getConnTimeOut(), a.q);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f6575i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.f6570d = binderCallBack;
        a();
    }

    protected int getConnTimeOut() {
        return 0;
    }

    protected int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f6568b;
    }

    public IBinder getServiceBinder() {
        return this.f6571e;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f6573g) {
            this.f6573g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f6571e = iBinder;
        c();
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f6567a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f6575i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f6575i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f6568b) || TextUtils.isEmpty(this.f6569c)) {
            e();
        }
        Intent intent = new Intent(this.f6568b);
        try {
            intent.setPackage(this.f6569c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f6572f) {
            if (this.f6567a.bindService(intent, this, 1)) {
                g();
            } else {
                this.f6573g = true;
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BinderCallBack binderCallBackF = f();
        if (binderCallBackF != null) {
            binderCallBackF.onBinderFailed(-1);
        }
    }
}
