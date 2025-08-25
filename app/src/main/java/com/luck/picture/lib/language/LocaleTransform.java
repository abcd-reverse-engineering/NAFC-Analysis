package com.luck.picture.lib.language;

import java.util.Locale;

/* loaded from: classes.dex */
public class LocaleTransform {
    public static Locale getLanguage(int i2) {
        switch (i2) {
            case 1:
                return Locale.TRADITIONAL_CHINESE;
            case 2:
                return Locale.ENGLISH;
            case 3:
                return Locale.KOREA;
            case 4:
                return Locale.GERMANY;
            case 5:
                return Locale.FRANCE;
            case 6:
                return Locale.JAPAN;
            case 7:
                return new Locale("vi");
            default:
                return Locale.CHINESE;
        }
    }
}
