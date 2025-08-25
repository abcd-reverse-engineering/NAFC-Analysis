package h.z2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import h.e1;
import h.q2.t.m1;
import h.t0;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class b0 extends a0 {
    @h.m2.f
    private static final int a(@i.c.a.d String str, char c2, int i2) {
        if (str != null) {
            return str.indexOf(c2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, char c2, int i2) {
        if (str != null) {
            return str.lastIndexOf(c2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ boolean c(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c(str, str2, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final char[] d(@i.c.a.d String str, int i2, int i3) {
        h.q2.t.i0.f(str, "$this$toCharArray");
        h.g2.d.Companion.a(i2, i3, str.length());
        char[] cArr = new char[i3 - i2];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    @h.m2.f
    private static final int f(@i.c.a.d String str, int i2) {
        if (str != null) {
            return str.codePointAt(i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int g(@i.c.a.d String str, int i2) {
        if (str != null) {
            return str.codePointBefore(i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final String h(@i.c.a.d String str, int i2) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(i2);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @h.m2.f
    private static final Pattern i(@i.c.a.d String str, int i2) {
        Pattern patternCompile = Pattern.compile(str, i2);
        h.q2.t.i0.a((Object) patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        return patternCompile;
    }

    @i.c.a.d
    public static final String j(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$capitalize");
        if (!(str.length() > 0) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strSubstring.toUpperCase();
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        String strSubstring2 = str.substring(1);
        h.q2.t.i0.a((Object) strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @i.c.a.d
    public static final String l(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$decapitalize");
        if (!(str.length() > 0) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strSubstring.toLowerCase();
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        h.q2.t.i0.a((Object) strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final byte[] m(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(f.f16682a);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @h.m2.f
    private static final String n(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String strIntern = str.intern();
        h.q2.t.i0.a((Object) strIntern, "(this as java.lang.String).intern()");
        return strIntern;
    }

    @h.m2.f
    private static final char[] o(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = str.toCharArray();
        h.q2.t.i0.a((Object) charArray, "(this as java.lang.String).toCharArray()");
        return charArray;
    }

    @h.m2.f
    private static final String p(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @h.m2.f
    private static final String q(@i.c.a.d String str) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @h.m2.f
    private static final int a(@i.c.a.d String str, String str2, int i2) {
        if (str != null) {
            return str.indexOf(str2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, String str2, int i2) {
        if (str != null) {
            return str.lastIndexOf(str2, i2);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static boolean c(@i.c.a.e String str, @i.c.a.e String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ String a(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, c2, c3, z);
    }

    public static /* synthetic */ String b(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(str, c2, c3, z);
    }

    public static /* synthetic */ boolean d(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return d(str, str2, z);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, char c2, char c3, boolean z) {
        h.q2.t.i0.f(str, "$this$replace");
        if (!z) {
            String strReplace = str.replace(c2, c3);
            h.q2.t.i0.a((Object) strReplace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return strReplace;
        }
        return h.x2.u.a(c0.b(str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, char c2, char c3, boolean z) {
        h.q2.t.i0.f(str, "$this$replaceFirst");
        int iA = c0.a((CharSequence) str, c2, 0, z, 2, (Object) null);
        return iA < 0 ? str : c0.a((CharSequence) str, iA, iA + 1, (CharSequence) String.valueOf(c3)).toString();
    }

    @h.m2.f
    private static final String c(@i.c.a.d String str, int i2, int i3) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(i2, i3);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean d(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$startsWith");
        h.q2.t.i0.f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2);
        }
        return a(str, 0, str2, 0, str2.length(), z);
    }

    @h.m2.f
    private static final String c(StringBuilder sb) {
        return new String(sb);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    public static /* synthetic */ String b(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(str, str2, str3, z);
    }

    @h.m2.f
    private static final String c(@i.c.a.d String str, Locale locale) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @h.m2.f
    private static final String d(@i.c.a.d String str, Locale locale) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase(locale);
        h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, boolean z) {
        h.q2.t.i0.f(str, "$this$replace");
        h.q2.t.i0.f(str2, "oldValue");
        h.q2.t.i0.f(str3, "newValue");
        return h.x2.u.a(c0.b(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, boolean z) {
        h.q2.t.i0.f(str, "$this$replaceFirst");
        h.q2.t.i0.f(str2, "oldValue");
        h.q2.t.i0.f(str3, "newValue");
        int iA = c0.a((CharSequence) str, str2, 0, z, 2, (Object) null);
        return iA < 0 ? str : c0.a((CharSequence) str, iA, str2.length() + iA, (CharSequence) str3).toString();
    }

    public static /* synthetic */ String a(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return b(cArr, i2, i3);
    }

    public static /* synthetic */ char[] a(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return d(str, i2, i3);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$concatToString");
        return new String(cArr);
    }

    public static /* synthetic */ String a(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(bArr, i2, i3, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d char[] cArr, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$concatToString");
        h.g2.d.Companion.a(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String a(@i.c.a.d byte[] bArr, int i2, int i3, boolean z) {
        h.q2.t.i0.f(bArr, "$this$decodeToString");
        h.g2.d.Companion.a(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, f.f16682a);
        }
        String string = f.f16682a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        h.q2.t.i0.a((Object) string, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return string;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final String b(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$decodeToString");
        return new String(bArr, f.f16682a);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(str, str2, z);
    }

    public static final boolean b(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$endsWith");
        h.q2.t.i0.f(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    @h.m2.f
    private static final int b(@i.c.a.d String str, int i2, int i3) {
        if (str != null) {
            return str.offsetByCodePoints(i2, i3);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.j
    @t0(version = "1.3")
    @h.m2.g
    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d Locale locale) {
        h.q2.t.i0.f(str, "$this$decapitalize");
        h.q2.t.i0.f(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strSubstring.toLowerCase(locale);
        h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        h.q2.t.i0.a((Object) strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static /* synthetic */ byte[] a(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(str, i2, i3, z);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final byte[] a(@i.c.a.d String str, int i2, int i3, boolean z) throws CharacterCodingException {
        h.q2.t.i0.f(str, "$this$encodeToByteArray");
        h.g2.d.Companion.a(i2, i3, str.length());
        if (!z) {
            String strSubstring = str.substring(i2, i3);
            h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = f.f16682a;
            if (strSubstring == null) {
                throw new e1("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = strSubstring.getBytes(charset);
            h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer byteBufferEncode = f.f16682a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray == null) {
                h.q2.t.i0.f();
            }
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                h.q2.t.i0.a((Object) bArrArray2, "byteBuffer.array()");
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    static /* synthetic */ char[] a(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @h.m2.f
    private static final char[] a(@i.c.a.d String str, char[] cArr, int i2, int i3, int i4) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, Object... objArr) {
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) str2, "java.lang.String.format(this, *args)");
        return str2;
    }

    @h.m2.f
    private static final String a(@i.c.a.d m1 m1Var, String str, Object... objArr) {
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, Locale locale, Object... objArr) {
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) str2, "java.lang.String.format(locale, this, *args)");
        return str2;
    }

    @h.m2.f
    private static final String a(@i.c.a.d m1 m1Var, Locale locale, String str, Object... objArr) {
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        h.q2.t.i0.a((Object) str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    public static /* synthetic */ List a(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(charSequence, pattern, i2);
    }

    @i.c.a.d
    public static final List<String> a(@i.c.a.d CharSequence charSequence, @i.c.a.d Pattern pattern, int i2) {
        h.q2.t.i0.f(charSequence, "$this$split");
        h.q2.t.i0.f(pattern, "regex");
        if (i2 >= 0) {
            if (i2 == 0) {
                i2 = -1;
            }
            String[] strArrSplit = pattern.split(charSequence, i2);
            h.q2.t.i0.a((Object) strArrSplit, "regex.split(this, if (limit == 0) -1 else limit)");
            return h.g2.q.d((Object[]) strArrSplit);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ boolean a(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(str, str2, i2, z);
    }

    public static final boolean a(@i.c.a.d String str, @i.c.a.d String str2, int i2, boolean z) {
        h.q2.t.i0.f(str, "$this$startsWith");
        h.q2.t.i0.f(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return a(str, i2, str2, 0, str2.length(), z);
    }

    @h.m2.f
    private static final String a(byte[] bArr, int i2, int i3, Charset charset) {
        return new String(bArr, i2, i3, charset);
    }

    @h.m2.f
    private static final String a(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @h.m2.f
    private static final String a(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, f.f16682a);
    }

    @h.m2.f
    private static final String a(byte[] bArr) {
        return new String(bArr, f.f16682a);
    }

    @h.m2.f
    private static final String a(char[] cArr) {
        return new String(cArr);
    }

    @h.m2.f
    private static final String a(char[] cArr, int i2, int i3) {
        return new String(cArr, i2, i3);
    }

    @h.m2.f
    private static final String a(int[] iArr, int i2, int i3) {
        return new String(iArr, i2, i3);
    }

    @h.m2.f
    private static final String a(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @h.m2.f
    private static final int a(@i.c.a.d String str, int i2, int i3) {
        if (str != null) {
            return str.codePointCount(i2, i3);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int a(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static final int a(@i.c.a.d String str, @i.c.a.d String str2, boolean z) {
        h.q2.t.i0.f(str, "$this$compareTo");
        h.q2.t.i0.f(str2, DispatchConstants.OTHER);
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    @h.m2.f
    private static final boolean a(@i.c.a.d String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    @h.m2.f
    private static final boolean a(@i.c.a.d String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new e1("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(@i.c.a.d java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            h.q2.t.i0.f(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            h.v2.k r0 = h.z2.c0.b(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = 1
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            h.g2.u0 r3 = (h.g2.u0) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = h.z2.d.p(r3)
            if (r3 != 0) goto L24
            r4 = 0
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = 1
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h.z2.b0.a(java.lang.CharSequence):boolean");
    }

    public static final boolean a(@i.c.a.d CharSequence charSequence, int i2, @i.c.a.d CharSequence charSequence2, int i3, int i4, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$regionMatches");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return a((String) charSequence, i2, (String) charSequence2, i3, i4, z);
        }
        return c0.b(charSequence, i2, charSequence2, i3, i4, z);
    }

    public static final boolean a(@i.c.a.d String str, int i2, @i.c.a.d String str2, int i3, int i4, boolean z) {
        h.q2.t.i0.f(str, "$this$regionMatches");
        h.q2.t.i0.f(str2, DispatchConstants.OTHER);
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    @h.m2.f
    private static final byte[] a(@i.c.a.d String str, Charset charset) {
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    static /* synthetic */ byte[] a(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = f.f16682a;
        }
        if (str == null) {
            throw new e1("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        h.q2.t.i0.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @h.j
    @t0(version = "1.3")
    @h.m2.g
    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d Locale locale) {
        h.q2.t.i0.f(str, "$this$capitalize");
        h.q2.t.i0.f(locale, "locale");
        if (str.length() > 0) {
            char cCharAt = str.charAt(0);
            if (Character.isLowerCase(cCharAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(cCharAt);
                if (titleCase != Character.toUpperCase(cCharAt)) {
                    sb.append(titleCase);
                } else {
                    String strSubstring = str.substring(0, 1);
                    h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring == null) {
                        throw new e1("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = strSubstring.toUpperCase(locale);
                    h.q2.t.i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String strSubstring2 = str.substring(1);
                h.q2.t.i0.a((Object) strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring2);
                String string = sb.toString();
                h.q2.t.i0.a((Object) string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
        }
        return str;
    }

    @i.c.a.d
    public static final String a(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 != 1) {
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                if (1 <= i2) {
                    while (true) {
                        sb.append(charSequence);
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
                String string = sb.toString();
                h.q2.t.i0.a((Object) string, "sb.toString()");
                return string;
            }
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = cCharAt;
            }
            return new String(cArr);
        }
        return charSequence.toString();
    }

    @i.c.a.d
    public static final Comparator<String> a(@i.c.a.d m1 m1Var) {
        h.q2.t.i0.f(m1Var, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        h.q2.t.i0.a((Object) comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    static /* synthetic */ Pattern a(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Pattern patternCompile = Pattern.compile(str, i2);
        h.q2.t.i0.a((Object) patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        return patternCompile;
    }
}
