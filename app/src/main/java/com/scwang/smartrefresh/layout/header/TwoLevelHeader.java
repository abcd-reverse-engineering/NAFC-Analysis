package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.d;
import com.scwang.smartrefresh.layout.b.g;
import com.scwang.smartrefresh.layout.b.h;
import com.scwang.smartrefresh.layout.b.i;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.b;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* loaded from: classes.dex */
public class TwoLevelHeader extends InternalAbstract implements g {

    /* renamed from: d, reason: collision with root package name */
    protected int f8309d;

    /* renamed from: e, reason: collision with root package name */
    protected float f8310e;

    /* renamed from: f, reason: collision with root package name */
    protected float f8311f;

    /* renamed from: g, reason: collision with root package name */
    protected float f8312g;

    /* renamed from: h, reason: collision with root package name */
    protected float f8313h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f8314i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f8315j;

    /* renamed from: k, reason: collision with root package name */
    protected int f8316k;

    /* renamed from: l, reason: collision with root package name */
    protected int f8317l;

    /* renamed from: m, reason: collision with root package name */
    protected h f8318m;
    protected i n;
    protected d o;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8319a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8320b = new int[c.values().length];

        static {
            try {
                f8320b[c.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8320b[c.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8319a = new int[b.values().length];
            try {
                f8319a[b.TwoLevelReleased.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8319a[b.TwoLevel.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8319a[b.TwoLevelFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8319a[b.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public TwoLevelHeader(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull i iVar, int i2, int i3) {
        h hVar = this.f8318m;
        if (hVar == null) {
            return;
        }
        if (((i3 + i2) * 1.0f) / i2 != this.f8311f && this.f8317l == 0) {
            this.f8317l = i2;
            this.f8318m = null;
            iVar.c().d(this.f8311f);
            this.f8318m = hVar;
        }
        if (this.n == null && hVar.getSpinnerStyle() == c.Translate && !isInEditMode()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.getView().getLayoutParams();
            marginLayoutParams.topMargin -= i2;
            hVar.getView().setLayoutParams(marginLayoutParams);
        }
        this.f8317l = i2;
        this.n = iVar;
        iVar.b(this.f8316k);
        iVar.b(this, !this.f8315j);
        hVar.a(iVar, i2, i3);
    }

    public TwoLevelHeader b(float f2) {
        if (this.f8311f != f2) {
            this.f8311f = f2;
            i iVar = this.n;
            if (iVar != null) {
                this.f8317l = 0;
                iVar.c().d(this.f8311f);
            }
        }
        return this;
    }

    public TwoLevelHeader c(float f2) {
        this.f8313h = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract
    public boolean equals(Object obj) {
        h hVar = this.f8318m;
        return (hVar != null && hVar.equals(obj)) || super.equals(obj);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8334b = c.MatchLayout;
        if (this.f8318m == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8334b = c.FixedBehind;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt instanceof g) {
                this.f8318m = (g) childAt;
                this.f8335c = (h) childAt;
                bringChildToFront(childAt);
                break;
            }
            i2++;
        }
        if (this.f8318m == null) {
            a(new ClassicsHeader(getContext()));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        h hVar = this.f8318m;
        if (hVar == null) {
            super.onMeasure(i2, i3);
        } else {
            if (View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
                super.onMeasure(i2, i3);
                return;
            }
            hVar.getView().measure(i2, i3);
            super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), hVar.getView().getMeasuredHeight());
        }
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoLevelHeader c(boolean z) {
        this.f8314i = z;
        return this;
    }

    public TwoLevelHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8310e = 0.0f;
        this.f8311f = 2.5f;
        this.f8312g = 1.9f;
        this.f8313h = 1.0f;
        this.f8314i = true;
        this.f8315j = true;
        this.f8316k = 1000;
        this.f8334b = c.FixedBehind;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.f8311f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.f8311f);
        this.f8312g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f8312g);
        this.f8313h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.f8313h);
        this.f8316k = typedArrayObtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.f8316k);
        this.f8314i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f8314i);
        this.f8315j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f8315j);
        typedArrayObtainStyledAttributes.recycle();
    }

    public TwoLevelHeader b(boolean z) {
        i iVar = this.n;
        this.f8315j = z;
        if (iVar != null) {
            iVar.b(this, !z);
        }
        return this;
    }

    public TwoLevelHeader b(int i2) {
        this.f8316k = i2;
        return this;
    }

    public TwoLevelHeader b() {
        i iVar = this.n;
        if (iVar != null) {
            iVar.b();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.d.f
    public void a(@NonNull j jVar, @NonNull b bVar, @NonNull b bVar2) {
        h hVar = this.f8318m;
        if (hVar != null) {
            hVar.a(jVar, bVar, bVar2);
            int i2 = a.f8319a[bVar2.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                if (hVar.getView() != this) {
                    hVar.getView().animate().alpha(0.0f).setDuration(this.f8316k / 2);
                }
                i iVar = this.n;
                if (iVar != null) {
                    d dVar = this.o;
                    if (dVar != null && !dVar.a(jVar)) {
                        z = false;
                    }
                    iVar.a(z);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    if (hVar.getView() != this) {
                        hVar.getView().animate().alpha(1.0f).setDuration(this.f8316k / 2);
                    }
                } else if (i2 == 4 && hVar.getView().getAlpha() == 0.0f && hVar.getView() != this) {
                    hVar.getView().setAlpha(1.0f);
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(boolean z, float f2, int i2, int i3, int i4) {
        a(i2);
        h hVar = this.f8318m;
        i iVar = this.n;
        if (hVar != null) {
            hVar.a(z, f2, i2, i3, i4);
        }
        if (z) {
            float f3 = this.f8310e;
            float f4 = this.f8312g;
            if (f3 < f4 && f2 >= f4 && this.f8314i) {
                iVar.a(b.ReleaseToTwoLevel);
            } else if (this.f8310e >= this.f8312g && f2 < this.f8313h) {
                iVar.a(b.PullDownToRefresh);
            } else {
                float f5 = this.f8310e;
                float f6 = this.f8312g;
                if (f5 >= f6 && f2 < f6) {
                    iVar.a(b.ReleaseToRefresh);
                }
            }
            this.f8310e = f2;
        }
    }

    protected void a(int i2) {
        h hVar = this.f8318m;
        if (this.f8309d == i2 || hVar == null) {
            return;
        }
        this.f8309d = i2;
        int i3 = a.f8320b[hVar.getSpinnerStyle().ordinal()];
        if (i3 == 1) {
            hVar.getView().setTranslationY(i2);
        } else {
            if (i3 != 2) {
                return;
            }
            View view = hVar.getView();
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i2));
        }
    }

    public TwoLevelHeader a(g gVar) {
        return a(gVar, -1, -2);
    }

    public TwoLevelHeader a(g gVar, int i2, int i3) {
        if (gVar != null) {
            h hVar = this.f8318m;
            if (hVar != null) {
                removeView(hVar.getView());
            }
            if (gVar.getSpinnerStyle() == c.FixedBehind) {
                addView(gVar.getView(), 0, new RelativeLayout.LayoutParams(i2, i3));
            } else {
                addView(gVar.getView(), i2, i3);
            }
            this.f8318m = gVar;
            this.f8335c = gVar;
        }
        return this;
    }

    public TwoLevelHeader a(float f2) {
        this.f8312g = f2;
        return this;
    }

    public TwoLevelHeader a(d dVar) {
        this.o = dVar;
        return this;
    }
}
