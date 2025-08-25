package ui.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import com.hicorenational.antifraud.R;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class CircularProgress extends View {
    private static final Interpolator p = new LinearInterpolator();
    private static final Interpolator q = new AccelerateDecelerateInterpolator();
    private static final int r = 2000;
    private static final int s = 900;
    private static final int t = 30;
    private static final int u = 3;

    /* renamed from: a, reason: collision with root package name */
    private final RectF f20286a;

    /* renamed from: b, reason: collision with root package name */
    private ObjectAnimator f20287b;

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f20288c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20289d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f20290e;

    /* renamed from: f, reason: collision with root package name */
    private float f20291f;

    /* renamed from: g, reason: collision with root package name */
    private float f20292g;

    /* renamed from: h, reason: collision with root package name */
    private float f20293h;

    /* renamed from: i, reason: collision with root package name */
    private float f20294i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20295j;

    /* renamed from: k, reason: collision with root package name */
    private int[] f20296k;

    /* renamed from: l, reason: collision with root package name */
    private int f20297l;

    /* renamed from: m, reason: collision with root package name */
    private int f20298m;
    private Property<CircularProgress, Float> n;
    private Property<CircularProgress, Float> o;

    class a extends Property<CircularProgress, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(CircularProgress circularProgress) {
            return Float.valueOf(circularProgress.getCurrentGlobalAngle());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(CircularProgress circularProgress, Float f2) {
            circularProgress.setCurrentGlobalAngle(f2.floatValue());
        }
    }

    class b extends Property<CircularProgress, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(CircularProgress circularProgress) {
            return Float.valueOf(circularProgress.getCurrentSweepAngle());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(CircularProgress circularProgress, Float f2) {
            circularProgress.setCurrentSweepAngle(f2.floatValue());
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            CircularProgress.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public CircularProgress(Context context) {
        this(context, null);
    }

    @SuppressLint({"NewApi"})
    private void b() {
        this.f20288c = ObjectAnimator.ofFloat(this, this.n, 360.0f);
        this.f20288c.setInterpolator(p);
        this.f20288c.setDuration(2000L);
        this.f20288c.setRepeatMode(1);
        this.f20288c.setRepeatCount(-1);
        this.f20287b = ObjectAnimator.ofFloat(this, this.o, 300.0f);
        this.f20287b.setInterpolator(q);
        this.f20287b.setDuration(900L);
        this.f20287b.setRepeatMode(1);
        this.f20287b.setRepeatCount(-1);
        this.f20287b.addListener(new c());
    }

    private void c() {
        if (a()) {
            return;
        }
        this.f20295j = true;
        this.f20288c.start();
        this.f20287b.start();
        invalidate();
    }

    private void d() {
        if (a()) {
            this.f20295j = false;
            this.f20288c.cancel();
            this.f20287b.cancel();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f20289d = !this.f20289d;
        if (this.f20289d) {
            int i2 = this.f20297l + 1;
            this.f20297l = i2;
            this.f20297l = i2 % 4;
            int i3 = this.f20298m + 1;
            this.f20298m = i3;
            this.f20298m = i3 % 4;
            this.f20291f = (this.f20291f + 60.0f) % 360.0f;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float f2;
        super.draw(canvas);
        float f3 = this.f20292g - this.f20291f;
        float f4 = this.f20293h;
        if (this.f20289d) {
            Paint paint = this.f20290e;
            int[] iArr = this.f20296k;
            paint.setColor(a(iArr[this.f20297l], iArr[this.f20298m], f4 / 300.0f));
            f2 = f4 + 30.0f;
        } else {
            f3 += f4;
            f2 = (360.0f - f4) - 30.0f;
        }
        canvas.drawArc(this.f20286a, f3, f2, false, this.f20290e);
    }

    public float getCurrentGlobalAngle() {
        return this.f20292g;
    }

    public float getCurrentSweepAngle() {
        return this.f20293h;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        c();
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        RectF rectF = this.f20286a;
        float f2 = this.f20294i;
        rectF.left = (f2 / 2.0f) + 0.5f;
        rectF.right = (i2 - (f2 / 2.0f)) - 0.5f;
        rectF.top = (f2 / 2.0f) + 0.5f;
        rectF.bottom = (i3 - (f2 / 2.0f)) - 0.5f;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            c();
        } else {
            d();
        }
    }

    public void setCurrentGlobalAngle(float f2) {
        this.f20292g = f2;
        invalidate();
    }

    public void setCurrentSweepAngle(float f2) {
        this.f20293h = f2;
        invalidate();
    }

    public CircularProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean a() {
        return this.f20295j;
    }

    public CircularProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20286a = new RectF();
        this.f20289d = true;
        this.n = new a(Float.class, "angle");
        this.o = new b(Float.class, "arc");
        float f2 = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularProgress, i2, 0);
        this.f20294i = typedArrayObtainStyledAttributes.getDimension(0, f2 * 3.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.f20296k = new int[4];
        this.f20296k[0] = ContextCompat.getColor(context, R.color.blue);
        this.f20296k[1] = ContextCompat.getColor(context, R.color.blue);
        this.f20296k[2] = ContextCompat.getColor(context, R.color.blue);
        this.f20296k[3] = ContextCompat.getColor(context, R.color.blue);
        this.f20297l = 0;
        this.f20298m = 1;
        this.f20290e = new Paint();
        this.f20290e.setAntiAlias(true);
        this.f20290e.setStyle(Paint.Style.STROKE);
        this.f20290e.setStrokeCap(Paint.Cap.ROUND);
        this.f20290e.setStrokeWidth(this.f20294i);
        this.f20290e.setColor(this.f20296k[this.f20297l]);
        b();
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb(255, (int) ((((16711680 & i3) >> 16) * f2) + (((i2 & 16711680) >> 16) * f3)), (int) ((((65280 & i3) >> 8) * f2) + (((i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) * f3)), (int) (((i3 & 255) * f2) + ((i2 & 255) * f3)));
    }
}
