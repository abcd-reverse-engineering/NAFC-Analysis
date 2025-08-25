package ui.callview;

import java.util.Map;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface WebFullCallView extends BaseView {
    void eventH5Action(String str, Map<String, Object> map);

    void onSurveyBeanRequest(String str, String str2, boolean z);
}
