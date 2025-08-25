package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.CriminalsView;
import ui.presenter.CriminalsPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: CriminalListActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000203J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u000203H\u0014J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u000203H\u0014J \u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\u000b2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u0006C"}, d2 = {"Lui/activity/CriminalListActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CriminalsView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mCriminalBeans", "Ljava/util/ArrayList;", "Lbean/CriminalBean;", "getMCriminalBeans", "()Ljava/util/ArrayList;", "setMCriminalBeans", "(Ljava/util/ArrayList;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/CriminalsPresenter;", "getMPresenter", "()Lui/presenter/CriminalsPresenter;", "setMPresenter", "(Lui/presenter/CriminalsPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onDestroy", "onEventMainThread", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CriminalListActivity extends BaseActivity implements CriminalsView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private CriminalsPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_add)
    @i.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.d
    private String caseInfoId = "";

    @i.c.a.d
    private ArrayList<CriminalBean> mCriminalBeans = new ArrayList<>();

    /* compiled from: CriminalListActivity.kt */
    public static final class a implements IClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18004b;

        a(int i2) {
            this.f18004b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CriminalsPresenter mPresenter = CriminalListActivity.this.getMPresenter();
            if (mPresenter != null) {
                ArrayList<CriminalBean> mCriminalBeans = CriminalListActivity.this.getMCriminalBeans();
                CriminalBean criminalBean = mCriminalBeans != null ? mCriminalBeans.get(this.f18004b) : null;
                h.q2.t.i0.a((Object) criminalBean, "mCriminalBeans?.get(itemPos)");
                mPresenter.deleteReportCriminal(criminalBean.getId());
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getItemPos() {
        return this.itemPos;
    }

    @i.c.a.d
    public final ArrayList<CriminalBean> getMCriminalBeans() {
        return this.mCriminalBeans;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final CriminalsPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final RecyclerView getMRecycleView() {
        RecyclerView recyclerView = this.mRecycleView;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecycleView");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvAdd() {
        TextView textView = this.mTvAdd;
        if (textView == null) {
            h.q2.t.i0.k("mTvAdd");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("嫌疑人");
        TextView textView2 = this.mTvAdd;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvAdd");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("嫌疑人信息");
        this.mPresenter = new CriminalsPresenter(this.mActivity, this.caseInfoId, this);
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecycleView");
            }
            criminalsPresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@i.c.a.d util.c2.a aVar) {
        h.q2.t.i0.f(aVar, "refreshUIEvent");
        aVar.a();
    }

    @Override // ui.callview.CriminalsView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        util.b1.b(this.mActivity, "删除当前嫌疑人信息？", "", "确定", "取消", new a(i2));
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CriminalsPresenter criminalsPresenter = this.mPresenter;
        if (criminalsPresenter != null) {
            criminalsPresenter.getCriminalList(this.caseInfoId);
        }
    }

    @Override // ui.callview.CriminalsView
    public void onSuccessHandle(int i2, @i.c.a.e List<CriminalBean> list) {
        if (i2 != 1) {
            if (i2 == 4) {
                this.mCriminalBeans.remove(this.itemPos);
                CriminalsPresenter criminalsPresenter = this.mPresenter;
                if (criminalsPresenter != null) {
                    criminalsPresenter.setListData(this.mCriminalBeans);
                    return;
                }
                return;
            }
            return;
        }
        ArrayList<CriminalBean> arrayList = this.mCriminalBeans;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<CriminalBean> arrayList2 = this.mCriminalBeans;
        if (arrayList2 != null) {
            if (list == null) {
                h.q2.t.i0.f();
            }
            arrayList2.addAll(list);
        }
        CriminalsPresenter criminalsPresenter2 = this.mPresenter;
        if (criminalsPresenter2 != null) {
            criminalsPresenter2.setListData(this.mCriminalBeans);
        }
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setItemPos(int i2) {
        this.itemPos = i2;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_list;
    }

    public final void setMCriminalBeans(@i.c.a.d ArrayList<CriminalBean> arrayList) {
        h.q2.t.i0.f(arrayList, "<set-?>");
        this.mCriminalBeans = arrayList;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e CriminalsPresenter criminalsPresenter) {
        this.mPresenter = criminalsPresenter;
    }

    public final void setMRecycleView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
