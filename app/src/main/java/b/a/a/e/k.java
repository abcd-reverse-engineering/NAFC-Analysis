package b.a.a.e;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.media.MediaDescriptionCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;

/* compiled from: WheelPicker.java */
/* loaded from: classes.dex */
public abstract class k extends b.a.a.f.b<View> {
    protected float I;
    protected int J;
    protected int K;
    protected Typeface L;
    protected int M;
    protected int N;
    protected int O;
    protected int b0;
    protected boolean c0;
    protected boolean d0;
    protected boolean e0;
    protected WheelView.c f0;

    public k(Activity activity) {
        super(activity);
        this.I = 2.0f;
        this.J = -1;
        this.K = 16;
        this.L = Typeface.DEFAULT;
        this.M = WheelView.i0;
        this.N = WheelView.h0;
        this.O = WheelView.h0;
        this.b0 = 3;
        this.c0 = true;
        this.d0 = true;
        this.e0 = true;
        this.f0 = new WheelView.c();
    }

    public void A(@ColorInt int i2) {
        this.N = i2;
    }

    public void B(int i2) {
        this.J = i2;
    }

    public void C(int i2) {
        this.K = i2;
    }

    public void a(float f2) {
        if (this.f0 == null) {
            this.f0 = new WheelView.c();
        }
        this.f0.a(f2);
    }

    public final void b(@FloatRange(from = 2.0d, to = 4.0d) float f2) {
        this.I = f2;
    }

    public void c(@ColorInt int i2, @IntRange(from = 1, to = 255) int i3) {
        if (this.f0 == null) {
            this.f0 = new WheelView.c();
        }
        this.f0.d(i2);
        this.f0.c(i3);
    }

    public void d(@ColorInt int i2, @ColorInt int i3) {
        this.N = i2;
        this.M = i3;
    }

    public void i(boolean z) {
        this.c0 = z;
    }

    public void j(boolean z) {
        if (this.f0 == null) {
            this.f0 = new WheelView.c();
        }
        this.f0.b(z);
    }

    @Deprecated
    public void k(boolean z) {
        j(z);
    }

    public void l(boolean z) {
        if (this.f0 == null) {
            this.f0 = new WheelView.c();
        }
        this.f0.a(z);
    }

    public void m(boolean z) {
        this.e0 = z;
    }

    public void n(boolean z) {
        this.d0 = z;
    }

    public void u(@ColorInt int i2) {
        if (this.f0 == null) {
            this.f0 = new WheelView.c();
        }
        this.f0.b(true);
        this.f0.b(i2);
    }

    public void v(int i2) {
        this.O = i2;
    }

    @Deprecated
    public void w(@ColorInt int i2) {
        u(i2);
    }

    public void x(@IntRange(from = 1, to = MediaDescriptionCompat.BT_FOLDER_TYPE_PLAYLISTS) int i2) {
        this.b0 = i2;
    }

    @Deprecated
    public void y(int i2) {
        this.J = i2;
    }

    public void z(@ColorInt int i2) {
        c(i2, 100);
    }

    @Deprecated
    public void b(WheelView.c cVar) {
        a(cVar);
    }

    protected TextView w() {
        TextView textView = new TextView(this.f2289a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextColor(this.O);
        textView.setTextSize(this.K);
        return textView;
    }

    protected WheelView x() {
        WheelView wheelView = new WheelView(this.f2289a);
        wheelView.setLineSpaceMultiplier(this.I);
        wheelView.setTextPadding(this.J);
        wheelView.setTextSize(this.K);
        wheelView.setTypeface(this.L);
        wheelView.a(this.M, this.N);
        wheelView.setDividerConfig(this.f0);
        wheelView.setOffset(this.b0);
        wheelView.setCycleDisable(this.c0);
        wheelView.setUseWeight(this.d0);
        wheelView.setTextSizeAutoFit(this.e0);
        return wheelView;
    }

    public void a(@Nullable WheelView.c cVar) {
        if (cVar == null) {
            this.f0 = new WheelView.c();
            this.f0.b(false);
            this.f0.a(false);
            return;
        }
        this.f0 = cVar;
    }

    @Override // b.a.a.f.a
    public View c() {
        if (this.G == null) {
            this.G = r();
        }
        return this.G;
    }
}
