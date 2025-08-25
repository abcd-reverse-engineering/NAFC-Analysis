package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.TagFlowLayout;
import ui.view.MyEdittext;

/* loaded from: classes2.dex */
public class FeedbackActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private FeedbackActivity f18131a;

    /* renamed from: b, reason: collision with root package name */
    private View f18132b;

    /* renamed from: c, reason: collision with root package name */
    private View f18133c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f18134a;

        a(FeedbackActivity feedbackActivity) {
            this.f18134a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18134a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f18136a;

        b(FeedbackActivity feedbackActivity) {
            this.f18136a = feedbackActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18136a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity) {
        this(feedbackActivity, feedbackActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackActivity feedbackActivity = this.f18131a;
        if (feedbackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18131a = null;
        feedbackActivity.mTvTitle = null;
        feedbackActivity.mFlowLayout = null;
        feedbackActivity.mEtDescribe = null;
        feedbackActivity.mRecyclerview = null;
        feedbackActivity.mPhone = null;
        feedbackActivity.mConfirm = null;
        this.f18132b.setOnClickListener(null);
        this.f18132b = null;
        this.f18133c.setOnClickListener(null);
        this.f18133c = null;
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.f18131a = feedbackActivity;
        feedbackActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackActivity.mFlowLayout = (TagFlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'mFlowLayout'", TagFlowLayout.class);
        feedbackActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        feedbackActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        feedbackActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.phone, "field 'mPhone'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        feedbackActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f18132b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18133c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackActivity));
    }
}
