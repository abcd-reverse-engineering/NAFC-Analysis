package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class SettingActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SettingActivity f18890a;

    /* renamed from: b, reason: collision with root package name */
    private View f18891b;

    /* renamed from: c, reason: collision with root package name */
    private View f18892c;

    /* renamed from: d, reason: collision with root package name */
    private View f18893d;

    /* renamed from: e, reason: collision with root package name */
    private View f18894e;

    /* renamed from: f, reason: collision with root package name */
    private View f18895f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingActivity f18896a;

        a(SettingActivity settingActivity) {
            this.f18896a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18896a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingActivity f18898a;

        b(SettingActivity settingActivity) {
            this.f18898a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18898a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingActivity f18900a;

        c(SettingActivity settingActivity) {
            this.f18900a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18900a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingActivity f18902a;

        d(SettingActivity settingActivity) {
            this.f18902a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18902a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingActivity f18904a;

        e(SettingActivity settingActivity) {
            this.f18904a = settingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18904a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity) {
        this(settingActivity, settingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingActivity settingActivity = this.f18890a;
        if (settingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18890a = null;
        settingActivity.mTvTitle = null;
        settingActivity.mSwitchCheck = null;
        settingActivity.mTimeTxt = null;
        settingActivity.mTimeSetting = null;
        settingActivity.mSwitchPush = null;
        settingActivity.mTvPushTips = null;
        settingActivity.mRlCache = null;
        settingActivity.mTvCacheNum = null;
        this.f18891b.setOnClickListener(null);
        this.f18891b = null;
        this.f18892c.setOnClickListener(null);
        this.f18892c = null;
        this.f18893d.setOnClickListener(null);
        this.f18893d = null;
        this.f18894e.setOnClickListener(null);
        this.f18894e = null;
        this.f18895f.setOnClickListener(null);
        this.f18895f = null;
    }

    @UiThread
    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.f18890a = settingActivity;
        settingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingActivity.mSwitchCheck = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_check, "field 'mSwitchCheck'", SwitchButton.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.time_txt, "field 'mTimeTxt' and method 'onViewClicked'");
        settingActivity.mTimeTxt = (TextView) Utils.castView(viewFindRequiredView, R.id.time_txt, "field 'mTimeTxt'", TextView.class);
        this.f18891b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(settingActivity));
        settingActivity.mTimeSetting = (Group) Utils.findRequiredViewAsType(view, R.id.time_setting, "field 'mTimeSetting'", Group.class);
        settingActivity.mSwitchPush = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_push, "field 'mSwitchPush'", SwitchButton.class);
        settingActivity.mTvPushTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_push_tips, "field 'mTvPushTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_cache_calean, "field 'mRlCache' and method 'onViewClicked'");
        settingActivity.mRlCache = viewFindRequiredView2;
        this.f18892c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(settingActivity));
        settingActivity.mTvCacheNum = (TextView) Utils.findRequiredViewAsType(view, R.id.cache_num, "field 'mTvCacheNum'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18893d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(settingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_account, "method 'onViewClicked'");
        this.f18894e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(settingActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.logout_btn, "method 'onViewClicked'");
        this.f18895f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(settingActivity));
    }
}
