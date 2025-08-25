package ui.callview;

import bean.CheckUserBean;
import bean.UserInfoBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface MinePersonalView extends BaseView {
    void onFailRequest();

    void onSuccRequest(UserInfoBean userInfoBean);

    void onSuccess(CheckUserBean checkUserBean);
}
