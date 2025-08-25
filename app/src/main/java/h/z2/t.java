package h.z2;

import bean.SurveyH5Bean;
import h.e1;
import h.t0;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes2.dex */
public class t {
    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final <T extends Appendable> T a(@i.c.a.d T t, @i.c.a.e CharSequence charSequence, int i2, int i3) {
        h.q2.t.i0.f(t, "$this$appendRange");
        T t2 = (T) t.append(charSequence, i2, i3);
        if (t2 != null) {
            return t2;
        }
        throw new e1("null cannot be cast to non-null type T");
    }

    @i.c.a.d
    public static final <T extends Appendable> T a(@i.c.a.d T t, @i.c.a.d CharSequence... charSequenceArr) throws IOException {
        h.q2.t.i0.f(t, "$this$append");
        h.q2.t.i0.f(charSequenceArr, SurveyH5Bean.VALUE);
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@i.c.a.d Appendable appendable, T t, @i.c.a.e h.q2.s.l<? super T, ? extends CharSequence> lVar) {
        h.q2.t.i0.f(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
