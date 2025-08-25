package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class AddCrimePhoneActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddCrimePhoneActivity f17611a;

    /* renamed from: b, reason: collision with root package name */
    private View f17612b;

    /* renamed from: c, reason: collision with root package name */
    private View f17613c;

    /* renamed from: d, reason: collision with root package name */
    private View f17614d;

    /* renamed from: e, reason: collision with root package name */
    private View f17615e;

    /* renamed from: f, reason: collision with root package name */
    private View f17616f;

    /* renamed from: g, reason: collision with root package name */
    private View f17617g;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17618a;

        a(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17618a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17618a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17620a;

        b(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17620a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17620a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17622a;

        c(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17622a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17622a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17624a;

        d(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17624a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17624a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17626a;

        e(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17626a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17626a.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddCrimePhoneActivity f17628a;

        f(AddCrimePhoneActivity addCrimePhoneActivity) {
            this.f17628a = addCrimePhoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17628a.onClick(view);
        }
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity) {
        this(addCrimePhoneActivity, addCrimePhoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AddCrimePhoneActivity addCrimePhoneActivity = this.f17611a;
        if (addCrimePhoneActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17611a = null;
        addCrimePhoneActivity.mIvBack = null;
        addCrimePhoneActivity.mTvTitle = null;
        addCrimePhoneActivity.mCallNum = null;
        addCrimePhoneActivity.mRecharge = null;
        addCrimePhoneActivity.mRelation = null;
        addCrimePhoneActivity.mDelivery = null;
        this.f17612b.setOnClickListener(null);
        this.f17612b = null;
        this.f17613c.setOnClickListener(null);
        this.f17613c = null;
        this.f17614d.setOnClickListener(null);
        this.f17614d = null;
        this.f17615e.setOnClickListener(null);
        this.f17615e = null;
        this.f17616f.setOnClickListener(null);
        this.f17616f = null;
        this.f17617g.setOnClickListener(null);
        this.f17617g = null;
    }

    @UiThread
    public AddCrimePhoneActivity_ViewBinding(AddCrimePhoneActivity addCrimePhoneActivity, View view) {
        this.f17611a = addCrimePhoneActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        addCrimePhoneActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17612b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addCrimePhoneActivity));
        addCrimePhoneActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        addCrimePhoneActivity.mCallNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_call_num, "field 'mCallNum'", TextView.class);
        addCrimePhoneActivity.mRecharge = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recharge_num, "field 'mRecharge'", TextView.class);
        addCrimePhoneActivity.mRelation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_relation_num, "field 'mRelation'", TextView.class);
        addCrimePhoneActivity.mDelivery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_delivery_num, "field 'mDelivery'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_type_phone, "method 'onClick'");
        this.f17613c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(addCrimePhoneActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_type_recharge, "method 'onClick'");
        this.f17614d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(addCrimePhoneActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_type_relation, "method 'onClick'");
        this.f17615e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(addCrimePhoneActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rl_type_delivery, "method 'onClick'");
        this.f17616f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(addCrimePhoneActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f17617g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(addCrimePhoneActivity));
    }
}
