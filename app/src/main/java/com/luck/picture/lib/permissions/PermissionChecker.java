package com.luck.picture.lib.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: classes.dex */
public class PermissionChecker {
    public static boolean checkSelfPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context.getApplicationContext(), str) == 0;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void launchAppDetailsSettings(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (isIntentAvailable(context, intent)) {
            applicationContext.startActivity(intent.addFlags(CommonNetImpl.FLAG_AUTH));
        }
    }

    public static void requestPermissions(Activity activity, @NonNull String[] strArr, int i2) {
        ActivityCompat.requestPermissions(activity, strArr, i2);
    }
}
