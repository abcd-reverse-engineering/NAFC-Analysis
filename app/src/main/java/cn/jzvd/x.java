package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: JZMediaSystem.java */
/* loaded from: classes.dex */
public class x extends w implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: f, reason: collision with root package name */
    public MediaPlayer f3255f;

    public x(Jzvd jzvd) {
        super(jzvd);
    }

    @Override // cn.jzvd.w
    public void a(final long j2) {
        this.f3252b.post(new Runnable() { // from class: cn.jzvd.c
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f3208a.b(j2);
            }
        });
    }

    public /* synthetic */ void b(long j2) throws IllegalStateException {
        try {
            this.f3255f.seekTo((int) j2);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.jzvd.w
    public boolean c() {
        return this.f3255f.isPlaying();
    }

    @Override // cn.jzvd.w
    public void d() {
        this.f3252b.post(new Runnable() { // from class: cn.jzvd.i
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f3221a.k();
            }
        });
    }

    @Override // cn.jzvd.w
    public void e() {
        f();
        this.f3251a = new HandlerThread("JZVD");
        this.f3251a.start();
        this.f3252b = new Handler(this.f3251a.getLooper());
        this.f3253c = new Handler();
        this.f3252b.post(new Runnable() { // from class: cn.jzvd.a
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f3204a.l();
            }
        });
    }

    @Override // cn.jzvd.w
    public void f() {
        final HandlerThread handlerThread;
        final MediaPlayer mediaPlayer;
        Handler handler = this.f3252b;
        if (handler == null || (handlerThread = this.f3251a) == null || (mediaPlayer = this.f3255f) == null) {
            return;
        }
        w.f3250e = null;
        handler.post(new Runnable() { // from class: cn.jzvd.h
            @Override // java.lang.Runnable
            public final void run() {
                x.a(mediaPlayer, handlerThread);
            }
        });
        this.f3255f = null;
    }

    @Override // cn.jzvd.w
    public void g() {
        this.f3252b.post(new Runnable() { // from class: cn.jzvd.f
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.f3216a.m();
            }
        });
    }

    public /* synthetic */ void h() {
        this.f3254d.j();
    }

    public /* synthetic */ void i() {
        this.f3254d.k();
    }

    public /* synthetic */ void j() {
        this.f3254d.l();
    }

    public /* synthetic */ void k() throws IllegalStateException {
        this.f3255f.pause();
    }

    public /* synthetic */ void l() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f3255f = new MediaPlayer();
            this.f3255f.setAudioStreamType(3);
            this.f3255f.setLooping(this.f3254d.f3190c.f3248e);
            this.f3255f.setOnPreparedListener(this);
            this.f3255f.setOnCompletionListener(this);
            this.f3255f.setOnBufferingUpdateListener(this);
            this.f3255f.setScreenOnWhilePlaying(true);
            this.f3255f.setOnSeekCompleteListener(this);
            this.f3255f.setOnErrorListener(this);
            this.f3255f.setOnInfoListener(this);
            this.f3255f.setOnVideoSizeChangedListener(this);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.f3255f, this.f3254d.f3190c.c().toString(), this.f3254d.f3190c.f3247d);
            this.f3255f.prepareAsync();
            this.f3255f.setSurface(new Surface(w.f3250e));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void m() throws IllegalStateException {
        this.f3255f.start();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, final int i2) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f3217a.a(i2);
            }
        });
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f3223a.h();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f3210a.a(i2, i3);
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f3213a.b(i2, i3);
            }
        });
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f3227a.i();
            }
        });
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f3222a.j();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = w.f3250e;
        if (surfaceTexture2 != null) {
            this.f3254d.u.setSurfaceTexture(surfaceTexture2);
        } else {
            w.f3250e = surfaceTexture;
            e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i2, final int i3) {
        this.f3253c.post(new Runnable() { // from class: cn.jzvd.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f3224a.c(i2, i3);
            }
        });
    }

    static /* synthetic */ void a(MediaPlayer mediaPlayer, HandlerThread handlerThread) {
        mediaPlayer.setSurface(null);
        mediaPlayer.release();
        handlerThread.quit();
    }

    public /* synthetic */ void c(int i2, int i3) {
        this.f3254d.c(i2, i3);
    }

    @Override // cn.jzvd.w
    public long b() {
        if (this.f3255f != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    @Override // cn.jzvd.w
    public long a() {
        if (this.f3255f != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    public /* synthetic */ void b(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f3255f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    public /* synthetic */ void b(int i2, int i3) {
        this.f3254d.b(i2, i3);
    }

    @Override // cn.jzvd.w
    public void a(final float f2, final float f3) {
        Handler handler = this.f3252b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: cn.jzvd.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f3205a.b(f2, f3);
            }
        });
    }

    @Override // cn.jzvd.w
    @RequiresApi(api = 23)
    public void a(float f2) {
        PlaybackParams playbackParams = this.f3255f.getPlaybackParams();
        playbackParams.setSpeed(f2);
        this.f3255f.setPlaybackParams(playbackParams);
    }

    public /* synthetic */ void a(int i2) {
        this.f3254d.setBufferProgress(i2);
    }

    public /* synthetic */ void a(int i2, int i3) {
        this.f3254d.a(i2, i3);
    }

    @Override // cn.jzvd.w
    public void a(Surface surface) {
        this.f3255f.setSurface(surface);
    }
}
