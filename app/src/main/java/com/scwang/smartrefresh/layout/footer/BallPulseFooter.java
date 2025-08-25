package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.b.f;
import com.scwang.smartrefresh.layout.b.j;
import com.scwang.smartrefresh.layout.c.c;
import com.scwang.smartrefresh.layout.e.b;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class BallPulseFooter extends InternalAbstract implements f {
    public static final int n = 50;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f8279d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f8280e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f8281f;

    /* renamed from: g, reason: collision with root package name */
    protected int f8282g;

    /* renamed from: h, reason: collision with root package name */
    protected int f8283h;

    /* renamed from: i, reason: collision with root package name */
    protected float f8284i;

    /* renamed from: j, reason: collision with root package name */
    protected float[] f8285j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f8286k;

    /* renamed from: l, reason: collision with root package name */
    protected ArrayList<ValueAnimator> f8287l;

    /* renamed from: m, reason: collision with root package name */
    protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f8288m;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f8290b;

        a(int i2, View view) {
            this.f8289a = i2;
            this.f8290b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BallPulseFooter.this.f8285j[this.f8289a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f8290b.postInvalidate();
        }
    }

    public BallPulseFooter(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public void a(@NonNull j jVar, int i2, int i3) {
        if (this.f8286k) {
            return;
        }
        for (int i4 = 0; i4 < this.f8287l.size(); i4++) {
            ValueAnimator valueAnimator = this.f8287l.get(i4);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f8288m.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.f8286k = true;
        this.f8281f.setColor(this.f8283h);
    }

    @Override // com.scwang.smartrefresh.layout.b.f
    public boolean a(boolean z) {
        return false;
    }

    public BallPulseFooter b(@ColorInt int i2) {
        this.f8282g = i2;
        this.f8279d = true;
        if (!this.f8286k) {
            this.f8281f.setColor(i2);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width, height);
        float f2 = this.f8284i;
        float f3 = (fMin - (f2 * 2.0f)) / 6.0f;
        float f4 = 2.0f * f3;
        float f5 = (width / 2) - (f2 + f4);
        float f6 = height / 2;
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            float f7 = i2;
            canvas.translate((f4 * f7) + f5 + (this.f8284i * f7), f6);
            float[] fArr = this.f8285j;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.drawCircle(0.0f, 0.0f, f3, this.f8281f);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8287l != null) {
            for (int i2 = 0; i2 < this.f8287l.size(); i2++) {
                this.f8287l.get(i2).cancel();
                this.f8287l.get(i2).removeAllListeners();
                this.f8287l.get(i2).removeAllUpdateListeners();
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (!this.f8280e && iArr.length > 1) {
            a(iArr[0]);
            this.f8280e = false;
        }
        if (this.f8279d) {
            return;
        }
        if (iArr.length > 1) {
            b(iArr[1]);
        } else if (iArr.length > 0) {
            b(ColorUtils.compositeColors(-1711276033, iArr[0]));
        }
        this.f8279d = false;
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f8282g = -1118482;
        this.f8283h = -1615546;
        this.f8285j = new float[]{1.0f, 1.0f, 1.0f};
        this.f8286k = false;
        this.f8288m = new HashMap();
        setMinimumHeight(b.b(60.0f));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        this.f8281f = new Paint();
        this.f8281f.setColor(-1);
        this.f8281f.setStyle(Paint.Style.FILL);
        this.f8281f.setAntiAlias(true);
        this.f8334b = c.Translate;
        this.f8334b = c.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f8334b.ordinal())];
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlNormalColor)) {
            b(typedArrayObtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor)) {
            a(typedArrayObtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f8284i = b.b(4.0f);
        this.f8287l = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (int i3 = 0; i3 < 3; i3++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            valueAnimatorOfFloat.setDuration(750L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setTarget(Integer.valueOf(i3));
            valueAnimatorOfFloat.setStartDelay(iArr[i3]);
            this.f8288m.put(valueAnimatorOfFloat, new a(i3, this));
            this.f8287l.add(valueAnimatorOfFloat);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.h
    public int a(@NonNull j jVar, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.f8287l;
        if (arrayList != null && this.f8286k) {
            this.f8286k = false;
            this.f8285j = new float[]{1.0f, 1.0f, 1.0f};
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        this.f8281f.setColor(this.f8282g);
        return 0;
    }

    public BallPulseFooter a(c cVar) {
        this.f8334b = cVar;
        return this;
    }

    public BallPulseFooter a(@ColorInt int i2) {
        this.f8283h = i2;
        this.f8280e = true;
        if (this.f8286k) {
            this.f8281f.setColor(i2);
        }
        return this;
    }
}
