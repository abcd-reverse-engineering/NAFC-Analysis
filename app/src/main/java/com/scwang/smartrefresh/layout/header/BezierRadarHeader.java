package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.e.e;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: classes.dex */
public class BezierRadarHeader extends InternalAbstract implements g {
    protected static final byte A = 2;
    protected static final byte B = 3;
    protected static final byte C = 4;
    protected static final byte y = 0;
    protected static final byte z = 1;

    /* renamed from: d, reason: collision with root package name */
    protected int f8294d;

    /* renamed from: e, reason: collision with root package name */
    protected int f8295e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f8296f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f8297g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f8298h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f8299i;

    /* renamed from: j, reason: collision with root package name */
    protected Path f8300j;

    /* renamed from: k, reason: collision with root package name */
    protected Paint f8301k;

    /* renamed from: l, reason: collision with root package name */
    protected int f8302l;

    /* renamed from: m, reason: collision with root package name */
    protected int f8303m;
    protected int n;
    protected float o;
    protected float p;
    protected float q;
    protected float r;
    protected int s;
    protected float t;
    protected float u;
    protected float v;
    protected Animator w;
    protected RectF x;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8304a = new int[com.scwang.smartrefresh.layout.c.b.values().length];

        static {
            try {
                f8304a[com.scwang.smartrefresh.layout.c.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8304a[com.scwang.smartrefresh.layout.c.b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        byte f8305a;

        b(byte b2) {
            this.f8305a = b2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b2 = this.f8305a;
            if (b2 == 0) {
                BezierRadarHeader.this.v = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b2) {
                BezierRadarHeader bezierRadarHeader = BezierRadarHeader.this;
                if (bezierRadarHeader.f8298h) {
                    valueAnimator.cancel();
                    return;
                }
                bezierRadarHeader.f8303m = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b2) {
                BezierRadarHeader.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b2) {
                BezierRadarHeader.this.r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b2) {
                BezierRadarHeader.this.s = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    protected void a(Canvas canvas, int i2) {
        this.f8300j.reset();
        this.f8300j.lineTo(0.0f, this.f8302l);
        Path path = this.f8300j;
        int i3 = this.n;
        if (i3 < 0) {
            i3 = i2 / 2;
        }
        float f2 = i2;
        path.quadTo(i3, this.f8303m + r3, f2, this.f8302l);
        this.f8300j.lineTo(f2, 0.0f);
        this.f8301k.setColor(this.f8295e);
        canvas.drawPath(this.f8300j, this.f8301k);
    }

    protected void b(Canvas canvas, int i2, int i3) {
        if (this.w != null || isInEditMode()) {
            float f2 = this.t;
            float f3 = this.v;
            float f4 = f2 * f3;
            float f5 = this.u * f3;
            this.f8301k.setColor(this.f8294d);
            this.f8301k.setStyle(Paint.Style.FILL);
            float f6 = i2 / 2;
            float f7 = i3 / 2;
            canvas.drawCircle(f6, f7, f4, this.f8301k);
            this.f8301k.setStyle(Paint.Style.STROKE);
            float f8 = f5 + f4;
            canvas.drawCircle(f6, f7, f8, this.f8301k);
            this.f8301k.setColor((this.f8295e & ViewCompat.MEASURED_SIZE_MASK) | 1426063360);
            this.f8301k.setStyle(Paint.Style.FILL);
            this.x.set(f6 - f4, f7 - f4, f6 + f4, f4 + f7);
            canvas.drawArc(this.x, 270.0f, this.s, true, this.f8301k);
            this.f8301k.setStyle(Paint.Style.STROKE);
            this.x.set(f6 - f8, f7 - f8, f6 + f8, f7 + f8);
            canvas.drawArc(this.x, 270.0f, this.s, false, this.f8301k);
            this.f8301k.setStyle(Paint.Style.FILL);
        }
    }

    protected void c(Canvas canvas, int i2, int i3) {
        if (this.r > 0.0f) {
            this.f8301k.setColor(this.f8294d);
            canvas.drawCircle(i2 / 2, i3 / 2, this.r, this.f8301k);
        }
    }

    public BezierRadarHeader d(@ColorRes int i2) {
        c(e.a(getContext(), i2));
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        a(canvas, width);
        a(canvas, width, height);
        b(canvas, width, height);
        c(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.w;
        if (animator != null) {
            animator.removeAllListeners();
            this.w.end();
            this.w = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0 && !this.f8296f) {
            c(iArr[0]);
            this.f8296f = false;
        }
        if (iArr.length <= 1 || this.f8297g) {
            return;
        }
        a(iArr[1]);
        this.f8297g = false;
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8299i = false;
        this.n = -1;
        this.s = 0;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.x = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f8334b = c.Scale;
        com.scwang.smartrefresh.layout.e.b bVar = new com.scwang.smartrefresh.layout.e.b();
        this.f8300j = new Path();
        this.f8301k = new Paint();
        this.f8301k.setAntiAlias(true);
        this.q = bVar.a(7.0f);
        this.t = bVar.a(20.0f);
        this.u = bVar.a(7.0f);
        this.f8301k.setStrokeWidth(bVar.a(3.0f));
        setMinimumHeight(bVar.a(100.0f));
        if (isInEditMode()) {
            this.f8302l = 1000;
            this.v = 1.0f;
            this.s = SubsamplingScaleImageView.ORIENTATION_270;
        } else {
            this.v = 0.0f;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f8299i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f8299i);
        a(typedArrayObtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        c(typedArrayObtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.f8297g = typedArrayObtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.f8296f = typedArrayObtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        typedArrayObtainStyledAttributes.recycle();
    }

    public BezierRadarHeader c(@ColorInt int i2) {
        this.f8295e = i2;
        this.f8296f = true;
        return this;
    }

    protected void a(Canvas canvas, int i2, int i3) {
        if (this.o > 0.0f) {
            this.f8301k.setColor(this.f8294d);
            float fB = com.scwang.smartrefresh.layout.e.b.b(i3);
            float f2 = i2 / 7;
            float f3 = this.p;
            float f4 = 1.0f;
            float f5 = (f2 * f3) - (f3 > 1.0f ? ((f3 - 1.0f) * f2) / f3 : 0.0f);
            float f6 = i3;
            float f7 = this.p;
            float f8 = 2.0f;
            float f9 = f6 - (f7 > 1.0f ? (((f7 - 1.0f) * f6) / 2.0f) / f7 : 0.0f);
            int i4 = 0;
            while (i4 < 7) {
                float f10 = (i4 + f4) - 4.0f;
                this.f8301k.setAlpha((int) (this.o * (f4 - ((Math.abs(f10) / 7.0f) * f8)) * 255.0f * (1.0d - (1.0d / Math.pow((fB / 800.0d) + 1.0d, 15.0d)))));
                float f11 = this.q * (1.0f - (1.0f / ((fB / 10.0f) + 1.0f)));
                canvas.drawCircle(((i2 / 2) - (f11 / 2.0f)) + (f10 * f5), f9 / 2.0f, f11, this.f8301k);
                i4++;
                f4 = 1.0f;
                f8 = 2.0f;
            }
            this.f8301k.setAlpha(255);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(boolean z2, float f2, int i2, int i3, int i4) {
        if (z2 || this.f8298h) {
            this.f8298h = true;
            this.f8302l = Math.min(i3, i2);
            this.f8303m = (int) (Math.max(0, i2 - i3) * 1.9f);
            this.p = f2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void b(@NonNull j jVar, int i2, int i3) {
        this.f8302l = i2;
        this.f8298h = false;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 360);
        valueAnimatorOfInt.setDuration(720L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new b((byte) 4));
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        valueAnimatorOfFloat2.addUpdateListener(new b((byte) 0));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfInt);
        animatorSet.start();
        int i4 = this.f8303m;
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i4, 0, -((int) (i4 * 0.8f)), 0, -((int) (i4 * 0.4f)), 0);
        valueAnimatorOfInt2.addUpdateListener(new b((byte) 1));
        valueAnimatorOfInt2.setInterpolator(decelerateInterpolator);
        valueAnimatorOfInt2.setDuration(800L);
        valueAnimatorOfInt2.start();
        this.w = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull j jVar, boolean z2) {
        Animator animator = this.w;
        if (animator != null) {
            animator.removeAllListeners();
            this.w.end();
            this.w = null;
        }
        int width = getWidth();
        int height = getHeight();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, (float) Math.sqrt((width * width) + (height * height)));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 3));
        valueAnimatorOfFloat.start();
        return 400;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull j jVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar, @NonNull com.scwang.smartrefresh.layout.c.b bVar2) {
        int i2 = a.f8304a[bVar2.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.o = 1.0f;
            this.v = 0.0f;
            this.r = 0.0f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public boolean a() {
        return this.f8299i;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(float f2, int i2, int i3) {
        this.n = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            invalidate();
        }
    }

    public BezierRadarHeader b(@ColorRes int i2) {
        a(e.a(getContext(), i2));
        return this;
    }

    public BezierRadarHeader b(boolean z2) {
        this.f8299i = z2;
        if (!z2) {
            this.n = -1;
        }
        return this;
    }

    public BezierRadarHeader a(@ColorInt int i2) {
        this.f8294d = i2;
        this.f8297g = true;
        return this;
    }
}
