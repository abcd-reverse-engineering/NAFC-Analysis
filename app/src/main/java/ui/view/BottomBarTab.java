package ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bean.module.BottomLocalBean;
import com.hicorenational.antifraud.R;
import manager.GrayManager;

/* loaded from: classes2.dex */
public class BottomBarTab extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f20275a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f20276b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f20277c;

    /* renamed from: d, reason: collision with root package name */
    private int f20278d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f20279e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f20280f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f20281g;

    public BottomBarTab(Context context, int i2) {
        super(context);
        this.f20278d = -1;
        this.f20279e = new String[]{"首页", "骗局曝光", "我的"};
        this.f20280f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_mine_unseled};
        this.f20281g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_mine_seled};
        a(context, i2);
    }

    private void a(Context context, int i2) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.f20275a = (ImageView) viewInflate.findViewById(R.id.iv_tab_bar);
        this.f20276b = (TextView) viewInflate.findViewById(R.id.tv_tab_bar);
        this.f20277c = (TextView) viewInflate.findViewById(R.id.red_tip);
        j.d.b(this.f20275a, Integer.valueOf(this.f20280f[i2]));
        this.f20276b.setText(this.f20279e[i2]);
    }

    public int getTabPosition() {
        return this.f20278d;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            this.f20275a.setImageResource(this.f20281g[this.f20278d]);
            this.f20276b.setTextColor(Color.parseColor("#2946E6"));
        } else {
            this.f20275a.setImageResource(this.f20280f[this.f20278d]);
            this.f20276b.setTextColor(Color.parseColor("#666666"));
        }
        if (this.f20278d == 0) {
            GrayManager.Companion.getInstance().setLayerGray(this);
        }
    }

    public BottomBarTab(Context context, int i2, BottomLocalBean bottomLocalBean) {
        super(context);
        this.f20278d = -1;
        this.f20279e = new String[]{"首页", "骗局曝光", "我的"};
        this.f20280f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_mine_unseled};
        this.f20281g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_mine_seled};
        a(context, i2, bottomLocalBean);
    }

    private void a(Context context, int i2, BottomLocalBean bottomLocalBean) {
        this.f20279e = new String[]{"首页", "骗局曝光", bottomLocalBean.getContent(), "我的"};
        this.f20280f = new int[]{R.mipmap.tab_home_unseled, R.mipmap.tab_xc_unseled, R.mipmap.tab_local_unseled, R.mipmap.tab_mine_unseled};
        this.f20281g = new int[]{R.mipmap.tab_home_seled, R.mipmap.tab_xc_seled, R.mipmap.tab_local_seled, R.mipmap.tab_mine_seled};
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.tab_bottom_bar, (ViewGroup) this, true);
        this.f20275a = (ImageView) viewInflate.findViewById(R.id.iv_tab_bar);
        this.f20276b = (TextView) viewInflate.findViewById(R.id.tv_tab_bar);
        this.f20277c = (TextView) viewInflate.findViewById(R.id.red_tip);
        j.d.b(this.f20275a, Integer.valueOf(this.f20280f[i2]));
        this.f20276b.setText(this.f20279e[i2]);
    }

    public void a(int i2, int i3) {
        this.f20278d = i2;
        if (i2 == i3) {
            setSelected(true);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.f20277c.setVisibility(0);
        } else {
            this.f20277c.setVisibility(4);
        }
    }
}
