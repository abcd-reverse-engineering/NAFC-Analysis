package com.bumptech.glide.load.p.b0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f4395a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f4396b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f4397a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f4398b;

        a() {
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f4395a.get(str);
            if (aVarA == null) {
                aVarA = this.f4396b.a();
                this.f4395a.put(str, aVarA);
            }
            aVarA.f4398b++;
        }
        aVarA.f4397a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.bumptech.glide.util.j.a(this.f4395a.get(str));
            if (aVar.f4398b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f4398b);
            }
            aVar.f4398b--;
            if (aVar.f4398b == 0) {
                a aVarRemove = this.f4395a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.f4396b.a(aVarRemove);
            }
        }
        aVar.f4397a.unlock();
    }

    /* compiled from: DiskCacheWriteLocker.java */
    private static class b {

        /* renamed from: b, reason: collision with root package name */
        private static final int f4399b = 10;

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f4400a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.f4400a) {
                aVarPoll = this.f4400a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.f4400a) {
                if (this.f4400a.size() < 10) {
                    this.f4400a.offer(aVar);
                }
            }
        }
    }
}
