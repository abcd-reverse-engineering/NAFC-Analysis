package c.c.a.a;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import k.a.a.a.j.e;
import k.a.a.c.a.c;
import k.a.a.c.a.c.a;

/* compiled from: HonorApi.java */
/* loaded from: classes.dex */
public class b<TOption extends c.a> {

    /* renamed from: a, reason: collision with root package name */
    private TOption f3082a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3083b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f3084c;

    public b(Activity activity, c<TOption> cVar, TOption toption) {
        this.f3083b = activity.getApplicationContext();
        this.f3084c = new WeakReference<>(activity);
        a(activity, cVar, toption);
    }

    private void a(Context context, c<TOption> cVar, TOption toption) {
        this.f3083b = context.getApplicationContext();
        this.f3082a = toption;
        a(context);
    }

    protected TOption e() {
        return this.f3082a;
    }

    public Activity f() {
        WeakReference<Activity> weakReference = this.f3084c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Context g() {
        return this.f3083b;
    }

    private void a(Context context) {
        e.a(context);
        com.hihonor.honorid.a.c().a(context);
    }

    public b(Context context, c<TOption> cVar, TOption toption) {
        a(context, cVar, toption);
    }
}
