package ui.callview;

import h.y;
import i.c.a.d;
import network.account.AccountInfo;
import ui.basemvp.BaseView;

/* compiled from: AddressCallview.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lui/callview/AddressCallview;", "Lui/basemvp/BaseView;", "onSuccessRegister", "", "accountInfo", "Lnetwork/account/AccountInfo;", "registerName", "", "registerCode", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface AddressCallview extends BaseView {
    void onSuccessRegister(@d AccountInfo accountInfo, @d String str, @d String str2);
}
