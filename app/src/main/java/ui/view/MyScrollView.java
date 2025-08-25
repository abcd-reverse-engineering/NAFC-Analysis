package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class MyScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private a f20377a;

    public interface a {
        void a(int i2);
    }

    public MyScrollView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f20377a;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f20377a = aVar;
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
