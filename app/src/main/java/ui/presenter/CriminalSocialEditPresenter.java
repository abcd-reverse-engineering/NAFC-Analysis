package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.CriminalSocialBean;
import bean.CriminalSocialFileBean;
import bean.CriminalSocialTypeBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.module.ModuelConfig;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSocialEditCallView;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalSocialEditPresenter extends OSSModelPresent<CriminalSocialEditCallView> {

    class a extends MiddleSubscriber<APIresult<List<CriminalSocialTypeBean>>> {

        /* renamed from: ui.presenter.CriminalSocialEditPresenter$a$a, reason: collision with other inner class name */
        class C0296a extends com.google.gson.d0.a<List<CriminalSocialTypeBean>> {
            C0296a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0296a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<CriminalSocialTypeBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onSuccessType(aPIresult.getData());
            }
        }
    }

    class b implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19854a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CriminalSocialBean f19855b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f19856c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f19857d;

        b(List list, CriminalSocialBean criminalSocialBean, OssFileRequest ossFileRequest, List list2) {
            this.f19854a = list;
            this.f19855b = criminalSocialBean;
            this.f19856c = ossFileRequest;
            this.f19857d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
            w1.a("网络异常,提交失败~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f19854a.add(ossFileInfo);
            if (this.f19855b.getNetAccountDetails() == null) {
                this.f19855b.setNetAccountDetails(new ArrayList());
            }
            this.f19855b.getNetAccountDetails().add(new CriminalSocialFileBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.f19854a.size() == this.f19856c.getFilePaths().size()) {
                CriminalSocialEditPresenter.this.confirmHttp(this.f19855b);
            } else {
                this.f19856c.setFilePath((String) this.f19857d.get(this.f19854a.size()));
                CriminalSocialEditPresenter.this.upFileToOss(this.f19856c, this);
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((CriminalSocialEditCallView) ((OSSModelPresent) CriminalSocialEditPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                w1.a("添加成功");
                CriminalSocialEditPresenter.this.mActivity.finish();
            }
        }
    }

    public CriminalSocialEditPresenter(Activity activity, CriminalSocialEditCallView criminalSocialEditCallView) {
        super(activity, criminalSocialEditCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmHttp(CriminalSocialBean criminalSocialBean) {
        saveSocial(criminalSocialBean, d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.W1), new c());
    }

    public void confirm(CriminalSocialBean criminalSocialBean, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmHttp(criminalSocialBean);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.isEmpty(list.get(i2).getOriginalPath())) {
                arrayList.add(list.get(i2).getPath());
            }
        }
        if (arrayList.size() <= 0) {
            confirmHttp(criminalSocialBean);
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePaths(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ossFileRequest.setFilePath(arrayList.get(arrayList2.size()));
        upFileToOss(ossFileRequest, new b(arrayList2, criminalSocialBean, ossFileRequest, arrayList));
    }

    public void typeHttp() {
        brandList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.X1), new a());
    }
}
