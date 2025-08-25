package ui.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.GuideBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.hicorenational.antifraud.service.WarnGuidService;
import interfaces.IOneClickListener;
import ui.Hicore;
import ui.presenter.BasePagePresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class WarnGuideActivity extends BaseActivity {

    /* renamed from: d, reason: collision with root package name */
    BasePagePresenter f19273d;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_warn_guide)
    ImageView mIvWarnGuide;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a, reason: collision with root package name */
    private ServiceConnection f19270a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f19271b = -1;

    /* renamed from: c, reason: collision with root package name */
    private GuideBean f19272c = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f19274e = false;

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
        }
    }

    private void a() {
        this.f19270a = new a();
        Intent intent = new Intent(this, (Class<?>) WarnGuidService.class);
        bindService(intent, this.f19270a, 1);
        GuideBean guideBean = this.f19272c;
        if (guideBean != null) {
            intent.putExtra(WarnGuidService.w, guideBean.getContent());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }
    }

    private void b() {
        switch (this.f19271b) {
            case 10001:
                this.f19274e = true;
                if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                    this.f19273d.checkOtherPerssion(null);
                    break;
                } else if (!util.k1.c(this.mActivity)) {
                    util.k1.e(this.mActivity);
                    break;
                }
                break;
            case 10002:
            case 10003:
            case GuideBean.GUIDE_CODE_SMS /* 10004 */:
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
                startActivity(intent);
                break;
            case GuideBean.GUIDE_CODE_AUTO /* 10005 */:
                util.v1.h(this.mActivity);
                break;
            case 10006:
                util.v1.g(this.mActivity);
                break;
            case 10007:
                c();
                break;
        }
    }

    private void c() {
        util.b1.b(this.mActivity, "请手动前往系统设置，完成开启", "确定", new b());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        this.mRlTitle.setBackgroundColor(getResources().getColor(R.color.blue));
        this.f19273d = new BasePagePresenter(this.mActivity);
        try {
            this.f19271b = getIntent().getIntExtra(WarnPrimessActivity.EXTRA_GUIDE_CODE, -1);
            this.f19272c = (GuideBean) getIntent().getSerializableExtra(WarnPrimessActivity.EXTRA_GUIDE_DATA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        GuideBean guideBean = this.f19272c;
        if (guideBean != null) {
            j.d.a(guideBean.getImgUrl(), this.mIvWarnGuide, Integer.valueOf(R.drawable.iv_blue_bg));
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ServiceConnection serviceConnection = this.f19270a;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
            this.f19270a = null;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        org.greenrobot.eventbus.c.f().d(new util.c2.a(156, null));
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (util.v1.b(getApplicationContext(), d.d.f13554j)) {
            stopService(new Intent(this, (Class<?>) WarnGuidService.class));
            finish();
        } else if (this.f19271b == 10001 && this.f19274e) {
            this.f19274e = false;
            this.f19271b = -1;
            finish();
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_go_setting})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
            return;
        }
        if (id != R.id.tv_go_setting) {
            return;
        }
        int i2 = this.f19271b;
        if (i2 != 10001 && i2 != 10007) {
            a();
        }
        b();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_warn_guide;
    }
}
