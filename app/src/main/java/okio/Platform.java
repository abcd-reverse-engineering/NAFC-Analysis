package okio;

import h.q2.e;
import h.q2.s.a;
import h.q2.t.f0;
import h.q2.t.i0;
import h.y;
import h.z2.f;
import i.c.a.d;

/* compiled from: -Platform.kt */
@e(name = "-Platform")
@y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\t*\u00020\bH\u0000*\n\u0010\u000b\"\u00020\f2\u00020\f*\n\u0010\r\"\u00020\u000e2\u00020\u000e*\n\u0010\u000f\"\u00020\u00102\u00020\u0010¨\u0006\u0011"}, d2 = {"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "EOFException", "Ljava/io/EOFException;", "IOException", "Ljava/io/IOException;", "okio"}, k = 2, mv = {1, 1, 16})
/* renamed from: okio.-Platform, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Platform {
    @d
    public static final byte[] asUtf8ToByteArray(@d String str) {
        i0.f(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(f.f16682a);
        i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m786synchronized(@d Object obj, @d a<? extends R> aVar) {
        R rInvoke;
        i0.f(obj, "lock");
        i0.f(aVar, "block");
        synchronized (obj) {
            try {
                rInvoke = aVar.invoke();
                f0.b(1);
            } catch (Throwable th) {
                f0.b(1);
                f0.a(1);
                throw th;
            }
        }
        f0.a(1);
        return rInvoke;
    }

    @d
    public static final String toUtf8String(@d byte[] bArr) {
        i0.f(bArr, "$this$toUtf8String");
        return new String(bArr, f.f16682a);
    }
}
