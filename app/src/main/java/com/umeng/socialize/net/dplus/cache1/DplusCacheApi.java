package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.c.b.a;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.db.DBConfig;
import com.umeng.socialize.net.dplus.db.DBManager;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DplusCacheApi {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11778a = "DplusCacheApi";

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f11779b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f11780c;

    /* renamed from: d, reason: collision with root package name */
    private final int f11781d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f11782e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Integer> f11783f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<Integer> f11784g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f11785h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f11786i;

    private static class SingletonHolder {

        /* renamed from: a, reason: collision with root package name */
        private static final DplusCacheApi f11803a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f11803a;
    }

    public void cleanCache(final Context context) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                a.a(context);
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            }
        });
    }

    public void deleteAllAsnc(Context context) {
        DBManager.get(ContextUtil.getContext()).deleteTable("stats");
    }

    public void deleteFile(final Context context) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f11782e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f11782e, "s_e");
                    DplusCacheApi.this.f11782e.clear();
                }
                if (DplusCacheApi.this.f11783f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f11783f, "auth");
                    DplusCacheApi.this.f11783f.clear();
                }
                if (DplusCacheApi.this.f11785h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f11785h, "dau");
                    DplusCacheApi.this.f11785h.clear();
                }
                if (DplusCacheApi.this.f11784g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f11784g, "userinfo");
                    DplusCacheApi.this.f11784g.clear();
                }
                if (DplusCacheApi.this.f11786i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f11786i, "stats");
                    DplusCacheApi.this.f11786i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f11782e.size() > 0) {
            DBManager.get(context).delete(this.f11782e, "s_e");
            this.f11782e.clear();
        }
        if (this.f11783f.size() > 0) {
            DBManager.get(context).delete(this.f11783f, "auth");
            this.f11783f.clear();
        }
        if (this.f11785h.size() > 0) {
            DBManager.get(context).delete(this.f11785h, "dau");
            this.f11785h.clear();
        }
        if (this.f11784g.size() > 0) {
            DBManager.get(context).delete(this.f11784g, "userinfo");
            this.f11784g.clear();
        }
        if (this.f11786i.size() > 0) {
            DBManager.get(context).delete(this.f11786i, "stats");
            this.f11786i.clear();
        }
    }

    public void readFile(final Context context, final int i2, final DplusCacheListener dplusCacheListener) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                JSONArray jSONArray;
                JSONArray jSONArray2;
                JSONArray jSONArray3;
                JSONArray jSONArray4;
                JSONArray jSONArray5;
                JSONArray jSONArray6;
                double dCheckFile = DplusCacheApi.checkFile();
                if (dCheckFile >= 5242880.0d) {
                    DBManager.get(ContextUtil.getContext()).deleteTable("stats");
                    return;
                }
                boolean z = 1048576.0d <= dCheckFile + 24576.0d;
                JSONObject jSONObject = new JSONObject();
                try {
                    new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArraySelect = DBManager.get(context).select("s_e", DplusCacheApi.this.f11782e, 1047552.0d, z);
                    double length = 1024.0d + jSONArraySelect.toString().getBytes().length;
                    JSONArray jSONArraySelect2 = DBManager.get(context).select("auth", DplusCacheApi.this.f11783f, 1048576.0d - length, z);
                    double length2 = length + jSONArraySelect2.toString().getBytes().length;
                    JSONArray jSONArraySelect3 = DBManager.get(context).select("userinfo", DplusCacheApi.this.f11784g, 1048576.0d - length2, z);
                    double length3 = length2 + jSONArraySelect3.toString().getBytes().length;
                    JSONArray jSONArraySelect4 = DBManager.get(context).select("dau", DplusCacheApi.this.f11785h, 1048576.0d - length3, z);
                    double length4 = length3 + jSONArraySelect4.toString().getBytes().length;
                    double dCheckFile2 = DplusCacheApi.checkFile();
                    if (jSONArraySelect4.length() != 0) {
                        jSONObject2.put("dau", jSONArraySelect4);
                    }
                    if (jSONArraySelect.length() != 0) {
                        jSONArray = jSONArraySelect;
                        jSONObject2.put("s_e", jSONArray);
                    } else {
                        jSONArray = jSONArraySelect;
                    }
                    if (jSONArraySelect2.length() != 0) {
                        jSONArray2 = jSONArraySelect2;
                        jSONObject2.put("auth", jSONArray2);
                    } else {
                        jSONArray2 = jSONArraySelect2;
                    }
                    if (jSONArraySelect3.length() != 0) {
                        jSONArray3 = jSONArraySelect3;
                        jSONObject2.put("userinfo", jSONArray3);
                    } else {
                        jSONArray3 = jSONArraySelect3;
                    }
                    JSONArray jSONArray7 = new JSONArray();
                    if (dCheckFile2 >= 524288.0d || i2 == 24583) {
                        double d2 = 1048576.0d - length4;
                        jSONArray4 = jSONArray;
                        jSONArray5 = jSONArray2;
                        jSONArray6 = jSONArraySelect4;
                        jSONArray7 = DBManager.get(context).select("stats", DplusCacheApi.this.f11786i, d2, z);
                        if (jSONArray7.length() != 0) {
                            jSONObject2.put("stats", jSONArray7);
                        }
                    } else {
                        jSONArray4 = jSONArray;
                        jSONArray5 = jSONArray2;
                        jSONArray6 = jSONArraySelect4;
                    }
                    jSONObject.put("share", jSONObject2);
                    if (jSONArray4.length() == 0 && jSONArray5.length() == 0 && jSONArray3.length() == 0 && jSONArray6.length() == 0) {
                        if (jSONArray7.length() == 0) {
                            jSONObject = null;
                        }
                    }
                } catch (JSONException e2) {
                    SLog.error(UmengText.CACHE.CACHEFILE, e2);
                }
                if (jSONObject != null && jSONObject.toString().getBytes().length > 1048576.0d) {
                    dplusCacheListener.onResult(null);
                }
                dplusCacheListener.onResult(jSONObject);
            }
        });
    }

    public JSONObject readFileAsnc(Context context, int i2) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        double dCheckFile = checkFile();
        if (dCheckFile >= 5242880.0d) {
            DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            return null;
        }
        boolean z = 1048576.0d <= dCheckFile + 24576.0d;
        JSONObject jSONObject = new JSONObject();
        try {
            new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArraySelect = DBManager.get(context).select("s_e", this.f11782e, 1047552.0d, z);
            double length = 1024.0d + jSONArraySelect.toString().getBytes().length;
            JSONArray jSONArraySelect2 = DBManager.get(context).select("auth", this.f11783f, 1048576.0d - length, z);
            double length2 = length + jSONArraySelect2.toString().getBytes().length;
            JSONArray jSONArraySelect3 = DBManager.get(context).select("userinfo", this.f11784g, 1048576.0d - length2, z);
            double length3 = length2 + jSONArraySelect3.toString().getBytes().length;
            JSONArray jSONArraySelect4 = DBManager.get(context).select("dau", this.f11785h, 1048576.0d - length3, z);
            double length4 = length3 + jSONArraySelect4.toString().getBytes().length;
            double dCheckFile2 = checkFile();
            if (jSONArraySelect4.length() != 0) {
                jSONObject2.put("dau", jSONArraySelect4);
            }
            if (jSONArraySelect.length() != 0) {
                jSONArray = jSONArraySelect;
                jSONObject2.put("s_e", jSONArray);
            } else {
                jSONArray = jSONArraySelect;
            }
            if (jSONArraySelect2.length() != 0) {
                jSONArray2 = jSONArraySelect2;
                jSONObject2.put("auth", jSONArray2);
            } else {
                jSONArray2 = jSONArraySelect2;
            }
            if (jSONArraySelect3.length() != 0) {
                jSONArray3 = jSONArraySelect3;
                jSONObject2.put("userinfo", jSONArray3);
            } else {
                jSONArray3 = jSONArraySelect3;
            }
            JSONArray jSONArray7 = new JSONArray();
            if (dCheckFile2 >= 524288.0d || i2 == 24583) {
                double d2 = 1048576.0d - length4;
                jSONArray4 = jSONArray;
                jSONArray5 = jSONArray2;
                jSONArray6 = jSONArraySelect4;
                jSONArray7 = DBManager.get(context).select("stats", this.f11786i, d2, z);
                if (jSONArray7.length() != 0) {
                    jSONObject2.put("stats", jSONArray7);
                }
            } else {
                jSONArray4 = jSONArray;
                jSONArray5 = jSONArray2;
                jSONArray6 = jSONArraySelect4;
            }
            jSONObject.put("share", jSONObject2);
            if (jSONArray4.length() == 0 && jSONArray5.length() == 0 && jSONArray3.length() == 0 && jSONArray6.length() == 0) {
                if (jSONArray7.length() == 0) {
                    jSONObject = null;
                }
            }
        } catch (JSONException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
        if (jSONObject == null || jSONObject.toString().getBytes().length <= 1048576.0d) {
            return jSONObject;
        }
        return null;
    }

    public void saveFile(final Context context, final JSONObject jSONObject, final int i2, final DplusCacheListener dplusCacheListener) {
        this.f11780c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i2) {
                    case SocializeConstants.DAU_EVENT /* 24577 */:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case SocializeConstants.SHARE_EVENT /* 24578 */:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case SocializeConstants.AUTH_EVENT /* 24579 */:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case SocializeConstants.GET_EVENT /* 24580 */:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                    case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    private DplusCacheApi() {
        this.f11781d = 1048576;
        this.f11782e = new ArrayList<>();
        this.f11783f = new ArrayList<>();
        this.f11784g = new ArrayList<>();
        this.f11785h = new ArrayList<>();
        this.f11786i = new ArrayList<>();
        this.f11779b = new HandlerThread(f11778a, 10);
        this.f11779b.start();
        this.f11780c = new Handler(this.f11779b.getLooper());
    }

    private static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.3.2");
        jSONObject.put(CommonNetImpl.PCV, SocializeConstants.PROTOCOL_VERSON);
        return jSONObject;
    }
}
