package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class VerifyFaceActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VerifyFaceActivity f19174a;

    /* renamed from: b, reason: collision with root package name */
    private View f19175b;

    /* renamed from: c, reason: collision with root package name */
    private View f19176c;

    /* renamed from: d, reason: collision with root package name */
    private View f19177d;

    /* renamed from: e, reason: collision with root package name */
    private View f19178e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyFaceActivity f19179a;

        a(VerifyFaceActivity verifyFaceActivity) {
            this.f19179a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19179a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyFaceActivity f19181a;

        b(VerifyFaceActivity verifyFaceActivity) {
            this.f19181a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19181a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyFaceActivity f19183a;

        c(VerifyFaceActivity verifyFaceActivity) {
            this.f19183a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19183a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VerifyFaceActivity f19185a;

        d(VerifyFaceActivity verifyFaceActivity) {
            this.f19185a = verifyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19185a.onViewClicked(view);
        }
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity) {
        this(verifyFaceActivity, verifyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VerifyFaceActivity verifyFaceActivity = this.f19174a;
        if (verifyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19174a = null;
        verifyFaceActivity.mIvBack = null;
        verifyFaceActivity.mTvTitle = null;
        verifyFaceActivity.mTvRight = null;
        verifyFaceActivity.mTvCardType = null;
        verifyFaceActivity.mUserName = null;
        verifyFaceActivity.mUserID = null;
        verifyFaceActivity.mConfirm = null;
        this.f19175b.setOnClickListener(null);
        this.f19175b = null;
        this.f19176c.setOnClickListener(null);
        this.f19176c = null;
        this.f19177d.setOnClickListener(null);
        this.f19177d = null;
        this.f19178e.setOnClickListener(null);
        this.f19178e = null;
    }

    @UiThread
    public VerifyFaceActivity_ViewBinding(VerifyFaceActivity verifyFaceActivity, View view) {
        this.f19174a = verifyFaceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        verifyFaceActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19175b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(verifyFaceActivity));
        verifyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_right, "field 'mTvRight' and method 'onViewClicked'");
        verifyFaceActivity.mTvRight = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_right, "field 'mTvRight'", TextView.class);
        this.f19176c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(verifyFaceActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_card_type, "field 'mTvCardType' and method 'onViewClicked'");
        verifyFaceActivity.mTvCardType = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_card_type, "field 'mTvCardType'", TextView.class);
        this.f19177d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(verifyFaceActivity));
        verifyFaceActivity.mUserName = (EditText) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'mUserName'", EditText.class);
        verifyFaceActivity.mUserID = (EditText) Utils.findRequiredViewAsType(view, R.id.user_ID, "field 'mUserID'", EditText.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        verifyFaceActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView4, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f19178e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(verifyFaceActivity));
    }
}
