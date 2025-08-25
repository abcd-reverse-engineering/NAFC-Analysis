package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.MyScrollView;

/* loaded from: classes2.dex */
public class TagFlowLaoutActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private TagFlowLaoutActivity f19100a;

    /* renamed from: b, reason: collision with root package name */
    private View f19101b;

    /* renamed from: c, reason: collision with root package name */
    private View f19102c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TagFlowLaoutActivity f19103a;

        a(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.f19103a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19103a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TagFlowLaoutActivity f19105a;

        b(TagFlowLaoutActivity tagFlowLaoutActivity) {
            this.f19105a = tagFlowLaoutActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19105a.onViewClicked(view);
        }
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity) {
        this(tagFlowLaoutActivity, tagFlowLaoutActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TagFlowLaoutActivity tagFlowLaoutActivity = this.f19100a;
        if (tagFlowLaoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19100a = null;
        tagFlowLaoutActivity.mIvBack = null;
        tagFlowLaoutActivity.mTvTitle = null;
        tagFlowLaoutActivity.mLlPraent = null;
        tagFlowLaoutActivity.myScrollView = null;
        tagFlowLaoutActivity.mLlNetworkNo = null;
        this.f19101b.setOnClickListener(null);
        this.f19101b = null;
        this.f19102c.setOnClickListener(null);
        this.f19102c = null;
    }

    @UiThread
    public TagFlowLaoutActivity_ViewBinding(TagFlowLaoutActivity tagFlowLaoutActivity, View view) {
        this.f19100a = tagFlowLaoutActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        tagFlowLaoutActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f19101b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(tagFlowLaoutActivity));
        tagFlowLaoutActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        tagFlowLaoutActivity.mLlPraent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_praent, "field 'mLlPraent'", LinearLayout.class);
        tagFlowLaoutActivity.myScrollView = (MyScrollView) Utils.findRequiredViewAsType(view, R.id.myScrollView, "field 'myScrollView'", MyScrollView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        tagFlowLaoutActivity.mLlNetworkNo = viewFindRequiredView2;
        this.f19102c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(tagFlowLaoutActivity));
    }
}
