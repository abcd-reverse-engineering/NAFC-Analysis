package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: classes2.dex */
public final class RelationAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RelationAddActivity f18660a;

    /* renamed from: b, reason: collision with root package name */
    private View f18661b;

    /* renamed from: c, reason: collision with root package name */
    private View f18662c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelationAddActivity f18663a;

        a(RelationAddActivity relationAddActivity) {
            this.f18663a = relationAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18663a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelationAddActivity f18665a;

        b(RelationAddActivity relationAddActivity) {
            this.f18665a = relationAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18665a.onViewClicked(view);
        }
    }

    @UiThread
    public RelationAddActivity_ViewBinding(RelationAddActivity relationAddActivity) {
        this(relationAddActivity, relationAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RelationAddActivity relationAddActivity = this.f18660a;
        if (relationAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18660a = null;
        relationAddActivity.mTvTitle = null;
        relationAddActivity.scrollView = null;
        relationAddActivity.mFlowLayout = null;
        relationAddActivity.mTvAccName = null;
        relationAddActivity.mEtAccount = null;
        relationAddActivity.mLlAccNorm = null;
        relationAddActivity.mTvOtherTips = null;
        relationAddActivity.mEtOtherName = null;
        relationAddActivity.mLlAccOther = null;
        this.f18661b.setOnClickListener(null);
        this.f18661b = null;
        this.f18662c.setOnClickListener(null);
        this.f18662c = null;
    }

    @UiThread
    public RelationAddActivity_ViewBinding(RelationAddActivity relationAddActivity, View view) {
        this.f18660a = relationAddActivity;
        relationAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        relationAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.scrollView, "field 'scrollView'", NestedScrollView.class);
        relationAddActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        relationAddActivity.mTvAccName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_name, "field 'mTvAccName'", TextView.class);
        relationAddActivity.mEtAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_account, "field 'mEtAccount'", EditText.class);
        relationAddActivity.mLlAccNorm = Utils.findRequiredView(view, R.id.ll_acc_nomar, "field 'mLlAccNorm'");
        relationAddActivity.mTvOtherTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_other_name, "field 'mTvOtherTips'", TextView.class);
        relationAddActivity.mEtOtherName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_other_name, "field 'mEtOtherName'", EditText.class);
        relationAddActivity.mLlAccOther = Utils.findRequiredView(view, R.id.ll_acc_other, "field 'mLlAccOther'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18661b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(relationAddActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f18662c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(relationAddActivity));
    }
}
