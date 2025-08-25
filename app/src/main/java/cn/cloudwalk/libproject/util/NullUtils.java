package cn.cloudwalk.libproject.util;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public class NullUtils {
    public static Boolean isEmpty(String str) {
        return Boolean.valueOf(isNull(str).booleanValue() || str.trim().length() == 0);
    }

    public static Boolean isNotEmpty(String str) {
        return Boolean.valueOf(isNotNull(str).booleanValue() && str.trim().length() > 0);
    }

    public static Boolean isNotNull(Object obj) {
        return Boolean.valueOf(obj != null);
    }

    public static Boolean isNull(Object obj) {
        return Boolean.valueOf(obj == null);
    }

    public static Boolean isEmpty(Collection<?> collection) {
        return Boolean.valueOf(isNull(collection).booleanValue() || collection.size() == 0);
    }

    public static Boolean isNotEmpty(Collection<?> collection) {
        return Boolean.valueOf(isNotNull(collection).booleanValue() && collection.size() > 0);
    }

    public static Boolean isEmpty(Object[] objArr) {
        return Boolean.valueOf(isNull(objArr).booleanValue() || objArr.length == 0);
    }

    public static Boolean isNotEmpty(Object[] objArr) {
        return Boolean.valueOf(isNotNull(objArr).booleanValue() && objArr.length > 0);
    }

    public static Boolean isEmpty(Map<?, ?> map) {
        return Boolean.valueOf(isNull(map).booleanValue() || map.isEmpty());
    }

    public static Boolean isNotEmpty(byte[] bArr) {
        return Boolean.valueOf(bArr != null && bArr.length > 0);
    }

    public static Boolean isNotEmpty(Map<?, ?> map) {
        return Boolean.valueOf(isNotNull(map).booleanValue() && !map.isEmpty());
    }
}
