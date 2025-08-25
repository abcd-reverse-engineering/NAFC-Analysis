package com.luck.picture.lib.widget;

import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class MyViewPageHelper {
    MScroller scroller;
    ViewPager viewPager;

    public MyViewPageHelper(ViewPager viewPager) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.viewPager = viewPager;
        init();
    }

    private void init() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.scroller = new MScroller(this.viewPager.getContext());
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.viewPager, this.scroller);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public MScroller getScroller() {
        return this.scroller;
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    public void setCurrentItem(int i2, boolean z) {
        if (Math.abs(this.viewPager.getCurrentItem() - i2) <= 1) {
            this.scroller.setNoDuration(false);
            this.viewPager.setCurrentItem(i2, z);
        } else {
            this.scroller.setNoDuration(true);
            this.viewPager.setCurrentItem(i2, z);
            this.scroller.setNoDuration(false);
        }
    }
}
