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
public class ForgetPdwOneActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ForgetPdwOneActivity f18169a;

    /* renamed from: b, reason: collision with root package name */
    private View f18170b;

    /* renamed from: c, reason: collision with root package name */
    private View f18171c;

    /* renamed from: d, reason: collision with root package name */
    private View f18172d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForgetPdwOneActivity f18173a;

        a(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f18173a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18173a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForgetPdwOneActivity f18175a;

        b(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f18175a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18175a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForgetPdwOneActivity f18177a;

        c(ForgetPdwOneActivity forgetPdwOneActivity) {
            this.f18177a = forgetPdwOneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18177a.onViewClicked(view);
        }
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity) {
        this(forgetPdwOneActivity, forgetPdwOneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPdwOneActivity forgetPdwOneActivity = this.f18169a;
        if (forgetPdwOneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18169a = null;
        forgetPdwOneActivity.mTvTitle = null;
        forgetPdwOneActivity.mPhoneCode = null;
        forgetPdwOneActivity.mConfim = null;
        forgetPdwOneActivity.mPhoneLable = null;
        forgetPdwOneActivity.mIvClean = null;
        this.f18170b.setOnClickListener(null);
        this.f18170b = null;
        this.f18171c.setOnClickListener(null);
        this.f18171c = null;
        this.f18172d.setOnClickListener(null);
        this.f18172d = null;
    }

    @UiThread
    public ForgetPdwOneActivity_ViewBinding(ForgetPdwOneActivity forgetPdwOneActivity, View view) {
        this.f18169a = forgetPdwOneActivity;
        forgetPdwOneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        forgetPdwOneActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        forgetPdwOneActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f18170b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(forgetPdwOneActivity));
        forgetPdwOneActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        forgetPdwOneActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18171c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(forgetPdwOneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18172d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(forgetPdwOneActivity));
    }
}
