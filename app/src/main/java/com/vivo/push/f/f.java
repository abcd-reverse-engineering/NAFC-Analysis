package com.vivo.push.f;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: classes2.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12048a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f12049b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f12050c;

    f(e eVar, Context context, Map map) {
        this.f12050c = eVar;
        this.f12048a = context;
        this.f12049b = map;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException {
        String packageName = this.f12048a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f12048a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.u.d("NotifyOpenClientTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        e.b(intent, this.f12049b);
                        this.f12048a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f12048a.getPackageManager().getLaunchIntentForPackage(this.f12048a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(CommonNetImpl.FLAG_AUTH);
        e.b(launchIntentForPackage, this.f12049b);
        this.f12048a.startActivity(launchIntentForPackage);
    }
}
