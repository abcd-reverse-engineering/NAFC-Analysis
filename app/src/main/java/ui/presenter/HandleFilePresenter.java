package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import interfaces.IOssPicCallback;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class HandleFilePresenter extends OSSModelPresent {

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f19915a;

        a(d dVar) {
            this.f19915a = dVar;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            this.f19915a.onfail();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f19915a.onSuccess(ossFileInfo);
        }
    }

    class b extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f19917a;

        b(c cVar) {
            this.f19917a = cVar;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e("删除失败，请重试");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            this.f19917a.onSuccRequest(aPIresult);
        }

        @Override // network.MiddleSubscriber
        protected void onStartMiddle(g.a.u0.c cVar) {
        }
    }

    public interface c {
        void onSuccRequest(APIresult aPIresult);
    }

    public interface d {
        void onSuccess(OssFileInfo ossFileInfo);

        void onfail();
    }

    public HandleFilePresenter(Activity activity) {
        super(activity, null);
    }

    public void cancelUpdateHttp(HashMap<String, String> map, c cVar) {
        cancelUpdateHttp(map, d.a.a(ModuelConfig.MODEL_REPORT, 5, e.b.c0), new b(cVar));
    }

    public void ossUpload(String str, d dVar) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("1");
        ossFileRequest.setFilePath(str);
        upFileToOss(ossFileRequest, new a(dVar));
    }
}
