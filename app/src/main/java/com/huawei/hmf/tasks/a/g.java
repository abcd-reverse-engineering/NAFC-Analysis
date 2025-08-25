package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class g extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f6471b = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f6472a = new ArrayList();

    private static g a(Activity activity) {
        g gVarA;
        WeakReference<g> weakReference = f6471b.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            g gVar = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar == null) {
                try {
                    gVarA = a(fragmentManager);
                } catch (ClassCastException e2) {
                    e = e2;
                    gVarA = gVar;
                    String str = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
                    return gVarA;
                }
            } else {
                gVarA = gVar;
            }
        } catch (ClassCastException e3) {
            e = e3;
            gVarA = null;
        }
        try {
            f6471b.put(activity, new WeakReference<>(gVarA));
            return gVarA;
        } catch (ClassCastException e4) {
            e = e4;
            String str2 = "found LifecycleCallbackFragment but the type do not match. " + e.getMessage();
            return gVarA;
        }
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar;
        try {
            gVar = new g();
            try {
                fragmentManager.beginTransaction().add(gVar, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            } catch (Exception e2) {
                e = e2;
                String str = "create fragment failed." + e.getMessage();
                return gVar;
            }
        } catch (Exception e3) {
            e = e3;
            gVar = null;
        }
        return gVar;
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g gVarA = a(activity);
        if (gVarA != null) {
            synchronized (gVarA.f6472a) {
                gVarA.f6472a.add(new WeakReference<>(executeResult));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.f6472a) {
            Iterator<WeakReference<ExecuteResult<?>>> it = this.f6472a.iterator();
            while (it.hasNext()) {
                ExecuteResult<?> executeResult = it.next().get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f6472a.clear();
        }
    }
}
