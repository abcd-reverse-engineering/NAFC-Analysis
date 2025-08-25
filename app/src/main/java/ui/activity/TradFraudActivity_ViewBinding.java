package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class TradFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private TradFraudActivity f19131a;

    /* renamed from: b, reason: collision with root package name */
    private View f19132b;

    /* renamed from: c, reason: collision with root package name */
    private View f19133c;

    /* renamed from: d, reason: collision with root package name */
    private View f19134d;

    /* renamed from: e, reason: collision with root package name */
    private View f19135e;

    /* renamed from: f, reason: collision with root package name */
    private View f19136f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradFraudActivity f19137a;

        a(TradFraudActivity tradFraudActivity) {
            this.f19137a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19137a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradFraudActivity f19139a;

        b(TradFraudActivity tradFraudActivity) {
            this.f19139a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19139a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradFraudActivity f19141a;

        c(TradFraudActivity tradFraudActivity) {
            this.f19141a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19141a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradFraudActivity f19143a;

        d(TradFraudActivity tradFraudActivity) {
            this.f19143a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19143a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradFraudActivity f19145a;

        e(TradFraudActivity tradFraudActivity) {
            this.f19145a = tradFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19145a.onViewClicked(view);
        }
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity) {
        this(tradFraudActivity, tradFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradFraudActivity tradFraudActivity = this.f19131a;
        if (tradFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19131a = null;
        tradFraudActivity.mTvTitle = null;
        tradFraudActivity.mTvAccName = null;
        tradFraudActivity.mRlOtherAcc = null;
        tradFraudActivity.mEtTagOther = null;
        tradFraudActivity.mTvAccNum = null;
        tradFraudActivity.mRegion = null;
        tradFraudActivity.mTvDuperyType = null;
        tradFraudActivity.mEtCaseDescribe = null;
        this.f19132b.setOnClickListener(null);
        this.f19132b = null;
        this.f19133c.setOnClickListener(null);
        this.f19133c = null;
        this.f19134d.setOnClickListener(null);
        this.f19134d = null;
        this.f19135e.setOnClickListener(null);
        this.f19135e = null;
        this.f19136f.setOnClickListener(null);
        this.f19136f = null;
    }

    @UiThread
    public TradFraudActivity_ViewBinding(TradFraudActivity tradFraudActivity, View view) {
        this.f19131a = tradFraudActivity;
        tradFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_account_name, "field 'mTvAccName' and method 'onViewClicked'");
        tradFraudActivity.mTvAccName = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_account_name, "field 'mTvAccName'", TextView.class);
        this.f19132b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tradFraudActivity));
        tradFraudActivity.mRlOtherAcc = Utils.findRequiredView(view, R.id.rl_other_acc, "field 'mRlOtherAcc'");
        tradFraudActivity.mEtTagOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_tag_other, "field 'mEtTagOther'", EditText.class);
        tradFraudActivity.mTvAccNum = (TextView) Utils.findRequiredViewAsType(view, R.id.trad_fraud_num, "field 'mTvAccNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.region, "field 'mRegion' and method 'onViewClicked'");
        tradFraudActivity.mRegion = (TextView) Utils.castView(viewFindRequiredView2, R.id.region, "field 'mRegion'", TextView.class);
        this.f19133c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tradFraudActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        tradFraudActivity.mTvDuperyType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f19134d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(tradFraudActivity));
        tradFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19135e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(tradFraudActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f19136f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(tradFraudActivity));
    }
}
