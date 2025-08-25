package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class CenterPopupView extends BasePopupView {
    protected FrameLayout p;
    protected int q;
    protected int r;

    public CenterPopupView(@NonNull Context context) {
        super(context);
        this.p = (FrameLayout) findViewById(R.id.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f7987a.f8037k;
        return i2 == 0 ? (int) (c.c(getContext()) * 0.86f) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected b getPopupAnimator() {
        return new com.lxj.xpopup.c.c(getPopupContentView(), com.lxj.xpopup.d.c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_center_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        View viewInflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.p, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewInflate.getLayoutParams();
        layoutParams.gravity = 17;
        this.p.addView(viewInflate, layoutParams);
        getPopupContentView().setTranslationX(this.f7987a.s);
        getPopupContentView().setTranslationY(this.f7987a.t);
        c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }
}
