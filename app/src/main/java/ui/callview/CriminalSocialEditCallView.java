package ui.callview;

import bean.CriminalSocialTypeBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalSocialEditCallView extends BaseView {
    void onSuccessType(List<CriminalSocialTypeBean> list);

    void onfail();
}
