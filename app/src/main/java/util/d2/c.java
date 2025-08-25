package util.d2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/* compiled from: UrlUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static a a(String str) {
        a aVarB;
        if (TextUtils.isEmpty(str) || str.indexOf(63) <= -1) {
            aVarB = null;
        } else {
            String strSubstring = str.substring(str.indexOf(63) + 1);
            int iIndexOf = strSubstring.indexOf(35);
            aVarB = iIndexOf > -1 ? b(strSubstring.substring(0, iIndexOf)) : b(strSubstring);
        }
        return aVarB == null ? new a() : aVarB;
    }

    public static a b(String str) {
        a aVar = new a();
        try {
            String[] strArrSplit = str.split("&");
            if (strArrSplit != null && strArrSplit.length > 0) {
                for (String str2 : strArrSplit) {
                    String[] strArrSplit2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                    if (strArrSplit2 != null && strArrSplit2.length == 2) {
                        aVar.a(URLDecoder.decode(strArrSplit2[0]), URLDecoder.decode(strArrSplit2[1]));
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return aVar;
    }

    public static String a(String str, String str2) throws IOException {
        URL url = new URL(str);
        if (str2.isEmpty() || url.getQuery().isEmpty()) {
            return str;
        }
        if (!str.contains("&" + str2)) {
            if (!str.contains("?" + str2)) {
                return str;
            }
        }
        return str.replace(str2, "");
    }
}
