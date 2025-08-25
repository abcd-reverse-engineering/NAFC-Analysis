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
public final class DeliveryAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private DeliveryAddActivity f18105a;

    /* renamed from: b, reason: collision with root package name */
    private View f18106b;

    /* renamed from: c, reason: collision with root package name */
    private View f18107c;

    /* renamed from: d, reason: collision with root package name */
    private View f18108d;

    /* renamed from: e, reason: collision with root package name */
    private View f18109e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryAddActivity f18110a;

        a(DeliveryAddActivity deliveryAddActivity) {
            this.f18110a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18110a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryAddActivity f18112a;

        b(DeliveryAddActivity deliveryAddActivity) {
            this.f18112a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18112a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryAddActivity f18114a;

        c(DeliveryAddActivity deliveryAddActivity) {
            this.f18114a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18114a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryAddActivity f18116a;

        d(DeliveryAddActivity deliveryAddActivity) {
            this.f18116a = deliveryAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18116a.onViewClicked(view);
        }
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity) {
        this(deliveryAddActivity, deliveryAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryAddActivity deliveryAddActivity = this.f18105a;
        if (deliveryAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18105a = null;
        deliveryAddActivity.mIvBack = null;
        deliveryAddActivity.mTvTitle = null;
        deliveryAddActivity.mBtnConfirm = null;
        deliveryAddActivity.mEtDeliveryNum = null;
        deliveryAddActivity.mTvDeliveryPlat = null;
        deliveryAddActivity.mLlDeliveryPlat = null;
        deliveryAddActivity.mEtPlatName = null;
        deliveryAddActivity.mEtDeliveryName = null;
        deliveryAddActivity.mEtDeliveryPhone = null;
        deliveryAddActivity.mEtDeliveryAddress = null;
        deliveryAddActivity.mTvDeliveryTime = null;
        deliveryAddActivity.mEtDeliveryWp = null;
        deliveryAddActivity.scrollView = null;
        deliveryAddActivity.mRecyView = null;
        this.f18106b.setOnClickListener(null);
        this.f18106b = null;
        this.f18107c.setOnClickListener(null);
        this.f18107c = null;
        this.f18108d.setOnClickListener(null);
        this.f18108d = null;
        this.f18109e.setOnClickListener(null);
        this.f18109e = null;
    }

    @UiThread
    public DeliveryAddActivity_ViewBinding(DeliveryAddActivity deliveryAddActivity, View view) {
        this.f18105a = deliveryAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        deliveryAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18106b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(deliveryAddActivity));
        deliveryAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        deliveryAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f18107c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_num, "field 'mEtDeliveryNum'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_delivery_plat, "field 'mTvDeliveryPlat' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryPlat = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_delivery_plat, "field 'mTvDeliveryPlat'", TextView.class);
        this.f18108d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(deliveryAddActivity));
        deliveryAddActivity.mLlDeliveryPlat = Utils.findRequiredView(view, R.id.ll_delivery_plat, "field 'mLlDeliveryPlat'");
        deliveryAddActivity.mEtPlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_name, "field 'mEtPlatName'", EditText.class);
        deliveryAddActivity.mEtDeliveryName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_sender, "field 'mEtDeliveryName'", EditText.class);
        deliveryAddActivity.mEtDeliveryPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_phone, "field 'mEtDeliveryPhone'", EditText.class);
        deliveryAddActivity.mEtDeliveryAddress = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_address, "field 'mEtDeliveryAddress'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_delivery_time, "field 'mTvDeliveryTime' and method 'onViewClicked'");
        deliveryAddActivity.mTvDeliveryTime = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_delivery_time, "field 'mTvDeliveryTime'", TextView.class);
        this.f18109e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(deliveryAddActivity));
        deliveryAddActivity.mEtDeliveryWp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_delivery_wp, "field 'mEtDeliveryWp'", EditText.class);
        deliveryAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        deliveryAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
