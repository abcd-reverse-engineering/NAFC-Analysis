package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class PersonalInfoAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PersonalInfoAddActivity f18487a;

    /* renamed from: b, reason: collision with root package name */
    private View f18488b;

    /* renamed from: c, reason: collision with root package name */
    private View f18489c;

    /* renamed from: d, reason: collision with root package name */
    private View f18490d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalInfoAddActivity f18491a;

        a(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f18491a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18491a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalInfoAddActivity f18493a;

        b(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f18493a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18493a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PersonalInfoAddActivity f18495a;

        c(PersonalInfoAddActivity personalInfoAddActivity) {
            this.f18495a = personalInfoAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18495a.onClick(view);
        }
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity) {
        this(personalInfoAddActivity, personalInfoAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PersonalInfoAddActivity personalInfoAddActivity = this.f18487a;
        if (personalInfoAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18487a = null;
        personalInfoAddActivity.mIvBack = null;
        personalInfoAddActivity.mTvTitle = null;
        personalInfoAddActivity.mClArea = null;
        personalInfoAddActivity.mClAreaDetail = null;
        personalInfoAddActivity.mEtArea = null;
        personalInfoAddActivity.mEtAddres = null;
        personalInfoAddActivity.mBtnConfirm = null;
        this.f18488b.setOnClickListener(null);
        this.f18488b = null;
        this.f18489c.setOnClickListener(null);
        this.f18489c = null;
        this.f18490d.setOnClickListener(null);
        this.f18490d = null;
    }

    @UiThread
    public PersonalInfoAddActivity_ViewBinding(PersonalInfoAddActivity personalInfoAddActivity, View view) {
        this.f18487a = personalInfoAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        personalInfoAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18488b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(personalInfoAddActivity));
        personalInfoAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        personalInfoAddActivity.mClArea = Utils.findRequiredView(view, R.id.cl_area_cont, "field 'mClArea'");
        personalInfoAddActivity.mClAreaDetail = Utils.findRequiredView(view, R.id.cl_area_detail_content, "field 'mClAreaDetail'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.et_area, "field 'mEtArea' and method 'onClick'");
        personalInfoAddActivity.mEtArea = (TextView) Utils.castView(viewFindRequiredView2, R.id.et_area, "field 'mEtArea'", TextView.class);
        this.f18489c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(personalInfoAddActivity));
        personalInfoAddActivity.mEtAddres = (EditText) Utils.findRequiredViewAsType(view, R.id.et_address, "field 'mEtAddres'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_confirm, "field 'mBtnConfirm' and method 'onClick'");
        personalInfoAddActivity.mBtnConfirm = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_confirm, "field 'mBtnConfirm'", Button.class);
        this.f18490d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(personalInfoAddActivity));
    }
}
