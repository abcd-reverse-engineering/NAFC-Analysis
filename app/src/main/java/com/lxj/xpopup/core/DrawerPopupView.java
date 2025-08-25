package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.d.d;
import com.lxj.xpopup.widget.PopupDrawerLayout;

/* loaded from: classes.dex */
public abstract class DrawerPopupView extends BasePopupView {
    PopupDrawerLayout p;
    protected FrameLayout q;

    class a implements PopupDrawerLayout.d {
        a() {
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.d
        public void a() {
            DrawerPopupView.super.e();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.d
        public void onClose() {
            DrawerPopupView.super.b();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.d
        public void a(float f2) {
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            drawerPopupView.p.f8180i = drawerPopupView.f7987a.r.booleanValue();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DrawerPopupView.this.p.a();
        }
    }

    public DrawerPopupView(@NonNull Context context) {
        super(context);
        this.p = (PopupDrawerLayout) findViewById(R.id.drawerLayout);
        this.q = (FrameLayout) findViewById(R.id.drawerContentContainer);
        this.q.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.q, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    public void e() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void f() {
        this.p.a();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        this.p.b();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.p.f8182k = this.f7987a.f8031e.booleanValue();
        this.p.setOnCloseListener(new a());
        getPopupImplView().setTranslationX(this.f7987a.s);
        getPopupImplView().setTranslationY(this.f7987a.t);
        PopupDrawerLayout popupDrawerLayout = this.p;
        d dVar = this.f7987a.q;
        if (dVar == null) {
            dVar = d.Left;
        }
        popupDrawerLayout.setDrawerPosition(dVar);
        this.p.setOnClickListener(new b());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        this.p.a();
    }
}
