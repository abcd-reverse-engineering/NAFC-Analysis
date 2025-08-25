package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyEdittext;

/* loaded from: classes2.dex */
public class SmsAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SmsAddActivity f19018a;

    /* renamed from: b, reason: collision with root package name */
    private View f19019b;

    /* renamed from: c, reason: collision with root package name */
    private View f19020c;

    /* renamed from: d, reason: collision with root package name */
    private View f19021d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsAddActivity f19022a;

        a(SmsAddActivity smsAddActivity) {
            this.f19022a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19022a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsAddActivity f19024a;

        b(SmsAddActivity smsAddActivity) {
            this.f19024a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19024a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsAddActivity f19026a;

        c(SmsAddActivity smsAddActivity) {
            this.f19026a = smsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19026a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity) {
        this(smsAddActivity, smsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsAddActivity smsAddActivity = this.f19018a;
        if (smsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19018a = null;
        smsAddActivity.mTvTitle = null;
        smsAddActivity.mBtnCommit = null;
        smsAddActivity.mEtPhone = null;
        smsAddActivity.mEtDescribe = null;
        smsAddActivity.mEtVictimPhone = null;
        smsAddActivity.mTvTime = null;
        this.f19019b.setOnClickListener(null);
        this.f19019b = null;
        this.f19020c.setOnClickListener(null);
        this.f19020c = null;
        this.f19021d.setOnClickListener(null);
        this.f19021d = null;
    }

    @UiThread
    public SmsAddActivity_ViewBinding(SmsAddActivity smsAddActivity, View view) {
        this.f19018a = smsAddActivity;
        smsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        smsAddActivity.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f19019b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsAddActivity));
        smsAddActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        smsAddActivity.mEtDescribe = (MyEdittext) Utils.findRequiredViewAsType(view, R.id.et_describe, "field 'mEtDescribe'", MyEdittext.class);
        smsAddActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        smsAddActivity.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f19020c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsAddActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19021d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(smsAddActivity));
    }
}
