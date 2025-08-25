package h.z2;

import h.t0;
import java.io.IOException;

/* compiled from: StringBuilderJVM.kt */
/* loaded from: classes2.dex */
class x extends w {
    @h.m2.f
    private static final void a(@i.c.a.d StringBuilder sb, int i2, char c2) {
        h.q2.t.i0.f(sb, "$this$set");
        sb.setCharAt(i2, c2);
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final StringBuilder b(@i.c.a.d StringBuilder sb) {
        h.q2.t.i0.f(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, int i2, int i3, String str) {
        StringBuilder sbReplace = sb.replace(i2, i3, str);
        h.q2.t.i0.a((Object) sbReplace, "this.replace(startIndex, endIndex, value)");
        return sbReplace;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder b(@i.c.a.d StringBuilder sb, int i2) {
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i2);
        h.q2.t.i0.a((Object) sbDeleteCharAt, "this.deleteCharAt(index)");
        return sbDeleteCharAt;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, int i2, int i3) {
        StringBuilder sbDelete = sb.delete(i2, i3);
        h.q2.t.i0.a((Object) sbDelete, "this.delete(startIndex, endIndex)");
        return sbDelete;
    }

    static /* synthetic */ void a(StringBuilder sb, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sb.length();
        }
        sb.getChars(i3, i4, cArr, i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final void a(@i.c.a.d StringBuilder sb, char[] cArr, int i2, int i3, int i4) {
        sb.getChars(i3, i4, cArr, i2);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, char[] cArr, int i2, int i3) {
        sb.append(cArr, i2, i3 - i2);
        h.q2.t.i0.a((Object) sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, CharSequence charSequence, int i2, int i3) {
        sb.append(charSequence, i2, i3);
        h.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, int i2, char[] cArr, int i3, int i4) {
        StringBuilder sbInsert = sb.insert(i2, cArr, i3, i4 - i3);
        h.q2.t.i0.a((Object) sbInsert, "this.insert(index, value…x, endIndex - startIndex)");
        return sbInsert;
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, int i2, CharSequence charSequence, int i3, int i4) {
        StringBuilder sbInsert = sb.insert(i2, charSequence, i3, i4);
        h.q2.t.i0.a((Object) sbInsert, "this.insert(index, value, startIndex, endIndex)");
        return sbInsert;
    }

    @i.c.a.d
    public static final Appendable a(@i.c.a.d Appendable appendable) throws IOException {
        h.q2.t.i0.f(appendable, "$this$appendln");
        Appendable appendableAppend = appendable.append(f0.f16692a);
        h.q2.t.i0.a((Object) appendableAppend, "append(SystemProperties.LINE_SEPARATOR)");
        return appendableAppend;
    }

    @h.m2.f
    private static final Appendable a(@i.c.a.d Appendable appendable, CharSequence charSequence) throws IOException {
        Appendable appendableAppend = appendable.append(charSequence);
        h.q2.t.i0.a((Object) appendableAppend, "append(value)");
        return a(appendableAppend);
    }

    @h.m2.f
    private static final Appendable a(@i.c.a.d Appendable appendable, char c2) throws IOException {
        Appendable appendableAppend = appendable.append(c2);
        h.q2.t.i0.a((Object) appendableAppend, "append(value)");
        return a(appendableAppend);
    }

    @i.c.a.d
    public static final StringBuilder a(@i.c.a.d StringBuilder sb) {
        h.q2.t.i0.f(sb, "$this$appendln");
        sb.append(f0.f16692a);
        h.q2.t.i0.a((Object) sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(stringBuffer);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, String str) {
        sb.append(str);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, Object obj) {
        sb.append(obj);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, StringBuilder sb2) {
        sb.append((CharSequence) sb2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, char c2) {
        sb.append(c2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, boolean z) {
        sb.append(z);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, int i2) {
        sb.append(i2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, short s) {
        sb.append((int) s);
        h.q2.t.i0.a((Object) sb, "append(value.toInt())");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, byte b2) {
        sb.append((int) b2);
        h.q2.t.i0.a((Object) sb, "append(value.toInt())");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, long j2) {
        sb.append(j2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, float f2) {
        sb.append(f2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }

    @h.m2.f
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, double d2) {
        sb.append(d2);
        h.q2.t.i0.a((Object) sb, "append(value)");
        return a(sb);
    }
}
