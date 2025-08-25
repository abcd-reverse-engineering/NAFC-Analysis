package network.interceptor;

import android.text.TextUtils;
import com.google.gson.e;
import com.hihonor.honorid.core.data.UserInfo;
import d.b;
import d.d;
import interfaces.IOneClickListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import manager.AccountManager;
import network.APICode;
import network.Api;
import network.FileRequestBody;
import network.http.RegionConfigHttp;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
import ui.Hicore;
import ui.presenter.JNIHandStamp;
import util.n1;
import util.v1;
import util.y1;

/* loaded from: classes2.dex */
public class RequestParamInterceptor implements Interceptor {
    static /* synthetic */ void a(Request.Builder builder) {
        builder.header("deviceid", JNIHandStamp.getInstance().getUUID());
        builder.header("identity", JNIHandStamp.identity + "");
        builder.header("seqid", JNIHandStamp.getInstance().getSeqid());
    }

    private static String encodeHead(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String getDecodeParam(Request request) throws IOException {
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null && !(requestBodyBody instanceof FormBody) && !(requestBodyBody instanceof MultipartBody) && !(requestBodyBody instanceof FileRequestBody) && requestBodyBody.contentLength() > 0) {
            try {
                String strOptString = new JSONObject(getParamContent(requestBodyBody)).optString("data");
                if (!TextUtils.isEmpty(strOptString)) {
                    return JNIHandStamp.jni.paramJsonDecode(strOptString);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private String getParamContent(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }

    private synchronized Request handleRequest(Request request, String str, int i2) {
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null) {
            return request;
        }
        if (infilterRequest(request)) {
            return request;
        }
        if (!(requestBodyBody instanceof FormBody) && !(requestBodyBody instanceof MultipartBody) && !(requestBodyBody instanceof FileRequestBody)) {
            try {
                String strG = y1.g(request.url().toString());
                String str2 = Api.getmHost();
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(strG, str2)) {
                    JNIHandStamp.getInstance().cleanJNIData();
                    i2 = APICode.CODE_EXPRIE;
                }
                Api.setHost(strG);
                JSONObject jSONObject = new JSONObject();
                HashMap map = new HashMap();
                final Request.Builder builderNewBuilder = request.newBuilder();
                if (JNIHandStamp.getInstance().expireFail(false) || i2 == 470) {
                    JNIHandStamp.getInstance().expireFail(true);
                    JNIHandStamp.getInstance().handshareKeySyn(strG, new IOneClickListener() { // from class: network.interceptor.a
                        @Override // interfaces.IOneClickListener
                        public final void clickOKBtn() {
                            RequestParamInterceptor.a(builderNewBuilder);
                        }
                    });
                }
                if (!TextUtils.isEmpty(str)) {
                    map.put("data", JNIHandStamp.jni.paramJsonEncode(str));
                    jSONObject = new JSONObject(map);
                }
                request = builderNewBuilder.method(request.method(), RequestBody.create(requestBodyBody.contentType(), jSONObject.toString())).build();
            } catch (Exception unused) {
                return request;
            }
        }
        return request;
    }

    private Response handleResponse(Interceptor.Chain chain, Request request, String str) throws IOException {
        Response responseProceed = chain.proceed(request);
        n1.b("RetrofitLog", "<-- " + responseProceed.code() + "  " + new e().a(request.newBuilder()) + d.D);
        return responseProceed.code() == 470 ? chain.proceed(handleRequest(request, str, APICode.CODE_EXPRIE)) : responseProceed;
    }

    private boolean infilterRequest(Request request) {
        String string = request.url().toString();
        return string.contains("getalldictionaryv2") || string.contains("handshark") || string.contains("oss-test.gjfzpt.cn") || string.contains("oss.gjfzpt.cn");
    }

    private void setHeader(Request.Builder builder) {
        if (builder == null) {
            return;
        }
        builder.addHeader("deviceid", JNIHandStamp.getInstance().getUUID());
        builder.addHeader("identity", JNIHandStamp.identity + "");
        builder.addHeader("seqid", JNIHandStamp.getInstance().getSeqid());
        if (JNIHandStamp.getInstance().isNeedDelay()) {
            builder.addHeader("delay", "1");
        } else {
            builder.addHeader("delay", "0");
        }
        builder.addHeader("os-version", v1.i());
        builder.addHeader("os-type", "0");
        builder.addHeader("os-brand", v1.b());
        builder.addHeader("os-model", v1.k());
        builder.addHeader("market", Hicore.getApp().getChannel());
        builder.addHeader("app-version", v1.o());
        builder.addHeader("app-version-code", v1.n() + "");
        builder.addHeader("api-version", "175");
        builder.addHeader("UM-deviceToken", receiver.e.f17545a + "");
        builder.addHeader("nodeid", RegionConfigHttp.getNodeRegionId());
        builder.addHeader("nodeCode", RegionConfigHttp.getNodeRegionId());
        builder.addHeader("longitude", "0");
        builder.addHeader("latitude", "0");
        builder.addHeader(UserInfo.ADDRESS, "");
        builder.addHeader("Authorization", AccountManager.getAccountToken());
        builder.addHeader("policeToken", b.c());
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        setHeader(builderNewBuilder);
        if (request.body() instanceof FormBody) {
            FormBody.Builder builder = new FormBody.Builder();
            FormBody formBody = (FormBody) request.body();
            for (int i2 = 0; i2 < formBody.size(); i2++) {
                builder.addEncoded(formBody.encodedName(i2), formBody.encodedValue(i2));
            }
            builderNewBuilder.method(request.method(), builder.build());
        }
        Request requestBuild = builderNewBuilder.build();
        String decodeParam = getDecodeParam(requestBuild);
        return handleResponse(chain, handleRequest(requestBuild, decodeParam, 0), decodeParam);
    }
}
