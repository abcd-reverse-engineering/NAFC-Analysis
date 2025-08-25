package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class RelationActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RelationActivity f18645a;

    /* renamed from: b, reason: collision with root package name */
    private View f18646b;

    /* renamed from: c, reason: collision with root package name */
    private View f18647c;

    /* renamed from: d, reason: collision with root package name */
    private View f18648d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelationActivity f18649a;

        a(RelationActivity relationActivity) {
            this.f18649a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18649a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelationActivity f18651a;

        b(RelationActivity relationActivity) {
            this.f18651a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18651a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RelationActivity f18653a;

        c(RelationActivity relationActivity) {
            this.f18653a = relationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18653a.onViewClicked(view);
        }
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity) {
        this(relationActivity, relationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RelationActivity relationActivity = this.f18645a;
        if (relationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18645a = null;
        relationActivity.mTvTitle = null;
        relationActivity.mRecyclerview = null;
        relationActivity.mTvSelectTip = null;
        relationActivity.mTvCommit = null;
        relationActivity.mBtnCommit = null;
        this.f18646b.setOnClickListener(null);
        this.f18646b = null;
        this.f18647c.setOnClickListener(null);
        this.f18647c = null;
        this.f18648d.setOnClickListener(null);
        this.f18648d = null;
    }

    @UiThread
    public RelationActivity_ViewBinding(RelationActivity relationActivity, View view) {
        this.f18645a = relationActivity;
        relationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        relationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        relationActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvSelectTip'", TextView.class);
        relationActivity.mTvCommit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommit'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        relationActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18646b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(relationActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18647c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(relationActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_add, "method 'onViewClicked'");
        this.f18648d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(relationActivity));
    }
}
