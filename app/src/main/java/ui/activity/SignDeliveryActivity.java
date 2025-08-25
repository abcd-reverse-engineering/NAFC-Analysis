package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.callview.DeliveryView;
import ui.presenter.DeliveryPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignDeliveryActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u00102\u001a\u00020-2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000604H\u0016J\b\u00105\u001a\u00020\u000fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00066"}, d2 = {"Lui/activity/SignDeliveryActivity;", "Lui/activity/BaseActivity;", "Lui/callview/DeliveryView;", "()V", "arrayListBean", "Ljava/util/ArrayList;", "Lbean/DeliveryBean;", "Lkotlin/collections/ArrayList;", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "itemPos", "", "getItemPos", "()I", "setItemPos", "(I)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "onClick", "view", "Landroid/view/View;", "onItemEdit", "onSuccessList", "list", "", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignDeliveryActivity extends BaseActivity implements DeliveryView {
    private int itemPos;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private DeliveryPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecycleView;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.d
    private String caseInfoId = "";
    private ArrayList<DeliveryBean> arrayListBean = new ArrayList<>();

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

    @i.c.a.e
    public final DeliveryPresenter getMPresenter() {
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
        textView.setText("寄递类嫌疑人电话");
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPresenter = new DeliveryPresenter(this.mActivity, this);
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            RecyclerView recyclerView = this.mRecycleView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecycleView");
            }
            deliveryPresenter.initRecycle(recyclerView);
        }
        DeliveryPresenter deliveryPresenter2 = this.mPresenter;
        if (deliveryPresenter2 != null) {
            deliveryPresenter2.getDeliveryList(this.caseInfoId);
        }
        DeliveryPresenter deliveryPresenter3 = this.mPresenter;
        if (deliveryPresenter3 != null) {
            deliveryPresenter3.isOnlySee(true);
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.callview.DeliveryView
    public void onItemDelet(int i2) {
        DeliveryView.a.a(this, i2);
    }

    @Override // ui.callview.DeliveryView
    public void onItemEdit(int i2) {
        this.itemPos = i2;
        Intent intent = new Intent(this.mActivity, (Class<?>) SignDeliveryDetailActivity.class);
        intent.putExtra(util.k1.C0, this.caseInfoId);
        ArrayList<DeliveryBean> arrayList = this.arrayListBean;
        intent.putExtra(util.k1.f20845c, arrayList != null ? arrayList.get(i2) : null);
        this.mActivity.startActivity(intent);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessList(@i.c.a.d List<? extends DeliveryBean> list) {
        h.q2.t.i0.f(list, "list");
        this.arrayListBean = (ArrayList) list;
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter != null) {
            deliveryPresenter.setListData(this.arrayListBean);
        }
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessPlatList(@i.c.a.d List<? extends DeliveryPlatBean> list) {
        h.q2.t.i0.f(list, "list");
        DeliveryView.a.b(this, list);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessSave(@i.c.a.d DeliveryBean deliveryBean) {
        h.q2.t.i0.f(deliveryBean, "bean");
        DeliveryView.a.a(this, deliveryBean);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessSaveFail(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "msg");
        DeliveryView.a.a(this, str);
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
        return R.layout.activity_delivery_sign;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e DeliveryPresenter deliveryPresenter) {
        this.mPresenter = deliveryPresenter;
    }

    public final void setMRecycleView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecycleView = recyclerView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
