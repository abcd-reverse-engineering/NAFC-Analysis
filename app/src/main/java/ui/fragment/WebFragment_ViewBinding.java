package ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WebFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WebFragment f19699a;

    /* renamed from: b, reason: collision with root package name */
    private View f19700b;

    /* renamed from: c, reason: collision with root package name */
    private View f19701c;

    /* renamed from: d, reason: collision with root package name */
    private View f19702d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebFragment f19703a;

        a(WebFragment webFragment) {
            this.f19703a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19703a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebFragment f19705a;

        b(WebFragment webFragment) {
            this.f19705a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19705a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebFragment f19707a;

        c(WebFragment webFragment) {
            this.f19707a = webFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19707a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFragment_ViewBinding(WebFragment webFragment, View view) {
        this.f19699a = webFragment;
        webFragment.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mTIvBack' and method 'onViewClicked'");
        webFragment.mTIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mTIvBack'", ImageView.class);
        this.f19700b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        webFragment.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f19701c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(webFragment));
        webFragment.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFragment.mLlNetworkNo = viewFindRequiredView3;
        this.f19702d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(webFragment));
        webFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pro_bar, "field 'mProgressBar'", ProgressBar.class);
        webFragment.mNetTips = (TextView) Utils.findRequiredViewAsType(view, R.id.net_tips, "field 'mNetTips'", TextView.class);
        webFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFragment webFragment = this.f19699a;
        if (webFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19699a = null;
        webFragment.mRlTitle = null;
        webFragment.mTIvBack = null;
        webFragment.mIvRight = null;
        webFragment.mTvTitle = null;
        webFragment.mLlNetworkNo = null;
        webFragment.mProgressBar = null;
        webFragment.mNetTips = null;
        webFragment.mLinearLayout = null;
        this.f19700b.setOnClickListener(null);
        this.f19700b = null;
        this.f19701c.setOnClickListener(null);
        this.f19701c = null;
        this.f19702d.setOnClickListener(null);
        this.f19702d = null;
    }
}
