package c.b.c.y.a;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: EmailAddressResultParser.java */
/* loaded from: classes.dex */
public final class i extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2958f = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    @Override // c.b.c.y.a.u
    public h a(c.b.c.r rVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String strB = u.b(rVar);
        if (!strB.startsWith("mailto:") && !strB.startsWith("MAILTO:")) {
            if (j.e(strB)) {
                return new h(strB);
            }
            return null;
        }
        String strSubstring = strB.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        String strD = u.d(strSubstring);
        String[] strArrSplit = !strD.isEmpty() ? f2958f.split(strD) : null;
        Map<String, String> mapB = u.b(strB);
        if (mapB != null) {
            if (strArrSplit == null && (str3 = mapB.get("to")) != null) {
                strArrSplit = f2958f.split(str3);
            }
            String str4 = mapB.get(com.umeng.ccg.a.f10591a);
            String[] strArrSplit2 = str4 != null ? f2958f.split(str4) : null;
            String str5 = mapB.get("bcc");
            String[] strArrSplit3 = str5 != null ? f2958f.split(str5) : null;
            String str6 = mapB.get("subject");
            str2 = mapB.get("body");
            strArr = strArrSplit;
            strArr3 = strArrSplit3;
            strArr2 = strArrSplit2;
            str = str6;
        } else {
            strArr = strArrSplit;
            strArr2 = null;
            strArr3 = null;
            str = null;
            str2 = null;
        }
        return new h(strArr, strArr2, strArr3, str, str2);
    }
}
