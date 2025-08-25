package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.ResBean;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public abstract class a extends b {

    /* renamed from: a, reason: collision with root package name */
    protected Context f8808a;

    /* renamed from: b, reason: collision with root package name */
    protected View f8809b;

    /* renamed from: c, reason: collision with root package name */
    protected FrameLayout f8810c;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f8811d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f8812e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f8813f;

    /* renamed from: g, reason: collision with root package name */
    protected TextView f8814g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f8815h;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f8816i;

    /* renamed from: j, reason: collision with root package name */
    protected ResBean f8817j;

    /* renamed from: k, reason: collision with root package name */
    protected int f8818k;

    /* renamed from: l, reason: collision with root package name */
    protected int f8819l;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8808a = getActivity();
        this.f8817j = ResBean.f8780a;
        int i2 = this.f8819l;
        if (i2 == 0) {
            this.f8809b = new RelativeLayout(this.f8808a);
            ((RelativeLayout) this.f8809b).setGravity(17);
            this.f8809b.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.f8810c = new FrameLayout(this.f8808a);
            this.f8810c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.f8811d = new LinearLayout(this.f8808a);
            this.f8811d.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.f8811d.setGravity(17);
            this.f8811d.setLayoutParams(layoutParams);
            this.f8811d.setMinimumWidth(com.tencent.bugly.beta.global.a.a(this.f8808a, 280.0f));
            this.f8811d.setOrientation(1);
            if (this.f8818k == 2) {
                float fA = com.tencent.bugly.beta.global.a.a(this.f8808a, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.f8811d.setBackgroundDrawable(shapeDrawable);
            }
            this.f8813f = new TextView(this.f8808a);
            this.f8813f.setGravity(16);
            this.f8813f.setSingleLine();
            TextView textView = this.f8813f;
            this.f8817j.getClass();
            textView.setTextColor(Color.parseColor("#273238"));
            this.f8813f.setTextSize(18.0f);
            this.f8813f.setLayoutParams(layoutParams);
            this.f8813f.setOnClickListener(null);
            this.f8813f.setEllipsize(TextUtils.TruncateAt.END);
            int iA = com.tencent.bugly.beta.global.a.a(this.f8808a, 16.0f);
            this.f8813f.setPadding(iA, 0, iA, 0);
            this.f8813f.setTypeface(null, 1);
            this.f8813f.setHeight(com.tencent.bugly.beta.global.a.a(this.f8808a, 42.0f));
            this.f8813f.setTag(Beta.TAG_TITLE);
            TextView textView2 = new TextView(this.f8808a);
            textView2.setBackgroundColor(-3355444);
            textView2.setHeight(1);
            ScrollView scrollView = new ScrollView(this.f8808a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, com.tencent.bugly.beta.global.a.a(this.f8808a, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.f8816i = new LinearLayout(this.f8808a);
            this.f8816i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f8816i.setOrientation(1);
            this.f8816i.setPadding(iA, com.tencent.bugly.beta.global.a.a(this.f8808a, 10.0f), iA, 0);
            LinearLayout linearLayout = new LinearLayout(this.f8808a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(0);
            int i3 = iA / 2;
            linearLayout.setPadding(i3, iA, i3, iA);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i3, 0, i3, 0);
            this.f8814g = new TextView(this.f8808a);
            this.f8814g.setSingleLine();
            this.f8814g.setGravity(17);
            this.f8814g.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int iA2 = com.tencent.bugly.beta.global.a.a(this.f8808a, 30.0f);
            if (this.f8818k == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iA2, iA2);
                layoutParams5.gravity = 53;
                this.f8814g.setLayoutParams(layoutParams5);
                this.f8814g.setTextSize((float) (iA2 * 0.3d));
            } else {
                this.f8814g.setLayoutParams(layoutParams4);
                this.f8814g.setTextSize(16);
                TextView textView3 = this.f8814g;
                this.f8817j.getClass();
                textView3.setTextColor(Color.parseColor("#757575"));
                this.f8814g.setPadding(com.tencent.bugly.beta.global.a.a(this.f8808a, 10.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 5.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 10.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 5.0f));
            }
            this.f8815h = new TextView(this.f8808a);
            this.f8815h.setLayoutParams(layoutParams4);
            this.f8815h.setGravity(17);
            this.f8815h.setTextSize(16);
            TextView textView4 = this.f8815h;
            this.f8817j.getClass();
            textView4.setTextColor(Color.parseColor("#273238"));
            this.f8815h.setSingleLine();
            this.f8815h.setPadding(com.tencent.bugly.beta.global.a.a(this.f8808a, 10.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 5.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 10.0f), com.tencent.bugly.beta.global.a.a(this.f8808a, 5.0f));
            this.f8815h.setTypeface(null, 1);
            this.f8815h.setTag(Beta.TAG_CONFIRM_BUTTON);
            int iA3 = com.tencent.bugly.beta.global.a.a(this.f8808a, 40.0f);
            scrollView.addView(this.f8816i);
            if (this.f8818k == 2) {
                FrameLayout frameLayout = new FrameLayout(this.f8808a);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i4 = iA2 / 2;
                int i5 = i4 - 5;
                this.f8810c.setPadding(i4, i5, i5, i4);
                frameLayout.addView(this.f8810c);
                frameLayout.addView(this.f8814g);
                ((RelativeLayout) this.f8809b).addView(frameLayout);
            } else {
                this.f8809b.setPadding(iA3, iA3, iA3, iA3);
                ((RelativeLayout) this.f8809b).addView(this.f8810c);
                linearLayout.addView(this.f8814g);
            }
            this.f8811d.addView(this.f8813f);
            this.f8811d.addView(textView2);
            this.f8811d.addView(scrollView);
            this.f8810c.addView(this.f8811d);
            linearLayout.addView(this.f8815h);
            this.f8810c.addView(linearLayout);
            if (this.f8818k == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                int i6 = iA2 / 2;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                paint.setColor(-3355444);
                float f2 = i6;
                canvas.drawCircle(f2, f2, f2, paint);
                canvas.rotate(45.0f, f2, f2);
                paint.setColor(-7829368);
                int iA4 = com.tencent.bugly.beta.global.a.a(this.f8808a, 0.8f);
                float f3 = f2 * 0.4f;
                float f4 = i6 - iA4;
                float f5 = f2 * 1.6f;
                float f6 = i6 + iA4;
                canvas.drawRect(f3, f4, f5, f6, paint);
                canvas.drawRect(f4, f3, f6, f5, paint);
                canvas.rotate(-45.0f);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(iA2, iA2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f2, f2, f2, paint);
                canvas2.rotate(45.0f, f2, f2);
                paint.setColor(-3355444);
                canvas2.drawRect(f3, f4, f5, f6, paint);
                canvas2.drawRect(f4, f3, f6, f5, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap2);
                this.f8814g.setBackgroundDrawable(bitmapDrawable);
                this.f8814g.setOnTouchListener(new com.tencent.bugly.beta.global.c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.f8809b.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.f8809b.startAnimation(alphaAnimation);
        } else {
            this.f8809b = layoutInflater.inflate(i2, (ViewGroup) null);
            this.f8812e = (ImageView) this.f8809b.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.f8813f = (TextView) this.f8809b.findViewWithTag(Beta.TAG_TITLE);
            this.f8814g = (TextView) this.f8809b.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.f8815h = (TextView) this.f8809b.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.f8814g.setVisibility(8);
        this.f8815h.setVisibility(8);
        this.f8814g.setFocusable(true);
        this.f8815h.setFocusable(true);
        this.f8815h.requestFocus();
        return this.f8809b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8808a = null;
        this.f8809b = null;
        this.f8810c = null;
        this.f8811d = null;
        this.f8813f = null;
        this.f8812e = null;
        this.f8814g = null;
        this.f8815h = null;
        this.f8816i = null;
    }

    protected void a(final String str, final View.OnClickListener onClickListener, final String str2, final View.OnClickListener onClickListener2) {
        com.tencent.bugly.beta.utils.e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                TextView textView = aVar.f8814g;
                if (textView == null || aVar.f8815h == null) {
                    return;
                }
                if (str != null) {
                    textView.setVisibility(0);
                    a aVar2 = a.this;
                    if (aVar2.f8818k != 2) {
                        aVar2.f8814g.setText(str);
                        a aVar3 = a.this;
                        if (aVar3.f8819l == 0) {
                            aVar3.f8814g.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(a.this.f8818k), a.this.f8814g, 1));
                        }
                    }
                    a.this.f8814g.setOnClickListener(onClickListener);
                }
                if (str2 != null) {
                    a.this.f8815h.setVisibility(0);
                    a.this.f8815h.setText(str2);
                    a.this.f8815h.setOnClickListener(onClickListener2);
                    a aVar4 = a.this;
                    if (aVar4.f8819l == 0) {
                        aVar4.f8815h.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(a.this.f8818k), a.this.f8815h, 1));
                    }
                    a.this.f8815h.requestFocus();
                }
            }
        });
    }

    @Override // com.tencent.bugly.beta.ui.b
    public void a() {
        if (this.f8809b == null) {
            super.a();
            return;
        }
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        com.tencent.bugly.beta.utils.e.a(new Runnable() { // from class: com.tencent.bugly.beta.ui.a.2
            @Override // java.lang.Runnable
            public void run() {
                View view = a.this.f8809b;
                if (view != null) {
                    view.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.bugly.beta.ui.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view = a.this.f8809b;
                if (view != null) {
                    view.setVisibility(8);
                }
                a.super.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
