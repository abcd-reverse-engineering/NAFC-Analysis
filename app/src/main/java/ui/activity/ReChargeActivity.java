package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.RechargeBean;
import bean.RechargePlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.RechargeView;
import ui.presenter.RechargePresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ReChargeActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u0019H\u0007J\u0010\u00106\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u0002032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u00108\u001a\u000203H\u0014J\u0016\u00109\u001a\u0002032\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0016J\b\u0010<\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010/\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+¨\u0006="}, d2 = {"Lui/activity/ReChargeActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RechargeView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/RechargeBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "itemPos", "", "mBtnCommit", "Landroid/widget/Button;", "getMBtnCommit", "()Landroid/widget/Button;", "setMBtnCommit", "(Landroid/widget/Button;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlAddLayout", "Landroid/view/View;", "getMLlAddLayout", "()Landroid/view/View;", "setMLlAddLayout", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/RechargePresenter;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvAdd", "Landroid/widget/TextView;", "getMTvAdd", "()Landroid/widget/TextView;", "setMTvAdd", "(Landroid/widget/TextView;)V", "mTvCommitTip", "getMTvCommitTip", "setMTvCommitTip", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "onClick", "view", "onItemDelet", "onItemEdit", "onResume", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReChargeActivity extends BaseActivity implements RechargeView {
    private int itemPos;

    @BindView(R.id.btn_commit)
    @i.c.a.d
    public Button mBtnCommit;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_add)
    @i.c.a.d
    public View mLlAddLayout;
    private RechargePresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_add)
    @i.c.a.d
    public TextView mTvAdd;

    @BindView(R.id.tv_commit_tip)
    @i.c.a.d
    public TextView mTvCommitTip;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private String caseInfoId = "";
    private ArrayList<RechargeBean> arrayListBean = new ArrayList<>();

    /* compiled from: ReChargeActivity.kt */
    public static final class a implements IClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18587b;

        a(int i2) {
            this.f18587b = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RechargePresenter rechargePresenter = ReChargeActivity.this.mPresenter;
            if (rechargePresenter != null) {
                String str = ReChargeActivity.this.caseInfoId;
                ArrayList arrayList = ReChargeActivity.this.arrayListBean;
                RechargeBean rechargeBean = arrayList != null ? (RechargeBean) arrayList.get(this.f18587b) : null;
                h.q2.t.i0.a((Object) rechargeBean, "arrayListBean?.get(itemPos)");
                rechargePresenter.deleteRecharge(str, rechargeBean.getChargeTelInfoID(), this.f18587b);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
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
    public final TextView getMTvCommitTip() {
        TextView textView = this.mTvCommitTip;
        if (textView == null) {
            h.q2.t.i0.k("mTvCommitTip");
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
        textView.setText("添加");
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("添加充值类嫌疑人电话");
        TextView textView3 = this.mTvCommitTip;
        if (textView3 == null) {
            h.q2.t.i0.k("mTvCommitTip");
        }
        textView3.setText("最多可添加20条充值类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new RechargePresenter(this.mActivity, this);
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecycleView");
            }
            rechargePresenter.initRecycle(recyclerView);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_add, R.id.btn_commit})
    public final void onClick(@i.c.a.d View view) {
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
            onBackPressed();
            return;
        }
        if (id != R.id.ll_add) {
            return;
        }
        ArrayList<RechargeBean> arrayList = this.arrayListBean;
        if (arrayList == null) {
            h.q2.t.i0.f();
        }
        if (arrayList.size() >= 20) {
            util.w1.a("最多可添加20条充值类嫌疑人电话");
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) RechargeAddActivity.class);
        intent.putExtra(util.k1.C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // ui.callview.RechargeView
    public void onItemDelet(int i2) {
        util.b1.b(this.mActivity, "删除当前充值类信息？", "", "确定", "取消", new a(i2));
    }

    @Override // ui.callview.RechargeView
    public void onItemEdit(int i2) {
        this.itemPos = i2;
        Intent intent = new Intent(this.mActivity, (Class<?>) RechargeAddActivity.class);
        intent.putExtra(util.k1.C0, this.caseInfoId);
        ArrayList<RechargeBean> arrayList = this.arrayListBean;
        intent.putExtra(util.k1.f20845c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            rechargePresenter.getReChargeList(this.caseInfoId);
        }
    }

    @Override // ui.callview.RechargeView
    public void onSuccessList(@i.c.a.d List<? extends RechargeBean> list) {
        h.q2.t.i0.f(list, "list");
        this.arrayListBean = (ArrayList) list;
        RechargePresenter rechargePresenter = this.mPresenter;
        if (rechargePresenter != null) {
            rechargePresenter.setListData(this.arrayListBean);
        }
    }

    @Override // ui.callview.RechargeView
    public void onSuccessPlatList(@i.c.a.d List<? extends RechargePlatBean> list) {
        h.q2.t.i0.f(list, "list");
        RechargeView.a.b(this, list);
    }

    @Override // ui.callview.RechargeView
    public void onSuccessSave() {
        RechargeView.a.a(this);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_recharg_list;
    }

    public final void setMBtnCommit(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnCommit = button;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlAddLayout(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlAddLayout = view;
    }

    public final void setMRecycleView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvAdd(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAdd = textView;
    }

    public final void setMTvCommitTip(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvCommitTip = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
