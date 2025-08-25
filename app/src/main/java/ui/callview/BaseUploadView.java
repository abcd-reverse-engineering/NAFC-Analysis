package ui.callview;

import bean.UploadFileBean;
import ui.basemvp.BaseView;

/* loaded from: classes2.dex */
public interface BaseUploadView extends BaseView {
    void onDeteleSuccess(int i2);

    void onErrorRequest();

    void onSaveSuccess();

    void onStartRequest();

    void onUploadSuccess(String str, UploadFileBean uploadFileBean);
}
