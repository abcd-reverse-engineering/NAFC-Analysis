package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class FeedbackDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private FeedbackDetailActivity f18138a;

    /* renamed from: b, reason: collision with root package name */
    private View f18139b;

    /* renamed from: c, reason: collision with root package name */
    private View f18140c;

    /* renamed from: d, reason: collision with root package name */
    private View f18141d;

    /* renamed from: e, reason: collision with root package name */
    private View f18142e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackDetailActivity f18143a;

        a(FeedbackDetailActivity feedbackDetailActivity) {
            this.f18143a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18143a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackDetailActivity f18145a;

        b(FeedbackDetailActivity feedbackDetailActivity) {
            this.f18145a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18145a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackDetailActivity f18147a;

        c(FeedbackDetailActivity feedbackDetailActivity) {
            this.f18147a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18147a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackDetailActivity f18149a;

        d(FeedbackDetailActivity feedbackDetailActivity) {
            this.f18149a = feedbackDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18149a.onViewClicked(view);
        }
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity) {
        this(feedbackDetailActivity, feedbackDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackDetailActivity feedbackDetailActivity = this.f18138a;
        if (feedbackDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18138a = null;
        feedbackDetailActivity.mTvTitle = null;
        feedbackDetailActivity.mTvQuestion = null;
        feedbackDetailActivity.mTvAnswer = null;
        feedbackDetailActivity.mTvGoFeedback = null;
        feedbackDetailActivity.mIvSolve = null;
        feedbackDetailActivity.mTvSolveTip = null;
        feedbackDetailActivity.mIvNotSolve = null;
        feedbackDetailActivity.mTvNotSolveTip = null;
        this.f18139b.setOnClickListener(null);
        this.f18139b = null;
        this.f18140c.setOnClickListener(null);
        this.f18140c = null;
        this.f18141d.setOnClickListener(null);
        this.f18141d = null;
        this.f18142e.setOnClickListener(null);
        this.f18142e = null;
    }

    @UiThread
    public FeedbackDetailActivity_ViewBinding(FeedbackDetailActivity feedbackDetailActivity, View view) {
        this.f18138a = feedbackDetailActivity;
        feedbackDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        feedbackDetailActivity.mTvQuestion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_question, "field 'mTvQuestion'", TextView.class);
        feedbackDetailActivity.mTvAnswer = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_answer, "field 'mTvAnswer'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_go_feedback, "field 'mTvGoFeedback' and method 'onViewClicked'");
        feedbackDetailActivity.mTvGoFeedback = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_go_feedback, "field 'mTvGoFeedback'", TextView.class);
        this.f18139b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(feedbackDetailActivity));
        feedbackDetailActivity.mIvSolve = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_solve, "field 'mIvSolve'", ImageView.class);
        feedbackDetailActivity.mTvSolveTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_solve_tip, "field 'mTvSolveTip'", TextView.class);
        feedbackDetailActivity.mIvNotSolve = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_solve, "field 'mIvNotSolve'", ImageView.class);
        feedbackDetailActivity.mTvNotSolveTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_not_solve_tip, "field 'mTvNotSolveTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18140c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(feedbackDetailActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_solve, "method 'onViewClicked'");
        this.f18141d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(feedbackDetailActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_not_solve, "method 'onViewClicked'");
        this.f18142e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(feedbackDetailActivity));
    }
}
