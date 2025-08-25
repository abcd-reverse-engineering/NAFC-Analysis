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
public final class LogoutSuccActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LogoutSuccActivity f18342a;

    /* renamed from: b, reason: collision with root package name */
    private View f18343b;

    /* renamed from: c, reason: collision with root package name */
    private View f18344c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSuccActivity f18345a;

        a(LogoutSuccActivity logoutSuccActivity) {
            this.f18345a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18345a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSuccActivity f18347a;

        b(LogoutSuccActivity logoutSuccActivity) {
            this.f18347a = logoutSuccActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18347a.onClick(view);
        }
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity) {
        this(logoutSuccActivity, logoutSuccActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSuccActivity logoutSuccActivity = this.f18342a;
        if (logoutSuccActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18342a = null;
        logoutSuccActivity.mIvBack = null;
        logoutSuccActivity.mTvTitle = null;
        logoutSuccActivity.mTvAccTips = null;
        this.f18343b.setOnClickListener(null);
        this.f18343b = null;
        this.f18344c.setOnClickListener(null);
        this.f18344c = null;
    }

    @UiThread
    public LogoutSuccActivity_ViewBinding(LogoutSuccActivity logoutSuccActivity, View view) {
        this.f18342a = logoutSuccActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSuccActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18343b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutSuccActivity));
        logoutSuccActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSuccActivity.mTvAccTips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_acc_tips, "field 'mTvAccTips'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_confirm, "method 'onClick'");
        this.f18344c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutSuccActivity));
    }
}
