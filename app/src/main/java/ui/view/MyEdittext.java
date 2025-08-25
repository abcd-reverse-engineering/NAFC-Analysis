package ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class MyEdittext extends EditText {
    public MyEdittext(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public MyEdittext(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyEdittext(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
