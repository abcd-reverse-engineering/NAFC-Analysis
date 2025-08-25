package ui.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.InDustryBean;
import bean.UserInfoBean;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.callview.IndustryAddView;
import ui.presenter.IndustrysPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: IndustryListActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020$H\u0016J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010(\u001a\u00020$J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020$2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u00020\u001bH\u0016R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lui/activity/IndustryListActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/callview/IndustryAddView;", "()V", "dayAdapter", "Lui/activity/IndustryListActivity$IndustrysAdapte;", "industrys", "Ljava/util/ArrayList;", "Lbean/InDustryBean;", "Lkotlin/collections/ArrayList;", "mIvBack", "Landroid/widget/ImageView;", "mPresenter", "Lui/presenter/IndustrysPresenter;", "getMPresenter", "()Lui/presenter/IndustrysPresenter;", "setMPresenter", "(Lui/presenter/IndustrysPresenter;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "mTvRight", "Landroid/widget/TextView;", "mTvTitle", "selectName", "", "selected", "", "Ljava/lang/Integer;", "userInfo", "Lbean/UserInfoBean;", "getUserInfo", "()Lbean/UserInfoBean;", "setUserInfo", "(Lbean/UserInfoBean;)V", "initListener", "", "initPage", "initRVIndustrys", "mViewRecycle", "initView", "onClick", "view", "Landroid/view/View;", "onSuccIndustryRequest", "bean", "", "onSuccUpdateRequest", "setLayoutView", "IndustrysAdapte", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class IndustryListActivity extends BaseActivity implements View.OnClickListener, IndustryAddView {
    private IndustrysAdapte dayAdapter;
    private ImageView mIvBack;

    @i.c.a.e
    private IndustrysPresenter mPresenter;
    private RecyclerView mRvList;
    private TextView mTvRight;
    private TextView mTvTitle;

    @i.c.a.e
    private UserInfoBean userInfo;
    private ArrayList<InDustryBean> industrys = new ArrayList<>();
    private Integer selected = 0;
    private String selectName = "";

    /* compiled from: IndustryListActivity.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lui/activity/IndustryListActivity$IndustrysAdapte;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lui/activity/IndustryListActivity$IndustrysAdapte$ListHolder;", "Lui/activity/IndustryListActivity;", com.umeng.analytics.pro.d.R, "Landroid/content/Context;", "(Lui/activity/IndustryListActivity;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListHolder", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public final class IndustrysAdapte extends RecyclerView.Adapter<ListHolder> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f18257a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IndustryListActivity f18258b;

        /* compiled from: IndustryListActivity.kt */
        @h.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lui/activity/IndustryListActivity$IndustrysAdapte$ListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lui/activity/IndustryListActivity$IndustrysAdapte;Landroid/view/View;)V", "mIvSelect", "Landroid/widget/ImageView;", "getMIvSelect", "()Landroid/widget/ImageView;", "setMIvSelect", "(Landroid/widget/ImageView;)V", "mTvCont", "Landroid/widget/TextView;", "getMTvCont", "()Landroid/widget/TextView;", "setMTvCont", "(Landroid/widget/TextView;)V", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
        public final class ListHolder extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            @i.c.a.d
            private TextView f18259a;

            /* renamed from: b, reason: collision with root package name */
            @i.c.a.d
            private ImageView f18260b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ IndustrysAdapte f18261c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListHolder(@i.c.a.d IndustrysAdapte industrysAdapte, View view) {
                super(view);
                h.q2.t.i0.f(view, "itemView");
                this.f18261c = industrysAdapte;
                View viewFindViewById = view.findViewById(R.id.content);
                h.q2.t.i0.a((Object) viewFindViewById, "itemView.findViewById(R.id.content)");
                this.f18259a = (TextView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R.id.iv_select);
                h.q2.t.i0.a((Object) viewFindViewById2, "itemView.findViewById(R.id.iv_select)");
                this.f18260b = (ImageView) viewFindViewById2;
            }

            public final void a(@i.c.a.d TextView textView) {
                h.q2.t.i0.f(textView, "<set-?>");
                this.f18259a = textView;
            }

            @i.c.a.d
            public final TextView b() {
                return this.f18259a;
            }

            @i.c.a.d
            public final ImageView a() {
                return this.f18260b;
            }

            public final void a(@i.c.a.d ImageView imageView) {
                h.q2.t.i0.f(imageView, "<set-?>");
                this.f18260b = imageView;
            }
        }

        /* compiled from: IndustryListActivity.kt */
        static final class a implements View.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f18263b;

            a(int i2) {
                this.f18263b = i2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IndustryListActivity industryListActivity = IndustrysAdapte.this.f18258b;
                Object obj = industryListActivity.industrys.get(this.f18263b);
                h.q2.t.i0.a(obj, "industrys.get(position)");
                industryListActivity.selected = Integer.valueOf(((InDustryBean) obj).getPositionId());
                IndustryListActivity industryListActivity2 = IndustrysAdapte.this.f18258b;
                Object obj2 = industryListActivity2.industrys.get(this.f18263b);
                h.q2.t.i0.a(obj2, "industrys.get(position)");
                industryListActivity2.selectName = ((InDustryBean) obj2).getPositionName();
                IndustrysAdapte.this.notifyDataSetChanged();
                IndustrysPresenter mPresenter = IndustrysAdapte.this.f18258b.getMPresenter();
                if (mPresenter != null) {
                    Integer num = IndustrysAdapte.this.f18258b.selected;
                    if (num == null) {
                        h.q2.t.i0.f();
                    }
                    mPresenter.updateUserIndustry(String.valueOf(num.intValue()));
                }
            }
        }

        public IndustrysAdapte(@i.c.a.d IndustryListActivity industryListActivity, Context context) {
            h.q2.t.i0.f(context, com.umeng.analytics.pro.d.R);
            this.f18258b = industryListActivity;
            this.f18257a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@i.c.a.d ListHolder listHolder, int i2) {
            h.q2.t.i0.f(listHolder, "holder");
            TextView textViewB = listHolder.b();
            if (textViewB != null) {
                Object obj = this.f18258b.industrys.get(i2);
                h.q2.t.i0.a(obj, "industrys.get(position)");
                textViewB.setText(((InDustryBean) obj).getPositionName());
            }
            Object obj2 = this.f18258b.industrys.get(i2);
            h.q2.t.i0.a(obj2, "industrys.get(position)");
            int positionId = ((InDustryBean) obj2).getPositionId();
            Integer num = this.f18258b.selected;
            if (num != null && positionId == num.intValue()) {
                TextView textViewB2 = listHolder.b();
                if (textViewB2 != null) {
                    textViewB2.setTextColor(Color.parseColor("#2B4CFF"));
                }
                ImageView imageViewA = listHolder.a();
                if (imageViewA == null) {
                    h.q2.t.i0.f();
                }
                imageViewA.setVisibility(0);
            } else {
                TextView textViewB3 = listHolder.b();
                if (textViewB3 != null) {
                    textViewB3.setTextColor(Color.parseColor("#000000"));
                }
                ImageView imageViewA2 = listHolder.a();
                if (imageViewA2 == null) {
                    h.q2.t.i0.f();
                }
                imageViewA2.setVisibility(8);
            }
            listHolder.itemView.setOnClickListener(new a(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f18258b.industrys.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @i.c.a.d
        public ListHolder onCreateViewHolder(@i.c.a.d ViewGroup viewGroup, int i2) {
            h.q2.t.i0.f(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(this.f18257a).inflate(R.layout.item_industry, viewGroup, false);
            h.q2.t.i0.a((Object) viewInflate, "LayoutInflater.from(cont…_industry, parent, false)");
            return new ListHolder(this, viewInflate);
        }
    }

    @i.c.a.e
    public final IndustrysPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.e
    public final UserInfoBean getUserInfo() {
        return this.userInfo;
    }

    public final void initListener() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        TextView textView = this.mTvRight;
        if (textView == null) {
            h.q2.t.i0.k("mTvRight");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setOnClickListener(this);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        this.mPresenter = new IndustrysPresenter(this.mActivity, this);
        initView();
        initListener();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("行业");
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRvList");
        }
        initRVIndustrys(recyclerView);
        IndustrysPresenter industrysPresenter = this.mPresenter;
        if (industrysPresenter != null) {
            industrysPresenter.getIndustry();
        }
    }

    public final void initRVIndustrys(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "mViewRecycle");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        Activity activity = this.mActivity;
        h.q2.t.i0.a((Object) activity, "mActivity");
        this.dayAdapter = new IndustrysAdapte(this, activity);
        recyclerView.setAdapter(this.dayAdapter);
    }

    public final void initView() {
        String position;
        View viewFindViewById = findViewById(R.id.iv_back);
        h.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.mIvBack = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_title);
        h.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.tv_title)");
        this.mTvTitle = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tv_right);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.tv_right)");
        this.mTvRight = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.rv_List);
        h.q2.t.i0.a((Object) viewFindViewById4, "findViewById(R.id.rv_List)");
        this.mRvList = (RecyclerView) viewFindViewById4;
        this.userInfo = (UserInfoBean) getIntent().getSerializableExtra(util.k1.f20845c);
        UserInfoBean userInfoBean = this.userInfo;
        this.selected = (userInfoBean == null || (position = userInfoBean.getPosition()) == null) ? null : Integer.valueOf(Integer.parseInt(position));
        UserInfoBean userInfoBean2 = this.userInfo;
        this.selectName = userInfoBean2 != null ? userInfoBean2.getProfessionName() : null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            a();
        }
    }

    @Override // ui.callview.IndustryAddView
    public void onSuccIndustryRequest(@i.c.a.e List<? extends InDustryBean> list) {
        if (list != null) {
            this.industrys = (ArrayList) list;
            IndustrysAdapte industrysAdapte = this.dayAdapter;
            if (industrysAdapte != null) {
                industrysAdapte.notifyDataSetChanged();
            }
        }
    }

    @Override // ui.callview.IndustryAddView
    public void onSuccUpdateRequest() {
        UserInfoBean userInfoBean = (UserInfoBean) util.p1.a(util.p1.f20902l, UserInfoBean.class);
        h.q2.t.i0.a((Object) userInfoBean, "userInfoBean");
        Integer num = this.selected;
        if (num == null) {
            h.q2.t.i0.f();
        }
        userInfoBean.setPosition(String.valueOf(num.intValue()));
        userInfoBean.setProfessionName(this.selectName);
        util.p1.a(util.p1.f20902l, userInfoBean);
        finish();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_industry_list;
    }

    public final void setMPresenter(@i.c.a.e IndustrysPresenter industrysPresenter) {
        this.mPresenter = industrysPresenter;
    }

    public final void setUserInfo(@i.c.a.e UserInfoBean userInfoBean) {
        this.userInfo = userInfoBean;
    }
}
