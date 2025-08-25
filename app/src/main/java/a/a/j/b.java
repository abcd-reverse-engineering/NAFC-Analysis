package a.a.j;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f1110a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f1111b = new ReentrantReadWriteLock();

    /* renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock.ReadLock f1112c = f1111b.readLock();

    /* renamed from: d, reason: collision with root package name */
    private static final ReentrantReadWriteLock.WriteLock f1113d = f1111b.writeLock();

    /* compiled from: Taobao */
    private static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        final a.a.j.a f1114a;

        /* renamed from: b, reason: collision with root package name */
        final c f1115b;

        /* renamed from: c, reason: collision with root package name */
        final int f1116c;

        a(a.a.j.a aVar, c cVar, int i2) {
            this.f1114a = aVar;
            this.f1115b = cVar;
            this.f1116c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f1116c - aVar.f1116c;
        }
    }

    public static void a(a.a.j.a aVar, c cVar, int i2) {
        try {
            if (aVar == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (cVar == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            f1113d.lock();
            f1110a.add(new a(aVar, cVar, i2));
            Collections.sort(f1110a);
        } finally {
            f1113d.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(a.a.j.a r2) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = a.a.j.b.f1113d     // Catch: java.lang.Throwable -> L24
            r0.lock()     // Catch: java.lang.Throwable -> L24
            java.util.List<a.a.j.b$a> r0 = a.a.j.b.f1110a     // Catch: java.lang.Throwable -> L24
            java.util.ListIterator r0 = r0.listIterator()     // Catch: java.lang.Throwable -> L24
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L24
            a.a.j.b$a r1 = (a.a.j.b.a) r1     // Catch: java.lang.Throwable -> L24
            a.a.j.a r1 = r1.f1114a     // Catch: java.lang.Throwable -> L24
            if (r1 != r2) goto Lb
            r0.remove()     // Catch: java.lang.Throwable -> L24
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = a.a.j.b.f1113d
            r2.unlock()
            return
        L24:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = a.a.j.b.f1113d
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.j.b.a(a.a.j.a):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r3 = r1.f1114a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a.a.j.a a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = a.a.j.b.f1112c     // Catch: java.lang.Throwable -> L29
            r0.lock()     // Catch: java.lang.Throwable -> L29
            java.util.List<a.a.j.b$a> r0 = a.a.j.b.f1110a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L29
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L29
            a.a.j.b$a r1 = (a.a.j.b.a) r1     // Catch: java.lang.Throwable -> L29
            a.a.j.c r2 = r1.f1115b     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.handleCache(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto Lb
            a.a.j.a r3 = r1.f1114a     // Catch: java.lang.Throwable -> L29
        L21:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = a.a.j.b.f1112c
            r4.unlock()
            return r3
        L27:
            r3 = 0
            goto L21
        L29:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = a.a.j.b.f1112c
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.j.b.a(java.lang.String, java.util.Map):a.a.j.a");
    }

    public static void a() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<a> it = f1110a.iterator();
        while (it.hasNext()) {
            try {
                it.next().f1114a.clear();
            } catch (Exception unused) {
            }
        }
    }
}
