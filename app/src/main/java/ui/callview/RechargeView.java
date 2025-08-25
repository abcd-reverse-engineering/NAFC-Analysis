package ui.callview;

import bean.RechargeBean;
import bean.RechargePlatBean;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.List;
import ui.basemvp.BaseView;

/* compiled from: RechargeView.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, d2 = {"Lui/callview/RechargeView;", "Lui/basemvp/BaseView;", "onItemDelet", "", "itemPos", "", "onItemEdit", "onSuccessList", "list", "", "Lbean/RechargeBean;", "onSuccessPlatList", "Lbean/RechargePlatBean;", "onSuccessSave", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface RechargeView extends BaseView {

    /* compiled from: RechargeView.kt */
    public static final class a {
        public static void a(RechargeView rechargeView) {
        }

        public static void a(RechargeView rechargeView, int i2) {
        }

        public static void a(RechargeView rechargeView, @d List<? extends RechargeBean> list) {
            i0.f(list, "list");
        }

        public static void b(RechargeView rechargeView, int i2) {
        }

        public static void b(RechargeView rechargeView, @d List<? extends RechargePlatBean> list) {
            i0.f(list, "list");
        }
    }

    void onItemDelet(int i2);

    void onItemEdit(int i2);

    void onSuccessList(@d List<? extends RechargeBean> list);

    void onSuccessPlatList(@d List<? extends RechargePlatBean> list);

    void onSuccessSave();
}
