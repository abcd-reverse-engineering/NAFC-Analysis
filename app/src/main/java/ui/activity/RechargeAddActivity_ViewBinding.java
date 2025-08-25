package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class RechargeAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RechargeAddActivity f18603a;

    /* renamed from: b, reason: collision with root package name */
    private View f18604b;

    /* renamed from: c, reason: collision with root package name */
    private View f18605c;

    /* renamed from: d, reason: collision with root package name */
    private View f18606d;

    /* renamed from: e, reason: collision with root package name */
    private View f18607e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RechargeAddActivity f18608a;

        a(RechargeAddActivity rechargeAddActivity) {
            this.f18608a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18608a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RechargeAddActivity f18610a;

        b(RechargeAddActivity rechargeAddActivity) {
            this.f18610a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18610a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RechargeAddActivity f18612a;

        c(RechargeAddActivity rechargeAddActivity) {
            this.f18612a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18612a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RechargeAddActivity f18614a;

        d(RechargeAddActivity rechargeAddActivity) {
            this.f18614a = rechargeAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18614a.onViewClicked(view);
        }
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity) {
        this(rechargeAddActivity, rechargeAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RechargeAddActivity rechargeAddActivity = this.f18603a;
        if (rechargeAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18603a = null;
        rechargeAddActivity.mTvTitle = null;
        rechargeAddActivity.mBtnConfirm = null;
        rechargeAddActivity.mEtRechargePlat = null;
        rechargeAddActivity.mLlOtherPlatName = null;
        rechargeAddActivity.mEtRechargePlatName = null;
        rechargeAddActivity.mEtRechargePhone = null;
        rechargeAddActivity.mEtRechargeSum = null;
        rechargeAddActivity.mEtRechargeTime = null;
        this.f18604b.setOnClickListener(null);
        this.f18604b = null;
        this.f18605c.setOnClickListener(null);
        this.f18605c = null;
        this.f18606d.setOnClickListener(null);
        this.f18606d = null;
        this.f18607e.setOnClickListener(null);
        this.f18607e = null;
    }

    @UiThread
    public RechargeAddActivity_ViewBinding(RechargeAddActivity rechargeAddActivity, View view) {
        this.f18603a = rechargeAddActivity;
        rechargeAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        rechargeAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f18604b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(rechargeAddActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.et_recharge_plat, "field 'mEtRechargePlat' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargePlat = (TextView) Utils.castView(viewFindRequiredView2, R.id.et_recharge_plat, "field 'mEtRechargePlat'", TextView.class);
        this.f18605c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(rechargeAddActivity));
        rechargeAddActivity.mLlOtherPlatName = Utils.findRequiredView(view, R.id.ll_recharge_plat, "field 'mLlOtherPlatName'");
        rechargeAddActivity.mEtRechargePlatName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_name, "field 'mEtRechargePlatName'", EditText.class);
        rechargeAddActivity.mEtRechargePhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_phone, "field 'mEtRechargePhone'", EditText.class);
        rechargeAddActivity.mEtRechargeSum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_recharge_sum, "field 'mEtRechargeSum'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_recharge_time, "field 'mEtRechargeTime' and method 'onViewClicked'");
        rechargeAddActivity.mEtRechargeTime = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_recharge_time, "field 'mEtRechargeTime'", TextView.class);
        this.f18606d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(rechargeAddActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18607e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(rechargeAddActivity));
    }
}
