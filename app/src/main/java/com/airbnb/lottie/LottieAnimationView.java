package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String t = LottieAnimationView.class.getSimpleName();
    private static final l<Throwable> u = new a();

    /* renamed from: a, reason: collision with root package name */
    private final l<com.airbnb.lottie.g> f3294a;

    /* renamed from: b, reason: collision with root package name */
    private final l<Throwable> f3295b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private l<Throwable> f3296c;

    /* renamed from: d, reason: collision with root package name */
    @DrawableRes
    private int f3297d;

    /* renamed from: e, reason: collision with root package name */
    private final j f3298e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3299f;

    /* renamed from: g, reason: collision with root package name */
    private String f3300g;

    /* renamed from: h, reason: collision with root package name */
    @RawRes
    private int f3301h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3302i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3303j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3304k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3305l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3306m;
    private boolean n;
    private t o;
    private final Set<n> p;
    private int q;

    @Nullable
    private q<com.airbnb.lottie.g> r;

    @Nullable
    private com.airbnb.lottie.g s;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f3307a;

        /* renamed from: b, reason: collision with root package name */
        int f3308b;

        /* renamed from: c, reason: collision with root package name */
        float f3309c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3310d;

        /* renamed from: e, reason: collision with root package name */
        String f3311e;

        /* renamed from: f, reason: collision with root package name */
        int f3312f;

        /* renamed from: g, reason: collision with root package name */
        int f3313g;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f3307a);
            parcel.writeFloat(this.f3309c);
            parcel.writeInt(this.f3310d ? 1 : 0);
            parcel.writeString(this.f3311e);
            parcel.writeInt(this.f3312f);
            parcel.writeInt(this.f3313g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3307a = parcel.readString();
            this.f3309c = parcel.readFloat();
            this.f3310d = parcel.readInt() == 1;
            this.f3311e = parcel.readString();
            this.f3312f = parcel.readInt();
            this.f3313g = parcel.readInt();
        }
    }

    class a implements l<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (!com.airbnb.lottie.b0.h.a(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            com.airbnb.lottie.b0.d.c("Unable to load composition.", th);
        }
    }

    class b implements l<com.airbnb.lottie.g> {
        b() {
        }

        @Override // com.airbnb.lottie.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.g gVar) {
            LottieAnimationView.this.setComposition(gVar);
        }
    }

    class c implements l<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f3297d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f3297d);
            }
            (LottieAnimationView.this.f3296c == null ? LottieAnimationView.u : LottieAnimationView.this.f3296c).onResult(th);
        }
    }

    class d implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3316a;

        d(int i2) {
            this.f3316a = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return LottieAnimationView.this.n ? h.b(LottieAnimationView.this.getContext(), this.f3316a) : h.b(LottieAnimationView.this.getContext(), this.f3316a, (String) null);
        }
    }

    class e implements Callable<p<com.airbnb.lottie.g>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3318a;

        e(String str) {
            this.f3318a = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return LottieAnimationView.this.n ? h.b(LottieAnimationView.this.getContext(), this.f3318a) : h.b(LottieAnimationView.this.getContext(), this.f3318a, (String) null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> extends com.airbnb.lottie.c0.j<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.c0.l f3320d;

        f(com.airbnb.lottie.c0.l lVar) {
            this.f3320d = lVar;
        }

        @Override // com.airbnb.lottie.c0.j
        public T a(com.airbnb.lottie.c0.b<T> bVar) {
            return (T) this.f3320d.a(bVar);
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3322a = new int[t.values().length];

        static {
            try {
                f3322a[t.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3322a[t.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3322a[t.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f3294a = new b();
        this.f3295b = new c();
        this.f3297d = 0;
        this.f3298e = new j();
        this.f3302i = false;
        this.f3303j = false;
        this.f3304k = false;
        this.f3305l = false;
        this.f3306m = false;
        this.n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    private void o() {
        q<com.airbnb.lottie.g> qVar = this.r;
        if (qVar != null) {
            qVar.d(this.f3294a);
            this.r.c(this.f3295b);
        }
    }

    private void p() {
        this.s = null;
        this.f3298e.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.g.f3322a
            com.airbnb.lottie.t r1 = r5.o
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L46
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = 1
            goto L46
        L15:
            com.airbnb.lottie.g r0 = r5.s
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.o()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L44
        L27:
            com.airbnb.lottie.g r0 = r5.s
            if (r0 == 0) goto L33
            int r0 = r0.k()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L44
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L44
        L3a:
            r4 = 24
            if (r0 == r4) goto L44
            r4 = 25
            if (r0 != r4) goto L43
            goto L44
        L43:
            r3 = 1
        L44:
            if (r3 == 0) goto L13
        L46:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L50
            r0 = 0
            r5.setLayerType(r1, r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.q():void");
    }

    private void r() {
        boolean zE = e();
        setImageDrawable(null);
        setImageDrawable(this.f3298e);
        if (zE) {
            this.f3298e.B();
        }
    }

    private void setCompositionTask(q<com.airbnb.lottie.g> qVar) {
        p();
        o();
        this.r = qVar.b(this.f3294a).a(this.f3295b);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.e.a("buildDrawingCache");
        this.q++;
        super.buildDrawingCache(z);
        if (this.q == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(t.HARDWARE);
        }
        this.q--;
        com.airbnb.lottie.e.b("buildDrawingCache");
    }

    public boolean d() {
        return this.f3298e.s();
    }

    public boolean e() {
        return this.f3298e.t();
    }

    public boolean f() {
        return this.f3298e.w();
    }

    @MainThread
    public void g() {
        this.f3306m = false;
        this.f3304k = false;
        this.f3303j = false;
        this.f3302i = false;
        this.f3298e.x();
        q();
    }

    @Nullable
    public com.airbnb.lottie.g getComposition() {
        return this.s;
    }

    public long getDuration() {
        com.airbnb.lottie.g gVar = this.s;
        if (gVar != null) {
            return (long) gVar.c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f3298e.g();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f3298e.h();
    }

    public float getMaxFrame() {
        return this.f3298e.i();
    }

    public float getMinFrame() {
        return this.f3298e.j();
    }

    @Nullable
    public s getPerformanceTracker() {
        return this.f3298e.k();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f3298e.l();
    }

    public int getRepeatCount() {
        return this.f3298e.m();
    }

    public int getRepeatMode() {
        return this.f3298e.n();
    }

    public float getScale() {
        return this.f3298e.o();
    }

    public float getSpeed() {
        return this.f3298e.p();
    }

    @MainThread
    public void h() {
        if (!isShown()) {
            this.f3302i = true;
        } else {
            this.f3298e.y();
            q();
        }
    }

    public void i() {
        this.f3298e.z();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        j jVar = this.f3298e;
        if (drawable2 == jVar) {
            super.invalidateDrawable(jVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j() {
        this.p.clear();
    }

    public void k() {
        this.f3298e.A();
    }

    @MainThread
    public void l() {
        if (isShown()) {
            this.f3298e.B();
            q();
        } else {
            this.f3302i = false;
            this.f3303j = true;
        }
    }

    public void m() {
        this.f3298e.C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.f3306m || this.f3304k)) {
            h();
            this.f3306m = false;
            this.f3304k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (e()) {
            a();
            this.f3304k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3300g = savedState.f3307a;
        if (!TextUtils.isEmpty(this.f3300g)) {
            setAnimation(this.f3300g);
        }
        this.f3301h = savedState.f3308b;
        int i2 = this.f3301h;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f3309c);
        if (savedState.f3310d) {
            h();
        }
        this.f3298e.b(savedState.f3311e);
        setRepeatMode(savedState.f3312f);
        setRepeatCount(savedState.f3313g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3307a = this.f3300g;
        savedState.f3308b = this.f3301h;
        savedState.f3309c = this.f3298e.l();
        savedState.f3310d = this.f3298e.t() || (!ViewCompat.isAttachedToWindow(this) && this.f3304k);
        savedState.f3311e = this.f3298e.h();
        savedState.f3312f = this.f3298e.n();
        savedState.f3313g = this.f3298e.m();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.f3299f) {
            if (!isShown()) {
                if (e()) {
                    g();
                    this.f3303j = true;
                    return;
                }
                return;
            }
            if (this.f3303j) {
                l();
            } else if (this.f3302i) {
                h();
            }
            this.f3303j = false;
            this.f3302i = false;
        }
    }

    public void setAnimation(@RawRes int i2) {
        this.f3301h = i2;
        this.f3300g = null;
        setCompositionTask(a(i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.n ? h.c(getContext(), str) : h.c(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f3298e.c(z);
    }

    public void setCacheComposition(boolean z) {
        this.n = z;
    }

    public void setComposition(@NonNull com.airbnb.lottie.g gVar) {
        if (com.airbnb.lottie.e.f3479a) {
            String str = "Set Composition \n" + gVar;
        }
        this.f3298e.setCallback(this);
        this.s = gVar;
        this.f3305l = true;
        boolean zA = this.f3298e.a(gVar);
        this.f3305l = false;
        q();
        if (getDrawable() != this.f3298e || zA) {
            if (!zA) {
                r();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<n> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().a(gVar);
            }
        }
    }

    public void setFailureListener(@Nullable l<Throwable> lVar) {
        this.f3296c = lVar;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.f3297d = i2;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.c cVar) {
        this.f3298e.a(cVar);
    }

    public void setFrame(int i2) {
        this.f3298e.a(i2);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.f3298e.d(z);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.d dVar) {
        this.f3298e.a(dVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f3298e.b(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        o();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        o();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        o();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f3298e.b(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f3298e.a(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f3298e.d(str);
    }

    public void setMinFrame(int i2) {
        this.f3298e.c(i2);
    }

    public void setMinProgress(float f2) {
        this.f3298e.b(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.f3298e.e(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f3298e.f(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f3298e.c(f2);
    }

    public void setRenderMode(t tVar) {
        this.o = tVar;
        q();
    }

    public void setRepeatCount(int i2) {
        this.f3298e.d(i2);
    }

    public void setRepeatMode(int i2) {
        this.f3298e.e(i2);
    }

    public void setSafeMode(boolean z) {
        this.f3298e.g(z);
    }

    public void setScale(float f2) {
        this.f3298e.d(f2);
        if (getDrawable() == this.f3298e) {
            r();
        }
    }

    public void setSpeed(float f2) {
        this.f3298e.e(f2);
    }

    public void setTextDelegate(v vVar) {
        this.f3298e.a(vVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        j jVar;
        if (!this.f3305l && drawable == (jVar = this.f3298e) && jVar.t()) {
            g();
        } else if (!this.f3305l && (drawable instanceof j)) {
            j jVar2 = (j) drawable;
            if (jVar2.t()) {
                jVar2.x();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void a(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i2, 0);
        this.n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f3304k = true;
            this.f3306m = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f3298e.d(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            a(new com.airbnb.lottie.y.e("**"), (com.airbnb.lottie.y.e) o.E, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.e>) new com.airbnb.lottie.c0.j(new u(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f3298e.d(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, t.AUTOMATIC.ordinal());
            if (iOrdinal >= t.values().length) {
                iOrdinal = t.AUTOMATIC.ordinal();
            }
            setRenderMode(t.values()[iOrdinal]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f3298e.a(Boolean.valueOf(com.airbnb.lottie.b0.h.a(getContext()) != 0.0f));
        q();
        this.f3299f = true;
    }

    public void b(String str, @Nullable String str2) {
        setCompositionTask(h.c(getContext(), str, str2));
    }

    public boolean c() {
        return this.f3298e.r();
    }

    public void setMaxFrame(String str) {
        this.f3298e.c(str);
    }

    public void setMinFrame(String str) {
        this.f3298e.e(str);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3298e.b(animatorUpdateListener);
    }

    public void setAnimation(String str) {
        this.f3300g = str;
        this.f3301h = 0;
        setCompositionTask(a(str));
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f3298e.b(animatorListener);
    }

    @RequiresApi(api = 19)
    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3298e.b(animatorPauseListener);
    }

    @Deprecated
    public void b(boolean z) {
        this.f3298e.d(z ? -1 : 0);
    }

    public void b() {
        this.f3298e.c();
    }

    public boolean b(@NonNull n nVar) {
        return this.p.remove(nVar);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3294a = new b();
        this.f3295b = new c();
        this.f3297d = 0;
        this.f3298e = new j();
        this.f3302i = false;
        this.f3303j = false;
        this.f3304k = false;
        this.f3305l = false;
        this.f3306m = false;
        this.n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3294a = new b();
        this.f3295b = new c();
        this.f3297d = 0;
        this.f3298e = new j();
        this.f3302i = false;
        this.f3303j = false;
        this.f3304k = false;
        this.f3305l = false;
        this.f3306m = false;
        this.n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a(attributeSet, i2);
    }

    public void a(boolean z) {
        this.f3298e.a(z);
    }

    private q<com.airbnb.lottie.g> a(@RawRes int i2) {
        if (isInEditMode()) {
            return new q<>(new d(i2), true);
        }
        return this.n ? h.a(getContext(), i2) : h.a(getContext(), i2, (String) null);
    }

    private q<com.airbnb.lottie.g> a(String str) {
        if (isInEditMode()) {
            return new q<>(new e(str), true);
        }
        return this.n ? h.a(getContext(), str) : h.a(getContext(), str, (String) null);
    }

    public void a(String str, @Nullable String str2) {
        a(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void a(InputStream inputStream, @Nullable String str) {
        setCompositionTask(h.a(inputStream, str));
    }

    public void a(String str, String str2, boolean z) {
        this.f3298e.a(str, str2, z);
    }

    public void a(int i2, int i3) {
        this.f3298e.a(i2, i3);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.f3298e.a(f2, f3);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3298e.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f3298e.a(animatorListener);
    }

    @RequiresApi(api = 19)
    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3298e.a(animatorPauseListener);
    }

    @Nullable
    public Bitmap a(String str, @Nullable Bitmap bitmap) {
        return this.f3298e.a(str, bitmap);
    }

    public List<com.airbnb.lottie.y.e> a(com.airbnb.lottie.y.e eVar) {
        return this.f3298e.a(eVar);
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t2, com.airbnb.lottie.c0.j<T> jVar) {
        this.f3298e.a(eVar, (com.airbnb.lottie.y.e) t2, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.e>) jVar);
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t2, com.airbnb.lottie.c0.l<T> lVar) {
        this.f3298e.a(eVar, (com.airbnb.lottie.y.e) t2, (com.airbnb.lottie.c0.j<com.airbnb.lottie.y.e>) new f(lVar));
    }

    @MainThread
    public void a() {
        this.f3304k = false;
        this.f3303j = false;
        this.f3302i = false;
        this.f3298e.a();
        q();
    }

    public boolean a(@NonNull n nVar) {
        com.airbnb.lottie.g gVar = this.s;
        if (gVar != null) {
            nVar.a(gVar);
        }
        return this.p.add(nVar);
    }
}
