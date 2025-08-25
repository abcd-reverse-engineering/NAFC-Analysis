package network.alioss;

import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

/* loaded from: classes2.dex */
public interface OssUploadCallBack {
    void onFailure();

    void onProgress(long j2, long j3);

    void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult);
}
