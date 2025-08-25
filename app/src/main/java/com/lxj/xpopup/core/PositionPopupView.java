package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.c.b;
import com.lxj.xpopup.c.d;
import com.lxj.xpopup.f.c;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public class PositionPopupView extends BasePopupView {
    PartShadowContainer p;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PositionPopupView positionPopupView = PositionPopupView.this;
            if (positionPopupView.f7987a.v) {
                PositionPopupView.this.p.setTranslationX((c.c(positionPopupView.getContext()) - PositionPopupView.this.p.getMeasuredWidth()) / 2.0f);
            } else {
                positionPopupView.p.setTranslationX(r1.s);
            }
            PositionPopupView.this.p.setTranslationY(r0.f7987a.t);
        }
    }

    public PositionPopupView(@NonNull Context context) {
        super(context);
        this.p = (PartShadowContainer) findViewById(R.id.attachPopupContainer);
        this.p.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.p, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected b getPopupAnimator() {
        return new d(getPopupContentView(), com.lxj.xpopup.d.c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new a());
    }
}
