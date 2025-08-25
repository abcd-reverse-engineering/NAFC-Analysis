package ui.activity;

import adapter.RelationAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.callview.RelationView;
import ui.presenter.RelationPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignRelationActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J*\u0010\u001e\u001a\u00020\u001c2\u0010\u0010\u001f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0007J\b\u0010)\u001a\u00020$H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lui/activity/SignRelationActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/RelationView;", "()V", "caseInfoId", "", "mAdapter", "Ladapter/RelationAdapter;", "mPresenter", "Lui/presenter/RelationPresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "platBeans", "Ljava/util/ArrayList;", "Lbean/RelationBean;", "Lkotlin/collections/ArrayList;", "initPage", "", "initRecycle", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "onSuccessList", "list", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignRelationActivity extends BaseActivity implements BaseQuickAdapter.i, RelationView {
    private RelationAdapter mAdapter;
    private RelationPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RelationBean> platBeans = new ArrayList<>();

    private final void initRecycle() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView == null) {
            h.q2.t.i0.f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RelationAdapter(R.layout.item_relation_acc, this.platBeans);
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            h.q2.t.i0.f();
        }
        RecyclerView recyclerView2 = this.mRecyclerview;
        if (recyclerView2 == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        relationAdapter.a(recyclerView2);
        RecyclerView recyclerView3 = this.mRecyclerview;
        if (recyclerView3 == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView3 == null) {
            h.q2.t.i0.f();
        }
        recyclerView3.setAdapter(this.mAdapter);
        RelationAdapter relationAdapter2 = this.mAdapter;
        if (relationAdapter2 == null) {
            h.q2.t.i0.f();
        }
        relationAdapter2.setOnItemChildClickListener(this);
        RelationAdapter relationAdapter3 = this.mAdapter;
        if (relationAdapter3 == null) {
            h.q2.t.i0.f();
        }
        relationAdapter3.k(true);
    }

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
        textView.setText("关联类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        initRecycle();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter != null) {
            relationPresenter.getRelationList(this.caseInfoId);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@i.c.a.e BaseQuickAdapter<?, ?> baseQuickAdapter, @i.c.a.d View view, int i2) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == R.id.cl_item) {
            Intent intent = new Intent(this.mActivity, (Class<?>) SignRelationDetialActivity.class);
            ArrayList<RelationBean> arrayList = this.platBeans;
            if (arrayList == null) {
                h.q2.t.i0.f();
            }
            intent.putExtra(util.k1.w, arrayList.get(i2));
            startActivity(intent);
        }
    }

    @Override // ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.a.a(this, i2);
    }

    @Override // ui.callview.RelationView
    public void onItemEdit() {
        RelationView.a.a(this);
    }

    @Override // ui.callview.RelationView
    public void onSuccessList(@i.c.a.d List<? extends RelationBean> list) {
        h.q2.t.i0.f(list, "list");
        this.platBeans = (ArrayList) list;
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter != null) {
            relationAdapter.a((List<RelationBean>) this.platBeans);
        }
    }

    @Override // ui.callview.RelationView
    public void onSuccessPlatList(@i.c.a.d List<? extends RelationPlatBean> list) {
        h.q2.t.i0.f(list, "list");
        RelationView.a.b(this, list);
    }

    @Override // ui.callview.RelationView
    public void onSuccessSave() {
        RelationView.a.b(this);
    }

    @OnClick({R.id.iv_back})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_relation_sign;
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
