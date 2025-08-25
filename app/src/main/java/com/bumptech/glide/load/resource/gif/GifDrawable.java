package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.resource.gif.f;
import com.bumptech.glide.util.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements f.b, Animatable, Animatable2Compat {

    /* renamed from: l, reason: collision with root package name */
    public static final int f4996l = -1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f4997m = 0;
    private static final int n = 119;

    /* renamed from: a, reason: collision with root package name */
    private final a f4998a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4999b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5000c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5001d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5002e;

    /* renamed from: f, reason: collision with root package name */
    private int f5003f;

    /* renamed from: g, reason: collision with root package name */
    private int f5004g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5005h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f5006i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f5007j;

    /* renamed from: k, reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f5008k;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        final f f5009a;

        a(f fVar) {
            this.f5009a = fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, com.bumptech.glide.o.a aVar, com.bumptech.glide.load.p.a0.e eVar, n<Bitmap> nVar, int i2, int i3, Bitmap bitmap) {
        this(context, aVar, nVar, i2, i3, bitmap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback k() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect l() {
        if (this.f5007j == null) {
            this.f5007j = new Rect();
        }
        return this.f5007j;
    }

    private Paint m() {
        if (this.f5006i == null) {
            this.f5006i = new Paint(2);
        }
        return this.f5006i;
    }

    private void n() {
        List<Animatable2Compat.AnimationCallback> list = this.f5008k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5008k.get(i2).onAnimationEnd(this);
            }
        }
    }

    private void o() {
        this.f5003f = 0;
    }

    private void p() {
        j.a(!this.f5001d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4998a.f5009a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f4999b) {
                return;
            }
            this.f4999b = true;
            this.f4998a.f5009a.a(this);
            invalidateSelf();
        }
    }

    private void q() {
        this.f4999b = false;
        this.f4998a.f5009a.b(this);
    }

    public void a(n<Bitmap> nVar, Bitmap bitmap) {
        this.f4998a.f5009a.a(nVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f4998a.f5009a.b();
    }

    public Bitmap c() {
        return this.f4998a.f5009a.e();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f5008k;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.f4998a.f5009a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f5001d) {
            return;
        }
        if (this.f5005h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), l());
            this.f5005h = false;
        }
        canvas.drawBitmap(this.f4998a.f5009a.c(), (Rect) null, l(), m());
    }

    public int e() {
        return this.f4998a.f5009a.d();
    }

    public n<Bitmap> f() {
        return this.f4998a.f5009a.g();
    }

    public int g() {
        return this.f4998a.f5009a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4998a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4998a.f5009a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4998a.f5009a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    boolean h() {
        return this.f5001d;
    }

    public void i() {
        this.f5001d = true;
        this.f4998a.f5009a.a();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4999b;
    }

    public void j() {
        j.a(!this.f4999b, "You cannot restart a currently running animation.");
        this.f4998a.f5009a.l();
        start();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5005h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f5008k == null) {
            this.f5008k = new ArrayList();
        }
        this.f5008k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        m().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        j.a(!this.f5001d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f5002e = z;
        if (!z) {
            q();
        } else if (this.f5000c) {
            p();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f5000c = true;
        o();
        if (this.f5002e) {
            p();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f5000c = false;
        q();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f5008k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public GifDrawable(Context context, com.bumptech.glide.o.a aVar, n<Bitmap> nVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new f(com.bumptech.glide.b.a(context), aVar, i2, i3, nVar, bitmap)));
    }

    void a(boolean z) {
        this.f4999b = z;
    }

    @Override // com.bumptech.glide.load.resource.gif.f.b
    public void a() {
        if (k() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f5003f++;
        }
        int i2 = this.f5004g;
        if (i2 == -1 || this.f5003f < i2) {
            return;
        }
        n();
        stop();
    }

    GifDrawable(a aVar) {
        this.f5002e = true;
        this.f5004g = -1;
        this.f4998a = (a) j.a(aVar);
    }

    @VisibleForTesting
    GifDrawable(f fVar, Paint paint) {
        this(new a(fVar));
        this.f5006i = paint;
    }

    public void a(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            int i3 = this.f4998a.f5009a.i();
            if (i3 == 0) {
                i3 = -1;
            }
            this.f5004g = i3;
            return;
        }
        this.f5004g = i2;
    }
}
