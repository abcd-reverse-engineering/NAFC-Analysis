package ui.presenter;

import android.app.Activity;
import bean.APIH5Bean;
import interfaces.IBaseBeanCall;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.DownloadInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.RegisterBody;
import ui.callview.UpdateAppView;
import ui.model.ModelPresent;
import util.UpdateUtil;
import util.r1;
import util.v1;

/* loaded from: classes2.dex */
public class UpdateAppPresenter extends ModelPresent<UpdateAppView> {

    class a extends MiddleSubscriber<APIresult<DownloadInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IBaseBeanCall f20165a;

        a(IBaseBeanCall iBaseBeanCall) {
            this.f20165a = iBaseBeanCall;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return DownloadInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            IBaseBeanCall iBaseBeanCall = this.f20165a;
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<DownloadInfo> aPIresult) {
            ((UpdateAppView) UpdateAppPresenter.this.mvpView).onSuccRequest(aPIresult, this.f20165a);
            UpdateUtil.isCheckUpdateAlready = true;
        }
    }

    public UpdateAppPresenter(Activity activity, UpdateAppView updateAppView) {
        super(activity, updateAppView);
    }

    private void updateApp(HashMap<String, String> map, IBaseBeanCall iBaseBeanCall) {
        updateApp(map, d.a.f13517c + e.b.f13564b, new a(iBaseBeanCall));
    }

    public void principalHttp(IBaseBeanCall iBaseBeanCall) {
        String strL = v1.l();
        RegisterBody registerBody = new RegisterBody();
        registerBody.setImei(strL);
        registerBody.setInnerversion(r1.f() + "");
        updateApp(JNIHandStamp.getInstance().pamramToMap(registerBody), iBaseBeanCall);
    }

    public void requestAppDownload(MiddleSubscriber<APIresult<APIH5Bean>> middleSubscriber) {
        String str = d.a.f13517c + e.b.f13573k;
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykey", "AndroidDownloadURL");
        requestAppConfig(map, str, middleSubscriber);
    }
}
