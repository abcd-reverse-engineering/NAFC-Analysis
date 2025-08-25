package ui.view.drag;

import android.content.Context;
import android.view.View;

/* compiled from: Child.java */
/* loaded from: classes2.dex */
public class a implements ui.view.drag.e.a {

    /* renamed from: a, reason: collision with root package name */
    public int f20519a;

    /* renamed from: b, reason: collision with root package name */
    public View f20520b;

    /* renamed from: d, reason: collision with root package name */
    private int f20522d;

    /* renamed from: e, reason: collision with root package name */
    private int f20523e;

    /* renamed from: g, reason: collision with root package name */
    private HandyGridView f20525g;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20524f = false;

    /* renamed from: c, reason: collision with root package name */
    private ui.view.drag.e.c f20521c = new ui.view.drag.e.c(this);

    public a(View view) {
        this.f20520b = view;
    }

    public void a(HandyGridView handyGridView) {
        this.f20525g = handyGridView;
    }

    public void b() {
        this.f20521c.b();
        this.f20524f = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a) && this.f20520b == ((a) obj).f20520b) {
            return true;
        }
        return super.equals(obj);
    }

    @Override // ui.view.drag.e.a
    public Context getContext() {
        return this.f20520b.getContext();
    }

    @Override // ui.view.drag.e.a
    public boolean post(Runnable runnable) {
        return this.f20520b.post(runnable);
    }

    @Override // ui.view.drag.e.a
    public boolean removeCallbacks(Runnable runnable) {
        return this.f20520b.removeCallbacks(runnable);
    }

    public void a(int i2, int i3) {
        this.f20522d = i2;
        this.f20523e = i3;
        int[] iArrA = this.f20525g.a(i2);
        int[] iArrA2 = this.f20525g.a(i3);
        if (this.f20521c.e()) {
            this.f20524f = true;
        } else {
            b(iArrA2[0] - iArrA[0], iArrA2[1] - iArrA[1]);
        }
    }

    private void b(int i2, int i3) {
        this.f20521c.a(i2, i3);
    }

    @Override // ui.view.drag.e.a
    public void a() {
        int[] iArr = {this.f20520b.getLeft(), this.f20520b.getTop()};
        this.f20522d = this.f20525g.pointToPosition(iArr[0], iArr[1]);
        int[] iArrA = this.f20525g.a(this.f20523e);
        if (this.f20524f) {
            if (this.f20522d != this.f20523e) {
                b(iArrA[0] - iArr[0], iArrA[1] - iArr[1]);
            }
            this.f20524f = false;
        }
    }

    @Override // ui.view.drag.e.a
    public void a(int i2, int i3, int i4, int i5) {
        this.f20520b.offsetLeftAndRight(i4 - i2);
        this.f20520b.offsetTopAndBottom(i5 - i3);
    }
}
