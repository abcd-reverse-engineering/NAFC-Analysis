package ui.view.drag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import util.c1;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class DragImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private int f20487a;

    /* renamed from: b, reason: collision with root package name */
    private int f20488b;

    /* renamed from: c, reason: collision with root package name */
    private int f20489c;

    /* renamed from: d, reason: collision with root package name */
    private int f20490d;

    /* renamed from: e, reason: collision with root package name */
    private Context f20491e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20492f;

    /* renamed from: g, reason: collision with root package name */
    private float f20493g;

    /* renamed from: h, reason: collision with root package name */
    private float f20494h;

    public DragImageView(Context context) {
        super(context);
        this.f20492f = false;
        this.f20491e = context;
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public boolean a() {
        return this.f20492f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f20487a = getMeasuredWidth();
        this.f20488b = getMeasuredHeight();
        this.f20489c = b(this.f20491e);
        this.f20490d = a(this.f20491e) - c1.d(this.f20491e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20492f = false;
            this.f20493g = motionEvent.getX();
            this.f20494h = motionEvent.getY();
        } else if (action == 1) {
            setPressed(false);
        } else if (action == 2) {
            float x = motionEvent.getX() - this.f20493g;
            float y = motionEvent.getY() - this.f20494h;
            if (Math.abs(x) > 10.0f || Math.abs(y) > 10.0f) {
                this.f20492f = true;
                int left = (int) (getLeft() + x);
                int i2 = this.f20487a + left;
                int top = (int) (getTop() + y);
                int i3 = this.f20488b + top;
                if (left < 0) {
                    i2 = this.f20487a + 0;
                    left = 0;
                } else {
                    int i4 = this.f20489c;
                    if (i2 > i4) {
                        left = i4 - this.f20487a;
                        i2 = i4;
                    }
                }
                if (top < 0) {
                    i3 = this.f20488b + 0;
                    top = 0;
                } else {
                    int i5 = this.f20490d;
                    if (i3 > i5) {
                        top = i5 - this.f20488b;
                        i3 = i5;
                    }
                }
                layout(left, top, i2, i3);
            }
        } else if (action == 3) {
            setPressed(false);
        }
        return true;
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    public DragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20492f = false;
        this.f20491e = context;
    }
}
