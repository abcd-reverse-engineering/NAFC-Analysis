package h.i2;

import h.m2.f;
import h.q2.e;
import h.q2.t.f0;
import i.c.a.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Locks.kt */
@e(name = "LocksKt")
/* loaded from: classes2.dex */
public final class a {
    @f
    private static final <T> T a(@d Lock lock, h.q2.s.a<? extends T> aVar) {
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            lock.unlock();
            f0.a(1);
        }
    }

    @f
    private static final <T> T b(@d ReentrantReadWriteLock reentrantReadWriteLock, h.q2.s.a<? extends T> aVar) {
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            while (i2 < readHoldCount) {
                lock.lock();
                i2++;
            }
            writeLock.unlock();
            f0.a(1);
        }
    }

    @f
    private static final <T> T a(@d ReentrantReadWriteLock reentrantReadWriteLock, h.q2.s.a<? extends T> aVar) {
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            f0.b(1);
            lock.unlock();
            f0.a(1);
        }
    }
}
