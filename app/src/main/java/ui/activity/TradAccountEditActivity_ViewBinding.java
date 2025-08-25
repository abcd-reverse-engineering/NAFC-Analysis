package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public class TradAccountEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private TradAccountEditActivity f19123a;

    /* renamed from: b, reason: collision with root package name */
    private View f19124b;

    /* renamed from: c, reason: collision with root package name */
    private View f19125c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradAccountEditActivity f19126a;

        a(TradAccountEditActivity tradAccountEditActivity) {
            this.f19126a = tradAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19126a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradAccountEditActivity f19128a;

        b(TradAccountEditActivity tradAccountEditActivity) {
            this.f19128a = tradAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19128a.onViewClicked(view);
        }
    }

    @UiThread
    public TradAccountEditActivity_ViewBinding(TradAccountEditActivity tradAccountEditActivity) {
        this(tradAccountEditActivity, tradAccountEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradAccountEditActivity tradAccountEditActivity = this.f19123a;
        if (tradAccountEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19123a = null;
        tradAccountEditActivity.mTvTitle = null;
        tradAccountEditActivity.mFlowLayout = null;
        tradAccountEditActivity.mTvAccName = null;
        tradAccountEditActivity.mEtAccount = null;
        tradAccountEditActivity.mLlAccNorm = null;
        tradAccountEditActivity.mEtTagOther = null;
        tradAccountEditActivity.mEtAccountOther = null;
        tradAccountEditActivity.mLlAccOther = null;
        this.f19124b.setOnClickListener(null);
        this.f19124b = null;
        this.f19125c.setOnClickListener(null);
        this.f19125c = null;
    }

    @UiThread
    public TradAccountEditActivity_ViewBinding(TradAccountEditActivity tradAccountEditActivity, View view) {
        this.f19123a = tradAccountEditActivity;
        tradAccountEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tradAccountEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        tradAccountEditActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        tradAccountEditActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, R.id.et_account, "field 'mEtAccount'", TextView.class);
        tradAccountEditActivity.mLlAccNorm = Utils.findRequiredView(view, R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        tradAccountEditActivity.mEtTagOther = (TextView) Utils.findRequiredViewAsType(view, R.id.et_tag_other, "field 'mEtTagOther'", TextView.class);
        tradAccountEditActivity.mEtAccountOther = (TextView) Utils.findRequiredViewAsType(view, R.id.et_account_other, "field 'mEtAccountOther'", TextView.class);
        tradAccountEditActivity.mLlAccOther = Utils.findRequiredView(view, R.id.ll_acc_other, "field 'mLlAccOther'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19124b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tradAccountEditActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f19125c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tradAccountEditActivity));
    }
}
