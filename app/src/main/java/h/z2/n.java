package h.z2;

import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.t.j0;
import h.z2.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* compiled from: Regex.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", SurveyH5Bean.VALUE, "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class n implements m {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final k f16720a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f16721b;

    /* renamed from: c, reason: collision with root package name */
    private final Matcher f16722c;

    /* renamed from: d, reason: collision with root package name */
    private final CharSequence f16723d;

    /* compiled from: Regex.kt */
    public static final class a extends h.g2.d<String> {
        a() {
        }

        public /* bridge */ boolean a(String str) {
            return super.contains(str);
        }

        public /* bridge */ int b(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int c(String str) {
            return super.lastIndexOf(str);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return n.this.e().groupCount() + 1;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public String get(int i2) {
            String strGroup = n.this.e().group(i2);
            return strGroup != null ? strGroup : "";
        }
    }

    public n(@i.c.a.d Matcher matcher, @i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(matcher, "matcher");
        h.q2.t.i0.f(charSequence, "input");
        this.f16722c = matcher;
        this.f16723d = charSequence;
        this.f16720a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult e() {
        return this.f16722c;
    }

    @Override // h.z2.m
    @i.c.a.d
    public List<String> b() {
        if (this.f16721b == null) {
            this.f16721b = new a();
        }
        List<String> list = this.f16721b;
        if (list == null) {
            h.q2.t.i0.f();
        }
        return list;
    }

    @Override // h.z2.m
    @i.c.a.d
    public k c() {
        return this.f16720a;
    }

    @Override // h.z2.m
    @i.c.a.d
    public h.v2.k d() {
        return p.b(e());
    }

    @Override // h.z2.m
    @i.c.a.d
    public String getValue() {
        String strGroup = e().group();
        h.q2.t.i0.a((Object) strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // h.z2.m
    @i.c.a.e
    public m next() {
        int iEnd = e().end() + (e().end() == e().start() ? 1 : 0);
        if (iEnd > this.f16723d.length()) {
            return null;
        }
        Matcher matcher = this.f16722c.pattern().matcher(this.f16723d);
        h.q2.t.i0.a((Object) matcher, "matcher.pattern().matcher(input)");
        return p.b(matcher, iEnd, this.f16723d);
    }

    @Override // h.z2.m
    @i.c.a.d
    public m.b a() {
        return m.a.a(this);
    }

    /* compiled from: Regex.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", CommonNetImpl.NAME, "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    public static final class b extends h.g2.a<j> implements l {

        /* compiled from: Regex.kt */
        static final class a extends j0 implements h.q2.s.l<Integer, j> {
            a() {
                super(1);
            }

            @Override // h.q2.s.l
            public /* bridge */ /* synthetic */ j invoke(Integer num) {
                return invoke(num.intValue());
            }

            @i.c.a.e
            public final j invoke(int i2) {
                return b.this.get(i2);
            }
        }

        b() {
        }

        public /* bridge */ boolean a(j jVar) {
            return super.contains(jVar);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof j : true) {
                return a((j) obj);
            }
            return false;
        }

        @Override // h.z2.k
        @i.c.a.e
        public j get(int i2) {
            h.v2.k kVarB = p.b(n.this.e(), i2);
            if (kVarB.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = n.this.e().group(i2);
            h.q2.t.i0.a((Object) strGroup, "matchResult.group(index)");
            return new j(strGroup, kVarB);
        }

        @Override // h.g2.a
        public int getSize() {
            return n.this.e().groupCount() + 1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // h.g2.a, java.util.Collection, java.lang.Iterable
        @i.c.a.d
        public Iterator<j> iterator() {
            return h.x2.u.w(h.g2.g0.i(h.g2.y.a((Collection<?>) this)), new a()).iterator();
        }

        @Override // h.z2.l
        @i.c.a.e
        public j get(@i.c.a.d String str) {
            h.q2.t.i0.f(str, CommonNetImpl.NAME);
            return h.m2.l.f16311a.a(n.this.e(), str);
        }
    }
}
