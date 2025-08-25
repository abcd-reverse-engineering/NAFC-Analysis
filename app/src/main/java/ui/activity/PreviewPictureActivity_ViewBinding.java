package ui.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class PreviewPictureActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PreviewPictureActivity f18549a;

    /* renamed from: b, reason: collision with root package name */
    private View f18550b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PreviewPictureActivity f18551a;

        a(PreviewPictureActivity previewPictureActivity) {
            this.f18551a = previewPictureActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18551a.onClick(view);
        }
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity) {
        this(previewPictureActivity, previewPictureActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        if (this.f18549a == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18549a = null;
        this.f18550b.setOnClickListener(null);
        this.f18550b = null;
    }

    @UiThread
    public PreviewPictureActivity_ViewBinding(PreviewPictureActivity previewPictureActivity, View view) {
        this.f18549a = previewPictureActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onClick'");
        this.f18550b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(previewPictureActivity));
    }
}
