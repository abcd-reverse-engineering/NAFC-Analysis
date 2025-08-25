package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class FeedbackHelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private FeedbackHelpActivity f18161a;

    /* renamed from: b, reason: collision with root package name */
    private View f18162b;

    /* renamed from: c, reason: collision with root package name */
    private View f18163c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackHelpActivity f18164a;

        a(FeedbackHelpActivity feedbackHelpActivity) {
            this.f18164a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18164a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackHelpActivity f18166a;

        b(FeedbackHelpActivity feedbackHelpActivity) {
            this.f18166a = feedbackHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18166a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity) {
        this(feedbackHelpActivity, feedbackHelpActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackHelpActivity feedbackHelpActivity = this.f18161a;
        if (feedbackHelpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18161a = null;
        feedbackHelpActivity.mTvTitle = null;
        feedbackHelpActivity.mLlQaContent = null;
        this.f18162b.setOnClickListener(null);
        this.f18162b = null;
        this.f18163c.setOnClickListener(null);
        this.f18163c = null;
    }

    @UiThread
    public FeedbackHelpActivity_ViewBinding(FeedbackHelpActivity feedbackHelpActivity, View view) {
        this.f18161a = feedbackHelpActivity;
        feedbackHelpActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackHelpActivity.mLlQaContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_qa_content, "field 'mLlQaContent'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18162b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackHelpActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_feedback, "method 'onViewClicked'");
        this.f18163c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackHelpActivity));
    }
}
