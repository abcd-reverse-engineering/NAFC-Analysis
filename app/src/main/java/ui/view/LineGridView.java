package ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class LineGridView extends GridView {
    public LineGridView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth() / getChildAt(0).getWidth();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getResources().getColor(R.color.divide_line));
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            int i3 = i2 + 1;
            if (i3 % width == 0) {
                canvas.drawLine(childAt.getLeft(), childAt.getBottom(), childAt.getRight(), childAt.getBottom(), paint);
            } else if (i3 > childCount - (childCount % width)) {
                canvas.drawLine(childAt.getRight(), childAt.getTop(), childAt.getRight(), childAt.getBottom(), paint);
            } else {
                canvas.drawLine(childAt.getRight(), childAt.getTop(), childAt.getRight(), childAt.getBottom(), paint);
                canvas.drawLine(childAt.getLeft(), childAt.getBottom(), childAt.getRight(), childAt.getBottom(), paint);
            }
            i2 = i3;
        }
        int i4 = childCount % width;
        if (i4 != 0) {
            for (int i5 = 0; i5 < width - i4; i5++) {
                View childAt2 = getChildAt(childCount - 1);
                canvas.drawLine(childAt2.getRight() + (childAt2.getWidth() * i5), childAt2.getTop(), childAt2.getRight() + (childAt2.getWidth() * i5), childAt2.getBottom(), paint);
            }
        }
    }

    public LineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
