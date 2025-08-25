package network;

import android.text.TextUtils;
import bean.ProgressBean;
import d.d;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import l.m;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.c;
import util.f1;
import util.n1;
import util.y1;

/* loaded from: classes2.dex */
public class RetrofitFileHelp {
    public static void bean2TextParam(MultipartBody.Builder builder, Object obj) {
        for (Map.Entry<String, Object> entry : y1.a(false, obj).entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue() + "");
        }
    }

    private static FileRequestBody getFileProgress(RequestBody requestBody) {
        return getFileProgress(requestBody, -1);
    }

    public static void setFileParam(MultipartBody.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str2);
        if (TextUtils.isEmpty(str)) {
            str = file.getName();
        }
        try {
            f1.a(f1.a(str2, new FileInputStream(file).available()), d.f13556l + str);
            File file2 = new File(d.f13556l + str);
            if (file.exists()) {
                file = file2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        builder.addFormDataPart("file", str, RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), file));
    }

    public static void setFileParamWithProgress(MultipartBody.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.addFormDataPart("file", str, getFileProgress(RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), new File(str2))));
    }

    public static void setTextParam(MultipartBody.Builder builder, String str, String str2) {
        builder.addFormDataPart(str, str2);
    }

    private static FileRequestBody getFileProgress(RequestBody requestBody, final int i2) {
        if (i2 == -1) {
            i2 = 201;
        }
        return new FileRequestBody(requestBody, new RetrofitCallback<String>() { // from class: network.RetrofitFileHelp.1
            @Override // l.d
            public void onFailure(l.b<String> bVar, Throwable th) {
                n1.a("onFailure RetrofitCallback-->>" + th.getMessage());
            }

            @Override // network.RetrofitCallback
            public void onLoading(long j2, long j3) {
                n1.a("onLoading RetrofitCallback-->>total:" + j2 + "--progress:" + j3);
                c.f().c(new util.c2.a(i2, new ProgressBean(j2, j3)));
            }

            @Override // network.RetrofitCallback
            public void onSuccess(l.b<String> bVar, m<String> mVar) {
                n1.a("onSuccess RetrofitCallback-->>" + mVar.a().toString());
            }
        });
    }
}
