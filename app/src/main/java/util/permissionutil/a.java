package util.permissionutil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.hicorenational.antifraud.R;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Permission.java */
/* loaded from: classes2.dex */
public class a {
    public static final String A = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: a, reason: collision with root package name */
    public static final String f20907a = "android.permission.READ_CALENDAR";

    /* renamed from: b, reason: collision with root package name */
    public static final String f20908b = "android.permission.WRITE_CALENDAR";

    /* renamed from: c, reason: collision with root package name */
    public static final String f20909c = "android.permission.CAMERA";

    /* renamed from: d, reason: collision with root package name */
    public static final String f20910d = "android.permission.READ_CONTACTS";

    /* renamed from: e, reason: collision with root package name */
    public static final String f20911e = "android.permission.WRITE_CONTACTS";

    /* renamed from: f, reason: collision with root package name */
    public static final String f20912f = "android.permission.GET_ACCOUNTS";

    /* renamed from: g, reason: collision with root package name */
    public static final String f20913g = "android.permission.ACCESS_FINE_LOCATION";

    /* renamed from: h, reason: collision with root package name */
    public static final String f20914h = "android.permission.ACCESS_COARSE_LOCATION";

    /* renamed from: i, reason: collision with root package name */
    public static final String f20915i = "android.permission.RECORD_AUDIO";

    /* renamed from: j, reason: collision with root package name */
    public static final String f20916j = "android.permission.READ_PHONE_STATE";

    /* renamed from: k, reason: collision with root package name */
    public static final String f20917k = "android.permission.CALL_PHONE";

    /* renamed from: l, reason: collision with root package name */
    public static final String f20918l = "android.permission.READ_CALL_LOG";

    /* renamed from: m, reason: collision with root package name */
    public static final String f20919m = "android.permission.WRITE_CALL_LOG";
    public static final String n = "com.android.voicemail.permission.ADD_VOICEMAIL";
    static final String o = "android.permission.ADD_VOICEMAIL";
    public static final String p = "android.permission.USE_SIP";
    public static final String q = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String r = "android.permission.READ_PHONE_NUMBERS";
    public static final String s = "android.permission.ANSWER_PHONE_CALLS";
    public static final String t = "android.permission.BODY_SENSORS";
    public static final String u = "android.permission.SEND_SMS";
    public static final String v = "android.permission.RECEIVE_SMS";
    public static final String w = "android.permission.READ_SMS";
    public static final String x = "android.permission.RECEIVE_WAP_PUSH";
    public static final String y = "android.permission.RECEIVE_MMS";
    public static final String z = "android.permission.READ_EXTERNAL_STORAGE";

    /* compiled from: Permission.java */
    /* renamed from: util.permissionutil.a$a, reason: collision with other inner class name */
    public static final class C0323a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f20920a = {a.f20907a, a.f20908b};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f20921b = {a.f20909c};

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f20922c = {a.f20910d, a.f20911e, a.f20912f};

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f20923d = {a.f20913g, a.f20914h};

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f20924e = {a.f20915i};

        /* renamed from: f, reason: collision with root package name */
        public static final String[] f20925f;

        /* renamed from: g, reason: collision with root package name */
        public static final String[] f20926g;

        /* renamed from: h, reason: collision with root package name */
        public static final String[] f20927h;

        /* renamed from: i, reason: collision with root package name */
        public static final String[] f20928i;

