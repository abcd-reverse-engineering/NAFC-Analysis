package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.umeng.ut.device.UTDevice;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static String f8676a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f8677b = "";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f8678c = true;
    public static final String channelService = "com.taobao.accs.ChannelService";

    /* renamed from: d, reason: collision with root package name */
    private static boolean f8679d = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean a(Context context) {
        String str;
        if (f8679d) {
            return f8678c;
        }
        try {
            if (TextUtils.isEmpty(com.taobao.accs.client.a.f8407c)) {
                if (TextUtils.isEmpty(f8676a)) {
                    f8676a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                str = f8676a;
            } else {
                str = com.taobao.accs.client.a.f8407c;
            }
            if (TextUtils.isEmpty(f8677b)) {
                f8677b = a(context, Process.myPid());
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f8677b)) {
                f8678c = str.equalsIgnoreCase(f8677b);
                f8679d = true;
            }
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
        }
        return f8678c;
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String c(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return String.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } catch (Throwable th) {
                ALog.e("AdapterUtilityImpl", "Android above 7.0 isNotificationEnabled", th, new Object[0]);
            }
        } else {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                boolean z = true;
                if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i2), packageName)).intValue() != 0) {
                    z = false;
                }
                return String.valueOf(z);
            } catch (Throwable th2) {
                ALog.e("AdapterUtilityImpl", "isNotificationEnabled", th2, new Object[0]);
            }
        }
        return "unknown";
    }

    public static String a(Context context, int i2) {
        IProcessName iProcessName = com.taobao.accs.client.a.f8409e;
        if (iProcessName != null) {
            return iProcessName.getCurrProcessName();
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com.taobao.accs.client.a.a(context).a().getRunningAppProcesses()) {
            try {
                if (runningAppProcessInfo.pid == i2) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static long a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (!dataDirectory.exists()) {
                return -1L;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public static boolean a(String str, int i2) {
        if (str == null) {
            return false;
        }
        try {
            StatFs statFs = new StatFs(str);
            int blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            StringBuilder sb = new StringBuilder();
            sb.append("st.getAvailableBlocks()=");
            sb.append(statFs.getAvailableBlocks());
            sb.append(",st.getAvailableBlocks() * blockSize=");
            long j2 = blockSize;
            sb.append(statFs.getAvailableBlocks() * j2);
            ALog.d("FileCheckUtils", sb.toString(), new Object[0]);
            return statFs.getAvailableBlocks() > 10 && availableBlocks * j2 > ((long) i2);
        } catch (Throwable unused) {
            return false;
        }
    }
}
