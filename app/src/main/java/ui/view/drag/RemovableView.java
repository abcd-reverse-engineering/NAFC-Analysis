package ui.view.drag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class RemovableView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Context f20510a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f20511b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20512c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20513d;

    /* renamed from: e, reason: collision with root package name */
    private float f20514e;

    /* renamed from: f, reason: collision with root package name */
    private float f20515f;

    /* renamed from: g, reason: collision with root package name */
    private int f20516g;

    /* renamed from: h, reason: collision with root package name */
    private int f20517h;

    /* renamed from: i, reason: collision with root package name */
    private int f20518i;

    public RemovableView(Context context) {
        this(context, null);
    }

    private void b() {
    }

    public boolean a() {
        return this.f20511b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f20513d) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2 && rawX >= 0.0f && rawX <= this.f20516g) {
                        if (rawY >= this.f20518i && rawY <= this.f20517h + r2) {
                            float f2 = rawX - this.f20514e;
                            float f3 = rawY - this.f20515f;
                            if (!this.f20511b) {
                                this.f20511b = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= 2.0d;
                            }
                            float x = getX() + f2;
                            float y = getY() + f3;
                            float width = this.f20516g - getWidth();
                            float height = this.f20517h - getHeight();
                            float fMin = x < 0.0f ? 0.0f : Math.min(x, width);
                            float fMin2 = y >= 0.0f ? Math.min(y, height) : 0.0f;
                            setX(fMin);
                            setY(fMin2);
                            this.f20514e = rawX;
                            this.f20515f = rawY;
                        }
                    }
                } else if (this.f20512c && this.f20511b) {
                    int i2 = this.f20516g;
                    if (this.f20514e <= (i2 >> 1)) {
                        this.f20514e = 0.0f;
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f20514e).start();
                    } else {
                        this.f20514e = i2 - getWidth();
                        animate().setInterpolator(new LinearInterpolator()).setDuration(200L).x(this.f20514e).start();
                    }
                }
            } else {
                this.f20511b = false;
                this.f20514e = rawX;
                this.f20515f = rawY;
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    int[] iArr = new int[2];
                    viewGroup.getLocationInWindow(iArr);
                    this.f20517h = viewGroup.getMeasuredHeight();
                    this.f20516g = viewGroup.getMeasuredWidth();
                    this.f20518i = iArr[1];
                }
            }
        }
        boolean z = this.f20511b;
        return z ? z : super.onTouchEvent(motionEvent);
    }

    public RemovableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemovableView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20511b = true;
        this.f20512c = true;
        this.f20513d = true;
        this.f20516g = 0;
        this.f20517h = 0;
        this.f20518i = 0;
        this.f20510a = context;
        b();
    }
}