        static {
            if (Build.VERSION.SDK_INT >= 26) {
                f20925f = new String[]{a.f20916j, a.f20917k, a.f20918l, a.f20919m, a.n, a.p, a.q, a.r, a.s};
            } else {
                f20925f = new String[]{a.f20916j, a.f20917k, a.f20918l, a.f20919m, a.n, a.p, a.q};
            }
            f20926g = new String[]{a.t};
            f20927h = new String[]{a.u, a.v, a.w, a.x, a.y};
            f20928i = new String[]{a.z, a.A};
        }
    }

    public static List<String> a(Context context, String... strArr) {
        return a(context, (List<String>) Arrays.asList(strArr));
    }

    @NonNull
    public static void b(Activity activity) {
        try {
            activity.startActivity(a(activity));
        } catch (Exception unused) {
            activity.startActivity(a((Context) activity));
        }
    }

    private static Intent c(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            return a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    private static Intent d(Context context) {
        return a(context);
    }

    private static Intent e(Context context) {
        return a(context);
    }

    private static Intent f(Context context) {
        return a(context);
    }

    private static Intent g(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        if (Build.VERSION.SDK_INT >= 25) {
            intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        } else {
            intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        }
        return intent;
    }

    private static Intent h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }

    public static List<String> a(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] strArr2 : strArr) {
            arrayList.addAll(Arrays.asList(strArr2));
        }
        return a(context, arrayList);
    }

    private static Intent b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    public static List<String> a(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            switch (it.next()) {
                case "android.permission.READ_CALENDAR":
                case "android.permission.WRITE_CALENDAR":
                    String string = context.getString(R.string.permission_name_calendar);
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.CAMERA":
                    String string2 = context.getString(R.string.permission_name_camera);
                    if (!arrayList.contains(string2)) {
                        arrayList.add(string2);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_CONTACTS":
                case "android.permission.WRITE_CONTACTS":
                    String string3 = context.getString(R.string.permission_name_contacts);
                    if (!arrayList.contains(string3)) {
                        arrayList.add(string3);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.GET_ACCOUNTS":
                    String string4 = context.getString(R.string.permission_name_accounts);
                    if (!arrayList.contains(string4)) {
                        arrayList.add(string4);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.ACCESS_FINE_LOCATION":
                case "android.permission.ACCESS_COARSE_LOCATION":
                    String string5 = context.getString(R.string.permission_name_location);
                    if (!arrayList.contains(string5)) {
                        arrayList.add(string5);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.RECORD_AUDIO":
                    String string6 = context.getString(R.string.permission_name_microphone);
                    if (!arrayList.contains(string6)) {
                        arrayList.add(string6);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_PHONE_STATE":
                case "android.permission.CALL_PHONE":
                case "android.permission.READ_CALL_LOG":
                case "android.permission.WRITE_CALL_LOG":
                case "com.android.voicemail.permission.ADD_VOICEMAIL":
                case "android.permission.ADD_VOICEMAIL":
                case "android.permission.USE_SIP":
                case "android.permission.PROCESS_OUTGOING_CALLS":
                case "android.permission.READ_PHONE_NUMBERS":
                case "android.permission.ANSWER_PHONE_CALLS":
                    String string7 = context.getString(R.string.permission_name_phone);
                    if (!arrayList.contains(string7)) {
                        arrayList.add(string7);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.BODY_SENSORS":
                    String string8 = context.getString(R.string.permission_name_sensors);
                    if (!arrayList.contains(string8)) {
                        arrayList.add(string8);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.SEND_SMS":
                case "android.permission.RECEIVE_SMS":
                case "android.permission.READ_SMS":
                case "android.permission.RECEIVE_WAP_PUSH":
                case "android.permission.RECEIVE_MMS":
                    String string9 = context.getString(R.string.permission_name_sms);
                    if (!arrayList.contains(string9)) {
                        arrayList.add(string9);
                        break;
                    } else {
                        break;
                    }
                case "android.permission.READ_EXTERNAL_STORAGE":
                case "android.permission.WRITE_EXTERNAL_STORAGE":
                    String string10 = context.getString(R.string.permission_name_storage);
                    if (!arrayList.contains(string10)) {
                        arrayList.add(string10);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return arrayList;
    }

    private static Intent a(Activity activity) {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("huawei")) {
            return b((Context) activity);
        }
        if (lowerCase.contains("xiaomi")) {
            return h(activity);
        }
        if (lowerCase.contains("oppo")) {
            return d(activity);
        }
        if (lowerCase.contains("vivo")) {
            return g(activity);
        }
        if (lowerCase.contains("samsung")) {
            return e(activity);
        }
        if (lowerCase.contains("meizu")) {
            return c(activity);
        }
        if (lowerCase.contains("smartisan")) {
            return f(activity);
        }
        return a((Context) activity);
    }

    private static Intent a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }
}
