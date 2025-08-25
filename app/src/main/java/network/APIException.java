package network;

import android.content.res.Resources;
import android.text.TextUtils;
import com.hicorenational.antifraud.R;
import network.account.APIresult;
import ui.Hicore;

/* loaded from: classes2.dex */
public class APIException extends RuntimeException {
    public static final int CODE_TOKEN_INVALID = 401;
    public static final int NO_NETWORK_CODE = -10001;
    private int code;

    private APIException(int i2, String str) {
        super(str);
        this.code = i2;
    }

    public static APIException getApiExcept() {
        return getApiExcept(-102, Hicore.getApp().getResources().getString(R.string.err_timeout));
    }

    public int getCode() {
        return this.code;
    }

    public boolean isNoNetwork() {
        return this.code == -10001;
    }

    public boolean isTokenInvalid() {
        return this.code == 401;
    }

    public static APIException getApiExcept(String str) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(str)) {
            str = Hicore.getApp().getResources().getString(R.string.err_timeout);
        }
        return getApiExcept(-102, str);
    }

    public static APIException getApiExcept(APIresult aPIresult) {
        int code;
        String string = Hicore.getApp().getString(R.string.err_timeout);
        if (aPIresult != null) {
            code = aPIresult.getCode();
            if (!TextUtils.isEmpty(aPIresult.getMsg())) {
                string = aPIresult.getMsg();
            }
        } else {
            code = -102;
        }
        return getApiExcept(code, string);
    }

    public static synchronized APIException getApiExcept(int i2, String str) {
        return new APIException(i2, str);
    }
}
