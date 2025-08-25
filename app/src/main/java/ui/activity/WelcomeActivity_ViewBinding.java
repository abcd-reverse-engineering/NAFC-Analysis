package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WelcomeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WelcomeActivity f19394a;

    /* renamed from: b, reason: collision with root package name */
    private View f19395b;

    /* renamed from: c, reason: collision with root package name */
    private View f19396c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WelcomeActivity f19397a;

        a(WelcomeActivity welcomeActivity) {
            this.f19397a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19397a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WelcomeActivity f19399a;

        b(WelcomeActivity welcomeActivity) {
            this.f19399a = welcomeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19399a.onViewClicked(view);
        }
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity) {
        this(welcomeActivity, welcomeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WelcomeActivity welcomeActivity = this.f19394a;
        if (welcomeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19394a = null;
        welcomeActivity.mImage = null;
        welcomeActivity.mTvNext = null;
        welcomeActivity.mLottieLike = null;
        welcomeActivity.mClLayout = null;
        this.f19395b.setOnClickListener(null);
        this.f19395b = null;
        this.f19396c.setOnClickListener(null);
        this.f19396c = null;
    }

    @UiThread
    public WelcomeActivity_ViewBinding(WelcomeActivity welcomeActivity, View view) {
        this.f19394a = welcomeActivity;
        welcomeActivity.mImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'mImage'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_next, "field 'mTvNext' and method 'onViewClicked'");
        welcomeActivity.mTvNext = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_next, "field 'mTvNext'", TextView.class);
        this.f19395b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(welcomeActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.lottie_likeanim, "field 'mLottieLike' and method 'onViewClicked'");
        welcomeActivity.mLottieLike = (LottieAnimationView) Utils.castView(viewFindRequiredView2, R.id.lottie_likeanim, "field 'mLottieLike'", LottieAnimationView.class);
        this.f19396c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(welcomeActivity));
        welcomeActivity.mClLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_layout, "field 'mClLayout'", ConstraintLayout.class);
    }
}
