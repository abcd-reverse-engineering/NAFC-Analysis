package h.z2;

import com.taobao.accs.common.Constants;
import h.n0;
import h.q2.t.h1;
import h.q2.t.j0;
import h.z2.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Regex.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002,-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\"\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\"J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class o implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends q> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int a(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        @i.c.a.d
        public final String b(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(str);
            h.q2.t.i0.a((Object) strQuoteReplacement, "Matcher.quoteReplacement(literal)");
            return strQuoteReplacement;
        }

        @i.c.a.d
        public final o c(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "literal");
            return new o(str, q.LITERAL);
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        @i.c.a.d
        public final String a(@i.c.a.d String str) {
            h.q2.t.i0.f(str, "literal");
            String strQuote = Pattern.quote(str);
            h.q2.t.i0.a((Object) strQuote, "Pattern.quote(literal)");
            return strQuote;
        }
    }

    /* compiled from: Regex.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", Constants.KEY_FLAGS, "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    private static final class b implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;

        @i.c.a.d
        private final String pattern;

        /* compiled from: Regex.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(h.q2.t.v vVar) {
                this();
            }
        }

        public b(@i.c.a.d String str, int i2) {
            h.q2.t.i0.f(str, "pattern");
            this.pattern = str;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            h.q2.t.i0.a((Object) patternCompile, "Pattern.compile(pattern, flags)");
            return new o(patternCompile);
        }

        public final int getFlags() {
            return this.flags;
        }

        @i.c.a.d
        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Regex.kt */
    static final class c extends j0 implements h.q2.s.a<m> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i2) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.q2.s.a
        @i.c.a.e
        public final m invoke() {
            return o.this.find(this.$input, this.$startIndex);
        }
    }

    /* compiled from: Regex.kt */
    static final /* synthetic */ class d extends h.q2.t.d0 implements h.q2.s.l<m, m> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        @Override // h.q2.t.p, h.w2.b
        public final String getName() {
            return "next";
        }

        @Override // h.q2.t.p
        public final h.w2.f getOwner() {
            return h1.b(m.class);
        }

        @Override // h.q2.t.p
        public final String getSignature() {
            return "next()Lkotlin/text/MatchResult;";
        }

        @Override // h.q2.s.l
        @i.c.a.e
        public final m invoke(@i.c.a.d m mVar) {
            h.q2.t.i0.f(mVar, "p1");
            return mVar.next();
        }
    }

    @n0
    public o(@i.c.a.d Pattern pattern) {
        h.q2.t.i0.f(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ m find$default(o oVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oVar.find(charSequence, i2);
    }

    public static /* synthetic */ h.x2.m findAll$default(o oVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oVar.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(o oVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oVar.split(charSequence, i2);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        h.q2.t.i0.a((Object) strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @i.c.a.e
    public final m find(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        h.q2.t.i0.a((Object) matcher, "nativePattern.matcher(input)");
        return p.b(matcher, i2, charSequence);
    }

    @i.c.a.d
    public final h.x2.m<m> findAll(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "input");
        return h.x2.s.a((h.q2.s.a) new c(charSequence, i2), (h.q2.s.l) d.INSTANCE);
    }

    @i.c.a.d
    public final Set<q> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(q.class);
        h.g2.d0.b((Iterable) enumSetAllOf, (h.q2.s.l) new p.a(iFlags));
        Set<q> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        h.q2.t.i0.a((Object) setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    @i.c.a.d
    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        h.q2.t.i0.a((Object) strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    @i.c.a.e
    public final m matchEntire(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        h.q2.t.i0.a((Object) matcher, "nativePattern.matcher(input)");
        return p.b(matcher, charSequence);
    }

    public final boolean matches(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @i.c.a.d
    public final String replace(@i.c.a.d CharSequence charSequence, @i.c.a.d String str) {
        h.q2.t.i0.f(charSequence, "input");
        h.q2.t.i0.f(str, "replacement");
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        h.q2.t.i0.a((Object) strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    @i.c.a.d
    public final String replaceFirst(@i.c.a.d CharSequence charSequence, @i.c.a.d String str) {
        h.q2.t.i0.f(charSequence, "input");
        h.q2.t.i0.f(str, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        h.q2.t.i0.a((Object) strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    @i.c.a.d
    public final List<String> split(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "input");
        int iEnd = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            return h.g2.x.a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i2 > 0 ? h.v2.q.b(i2, 10) : 10);
        int i3 = i2 - 1;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    @i.c.a.d
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @i.c.a.d
    public String toString() {
        String string = this.nativePattern.toString();
        h.q2.t.i0.a((Object) string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        h.q2.t.i0.a((Object) patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    @i.c.a.d
    public final String replace(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super m, ? extends CharSequence> lVar) {
        h.q2.t.i0.f(charSequence, "input");
        h.q2.t.i0.f(lVar, "transform");
        int iIntValue = 0;
        m mVarFind$default = find$default(this, charSequence, 0, 2, null);
        if (mVarFind$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (mVarFind$default == null) {
                h.q2.t.i0.f();
            }
            sb.append(charSequence, iIntValue, mVarFind$default.d().getStart().intValue());
            sb.append(lVar.invoke(mVarFind$default));
            iIntValue = mVarFind$default.d().getEndInclusive().intValue() + 1;
            mVarFind$default = mVarFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (mVarFind$default != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@i.c.a.d String str, @i.c.a.d q qVar) {
        h.q2.t.i0.f(str, "pattern");
        h.q2.t.i0.f(qVar, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.a(qVar.getValue()));
        h.q2.t.i0.a((Object) patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public o(@i.c.a.d String str, @i.c.a.d Set<? extends q> set) {
        h.q2.t.i0.f(str, "pattern");
        h.q2.t.i0.f(set, "options");
        Pattern patternCompile = Pattern.compile(str, Companion.a(p.b((Iterable<? extends i>) set)));
        h.q2.t.i0.a((Object) patternCompile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
        this(patternCompile);
    }
}
