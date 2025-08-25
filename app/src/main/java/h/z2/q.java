package h.z2;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class q implements i {
    public static final q CANON_EQ;
    public static final q COMMENTS;
    public static final q DOT_MATCHES_ALL;
    public static final q IGNORE_CASE;
    public static final q LITERAL;
    public static final q MULTILINE;
    public static final q UNIX_LINES;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ q[] f16726a;
    private final int mask;
    private final int value;

    static {
        q qVar = new q("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = qVar;
        q qVar2 = new q("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = qVar2;
        int i2 = 0;
        int i3 = 2;
        h.q2.t.v vVar = null;
        q qVar3 = new q("LITERAL", 2, 16, i2, i3, vVar);
        LITERAL = qVar3;
        q qVar4 = new q("UNIX_LINES", 3, 1, i2, i3, vVar);
        UNIX_LINES = qVar4;
        q qVar5 = new q("COMMENTS", 4, 4, i2, i3, vVar);
        COMMENTS = qVar5;
        q qVar6 = new q("DOT_MATCHES_ALL", 5, 32, i2, i3, vVar);
        DOT_MATCHES_ALL = qVar6;
        q qVar7 = new q("CANON_EQ", 6, 128, i2, i3, vVar);
        CANON_EQ = qVar7;
        f16726a = new q[]{qVar, qVar2, qVar3, qVar4, qVar5, qVar6, qVar7};
    }

    private q(String str, int i2, int i3, int i4) {
        this.value = i3;
        this.mask = i4;
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f16726a.clone();
    }

    @Override // h.z2.i
    public int getMask() {
        return this.mask;
    }

    @Override // h.z2.i
    public int getValue() {
        return this.value;
    }

    /* synthetic */ q(String str, int i2, int i3, int i4, int i5, h.q2.t.v vVar) {
        this(str, i2, i3, (i5 & 2) != 0 ? i3 : i4);
    }
}
