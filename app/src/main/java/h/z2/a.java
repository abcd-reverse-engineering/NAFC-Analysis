package h.z2;

import bean.SurveyH5Bean;
import h.g2.b1;
import h.q2.t.j0;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: CharCategory.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b \b\u0086\u0001\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006."}, d2 = {"Lkotlin/text/CharCategory;", "", SurveyH5Bean.VALUE, "", "code", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "()I", "contains", "", "char", "", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public enum a {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");


    @i.c.a.d
    private final String code;
    private final int value;
    public static final b Companion = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final h.s f16673b = h.v.a(C0251a.INSTANCE);

    /* compiled from: CharCategory.kt */
    /* renamed from: h.z2.a$a, reason: collision with other inner class name */
    static final class C0251a extends j0 implements h.q2.s.a<Map<Integer, ? extends a>> {
        public static final C0251a INSTANCE = new C0251a();

        C0251a() {
            super(0);
        }

        @Override // h.q2.s.a
        @i.c.a.d
        public final Map<Integer, ? extends a> invoke() {
            a[] aVarArrValues = a.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(h.v2.q.a(b1.b(aVarArrValues.length), 16));
            for (a aVar : aVarArrValues) {
                linkedHashMap.put(Integer.valueOf(aVar.getValue()), aVar);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharCategory.kt */
    public static final class b {
        private b() {
        }

        private final Map<Integer, a> a() {
            h.s sVar = a.f16673b;
            b bVar = a.Companion;
            return (Map) sVar.getValue();
        }

        @i.c.a.d
        public final a a(int i2) {
            a aVar = a().get(Integer.valueOf(i2));
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalArgumentException("Category #" + i2 + " is not defined.");
        }

        public /* synthetic */ b(h.q2.t.v vVar) {
            this();
        }
    }

    a(int i2, String str) {
        this.value = i2;
        this.code = str;
    }

    public final boolean contains(char c2) {
        return Character.getType(c2) == this.value;
    }

    @i.c.a.d
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
