package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.SurveyAudioCallView;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class SurveyAudioPresenter extends OSSModelPresent<SurveyAudioCallView> {
    private g.a.u0.c mDisposable;

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadFileBean f20146a;

        a(UploadFileBean uploadFileBean) {
            this.f20146a = uploadFileBean;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            w1.a("提交失败~");
            ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f20146a.setFilePath(ossFileInfo.getFilePath());
                this.f20146a.setFileMd5(ossFileInfo.getFileMd5());
                this.f20146a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onSaveSuccess(this.f20146a);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((SurveyAudioCallView) ((OSSModelPresent) SurveyAudioPresenter.this).mvpView).onDeteleSuccess();
                    return;
                } else {
                    if (aPIresult.getCode() == -1) {
                        LoginManager.getInstance().exit();
                        return;
                    }
                    w1.a(aPIresult.getMsg());
                }
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public SurveyAudioPresenter(Activity activity, SurveyAudioCallView surveyAudioCallView) {
        super(activity, surveyAudioCallView);
        this.mDisposable = null;
    }

    public void cancleDisposable() {
        g.a.u0.c cVar = this.mDisposable;
        if (cVar == null || cVar.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
    }

    public void deleteDetail(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", str);
        getOperation(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.u1), map, new b());
    }

    public void uploadDetail(UploadFileBean uploadFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(uploadFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new a(uploadFileBean));
    }
}
