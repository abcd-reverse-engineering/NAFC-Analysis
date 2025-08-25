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
public class ResetPhoneNumActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ResetPhoneNumActivity f18847a;

    /* renamed from: b, reason: collision with root package name */
    private View f18848b;

    /* renamed from: c, reason: collision with root package name */
    private View f18849c;

    /* renamed from: d, reason: collision with root package name */
    private View f18850d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPhoneNumActivity f18851a;

        a(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f18851a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18851a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPhoneNumActivity f18853a;

        b(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f18853a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18853a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResetPhoneNumActivity f18855a;

        c(ResetPhoneNumActivity resetPhoneNumActivity) {
            this.f18855a = resetPhoneNumActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18855a.onViewClicked(view);
        }
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity) {
        this(resetPhoneNumActivity, resetPhoneNumActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ResetPhoneNumActivity resetPhoneNumActivity = this.f18847a;
        if (resetPhoneNumActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18847a = null;
        resetPhoneNumActivity.mTvTitle = null;
        resetPhoneNumActivity.mPhoneCode = null;
        resetPhoneNumActivity.mConfim = null;
        resetPhoneNumActivity.mPhoneLable = null;
        resetPhoneNumActivity.mTvBomTips = null;
        resetPhoneNumActivity.mIvClean = null;
        this.f18848b.setOnClickListener(null);
        this.f18848b = null;
        this.f18849c.setOnClickListener(null);
        this.f18849c = null;
        this.f18850d.setOnClickListener(null);
        this.f18850d = null;
    }

    @UiThread
    public ResetPhoneNumActivity_ViewBinding(ResetPhoneNumActivity resetPhoneNumActivity, View view) {
        this.f18847a = resetPhoneNumActivity;
        resetPhoneNumActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        resetPhoneNumActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        resetPhoneNumActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f18848b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(resetPhoneNumActivity));
        resetPhoneNumActivity.mPhoneLable = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_label, "field 'mPhoneLable'", TextView.class);
        resetPhoneNumActivity.mTvBomTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bom_tips, "field 'mTvBomTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        resetPhoneNumActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18849c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(resetPhoneNumActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18850d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(resetPhoneNumActivity));
    }
}
