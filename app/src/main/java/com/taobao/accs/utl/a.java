package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public static final String TAG = "a";

    /* renamed from: a, reason: collision with root package name */
    private static Handler f8635a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r27, android.content.Intent r28, com.taobao.accs.base.AccsDataListener r29) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.a.a(android.content.Context, android.content.Intent, com.taobao.accs.base.AccsDataListener):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TaoBaseService.ExtraInfo c(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap map = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> mapA = a(map);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_HOST);
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = mapA;
            extraInfo.oriExtHeader = map;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    private static void a(String str, Runnable runnable) {
        if ("accs-impaas".equals(str) && t.e()) {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        } else {
            f8635a.post(runnable);
        }
    }

    public static NetPerformanceMonitor a(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable(Constants.KEY_MONIROT);
        } catch (Exception e2) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e2, new Object[0]);
            return null;
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> a(Map<Integer, String> map) {
        HashMap map2;
        if (map == null) {
            return null;
        }
        try {
            map2 = new HashMap();
            try {
                for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                    String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        map2.put(extHeaderType, str);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                ALog.e(TAG, "getExtHeader", e, new Object[0]);
                return map2;
            }
        } catch (Exception e3) {
            e = e3;
            map2 = null;
        }
        return map2;
    }

    private static void a(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.KEY_HOST);
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                com.taobao.accs.b accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.a(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            k.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
