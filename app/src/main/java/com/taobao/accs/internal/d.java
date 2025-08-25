package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.v;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class d implements IBaseService {

    /* renamed from: a, reason: collision with root package name */
    protected static ConcurrentHashMap<String, com.taobao.accs.net.a> f8495a = new ConcurrentHashMap<>(2);

    /* renamed from: b, reason: collision with root package name */
    private Context f8496b;

    /* renamed from: c, reason: collision with root package name */
    private Service f8497c;

    public d(Service service2) {
        this.f8497c = null;
        this.f8497c = service2;
        this.f8496b = service2.getApplicationContext();
    }

    protected static com.taobao.accs.net.a a(Context context, String str, boolean z) {
        com.taobao.accs.net.a vVar = null;
        try {
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "getConnection", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.w("ElectionServiceImpl", "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(f8495a.size()));
            if (f8495a.size() > 0) {
                return f8495a.elements().nextElement();
            }
            return null;
        }
        ALog.i("ElectionServiceImpl", "getConnection", Constants.KEY_CONFIG_TAG, str, "start", Boolean.valueOf(z));
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag != null && configByTag.getDisableChannel()) {
            ALog.e("ElectionServiceImpl", "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
            return null;
        }
        int iB = v.b(context);
        String str2 = str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + iB;
        synchronized (d.class) {
            try {
                com.taobao.accs.net.a aVar = f8495a.get(str2);
                if (aVar == null) {
                    try {
                        AccsClientConfig.mEnv = iB;
                        vVar = new com.taobao.accs.net.v(context, 0, str);
                        f8495a.put(str2, vVar);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    vVar = aVar;
                }
                if (z) {
                    vVar.a();
                }
                return vVar;
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private void b(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra("appKey");
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            int intExtra = intent.getIntExtra(Constants.KEY_MODE, 0);
            ALog.i("ElectionServiceImpl", "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, com.heytap.mcssdk.constant.b.A, stringExtra4, Constants.KEY_TTID, stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.f8496b.getPackageName())) {
                v.a(this.f8496b, intExtra);
                com.taobao.accs.net.a aVarA = a(this.f8496b, stringExtra5, false);
                if (aVarA != null) {
                    aVarA.f8500a = stringExtra3;
                } else {
                    ALog.e("ElectionServiceImpl", "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
                }
            }
        } catch (Throwable th) {
            ALog.e("ElectionServiceImpl", "handleStartCommand", th, new Object[0]);
        }
    }

    public abstract int a(Intent intent);

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", "sdkVersion", 221);
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.f8496b = null;
        this.f8497c = null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            b(intent);
        }
        return a(intent);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    protected static com.taobao.accs.net.a b(Context context, String str, boolean z) {
        return a(context, str, z);
    }
}
