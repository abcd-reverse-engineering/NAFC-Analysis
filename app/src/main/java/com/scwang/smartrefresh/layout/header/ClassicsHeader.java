package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.b;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements g {
    public static final byte H = 4;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static String O;
    public static String b0;
    protected String A;
    protected String B;
    protected String C;
    protected String D;
    protected String E;
    protected String F;
    protected String G;
    protected String t;
    protected Date u;
    protected TextView v;
    protected SharedPreferences w;
    protected DateFormat x;
    protected boolean y;
    protected String z;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8307a = new int[b.values().length];

        static {
            try {
                f8307a[b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8307a[b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8307a[b.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8307a[b.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8307a[b.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8307a[b.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8307a[b.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    public ClassicsHeader b(boolean z) {
        TextView textView = this.v;
        this.y = z;
        textView.setVisibility(z ? 0 : 8);
        i iVar = this.f8340h;
        if (iVar != null) {
            iVar.a(this);
        }
        return this;
    }

    public ClassicsHeader f(float f2) {
        this.v.setTextSize(f2);
        i iVar = this.f8340h;
        if (iVar != null) {
            iVar.a(this);
        }
        return this;
    }

    public ClassicsHeader g(float f2) {
        TextView textView = this.v;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = com.scwang.smartrefresh.layout.e.b.b(f2);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull j jVar, boolean z) {
        if (z) {
            this.f8336d.setText(this.D);
            if (this.u != null) {
                a(new Date());
            }
        } else {
            this.f8336d.setText(this.E);
        }
        return super.a(jVar, z);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i2) {
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        super(context, attributeSet, i2);
        this.t = "LAST_UPDATE_TIME";
        this.y = true;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        if (I == null) {
            I = context.getString(R.string.srl_header_pulling);
        }
        if (J == null) {
            J = context.getString(R.string.srl_header_refreshing);
        }
        if (K == null) {
            K = context.getString(R.string.srl_header_loading);
        }
        if (L == null) {
            L = context.getString(R.string.srl_header_release);
        }
        if (M == null) {
            M = context.getString(R.string.srl_header_finish);
        }
        if (N == null) {
            N = context.getString(R.string.srl_header_failed);
        }
        if (O == null) {
            O = context.getString(R.string.srl_header_update);
        }
        if (b0 == null) {
            b0 = context.getString(R.string.srl_header_secondary);
        }
        this.v = new TextView(context);
        this.v.setTextColor(-8618884);
        this.x = new SimpleDateFormat(O, Locale.getDefault());
        ImageView imageView = this.f8337e;
        TextView textView = this.v;
        ImageView imageView2 = this.f8338f;
        LinearLayout linearLayout = this.f8339g;
        com.scwang.smartrefresh.layout.e.b bVar = new com.scwang.smartrefresh.layout.e.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, bVar.a(0.0f));
        layoutParams2.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, bVar.a(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.n = typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.n);
        this.y = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.y);
        this.f8334b = c.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f8334b.ordinal())];
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.f8337e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else {
            this.f8341i = new com.scwang.smartrefresh.layout.internal.a();
            this.f8341i.a(-10066330);
            this.f8337e.setImageDrawable(this.f8341i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.f8338f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else {
            this.f8342j = new com.scwang.smartrefresh.layout.internal.c();
            this.f8342j.a(-10066330);
            this.f8338f.setImageDrawable(this.f8342j);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.f8336d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, com.scwang.smartrefresh.layout.e.b.b(16.0f)));
        } else {
            this.f8336d.setTextSize(16.0f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.v.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, com.scwang.smartrefresh.layout.e.b.b(12.0f)));
        } else {
            this.v.setTextSize(12.0f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.e(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            a(typedArrayObtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        this.z = I;
        this.B = K;
        this.C = L;
        this.D = M;
        this.E = N;
        this.F = O;
        this.G = b0;
        this.A = J;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextPulling)) {
            this.z = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextPulling);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextLoading)) {
            this.B = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextLoading);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRelease)) {
            this.C = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRelease);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFinish)) {
            this.D = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFinish);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFailed)) {
            this.E = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFailed);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.F = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextUpdate);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.G = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextSecondary);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.A = typedArrayObtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRefreshing);
        }
        typedArrayObtainStyledAttributes.recycle();
        textView.setId(4);
        textView.setVisibility(this.y ? 0 : 8);
        linearLayout.addView(textView, layoutParams3);
        this.f8336d.setText(isInEditMode() ? this.A : this.z);
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                a(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.t += context.getClass().getName();
        this.w = context.getSharedPreferences("ClassicsHeader", 0);
        a(new Date(this.w.getLong(this.t, System.currentTimeMillis())));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull j jVar, @NonNull b bVar, @NonNull b bVar2) {
        ImageView imageView = this.f8337e;
        TextView textView = this.v;
        switch (a.f8307a[bVar2.ordinal()]) {
            case 1:
                textView.setVisibility(this.y ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f8336d.setText(this.A);
                imageView.setVisibility(8);
                return;
            case 5:
                this.f8336d.setText(this.C);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.f8336d.setText(this.G);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.y ? 4 : 8);
                this.f8336d.setText(this.B);
                return;
            default:
                return;
        }
        this.f8336d.setText(this.z);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    public ClassicsHeader a(Date date) {
        this.u = date;
        this.v.setText(this.x.format(date));
        if (this.w != null && !isInEditMode()) {
            this.w.edit().putLong(this.t, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader a(DateFormat dateFormat) {
        this.x = dateFormat;
        Date date = this.u;
        if (date != null) {
            this.v.setText(this.x.format(date));
        }
        return this;
    }

    public ClassicsHeader a(CharSequence charSequence) {
        this.u = null;
        this.v.setText(charSequence);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    public ClassicsHeader a(@ColorInt int i2) {
        this.v.setTextColor((16777215 & i2) | (-872415232));
        return (ClassicsHeader) super.a(i2);
    }
}
