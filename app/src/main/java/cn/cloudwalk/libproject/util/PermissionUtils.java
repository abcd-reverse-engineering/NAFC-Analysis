package cn.cloudwalk.libproject.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.List;

/* loaded from: classes.dex */
public class PermissionUtils {
    private static final int OPEN_PERMISSIONS_MANUALLY = 1011;
    private static final int PERMISSION_REQUEST_CODE = 136;
    private static PermissionUtils permissionsUtils;
    private AlertDialog mPermissionDialog;
    private IPermissionsResult mPermissionsResult;

    public interface IPermissionsResult {
        void forbidPermissions();

        void passPermissions();
    }

    public static PermissionUtils getInstance() {
        if (permissionsUtils == null) {
            permissionsUtils = new PermissionUtils();
        }
        return permissionsUtils;
    }

    private boolean isAppOnForeground(Activity activity) {
        ActivityManager activityManager = (ActivityManager) activity.getApplicationContext().getSystemService("activity");
        String packageName = activity.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    private boolean permissionIsGranted(Activity activity, String[] strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        for (String str : strArr) {
            if (activity.checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean privateShouldShowRequestPermissionRationale(Activity activity, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 23 && strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (activity.shouldShowRequestPermissionRationale(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void showSystemPermissionsSettingDialog(final Activity activity) {
        AlertDialog alertDialog;
        final String packageName = activity.getPackageName();
        if (this.mPermissionDialog == null) {
            this.mPermissionDialog = new AlertDialog.Builder(activity).setTitle("申请权限").setMessage("已禁用权限，请手动授予").setPositiveButton("设置", new DialogInterface.OnClickListener() { // from class: cn.cloudwalk.libproject.util.PermissionUtils.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    PermissionUtils.this.cancelPermissionDialog();
                    activity.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + packageName)), 1011);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: cn.cloudwalk.libproject.util.PermissionUtils.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    PermissionUtils.this.cancelPermissionDialog();
                    PermissionUtils.this.mPermissionsResult.forbidPermissions();
                }
            }).create();
        }
        if (!isAppOnForeground(activity) || (alertDialog = this.mPermissionDialog) == null || alertDialog.isShowing()) {
            return;
        }
        this.mPermissionDialog.show();
    }

    public void cancelPermissionDialog() {
        AlertDialog alertDialog = this.mPermissionDialog;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.mPermissionDialog = null;
        }
    }

    public void checkPermissions(Activity activity, String[] strArr, IPermissionsResult iPermissionsResult) {
        this.mPermissionsResult = iPermissionsResult;
        if (Build.VERSION.SDK_INT < 23) {
            iPermissionsResult.passPermissions();
            return;
        }
        if (permissionIsGranted(activity, strArr)) {
            iPermissionsResult.passPermissions();
        } else if (privateShouldShowRequestPermissionRationale(activity, strArr)) {
            showSystemPermissionsSettingDialog(activity);
        } else {
            activity.requestPermissions(strArr, PERMISSION_REQUEST_CODE);
        }
    }

    public void onActivityResult(int i2, Activity activity, String[] strArr, IPermissionsResult iPermissionsResult) {
        if (i2 == 1011) {
            checkPermissions(activity, strArr, iPermissionsResult);
        }
    }

    public void onRequestPermissionsResult(Activity activity, int i2, String[] strArr, int[] iArr) {
        if (PERMISSION_REQUEST_CODE == i2) {
            int i3 = 0;
            for (int i4 : iArr) {
                i3 += i4;
            }
            if (i3 == 0) {
                this.mPermissionsResult.passPermissions();
            } else {
                showSystemPermissionsSettingDialog(activity);
            }
        }
    }
}
