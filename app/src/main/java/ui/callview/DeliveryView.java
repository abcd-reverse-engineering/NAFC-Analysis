package ui.callview;

import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.List;
import ui.basemvp.BaseView;

/* compiled from: DeliveryView.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lui/callview/DeliveryView;", "Lui/basemvp/BaseView;", "onItemDelet", "", "itemPos", "", "onItemEdit", "onSuccessList", "list", "", "Lbean/DeliveryBean;", "onSuccessPlatList", "Lbean/DeliveryPlatBean;", "onSuccessSave", "bean", "onSuccessSaveFail", "msg", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface DeliveryView extends BaseView {

    /* compiled from: DeliveryView.kt */
    public static final class a {
        public static void a(DeliveryView deliveryView, int i2) {
        }

        public static void a(DeliveryView deliveryView, @d DeliveryBean deliveryBean) {
            i0.f(deliveryBean, "bean");
        }

        public static void a(DeliveryView deliveryView, @d String str) {
            i0.f(str, "msg");
        }

        public static void a(DeliveryView deliveryView, @d List<? extends DeliveryBean> list) {
            i0.f(list, "list");
        }

        public static void b(DeliveryView deliveryView, int i2) {
        }

        public static void b(DeliveryView deliveryView, @d List<? extends DeliveryPlatBean> list) {
            i0.f(list, "list");
        }
    }

    void onItemDelet(int i2);

    void onItemEdit(int i2);

    void onSuccessList(@d List<? extends DeliveryBean> list);

    void onSuccessPlatList(@d List<? extends DeliveryPlatBean> list);

    void onSuccessSave(@d DeliveryBean deliveryBean);

    void onSuccessSaveFail(@d String str);
}
