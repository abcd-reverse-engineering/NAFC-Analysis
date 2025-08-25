package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class SocialApi {

    /* renamed from: a, reason: collision with root package name */
    private SocialApiIml f9715a;

    public SocialApi(QQToken qQToken) {
        this.f9715a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f9715a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f9715a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f9715a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) throws JSONException, NoSuchAlgorithmException {
        if (com.tencent.connect.a.a("SocialApi", iUiListener)) {
            return;
        }
        this.f9715a.story(activity, bundle, iUiListener);
    }
}
