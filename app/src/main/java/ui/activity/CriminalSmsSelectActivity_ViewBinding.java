package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class CriminalSmsSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalSmsSelectActivity f18042a;

    /* renamed from: b, reason: collision with root package name */
    private View f18043b;

    /* renamed from: c, reason: collision with root package name */
    private View f18044c;

    /* renamed from: d, reason: collision with root package name */
    private View f18045d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsSelectActivity f18046a;

        a(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f18046a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18046a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsSelectActivity f18048a;

        b(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f18048a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18048a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsSelectActivity f18050a;

        c(CriminalSmsSelectActivity criminalSmsSelectActivity) {
            this.f18050a = criminalSmsSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18050a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity) {
        this(criminalSmsSelectActivity, criminalSmsSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsSelectActivity criminalSmsSelectActivity = this.f18042a;
        if (criminalSmsSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18042a = null;
        criminalSmsSelectActivity.mTvTitle = null;
        criminalSmsSelectActivity.mBtnCommit = null;
        criminalSmsSelectActivity.mEtVictimPhone = null;
        criminalSmsSelectActivity.mEtPhone = null;
        criminalSmsSelectActivity.mTvDescribe = null;
        criminalSmsSelectActivity.mTvTime = null;
        criminalSmsSelectActivity.mRbYes = null;
        criminalSmsSelectActivity.mRbNo = null;
        criminalSmsSelectActivity.mRecyclerview = null;
        criminalSmsSelectActivity.mLlPicture = null;
        this.f18043b.setOnClickListener(null);
        this.f18043b = null;
        this.f18044c.setOnClickListener(null);
        this.f18044c = null;
        this.f18045d.setOnClickListener(null);
        this.f18045d = null;
    }

    @UiThread
    public CriminalSmsSelectActivity_ViewBinding(CriminalSmsSelectActivity criminalSmsSelectActivity, View view) {
        this.f18042a = criminalSmsSelectActivity;
        criminalSmsSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsSelectActivity.mBtnCommit = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mBtnCommit'", TextView.class);
        this.f18043b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mEtVictimPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_victim_phone, "field 'mEtVictimPhone'", EditText.class);
        criminalSmsSelectActivity.mEtPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone, "field 'mEtPhone'", EditText.class);
        criminalSmsSelectActivity.mTvDescribe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_describe, "field 'mTvDescribe'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_time, "field 'mTvTime' and method 'onViewClicked'");
        criminalSmsSelectActivity.mTvTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_time, "field 'mTvTime'", TextView.class);
        this.f18044c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsSelectActivity));
        criminalSmsSelectActivity.mRbYes = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_yes, "field 'mRbYes'", RadioButton.class);
        criminalSmsSelectActivity.mRbNo = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_no, "field 'mRbNo'", RadioButton.class);
        criminalSmsSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsSelectActivity.mLlPicture = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_picture, "field 'mLlPicture'", LinearLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18045d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalSmsSelectActivity));
    }
}
