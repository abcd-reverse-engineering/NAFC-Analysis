package util.permissionutil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.AttributionReporter;
import com.umeng.analytics.pro.bl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import ui.Hicore;
import ui.activity.MainActivity;
import ui.presenter.BasePagePresenter;
import util.b1;
import util.f1;
import util.k1;
import util.n1;

/* compiled from: PermissionUtil.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f20929b = "c";

    /* renamed from: a, reason: collision with root package name */
    private PermissionFragment f20930a;

    /* compiled from: PermissionUtil.java */
    static class a implements util.permissionutil.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PermissionsListener f20931a;

        a(PermissionsListener permissionsListener) {
            this.f20931a = permissionsListener;
        }

        @Override // util.permissionutil.b
        public void a(List<String> list) {
            PermissionsListener permissionsListener = this.f20931a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, true);
            }
        }

        @Override // util.permissionutil.b
        public void b(List<String> list) {
            PermissionsListener permissionsListener = this.f20931a;
            if (permissionsListener != null) {
                permissionsListener.onDenied(list, false);
            }
        }

        @Override // util.permissionutil.b
        public void onGranted() {
            PermissionsListener permissionsListener = this.f20931a;
            if (permissionsListener != null) {
                permissionsListener.onGranted();
            }
        }
    }

    /* compiled from: PermissionUtil.java */
    static class b implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20932a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f20933b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f20934c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f20935d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PermissionsListener f20936e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f20937f;

        b(boolean z, IOneClickListener iOneClickListener, Activity activity, List list, PermissionsListener permissionsListener, boolean z2) {
            this.f20932a = z;
            this.f20933b = iOneClickListener;
            this.f20934c = activity;
            this.f20935d = list;
            this.f20936e = permissionsListener;
            this.f20937f = z2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (this.f20937f) {
                Activity activity = this.f20934c;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.f20934c.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!this.f20932a) {
                List list = this.f20935d;
                c.a(this.f20934c, (String[]) list.toArray(new String[list.size()]), this.f20936e);
                return;
            }
            IOneClickListener iOneClickListener = this.f20933b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
            this.f20934c.startActivity(intent);
        }
    }

    /* compiled from: PermissionUtil.java */
    /* renamed from: util.permissionutil.c$c, reason: collision with other inner class name */
    static class C0324c implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f20938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f20939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f20940c;

        C0324c(Activity activity, IOneClickListener iOneClickListener, boolean z) {
            this.f20938a = activity;
            this.f20939b = iOneClickListener;
            this.f20940c = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            IOneClickListener iOneClickListener = this.f20939b;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
                return;
            }
            if (this.f20940c) {
                Activity activity = this.f20938a;
                if ((activity instanceof MainActivity) || activity.isFinishing()) {
                    return;
                }
                this.f20938a.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                new BasePagePresenter(this.f20938a).checkOtherPerssion(null);
            } else {
                if (k1.c(this.f20938a)) {
                    return;
                }
                k1.e(this.f20938a);
            }
        }
    }

    public c(Activity activity) {
        this.f20930a = a(activity);
    }

    private PermissionFragment a(Activity activity) {
        PermissionFragment permissionFragment = (PermissionFragment) activity.getFragmentManager().findFragmentByTag(f20929b);
        if (permissionFragment == null) {
            try {
                PermissionFragment permissionFragment2 = new PermissionFragment();
                try {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    fragmentManager.beginTransaction().add(permissionFragment2, f20929b).commitAllowingStateLoss();
                    fragmentManager.executePendingTransactions();
                    return permissionFragment2;
                } catch (Exception unused) {
                    return permissionFragment2;
                }
            } catch (Exception unused2) {
            }
        }
        return permissionFragment;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static boolean b() {
        try {
            ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(Uri.parse("content://sms/failed"), new String[]{bl.f10170d, UserInfo.ADDRESS, "person", "body", "date", "type"}, null, null, "date desc");
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d() throws IOException {
        File file = new File(f1.b() + "permission.ymt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.flush();
            fileOutputStream.close();
            file.delete();
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean e() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f() throws NoSuchFieldException {
        try {
            Camera cameraOpen = Camera.open();
            Field declaredField = cameraOpen.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(cameraOpen)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean g() {
        n1.b(AttributionReporter.SYSTEM_PERMISSION, "Build.BRAND:" + Build.BRAND);
        return Build.VERSION.SDK_INT <= 23 || Build.BRAND.toLowerCase().equals("smartisan") || Build.BRAND.toLowerCase().equals("xiaomi") || Build.BRAND.toLowerCase().equals("oppo") || Build.BRAND.toLowerCase().equals("vivo") || Build.BRAND.toLowerCase().equals("lenovo") || Build.BRAND.toLowerCase().equals("meizu");
    }

    private static int b(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentmode"));
                    cursorQuery.close();
                    return i2;
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return 1;
    }

    public static boolean a(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public void a(String[] strArr, util.permissionutil.b bVar) {
        PermissionFragment permissionFragment = this.f20930a;
        if (permissionFragment != null) {
            permissionFragment.a(bVar);
            this.f20930a.a(strArr);
        }
    }

    public static void a(Activity activity, String[] strArr, PermissionsListener permissionsListener) {
        new c(activity).a(strArr, new a(permissionsListener));
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener) {
        a(activity, list, z, z2, permissionsListener, "", "", "", "", null);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, IOneClickListener iOneClickListener) {
        a(activity, list, z, z2, permissionsListener, "", "", "", "", iOneClickListener);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4) {
        a(activity, list, z, z2, permissionsListener, str, str2, str3, str4, null);
    }

    public static void a(Activity activity, List<String> list, boolean z, boolean z2, PermissionsListener permissionsListener, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        b1.f(activity, TextUtils.isEmpty(str) ? "权限开启" : str, TextUtils.isEmpty(str2) ? "国家反诈中心未取得权限，这样会导致此功能无法使用。" : str2, TextUtils.isEmpty(str3) ? "取消" : str3, TextUtils.isEmpty(str4) ? "去授权" : str4, new b(z, iOneClickListener, activity, list, permissionsListener, z2));
    }

    public static void a(Activity activity, boolean z, String str, String str2, String str3, String str4, IOneClickListener iOneClickListener) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "权限开启";
        }
        String str5 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "开启APP预警需授权【悬浮框权限】\n如未授权会导致功能无法使用。";
        }
        String str6 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "取消";
        }
        String str7 = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = "去授权";
        }
        b1.f(activity, str5, str6, str7, str4, new C0324c(activity, iOneClickListener, z));
    }

    public static boolean a() {
        try {
            Cursor cursorQuery = Hicore.getApp().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", CommonNetImpl.NAME, "geocoded_location"}, null, null, null);
            if (cursorQuery == null) {
                return true;
            }
            cursorQuery.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int a(Context context) {
        try {
            if (context != null) {
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
                if (cursorQuery != null) {
                    cursorQuery.getColumnNames();
                    if (cursorQuery.moveToFirst()) {
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("currentlmode"));
                        cursorQuery.close();
                        return i2;
                    }
                    cursorQuery.close();
                    return b(context);
                }
                return b(context);
            }
            throw new IllegalArgumentException("context is null");
        } catch (Exception unused) {
            return b(context);
        }
    }
}
