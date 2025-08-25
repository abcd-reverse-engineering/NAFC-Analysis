package a.a.o;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1169a = "anet.NetworkSdkSetting";

    /* renamed from: c, reason: collision with root package name */
    private static Context f1171c;
    public static ENV CURRENT_ENV = ENV.ONLINE;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f1170b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, Object> f1172d = null;

    private static void a() {
        try {
            Utils.invokeStaticMethodThrowException("anet.channel.TaobaoNetworkAdapter", "init", new Class[]{Context.class, HashMap.class}, f1171c, f1172d);
            ALog.i(f1169a, "init taobao adapter success", null, new Object[0]);
        } catch (Exception e2) {
            ALog.i(f1169a, "initTaobaoAdapter failed. maybe not taobao app", null, e2);
        }
    }

    public static Context getContext() {
        return f1171c;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f1170b.compareAndSet(false, true)) {
                ALog.e(f1169a, "NetworkSdkSetting init", null, new Object[0]);
                f1171c = context;
                GlobalAppRuntimeInfo.setInitTime(System.currentTimeMillis());
                GlobalAppRuntimeInfo.setContext(context);
                a.a.k.b.d();
                a();
                a.a.q.a.d();
                if (!AwcnConfig.isTbNextLaunch()) {
                    a.a.l.a.a(context);
                }
                SessionCenter.init(context);
            }
        } catch (Throwable th) {
            ALog.e(f1169a, "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    public static void setTtid(String str) {
        GlobalAppRuntimeInfo.setTtid(str);
    }

    public static void init(Application application, HashMap<String, Object> map) {
        try {
            GlobalAppRuntimeInfo.setTtid((String) map.get(Constants.KEY_TTID));
            GlobalAppRuntimeInfo.setUtdid((String) map.get("deviceId"));
            String str = (String) map.get(UMModuleRegister.PROCESS);
            if (!TextUtils.isEmpty(str)) {
                GlobalAppRuntimeInfo.setCurrentProcess(str);
            }
            f1172d = new HashMap<>(map);
            init(application.getApplicationContext());
            f1172d = null;
        } catch (Exception e2) {
            ALog.e(f1169a, "Network SDK initial failed!", null, e2, new Object[0]);
        }
    }
}
