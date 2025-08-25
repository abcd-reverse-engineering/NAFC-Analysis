package ui.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.view.pagerecycle.PageIndicatorView;
import ui.view.pagerecycle.PageRecyclerView;
import ui.view.pagerecycle.PageRecyclerView.PageAdapter;

/* loaded from: classes2.dex */
public class ToolView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f19674a;

    /* renamed from: b, reason: collision with root package name */
    private PageRecyclerView f19675b;

    /* renamed from: c, reason: collision with root package name */
    private PageIndicatorView f19676c;

    /* renamed from: d, reason: collision with root package name */
    private List<HomeToolBean> f19677d;

    /* renamed from: e, reason: collision with root package name */
    private List<HomeToolBean> f19678e;

    /* renamed from: f, reason: collision with root package name */
    private PageRecyclerView.PageAdapter f19679f;

    /* renamed from: g, reason: collision with root package name */
    private b f19680g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f19681h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f19682i;

    public class Holder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private View f19683a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f19684b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f19685c;

        /* renamed from: d, reason: collision with root package name */
        private View f19686d;

        /* synthetic */ Holder(ToolView toolView, Context context, View view, a aVar) {
            this(context, view);
        }

        private Holder(Context context, View view) {
            super(view);
            this.f19683a = view.findViewById(R.id.ll_item);
            this.f19684b = (ImageView) view.findViewById(R.id.iv_icon);
            this.f19685c = (TextView) view.findViewById(R.id.tv_name);
            this.f19686d = view.findViewById(R.id.red_dot);
            view.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f19733a.a(view2);
                }
            });
        }

        public /* synthetic */ void a(View view) {
            int adapterPosition;
            if (!Hicore.getApp().isDouble() && ToolView.this.f19678e.size() > 0 && (adapterPosition = getAdapterPosition()) >= 0) {
                HomeToolBean homeToolBean = (HomeToolBean) ToolView.this.f19678e.get(adapterPosition);
                if (ToolView.this.f19680g == null || homeToolBean == null) {
                    return;
                }
                ToolView.this.f19680g.onClickToolItem(homeToolBean);
            }
        }
    }

    public interface b {
        void onClickToolItem(HomeToolBean homeToolBean);
    }

    public ToolView(Context context) {
        super(context);
        this.f19677d = new ArrayList();
        this.f19678e = new ArrayList();
        this.f19681h = null;
        this.f19682i = new int[]{R.drawable.iv_home_report, R.drawable.iv_home_case, R.drawable.iv_home_warn, R.drawable.iv_home_id_check};
        a();
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        if (regionMudelBean == null) {
            b();
            this.f19678e = this.f19677d;
        } else if (regionMudelBean.getTool() == null || regionMudelBean.getTool().size() <= 0) {
            setVisibility(8);
        } else {
            this.f19678e = regionMudelBean.getTool();
            for (int i2 = 0; i2 < this.f19678e.size(); i2++) {
                HomeToolBean homeToolBean = this.f19678e.get(i2);
                int iIndexOf = this.f19681h.indexOf(homeToolBean.getModule());
                if (iIndexOf > -1) {
                    homeToolBean.setLocalIcon(this.f19682i[iIndexOf]);
                } else {
                    int iIndexOf2 = this.f19681h.indexOf(homeToolBean.getId());
                    if (iIndexOf2 > -1) {
                        homeToolBean.setLocalIcon(this.f19682i[iIndexOf2]);
                    } else {
                        homeToolBean.setLocalIcon(R.drawable.iv_cricle_img_def);
                    }
                }
            }
        }
        this.f19675b.setIndicator(this.f19676c);
        this.f19675b.a(1, 4);
        this.f19679f = a(this.f19675b);
    }

    public void setItemClick(b bVar) {
        if (bVar != null) {
            this.f19680g = bVar;
        }
    }

    class a implements PageRecyclerView.a {
        a() {
        }

        @Override // ui.view.pagerecycle.PageRecyclerView.a
        public RecyclerView.ViewHolder a(ViewGroup viewGroup, int i2) {
            View viewInflate = LayoutInflater.from(ToolView.this.f19674a).inflate(R.layout.item_tool, viewGroup, false);
            ToolView toolView = ToolView.this;
            return new Holder(toolView, toolView.f19674a, viewInflate, null);
        }

        @Override // ui.view.pagerecycle.PageRecyclerView.a
        public void a(RecyclerView.ViewHolder viewHolder, int i2) {
            HomeToolBean homeToolBean;
            if (ToolView.this.f19678e.size() <= 0 || (homeToolBean = (HomeToolBean) ToolView.this.f19678e.get(i2)) == null) {
                return;
            }
            Holder holder = (Holder) viewHolder;
            holder.f19683a.setVisibility(0);
            holder.f19685c.setText(homeToolBean.getContent());
            j.d.b(homeToolBean.getImage(), holder.f19684b, Integer.valueOf(homeToolBean.getLocalIcon()));
            if (homeToolBean.isHasRedDot()) {
                holder.f19686d.setVisibility(0);
            } else {
                holder.f19686d.setVisibility(8);
            }
        }
    }

    private void a() {
        this.f19674a = getContext();
        this.f19681h = new ArrayList<>();
        this.f19681h.add(ModuelConfig.MODEL_REPORT);
        this.f19681h.add(ModuelConfig.MODEL_CASEXC);
        this.f19681h.add(ModuelConfig.MODEL_WARN);
        this.f19681h.add(ModuelConfig.MODEL_IDVERIFY);
        View viewInflate = LayoutInflater.from(this.f19674a).inflate(R.layout.view_tools, (ViewGroup) this, true);
        this.f19675b = (PageRecyclerView) viewInflate.findViewById(R.id.page_recyclerview);
        this.f19676c = (PageIndicatorView) viewInflate.findViewById(R.id.page_indicator);
    }

    private void b() {
        List<HomeToolBean> list = this.f19677d;
        if (list == null || list.size() <= 0) {
            String[] strArr = {"我要举报", "报案助手", "来电预警", "身份核实"};
            this.f19677d.clear();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                HomeToolBean homeToolBean = new HomeToolBean();
                homeToolBean.setModule(this.f19681h.get(i2));
                homeToolBean.setContent(str);
                homeToolBean.setLocalIcon(this.f19682i[i2]);
                homeToolBean.setIsNeedVerified(1);
                this.f19677d.add(homeToolBean);
            }
        }
    }

    public ToolView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19677d = new ArrayList();
        this.f19678e = new ArrayList();
        this.f19681h = null;
        this.f19682i = new int[]{R.drawable.iv_home_report, R.drawable.iv_home_case, R.drawable.iv_home_warn, R.drawable.iv_home_id_check};
        a();
    }

    public boolean a(String str) {
        ArrayList<String> arrayList = this.f19681h;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(str);
    }

    public void a(boolean z) {
        int i2;
        if (this.f19675b != null) {
            try {
                if (this.f19678e == null || this.f19678e.size() <= 0) {
                    return;
                }
                int i3 = 0;
                while (i2 < this.f19678e.size()) {
                    i2 = (TextUtils.equals(this.f19678e.get(i2).getModule(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f19678e.get(i2).getId(), ModuelConfig.MODEL_IDVERIFY) || TextUtils.equals(this.f19678e.get(i2).getContent(), "身份核实")) ? 0 : i2 + 1;
                    this.f19678e.get(i2).setHasRedDot(z);
                    View viewA = this.f19675b.a(i2);
                    if (viewA != null) {
                        View viewFindViewById = viewA.findViewById(R.id.red_dot);
                        if (!z) {
                            i3 = 8;
                        }
                        if (viewFindViewById == null || viewFindViewById.getVisibility() == i3) {
                            return;
                        }
                        viewFindViewById.setVisibility(i3);
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public PageRecyclerView.PageAdapter a(PageRecyclerView pageRecyclerView) {
        pageRecyclerView.getClass();
        this.f19679f = pageRecyclerView.new PageAdapter(this.f19678e, new a());
        pageRecyclerView.setAdapter(this.f19679f);
        this.f19679f.notifyDataSetChanged();
        return this.f19679f;
    }
}
