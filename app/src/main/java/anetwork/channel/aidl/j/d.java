package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d extends f.a {
    private static final String r = "anet.ParcelableInputStreamImpl";
    private static final ByteArray s = ByteArray.create(0);

    /* renamed from: k, reason: collision with root package name */
    private int f2159k;

    /* renamed from: l, reason: collision with root package name */
    private int f2160l;

    /* renamed from: m, reason: collision with root package name */
    private int f2161m;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f2157i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private LinkedList<ByteArray> f2158j = new LinkedList<>();
    private int n = 10000;
    private String o = "";
    final ReentrantLock p = new ReentrantLock();
    final Condition q = this.p.newCondition();

    private void b() {
        this.p.lock();
        try {
            this.f2158j.set(this.f2159k, s).recycle();
        } finally {
            this.p.unlock();
        }
    }

    public void a(ByteArray byteArray) {
        if (this.f2157i.get()) {
            return;
        }
        this.p.lock();
        try {
            this.f2158j.add(byteArray);
            this.q.signal();
        } finally {
            this.p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public int available() throws RemoteException {
        if (this.f2157i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.p.lock();
        try {
            int dataLength = 0;
            if (this.f2159k == this.f2158j.size()) {
                return 0;
            }
            ListIterator<ByteArray> listIterator = this.f2158j.listIterator(this.f2159k);
            while (listIterator.hasNext()) {
                dataLength += listIterator.next().getDataLength();
            }
            return dataLength - this.f2160l;
        } finally {
            this.p.unlock();
        }
    }

    @Override // anetwork.channel.aidl.f
    public void close() throws RemoteException {
        if (this.f2157i.compareAndSet(false, true)) {
            this.p.lock();
            try {
                Iterator<ByteArray> it = this.f2158j.iterator();
                while (it.hasNext()) {
                    ByteArray next = it.next();
                    if (next != s) {
                        next.recycle();
                    }
                }
                this.f2158j.clear();
                this.f2158j = null;
                this.f2159k = -1;
                this.f2160l = -1;
                this.f2161m = 0;
            } finally {
                this.p.unlock();
            }
        }
    }

    @Override // anetwork.channel.aidl.f
    public int length() throws RemoteException {
        return this.f2161m;
    }

    @Override // anetwork.channel.aidl.f
    public int read(byte[] bArr) throws RemoteException {
        return a(bArr, 0, bArr.length);
    }

    @Override // anetwork.channel.aidl.f
    public int readByte() throws RemoteException {
        byte b2;
        if (this.f2157i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        this.p.lock();
        while (true) {
            try {
                try {
                    if (this.f2159k == this.f2158j.size() && !this.q.await(this.n, TimeUnit.MILLISECONDS)) {
                        close();
                        throw new RuntimeException("await timeout.");
                    }
                    ByteArray byteArray = this.f2158j.get(this.f2159k);
                    if (byteArray == s) {
                        b2 = -1;
                        break;
                    }
                    if (this.f2160l < byteArray.getDataLength()) {
                        b2 = byteArray.getBuffer()[this.f2160l];
                        this.f2160l++;
                        break;
                    }
                    b();
                    this.f2159k++;
                    this.f2160l = 0;
                } catch (InterruptedException unused) {
                    close();
                    throw new RuntimeException("await interrupt");
                }
            } finally {
                this.p.unlock();
            }
        }
        return b2;
    }

    public void a() {
        a(s);
    }

    @Override // anetwork.channel.aidl.f
    public int a(byte[] bArr, int i2, int i3) throws RemoteException {
        int i4;
        if (this.f2157i.get()) {
            throw new RuntimeException("Stream is closed");
        }
        if (bArr != null) {
            if (i2 >= 0 && i3 >= 0 && (i4 = i3 + i2) <= bArr.length) {
                this.p.lock();
                int i5 = i2;
                while (i5 < i4) {
                    try {
                        try {
                            if (this.f2159k == this.f2158j.size() && !this.q.await(this.n, TimeUnit.MILLISECONDS)) {
                                close();
                                throw new RuntimeException("await timeout.");
                            }
                            ByteArray byteArray = this.f2158j.get(this.f2159k);
                            if (byteArray == s) {
                                break;
                            }
                            int dataLength = byteArray.getDataLength() - this.f2160l;
                            int i6 = i4 - i5;
                            if (dataLength < i6) {
                                System.arraycopy(byteArray.getBuffer(), this.f2160l, bArr, i5, dataLength);
                                i5 += dataLength;
                                b();
                                this.f2159k++;
                                this.f2160l = 0;
                            } else {
                                System.arraycopy(byteArray.getBuffer(), this.f2160l, bArr, i5, i6);
                                this.f2160l += i6;
                                i5 += i6;
                            }
                        } catch (InterruptedException unused) {
                            close();
                            throw new RuntimeException("await interrupt");
                        }
                    } catch (Throwable th) {
                        this.p.unlock();
                        throw th;
                    }
                }
                this.p.unlock();
                int i7 = i5 - i2;
                if (i7 > 0) {
                    return i7;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    @Override // anetwork.channel.aidl.f
    public long a(int i2) throws RemoteException {
        ByteArray byteArray;
        this.p.lock();
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.f2159k != this.f2158j.size() && (byteArray = this.f2158j.get(this.f2159k)) != s) {
                    int dataLength = byteArray.getDataLength();
                    int i4 = i2 - i3;
                    if (dataLength - this.f2160l < i4) {
                        i3 += dataLength - this.f2160l;
                        b();
                        this.f2159k++;
                        this.f2160l = 0;
                    } else {
                        this.f2160l += i4;
                        i3 = i2;
                    }
                }
            } catch (Throwable th) {
                this.p.unlock();
                throw th;
            }
        }
        this.p.unlock();
        return i3;
    }

    public void a(anetwork.channel.entity.k kVar, int i2) {
        this.f2161m = i2;
        this.o = kVar.f2229i;
        this.n = kVar.f2228h;
    }
}
