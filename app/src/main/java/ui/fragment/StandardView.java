package ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.R;
import interfaces.IVerifyListener;
import network.http.StatisticsHttp;
import ui.activity.CheckFraudActivity;
import ui.activity.VirusKillingActivity;
import ui.presenter.WelocmPresenter;
import util.a2;
import util.j1;
import util.k1;
import util.u1;
import util.w1;
import util.y1;
import util.z1;

/* loaded from: classes2.dex */
public class StandardView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Activity f19662a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f19663b;

    /* renamed from: c, reason: collision with root package name */
    private ConstraintLayout f19664c;

    /* renamed from: d, reason: collision with root package name */
    private ConstraintLayout f19665d;

    /* renamed from: e, reason: collision with root package name */
    private ViewStub f19666e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f19667f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f19668g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f19669h;

    /* renamed from: i, reason: collision with root package name */
    private ViewStub.OnInflateListener f19670i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                w1.a(WelocmPresenter.VIRSTMSG);
                return;
            }
            StandardView.this.d();
            y1.a((Context) StandardView.this.f19662a, (Class<?>) VirusKillingActivity.class);
            StatisticsHttp.getInstance().trackPageClick("0");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public /* synthetic */ void a() {
            RegionMudelBean regionMudelBeanJ = d.a.j();
            if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getRiskCheck())) {
                StandardView.this.f19662a.startActivity(new Intent(StandardView.this.f19662a, (Class<?>) CheckFraudActivity.class));
                return;
            }
            k1.a(StandardView.this.f19662a, regionMudelBeanJ.getH5Url() + regionMudelBeanJ.getRiskCheck());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z1.a(StandardView.this.f19662a).a(6, new IVerifyListener() { // from class: ui.fragment.p
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f19732a.a();
                }
            });
        }
    }

    class c implements ViewStub.OnInflateListener {
        c() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            StandardView.this.f19668g = (ImageView) view.findViewById(R.id.iv_animation_ing);
            StandardView.this.f19669h = (ImageView) view.findViewById(R.id.iv_animation_scal);
        }
    }

    public StandardView(Context context) {
        super(context);
        c();
    }

    private void c() {
        this.f19662a = (Activity) getContext();
        View viewInflate = LayoutInflater.from(this.f19662a).inflate(R.layout.view_standard, (ViewGroup) this, true);
        this.f19663b = (TextView) viewInflate.findViewById(R.id.tv_title);
        this.f19664c = (ConstraintLayout) viewInflate.findViewById(R.id.cl_virus_check);
        this.f19665d = (ConstraintLayout) viewInflate.findViewById(R.id.cl_fraud_check);
        this.f19667f = (ImageView) viewInflate.findViewById(R.id.iv_img);
        this.f19666e = (ViewStub) viewInflate.findViewById(R.id.stub_animation);
        this.f19664c.setOnClickListener(new a());
        this.f19665d.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ui.e.b.e().b();
        u1.b(u1.z0, true);
        a(false);
    }

    private void e() throws Resources.NotFoundException {
        ImageView imageView = this.f19667f;
        if (imageView != null) {
            imageView.setVisibility(8);
            b(true);
            ImageView imageView2 = this.f19668g;
            if (imageView2 != null) {
                y1.a(this.f19662a, R.anim.scan_app_home_anim, imageView2);
            }
        }
    }

    public void setDataChange(RegionMudelBean regionMudelBean) {
        if (regionMudelBean == null) {
            setVisibility(0);
            this.f19664c.setVisibility(0);
            this.f19665d.setVisibility(8);
        } else {
            if (regionMudelBean.getStandard() == null || regionMudelBean.getStandard().size() <= 0) {
                setVisibility(8);
                return;
            }
            boolean zContains = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_VIRUS_KILL);
            boolean zContains2 = regionMudelBean.getStandard().contains(ModuelConfig.MODEL_FRAUDCHECK);
            if (!zContains && !zContains2) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f19664c.setVisibility(zContains ? 0 : 8);
            this.f19665d.setVisibility(zContains2 ? 0 : 8);
        }
    }

    public void setTypeface(Typeface typeface) {
        this.f19663b.setTypeface(typeface);
    }

    public StandardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void b(boolean z) {
        ViewStub viewStub = this.f19666e;
        if (viewStub != null) {
            if (z) {
                if (this.f19670i == null) {
                    this.f19670i = new c();
                    this.f19666e.setOnInflateListener(this.f19670i);
                }
                this.f19666e.setVisibility(0);
                return;
            }
            viewStub.setVisibility(8);
        }
    }

    public void a() {
        boolean zD = j1.d();
        boolean zA = u1.a(u1.z0, false);
        boolean zA2 = u1.a(u1.A0, false);
        if ((zD && !zA) || !zA2) {
            if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "1")) {
                e();
                new a2(this.f19662a, a2.f20715e);
                return;
            } else {
                b();
                return;
            }
        }
        b();
    }

    public void b() {
        a(u1.a(u1.B0, false));
    }

    private void a(boolean z) {
        if (this.f19668g != null) {
            b(false);
            a(this.f19668g);
        }
        ImageView imageView = this.f19667f;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (z) {
                this.f19667f.setImageResource(R.drawable.iv_scan_afrad);
            } else {
                this.f19667f.setImageResource(R.drawable.iv_fraud_check);
            }
        }
    }

    private void a(ImageView imageView) {
        if (imageView != null) {
            try {
                if (imageView.getDrawable() != null) {
                    imageView.clearAnimation();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
