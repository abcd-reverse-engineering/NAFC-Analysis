package h.i2;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.AccsClientConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.m2.f;
import h.q2.e;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;

/* compiled from: Thread.kt */
@e(name = "ThreadsKt")
@y(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a0\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", CommonNetImpl.NAME, "", RemoteMessageConst.Notification.PRIORITY, "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", AccsClientConfig.DEFAULT_CONFIGTAG, "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class b {

    /* compiled from: Thread.kt */
    public static final class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.q2.s.a f16230a;

        a(h.q2.s.a aVar) {
            this.f16230a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f16230a.invoke();
        }
    }

    @d
    public static final Thread a(boolean z, boolean z2, @i.c.a.e ClassLoader classLoader, @i.c.a.e String str, int i2, @d h.q2.s.a<y1> aVar) {
        i0.f(aVar, "block");
        a aVar2 = new a(aVar);
        if (z2) {
            aVar2.setDaemon(true);
        }
        if (i2 > 0) {
            aVar2.setPriority(i2);
        }
        if (str != null) {
            aVar2.setName(str);
        }
        if (classLoader != null) {
            aVar2.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar2.start();
        }
        return aVar2;
    }

    @f
    private static final <T> T a(@d ThreadLocal<T> threadLocal, h.q2.s.a<? extends T> aVar) {
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T tInvoke = aVar.invoke();
        threadLocal.set(tInvoke);
        return tInvoke;
    }
}
