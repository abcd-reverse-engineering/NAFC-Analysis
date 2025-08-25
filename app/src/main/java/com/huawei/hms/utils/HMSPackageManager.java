package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import anet.channel.util.HttpConstant;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class HMSPackageManager {
    private static HMSPackageManager o;
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final Map<String, String> s;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7373a;

    /* renamed from: b, reason: collision with root package name */
    private final PackageManagerHelper f7374b;

    /* renamed from: c, reason: collision with root package name */
    private String f7375c;

    /* renamed from: d, reason: collision with root package name */
    private String f7376d;

    /* renamed from: e, reason: collision with root package name */
    private int f7377e;

    /* renamed from: f, reason: collision with root package name */
    private String f7378f;

    /* renamed from: g, reason: collision with root package name */
    private String f7379g;

    /* renamed from: h, reason: collision with root package name */
    private String f7380h;

    /* renamed from: i, reason: collision with root package name */
    private String f7381i;

    /* renamed from: j, reason: collision with root package name */
    private int f7382j;

    /* renamed from: k, reason: collision with root package name */
    private int f7383k;

    /* renamed from: l, reason: collision with root package name */
    private long f7384l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7385m;
    private int n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a, reason: collision with root package name */
        private String f7386a;

        /* renamed from: b, reason: collision with root package name */
        private String f7387b;

        /* renamed from: c, reason: collision with root package name */
        private String f7388c;

        /* renamed from: d, reason: collision with root package name */
        private String f7389d;

        /* renamed from: e, reason: collision with root package name */
        private String f7390e;

        /* renamed from: f, reason: collision with root package name */
        private Long f7391f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j2) {
            this.f7386a = str;
            this.f7387b = str2;
            this.f7388c = str3;
            this.f7389d = str4;
            this.f7390e = str5;
            this.f7391f = Long.valueOf(j2);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            return TextUtils.equals(this.f7390e, packagePriorityInfo.f7390e) ? this.f7391f.compareTo(packagePriorityInfo.f7391f) : this.f7390e.compareTo(packagePriorityInfo.f7390e);
        }
    }

    class a implements Comparator<ResolveInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.s.containsKey(str) && HMSPackageManager.s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.s.containsKey(str2) ? 1 : 0;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> listQueryIntentServices = HMSPackageManager.this.f7373a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                    return;
                }
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.d();
                    }
                }
                HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e2) {
                HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e2.getMessage());
            }
        }
    }

    static {
        HashMap map = new HashMap();
        s = map;
        map.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        map.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f7373a = context;
        this.f7374b = new PackageManagerHelper(context);
    }

    private boolean c(String str, String str2) {
        return Objects.equals(str2, this.f7374b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f7374b.getPackageSignature(str));
    }

    private Pair<String, String> d(String str, String str2) {
        if (!s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.n = 3;
        return new Pair<>(str, str2);
    }

    private void e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f7373a, str) || Build.VERSION.SDK_INT < 28 || b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    private void f() {
        synchronized (q) {
            this.f7375c = null;
            this.f7376d = null;
            this.f7377e = 0;
        }
    }

    private Pair<String, String> g() throws PackageManager.NameNotFoundException {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f7373a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            a(listQueryIntentServices);
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.f7374b.getPackageSigningCertificate(str);
                String packageSignature = this.f7374b.getPackageSignature(str);
                Pair<String, String> pairD = d(str, packageSigningCertificate);
                if (pairD != null) {
                    HMSLog.i("HMSPackageManager", "signature V3 check success");
                    return pairD;
                }
                Pair<String, String> pairA = a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (pairA != null) {
                    HMSLog.i("HMSPackageManager", "DSS signature check success");
                    return pairA;
                }
                Pair<String, String> pairA2 = a(str, packageSignature);
                if (pairA2 != null) {
                    HMSLog.i("HMSPackageManager", "signature V2 check success");
                    return pairA2;
                }
            }
            return null;
        } catch (Exception e2) {
            HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e2.getMessage());
            return null;
        }
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (p) {
            if (o == null && context != null) {
                if (context.getApplicationContext() != null) {
                    o = new HMSPackageManager(context.getApplicationContext());
                } else {
                    o = new HMSPackageManager(context);
                }
                o.k();
                o.b();
            }
        }
        return o;
    }

    private Pair<String, String> h() throws PackageManager.NameNotFoundException {
        Pair<String, String> pairG = g();
        if (pairG != null) {
            HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) pairG.first));
            this.f7380h = "com.huawei.hms.core.aidlservice";
            this.f7381i = null;
            return pairG;
        }
        ArrayList<PackagePriorityInfo> arrayListI = i();
        if (arrayListI == null) {
            HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it = arrayListI.iterator();
        while (it.hasNext()) {
            PackagePriorityInfo next = it.next();
            String str = next.f7386a;
            String str2 = next.f7387b;
            String str3 = next.f7388c;
            String str4 = next.f7389d;
            String packageSignature = this.f7374b.getPackageSignature(str);
            if (a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                HMSLog.i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f7391f);
                this.f7380h = PackageConstants.GENERAL_SERVICES_ACTION;
                d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    private ArrayList<PackagePriorityInfo> i() throws PackageManager.NameNotFoundException {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f7373a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.f7374b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String strA = a(bundle, "hms_app_checker_config");
                    String strA2 = a(strA);
                    if (TextUtils.isEmpty(strA2)) {
                        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + strA);
                    } else {
                        String strA3 = a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(strA3)) {
                            HMSLog.i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String strA4 = a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(strA4)) {
                                HMSLog.i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.i("HMSPackageManager", "add: " + str + ", " + strA + ", " + packageFirstInstallTime);
                                arrayList.add(new PackagePriorityInfo(str, strA, strA3, strA4, strA2, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e2) {
            HMSLog.e("HMSPackageManager", "query aglite action failed. " + e2.getMessage());
            return null;
        }
    }

    private void j() {
        synchronized (q) {
            Pair<String, String> pairG = g();
            if (pairG == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                f();
                return;
            }
            String str = (String) pairG.first;
            this.f7375c = str;
            this.f7376d = (String) pairG.second;
            this.f7377e = this.f7374b.getPackageVersionCode(str);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f7375c + " version: " + this.f7377e);
        }
    }

    private void k() {
        synchronized (q) {
            Pair<String, String> pairH = h();
            if (pairH == null) {
                HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                e();
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                return;
            }
            this.f7378f = (String) pairH.first;
            this.f7379g = (String) pairH.second;
            this.f7382j = this.f7374b.getPackageVersionCode(getHMSPackageNameForMultiService());
            e(this.f7378f);
            HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f7378f + " version: " + this.f7382j);
        }
    }

    private boolean l() {
        Bundle bundle;
        PackageManager packageManager = this.f7373a.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e2) {
            HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e2);
        }
        if (!TextUtils.isEmpty(this.f7380h) && (this.f7380h.equals(PackageConstants.GENERAL_SERVICES_ACTION) || this.f7380h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            HMSLog.i("HMSPackageManager", "action = " + this.f7380h + " exist");
            return false;
        }
        ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
            HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");
            return false;
        }
        return true;
    }

    public String getHMSFingerprint() {
        String str = this.f7376d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f7375c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f7374b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                j();
            }
            String str2 = this.f7375c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f7378f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f7374b.getPackageStates(str))) {
                HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                k();
            }
            String str2 = this.f7378f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (p) {
            refresh();
            PackageManagerHelper.PackageStates packageStates = this.f7374b.getPackageStates(this.f7375c);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                f();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f7375c) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f7375c, this.f7376d)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (p) {
            refreshForMultiService();
            PackageManagerHelper.PackageStates packageStates = this.f7374b.getPackageStates(this.f7378f);
            PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
            if (packageStates == packageStates2) {
                e();
                return packageStates2;
            }
            boolean z = false;
            if ("com.huawei.hwid".equals(this.f7378f) && d() == 1) {
                return PackageManagerHelper.PackageStates.SPOOF;
            }
            if (packageStates == PackageManagerHelper.PackageStates.ENABLED && !c(this.f7378f, this.f7379g)) {
                z = true;
            }
            return z ? packageStates2 : packageStates;
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f7374b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f7374b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f7380h) ? this.f7380h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i2) throws PackageManager.NameNotFoundException {
        if (this.f7377e >= i2 || !l()) {
            return true;
        }
        int packageVersionCode = this.f7374b.getPackageVersionCode(getHMSPackageName());
        this.f7377e = packageVersionCode;
        return packageVersionCode >= i2;
    }

    public boolean isApkNeedUpdate(int i2) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i2);
        return hmsVersionCode < i2;
    }

    public boolean isApkUpdateNecessary(int i2) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i2);
        return l() && hmsVersionCode < i2;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f7378f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f7385m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f7375c) || TextUtils.isEmpty(this.f7376d)) {
            j();
        }
        c(this.f7375c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f7378f) || TextUtils.isEmpty(this.f7379g)) {
            k();
        }
        c(this.f7378f);
    }

    public void resetMultiServiceState() {
        e();
    }

    public void setUseOldCertificate(boolean z) {
        this.f7385m = z;
    }

    private boolean b(String str) {
        return !"com.huawei.hwid".equals(str) || this.n == 3;
    }

    private void a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new a());
    }

    private boolean b(String str, String str2) {
        Map<String, String> map = s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    private void c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f7374b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    private Pair<String, String> a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.n = 2;
        if (a(bundle, str, str2)) {
            HMSLog.i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!a(str + "&" + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.n = 3;
        }
        return new Pair<>(str, str3);
    }

    private void b() {
        new Thread(new b(), "Thread-asyncOnceCheckMDMState").start();
    }

    private void d(String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.f7381i = strA.substring(9);
    }

    private void e() {
        synchronized (q) {
            this.f7378f = null;
            this.f7379g = null;
            this.f7380h = null;
            this.f7381i = null;
            this.f7382j = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        synchronized (r) {
            HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");
            if (!(this.f7383k == 3 || this.f7384l != this.f7374b.getPackageFirstInstallTime("com.huawei.hwid"))) {
                HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.f7383k));
                return this.f7383k;
            }
            this.f7383k = c() ? 2 : 1;
            this.f7384l = this.f7374b.getPackageFirstInstallTime("com.huawei.hwid");
            HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.f7383k));
            return this.f7383k;
        }
    }

    private boolean c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f7373a);
        if (hmsPath == null) {
            HMSLog.i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    private Pair<String, String> a(String str, String str2) {
        if (b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.w("HMSPackageManager", "check sign fail: " + str + c.c.a.b.a.a.s1 + str2);
        return null;
    }

    private boolean a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !b(str, str2) && Build.VERSION.SDK_INT >= 28;
    }

    private String a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("priority=");
        if (iIndexOf == -1) {
            HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int iIndexOf2 = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    private boolean a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> listB = com.huawei.hms.device.a.b(str3);
            if (listB.size() == 0) {
                HMSLog.e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f7373a), listB)) {
                HMSLog.e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            X509Certificate x509Certificate = listB.get(listB.size() - 1);
            if (!com.huawei.hms.device.a.a(x509Certificate, "Huawei CBG HMS")) {
                HMSLog.e("HMSPackageManager", "CN is invalid");
                return false;
            }
            if (!com.huawei.hms.device.a.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                HMSLog.e("HMSPackageManager", "OU is invalid");
                return false;
            }
            if (com.huawei.hms.device.a.a(x509Certificate, str, str2)) {
                return true;
            }
            HMSLog.e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    }

    private static String a(int i2) {
        if (i2 == 1) {
            return "SPOOFED";
        }
        if (i2 == 2) {
            return HttpConstant.SUCCESS;
        }
        if (i2 == 3) {
            return "UNCHECKED";
        }
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + i2);
        return "";
    }
}
