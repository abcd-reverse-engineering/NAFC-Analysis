package util.b2;

import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.opengl.EGLContext;
import android.view.Surface;
import java.io.IOException;
import util.b2.b;
import util.n1;

/* compiled from: MediaVideoEncoder.java */
/* loaded from: classes2.dex */
public class d extends b {
    private static final int A = 25;
    private static final float B = 0.25f;
    protected static int[] C = {2130708361};
    private static final boolean x = false;
    private static final String y = "MediaVideoEncoder";
    private static final String z = "video/avc";
    private final int r;
    private final int s;
    private Surface t;
    private MediaProjection u;
    private VirtualDisplay v;
    private int w;

    public d(c cVar, b.a aVar, int i2, int i3, MediaProjection mediaProjection) {
        super(cVar, aVar);
        this.u = null;
        this.v = null;
        this.w = 240;
        this.r = i2;
        this.s = i3;
        this.u = mediaProjection;
    }

    private int j() {
        int i2 = (int) (this.r * 6.25f * this.s);
        n1.c(y, String.format("bitrate=%5.2f[Mbps]", Float.valueOf((i2 / 1024.0f) / 1024.0f)));
        return i2;
    }

    private VirtualDisplay k() {
        MediaProjection mediaProjection = this.u;
        if (mediaProjection == null || this.f20755h == null) {
            return null;
        }
        return mediaProjection.createVirtualDisplay("mediaProjection", this.r, this.s, this.w, 16, this.t, null, null);
    }

    public void a(EGLContext eGLContext, int i2) {
    }

    public boolean a(float[] fArr) {
        return super.b();
    }

    @Override // util.b2.b
    public boolean b() {
        return super.b();
    }

    @Override // util.b2.b
    protected void e() throws IOException {
        this.f20754g = -1;
        this.f20752e = false;
        this.f20753f = false;
        if (a(z) == null) {
            n1.b(y, "Unable to find an appropriate codec for video/avc");
            return;
        }
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(z, this.r, this.s);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", j());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", 25);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 10);
        this.f20755h = MediaCodec.createEncoderByType(z);
        this.f20755h.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.t = this.f20755h.createInputSurface();
        this.f20755h.start();
        this.v = k();
        b.a aVar = this.f20758k;
        if (aVar != null) {
            try {
                aVar.a(this);
            } catch (Exception e2) {
                n1.a(y, "prepare:", e2);
            }
        }
    }

    @Override // util.b2.b
    protected void f() {
        Surface surface = this.t;
        if (surface != null) {
            surface.release();
            this.t = null;
        }
        super.f();
    }

    @Override // util.b2.b
    protected void g() {
        this.f20755h.signalEndOfInputStream();
        this.f20752e = true;
    }

    public boolean a(float[] fArr, float[] fArr2) {
        return super.b();
    }

    protected static final MediaCodecInfo a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str) && a(codecInfoAt, str) > 0) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    protected static final int a(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            Thread.currentThread().setPriority(10);
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Thread.currentThread().setPriority(5);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr = capabilitiesForType.colorFormats;
                if (i3 >= iArr.length) {
                    break;
                }
                int i4 = iArr[i3];
                if (a(i4)) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
            if (i2 == 0) {
                n1.b(y, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
            }
            return i2;
        } catch (Throwable th) {
            Thread.currentThread().setPriority(5);
            throw th;
        }
    }

    private static final boolean a(int i2) {
        int[] iArr = C;
        int length = iArr != null ? iArr.length : 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (C[i3] == i2) {
                return true;
            }
        }
        return false;
    }
}
