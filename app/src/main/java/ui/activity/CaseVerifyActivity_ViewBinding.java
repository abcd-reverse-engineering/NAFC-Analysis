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
public class CaseVerifyActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CaseVerifyActivity f17904a;

    /* renamed from: b, reason: collision with root package name */
    private View f17905b;

    /* renamed from: c, reason: collision with root package name */
    private View f17906c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseVerifyActivity f17907a;

        a(CaseVerifyActivity caseVerifyActivity) {
            this.f17907a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17907a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CaseVerifyActivity f17909a;

        b(CaseVerifyActivity caseVerifyActivity) {
            this.f17909a = caseVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17909a.onViewClicked(view);
        }
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity) {
        this(caseVerifyActivity, caseVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CaseVerifyActivity caseVerifyActivity = this.f17904a;
        if (caseVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17904a = null;
        caseVerifyActivity.mTvTitle = null;
        caseVerifyActivity.mEtName = null;
        caseVerifyActivity.mEtID = null;
        this.f17905b.setOnClickListener(null);
        this.f17905b = null;
        this.f17906c.setOnClickListener(null);
        this.f17906c = null;
    }

    @UiThread
    public CaseVerifyActivity_ViewBinding(CaseVerifyActivity caseVerifyActivity, View view) {
        this.f17904a = caseVerifyActivity;
        caseVerifyActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        caseVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        caseVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, R.id.et_ID, "field 'mEtID'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17905b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(caseVerifyActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_start, "method 'onViewClicked'");
        this.f17906c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(caseVerifyActivity));
    }
}
