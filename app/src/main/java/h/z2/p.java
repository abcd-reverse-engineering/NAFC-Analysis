package h.z2;

import androidx.exifinterface.media.ExifInterface;
import bean.SurveyH5Bean;
import h.q2.t.j0;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* compiled from: Regex.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014"}, d2 = {"fromInt", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/text/FlagEnum;", "", SurveyH5Bean.VALUE, "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Regex.kt */
    public static final class a<T> extends j0 implements h.q2.s.l<T, Boolean> {
        final /* synthetic */ int $value$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.$value$inlined = i2;
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            i iVar = (i) r3;
            return (this.$value$inlined & iVar.getMask()) == iVar.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Regex.kt */
    public static final class b<T> extends j0 implements h.q2.s.l<T, Boolean> {
        final /* synthetic */ int $value$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(1);
            this.$value$inlined = i2;
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            i iVar = (i) r3;
            return (this.$value$inlined & iVar.getMask()) == iVar.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ <T extends Enum<T> & i> Set<T> b(int i2) {
        h.q2.t.i0.a(4, ExifInterface.GPS_DIRECTION_TRUE);
        EnumSet enumSetAllOf = EnumSet.allOf(Enum.class);
        h.g2.d0.b((Iterable) enumSetAllOf, (h.q2.s.l) new b(i2));
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        h.q2.t.i0.a((Object) setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return setUnmodifiableSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m b(@i.c.a.d Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m b(@i.c.a.d Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h.v2.k b(@i.c.a.d MatchResult matchResult) {
        return h.v2.q.d(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h.v2.k b(@i.c.a.d MatchResult matchResult, int i2) {
        return h.v2.q.d(matchResult.start(i2), matchResult.end(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(@i.c.a.d Iterable<? extends i> iterable) {
        Iterator<? extends i> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
