package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class BeforIdVerifyActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private BeforIdVerifyActivity f17719a;

    /* renamed from: b, reason: collision with root package name */
    private View f17720b;

    /* renamed from: c, reason: collision with root package name */
    private View f17721c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BeforIdVerifyActivity f17722a;

        a(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.f17722a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17722a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BeforIdVerifyActivity f17724a;

        b(BeforIdVerifyActivity beforIdVerifyActivity) {
            this.f17724a = beforIdVerifyActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17724a.onViewClicked(view);
        }
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity) {
        this(beforIdVerifyActivity, beforIdVerifyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BeforIdVerifyActivity beforIdVerifyActivity = this.f17719a;
        if (beforIdVerifyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17719a = null;
        beforIdVerifyActivity.mIvBack = null;
        beforIdVerifyActivity.mEtName = null;
        beforIdVerifyActivity.mEtID = null;
        beforIdVerifyActivity.mStart = null;
        this.f17720b.setOnClickListener(null);
        this.f17720b = null;
        this.f17721c.setOnClickListener(null);
        this.f17721c = null;
    }

    @UiThread
    public BeforIdVerifyActivity_ViewBinding(BeforIdVerifyActivity beforIdVerifyActivity, View view) {
        this.f17719a = beforIdVerifyActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        beforIdVerifyActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17720b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(beforIdVerifyActivity));
        beforIdVerifyActivity.mEtName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_name, "field 'mEtName'", EditText.class);
        beforIdVerifyActivity.mEtID = (EditText) Utils.findRequiredViewAsType(view, R.id.et_ID, "field 'mEtID'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_start, "field 'mStart' and method 'onViewClicked'");
        beforIdVerifyActivity.mStart = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_start, "field 'mStart'", Button.class);
        this.f17721c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(beforIdVerifyActivity));
    }
}
