package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

/* loaded from: classes2.dex */
public class CustomExpandableListView extends ExpandableListView {
    public CustomExpandableListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public CustomExpandableListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public CustomExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
