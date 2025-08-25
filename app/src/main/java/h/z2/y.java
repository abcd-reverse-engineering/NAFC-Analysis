package h.z2;

import bean.SurveyH5Bean;
import h.o0;
import h.t0;
import h.y1;

/* compiled from: StringBuilder.kt */
/* loaded from: classes2.dex */
class y extends x {
    @h.m2.f
    @h.c(level = h.d.WARNING, message = "Use append(value: Any?) instead", replaceWith = @o0(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder a(@i.c.a.d StringBuilder sb, Object obj) {
        sb.append(obj);
        h.q2.t.i0.a((Object) sb, "this.append(obj)");
        return sb;
    }

    @h.m2.f
    private static final String a(h.q2.s.l<? super StringBuilder, y1> lVar) {
        StringBuilder sb = new StringBuilder();
        lVar.invoke(sb);
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final String a(int i2, h.q2.s.l<? super StringBuilder, y1> lVar) {
        StringBuilder sb = new StringBuilder(i2);
        lVar.invoke(sb);
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @i.c.a.d
    public static final StringBuilder a(@i.c.a.d StringBuilder sb, @i.c.a.d String... strArr) {
        h.q2.t.i0.f(sb, "$this$append");
        h.q2.t.i0.f(strArr, SurveyH5Bean.VALUE);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    @i.c.a.d
    public static final StringBuilder a(@i.c.a.d StringBuilder sb, @i.c.a.d Object... objArr) {
        h.q2.t.i0.f(sb, "$this$append");
        h.q2.t.i0.f(objArr, SurveyH5Bean.VALUE);
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
