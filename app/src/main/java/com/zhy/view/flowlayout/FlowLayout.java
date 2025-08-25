package com.zhy.view.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    private static final String f13488f = "FlowLayout";

    /* renamed from: g, reason: collision with root package name */
    private static final int f13489g = -1;

    /* renamed from: h, reason: collision with root package name */
    private static final int f13490h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final int f13491i = 1;

    /* renamed from: a, reason: collision with root package name */
    protected List<List<View>> f13492a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Integer> f13493b;

    /* renamed from: c, reason: collision with root package name */
    protected List<Integer> f13494c;

    /* renamed from: d, reason: collision with root package name */
    private int f13495d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f13496e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13492a = new ArrayList();
        this.f13493b = new ArrayList();
        this.f13494c = new ArrayList();
        this.f13496e = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f13495d = typedArrayObtainStyledAttributes.getInt(R.styleable.TagFlowLayout_tag_gravity, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int paddingLeft;
        this.f13492a.clear();
        this.f13493b.clear();
        this.f13494c.clear();
        this.f13496e.clear();
        int width = getWidth();
        int childCount = getChildCount();
        int iMax = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i7 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.f13493b.add(Integer.valueOf(iMax));
                    this.f13492a.add(this.f13496e);
                    this.f13494c.add(Integer.valueOf(i7));
                    iMax = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.f13496e = new ArrayList();
                    i7 = 0;
                }
                i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                iMax = Math.max(iMax, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                this.f13496e.add(childAt);
            }
        }
        this.f13493b.add(Integer.valueOf(iMax));
        this.f13494c.add(Integer.valueOf(i7));
        this.f13492a.add(this.f13496e);
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f13492a.size();
        int i9 = paddingTop;
        int paddingLeft3 = paddingLeft2;
        int i10 = 0;
        while (i10 < size) {
            this.f13496e = this.f13492a.get(i10);
            int iIntValue = this.f13493b.get(i10).intValue();
            int iIntValue2 = this.f13494c.get(i10).intValue();
            int i11 = this.f13495d;
            if (i11 != -1) {
                if (i11 == 0) {
                    i6 = (width - iIntValue2) / 2;
                    paddingLeft = getPaddingLeft();
                } else if (i11 == 1) {
                    i6 = width - iIntValue2;
                    paddingLeft = getPaddingLeft();
                }
                paddingLeft3 = i6 + paddingLeft;
            } else {
                paddingLeft3 = getPaddingLeft();
            }
            int measuredWidth2 = paddingLeft3;
            for (int i12 = 0; i12 < this.f13496e.size(); i12++) {
                View view = this.f13496e.get(i12);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + measuredWidth2;
                    int i14 = marginLayoutParams2.topMargin + i9;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    measuredWidth2 += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            i9 += iIntValue;
            i10++;
            paddingLeft3 = measuredWidth2;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int childCount = getChildCount();
        int i5 = 0;
        int iMax = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                if (i5 == childCount - 1) {
                    iMax = Math.max(i6, iMax);
                    i8 += i7;
                }
                i4 = size2;
            } else {
                measureChild(childAt, i2, i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i4 = size2;
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int i9 = i6 + measuredWidth;
                if (i9 > (size - getPaddingLeft()) - getPaddingRight()) {
                    iMax = Math.max(iMax, i6);
                    i8 += i7;
                } else {
                    measuredHeight = Math.max(i7, measuredHeight);
                    measuredWidth = i9;
                }
                if (i5 == childCount - 1) {
                    iMax = Math.max(measuredWidth, iMax);
                    i8 += measuredHeight;
                }
                i7 = measuredHeight;
                i6 = measuredWidth;
            }
            i5++;
            size2 = i4;
        }
        int i10 = size2;
        if (mode != 1073741824) {
            size = getPaddingRight() + iMax + getPaddingLeft();
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i10 : i8 + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }
}
