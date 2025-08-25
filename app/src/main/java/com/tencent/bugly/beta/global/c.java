package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final int f8787a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f8788b;

    public c(int i2, Object... objArr) {
        this.f8787a = i2;
        this.f8788b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e2) {
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f8787a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundDrawable((Drawable) this.f8788b[0]);
        } else {
            view.setBackgroundDrawable((Drawable) this.f8788b[1]);
        }
        return false;
    }
}
