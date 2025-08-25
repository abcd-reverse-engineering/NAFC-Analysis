package c.c.a.c.a;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import c.c.a.c.a.b.b;
import c.c.a.d.j;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.List;
import k.a.a.a.j.e;

/* compiled from: HonorIdSignInManager.java */
/* loaded from: classes.dex */
public final class a {
    private static Intent a(Activity activity, SignInOptions signInOptions) {
        return b(activity, signInOptions).c();
    }

    public static boolean b(Context context) {
        return b.b(context);
    }

    public static void a(Activity activity, int i2, SignInOptions signInOptions) {
        if (activity == null || signInOptions == null) {
            throw new NullPointerException("SignInOptions should not be null or activity is null");
        }
        if (!k.a.a.a.b.b(signInOptions.f())) {
            throw new NullPointerException("ScopeList should not be null");
        }
        Intent intentA = a(activity, signInOptions);
        if (intentA == null) {
            e.a("HonorIdSignInManager", "addAuthScopes signInIntent is null", true);
        } else {
            activity.startActivityForResult(intentA, i2);
        }
    }

    public static c.c.a.c.a.c.a b(Activity activity, SignInOptions signInOptions) {
        k.a.a.a.a.a(activity, "Null activity is not permitted.");
        return new c.c.a.c.a.c.b(activity, signInOptions);
    }

    public static boolean a(Context context, SignInAccountInfo signInAccountInfo, List<Scope> list) {
        k.a.a.a.a.a(context, "Null context is not permitted.");
        if (signInAccountInfo == null || k.a.a.a.b.a(list)) {
            return false;
        }
        return b.a(context, signInAccountInfo, list);
    }

    public static c.c.a.c.a.c.a a(Context context, SignInOptions signInOptions) {
        k.a.a.a.a.a(context, "Null context is not permitted.");
        return new c.c.a.c.a.c.b(context, signInOptions);
    }

    public static boolean a() {
        return b.a();
    }

    public static boolean a(Context context) {
        return b.a(context);
    }

    public static j<SignInAccountInfo> a(Intent intent) {
        return a(-2, intent);
    }

    public static j<SignInAccountInfo> a(int i2, Intent intent) {
        return b.a(i2, intent);
    }

    public static void a(Fragment fragment, int i2, SignInOptions signInOptions) {
        if (fragment != null && signInOptions != null) {
            if (k.a.a.a.b.b(signInOptions.f())) {
                fragment.startActivityForResult(a(fragment.getActivity(), signInOptions), i2);
                return;
            }
            throw new NullPointerException("ScopeList should not be null");
        }
        throw new NullPointerException("SignInOptions should not be null or fragment is null");
    }
}
