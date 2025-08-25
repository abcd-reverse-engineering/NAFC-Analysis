package ui.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import bean.HandKey;
import bean.TellNumHtyBean;
import com.hicorenational.antifraud.R;
import com.openssl.md.JniHand;
import interfaces.IOneClickListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import l.n;
import network.APIException;
import network.IReportService;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import ui.Hicore;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.n1;
import util.v1;
import util.w1;

/* loaded from: classes2.dex */
public class JNIHandStamp<T> extends ModelPresent {
    public static final String ENCODEKEY = "data";
    private AtomicLong atomicInte;
    private long expireTime;
    private boolean isExpireQurey;
    private long lastLocal;
    private static JNIHandStamp jniPresenter = new JNIHandStamp();
    public static JniHand jni = new JniHand();
    public static String identity = "";

    class a extends MiddleSubscriber<APIresult<HandKey>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f19950a;

        a(IOneClickListener iOneClickListener) {
            this.f19950a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HandKey.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
            JNIHandStamp.this.isExpireQurey = false;
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HandKey> aPIresult) {
            JNIHandStamp.this.getHandKey(aPIresult, this.f19950a);
        }
    }

    class b extends com.google.gson.d0.a<HashMap<String, String>> {
        b() {
        }
    }

    public interface c {
        void onSuccess(HashMap map);
    }

    private JNIHandStamp() {
        super((Activity) null, (BaseView) null);
        this.atomicInte = new AtomicLong(1L);
        this.isExpireQurey = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> APIresult<V> analyzeParamResult(APIresult<V> aPIresult, Type type) {
        if (aPIresult == null) {
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_timeout));
        }
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return aPIresult;
        }
        String str = aPIresult.getsData();
        if (TextUtils.isEmpty(str)) {
            return aPIresult;
        }
        String strParamJsonDecode = jni.paramJsonDecode(str);
        n1.b("RetrofitLog", "参数解密 " + strParamJsonDecode);
        aPIresult.setEncodeStr(strParamJsonDecode);
        com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) eVarBuildGson.a(strParamJsonDecode, (Class) APIresult.class));
        tellNumHtyBean.setEncodeStr(strParamJsonDecode);
        if (type != null) {
            try {
                com.google.gson.k kVar = new com.google.gson.o().a(strParamJsonDecode).getAsJsonObject().get("data");
                if (kVar != null) {
                    tellNumHtyBean.setData(eVarBuildGson.a(kVar.toString(), type));
                } else {
                    tellNumHtyBean.setData(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                tellNumHtyBean.setData(null);
            }
        }
        systemError(tellNumHtyBean);
        return tellNumHtyBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void getHandKey(APIresult<HandKey> aPIresult, IOneClickListener iOneClickListener) {
        if (aPIresult.getCode() == 0) {
            try {
                HandKey data = aPIresult.getData();
                jni.setApiPubKey(data.getPeer().replaceAll("(.{64})", "$1\n").trim());
                identity = jni.paramJsonDecode(data.getIdentity());
                String strParamJsonDecode = jni.paramJsonDecode(data.getSeqid());
                if (!TextUtils.isEmpty(strParamJsonDecode)) {
                    this.atomicInte.set(Long.parseLong(strParamJsonDecode));
                }
                String strParamJsonDecode2 = jni.paramJsonDecode(data.getExpire());
                if (!TextUtils.isEmpty(strParamJsonDecode2)) {
                    this.expireTime = Long.parseLong(strParamJsonDecode2);
                }
                this.lastLocal = System.currentTimeMillis();
                this.isExpireQurey = true;
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            } catch (Exception unused) {
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            }
        } else {
            w1.e("请求超时");
        }
    }

    public static JNIHandStamp getInstance() {
        return jniPresenter;
    }

    private String operatUrl(String str) {
        if (d.a.f13517c.contains(str)) {
            return d.a.f13517c + e.b.f13565c;
        }
        if (d.a.f13522h.contains(str)) {
            return d.a.f13522h + e.b.f13566d;
        }
        if (!d.a.f13524j.contains(str)) {
            return "";
        }
        return d.a.f13524j + e.b.f13566d;
    }

    private HashMap<String, String> princiHttp(T t) {
        HashMap<String, String> map = new HashMap<>();
        if (t != null) {
            String strA = ResponseDataTypeAdaptor.buildGson().a(t);
            n1.b("RetrofitLog", "参数data " + strA);
            String strParamJsonEncode = jni.paramJsonEncode(strA);
            n1.b("RetrofitLog", "参数data加密后 " + strParamJsonEncode);
            map.put("data", strParamJsonEncode);
        }
        return map;
    }

    private <V> void systemError(APIresult<V> aPIresult) {
        if (aPIresult.getCode() == 999) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(R.string.err_system));
        } else if (TextUtils.isEmpty(aPIresult.getMsg())) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(R.string.err_timeout));
        }
    }

    public <V> APIresult<V> analyzeParam(APIresult<V> aPIresult, Type type) {
        return analyzeParamResult(aPIresult, type);
    }

    public void cleanJNIData() {
        identity = "";
        this.isExpireQurey = true;
        this.atomicInte.set(1L);
    }

    public synchronized boolean expireFail(boolean z) {
        if (z) {
            this.isExpireQurey = false;
            return true;
        }
        if (isNeedDelay()) {
            return false;
        }
        if (this.expireTime - ((System.currentTimeMillis() - this.lastLocal) / 1000) > 0) {
            return false;
        }
        this.isExpireQurey = false;
        return true;
    }

    public String getSeqid() {
        return jni.paramJsonEncode(String.valueOf(this.atomicInte.incrementAndGet()));
    }

    public String getUUID() {
        return jni.paramJsonEncode(v1.l());
    }

    public synchronized void handshareKeySyn(String str, IOneClickListener iOneClickListener) {
        if (this.isExpireQurey) {
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            return;
        }
        String strOperatUrl = operatUrl(str);
        if (TextUtils.isEmpty(strOperatUrl)) {
            iOneClickListener.clickOKBtn();
            w1.a("请求数据异常");
        }
        HashMap map = new HashMap();
        map.put("peer", jni.getAppPubKey());
        try {
            l.b<APIresult<HandKey>> bVarJniAppKeySyn = ((IReportService) new n.b().a(d.a.i()).a(l.r.a.a.a()).a().a(IReportService.class)).jniAppKeySyn(strOperatUrl, map);
            n1.b("RetrofitLog", "retrofitHeader  " + new com.google.gson.e().a(bVarJniAppKeySyn.request().newBuilder()) + "-------------");
            l.m<APIresult<HandKey>> mVarExecute = bVarJniAppKeySyn.execute();
            n1.b("RetrofitLog", "response<-- " + mVarExecute.b() + c.c.a.b.a.a.f3100g + bVarJniAppKeySyn.request().url());
            if (mVarExecute != null) {
                getHandKey(mVarExecute.a(), iOneClickListener);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            w1.e(e2.getMessage());
        }
    }

    public synchronized void handsharkKeyAsyn(IOneClickListener iOneClickListener) {
        String str = d.a.f13517c + e.b.f13565c;
        HashMap<String, String> map = new HashMap<>();
        map.put("peer", jni.getAppPubKey());
        jniAppKey(map, str, new a(iOneClickListener));
    }

    public boolean isNeedDelay() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.lastLocal) / 1000;
        long j2 = this.expireTime;
        if (j2 - jCurrentTimeMillis <= 0 || j2 - jCurrentTimeMillis >= 60) {
            return false;
        }
        this.lastLocal = System.currentTimeMillis();
        return true;
    }

    public HashMap pamramToMap(T t) {
        com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
        return (HashMap) eVarBuildGson.a(eVarBuildGson.a(t), new b().getType());
    }

    public String pamramToString(T t) {
        return ResponseDataTypeAdaptor.buildGson().a(t);
    }

    public synchronized HashMap<String, String> princEncode(T t) {
        return princiHttp(t);
    }
}
