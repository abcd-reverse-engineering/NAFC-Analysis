package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AccountListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AccountListActivity f17596a;

    /* renamed from: b, reason: collision with root package name */
    private View f17597b;

    /* renamed from: c, reason: collision with root package name */
    private View f17598c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountListActivity f17599a;

        a(AccountListActivity accountListActivity) {
            this.f17599a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17599a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountListActivity f17601a;

        b(AccountListActivity accountListActivity) {
            this.f17601a = accountListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17601a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity) {
        this(accountListActivity, accountListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListActivity accountListActivity = this.f17596a;
        if (accountListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17596a = null;
        accountListActivity.mTvTitle = null;
        accountListActivity.mLlAdd = null;
        accountListActivity.mTvAdd = null;
        accountListActivity.mRecyclerview = null;
        this.f17597b.setOnClickListener(null);
        this.f17597b = null;
        this.f17598c.setOnClickListener(null);
        this.f17598c = null;
    }

    @UiThread
    public AccountListActivity_ViewBinding(AccountListActivity accountListActivity, View view) {
        this.f17596a = accountListActivity;
        accountListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAdd' and method 'onViewClicked'");
        accountListActivity.mLlAdd = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_add, "field 'mLlAdd'", LinearLayout.class);
        this.f17597b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountListActivity));
        accountListActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        accountListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17598c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(accountListActivity));
    }
}
