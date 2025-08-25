package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.f;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.b;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/* loaded from: classes.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements f {
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    protected boolean A;
    protected String t;
    protected String u;
    protected String v;
    protected String w;
    protected String x;
    protected String y;
    protected String z;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8292a = new int[b.values().length];

        static {
            try {
                f8292a[b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8292a[b.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8292a[b.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8292a[b.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8292a[b.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8292a[b.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull j jVar, int i2, int i3) {
        if (this.A) {
            return;
        }
        super.a(jVar, i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.f8334b == c.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = false;
        if (B == null) {
            B = context.getString(R.string.srl_footer_pulling);
        }
        if (C == null) {
            C = context.getString(R.string.srl_footer_release);
        }
        if (D == null) {
            D = context.getString(R.string.srl_footer_loading);
        }
        if (E == null) {
            E = context.getString(R.string.srl_footer_refreshing);
        }
        if (F == null) {
            F = context.getString(R.string.srl_footer_finish);
        }
        if (G == null) {
            G = context.getString(R.string.srl_footer_failed);
        }
        if (H == null) {
            H = context.getString(R.string.srl_footer_nothing);
        }
        ImageView imageView = this.f8337e;
        ImageView imageView2 = this.f8338f;
        com.scwang.smartrefresh.layout.e.b bVar = new com.scwang.smartrefresh.layout.e.b();
        this.f8336d.setTextColor(-10066330);
        this.f8336d.setText(isInEditMode() ? D : B);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, bVar.a(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.n = typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.n);
        this.f8334b = c.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f8334b.ordinal())];
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.f8337e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
        } else {
            this.f8341i = new com.scwang.smartrefresh.layout.internal.a();
            this.f8341i.a(-10066330);
            this.f8337e.setImageDrawable(this.f8341i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.f8338f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
        } else {
            this.f8342j = new com.scwang.smartrefresh.layout.internal.c();
            this.f8342j.a(-10066330);
            this.f8338f.setImageDrawable(this.f8342j);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.f8336d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, com.scwang.smartrefresh.layout.e.b.b(16.0f)));
        } else {
            this.f8336d.setTextSize(16.0f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.e(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            super.a(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        this.t = B;
        this.u = C;
        this.v = D;
        this.w = E;
        this.x = F;
        this.y = G;
        this.z = H;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextPulling)) {
            this.t = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextPulling);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRelease)) {
            this.u = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRelease);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextLoading)) {
            this.v = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextLoading);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.w = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRefreshing);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFinish)) {
            this.x = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFinish);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFailed)) {
            this.y = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFailed);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextNothing)) {
            this.z = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextNothing);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull j jVar, boolean z) {
        if (this.A) {
            return 0;
        }
        this.f8336d.setText(z ? this.x : this.y);
        return super.a(jVar, z);
    }

    @Override // com.scwang.smartrefresh.layout.b.f
    public boolean a(boolean z) {
        if (this.A == z) {
            return true;
        }
        this.A = z;
        ImageView imageView = this.f8337e;
        if (z) {
            this.f8336d.setText(this.z);
            imageView.setVisibility(8);
            return true;
        }
        this.f8336d.setText(this.t);
        imageView.setVisibility(0);
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull j jVar, @NonNull b bVar, @NonNull b bVar2) {
        ImageView imageView = this.f8337e;
        if (this.A) {
            return;
        }
        switch (a.f8292a[bVar2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.f8336d.setText(this.v);
                return;
            case 5:
                this.f8336d.setText(this.u);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.f8336d.setText(this.w);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.f8336d.setText(this.t);
        imageView.animate().rotation(180.0f);
    }
}
