package i.a.a.a.m;

import java.util.Locale;

/* compiled from: SoundexUtils.java */
/* loaded from: classes2.dex */
final class j {
    j() {
    }

    static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (Character.isLetter(str.charAt(i3))) {
                cArr[i2] = str.charAt(i3);
                i2++;
            }
        }
        return i2 == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i2).toUpperCase(Locale.ENGLISH);
    }

    static int a(i.a.a.a.i iVar, String str, String str2) throws i.a.a.a.g {
        return a(iVar.a(str), iVar.a(str2));
    }

    static int a(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int iMin = Math.min(str.length(), str2.length());
        int i2 = 0;
        for (int i3 = 0; i3 < iMin; i3++) {
            if (str.charAt(i3) == str2.charAt(i3)) {
                i2++;
            }
        }
        return i2;
    }
}
