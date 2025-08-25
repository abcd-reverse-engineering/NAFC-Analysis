package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class SocialAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SocialAccountActivity f19055a;

    /* renamed from: b, reason: collision with root package name */
    private View f19056b;

    /* renamed from: c, reason: collision with root package name */
    private View f19057c;

    /* renamed from: d, reason: collision with root package name */
    private View f19058d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialAccountActivity f19059a;

        a(SocialAccountActivity socialAccountActivity) {
            this.f19059a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19059a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialAccountActivity f19061a;

        b(SocialAccountActivity socialAccountActivity) {
            this.f19061a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19061a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SocialAccountActivity f19063a;

        c(SocialAccountActivity socialAccountActivity) {
            this.f19063a = socialAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19063a.onViewClicked(view);
        }
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity) {
        this(socialAccountActivity, socialAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SocialAccountActivity socialAccountActivity = this.f19055a;
        if (socialAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19055a = null;
        socialAccountActivity.mTvTitle = null;
        socialAccountActivity.mRecyclerview = null;
        socialAccountActivity.mTvSelectTip = null;
        socialAccountActivity.mTvCommit = null;
        socialAccountActivity.mBtnCommit = null;
        this.f19056b.setOnClickListener(null);
        this.f19056b = null;
        this.f19057c.setOnClickListener(null);
        this.f19057c = null;
        this.f19058d.setOnClickListener(null);
        this.f19058d = null;
    }

    @UiThread
    public SocialAccountActivity_ViewBinding(SocialAccountActivity socialAccountActivity, View view) {
        this.f19055a = socialAccountActivity;
        socialAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        socialAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        socialAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        socialAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        socialAccountActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19056b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(socialAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19057c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(socialAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f19058d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(socialAccountActivity));
    }
}
