package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6438a;

    private static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    c(Context context) {
        this.f6438a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) throws ClassNotFoundException {
        StringBuilder sb;
        String localizedMessage;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            String str2 = cls + " must extends from ServiceRegistrar.";
            return null;
        } catch (ClassNotFoundException e2) {
            String str3 = "Can not found service class, " + e2.getMessage();
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        } catch (InstantiationException e4) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e4.getLocalizedMessage();
            sb.append(localizedMessage);
            sb.toString();
            return null;
        }
    }

    private List<String> b() throws PackageManager.NameNotFoundException {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle bundleC = c();
        if (bundleC == null) {
            return arrayList;
        }
        HashMap map = new HashMap(10);
        for (String message : bundleC.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(bundleC.getString(message))) {
                String[] strArrSplit = message.split(Constants.COLON_SEPARATOR);
                if (strArrSplit.length == 2) {
                    try {
                        map.put(strArrSplit[0], Integer.valueOf(strArrSplit[1]));
                    } catch (NumberFormatException e2) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        message = e2.getMessage();
                    }
                } else if (strArrSplit.length == 1) {
                    map.put(strArrSplit[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(message);
                    sb.toString();
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(map.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    private Bundle c() throws PackageManager.NameNotFoundException {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f6438a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f6438a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            String str = "get ServiceDiscovery exception." + e2.getLocalizedMessage();
        }
        if (serviceInfo == null) {
            return null;
        }
        return serviceInfo.metaData;
    }

    public List<Service> a() throws PackageManager.NameNotFoundException, ClassNotFoundException {
        List<String> listB = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listB.iterator();
        while (it.hasNext()) {
            ServiceRegistrar serviceRegistrarA = a(it.next());
            if (serviceRegistrarA != null) {
                serviceRegistrarA.initialize(this.f6438a);
                List<Service> services = serviceRegistrarA.getServices(this.f6438a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        String str = "services:" + arrayList.size();
        return arrayList;
    }
}
