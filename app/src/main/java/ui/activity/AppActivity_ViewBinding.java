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
public class AppActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AppActivity f17641a;

    /* renamed from: b, reason: collision with root package name */
    private View f17642b;

    /* renamed from: c, reason: collision with root package name */
    private View f17643c;

    /* renamed from: d, reason: collision with root package name */
    private View f17644d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppActivity f17645a;

        a(AppActivity appActivity) {
            this.f17645a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17645a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppActivity f17647a;

        b(AppActivity appActivity) {
            this.f17647a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17647a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppActivity f17649a;

        c(AppActivity appActivity) {
            this.f17649a = appActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17649a.onViewClicked(view);
        }
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity) {
        this(appActivity, appActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppActivity appActivity = this.f17641a;
        if (appActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17641a = null;
        appActivity.mTvTitle = null;
        appActivity.mRecyclerview = null;
        appActivity.mTvSelectTip = null;
        appActivity.mTvCommitTip = null;
        appActivity.mBtnCommit = null;
        this.f17642b.setOnClickListener(null);
        this.f17642b = null;
        this.f17643c.setOnClickListener(null);
        this.f17643c = null;
        this.f17644d.setOnClickListener(null);
        this.f17644d = null;
    }

    @UiThread
    public AppActivity_ViewBinding(AppActivity appActivity, View view) {
        this.f17641a = appActivity;
        appActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        appActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        appActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        appActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f17642b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17643c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f17644d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appActivity));
    }
}
