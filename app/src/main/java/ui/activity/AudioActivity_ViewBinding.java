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
public class AudioActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AudioActivity f17684a;

    /* renamed from: b, reason: collision with root package name */
    private View f17685b;

    /* renamed from: c, reason: collision with root package name */
    private View f17686c;

    /* renamed from: d, reason: collision with root package name */
    private View f17687d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioActivity f17688a;

        a(AudioActivity audioActivity) {
            this.f17688a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17688a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioActivity f17690a;

        b(AudioActivity audioActivity) {
            this.f17690a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17690a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioActivity f17692a;

        c(AudioActivity audioActivity) {
            this.f17692a = audioActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17692a.onViewClicked(view);
        }
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity) {
        this(audioActivity, audioActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AudioActivity audioActivity = this.f17684a;
        if (audioActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17684a = null;
        audioActivity.mTvTitle = null;
        audioActivity.mRecyclerview = null;
        audioActivity.mTvSelectTip = null;
        audioActivity.mTvCommitTip = null;
        audioActivity.mBtnCommit = null;
        this.f17685b.setOnClickListener(null);
        this.f17685b = null;
        this.f17686c.setOnClickListener(null);
        this.f17686c = null;
        this.f17687d.setOnClickListener(null);
        this.f17687d = null;
    }

    @UiThread
    public AudioActivity_ViewBinding(AudioActivity audioActivity, View view) {
        this.f17684a = audioActivity;
        audioActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        audioActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        audioActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        audioActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        audioActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f17685b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(audioActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17686c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(audioActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f17687d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(audioActivity));
    }
}
