package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class WarnSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WarnSettingActivity f19328a;

    /* renamed from: b, reason: collision with root package name */
    private View f19329b;

    /* renamed from: c, reason: collision with root package name */
    private View f19330c;

    /* renamed from: d, reason: collision with root package name */
    private View f19331d;

    /* renamed from: e, reason: collision with root package name */
    private View f19332e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnSettingActivity f19333a;

        a(WarnSettingActivity warnSettingActivity) {
            this.f19333a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19333a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnSettingActivity f19335a;

        b(WarnSettingActivity warnSettingActivity) {
            this.f19335a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19335a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnSettingActivity f19337a;

        c(WarnSettingActivity warnSettingActivity) {
            this.f19337a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19337a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnSettingActivity f19339a;

        d(WarnSettingActivity warnSettingActivity) {
            this.f19339a = warnSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19339a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity) {
        this(warnSettingActivity, warnSettingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnSettingActivity warnSettingActivity = this.f19328a;
        if (warnSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19328a = null;
        warnSettingActivity.mIvBack = null;
        warnSettingActivity.mTvTitle = null;
        warnSettingActivity.mIvRight = null;
        warnSettingActivity.mTvContent = null;
        warnSettingActivity.mTvContentSecond = null;
        warnSettingActivity.mLayoutOpen = null;
        warnSettingActivity.mSwitchCall = null;
        warnSettingActivity.mSwitchSms = null;
        warnSettingActivity.mSwitchApp = null;
        warnSettingActivity.mTvCall = null;
        warnSettingActivity.mTvSms = null;
        warnSettingActivity.mTvApp = null;
        warnSettingActivity.mTvGoPermission = null;
        this.f19329b.setOnClickListener(null);
        this.f19329b = null;
        this.f19330c.setOnClickListener(null);
        this.f19330c = null;
        this.f19331d.setOnClickListener(null);
        this.f19331d = null;
        this.f19332e.setOnClickListener(null);
        this.f19332e = null;
    }

    @UiThread
    public WarnSettingActivity_ViewBinding(WarnSettingActivity warnSettingActivity, View view) {
        this.f19328a = warnSettingActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        warnSettingActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19329b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnSettingActivity));
        warnSettingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        warnSettingActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f19330c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(warnSettingActivity));
        warnSettingActivity.mTvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'mTvContent'", TextView.class);
        warnSettingActivity.mTvContentSecond = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content_second, "field 'mTvContentSecond'", TextView.class);
        warnSettingActivity.mLayoutOpen = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_open, "field 'mLayoutOpen'", ConstraintLayout.class);
        warnSettingActivity.mSwitchCall = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_call, "field 'mSwitchCall'", SwitchButton.class);
        warnSettingActivity.mSwitchSms = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_sms, "field 'mSwitchSms'", SwitchButton.class);
        warnSettingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        warnSettingActivity.mTvCall = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_call, "field 'mTvCall'", TextView.class);
        warnSettingActivity.mTvSms = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sms, "field 'mTvSms'", TextView.class);
        warnSettingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app, "field 'mTvApp'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_go_permission, "field 'mTvGoPermission' and method 'onViewClicked'");
        warnSettingActivity.mTvGoPermission = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_go_permission, "field 'mTvGoPermission'", TextView.class);
        this.f19331d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(warnSettingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_error_free, "method 'onViewClicked'");
        this.f19332e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(warnSettingActivity));
    }
}
