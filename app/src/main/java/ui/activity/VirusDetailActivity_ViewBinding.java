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
public class VirusDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VirusDetailActivity f19225a;

    /* renamed from: b, reason: collision with root package name */
    private View f19226b;

    /* renamed from: c, reason: collision with root package name */
    private View f19227c;

    /* renamed from: d, reason: collision with root package name */
    private View f19228d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusDetailActivity f19229a;

        a(VirusDetailActivity virusDetailActivity) {
            this.f19229a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19229a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusDetailActivity f19231a;

        b(VirusDetailActivity virusDetailActivity) {
            this.f19231a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19231a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusDetailActivity f19233a;

        c(VirusDetailActivity virusDetailActivity) {
            this.f19233a = virusDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19233a.onViewClicked(view);
        }
    }

    @UiThread
    public VirusDetailActivity_ViewBinding(VirusDetailActivity virusDetailActivity) {
        this(virusDetailActivity, virusDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VirusDetailActivity virusDetailActivity = this.f19225a;
        if (virusDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19225a = null;
        virusDetailActivity.mTvTitle = null;
        virusDetailActivity.mImageview = null;
        virusDetailActivity.mTvAppName = null;
        virusDetailActivity.mTvAppVersion = null;
        virusDetailActivity.mTvRiskFlag = null;
        virusDetailActivity.mTvVirusName = null;
        virusDetailActivity.mTvDescribe = null;
        virusDetailActivity.mTvDelete = null;
        this.f19226b.setOnClickListener(null);
        this.f19226b = null;
        this.f19227c.setOnClickListener(null);
        this.f19227c = null;
        this.f19228d.setOnClickListener(null);
        this.f19228d = null;
    }

    @UiThread
    public VirusDetailActivity_ViewBinding(VirusDetailActivity virusDetailActivity, View view) {
        this.f19225a = virusDetailActivity;
        virusDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        virusDetailActivity.mImageview = (ImageView) Utils.findRequiredViewAsType(view, R.id.imageview, "field 'mImageview'", ImageView.class);
        virusDetailActivity.mTvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'mTvAppName'", TextView.class);
        virusDetailActivity.mTvAppVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_version, "field 'mTvAppVersion'", TextView.class);
        virusDetailActivity.mTvRiskFlag = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_risk_flag, "field 'mTvRiskFlag'", TextView.class);
        virusDetailActivity.mTvVirusName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'mTvVirusName'", TextView.class);
        virusDetailActivity.mTvDescribe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_describe, "field 'mTvDescribe'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_delete, "field 'mTvDelete' and method 'onViewClicked'");
        virusDetailActivity.mTvDelete = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_delete, "field 'mTvDelete'", TextView.class);
        this.f19226b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(virusDetailActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19227c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(virusDetailActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_appeal, "method 'onViewClicked'");
        this.f19228d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(virusDetailActivity));
    }
}
