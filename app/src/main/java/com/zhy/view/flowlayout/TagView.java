package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class TagView extends FrameLayout implements Checkable {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f13504b = {android.R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    private boolean f13505a;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13505a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f13504b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f13505a != z) {
            this.f13505a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f13505a);
    }
}
