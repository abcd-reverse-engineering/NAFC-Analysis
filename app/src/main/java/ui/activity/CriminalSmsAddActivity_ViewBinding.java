package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CriminalSmsAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalSmsAddActivity f18032a;

    /* renamed from: b, reason: collision with root package name */
    private View f18033b;

    /* renamed from: c, reason: collision with root package name */
    private View f18034c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsAddActivity f18035a;

        a(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.f18035a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18035a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsAddActivity f18037a;

        b(CriminalSmsAddActivity criminalSmsAddActivity) {
            this.f18037a = criminalSmsAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18037a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity) {
        this(criminalSmsAddActivity, criminalSmsAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsAddActivity criminalSmsAddActivity = this.f18032a;
        if (criminalSmsAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18032a = null;
        criminalSmsAddActivity.mTvTitle = null;
        criminalSmsAddActivity.mTvType = null;
        this.f18033b.setOnClickListener(null);
        this.f18033b = null;
        this.f18034c.setOnClickListener(null);
        this.f18034c = null;
    }

    @UiThread
    public CriminalSmsAddActivity_ViewBinding(CriminalSmsAddActivity criminalSmsAddActivity, View view) {
        this.f18032a = criminalSmsAddActivity;
        criminalSmsAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_type, "field 'mTvType' and method 'onViewClicked'");
        criminalSmsAddActivity.mTvType = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_type, "field 'mTvType'", TextView.class);
        this.f18033b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsAddActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18034c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsAddActivity));
    }
}
