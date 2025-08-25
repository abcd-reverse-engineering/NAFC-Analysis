package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CallRecordActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CallRecordActivity f17788a;

    /* renamed from: b, reason: collision with root package name */
    private View f17789b;

    /* renamed from: c, reason: collision with root package name */
    private View f17790c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordActivity f17791a;

        a(CallRecordActivity callRecordActivity) {
            this.f17791a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17791a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordActivity f17793a;

        b(CallRecordActivity callRecordActivity) {
            this.f17793a = callRecordActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17793a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity) {
        this(callRecordActivity, callRecordActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordActivity callRecordActivity = this.f17788a;
        if (callRecordActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17788a = null;
        callRecordActivity.mIvBack = null;
        callRecordActivity.mTvTitle = null;
        callRecordActivity.mRlTitle = null;
        callRecordActivity.mRecyclerview = null;
        callRecordActivity.mBtnReport = null;
        this.f17789b.setOnClickListener(null);
        this.f17789b = null;
        this.f17790c.setOnClickListener(null);
        this.f17790c = null;
    }

    @UiThread
    public CallRecordActivity_ViewBinding(CallRecordActivity callRecordActivity, View view) {
        this.f17788a = callRecordActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17789b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callRecordActivity));
        callRecordActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f17790c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callRecordActivity));
    }
}
