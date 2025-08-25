package ui.callview;

import bean.AccountListBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface AccountListCallView extends BaseView {
    void onDeleteSuccess(AccountListBean accountListBean);

    void onSuccess(List<AccountListBean> list);
}
