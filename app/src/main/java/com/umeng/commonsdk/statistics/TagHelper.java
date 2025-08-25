package com.umeng.commonsdk.statistics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TagHelper {
    private static Object lock = new Object();
    private static Map<String, String> moduleTags = new HashMap();

    public static void deleteModuleTag(String str) {
        synchronized (lock) {
            try {
                if (moduleTags.containsKey(str)) {
                    moduleTags.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, String> getModuleTags() {
        HashMap map = new HashMap();
        synchronized (lock) {
            try {
                if (moduleTags.size() > 0) {
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return map;
    }

    public static void setModuleTag(String str, String str2) {
        synchronized (lock) {
            if (moduleTags.size() >= 30) {
                return;
            }
            if (!moduleTags.containsKey(str)) {
                moduleTags.put(str, str2);
            }
        }
    }
}
