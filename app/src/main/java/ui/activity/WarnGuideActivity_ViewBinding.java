package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WarnGuideActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WarnGuideActivity f19277a;

    /* renamed from: b, reason: collision with root package name */
    private View f19278b;

    /* renamed from: c, reason: collision with root package name */
    private View f19279c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnGuideActivity f19280a;

        a(WarnGuideActivity warnGuideActivity) {
            this.f19280a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19280a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnGuideActivity f19282a;

        b(WarnGuideActivity warnGuideActivity) {
            this.f19282a = warnGuideActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19282a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity) {
        this(warnGuideActivity, warnGuideActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnGuideActivity warnGuideActivity = this.f19277a;
        if (warnGuideActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19277a = null;
        warnGuideActivity.mRlTitle = null;
        warnGuideActivity.mIvBack = null;
        warnGuideActivity.mTvTitle = null;
        warnGuideActivity.mIvWarnGuide = null;
        this.f19278b.setOnClickListener(null);
        this.f19278b = null;
        this.f19279c.setOnClickListener(null);
        this.f19279c = null;
    }

    @UiThread
    public WarnGuideActivity_ViewBinding(WarnGuideActivity warnGuideActivity, View view) {
        this.f19277a = warnGuideActivity;
        warnGuideActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnGuideActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19278b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnGuideActivity));
        warnGuideActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        warnGuideActivity.mIvWarnGuide = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_warn_guide, "field 'mIvWarnGuide'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_go_setting, "method 'onViewClicked'");
        this.f19279c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(warnGuideActivity));
    }
}
