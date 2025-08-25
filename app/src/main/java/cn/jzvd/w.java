package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;

/* compiled from: JZMediaInterface.java */
/* loaded from: classes.dex */
public abstract class w implements TextureView.SurfaceTextureListener {

    /* renamed from: e, reason: collision with root package name */
    public static SurfaceTexture f3250e;

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f3251a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f3252b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f3253c;

    /* renamed from: d, reason: collision with root package name */
    public Jzvd f3254d;

    public w(Jzvd jzvd) {
        this.f3254d = jzvd;
    }

    public abstract long a();

    public abstract void a(float f2);

    public abstract void a(float f2, float f3);

    public abstract void a(long j2);

    public abstract void a(Surface surface);

    public abstract long b();

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
