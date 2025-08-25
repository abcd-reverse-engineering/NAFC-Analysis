package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AccountListPreviewActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AccountListPreviewActivity f17603a;

    /* renamed from: b, reason: collision with root package name */
    private View f17604b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountListPreviewActivity f17605a;

        a(AccountListPreviewActivity accountListPreviewActivity) {
            this.f17605a = accountListPreviewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17605a.onViewClicked(view);
        }
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity) {
        this(accountListPreviewActivity, accountListPreviewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AccountListPreviewActivity accountListPreviewActivity = this.f17603a;
        if (accountListPreviewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17603a = null;
        accountListPreviewActivity.mTvTitle = null;
        accountListPreviewActivity.mRecyclerview = null;
        this.f17604b.setOnClickListener(null);
        this.f17604b = null;
    }

    @UiThread
    public AccountListPreviewActivity_ViewBinding(AccountListPreviewActivity accountListPreviewActivity, View view) {
        this.f17603a = accountListPreviewActivity;
        accountListPreviewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        accountListPreviewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17604b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(accountListPreviewActivity));
    }
}
