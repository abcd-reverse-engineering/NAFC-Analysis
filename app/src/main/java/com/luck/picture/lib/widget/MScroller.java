package com.luck.picture.lib.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes.dex */
public class MScroller extends Scroller {
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.luck.picture.lib.widget.c
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            return MScroller.a(f2);
        }
    };
    public boolean noDuration;

    public MScroller(Context context) {
        this(context, sInterpolator);
    }

    static /* synthetic */ float a(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3 * f3 * f3) + 1.0f;
    }

    public void setNoDuration(boolean z) {
        this.noDuration = z;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        if (this.noDuration) {
            super.startScroll(i2, i3, i4, i5, 0);
        } else {
            super.startScroll(i2, i3, i4, i5, i6);
        }
    }

    public MScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }
}
