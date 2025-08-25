package ui.view.drag.vert;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f20534c = {R.attr.listDivider};

    /* renamed from: d, reason: collision with root package name */
    public static final int f20535d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f20536e = 1;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f20537a;

    /* renamed from: b, reason: collision with root package name */
    private int f20538b;

    public DividerItemDecoration(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f20534c);
        this.f20537a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(i2);
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            this.f20537a.setBounds(right, paddingTop, this.f20537a.getIntrinsicHeight() + right, height);
            this.f20537a.draw(canvas);
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            new RecyclerView(recyclerView.getContext());
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            this.f20537a.setBounds(paddingLeft, bottom, width, this.f20537a.getIntrinsicHeight() + bottom);
            this.f20537a.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
        if (this.f20538b == 1) {
            rect.set(0, 0, 0, this.f20537a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f20537a.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.f20538b == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.f20538b = i2;
    }
}
