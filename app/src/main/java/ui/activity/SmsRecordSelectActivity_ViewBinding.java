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
public class SmsRecordSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SmsRecordSelectActivity f19046a;

    /* renamed from: b, reason: collision with root package name */
    private View f19047b;

    /* renamed from: c, reason: collision with root package name */
    private View f19048c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsRecordSelectActivity f19049a;

        a(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.f19049a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19049a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmsRecordSelectActivity f19051a;

        b(SmsRecordSelectActivity smsRecordSelectActivity) {
            this.f19051a = smsRecordSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19051a.onViewClicked(view);
        }
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity) {
        this(smsRecordSelectActivity, smsRecordSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SmsRecordSelectActivity smsRecordSelectActivity = this.f19046a;
        if (smsRecordSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19046a = null;
        smsRecordSelectActivity.mIvBack = null;
        smsRecordSelectActivity.mTvTitle = null;
        smsRecordSelectActivity.mRlTitle = null;
        smsRecordSelectActivity.mRecyclerview = null;
        smsRecordSelectActivity.mBtnReport = null;
        this.f19047b.setOnClickListener(null);
        this.f19047b = null;
        this.f19048c.setOnClickListener(null);
        this.f19048c = null;
    }

    @UiThread
    public SmsRecordSelectActivity_ViewBinding(SmsRecordSelectActivity smsRecordSelectActivity, View view) {
        this.f19046a = smsRecordSelectActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        smsRecordSelectActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19047b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(smsRecordSelectActivity));
        smsRecordSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        smsRecordSelectActivity.mRlTitle = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
        smsRecordSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        smsRecordSelectActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f19048c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(smsRecordSelectActivity));
    }
}
