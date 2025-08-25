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
public class SocialAccountEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SocialAccountEditActivity f19067a;

    /* renamed from: b, reason: collision with root package name */
    private View f19068b;

    /* renamed from: c, reason: collision with root package name */
    private View f19069c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialAccountEditActivity f19070a;

        a(SocialAccountEditActivity socialAccountEditActivity) {
            this.f19070a = socialAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19070a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialAccountEditActivity f19072a;

        b(SocialAccountEditActivity socialAccountEditActivity) {
            this.f19072a = socialAccountEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19072a.onViewClicked(view);
        }
    }

    @UiThread
    public SocialAccountEditActivity_ViewBinding(SocialAccountEditActivity socialAccountEditActivity) {
        this(socialAccountEditActivity, socialAccountEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SocialAccountEditActivity socialAccountEditActivity = this.f19067a;
        if (socialAccountEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19067a = null;
        socialAccountEditActivity.mTvTitle = null;
        socialAccountEditActivity.mFlowLayout = null;
        socialAccountEditActivity.mTvAccName = null;
        socialAccountEditActivity.mEtAccount = null;
        socialAccountEditActivity.mLlAccNorm = null;
        socialAccountEditActivity.mEtTagOther = null;
        socialAccountEditActivity.mEtAccountOther = null;
        socialAccountEditActivity.mLlAccOther = null;
        this.f19068b.setOnClickListener(null);
        this.f19068b = null;
        this.f19069c.setOnClickListener(null);
        this.f19069c = null;
    }

    @UiThread
    public SocialAccountEditActivity_ViewBinding(SocialAccountEditActivity socialAccountEditActivity, View view) {
        this.f19067a = socialAccountEditActivity;
        socialAccountEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        socialAccountEditActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        socialAccountEditActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        socialAccountEditActivity.mEtAccount = (TextView) Utils.findRequiredViewAsType(view, R.id.et_account, "field 'mEtAccount'", TextView.class);
        socialAccountEditActivity.mLlAccNorm = Utils.findRequiredView(view, R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        socialAccountEditActivity.mEtTagOther = (TextView) Utils.findRequiredViewAsType(view, R.id.et_tag_other, "field 'mEtTagOther'", TextView.class);
        socialAccountEditActivity.mEtAccountOther = (TextView) Utils.findRequiredViewAsType(view, R.id.et_account_other, "field 'mEtAccountOther'", TextView.class);
        socialAccountEditActivity.mLlAccOther = Utils.findRequiredView(view, R.id.ll_acc_other, "field 'mLlAccOther'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19068b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(socialAccountEditActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f19069c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(socialAccountEditActivity));
    }
}
