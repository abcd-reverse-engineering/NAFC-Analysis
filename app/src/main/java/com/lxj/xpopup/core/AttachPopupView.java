package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.c.d;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public abstract class AttachPopupView extends BasePopupView {
    protected int p;
    protected int q;
    protected PartShadowContainer r;
    public boolean s;
    boolean t;
    protected int u;
    float v;
    float w;
    float x;
    float y;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView.this.u();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView attachPopupView = AttachPopupView.this;
            float f2 = attachPopupView.t ? attachPopupView.f7987a.f8036j.x : attachPopupView.y;
            AttachPopupView attachPopupView2 = AttachPopupView.this;
            boolean z = attachPopupView2.t;
            int i2 = attachPopupView2.q;
            if (!z) {
                i2 = -i2;
            }
            attachPopupView.v = f2 + i2;
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f7987a.v) {
                if (attachPopupView3.t) {
                    attachPopupView3.v -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                } else {
                    attachPopupView3.v += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                }
            }
            if (AttachPopupView.this.v()) {
                AttachPopupView attachPopupView4 = AttachPopupView.this;
                attachPopupView4.w = (attachPopupView4.f7987a.f8036j.y - attachPopupView4.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.p;
            } else {
                AttachPopupView attachPopupView5 = AttachPopupView.this;
                attachPopupView5.w = attachPopupView5.f7987a.f8036j.y + attachPopupView5.p;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.v);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.w);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f7985a;

        c(Rect rect) {
            this.f7985a = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView attachPopupView = AttachPopupView.this;
            float f2 = attachPopupView.t ? this.f7985a.left : attachPopupView.y;
            AttachPopupView attachPopupView2 = AttachPopupView.this;
            boolean z = attachPopupView2.t;
            int i2 = attachPopupView2.q;
            if (!z) {
                i2 = -i2;
            }
            attachPopupView.v = f2 + i2;
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f7987a.v) {
                if (attachPopupView3.t) {
                    attachPopupView3.v += (this.f7985a.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                } else {
                    attachPopupView3.v -= (this.f7985a.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                }
            }
            if (AttachPopupView.this.v()) {
                AttachPopupView.this.w = (this.f7985a.top - r0.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.p;
            } else {
                AttachPopupView.this.w = this.f7985a.bottom + r0.p;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.v);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.w);
        }
    }

    public AttachPopupView(@NonNull Context context) {
        super(context);
        this.p = 0;
        this.q = 0;
        this.u = 6;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = com.lxj.xpopup.f.c.b(getContext());
        this.y = 0.0f;
        this.r = (PartShadowContainer) findViewById(R.id.attachPopupContainer);
        this.r.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.r, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return v() ? this.t ? new d(getPopupContentView(), com.lxj.xpopup.d.c.ScrollAlphaFromLeftBottom) : new d(getPopupContentView(), com.lxj.xpopup.d.c.ScrollAlphaFromRightBottom) : this.t ? new d(getPopupContentView(), com.lxj.xpopup.d.c.ScrollAlphaFromLeftTop) : new d(getPopupContentView(), com.lxj.xpopup.d.c.ScrollAlphaFromRightTop);
    }

    protected Drawable getPopupBackground() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        if (this.f7987a.a() == null && this.f7987a.f8036j == null) {
            throw new IllegalArgumentException("atView() or touchPoint must not be null for AttachPopupView ！");
        }
        int iA = this.f7987a.t;
        if (iA == 0) {
            iA = com.lxj.xpopup.f.c.a(getContext(), 4.0f);
        }
        this.p = iA;
        int iA2 = this.f7987a.s;
        if (iA2 == 0) {
            iA2 = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.q = iA2;
        getPopupImplView().setTranslationX(this.f7987a.s);
        getPopupImplView().setTranslationY(this.f7987a.t);
        if (!this.f7987a.f8031e.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (getPopupBackground() == null) {
                    this.r.setBackgroundColor(-1);
                } else {
                    this.r.setBackgroundDrawable(getPopupBackground());
                }
                this.r.setElevation(com.lxj.xpopup.f.c.a(getContext(), 10.0f));
            } else if (getPopupImplView().getBackground() == null) {
                int i2 = this.q;
                int i3 = this.u;
                this.q = i2 - i3;
                this.p -= i3;
                this.r.setBackgroundResource(R.drawable._xpopup_shadow);
            } else {
                this.r.setBackgroundDrawable(getPopupBackground());
            }
        }
        com.lxj.xpopup.f.c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new a());
    }

    protected void u() {
        com.lxj.xpopup.core.a aVar = this.f7987a;
        PointF pointF = aVar.f8036j;
        if (pointF != null) {
            this.y = Math.max(pointF.x - getPopupContentView().getMeasuredWidth(), 0.0f);
            if (this.f7987a.f8036j.y + ((float) getPopupContentView().getMeasuredHeight()) > this.x) {
                this.s = this.f7987a.f8036j.y > ((float) (com.lxj.xpopup.f.c.b(getContext()) / 2));
            } else {
                this.s = false;
            }
            this.t = this.f7987a.f8036j.x < ((float) (com.lxj.xpopup.f.c.c(getContext()) / 2));
            if (v()) {
                if (getPopupContentView().getMeasuredHeight() > this.f7987a.f8036j.y) {
                    ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
                    layoutParams.height = (int) (this.f7987a.f8036j.y - com.lxj.xpopup.f.c.c());
                    getPopupContentView().setLayoutParams(layoutParams);
                }
            } else if (getPopupContentView().getMeasuredHeight() + this.f7987a.f8036j.y > com.lxj.xpopup.f.c.b(getContext())) {
                ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
                layoutParams2.height = (int) (com.lxj.xpopup.f.c.b(getContext()) - this.f7987a.f8036j.y);
                getPopupContentView().setLayoutParams(layoutParams2);
            }
            getPopupContentView().post(new b());
            return;
        }
        int[] iArr = new int[2];
        aVar.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f7987a.a().getMeasuredWidth(), iArr[1] + this.f7987a.a().getMeasuredHeight());
        this.y = Math.max(rect.right - getPopupContentView().getMeasuredWidth(), 0);
        int i2 = (rect.left + rect.right) / 2;
        if (((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.x) {
            this.s = (rect.top + rect.bottom) / 2 > com.lxj.xpopup.f.c.b(getContext()) / 2;
        } else {
            this.s = false;
        }
        this.t = i2 < com.lxj.xpopup.f.c.c(getContext()) / 2;
        if (v()) {
            if (getPopupContentView().getMeasuredHeight() > rect.top) {
                ViewGroup.LayoutParams layoutParams3 = getPopupContentView().getLayoutParams();
                layoutParams3.height = rect.top - com.lxj.xpopup.f.c.c();
                getPopupContentView().setLayoutParams(layoutParams3);
            }
        } else if (getPopupContentView().getMeasuredHeight() + rect.bottom > com.lxj.xpopup.f.c.b(getContext())) {
            ViewGroup.LayoutParams layoutParams4 = getPopupContentView().getLayoutParams();
            layoutParams4.height = com.lxj.xpopup.f.c.b(getContext()) - rect.bottom;
            getPopupContentView().setLayoutParams(layoutParams4);
        }
        getPopupContentView().post(new c(rect));
    }

    protected boolean v() {
        return (this.s || this.f7987a.q == com.lxj.xpopup.d.d.Top) && this.f7987a.q != com.lxj.xpopup.d.d.Bottom;
    }
}
