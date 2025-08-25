package ui.callview;

import bean.CriminalBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface CriminalsView extends BaseView {
    void onItemDelet(int i2);

    void onSuccessHandle(int i2, List<CriminalBean> list);
}
