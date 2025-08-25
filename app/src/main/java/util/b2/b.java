package util.b2;

import android.media.MediaCodec;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import util.n1;

/* compiled from: MediaEncoder.java */
/* loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* renamed from: m, reason: collision with root package name */
    private static final boolean f20747m = false;
    private static final String n = "MediaEncoder";
    protected static final int o = 10000;
    protected static final int p = 1;
    protected static final int q = 9;

    /* renamed from: b, reason: collision with root package name */
    protected volatile boolean f20749b;

    /* renamed from: c, reason: collision with root package name */
    private int f20750c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile boolean f20751d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f20752e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f20753f;

    /* renamed from: g, reason: collision with root package name */
    protected int f20754g;

    /* renamed from: h, reason: collision with root package name */
    protected MediaCodec f20755h;

    /* renamed from: i, reason: collision with root package name */
    protected final WeakReference<c> f20756i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec.BufferInfo f20757j;

    /* renamed from: k, reason: collision with root package name */
    protected final a f20758k;

    /* renamed from: a, reason: collision with root package name */
    protected final Object f20748a = new Object();

    /* renamed from: l, reason: collision with root package name */
    private long f20759l = 0;

    /* compiled from: MediaEncoder.java */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public b(c cVar, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("MediaEncoderListener is null");
        }
        if (cVar == null) {
            throw new NullPointerException("MediaMuxerWrapper is null");
        }
        this.f20756i = new WeakReference<>(cVar);
        cVar.a(this);
        this.f20758k = aVar;
        synchronized (this.f20748a) {
            this.f20757j = new MediaCodec.BufferInfo();
            new Thread(this, getClass().getSimpleName()).start();
            try {
                this.f20748a.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void j() throws MediaCodec.CryptoException {
        boolean z;
        while (true) {
            synchronized (this.f20748a) {
                z = this.f20751d;
                if (this.f20750c > 0) {
                    this.f20750c--;
                }
            }
            if (z) {
                a();
                g();
                a();
                f();
                return;
            }
            a();
        }
    }

    protected void a(ByteBuffer byteBuffer, int i2, long j2) throws MediaCodec.CryptoException {
        if (this.f20749b) {
            ByteBuffer[] inputBuffers = this.f20755h.getInputBuffers();
            while (this.f20749b) {
                int iDequeueInputBuffer = this.f20755h.dequeueInputBuffer(com.heytap.mcssdk.constant.a.q);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[iDequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i2 > 0) {
                        this.f20755h.queueInputBuffer(iDequeueInputBuffer, 0, i2, j2, 0);
                        return;
                    } else {
                        this.f20752e = true;
                        this.f20755h.queueInputBuffer(iDequeueInputBuffer, 0, 0, j2, 4);
                        return;
                    }
                }
            }
        }
    }

    public boolean b() {
        synchronized (this.f20748a) {
            if (this.f20749b && !this.f20751d) {
                this.f20750c++;
                this.f20748a.notifyAll();
                return true;
            }
            return false;
        }
    }

    public String c() {
        c cVar = this.f20756i.get();
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    protected long d() {
        long jNanoTime = System.nanoTime() / 1000;
        long j2 = this.f20759l;
        return jNanoTime < j2 ? jNanoTime + (j2 - jNanoTime) : jNanoTime;
    }

    abstract void e() throws IOException;

    protected void f() {
        try {
            this.f20758k.b(this);
        } catch (Exception e2) {
            n1.a(n, "failed onStopped", e2);
        }
        this.f20749b = false;
        MediaCodec mediaCodec = this.f20755h;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f20755h.release();
                this.f20755h = null;
            } catch (Exception e3) {
                n1.a(n, "failed releasing MediaCodec", e3);
            }
        }
        if (this.f20753f) {
            WeakReference<c> weakReference = this.f20756i;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                try {
                    cVar.f();
                } catch (Exception e4) {
                    n1.a(n, "failed stopping muxer", e4);
                }
            }
        }
        this.f20757j = null;
    }

    protected void g() throws MediaCodec.CryptoException {
        a(null, 0, d());
    }

    void h() {
        synchronized (this.f20748a) {
            this.f20749b = true;
            this.f20751d = false;
            this.f20748a.notifyAll();
        }
    }

    void i() {
        synchronized (this.f20748a) {
            if (this.f20749b && !this.f20751d) {
                this.f20751d = true;
                this.f20748a.notifyAll();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() throws MediaCodec.CryptoException {
        synchronized (this.f20748a) {
            this.f20751d = false;
            this.f20750c = 0;
            this.f20748a.notify();
        }
        j();
        synchronized (this.f20748a) {
            this.f20751d = true;
            this.f20749b = false;
        }
    }

    protected void a() {
        MediaCodec mediaCodec = this.f20755h;
        if (mediaCodec == null) {
            return;
        }
        try {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            c cVar = this.f20756i.get();
            if (cVar == null) {
                n1.f(n, "muxer is unexpectedly null");
                return;
            }
            ByteBuffer[] outputBuffers2 = outputBuffers;
            int i2 = 0;
            while (this.f20749b) {
                int iDequeueOutputBuffer = this.f20755h.dequeueOutputBuffer(this.f20757j, com.heytap.mcssdk.constant.a.q);
                if (iDequeueOutputBuffer == -1) {
                    if (!this.f20752e && (i2 = i2 + 1) > 5) {
                        return;
                    }
                } else if (iDequeueOutputBuffer == -3) {
                    outputBuffers2 = this.f20755h.getOutputBuffers();
                } else if (iDequeueOutputBuffer == -2) {
                    if (!this.f20753f) {
                        this.f20754g = cVar.a(this.f20755h.getOutputFormat());
                        this.f20753f = true;
                        if (cVar.d()) {
                            continue;
                        } else {
                            synchronized (cVar) {
                                while (!cVar.b()) {
                                    try {
                                        cVar.wait(100L);
                                    } catch (InterruptedException unused) {
                                        return;
                                    }
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else if (iDequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = outputBuffers2[iDequeueOutputBuffer];
                    if (byteBuffer != null) {
                        MediaCodec.BufferInfo bufferInfo = this.f20757j;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        MediaCodec.BufferInfo bufferInfo2 = this.f20757j;
                        if (bufferInfo2.size != 0) {
                            if (this.f20753f) {
                                bufferInfo2.presentationTimeUs = d();
                                cVar.a(this.f20754g, byteBuffer, this.f20757j);
                                this.f20759l = this.f20757j.presentationTimeUs;
                                i2 = 0;
                            } else {
                                throw new RuntimeException("drain:muxer hasn't started");
                            }
                        }
                        this.f20755h.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        if ((this.f20757j.flags & 4) != 0) {
                            this.f20749b = false;
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                    }
                } else {
                    continue;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
