package ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportWebsitBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import ui.presenter.GridViewPicPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* compiled from: SignWebsitDetialActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0016J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\nH\u0007J\b\u0010/\u001a\u000200H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00061"}, d2 = {"Lui/activity/SignWebsitDetialActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlPic", "Landroid/view/View;", "getMLlPic", "()Landroid/view/View;", "setMLlPic", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/GridViewPicPresenter;", "getMPresenter", "()Lui/presenter/GridViewPicPresenter;", "setMPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvWebUrl", "getMTvWebUrl", "setMTvWebUrl", "mWebBean", "Lbean/ReportWebsitBean;", "getMWebBean", "()Lbean/ReportWebsitBean;", "setMWebBean", "(Lbean/ReportWebsitBean;)V", "initPage", "", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignWebsitDetialActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private GridViewPicPresenter f18984a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.e
    private ReportWebsitBean f18985b;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_pic)
    @i.c.a.d
    public View mLlPic;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyView;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_weburl)
    @i.c.a.d
    public TextView mTvWebUrl;

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvWebUrl = textView;
    }

    @i.c.a.d
    public final TextView b() {
        TextView textView = this.mTvWebUrl;
        if (textView == null) {
            h.q2.t.i0.k("mTvWebUrl");
        }
        return textView;
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
    public final GridViewPicPresenter getMPresenter() {
        return this.f18984a;
    }

    @i.c.a.d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyView");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @i.c.a.e
    public final ReportWebsitBean getMWebBean() {
        return this.f18985b;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("网址信息");
        initView();
    }

    public final void initView() {
        this.f18985b = (ReportWebsitBean) getIntent().getSerializableExtra(util.k1.f20845c);
        this.f18984a = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f18984a;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView = this.mRecyView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView);
        }
        ReportWebsitBean reportWebsitBean = this.f18985b;
        if (reportWebsitBean != null) {
            if (!TextUtils.isEmpty(reportWebsitBean != null ? reportWebsitBean.getUrl() : null)) {
                TextView textView = this.mTvWebUrl;
                if (textView == null) {
                    h.q2.t.i0.k("mTvWebUrl");
                }
                ReportWebsitBean reportWebsitBean2 = this.f18985b;
                textView.setText(reportWebsitBean2 != null ? reportWebsitBean2.getUrl() : null);
            }
            ReportWebsitBean reportWebsitBean3 = this.f18985b;
            ArrayList<UploadFileBean> urlDetails = reportWebsitBean3 != null ? reportWebsitBean3.getUrlDetails() : null;
            if (urlDetails == null || urlDetails.size() <= 0) {
                View view = this.mLlPic;
                if (view == null) {
                    h.q2.t.i0.k("mLlPic");
                }
                view.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f18984a;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(urlDetails);
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_websit_copy})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_websit_copy) {
                return;
            }
            TextView textView = this.mTvWebUrl;
            if (textView == null) {
                h.q2.t.i0.k("mTvWebUrl");
            }
            y1.s(textView.getText().toString());
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_weburl_detial;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlPic(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlPic = view;
    }

    public final void setMRecyView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMWebBean(@i.c.a.e ReportWebsitBean reportWebsitBean) {
        this.f18985b = reportWebsitBean;
    }

    @i.c.a.d
    public final View a() {
        View view = this.mLlPic;
        if (view == null) {
            h.q2.t.i0.k("mLlPic");
        }
        return view;
    }

    public final void a(@i.c.a.e GridViewPicPresenter gridViewPicPresenter) {
        this.f18984a = gridViewPicPresenter;
    }
}
