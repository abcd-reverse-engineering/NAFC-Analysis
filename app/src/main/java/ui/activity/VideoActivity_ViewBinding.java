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
public class VideoActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VideoActivity f19213a;

    /* renamed from: b, reason: collision with root package name */
    private View f19214b;

    /* renamed from: c, reason: collision with root package name */
    private View f19215c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoActivity f19216a;

        a(VideoActivity videoActivity) {
            this.f19216a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19216a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoActivity f19218a;

        b(VideoActivity videoActivity) {
            this.f19218a = videoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19218a.onViewClicked(view);
        }
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity) {
        this(videoActivity, videoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoActivity videoActivity = this.f19213a;
        if (videoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19213a = null;
        videoActivity.mTvTitle = null;
        videoActivity.mRecyclerview = null;
        videoActivity.mTvCommitTip = null;
        videoActivity.mBtnCommit = null;
        this.f19214b.setOnClickListener(null);
        this.f19214b = null;
        this.f19215c.setOnClickListener(null);
        this.f19215c = null;
    }

    @UiThread
    public VideoActivity_ViewBinding(VideoActivity videoActivity, View view) {
        this.f19213a = videoActivity;
        videoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        videoActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        videoActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        videoActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19214b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(videoActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19215c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(videoActivity));
    }
}
