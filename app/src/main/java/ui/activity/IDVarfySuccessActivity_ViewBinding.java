package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class IDVarfySuccessActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private IDVarfySuccessActivity f18250a;

    /* renamed from: b, reason: collision with root package name */
    private View f18251b;

    /* renamed from: c, reason: collision with root package name */
    private View f18252c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDVarfySuccessActivity f18253a;

        a(IDVarfySuccessActivity iDVarfySuccessActivity) {
            this.f18253a = iDVarfySuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18253a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDVarfySuccessActivity f18255a;

        b(IDVarfySuccessActivity iDVarfySuccessActivity) {
            this.f18255a = iDVarfySuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18255a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfySuccessActivity_ViewBinding(IDVarfySuccessActivity iDVarfySuccessActivity) {
        this(iDVarfySuccessActivity, iDVarfySuccessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfySuccessActivity iDVarfySuccessActivity = this.f18250a;
        if (iDVarfySuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18250a = null;
        iDVarfySuccessActivity.mIvBack = null;
        iDVarfySuccessActivity.mTvTitle = null;
        iDVarfySuccessActivity.mTvTips = null;
        this.f18251b.setOnClickListener(null);
        this.f18251b = null;
        this.f18252c.setOnClickListener(null);
        this.f18252c = null;
    }

    @UiThread
    public IDVarfySuccessActivity_ViewBinding(IDVarfySuccessActivity iDVarfySuccessActivity, View view) {
        this.f18250a = iDVarfySuccessActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        iDVarfySuccessActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18251b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDVarfySuccessActivity));
        iDVarfySuccessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfySuccessActivity.mTvTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'mTvTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_idvrfy_start, "method 'onViewClicked'");
        this.f18252c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(iDVarfySuccessActivity));
    }
}
