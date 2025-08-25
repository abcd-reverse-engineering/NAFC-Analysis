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
public final class InviteQrcodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private InviteQrcodeActivity f18269a;

    /* renamed from: b, reason: collision with root package name */
    private View f18270b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InviteQrcodeActivity f18271a;

        a(InviteQrcodeActivity inviteQrcodeActivity) {
            this.f18271a = inviteQrcodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18271a.onClick(view);
        }
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity) {
        this(inviteQrcodeActivity, inviteQrcodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        InviteQrcodeActivity inviteQrcodeActivity = this.f18269a;
        if (inviteQrcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18269a = null;
        inviteQrcodeActivity.mRlTitle = null;
        inviteQrcodeActivity.mIvBack = null;
        inviteQrcodeActivity.mTvTitle = null;
        inviteQrcodeActivity.mIvQrcode = null;
        this.f18270b.setOnClickListener(null);
        this.f18270b = null;
    }

    @UiThread
    public InviteQrcodeActivity_ViewBinding(InviteQrcodeActivity inviteQrcodeActivity, View view) {
        this.f18269a = inviteQrcodeActivity;
        inviteQrcodeActivity.mRlTitle = Utils.findRequiredView(view, R.id.rl_title, "field 'mRlTitle'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        inviteQrcodeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18270b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(inviteQrcodeActivity));
        inviteQrcodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        inviteQrcodeActivity.mIvQrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_qrcode, "field 'mIvQrcode'", ImageView.class);
    }
}
