package ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class SimpleDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    private int f20437a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f20438b = new Paint();

    public SimpleDividerDecoration(Context context) {
        this.f20438b.setColor(context.getResources().getColor(R.color.line_color));
        this.f20437a = context.getResources().getDimensionPixelSize(R.dimen.dp_1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f20437a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        for (int i2 = 0; i2 < childCount - 1; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            canvas.drawRect(paddingLeft, childAt.getBottom(), width, childAt.getBottom() + this.f20437a, this.f20438b);
        }
    }
}
