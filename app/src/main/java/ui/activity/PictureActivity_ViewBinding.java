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
public class PictureActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PictureActivity f18498a;

    /* renamed from: b, reason: collision with root package name */
    private View f18499b;

    /* renamed from: c, reason: collision with root package name */
    private View f18500c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PictureActivity f18501a;

        a(PictureActivity pictureActivity) {
            this.f18501a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18501a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PictureActivity f18503a;

        b(PictureActivity pictureActivity) {
            this.f18503a = pictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18503a.onViewClicked(view);
        }
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity) {
        this(pictureActivity, pictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PictureActivity pictureActivity = this.f18498a;
        if (pictureActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18498a = null;
        pictureActivity.mTvTitle = null;
        pictureActivity.mRecyclerview = null;
        pictureActivity.mTvCommitTip = null;
        pictureActivity.mBtnCommit = null;
        this.f18499b.setOnClickListener(null);
        this.f18499b = null;
        this.f18500c.setOnClickListener(null);
        this.f18500c = null;
    }

    @UiThread
    public PictureActivity_ViewBinding(PictureActivity pictureActivity, View view) {
        this.f18498a = pictureActivity;
        pictureActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        pictureActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        pictureActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        pictureActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18499b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(pictureActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18500c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(pictureActivity));
    }
}
