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
public class ManualCheckActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ManualCheckActivity f18357a;

    /* renamed from: b, reason: collision with root package name */
    private View f18358b;

    /* renamed from: c, reason: collision with root package name */
    private View f18359c;

    /* renamed from: d, reason: collision with root package name */
    private View f18360d;

    /* renamed from: e, reason: collision with root package name */
    private View f18361e;

    /* renamed from: f, reason: collision with root package name */
    private View f18362f;

    /* renamed from: g, reason: collision with root package name */
    private View f18363g;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18364a;

        a(ManualCheckActivity manualCheckActivity) {
            this.f18364a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18364a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18366a;

        b(ManualCheckActivity manualCheckActivity) {
            this.f18366a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18366a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18368a;

        c(ManualCheckActivity manualCheckActivity) {
            this.f18368a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18368a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18370a;

        d(ManualCheckActivity manualCheckActivity) {
            this.f18370a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18370a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18372a;

        e(ManualCheckActivity manualCheckActivity) {
            this.f18372a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18372a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualCheckActivity f18374a;

        f(ManualCheckActivity manualCheckActivity) {
            this.f18374a = manualCheckActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18374a.onViewClicked(view);
        }
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity) {
        this(manualCheckActivity, manualCheckActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ManualCheckActivity manualCheckActivity = this.f18357a;
        if (manualCheckActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18357a = null;
        manualCheckActivity.mTvTitle = null;
        manualCheckActivity.mTvTips = null;
        manualCheckActivity.mIvUploadPicZ = null;
        manualCheckActivity.mIvUploadPicF = null;
        manualCheckActivity.mIvConfirm = null;
        this.f18358b.setOnClickListener(null);
        this.f18358b = null;
        this.f18359c.setOnClickListener(null);
        this.f18359c = null;
        this.f18360d.setOnClickListener(null);
        this.f18360d = null;
        this.f18361e.setOnClickListener(null);
        this.f18361e = null;
        this.f18362f.setOnClickListener(null);
        this.f18362f = null;
        this.f18363g.setOnClickListener(null);
        this.f18363g = null;
    }

    @UiThread
    public ManualCheckActivity_ViewBinding(ManualCheckActivity manualCheckActivity, View view) {
        this.f18357a = manualCheckActivity;
        manualCheckActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualCheckActivity.mTvTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'mTvTips'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_upload_pic_z, "field 'mIvUploadPicZ' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicZ = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_upload_pic_z, "field 'mIvUploadPicZ'", ImageView.class);
        this.f18358b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(manualCheckActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_upload_pic_f, "field 'mIvUploadPicF' and method 'onViewClicked'");
        manualCheckActivity.mIvUploadPicF = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_upload_pic_f, "field 'mIvUploadPicF'", ImageView.class);
        this.f18359c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(manualCheckActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.confirm, "field 'mIvConfirm' and method 'onViewClicked'");
        manualCheckActivity.mIvConfirm = (TextView) Utils.castView(viewFindRequiredView3, R.id.confirm, "field 'mIvConfirm'", TextView.class);
        this.f18360d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(manualCheckActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18361e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(manualCheckActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.fl_upload_pic_z, "method 'onViewClicked'");
        this.f18362f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(manualCheckActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.fl_upload_pic_f, "method 'onViewClicked'");
        this.f18363g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(manualCheckActivity));
    }
}
