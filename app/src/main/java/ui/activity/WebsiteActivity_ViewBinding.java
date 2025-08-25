package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WebsiteActivity f19373a;

    /* renamed from: b, reason: collision with root package name */
    private View f19374b;

    /* renamed from: c, reason: collision with root package name */
    private View f19375c;

    /* renamed from: d, reason: collision with root package name */
    private View f19376d;

    /* renamed from: e, reason: collision with root package name */
    private View f19377e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebsiteActivity f19378a;

        a(WebsiteActivity websiteActivity) {
            this.f19378a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19378a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebsiteActivity f19380a;

        b(WebsiteActivity websiteActivity) {
            this.f19380a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19380a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebsiteActivity f19382a;

        c(WebsiteActivity websiteActivity) {
            this.f19382a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19382a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebsiteActivity f19384a;

        d(WebsiteActivity websiteActivity) {
            this.f19384a = websiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19384a.onViewClicked(view);
        }
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity) {
        this(websiteActivity, websiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebsiteActivity websiteActivity = this.f19373a;
        if (websiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19373a = null;
        websiteActivity.mIvBack = null;
        websiteActivity.mTvTitle = null;
        websiteActivity.mVline = null;
        websiteActivity.mTvSelectHistory = null;
        websiteActivity.mLinearLayout = null;
        websiteActivity.mTvCommit = null;
        websiteActivity.mBtnCommit = null;
        this.f19374b.setOnClickListener(null);
        this.f19374b = null;
        this.f19375c.setOnClickListener(null);
        this.f19375c = null;
        this.f19376d.setOnClickListener(null);
        this.f19376d = null;
        this.f19377e.setOnClickListener(null);
        this.f19377e = null;
    }

    @UiThread
    public WebsiteActivity_ViewBinding(WebsiteActivity websiteActivity, View view) {
        this.f19373a = websiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        websiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19374b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(websiteActivity));
        websiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        websiteActivity.mVline = Utils.findRequiredView(view, R.id.v_line, "field 'mVline'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.fl_select_history, "field 'mTvSelectHistory' and method 'onViewClicked'");
        websiteActivity.mTvSelectHistory = viewFindRequiredView2;
        this.f19375c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(websiteActivity));
        websiteActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.linearlayout, "field 'mLinearLayout'", LinearLayout.class);
        websiteActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        websiteActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19376d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(websiteActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.fl_select, "method 'onViewClicked'");
        this.f19377e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(websiteActivity));
    }
}
