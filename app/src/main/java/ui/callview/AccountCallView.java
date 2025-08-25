package ui.callview;

import bean.CaseDivisonBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface AccountCallView extends BaseView {
    void onSuccessAccountType(List<CaseDivisonBean> list);

    void onSuccessSave(String str);
}
