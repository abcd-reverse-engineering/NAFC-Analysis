package util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import bean.SmsBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ui.activity.WebFullActivity;

/* compiled from: IntentUtils.java */
/* loaded from: classes2.dex */
public class k1 {
    public static final String A = "value_apps_warn";
    public static final String A0 = "extra_group_invite_id";
    public static final String B = "report_his_time";
    public static final String B0 = "extra_group_invite_master";
    public static final String C = "turn_page_type";
    public static final String C0 = "survey_case_ID";
    public static final int D = 1;
    public static final String D0 = "survey_case_num";
    public static final String E = "int_phone_code";
    public static final String E0 = "survey_case_phone";
    public static final String F = "int_forget_phone";
    public static final String F0 = "select_list_item";
    public static final String G = "int_forget_phone_code";
    public static final String G0 = "conversation_id";
    public static final String H = "int_forget_phone_resetpwd";
    public static final String H0 = "chat_record_type";
    public static int I = 0;
    public static final String I0 = "chat_position";
    public static int J = 1;
    public static final String J0 = "extra_chat_typetxt";
    public static int K = 2;
    public static final String K0 = "extra_ocr_help";
    public static int L = 3;
    public static final int L0 = 1;
    public static final String M = "platm_type";
    public static final int M0 = 2;
    public static final String N = "open_id";
    public static final int N0 = 3;
    public static final String O = "int_tag_name";
    public static final String O0 = "extra_one_record_type";
    public static final String P = "extra_web_title";
    public static final String P0 = "extra_one_record_audio";
    public static final String Q = "extra_web_url";
    public static final String Q0 = "extra_one_record_video";
    public static final String R = "extra_web_img";
    public static final String R0 = "extra_one_record_path";
    public static final String S = "extra_web_desc";
    public static final String S0 = "extra_one_record_name";
    public static final String T = "extra_web_id";
    public static final String T0 = "extra_one_record_duration";
    public static final String U = "extra_web_enter";
    public static final int U0 = 0;
    public static final String V = "extra_web_theme_caragy";
    public static final int V0 = 1;
    public static final int W = 1;
    public static final int W0 = 2;
    public static final int X = 2;
    public static final String X0 = "extra_node_type";
    public static final int Y = 3;
    public static final int Y0 = 1;
    public static final String Z = "extra_web_personalize";
    public static final int Z0 = 2;

    /* renamed from: a, reason: collision with root package name */
    public static final String f20843a = "com.coolapk.market";
    public static final String a0 = "extra_web_personalize_ad";
    public static final int a1 = 3;

    /* renamed from: b, reason: collision with root package name */
    public static final String f20844b = "from_page_bean_extra";
    public static final String b0 = "extra_name";
    public static final int b1 = 4;

    /* renamed from: c, reason: collision with root package name */
    public static final String f20845c = "from_page_bean";
    public static final String c0 = "extra_id_info";
    public static final int c1 = 5;

    /* renamed from: d, reason: collision with root package name */
    public static final String f20846d = "from_page_type";
    public static final String d0 = "extra_id_number";
    public static final int d1 = 6;

    /* renamed from: e, reason: collision with root package name */
    public static final String f20847e = "from_page_tag";
    public static final String e0 = "phone_number";
    public static final String e1 = "1";

    /* renamed from: f, reason: collision with root package name */
    public static final int f20848f = 1;
    public static final String f0 = "extra_text";
    public static final String f1 = "2";

    /* renamed from: g, reason: collision with root package name */
    public static final int f20849g = 2;
    public static final String g0 = "extra_code";
    public static final String g1 = "3";

    /* renamed from: h, reason: collision with root package name */
    public static final int f20850h = 3;
    public static final String h0 = "extra_msg";
    public static final String h1 = "4";

    /* renamed from: i, reason: collision with root package name */
    public static final String f20851i = "int_detial";
    public static final String i0 = "extra_json_null";
    public static final String i1 = "extra_feedback_id";

    /* renamed from: j, reason: collision with root package name */
    public static final String f20852j = "int_casefrautype";
    public static final String j0 = "extra_trift_id";
    public static final String j1 = "extra_payment_type";

    /* renamed from: k, reason: collision with root package name */
    public static final String f20853k = "int_casefrautxt";
    public static final String k0 = "extra_trift_name";
    public static String k1 = "record_intercepte";

    /* renamed from: l, reason: collision with root package name */
    public static final String f20854l = "int_caseregion";
    public static final String l0 = "extra_trift_api";

