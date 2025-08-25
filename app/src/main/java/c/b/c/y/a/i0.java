package c.b.c.y.a;

import java.util.regex.Pattern;
import ui.activity.BaseProgressUploadActivity;

/* compiled from: VINResultParser.java */
/* loaded from: classes.dex */
public final class i0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2959f = Pattern.compile("[IOQ]");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f2960g = Pattern.compile("[A-Z0-9]{17}");

    private static int b(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return 9 - i2;
        }
        if (i2 == 8) {
            return 10;
        }
        if (i2 == 9) {
            return 0;
        }
        if (i2 < 10 || i2 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i2;
    }

    private static int c(char c2) {
        if (c2 >= 'A' && c2 <= 'I') {
            return (c2 - 'A') + 1;
        }
        if (c2 >= 'J' && c2 <= 'R') {
            return (c2 - 'J') + 1;
        }
        if (c2 >= 'S' && c2 <= 'Z') {
            return (c2 - 'S') + 2;
        }
        if (c2 < '0' || c2 > '9') {
            throw new IllegalArgumentException();
        }
        return c2 - '0';
    }

    private static int b(char c2) {
        if (c2 >= 'E' && c2 <= 'H') {
            return (c2 - 'E') + 1984;
        }
        if (c2 >= 'J' && c2 <= 'N') {
            return (c2 - 'J') + 1988;
        }
        if (c2 == 'P') {
            return 1993;
        }
        if (c2 >= 'R' && c2 <= 'T') {
            return (c2 - 'R') + 1994;
        }
        if (c2 >= 'V' && c2 <= 'Y') {
            return (c2 - 'V') + 1997;
        }
        if (c2 >= '1' && c2 <= '9') {
            return (c2 - '1') + BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
        }
        if (c2 < 'A' || c2 > 'D') {
            throw new IllegalArgumentException();
        }
        return (c2 - 'A') + 2010;
    }

    @Override // c.b.c.y.a.u
    public h0 a(c.b.c.r rVar) {
        if (rVar.a() != c.b.c.a.CODE_39) {
            return null;
        }
        String strTrim = f2959f.matcher(rVar.e()).replaceAll("").trim();
        if (!f2960g.matcher(strTrim).matches()) {
            return null;
        }
        try {
            if (!a((CharSequence) strTrim)) {
                return null;
            }
            String strSubstring = strTrim.substring(0, 3);
            return new h0(strTrim, strSubstring, strTrim.substring(3, 9), strTrim.substring(9, 17), b((CharSequence) strSubstring), strTrim.substring(3, 8), b(strTrim.charAt(9)), strTrim.charAt(10), strTrim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String b(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        if (cCharAt == '9') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                return "BR";
            }
            if (cCharAt2 < '3' || cCharAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (cCharAt == 'S') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'M') {
                return "UK";
            }
            if (cCharAt2 < 'N' || cCharAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (cCharAt == 'Z') {
            if (cCharAt2 < 'A' || cCharAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (cCharAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (cCharAt2 < 'A' || cCharAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (cCharAt) {
                    case 'J':
                        if (cCharAt2 < 'A' || cCharAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (cCharAt2 < 'L' || cCharAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case 'L':
                        return "CN";
                    case 'M':
                        if (cCharAt2 < 'A' || cCharAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (cCharAt) {
                            case 'V':
                                if (cCharAt2 >= 'F' && cCharAt2 <= 'R') {
                                    return "FR";
                                }
                                if (cCharAt2 < 'S' || cCharAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case 'W':
                                return "DE";
                            case 'X':
                                if (cCharAt2 == '0') {
                                    return "RU";
                                }
                                if (cCharAt2 < '3' || cCharAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    private static boolean a(CharSequence charSequence) {
        int i2 = 0;
        int iB = 0;
        while (i2 < charSequence.length()) {
            int i3 = i2 + 1;
            iB += b(i3) * c(charSequence.charAt(i2));
            i2 = i3;
        }
        return charSequence.charAt(8) == a(iB % 11);
    }

    private static char a(int i2) {
        if (i2 < 10) {
            return (char) (i2 + 48);
        }
        if (i2 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }
}
