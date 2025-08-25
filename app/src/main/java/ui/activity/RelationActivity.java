package ui.activity;

import adapter.RelationAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.RelationView;
import ui.presenter.RelationPresenter;

/* compiled from: RelationActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0002J(\u0010-\u001a\u00020(2\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030/2\u0006\u00100\u001a\u0002012\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020*H\u0016J\b\u00104\u001a\u00020(H\u0014J\u0016\u00105\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000707H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0007J\b\u00109\u001a\u00020*H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006:"}, d2 = {"Lui/activity/RelationActivity;", "Lui/activity/BaseActivity;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "Lui/callview/RelationView;", "()V", "accBeans", "Ljava/util/ArrayList;", "Lbean/RelationBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "mAdapter", "Ladapter/RelationAdapter;", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mPresenter", "Lui/presenter/RelationPresenter;", "mRecyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerview", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerview", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvCommit", "Landroid/widget/TextView;", "getMTvCommit", "()Landroid/widget/TextView;", "setMTvCommit", "(Landroid/widget/TextView;)V", "mTvSelectTip", "getMTvSelectTip", "setMTvSelectTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "forceActivity", "", "position", "", "initPage", "initRecycle", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "onItemDelet", "itemPos", "onResume", "onSuccessList", "list", "", "onViewClicked", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RelationActivity extends BaseActivity implements BaseQuickAdapter.i, RelationView {
    private RelationAdapter mAdapter;

    @BindView(R.id.btn_commit)
    @i.c.a.d
    public Button mBtnCommit;
    private RelationPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    @i.c.a.d
    public TextView mTvCommit;

    @BindView(R.id.tv_add)
    @i.c.a.d
    public TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RelationBean> accBeans = new ArrayList<>();

    /* compiled from: RelationActivity.kt */
    public static final class a implements IClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18644b;

        a(int i2) {
            this.f18644b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RelationPresenter relationPresenter = RelationActivity.this.mPresenter;
            if (relationPresenter != null) {
                String str = RelationActivity.this.caseInfoId;
                ArrayList arrayList = RelationActivity.this.accBeans;
                if (arrayList == null) {
                    h.q2.t.i0.f();
                }
                Object obj = arrayList.get(this.f18644b);
                h.q2.t.i0.a(obj, "accBeans!![position]");
                relationPresenter.removeRelationtel(str, ((RelationBean) obj).getLinkTelInfoID(), this.f18644b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) RelationAddActivity.class);
        intent.putExtra(util.k1.C0, this.caseInfoId);
        if (i2 != -1) {
            intent.putExtra(util.k1.v, i2);
            ArrayList<RelationBean> arrayList = this.accBeans;
            if (arrayList == null) {
                h.q2.t.i0.f();
            }
            intent.putExtra(util.k1.w, arrayList.get(i2));
        }
        startActivity(intent);
    }

    private final void initRecycle() {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyclerview");
        }
        if (recyclerView == null) {
            h.q2.t.i0.f();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RelationAdapter(R.layout.item_relation_acc, this.accBeans);
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
    }

    @i.c.a.d
    public final Button getMBtnCommit() {
        Button button = this.mBtnCommit;
        if (button == null) {
            h.q2.t.i0.k("mBtnCommit");
        }
        return button;
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
    public final TextView getMTvCommit() {
        TextView textView = this.mTvCommit;
        if (textView == null) {
            h.q2.t.i0.k("mTvCommit");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvSelectTip() {
        TextView textView = this.mTvSelectTip;
        if (textView == null) {
            h.q2.t.i0.k("mTvSelectTip");
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
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("添加关联类嫌疑人电话");
        TextView textView2 = this.mTvSelectTip;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvSelectTip");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("添加");
        TextView textView3 = this.mTvCommit;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvCommit");
        }
        if (textView3 == null) {
            h.q2.t.i0.f();
        }
        textView3.setText("最多可添加20条关联类嫌疑人电话");
        Button button = this.mBtnCommit;
        if (button == null) {
            h.q2.t.i0.k("mBtnCommit");
        }
        if (button == null) {
            h.q2.t.i0.f();
        }
        button.setText("确定");
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        initRecycle();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@i.c.a.d BaseQuickAdapter<?, ?> baseQuickAdapter, @i.c.a.d View view, int i2) {
        h.q2.t.i0.f(baseQuickAdapter, "adapter");
        h.q2.t.i0.f(view, "view");
        int id = view.getId();
        if (id == R.id.cl_item) {
            forceActivity(i2);
        } else if (id == R.id.iv_delete) {
            util.b1.b(this.mActivity, "删除当前关联类信息？", "", "确定", "取消", new a(i2));
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @Override // ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.a.a(this, i2);
        this.accBeans.remove(i2);
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            h.q2.t.i0.f();
        }
        relationAdapter.a((List<RelationBean>) this.accBeans);
    }

    @Override // ui.callview.RelationView
    public void onItemEdit() {
        RelationView.a.a(this);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter != null) {
            relationPresenter.getRelationList(this.caseInfoId);
        }
    }

    @Override // ui.callview.RelationView
    public void onSuccessList(@i.c.a.d List<? extends RelationBean> list) {
        h.q2.t.i0.f(list, "list");
        this.accBeans = (ArrayList) list;
        RelationAdapter relationAdapter = this.mAdapter;
        if (relationAdapter == null) {
            h.q2.t.i0.f();
        }
        relationAdapter.a((List<RelationBean>) this.accBeans);
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

    @OnClick({R.id.iv_back, R.id.ll_add, R.id.btn_commit})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.ll_add) {
            return;
        }
        ArrayList<RelationBean> arrayList = this.accBeans;
        if (arrayList == null) {
            h.q2.t.i0.f();
        }
        if (arrayList.size() >= 20) {
            util.w1.a("最多可添加20条关联类嫌疑人电话");
        } else {
            forceActivity(-1);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_relation_list;
    }

    public final void setMBtnCommit(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMRecyclerview(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyclerview = recyclerView;
    }

    public final void setMTvCommit(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvCommit = textView;
    }

    public final void setMTvSelectTip(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvSelectTip = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
