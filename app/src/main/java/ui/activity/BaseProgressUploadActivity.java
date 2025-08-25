package ui.activity;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ui.Hicore;

/* loaded from: classes2.dex */
public abstract class BaseProgressUploadActivity extends BaseActivity {
    public static final int DATA_TYPE_1 = 1;
    public static final int DATA_TYPE_2 = 2;
    public static final int REQUESTION_CODE_RECORD = 2000;
    public static final int REQUESTION_CODE_RECORD_AUDIO_1 = 2001;
    public static final int REQUESTION_CODE_RECORD_AUDIO_2 = 2002;
    public static final String UPLOAD_FINISH_TXT = "确定";
    public static final int UPLOAD_STATE_FAIL = 3;
    public static final int UPLOAD_STATE_LOADING = 0;
    public static final int UPLOAD_STATE_SUCCESS = 2;
    public static final int UPLOAD_STATE_UPLOAD = 1;
    private boolean isDataType2 = false;
    public List<UploadFileBean> mUploadList = new ArrayList();
    public List<UploadFileBean> mFirstUploadList = new ArrayList();
    public List<UploadFileBean> mSecondUploadList = new ArrayList();
    public List<UploadStateInfo> mStateList = new ArrayList();
    public List<UploadStateInfo> mFirstStateList = new ArrayList();
    public List<UploadStateInfo> mSecondStateList = new ArrayList();
    public int mCurrentUploadIndex = -1;
    private boolean isUploadOne = false;

    class a implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17703a;

