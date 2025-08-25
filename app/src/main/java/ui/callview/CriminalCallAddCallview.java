package ui.callview;

import h.y;
import i.c.a.d;
import java.util.List;
import ui.basemvp.BaseView;

/* compiled from: CriminalCallAddCallview.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lui/callview/CriminalCallAddCallview;", "Lui/basemvp/BaseView;", "onSuccess", "", "callType", "", "CNATelList", "", "onSuccessRemove", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface CriminalCallAddCallview extends BaseView {
    void onSuccess(@d String str);

    void onSuccess(@d List<String> list);

    void onSuccessRemove();
}
