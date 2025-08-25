package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class EvidenceDiscActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private EvidenceDiscActivity f18118a;

    /* renamed from: b, reason: collision with root package name */
    private View f18119b;

    /* renamed from: c, reason: collision with root package name */
    private View f18120c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EvidenceDiscActivity f18121a;

        a(EvidenceDiscActivity evidenceDiscActivity) {
            this.f18121a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18121a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EvidenceDiscActivity f18123a;

        b(EvidenceDiscActivity evidenceDiscActivity) {
            this.f18123a = evidenceDiscActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18123a.onViewClicked(view);
        }
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity) {
        this(evidenceDiscActivity, evidenceDiscActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EvidenceDiscActivity evidenceDiscActivity = this.f18118a;
        if (evidenceDiscActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18118a = null;
        evidenceDiscActivity.mIvBack = null;
        evidenceDiscActivity.mTvTitle = null;
        evidenceDiscActivity.mEtCaseDescribe = null;
        evidenceDiscActivity.mBtnCommit = null;
        this.f18119b.setOnClickListener(null);
        this.f18119b = null;
        this.f18120c.setOnClickListener(null);
        this.f18120c = null;
    }

    @UiThread
    public EvidenceDiscActivity_ViewBinding(EvidenceDiscActivity evidenceDiscActivity, View view) {
        this.f18118a = evidenceDiscActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        evidenceDiscActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18119b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(evidenceDiscActivity));
        evidenceDiscActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        evidenceDiscActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.ed_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        evidenceDiscActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18120c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(evidenceDiscActivity));
    }
}
