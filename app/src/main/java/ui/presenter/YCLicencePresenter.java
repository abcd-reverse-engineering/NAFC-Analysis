package ui.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import bean.YcLicenceBean;
import cn.cloudwalk.libproject.Builder;
import cn.cloudwalk.libproject.LiveActivity;
import cn.cloudwalk.libproject.callback.FrontDetectCallback;
import interfaces.IFaceLiveCallBack;
import interfaces.IFaceResultView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.RegisterInfo;
import ui.activity.IDVarfyFaceActivity;
import ui.basemvp.BaseView;
import ui.callview.HandleIDVarfyFaceView;
import ui.callview.VerifyFaceCallview;
import ui.model.ModelPresent;
import util.m1;
import util.n1;

/* loaded from: classes2.dex */
public class YCLicencePresenter<V extends BaseView> extends ModelPresent<V> {
    public static final String TAG = YCLicencePresenter.class.getSimpleName();
    private final int liveCount;
    private String publicFilePath;

    class a extends MiddleSubscriber<APIresult<YcLicenceBean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return YcLicenceBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<YcLicenceBean> aPIresult) {
            YcLicenceBean data = aPIresult.getData();
            if (data == null || TextUtils.isEmpty(data.getAppLicenceCode())) {
                return;
            }
            m1.u.b(data.getAppLicenceCode());
            m1.u.a(data.getAppLicenceVersion());
        }
    }

    class b implements FrontDetectCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Builder f20198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFaceLiveCallBack f20199b;

        b(Builder builder, IFaceLiveCallBack iFaceLiveCallBack) {
            this.f20198a = builder;
            this.f20199b = iFaceLiveCallBack;
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessCancel() {
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessFail(int i2) {
            Activity activity = YCLicencePresenter.this.mActivity;
            activity.startActivity(new Intent(activity, (Class<?>) IDVarfyFaceActivity.class));
        }

        @Override // cn.cloudwalk.libproject.callback.FrontDetectCallback
        public void onLivenessSuccess(byte[] bArr, String str, byte[] bArr2, String str2, byte[] bArr3) {
            String str3 = YCLicencePresenter.TAG;
            this.f20198a.setFaceResult(YCLicencePresenter.this.mActivity, 5, 0.0d, "", "");
            this.f20199b.onLivenessSuccess(bArr);
        }
    }

    class c extends MiddleSubscriber<APIresult<RegisterInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20201a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFaceResultView f20202b;

        c(boolean z, IFaceResultView iFaceResultView) {
            this.f20201a = z;
            this.f20202b = iFaceResultView;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return RegisterInfo.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            n1.a("register", "-->onError");
            this.f20202b.onSuccRequest(new Message());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<RegisterInfo> aPIresult) {
            n1.a("register", "-->onNext");
            Message message = new Message();
            if (aPIresult == null) {
                message.what = -1;
            } else {
                int code = aPIresult.getCode();
                if (code == 0) {
                    RegisterInfo data = aPIresult.getData();
                    int responseCode = data.getResponseCode();
                    if (responseCode == 100) {
                        message.what = data.getResult();
                    } else {
                        message.what = responseCode;
                    }
                } else if (code == 3) {
                    if (this.f20201a) {
                        message.what = 8;
                    } else {
                        message.what = 30;
                    }
                } else if (code == 4) {
                    if (!this.f20201a) {
                        message.what = 31;
                    }
                    String msg = aPIresult.getMsg();
                    if (!TextUtils.isEmpty(msg)) {
                        message.obj = msg;
                    }
                } else {
                    String msg2 = aPIresult.getMsg();
                    if (!TextUtils.isEmpty(msg2)) {
                        message.obj = msg2;
                    }
                    message.what = aPIresult.getCode();
                }
            }
            this.f20202b.onSuccRequest(message);
        }
    }

    public YCLicencePresenter(Activity activity) {
        super(activity, (BaseView) null);
        this.liveCount = 3;
        getYCLicence();
    }

    private void getYCLicence() {
        String str = d.a.f13517c + e.b.f13574l;
        HashMap<String, String> map = new HashMap<>();
        map.put("appversion", m1.u.d());
        getYCLicence(map, str, new a());
    }

    public void startLiveFace(IFaceLiveCallBack iFaceLiveCallBack) {
        ArrayList<Integer> arrayList = new ArrayList<>(3);
        arrayList.add(1004);
        arrayList.add(1005);
        arrayList.add(1000);
        arrayList.add(1001);
        Builder builder = new Builder();
        builder.setLicence(m1.u.t()).setFrontDetectCallback(new b(builder, iFaceLiveCallBack)).isServerLive(false).isFrontHack(true).isResultPage(false).setPublicFilePath(this.publicFilePath).setLives(arrayList, 3, true, false, Builder.liveLevel).startActivity(this.mActivity, LiveActivity.class);
    }

    public void verifyHttp(HashMap<String, String> map, boolean z, IFaceResultView iFaceResultView) {
        String strA = d.a.a("", 3, e.b.M);
        if (z) {
            strA = d.a.f13517c + e.b.s0;
        }
        requessVerifyHttp(strA, map, new c(z, iFaceResultView));
    }

    protected YCLicencePresenter(Activity activity, HandleIDVarfyFaceView handleIDVarfyFaceView) {
        super(activity, handleIDVarfyFaceView);
        this.liveCount = 3;
        getYCLicence();
    }

    protected YCLicencePresenter(Activity activity, VerifyFaceCallview verifyFaceCallview) {
        super(activity, verifyFaceCallview);
        this.liveCount = 3;
        getYCLicence();
    }
}
