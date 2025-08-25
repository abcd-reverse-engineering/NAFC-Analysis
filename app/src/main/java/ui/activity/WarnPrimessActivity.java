package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import bean.GuideBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hicorenational.antifraud.R;
import com.hicorenational.antifraud.service.WarnGuidService;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.WarnPrimessCallView;
import ui.presenter.BasePagePresenter;
import ui.presenter.WarnPrimessPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class WarnPrimessActivity extends BaseActivity implements WarnPrimessCallView {
    public static final String EXTRA_GUIDE_CODE = "extra_guide_code";
    public static final String EXTRA_GUIDE_DATA = "extra_guide_data";
    BasePagePresenter mBasePresenter;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_ic)
    ImageView mIvIc;

    @BindView(R.id.ll_content)
    LinearLayout mLlContent;

    @BindView(R.id.open_auto)
    TextView mOpenAuto;

    @BindView(R.id.open_flow)
    TextView mOpenFlow;

    @BindView(R.id.open_lock)
    TextView mOpenLock;

    @BindView(R.id.open_phone)
    TextView mOpenPhone;

    @BindView(R.id.open_phone_record)
    TextView mOpenPhoneRecord;

    @BindView(R.id.open_power)
    TextView mOpenPower;

    @BindView(R.id.open_sms)
    TextView mOpenSms;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_label)
    TextView mTvLabel;

    @BindView(R.id.tv_label_small)
    TextView mTvLabelSmall;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    WarnPrimessPresenter mWarnPresenter;
    public final String COUNT_TAG_FLOW = "0";
    public final String COUNT_TAG_PHONE = "1";
    public final String COUNT_TAG_RECORD = "2";
    public final String COUNT_TAG_SMS = "3";
    private String[] permListPhone = {util.permissionutil.a.f20918l};
    private String[] permListRecord = null;
    private String[] permListSms = {util.permissionutil.a.w, util.permissionutil.a.v};
    private String[] permListNormal = null;
    private int mCurrentCode = -1;
    HashMap<String, GuideBean> mGuideMap = null;
    private String mOpenCount = "";
    private int mSumCount = 4;
    private int mOldShowCount = -1;
    private BottomSheetDialog mBottomSheetDialog = null;
    private boolean isToOpenFlow = false;

    class a implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19284a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f19285b;

        a(String str, TextView textView) {
            this.f19284a = str;
            this.f19285b = textView;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            util.u1.b(this.f19284a, true);
            WarnPrimessActivity.this.openStateNotNecessary(this.f19285b, true);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            util.u1.b(this.f19284a, false);
            WarnPrimessActivity.this.openStateNotNecessary(this.f19285b, false);
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            WarnPrimessActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class c extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f19288a;

        c(BottomSheetBehavior bottomSheetBehavior) {
            this.f19288a = bottomSheetBehavior;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i2) {
            if (i2 == 5) {
                WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
                this.f19288a.setState(4);
            }
        }
    }

    class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f19290a;

        d(BottomSheetBehavior bottomSheetBehavior) {
            this.f19290a = bottomSheetBehavior;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
            this.f19290a.setState(4);
        }
    }

    class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f19292a;

        e(BottomSheetBehavior bottomSheetBehavior) {
            this.f19292a = bottomSheetBehavior;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WarnPrimessActivity.this.mBottomSheetDialog.dismiss();
            this.f19292a.setState(4);
            WarnPrimessActivity.this.isToOpenFlow = true;
            if (!Build.BRAND.equalsIgnoreCase("vivo")) {
                WarnPrimessActivity.this.mBasePresenter.checkOtherPerssion(null);
            } else {
                if (util.k1.c(WarnPrimessActivity.this.mActivity)) {
                    return;
                }
                util.k1.e(WarnPrimessActivity.this.mActivity);
            }
        }
    }

    class f implements PermissionsListener {
        f() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            WarnPrimessActivity.this.checkResult(false, z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            boolean z = false;
            boolean z2 = true;
            if (util.permissionutil.c.g() && (!util.permissionutil.c.b() || !util.permissionutil.c.a() || !util.permissionutil.c.c())) {
                z = true;
                z2 = false;
            }
            WarnPrimessActivity.this.checkResult(z2, z);
        }
    }

    private void checkPermission(String[] strArr) {
        util.permissionutil.c.a(this.mActivity, strArr, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkResult(boolean z, boolean z2) {
        boolean zA = util.permissionutil.c.a(this.mActivity, this.permListPhone);
        boolean zA2 = util.permissionutil.c.a(this.mActivity, this.permListRecord);
        boolean zA3 = util.permissionutil.c.a(this.mActivity, this.permListSms);
        openState(this.mOpenPhone, zA);
        openState(this.mOpenPhoneRecord, zA2);
        openState(this.mOpenSms, zA3);
        if (!zA) {
            this.mCurrentCode = 10002;
            z = false;
        } else if (!zA2) {
            this.mCurrentCode = 10003;
        } else {
            if (zA3) {
                this.mCurrentCode = -1;
                return;
            }
            this.mCurrentCode = GuideBean.GUIDE_CODE_SMS;
        }
        if (this.mCurrentCode != -1) {
            z2 = true;
            z = false;
        }
        switch (this.mCurrentCode) {
            case 10002:
                openState(this.mOpenPhone, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
            case 10003:
                openState(this.mOpenPhoneRecord, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
            case GuideBean.GUIDE_CODE_SMS /* 10004 */:
                openState(this.mOpenSms, z);
                if (z2) {
                    intentNext();
                    break;
                }
                break;
        }
    }

    private int getWindowHeight() {
        return this.mActivity.getResources().getDisplayMetrics().heightPixels;
    }

    private void intentNext() {
        Intent intent = new Intent(this, (Class<?>) WarnGuideActivity.class);
        intent.putExtra(EXTRA_GUIDE_CODE, this.mCurrentCode);
        HashMap<String, GuideBean> map = this.mGuideMap;
        if (map != null && !map.isEmpty()) {
            intent.putExtra(EXTRA_GUIDE_DATA, this.mGuideMap.get(this.mCurrentCode + ""));
        }
        startActivity(intent);
    }

    private void intentNextFlow() {
        GuideBean guideBean;
        HashMap<String, GuideBean> map = this.mGuideMap;
        if (map == null || map.isEmpty()) {
            guideBean = null;
        } else {
            guideBean = this.mGuideMap.get(this.mCurrentCode + "");
        }
        showBottomDlg(guideBean);
    }

    private void openDialog(String str, String str2, TextView textView) {
        util.b1.a(this.mActivity, "是否已经成功开启【" + str + "】权限？", "", "成功开启", "未开启", -1, -1, true, (IClickListener) new a(str2, textView));
    }

    private void openState(TextView textView, boolean z) {
        String str;
        try {
            str = (String) textView.getTag();
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        openState(textView, z, true, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openStateNotNecessary(TextView textView, boolean z) {
        openState(textView, z, false, "");
    }

    private void showBottomDlg(GuideBean guideBean) {
        View viewInflate = View.inflate(this.mActivity, R.layout.layout_warn_guide_flow, null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_warn_guide_close);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_warn_guide);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_go_setting);
        this.mBottomSheetDialog = new BottomSheetDialog(this.mActivity, R.style.base_dialog_style);
        this.mBottomSheetDialog.setContentView(viewInflate);
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) viewInflate.getParent());
        bottomSheetBehaviorFrom.setPeekHeight(getWindowHeight());
        bottomSheetBehaviorFrom.setBottomSheetCallback(new c(bottomSheetBehaviorFrom));
        imageView.setOnClickListener(new d(bottomSheetBehaviorFrom));
        textView.setOnClickListener(new e(bottomSheetBehaviorFrom));
        if (guideBean != null) {
            j.d.a(guideBean.getImgUrl(), imageView2, Integer.valueOf(R.drawable.iv_blue_bg));
        }
        this.mBottomSheetDialog.show();
    }

    private void showWindowAlpha(boolean z) {
    }

    private void titleState() {
        if (this.mIvIc == null) {
            return;
        }
        int length = this.mOpenCount.length();
        int i2 = this.mSumCount;
        if (length == i2) {
            if (this.mIvIc.getVisibility() == 0) {
                return;
            }
            this.mTvLabel.setText("预警守护中");
            this.mTvLabelSmall.setText("准确识别电信网络诈骗");
            this.mIvIc.setVisibility(0);
            this.mConfirm.setEnabled(true);
            return;
        }
        int length2 = i2 - this.mOpenCount.length();
        if (length2 < 0) {
            return;
        }
        if (this.mIvIc.getVisibility() == 8 && this.mOldShowCount == length2) {
            return;
        }
        this.mTvLabel.setText("预警需开启以下权限");
        this.mTvLabelSmall.setText("还需开启" + length2 + "项权限");
        this.mIvIc.setVisibility(8);
        this.mOldShowCount = length2;
        this.mConfirm.setEnabled(false);
    }

    public /* synthetic */ void a() {
        boolean zIsOpenFlowPrim = this.mBasePresenter.isOpenFlowPrim();
        if (this.mCurrentCode == 10001 && this.isToOpenFlow && zIsOpenFlowPrim) {
            this.isToOpenFlow = false;
            this.mCurrentCode = -1;
            checkPermission(this.permListNormal);
        }
        openState(this.mOpenFlow, zIsOpenFlowPrim);
        titleState();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.o);
        org.greenrobot.eventbus.c.f().e(this);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        this.mRlTitle.setBackgroundColor(getResources().getColor(R.color.blue));
        this.mIvIc.setVisibility(8);
        this.mBasePresenter = new BasePagePresenter(this.mActivity);
        this.mWarnPresenter = new WarnPrimessPresenter(this.mActivity, this);
        this.mWarnPresenter.requestGuideConfig();
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.f20916j);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(util.permissionutil.a.r);
        }
        this.permListRecord = (String[]) arrayList.toArray(new String[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList(this.permListPhone));
        arrayList2.addAll(arrayList);
        arrayList2.addAll(Arrays.asList(this.permListSms));
        this.permListNormal = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        this.mOpenFlow.setTag("0");
        this.mOpenPhone.setTag("1");
        this.mOpenPhoneRecord.setTag("2");
        this.mOpenSms.setTag("3");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!util.permissionutil.c.a(this.mActivity, this.mBasePresenter.checkPermission())) {
            util.b1.a(this.mActivity, "预警权限未开启", "", "放弃使用", "去开启", -1, -1, true, (IClickListener) new b());
            return;
        }
        util.u1.b(util.u1.F, true);
        util.u1.b(util.u1.G, true);
        util.u1.b(util.u1.H, true);
        Hicore.getApp().registerPhoneStateListener();
        super.onBackPressed();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 156) {
            return;
        }
        showWindowAlpha(false);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mOpenCount = "";
        this.mOldShowCount = -1;
        if (util.v1.b(getApplicationContext(), d.d.f13554j)) {
            stopService(new Intent(this, (Class<?>) WarnGuidService.class));
        }
        y1.f21027b.postDelayed(new Runnable() { // from class: ui.activity.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f19449a.a();
            }
        }, 500L);
        openState(this.mOpenPhone, util.permissionutil.c.a(this.mActivity, this.permListPhone));
        openState(this.mOpenPhoneRecord, util.permissionutil.c.a(this.mActivity, this.permListRecord));
        openState(this.mOpenSms, util.permissionutil.c.a(this.mActivity, this.permListSms));
        openStateNotNecessary(this.mOpenAuto, util.u1.a(util.u1.I, false));
        openStateNotNecessary(this.mOpenPower, util.u1.a(util.u1.J, false));
        openStateNotNecessary(this.mOpenLock, util.u1.a(util.u1.K, false));
        if (this.mCurrentCode == 10005) {
            this.mCurrentCode = -1;
            openDialog("自启动", util.u1.I, this.mOpenAuto);
        }
        if (this.mCurrentCode == 10006) {
            this.mCurrentCode = -1;
            openDialog("耗电保护", util.u1.J, this.mOpenPower);
        }
        if (this.mCurrentCode == 10007) {
            this.mCurrentCode = -1;
            openDialog("应用锁", util.u1.K, this.mOpenLock);
        }
    }

    @Override // ui.callview.WarnPrimessCallView
    public void onSuccessRequest(HashMap<String, GuideBean> map) {
        this.mGuideMap = map;
        if (this.mBasePresenter.isOpenFlowPrim()) {
            showWindowAlpha(false);
        } else {
            this.mCurrentCode = 10001;
            intentNextFlow();
        }
    }

    @OnClick({R.id.iv_back, R.id.open_flow, R.id.open_phone, R.id.open_phone_record, R.id.open_sms, R.id.open_auto, R.id.open_power, R.id.open_lock, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            onBackPressed();
            return;
        }
        if (id == R.id.iv_back) {
            onBackPressed();
            return;
        }
        switch (id) {
            case R.id.open_auto /* 2131297057 */:
                this.mCurrentCode = GuideBean.GUIDE_CODE_AUTO;
                intentNext();
                break;
            case R.id.open_flow /* 2131297058 */:
                this.mCurrentCode = 10001;
                BottomSheetDialog bottomSheetDialog = this.mBottomSheetDialog;
                if (bottomSheetDialog != null) {
                    bottomSheetDialog.show();
                    break;
                } else {
                    this.mWarnPresenter.requestGuideConfig();
                    break;
                }
            case R.id.open_lock /* 2131297059 */:
                this.mCurrentCode = 10007;
                intentNext();
                break;
            case R.id.open_phone /* 2131297060 */:
            case R.id.open_phone_record /* 2131297061 */:
            case R.id.open_sms /* 2131297063 */:
                checkPermission(this.permListNormal);
                break;
            case R.id.open_power /* 2131297062 */:
                this.mCurrentCode = 10006;
                intentNext();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        showWindowAlpha(true);
        return R.layout.activity_warn_primess;
    }

    private void openState(TextView textView, boolean z, boolean z2, String str) {
        if (textView == null) {
            return;
        }
        if (z) {
            textView.setEnabled(false);
            textView.setText("已开启");
            textView.setTextColor(getResources().getColor(R.color.colorGray));
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setBackgroundResource(R.drawable.shape_gray_3);
            if (!z2 || TextUtils.isEmpty(str) || this.mOpenCount.contains(str)) {
                return;
            }
            this.mOpenCount += str;
            return;
        }
        textView.setEnabled(true);
        textView.setText("去开启");
        textView.setTextColor(getResources().getColor(R.color.blue));
        textView.setBackgroundResource(R.drawable.shape_blue_3);
    }
}
