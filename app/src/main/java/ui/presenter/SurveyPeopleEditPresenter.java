package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import b.a.a.e.h;
import bean.CaseDivisonBean;
import bean.SurveyPeopleBean;
import bean.module.ModuelConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.SurveyPeopEditView;
import ui.model.ModelPresent;
import util.b1;
import util.w1;

/* loaded from: classes2.dex */
public class SurveyPeopleEditPresenter extends ModelPresent<SurveyPeopEditView> {
    private List<CaseDivisonBean> credentTypeBeans;

    class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f20149a;

        a(TextView textView) {
            this.f20149a = textView;
        }

        @Override // b.a.a.e.h.a
        public void b(int i2, String str) {
            this.f20149a.setText(str);
            SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
            ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
        }
    }

    class b extends MiddleSubscriber<APIresult<List<CaseDivisonBean>>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20151a;

        class a extends com.google.gson.d0.a<List<CaseDivisonBean>> {
            a() {
            }
        }

        b(boolean z) {
            this.f20151a = z;
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
        protected void onNextMiddle(APIresult<List<CaseDivisonBean>> aPIresult) {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                return;
            }
            SurveyPeopleEditPresenter.this.credentTypeBeans = aPIresult.getData();
            if (this.f20151a) {
                for (int i2 = 0; i2 < SurveyPeopleEditPresenter.this.credentTypeBeans.size(); i2++) {
                    if (TextUtils.equals("身份证", ((CaseDivisonBean) SurveyPeopleEditPresenter.this.credentTypeBeans.get(i2)).getName())) {
                        SurveyPeopleEditPresenter surveyPeopleEditPresenter = SurveyPeopleEditPresenter.this;
                        ((SurveyPeopEditView) surveyPeopleEditPresenter.mvpView).onSuccessDocum((CaseDivisonBean) surveyPeopleEditPresenter.credentTypeBeans.get(i2));
                    }
                }
            }
        }
    }

    class c extends MiddleSubscriber<APIresult> {
        c() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult != null && aPIresult.getCode() == 0) {
                ((SurveyPeopEditView) SurveyPeopleEditPresenter.this.mvpView).onSuccessHandle(2);
            } else {
                w1.a(aPIresult.getMsg());
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public SurveyPeopleEditPresenter(Activity activity, SurveyPeopEditView surveyPeopEditView) {
        super(activity, surveyPeopEditView);
        this.credentTypeBeans = new ArrayList();
    }

    private void editPersonInfoHttp(HashMap<String, String> map) {
        surveyAddCasePerson(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.c1), map, new c());
    }

    public void editPersonInfo(SurveyPeopleBean surveyPeopleBean) {
        b1.a("请稍后...", true, this.mActivity);
        HashMap<String, String> map = new HashMap<>();
        map.put("victimInfoID", surveyPeopleBean.getVictimInfoID());
        map.put(CommonNetImpl.NAME, surveyPeopleBean.getPeopleName());
        map.put("mobileNumber", surveyPeopleBean.getPeoplePhone());
        map.put("documentType", TextUtils.isEmpty(surveyPeopleBean.getDocumentType()) ? "0" : surveyPeopleBean.getDocumentType());
        map.put("documentTypeText", surveyPeopleBean.getDocumentName());
        map.put("documentNumber", surveyPeopleBean.getDocumentNumber());
        map.put("caseInfoID", surveyPeopleBean.getCaseInfoID());
        editPersonInfoHttp(map);
    }

    public void httpCredentType(boolean z) {
        surveyCredentType(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.f1), new b(z));
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.credentTypeBeans.size(); i2++) {
            arrayList.add(this.credentTypeBeans.get(i2).getName());
        }
        if (arrayList.size() == 0) {
            return;
        }
        b.a.a.e.h hVar = new b.a.a.e.h(this.mActivity, arrayList);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new a(textView));
        hVar.m();
    }
}
