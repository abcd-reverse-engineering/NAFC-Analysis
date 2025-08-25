package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class LogoutConfirmActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LogoutConfirmActivity f18306a;

    /* renamed from: b, reason: collision with root package name */
    private View f18307b;

    /* renamed from: c, reason: collision with root package name */
    private View f18308c;

    /* renamed from: d, reason: collision with root package name */
    private View f18309d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutConfirmActivity f18310a;

        a(LogoutConfirmActivity logoutConfirmActivity) {
            this.f18310a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18310a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutConfirmActivity f18312a;

        b(LogoutConfirmActivity logoutConfirmActivity) {
            this.f18312a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18312a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutConfirmActivity f18314a;

        c(LogoutConfirmActivity logoutConfirmActivity) {
            this.f18314a = logoutConfirmActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18314a.onClick(view);
        }
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity) {
        this(logoutConfirmActivity, logoutConfirmActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutConfirmActivity logoutConfirmActivity = this.f18306a;
        if (logoutConfirmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18306a = null;
        logoutConfirmActivity.mIvBack = null;
        logoutConfirmActivity.mTvTitle = null;
        logoutConfirmActivity.mLogout = null;
        logoutConfirmActivity.mCancel = null;
        this.f18307b.setOnClickListener(null);
        this.f18307b = null;
        this.f18308c.setOnClickListener(null);
        this.f18308c = null;
        this.f18309d.setOnClickListener(null);
        this.f18309d = null;
    }

    @UiThread
    public LogoutConfirmActivity_ViewBinding(LogoutConfirmActivity logoutConfirmActivity, View view) {
        this.f18306a = logoutConfirmActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutConfirmActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18307b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutConfirmActivity));
        logoutConfirmActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_logout, "field 'mLogout' and method 'onClick'");
        logoutConfirmActivity.mLogout = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_logout, "field 'mLogout'", Button.class);
        this.f18308c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutConfirmActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_cancel, "field 'mCancel' and method 'onClick'");
        logoutConfirmActivity.mCancel = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_cancel, "field 'mCancel'", Button.class);
        this.f18309d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutConfirmActivity));
    }
}
