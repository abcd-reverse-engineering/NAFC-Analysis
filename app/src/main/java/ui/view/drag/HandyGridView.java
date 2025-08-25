package ui.view.drag;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

/* loaded from: classes2.dex */
public class HandyGridView extends GridView implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, ui.view.drag.e.a {
    private AdapterView.OnItemClickListener A;
    private boolean B;
    private boolean C;
    private boolean D;
    private b E;
    private Drawable F;
    private Drawable G;
    private ui.view.drag.d.a H;
    private boolean I;
    private ui.view.drag.d.b J;

    /* renamed from: a, reason: collision with root package name */
    private int f20495a;

    /* renamed from: b, reason: collision with root package name */
    private int f20496b;

    /* renamed from: c, reason: collision with root package name */
    private int f20497c;

    /* renamed from: d, reason: collision with root package name */
    private int f20498d;

    /* renamed from: e, reason: collision with root package name */
    private float f20499e;

    /* renamed from: f, reason: collision with root package name */
    private float f20500f;

    /* renamed from: g, reason: collision with root package name */
    private ui.view.drag.b f20501g;

    /* renamed from: h, reason: collision with root package name */
    private int f20502h;

    /* renamed from: i, reason: collision with root package name */
    private AdapterView.OnItemLongClickListener f20503i;

    /* renamed from: j, reason: collision with root package name */
    private AbsListView.OnScrollListener f20504j;

    /* renamed from: k, reason: collision with root package name */
    private ui.view.drag.e.c f20505k;

