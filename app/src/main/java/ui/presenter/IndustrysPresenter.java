package ui.presenter;

import android.app.Activity;
import java.util.HashMap;
import manager.AccountManager;
import manager.LoginManager;
import ui.callview.IndustryAddView;
import ui.model.ModelPresent;
import util.b1;

/* loaded from: classes2.dex */
public class IndustrysPresenter extends ModelPresent<IndustryAddView> {
    public IndustrysPresenter(Activity activity, IndustryAddView industryAddView) {
        super(activity, industryAddView);
    }

    private void timeStampHttp(HashMap<String, String> map) {
        updateUserHttp(map);
    }

    private void updateUserHttp(HashMap<String, String> map) {
    }

    public void getIndustry() {
    }

    public void updateUserIndustry(String str) {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        b1.a("提交中...", true, this.mActivity);
        String accountId = AccountManager.getAccountId();
        HashMap<String, String> map = new HashMap<>();
        map.put("id", accountId);
        map.put("profession", str + "");
        timeStampHttp(map);
    }
}
