package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.lxj.xpopup.R;
import com.lxj.xpopup.b;
import com.lxj.xpopup.e.e;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener {
    AppCompatEditText E;
    public String F;
    com.lxj.xpopup.e.a G;
    e H;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputConfirmPopupView.this.E.setBackgroundDrawable(c.a(c.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.E.getMeasuredWidth(), Color.parseColor("#888888")), c.a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.E.getMeasuredWidth(), b.b())));
        }
    }

    public InputConfirmPopupView(@NonNull Context context) {
        super(context);
    }

    public AppCompatEditText getEditText() {
        return this.E;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.E = (AppCompatEditText) findViewById(R.id.et_input);
        this.E.setVisibility(0);
        if (!TextUtils.isEmpty(this.A)) {
            this.E.setHint(this.A);
        }
        if (!TextUtils.isEmpty(this.F)) {
            this.E.setText(this.F);
            this.E.setSelection(this.F.length());
        }
        w();
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.w) {
            com.lxj.xpopup.e.a aVar = this.G;
            if (aVar != null) {
                aVar.onCancel();
            }
            b();
            return;
        }
        if (view == this.x) {
            e eVar = this.H;
            if (eVar != null) {
                eVar.a(this.E.getText().toString().trim());
            }
            if (this.f7987a.f8030d.booleanValue()) {
                b();
            }
        }
    }

    protected void w() {
        super.u();
        c.a(this.E, b.b());
        this.E.post(new a());
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView
    public InputConfirmPopupView a(int i2) {
        this.q = i2;
        return this;
    }

    public void a(e eVar, com.lxj.xpopup.e.a aVar) {
        this.G = aVar;
        this.H = eVar;
    }
}
