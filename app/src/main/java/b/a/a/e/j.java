package b.a.a.e;

import android.app.Activity;
import b.a.a.e.d;

/* compiled from: TimePicker.java */
/* loaded from: classes.dex */
public class j extends b.a.a.e.d {

    /* compiled from: TimePicker.java */
    class a implements d.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2283a;

        a(d dVar) {
            this.f2283a = dVar;
        }

        @Override // b.a.a.e.d.l
        public void a(int i2, String str) {
            this.f2283a.a(i2, str);
        }

        @Override // b.a.a.e.d.l
        public void b(int i2, String str) {
        }

        @Override // b.a.a.e.d.l
        public void c(int i2, String str) {
            this.f2283a.c(i2, str);
        }

        @Override // b.a.a.e.d.l
        public void d(int i2, String str) {
        }

        @Override // b.a.a.e.d.l
        public void e(int i2, String str) {
        }
    }

    /* compiled from: TimePicker.java */
    class b implements d.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2285a;

        b(c cVar) {
            this.f2285a = cVar;
        }

        @Override // b.a.a.e.d.k
        public void a(String str, String str2) {
            this.f2285a.a(str, str2);
        }
    }

    /* compiled from: TimePicker.java */
    public interface c {
        void a(String str, String str2);
    }

    /* compiled from: TimePicker.java */
    public interface d {
        void a(int i2, String str);

        void c(int i2, String str);
    }

    public j(Activity activity) {
        this(activity, 3);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void a(String str, String str2, String str3, String str4, String str5) {
        super.a(str, str2, str3, str4, str5);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void b(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void e(int i2, int i3) {
        throw new UnsupportedOperationException("Data range nonsupport");
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void f(int i2, int i3) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // b.a.a.e.d
    @Deprecated
    public void g(int i2, int i3) {
        super.i(i2, 0);
        super.h(i3, 59);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public void h(int i2, int i3) {
        super.h(i2, i3);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public void i(int i2, int i3) {
        super.i(i2, i3);
    }

    public void j(int i2, int i3) {
        super.h(i2, i3);
    }

    public void k(int i2, int i3) {
        super.i(i2, i3);
    }

    public void l(int i2, int i3) {
        super.a(0, 0, i2, i3);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void setOnDateTimePickListener(d.h hVar) {
        super.setOnDateTimePickListener(hVar);
    }

    public void setOnTimePickListener(c cVar) {
        if (cVar == null) {
            return;
        }
        super.setOnDateTimePickListener(new b(cVar));
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void setOnWheelListener(d.l lVar) {
        super.setOnWheelListener(lVar);
    }

    public j(Activity activity, int i2) {
        super(activity, -1, i2);
    }

    public void a(String str, String str2) {
        super.a("", "", "", str, str2);
    }

    public void setOnWheelListener(d dVar) {
        if (dVar == null) {
            return;
        }
        super.setOnWheelListener(new a(dVar));
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        super.a(i2, i3, i4, i5, i6);
    }

    @Override // b.a.a.e.d
    @Deprecated
    public final void a(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
    }
}
