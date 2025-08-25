package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class ChatFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ChatFraudActivity f17912a;

    /* renamed from: b, reason: collision with root package name */
    private View f17913b;

    /* renamed from: c, reason: collision with root package name */
    private View f17914c;

    /* renamed from: d, reason: collision with root package name */
    private View f17915d;

    /* renamed from: e, reason: collision with root package name */
    private View f17916e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatFraudActivity f17917a;

        a(ChatFraudActivity chatFraudActivity) {
            this.f17917a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17917a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatFraudActivity f17919a;

        b(ChatFraudActivity chatFraudActivity) {
            this.f17919a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17919a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatFraudActivity f17921a;

        c(ChatFraudActivity chatFraudActivity) {
            this.f17921a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17921a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChatFraudActivity f17923a;

        d(ChatFraudActivity chatFraudActivity) {
            this.f17923a = chatFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17923a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatFraudActivity_ViewBinding(ChatFraudActivity chatFraudActivity) {
        this(chatFraudActivity, chatFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatFraudActivity chatFraudActivity = this.f17912a;
        if (chatFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17912a = null;
        chatFraudActivity.mTvTitle = null;
        chatFraudActivity.mRgChat = null;
        chatFraudActivity.mRbWx = null;
        chatFraudActivity.mRbQQ = null;
        chatFraudActivity.mTvAccNum = null;
        chatFraudActivity.mRegion = null;
        chatFraudActivity.mTvDuperyType = null;
        chatFraudActivity.mEtCaseDescribe = null;
        this.f17913b.setOnClickListener(null);
        this.f17913b = null;
        this.f17914c.setOnClickListener(null);
        this.f17914c = null;
        this.f17915d.setOnClickListener(null);
        this.f17915d = null;
        this.f17916e.setOnClickListener(null);
        this.f17916e = null;
    }

    @UiThread
    public ChatFraudActivity_ViewBinding(ChatFraudActivity chatFraudActivity, View view) {
        this.f17912a = chatFraudActivity;
        chatFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        chatFraudActivity.mRgChat = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_chat, "field 'mRgChat'", RadioGroup.class);
        chatFraudActivity.mRbWx = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_wx, "field 'mRbWx'", RadioButton.class);
        chatFraudActivity.mRbQQ = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_qq, "field 'mRbQQ'", RadioButton.class);
        chatFraudActivity.mTvAccNum = (TextView) Utils.findRequiredViewAsType(view, R.id.trad_fraud_num, "field 'mTvAccNum'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.region, "field 'mRegion' and method 'onViewClicked'");
        chatFraudActivity.mRegion = (TextView) Utils.castView(viewFindRequiredView, R.id.region, "field 'mRegion'", TextView.class);
        this.f17913b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(chatFraudActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        chatFraudActivity.mTvDuperyType = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f17914c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(chatFraudActivity));
        chatFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17915d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(chatFraudActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f17916e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(chatFraudActivity));
    }
}
