package h.z2;

/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes2.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    @h.q2.c
    @i.c.a.d
    public static final o f16727a;

    /* renamed from: b, reason: collision with root package name */
    public static final r f16728b = new r();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f16727a = new o("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private r() {
    }
}