    /* renamed from: m, reason: collision with root package name */
    public static final String f20855m = "int_casedesc";
    public static final String m0 = "extra_check_fraud_result";
    public static final String n = "int_websit";
    public static final String n0 = "extra_check_fraud_share";
    public static final String o = "int_socail";
    public static final String o0 = "extra_check_fraud_type";
    public static final String p = "int_audio";
    public static final String p0 = "extra_check_fraud_type_pay";
    public static final String q = "int_suspect_id";
    public static final String q0 = "extra_check_fraud_type_url";
    public static final String r = "int_trad";
    public static final int r0 = 1;
    public static final String s = "int_call";
    public static final int s0 = 2;
    public static final String t = "int_apps";
    public static final int t0 = 3;
    public static final String u = "int_SMS";
    public static final int u0 = 4;
    public static final String v = "int_social_pos";
    public static final int v0 = 5;
    public static final String w = "int_social_bean";
    public static final int w0 = 7;
    public static final String x = "int_apps_virus";
    public static final String x0 = "extra_group";
    public static final String y = "extra_apps_type";
    public static final String y0 = "extra_group_id";
    public static final String z = "value_apps_virus";
    public static final String z0 = "extra_group_api";

    public static void a(Activity activity, Uri uri, int i2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        File file = new File(d.d.f13555k + d.d.f13545a);
        if (Build.VERSION.SDK_INT < 24) {
            intent.setDataAndType(uri, "image/*");
        } else {
            File fileA = uri != null ? f1.a(activity, uri) : file;
            intent.addFlags(128);
            intent.setDataAndType(f1.a(activity, fileA), "image/*");
        }
        intent.putExtra("crop", a.a.u.a.f1253j);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", i2);
        intent.putExtra("outputY", i2);
        intent.putExtra("circleCrop", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("return-data", false);
        u1.b(d.d.f13547c, Uri.fromFile(file).toString());
        activity.startActivityForResult(intent, 100);
    }

    public static void b(Activity activity, String str) {
        Uri uriForFile;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(activity.getApplicationContext(), "请确认已经插入SD卡", 1).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        File file = new File(d.d.f13555k);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (Build.VERSION.SDK_INT < 24) {
            uriForFile = Uri.fromFile(new File(str));
        } else {
            new ContentValues(1).put("_data", str);
            uriForFile = FileProvider.getUriForFile(activity.getApplicationContext(), activity.getPackageName() + ".fileprovider", new File(str));
        }
        intent.putExtra("output", uriForFile);
        activity.startActivityForResult(intent, 101);
    }

    public static boolean c(Context context) {
        Intent intent = new Intent("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        try {
            return a(context, intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Intent d(Context context) {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
            } else {
                intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
            }
            return intent;
        } catch (Exception unused) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
    }

    public static void e(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    public static void f(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=20000056")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到支付宝，请检查您是否安装了支付宝！", 0).show();
        }
    }

    public static void g(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到支付宝，请检查您是否安装了支付宝！", 0).show();
        }
    }

    public static void h(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("weixin://")));
        } catch (Exception unused) {
            Toast.makeText(context, "无法跳转到微信，请检查您是否安装了微信！", 0).show();
        }
    }

    @SuppressLint({"WrongConstant"})
    public static void i(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(335544320);
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void j(Context context) {
        Intent intent = new Intent();
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            } else if (Build.VERSION.SDK_INT <= 8) {
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
            }
            context.startActivity(intent);
        } catch (Exception unused) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public static boolean b(Context context) {
        try {
            return ((Integer) AppOpsManager.class.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), 24, Integer.valueOf(Binder.getCallingUid()), context.getApplicationContext().getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Activity activity) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        activity.startActivityForResult(intent, 102);
    }

    private static boolean a(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            return false;
        }
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent);
        return true;
    }

    public static boolean a(Context context) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            return true;
        }
        if (i2 >= 23) {
            try {
                return Settings.canDrawOverlays(context);
            } catch (Exception unused) {
                return b(context);
            }
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            if (!(obj instanceof String)) {
                return false;
            }
            Object objInvoke = cls.getMethod("getSystemService", String.class).invoke(context, (String) obj);
            Class<?> cls2 = Class.forName("android.app.AppOpsManager");
            Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
            declaredField2.setAccessible(true);
            return ((Integer) cls2.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(objInvoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == declaredField2.getInt(cls2);
        } catch (Exception unused2) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setComponent(null);
        intent.setSelector(null);
        context.startActivity(intent);
    }

    public static Intent a(Intent intent, HashMap<String, Object> map) {
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if (value instanceof List) {
                    intent.putParcelableArrayListExtra(key, (ArrayList) value);
                } else if (value instanceof SmsBean) {
                    intent.putExtra(key, (SmsBean) value);
                } else {
                    intent.putExtra(key, (String) value);
                }
            }
            return intent;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new Intent();
        }
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) WebFullActivity.class);
        intent.putExtra(Q, str);
        activity.startActivity(intent);
    }
}
