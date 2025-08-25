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
public class IDVarfyFaceActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private IDVarfyFaceActivity f18238a;

    /* renamed from: b, reason: collision with root package name */
    private View f18239b;

    /* renamed from: c, reason: collision with root package name */
    private View f18240c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDVarfyFaceActivity f18241a;

        a(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.f18241a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18241a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDVarfyFaceActivity f18243a;

        b(IDVarfyFaceActivity iDVarfyFaceActivity) {
            this.f18243a = iDVarfyFaceActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18243a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity) {
        this(iDVarfyFaceActivity, iDVarfyFaceActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyFaceActivity iDVarfyFaceActivity = this.f18238a;
        if (iDVarfyFaceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18238a = null;
        iDVarfyFaceActivity.mIvBack = null;
        iDVarfyFaceActivity.mTvTitle = null;
        this.f18239b.setOnClickListener(null);
        this.f18239b = null;
        this.f18240c.setOnClickListener(null);
        this.f18240c = null;
    }

    @UiThread
    public IDVarfyFaceActivity_ViewBinding(IDVarfyFaceActivity iDVarfyFaceActivity, View view) {
        this.f18238a = iDVarfyFaceActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        iDVarfyFaceActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18239b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDVarfyFaceActivity));
        iDVarfyFaceActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_firm, "method 'onViewClicked'");
        this.f18240c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(iDVarfyFaceActivity));
    }
}
