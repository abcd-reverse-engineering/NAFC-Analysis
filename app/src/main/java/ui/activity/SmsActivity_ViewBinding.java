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
public class SmsActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SmsActivity f19000a;

    /* renamed from: b, reason: collision with root package name */
    private View f19001b;

    /* renamed from: c, reason: collision with root package name */
    private View f19002c;

    /* renamed from: d, reason: collision with root package name */
    private View f19003d;

    /* renamed from: e, reason: collision with root package name */
    private View f19004e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsActivity f19005a;

        a(SmsActivity smsActivity) {
            this.f19005a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19005a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsActivity f19007a;

        b(SmsActivity smsActivity) {
            this.f19007a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19007a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsActivity f19009a;

        c(SmsActivity smsActivity) {
            this.f19009a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19009a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsActivity f19011a;

        d(SmsActivity smsActivity) {
            this.f19011a = smsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19011a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity) {
        this(smsActivity, smsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsActivity smsActivity = this.f19000a;
        if (smsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19000a = null;
        smsActivity.mTvTitle = null;
        smsActivity.mRecyclerview = null;
        smsActivity.mTvSelectTip = null;
        smsActivity.mTvCommitTip = null;
        smsActivity.mBtnCommit = null;
        smsActivity.mTvInputTip = null;
        this.f19001b.setOnClickListener(null);
        this.f19001b = null;
        this.f19002c.setOnClickListener(null);
        this.f19002c = null;
        this.f19003d.setOnClickListener(null);
        this.f19003d = null;
        this.f19004e.setOnClickListener(null);
        this.f19004e = null;
    }

    @UiThread
    public SmsActivity_ViewBinding(SmsActivity smsActivity, View view) {
        this.f19000a = smsActivity;
        smsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        smsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        smsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        smsActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f19001b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsActivity));
        smsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19002c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f19003d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(smsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f19004e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(smsActivity));
    }
}
