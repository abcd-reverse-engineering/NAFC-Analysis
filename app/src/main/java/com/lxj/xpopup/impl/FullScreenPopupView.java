package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.b;
import com.lxj.xpopup.c.g;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class FullScreenPopupView extends CenterPopupView {
    Paint s;
    Rect t;

    public FullScreenPopupView(@NonNull Context context) {
        super(context);
        this.s = new Paint();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f7987a.r.booleanValue()) {
            this.s.setColor(b.f7945c);
            this.t = new Rect(0, 0, c.c(getContext()), c.c());
            canvas.drawRect(this.t, this.s);
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return new g(getPopupContentView(), com.lxj.xpopup.d.c.TranslateFromBottom);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        View popupContentView = getPopupContentView();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) popupContentView.getLayoutParams();
        layoutParams.gravity = 48;
        popupContentView.setLayoutParams(layoutParams);
        int iB = c.d(getContext()) ? c.b() : 0;
        if (rotation == 0) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), iB);
        } else if (rotation == 1 || rotation == 3) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), 0);
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = null;
    }
}
