package h.z2;

import bean.SurveyH5Bean;
import java.util.List;

/* compiled from: MatchResult.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface m {

    /* compiled from: MatchResult.kt */
    public static final class a {
        @i.c.a.d
        public static b a(m mVar) {
            return new b(mVar);
        }
    }

    /* compiled from: MatchResult.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @i.c.a.d
        private final m f16719a;

        public b(@i.c.a.d m mVar) {
            h.q2.t.i0.f(mVar, "match");
            this.f16719a = mVar;
        }

        @h.m2.f
        private final String c() {
            return a().b().get(1);
        }

        @h.m2.f
        private final String d() {
            return a().b().get(10);
        }

        @h.m2.f
        private final String e() {
            return a().b().get(2);
        }

        @h.m2.f
        private final String f() {
            return a().b().get(3);
        }

        @h.m2.f
        private final String g() {
            return a().b().get(4);
        }

        @h.m2.f
        private final String h() {
            return a().b().get(5);
        }

        @h.m2.f
        private final String i() {
            return a().b().get(6);
        }

        @h.m2.f
        private final String j() {
            return a().b().get(7);
        }

        @h.m2.f
        private final String k() {
            return a().b().get(8);
        }

        @h.m2.f
        private final String l() {
            return a().b().get(9);
        }

        @i.c.a.d
        public final m a() {
            return this.f16719a;
        }

        @i.c.a.d
        public final List<String> b() {
            return this.f16719a.b().subList(1, this.f16719a.b().size());
        }
    }

    @i.c.a.d
    b a();

    @i.c.a.d
    List<String> b();

    @i.c.a.d
    k c();

    @i.c.a.d
    h.v2.k d();

    @i.c.a.d
    String getValue();

    @i.c.a.e
    m next();
}
