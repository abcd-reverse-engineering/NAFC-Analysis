package ui.activity;

import adapter.SignCallAdapter;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallBean;
import bean.CriminalPhoneNumBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.callview.CriminalPhoneView;
import ui.presenter.CriminalPhonePresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignCallActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J*\u0010\u001d\u001a\u00020\u001b2\u0010\u0010\u001e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014J\u0016\u0010%\u001a\u00020\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010)\u001a\u00020#H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lui/activity/SignCallActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/CriminalPhoneView;", "()V", "caseInfoId", "", "mAdapter", "Ladapter/SignCallAdapter;", "mPresenter", "Lui/presenter/CriminalPhonePresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mSelectList", "", "Lbean/CallBean;", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initAdapter", "", "initPage", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "onResume", "onSuccessList", "callBeans", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCallActivity extends BaseActivity implements BaseQuickAdapter.i, CriminalPhoneView {
    private String caseInfoId;
    private SignCallAdapter mAdapter;
    private CriminalPhonePresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyclerview;
    private final List<CallBean> mSelectList = new ArrayList();

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.d
    public final RecyclerView getMRecyclerview() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyclerview");
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

    public final void initAdapter() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView == null) {
            h.q2.t.i0.f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new SignCallAdapter(R.layout.sign_call_item, this.mSelectList);
        SignCallAdapter signCallAdapter = this.mAdapter;
        if (signCallAdapter == null) {
            h.q2.t.i0.f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        signCallAdapter.a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            h.q2.t.i0.f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        SignCallAdapter signCallAdapter2 = this.mAdapter;
        if (signCallAdapter2 == null) {
            h.q2.t.i0.f();
        }
        signCallAdapter2.setOnItemChildClickListener(this);
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
        textView.setText("通话类嫌疑人电话");
        this.caseInfoId = getIntent().getStringExtra(util.k1.C0);
        Activity activity = this.mActivity;
        h.q2.t.i0.a((Object) activity, "mActivity");
        this.mPresenter = new CriminalPhonePresenter(activity, this);
        initAdapter();
        CriminalPhonePresenter criminalPhonePresenter = this.mPresenter;
        if (criminalPhonePresenter == null) {
            h.q2.t.i0.f();
        }
        String str = this.caseInfoId;
        if (str == null) {
            h.q2.t.i0.f();
        }
        criminalPhonePresenter.getCriminalCallList(str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@i.c.a.e BaseQuickAdapter<?, ?> baseQuickAdapter, @i.c.a.d View view, int i2) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == R.id.cl_item) {
            Intent intent = new Intent(this.mActivity, (Class<?>) SignCallDetailActivity.class);
            intent.putExtra(util.k1.f20845c, this.mSelectList.get(i2));
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccess(@i.c.a.d List<String> list) {
        h.q2.t.i0.f(list, "CNATelList");
        CriminalPhoneView.a.a(this, list);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessList(@i.c.a.d List<? extends CallBean> list) {
        h.q2.t.i0.f(list, "callBeans");
        this.mSelectList.clear();
        this.mSelectList.addAll(list);
        SignCallAdapter signCallAdapter = this.mAdapter;
        if (signCallAdapter == null) {
            h.q2.t.i0.f();
        }
        signCallAdapter.notifyDataSetChanged();
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessPhoneNum(@i.c.a.d CriminalPhoneNumBean criminalPhoneNumBean) {
        h.q2.t.i0.f(criminalPhoneNumBean, "bean");
        CriminalPhoneView.a.a(this, criminalPhoneNumBean);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessRemove() {
        CriminalPhoneView.a.a(this);
    }

    @Override // ui.callview.CriminalPhoneView
    public void onSuccessSave(@i.c.a.d CallBean callBean) {
        h.q2.t.i0.f(callBean, "callBeans");
        CriminalPhoneView.a.a(this, callBean);
    }

    @OnClick({R.id.iv_back})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_call;
    }

    public final void setMRecyclerview(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
