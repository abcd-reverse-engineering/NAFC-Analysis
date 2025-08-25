package util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import ui.Hicore;

/* compiled from: NetworkUtil.java */
/* loaded from: classes2.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f20945a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f20946b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f20947c = 1;

    /* renamed from: d, reason: collision with root package name */
    static String f20948d = "";

    /* renamed from: e, reason: collision with root package name */
    static int f20949e = 1;

    /* compiled from: NetworkUtil.java */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            try {
                q1.f20949e++;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://ip.ifcert.cn/").openConnection();
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36");
                if (httpURLConnection.getResponseCode() == 200) {
                    String line = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine();
                    if (TextUtils.isEmpty(line)) {
                        return;
                    }
                    q1.f20948d = line;
                    String str = "您的IP地址是：" + q1.f20948d;
                }
            } catch (Exception unused) {
                q1.f20948d = "";
            }
        }
    }

    public static String a() {
        int type;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || (type = activeNetworkInfo.getType()) == 1 || type != 0) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        int subtype = activeNetworkInfo.getSubtype();
        return subtype == 13 ? "4G" : (subtype != 3 || ((TelephonyManager) Hicore.getApp().getSystemService("phone")).isNetworkRoaming()) ? "5G" : "3G";
    }

    public static int b() {
        TelephonyManager telephonyManager = (TelephonyManager) Hicore.getApp().getSystemService("phone");
        int dbm = -1;
        if (ContextCompat.checkSelfPermission(Hicore.getApp(), util.permissionutil.a.f20914h) != 0) {
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (Build.VERSION.SDK_INT >= 17 && allCellInfo != null) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo instanceof CellInfoGsm) {
                        dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                        }
                    } else if (cellInfo instanceof CellInfoLte) {
                        dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    }
                }
            }
        }
        return dbm;
    }

    public static String c() {
        if (!TextUtils.isEmpty(f20948d)) {
            return f20948d;
        }
        if (f20949e > 5) {
            return "";
        }
        new Thread(new a()).start();
        return TextUtils.isEmpty(f20948d) ? l1.a() : f20948d;
    }

    public static int d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 0;
            }
        }
        return -1;
    }

    public static String e() {
        int type;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || (type = activeNetworkInfo.getType()) == 1 || type != 0) ? UtilityImpl.NET_TYPE_WIFI : activeNetworkInfo.getSubtypeName();
    }

    public static boolean f() {
        NetworkInfo activeNetworkInfo;
        if (Hicore.getApp() == null || (activeNetworkInfo = ((ConnectivityManager) Hicore.getApp().getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }
}
