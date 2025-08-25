package c.c.a.c.a.b;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c.c.a.d.j;
import c.c.a.d.k;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.client.Status;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.honor.openSdk.R;
import com.huawei.hms.android.SystemUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k.a.a.a.d;
import k.a.a.a.g;
import k.a.a.a.j.e;
import org.json.JSONObject;

/* compiled from: AccountAuthUtil.java */
/* loaded from: classes.dex */
public class b {
    public static Intent b(Context context, SignInOptions signInOptions) {
        if (context == null) {
            return null;
        }
        e.a(context);
        e.b("AccountAuthUtil", "getSignInIntent", true);
        if (g.c(context, 60000000)) {
            if (TextUtils.equals(g.b(context, k.a.a.a.e.a(context).a()), context.getString(R.string.apk_raw_finger))) {
                if (!c(context)) {
                    return null;
                }
            } else if (g.a(context, 60300360)) {
                e.b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (g.c(context)) {
            if (g.a(context, 60300360)) {
                e.b("AccountAuthUtil", "HonorAPK version is too low", true);
                return null;
            }
        } else if (!c(context)) {
            return null;
        }
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114522, 100, "getSignInIntent entry", strC, "api_entry");
        k.a.a.a.a.a(context, "AccountAuthUtil : Null context is not permitted.");
        String packageName = context.getPackageName();
        if (!TextUtils.equals(packageName, com.hihonor.honorid.f.a.d(context))) {
            e.b("AccountAuthUtil", "packageName is not equals current's!", true);
            b(context, 907114522, 100, "packageName is not equals current's!", strC, "api_ret");
            return null;
        }
        String strB = signInOptions.b();
        k.a.a.a.a.a(strB, "AccountAuthUtil : Null clientId is not permitted.");
        Intent intent = new Intent();
        intent.setAction(c.c.a.b.a.a.w0);
        intent.setPackage("com.hihonor.id");
        intent.putExtra(Constants.PARAM_CLIENT_ID, strB);
        intent.putExtra(Constants.PARAM_SCOPE, d.a(signInOptions.f()));
        intent.putExtra("loginChannel", signInOptions.c());
        intent.putExtra(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, packageName);
        intent.putExtra("requireAuthCode", signInOptions.l());
        intent.putExtra("requireToken", signInOptions.m());
        intent.putExtra("callType", "openSDK");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, int i2, int i3, String str, String str2, String str3) {
    }

    private static boolean c(Context context) {
        if (!g.a(context, 50120345) && ((!g.b(context, 60100316) || !g.c(context, 60100318)) && ((!g.b(context, 60100301) || !g.c(context, 60100303)) && g.b(context) != 60130300))) {
            return true;
        }
        e.b("AccountAuthUtil", "HonorAPK version is too low", true);
        return false;
    }

    public static j<SignInAccountInfo> d(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "silentSignIn start!", true);
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114521, 100, "silentSignIn entry", strC, "api_entry");
        k kVar = new k();
        if (!com.hihonor.honorid.f.a.a(context)) {
            e.a("AccountAuthUtil", "HonorAccount is not install", true);
            b(context, 907114521, 102, "HonorAccount is not install!", strC, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(34, "HonorAccount is not install")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", strC, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        if (TextUtils.isEmpty(signInOptions.b())) {
            e.a("AccountAuthUtil", "clientid is null", true);
            b(context, 907114521, 104, "clientid is null", strC, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "clientid is null")));
            return kVar.a();
        }
        k.a.a.c.a.a aVarA = k.a.a.c.a.a.a(context);
        if (aVarA == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, 907114521, 106, "manager is null", strC, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        Bundle bundleA = c.c.a.c.a.b.a.a(signInOptions);
        bundleA.putString("transid", strC);
        bundleA.putBoolean("silentSignIn", true);
        bundleA.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        bundleA.putString("callType", "openSDK");
        aVarA.a(new c.c.a.a.e.b(context, context.getPackageName(), bundleA, new a(context, strC, kVar)));
        return kVar.a();
    }

    /* compiled from: AccountAuthUtil.java */
    class a implements c.c.a.a.d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3119a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3120b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f3121c;

        a(Context context, String str, k kVar) {
            this.f3119a = context;
            this.f3120b = str;
            this.f3121c = kVar;
        }

        @Override // c.c.a.a.d.a
        public void a(ErrorStatus errorStatus) {
            b.b(this.f3119a, 907114521, -1, "request network fail", this.f3120b, "api_ret");
            this.f3121c.a((Exception) new c.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
        }

        @Override // c.c.a.a.d.a
        public void a(HonorAccount honorAccount) {
            b.b(this.f3119a, 907114521, 0, "request network success", this.f3120b, "_success");
            if (honorAccount != null) {
                this.f3121c.a((k) c.c.a.c.a.b.a.a(honorAccount));
            }
        }
    }

    /* compiled from: AccountAuthUtil.java */
    class c implements c.c.a.a.d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3127a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3128b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f3129c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f3130d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f3131e;

        c(Context context, String str, CountDownLatch countDownLatch, List list, AtomicBoolean atomicBoolean) {
            this.f3127a = context;
            this.f3128b = str;
            this.f3129c = countDownLatch;
            this.f3130d = list;
            this.f3131e = atomicBoolean;
        }

        @Override // c.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "checkIsContainScopes onFail : " + errorStatus.b(), true);
            this.f3129c.countDown();
        }

        @Override // c.c.a.a.d.b
        public void a(Bundle bundle) {
            b.b(this.f3127a, 907114518, 0, "checkIsContainScopes req success", this.f3128b, "api_ret");
            String string = bundle.getString(Constants.PARAM_SCOPE);
            if (TextUtils.isEmpty(string)) {
                e.b("AccountAuthUtil", "authOperationResult : strScope is null", true);
                this.f3129c.countDown();
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                for (String str : new JSONObject(string).getString(Constants.PARAM_SCOPE).replace("[", "").replace("]", "").replace(c.c.a.b.a.a.f3100g, "").split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new Scope(str));
                    }
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "authOperationResult json exception", true);
                e2.printStackTrace();
            }
            if (arrayList.containsAll(this.f3130d)) {
                this.f3131e.set(true);
            }
            this.f3129c.countDown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[PHI: r4
  0x00d5: PHI (r4v4 java.lang.String) = (r4v0 java.lang.String), (r4v9 java.lang.String) binds: [B:36:0x00cd, B:19:0x006b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static c.c.a.d.j<com.hihonor.cloudservice.support.account.result.SignInAccountInfo> a(int r7, android.content.Intent r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getSignInResultFromIntent : resultCode"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r1 = 1
            java.lang.String r2 = "AccountAuthUtil"
            k.a.a.a.j.e.b(r2, r0, r1)
            c.c.a.d.k r0 = new c.c.a.d.k
            r0.<init>()
            r3 = 67
            java.lang.String r4 = "intent is null"
            if (r8 == 0) goto Lbb
            r5 = -2
            if (r5 == r7) goto L80
            r5 = -1
            if (r5 != r7) goto L29
            goto L80
        L29:
            r5 = 57
            if (r5 != r7) goto L31
            java.lang.String r4 = "mcp check fail"
            goto Ld7
        L31:
            r5 = 56
            if (r5 != r7) goto L75
            android.os.Bundle r7 = r8.getExtras()
            if (r7 == 0) goto L4b
            java.lang.String r8 = "err_code"
            int r8 = r7.getInt(r8, r5)
            java.lang.String r4 = "server_err_desc"
            java.lang.String r5 = "access server return error"
            java.lang.String r4 = r7.getString(r4, r5)
            r7 = r8
            goto L4d
        L4b:
            r7 = 56
        L4d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r5 = "loginResult : errCode = "
            r8.append(r5)
            r8.append(r7)
            java.lang.String r5 = " errMsg = "
            r8.append(r5)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            k.a.a.a.j.e.a(r2, r8, r1)
            r8 = 1101(0x44d, float:1.543E-42)
            if (r8 != r7) goto L6e
            goto Ld5
        L6e:
            r8 = 1202(0x4b2, float:1.684E-42)
            if (r8 != r7) goto Ld7
            r7 = 68
            goto Ld7
        L75:
            r8 = 2005(0x7d5, float:2.81E-42)
            if (r8 != r7) goto L7d
            r7 = 5
            java.lang.String r4 = "network unaviable!"
            goto Ld7
        L7d:
            java.lang.String r4 = "other error!"
            goto Ld7
        L80:
            android.os.Bundle r7 = r8.getExtras()
            com.hihonor.honorid.core.data.HonorAccount r8 = new com.hihonor.honorid.core.data.HonorAccount
            r8.<init>()
            com.hihonor.honorid.core.data.HonorAccount r7 = r8.a(r7)
            com.hihonor.honorid.a r8 = com.hihonor.honorid.a.c()
            android.content.Context r8 = r8.a()
            com.hihonor.honorid.h.a r8 = com.hihonor.honorid.h.a.a(r8)
            r8.a(r7)
            java.lang.String r1 = r7.m()
            java.lang.String r4 = r7.n()
            java.lang.String r5 = r7.v()
            java.lang.String r6 = r7.i()
            r3 = 0
            java.lang.String r2 = ""
            com.hihonor.cloudservice.support.account.result.SignInAccountInfo r7 = com.hihonor.cloudservice.support.account.result.SignInAccountInfo.a(r1, r2, r3, r4, r5, r6)
            r0.a(r7)
            c.c.a.d.j r7 = r0.a()
            return r7
        Lbb:
            r8 = 2
            if (r7 != r8) goto Lc3
            r7 = 30
            java.lang.String r4 = "serviceToken invalid!"
            goto Ld7
        Lc3:
            if (r7 != 0) goto Lcb
            r7 = 3002(0xbba, float:4.207E-42)
            java.lang.String r4 = "user cancel login!"
            goto Ld7
        Lcb:
            r8 = 2012(0x7dc, float:2.82E-42)
            if (r8 != r7) goto Ld5
            r7 = 70
            java.lang.String r4 = "user cancel auth!"
            goto Ld7
        Ld5:
            r7 = 67
        Ld7:
            com.hihonor.cloudservice.support.api.client.Status r8 = new com.hihonor.cloudservice.support.api.client.Status
            r8.<init>(r7, r4)
            c.c.a.a.a r7 = new c.c.a.a.a
            r7.<init>(r8)
            r0.a(r7)
            c.c.a.d.j r7 = r0.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.c.a.b.b.a(int, android.content.Intent):c.c.a.d.j");
    }

    /* compiled from: AccountAuthUtil.java */
    /* renamed from: c.c.a.c.a.b.b$b, reason: collision with other inner class name */
    class C0040b implements c.c.a.a.d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3122a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f3123b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3124c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3125d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f3126e;

        C0040b(String str, Context context, int i2, String str2, k kVar) {
            this.f3122a = str;
            this.f3123b = context;
            this.f3124c = i2;
            this.f3125d = str2;
            this.f3126e = kVar;
        }

        @Override // c.c.a.a.d.b
        public void a(ErrorStatus errorStatus) {
            e.a("AccountAuthUtil", "authOperation : onFail call opType:" + this.f3122a, true);
            b.b(this.f3123b, this.f3124c, -1, "authOperation req fail", this.f3125d, "api_ret");
            this.f3126e.a((Exception) new c.c.a.a.a(new Status(errorStatus.a(), errorStatus.b())));
            e.a("AccountAuthUtil", "call opType:" + this.f3122a + " error:" + errorStatus.a(), true);
        }

        @Override // c.c.a.a.d.b
        public void a(Bundle bundle) {
            e.a("AccountAuthUtil", "authOperation : onSuccess call opType:" + this.f3122a, true);
            b.b(this.f3123b, this.f3124c, 0, "authOperation req success", this.f3125d, "api_ret");
            this.f3126e.a((k) null);
        }
    }

    public static j<Void> c(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "logout start!", true);
        return a(context, signInOptions, 907114520, "logout entry", com.hihonor.honorid.f.a.c(context), "honorid.signout");
    }

    public static j<Void> a(Context context, SignInOptions signInOptions, int i2, String str, String str2, String str3) {
        e.b("AccountAuthUtil", "authOperation : opType = " + str3, true);
        b(context, i2, 100, str, str2, "api_entry");
        k kVar = new k();
        if (context == null) {
            e.b("AccountAuthUtil", "getAccountsByType: context is null", true);
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "getAccountsByType: context is null!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.b(context)) {
            e.b("AccountAuthUtil", "can not use honor id", true);
            b(context, i2, 105, "can not use honor id", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(33, "can not use honor id!")));
            return kVar.a();
        }
        if (!g.a(context)) {
            e.b("AccountAuthUtil", "honor id is not exit", true);
            b(context, i2, 102, "honor id is not exit", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(34, "honor id is not exit!")));
            return kVar.a();
        }
        if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.HonorInvokeService")) {
            e.a("AccountAuthUtil", "HonorAPK version is too low", true);
            b(context, 907114521, 103, "HonorAPK version is too low", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(35, "HonorAPK version is too low")));
            return kVar.a();
        }
        k.a.a.c.a.a aVarA = k.a.a.c.a.a.a(context);
        if (aVarA == null) {
            e.a("AccountAuthUtil", "manager is null", true);
            b(context, i2, 106, "manager is null", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(40, "manager is null!")));
            return kVar.a();
        }
        String strB = com.hihonor.honorid.h.a.a(context).b();
        if (TextUtils.isEmpty(strB) && !"honorid.revokeaccess".equals(str3)) {
            e.a("AccountAuthUtil", "userId is null", true);
            b(context, i2, 106, "userId is null", str2, "api_ret");
            kVar.a((Exception) new c.c.a.a.a(new Status(12, "userId is null!")));
            return kVar.a();
        }
        Bundle bundle = new Bundle();
        bundle.putString("app_id", signInOptions.b());
        bundle.putString("access_token", signInOptions.a());
        bundle.putString("uid", strB);
        bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
        aVarA.a(new c.c.a.a.e.a(context, bundle, str3, new C0040b(str3, context, i2, str2, kVar)));
        return kVar.a();
    }

    public static boolean b(Context context) {
        return g.c(context, 60001301);
    }

    public static j<Void> a(Context context, SignInOptions signInOptions) {
        e.b("AccountAuthUtil", "cancelAuthorization start!", true);
        return a(context, signInOptions, 907114519, "cancelAuthorization entry", com.hihonor.honorid.f.a.c(context), "honorid.revokeaccess");
    }

    public static boolean a(Context context, SignInAccountInfo signInAccountInfo, List<Scope> list) {
        e.b("AccountAuthUtil", "checkIsContainScopes start!", true);
        String strC = com.hihonor.honorid.f.a.c(context);
        b(context, 907114518, 100, "checkIsContainScopes entry", strC, "api_entry");
        if (signInAccountInfo == null) {
            e.b("AccountAuthUtil", "checkIsContainScopes signInAccountInfo is null", true);
            return false;
        }
        if (list != null && list.size() > 0) {
            String strB = com.hihonor.honorid.h.a.a(context).b();
            if (TextUtils.isEmpty(strB)) {
                e.a("AccountAuthUtil", "checkIsContainScopes : userId is null", true);
                return false;
            }
            k.a.a.c.a.a aVarA = k.a.a.c.a.a.a(context);
            if (!com.hihonor.honorid.f.a.a(context, "com.hihonor.id.ICloudService")) {
                e.b("AccountAuthUtil", "has no service: com.hihonor.id.ICloudService", true);
                return false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", signInAccountInfo.a());
            bundle.putString("uid", strB);
            bundle.putString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME, context.getPackageName());
            aVarA.a(new c.c.a.a.e.a(context, bundle, "honorid.getScope", new c(context, strC, countDownLatch, list, atomicBoolean)));
            try {
                if (!countDownLatch.await(com.heytap.mcssdk.constant.a.r, TimeUnit.MILLISECONDS)) {
                    return false;
                }
            } catch (Exception e2) {
                e.b("AccountAuthUtil", "checkIsContainScopes await error ： " + e2.getMessage(), true);
            }
            return atomicBoolean.get();
        }
        e.b("AccountAuthUtil", "checkIsContainScopes scopeList is null or size <= 0", true);
        return false;
    }

    public static boolean a(Context context) {
        boolean z;
        e.b("AccountAuthUtil", "isAccountAlreadyLogin", true);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse(c.c.a.b.a.a.w1), null, null, null, null);
                if (cursorQuery == null) {
                    e.a("AccountAuthUtil", "isAccountAlreadyLogin cursor is null.", true);
                }
                loop0: while (true) {
                    z = false;
                    while (cursorQuery != null) {
                        try {
                            if (!cursorQuery.moveToNext()) {
                                break loop0;
                            }
                            int columnIndex = cursorQuery.getColumnIndex("hasLogin");
                            if (columnIndex == -1) {
                                e.b("AccountAuthUtil", "isAccountAlreadyLogin index -1", true);
                            } else if (1 == cursorQuery.getInt(columnIndex)) {
                                z = true;
                            }
                        } catch (SQLException unused) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin SQLException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (IllegalArgumentException unused2) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin IllegalArgumentException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (SecurityException unused3) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin SecurityException.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        } catch (Throwable unused4) {
                            e.b("AccountAuthUtil", "isAccountAlreadyLogin Throwable.", true);
                            if (cursorQuery != null) {
                            }
                            e.b("AccountAuthUtil", "account state :" + z, true);
                            return z;
                        }
                    }
                }
            } catch (SQLException unused5) {
                z = false;
            } catch (IllegalArgumentException unused6) {
                z = false;
            } catch (SecurityException unused7) {
                z = false;
            } catch (Throwable unused8) {
                z = false;
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static boolean a() {
        try {
            return TextUtils.equals(Build.MANUFACTURER, SystemUtils.PRODUCT_HONOR);
        } catch (Exception unused) {
            return false;
        }
    }
}
