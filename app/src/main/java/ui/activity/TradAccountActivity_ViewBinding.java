package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class TradAccountActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private TradAccountActivity f19111a;

    /* renamed from: b, reason: collision with root package name */
    private View f19112b;

    /* renamed from: c, reason: collision with root package name */
    private View f19113c;

    /* renamed from: d, reason: collision with root package name */
    private View f19114d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradAccountActivity f19115a;

        a(TradAccountActivity tradAccountActivity) {
            this.f19115a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19115a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradAccountActivity f19117a;

        b(TradAccountActivity tradAccountActivity) {
            this.f19117a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19117a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TradAccountActivity f19119a;

        c(TradAccountActivity tradAccountActivity) {
            this.f19119a = tradAccountActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19119a.onViewClicked(view);
        }
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity) {
        this(tradAccountActivity, tradAccountActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TradAccountActivity tradAccountActivity = this.f19111a;
        if (tradAccountActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19111a = null;
        tradAccountActivity.mTvTitle = null;
        tradAccountActivity.mRecyclerview = null;
        tradAccountActivity.mTvSelectTip = null;
        tradAccountActivity.mTvCommit = null;
        tradAccountActivity.mBtnCommit = null;
        this.f19112b.setOnClickListener(null);
        this.f19112b = null;
        this.f19113c.setOnClickListener(null);
        this.f19113c = null;
        this.f19114d.setOnClickListener(null);
        this.f19114d = null;
    }

    @UiThread
    public TradAccountActivity_ViewBinding(TradAccountActivity tradAccountActivity, View view) {
        this.f19111a = tradAccountActivity;
        tradAccountActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tradAccountActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        tradAccountActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        tradAccountActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        tradAccountActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19112b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tradAccountActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19113c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tradAccountActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f19114d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(tradAccountActivity));
    }
}
