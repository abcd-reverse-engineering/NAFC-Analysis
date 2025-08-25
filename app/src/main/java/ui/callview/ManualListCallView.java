package ui.callview;

import bean.ManualListBean;
import bean.PageBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ManualListCallView extends BaseView {
    void onSuccess(PageBean<ManualListBean> pageBean);
}
