package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bean.module.BottomLocalBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomBar extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private List<BottomBarTab> f20268a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f20269b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout.LayoutParams f20270c;

    /* renamed from: d, reason: collision with root package name */
    private int f20271d;

    /* renamed from: e, reason: collision with root package name */
    private a f20272e;

    /* renamed from: f, reason: collision with root package name */
    private int f20273f;

    /* renamed from: g, reason: collision with root package name */
    private BottomBarTab f20274g;

    public interface a {
        void a(BottomLocalBean bottomLocalBean, int i2, int i3);
    }

    public BottomBar(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(1);
        this.f20269b = new LinearLayout(context);
        this.f20269b.setBackgroundColor(-1);
        this.f20269b.setOrientation(0);
        addView(this.f20269b, new LinearLayout.LayoutParams(-1, -1));
        this.f20270c = new LinearLayout.LayoutParams(0, -1);
        this.f20270c.weight = 1.0f;
    }

    public /* synthetic */ void b(int i2) {
        for (int i3 = 0; i3 < this.f20273f; i3++) {
            this.f20269b.getChildAt(i3).setSelected(false);
        }
        this.f20271d = i2;
        this.f20269b.getChildAt(i2).setSelected(true);
    }

    public int getCurrentItemPosition() {
        return this.f20271d;
    }

    public void setCurrentItem(final int i2) {
        this.f20269b.post(new Runnable() { // from class: ui.view.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f20482a.b(i2);
            }
        });
    }

    public void setCurrentPosition(int i2) {
        this.f20271d = i2;
    }

    public void setOnTabSelectedListener(a aVar) {
        this.f20272e = aVar;
    }

    public BottomBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20268a = new ArrayList();
        this.f20271d = 0;
        a(context);
    }

    public void a() {
        this.f20273f = 3;
        this.f20268a.clear();
        this.f20269b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f20273f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2);
            a(bottomBarTab, (BottomLocalBean) null);
            a(i2, bottomBarTab);
        }
    }

    public void a(BottomLocalBean bottomLocalBean) {
        this.f20273f = 4;
        this.f20268a.clear();
        this.f20269b.removeAllViews();
        invalidate();
        for (int i2 = 0; i2 < this.f20273f; i2++) {
            BottomBarTab bottomBarTab = new BottomBarTab(getContext(), i2, bottomLocalBean);
            a(bottomBarTab, bottomLocalBean);
            a(i2, bottomBarTab);
        }
    }

    private void a(int i2, BottomBarTab bottomBarTab) {
        if (i2 == this.f20273f - 1) {
            this.f20274g = bottomBarTab;
        }
    }

    public void a(boolean z) {
        BottomBarTab bottomBarTab = this.f20274g;
        if (bottomBarTab != null) {
            bottomBarTab.a(z);
        }
    }

    public void a(final BottomBarTab bottomBarTab, final BottomLocalBean bottomLocalBean) {
        bottomBarTab.setOnClickListener(new View.OnClickListener() { // from class: ui.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20479a.a(bottomBarTab, bottomLocalBean, view);
            }
        });
        bottomBarTab.a(this.f20269b.getChildCount(), this.f20271d);
        bottomBarTab.setLayoutParams(this.f20270c);
        this.f20269b.addView(bottomBarTab);
        this.f20268a.add(bottomBarTab);
    }

    public /* synthetic */ void a(BottomBarTab bottomBarTab, BottomLocalBean bottomLocalBean, View view) {
        int tabPosition;
        int i2;
        if (this.f20272e == null || (i2 = this.f20271d) == (tabPosition = bottomBarTab.getTabPosition())) {
            return;
        }
        if (bottomLocalBean != null) {
            this.f20272e.a(bottomLocalBean, tabPosition, i2);
        } else {
            this.f20272e.a(null, tabPosition, this.f20273f);
        }
        bottomBarTab.setSelected(true);
        this.f20268a.get(this.f20271d).setSelected(false);
        this.f20271d = tabPosition;
    }

    public BottomBarTab a(int i2) {
        if (this.f20268a.size() < i2) {
            return null;
        }
        return this.f20268a.get(i2);
    }
}
