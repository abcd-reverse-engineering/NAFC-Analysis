package ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.AppBean;
import bean.AppInfoBean;
import bean.CallBean;
import bean.CasePicBean;
import bean.ReportPersonBean;
import bean.ReportZPEleBean;
import bean.SmsBean;
import bean.SocialAccBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.PictureFileUtils;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.HistoryListInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.ReportCallView;
import ui.presenter.ReportPresenter;
import ui.view.MyScrollView;
import ui.view.PicItemView;
import util.y1;

/* loaded from: classes2.dex */
public class ReportNewActivity extends BaseActivity implements ReportCallView {
    public static int REPORTNUM = 0;
    public static String REPORT_UP_ID = "";
    private static final int REQUEST_CODE_PICTURE = 1001;
    private Dialog dialogRP;
    private LocalMedia fromRecordMedia;
    private ReportZPEleBean info;
    private ArrayList<AppInfoBean> intentApps;
    private CallBean intentCallBean;
    private SmsBean intentSMSBean;

    @BindView(R.id.tv_upload_app)
    TextView mAppNum;

    @BindView(R.id.tv_upload_audio)
    TextView mAudioNum;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.tv_upload_call)
    TextView mCallNum;

    @BindView(R.id.et_case_describe)
    TextView mEtCaseDescribe;

    @BindView(R.id.fl_app_bg)
    View mFlAppBg;

    @BindView(R.id.fl_audio_bg)
    View mFlAudioBg;

    @BindView(R.id.fl_pic_bg)
    View mFlPicBg;

    @BindView(R.id.fl_vedio_bg)
    View mFlVideoBg;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.ll_app)
    PicItemView mLlApp;

    @BindView(R.id.ll_dupery_type)
    FrameLayout mLlDuperyType;

    @BindView(R.id.ll_pic)
    PicItemView mLlPic;

    @BindView(R.id.myScrollView)
    MyScrollView mMyScrollView;

    @BindView(R.id.tv_num_tip)
    TextView mNumTip;

    @BindView(R.id.tv_upload_picture)
    TextView mPicNum;
    private ReportPresenter mPresenter;

    @BindView(R.id.region)
    TextView mRegion;

    @BindView(R.id.rl_title)
    RelativeLayout mRlTitle;

    @BindView(R.id.tv_upload_sms)
    TextView mSMSNum;

    @BindView(R.id.tv_social)
    TextView mSocialNum;

    @BindView(R.id.tv_trad)
    TextView mTradNum;

    @BindView(R.id.tv_attention)
    TextView mTvAttention;

    @BindView(R.id.tv_dupery_type)
    TextView mTvDuperyType;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_upload_url)
    TextView mUrlNum;

    @BindView(R.id.tv_upload_video)
    TextView mVideoNum;
    private String mVideoPath;
    private List<LocalMedia> mLocalVideoList = new ArrayList();
    private List<LocalMedia> mLocalAudioList = new ArrayList();
    private List<UploadStateInfo> mAudioStateList = new ArrayList();
    private List<UploadStateInfo> mAppStateList = new ArrayList();
    private List<UploadStateInfo> mPictureStateList = new ArrayList();
    private List<UploadStateInfo> mVideoStateList = new ArrayList();
    private List<CallBean> mCallList = new ArrayList();
    private List<SmsBean> mSmsList = new ArrayList();
    private List<LocalMedia> mPictureList = new ArrayList();
    private List<AppInfoBean> mAppList = new ArrayList();
    private List<String> mWebUrlList = new ArrayList();
    private List<SocialAccBean> mSocialAccs = new ArrayList();
    private List<SocialAccBean> mTradlAccs = new ArrayList();
    private List<CasePicBean> mCasePic = new ArrayList();
    private List<AppBean> mApps = new ArrayList();
    private int mDefraudCode = -1;
    private boolean isFromVirusCheck = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ReportNewActivity.this.mMyScrollView.fullScroll(130);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            ReportNewActivity.this.mPresenter.reportSubmit(ReportNewActivity.this.mCallList, ReportNewActivity.this.mSmsList, ReportNewActivity.this.mWebUrlList, ReportNewActivity.this.mSocialAccs, ReportNewActivity.this.mTradlAccs, ReportNewActivity.this.buildDiscCache());
        }
    }

    class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportNewActivity.this.mPresenter.cancleUploadFile(true);
            ReportNewActivity.this.cleanCacheData();
            ReportNewActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ReportNewActivity.this.saveCacheData();
            ReportNewActivity.this.cleanList();
            ReportNewActivity.this.finish();
        }
    }

    class d implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryListInfo.RowsBean f18707a;

        d(HistoryListInfo.RowsBean rowsBean) {
            this.f18707a = rowsBean;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ReportNewActivity.this.dialogRP.dismiss();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ReportNewActivity.this.dialogRP.dismiss();
            ReportNewActivity.this.finish();
            Intent intent = new Intent(ReportNewActivity.this.mActivity, (Class<?>) HistoryDetailActivity.class);
            intent.putExtra(util.k1.B, this.f18707a);
            ReportNewActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReportPersonBean buildDiscCache() {
        String str = getmRegionId();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String string = this.mRegion.getText().toString();
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        String string2 = this.mTvDuperyType.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            string2 = "";
        }
        String string3 = this.mEtCaseDescribe.getText().toString();
        String str2 = TextUtils.isEmpty(string3) ? "" : string3;
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic(str);
        reportPersonBean.setReportAdd(string);
        reportPersonBean.setDupery(string2);
        reportPersonBean.setDefraudType(this.mDefraudCode);
        reportPersonBean.setCaseDis(str2);
        return reportPersonBean;
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20916j}, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanCacheData() {
        util.u1.a((Object) null, util.u1.c0);
        util.u1.a((List) null, util.u1.d0);
        util.u1.a((List) null, util.u1.e0);
        util.u1.a((List) null, util.u1.f0);
        util.u1.a((List) null, util.u1.h0);
        util.u1.a((List) null, util.u1.k0);
        util.u1.a((List) null, util.u1.l0);
        util.u1.a((List) null, util.u1.m0);
        util.u1.a((List) null, util.u1.o0);
        util.u1.a((List) null, util.u1.p0);
        util.u1.a((List) null, util.u1.q0);
        util.u1.b(util.u1.v, "");
        j.c.a(j.c.f17003a);
        cleanList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanList() {
        REPORT_UP_ID = "";
        this.mCallList.clear();
        this.mSmsList.clear();
        this.mAppList.clear();
        this.mPictureList.clear();
        this.mLocalAudioList.clear();
        this.mLocalVideoList.clear();
        this.mWebUrlList.clear();
        this.mSocialAccs.clear();
        this.mTradlAccs.clear();
        this.mAudioStateList.clear();
        this.mAppStateList.clear();
        this.mPictureStateList.clear();
        this.mVideoStateList.clear();
        this.mCasePic.clear();
        this.mApps.clear();
        this.mLlApp.setAppSData(this.mApps);
        this.mLlPic.setPicListData(this.mPictureList);
        this.mTvDuperyType.setText("");
        this.mRegion.setText("");
        this.mEtCaseDescribe.setText("");
        this.info = null;
        this.mCallNum.setText("请选择");
        this.mSMSNum.setText("请选择");
        this.mAppNum.setText("请选择");
        this.mPicNum.setText("请选择");
        this.mAudioNum.setText("请选择");
        this.mVideoNum.setText("请选择");
        this.mUrlNum.setText("请填写");
        this.mSocialNum.setText("请填写");
        this.mTradNum.setText("请填写");
        this.mFlAppBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlPicBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlAudioBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlVideoBg.setBackgroundResource(R.drawable.white_corner);
        PictureFileUtils.deleteAllCacheDirFile(this);
        TradAccountActivity.f19107c = false;
    }

    private void fixApps() {
        if (this.intentApps != null) {
            for (int i2 = 0; i2 < this.intentApps.size(); i2++) {
                this.mApps.add(AppBean.AppInfoBean2AppBean(this.intentApps.get(i2)));
                this.mAppStateList.add(new UploadStateInfo());
            }
        }
    }

    private void fixRecordMediasAudio() {
        if (util.f1.e(this.mVideoPath)) {
            this.mLocalAudioList.add(this.fromRecordMedia);
            this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
            this.mAudioStateList.add(new UploadStateInfo());
        }
    }

    private void fixRecordMediasVideo() {
        if (util.f1.f(this.mVideoPath)) {
            this.mLocalVideoList.add(this.fromRecordMedia);
            this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
            this.mVideoStateList.add(new UploadStateInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCacheBean, reason: merged with bridge method [inline-methods] */
    public void a() {
        List<SocialAccBean> list;
        REPORT_UP_ID = util.u1.b(util.u1.v);
        ReportPersonBean reportPersonBean = (ReportPersonBean) util.u1.a(util.u1.c0, ReportPersonBean.class);
        if (reportPersonBean != null) {
            this.mEtCaseDescribe.setText(reportPersonBean.getCaseDis());
            this.mRegion.setText(reportPersonBean.getReportAdd());
            this.mTvDuperyType.setText(reportPersonBean.getDupery());
            this.mDefraudCode = reportPersonBean.getDefraudType();
            setRegionId(reportPersonBean.getReportDic());
        }
        List<CallBean> listB = util.u1.b(util.u1.d0, CallBean.class);
        List<SmsBean> listB2 = util.u1.b(util.u1.e0, SmsBean.class);
        List<AppBean> listB3 = util.u1.b(util.u1.f0, AppBean.class);
        List<CasePicBean> listB4 = util.u1.b(util.u1.h0, CasePicBean.class);
        List<LocalMedia> listB5 = util.u1.b(util.u1.k0, LocalMedia.class);
        List<LocalMedia> listB6 = util.u1.b(util.u1.m0, LocalMedia.class);
        List<String> listB7 = util.u1.b(util.u1.o0, String.class);
        List<SocialAccBean> listB8 = util.u1.b(util.u1.p0, SocialAccBean.class);
        List<SocialAccBean> listB9 = util.u1.b(util.u1.q0, SocialAccBean.class);
        List<UploadStateInfo> listB10 = util.u1.b(util.u1.l0, UploadStateInfo.class);
        List<UploadStateInfo> listB11 = util.u1.b(util.u1.g0, UploadStateInfo.class);
        List<UploadStateInfo> listB12 = util.u1.b(util.u1.j0, UploadStateInfo.class);
        List<UploadStateInfo> listB13 = util.u1.b(util.u1.n0, UploadStateInfo.class);
        if (listB == null || listB.size() <= 0) {
            list = listB9;
            CallBean callBean = this.intentCallBean;
            if (callBean != null) {
                this.mCallList.add(callBean);
                this.mCallNum.setText(this.mCallList.size() + "个");
            }
        } else {
            this.mCallList = listB;
            CallBean callBean2 = this.intentCallBean;
            if (callBean2 != null) {
                this.mCallList.add(callBean2);
            }
            TextView textView = this.mCallNum;
            StringBuilder sb = new StringBuilder();
            list = listB9;
            sb.append(this.mCallList.size());
            sb.append("个");
            textView.setText(sb.toString());
        }
        if (listB2 == null || listB2.size() <= 0) {
            SmsBean smsBean = this.intentSMSBean;
            if (smsBean != null) {
                this.mSmsList.add(smsBean);
                this.mSMSNum.setText(this.mSmsList.size() + "条");
            }
        } else {
            this.mSmsList = listB2;
            SmsBean smsBean2 = this.intentSMSBean;
            if (smsBean2 != null) {
                this.mSmsList.add(smsBean2);
            }
            this.mSMSNum.setText(this.mSmsList.size() + "条");
        }
        if (listB5 == null || listB5.size() <= 0) {
            fixRecordMediasAudio();
            if (this.mLocalAudioList.size() > 0) {
                this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
            }
        } else {
            this.mLocalAudioList = listB5;
            this.mAudioStateList = listB10;
            fixRecordMediasAudio();
            this.mAudioNum.setText(this.mLocalAudioList.size() + "个");
        }
        if (listB6 == null || listB6.size() <= 0) {
            fixRecordMediasVideo();
            if (this.mLocalVideoList.size() > 0) {
                this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
            }
        } else {
            this.mLocalVideoList = listB6;
            this.mVideoStateList = listB13;
            fixRecordMediasVideo();
            this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
        }
        if (listB3 == null || listB3.size() <= 0) {
            ArrayList<AppInfoBean> arrayList = this.intentApps;
            if (arrayList == null || arrayList.size() <= 0) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(1, null));
            } else {
                fixApps();
                this.mLlApp.setAppSData(this.mApps);
                this.mAppNum.setText(this.mApps.size() + "个");
            }
        } else {
            this.mAppList.clear();
            this.mApps = listB3;
            this.mAppStateList = listB11;
            fixApps();
            this.mLlApp.setAppSData(this.mApps);
            this.mAppNum.setText(this.mApps.size() + "个");
        }
        if (listB4 != null && listB4.size() > 0) {
            this.mPictureList.clear();
            this.mCasePic = listB4;
            this.mPictureStateList = listB12;
            this.mPicNum.setText(this.mCasePic.size() + "个");
            for (int i2 = 0; i2 < this.mCasePic.size(); i2++) {
                LocalMedia localMedia = new LocalMedia();
                localMedia.setPath(this.mCasePic.get(i2).getPath());
                this.mPictureList.add(localMedia);
            }
            this.mLlPic.setPicListData(this.mPictureList);
        }
        if (listB7 != null && listB7.size() > 0) {
            this.mWebUrlList = listB7;
            this.mUrlNum.setText(this.mWebUrlList.size() + "个");
        }
        if (listB8 != null && listB8.size() > 0) {
            this.mSocialAccs = listB8;
            this.mSocialNum.setText(this.mSocialAccs.size() + "个");
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTradlAccs = list;
        this.mTradNum.setText(this.mTradlAccs.size() + "个");
    }

    private void getRecordInfo() {
        this.mVideoPath = getIntent().getStringExtra("video_path");
        if (this.mVideoPath != null) {
            this.fromRecordMedia = new LocalMedia();
            this.fromRecordMedia.setPath(this.mVideoPath);
        }
    }

    private boolean hasData() {
        return this.mTvDuperyType.getText().toString().length() > 0 || this.mRegion.getText().toString().length() > 0 || this.mEtCaseDescribe.getText().toString().length() > 0 || this.mCallList.size() > 0 || this.mSmsList.size() > 0 || this.mApps.size() > 0 || this.mAppList.size() > 0 || this.mCasePic.size() > 0 || this.mPictureList.size() > 0 || this.mLocalVideoList.size() > 0 || this.mLocalAudioList.size() > 0 || this.mWebUrlList.size() > 0 || this.mSocialAccs.size() > 0 || this.mTradlAccs.size() > 0;
    }

    private boolean hasReportData() {
        return this.mCallList.size() > 0 || this.mSmsList.size() > 0 || this.mWebUrlList.size() > 0 || this.mSocialAccs.size() > 0 || this.mTradlAccs.size() > 0;
    }

    private int hasUpFileId() {
        if (this.mApps.size() <= 0 && this.mAppList.size() <= 0 && this.mCasePic.size() <= 0 && this.mPictureList.size() <= 0 && this.mLocalAudioList.size() <= 0 && this.mLocalVideoList.size() <= 0) {
            return 0;
        }
        if (!TextUtils.isEmpty(REPORT_UP_ID)) {
            return upFileFail();
        }
        upFileFail();
        return 1;
    }

    private void initScanData(Intent intent) {
        this.intentCallBean = (CallBean) intent.getSerializableExtra("intecepte_phone_number");
        this.intentSMSBean = (SmsBean) intent.getSerializableExtra(util.k1.u);
        this.intentApps = getIntent().getParcelableArrayListExtra(util.k1.t);
        ArrayList<AppInfoBean> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(util.k1.x);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
            return;
        }
        this.intentApps = parcelableArrayListExtra;
        this.isFromVirusCheck = true;
    }

    private void initView() {
        util.b1.a(this, 3, "110", getString(R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        this.mTvTitle.setText(R.string.one_key_report);
        this.mNumTip.setText(Html.fromHtml("今日剩余可举报次数<font color=#2B4CFF>" + REPORTNUM + "</font>次"));
        this.mPresenter = new ReportPresenter(this, this);
        if (isNeedSaveOrClear()) {
            this.mMyScrollView.post(new a());
        } else {
            showProgressDialog("加载中...", true);
            y1.f21027b.post(new Runnable() { // from class: ui.activity.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19487a.a();
                }
            });
        }
    }

    private boolean isNeedSaveOrClear() {
        return TradAccountActivity.f19107c;
    }

    private boolean reportDisct() {
        return this.mTvDuperyType.getText().toString().length() > 0 || this.mRegion.getText().toString().length() > 0 || this.mEtCaseDescribe.getText().toString().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCacheData() {
        util.u1.b(util.u1.v, REPORT_UP_ID);
        util.u1.a(buildDiscCache(), util.u1.c0);
        util.u1.a((List) this.mCallList, util.u1.d0);
        util.u1.a((List) this.mSmsList, util.u1.e0);
        util.u1.a((List) this.mLocalAudioList, util.u1.k0);
        util.u1.a((List) this.mLocalVideoList, util.u1.m0);
        util.u1.a((List) this.mWebUrlList, util.u1.o0);
        util.u1.a((List) this.mSocialAccs, util.u1.p0);
        util.u1.a((List) this.mTradlAccs, util.u1.q0);
        util.u1.a((List) this.mAudioStateList, util.u1.l0);
        util.u1.a((List) this.mAppStateList, util.u1.g0);
        util.u1.a((List) this.mPictureStateList, util.u1.j0);
        util.u1.a((List) this.mVideoStateList, util.u1.n0);
        this.mCasePic.clear();
        this.mApps.clear();
        for (int i2 = 0; i2 < this.mPictureList.size(); i2++) {
            CasePicBean casePicBean = new CasePicBean();
            casePicBean.setPath(this.mPictureList.get(i2).getPath());
            this.mCasePic.add(casePicBean);
        }
        for (int i3 = 0; i3 < this.mAppList.size(); i3++) {
            j.c.a(j.c.a(this.mAppList.get(i3).getAppIcon()), this.mAppList.get(i3).getName(), this.mAppList.get(i3).getVersionName(), j.c.f17003a);
            this.mApps.add(AppBean.AppInfoBean2AppBean(this.mAppList.get(i3)));
        }
        util.u1.a((List) this.mApps, util.u1.f0);
        util.u1.a((List) this.mCasePic, util.u1.h0);
    }

    private void saveDataCache() {
        if (!hasData()) {
            cleanCacheData();
            finish();
        } else if (!isNeedSaveOrClear()) {
            util.b1.a((Activity) this, "将此次编辑保留", "", "不保留", "保留", R.color._353536, -1, true, (IClickListener) new c());
        } else {
            cleanList();
            finish();
        }
    }

    private int upFileFail() {
        this.mFlAppBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlPicBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlAudioBg.setBackgroundResource(R.drawable.white_corner);
        this.mFlVideoBg.setBackgroundResource(R.drawable.white_corner);
        if (this.mAppStateList.size() > 0) {
            Iterator<UploadStateInfo> it = this.mAppStateList.iterator();
            while (it.hasNext()) {
                if (it.next().getUploadState() != 2) {
                    this.mFlAppBg.setBackgroundResource(R.drawable.red_corner);
                    return 3;
                }
            }
        }
        if (this.mPictureStateList.size() > 0) {
            Iterator<UploadStateInfo> it2 = this.mPictureStateList.iterator();
            while (it2.hasNext()) {
                if (it2.next().getUploadState() != 2) {
                    this.mFlPicBg.setBackgroundResource(R.drawable.red_corner);
                    return 4;
                }
            }
        }
        if (this.mAudioStateList.size() > 0) {
            Iterator<UploadStateInfo> it3 = this.mAudioStateList.iterator();
            while (it3.hasNext()) {
                if (it3.next().getUploadState() != 2) {
                    this.mFlAudioBg.setBackgroundResource(R.drawable.red_corner);
                    return 5;
                }
            }
        }
        if (this.mVideoStateList.size() > 0) {
            Iterator<UploadStateInfo> it4 = this.mVideoStateList.iterator();
            while (it4.hasNext()) {
                if (it4.next().getUploadState() != 2) {
                    this.mFlVideoBg.setBackgroundResource(R.drawable.red_corner);
                    return 6;
                }
            }
        }
        return 2;
    }

    public void doKeyBack() {
        saveDataCache();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13594l);
        org.greenrobot.eventbus.c.f().e(this);
        initScanData(getIntent());
        getRecordInfo();
        initView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        if (Jzvd.C()) {
            return;
        }
        super.a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 16) {
                this.mSocialAccs.clear();
                this.mSocialNum.setText("请填写");
                ArrayList arrayList = (ArrayList) aVar.b();
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                this.mSocialAccs = arrayList;
                this.mSocialNum.setText(this.mSocialAccs.size() + "个");
            }
            if (iA == 19) {
                this.mTradlAccs.clear();
                this.mTradNum.setText("请填写");
                ArrayList arrayList2 = (ArrayList) aVar.b();
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    return;
                }
                this.mTradlAccs = arrayList2;
                this.mTradNum.setText(this.mTradlAccs.size() + "个");
                return;
            }
            switch (iA) {
                case 1:
                    hideProgressDialog();
                    List<AppInfoBean> list = (List) aVar.b();
                    if (list != null) {
                        this.mAppList = list;
                        break;
                    }
                    break;
                case 2:
                    this.mEtCaseDescribe.setText((String) aVar.b());
                    break;
                case 3:
                    this.info = (ReportZPEleBean) aVar.b();
                    ReportZPEleBean reportZPEleBean = this.info;
                    if (reportZPEleBean != null) {
                        this.mTvDuperyType.setText(reportZPEleBean.getName());
                        this.mDefraudCode = this.info.getCode();
                        break;
                    }
                    break;
                case 4:
                    this.mLocalAudioList.clear();
                    this.mAudioStateList.clear();
                    this.mAudioNum.setText("请选择");
                    List<LocalMedia> list2 = (List) aVar.b();
                    if (list2 != null && list2.size() > 0) {
                        this.mAudioNum.setText(list2.size() + "个");
                        this.mLocalAudioList = list2;
                    }
                    List<UploadStateInfo> list3 = (List) aVar.d();
                    if (list3 != null && list3.size() > 0) {
                        this.mAudioStateList = list3;
                    }
                    upFileFail();
                    break;
                case 5:
                    this.mApps.clear();
                    this.mAppList.clear();
                    this.mAppStateList.clear();
                    this.mAppNum.setText("请选择");
                    this.mLlApp.setAppListData(this.mAppList);
                    List<AppInfoBean> list4 = (List) aVar.b();
                    if (list4 != null && list4.size() > 0) {
                        this.mAppList = list4;
                        this.mAppNum.setText(this.mAppList.size() + "个");
                        this.mLlApp.setAppListData(this.mAppList);
                    }
                    List<UploadStateInfo> list5 = (List) aVar.d();
                    if (list5 != null && list5.size() > 0) {
                        this.mAppStateList = list5;
                    }
                    upFileFail();
                    break;
                case 6:
                    this.mCasePic.clear();
                    this.mPictureList.clear();
                    this.mPictureStateList.clear();
                    this.mPicNum.setText("请选择");
                    this.mLlPic.setPicListData(this.mPictureList);
                    List<LocalMedia> list6 = (List) aVar.b();
                    if (list6 != null && list6.size() > 0) {
                        this.mPictureList = list6;
                        this.mPicNum.setText(this.mPictureList.size() + "个");
                        this.mLlPic.setPicListData(this.mPictureList);
                    }
                    List<UploadStateInfo> list7 = (List) aVar.d();
                    if (list7 != null && list7.size() > 0) {
                        this.mPictureStateList = list7;
                    }
                    upFileFail();
                    break;
                case 7:
                    this.mLocalVideoList.clear();
                    this.mVideoStateList.clear();
                    this.mVideoNum.setText("请选择");
                    List<LocalMedia> list8 = (List) aVar.b();
                    if (list8 != null && list8.size() > 0) {
                        this.mLocalVideoList = list8;
                        this.mVideoNum.setText(this.mLocalVideoList.size() + "个");
                    }
                    List<UploadStateInfo> list9 = (List) aVar.d();
                    if (list9 != null && list9.size() > 0) {
                        this.mVideoStateList = list9;
                    }
                    upFileFail();
                    break;
                case 8:
                    this.mWebUrlList.clear();
                    this.mUrlNum.setText("请填写");
                    ArrayList arrayList3 = (ArrayList) aVar.b();
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        this.mWebUrlList = arrayList3;
                        this.mUrlNum.setText(this.mWebUrlList.size() + "个");
                        break;
                    }
                    break;
                case 9:
                    this.mCallList.clear();
                    this.mCallNum.setText("请选择");
                    ArrayList arrayList4 = (ArrayList) aVar.b();
                    if (arrayList4 != null && arrayList4.size() > 0) {
                        this.mCallList = arrayList4;
                        this.mCallNum.setText(arrayList4.size() + "个");
                        break;
                    }
                    break;
                case 10:
                    this.mSmsList.clear();
                    this.mSMSNum.setText("请选择");
                    ArrayList arrayList5 = (ArrayList) aVar.b();
                    if (arrayList5 != null && arrayList5.size() > 0) {
                        this.mSmsList = arrayList5;
                        this.mSMSNum.setText(this.mSmsList.size() + "个");
                        break;
                    }
                    break;
            }
        }
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 11) {
                org.greenrobot.eventbus.c.f().f(aVar);
                SmsBean smsBean = (SmsBean) aVar.b();
                if (smsBean != null) {
                    this.mSmsList.add(smsBean);
                    this.mSMSNum.setText(this.mSmsList.size() + "个");
                    return;
                }
                return;
            }
            if (iA != 12) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            List list = (List) aVar.b();
            if (list != null && list.size() > 0) {
                this.mAppList.addAll(list);
                try {
                    this.mAppNum.setText(this.mAppList.size() + "个");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    util.n1.b(e2.getMessage());
                }
                this.mLlApp.setAppListData(this.mAppList);
            }
            List list2 = (List) aVar.d();
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            this.mAppStateList.addAll(list2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        doKeyBack();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13594l);
        this.isFromVirusCheck = false;
        setIntent(intent);
        initScanData(getIntent());
        getRecordInfo();
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Jzvd.F();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Hicore.fromPageReport = true;
    }

    @Override // ui.callview.ReportCallView
    public void onSuccessRequest(HistoryListInfo.RowsBean rowsBean) {
        hideProgressDialog();
        if (this.isFromVirusCheck) {
            ArrayList arrayList = new ArrayList();
            List<AppInfoBean> list = this.mAppList;
            if (list != null && list.size() > 0) {
                for (AppInfoBean appInfoBean : this.mAppList) {
                    if (appInfoBean.getSource() == 1) {
                        arrayList.add(appInfoBean);
                    }
                }
            }
            org.greenrobot.eventbus.c.f().d(new util.c2.a(26, arrayList));
        }
        if (isNeedSaveOrClear()) {
            cleanList();
        } else {
            cleanCacheData();
        }
        TextView textView = this.mNumTip;
        StringBuilder sb = new StringBuilder();
        sb.append("今日剩余可举报次数<font color=#2B4CFF>");
        int i2 = REPORTNUM - 1;
        REPORTNUM = i2;
        sb.append(i2);
        sb.append("</font>次");
        textView.setText(Html.fromHtml(sb.toString()));
        this.dialogRP = util.b1.a(REPORTNUM, this.mActivity, "举报成功", "感谢您的举报，我们将尽快处理", "继续举报", "查看举报", new d(rowsBean));
    }

    @OnClick({R.id.iv_back, R.id.btn_commit, R.id.tv_upload_video, R.id.tv_upload_call, R.id.tv_upload_audio, R.id.tv_upload_sms, R.id.tv_upload_app, R.id.tv_upload_picture, R.id.region, R.id.et_case_describe, R.id.tv_record_help, R.id.tv_upload_url, R.id.ll_dupery_type, R.id.tv_social, R.id.tv_trad})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    if (hasUpFileId() == 0 && !hasReportData()) {
                        util.b1.b(this.mActivity, "请至少填写一项举报信息", "知道了", null);
                        break;
                    } else if (hasUpFileId() != 1 && hasUpFileId() != 3 && hasUpFileId() != 4 && hasUpFileId() != 5 && hasUpFileId() != 6) {
                        if (this.mDefraudCode != -1 && !TextUtils.isEmpty(this.mTvDuperyType.getText())) {
                            checkPermission();
                            break;
                        } else {
                            util.w1.a("请选择诈骗类型");
                            break;
                        }
                    } else {
                        util.w1.a("请先上传文件");
                        break;
                    }
                }
                break;
            case R.id.et_case_describe /* 2131296552 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) EvidenceDiscActivity.class);
                intent.putExtra("disc", this.mEtCaseDescribe.getText().toString());
                intent.putExtra("title", "举报描述");
                startActivity(intent);
                break;
            case R.id.iv_back /* 2131296762 */:
                saveDataCache();
                break;
            case R.id.ll_dupery_type /* 2131296944 */:
                Intent intent2 = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent2.putExtra(util.k1.O, reportZPEleBean);
                }
                startActivity(intent2);
                break;
            case R.id.region /* 2131297159 */:
                regionShow(this.mRegion, this.mActivity);
                break;
            case R.id.tv_record_help /* 2131297677 */:
                startActivity(new Intent(this.mActivity, (Class<?>) RecordHelpActivity.class));
                break;
            case R.id.tv_social /* 2131297716 */:
                Intent intent3 = new Intent(this, (Class<?>) SocialAccountActivity.class);
                intent3.putExtra(util.k1.o, (Serializable) this.mSocialAccs);
                startActivity(intent3);
                break;
            case R.id.tv_trad /* 2131297766 */:
                Intent intent4 = new Intent(this, (Class<?>) TradAccountActivity.class);
                intent4.putExtra(util.k1.r, (Serializable) this.mTradlAccs);
                startActivity(intent4);
                break;
            case R.id.tv_upload_app /* 2131297786 */:
                startActivity(new Intent(this, (Class<?>) AppActivity.class));
                List<AppInfoBean> list = this.mAppList;
                if (list != null && list.size() > 0) {
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(50, this.mAppList, this.mAppStateList));
                    break;
                }
                break;
            case R.id.tv_upload_audio /* 2131297787 */:
                startActivity(new Intent(this, (Class<?>) AudioActivity.class));
                List<LocalMedia> list2 = this.mLocalAudioList;
                if (list2 != null && list2.size() > 0) {
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(40, this.mLocalAudioList, this.mAudioStateList));
                    break;
                }
                break;
            case R.id.tv_upload_call /* 2131297788 */:
                Intent intent5 = new Intent(this, (Class<?>) CallNewActivity.class);
                List<CallBean> list3 = this.mCallList;
                if (list3 != null && list3.size() > 0) {
                    intent5.putExtra(util.k1.s, (Serializable) this.mCallList);
                }
                startActivity(intent5);
                break;
            case R.id.tv_upload_picture /* 2131297789 */:
                startActivity(new Intent(this, (Class<?>) PictureActivity.class));
                List<LocalMedia> list4 = this.mPictureList;
                if (list4 != null && list4.size() > 0) {
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(60, this.mPictureList, this.mPictureStateList));
                    break;
                }
                break;
            case R.id.tv_upload_sms /* 2131297790 */:
                Intent intent6 = new Intent(this, (Class<?>) SmsActivity.class);
                List<SmsBean> list5 = this.mSmsList;
                if (list5 != null && list5.size() > 0) {
                    intent6.putExtra(util.k1.u, (Serializable) this.mSmsList);
                }
                startActivity(intent6);
                break;
            case R.id.tv_upload_url /* 2131297792 */:
                Intent intent7 = new Intent(this, (Class<?>) WebsiteActivity.class);
                intent7.putStringArrayListExtra(util.k1.n, (ArrayList) this.mWebUrlList);
                startActivity(intent7);
                break;
            case R.id.tv_upload_video /* 2131297793 */:
                startActivity(new Intent(this, (Class<?>) VideoActivity.class));
                List<LocalMedia> list6 = this.mLocalVideoList;
                if (list6 != null && list6.size() > 0) {
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(70, this.mLocalVideoList, this.mVideoStateList));
                    break;
                }
                break;
        }
    }

    @Override // ui.callview.ReportCallView
    public void onfailRequest() {
        util.b1.a((Activity) this, false, 1, "提交失败请重新提交", R.drawable.iv_comit_fail);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_new;
    }
}
