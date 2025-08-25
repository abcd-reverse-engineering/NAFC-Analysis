package ui.view.swip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.hicorenational.antifraud.R;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class SwipBackLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f20671a;

    /* renamed from: b, reason: collision with root package name */
    private int f20672b;

    /* renamed from: c, reason: collision with root package name */
    private int f20673c;

    /* renamed from: d, reason: collision with root package name */
    private int f20674d;

    /* renamed from: e, reason: collision with root package name */
    private int f20675e;

    /* renamed from: f, reason: collision with root package name */
    private Scroller f20676f;

    /* renamed from: g, reason: collision with root package name */
    private int f20677g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20678h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20679i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20680j;

    /* renamed from: k, reason: collision with root package name */
    private Activity f20681k;

    /* renamed from: l, reason: collision with root package name */
    private List<ViewPager> f20682l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f20683m;

    public SwipBackLayout(Context context) {
        this(context, null);
    }

    public static SwipBackLayout a(Activity activity) {
        return new SwipBackLayout(activity);
    }

    private void c() {
        int scrollX = this.f20671a.getScrollX();
        this.f20676f.startScroll(this.f20671a.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void d() {
        int scrollX = this.f20677g + this.f20671a.getScrollX();
        this.f20676f.startScroll(this.f20671a.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs(scrollX));
        postInvalidate();
    }

    private void setContentView(View view) {
        this.f20671a = (View) view.getParent();
    }

    public boolean b() {
        return this.f20680j;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f20676f.computeScrollOffset()) {
            this.f20671a.scrollTo(this.f20676f.getCurrX(), this.f20676f.getCurrY());
            postInvalidate();
            if (this.f20676f.isFinished() && this.f20679i) {
                this.f20681k.finish();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View view;
        super.dispatchDraw(canvas);
        if (this.f20683m == null || (view = this.f20671a) == null) {
            return;
        }
        int left = view.getLeft() - this.f20683m.getIntrinsicWidth();
        this.f20683m.setBounds(left, this.f20671a.getTop(), this.f20683m.getIntrinsicWidth() + left, this.f20671a.getBottom());
        this.f20683m.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f20680j) {
            return false;
        }
        ViewPager viewPagerA = a(this.f20682l, motionEvent);
        if (viewPagerA != null && viewPagerA.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int rawX = (int) motionEvent.getRawX();
            this.f20675e = rawX;
            this.f20673c = rawX;
            this.f20674d = (int) motionEvent.getRawY();
        } else if (action == 2 && ((int) motionEvent.getRawX()) - this.f20673c > this.f20672b && Math.abs(((int) motionEvent.getRawY()) - this.f20674d) < this.f20672b) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            this.f20677g = getWidth();
            a(this.f20682l, this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f20680j) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            this.f20678h = false;
            if (this.f20671a.getScrollX() <= (-this.f20677g) / 2) {
                this.f20679i = true;
                d();
            } else {
                c();
                this.f20679i = false;
            }
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int i2 = this.f20675e - rawX;
            this.f20675e = rawX;
            if (rawX - this.f20673c > this.f20672b && Math.abs(((int) motionEvent.getRawY()) - this.f20674d) < this.f20672b) {
                this.f20678h = true;
            }
            if (rawX - this.f20673c >= 0 && this.f20678h) {
                this.f20671a.scrollBy(i2, 0);
            }
        }
        return true;
    }

    public void setInterEvent(boolean z) {
        this.f20680j = z;
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) this.f20681k.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    public SwipBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20680j = false;
        this.f20682l = new LinkedList();
        this.f20681k = (Activity) context;
        this.f20672b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f20676f = new Scroller(context);
        this.f20683m = getResources().getDrawable(R.drawable.swip_left_shadow);
    }

    private void a(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(list, (ViewGroup) childAt);
            }
        }
    }

    private ViewPager a(List<ViewPager> list, MotionEvent motionEvent) {
        if (list != null && list.size() != 0) {
            Rect rect = new Rect();
            for (ViewPager viewPager : list) {
                viewPager.getHitRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return viewPager;
                }
            }
        }
        return null;
    }
}
