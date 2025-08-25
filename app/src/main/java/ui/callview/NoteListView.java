package ui.callview;

import bean.NoteListBean;
import h.y;
import i.c.a.d;
import java.util.List;
import ui.basemvp.BaseView;

/* compiled from: NoteListView.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lui/callview/NoteListView;", "Lui/basemvp/BaseView;", "onSuccessRequest", "", "beans", "", "Lbean/NoteListBean;", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface NoteListView extends BaseView {
    void onSuccessRequest(@d List<? extends NoteListBean> list);
}
