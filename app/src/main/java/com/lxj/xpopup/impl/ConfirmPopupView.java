package com.lxj.xpopup.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.b;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.e.a;
import com.lxj.xpopup.e.c;

/* loaded from: classes.dex */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {
    String A;
    String B;
    String C;
    boolean D;
    a s;
    c t;
    TextView u;
    TextView v;
    TextView w;
    TextView x;
    String y;
    String z;

    public ConfirmPopupView(@NonNull Context context) {
        super(context);
        this.D = false;
    }

    public ConfirmPopupView a(int i2) {
        this.q = i2;
        return this;
    }

    public ConfirmPopupView b(String str) {
        this.C = str;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.q;
        return i2 != 0 ? i2 : R.layout._xpopup_center_impl_confirm;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.u = (TextView) findViewById(R.id.tv_title);
        this.v = (TextView) findViewById(R.id.tv_content);
        this.w = (TextView) findViewById(R.id.tv_cancel);
        this.x = (TextView) findViewById(R.id.tv_confirm);
        if (this.q == 0) {
            u();
        }
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        if (TextUtils.isEmpty(this.y)) {
            this.u.setVisibility(8);
        } else {
            this.u.setText(this.y);
        }
        if (!TextUtils.isEmpty(this.z)) {
            this.v.setText(this.z);
        }
        if (!TextUtils.isEmpty(this.B)) {
            this.w.setText(this.B);
        }
        if (!TextUtils.isEmpty(this.C)) {
            this.x.setText(this.C);
        }
        if (this.D) {
            this.w.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.w) {
            a aVar = this.s;
            if (aVar != null) {
                aVar.onCancel();
            }
            b();
            return;
        }
        if (view == this.x) {
            c cVar = this.t;
            if (cVar != null) {
                cVar.a();
            }
            if (this.f7987a.f8030d.booleanValue()) {
                b();
            }
        }
    }

    protected void u() {
        this.w.setTextColor(b.b());
        this.x.setTextColor(b.b());
    }

    public ConfirmPopupView v() {
        this.D = true;
        return this;
    }

    public ConfirmPopupView a(c cVar, a aVar) {
        this.s = aVar;
        this.t = cVar;
        return this;
    }

    public ConfirmPopupView a(String str, String str2, String str3) {
        this.y = str;
        this.z = str2;
        this.A = str3;
        return this;
    }

    public ConfirmPopupView a(String str) {
        this.B = str;
        return this;
    }
}
