package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.FeedbackInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.FeedbackCallView;
import ui.model.OSSModelPresent;
import util.n1;
import util.w1;

/* loaded from: classes2.dex */
public class FeedbackPresenter extends OSSModelPresent<FeedbackCallView> {
    List<OssFileInfo> ossFiles;

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19904a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f19905b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedbackInfo f19906c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f19907d;

        a(List list, OssFileRequest ossFileRequest, FeedbackInfo feedbackInfo, List list2) {
            this.f19904a = list;
            this.f19905b = ossFileRequest;
            this.f19906c = feedbackInfo;
            this.f19907d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
            n1.b("ossFiles-------->" + FeedbackPresenter.this.ossFiles.size());
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f19904a.add(ossFileInfo);
            if (this.f19904a.size() == this.f19905b.getFilePaths().size()) {
                this.f19906c.setFileInfos(this.f19904a);
                FeedbackPresenter.this.confirmFeedbackHttp(this.f19906c);
            } else {
                this.f19905b.setFilePath((String) this.f19907d.get(this.f19904a.size()));
                FeedbackPresenter.this.upFileToOss(this.f19905b, this);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((FeedbackCallView) ((OSSModelPresent) FeedbackPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            n1.a("Feedback", "-->onNext");
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                w1.a("提交成功");
                FeedbackPresenter.this.mActivity.finish();
            }
        }
    }

    public FeedbackPresenter(Activity activity, FeedbackCallView feedbackCallView) {
        super(activity, feedbackCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmFeedbackHttp(FeedbackInfo feedbackInfo) {
        uploadReportParam(feedbackInfo, d.a.a(ModuelConfig.MODEL_FEEDBACK, 9, e.b.L0), new b());
    }

    private List<String> hasUpFile(List<OssFileInfo> list, List<LocalMedia> list2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            arrayList.add(list2.get(i2).getPath());
        }
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                LocalMedia localMedia = list2.get(i3);
                for (int i4 = 0; i4 < list.size(); i4++) {
                    if (TextUtils.equals(localMedia.getPath(), list.get(i4).getLocalPath())) {
                        arrayList.remove(localMedia.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    public void confirmFeedback(FeedbackInfo feedbackInfo, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmFeedbackHttp(feedbackInfo);
            return;
        }
        List<String> listHasUpFile = hasUpFile(this.ossFiles, list);
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("2");
        ossFileRequest.setFilePaths(listHasUpFile);
        ArrayList arrayList = new ArrayList();
        ossFileRequest.setFilePath(listHasUpFile.get(arrayList.size()));
        upFileToOss(ossFileRequest, new a(arrayList, ossFileRequest, feedbackInfo, listHasUpFile));
    }

    public void uploadReportParam(FeedbackInfo feedbackInfo, String str, MiddleSubscriber<APIresult> middleSubscriber) {
        feedBack2(feedbackInfo, str, middleSubscriber);
    }
}
