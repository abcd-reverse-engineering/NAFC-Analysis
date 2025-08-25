package ui.presenter;

import bean.SurveyPeopleBean;
import interfaces.IClickListener;
import ui.presenter.ReportCaseInfoPresenter;

/* compiled from: ReportCaseInfoPresenter.java */
/* loaded from: classes2.dex */
class f0 implements IClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20221a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ReportCaseInfoPresenter.HolderAdapte f20222b;

    f0(ReportCaseInfoPresenter.HolderAdapte holderAdapte, int i2) {
        this.f20222b = holderAdapte;
        this.f20221a = i2;
    }

    @Override // interfaces.IClickListener
    public void cancelBtn() {
        SurveyPeopleBean surveyPeopleBean = (SurveyPeopleBean) ReportCaseInfoPresenter.this.surveyPeopleBeans.get(this.f20221a);
        if (surveyPeopleBean != null) {
            ReportCaseInfoPresenter.this.deletePeople(surveyPeopleBean.getVictimInfoID());
        }
    }

    @Override // interfaces.IClickListener
    public void clickOKBtn() {
    }
}
