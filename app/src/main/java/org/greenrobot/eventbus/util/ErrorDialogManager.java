package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes2.dex */
public class ErrorDialogManager {

    /* renamed from: a, reason: collision with root package name */
    public static c<?> f17459a = null;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f17460b = "de.greenrobot.eventbus.error_dialog";

    /* renamed from: c, reason: collision with root package name */
    protected static final String f17461c = "de.greenrobot.eventbus.error_dialog_manager";

    /* renamed from: d, reason: collision with root package name */
    public static final String f17462d = "de.greenrobot.eventbus.errordialog.title";

    /* renamed from: e, reason: collision with root package name */
    public static final String f17463e = "de.greenrobot.eventbus.errordialog.message";

    /* renamed from: f, reason: collision with root package name */
    public static final String f17464f = "de.greenrobot.eventbus.errordialog.finish_after_dialog";

    /* renamed from: g, reason: collision with root package name */
    public static final String f17465g = "de.greenrobot.eventbus.errordialog.icon_id";

    /* renamed from: h, reason: collision with root package name */
    public static final String f17466h = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    private static boolean b(Activity activity) {
        String name;
        Class<?> superclass = activity.getClass();
        do {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = superclass.getName();
            if (name.equals("androidx.fragment.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }

    public static void a(Activity activity) {
        a(activity, false, null);
    }

    public static void a(Activity activity, boolean z) {
        a(activity, z, null);
    }

    public static void a(Activity activity, boolean z, Bundle bundle) {
        a(activity, activity.getClass(), z, bundle);
    }

    public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (f17459a != null) {
            if (b(activity)) {
                SupportManagerFragment.a(activity, obj, z, bundle);
                return;
            } else {
                HoneycombManagerFragment.a(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f17467a;

        /* renamed from: b, reason: collision with root package name */
        protected Bundle f17468b;

        /* renamed from: c, reason: collision with root package name */
        private org.greenrobot.eventbus.c f17469c;

        /* renamed from: d, reason: collision with root package name */
        private Object f17470d;

        public void a(f fVar) {
            if (ErrorDialogManager.b(this.f17470d, fVar)) {
                ErrorDialogManager.a(fVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f17460b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) ErrorDialogManager.f17459a.a(fVar, this.f17467a, this.f17468b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f17460b);
                }
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f17469c.g(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            this.f17469c = ErrorDialogManager.f17459a.f17494a.b();
            this.f17469c.e(this);
        }

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombManagerFragment = (HoneycombManagerFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f17461c);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, ErrorDialogManager.f17461c).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.f17467a = z;
            honeycombManagerFragment.f17468b = bundle;
            honeycombManagerFragment.f17470d = obj;
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f17471a;

        /* renamed from: b, reason: collision with root package name */
        protected Bundle f17472b;

        /* renamed from: c, reason: collision with root package name */
        private org.greenrobot.eventbus.c f17473c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f17474d;

        /* renamed from: e, reason: collision with root package name */
        private Object f17475e;

        public void a(f fVar) {
            if (ErrorDialogManager.b(this.f17475e, fVar)) {
                ErrorDialogManager.a(fVar);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag(ErrorDialogManager.f17460b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                androidx.fragment.app.DialogFragment dialogFragment2 = (androidx.fragment.app.DialogFragment) ErrorDialogManager.f17459a.a(fVar, this.f17471a, this.f17472b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, ErrorDialogManager.f17460b);
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f17473c = ErrorDialogManager.f17459a.f17494a.b();
            this.f17473c.e(this);
            this.f17474d = true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f17473c.g(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f17474d) {
                this.f17474d = false;
            } else {
                this.f17473c = ErrorDialogManager.f17459a.f17494a.b();
                this.f17473c.e(this);
            }
        }

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            SupportManagerFragment supportManagerFragment = (SupportManagerFragment) supportFragmentManager.findFragmentByTag(ErrorDialogManager.f17461c);
            if (supportManagerFragment == null) {
                supportManagerFragment = new SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, ErrorDialogManager.f17461c).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.f17471a = z;
            supportManagerFragment.f17472b = bundle;
            supportManagerFragment.f17475e = obj;
        }
    }

    protected static void a(f fVar) {
        b bVar = f17459a.f17494a;
        if (bVar.f17490f) {
            if (bVar.f17491g == null) {
                String str = org.greenrobot.eventbus.c.s;
            }
            Throwable th = fVar.f17496a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Object obj, f fVar) {
        Object objA;
        return fVar == null || (objA = fVar.a()) == null || objA.equals(obj);
    }
}
