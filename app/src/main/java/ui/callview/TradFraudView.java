package ui.callview;

import bean.SocialTypeBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface TradFraudView extends BaseView {
    void onErrorRequest();

    void onSuccessRequest(List<SocialTypeBean> list);
}
