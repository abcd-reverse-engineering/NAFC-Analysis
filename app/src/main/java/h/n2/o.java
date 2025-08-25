package h.n2;

import h.e1;
import h.g2.y;
import h.g2.z;
import h.q2.t.i0;
import h.z2.c0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilePathComponents.kt */
/* loaded from: classes2.dex */
class o {
    private static final int a(@i.c.a.d String str) {
        int iA;
        int iA2 = c0.a((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (iA2 != 0) {
            if (iA2 > 0 && str.charAt(iA2 - 1) == ':') {
                return iA2 + 1;
            }
            if (iA2 == -1 && c0.b((CharSequence) str, ':', false, 2, (Object) null)) {
                return str.length();
            }
            return 0;
        }
        if (str.length() > 1) {
            char cCharAt = str.charAt(1);
            char c2 = File.separatorChar;
            if (cCharAt == c2 && (iA = c0.a((CharSequence) str, c2, 2, false, 4, (Object) null)) >= 0) {
                int iA3 = c0.a((CharSequence) str, File.separatorChar, iA + 1, false, 4, (Object) null);
                return iA3 >= 0 ? iA3 + 1 : str.length();
            }
        }
        return 1;
    }

    @i.c.a.d
    public static final String b(@i.c.a.d File file) {
        i0.f(file, "$this$rootName");
        String path = file.getPath();
        i0.a((Object) path, "path");
        String path2 = file.getPath();
        i0.a((Object) path2, "path");
        int iA = a(path2);
        if (path == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = path.substring(0, iA);
        i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean c(@i.c.a.d File file) {
        i0.f(file, "$this$isRooted");
        String path = file.getPath();
        i0.a((Object) path, "path");
        return a(path) > 0;
    }

    @i.c.a.d
    public static final i d(@i.c.a.d File file) {
        List listB;
        i0.f(file, "$this$toComponents");
        String path = file.getPath();
        i0.a((Object) path, "path");
        int iA = a(path);
        String strSubstring = path.substring(0, iA);
        i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = path.substring(iA);
        i0.a((Object) strSubstring2, "(this as java.lang.String).substring(startIndex)");
        if (strSubstring2.length() == 0) {
            listB = y.b();
        } else {
            List listA = c0.a((CharSequence) strSubstring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(z.a(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listB = arrayList;
        }
        return new i(new File(strSubstring), listB);
    }

    @i.c.a.d
    public static final File a(@i.c.a.d File file) {
        i0.f(file, "$this$root");
        return new File(b(file));
    }

    @i.c.a.d
    public static final File a(@i.c.a.d File file, int i2, int i3) {
        i0.f(file, "$this$subPath");
        return d(file).a(i2, i3);
    }
}
