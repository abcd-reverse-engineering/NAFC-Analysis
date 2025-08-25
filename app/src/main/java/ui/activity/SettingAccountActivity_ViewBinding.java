package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class SettingAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SettingAccountActivity f18875a;

    /* renamed from: b, reason: collision with root package name */
    private View f18876b;

    /* renamed from: c, reason: collision with root package name */
    private View f18877c;

    /* renamed from: d, reason: collision with root package name */
    private View f18878d;

    /* renamed from: e, reason: collision with root package name */
    private View f18879e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingAccountActivity f18880a;

        a(SettingAccountActivity settingAccountActivity) {
            this.f18880a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18880a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingAccountActivity f18882a;

        b(SettingAccountActivity settingAccountActivity) {
            this.f18882a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18882a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingAccountActivity f18884a;

        c(SettingAccountActivity settingAccountActivity) {
            this.f18884a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18884a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettingAccountActivity f18886a;

        d(SettingAccountActivity settingAccountActivity) {
            this.f18886a = settingAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18886a.onViewClicked(view);
        }
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity) {
        this(settingAccountActivity, settingAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingAccountActivity settingAccountActivity = this.f18875a;
        if (settingAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18875a = null;
        settingAccountActivity.mTvTitle = null;
        settingAccountActivity.mTvPhone = null;
        this.f18876b.setOnClickListener(null);
        this.f18876b = null;
        this.f18877c.setOnClickListener(null);
        this.f18877c = null;
        this.f18878d.setOnClickListener(null);
        this.f18878d = null;
        this.f18879e.setOnClickListener(null);
        this.f18879e = null;
    }

    @UiThread
    public SettingAccountActivity_ViewBinding(SettingAccountActivity settingAccountActivity, View view) {
        this.f18875a = settingAccountActivity;
        settingAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        settingAccountActivity.mTvPhone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone, "field 'mTvPhone'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18876b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(settingAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_ed_phone, "method 'onViewClicked'");
        this.f18877c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(settingAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_ed_pwd, "method 'onViewClicked'");
        this.f18878d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(settingAccountActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_logout_view, "method 'onViewClicked'");
        this.f18879e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(settingAccountActivity));
    }
}
