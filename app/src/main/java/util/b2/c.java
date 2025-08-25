package util.b2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import util.n1;

/* compiled from: MediaMuxerWrapper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f20760h = false;

    /* renamed from: i, reason: collision with root package name */
    private static final String f20761i = "MediaMuxerWrapper";

    /* renamed from: j, reason: collision with root package name */
    private static final String f20762j = "AVRecSample";

    /* renamed from: k, reason: collision with root package name */
    private static final SimpleDateFormat f20763k = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: a, reason: collision with root package name */
    private String f20764a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaMuxer f20765b;

    /* renamed from: c, reason: collision with root package name */
    private int f20766c;

    /* renamed from: d, reason: collision with root package name */
    private int f20767d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f20768e;

    /* renamed from: f, reason: collision with root package name */
    private b f20769f;

    /* renamed from: g, reason: collision with root package name */
    private b f20770g;

    public c(String str) throws IOException {
        try {
            this.f20764a = a(Environment.DIRECTORY_MOVIES, TextUtils.isEmpty(str) ? ".mp4" : str).toString();
            this.f20765b = new MediaMuxer(this.f20764a, 0);
            this.f20767d = 0;
            this.f20766c = 0;
            this.f20768e = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    private static final String h() {
        return f20763k.format(new GregorianCalendar().getTime());
    }

    public String a() {
        return this.f20764a;
    }

    public synchronized boolean b() {
        return this.f20768e;
    }

    public void c() throws IOException {
        b bVar = this.f20769f;
        if (bVar != null) {
            bVar.e();
        }
        b bVar2 = this.f20770g;
        if (bVar2 != null) {
            bVar2.e();
        }
    }

    synchronized boolean d() {
        this.f20767d++;
        if (this.f20766c > 0 && this.f20767d == this.f20766c) {
            this.f20765b.start();
            this.f20768e = true;
            notifyAll();
        }
        return this.f20768e;
    }

    public void e() {
        b bVar = this.f20769f;
        if (bVar != null) {
            bVar.h();
        }
        b bVar2 = this.f20770g;
        if (bVar2 != null) {
            bVar2.h();
        }
    }

    synchronized void f() {
        this.f20767d--;
        if (this.f20766c > 0 && this.f20767d <= 0) {
            this.f20765b.stop();
            this.f20765b.release();
            this.f20768e = false;
        }
    }

    public void g() {
        b bVar = this.f20769f;
        if (bVar != null) {
            bVar.i();
        }
        this.f20769f = null;
        b bVar2 = this.f20770g;
        if (bVar2 != null) {
            bVar2.i();
        }
        this.f20770g = null;
    }

    void a(b bVar) {
        if (bVar instanceof d) {
            if (this.f20769f != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f20769f = bVar;
        } else {
            if (!(bVar instanceof a)) {
                throw new IllegalArgumentException("unsupported encoder");
            }
            if (this.f20770g != null) {
                throw new IllegalArgumentException("Video encoder already added.");
            }
            this.f20770g = bVar;
        }
        this.f20766c = (this.f20769f != null ? 1 : 0) + (this.f20770g == null ? 0 : 1);
    }

    synchronized int a(MediaFormat mediaFormat) {
        if (!this.f20768e) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f20765b.addTrack(mediaFormat);
    }

    synchronized void a(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f20767d > 0) {
            this.f20765b.writeSampleData(i2, byteBuffer, bufferInfo);
        }
    }

    public static final File a(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        File file = new File(d.d.f13557m);
        n1.a(f20761i, "path=" + file.toString());
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, simpleDateFormat.format(new Date()) + str2);
    }
}
