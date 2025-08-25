package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: classes.dex */
public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        static final int POWER_SAVER_MODE = 4;
        static final String SMART_MODE_STATUS = "SmartModeStatus";
    }

    public static boolean isAppIdleMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "isAppIdleMode Context is null!");
            return false;
        }
        String packageName = context.getPackageName();
        UsageStatsManager usageStatsManager = null;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            Logger.i(TAG, "isAppIdleMode statsManager is null!");
        } else if (i2 >= 22) {
            Object systemService = context.getSystemService("usagestats");
            if (!(systemService instanceof UsageStatsManager)) {
                return false;
            }
            usageStatsManager = (UsageStatsManager) systemService;
        }
        if (usageStatsManager == null) {
            Logger.i(TAG, "isAppIdleMode statsManager is null!");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return usageStatsManager.isAppInactive(packageName);
        }
        return false;
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
        Object systemService = ContextCompat.getSystemService(context, "power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null) {
            Logger.i(TAG, "isDozeIdleMode powerManager is null!");
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            Logger.i(TAG, "isDozeIdleMode is version control state!");
            return false;
        }
        try {
            return powerManager.isDeviceIdleMode();
        } catch (RuntimeException e2) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
            return false;
        }
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e2) {
                        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e2.getClass().getSimpleName() + e2.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e2) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
                }
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            Logger.i(TAG, "readDataSaverMode Context is null!");
            return 0;
        }
        if (Build.VERSION.SDK_INT < 16 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return 0;
        }
        if (!connectivityManager.isActiveNetworkMetered()) {
            Logger.v(TAG, "ConnectType is not Mobile Network!");
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
        return 0;
    }

    public static int readPowerSaverMode(Context context) {
        if (context == null) {
            Logger.i(TAG, "readPowerSaverMode Context is null!");
            return 0;
        }
        int systemInt = SettingUtil.getSystemInt(context.getContentResolver(), "SmartModeStatus", 0);
        if (systemInt == 0) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        return powerManager.isPowerSaveMode() ? 4 : 0;
                    } catch (RuntimeException e2) {
                        Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
                    }
                } else {
                    Logger.i(TAG, "readPowerSaverMode is control by version!");
                }
            }
        }
        return systemInt;
    }
}
