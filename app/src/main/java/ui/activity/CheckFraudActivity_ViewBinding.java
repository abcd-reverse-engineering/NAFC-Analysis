package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CheckFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CheckFraudActivity f17927a;

    /* renamed from: b, reason: collision with root package name */
    private View f17928b;

    /* renamed from: c, reason: collision with root package name */
    private View f17929c;

    /* renamed from: d, reason: collision with root package name */
    private View f17930d;

    /* renamed from: e, reason: collision with root package name */
    private View f17931e;

    /* renamed from: f, reason: collision with root package name */
    private View f17932f;

    /* renamed from: g, reason: collision with root package name */
    private View f17933g;

    /* renamed from: h, reason: collision with root package name */
    private View f17934h;

    /* renamed from: i, reason: collision with root package name */
    private View f17935i;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17936a;

        a(CheckFraudActivity checkFraudActivity) {
            this.f17936a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17936a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17938a;

        b(CheckFraudActivity checkFraudActivity) {
            this.f17938a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17938a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17940a;

        c(CheckFraudActivity checkFraudActivity) {
            this.f17940a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17940a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17942a;

        d(CheckFraudActivity checkFraudActivity) {
            this.f17942a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17942a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17944a;

        e(CheckFraudActivity checkFraudActivity) {
            this.f17944a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17944a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17946a;

        f(CheckFraudActivity checkFraudActivity) {
            this.f17946a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17946a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17948a;

        g(CheckFraudActivity checkFraudActivity) {
            this.f17948a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17948a.onViewClicked(view);
        }
    }

    class h extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudActivity f17950a;

        h(CheckFraudActivity checkFraudActivity) {
            this.f17950a = checkFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17950a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckFraudActivity_ViewBinding(CheckFraudActivity checkFraudActivity) {
        this(checkFraudActivity, checkFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckFraudActivity checkFraudActivity = this.f17927a;
        if (checkFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17927a = null;
        checkFraudActivity.mIvBack = null;
        checkFraudActivity.mTvTitle = null;
        checkFraudActivity.mIvRight = null;
        checkFraudActivity.mEtContent = null;
        checkFraudActivity.mTvCount_tip = null;
        checkFraudActivity.mRbPay = null;
        checkFraudActivity.mRbUrl = null;
        checkFraudActivity.mRbChat = null;
        checkFraudActivity.mIvClear = null;
        checkFraudActivity.mTvScan = null;
        this.f17928b.setOnClickListener(null);
        this.f17928b = null;
        this.f17929c.setOnClickListener(null);
        this.f17929c = null;
        this.f17930d.setOnClickListener(null);
        this.f17930d = null;
        this.f17931e.setOnClickListener(null);
        this.f17931e = null;
        this.f17932f.setOnClickListener(null);
        this.f17932f = null;
        this.f17933g.setOnClickListener(null);
        this.f17933g = null;
        this.f17934h.setOnClickListener(null);
        this.f17934h = null;
        this.f17935i.setOnClickListener(null);
        this.f17935i = null;
    }

    @UiThread
    public CheckFraudActivity_ViewBinding(CheckFraudActivity checkFraudActivity, View view) {
        this.f17927a = checkFraudActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkFraudActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17928b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkFraudActivity));
        checkFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        checkFraudActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f17929c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkFraudActivity));
        checkFraudActivity.mEtContent = (EditText) Utils.findRequiredViewAsType(view, R.id.et_content, "field 'mEtContent'", EditText.class);
        checkFraudActivity.mTvCount_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count_tip, "field 'mTvCount_tip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_pay, "field 'mRbPay' and method 'onViewClicked'");
        checkFraudActivity.mRbPay = (RadioButton) Utils.castView(viewFindRequiredView3, R.id.rb_pay, "field 'mRbPay'", RadioButton.class);
        this.f17930d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkFraudActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rb_url, "field 'mRbUrl' and method 'onViewClicked'");
        checkFraudActivity.mRbUrl = (RadioButton) Utils.castView(viewFindRequiredView4, R.id.rb_url, "field 'mRbUrl'", RadioButton.class);
        this.f17931e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkFraudActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rb_chat, "field 'mRbChat' and method 'onViewClicked'");
        checkFraudActivity.mRbChat = (RadioButton) Utils.castView(viewFindRequiredView5, R.id.rb_chat, "field 'mRbChat'", RadioButton.class);
        this.f17932f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(checkFraudActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClear' and method 'onViewClicked'");
        checkFraudActivity.mIvClear = (ImageView) Utils.castView(viewFindRequiredView6, R.id.iv_clear, "field 'mIvClear'", ImageView.class);
        this.f17933g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(checkFraudActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.ll_scan, "field 'mTvScan' and method 'onViewClicked'");
        checkFraudActivity.mTvScan = (LinearLayout) Utils.castView(viewFindRequiredView7, R.id.ll_scan, "field 'mTvScan'", LinearLayout.class);
        this.f17934h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(checkFraudActivity));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.confirm, "method 'onViewClicked'");
        this.f17935i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(checkFraudActivity));
    }
}
