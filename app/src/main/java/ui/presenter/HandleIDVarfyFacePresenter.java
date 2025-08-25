package ui.presenter;

import android.app.Activity;
import android.os.Message;
import interfaces.IFaceLiveCallBack;
import interfaces.IFaceResultView;
import network.account.VerifyBody;
import ui.callview.HandleIDVarfyFaceView;

/* loaded from: classes2.dex */
public class HandleIDVarfyFacePresenter extends YCLicencePresenter<HandleIDVarfyFaceView> {

    class a implements IFaceLiveCallBack {
        a() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            ((HandleIDVarfyFaceView) HandleIDVarfyFacePresenter.this.mvpView).onSuccImaggRequest(bArr);
        }
    }

    class b implements IFaceResultView {
        b() {
        }

        @Override // interfaces.IFaceResultView
        public void onSuccRequest(Message message) {
            ((HandleIDVarfyFaceView) HandleIDVarfyFacePresenter.this.mvpView).onSuccRequest(message);
        }
    }

    public HandleIDVarfyFacePresenter(Activity activity, HandleIDVarfyFaceView handleIDVarfyFaceView) {
        super(activity, handleIDVarfyFaceView);
    }

    public void startLive() {
        startLiveFace(new a());
    }

    public void verifyAction(String str, String str2, String str3, String str4) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str4);
        verifyBody.setName(str2);
        verifyBody.setIdentityCardNum(str3);
        verifyBody.setImage(str);
        verifyHttp(JNIHandStamp.getInstance().pamramToMap(verifyBody), true, new b());
    }
}
