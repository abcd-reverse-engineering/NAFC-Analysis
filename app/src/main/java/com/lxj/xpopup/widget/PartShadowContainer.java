package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lxj.xpopup.e.b;
import com.lxj.xpopup.f.c;

/* loaded from: classes.dex */
public class PartShadowContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8156a;

    /* renamed from: b, reason: collision with root package name */
    private float f8157b;

    /* renamed from: c, reason: collision with root package name */
    private float f8158c;

    /* renamed from: d, reason: collision with root package name */
    private b f8159d;

    public PartShadowContainer(@NonNull Context context) {
        super(context);
        this.f8156a = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!c.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f8157b = motionEvent.getX();
                this.f8158c = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f8157b, 2.0d) + Math.pow(motionEvent.getY() - this.f8158c, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.f8156a && (bVar = this.f8159d) != null) {
                    bVar.a();
                }
                this.f8157b = 0.0f;
                this.f8158c = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(b bVar) {
        this.f8159d = bVar;
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8156a = true;
    }
}
