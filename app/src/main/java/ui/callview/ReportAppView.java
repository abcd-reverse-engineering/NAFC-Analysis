package ui.callview;

import bean.SurveyAppBean;
import java.util.List;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface ReportAppView extends BaseView {
    public static final int APPUPLOAD = 12;
    public static final int CASEADD = 2;
    public static final int CASEUPDATE = 3;
    public static final int LOGOUPLOAD = 10;
    public static final int QRCODEUPLOAD = 11;

    void onFailRequest();

    void onItemDelet(int i2);

    void onSuccessHandle(int i2, List<SurveyAppBean> list);
}
