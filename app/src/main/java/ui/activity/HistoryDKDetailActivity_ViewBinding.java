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
public class HistoryDKDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private HistoryDKDetailActivity f18219a;

    /* renamed from: b, reason: collision with root package name */
    private View f18220b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryDKDetailActivity f18221a;

        a(HistoryDKDetailActivity historyDKDetailActivity) {
            this.f18221a = historyDKDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18221a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity) {
        this(historyDKDetailActivity, historyDKDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryDKDetailActivity historyDKDetailActivity = this.f18219a;
        if (historyDKDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18219a = null;
        historyDKDetailActivity.mTvTitle = null;
        historyDKDetailActivity.mExpendList = null;
        this.f18220b.setOnClickListener(null);
        this.f18220b = null;
    }

    @UiThread
    public HistoryDKDetailActivity_ViewBinding(HistoryDKDetailActivity historyDKDetailActivity, View view) {
        this.f18219a = historyDKDetailActivity;
        historyDKDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        historyDKDetailActivity.mExpendList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.expand_list, "field 'mExpendList'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18220b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(historyDKDetailActivity));
    }
}
