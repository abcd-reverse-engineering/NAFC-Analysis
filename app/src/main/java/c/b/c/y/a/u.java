package c.b.c.y.a;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ResultParser.java */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private static final u[] f2988a = {new f(), new c(), new j(), new b(), new f0(), new e(), new g0(), new i(), new y(), new a0(), new v(), new x(), new n(), new k0(), new e0(), new d0(), new p(), new t(), new l(), new i0()};

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f2989b = Pattern.compile("\\d+");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f2990c = Pattern.compile("&");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f2991d = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);

    /* renamed from: e, reason: collision with root package name */
    private static final String f2992e = "\ufeff";

    protected static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    protected static void a(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    protected static String[] a(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String b(c.b.c.r rVar) {
        String strE = rVar.e();
        return strE.startsWith(f2992e) ? strE.substring(1) : strE;
    }

    public static q c(c.b.c.r rVar) {
        for (u uVar : f2988a) {
            q qVarA = uVar.a(rVar);
            if (qVarA != null) {
                return qVarA;
            }
        }
        return new b0(rVar.e(), null);
    }

    static String d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public abstract q a(c.b.c.r rVar);

    protected static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }

    protected static boolean b(CharSequence charSequence, int i2) {
        return charSequence != null && i2 > 0 && i2 == charSequence.length() && f2989b.matcher(charSequence).matches();
    }

    protected static String c(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    static Map<String, String> b(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        HashMap map = new HashMap(3);
        for (String str2 : f2990c.split(str.substring(iIndexOf + 1))) {
            a(str2, map);
        }
        return map;
    }

    protected static boolean a(CharSequence charSequence, int i2, int i3) {
        int i4;
        return charSequence != null && i3 > 0 && charSequence.length() >= (i4 = i3 + i2) && f2989b.matcher(charSequence.subSequence(i2, i4)).matches();
    }

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] strArrSplit = f2991d.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], d(strArrSplit[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    static String b(String str, String str2, char c2, boolean z) {
        String[] strArrA = a(str, str2, c2, z);
        if (strArrA == null) {
            return null;
        }
        return strArrA[0];
    }

    static String[] a(String str, String str2, char c2, boolean z) {
        int length;
        int length2 = str2.length();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < length2; i2 = length) {
            int iIndexOf = str2.indexOf(str, i2);
            if (iIndexOf < 0) {
                break;
            }
            int length3 = iIndexOf + str.length();
            boolean z2 = true;
            length = length3;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length);
                if (iIndexOf2 < 0) {
                    length = str2.length();
                } else if (a(str2, iIndexOf2) % 2 != 0) {
                    length = iIndexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(3);
                    }
                    String strC = c(str2.substring(length3, iIndexOf2));
                    if (z) {
                        strC = strC.trim();
                    }
                    if (!strC.isEmpty()) {
                        arrayList.add(strC);
                    }
                    length = iIndexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static int a(CharSequence charSequence, int i2) {
        int i3 = 0;
        for (int i4 = i2 - 1; i4 >= 0 && charSequence.charAt(i4) == '\\'; i4--) {
            i3++;
        }
        return i3;
    }
}
