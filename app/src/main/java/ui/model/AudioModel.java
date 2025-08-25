package ui.model;

import android.app.Activity;
import android.text.TextUtils;
import bean.ReportResultBean;
import bean.module.ModuelConfig;
import g.a.u0.c;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.IRequest;
import network.MiddleSubscriber;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import network.request.ReportFileInfo;
import ui.basemvp.BaseView;
import util.o1;
import util.v1;

/* loaded from: classes2.dex */
public class AudioModel extends ModelPresent {

    class a extends MiddleSubscriber<APIresult<ReportResultBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRequest f19743a;

        a(IRequest iRequest) {
            this.f19743a = iRequest;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return ReportResultBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            this.f19743a.onErrorMiddle();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<ReportResultBean> aPIresult) {
            this.f19743a.onNextMiddle(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(c cVar) {
            this.f19743a.onStartMiddle();
        }
    }

    public AudioModel(Activity activity) {
        super(activity, (BaseView) null);
    }

    private void confirmHttp(HashMap<String, Object> map, IRequest<APIresult<ReportResultBean>> iRequest) {
        reportUploadFile(map, d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.a0), new a(iRequest));
    }

    private void uploadParam(ReportFileInfo reportFileInfo, IRequest<APIresult<ReportResultBean>> iRequest) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", TextUtils.isEmpty(reportFileInfo.getCaseinfo().getId()) ? "" : reportFileInfo.getCaseinfo().getId());
        map.put("appReportDetail", reportFileInfo.getAppReportDetail());
        map.put("reportDetail", reportFileInfo.getReportDetail());
        confirmHttp(map, iRequest);
    }

    public void doAudioUpload(ReportAppInfo reportAppInfo, ReportCaseInfo reportCaseInfo, IRequest<APIresult<ReportResultBean>> iRequest) {
        File file = new File(reportAppInfo.getFileLocalPath());
        if (TextUtils.isEmpty(reportAppInfo.getFileMd5())) {
            reportAppInfo.setFileMd5(o1.a(file));
        }
        if (TextUtils.isEmpty(reportAppInfo.getOccurTime())) {
            reportAppInfo.setOccurTime(v1.a(file.lastModified()) + "");
        }
        int source = reportAppInfo.getSource();
        ReportFileInfo reportFileInfo = new ReportFileInfo();
        reportFileInfo.setCaseinfo(reportCaseInfo);
        if (source == 1) {
            reportFileInfo.setAppReportDetail(reportAppInfo);
        } else if (source == 2 || source == 3 || source == 5) {
            reportFileInfo.setReportDetail(reportAppInfo);
        }
        uploadParam(reportFileInfo, iRequest);
    }
}
