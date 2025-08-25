package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AccountActivity f17575a;

    /* renamed from: b, reason: collision with root package name */
    private View f17576b;

    /* renamed from: c, reason: collision with root package name */
    private View f17577c;

    /* renamed from: d, reason: collision with root package name */
    private View f17578d;

    /* renamed from: e, reason: collision with root package name */
    private View f17579e;

    /* renamed from: f, reason: collision with root package name */
    private View f17580f;

    /* renamed from: g, reason: collision with root package name */
    private View f17581g;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17582a;

        a(AccountActivity accountActivity) {
            this.f17582a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17582a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17584a;

        b(AccountActivity accountActivity) {
            this.f17584a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17584a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17586a;

        c(AccountActivity accountActivity) {
            this.f17586a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17586a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17588a;

        d(AccountActivity accountActivity) {
            this.f17588a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17588a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17590a;

        e(AccountActivity accountActivity) {
            this.f17590a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17590a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountActivity f17592a;

        f(AccountActivity accountActivity) {
            this.f17592a = accountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17592a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountActivity_ViewBinding(AccountActivity accountActivity) {
        this(accountActivity, accountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountActivity accountActivity = this.f17575a;
        if (accountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17575a = null;
        accountActivity.mTvTitle = null;
        accountActivity.mTvPaymentType = null;
        accountActivity.mTvTime = null;
        accountActivity.mLlAmount = null;
        accountActivity.mEtAmount = null;
        accountActivity.mTvVictimType = null;
        accountActivity.mEtVictimOther = null;
        accountActivity.mEtVictimAccount = null;
        accountActivity.mTvSuspectType = null;
        accountActivity.mEtSuspectOther = null;
        accountActivity.mEtSuspectAccountName = null;
        accountActivity.mEtSuspectAccount = null;
        accountActivity.scrollView = null;
        accountActivity.mRecyclerview = null;
        accountActivity.mTvTip = null;
        accountActivity.mGroupVictim = null;
        accountActivity.mGroupSuspect = null;
        accountActivity.mTvConfirm = null;
        this.f17576b.setOnClickListener(null);
        this.f17576b = null;
        this.f17577c.setOnClickListener(null);
        this.f17577c = null;
        this.f17578d.setOnClickListener(null);
        this.f17578d = null;
        this.f17579e.setOnClickListener(null);
        this.f17579e = null;
        this.f17580f.setOnClickListener(null);
        this.f17580f = null;
        this.f17581g.setOnClickListener(null);
        this.f17581g = null;
    }

    @UiThread
    public AccountActivity_ViewBinding(AccountActivity accountActivity, View view) {
        this.f17575a = accountActivity;
        accountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_payment_type, "field 'mTvPaymentType' and method 'onViewClicked'");
        accountActivity.mTvPaymentType = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_payment_type, "field 'mTvPaymentType'", TextView.class);
        this.f17576b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        accountActivity.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f17577c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(accountActivity));
        accountActivity.mLlAmount = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_amount, "field 'mLlAmount'", LinearLayout.class);
        accountActivity.mEtAmount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_amount, "field 'mEtAmount'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_victim_type, "field 'mTvVictimType' and method 'onViewClicked'");
        accountActivity.mTvVictimType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_victim_type, "field 'mTvVictimType'", TextView.class);
        this.f17578d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(accountActivity));
        accountActivity.mEtVictimOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_other, "field 'mEtVictimOther'", EditText.class);
        accountActivity.mEtVictimAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_account, "field 'mEtVictimAccount'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_suspect_type, "field 'mTvSuspectType' and method 'onViewClicked'");
        accountActivity.mTvSuspectType = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_suspect_type, "field 'mTvSuspectType'", TextView.class);
        this.f17579e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(accountActivity));
        accountActivity.mEtSuspectOther = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_other, "field 'mEtSuspectOther'", EditText.class);
        accountActivity.mEtSuspectAccountName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account_name, "field 'mEtSuspectAccountName'", EditText.class);
        accountActivity.mEtSuspectAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_suspect_account, "field 'mEtSuspectAccount'", EditText.class);
        accountActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        accountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        accountActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
        accountActivity.mGroupVictim = Utils.findRequiredView(view, R.id.group_victim, "field 'mGroupVictim'");
        accountActivity.mGroupSuspect = Utils.findRequiredView(view, R.id.group_suspect, "field 'mGroupSuspect'");
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_confirm, "field 'mTvConfirm' and method 'onViewClicked'");
        accountActivity.mTvConfirm = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_confirm, "field 'mTvConfirm'", TextView.class);
        this.f17580f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(accountActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17581g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(accountActivity));
    }
}
