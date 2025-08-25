package i.a.a.a.m.k;

import i.a.a.a.m.k.c;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Lang.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<d, b> f16804c = new EnumMap(d.class);

    /* renamed from: d, reason: collision with root package name */
    private static final String f16805d = "org/apache/commons/codec/language/bm/lang.txt";

    /* renamed from: a, reason: collision with root package name */
    private final c f16806a;

    /* renamed from: b, reason: collision with root package name */
    private final List<C0253b> f16807b;

    /* compiled from: Lang.java */
    /* renamed from: i.a.a.a.m.k.b$b, reason: collision with other inner class name */
    private static final class C0253b {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f16808a;

        /* renamed from: b, reason: collision with root package name */
        private final Set<String> f16809b;

        /* renamed from: c, reason: collision with root package name */
        private final Pattern f16810c;

        private C0253b(Pattern pattern, Set<String> set, boolean z) {
            this.f16810c = pattern;
            this.f16809b = set;
            this.f16808a = z;
        }

        public boolean a(String str) {
            return this.f16810c.matcher(str).find();
        }
    }

    static {
        for (d dVar : d.values()) {
            f16804c.put(dVar, a(f16805d, c.a(dVar)));
        }
    }

    private b(List<C0253b> list, c cVar) {
        this.f16807b = Collections.unmodifiableList(list);
        this.f16806a = cVar;
    }

    public static b a(d dVar) {
        return f16804c.get(dVar);
    }

    public c.AbstractC0254c b(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        HashSet hashSet = new HashSet(this.f16806a.a());
        for (C0253b c0253b : this.f16807b) {
            if (c0253b.a(lowerCase)) {
                if (c0253b.f16808a) {
                    hashSet.retainAll(c0253b.f16809b);
                } else {
                    hashSet.removeAll(c0253b.f16809b);
                }
            }
        }
        c.AbstractC0254c abstractC0254cA = c.AbstractC0254c.a(hashSet);
        return abstractC0254cA.equals(c.f16813d) ? c.f16814e : abstractC0254cA;
    }

    public static b a(String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        InputStream resourceAsStream = b.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream == null) {
            throw new IllegalStateException("Unable to resolve required resource:org/apache/commons/codec/language/bm/lang.txt");
        }
        Scanner scanner = new Scanner(resourceAsStream, "UTF-8");
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
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
                    if (strTrim.length() != 0) {
                        String[] strArrSplit = strTrim.split("\\s+");
                        if (strArrSplit.length != 3) {
                            System.err.println("Warning: malformed line '" + strNextLine + "'");
                        } else {
                            arrayList.add(new C0253b(Pattern.compile(strArrSplit[0]), new HashSet(Arrays.asList(strArrSplit[1].split("\\+"))), strArrSplit[2].equals(a.a.u.a.f1253j)));
                        }
                    }
                }
            }
            return new b(arrayList, cVar);
        }
    }

    public String a(String str) {
        c.AbstractC0254c abstractC0254cB = b(str);
        return abstractC0254cB.c() ? abstractC0254cB.a() : c.f16811b;
    }
}
