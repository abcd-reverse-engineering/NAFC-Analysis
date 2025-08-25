package util;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.text.TextUtils;
import bean.PhoneInfoBean;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ui.Hicore;

/* compiled from: HttpPhoneUtil.java */
/* loaded from: classes2.dex */
public class h1 {

    /* renamed from: f, reason: collision with root package name */
    private static com.google.gson.e f20822f;

    /* renamed from: b, reason: collision with root package name */
    private String f20824b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f20825c;

    /* renamed from: d, reason: collision with root package name */
    private c f20826d;

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f20823a = new OkHttpClient();

    /* renamed from: e, reason: collision with root package name */
    private Handler f20827e = new Handler(Looper.getMainLooper());

    /* compiled from: HttpPhoneUtil.java */
    class a implements Callback {

        /* compiled from: HttpPhoneUtil.java */
        /* renamed from: util.h1$a$a, reason: collision with other inner class name */
        class RunnableC0322a implements Runnable {
            RunnableC0322a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h1.this.f20826d.onFail("请求错误");
            }
        }

        /* compiled from: HttpPhoneUtil.java */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Response f20830a;

            b(Response response) {
                this.f20830a = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f20830a.isSuccessful()) {
                    h1.this.f20826d.onFail("请求失败");
                    return;
                }
                try {
                    h1.this.f20826d.onSuccess(this.f20830a.body().string());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    h1.this.f20826d.onFail("结果转换失败");
                }
            }
        }

        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (h1.this.f20826d != null) {
                h1.this.f20827e.post(new RunnableC0322a());
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (h1.this.f20826d != null) {
                h1.this.f20827e.post(new b(response));
            }
        }
    }

    /* compiled from: HttpPhoneUtil.java */
    public interface b {
        void a(PhoneInfoBean phoneInfoBean);
    }

    /* compiled from: HttpPhoneUtil.java */
    public interface c {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public h1(c cVar) {
        this.f20826d = cVar;
    }

    public void a(String str, Map<String, String> map) {
        a(str, map, false);
    }

    public void b(String str, Map<String, String> map) {
        a(str, map, true);
    }

    private void a(String str, Map<String, String> map, boolean z) {
        this.f20824b = str;
        this.f20825c = map;
        b(z);
    }

    private void b(boolean z) {
        this.f20823a.newCall(a(z)).enqueue(new a());
    }

    private Request a(boolean z) {
        if (z) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            for (Map.Entry<String, String> entry : this.f20825c.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
            return new Request.Builder().url(this.f20824b).post(builder.build()).build();
        }
        return new Request.Builder().url(this.f20824b + "?" + a(this.f20825c)).build();
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + "&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String a(String str) {
        String str2 = "";
        Cursor cursorQuery = null;
        try {
            cursorQuery = Hicore.getApp().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date", "type", "geocoded_location", CommonNetImpl.NAME}, null, null, null);
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(3);
                if (TextUtils.equals(string, str) && !TextUtils.isEmpty(string2)) {
                    str2 = string2;
                }
            }
            cursorQuery.close();
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception unused3) {
            }
        }
        return TextUtils.isEmpty(str2) ? y1.m(str) : str2;
    }
}
