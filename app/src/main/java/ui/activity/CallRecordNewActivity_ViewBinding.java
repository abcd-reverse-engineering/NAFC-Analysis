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
public class CallRecordNewActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CallRecordNewActivity f17810a;

    /* renamed from: b, reason: collision with root package name */
    private View f17811b;

    /* renamed from: c, reason: collision with root package name */
    private View f17812c;

    /* renamed from: d, reason: collision with root package name */
    private View f17813d;

    /* renamed from: e, reason: collision with root package name */
    private View f17814e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordNewActivity f17815a;

        a(CallRecordNewActivity callRecordNewActivity) {
            this.f17815a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17815a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordNewActivity f17817a;

        b(CallRecordNewActivity callRecordNewActivity) {
            this.f17817a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17817a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordNewActivity f17819a;

        c(CallRecordNewActivity callRecordNewActivity) {
            this.f17819a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17819a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallRecordNewActivity f17821a;

        d(CallRecordNewActivity callRecordNewActivity) {
            this.f17821a = callRecordNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17821a.onViewClicked(view);
        }
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity) {
        this(callRecordNewActivity, callRecordNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallRecordNewActivity callRecordNewActivity = this.f17810a;
        if (callRecordNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17810a = null;
        callRecordNewActivity.mIvBack = null;
        callRecordNewActivity.mTvTitle = null;
        callRecordNewActivity.mRlTitle = null;
        callRecordNewActivity.mRecyclerview = null;
        callRecordNewActivity.mBtnReport = null;
        callRecordNewActivity.mTvChildTabMe = null;
        callRecordNewActivity.mVMe = null;
        callRecordNewActivity.mTvChildTabOther = null;
        callRecordNewActivity.mVOther = null;
        callRecordNewActivity.mTvTip = null;
        this.f17811b.setOnClickListener(null);
        this.f17811b = null;
        this.f17812c.setOnClickListener(null);
        this.f17812c = null;
        this.f17813d.setOnClickListener(null);
        this.f17813d = null;
        this.f17814e.setOnClickListener(null);
        this.f17814e = null;
    }

    @UiThread
    public CallRecordNewActivity_ViewBinding(CallRecordNewActivity callRecordNewActivity, View view) {
        this.f17810a = callRecordNewActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        callRecordNewActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17811b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callRecordNewActivity));
        callRecordNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callRecordNewActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        callRecordNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        callRecordNewActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f17812c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callRecordNewActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_child_tab_me, "field 'mTvChildTabMe' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabMe = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_child_tab_me, "field 'mTvChildTabMe'", TextView.class);
        this.f17813d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callRecordNewActivity));
        callRecordNewActivity.mVMe = Utils.findRequiredView(view, R.id.v_me, "field 'mVMe'");
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_child_tab_other, "field 'mTvChildTabOther' and method 'onViewClicked'");
        callRecordNewActivity.mTvChildTabOther = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_child_tab_other, "field 'mTvChildTabOther'", TextView.class);
        this.f17814e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callRecordNewActivity));
        callRecordNewActivity.mVOther = Utils.findRequiredView(view, R.id.v_other, "field 'mVOther'");
        callRecordNewActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
    }
}
