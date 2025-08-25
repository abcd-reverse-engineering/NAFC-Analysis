package com.lxj.xpermission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class XPermission {

    /* renamed from: k, reason: collision with root package name */
    private static List<String> f7900k;

    /* renamed from: l, reason: collision with root package name */
    private static XPermission f7901l;

    /* renamed from: m, reason: collision with root package name */
    private static d f7902m;
    private static d n;

    /* renamed from: a, reason: collision with root package name */
    private Context f7903a;

    /* renamed from: b, reason: collision with root package name */
    private c f7904b;

    /* renamed from: c, reason: collision with root package name */
    private d f7905c;

    /* renamed from: d, reason: collision with root package name */
    private b f7906d;

    /* renamed from: e, reason: collision with root package name */
    private e f7907e;

    /* renamed from: f, reason: collision with root package name */
    private Set<String> f7908f;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f7909g;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f7910h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f7911i;

    /* renamed from: j, reason: collision with root package name */
    private List<String> f7912j;

    @RequiresApi(api = 23)
    public static class PermissionActivity extends Activity {

        /* renamed from: a, reason: collision with root package name */
        private static final String f7913a = "TYPE";

        /* renamed from: b, reason: collision with root package name */
        public static final int f7914b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f7915c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final int f7916d = 3;

        public static void a(Context context, int i2) {
            Intent intent = new Intent(context, (Class<?>) PermissionActivity.class);
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            intent.putExtra("TYPE", i2);
            context.startActivity(intent);
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i2, int i3, Intent intent) {
            if (i2 == 2) {
                if (XPermission.f7902m == null) {
                    return;
                }
                if (XPermission.f7901l.c()) {
                    XPermission.f7902m.onGranted();
                } else {
                    XPermission.f7902m.a();
                }
                d unused = XPermission.f7902m = null;
            } else if (i2 == 3) {
                if (XPermission.n == null) {
                    return;
                }
                if (XPermission.f7901l.b()) {
                    XPermission.n.onGranted();
                } else {
                    XPermission.n.a();
                }
                d unused2 = XPermission.n = null;
            }
            finish();
        }

        @Override // android.app.Activity
        protected void onCreate(@Nullable Bundle bundle) {
            getWindow().addFlags(262672);
            getWindow().getAttributes().alpha = 0.0f;
            int intExtra = getIntent().getIntExtra("TYPE", 1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    super.onCreate(bundle);
                    XPermission.f7901l.b(this, 2);
                    return;
                } else {
                    if (intExtra == 3) {
                        super.onCreate(bundle);
                        XPermission.f7901l.a(this, 3);
                        return;
                    }
                    return;
                }
            }
            if (XPermission.f7901l == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            if (XPermission.f7901l.f7907e != null) {
                XPermission.f7901l.f7907e.a(this);
            }
            super.onCreate(bundle);
            if (XPermission.f7901l.c(this)) {
                finish();
                return;
            }
            if (XPermission.f7901l.f7909g != null) {
                int size = XPermission.f7901l.f7909g.size();
                if (size <= 0) {
                    finish();
                } else {
                    requestPermissions((String[]) XPermission.f7901l.f7909g.toArray(new String[size]), 1);
                }
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            XPermission.f7901l.b(this);
            finish();
        }
    }

    class a implements c.a {
        a() {
        }

        @Override // com.lxj.xpermission.XPermission.c.a
        public void a(boolean z) {
            if (z) {
                XPermission.this.j();
            } else {
                XPermission.this.i();
            }
        }
    }

    public interface b {
        void a(List<String> list);

        void a(List<String> list, List<String> list2);
    }

    public interface c {

        public interface a {
            void a(boolean z);
        }

        void a(a aVar);
    }

    public interface d {
        void a();

        void onGranted();
    }

    public interface e {
        void a(Activity activity);
    }

    private XPermission(Context context, String... strArr) {
        f7901l = this;
        this.f7903a = context;
        b(strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f7905c != null) {
            if (this.f7909g.size() == 0 || this.f7908f.size() == this.f7910h.size()) {
                this.f7905c.onGranted();
            } else if (!this.f7911i.isEmpty()) {
                this.f7905c.a();
            }
            this.f7905c = null;
        }
        if (this.f7906d != null) {
            if (this.f7909g.size() == 0 || this.f7908f.size() == this.f7910h.size()) {
                this.f7906d.a(this.f7910h);
            } else if (!this.f7911i.isEmpty()) {
                this.f7906d.a(this.f7912j, this.f7911i);
            }
            this.f7906d = null;
        }
        this.f7904b = null;
        this.f7907e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public void j() {
        this.f7911i = new ArrayList();
        this.f7912j = new ArrayList();
        PermissionActivity.a(this.f7903a, 1);
    }

    @RequiresApi(api = 23)
    public boolean c() {
        return Settings.System.canWrite(this.f7903a);
    }

    public void e() {
        this.f7910h = new ArrayList();
        this.f7909g = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.f7910h.addAll(this.f7908f);
            i();
            return;
        }
        for (String str : this.f7908f) {
            if (b(str)) {
                this.f7910h.add(str);
            } else {
                this.f7909g.add(str);
            }
        }
        if (this.f7909g.isEmpty()) {
            i();
        } else {
            j();
        }
    }

    @RequiresApi(api = 23)
    public void c(d dVar) {
        if (!c()) {
            f7902m = dVar;
            PermissionActivity.a(this.f7903a, 2);
        } else if (dVar != null) {
            dVar.onGranted();
        }
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f7903a.getPackageName()));
        if (a(intent)) {
            this.f7903a.startActivity(intent.addFlags(CommonNetImpl.FLAG_AUTH));
        }
    }

    private boolean b(String str) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this.f7903a, str) == 0;
    }

    public List<String> a() {
        return a(this.f7903a.getPackageName());
    }

    public List<String> a(String str) {
        try {
            String[] strArr = this.f7903a.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void b(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f7903a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 23)
    public boolean c(Activity activity) {
        boolean z = false;
        if (this.f7904b != null) {
            Iterator<String> it = this.f7909g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    a(activity);
                    this.f7904b.a(new a());
                    z = true;
                    break;
                }
            }
            this.f7904b = null;
        }
        return z;
    }

    public boolean a(String... strArr) {
        for (String str : strArr) {
            if (!b(str)) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = 23)
    public boolean b() {
        if (Build.VERSION.SDK_INT >= 26) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f7903a.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            int iCheckOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), this.f7903a.getPackageName());
            return iCheckOpNoThrow == 0 || iCheckOpNoThrow == 1;
        }
        return Settings.canDrawOverlays(this.f7903a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void a(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.f7903a.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    @RequiresApi(api = 23)
    public void b(d dVar) {
        if (!b()) {
            n = dVar;
            PermissionActivity.a(this.f7903a, 3);
        } else if (dVar != null) {
            dVar.onGranted();
        }
    }

    public static XPermission a(Context context, String... strArr) {
        XPermission xPermission = f7901l;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.b(strArr);
        return f7901l;
    }

    public static XPermission a(Context context) {
        return a(context, (String[]) null);
    }

    private void b(String... strArr) {
        this.f7908f = new LinkedHashSet();
        f7900k = a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : com.lxj.xpermission.b.a(str)) {
                if (f7900k.contains(str2)) {
                    this.f7908f.add(str2);
                }
            }
        }
    }

    private boolean a(Intent intent) {
        return this.f7903a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public XPermission a(c cVar) {
        this.f7904b = cVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        a(activity);
        i();
    }

    public XPermission a(d dVar) {
        this.f7905c = dVar;
        return this;
    }

    public XPermission a(b bVar) {
        this.f7906d = bVar;
        return this;
    }

    public XPermission a(e eVar) {
        this.f7907e = eVar;
        return this;
    }

    private void a(Activity activity) {
        for (String str : this.f7909g) {
            if (b(str)) {
                this.f7910h.add(str);
            } else {
                this.f7911i.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f7912j.add(str);
                }
            }
        }
    }
}
