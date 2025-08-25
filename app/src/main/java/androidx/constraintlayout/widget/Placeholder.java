package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import util.c2.a;

/* loaded from: classes.dex */
public class Placeholder extends View {
    private View mContent;
    private int mContentId;
    private int mEmptyVisibility;

    public Placeholder(Context context) {
        super(context);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        super.setVisibility(this.mEmptyVisibility);
        this.mContentId = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.mContentId = typedArrayObtainStyledAttributes.getResourceId(index, this.mContentId);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.mEmptyVisibility = typedArrayObtainStyledAttributes.getInt(index, this.mEmptyVisibility);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.mContent;
    }

    public int getEmptyVisibility() {
        return this.mEmptyVisibility;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(a.z0, a.z0, a.z0);
            Paint paint = new Paint();
            paint.setARGB(255, a.u0, a.u0, a.u0);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i2) {
        View viewFindViewById;
        if (this.mContentId == i2) {
            return;
        }
        View view = this.mContent;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.mContent.getLayoutParams()).isInPlaceholder = false;
            this.mContent = null;
        }
        this.mContentId = i2;
        if (i2 == -1 || (viewFindViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.mEmptyVisibility = i2;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.mContent == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mContent.getLayoutParams();
        layoutParams2.widget.setVisibility(0);
        if (layoutParams.widget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
            layoutParams.widget.setWidth(layoutParams2.widget.getWidth());
        }
        if (layoutParams.widget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
            layoutParams.widget.setHeight(layoutParams2.widget.getHeight());
        }
        layoutParams2.widget.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.mContentId == -1 && !isInEditMode()) {
            setVisibility(this.mEmptyVisibility);
        }
        this.mContent = constraintLayout.findViewById(this.mContentId);
        View view = this.mContent;
        if (view != null) {
            ((ConstraintLayout.LayoutParams) view.getLayoutParams()).isInPlaceholder = true;
            this.mContent.setVisibility(0);
            setVisibility(0);
        }
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.mContentId = -1;
        this.mContent = null;
        this.mEmptyVisibility = 4;
        init(attributeSet);
    }
}
