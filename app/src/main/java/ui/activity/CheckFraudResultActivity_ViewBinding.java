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
public class CheckFraudResultActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CheckFraudResultActivity f17953a;

    /* renamed from: b, reason: collision with root package name */
    private View f17954b;

    /* renamed from: c, reason: collision with root package name */
    private View f17955c;

    /* renamed from: d, reason: collision with root package name */
    private View f17956d;

    /* renamed from: e, reason: collision with root package name */
    private View f17957e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudResultActivity f17958a;

        a(CheckFraudResultActivity checkFraudResultActivity) {
            this.f17958a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17958a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudResultActivity f17960a;

        b(CheckFraudResultActivity checkFraudResultActivity) {
            this.f17960a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17960a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudResultActivity f17962a;

        c(CheckFraudResultActivity checkFraudResultActivity) {
            this.f17962a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17962a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CheckFraudResultActivity f17964a;

        d(CheckFraudResultActivity checkFraudResultActivity) {
            this.f17964a = checkFraudResultActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17964a.onViewClicked(view);
        }
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity) {
        this(checkFraudResultActivity, checkFraudResultActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CheckFraudResultActivity checkFraudResultActivity = this.f17953a;
        if (checkFraudResultActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17953a = null;
        checkFraudResultActivity.mIvBack = null;
        checkFraudResultActivity.mTvTitle = null;
        checkFraudResultActivity.mIvRight = null;
        checkFraudResultActivity.mIvPicture = null;
        checkFraudResultActivity.mCheckResult = null;
        checkFraudResultActivity.mTvCotent = null;
        checkFraudResultActivity.mWarnTxt = null;
        checkFraudResultActivity.mTvAppeal = null;
        checkFraudResultActivity.mTvType = null;
        this.f17954b.setOnClickListener(null);
        this.f17954b = null;
        this.f17955c.setOnClickListener(null);
        this.f17955c = null;
        this.f17956d.setOnClickListener(null);
        this.f17956d = null;
        this.f17957e.setOnClickListener(null);
        this.f17957e = null;
    }

    @UiThread
    public CheckFraudResultActivity_ViewBinding(CheckFraudResultActivity checkFraudResultActivity, View view) {
        this.f17953a = checkFraudResultActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        checkFraudResultActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17954b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(checkFraudResultActivity));
        checkFraudResultActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        checkFraudResultActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f17955c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(checkFraudResultActivity));
        checkFraudResultActivity.mIvPicture = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_picture, "field 'mIvPicture'", ImageView.class);
        checkFraudResultActivity.mCheckResult = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_check_result, "field 'mCheckResult'", TextView.class);
        checkFraudResultActivity.mTvCotent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cotent, "field 'mTvCotent'", TextView.class);
        checkFraudResultActivity.mWarnTxt = (TextView) Utils.findRequiredViewAsType(view, R.id.warn_txt, "field 'mWarnTxt'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        checkFraudResultActivity.mTvAppeal = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f17956d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(checkFraudResultActivity));
        checkFraudResultActivity.mTvType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_type, "field 'mTvType'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_report, "method 'onViewClicked'");
        this.f17957e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(checkFraudResultActivity));
    }
}
