package ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import ui.activity.BaseActivity;
import ui.activity.MainActivity;
import util.y1;

/* compiled from: ActivityManager.java */
/* loaded from: classes2.dex */
public class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c, reason: collision with root package name */
    private static c f19493c;

    /* renamed from: a, reason: collision with root package name */
    private Stack<Activity> f19494a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    private int f19495b;

    private c() {
    }

    public static c i() {
        if (f19493c == null) {
            synchronized (c.class) {
                if (f19493c == null) {
                    f19493c = new c();
                }
            }
        }
        return f19493c;
    }

    public static boolean j() throws SecurityException {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) Hicore.getApp().getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            if (Hicore.getApp().getPackageName().equals(runningTasks.get(0).topActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void a(Activity activity) {
        this.f19494a.add(activity);
    }

    public boolean b() {
        return this.f19495b <= 0;
    }

    public Activity c() {
        return this.f19494a.lastElement();
    }

    public void d(Activity activity) {
        if (activity != null) {
            this.f19494a.remove(activity);
        }
    }

    public void e() {
        int size = this.f19494a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            if (this.f19494a.get(i2) != null) {
                c(this.f19494a.get(i2));
            }
        }
    }

    public void f() {
        int size = this.f19494a.size();
        for (int i2 = 0; i2 < size - 1; i2++) {
            Activity activity = this.f19494a.get(i2);
            if (activity != null && !(activity instanceof MainActivity)) {
                c(this.f19494a.get(i2));
            }
        }
    }

    public Stack<Activity> g() {
        return this.f19494a;
    }

    public Activity h() {
        return this.f19494a.lastElement();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f19495b++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f19495b--;
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi") || j()) {
            return;
        }
        y1.c(activity, 0);
    }

    public void a(int i2) {
        if (this.f19494a.size() > i2) {
            b(this.f19494a.get(i2));
        }
    }

    public void b(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f19494a.remove(activity);
        activity.finish();
    }

    public void c(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public void d() {
        int size = this.f19494a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f19494a.get(i2) != null) {
                c(this.f19494a.get(i2));
            }
        }
        this.f19494a.clear();
    }

    public void a(Class<?> cls) {
        Iterator<Activity> it = this.f19494a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                b(next);
                return;
            }
        }
    }

    public <T extends BaseActivity> T b(Class<T> cls) {
        Stack<Activity> stack = this.f19494a;
        if (stack == null) {
            return null;
        }
        Iterator<Activity> it = stack.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                return (T) next;
            }
        }
        return null;
    }

    public void a() {
        try {
            this.f19495b = 0;
            d();
            Process.killProcess(Process.myPid());
            System.exit(0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
