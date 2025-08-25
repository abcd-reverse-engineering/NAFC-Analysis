package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class ReChargeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReChargeActivity f18588a;

    /* renamed from: b, reason: collision with root package name */
    private View f18589b;

    /* renamed from: c, reason: collision with root package name */
    private View f18590c;

    /* renamed from: d, reason: collision with root package name */
    private View f18591d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReChargeActivity f18592a;

        a(ReChargeActivity reChargeActivity) {
            this.f18592a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18592a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReChargeActivity f18594a;

        b(ReChargeActivity reChargeActivity) {
            this.f18594a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18594a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReChargeActivity f18596a;

        c(ReChargeActivity reChargeActivity) {
            this.f18596a = reChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18596a.onClick(view);
        }
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity) {
        this(reChargeActivity, reChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReChargeActivity reChargeActivity = this.f18588a;
        if (reChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18588a = null;
        reChargeActivity.mIvBack = null;
        reChargeActivity.mTvTitle = null;
        reChargeActivity.mLlAddLayout = null;
        reChargeActivity.mTvAdd = null;
        reChargeActivity.mRecycleView = null;
        reChargeActivity.mTvCommitTip = null;
        reChargeActivity.mBtnCommit = null;
        this.f18589b.setOnClickListener(null);
        this.f18589b = null;
        this.f18590c.setOnClickListener(null);
        this.f18590c = null;
        this.f18591d.setOnClickListener(null);
        this.f18591d = null;
    }

    @UiThread
    public ReChargeActivity_ViewBinding(ReChargeActivity reChargeActivity, View view) {
        this.f18588a = reChargeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reChargeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18589b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reChargeActivity));
        reChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reChargeActivity.mLlAddLayout = viewFindRequiredView2;
        this.f18590c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reChargeActivity));
        reChargeActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        reChargeActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reChargeActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18591d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reChargeActivity));
    }
}
