package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class PayStopAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PayStopAddActivity f18442a;

    /* renamed from: b, reason: collision with root package name */
    private View f18443b;

    /* renamed from: c, reason: collision with root package name */
    private View f18444c;

    /* renamed from: d, reason: collision with root package name */
    private View f18445d;

    /* renamed from: e, reason: collision with root package name */
    private View f18446e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopAddActivity f18447a;

        a(PayStopAddActivity payStopAddActivity) {
            this.f18447a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18447a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopAddActivity f18449a;

        b(PayStopAddActivity payStopAddActivity) {
            this.f18449a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18449a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopAddActivity f18451a;

        c(PayStopAddActivity payStopAddActivity) {
            this.f18451a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18451a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopAddActivity f18453a;

        d(PayStopAddActivity payStopAddActivity) {
            this.f18453a = payStopAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18453a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity) {
        this(payStopAddActivity, payStopAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopAddActivity payStopAddActivity = this.f18442a;
        if (payStopAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18442a = null;
        payStopAddActivity.mTvTitle = null;
        payStopAddActivity.mTvSuspectType = null;
        payStopAddActivity.mEtSuspectAccountName = null;
        payStopAddActivity.mEtSuspectAccount = null;
        payStopAddActivity.mTvTransTime = null;
        payStopAddActivity.mEtTransMoy = null;
        payStopAddActivity.mBtnCommit = null;
        this.f18443b.setOnClickListener(null);
        this.f18443b = null;
        this.f18444c.setOnClickListener(null);
        this.f18444c = null;
        this.f18445d.setOnClickListener(null);
        this.f18445d = null;
        this.f18446e.setOnClickListener(null);
        this.f18446e = null;
    }

    @UiThread
    public PayStopAddActivity_ViewBinding(PayStopAddActivity payStopAddActivity, View view) {
        this.f18442a = payStopAddActivity;
        payStopAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_suspect_type, "field 'mTvSuspectType' and method 'onViewClicked'");
        payStopAddActivity.mTvSuspectType = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        this.f18443b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopAddActivity));
        payStopAddActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        payStopAddActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTransTime' and method 'onViewClicked'");
        payStopAddActivity.mTvTransTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTransTime'", TextView.class);
        this.f18444c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopAddActivity));
        payStopAddActivity.mEtTransMoy = (EditText) Utils.findRequiredViewAsType(view, R.id.et_transfer_money, "field 'mEtTransMoy'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopAddActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18445d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(payStopAddActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18446e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(payStopAddActivity));
    }
}
