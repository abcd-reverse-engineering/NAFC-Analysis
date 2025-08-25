package cn.cloudwalk.libproject.net;

import android.os.AsyncTask;
import anet.channel.util.HttpConstant;
import cn.cloudwalk.libproject.util.Base64Util;
import cn.cloudwalk.libproject.util.LogUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.open.SocialConstants;
import h.z2.h0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HttpManager {
    private static final String TAG = LogUtils.makeLogTag("HttpManager");

    public interface DataCallBack {
        void requestFailure(String str);

        void requestSucess(JSONObject jSONObject);
    }

    public static void cwAddFaceToGroup(String str, String str2, String str3, String str4, String str5, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put("faceId", str4);
            map.put("groupId", str5);
            postAsync(str + "/face/clustering/group/addFace", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwBankOcr(String str, String str2, String str3, byte[] bArr, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put(SocialConstants.PARAM_IMG_URL, Base64Util.encode(bArr));
        postAsync(str + "/ocr/bankcard", generateUrl(map), dataCallBack);
    }

    public static void cwCreateFace(String str, String str2, String str3, String str4, String str5, String str6, String str7, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put(SocialConstants.PARAM_IMG_URL, str6);
            map.put("faceId", str4);
            map.put("groupId", str5);
            map.put("tag", str7);
            postAsync(str + "/face/clustering/face/create", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwCreateGroup(String str, String str2, String str3, String str4, String str5, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put("groupId", str4);
            map.put("tag", str5);
            postAsync(str + "/face/clustering/group/create", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwDelFaceToGroup(String str, String str2, String str3, String str4, String str5, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put("faceId", str4);
            map.put("groupId", str5);
            postAsync(str + "/face/clustering/group/removeFace", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwDelGroup(String str, String str2, String str3, String str4, String str5, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put("groupId", str4);
            postAsync(str + "/face/clustering/group/delete", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwFaceAttribute(String str, String str2, String str3, String str4, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put(SocialConstants.PARAM_IMG_URL, str4);
            postAsync(str + "/face/tool/attribute", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwFaceComper(String str, String str2, String str3, String str4, String str5, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put("imgA", str4);
            map.put("imgB", str5);
            postAsync(str + "/face/tool/compare", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwFaceRecg(String str, String str2, String str3, String str4, String str5, int i2, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put(SocialConstants.PARAM_IMG_URL, str5);
            map.put("groupId", str4);
            map.put("topN", i2 + "");
            postAsync(str + "/face/recog/group/identify", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwFaceSerLivess(String str, String str2, String str3, String str4, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put(RemoteMessageConst.MessageBody.PARAM, str4);
        postAsync(str + "/faceliveness", generateUrl(map), dataCallBack);
    }

    public static void cwIDOcr(String str, String str2, String str3, String str4, int i2, DataCallBack dataCallBack) {
        try {
            HashMap map = new HashMap();
            map.put("app_id", str2);
            map.put("app_secret", str3);
            map.put(SocialConstants.PARAM_IMG_URL, str4);
            map.put("getFace", i2 + "");
            postAsync(str + "/ocr", generateUrl(map), dataCallBack);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void cwMaskAddImg(String str, String str2, String str3, byte[] bArr, byte[] bArr2, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr));
        map.put("imgMask", Base64Util.encode(bArr2));
        postAsync(str + "/tool/digitalwater/addImage", generateUrl(map), dataCallBack);
    }

    public static void cwMaskAddStr(String str, String str2, String str3, byte[] bArr, String str4, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr));
        map.put("strMask", str4);
        postAsync(str + "/tool/digitalwater/addString", generateUrl(map), dataCallBack);
    }

    public static void cwMaskDelImg(String str, String str2, String str3, byte[] bArr, byte[] bArr2, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr2));
        map.put("imgMask", Base64Util.encode(bArr2));
        postAsync(str + "/tool/digitalwater/removeImage", generateUrl(map), dataCallBack);
    }

    public static void cwMaskDelStr(String str, String str2, String str3, byte[] bArr, String str4, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr));
        map.put("strMask", str4);
        postAsync(str + "/tool/digitalwater/removeString", generateUrl(map), dataCallBack);
    }

    public static void cwMaskDetectImg(String str, String str2, String str3, byte[] bArr, byte[] bArr2, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr2));
        map.put("imgMask", Base64Util.encode(bArr2));
        postAsync(str + "/tool/digitalwater/detectImage", generateUrl(map), dataCallBack);
    }

    public static void cwMaskDetectStr(String str, String str2, String str3, byte[] bArr, String str4, DataCallBack dataCallBack) {
        HashMap map = new HashMap();
        map.put("app_id", str2);
        map.put("app_secret", str3);
        map.put("imgSrc", Base64Util.encode(bArr));
        map.put("strMask", str4);
        postAsync(str + "/tool/digitalwater/detectString", generateUrl(map), dataCallBack);
    }

    private static String generateUrl(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                try {
                    sb.append(key);
                    sb.append('=');
                    sb.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    sb.append(key);
                    sb.append('=');
                    sb.append(value);
                    e2.printStackTrace();
                }
                if (it.hasNext()) {
                    sb.append(h0.f16706c);
                }
            }
        }
        return sb.toString();
    }

    public static void postAsync(final String str, final String str2, final DataCallBack dataCallBack) {
        LogUtils.LOGW(TAG, "url&params:" + str + ", " + str2);
        new AsyncTask<Object, Object, String>() { // from class: cn.cloudwalk.libproject.net.HttpManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Object... objArr) {
                try {
                    return str.startsWith(HttpConstant.HTTPS) ? HttpsUrlConnectionUtil.post(str, str2) : HttpUrlConnectionUtil.post(str, str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str3) {
                LogUtils.LOGW(HttpManager.TAG, "--result:" + str3);
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.optInt("result") == 0) {
                        dataCallBack.requestSucess(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("info");
                        dataCallBack.requestFailure("错误码:" + jSONObject.optInt("result") + " 错误信息:" + strOptString);
                    }
                } catch (Exception e2) {
                    dataCallBack.requestFailure("网络异常,请检查网络!");
                    e2.printStackTrace();
                }
            }
        }.execute("");
    }
}
