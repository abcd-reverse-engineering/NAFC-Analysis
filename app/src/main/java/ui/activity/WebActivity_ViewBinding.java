package ui.activity;

import android.view.View;
import android.widget.ImageView;
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
public class WebActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WebActivity f19345a;

    /* renamed from: b, reason: collision with root package name */
    private View f19346b;

    /* renamed from: c, reason: collision with root package name */
    private View f19347c;

    /* renamed from: d, reason: collision with root package name */
    private View f19348d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebActivity f19349a;

        a(WebActivity webActivity) {
            this.f19349a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19349a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebActivity f19351a;

        b(WebActivity webActivity) {
            this.f19351a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19351a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebActivity f19353a;

        c(WebActivity webActivity) {
            this.f19353a = webActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19353a.onViewClicked(view);
        }
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity) {
        this(webActivity, webActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebActivity webActivity = this.f19345a;
        if (webActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19345a = null;
        webActivity.mRlTitle = null;
        webActivity.mTvTitle = null;
        webActivity.mTIvBack = null;
        webActivity.mTIvShare = null;
        webActivity.mWebview = null;
        webActivity.mProgressBar = null;
        webActivity.mProgressLoad = null;
        webActivity.mFlmask = null;
        webActivity.mLlNetworkNo = null;
        this.f19346b.setOnClickListener(null);
        this.f19346b = null;
        this.f19347c.setOnClickListener(null);
        this.f19347c = null;
        this.f19348d.setOnClickListener(null);
        this.f19348d = null;
    }

    @UiThread
    public WebActivity_ViewBinding(WebActivity webActivity, View view) {
        this.f19345a = webActivity;
        webActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        webActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webActivity.mTIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f19346b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mTIvShare' and method 'onViewClicked'");
        webActivity.mTIvShare = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mTIvShare'", ImageView.class);
        this.f19347c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(webActivity));
        webActivity.mWebview = (MyWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'mWebview'", MyWebView.class);
        webActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webActivity.mProgressLoad = Utils.findRequiredView(view, R.id.ll_progress, "field 'mProgressLoad'");
        webActivity.mFlmask = Utils.findRequiredView(view, R.id.fl_mask, "field 'mFlmask'");
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webActivity.mLlNetworkNo = viewFindRequiredView3;
        this.f19348d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(webActivity));
    }
}
