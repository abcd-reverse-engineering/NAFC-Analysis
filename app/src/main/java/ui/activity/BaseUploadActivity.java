package ui.activity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import bean.OssFileInfo;
import bean.ReportResultBean;
import bean.UploadStateInfo;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.request.ReportCaseInfo;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.AudioCallView;
import ui.presenter.HandleFilePresenter;

/* loaded from: classes2.dex */
public abstract class BaseUploadActivity extends BaseActivity implements AudioCallView {
    public static final String UPLOAD_FINISH_TXT = "确定";
    public static final int UPLOAD_STATE_FAIL = 3;
    public static final int UPLOAD_STATE_LOADING = 0;
    public static final int UPLOAD_STATE_SUCCESS = 2;
    public static final int UPLOAD_STATE_UPLOAD = 1;
    public ReportCaseInfo info;
    private HandleFilePresenter mPresenter;
    public List<UploadStateInfo> mUploadStateList = new ArrayList();
    public int mCurrentUploadIndex = -1;

    class a implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17706a;

        a(int i2) {
            this.f17706a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BaseUploadActivity.this.mUploadStateList.get(this.f17706a).getUploadState() == 1) {
                    AliOssClient.getInstance().taskCancle();
                }
                BaseUploadActivity.this.cancelUpdateHttp(this.f17706a);
                BaseUploadActivity.this.clearItem(this.f17706a);
                BaseUploadActivity.this.UploadNextFile();
            } catch (Exception unused) {
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            BaseUploadActivity.this.stopUpload();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class c implements HandleFilePresenter.d {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ OssFileInfo f17710a;

            a(OssFileInfo ossFileInfo) {
                this.f17710a = ossFileInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (this.f17710a != null) {
                        String filePath = this.f17710a.getFilePath();
                        if (!TextUtils.isEmpty(filePath)) {
                            BaseUploadActivity.this.mUploadStateList.get(BaseUploadActivity.this.mCurrentUploadIndex).setFilePath(filePath);
                        }
                        String fileMd5 = this.f17710a.getFileMd5();
                        if (!TextUtils.isEmpty(fileMd5)) {
                            BaseUploadActivity.this.mUploadStateList.get(BaseUploadActivity.this.mCurrentUploadIndex).setFileMd5(fileMd5);
                        }
                    }
                    BaseUploadActivity.this.doUpload();
                } catch (Exception unused) {
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseUploadActivity.this.resultFail();
            }
        }

        c() {
        }

        @Override // ui.presenter.HandleFilePresenter.d
        public void onSuccess(OssFileInfo ossFileInfo) {
            BaseUploadActivity.this.runOnUiThread(new a(ossFileInfo));
        }

        @Override // ui.presenter.HandleFilePresenter.d
        public void onfail() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                BaseUploadActivity.this.runOnUiThread(new b());
            } else {
                BaseUploadActivity.this.resultFail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadNextFile() {
        int i2;
        nextUploadIndex();
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size()) {
            setUpId();
            ossUpload(getChildPath());
        } else if (isAllSuccess()) {
            changeBtnCommit("确定", true);
        } else {
            changeBtnCommit("上传文件", true);
        }
    }

    static /* synthetic */ void a(APIresult aPIresult) {
        if (aPIresult.getCode() == 0) {
            util.n1.c("onNextMiddle--》", "成功");
        } else {
            util.w1.a("删除失败，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelUpdateHttp(int i2) {
        String fileId = this.mUploadStateList.get(i2).getFileId();
        if (TextUtils.isEmpty(fileId)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        String upId = getUpId();
        if (TextUtils.isEmpty(upId)) {
            return;
        }
        map.put("id", upId);
        if (this.mActivity instanceof AppActivity) {
            map.put("appReportDetailId", fileId);
        } else {
            map.put("reportDetailId", fileId);
        }
        this.mPresenter.cancelUpdateHttp(map, new HandleFilePresenter.c() { // from class: ui.activity.h
            @Override // ui.presenter.HandleFilePresenter.c
            public final void onSuccRequest(APIresult aPIresult) {
                BaseUploadActivity.a(aPIresult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItem(int i2) {
        boolean z;
        removeLocalData(i2);
        this.mUploadStateList.remove(i2);
        int i3 = this.mCurrentUploadIndex;
        if (i3 > i2) {
            this.mCurrentUploadIndex = i3 - 1;
        } else if (i3 == i2) {
            this.mCurrentUploadIndex = -1;
        }
        notifyAdapter();
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().getUploadState() != 2) {
                z = false;
                break;
            }
        }
        if (z) {
            changeBtnCommit("确定", true);
        }
    }

    private String getTruePath(String str) throws IllegalArgumentException {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    private void nextUploadFailIndex() {
        for (int i2 = 0; i2 < this.mUploadStateList.size(); i2++) {
            if (this.mUploadStateList.get(i2).getUploadState() == 3 || this.mUploadStateList.get(i2).getUploadState() == 1) {
                this.mUploadStateList.get(i2).setUploadState(0);
                return;
            }
        }
    }

    private void ossUpload(String str) {
        try {
            if (this.mCurrentUploadIndex > -1) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(1);
                changeBtnCommit("", false);
                notifyAdapter();
            }
        } catch (Exception unused) {
        }
        this.mPresenter.ossUpload(str, new c());
    }

    private void resultDeal(boolean z) {
        int i2;
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size() && this.mCurrentUploadIndex < this.mUploadStateList.size()) {
            if (z) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(2);
            } else {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(3);
                changeBtnCommit("上传文件", true);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    public void backDialog() {
        util.b1.a(this.mActivity, "是否停止文件上传？", "", "是", "否", R.color._353536, -1, (IClickListener) new b());
    }

    public boolean backPressedUpload() {
        if (rejuctOperation(true)) {
            return true;
        }
        sendData();
        finish();
        return false;
    }

    public void changeBtnCommit(String str, boolean z) {
    }

    @Override // ui.activity.BaseActivity
    public void changePath(List<LocalMedia> list) throws IllegalArgumentException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    public void commitDeal() {
        int i2;
        if (!util.q1.f()) {
            util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail();
            return;
        }
        if (isAllSuccess()) {
            sendData();
            finish();
            return;
        }
        nextUploadIndex();
        if (this.mCurrentUploadIndex <= -1) {
            nextUploadFailIndex();
            nextUploadIndex();
        }
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list == null || (i2 = this.mCurrentUploadIndex) <= -1 || i2 >= list.size()) {
            return;
        }
        createCaseInfo();
        ossUpload(getChildPath());
    }

    public void createCaseInfo() {
        if (this.info == null) {
            this.info = new ReportCaseInfo();
            this.info.setCommonParams();
        }
        setUpId();
    }

    public void deleteDialog(int i2) {
        if (i2 >= this.mUploadStateList.size()) {
            return;
        }
        int uploadState = this.mUploadStateList.get(i2).getUploadState();
        if (uploadState != 0) {
            if (uploadState == 1) {
                util.b1.a(this.mActivity, "是否停止上传并删除所选记录？", "", "是", "否", R.color._353536, -1, (IClickListener) new a(i2));
                return;
            }
            if (uploadState == 2) {
                if (!util.q1.f()) {
                    util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
                    return;
                } else {
                    cancelUpdateHttp(i2);
                    clearItem(i2);
                    return;
                }
            }
            if (uploadState != 3) {
                return;
            }
        }
        clearItem(i2);
    }

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && localMedia != null)) {
            list2 = new ArrayList<>();
            list2.add(localMedia);
        }
        Iterator<LocalMedia> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            LocalMedia next = it.next();
            if (list.size() > 0) {
                for (LocalMedia localMedia2 : list) {
                    if (!next.getPath().equals(localMedia2.getPath())) {
                        if (Build.VERSION.SDK_INT > 28 && getChildSource() == 3) {
                            try {
                                String path = localMedia2.getPath();
                                String path2 = next.getPath();
                                if (util.o1.a(new File(path)).equals(util.o1.a(new File(path2)))) {
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    z = true;
                }
                if (!z) {
                    next.setChecked(true);
                    list.add(next);
                }
            } else {
                next.setChecked(true);
                list.add(next);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia3 = list.get(i2);
            if (localMedia3.isChecked()) {
                localMedia3.setChecked(false);
                this.mUploadStateList.add(i2, new UploadStateInfo());
            }
        }
    }

    public void doUpload() {
    }

    public String getChildPath() {
        return "";
    }

    public int getChildSource() {
        return -1;
    }

    public String getUpId() {
        return Hicore.fromPageReport ? ReportNewActivity.REPORT_UP_ID : util.u1.b(util.u1.w);
    }

    @Override // ui.activity.BaseActivity
    public abstract void initPage();

    public boolean isAllSuccess() {
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasFail() {
        if (this.mUploadStateList.size() == 0) {
            return false;
        }
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasUpload() {
        Iterator<UploadStateInfo> it = this.mUploadStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 1) {
                return true;
            }
        }
        return false;
    }

    public void networkFail() {
    }

    public void nextUploadIndex() {
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list == null || list.size() <= 0) {
            this.mCurrentUploadIndex = -1;
            util.n1.a("mCurrentUploadIndex-->-1 mUploadStateList");
            return;
        }
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            if (i2 >= this.mUploadStateList.size()) {
                z = true;
                break;
            }
            if (this.mUploadStateList.get(i2).getUploadState() != 2) {
                z2 = false;
            }
            if (this.mUploadStateList.get(i2).getUploadState() == 0) {
                this.mCurrentUploadIndex = i2;
                break;
            }
            i2++;
        }
        if (z) {
            this.mCurrentUploadIndex = -1;
            util.n1.a("mCurrentUploadIndex-->-1 noLoading");
        }
        if (z2) {
            this.mCurrentUploadIndex = -1;
            util.n1.a("mCurrentUploadIndex-->-1 allSuccess");
        }
    }

    public void notifyAdapter() {
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        org.greenrobot.eventbus.c.f().e(this);
        this.mPresenter = new HandleFilePresenter(this);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @Override // ui.callview.AudioCallView
    public void onErrorRequest() {
        resultFail();
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 40 || iA == 50 || iA == 60 || iA == 70 || iA == 80) {
                org.greenrobot.eventbus.c.f().f(aVar);
                redisplayData(aVar);
            }
        }
    }

    @Override // ui.callview.AudioCallView
    public void onNextRequest(APIresult<ReportResultBean> aPIresult) {
        try {
            if (aPIresult.getCode() != 0) {
                util.w1.a(aPIresult.getMsg());
                resultFail();
                return;
            }
            ReportResultBean data = aPIresult.getData();
            if (data == null) {
                resultFail();
                return;
            }
            String id = data.getId();
            if (!TextUtils.isEmpty(id)) {
                if (Hicore.fromPageReport) {
                    ReportNewActivity.REPORT_UP_ID = id;
                } else {
                    util.u1.b(util.u1.w, id);
                }
            }
            if (this.mCurrentUploadIndex <= -1) {
                resultFail();
                return;
            }
            String appReportDetailId = TextUtils.isEmpty(data.getReportDetailId()) ? data.getAppReportDetailId() : data.getReportDetailId();
            if (!TextUtils.isEmpty(appReportDetailId)) {
                this.mUploadStateList.get(this.mCurrentUploadIndex).setFileId(appReportDetailId);
            }
            resultSuccess();
        } catch (Exception unused) {
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // ui.callview.AudioCallView
    public void onStartRequest() {
    }

    public void onSuccessRequest(APIresult aPIresult) {
    }

    public void onfailRequest() {
    }

    public void redisplayData(util.c2.a aVar) {
    }

    public boolean rejuctOperation(boolean z) {
        boolean zIsHasUpload = isHasUpload();
        if (zIsHasUpload) {
            if (z) {
                backDialog();
            } else {
                uploadingTip();
            }
        }
        return zIsHasUpload;
    }

    public void removeLocalData(int i2) {
    }

    public void resetToLoading() {
        for (UploadStateInfo uploadStateInfo : this.mUploadStateList) {
            if (uploadStateInfo.getUploadState() == 3) {
                uploadStateInfo.setUploadState(0);
            }
        }
    }

    public void resultFail() {
        resultDeal(false);
    }

    public void resultSuccess() {
        resultDeal(true);
    }

    public void sendData() {
    }

    @Override // ui.activity.BaseActivity
    public abstract int setLayoutView();

    public void setUpId() {
        if (this.info == null) {
            createCaseInfo();
        }
        ReportCaseInfo reportCaseInfo = this.info;
        if (reportCaseInfo == null || !TextUtils.isEmpty(reportCaseInfo.getId())) {
            return;
        }
        String strB = Hicore.fromPageReport ? ReportNewActivity.REPORT_UP_ID : util.u1.b(util.u1.w);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        this.info.setId(strB);
    }

    public void stopUpload() {
        try {
            if (this.mCurrentUploadIndex > -1) {
                if (this.mUploadStateList.get(this.mCurrentUploadIndex).getUploadState() == 1) {
                    AliOssClient.getInstance().taskCancle();
                    this.mUploadStateList.get(this.mCurrentUploadIndex).setUploadState(3);
                }
                sendData();
                finish();
            }
        } catch (Exception unused) {
        }
    }

    public void uploadingTip() {
        util.w1.a("文件上传中，请上传完成后操作");
    }
}
