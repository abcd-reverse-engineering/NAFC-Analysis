package h.j2;

import bean.SurveyH5Bean;
import h.m;
import h.t0;
import h.y;

/* compiled from: ContractBuilder.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", SurveyH5Bean.VALUE, "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@f
@h.m2.b
@t0(version = "1.3")
/* loaded from: classes2.dex */
public interface c {

    /* compiled from: ContractBuilder.kt */
    public static final class a {
        public static /* synthetic */ h.j2.a a(c cVar, m mVar, g gVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i2 & 2) != 0) {
                gVar = g.UNKNOWN;
            }
            return cVar.a(mVar, gVar);
        }
    }

    @h.m2.b
    @i.c.a.d
    <R> h.j2.a a(@i.c.a.d m<? extends R> mVar, @i.c.a.d g gVar);

    @h.m2.b
    @i.c.a.d
    h a();

    @h.m2.b
    @i.c.a.d
    h a(@i.c.a.e Object obj);

    @h.m2.b
    @i.c.a.d
    i b();
}
