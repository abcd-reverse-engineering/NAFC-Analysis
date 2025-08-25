package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static long f13429a;

    /* renamed from: b, reason: collision with root package name */
    private static long f13430b;

    /* renamed from: c, reason: collision with root package name */
    private static long f13431c;

    /* renamed from: a, reason: collision with other field name */
    private final a f1055a;

    /* renamed from: a, reason: collision with other field name */
    private final c f1056a;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final c f13432a;

        a(c cVar) {
            this.f13432a = cVar;
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this.f13432a) {
                    this.f13432a.f13436c = true;
                    this.f13432a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        protected int f13433a;

        public b(int i2) {
            this.f13433a = i2;
        }
    }

    private static final class c extends Thread {

        /* renamed from: b, reason: collision with other field name */
        private boolean f1059b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f13436c;

        /* renamed from: a, reason: collision with root package name */
        private volatile long f13434a = 0;

        /* renamed from: a, reason: collision with other field name */
        private volatile boolean f1058a = false;

        /* renamed from: b, reason: collision with root package name */
        private long f13435b = 50;

        /* renamed from: a, reason: collision with other field name */
        private a f1057a = new a();

        private static final class a {

            /* renamed from: a, reason: collision with root package name */
            private int f13437a;

            /* renamed from: a, reason: collision with other field name */
            private d[] f1060a;

            /* renamed from: b, reason: collision with root package name */
            private int f13438b;

            /* renamed from: c, reason: collision with root package name */
            private int f13439c;

            private a() {
                this.f13437a = 256;
                this.f1060a = new d[this.f13437a];
                this.f13438b = 0;
                this.f13439c = 0;
            }

            private void c() {
                int i2 = this.f13438b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i2].f1061a >= dVarArr[i3].f1061a) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            public void b(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f13438b)) {
                    return;
                }
                d[] dVarArr = this.f1060a;
                int i4 = i3 - 1;
                this.f13438b = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[this.f13438b] = null;
                c(i2);
            }

            public d a() {
                return this.f1060a[0];
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m738a() {
                return this.f13438b == 0;
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m737a(d dVar) {
                d[] dVarArr = this.f1060a;
                int length = dVarArr.length;
                int i2 = this.f13438b;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.f1060a = dVarArr2;
                }
                d[] dVarArr3 = this.f1060a;
                int i3 = this.f13438b;
                this.f13438b = i3 + 1;
                dVarArr3[i3] = dVar;
                c();
            }

            public void b() {
                int i2 = 0;
                while (i2 < this.f13438b) {
                    if (this.f1060a[i2].f1064a) {
                        this.f13439c++;
                        b(i2);
                        i2--;
                    }
                    i2++;
                }
            }

            private void c(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f13438b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f1060a;
                        if (dVarArr[i5].f1061a < dVarArr[i3].f1061a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f1060a;
                    if (dVarArr2[i2].f1061a < dVarArr2[i3].f1061a) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m739a(int i2) {
                for (int i3 = 0; i3 < this.f13438b; i3++) {
                    if (this.f1060a[i3].f13440a == i2) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i2) {
                for (int i3 = 0; i3 < this.f13438b; i3++) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i3].f13440a == i2) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            public void a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f13438b; i3++) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i3].f1062a == bVar) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m736a() {
                this.f1060a = new d[this.f13437a];
                this.f13438b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f1060a;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
        
            r10.f13434a = android.os.SystemClock.uptimeMillis();
            r10.f1058a = true;
            r2.f1062a.run();
            r10.f1058a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00aa, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ab, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ac, code lost:
        
            r10.f1059b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00af, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 188
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f1057a.m737a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1059b = true;
            this.f1057a.m736a();
            notify();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m735a() {
            return this.f1058a && SystemClock.uptimeMillis() - this.f13434a > 600000;
        }
    }

    static {
        f13429a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f13430b = f13429a;
    }

    public n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f1056a = new c(str, z);
        this.f1055a = new a(this.f1056a);
    }

    static synchronized long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > f13430b) {
            f13429a += jElapsedRealtime - f13430b;
        }
        f13430b = jElapsedRealtime;
        return f13429a;
    }

    private static synchronized long b() {
        long j2;
        j2 = f13431c;
        f13431c = 1 + j2;
        return j2;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m733b() {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.m736a();
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int f13440a;

        /* renamed from: a, reason: collision with other field name */
        long f1061a;

        /* renamed from: a, reason: collision with other field name */
        b f1062a;

        /* renamed from: a, reason: collision with other field name */
        final Object f1063a = new Object();

        /* renamed from: a, reason: collision with other field name */
        boolean f1064a;

        /* renamed from: b, reason: collision with root package name */
        private long f13441b;

        d() {
        }

        void a(long j2) {
            synchronized (this.f1063a) {
                this.f13441b = j2;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1063a) {
                z = !this.f1064a && this.f1061a > 0;
                this.f1064a = true;
            }
            return z;
        }
    }

    public n(String str) {
        this(str, false);
    }

    private void b(b bVar, long j2) {
        synchronized (this.f1056a) {
            if (!this.f1056a.f1059b) {
                long jA = j2 + a();
                if (jA >= 0) {
                    d dVar = new d();
                    dVar.f13440a = bVar.f13433a;
                    dVar.f1062a = bVar;
                    dVar.f1061a = jA;
                    this.f1056a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m730a() {
        com.xiaomi.channel.commonutils.logger.b.m50a("quit. finalizer:" + this.f1055a);
        this.f1056a.a();
    }

    public n() {
        this(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m732a(int i2) {
        boolean zM739a;
        synchronized (this.f1056a) {
            zM739a = this.f1056a.f1057a.m739a(i2);
        }
        return zM739a;
    }

    public void a(int i2) {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.a(i2);
        }
    }

    public void a(int i2, b bVar) {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.a(i2, bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m731a() {
        return this.f1056a.m735a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f1056a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j2) {
        if (j2 >= 0) {
            b(bVar, j2);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j2);
    }
}
