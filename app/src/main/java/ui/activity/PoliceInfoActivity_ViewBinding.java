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
public final class PoliceInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PoliceInfoActivity f18506a;

    /* renamed from: b, reason: collision with root package name */
    private View f18507b;

    /* renamed from: c, reason: collision with root package name */
    private View f18508c;

    /* renamed from: d, reason: collision with root package name */
    private View f18509d;

    /* renamed from: e, reason: collision with root package name */
    private View f18510e;

    /* renamed from: f, reason: collision with root package name */
    private View f18511f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceInfoActivity f18512a;

        a(PoliceInfoActivity policeInfoActivity) {
            this.f18512a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18512a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceInfoActivity f18514a;

        b(PoliceInfoActivity policeInfoActivity) {
            this.f18514a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18514a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceInfoActivity f18516a;

        c(PoliceInfoActivity policeInfoActivity) {
            this.f18516a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18516a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceInfoActivity f18518a;

        d(PoliceInfoActivity policeInfoActivity) {
            this.f18518a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18518a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceInfoActivity f18520a;

        e(PoliceInfoActivity policeInfoActivity) {
            this.f18520a = policeInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18520a.onClick(view);
        }
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity) {
        this(policeInfoActivity, policeInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PoliceInfoActivity policeInfoActivity = this.f18506a;
        if (policeInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18506a = null;
        policeInfoActivity.mIvBack = null;
        policeInfoActivity.mTvTitle = null;
        policeInfoActivity.mIvRight = null;
        policeInfoActivity.mTvPhoneNum = null;
        policeInfoActivity.mTvInviteNum = null;
        policeInfoActivity.mTvDownApp = null;
        policeInfoActivity.mTvRegistNum = null;
        this.f18507b.setOnClickListener(null);
        this.f18507b = null;
        this.f18508c.setOnClickListener(null);
        this.f18508c = null;
        this.f18509d.setOnClickListener(null);
        this.f18509d = null;
        this.f18510e.setOnClickListener(null);
        this.f18510e = null;
        this.f18511f.setOnClickListener(null);
        this.f18511f = null;
    }

    @UiThread
    public PoliceInfoActivity_ViewBinding(PoliceInfoActivity policeInfoActivity, View view) {
        this.f18506a = policeInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        policeInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18507b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(policeInfoActivity));
        policeInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onClick'");
        policeInfoActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f18508c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(policeInfoActivity));
        policeInfoActivity.mTvPhoneNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_num, "field 'mTvPhoneNum'", TextView.class);
        policeInfoActivity.mTvInviteNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_invite_num, "field 'mTvInviteNum'", TextView.class);
        policeInfoActivity.mTvDownApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_doapp_num, "field 'mTvDownApp'", TextView.class);
        policeInfoActivity.mTvRegistNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_regist_num, "field 'mTvRegistNum'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_case_manger, "method 'onClick'");
        this.f18509d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(policeInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_manual, "method 'onClick'");
        this.f18510e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(policeInfoActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_invite_qrcode, "method 'onClick'");
        this.f18511f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(policeInfoActivity));
    }
}
