package ui.callview;

import bean.CallBean;
import bean.CriminalPhoneNumBean;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.List;
import ui.basemvp.BaseView;

/* compiled from: CriminalPhoneView.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lui/callview/CriminalPhoneView;", "Lui/basemvp/BaseView;", "onSuccess", "", "CNATelList", "", "", "onSuccessList", "callBeans", "Lbean/CallBean;", "onSuccessPhoneNum", "bean", "Lbean/CriminalPhoneNumBean;", "onSuccessRemove", "onSuccessSave", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface CriminalPhoneView extends BaseView {

    /* compiled from: CriminalPhoneView.kt */
    public static final class a {
        public static void a(CriminalPhoneView criminalPhoneView) {
        }

        public static void a(CriminalPhoneView criminalPhoneView, @d CallBean callBean) {
            i0.f(callBean, "callBeans");
        }

        public static void a(CriminalPhoneView criminalPhoneView, @d CriminalPhoneNumBean criminalPhoneNumBean) {
            i0.f(criminalPhoneNumBean, "bean");
        }

        public static void a(CriminalPhoneView criminalPhoneView, @d List<String> list) {
            i0.f(list, "CNATelList");
        }

        public static void b(CriminalPhoneView criminalPhoneView, @d List<? extends CallBean> list) {
            i0.f(list, "callBeans");
        }
    }

    void onSuccess(@d List<String> list);

    void onSuccessList(@d List<? extends CallBean> list);

    void onSuccessPhoneNum(@d CriminalPhoneNumBean criminalPhoneNumBean);

    void onSuccessRemove();

    void onSuccessSave(@d CallBean callBean);
}