    /* renamed from: l, reason: collision with root package name */
    private int f20506l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f20507m;
    private Rect n;
    private MotionEvent o;
    private ListAdapter p;
    private ui.view.drag.e.b q;
    private View r;
    private int s;
    private Rect t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i3 != 0) {
                HandyGridView.this.f20498d = i2;
                HandyGridView.this.b(i2);
                if (HandyGridView.this.f20504j != null) {
                    HandyGridView.this.f20504j.onScroll(absListView, i2, i3, i4);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (HandyGridView.this.f20504j != null) {
                HandyGridView.this.f20504j.onScrollStateChanged(absListView, i2);
            }
        }
    }

    public enum b {
        TOUCH,
        LONG_PRESS,
        NONE;

        public static b get(int i2) {
            int i3 = 0;
            for (b bVar : values()) {
                if (i3 == i2) {
                    return bVar;
                }
                i3++;
            }
            return null;
        }

        public static int indexOf(b bVar) {
            int i2 = -1;
            for (b bVar2 : values()) {
                i2++;
                if (bVar == bVar2) {
                    break;
                }
            }
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
        @Override // java.lang.Enum
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r5 = this;
                java.lang.String r0 = r5.name()
                int r1 = r0.hashCode()
                r2 = 2402104(0x24a738, float:3.366065E-39)
                r3 = 2
                r4 = 1
                if (r1 == r2) goto L2e
                r2 = 80013087(0x4c4e71f, float:4.629163E-36)
                if (r1 == r2) goto L24
                r2 = 1074528416(0x400c00a0, float:2.1875381)
                if (r1 == r2) goto L1a
                goto L38
            L1a:
                java.lang.String r1 = "LONG_PRESS"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L38
                r0 = 1
                goto L39
            L24:
                java.lang.String r1 = "TOUCH"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L38
                r0 = 0
                goto L39
            L2e:
                java.lang.String r1 = "NONE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L38
                r0 = 2
                goto L39
            L38:
                r0 = -1
            L39:
                if (r0 == 0) goto L4a
                if (r0 == r4) goto L47
                if (r0 == r3) goto L44
                java.lang.String r0 = super.toString()
                return r0
            L44:
                java.lang.String r0 = "普通模式"
                return r0
            L47:
                java.lang.String r0 = "长按拖拽模式"
                return r0
            L4a:
                java.lang.String r0 = "编辑模式"
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ui.view.drag.HandyGridView.b.toString():java.lang.String");
        }
    }

    public HandyGridView(Context context) {
        this(context, null);
    }

    private void a(String str) {
    }

    private void e(int i2) {
        this.f20501g.b(i2);
    }

    private int getMotionPosition() {
        return pointToPosition((int) (this.o.getRawX() - this.n.left), (int) (this.o.getRawY() - this.n.top));
    }

    private void h() {
        this.f20501g.a();
    }

    private void i() {
        if (this.J == null || d(this.z)) {
            return;
        }
        this.J.b(this.r, this.z);
    }

    private void j() {
        if (this.J == null || d(this.z)) {
            return;
        }
        this.J.a(this.r, this.z);
    }

    private boolean k() {
        Rect rect = this.n;
        Rect rect2 = this.t;
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    private void l() {
        this.r.getGlobalVisibleRect(this.t);
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        Rect rect = this.t;
        rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.t.height());
    }

    private void m() {
        if (this.n == null) {
            this.n = new Rect();
            getGlobalVisibleRect(this.n);
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Rect rect = this.n;
            rect.set(iArr[0], iArr[1], iArr[0] + rect.width(), iArr[1] + this.n.height());
        }
    }

    private void n() {
        int childCount = getChildCount();
        h();
        for (int i2 = 0; i2 < childCount; i2++) {
            a(i2, super.getChildAt(i2));
        }
    }

    private void o() {
        int[] iArrA = a(this.z);
        int left = iArrA[0] - this.r.getLeft();
        int top = iArrA[1] - this.r.getTop();
        this.r.offsetLeftAndRight(left);
        this.r.offsetTopAndBottom(top);
        j();
        if (this.r.isPressed()) {
            this.r.setPressed(false);
        }
    }

    @TargetApi(19)
    private void p() {
        int totalScrollY;
        int listPaddingBottom;
        l();
        m();
        if (!k()) {
            this.f20505k.b();
            return;
        }
        Rect rect = this.t;
        int i2 = rect.top;
        Rect rect2 = this.n;
        if (i2 <= rect2.top) {
            if (!b() || this.f20505k.e()) {
                return;
            }
            int listPaddingTop = this.f20507m ? this.f20495a : this.f20495a - getListPaddingTop();
            this.f20505k.a(0, listPaddingTop, (Math.abs(listPaddingTop) * 1000) / this.f20506l);
            return;
        }
        if (rect.bottom < rect2.bottom) {
            this.f20505k.b();
            return;
        }
        if (!c() || this.f20505k.e()) {
            return;
        }
        if (this.f20507m) {
            totalScrollY = getTotalScrollY();
            listPaddingBottom = this.f20495a;
        } else {
            totalScrollY = getTotalScrollY() + this.f20495a;
            listPaddingBottom = getListPaddingBottom();
        }
        int i3 = totalScrollY + listPaddingBottom;
        this.f20505k.a(0, i3, (Math.abs(i3) * 1000) / this.f20506l);
    }

    @Override // ui.view.drag.e.a
    public void a() {
    }

    @Override // android.view.ViewGroup
    protected void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.attachViewToParent(view, i2, layoutParams);
        a(i2, view);
    }

    public boolean c() {
        return getTotalScrollY() > (-(this.f20507m ? -this.f20495a : getListPaddingBottom()));
    }

    public boolean d() {
        return this.E == b.LONG_PRESS;
    }

    @Override // android.view.ViewGroup
    protected void detachAllViewsFromParent() {
        super.detachAllViewsFromParent();
        h();
    }

    @Override // android.view.ViewGroup
    protected void detachViewsFromParent(int i2, int i3) {
        super.detachViewsFromParent(i2, i3);
        if (i2 == 0) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                e(0);
            }
            return;
        }
        int iB = this.f20501g.b() - 1;
        for (int i5 = iB; i5 > iB - i3; i5--) {
            e(i5);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!this.I) {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (this.I) {
            a(canvas);
        }
    }

    public boolean f() {
        return this.C;
    }

    public boolean g() {
        if ((b() || c()) && this.D) {
            this.E = b.LONG_PRESS;
        }
        return this.E == b.TOUCH;
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i2) {
        int childCount = getChildCount();
        if (this.r != null) {
            int i3 = this.z - this.f20498d;
            if (i3 != 0) {
                int i4 = childCount - 1;
                if (i3 == i4 && childCount % this.w != 1) {
                    if (i2 == i4) {
                        i2--;
                    } else if (i2 == childCount - 2) {
                        i2 = i4;
                    }
                }
            } else if (i2 == 0) {
                i2 = 1;
            } else if (i2 == 1) {
                i2 = 0;
            }
        }
        if (i2 >= getChildCount()) {
            i2 = getChildCount() - 1;
        }
        return super.getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return super.getChildCount();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.r == null) {
            return i3;
        }
        this.s = this.z - this.f20498d;
        int i4 = this.s;
        return i3 == i4 ? i2 - 1 : i3 == i2 + (-1) ? i4 : i3;
    }

    public int getDragPosition() {
        return this.z;
    }

    public b getMode() {
        return this.E;
    }

    public int getTotalScrollY() {
        if (this.p == null) {
            return 0;
        }
        int count = ((r0.getCount() - 1) / this.w) + 1;
        return ((this.v * count) + ((count - 1) * this.y)) - getHeight();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        if (this.r == null) {
            n();
            return;
        }
        n();
        View childAt = super.getChildAt(this.z - this.f20498d);
        j();
        this.r = childAt;
        i();
        a(0, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AdapterView.OnItemClickListener onItemClickListener = this.A;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i2, j2);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        boolean z;
        if (!d() || d(i2)) {
            z = false;
        } else {
            a(view, i2);
            z = true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f20503i;
        if (onItemLongClickListener != null) {
            boolean zOnItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i2, j2);
            if (!z) {
                return zOnItemLongClick;
            }
        }
        return z;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.n = null;
        m();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return a(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        a(indexOfChild(view), view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        a(view);
    }

    @Override // android.widget.AbsListView
    public int pointToPosition(int i2, int i3) {
        int i4;
        int i5 = this.u;
        int i6 = this.x;
        if (i5 + i6 > 0) {
            int i7 = this.v;
            int i8 = this.y;
            if (i7 + i8 != 0) {
                int i9 = this.f20497c;
                int i10 = (i2 - i9) / (i5 + i6);
                int i11 = this.f20496b;
                int i12 = (i3 - i11) / (i7 + i8);
                int i13 = i11 + ((i12 + 1) * (i8 + i7)) + i7;
                if (i2 <= i9 + ((i10 + 1) * (i5 + i6)) && i3 <= i13 && i10 < (i4 = this.w)) {
                    int i14 = this.f20498d + (i12 * i4) + i10;
                    if (i14 <= getLastVisiblePosition()) {
                        return i14;
                    }
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override // android.widget.AbsListView
    @TargetApi(19)
    public void scrollListBy(int i2) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 19) {
            super.scrollListBy(i2);
            return;
        }
        int i3 = -i2;
        Object[] objArr = {Integer.valueOf(i3), Integer.valueOf(i3)};
        Class cls = Integer.TYPE;
        c.a(this, "trackMotionScroll", objArr, new Class[]{cls, cls});
    }

    public void setAutoOptimize(boolean z) {
        this.D = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.f20507m = z;
    }

    @Override // android.widget.GridView
    public void setHorizontalSpacing(int i2) {
        super.setHorizontalSpacing(i2);
        this.x = i2;
    }

    public void setMode(b bVar) {
        this.E = bVar;
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i2) {
        super.setNumColumns(i2);
        this.w = i2;
    }

    public void setOnItemCapturedListener(ui.view.drag.d.b bVar) {
        this.J = bVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f20503i = onItemLongClickListener;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f20504j = onScrollListener;
    }

    public void setScrollSpeed(int i2) {
        this.f20506l = i2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        if (this.C) {
            super.setSelector(drawable);
            return;
        }
        this.F = drawable;
        if (this.G == null) {
            this.G = new ColorDrawable();
        }
        super.setSelector(this.G);
    }

    public void setSelectorEnabled(boolean z) {
        Drawable drawable;
        if (z != this.C) {
            this.C = z;
            if (this.C && (drawable = this.F) != null) {
                setSelector(drawable);
            }
            if (this.C) {
                return;
            }
            setSelector(getSelector());
        }
    }

    @Override // android.widget.GridView
    public void setVerticalSpacing(int i2) {
        super.setVerticalSpacing(i2);
        this.y = i2;
    }

    public HandyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20498d = -1;
        this.f20506l = 750;
        this.f20507m = false;
        this.s = -1;
        this.t = new Rect();
        this.z = -1;
        this.B = false;
        this.C = false;
        this.D = true;
        this.E = b.TOUCH;
        this.I = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        View childAt = getChildAt(0);
        this.f20497c = getListPaddingLeft();
        this.f20496b = childAt.getTop();
        this.u = childAt.getWidth();
        this.v = childAt.getHeight();
        this.f20495a = this.f20496b - ((i2 / this.w) * (this.y + this.v));
    }

    private boolean d(int i2) {
        if (i2 != -1) {
            ListAdapter listAdapter = this.p;
            if (listAdapter instanceof ui.view.drag.e.b) {
                this.q = (ui.view.drag.e.b) listAdapter;
                if (this.q.a(i2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean e() {
        return this.E == b.NONE;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        this.p = listAdapter;
        if (listAdapter instanceof ui.view.drag.e.b) {
            this.q = (ui.view.drag.e.b) listAdapter;
        } else {
            a("Your adapter should implements OnItemMovedListener for listening  item's swap action.");
        }
        super.setAdapter(this.p);
    }

    private void a(Context context) {
        this.f20505k = new ui.view.drag.e.c(this, new AccelerateDecelerateInterpolator());
        setChildrenDrawingOrderEnabled(true);
        super.setOnItemLongClickListener(this);
        super.setOnItemClickListener(this);
        setOverScrollMode(2);
        this.f20502h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f20501g = new ui.view.drag.b(this);
        super.setOnScrollListener(new a());
    }

    private void c(int i2, int i3) {
        ui.view.drag.a aVarA = this.f20501g.a(i2 - getFirstVisiblePosition());
        View view = aVarA.f20520b;
        if (aVarA == null || view == null) {
            return;
        }
        aVarA.a(i2, i3);
        b(i3, view);
        b(i2, i3);
        detachViewFromParent(view);
        super.attachViewToParent(view, i3 - getFirstVisiblePosition(), view.getLayoutParams());
    }

    public boolean b() {
        return this.f20495a < (this.f20507m ? 0 : getListPaddingTop());
    }

    private void b(MotionEvent motionEvent) {
        int dragPosition;
        if (motionEvent == null || this.r == null || d(this.z)) {
            return;
        }
        m();
        l();
        int iPointToPosition = pointToPosition((int) (motionEvent.getRawX() - this.n.left), (int) (motionEvent.getRawY() - this.n.top));
        boolean zK = k();
        if (iPointToPosition == -1 || !zK) {
            iPointToPosition = -1;
        }
        if (d(iPointToPosition)) {
            iPointToPosition = -1;
        }
        if (iPointToPosition == -1 || iPointToPosition == (dragPosition = getDragPosition())) {
            return;
        }
        l();
        if (iPointToPosition >= dragPosition) {
            while (true) {
                dragPosition++;
                if (dragPosition > iPointToPosition) {
                    break;
                } else {
                    c(dragPosition, dragPosition - 1);
                }
            }
        } else {
            for (int i2 = dragPosition - 1; i2 >= iPointToPosition; i2--) {
                c(i2, i2 + 1);
            }
        }
        b(iPointToPosition, this.r);
        this.z = iPointToPosition;
    }

    private int c(int i2) {
        return i2 - this.f20498d;
    }

    public void a(ui.view.drag.d.a aVar, boolean z) {
        this.H = aVar;
        this.I = z;
    }

    private void a(int i2, View view) {
        if (i2 < 0) {
            i2 = this.f20501g.b();
        }
        this.f20501g.a(i2, view);
    }

    private boolean a(View view) {
        int iB = this.f20501g.b();
        for (int i2 = 0; i2 < iB; i2++) {
            ui.view.drag.a aVarA = this.f20501g.a(i2);
            if (aVarA.f20520b == view) {
                return this.f20501g.a(aVarA);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r6.o = r7
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L67
            if (r0 == r3) goto L55
            r4 = 2
            if (r0 == r4) goto L15
            r4 = 3
            if (r0 == r4) goto L55
            goto L89
        L15:
            float r0 = r7.getRawX()
            float r1 = r6.f20499e
            float r0 = r0 - r1
            int r0 = (int) r0
            float r1 = r7.getRawY()
            float r4 = r6.f20500f
            float r1 = r1 - r4
            int r1 = (int) r1
            android.view.View r4 = r6.r
            if (r4 == 0) goto L89
            boolean r5 = r6.B
            if (r5 != 0) goto L3a
            boolean r4 = r4.isPressed()
            if (r4 == 0) goto L38
            android.view.View r4 = r6.r
            r4.setPressed(r2)
        L38:
            r6.B = r3
        L3a:
            boolean r2 = r6.B
            if (r2 == 0) goto L47
            r6.a(r0, r1)
            r6.b(r7)
            r6.p()
        L47:
            float r0 = r7.getRawX()
            r6.f20499e = r0
            float r0 = r7.getRawY()
            r6.f20500f = r0
            r2 = 1
            goto L89
        L55:
            android.view.View r0 = r6.r
            if (r0 == 0) goto L62
            r6.o()
            ui.view.drag.e.c r0 = r6.f20505k
            r0.b()
            r2 = 1
        L62:
            r6.r = r1
            r6.o = r1
            goto L89
        L67:
            float r0 = r7.getRawX()
            r6.f20499e = r0
            float r0 = r7.getRawY()
            r6.f20500f = r0
            r6.B = r2
            boolean r0 = r6.g()
            if (r0 == 0) goto L89
            r0 = -1
            r6.a(r1, r0)
            r6.invalidate()
            android.view.View r0 = r6.r
            if (r0 == 0) goto L89
            r0.setPressed(r3)
        L89:
            boolean r0 = r6.g()
            if (r0 == 0) goto L90
            r2 = 1
        L90:
            if (r2 == 0) goto L93
            goto L97
        L93:
            boolean r2 = super.onTouchEvent(r7)
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.view.drag.HandyGridView.a(android.view.MotionEvent):boolean");
    }

    private void b(int i2, int i3) {
        ui.view.drag.e.b bVar = this.q;
        if (bVar != null) {
            bVar.a(i2, i3);
        }
    }

    private void b(int i2, View view) {
        a(view);
        a(c(i2), view);
    }

    private void a(View view, int i2) {
        m();
        if (view == null && i2 == -1) {
            int motionPosition = getMotionPosition();
            if (motionPosition != -1) {
                a(getChildAt(motionPosition - this.f20498d), motionPosition);
                return;
            }
            return;
        }
        this.z = i2;
        this.r = view;
        l();
        this.s = this.z - this.f20498d;
        i();
        a(0, 0);
    }

    private void a(Canvas canvas) {
        if (this.H != null) {
            canvas.save();
            this.H.a(canvas, getWidth(), getHeight());
            canvas.restore();
        }
    }

    @Override // ui.view.drag.e.a
    public void a(int i2, int i3, int i4, int i5) throws NoSuchMethodException, SecurityException {
        int i6 = i5 - i3;
        this.r.offsetTopAndBottom(i6);
        scrollListBy(i6);
        b(this.o);
    }

    public int[] a(int i2) {
        int i3 = this.w;
        return new int[]{this.f20497c + ((i2 % i3) * (this.u + this.x)), this.f20495a + ((i2 / i3) * (this.v + this.y))};
    }

    private void a(int i2, int i3) {
        MotionEvent motionEvent = this.o;
        if (motionEvent == null) {
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = this.o.getRawY();
        m();
        int left = ((int) ((rawX - this.n.left) - (this.r.getLeft() + (this.u / 2)))) + i2;
        int top = ((int) ((rawY - this.n.top) - (this.r.getTop() + (this.v / 2)))) + i3;
        if (d(this.z)) {
            return;
        }
        this.r.offsetLeftAndRight(left);
        this.r.offsetTopAndBottom(top);
    }
}
