package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class NoSlideViewPager extends ViewPager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f20379a;

    public NoSlideViewPager(Context context) {
        super(context);
        this.f20379a = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        return this.f20379a;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f20379a;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f20379a;
    }

    public void setSlide(boolean z) {
        this.f20379a = z;
    }

    public NoSlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20379a = false;
    }
}
