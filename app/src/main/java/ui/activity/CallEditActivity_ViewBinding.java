package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CallEditActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CallEditActivity f17747a;

    /* renamed from: b, reason: collision with root package name */
    private View f17748b;

    /* renamed from: c, reason: collision with root package name */
    private View f17749c;

    /* renamed from: d, reason: collision with root package name */
    private View f17750d;

    /* renamed from: e, reason: collision with root package name */
    private View f17751e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallEditActivity f17752a;

        a(CallEditActivity callEditActivity) {
            this.f17752a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17752a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallEditActivity f17754a;

        b(CallEditActivity callEditActivity) {
            this.f17754a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17754a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallEditActivity f17756a;

        c(CallEditActivity callEditActivity) {
            this.f17756a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17756a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallEditActivity f17758a;

        d(CallEditActivity callEditActivity) {
            this.f17758a = callEditActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17758a.onViewClicked(view);
        }
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity) {
        this(callEditActivity, callEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallEditActivity callEditActivity = this.f17747a;
        if (callEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17747a = null;
        callEditActivity.mTvTitle = null;
        callEditActivity.mBtnConfirm = null;
        callEditActivity.mEtVictimPhone = null;
        callEditActivity.mEtPhone = null;
        callEditActivity.mTvOccurTime = null;
        callEditActivity.mTvDuration = null;
        this.f17748b.setOnClickListener(null);
        this.f17748b = null;
        this.f17749c.setOnClickListener(null);
        this.f17749c = null;
        this.f17750d.setOnClickListener(null);
        this.f17750d = null;
        this.f17751e.setOnClickListener(null);
        this.f17751e = null;
    }

    @UiThread
    public CallEditActivity_ViewBinding(CallEditActivity callEditActivity, View view) {
        this.f17747a = callEditActivity;
        callEditActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onViewClicked'");
        callEditActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f17748b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callEditActivity));
        callEditActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        callEditActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_occur_time, "field 'mTvOccurTime' and method 'onViewClicked'");
        callEditActivity.mTvOccurTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_occur_time, "field 'mTvOccurTime'", TextView.class);
        this.f17749c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callEditActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_duration, "field 'mTvDuration' and method 'onViewClicked'");
        callEditActivity.mTvDuration = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_duration, "field 'mTvDuration'", TextView.class);
        this.f17750d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callEditActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17751e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callEditActivity));
    }
}
