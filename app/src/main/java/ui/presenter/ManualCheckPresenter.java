package ui.presenter;

import android.app.Activity;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.ManualCheckView;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class ManualCheckPresenter extends OSSModelPresent<ManualCheckView> {
    private boolean isIDCard;
    private OssFileInfo mBackImgInfo;
    private OssFileInfo mFrontImgInfo;
    private String phoneNum;
    private String strIDNumber;
    private String strName;

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OssFileInfo f19959a;

        a(OssFileInfo ossFileInfo) {
            this.f19959a = ossFileInfo;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            w1.a(ManualCheckPresenter.this.mActivity.getString(R.string.err_system));
            ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f19959a.setAlreadyUpload(true);
                this.f19959a.setFileSHA1(ossFileInfo.getFileSHA1());
                this.f19959a.setFileMd5(ossFileInfo.getFileMd5());
                this.f19959a.setFilePath(ossFileInfo.getFilePath());
                ManualCheckPresenter.this.uploadFile();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
            w1.a(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult != null && aPIresult.getCode() == 0) {
                ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onSubmitSuccessRequest(aPIresult);
            } else {
                ((ManualCheckView) ((OSSModelPresent) ManualCheckPresenter.this).mvpView).onfail();
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    public ManualCheckPresenter(Activity activity, ManualCheckView manualCheckView, String str, String str2, String str3, boolean z) {
        super(activity, manualCheckView);
        this.mFrontImgInfo = null;
        this.mBackImgInfo = null;
        this.strName = str;
        this.phoneNum = str3;
        this.strIDNumber = str2;
        this.isIDCard = z;
    }

    private void confirmIDAuthHttp(HashMap map) {
        confirmIDAuth(d.a.a(ModuelConfig.MODEL_MANUAL, 8, e.b.D0), map, new b());
    }

    private OssFileInfo getLocalPath() {
        if (!this.mFrontImgInfo.isAlreadyUpload()) {
            return this.mFrontImgInfo;
        }
        if (!this.mBackImgInfo.isAlreadyUpload()) {
            return this.mBackImgInfo;
        }
        confirmIDAuth(this.strName, this.strIDNumber, this.phoneNum, this.mFrontImgInfo, this.mBackImgInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFile() {
        OssFileInfo localPath = getLocalPath();
        if (localPath == null) {
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("3");
        ossFileRequest.setFilePath(localPath.getLocalPath());
        upFileToOss(ossFileRequest, new a(localPath));
    }

    public void clearBack() {
        OssFileInfo ossFileInfo = this.mBackImgInfo;
        if (ossFileInfo != null) {
            ossFileInfo.toClear();
        }
    }

    public void clearFront() {
        OssFileInfo ossFileInfo = this.mFrontImgInfo;
        if (ossFileInfo != null) {
            ossFileInfo.toClear();
        }
    }

    public void confirmIDAuth(String str, String str2, String str3, OssFileInfo ossFileInfo, OssFileInfo ossFileInfo2) {
        HashMap map = new HashMap();
        map.put(CommonNetImpl.NAME, str);
        map.put("idNumber", str2);
        map.put("telnumber", str3);
        map.put("frontImgInfo", ossFileInfo);
        map.put("backImgInfo", ossFileInfo2);
        if (this.isIDCard) {
            map.put("documentType", "1");
        } else {
            map.put("documentType", "2");
        }
        confirmIDAuthHttp(map);
    }

    public void uploadPic(String str, String str2) {
        OssFileInfo ossFileInfo = this.mFrontImgInfo;
        if (ossFileInfo == null) {
            this.mFrontImgInfo = new OssFileInfo(str);
        } else {
            ossFileInfo.setLocalPath(str);
        }
        OssFileInfo ossFileInfo2 = this.mBackImgInfo;
        if (ossFileInfo2 == null) {
            this.mBackImgInfo = new OssFileInfo(str2);
        } else {
            ossFileInfo2.setLocalPath(str2);
        }
        uploadFile();
    }
}
