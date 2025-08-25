package network.alioss;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bean.OssTokenBean;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import ui.Hicore;
import util.n1;

/* loaded from: classes2.dex */
public class AliOssClient {
    static AliOssClient instance = null;
    static String mEndpoint = "oss-cn-shanghai.aliyuncs.com";
    String AccessKeyID = "STS.41Xx6Vtqoj1q1dR8WARxDtaZih";
    String SecretKeyId = "BpYfGTq6uwK2MZWFBApG7rYwLeC7LupU9eNA1NmMXeuT";
    String StsToken = "CAIS7wF1q6Ft5B6yfSjI1fLtM4zima5O3fOaM0Lj3FcUXvdom6Txi3bGAXtOeHNvBuEdt/4xm21S7PcajoMcTIReAFTZcZPffymvJkTzDbDasumZsJYm6vT8a0XxZjf/2MjNGZabKPrWZvaqbX3diyZ32sGUXD6+XlujQ/br4NwdGbZxZASjaidcD9p7PxZrrNRgVUHcLvGwKBXn8AGyZQhKwlMm1jIgtPzvmJDEs0GG1QPAp7VL99irEP+NdNJxOZpzadCx0dFte7DJuCwqsEIWrvgp3fcdo2mY44vHUgEL+XWcOu/O9dliPB+J0A34oDuOxhqAASKHFdAswMiV6plFNklr2JiI8KcLne1aVQrV01CUIi8NvdMd54IQOk3TO/g1PChM/oMEX8DOWNUV7PoXynRcg4a2+5GMMfPQpS4dtSDb5lB6Y1l1DkJJI3NWND9FrgfE/mvbBLLnydTUCvWH02J/sV95FDa5ozSsxRFeZEsekjzp";
    Handler myTime = new Handler() { // from class: network.alioss.AliOssClient.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            AliOssClient.this.ossCallBack.onFailure();
            AliOssClient.this.task.cancel();
        }
    };
    private OSS oss;
    private OssUploadCallBack ossCallBack;
    private OSSAsyncTask task;

    private void OSClientConfiguration() {
    }

    public static AliOssClient getInstance() {
        if (instance == null) {
            synchronized (AliOssClient.class) {
                if (instance == null) {
                    instance = new AliOssClient();
                }
            }
        }
        return instance;
    }

    public void initClient(String str, String str2, String str3, String str4) {
        OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(str2, str3, str4);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            arrayList.add(mEndpoint);
        } else {
            arrayList.add(str);
        }
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(5000);
        clientConfiguration.setSocketTimeout(5000);
        clientConfiguration.setMaxConcurrentRequest(15);
        clientConfiguration.setMaxErrorRetry(2);
        clientConfiguration.setCustomCnameExcludeList(arrayList);
        if (TextUtils.isEmpty(str)) {
            this.oss = new OSSClient(Hicore.getApp(), mEndpoint, oSSStsTokenCredentialProvider, clientConfiguration);
        } else {
            this.oss = new OSSClient(Hicore.getApp(), str, oSSStsTokenCredentialProvider, clientConfiguration);
        }
    }

    public boolean isFileExist(String str, String str2) {
        return this.oss.doesObjectExist(str, str2);
    }

    public void taskCancle() {
        OSSAsyncTask oSSAsyncTask = this.task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.cancel();
        }
    }

    public void upLoadFile(String str, String str2, String str3, final OssTokenBean.CallBackBean callBackBean, final OssUploadCallBack ossUploadCallBack) {
        this.ossCallBack = ossUploadCallBack;
        PutObjectRequest putObjectRequest = new PutObjectRequest(str, str2, str3);
        if (callBackBean != null) {
            putObjectRequest.setCallbackParam(new HashMap<String, String>() { // from class: network.alioss.AliOssClient.2
                {
                    put("callbackUrl", callBackBean.getCallBackUrl());
                    put("callbackBody", callBackBean.getCallbackBody());
                }
            });
        }
        putObjectRequest.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() { // from class: network.alioss.AliOssClient.3
            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public void onProgress(PutObjectRequest putObjectRequest2, long j2, long j3) {
                String str4 = "currentSize: " + j2 + " totalSize: " + j3;
                ossUploadCallBack.onProgress(j2, j3);
                if (j2 == j3) {
                    AliOssClient.this.myTime.sendEmptyMessageDelayed(-1000, 3000L);
                }
            }
        });
        this.task = this.oss.asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() { // from class: network.alioss.AliOssClient.4
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(PutObjectRequest putObjectRequest2, ClientException clientException, ServiceException serviceException) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                AliOssClient.this.task.cancel();
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    n1.b("ErrorCode", serviceException.getErrorCode());
                    n1.b("RequestId", serviceException.getRequestId());
                    n1.b("HostId", serviceException.getHostId());
                    n1.b("RawMessage", serviceException.getRawMessage());
                }
                ossUploadCallBack.onFailure();
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(PutObjectRequest putObjectRequest2, PutObjectResult putObjectResult) {
                AliOssClient.this.myTime.removeCallbacksAndMessages(null);
                n1.a("PutObject", "UploadSuccess");
                n1.a(HttpHeaders.ETAG, putObjectResult.getETag());
                n1.a("RequestId", putObjectResult.getRequestId());
                n1.b("StatusCode", putObjectResult.getStatusCode() + "");
                if (putObjectResult.getStatusCode() == 200) {
                    ossUploadCallBack.onSuccess(putObjectRequest2, putObjectResult);
                } else {
                    ossUploadCallBack.onFailure();
                }
            }
        });
    }

    public void waitUntilFinished() throws ExecutionException, InterruptedException {
        OSSAsyncTask oSSAsyncTask = this.task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.waitUntilFinished();
        }
    }
}
