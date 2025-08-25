package interfaces;

import bean.OssFileInfo;
import java.util.List;

/* loaded from: classes2.dex */
public interface IOssPicListCallback {
    void onFail(String str, List<OssFileInfo> list);

    void onSuccess(List<OssFileInfo> list);
}
