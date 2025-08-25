package m.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import c.b.c.n;
import java.io.IOException;

/* compiled from: CameraManager.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: m, reason: collision with root package name */
    private static final String f17266m = "d";
    private static final int n = 240;
    private static final int o = 240;
    private static final int p = 1200;
    private static final int q = 675;

    /* renamed from: a, reason: collision with root package name */
    private final Context f17267a;

    /* renamed from: b, reason: collision with root package name */
    private final b f17268b;

    /* renamed from: c, reason: collision with root package name */
    private Camera f17269c;

    /* renamed from: d, reason: collision with root package name */
    private a f17270d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f17271e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f17272f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17273g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f17274h;

    /* renamed from: i, reason: collision with root package name */
    private int f17275i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f17276j;

    /* renamed from: k, reason: collision with root package name */
    private int f17277k;

    /* renamed from: l, reason: collision with root package name */
    private final f f17278l;

    public d(Context context) {
        this.f17267a = context;
        this.f17268b = new b(context);
        this.f17278l = new f(this.f17268b);
    }

    public synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        Camera cameraA = this.f17269c;
        if (cameraA == null) {
            cameraA = this.f17275i >= 0 ? e.a(this.f17275i) : e.a();
            if (cameraA == null) {
                throw new IOException();
            }
            this.f17269c = cameraA;
        }
        cameraA.setPreviewDisplay(surfaceHolder);
        if (!this.f17273g) {
            this.f17273g = true;
            this.f17268b.a(cameraA);
            if (this.f17276j > 0 && this.f17277k > 0) {
                a(this.f17276j, this.f17277k);
                this.f17276j = 0;
                this.f17277k = 0;
            }
        }
        Camera.Parameters parameters = cameraA.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.f17268b.a(cameraA, false);
        } catch (RuntimeException unused) {
            String str = "Resetting to saved camera params: " + strFlatten;
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraA.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraA.setParameters(parameters2);
                    this.f17268b.a(cameraA, true);
                } catch (RuntimeException unused2) {
                }
            }
        }
    }

    public synchronized Rect b() {
        if (this.f17271e == null) {
            if (this.f17269c == null) {
                return null;
            }
            Point pointB = this.f17268b.b();
            if (pointB == null) {
                return null;
            }
            int iA = (a(pointB.x, 240, p) * 4) / 5;
            int iA2 = (a(pointB.y, 240, q) * 4) / 5;
            int i2 = (pointB.x - iA) / 2;
            int i3 = (pointB.y - iA2) / 2;
            this.f17271e = new Rect(i2, i3, iA + i2, iA2 + i3);
            String str = "Calculated framing rect: " + this.f17271e;
        }
        return this.f17271e;
    }

    public synchronized Rect c() {
        if (this.f17272f == null) {
            Rect rectB = b();
            if (rectB == null) {
                return null;
            }
            Rect rect = new Rect(rectB);
            Point pointA = this.f17268b.a();
            Point pointB = this.f17268b.b();
            if (pointA != null && pointB != null) {
                rect.left = (rect.left * pointA.y) / pointB.x;
                rect.right = (rect.right * pointA.y) / pointB.x;
                rect.top = (rect.top * pointA.x) / pointB.y;
                rect.bottom = (rect.bottom * pointA.x) / pointB.y;
                this.f17272f = rect;
            }
            return null;
        }
        return this.f17272f;
    }

    public synchronized boolean d() {
        return this.f17269c != null;
    }

    public synchronized void e() {
        Camera camera = this.f17269c;
        if (camera != null && !this.f17274h) {
            camera.startPreview();
            this.f17274h = true;
            this.f17270d = new a(this.f17267a, this.f17269c);
        }
    }

    public synchronized void f() {
        if (this.f17270d != null) {
            this.f17270d.b();
            this.f17270d = null;
        }
        if (this.f17269c != null && this.f17274h) {
            this.f17269c.stopPreview();
            this.f17278l.a(null, 0);
            this.f17274h = false;
        }
    }

    public synchronized void a() {
        if (this.f17269c != null) {
            this.f17269c.setPreviewCallback(null);
            this.f17269c.stopPreview();
            this.f17269c.release();
            this.f17269c = null;
            this.f17271e = null;
            this.f17272f = null;
        }
    }

    public synchronized void a(Handler handler, int i2) {
        Camera camera = this.f17269c;
        if (camera != null && this.f17274h) {
            this.f17278l.a(handler, i2);
            camera.setOneShotPreviewCallback(this.f17278l);
        }
    }

    private static int a(int i2, int i3, int i4) {
        int i5 = (i2 * 5) / 8;
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public synchronized void a(int i2) {
        this.f17275i = i2;
    }

    public synchronized void a(int i2, int i3) {
        if (this.f17273g) {
            Point pointB = this.f17268b.b();
            if (i2 > pointB.x) {
                i2 = pointB.x;
            }
            if (i3 > pointB.y) {
                i3 = pointB.y;
            }
            int i4 = (pointB.x - i2) / 2;
            int i5 = (pointB.y - i3) / 2;
            this.f17271e = new Rect(i4, i5, i2 + i4, i3 + i5);
            String str = "Calculated manual framing rect: " + this.f17271e;
            this.f17272f = null;
        } else {
            this.f17276j = i2;
            this.f17277k = i3;
        }
    }

    public n a(byte[] bArr, int i2, int i3) {
        Rect rectC = c();
        if (rectC == null) {
            return null;
        }
        return new n(bArr, i2, i3, rectC.left, rectC.top, rectC.width(), rectC.height(), false);
    }
}
