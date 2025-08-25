package ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class ScaleRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private static final String f20410f = "ScaleRecyclerView";

    /* renamed from: a, reason: collision with root package name */
    private float f20411a;

    /* renamed from: b, reason: collision with root package name */
    private float f20412b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20413c;

    /* renamed from: d, reason: collision with root package name */
    private float f20414d;

    /* renamed from: e, reason: collision with root package name */
    private float f20415e;

    public ScaleRecyclerView(Context context) {
        super(context);
        this.f20413c = false;
        this.f20414d = 1.0f;
        this.f20415e = 0.3f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20411a = x;
            this.f20412b = y;
        } else if (action != 1) {
            if (action == 2) {
                if (y - this.f20412b > 0.0f) {
                    View childAt = getChildAt(0);
                    if (((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition() == 0 && childAt.getTop() >= 0) {
                        this.f20414d = (((y - this.f20412b) * this.f20415e) / getHeight()) + 1.0f;
                        setPivotY(0.0f);
                        setPivotX(getWidth() / 2);
                        ViewCompat.setScaleY(this, this.f20414d);
                        this.f20413c = true;
                    }
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition() + 1 == getAdapter().getItemCount() && childAt2.getBottom() <= getBottom()) {
                        this.f20414d = 1.0f - ((this.f20415e * (y - this.f20412b)) / getHeight());
                        setPivotX(getWidth() / 2);
                        setPivotY(getHeight());
                        ViewCompat.setScaleY(this, this.f20414d);
                        this.f20413c = true;
                    }
                }
            }
        } else if (this.f20413c) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleY", this.f20414d, 1.0f);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            this.f20413c = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20413c = false;
        this.f20414d = 1.0f;
        this.f20415e = 0.3f;
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20413c = false;
        this.f20414d = 1.0f;
        this.f20415e = 0.3f;
    }
}
