package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class ManualPhoneActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ManualPhoneActivity f18388a;

    /* renamed from: b, reason: collision with root package name */
    private View f18389b;

    /* renamed from: c, reason: collision with root package name */
    private View f18390c;

    /* renamed from: d, reason: collision with root package name */
    private View f18391d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualPhoneActivity f18392a;

        a(ManualPhoneActivity manualPhoneActivity) {
            this.f18392a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18392a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualPhoneActivity f18394a;

        b(ManualPhoneActivity manualPhoneActivity) {
            this.f18394a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18394a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualPhoneActivity f18396a;

        c(ManualPhoneActivity manualPhoneActivity) {
            this.f18396a = manualPhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18396a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity) {
        this(manualPhoneActivity, manualPhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualPhoneActivity manualPhoneActivity = this.f18388a;
        if (manualPhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18388a = null;
        manualPhoneActivity.mTvTitle = null;
        manualPhoneActivity.mPhoneCode = null;
        manualPhoneActivity.mConfim = null;
        manualPhoneActivity.mPhoneLable = null;
        manualPhoneActivity.mIvClean = null;
        this.f18389b.setOnClickListener(null);
        this.f18389b = null;
        this.f18390c.setOnClickListener(null);
        this.f18390c = null;
        this.f18391d.setOnClickListener(null);
        this.f18391d = null;
    }

    @UiThread
    public ManualPhoneActivity_ViewBinding(ManualPhoneActivity manualPhoneActivity, View view) {
        this.f18388a = manualPhoneActivity;
        manualPhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualPhoneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        manualPhoneActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f18389b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(manualPhoneActivity));
        manualPhoneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        manualPhoneActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18390c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(manualPhoneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18391d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(manualPhoneActivity));
    }
}
