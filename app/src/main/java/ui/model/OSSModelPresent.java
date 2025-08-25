package ui.model;

import android.app.Activity;
import android.text.TextUtils;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.OssTokenBean;
import bean.module.ModuelConfig;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import interfaces.IOssPicCallback;
import interfaces.IOssPicListCallback;
import interfaces.IRCallback;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.RetrofitFileHelp;
import network.account.APIresult;
import network.alioss.AliOssClient;
import network.alioss.OssUploadCallBack;
import okhttp3.MultipartBody;
import ui.basemvp.BaseView;
import ui.callview.OssTokenCallView;
import ui.model.OSSModelPresent;
import util.n1;
import util.o1;
import util.y1;

/* loaded from: classes2.dex */
public class OSSModelPresent<V extends BaseView> extends ModelPresent {
    public V mvpView;
    private int upIndex;

    class a extends MiddleSubscriber<APIresult<OssTokenBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OssTokenCallView f19745a;

        a(OssTokenCallView ossTokenCallView) {
            this.f19745a = ossTokenCallView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return OssTokenBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            this.f19745a.onfailRequest();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<OssTokenBean> aPIresult) {
            if (aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            OssTokenBean data = aPIresult.getData();
            if (data == null) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
                return;
            }
            OssTokenBean.Credential stsCredentials = data.getStsCredentials();
            if (stsCredentials != null && data.isExist() == 0) {
                AliOssClient.getInstance().initClient(data.getEndPoint(), stsCredentials.getAccessKeyId(), stsCredentials.getAccessKeySecret(), stsCredentials.getSecurityToken());
            }
            this.f19745a.onSuccRequest(data);
        }
    }

    class b implements OssTokenCallView {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f19747a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOssPicCallback f19748b;

        class a extends MiddleSubscriber<APIresult> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ OssFileInfo f19750a;

            a(OssFileInfo ossFileInfo) {
                this.f19750a = ossFileInfo;
            }

            static /* synthetic */ void a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
                ossFileInfo.setAlreadyUpload(true);
                iOssPicCallback.onSuccess(ossFileInfo);
            }

            @Override // network.MiddleSubscriber
            protected Type getType() {
                return super.getType();
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                b.this.f19748b.onFail(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult aPIresult) {
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept(aPIresult));
                    return;
                }
                b bVar = b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.f19750a;
                final IOssPicCallback iOssPicCallback = bVar.f19748b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.b.a.a(ossFileInfo, iOssPicCallback);
                    }
                });
            }
        }

        /* renamed from: ui.model.OSSModelPresent$b$b, reason: collision with other inner class name */
        class C0291b implements IRCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ OssFileInfo f19752a;

            /* renamed from: ui.model.OSSModelPresent$b$b$a */
            class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f19754a;

                a(String str) {
                    this.f19754a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    n1.b("hsc", "getOssToken onFailure------------");
                    b.this.f19748b.onFail(this.f19754a);
                }
            }

            C0291b(OssFileInfo ossFileInfo) {
                this.f19752a = ossFileInfo;
            }

            static /* synthetic */ void a(OssFileInfo ossFileInfo, IOssPicCallback iOssPicCallback) {
                ossFileInfo.setAlreadyUpload(true);
                iOssPicCallback.onSuccess(ossFileInfo);
            }

            @Override // interfaces.IRCallback
            public void onFail(String str) {
                OSSModelPresent.this.mActivity.runOnUiThread(new a(str));
            }

            @Override // interfaces.IRCallback
            public void onSuccess() {
                b bVar = b.this;
                Activity activity = OSSModelPresent.this.mActivity;
                final OssFileInfo ossFileInfo = this.f19752a;
                final IOssPicCallback iOssPicCallback = bVar.f19748b;
                activity.runOnUiThread(new Runnable() { // from class: ui.model.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        OSSModelPresent.b.C0291b.a(ossFileInfo, iOssPicCallback);
                    }
                });
            }
        }

        b(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
            this.f19747a = ossFileRequest;
            this.f19748b = iOssPicCallback;
        }

        @Override // ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            OssTokenBean.CallBackBean callBack = ossTokenBean.getCallBack();
            if (this.f19747a == null) {
                this.f19748b.onSuccess(null);
                return;
            }
            OssFileInfo ossFileInfo = new OssFileInfo();
            String str = path + "/" + this.f19747a.getFileName();
            ossFileInfo.setFilePath(str);
            ossFileInfo.setFileMd5(this.f19747a.getFileMd5());
            ossFileInfo.setLocalPath(this.f19747a.getFilePath());
            ossFileInfo.setFileName(this.f19747a.getFileName());
            if (!TextUtils.equals(this.f19747a.getType(), "1")) {
                ossFileInfo.setFileSHA1(o1.b(new File(this.f19747a.getFilePath())));
            }
            if (ossTokenBean.isExist() == 1) {
                ossFileInfo.setAlreadyUpload(true);
                ossFileInfo.setFilePath(path);
                this.f19748b.onSuccess(ossFileInfo);
            } else {
                if (ossTokenBean.getStorageType() != 1) {
                    OSSModelPresent.this.conUpLoadFile(bucketName, str, callBack, this.f19747a.getFilePath(), new C0291b(ossFileInfo));
                    return;
                }
                if (TextUtils.isEmpty(ossTokenBean.getPutFileUrl())) {
                    this.f19748b.onFail("本地文件地址为空");
                    return;
                }
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                RetrofitFileHelp.setTextParam(type, "filePath", ossFileInfo.getFilePath());
                if (!TextUtils.isEmpty(this.f19747a.getFilePath())) {
                    RetrofitFileHelp.setFileParamWithProgress(type, this.f19747a.getFileName(), this.f19747a.getFilePath());
                }
                OSSModelPresent.this.uploadFile(ossTokenBean.getPutFileUrl(), type.build(), new a(ossFileInfo));
            }
        }

        @Override // ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f19748b.onFail("Oss-token 获取失败");
        }
    }

    class c implements OssTokenCallView {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OssFileRequest f19756a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IOssPicListCallback f19757b;

        c(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) {
            this.f19756a = ossFileRequest;
            this.f19757b = iOssPicListCallback;
        }

        @Override // ui.callview.OssTokenCallView
        public void onSuccRequest(OssTokenBean ossTokenBean) throws NoSuchAlgorithmException, IOException {
            String bucketName = ossTokenBean.getBucketName();
            String path = ossTokenBean.getPath();
            ArrayList arrayList = new ArrayList();
            List<String> filePaths = this.f19756a.getFilePaths();
            if (filePaths == null || filePaths.size() <= 0) {
                this.f19757b.onSuccess(arrayList);
            } else {
                OSSModelPresent.this.upLoadFile(bucketName, path, OSSModelPresent.this.doUpFileInfo(path, filePaths), filePaths, arrayList, this.f19757b);
            }
        }

        @Override // ui.callview.OssTokenCallView
        public void onfailRequest() {
            this.f19757b.onFail("Oss-token 获取失败", null);
        }
    }

    class d implements OssUploadCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRCallback f19759a;

        d(IRCallback iRCallback) {
            this.f19759a = iRCallback;
        }

        @Override // network.alioss.OssUploadCallBack
        public void onFailure() {
            this.f19759a.onFail("文件上传失败!");
        }

        @Override // network.alioss.OssUploadCallBack
        public void onProgress(long j2, long j3) {
        }

        @Override // network.alioss.OssUploadCallBack
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            this.f19759a.onSuccess();
        }
    }

    protected OSSModelPresent(Activity activity, V v) {
        super(activity, (BaseView) v);
        this.upIndex = 0;
        this.mActivity = activity;
        this.mvpView = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conUpLoadFile(String str, String str2, OssTokenBean.CallBackBean callBackBean, String str3, IRCallback iRCallback) {
        AliOssClient.getInstance().upLoadFile(str, str2, str3, callBackBean, new d(iRCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OssFileInfo doUpFileInfo(String str, List<String> list) throws NoSuchAlgorithmException, IOException {
        String str2 = list.get(this.upIndex);
        File file = new File(str2);
        String strA = o1.a(file);
        String str3 = str + "/" + strA + y1.f(file.getName());
        OssFileInfo ossFileInfo = new OssFileInfo();
        ossFileInfo.setFilePath(str3);
        ossFileInfo.setFileMd5(strA);
        ossFileInfo.setFileSHA1(o1.b(file));
        ossFileInfo.setLocalPath(str2);
        return ossFileInfo;
    }

    private final void getOssToken(OssFileRequest ossFileRequest, OssTokenCallView ossTokenCallView) throws NoSuchAlgorithmException, IOException {
        String str = TextUtils.equals(ossFileRequest.getType(), "1") ? ModuelConfig.MODEL_REPORT : TextUtils.equals(ossFileRequest.getType(), "2") ? ModuelConfig.MODEL_FEEDBACK : TextUtils.equals(ossFileRequest.getType(), "3") ? ModuelConfig.MODEL_MANUAL : TextUtils.equals(ossFileRequest.getType(), "5") ? ModuelConfig.MODEL_CASEXC : "";
        File file = new File(ossFileRequest.getFilePath());
        String strA = o1.a(file);
        ossFileRequest.setFileMd5(strA);
        String strB = o1.b(strA + AccountManager.getAccountId() + System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(strB);
        sb.append(y1.f(file.getName()));
        String string = sb.toString();
        ossFileRequest.setFileName(string);
        HashMap map = new HashMap();
        map.put("fileScopeType", ossFileRequest.getType());
        map.put("fileName", string);
        getOssToken(d.a.a(str, 8, e.b.S), map, new a(ossTokenCallView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upLoadFile(String str, String str2, OssFileInfo ossFileInfo, List<String> list, List<OssFileInfo> list2, IOssPicListCallback iOssPicListCallback) {
    }

    public void upFileToOss(OssFileRequest ossFileRequest, IOssPicCallback iOssPicCallback) {
        getOssToken(ossFileRequest, new b(ossFileRequest, iOssPicCallback));
    }

    public void upFileToOssList(OssFileRequest ossFileRequest, IOssPicListCallback iOssPicListCallback) throws NoSuchAlgorithmException, IOException {
        this.upIndex = 0;
        getOssToken(ossFileRequest, new c(ossFileRequest, iOssPicListCallback));
    }
}
