package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class SignDeliveryDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignDeliveryDetailActivity f18961a;

    /* renamed from: b, reason: collision with root package name */
    private View f18962b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignDeliveryDetailActivity f18963a;

        a(SignDeliveryDetailActivity signDeliveryDetailActivity) {
            this.f18963a = signDeliveryDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18963a.onViewClicked(view);
        }
    }

    @UiThread
    public SignDeliveryDetailActivity_ViewBinding(SignDeliveryDetailActivity signDeliveryDetailActivity) {
        this(signDeliveryDetailActivity, signDeliveryDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignDeliveryDetailActivity signDeliveryDetailActivity = this.f18961a;
        if (signDeliveryDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18961a = null;
        signDeliveryDetailActivity.mIvBack = null;
        signDeliveryDetailActivity.mTvTitle = null;
        signDeliveryDetailActivity.mBtnConfirm = null;
        signDeliveryDetailActivity.mEtDeliveryNum = null;
        signDeliveryDetailActivity.mTvDeliveryPlat = null;
        signDeliveryDetailActivity.mEtDeliveryName = null;
        signDeliveryDetailActivity.mEtDeliveryPhone = null;
        signDeliveryDetailActivity.mEtDeliveryAddress = null;
        signDeliveryDetailActivity.mTvDeliveryTime = null;
        signDeliveryDetailActivity.mEtDeliveryWp = null;
        signDeliveryDetailActivity.scrollView = null;
        signDeliveryDetailActivity.mLlWlPic = null;
        signDeliveryDetailActivity.mRecyView = null;
        this.f18962b.setOnClickListener(null);
        this.f18962b = null;
    }

    @UiThread
    public SignDeliveryDetailActivity_ViewBinding(SignDeliveryDetailActivity signDeliveryDetailActivity, View view) {
        this.f18961a = signDeliveryDetailActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        signDeliveryDetailActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18962b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signDeliveryDetailActivity));
        signDeliveryDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signDeliveryDetailActivity.mBtnConfirm = (Button) Utils.findRequiredViewAsType(view, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        signDeliveryDetailActivity.mEtDeliveryNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_num, "field 'mEtDeliveryNum'", EditText.class);
        signDeliveryDetailActivity.mTvDeliveryPlat = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delivery_plat, "field 'mTvDeliveryPlat'", TextView.class);
        signDeliveryDetailActivity.mEtDeliveryName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_sender, "field 'mEtDeliveryName'", EditText.class);
        signDeliveryDetailActivity.mEtDeliveryPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_phone, "field 'mEtDeliveryPhone'", EditText.class);
        signDeliveryDetailActivity.mEtDeliveryAddress = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_address, "field 'mEtDeliveryAddress'", EditText.class);
        signDeliveryDetailActivity.mTvDeliveryTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delivery_time, "field 'mTvDeliveryTime'", TextView.class);
        signDeliveryDetailActivity.mEtDeliveryWp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_wp, "field 'mEtDeliveryWp'", EditText.class);
        signDeliveryDetailActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        signDeliveryDetailActivity.mLlWlPic = Utils.findRequiredView(view, R.id.ll_wu_pic, "field 'mLlWlPic'");
        signDeliveryDetailActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
