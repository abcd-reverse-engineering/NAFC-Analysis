package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.ReportWebView;
import ui.presenter.ReportWebsitePresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ReportWebsiteActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00108\u001a\u000209H\u0016J\u0006\u0010:\u001a\u000209J\u0010\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\u0017H\u0007J\b\u0010=\u001a\u000209H\u0014J\u0010\u0010>\u001a\u0002092\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u000209H\u0014J \u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u000b2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\b\u0010C\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104¨\u0006D"}, d2 = {"Lui/activity/ReportWebsiteActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportWebView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/ReportWebsitePresenter;", "getMPresenter", "()Lui/presenter/ReportWebsitePresenter;", "setMPresenter", "(Lui/presenter/ReportWebsitePresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReportWebBeans", "", "Lbean/ReportWebsitBean;", "getMReportWebBeans", "()Ljava/util/List;", "setMReportWebBeans", "(Ljava/util/List;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "onDestroy", "onItemDelet", "onResume", "onSuccessHandle", "type", "list", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportWebsiteActivity extends BaseActivity implements ReportWebView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_add)
    @i.c.a.d
    public View mLlAddLayout;

    @i.c.a.e
    private ReportWebsitePresenter mPresenter;

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
    private List<ReportWebsitBean> mReportWebBeans = new ArrayList();

    @i.c.a.d
    private String caseInfoId = "";

    /* compiled from: ReportWebsiteActivity.kt */
    public static final class a implements IClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18809b;

        a(int i2) {
            this.f18809b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportWebsitePresenter mPresenter = ReportWebsiteActivity.this.getMPresenter();
            if (mPresenter != null) {
                String caseInfoId = ReportWebsiteActivity.this.getCaseInfoId();
                List<ReportWebsitBean> mReportWebBeans = ReportWebsiteActivity.this.getMReportWebBeans();
                mPresenter.deleteCaseWebUrl(caseInfoId, (mReportWebBeans != null ? mReportWebBeans.get(this.f18809b) : null).getUrlInfoID());
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
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final View getMLlAddLayout() {
        View view = this.mLlAddLayout;
        if (view == null) {
            h.q2.t.i0.k("mLlAddLayout");
        }
        return view;
    }

    @i.c.a.e
    public final ReportWebsitePresenter getMPresenter() {
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
    public final List<ReportWebsitBean> getMReportWebBeans() {
        return this.mReportWebBeans;
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
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvAdd;
        if (textView == null) {
            h.q2.t.i0.k("mTvAdd");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("添加涉诈网址");
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("添加涉诈网址");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new ReportWebsitePresenter(this.mActivity, this.caseInfoId, this);
        ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
        if (reportWebsitePresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecycleView");
            }
            reportWebsitePresenter.initRecycleWeb(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.ll_add) {
                return;
            }
            Intent intent = new Intent(this.mActivity, (Class<?>) ReportWebsiteAddActivity.class);
            intent.putExtra(util.k1.C0, this.caseInfoId);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.callview.ReportWebView
    public void onItemDelet(int i2) {
        this.itemPos = i2;
        util.b1.b(this.mActivity, "删除当前网址信息？", "", "确定", "取消", new a(i2));
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
        if (reportWebsitePresenter != null) {
            reportWebsitePresenter.getSurveyWebList(this.caseInfoId);
        }
    }

    @Override // ui.callview.ReportWebView
    public void onSuccessHandle(int i2, @i.c.a.e List<ReportWebsitBean> list) {
        if (i2 != 1) {
            if (i2 == 4) {
                util.w1.a("删除成功");
                this.mReportWebBeans.remove(this.itemPos);
                ReportWebsitePresenter reportWebsitePresenter = this.mPresenter;
                if (reportWebsitePresenter != null) {
                    reportWebsitePresenter.setListData(this.mReportWebBeans);
                    return;
                }
                return;
            }
            return;
        }
        List<ReportWebsitBean> list2 = this.mReportWebBeans;
        if (list2 != null) {
            list2.clear();
        }
        List<ReportWebsitBean> list3 = this.mReportWebBeans;
        if (list3 != null) {
            if (list == null) {
                h.q2.t.i0.f();
            }
            list3.addAll(list);
        }
        ReportWebsitePresenter reportWebsitePresenter2 = this.mPresenter;
        if (reportWebsitePresenter2 != null) {
            reportWebsitePresenter2.setListData(this.mReportWebBeans);
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
        return R.layout.activity_report_weburl_list;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMPresenter(@i.c.a.e ReportWebsitePresenter reportWebsitePresenter) {
        this.mPresenter = reportWebsitePresenter;
    }

    public final void setMRecycleView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMReportWebBeans(@i.c.a.d List<ReportWebsitBean> list) {
        h.q2.t.i0.f(list, "<set-?>");
        this.mReportWebBeans = list;
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
