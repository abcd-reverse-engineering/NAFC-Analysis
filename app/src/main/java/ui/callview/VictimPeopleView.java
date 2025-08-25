package ui.callview;

import bean.SignComitBean;
import bean.SurveyPeopleBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface VictimPeopleView extends BaseView {
    void onSuccessCaseNum(SignComitBean signComitBean);

    void onSuccessDelet();

    void onSuccessHandle(List<SurveyPeopleBean> list);
}
