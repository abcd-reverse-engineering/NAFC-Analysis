package k.a.a.a.i;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.HonorAccount;
import com.taobao.accs.AccsClientConfig;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import k.a.a.a.j.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: XmlFileGrade.java */
/* loaded from: classes2.dex */
public class d implements a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<com.hihonor.honorid.core.data.HonorAccount> a(java.lang.String r6, android.content.Context r7, boolean r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "XmlFileGrade"
            r2 = 0
            r3 = 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.io.File r5 = r7.getFilesDir()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r5 = r5.getCanonicalPath()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.append(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.append(r6)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            boolean r6 = r4.exists()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            if (r6 != 0) goto L3b
            java.lang.String r6 = "xmlfilegradle sdk filepath not exist"
            k.a.a.a.j.e.b(r1, r6, r3)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r6.<init>()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            return r6
        L38:
            r6 = move-exception
            goto Lbf
        L3b:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L53 java.lang.RuntimeException -> L68 java.io.IOException -> L7d java.io.FileNotFoundException -> L92 org.xmlpull.v1.XmlPullParserException -> La7
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r4.setInput(r6, r2)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = a(r4, r7, r8)     // Catch: java.lang.Exception -> L54 java.lang.RuntimeException -> L69 java.io.IOException -> L7e java.io.FileNotFoundException -> L93 org.xmlpull.v1.XmlPullParserException -> La8 java.lang.Throwable -> Lbc
            r6.close()     // Catch: java.io.IOException -> L4f
            goto L52
        L4f:
            k.a.a.a.j.e.a(r1, r0, r3)
        L52:
            return r7
        L53:
            r6 = r2
        L54:
            java.lang.String r7 = "readAccountsFromXml Exception"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L67
            r6.close()     // Catch: java.io.IOException -> L64
            goto L67
        L64:
            k.a.a.a.j.e.a(r1, r0, r3)
        L67:
            return r7
        L68:
            r6 = r2
        L69:
            java.lang.String r7 = "readAccountsFromXml RuntimeException"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L7c
            r6.close()     // Catch: java.io.IOException -> L79
            goto L7c
        L79:
            k.a.a.a.j.e.a(r1, r0, r3)
        L7c:
            return r7
        L7d:
            r6 = r2
        L7e:
            java.lang.String r7 = "readAccountsFromXml IOException"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto L91
            r6.close()     // Catch: java.io.IOException -> L8e
            goto L91
        L8e:
            k.a.a.a.j.e.a(r1, r0, r3)
        L91:
            return r7
        L92:
            r6 = r2
        L93:
            java.lang.String r7 = "readAccountsFromXml FileNotFoundException"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto La6
            r6.close()     // Catch: java.io.IOException -> La3
            goto La6
        La3:
            k.a.a.a.j.e.a(r1, r0, r3)
        La6:
            return r7
        La7:
            r6 = r2
        La8:
            java.lang.String r7 = "XmlPullParserException readAccountsFromXmlfailed!"
            k.a.a.a.j.e.a(r1, r7, r3)     // Catch: java.lang.Throwable -> Lbc
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r7.<init>()     // Catch: java.lang.Throwable -> Lbc
            if (r6 == 0) goto Lbb
            r6.close()     // Catch: java.io.IOException -> Lb8
            goto Lbb
        Lb8:
            k.a.a.a.j.e.a(r1, r0, r3)
        Lbb:
            return r7
        Lbc:
            r7 = move-exception
            r2 = r6
            r6 = r7
        Lbf:
            if (r2 == 0) goto Lc8
            r2.close()     // Catch: java.io.IOException -> Lc5
            goto Lc8
        Lc5:
            k.a.a.a.j.e.a(r1, r0, r3)
        Lc8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k.a.a.a.i.d.a(java.lang.String, android.content.Context, boolean):java.util.ArrayList");
    }

    private static void b(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) {
        if ("loginUserName".equals(str)) {
            honorAccount.l(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
        } else if (c.c.a.b.a.a.D.equals(str)) {
            honorAccount.j(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
        }
    }

    private void b(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NumberFormatException, InvalidKeyException, InvalidAlgorithmParameterException {
        e.b("XmlFileGrade", "update HnAccounts.xml when version update", true);
        k.a.a.b.a.a aVarA = k.a.a.b.a.a.a(context);
        aVarA.a("last_head_picture_url");
        e.b("XmlFileGrade", "delete last_head_picture_url in HonorAccount.xml", true);
        aVarA.a("DEVID_1");
        e.b("XmlFileGrade", "delete DEVID in HonorAccount.xml", true);
        aVarA.a("SUBDEVID");
        e.b("XmlFileGrade", "delete SUBDEVID in HonorAccount.xml", true);
        aVarA.a("hasEncryptHeadPictureUrl");
        e.b("XmlFileGrade", "delete hasEncryptHeadPictureUrl in HonorAccount.xml", true);
        String strA = aVarA.a("accessToken", "");
        if (!TextUtils.isEmpty(strA)) {
            String strC = com.hihonor.honorid.d.a.b.c(context, strA);
            if (!TextUtils.isEmpty(strC)) {
                e.b("XmlFileGrade", "update accessToken in HonorAccount.xml", true);
                aVarA.b("accessToken", strC);
            } else {
                aVarA.a("accessToken");
                e.b("XmlFileGrade", "accessToken ecb decrypt error", true);
            }
        }
        String strA2 = aVarA.a("UUID", "");
        if (!TextUtils.isEmpty(strA2)) {
            e.b("XmlFileGrade", "update uuid in HonorAccount.xml", true);
            aVarA.b("UUID", strA2);
        } else {
            aVarA.a("UUID");
            e.b("XmlFileGrade", "uuid ecb decrypt error", true);
        }
    }

    private static void a(XmlPullParser xmlPullParser, Context context, boolean z, HonorAccount honorAccount, String str) throws XmlPullParserException, IOException {
        if ("userId".equals(str)) {
            String strNextText = xmlPullParser.nextText();
            if (z) {
                strNextText = com.hihonor.honorid.d.a.b.c(context, strNextText);
            }
            honorAccount.x(strNextText);
            return;
        }
        if ("deviceId".equals(str)) {
            String strNextText2 = xmlPullParser.nextText();
            if (z) {
                strNextText2 = com.hihonor.honorid.d.a.b.c(context, strNextText2);
            }
            honorAccount.g(strNextText2);
            return;
        }
        if (c.c.a.b.a.a.t.equals(str)) {
            String strNextText3 = xmlPullParser.nextText();
            if (z) {
                strNextText3 = com.hihonor.honorid.d.a.b.c(context, strNextText3);
            }
            honorAccount.s(strNextText3);
            return;
        }
        if ("deviceType".equals(str)) {
            honorAccount.h(xmlPullParser.nextText());
            return;
        }
        if (c.c.a.b.a.a.N.equals(str)) {
            honorAccount.t(com.hihonor.honorid.d.a.b.c(context, xmlPullParser.nextText()));
            return;
        }
        if (c.c.a.b.a.a.q.equals(str)) {
            try {
                honorAccount.b(Integer.parseInt(xmlPullParser.nextText()));
                return;
            } catch (NumberFormatException unused) {
                e.d("XmlFileGrade", "NumberFormatException: read accounts.xml parseInt error", true);
                return;
            } catch (Exception unused2) {
                e.d("XmlFileGrade", "read accounts.xml parseInt error", true);
                return;
            }
        }
        if ("accountType".equals(str)) {
            honorAccount.d(xmlPullParser.nextText());
        } else {
            b(xmlPullParser, context, z, honorAccount, str);
        }
    }

    private static ArrayList<HonorAccount> a(XmlPullParser xmlPullParser, Context context, boolean z) throws XmlPullParserException, IOException {
        e.c("XmlFileGrade", "parseAccountsFromXml Start", true);
        int eventType = xmlPullParser.getEventType();
        ArrayList<HonorAccount> arrayList = new ArrayList<>();
        HonorAccount honorAccount = new HonorAccount();
        while (1 != eventType) {
            String name = xmlPullParser.getName();
            if (eventType != 0) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        e.c("XmlFileGrade", AccsClientConfig.DEFAULT_CONFIGTAG, true);
                    } else if (c.c.a.b.a.a.P.equals(name)) {
                        e.c("XmlFileGrade", "parseAccountsFromXml account add ", true);
                        if (!TextUtils.isEmpty(honorAccount.c())) {
                            arrayList.add(honorAccount);
                        } else {
                            e.b("XmlFileGrade", "Invalid account , not need add.", true);
                        }
                        honorAccount = new HonorAccount();
                    }
                } else if (c.c.a.b.a.a.P.equals(name)) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "appId");
                    if (TextUtils.isEmpty(attributeValue)) {
                        e.c("XmlFileGrade", "authTokenType is null", true);
                        attributeValue = com.hihonor.honorid.f.a.d(context);
                    }
                    honorAccount.u(attributeValue);
                } else if (c.c.a.b.a.a.H.equals(name)) {
                    String strNextText = xmlPullParser.nextText();
                    if (z) {
                        strNextText = com.hihonor.honorid.d.a.b.c(context, strNextText);
                    }
                    honorAccount.c(strNextText);
                } else {
                    a(xmlPullParser, context, z, honorAccount, name);
                }
            }
            eventType = xmlPullParser.next();
        }
        return arrayList;
    }

    @Override // k.a.a.a.i.a
    public void a(Context context, int i2, int i3) throws Throwable {
        if (i2 >= i3) {
            e.a("XmlFileGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            b(context);
            a(context);
        }
    }

    private void a(Context context) throws Throwable {
        if (com.hihonor.honorid.f.a.e(context)) {
            return;
        }
        ArrayList<HonorAccount> arrayListA = a("accounts.xml", context, true);
        k.a.a.a.c.a(context, "accounts.xml");
        com.hihonor.honorid.g.c.b.a(context, "accounts.xml", (List<HonorAccount>) arrayListA, true);
    }
}
