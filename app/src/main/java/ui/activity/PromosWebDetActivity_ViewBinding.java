package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyWebView;

/* loaded from: classes2.dex */
public class PromosWebDetActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PromosWebDetActivity f18559a;

    /* renamed from: b, reason: collision with root package name */
    private View f18560b;

    /* renamed from: c, reason: collision with root package name */
    private View f18561c;

    /* renamed from: d, reason: collision with root package name */
    private View f18562d;

    /* renamed from: e, reason: collision with root package name */
    private View f18563e;

    /* renamed from: f, reason: collision with root package name */
    private View f18564f;

    /* renamed from: g, reason: collision with root package name */
    private View f18565g;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18566a;

        a(PromosWebDetActivity promosWebDetActivity) {
            this.f18566a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18566a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18568a;

        b(PromosWebDetActivity promosWebDetActivity) {
            this.f18568a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18568a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18570a;

        c(PromosWebDetActivity promosWebDetActivity) {
            this.f18570a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18570a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18572a;

        d(PromosWebDetActivity promosWebDetActivity) {
            this.f18572a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18572a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18574a;

        e(PromosWebDetActivity promosWebDetActivity) {
            this.f18574a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18574a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PromosWebDetActivity f18576a;

        f(PromosWebDetActivity promosWebDetActivity) {
            this.f18576a = promosWebDetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18576a.onViewClicked(view);
        }
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity) {
        this(promosWebDetActivity, promosWebDetActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PromosWebDetActivity promosWebDetActivity = this.f18559a;
        if (promosWebDetActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18559a = null;
        promosWebDetActivity.mRlTitle = null;
        promosWebDetActivity.mTvTitle = null;
        promosWebDetActivity.mIvRight = null;
        promosWebDetActivity.mIvRight2 = null;
        promosWebDetActivity.mRlTitleWhite = null;
        promosWebDetActivity.mWebview = null;
        promosWebDetActivity.mTvHelp = null;
        promosWebDetActivity.mProgressBar = null;
        promosWebDetActivity.mLlNetworkNo = null;
        promosWebDetActivity.mLlToReport = null;
        this.f18560b.setOnClickListener(null);
        this.f18560b = null;
        this.f18561c.setOnClickListener(null);
        this.f18561c = null;
        this.f18562d.setOnClickListener(null);
        this.f18562d = null;
        this.f18563e.setOnClickListener(null);
        this.f18563e = null;
        this.f18564f.setOnClickListener(null);
        this.f18564f = null;
        this.f18565g.setOnClickListener(null);
        this.f18565g = null;
    }

    @UiThread
    public PromosWebDetActivity_ViewBinding(PromosWebDetActivity promosWebDetActivity, View view) {
        this.f18559a = promosWebDetActivity;
        promosWebDetActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        promosWebDetActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f18560b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(promosWebDetActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right2, "field 'mIvRight2' and method 'onViewClicked'");
        promosWebDetActivity.mIvRight2 = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right2, "field 'mIvRight2'", ImageView.class);
        this.f18561c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(promosWebDetActivity));
        promosWebDetActivity.mRlTitleWhite = Utils.findRequiredView(view, R.id.fl_tit_white, "field 'mRlTitleWhite'");
        promosWebDetActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebview'", MyWebView.class);
        promosWebDetActivity.mTvHelp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_help, "field 'mTvHelp'", TextView.class);
        promosWebDetActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        promosWebDetActivity.mLlNetworkNo = viewFindRequiredView3;
        this.f18562d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(promosWebDetActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_to_report, "field 'mLlToReport' and method 'onViewClicked'");
        promosWebDetActivity.mLlToReport = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.ll_to_report, "field 'mLlToReport'", LinearLayout.class);
        this.f18563e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(promosWebDetActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18564f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(promosWebDetActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_back2, "method 'onViewClicked'");
        this.f18565g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(promosWebDetActivity));
    }
}
