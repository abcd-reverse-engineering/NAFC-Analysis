package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class fa {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f12805a = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    public static boolean f494a;

    /* renamed from: a, reason: collision with other field name */
    protected fb f497a;

    /* renamed from: a, reason: collision with other field name */
    protected XMPushService f499a;

    /* renamed from: a, reason: collision with other field name */
    protected int f495a = 0;

    /* renamed from: a, reason: collision with other field name */
    protected long f496a = -1;

    /* renamed from: b, reason: collision with other field name */
    protected volatile long f504b = 0;

    /* renamed from: c, reason: collision with other field name */
    protected volatile long f507c = 0;

    /* renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f502a = new LinkedList<>();

    /* renamed from: a, reason: collision with other field name */
    private final Collection<fd> f501a = new CopyOnWriteArrayList();

    /* renamed from: a, reason: collision with other field name */
    protected final Map<ff, a> f503a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with other field name */
    protected final Map<ff, a> f506b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with other field name */
    protected fj f498a = null;

    /* renamed from: a, reason: collision with other field name */
    protected String f500a = "";

    /* renamed from: b, reason: collision with other field name */
    protected String f505b = "";

    /* renamed from: c, reason: collision with root package name */
    private int f12807c = 2;

    /* renamed from: b, reason: collision with root package name */
    protected final int f12806b = f12805a.getAndIncrement();

    /* renamed from: e, reason: collision with root package name */
    private long f12809e = 0;

    /* renamed from: d, reason: collision with root package name */
    protected long f12808d = 0;

    static {
        f494a = false;
        try {
            f494a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        fg.m423a();
    }

    protected fa(XMPushService xMPushService, fb fbVar) throws ClassNotFoundException {
        this.f497a = fbVar;
        this.f499a = xMPushService;
        m417b();
    }

    private String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a, reason: collision with other method in class */
    public fb m413a() {
        return this.f497a;
    }

    public abstract void a(fo foVar);

    public abstract void a(am.b bVar);

    public abstract void a(String str, String str2);

    public abstract void a(er[] erVarArr);

    /* renamed from: a */
    public boolean mo407a() {
        return false;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m416b() {
        return this.f497a.b();
    }

    public abstract void b(int i2, Exception exc);

    public abstract void b(er erVar);

    public abstract void b(boolean z);

    /* renamed from: c, reason: collision with other method in class */
    public boolean m419c() {
        return this.f12807c == 1;
    }

    public void d() {
        synchronized (this.f502a) {
            this.f502a.clear();
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ff f12810a;

        /* renamed from: a, reason: collision with other field name */
        private fk f508a;

        public a(ff ffVar, fk fkVar) {
            this.f12810a = ffVar;
            this.f508a = fkVar;
        }

        public void a(fo foVar) {
            fk fkVar = this.f508a;
            if (fkVar == null || fkVar.mo240a(foVar)) {
                this.f12810a.a(foVar);
            }
        }

        public void a(er erVar) {
            this.f12810a.a(erVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String mo414a() {
        return this.f497a.c();
    }

    public void b(fd fdVar) {
        this.f501a.remove(fdVar);
    }

    public synchronized void c() {
        this.f12809e = SystemClock.elapsedRealtime();
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m412a() {
        return this.f507c;
    }

    public void b(ff ffVar, fk fkVar) {
        if (ffVar != null) {
            this.f506b.put(ffVar, new a(ffVar, fkVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(fd fdVar) {
        if (fdVar == null || this.f501a.contains(fdVar)) {
            return;
        }
        this.f501a.add(fdVar);
    }

    public void a(ff ffVar, fk fkVar) {
        if (ffVar != null) {
            this.f503a.put(ffVar, new a(ffVar, fkVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public void b(ff ffVar) {
        this.f506b.remove(ffVar);
    }

    /* renamed from: b, reason: collision with other method in class */
    protected void m417b() throws ClassNotFoundException {
        String property;
        if (this.f497a.m421a() && this.f498a == null) {
            Class<?> cls = null;
            try {
                property = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                property = null;
            }
            if (property != null) {
                try {
                    cls = Class.forName(property);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (cls == null) {
                this.f498a = new ez(this);
                return;
            }
            try {
                this.f498a = (fj) cls.getConstructor(fa.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e3) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
            }
        }
    }

    public void a(ff ffVar) {
        this.f503a.remove(ffVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    protected Map<ff, a> m415a() {
        return this.f503a;
    }

    public int a() {
        return this.f495a;
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.f12807c;
        if (i2 != i4) {
            com.xiaomi.channel.commonutils.logger.b.m50a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i4), a(i2), com.xiaomi.push.service.an.a(i3)));
        }
        if (au.m151a((Context) this.f499a)) {
            m411a(i2);
        }
        if (i2 == 1) {
            this.f499a.a(10);
            if (this.f12807c != 0) {
                com.xiaomi.channel.commonutils.logger.b.m50a("try set connected while not connecting.");
            }
            this.f12807c = i2;
            Iterator<fd> it = this.f501a.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i2 == 0) {
            if (this.f12807c != 2) {
                com.xiaomi.channel.commonutils.logger.b.m50a("try set connecting while not disconnected.");
            }
            this.f12807c = i2;
            Iterator<fd> it2 = this.f501a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
            return;
        }
        if (i2 == 2) {
            this.f499a.a(10);
            int i5 = this.f12807c;
            if (i5 == 0) {
                Iterator<fd> it3 = this.f501a.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                Iterator<fd> it4 = this.f501a.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i3, exc);
                }
            }
            this.f12807c = i2;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m418b() {
        return this.f12807c == 0;
    }

    public int b() {
        return this.f12807c;
    }

    public synchronized void a(String str) {
        if (this.f12807c == 0) {
            com.xiaomi.channel.commonutils.logger.b.m50a("setChallenge hash = " + ba.a(str).substring(0, 8));
            this.f500a = str;
            a(1, 0, null);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("ignore setChallenge because connection was disconnected");
        }
    }

    public synchronized boolean a(long j2) {
        return this.f12809e >= j2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m411a(int i2) {
        synchronized (this.f502a) {
            if (i2 == 1) {
                this.f502a.clear();
            } else {
                this.f502a.add(new Pair<>(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.f502a.size() > 6) {
                    this.f502a.remove(0);
                }
            }
        }
    }
}
