package ui.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import network.http.StatisticsHttp;
import ui.presenter.PolicInfoPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: InviteQrcodeActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\u001fJ\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0013H\u0007J\b\u0010&\u001a\u00020'H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lui/activity/InviteQrcodeActivity;", "Lui/activity/BaseActivity;", "()V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mIvQrcode", "getMIvQrcode", "setMIvQrcode", "mPresenter", "Lui/presenter/PolicInfoPresenter;", "getMPresenter", "()Lui/presenter/PolicInfoPresenter;", "setMPresenter", "(Lui/presenter/PolicInfoPresenter;)V", "mRlTitle", "Landroid/view/View;", "getMRlTitle", "()Landroid/view/View;", "setMRlTitle", "(Landroid/view/View;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "createQRcode", "", "content", "", "initPage", "initView", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class InviteQrcodeActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private PolicInfoPresenter f18264a;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_qrcode)
    @i.c.a.d
    public ImageView mIvQrcode;

    @BindView(R.id.rl_title)
    @i.c.a.d
    public View mRlTitle;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    /* compiled from: InviteQrcodeActivity.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18266b;

        /* compiled from: InviteQrcodeActivity.kt */
        /* renamed from: ui.activity.InviteQrcodeActivity$a$a, reason: collision with other inner class name */
        static final class RunnableC0284a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bitmap f18268b;

            RunnableC0284a(Bitmap bitmap) {
                this.f18268b = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InviteQrcodeActivity.this.a().setImageBitmap(this.f18268b);
            }
        }

        a(String str) {
            this.f18266b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(InviteQrcodeActivity.this.getResources(), R.drawable.iv_qrcode_polic);
            int iA = util.c1.a(InviteQrcodeActivity.this, 240.0f);
            Bitmap bitmapA = util.e1.a(this.f18266b, iA, iA, bitmapDecodeResource);
            if (InviteQrcodeActivity.this.a() != null) {
                InviteQrcodeActivity.this.a().post(new RunnableC0284a(bitmapA));
            }
        }
    }

    private final void createQRcode(String str) {
        new Thread(new a(str)).start();
    }

    @i.c.a.d
    public final ImageView a() {
        ImageView imageView = this.mIvQrcode;
        if (imageView == null) {
            h.q2.t.i0.k("mIvQrcode");
        }
        return imageView;
    }

    @i.c.a.d
    public final View b() {
        View view = this.mRlTitle;
        if (view == null) {
            h.q2.t.i0.k("mRlTitle");
        }
        return view;
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
    public final PolicInfoPresenter getMPresenter() {
        return this.f18264a;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13592j);
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        textView.setText("邀请二维码");
        initView();
    }

    public final void initView() {
        this.f18264a = new PolicInfoPresenter(this.mActivity, null);
        View view = this.mRlTitle;
        if (view == null) {
            h.q2.t.i0.k("mRlTitle");
        }
        view.setBackgroundResource(R.color.transparent);
        PolicBean policBeanA = d.b.a();
        if (policBeanA != null) {
            createQRcode(d.a.f13520f + "/QRCode/?pcode=" + policBeanA.getPoliceUserPCode() + "&policeuserid=" + policBeanA.getId() + "&os=0");
        }
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_invite_qrcode;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e PolicInfoPresenter policInfoPresenter) {
        this.f18264a = policInfoPresenter;
    }

    public final void setMRlTitle(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mRlTitle = view;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void a(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvQrcode = imageView;
    }
}
