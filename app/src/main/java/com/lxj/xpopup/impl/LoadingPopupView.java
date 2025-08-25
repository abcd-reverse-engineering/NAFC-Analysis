package com.lxj.xpopup.impl;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.core.CenterPopupView;

/* loaded from: classes.dex */
public class LoadingPopupView extends CenterPopupView {
    private TextView s;
    private String t;

    public LoadingPopupView(@NonNull Context context) {
        super(context);
    }

    public LoadingPopupView a(int i2) {
        this.q = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.q;
        return i2 != 0 ? i2 : R.layout._xpopup_center_impl_loading;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        TextView textView;
        super.k();
        this.s = (TextView) findViewById(R.id.tv_title);
        if (this.t == null || (textView = this.s) == null) {
            return;
        }
        textView.setVisibility(0);
        this.s.setText(this.t);
    }

    public LoadingPopupView a(String str) {
        this.t = str;
        return this;
    }
}
