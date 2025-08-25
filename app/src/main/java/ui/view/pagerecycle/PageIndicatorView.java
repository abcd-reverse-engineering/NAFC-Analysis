package ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import util.c1;

/* loaded from: classes2.dex */
public class PageIndicatorView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f20617a;

    /* renamed from: b, reason: collision with root package name */
    private int f20618b;

    /* renamed from: c, reason: collision with root package name */
    private int f20619c;

    /* renamed from: d, reason: collision with root package name */
    private int f20620d;

    /* renamed from: e, reason: collision with root package name */
    private int f20621e;

    /* renamed from: f, reason: collision with root package name */
    private int f20622f;

    /* renamed from: g, reason: collision with root package name */
    private List<View> f20623g;

    public PageIndicatorView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f20617a = context;
        this.f20618b = c1.a(context, this.f20618b);
        this.f20620d = c1.a(context, this.f20620d);
        this.f20619c = c1.a(context, this.f20619c);
    }

    public void setSelectedPage(int i2) {
        if (this.f20622f == 1) {
            setBackgroundResource(R.drawable.white_radius);
        } else {
            this.f20623g.get(0).setTranslationX(((this.f20618b - this.f20620d) / (r0 - 1)) * i2);
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20617a = null;
        this.f20618b = 25;
        this.f20619c = 4;
        this.f20620d = 12;
        this.f20621e = 4;
        this.f20623g = null;
        a(context);
    }

    public void a(int i2) {
        this.f20622f = i2;
        List<View> list = this.f20623g;
        if (list == null) {
            this.f20623g = new ArrayList();
        } else {
            list.clear();
            removeAllViews();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f20620d, this.f20619c);
        View view = new View(this.f20617a);
        view.setBackgroundResource(R.drawable.white_radius);
        addView(view, layoutParams);
        this.f20623g.add(view);
    }
}
