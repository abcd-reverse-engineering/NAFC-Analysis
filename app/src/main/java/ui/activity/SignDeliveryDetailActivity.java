package ui.activity;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import bean.DeliveryBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import ui.Hicore;
import ui.presenter.DeliveryPresenter;
import ui.presenter.GridViewPicPresenter;

/* compiled from: SignDeliveryDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010U\u001a\u00020VH\u0016J\u0006\u0010W\u001a\u00020VJ\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020(H\u0007J\b\u0010Z\u001a\u00020.H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001e\u0010F\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006["}, d2 = {"Lui/activity/SignDeliveryDetailActivity;", "Lui/activity/BaseActivity;", "()V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mDeliveryBean", "Lbean/DeliveryBean;", "getMDeliveryBean", "()Lbean/DeliveryBean;", "setMDeliveryBean", "(Lbean/DeliveryBean;)V", "mEtDeliveryAddress", "Landroid/widget/EditText;", "getMEtDeliveryAddress", "()Landroid/widget/EditText;", "setMEtDeliveryAddress", "(Landroid/widget/EditText;)V", "mEtDeliveryName", "getMEtDeliveryName", "setMEtDeliveryName", "mEtDeliveryNum", "getMEtDeliveryNum", "setMEtDeliveryNum", "mEtDeliveryPhone", "getMEtDeliveryPhone", "setMEtDeliveryPhone", "mEtDeliveryWp", "getMEtDeliveryWp", "setMEtDeliveryWp", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlWlPic", "Landroid/view/View;", "getMLlWlPic", "()Landroid/view/View;", "setMLlWlPic", "(Landroid/view/View;)V", "mMaxSelectNum", "", "getMMaxSelectNum", "()I", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvDeliveryPlat", "Landroid/widget/TextView;", "getMTvDeliveryPlat", "()Landroid/widget/TextView;", "setMTvDeliveryPlat", "(Landroid/widget/TextView;)V", "mTvDeliveryTime", "getMTvDeliveryTime", "setMTvDeliveryTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "picPresenter", "Lui/presenter/GridViewPicPresenter;", "getPicPresenter", "()Lui/presenter/GridViewPicPresenter;", "setPicPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "initPage", "", "initView", "onViewClicked", "view", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignDeliveryDetailActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private DeliveryPresenter f18957a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.e
    private GridViewPicPresenter f18958b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18959c = 6;

    /* renamed from: d, reason: collision with root package name */
    @i.c.a.e
    private DeliveryBean f18960d;

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @BindView(R.id.et_delivery_address)
    @i.c.a.d
    public EditText mEtDeliveryAddress;

    @BindView(R.id.et_delivery_sender)
    @i.c.a.d
    public EditText mEtDeliveryName;

    @BindView(R.id.et_delivery_num)
    @i.c.a.d
    public EditText mEtDeliveryNum;

    @BindView(R.id.et_delivery_phone)
    @i.c.a.d
    public EditText mEtDeliveryPhone;

    @BindView(R.id.et_delivery_wp)
    @i.c.a.d
    public EditText mEtDeliveryWp;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_wu_pic)
    @i.c.a.d
    public View mLlWlPic;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyView;

    @BindView(R.id.tv_delivery_plat)
    @i.c.a.d
    public TextView mTvDeliveryPlat;

    @BindView(R.id.tv_delivery_time)
    @i.c.a.d
    public TextView mTvDeliveryTime;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.ns_layout)
    @i.c.a.d
    public NestedScrollView scrollView;

    @i.c.a.d
    public final View a() {
        View view = this.mLlWlPic;
        if (view == null) {
            h.q2.t.i0.k("mLlWlPic");
        }
        return view;
    }

    @i.c.a.e
    public final GridViewPicPresenter b() {
        return this.f18958b;
    }

    @i.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @i.c.a.e
    public final DeliveryBean getMDeliveryBean() {
        return this.f18960d;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryAddress() {
        EditText editText = this.mEtDeliveryAddress;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryAddress");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryName() {
        EditText editText = this.mEtDeliveryName;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryName");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryNum() {
        EditText editText = this.mEtDeliveryNum;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryNum");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryPhone() {
        EditText editText = this.mEtDeliveryPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryWp() {
        EditText editText = this.mEtDeliveryWp;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryWp");
        }
        return editText;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    public final int getMMaxSelectNum() {
        return this.f18959c;
    }

    @i.c.a.e
    public final DeliveryPresenter getMPresenter() {
        return this.f18957a;
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
    public final TextView getMTvDeliveryPlat() {
        TextView textView = this.mTvDeliveryPlat;
        if (textView == null) {
            h.q2.t.i0.k("mTvDeliveryPlat");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvDeliveryTime() {
        TextView textView = this.mTvDeliveryTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvDeliveryTime");
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

    @i.c.a.d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            h.q2.t.i0.k("scrollView");
        }
        return nestedScrollView;
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
        textView.setText("寄件类嫌疑人电话详情");
        initView();
    }

    public final void initView() {
        this.f18960d = (DeliveryBean) getIntent().getSerializableExtra(util.k1.f20845c);
        this.f18957a = new DeliveryPresenter(this.mActivity, null);
        this.f18958b = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f18958b;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView = this.mRecyView;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView);
        }
        if (this.f18960d != null) {
            EditText editText = this.mEtDeliveryNum;
            if (editText == null) {
                h.q2.t.i0.k("mEtDeliveryNum");
            }
            DeliveryBean deliveryBean = this.f18960d;
            editText.setText(deliveryBean != null ? deliveryBean.getDeliveryNum() : null);
            TextView textView = this.mTvDeliveryPlat;
            if (textView == null) {
                h.q2.t.i0.k("mTvDeliveryPlat");
            }
            DeliveryBean deliveryBean2 = this.f18960d;
            textView.setText(deliveryBean2 != null ? deliveryBean2.getDeliveryPlat() : null);
            EditText editText2 = this.mEtDeliveryName;
            if (editText2 == null) {
                h.q2.t.i0.k("mEtDeliveryName");
            }
            DeliveryBean deliveryBean3 = this.f18960d;
            editText2.setText(deliveryBean3 != null ? deliveryBean3.getDeliveryName() : null);
            EditText editText3 = this.mEtDeliveryPhone;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtDeliveryPhone");
            }
            DeliveryBean deliveryBean4 = this.f18960d;
            editText3.setText(deliveryBean4 != null ? deliveryBean4.getDeliveryPhone() : null);
            EditText editText4 = this.mEtDeliveryAddress;
            if (editText4 == null) {
                h.q2.t.i0.k("mEtDeliveryAddress");
            }
            DeliveryBean deliveryBean5 = this.f18960d;
            editText4.setText(deliveryBean5 != null ? deliveryBean5.getDeliveryAddress() : null);
            TextView textView2 = this.mTvDeliveryTime;
            if (textView2 == null) {
                h.q2.t.i0.k("mTvDeliveryTime");
            }
            DeliveryBean deliveryBean6 = this.f18960d;
            textView2.setText(deliveryBean6 != null ? deliveryBean6.getDeliveryTime() : null);
            EditText editText5 = this.mEtDeliveryWp;
            if (editText5 == null) {
                h.q2.t.i0.k("mEtDeliveryWp");
            }
            DeliveryBean deliveryBean7 = this.f18960d;
            editText5.setText(deliveryBean7 != null ? deliveryBean7.getDeliveryWp() : null);
            Button button = this.mBtnConfirm;
            if (button == null) {
                h.q2.t.i0.k("mBtnConfirm");
            }
            button.setVisibility(8);
            EditText editText6 = this.mEtDeliveryNum;
            if (editText6 == null) {
                h.q2.t.i0.k("mEtDeliveryNum");
            }
            editText6.setEnabled(false);
            TextView textView3 = this.mTvDeliveryPlat;
            if (textView3 == null) {
                h.q2.t.i0.k("mTvDeliveryPlat");
            }
            textView3.setEnabled(false);
            EditText editText7 = this.mEtDeliveryName;
            if (editText7 == null) {
                h.q2.t.i0.k("mEtDeliveryName");
            }
            editText7.setEnabled(false);
            EditText editText8 = this.mEtDeliveryPhone;
            if (editText8 == null) {
                h.q2.t.i0.k("mEtDeliveryPhone");
            }
            editText8.setEnabled(false);
            EditText editText9 = this.mEtDeliveryAddress;
            if (editText9 == null) {
                h.q2.t.i0.k("mEtDeliveryAddress");
            }
            editText9.setEnabled(false);
            TextView textView4 = this.mTvDeliveryTime;
            if (textView4 == null) {
                h.q2.t.i0.k("mTvDeliveryTime");
            }
            textView4.setEnabled(false);
            EditText editText10 = this.mEtDeliveryWp;
            if (editText10 == null) {
                h.q2.t.i0.k("mEtDeliveryWp");
            }
            editText10.setEnabled(false);
            TextView textView5 = this.mTvDeliveryPlat;
            if (textView5 == null) {
                h.q2.t.i0.k("mTvDeliveryPlat");
            }
            if (textView5 == null) {
                h.q2.t.i0.f();
            }
            textView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            TextView textView6 = this.mTvDeliveryTime;
            if (textView6 == null) {
                h.q2.t.i0.k("mTvDeliveryTime");
            }
            if (textView6 == null) {
                h.q2.t.i0.f();
            }
            textView6.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            DeliveryBean deliveryBean8 = this.f18960d;
            ArrayList<UploadFileBean> mailingTelDetails = deliveryBean8 != null ? deliveryBean8.getMailingTelDetails() : null;
            if (mailingTelDetails == null || mailingTelDetails.size() <= 0) {
                View view = this.mLlWlPic;
                if (view == null) {
                    h.q2.t.i0.k("mLlWlPic");
                }
                view.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f18958b;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(mailingTelDetails);
            }
        }
    }

    @OnClick({R.id.iv_back})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (!app.isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_delivery_add;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMDeliveryBean(@i.c.a.e DeliveryBean deliveryBean) {
        this.f18960d = deliveryBean;
    }

    public final void setMEtDeliveryAddress(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryAddress = editText;
    }

    public final void setMEtDeliveryName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryName = editText;
    }

    public final void setMEtDeliveryNum(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryNum = editText;
    }

    public final void setMEtDeliveryPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryPhone = editText;
    }

    public final void setMEtDeliveryWp(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryWp = editText;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlWlPic(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlWlPic = view;
    }

    public final void setMPresenter(@i.c.a.e DeliveryPresenter deliveryPresenter) {
        this.f18957a = deliveryPresenter;
    }

    public final void setMRecyView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvDeliveryPlat(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDeliveryPlat = textView;
    }

    public final void setMTvDeliveryTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDeliveryTime = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setScrollView(@i.c.a.d NestedScrollView nestedScrollView) {
        h.q2.t.i0.f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void a(@i.c.a.e GridViewPicPresenter gridViewPicPresenter) {
        this.f18958b = gridViewPicPresenter;
    }
}
