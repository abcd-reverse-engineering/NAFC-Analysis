package m.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;

/* compiled from: PreviewCallback.java */
/* loaded from: classes2.dex */
final class f implements Camera.PreviewCallback {

    /* renamed from: d, reason: collision with root package name */
    private static final String f17280d = f.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final b f17281a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f17282b;

    /* renamed from: c, reason: collision with root package name */
    private int f17283c;

    f(b bVar) {
        this.f17281a = bVar;
    }

    void a(Handler handler, int i2) {
        this.f17282b = handler;
        this.f17283c = i2;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointA = this.f17281a.a();
        Handler handler = this.f17282b;
        if (pointA == null || handler == null) {
            return;
        }
        handler.obtainMessage(this.f17283c, pointA.x, pointA.y, bArr).sendToTarget();
        this.f17282b = null;
    }
}
