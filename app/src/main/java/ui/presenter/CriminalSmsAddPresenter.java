package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import b.a.a.e.i;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.SmsPictureBean;
import bean.module.ModuelConfig;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IOssPicCallback;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.CriminalSmsAddCallView;
import ui.model.OSSModelPresent;
import util.w1;

/* loaded from: classes2.dex */
public class CriminalSmsAddPresenter extends OSSModelPresent<CriminalSmsAddCallView> {

    class a implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f19839a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CriminalSmsBean f19840b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f19841c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f19842d;

        a(List list, CriminalSmsBean criminalSmsBean, OssFileRequest ossFileRequest, List list2) {
            this.f19839a = list;
            this.f19840b = criminalSmsBean;
            this.f19841c = ossFileRequest;
            this.f19842d = list2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
            w1.a("网络异常,提交失败~");
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            this.f19839a.add(ossFileInfo);
            if (this.f19840b.getSmsDetails() == null) {
                this.f19840b.setSmsDetails(new ArrayList());
            }
            this.f19840b.getSmsDetails().add(new SmsPictureBean(ossFileInfo.getLocalPath(), ossFileInfo.getFilePath(), ossFileInfo.getFileMd5(), ossFileInfo.getFileSHA1()));
            if (this.f19839a.size() == this.f19841c.getFilePaths().size()) {
                CriminalSmsAddPresenter.this.confirmHttp(this.f19840b);
            } else {
                this.f19841c.setFilePath((String) this.f19842d.get(this.f19839a.size()));
                CriminalSmsAddPresenter.this.upFileToOss(this.f19841c, this);
            }
        }
    }

    class b extends MiddleSubscriber<APIresult> {
        b() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onfail();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                w1.a("提交成功");
                CriminalSmsAddPresenter.this.mActivity.finish();
            }
        }
    }

    class c extends MiddleSubscriber<APIresult<List<BrandBean>>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b f19845a;

        class a extends com.google.gson.d0.a<List<BrandBean>> {
            a() {
            }
        }

        c(i.b bVar) {
            this.f19845a = bVar;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<BrandBean>> aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((CriminalSmsAddCallView) ((OSSModelPresent) CriminalSmsAddPresenter.this).mvpView).onSuccessBrand(aPIresult.getData(), this.f19845a);
            }
        }
    }

    public CriminalSmsAddPresenter(Activity activity, CriminalSmsAddCallView criminalSmsAddCallView) {
        super(activity, criminalSmsAddCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmHttp(CriminalSmsBean criminalSmsBean) {
        saveSms(criminalSmsBean, d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.Q1), new b());
    }

    public void brandHttp(i.b<BrandBean> bVar) {
        brandList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.S1), new c(bVar));
    }

    public void confirm(CriminalSmsBean criminalSmsBean, List<LocalMedia> list) {
        if (list == null || list.size() == 0) {
            confirmHttp(criminalSmsBean);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.isEmpty(list.get(i2).getOriginalPath())) {
                arrayList.add(list.get(i2).getPath());
            }
        }
        if (arrayList.size() <= 0) {
            confirmHttp(criminalSmsBean);
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePaths(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ossFileRequest.setFilePath(arrayList.get(arrayList2.size()));
        upFileToOss(ossFileRequest, new a(arrayList2, criminalSmsBean, ossFileRequest, arrayList));
    }
}
