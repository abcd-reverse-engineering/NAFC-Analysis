package c.c.a.c.a.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import c.c.a.d.j;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import k.a.a.a.j.e;
import k.a.a.c.a.c;

/* compiled from: HonorIDSignInServiceImpl.java */
/* loaded from: classes.dex */
public class b extends c.c.a.a.b<SignInOptions> implements a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3132d = "HonorIDSignInServiceImpl";

    /* renamed from: e, reason: collision with root package name */
    public static final c<SignInOptions> f3133e = new c<>("SignInAccountInfo.API");

    public b(Activity activity, SignInOptions signInOptions) {
        super(activity, f3133e, signInOptions);
    }

    @Override // c.c.a.c.a.c.a
    public j<SignInAccountInfo> a() {
        e.b(f3132d, "silentSignIn", true);
        return c.c.a.c.a.b.b.d(g(), e());
    }

    @Override // c.c.a.c.b.a.a
    public j<Void> b() {
        e.b(f3132d, "signOut", true);
        return c.c.a.c.a.b.b.c(g(), e());
    }

    @Override // c.c.a.c.b.a.a
    public Intent c() {
        return c.c.a.c.a.b.b.b(g(), e());
    }

    @Override // c.c.a.c.b.a.a
    public j<Void> d() {
        e.b(f3132d, "cancelAuthorization", true);
        return c.c.a.c.a.b.b.a(g(), e());
    }

    public b(Context context, SignInOptions signInOptions) {
        super(context, f3133e, signInOptions);
    }
}
