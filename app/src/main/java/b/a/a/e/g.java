package b.a.a.e;

import android.app.Activity;
import b.a.a.e.h;
import b.a.a.e.i;

/* compiled from: NumberPicker.java */
/* loaded from: classes.dex */
public class g extends i<Number> {

    /* compiled from: NumberPicker.java */
    class a extends b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a f2280a;

        a(h.a aVar) {
            this.f2280a = aVar;
        }

        @Override // b.a.a.e.g.b
        public void b(int i2, Number number) {
            this.f2280a.b(i2, number.toString());
        }
    }

    /* compiled from: NumberPicker.java */
    public static abstract class b implements i.b<Number> {
        public abstract void b(int i2, Number number);

        @Override // b.a.a.e.i.b
        public final void a(int i2, Number number) {
            b(i2, number);
        }
    }

    /* compiled from: NumberPicker.java */
    public interface c extends i.c<Number> {
    }

    public g(Activity activity) {
        super(activity, new Number[0]);
    }

    public void F(int i2) {
        super.c((g) Integer.valueOf(i2));
    }

    public void a(int i2, int i3, int i4) {
        while (i2 <= i3) {
            a((g) Integer.valueOf(i2));
            i2 += i4;
        }
    }

    public void e(int i2, int i3) {
        a(i2, i3, 1);
    }

    public void setOnNumberPickListener(b bVar) {
        super.setOnItemPickListener(bVar);
    }

    @Deprecated
    public void setOnOptionPickListener(h.a aVar) {
        setOnNumberPickListener(new a(aVar));
    }

    public void setOnWheelListener(c cVar) {
        super.setOnWheelListener((i.c) cVar);
    }

    public void a(double d2, double d3, double d4) {
        while (d2 <= d3) {
            a((g) Double.valueOf(d2));
            d2 += d4;
        }
    }

    public void a(double d2) {
        super.c((g) Double.valueOf(d2));
    }
}
