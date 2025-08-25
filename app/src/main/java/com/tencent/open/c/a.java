package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9820a = a.class.getName();

    /* renamed from: b, reason: collision with root package name */
    private Rect f9821b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9822c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0131a f9823d;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0131a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f9821b = null;
        this.f9822c = false;
        this.f9823d = null;
        if (this.f9821b == null) {
            this.f9821b = new Rect();
        }
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        this.f9823d = interfaceC0131a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f9821b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f9821b.top) - size;
        InterfaceC0131a interfaceC0131a = this.f9823d;
        if (interfaceC0131a != null && size != 0) {
            if (height > 100) {
                interfaceC0131a.a((Math.abs(this.f9821b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0131a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
