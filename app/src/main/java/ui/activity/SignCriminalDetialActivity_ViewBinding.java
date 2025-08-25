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
public final class SignCriminalDetialActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCriminalDetialActivity f18949a;

    /* renamed from: b, reason: collision with root package name */
    private View f18950b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCriminalDetialActivity f18951a;

        a(SignCriminalDetialActivity signCriminalDetialActivity) {
            this.f18951a = signCriminalDetialActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18951a.onClick(view);
        }
    }

    @UiThread
    public SignCriminalDetialActivity_ViewBinding(SignCriminalDetialActivity signCriminalDetialActivity) {
        this(signCriminalDetialActivity, signCriminalDetialActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCriminalDetialActivity signCriminalDetialActivity = this.f18949a;
        if (signCriminalDetialActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18949a = null;
        signCriminalDetialActivity.mIvBack = null;
        signCriminalDetialActivity.mTvTitle = null;
        signCriminalDetialActivity.mRlPhoneView = null;
        signCriminalDetialActivity.mTvPhone = null;
        signCriminalDetialActivity.mRlSocityView = null;
        signCriminalDetialActivity.mTvSocial = null;
        signCriminalDetialActivity.mRlAudioView = null;
        signCriminalDetialActivity.mRecyclerAudio = null;
        signCriminalDetialActivity.mRlPicView = null;
        signCriminalDetialActivity.mRecyView = null;
        this.f18950b.setOnClickListener(null);
        this.f18950b = null;
    }

    @UiThread
    public SignCriminalDetialActivity_ViewBinding(SignCriminalDetialActivity signCriminalDetialActivity, View view) {
        this.f18949a = signCriminalDetialActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCriminalDetialActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18950b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCriminalDetialActivity));
        signCriminalDetialActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCriminalDetialActivity.mRlPhoneView = Utils.findRequiredView(view, R.id.rl_phone_view, "field 'mRlPhoneView'");
        signCriminalDetialActivity.mTvPhone = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_num, "field 'mTvPhone'", TextView.class);
        signCriminalDetialActivity.mRlSocityView = Utils.findRequiredView(view, R.id.rl_socity_view, "field 'mRlSocityView'");
        signCriminalDetialActivity.mTvSocial = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_social_num, "field 'mTvSocial'", TextView.class);
        signCriminalDetialActivity.mRlAudioView = Utils.findRequiredView(view, R.id.rl_audio_view, "field 'mRlAudioView'");
        signCriminalDetialActivity.mRecyclerAudio = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_audio, "field 'mRecyclerAudio'", RecyclerView.class);
        signCriminalDetialActivity.mRlPicView = Utils.findRequiredView(view, R.id.rl_pic_view, "field 'mRlPicView'");
        signCriminalDetialActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
