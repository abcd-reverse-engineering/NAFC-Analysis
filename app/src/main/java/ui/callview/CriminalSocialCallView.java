package ui.callview;

import bean.CriminalSocialBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalSocialCallView extends BaseView {
    void onSuccess(List<CriminalSocialBean> list);

    void onSuccessDelete(int i2);
}
