package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AppUploadActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AppUploadActivity f17678a;

    /* renamed from: b, reason: collision with root package name */
    private View f17679b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppUploadActivity f17680a;

        a(AppUploadActivity appUploadActivity) {
            this.f17680a = appUploadActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17680a.onViewClicked(view);
        }
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity) {
        this(appUploadActivity, appUploadActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppUploadActivity appUploadActivity = this.f17678a;
        if (appUploadActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17678a = null;
        appUploadActivity.mTvTitle = null;
        appUploadActivity.mRecyclerview = null;
        this.f17679b.setOnClickListener(null);
        this.f17679b = null;
    }

    @UiThread
    public AppUploadActivity_ViewBinding(AppUploadActivity appUploadActivity, View view) {
        this.f17678a = appUploadActivity;
        appUploadActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        appUploadActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17679b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appUploadActivity));
    }
}
