package ui.view.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class CustomLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f20486a;

    public CustomLinearLayout(Context context) {
        super(context);
        this.f20486a = -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.f20486a;
        return i4 != -1 ? i3 == i4 ? i2 - 1 : i3 == i2 + (-1) ? i4 : i3 : i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof HandyGridView) {
                HandyGridView handyGridView = (HandyGridView) childAt;
                if (handyGridView.d() || handyGridView.g()) {
                    setChildrenDrawingOrderEnabled(true);
                    this.f20486a = i2;
                    return;
                }
                return;
            }
        }
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20486a = -1;
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20486a = -1;
    }
}
