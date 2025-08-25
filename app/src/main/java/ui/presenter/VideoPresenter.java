package ui.presenter;

import android.app.Activity;
import bean.ReportResultBean;
import network.IRequest;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import ui.activity.VideoActivity;
import ui.basemvp.BasePresenter;
import ui.model.AudioModel;

/* loaded from: classes2.dex */
public class VideoPresenter extends BasePresenter<VideoActivity, AudioModel> {

    class a implements IRequest<APIresult<ReportResultBean>> {
        a() {
        }

        @Override // network.IRequest
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onNextRequest(aPIresult);
        }

        @Override // network.IRequest
        public void onErrorMiddle() {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onErrorRequest();
        }

        @Override // network.IRequest
        public void onStartMiddle() {
            ((VideoActivity) ((BasePresenter) VideoPresenter.this).mView).onStartRequest();
        }
    }

    public VideoPresenter(Activity activity) {
        attachModel(new AudioModel(activity));
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo) {
        ((AudioModel) this.mModel).doAudioUpload(reportAppInfo, reportCaseInfo, new a());
    }
}
