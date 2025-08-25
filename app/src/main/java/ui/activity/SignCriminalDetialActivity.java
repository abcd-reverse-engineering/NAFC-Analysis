package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.CallCriminalBean;
import bean.CriminalBean;
import bean.SocialCriminalBean;
import bean.UploadFileBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import java.util.List;
import ui.presenter.GridViewPicPresenter;
import ui.presenter.RecyclerAudioPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignCriminalDetialActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010?\u001a\u00020@H\u0016J\u0006\u0010A\u001a\u00020@J\u0010\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020%H\u0007J\b\u0010D\u001a\u00020@H\u0014J\b\u0010E\u001a\u00020FH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u00100\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001e\u00103\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001e\u0010<\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108¨\u0006G"}, d2 = {"Lui/activity/SignCriminalDetialActivity;", "Lui/activity/BaseActivity;", "()V", "mBean", "Lbean/CriminalBean;", "getMBean", "()Lbean/CriminalBean;", "setMBean", "(Lbean/CriminalBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/GridViewPicPresenter;", "getMPresenter", "()Lui/presenter/GridViewPicPresenter;", "setMPresenter", "(Lui/presenter/GridViewPicPresenter;)V", "mPresenterAudio", "Lui/presenter/RecyclerAudioPresenter;", "getMPresenterAudio", "()Lui/presenter/RecyclerAudioPresenter;", "setMPresenterAudio", "(Lui/presenter/RecyclerAudioPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerAudio", "getMRecyclerAudio", "setMRecyclerAudio", "mRlAudioView", "Landroid/view/View;", "getMRlAudioView", "()Landroid/view/View;", "setMRlAudioView", "(Landroid/view/View;)V", "mRlPhoneView", "getMRlPhoneView", "setMRlPhoneView", "mRlPicView", "getMRlPicView", "setMRlPicView", "mRlSocityView", "getMRlSocityView", "setMRlSocityView", "mTvPhone", "Landroid/widget/TextView;", "getMTvPhone", "()Landroid/widget/TextView;", "setMTvPhone", "(Landroid/widget/TextView;)V", "mTvSocial", "getMTvSocial", "setMTvSocial", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initView", "onClick", "view", "onPause", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignCriminalDetialActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private RecyclerAudioPresenter f18946a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.e
    private GridViewPicPresenter f18947b;

    /* renamed from: c, reason: collision with root package name */
    @i.c.a.e
    private CriminalBean f18948c;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyView;

    @BindView(R.id.recyclerview_audio)
    @i.c.a.d
    public RecyclerView mRecyclerAudio;

    @BindView(R.id.rl_audio_view)
    @i.c.a.d
    public View mRlAudioView;

    @BindView(R.id.rl_phone_view)
    @i.c.a.d
    public View mRlPhoneView;

    @BindView(R.id.rl_pic_view)
    @i.c.a.d
    public View mRlPicView;

    @BindView(R.id.rl_socity_view)
    @i.c.a.d
    public View mRlSocityView;

    @BindView(R.id.tv_phone_num)
    @i.c.a.d
    public TextView mTvPhone;

    @BindView(R.id.tv_social_num)
    @i.c.a.d
    public TextView mTvSocial;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvPhone = textView;
    }

    public final void b(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvSocial = textView;
    }

    @i.c.a.d
    public final View c() {
        View view = this.mRlAudioView;
        if (view == null) {
            h.q2.t.i0.k("mRlAudioView");
        }
        return view;
    }

    @i.c.a.d
    public final View d() {
        View view = this.mRlPhoneView;
        if (view == null) {
            h.q2.t.i0.k("mRlPhoneView");
        }
        return view;
    }

    @i.c.a.d
    public final View e() {
        View view = this.mRlPicView;
        if (view == null) {
            h.q2.t.i0.k("mRlPicView");
        }
        return view;
    }

    @i.c.a.d
    public final View f() {
        View view = this.mRlSocityView;
        if (view == null) {
            h.q2.t.i0.k("mRlSocityView");
        }
        return view;
    }

    @i.c.a.d
    public final TextView g() {
        TextView textView = this.mTvPhone;
        if (textView == null) {
            h.q2.t.i0.k("mTvPhone");
        }
        return textView;
    }

    @i.c.a.e
    public final CriminalBean getMBean() {
        return this.f18948c;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final GridViewPicPresenter getMPresenter() {
        return this.f18947b;
    }

    @i.c.a.d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyView");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView h() {
        TextView textView = this.mTvSocial;
        if (textView == null) {
            h.q2.t.i0.k("mTvSocial");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("嫌疑人信息");
        initView();
    }

    public final void initView() {
        this.f18948c = (CriminalBean) getIntent().getSerializableExtra(util.k1.f20845c);
        this.f18946a = new RecyclerAudioPresenter(this.mActivity);
        RecyclerAudioPresenter recyclerAudioPresenter = this.f18946a;
        if (recyclerAudioPresenter != null) {
            RecyclerView recyclerView = this.mRecyclerAudio;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRecyclerAudio");
            }
            recyclerAudioPresenter.initRecycleWeb(recyclerView);
        }
        this.f18947b = new GridViewPicPresenter(this.mActivity);
        GridViewPicPresenter gridViewPicPresenter = this.f18947b;
        if (gridViewPicPresenter != null) {
            RecyclerView recyclerView2 = this.mRecyView;
            if (recyclerView2 == null) {
                h.q2.t.i0.k("mRecyView");
            }
            gridViewPicPresenter.initRecycleWeb(recyclerView2);
        }
        if (this.f18948c != null) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            CriminalBean criminalBean = this.f18948c;
            List<CallCriminalBean> mobiles = criminalBean != null ? criminalBean.getMobiles() : null;
            CriminalBean criminalBean2 = this.f18948c;
            List<SocialCriminalBean> socialAccounts = criminalBean2 != null ? criminalBean2.getSocialAccounts() : null;
            CriminalBean criminalBean3 = this.f18948c;
            List<UploadFileBean> audios = criminalBean3 != null ? criminalBean3.getAudios() : null;
            CriminalBean criminalBean4 = this.f18948c;
            List<UploadFileBean> printscreens = criminalBean4 != null ? criminalBean4.getPrintscreens() : null;
            int i2 = 0;
            if (mobiles == null || mobiles.size() <= 0) {
                View view = this.mRlPhoneView;
                if (view == null) {
                    h.q2.t.i0.k("mRlPhoneView");
                }
                view.setVisibility(8);
            } else {
                int size = mobiles.size();
                int i3 = 0;
                while (i3 < size) {
                    CallCriminalBean callCriminalBean = mobiles.get(i3);
                    h.q2.t.i0.a((Object) callCriminalBean, "callBeans[index]");
                    stringBuffer.append(callCriminalBean.getAccount());
                    i3++;
                    if (mobiles == null || i3 != mobiles.size()) {
                        stringBuffer.append("\n");
                    }
                }
                TextView textView = this.mTvPhone;
                if (textView == null) {
                    h.q2.t.i0.k("mTvPhone");
                }
                textView.setText(stringBuffer.toString());
            }
            if (socialAccounts == null || socialAccounts.size() <= 0) {
                View view2 = this.mRlSocityView;
                if (view2 == null) {
                    h.q2.t.i0.k("mRlSocityView");
                }
                view2.setVisibility(8);
            } else {
                int size2 = socialAccounts.size();
                while (i2 < size2) {
                    SocialCriminalBean socialCriminalBean = socialAccounts.get(i2);
                    h.q2.t.i0.a((Object) socialCriminalBean, "socialBeans[index]");
                    stringBuffer2.append(socialCriminalBean.getAccountTypeName());
                    stringBuffer2.append("  ");
                    SocialCriminalBean socialCriminalBean2 = socialAccounts.get(i2);
                    h.q2.t.i0.a((Object) socialCriminalBean2, "socialBeans[index]");
                    stringBuffer2.append(socialCriminalBean2.getAccount());
                    i2++;
                    if (socialAccounts == null || i2 != socialAccounts.size()) {
                        stringBuffer2.append("\n");
                    }
                }
                TextView textView2 = this.mTvSocial;
                if (textView2 == null) {
                    h.q2.t.i0.k("mTvSocial");
                }
                textView2.setText(stringBuffer2.toString());
            }
            if (audios == null || audios.size() <= 0) {
                View view3 = this.mRlAudioView;
                if (view3 == null) {
                    h.q2.t.i0.k("mRlAudioView");
                }
                view3.setVisibility(8);
            } else {
                RecyclerAudioPresenter recyclerAudioPresenter2 = this.f18946a;
                if (recyclerAudioPresenter2 != null) {
                    recyclerAudioPresenter2.setListData(audios);
                }
            }
            if (printscreens == null || printscreens.size() <= 0) {
                View view4 = this.mRlPicView;
                if (view4 == null) {
                    h.q2.t.i0.k("mRlPicView");
                }
                view4.setVisibility(8);
                return;
            }
            GridViewPicPresenter gridViewPicPresenter2 = this.f18947b;
            if (gridViewPicPresenter2 != null) {
                gridViewPicPresenter2.setListData(printscreens);
            }
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() throws IllegalStateException {
        super.onPause();
        RecyclerAudioPresenter recyclerAudioPresenter = this.f18946a;
        if (recyclerAudioPresenter != null) {
            recyclerAudioPresenter.onPause();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_criminal_detial;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMRecyView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMRlAudioView(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mRlAudioView = view;
    }

    public final void setMRlPhoneView(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mRlPhoneView = view;
    }

    public final void setMRlPicView(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mRlPicView = view;
    }

    public final void setMRlSocityView(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mRlSocityView = view;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void a(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyclerAudio = recyclerView;
    }

    @i.c.a.d
    public final RecyclerView b() {
        RecyclerView recyclerView = this.mRecyclerAudio;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyclerAudio");
        }
        return recyclerView;
    }

    @i.c.a.e
    public final RecyclerAudioPresenter a() {
        return this.f18946a;
    }

    public final void a(@i.c.a.e RecyclerAudioPresenter recyclerAudioPresenter) {
        this.f18946a = recyclerAudioPresenter;
    }

    public final void a(@i.c.a.e GridViewPicPresenter gridViewPicPresenter) {
        this.f18947b = gridViewPicPresenter;
    }

    public final void a(@i.c.a.e CriminalBean criminalBean) {
        this.f18948c = criminalBean;
    }
}
