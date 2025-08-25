package com.luck.picture.lib.immersive;

import android.os.Build;
import android.text.TextUtils;
import c.c.a.b.a.a;
import com.luck.picture.lib.tools.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class RomUtils {
    private static Integer romType;

    public class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;
        public static final int NA = 4;

        public AvailableRomType() {
        }
    }

    public static int getFlymeVersion() {
        String strSubstring;
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme") || (strSubstring = str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(a.f3100g, "").substring(0, 1)) == null) {
            return 0;
        }
        return StringUtils.stringToInt(strSubstring);
    }

    public static int getLightStatausBarAvailableRomType() {
        Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            romType = 1;
            return romType.intValue();
        }
        if (isFlymeV4OrAbove()) {
            romType = 2;
            return romType.intValue();
        }
        if (isAndroid5OrAbove()) {
            romType = 3;
            return romType.intValue();
        }
        romType = 4;
        return romType.intValue();
    }

    public static int getMIUIVersionCode() throws Throwable {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return 0;
        }
        try {
            return Integer.parseInt(systemProperty);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getSystemProperty(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return line;
        } catch (IOException unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean isAndroid5OrAbove() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    private static boolean isMIUIV6OrAbove() throws Throwable {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            return Integer.parseInt(systemProperty) >= 4;
        } catch (Exception unused) {
            return false;
        }
    }
}
