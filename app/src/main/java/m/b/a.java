package m.b;

import android.content.Intent;
import android.net.Uri;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import zxing.android.e;

/* compiled from: DecodeFormatManager.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static final Map<String, Set<c.b.c.a>> f17292i;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f17284a = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: e, reason: collision with root package name */
    static final Set<c.b.c.a> f17288e = EnumSet.of(c.b.c.a.QR_CODE);

    /* renamed from: f, reason: collision with root package name */
    static final Set<c.b.c.a> f17289f = EnumSet.of(c.b.c.a.DATA_MATRIX);

    /* renamed from: g, reason: collision with root package name */
    static final Set<c.b.c.a> f17290g = EnumSet.of(c.b.c.a.AZTEC);

    /* renamed from: h, reason: collision with root package name */
    static final Set<c.b.c.a> f17291h = EnumSet.of(c.b.c.a.PDF_417);

    /* renamed from: b, reason: collision with root package name */
    public static final Set<c.b.c.a> f17285b = EnumSet.of(c.b.c.a.UPC_A, c.b.c.a.UPC_E, c.b.c.a.EAN_13, c.b.c.a.EAN_8, c.b.c.a.RSS_14, c.b.c.a.RSS_EXPANDED);

    /* renamed from: c, reason: collision with root package name */
    static final Set<c.b.c.a> f17286c = EnumSet.of(c.b.c.a.CODE_39, c.b.c.a.CODE_93, c.b.c.a.CODE_128, c.b.c.a.ITF, c.b.c.a.CODABAR);

    /* renamed from: d, reason: collision with root package name */
    private static final Set<c.b.c.a> f17287d = EnumSet.copyOf((Collection) f17285b);

    static {
        f17287d.addAll(f17286c);
        f17292i = new HashMap();
        f17292i.put(e.c.f21114d, f17287d);
        f17292i.put(e.c.f21113c, f17285b);
        f17292i.put(e.c.f21115e, f17288e);
        f17292i.put(e.c.f21116f, f17289f);
        f17292i.put(e.c.f21117g, f17290g);
        f17292i.put(e.c.f21118h, f17291h);
    }

    private a() {
    }

    public static Set<c.b.c.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra(e.c.f21119i);
        return a(stringExtra != null ? Arrays.asList(f17284a.split(stringExtra)) : null, intent.getStringExtra(e.c.f21112b));
    }

    public static Set<c.b.c.a> a(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(e.c.f21119i);
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(f17284a.split(queryParameters.get(0)));
        }
        return a(queryParameters, uri.getQueryParameter(e.c.f21112b));
    }

    private static Set<c.b.c.a> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(c.b.c.a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(c.b.c.a.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f17292i.get(str);
        }
        return null;
    }
}
