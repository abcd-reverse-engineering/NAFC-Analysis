package i.a.a.a.m.k;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import i.a.a.a.m.k.c;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* compiled from: Rule.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: f, reason: collision with root package name */
    public static final String f16837f = "ALL";

    /* renamed from: g, reason: collision with root package name */
    private static final String f16838g = "\"";

    /* renamed from: h, reason: collision with root package name */
    private static final String f16839h = "#include";

    /* renamed from: a, reason: collision with root package name */
    private final n f16841a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16842b;

    /* renamed from: c, reason: collision with root package name */
    private final l f16843c;

    /* renamed from: d, reason: collision with root package name */
    private final n f16844d;

    /* renamed from: e, reason: collision with root package name */
    public static final n f16836e = new b();

    /* renamed from: i, reason: collision with root package name */
    private static final Map<i.a.a.a.m.k.d, Map<i.a.a.a.m.k.h, Map<String, List<g>>>> f16840i = new EnumMap(i.a.a.a.m.k.d.class);

    /* compiled from: Rule.java */
    static class a implements n {

        /* renamed from: a, reason: collision with root package name */
        Pattern f16845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16846b;

        a(String str) {
            this.f16846b = str;
            this.f16845a = Pattern.compile(this.f16846b);
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return this.f16845a.matcher(charSequence).find();
        }
    }

    /* compiled from: Rule.java */
    static class b implements n {
        b() {
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return true;
        }
    }

    /* compiled from: Rule.java */
    static class c extends g {

        /* renamed from: j, reason: collision with root package name */
        private final int f16847j;

        /* renamed from: k, reason: collision with root package name */
        private final String f16848k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f16849l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f16850m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, String str3, l lVar, int i2, String str4) {
            super(str, str2, str3, lVar);
            this.f16849l = i2;
            this.f16850m = str4;
            this.f16847j = this.f16849l;
            this.f16848k = this.f16850m;
        }

        public String toString() {
            return "Rule{line=" + this.f16847j + ", loc='" + this.f16848k + "'}";
        }
    }

    /* compiled from: Rule.java */
    static class d implements n {
        d() {
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* compiled from: Rule.java */
    static class e implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16851a;

        e(String str) {
            this.f16851a = str;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.equals(this.f16851a);
        }
    }

    /* compiled from: Rule.java */
    static class f implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16852a;

        f(String str) {
            this.f16852a = str;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return g.d(charSequence, this.f16852a);
        }
    }

    /* compiled from: Rule.java */
    /* renamed from: i.a.a.a.m.k.g$g, reason: collision with other inner class name */
    static class C0255g implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16853a;

        C0255g(String str) {
            this.f16853a = str;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return g.c(charSequence, this.f16853a);
        }
    }

    /* compiled from: Rule.java */
    static class h implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16854a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16855b;

        h(String str, boolean z) {
            this.f16854a = str;
            this.f16855b = z;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() == 1 && g.b(this.f16854a, charSequence.charAt(0)) == this.f16855b;
        }
    }

    /* compiled from: Rule.java */
    static class i implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16857b;

        i(String str, boolean z) {
            this.f16856a = str;
            this.f16857b = z;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && g.b(this.f16856a, charSequence.charAt(0)) == this.f16857b;
        }
    }

    /* compiled from: Rule.java */
    static class j implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16858a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16859b;

        j(String str, boolean z) {
            this.f16858a = str;
            this.f16859b = z;
        }

        @Override // i.a.a.a.m.k.g.n
        public boolean a(CharSequence charSequence) {
            return charSequence.length() > 0 && g.b(this.f16858a, charSequence.charAt(charSequence.length() - 1)) == this.f16859b;
        }
    }

    /* compiled from: Rule.java */
    public static final class k implements l {

        /* renamed from: c, reason: collision with root package name */
        public static final Comparator<k> f16860c = new a();

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f16861a;

        /* renamed from: b, reason: collision with root package name */
        private final c.AbstractC0254c f16862b;

        /* compiled from: Rule.java */
        static class a implements Comparator<k> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(k kVar, k kVar2) {
                for (int i2 = 0; i2 < kVar.f16861a.length(); i2++) {
                    if (i2 >= kVar2.f16861a.length()) {
                        return 1;
                    }
                    int iCharAt = kVar.f16861a.charAt(i2) - kVar2.f16861a.charAt(i2);
                    if (iCharAt != 0) {
                        return iCharAt;
                    }
                }
                return kVar.f16861a.length() < kVar2.f16861a.length() ? -1 : 0;
            }
        }

        public k(CharSequence charSequence, c.AbstractC0254c abstractC0254c) {
            this.f16861a = charSequence;
            this.f16862b = abstractC0254c;
        }

        public k a(CharSequence charSequence) {
            return new k(this.f16861a.toString() + charSequence.toString(), this.f16862b);
        }

        public CharSequence c() {
            return this.f16861a;
        }

        @Override // i.a.a.a.m.k.g.l
        public Iterable<k> a() {
            return Collections.singleton(this);
        }

        public c.AbstractC0254c b() {
            return this.f16862b;
        }

        public k a(k kVar) {
            return new k(this.f16861a.toString() + kVar.f16861a.toString(), this.f16862b.a(kVar.f16862b));
        }
    }

    /* compiled from: Rule.java */
    public interface l {
        Iterable<k> a();
    }

    /* compiled from: Rule.java */
    public static final class m implements l {

        /* renamed from: a, reason: collision with root package name */
        private final List<k> f16863a;

        public m(List<k> list) {
            this.f16863a = list;
        }

        @Override // i.a.a.a.m.k.g.l
        public List<k> a() {
            return this.f16863a;
        }
    }

    /* compiled from: Rule.java */
    public interface n {
        boolean a(CharSequence charSequence);
    }

    static {
        for (i.a.a.a.m.k.d dVar : i.a.a.a.m.k.d.values()) {
            EnumMap enumMap = new EnumMap(i.a.a.a.m.k.h.class);
            for (i.a.a.a.m.k.h hVar : i.a.a.a.m.k.h.values()) {
                HashMap map = new HashMap();
                for (String str : i.a.a.a.m.k.c.a(dVar).a()) {
                    try {
                        map.put(str, a(b(dVar, hVar, str), a(dVar, hVar, str)));
                    } catch (IllegalStateException e2) {
                        throw new IllegalStateException("Problem processing " + a(dVar, hVar, str), e2);
                    }
                }
                if (!hVar.equals(i.a.a.a.m.k.h.RULES)) {
                    map.put("common", a(b(dVar, hVar, "common"), a(dVar, hVar, "common")));
                }
                enumMap.put((EnumMap) hVar, (i.a.a.a.m.k.h) Collections.unmodifiableMap(map));
            }
            f16840i.put(dVar, Collections.unmodifiableMap(enumMap));
        }
    }

    public g(String str, String str2, String str3, l lVar) {
        this.f16842b = str;
        this.f16841a = d(str2 + "$");
        this.f16844d = d("^" + str3);
        this.f16843c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    private static n d(String str) {
        boolean zStartsWith = str.startsWith("^");
        boolean zEndsWith = str.endsWith("$");
        int length = str.length();
        if (zEndsWith) {
            length--;
        }
        String strSubstring = str.substring(zStartsWith ? 1 : 0, length);
        if (strSubstring.contains("[")) {
            boolean zStartsWith2 = strSubstring.startsWith("[");
            boolean zEndsWith2 = strSubstring.endsWith("]");
            if (zStartsWith2 && zEndsWith2) {
                String strSubstring2 = strSubstring.substring(1, strSubstring.length() - 1);
                if (!strSubstring2.contains("[")) {
                    boolean zStartsWith3 = strSubstring2.startsWith("^");
                    if (zStartsWith3) {
                        strSubstring2 = strSubstring2.substring(1);
                    }
                    boolean z = !zStartsWith3;
                    if (zStartsWith && zEndsWith) {
                        return new h(strSubstring2, z);
                    }
                    if (zStartsWith) {
                        return new i(strSubstring2, z);
                    }
                    if (zEndsWith) {
                        return new j(strSubstring2, z);
                    }
                }
            }
        } else {
            if (zStartsWith && zEndsWith) {
                return strSubstring.length() == 0 ? new d() : new e(strSubstring);
            }
            if ((zStartsWith || zEndsWith) && strSubstring.length() == 0) {
                return f16836e;
            }
            if (zStartsWith) {
                return new f(strSubstring);
            }
            if (zEndsWith) {
                return new C0255g(strSubstring);
            }
        }
        return new a(str);
    }

    private static String e(String str) {
        if (str.startsWith(f16838g)) {
            str = str.substring(1);
        }
        return str.endsWith(f16838g) ? str.substring(0, str.length() - 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(CharSequence charSequence, char c2) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == c2) {
                return true;
            }
        }
        return false;
    }

    private static String a(i.a.a.a.m.k.d dVar, i.a.a.a.m.k.h hVar, String str) {
        return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", dVar.getName(), hVar.getName(), str);
    }

    private static Scanner a(String str) {
        String str2 = String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        InputStream resourceAsStream = i.a.a.a.m.k.c.class.getClassLoader().getResourceAsStream(str2);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + str2);
    }

    private static Scanner b(i.a.a.a.m.k.d dVar, i.a.a.a.m.k.h hVar, String str) {
        String strA = a(dVar, hVar, str);
        InputStream resourceAsStream = i.a.a.a.m.k.c.class.getClassLoader().getResourceAsStream(strA);
        if (resourceAsStream != null) {
            return new Scanner(resourceAsStream, "UTF-8");
        }
        throw new IllegalArgumentException("Unable to load resource: " + strA);
    }

    public static List<g> c(i.a.a.a.m.k.d dVar, i.a.a.a.m.k.h hVar, String str) {
        List<g> list = f16840i.get(dVar).get(hVar).get(str);
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", dVar.getName(), hVar.getName(), str));
    }

    private static l c(String str) {
        if (str.startsWith("(")) {
            if (str.endsWith(")")) {
                ArrayList arrayList = new ArrayList();
                String strSubstring = str.substring(1, str.length() - 1);
                for (String str2 : strSubstring.split("[|]")) {
                    arrayList.add(b(str2));
                }
                if (strSubstring.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || strSubstring.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                    arrayList.add(new k("", i.a.a.a.m.k.c.f16814e));
                }
                return new m(arrayList);
            }
            throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        return b(str);
    }

    public static List<g> a(i.a.a.a.m.k.d dVar, i.a.a.a.m.k.h hVar, c.AbstractC0254c abstractC0254c) {
        return c(dVar, hVar, abstractC0254c.c() ? abstractC0254c.a() : i.a.a.a.m.k.c.f16811b);
    }

    private static k b(String str) {
        int iIndexOf = str.indexOf("[");
        if (iIndexOf >= 0) {
            if (str.endsWith("]")) {
                return new k(str.substring(0, iIndexOf), c.AbstractC0254c.a(new HashSet(Arrays.asList(str.substring(iIndexOf + 1, str.length() - 1).split("[+]")))));
            }
            throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
        }
        return new k(str, i.a.a.a.m.k.c.f16814e);
    }

    private static List<g> a(Scanner scanner, String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                i2++;
                String strNextLine = scanner.nextLine();
                if (z) {
                    if (strNextLine.endsWith("*/")) {
                        break;
                    }
                } else if (strNextLine.startsWith("/*")) {
                    z = true;
                } else {
                    int iIndexOf = strNextLine.indexOf("//");
                    String strTrim = (iIndexOf >= 0 ? strNextLine.substring(0, iIndexOf) : strNextLine).trim();
                    if (strTrim.length() == 0) {
                        continue;
                    } else if (strTrim.startsWith(f16839h)) {
                        String strTrim2 = strTrim.substring(8).trim();
                        if (strTrim2.contains(c.c.a.b.a.a.f3100g)) {
                            System.err.println("Warining: malformed import statement: " + strNextLine);
                        } else {
                            arrayList.addAll(a(a(strTrim2), str + "->" + strTrim2));
                        }
                    } else {
                        String[] strArrSplit = strTrim.split("\\s+");
                        if (strArrSplit.length != 4) {
                            System.err.println("Warning: malformed rule statement split into " + strArrSplit.length + " parts: " + strNextLine);
                        } else {
                            try {
                                arrayList.add(new c(e(strArrSplit[0]), e(strArrSplit[1]), e(strArrSplit[2]), c(e(strArrSplit[3])), i2, str));
                            } catch (IllegalArgumentException e2) {
                                throw new IllegalStateException("Problem parsing line " + i2, e2);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    public String b() {
        return this.f16842b;
    }

    public l c() {
        return this.f16843c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public n d() {
        return this.f16844d;
    }

    public n a() {
        return this.f16841a;
    }

    public boolean a(CharSequence charSequence, int i2) {
        if (i2 >= 0) {
            int length = this.f16842b.length() + i2;
            if (length > charSequence.length()) {
                return false;
            }
            return charSequence.subSequence(i2, length).equals(this.f16842b) && this.f16844d.a(charSequence.subSequence(length, charSequence.length())) && this.f16841a.a(charSequence.subSequence(0, i2));
        }
        throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
    }
}
