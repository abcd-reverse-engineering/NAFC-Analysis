package ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.BottomBar;
import ui.view.NoSlideViewPager;

/* loaded from: classes2.dex */
public class MainActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private MainActivity f18350a;

    /* renamed from: b, reason: collision with root package name */
    private View f18351b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MainActivity f18352a;

        a(MainActivity mainActivity) {
            this.f18352a = mainActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18352a.onViewClicked(view);
        }
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MainActivity mainActivity = this.f18350a;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18350a = null;
        mainActivity.mViewpager = null;
        mainActivity.mBottomBar = null;
        mainActivity.mFullScreen = null;
        mainActivity.mIvGuideMain1 = null;
        this.f18351b.setOnClickListener(null);
        this.f18351b = null;
    }

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.f18350a = mainActivity;
        mainActivity.mViewpager = (NoSlideViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'mViewpager'", NoSlideViewPager.class);
        mainActivity.mBottomBar = (BottomBar) Utils.findRequiredViewAsType(view, R.id.bottomBar, "field 'mBottomBar'", BottomBar.class);
        mainActivity.mFullScreen = Utils.findRequiredView(view, R.id.full_screen, "field 'mFullScreen'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_guide_main_1, "field 'mIvGuideMain1' and method 'onViewClicked'");
        mainActivity.mIvGuideMain1 = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_guide_main_1, "field 'mIvGuideMain1'", ImageView.class);
        this.f18351b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(mainActivity));
    }
}
