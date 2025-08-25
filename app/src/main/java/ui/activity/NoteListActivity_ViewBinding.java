package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class NoteListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private NoteListActivity f18419a;

    /* renamed from: b, reason: collision with root package name */
    private View f18420b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NoteListActivity f18421a;

        a(NoteListActivity noteListActivity) {
            this.f18421a = noteListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18421a.onClick(view);
        }
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity) {
        this(noteListActivity, noteListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NoteListActivity noteListActivity = this.f18419a;
        if (noteListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18419a = null;
        noteListActivity.mIvBack = null;
        noteListActivity.mTvTitle = null;
        noteListActivity.mRefreshLayout = null;
        noteListActivity.mRecycle = null;
        noteListActivity.noDateView = null;
        noteListActivity.mNoImg = null;
        noteListActivity.mNoTxt = null;
        this.f18420b.setOnClickListener(null);
        this.f18420b = null;
    }

    @UiThread
    public NoteListActivity_ViewBinding(NoteListActivity noteListActivity, View view) {
        this.f18419a = noteListActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        noteListActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18420b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(noteListActivity));
        noteListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        noteListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        noteListActivity.mRecycle = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycle'", RecyclerView.class);
        noteListActivity.noDateView = Utils.findRequiredView(view, R.id.cl_no_data, "field 'noDateView'");
        noteListActivity.mNoImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'mNoImg'", ImageView.class);
        noteListActivity.mNoTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mNoTxt'", TextView.class);
    }
}
