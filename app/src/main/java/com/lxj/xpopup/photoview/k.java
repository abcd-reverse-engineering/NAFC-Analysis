package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float O = 4.0f;
    private static float b0 = 2.5f;
    private static float c0 = 1.0f;
    private static int d0 = 200;
    private static final int e0 = -1;
    private static final int f0 = 0;
    private static final int g0 = 1;
    private static final int h0 = 2;
    private static final int i0 = -1;
    private static final int j0 = 0;
    private static final int k0 = 1;
    private static final int l0 = 2;
    private static int m0 = 1;
    private float B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean G;
    public boolean H;
    float M;
    float N;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f8113h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f8114i;

    /* renamed from: j, reason: collision with root package name */
    private com.lxj.xpopup.photoview.b f8115j;
    private com.lxj.xpopup.photoview.d p;
    private com.lxj.xpopup.photoview.f q;
    private com.lxj.xpopup.photoview.e r;
    private j s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private g v;
    private h w;
    private i x;
    private f y;

    /* renamed from: a, reason: collision with root package name */
    private Interpolator f8106a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private int f8107b = d0;

    /* renamed from: c, reason: collision with root package name */
    private float f8108c = c0;

    /* renamed from: d, reason: collision with root package name */
    private float f8109d = b0;

    /* renamed from: e, reason: collision with root package name */
    private float f8110e = O;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8111f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8112g = false;

    /* renamed from: k, reason: collision with root package name */
    private final Matrix f8116k = new Matrix();

    /* renamed from: l, reason: collision with root package name */
    private final Matrix f8117l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f8118m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private int A = 2;
    public boolean F = false;
    private boolean I = true;
    private boolean J = false;
    private ImageView.ScaleType K = ImageView.ScaleType.FIT_CENTER;
    private com.lxj.xpopup.photoview.c L = new a();

    /* compiled from: PhotoViewAttacher.java */
    class a implements com.lxj.xpopup.photoview.c {
        a() {
        }

        @Override // com.lxj.xpopup.photoview.c
        public void onDrag(float f2, float f3) {
            if (k.this.f8115j.b()) {
                return;
            }
            if (k.this.x != null) {
                k.this.x.onDrag(f2, f3);
            }
            k.this.f8118m.postTranslate(f2, f3);
            k.this.n();
            k kVar = k.this;
            kVar.C = kVar.A == 0 && k.this.f() != 1.0f;
            k kVar2 = k.this;
            kVar2.D = kVar2.A == 1 && k.this.f() != 1.0f;
            k kVar3 = k.this;
            kVar3.E = kVar3.z == 0 && k.this.f() != 1.0f;
            k kVar4 = k.this;
            kVar4.F = kVar4.z == 1 && k.this.f() != 1.0f;
            ViewParent parent = k.this.f8113h.getParent();
            if (parent == null) {
                return;
            }
            if (!k.this.f8111f || k.this.f8115j.b() || k.this.f8112g) {
                if (k.this.z == 2 && k.this.J && k.this.H) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                } else {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
            }
            if ((k.this.z == 2 && !k.this.J) || ((k.this.z == 0 && f2 >= 0.0f && k.this.H) || (k.this.z == 1 && f2 <= -0.0f && k.this.H))) {
                parent.requestDisallowInterceptTouchEvent(false);
                return;
            }
            if (k.this.A != 2 || !k.this.G) {
                k kVar5 = k.this;
                if (!kVar5.C || f3 <= 0.0f || !kVar5.G) {
                    k kVar6 = k.this;
                    if (!kVar6.D || f3 >= 0.0f || !kVar6.G) {
                        if (k.this.J) {
                            if ((k.this.A == 0 && f3 > 0.0f && k.this.G) || (k.this.A == 1 && f3 < 0.0f && k.this.G)) {
                                parent.requestDisallowInterceptTouchEvent(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            parent.requestDisallowInterceptTouchEvent(false);
        }

        @Override // com.lxj.xpopup.photoview.c
        public void onFling(float f2, float f3, float f4, float f5) {
            k kVar = k.this;
            kVar.y = kVar.new f(kVar.f8113h.getContext());
            f fVar = k.this.y;
            k kVar2 = k.this;
            int iB = kVar2.b(kVar2.f8113h);
            k kVar3 = k.this;
            fVar.a(iB, kVar3.a(kVar3.f8113h), (int) f4, (int) f5);
            k.this.f8113h.post(k.this.y);
        }

        @Override // com.lxj.xpopup.photoview.c
        public void onScale(float f2, float f3, float f4) {
            if (k.this.f() < k.this.f8110e || f2 < 1.0f) {
                if (k.this.v != null) {
                    k.this.v.onScaleChange(f2, f3, f4);
                }
                k.this.f8118m.postScale(f2, f2, f3, f4);
                k.this.n();
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (k.this.w == null || k.this.f() > k.c0 || motionEvent.getPointerCount() > k.m0 || motionEvent2.getPointerCount() > k.m0) {
                return false;
            }
            return k.this.w.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.u != null) {
                k.this.u.onLongClick(k.this.f8113h);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float f2 = k.this.f();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (f2 < k.this.d()) {
                    k.this.a(k.this.d(), x, y, true);
                } else if (f2 < k.this.d() || f2 >= k.this.c()) {
                    k.this.a(k.this.e(), x, y, true);
                } else {
                    k.this.a(k.this.c(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.t != null) {
                k.this.t.onClick(k.this.f8113h);
            }
            RectF rectFA = k.this.a();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (k.this.s != null) {
                k.this.s.onViewTap(k.this.f8113h, x, y);
            }
            if (rectFA == null) {
                return false;
            }
            if (!rectFA.contains(x, y)) {
                if (k.this.r == null) {
                    return false;
                }
                k.this.r.onOutsidePhotoTap(k.this.f8113h);
                return false;
            }
            float fWidth = (x - rectFA.left) / rectFA.width();
            float fHeight = (y - rectFA.top) / rectFA.height();
            if (k.this.q == null) {
                return true;
            }
            k.this.q.onPhotoTap(k.this.f8113h, fWidth, fHeight);
            return true;
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8122a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f8122a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8122a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8122a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8122a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    private class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final float f8123a;

        /* renamed from: b, reason: collision with root package name */
        private final float f8124b;

        /* renamed from: c, reason: collision with root package name */
        private final long f8125c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private final float f8126d;

        /* renamed from: e, reason: collision with root package name */
        private final float f8127e;

        public e(float f2, float f3, float f4, float f5) {
            this.f8123a = f4;
            this.f8124b = f5;
            this.f8126d = f2;
            this.f8127e = f3;
        }

        private float a() {
            return k.this.f8106a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f8125c) * 1.0f) / k.this.f8107b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f2 = this.f8126d;
            k.this.L.onScale((f2 + ((this.f8127e - f2) * fA)) / k.this.f(), this.f8123a, this.f8124b);
            if (fA < 1.0f) {
                com.lxj.xpopup.photoview.a.a(k.this.f8113h, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    private class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final OverScroller f8129a;

        /* renamed from: b, reason: collision with root package name */
        private int f8130b;

        /* renamed from: c, reason: collision with root package name */
        private int f8131c;

        public f(Context context) {
            this.f8129a = new OverScroller(context);
        }

        public void a() {
            this.f8129a.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f8129a.isFinished() && this.f8129a.computeScrollOffset()) {
                int currX = this.f8129a.getCurrX();
                int currY = this.f8129a.getCurrY();
                k.this.f8118m.postTranslate(this.f8130b - currX, this.f8131c - currY);
                k.this.n();
                this.f8130b = currX;
                this.f8131c = currY;
                com.lxj.xpopup.photoview.a.a(k.this.f8113h, this);
            }
        }

        public void a(int i2, int i3, int i4, int i5) {
            int i6;
            int iRound;
            int i7;
            int iRound2;
            RectF rectFA = k.this.a();
            if (rectFA == null) {
                return;
            }
            int iRound3 = Math.round(-rectFA.left);
            float f2 = i2;
            if (f2 < rectFA.width()) {
                iRound = Math.round(rectFA.width() - f2);
                i6 = 0;
            } else {
                i6 = iRound3;
                iRound = i6;
            }
            int iRound4 = Math.round(-rectFA.top);
            float f3 = i3;
            if (f3 < rectFA.height()) {
                iRound2 = Math.round(rectFA.height() - f3);
                i7 = 0;
            } else {
                i7 = iRound4;
                iRound2 = i7;
            }
            this.f8130b = iRound3;
            this.f8131c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f8129a.fling(iRound3, iRound4, i4, i5, i6, iRound, i7, iRound2, 0, 0);
        }
    }

    public k(ImageView imageView) {
        this.f8113h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.B = 0.0f;
        this.f8115j = new com.lxj.xpopup.photoview.b(imageView.getContext(), this.L);
        this.f8114i = new GestureDetector(imageView.getContext(), new b());
        this.f8114i.setOnDoubleTapListener(new c());
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        a(this.f8113h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.photoview.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f8114i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void setOnMatrixChangeListener(com.lxj.xpopup.photoview.d dVar) {
        this.p = dVar;
    }

    public void setOnOutsidePhotoTapListener(com.lxj.xpopup.photoview.e eVar) {
        this.r = eVar;
    }

    public void setOnPhotoTapListener(com.lxj.xpopup.photoview.f fVar) {
        this.q = fVar;
    }

    public void setOnScaleChangeListener(g gVar) {
        this.v = gVar;
    }

    public void setOnSingleFlingListener(h hVar) {
        this.w = hVar;
    }

    public void setOnViewDragListener(i iVar) {
        this.x = iVar;
    }

    public void setOnViewTapListener(j jVar) {
        this.s = jVar;
    }

    private void m() {
        f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (o()) {
            e(p());
        }
    }

    private boolean o() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        RectF rectFD = d(p());
        if (rectFD == null) {
            return false;
        }
        float fHeight = rectFD.height();
        float fWidth = rectFD.width();
        float fA = a(this.f8113h);
        float f8 = 0.0f;
        if (fHeight > fA || rectFD.top < 0.0f) {
            float f9 = rectFD.top;
            if (f9 >= 0.0f) {
                this.A = 0;
                f2 = -f9;
            } else {
                float f10 = rectFD.bottom;
                if (f10 <= fA) {
                    this.A = 1;
                    f2 = fA - f10;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        } else {
            int i2 = d.f8122a[this.K.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (fA - fHeight) / 2.0f;
                    f7 = rectFD.top;
                } else {
                    f6 = fA - fHeight;
                    f7 = rectFD.top;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFD.top;
            }
            this.A = 2;
            f2 = f5;
        }
        float fB = b(this.f8113h);
        if (fWidth > fB || rectFD.left < 0.0f) {
            float f11 = rectFD.left;
            if (f11 >= 0.0f) {
                this.z = 0;
                f8 = -f11;
            } else {
                float f12 = rectFD.right;
                if (f12 <= fB) {
                    f8 = fB - f12;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        } else {
            int i3 = d.f8122a[this.K.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (fB - fWidth) / 2.0f;
                    f4 = rectFD.left;
                } else {
                    f3 = fB - fWidth;
                    f4 = rectFD.left;
                }
                f8 = f3 - f4;
            } else {
                f8 = -rectFD.left;
            }
            this.z = 2;
        }
        this.f8118m.postTranslate(f8, f2);
        return true;
    }

    private Matrix p() {
        this.f8117l.set(this.f8116k);
        this.f8117l.postConcat(this.f8118m);
        return this.f8117l;
    }

    private void q() {
        this.f8118m.reset();
        e(this.B);
        e(p());
        o();
    }

    public boolean c(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f8113h.getDrawable() == null) {
            return false;
        }
        this.f8118m.set(matrix);
        n();
        return true;
    }

    public float d() {
        return this.f8109d;
    }

    public void e(float f2) {
        this.f8118m.postRotate(f2 % 360.0f);
        n();
    }

    public void f(float f2) {
        this.f8118m.setRotate(f2 % 360.0f);
        n();
    }

    public ImageView.ScaleType g() {
        return this.K;
    }

    @Deprecated
    public boolean h() {
        return this.I;
    }

    public boolean i() {
        return this.I;
    }

    public void j() {
        if (this.I) {
            a(this.f8113h.getDrawable());
        } else {
            q();
        }
    }

    public void b(float f2) {
        l.a(this.f8108c, this.f8109d, f2);
        this.f8110e = f2;
    }

    public void d(float f2) {
        l.a(f2, this.f8109d, this.f8110e);
        this.f8108c = f2;
    }

    public void g(float f2) {
        a(f2, false);
    }

    public RectF a() {
        o();
        return d(p());
    }

    public float e() {
        return this.f8108c;
    }

    public float f() {
        return (float) Math.sqrt(((float) Math.pow(a(this.f8118m, 0), 2.0d)) + ((float) Math.pow(a(this.f8118m, 3), 2.0d)));
    }

    private RectF d(Matrix matrix) {
        if (this.f8113h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private void e(Matrix matrix) {
        RectF rectFD;
        this.f8113h.setImageMatrix(matrix);
        if (this.p == null || (rectFD = d(matrix)) == null) {
            return;
        }
        this.p.onMatrixChanged(rectFD);
    }

    public void b(boolean z) {
        this.I = z;
        j();
    }

    public void a(float f2) {
        this.B = f2 % 360.0f;
        j();
        e(this.B);
        n();
    }

    public float c() {
        return this.f8110e;
    }

    public void b(Matrix matrix) {
        matrix.set(this.f8118m);
    }

    public void c(float f2) {
        l.a(this.f8108c, f2, this.f8110e);
        this.f8109d = f2;
    }

    public Matrix b() {
        return this.f8117l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public void a(boolean z) {
        this.f8111f = z;
    }

    public void a(float f2, float f3, float f4) {
        l.a(f2, f3, f4);
        this.f8108c = f2;
        this.f8109d = f3;
        this.f8110e = f4;
    }

    public void a(float f2, boolean z) {
        a(f2, this.f8113h.getRight() / 2, this.f8113h.getBottom() / 2, z);
    }

    public void a(float f2, float f3, float f4, boolean z) {
        if (z) {
            this.f8113h.post(new e(f(), f2, f3, f4));
        } else {
            this.f8118m.setScale(f2, f2, f3, f4);
            n();
        }
    }

    public void a(Interpolator interpolator) {
        this.f8106a = interpolator;
    }

    public void a(ImageView.ScaleType scaleType) {
        if (!l.a(scaleType) || scaleType == this.K) {
            return;
        }
        this.K = scaleType;
        j();
    }

    public void a(Matrix matrix) {
        matrix.set(p());
    }

    public void a(int i2) {
        this.f8107b = i2;
    }

    public float a(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fB = b(this.f8113h);
        float fA = a(this.f8113h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f8116k.reset();
        float f2 = intrinsicWidth;
        float f3 = fB / f2;
        float f4 = intrinsicHeight;
        float f5 = fA / f4;
        ImageView.ScaleType scaleType = this.K;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f8116k.postTranslate((fB - f2) / 2.0f, (fA - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.f8116k.postScale(fMax, fMax);
            this.f8116k.postTranslate((fB - (f2 * fMax)) / 2.0f, (fA - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.f8116k.postScale(fMin, fMin);
            this.f8116k.postTranslate((fB - (f2 * fMin)) / 2.0f, (fA - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fB, fA);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.f8122a[this.K.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f8116k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.f8116k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.f8116k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            } else if (f4 > fA && (f4 * 1.0f) / f2 > (fA * 1.0f) / fB) {
                this.J = true;
                this.f8116k.setRectToRect(rectF, new RectF(0.0f, 0.0f, fB, f4 * f3), Matrix.ScaleToFit.START);
            } else {
                this.f8116k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
