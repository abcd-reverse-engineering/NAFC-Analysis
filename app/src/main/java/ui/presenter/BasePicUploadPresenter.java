package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.UploadFileBean;
import com.hicorenational.antifraud.R;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.BaseUploadView;
import ui.model.OSSModelPresent;
import util.b1;
import util.n1;
import util.w1;

/* loaded from: classes2.dex */
public class BasePicUploadPresenter extends OSSModelPresent<BaseUploadView> {
    private g.a.u0.c mDisposable;

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadFileBean f19796a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19797b;

        a(UploadFileBean uploadFileBean, String str) {
            this.f19796a = uploadFileBean;
            this.f19797b = str;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            w1.a("提交失败~");
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f19796a.setFilePath(ossFileInfo.getFilePath());
                this.f19796a.setFileMd5(ossFileInfo.getFileMd5());
                this.f19796a.setFileSHA1(ossFileInfo.getFileSHA1());
                if (TextUtils.isEmpty(this.f19797b)) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess("", this.f19796a);
                } else {
                    BasePicUploadPresenter.this.uploadTransDetail(this.f19796a, this.f19797b);
                }
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<String>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadFileBean f19799a;

        b(UploadFileBean uploadFileBean) {
            this.f19799a = uploadFileBean;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return String.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onErrorRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<String> aPIresult) throws Resources.NotFoundException {
            n1.a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() == 0) {
                ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onUploadSuccess(aPIresult.getData(), this.f19799a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19801a;

        c(int i2) {
            this.f19801a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(Hicore.getApp().getResources().getString(R.string.err_system));
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult != null) {
                if (aPIresult.getCode() == 0) {
                    ((BaseUploadView) ((OSSModelPresent) BasePicUploadPresenter.this).mvpView).onDeteleSuccess(this.f19801a);
                    return;
                }
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            }
            onErrorMiddle(APIException.getApiExcept());
        }
    }

    public BasePicUploadPresenter(Activity activity, BaseUploadView baseUploadView) {
        super(activity, baseUploadView);
        this.mDisposable = null;
    }

    public void cancleDisposable() {
        g.a.u0.c cVar = this.mDisposable;
        if (cVar == null || cVar.isDisposed()) {
            return;
        }
        this.mDisposable.dispose();
    }

    public void deleteDetail(int i2) {
        ((BaseUploadView) ((OSSModelPresent) this).mvpView).onDeteleSuccess(i2);
    }

    public void uploadDetail(String str, UploadFileBean uploadFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(uploadFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new a(uploadFileBean, str));
    }

    public void uploadTransDetail(UploadFileBean uploadFileBean, String str) {
        uploadTransDetail(str, uploadFileBean);
    }

    public void deleteDetail(String str, String str2, int i2) {
        b1.a(this.mActivity, "请稍等...");
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str2);
        deleteReportCriminalPic(str, map, new c(i2));
    }

    public void uploadTransDetail(String str, UploadFileBean uploadFileBean) {
        uploadCriminalFile2(uploadFileBean, str, new b(uploadFileBean));
    }
}
