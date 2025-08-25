package ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes2.dex */
public class ScaleScrollView extends NestedScrollView {

    /* renamed from: f, reason: collision with root package name */
    private static final String f20416f = "ScaleRecyclerView";

    /* renamed from: a, reason: collision with root package name */
    private float f20417a;

    /* renamed from: b, reason: collision with root package name */
    private float f20418b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20419c;

    /* renamed from: d, reason: collision with root package name */
    private float f20420d;

    /* renamed from: e, reason: collision with root package name */
    private float f20421e;

    public ScaleScrollView(Context context) {
        super(context);
        this.f20419c = false;
        this.f20420d = 1.0f;
        this.f20421e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20417a = x;
            this.f20418b = y;
        } else if (action != 1) {
            if (action == 2 && y - this.f20418b > 0.0f && getScrollY() == 0) {
                this.f20420d = (((y - this.f20418b) * this.f20421e) / getHeight()) + 1.0f;
                setPivotY(0.0f);
                setPivotX(getWidth() / 2);
                ViewCompat.setScaleY(this, this.f20420d);
                this.f20419c = true;
            }
        } else if (this.f20419c) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f20420d, 1.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            this.f20419c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20419c = false;
        this.f20420d = 1.0f;
        this.f20421e = 0.3f;
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20419c = false;
        this.f20420d = 1.0f;
        this.f20421e = 0.3f;
    }
}
