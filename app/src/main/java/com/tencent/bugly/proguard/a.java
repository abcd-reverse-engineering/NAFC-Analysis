package com.tencent.bugly.proguard;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.set(i2, a(arrayList.get(i2)));
        }
        Collections.reverse(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = arrayList.get(i3);
            if (str.equals("list")) {
                int i4 = i3 - 1;
                arrayList.set(i4, "<" + arrayList.get(i4));
                arrayList.set(0, arrayList.get(0) + ">");
            } else if (str.equals("map")) {
                int i5 = i3 - 1;
                arrayList.set(i5, "<" + arrayList.get(i5) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                StringBuilder sb = new StringBuilder();
                sb.append(arrayList.get(0));
                sb.append(">");
                arrayList.set(0, sb.toString());
            } else if (str.equals("Array")) {
                int i6 = i3 - 1;
                arrayList.set(i6, "<" + arrayList.get(i6));
                arrayList.set(0, arrayList.get(0) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (str.equals("java.lang.Integer") || str.equals("int")) {
            return "int32";
        }
        if (str.equals("java.lang.Boolean") || str.equals("boolean")) {
            return "bool";
        }
        if (str.equals("java.lang.Byte") || str.equals("byte")) {
            return "char";
        }
        String str2 = "double";
        if (!str.equals("java.lang.Double") && !str.equals("double")) {
            str2 = "float";
            if (!str.equals("java.lang.Float") && !str.equals("float")) {
                if (str.equals("java.lang.Long") || str.equals("long")) {
                    return "int64";
                }
                if (str.equals("java.lang.Short") || str.equals("short")) {
                    return "short";
                }
                if (str.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                return str.equals("java.lang.String") ? "string" : str.equals("java.util.List") ? "list" : str.equals("java.util.Map") ? "map" : str;
            }
        }
        return str2;
    }
}