        a(int i2) {
            this.f17703a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            try {
                if (BaseProgressUploadActivity.this.mStateList.get(this.f17703a).getUploadState() == 1) {
                    try {
                        BaseProgressUploadActivity.this.cancleDisposable();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                BaseProgressUploadActivity.this.deteleUpload(this.f17703a);
                BaseProgressUploadActivity.this.clearItem(this.f17703a);
                BaseProgressUploadActivity.this.UploadNextFile();
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
            BaseProgressUploadActivity.this.stopUpload();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UploadNextFile() {
        List<UploadStateInfo> list;
        if (this.isUploadOne) {
            this.isUploadOne = false;
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("确定", true);
            return;
        }
        if (!util.q1.f()) {
            util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
            return;
        }
        nextUploadIndex();
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1 && (list = this.mStateList) != null && i2 < list.size()) {
            doUpload();
            return;
        }
        if (isAllSuccess()) {
            finishFile();
            changeBtnCommit("确定", true);
        } else {
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("上传文件", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearItem(int i2) {
        boolean z;
        removeLocalData(i2);
        this.mStateList.remove(i2);
        this.mUploadList.remove(i2);
        notifyAdapter();
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void deteleUpload(int i2) {
        String id = this.mUploadList.get(i2).getId();
        if (id == null) {
            return;
        }
        deteleUploadHttp(id + "");
    }

    private void doUpload() {
        changeBtnCommit("", false);
        this.mStateList.get(this.mCurrentUploadIndex).setUploadState(1);
        notifyAdapter();
        doUploadHttp();
    }

    private void networkFail2Fail() {
        loadingToFail();
        notifyAdapter();
        changeBtnCommit("", false);
    }

    private void nextUploadFailIndex() {
        for (int i2 = 0; i2 < this.mStateList.size(); i2++) {
            if (this.mStateList.get(i2).getUploadState() == 3 || this.mStateList.get(i2).getUploadState() == 1) {
                this.mStateList.get(i2).setUploadState(0);
                return;
            }
        }
    }

    private void prepareUp() {
        List<UploadStateInfo> list;
        if (!util.q1.f()) {
            util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
        } else {
            int i2 = this.mCurrentUploadIndex;
            if (i2 <= -1 || (list = this.mStateList) == null || i2 >= list.size()) {
                return;
            }
            doUpload();
        }
    }

    private void resultDeal(boolean z) {
        int i2;
        List<UploadStateInfo> list = this.mStateList;
        if (list != null && (i2 = this.mCurrentUploadIndex) > -1 && i2 < list.size() && this.mCurrentUploadIndex < this.mStateList.size()) {
            if (z) {
                this.mStateList.get(this.mCurrentUploadIndex).setUploadState(2);
            } else {
                this.mStateList.get(this.mCurrentUploadIndex).setUploadState(3);
            }
            notifyAdapter();
        }
        UploadNextFile();
    }

    public void UploadOneFile(int i2) {
        List<UploadStateInfo> list;
        if (!util.q1.f()) {
            util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail();
            return;
        }
        this.isUploadOne = true;
        this.mCurrentUploadIndex = i2;
        int i3 = this.mCurrentUploadIndex;
        if (i3 > -1 && (list = this.mStateList) != null && i3 < list.size()) {
            doUpload();
            return;
        }
        if (isAllSuccess()) {
            finishFile();
            changeBtnCommit("确定", true);
        } else {
            if (isHasFail()) {
                return;
            }
            changeBtnCommit("上传文件", true);
        }
    }

    public void backDialog() {
        util.b1.a(this.mActivity, "有未上传成功的文件，确定返回？", "", "是", "否", R.color._353536, -1, (IClickListener) new b());
    }

    public boolean backPressedUpload() {
        if (rejuctOperation(true)) {
            return true;
        }
        creatAllData();
        finishFile();
        return false;
    }

    public void cancleDisposable() {
    }

    public void changeBtnCommit(String str, boolean z) {
    }

    public void commitDeal() {
        creatAllData();
        if (!util.q1.f()) {
            util.w1.a(Hicore.getApp().getResources().getString(R.string.err_timeout));
            networkFail2Fail();
            networkFail();
        } else {
            if (isAllSuccess()) {
                finishFile();
                return;
            }
            if (isHasFail()) {
                failToLoading();
            }
            nextUploadIndex();
            if (this.mCurrentUploadIndex > -1) {
                prepareUp();
            } else {
                finishFile();
            }
        }
    }

    public void creatAllData() {
        if (this.isDataType2) {
            this.mUploadList.clear();
            this.mUploadList.addAll(this.mFirstUploadList);
            this.mUploadList.addAll(this.mSecondUploadList);
            this.mStateList.clear();
            this.mStateList.addAll(this.mFirstStateList);
            this.mStateList.addAll(this.mSecondStateList);
        }
    }

    public void deleteDialog(int i2) {
        if (i2 >= this.mStateList.size()) {
            return;
        }
        int uploadState = this.mStateList.get(i2).getUploadState();
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
                    deteleUpload(i2);
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

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia, List<UploadFileBean> list3, List<UploadStateInfo> list4) {
        if (list == null || list3 == null || list4 == null) {
            util.w1.a("聊录去重，请先初始化数据");
            return;
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
                UploadFileBean uploadFileBean = new UploadFileBean();
                uploadFileBean.setLocalPath(localMedia3.getPath());
                uploadFileBean.setFileName(localMedia3.getFileName());
                uploadFileBean.setFileSize(localMedia3.getSize());
                list3.add(i2, uploadFileBean);
                list4.add(i2, new UploadStateInfo(localMedia3.getSize()));
            }
        }
    }

    public void deteleUploadHttp(String str) {
    }

    public void doUploadHttp() {
    }

    public void failToLoading() {
        for (UploadStateInfo uploadStateInfo : this.mStateList) {
            if (uploadStateInfo.getUploadState() == 3) {
                uploadStateInfo.setUploadState(0);
            }
        }
    }

    public void finishFile() {
    }

    public int getChildSource() {
        return -1;
    }

    public int getDataType() {
        return 1;
    }

    public List<UploadFileBean> getOldData() {
        return null;
    }

    public List<UploadFileBean> getSecondOldData() {
        return null;
    }

    public boolean isAllSuccess() {
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() != 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasFail() {
        if (this.mStateList.size() == 0) {
            return false;
        }
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasUpload() {
        Iterator<UploadStateInfo> it = this.mStateList.iterator();
        while (it.hasNext()) {
            if (it.next().getUploadState() == 1) {
                return true;
            }
        }
        return false;
    }

    public void loadingToFail() {
        for (UploadStateInfo uploadStateInfo : this.mStateList) {
            if (uploadStateInfo.getUploadState() == 0) {
                uploadStateInfo.setUploadState(3);
            }
        }
    }

    public void networkFail() {
    }

    public void nextUploadIndex() {
        List<UploadStateInfo> list = this.mStateList;
        if (list == null || list.size() <= 0) {
            this.mCurrentUploadIndex = -1;
            util.n1.a("mCurrentUploadIndex-->-1 mUploadStateList");
            return;
        }
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            if (i2 >= this.mStateList.size()) {
                z = true;
                break;
            }
            if (this.mStateList.get(i2).getUploadState() != 2) {
                z2 = false;
            }
            if (this.mStateList.get(i2).getUploadState() == 0) {
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
        if (this.mActivity.isFinishing()) {
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getDataType() != 2) {
            redisplayData(this.mUploadList);
            return;
        }
        this.isDataType2 = true;
        redisplayData(this.mFirstUploadList);
        secondRedisplayData(this.mSecondUploadList);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mCurrentUploadIndex = -1;
        this.mFirstUploadList.clear();
        this.mFirstStateList.clear();
        this.mSecondUploadList.clear();
        this.mSecondStateList.clear();
        this.mUploadList.clear();
        this.mStateList.clear();
        this.mUploadList.clear();
        this.mStateList.clear();
    }

    public void redisplayData(List<UploadFileBean> list) {
    }

    public boolean rejuctOperation(boolean z) {
        boolean zIsHasUpload;
        if (z) {
            zIsHasUpload = !isAllSuccess();
            if (zIsHasUpload) {
                backDialog();
            }
        } else {
            zIsHasUpload = isHasUpload();
            if (zIsHasUpload) {
                uploadingTip();
            }
        }
        return zIsHasUpload;
    }

    public void removeLocalData(int i2) {
    }

    public void resultFail() {
        resultDeal(false);
    }

    public void resultSuccess() {
        resultDeal(true);
    }

    public void secondRedisplayData(List<UploadFileBean> list) {
    }

    public void startRequest() {
        int i2 = this.mCurrentUploadIndex;
        if (i2 > -1) {
            this.mStateList.get(i2).setUploadState(1);
            changeBtnCommit("", false);
            notifyAdapter();
        }
    }

    public void stopUpload() {
        finishFile();
        if (this.mCurrentUploadIndex > -1) {
            finish();
        }
    }

    public void uploadingTip() {
        util.w1.a("文件上传中，请上传完成后操作");
    }
}
