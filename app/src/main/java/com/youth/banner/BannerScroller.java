package com.youth.banner;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* loaded from: classes2.dex */
public class BannerScroller extends Scroller {
    private int mDuration;

    public BannerScroller(Context context) {
        super(context);
        this.mDuration = BannerConfig.DURATION;
    }

    public void setDuration(int i2) {
        this.mDuration = i2;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, this.mDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5, this.mDuration);
    }

    public BannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = BannerConfig.DURATION;
    }

    public BannerScroller(Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
        this.mDuration = BannerConfig.DURATION;
    }
}
