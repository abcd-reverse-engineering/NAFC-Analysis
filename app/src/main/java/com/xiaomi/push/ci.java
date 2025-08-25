package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ci {

    public static class a extends ch {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.ch
        public String a(Context context, String str, List<at> list) {
            if (list == null) {
                return au.a(context, new URL(str));
            }
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            for (at atVar : list) {
                builderBuildUpon.appendQueryParameter(atVar.a(), atVar.b());
            }
            return au.a(context, new URL(builderBuildUpon.toString()));
        }
    }

    public static String a(Context context, String str, List<at> list) {
        return a(context, str, list, new a(), true);
    }

    public static String a(Context context, String str, List<at> list, ch chVar, boolean z) throws NumberFormatException {
        cc ccVar;
        String strA;
        String str2;
        if (au.m151a(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cc ccVarM229a = cg.a().m229a(str);
                    if (ccVarM229a != null) {
                        arrayList = ccVarM229a.a(str);
                    }
                    ccVar = ccVarM229a;
                } else {
                    ccVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it = arrayList.iterator();
                String str3 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        strA = str3;
                    }
                    if (!chVar.m239a(context, next, (List<at>) arrayList2)) {
                        break;
                    }
                    strA = chVar.a(context, next, (List<at>) arrayList2);
                    try {
                    } catch (IOException e3) {
                        e = e3;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        if (ccVar != null) {
                            str2 = strA;
                            try {
                                ccVar.a(next, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, next, arrayList2, strA), null);
                            } catch (IOException e4) {
                                e = e4;
                                strA = str2;
                            }
                        } else {
                            str2 = strA;
                        }
                        str3 = str2;
                    } else {
                        if (ccVar == null) {
                            return strA;
                        }
                        try {
                            ccVar.a(next, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, next, arrayList2, strA));
                            return strA;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    }
                    if (ccVar != null) {
                        str2 = strA;
                        ccVar.a(next, System.currentTimeMillis() - jCurrentTimeMillis, a(chVar, next, arrayList2, strA), e);
                    } else {
                        str2 = strA;
                    }
                    e.printStackTrace();
                    str3 = str2;
                }
                return str3;
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    private static int a(ch chVar, String str, List<at> list, String str2) {
        if (chVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (chVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    static int a(List<at> list) {
        int length = 0;
        for (at atVar : list) {
            if (!TextUtils.isEmpty(atVar.a())) {
                length += atVar.a().length();
            }
            if (!TextUtils.isEmpty(atVar.b())) {
                length += atVar.b().length();
            }
        }
        return length * 2;
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(int i2, int i3) {
        return (((i3 + 243) / 1448) * 132) + 1080 + i2 + i3;
    }

    static int a(int i2, int i3, int i4) {
        return (((i3 + 200) / 1448) * 132) + 1011 + i3 + i2 + i4;
    }
}
