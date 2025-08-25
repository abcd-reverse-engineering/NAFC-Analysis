package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class LogoutActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LogoutActivity f18296a;

    /* renamed from: b, reason: collision with root package name */
    private View f18297b;

    /* renamed from: c, reason: collision with root package name */
    private View f18298c;

    /* renamed from: d, reason: collision with root package name */
    private View f18299d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutActivity f18300a;

        a(LogoutActivity logoutActivity) {
            this.f18300a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18300a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutActivity f18302a;

        b(LogoutActivity logoutActivity) {
            this.f18302a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18302a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutActivity f18304a;

        c(LogoutActivity logoutActivity) {
            this.f18304a = logoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18304a.onClick(view);
        }
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity) {
        this(logoutActivity, logoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutActivity logoutActivity = this.f18296a;
        if (logoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18296a = null;
        logoutActivity.mIvBack = null;
        logoutActivity.mTvTitle = null;
        this.f18297b.setOnClickListener(null);
        this.f18297b = null;
        this.f18298c.setOnClickListener(null);
        this.f18298c = null;
        this.f18299d.setOnClickListener(null);
        this.f18299d = null;
    }

    @UiThread
    public LogoutActivity_ViewBinding(LogoutActivity logoutActivity, View view) {
        this.f18296a = logoutActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18297b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutActivity));
        logoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_logout, "method 'onClick'");
        this.f18298c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onClick'");
        this.f18299d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutActivity));
    }
}
