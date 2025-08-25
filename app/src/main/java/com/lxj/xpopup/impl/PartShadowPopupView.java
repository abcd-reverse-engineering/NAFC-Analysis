package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.c.g;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;

/* loaded from: classes.dex */
public abstract class PartShadowPopupView extends AttachPopupView {

    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PartShadowPopupView.this.f7987a.f8029c.booleanValue()) {
                return false;
            }
            PartShadowPopupView.this.b();
            return false;
        }
    }

    class b implements com.lxj.xpopup.e.b {
        b() {
        }

        @Override // com.lxj.xpopup.e.b
        public void a() {
            if (PartShadowPopupView.this.f7987a.f8029c.booleanValue()) {
                PartShadowPopupView.this.b();
            }
        }
    }

    public PartShadowPopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return new g(getPopupImplView(), this.s ? c.TranslateFromBottom : c.TranslateFromTop);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        int iA = this.f7987a.t;
        if (iA == 0) {
            iA = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.p = iA;
        int iA2 = this.f7987a.s;
        if (iA2 == 0) {
            iA2 = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.q = iA2;
        getPopupImplView().setTranslationX(this.f7987a.s);
        getPopupImplView().setTranslationY(this.f7987a.t);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f7987a.f8029c.booleanValue()) {
            b();
        }
        return !this.f7987a.f8029c.booleanValue();
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    protected void u() {
        if (this.f7987a.a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
        }
        this.f7989c.f7950a = getPopupContentView();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        if (rotation == 0) {
            marginLayoutParams.width = getMeasuredWidth();
        } else if (rotation == 1 || rotation == 3) {
            marginLayoutParams.width = getMeasuredWidth() - (com.lxj.xpopup.f.c.d(getContext()) ? com.lxj.xpopup.f.c.b() : 0);
        }
        if (this.f7987a.v && getPopupImplView() != null) {
            getPopupImplView().setTranslationX((com.lxj.xpopup.f.c.c(getContext()) / 2.0f) - (getPopupContentView().getMeasuredWidth() / 2.0f));
        }
        int[] iArr = new int[2];
        this.f7987a.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f7987a.a().getMeasuredWidth(), iArr[1] + this.f7987a.a().getMeasuredHeight());
        if ((rect.top + (rect.height() / 2) > getMeasuredHeight() / 2 || this.f7987a.q == d.Top) && this.f7987a.q != d.Bottom) {
            marginLayoutParams.height = rect.top;
            this.s = true;
            marginLayoutParams.topMargin = -this.p;
            View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        } else {
            marginLayoutParams.height = getMeasuredHeight() - rect.bottom;
            if (com.lxj.xpopup.f.c.d(getContext())) {
                marginLayoutParams.height -= com.lxj.xpopup.f.c.b();
            }
            this.s = false;
            marginLayoutParams.topMargin = rect.bottom + this.p;
            View childAt2 = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams2.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams2.height = Math.min(childAt2.getMeasuredHeight(), getMaxHeight());
            }
            childAt2.setLayoutParams(layoutParams2);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        this.r.setOnLongClickListener(new a());
        this.r.setOnClickOutsideListener(new b());
    }
}
