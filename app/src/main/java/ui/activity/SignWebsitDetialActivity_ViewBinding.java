package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class SignWebsitDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignWebsitDetialActivity f18986a;

    /* renamed from: b, reason: collision with root package name */
    private View f18987b;

    /* renamed from: c, reason: collision with root package name */
    private View f18988c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignWebsitDetialActivity f18989a;

        a(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.f18989a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18989a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignWebsitDetialActivity f18991a;

        b(SignWebsitDetialActivity signWebsitDetialActivity) {
            this.f18991a = signWebsitDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18991a.onClick(view);
        }
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity) {
        this(signWebsitDetialActivity, signWebsitDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignWebsitDetialActivity signWebsitDetialActivity = this.f18986a;
        if (signWebsitDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18986a = null;
        signWebsitDetialActivity.mIvBack = null;
        signWebsitDetialActivity.mTvTitle = null;
        signWebsitDetialActivity.mTvWebUrl = null;
        signWebsitDetialActivity.mLlPic = null;
        signWebsitDetialActivity.mRecyView = null;
        this.f18987b.setOnClickListener(null);
        this.f18987b = null;
        this.f18988c.setOnClickListener(null);
        this.f18988c = null;
    }

    @UiThread
    public SignWebsitDetialActivity_ViewBinding(SignWebsitDetialActivity signWebsitDetialActivity, View view) {
        this.f18986a = signWebsitDetialActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signWebsitDetialActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18987b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signWebsitDetialActivity));
        signWebsitDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signWebsitDetialActivity.mTvWebUrl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weburl, "field 'mTvWebUrl'", TextView.class);
        signWebsitDetialActivity.mLlPic = Utils.findRequiredView(view, R.id.ll_pic, "field 'mLlPic'");
        signWebsitDetialActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_websit_copy, "method 'onClick'");
        this.f18988c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(signWebsitDetialActivity));
    }
}
