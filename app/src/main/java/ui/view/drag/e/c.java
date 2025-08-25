package ui.view.drag.e;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;

/* compiled from: ScrollRunner.java */
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Scroller f20529a;

    /* renamed from: b, reason: collision with root package name */
    private a f20530b;

    /* renamed from: c, reason: collision with root package name */
    private int f20531c;

    /* renamed from: d, reason: collision with root package name */
    private int f20532d;

    /* renamed from: e, reason: collision with root package name */
    private int f20533e;

    public c(a aVar) {
        this(aVar, new LinearInterpolator());
    }

    public void a(a aVar) {
        this.f20530b = aVar;
    }

    public void b() {
        if (this.f20529a.isFinished()) {
            return;
        }
        this.f20530b.removeCallbacks(this);
        this.f20529a.forceFinished(true);
    }

    public int c() {
        return this.f20529a.getCurrX();
    }

    public int d() {
        return this.f20529a.getCurrY();
    }

    public boolean e() {
        return !this.f20529a.isFinished();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f20529a.computeScrollOffset()) {
            this.f20530b.removeCallbacks(this);
            this.f20530b.a();
            return;
        }
        int currX = this.f20529a.getCurrX();
        int currY = this.f20529a.getCurrY();
        this.f20530b.a(this.f20532d, this.f20533e, currX, currY);
        this.f20532d = currX;
        this.f20533e = currY;
        if (currX != this.f20529a.getFinalX() || currY != this.f20529a.getFinalY()) {
            this.f20530b.post(this);
        } else {
            this.f20530b.removeCallbacks(this);
            this.f20530b.a();
        }
    }

    public c(a aVar, Interpolator interpolator) {
        this.f20531c = 250;
        this.f20530b = aVar;
        this.f20529a = new Scroller(aVar.getContext(), interpolator);
    }

    public void a(int i2, int i3) {
        a(i2, i3, this.f20531c);
    }

    public void a(int i2, int i3, int i4) {
        a(0, 0, i2, i3, i4);
    }

    public void a(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, this.f20531c);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        this.f20531c = i6;
        this.f20529a.startScroll(i2, i3, i4, i5, i6);
        this.f20530b.removeCallbacks(this);
        this.f20530b.post(this);
        this.f20532d = i2;
        this.f20533e = i3;
    }

    public void a() {
        if (this.f20529a.isFinished()) {
            return;
        }
        this.f20529a.abortAnimation();
    }
}
