package util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.taobao.accs.utl.UtilityImpl;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ui.Hicore;

/* compiled from: IpGetUtil.java */
/* loaded from: classes2.dex */
public class l1 {
    public static String a() throws SocketException {
        Hicore app = Hicore.getApp();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) app.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "当前无网络连接";
        }
        if (activeNetworkInfo.getType() != 0) {
            return activeNetworkInfo.getType() == 1 ? a(((WifiManager) app.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getIpAddress()) : "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }
}
