package a.a.p;

import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<b> f1173a = new CopyOnWriteArrayList<>();

    private c() {
    }

    public static void a(b bVar) {
        if (f1173a.contains(bVar)) {
            return;
        }
        f1173a.add(bVar);
        ALog.i("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", f1173a.toString());
    }

    public static boolean b(b bVar) {
        return f1173a.contains(bVar);
    }

    public static void c(b bVar) {
        f1173a.remove(bVar);
        ALog.i("anet.InterceptorManager", "[remoteInterceptor]", null, "interceptors", f1173a.toString());
    }

    public static b a(int i2) {
        return f1173a.get(i2);
    }

    public static int a() {
        return f1173a.size();
    }
}
