package com.hihonor.honorid.f;

/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public class b {
    public static boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null) ? str == null ? str2.trim().length() == 0 : str.trim().length() == 0 : str.equals(str2);
    }
}
