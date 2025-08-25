package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class UrlFraudActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private UrlFraudActivity f19151a;

    /* renamed from: b, reason: collision with root package name */
    private View f19152b;

    /* renamed from: c, reason: collision with root package name */
    private View f19153c;

    /* renamed from: d, reason: collision with root package name */
    private View f19154d;

    /* renamed from: e, reason: collision with root package name */
    private View f19155e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UrlFraudActivity f19156a;

        a(UrlFraudActivity urlFraudActivity) {
            this.f19156a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19156a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UrlFraudActivity f19158a;

        b(UrlFraudActivity urlFraudActivity) {
            this.f19158a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19158a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UrlFraudActivity f19160a;

        c(UrlFraudActivity urlFraudActivity) {
            this.f19160a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19160a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UrlFraudActivity f19162a;

        d(UrlFraudActivity urlFraudActivity) {
            this.f19162a = urlFraudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19162a.onViewClicked(view);
        }
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity) {
        this(urlFraudActivity, urlFraudActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UrlFraudActivity urlFraudActivity = this.f19151a;
        if (urlFraudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19151a = null;
        urlFraudActivity.mTvTitle = null;
        urlFraudActivity.mFraudNum = null;
        urlFraudActivity.mRegion = null;
        urlFraudActivity.mTvDuperyType = null;
        urlFraudActivity.mEtCaseDescribe = null;
        this.f19152b.setOnClickListener(null);
        this.f19152b = null;
        this.f19153c.setOnClickListener(null);
        this.f19153c = null;
        this.f19154d.setOnClickListener(null);
        this.f19154d = null;
        this.f19155e.setOnClickListener(null);
        this.f19155e = null;
    }

    @UiThread
    public UrlFraudActivity_ViewBinding(UrlFraudActivity urlFraudActivity, View view) {
        this.f19151a = urlFraudActivity;
        urlFraudActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        urlFraudActivity.mFraudNum = (TextView) Utils.findRequiredViewAsType(view, R.id.fraud_num, "field 'mFraudNum'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.region, "field 'mRegion' and method 'onViewClicked'");
        urlFraudActivity.mRegion = (TextView) Utils.castView(viewFindRequiredView, R.id.region, "field 'mRegion'", TextView.class);
        this.f19152b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(urlFraudActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_dupery_type, "field 'mTvDuperyType' and method 'onViewClicked'");
        urlFraudActivity.mTvDuperyType = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_dupery_type, "field 'mTvDuperyType'", TextView.class);
        this.f19153c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(urlFraudActivity));
        urlFraudActivity.mEtCaseDescribe = (EditText) Utils.findRequiredViewAsType(view, R.id.et_case_describe, "field 'mEtCaseDescribe'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19154d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(urlFraudActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onViewClicked'");
        this.f19155e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(urlFraudActivity));
    }
}
