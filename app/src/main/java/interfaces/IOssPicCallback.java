package interfaces;

import bean.OssFileInfo;

/* loaded from: classes2.dex */
public interface IOssPicCallback {
    void onFail(String str);

    void onSuccess(OssFileInfo ossFileInfo);
}
