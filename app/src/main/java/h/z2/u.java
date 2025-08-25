package h.z2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import h.e1;
import h.q2.t.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Indent.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes2.dex */
class u extends t {

    /* compiled from: Indent.kt */
    static final class a extends j0 implements h.q2.s.l<String, String> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "line");
            return str;
        }
    }

    /* compiled from: Indent.kt */
    static final class b extends j0 implements h.q2.s.l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "line");
            return this.$indent + str;
        }
    }

    /* compiled from: Indent.kt */
    static final class c extends j0 implements h.q2.s.l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.$indent = str;
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "it");
            if (b0.a((CharSequence) str)) {
                return str.length() < this.$indent.length() ? this.$indent : str;
            }
            return this.$indent + str;
        }
    }

    public static /* synthetic */ String a(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        if ((i2 & 2) != 0) {
            str3 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return a(str, str2, str3);
    }

    public static /* synthetic */ String b(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        return b(str, str2);
    }

    public static /* synthetic */ String c(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return c(str, str2);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3) {
        int i2;
        String strInvoke;
        h.q2.t.i0.f(str, "$this$replaceIndentByMargin");
        h.q2.t.i0.f(str2, "newIndent");
        h.q2.t.i0.f(str3, "marginPrefix");
        if (!(!b0.a((CharSequence) str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listK = c0.k((CharSequence) str);
        int length = str.length() + (str2.length() * listK.size());
        h.q2.s.l<String, String> lVarA = a(str2);
        int iA = h.g2.y.a((List) listK);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : listK) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                h.g2.y.f();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i3 == 0 || i3 == iA) && b0.a((CharSequence) str4)) {
                str4 = null;
            } else {
                int length2 = str4.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i2 = -1;
                        break;
                    }
                    if (!d.p(str4.charAt(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    int i6 = i2;
                    if (b0.a(str4, str3, i2, false, 4, (Object) null)) {
                        int length3 = i6 + str3.length();
                        if (str4 == null) {
                            throw new e1("null cannot be cast to non-null type java.lang.String");
                        }
                        strSubstring = str4.substring(length3);
                        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = lVarA.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i3 = i4;
        }
        String string = ((StringBuilder) h.g2.g0.a(arrayList, new StringBuilder(length), (null & 2) != 0 ? ", " : "\n", (null & 4) != 0 ? "" : null, (null & 8) == 0 ? null : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : null)).toString();
        h.q2.t.i0.a((Object) string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d String str2) {
        String strInvoke;
        h.q2.t.i0.f(str, "$this$replaceIndent");
        h.q2.t.i0.f(str2, "newIndent");
        List<String> listK = c0.k((CharSequence) str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (!b0.a((CharSequence) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(h.g2.z.a(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(b((String) it.next())));
        }
        Integer num = (Integer) h.g2.w.y((Iterable) arrayList2);
        int i2 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listK.size());
        h.q2.s.l<String, String> lVarA = a(str2);
        int iA = h.g2.y.a((List) listK);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listK) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                h.g2.y.f();
            }
            String str3 = (String) obj2;
            if ((i2 == 0 || i2 == iA) && b0.a((CharSequence) str3)) {
                str3 = null;
            } else {
                String strF = e0.f(str3, iIntValue);
                if (strF != null && (strInvoke = lVarA.invoke(strF)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) h.g2.g0.a(arrayList3, new StringBuilder(length), (null & 2) != 0 ? ", " : "\n", (null & 4) != 0 ? "" : null, (null & 8) == 0 ? null : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : null)).toString();
        h.q2.t.i0.a((Object) string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$trimMargin");
        h.q2.t.i0.f(str2, "marginPrefix");
        return a(str, "", str2);
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$trimIndent");
        return b(str, "");
    }

    public static /* synthetic */ String a(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "    ";
        }
        return a(str, str2);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$prependIndent");
        h.q2.t.i0.f(str2, "indent");
        return h.x2.u.a(h.x2.u.w(c0.j((CharSequence) str), new c(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    private static final int b(@i.c.a.d String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!d.p(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    private static final h.q2.s.l<String, String> a(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    private static final String a(@i.c.a.d List<String> list, int i2, h.q2.s.l<? super String, String> lVar, h.q2.s.l<? super String, String> lVar2) {
        String strInvoke;
        int iA = h.g2.y.a((List) list);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                if (!h.m2.l.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                h.g2.y.f();
            }
            String str = (String) obj;
            if ((i3 == 0 || i3 == iA) && b0.a((CharSequence) str)) {
                str = null;
            } else {
                String strInvoke2 = lVar2.invoke(str);
                if (strInvoke2 != null && (strInvoke = lVar.invoke(strInvoke2)) != null) {
                    str = strInvoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i3 = i4;
        }
        String string = ((StringBuilder) h.g2.g0.a(arrayList, new StringBuilder(i2), (null & 2) != 0 ? ", " : "\n", (null & 4) != 0 ? "" : null, (null & 8) == 0 ? null : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : null)).toString();
        h.q2.t.i0.a((Object) string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }
}
