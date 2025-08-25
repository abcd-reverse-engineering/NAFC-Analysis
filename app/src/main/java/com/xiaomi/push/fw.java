package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class fw {

    /* renamed from: a, reason: collision with root package name */
    private static XmlPullParser f12899a;

    public static fo a(XmlPullParser xmlPullParser) throws XmlPullParserException, fi, IOException {
        String attributeValue;
        boolean z = false;
        String strNextText = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", com.umeng.analytics.pro.bh.aE))) {
            String attributeValue2 = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue6 = xmlPullParser.getAttributeValue("", "type");
            am.b bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue5);
            if (bVarA == null) {
                bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue4);
            }
            if (bVarA == null) {
                throw new fi("the channel id is wrong while receiving a encrypted message");
            }
            fo foVarA = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!com.umeng.analytics.pro.bh.aE.equals(xmlPullParser.getName())) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new fi("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue2) || "6".equals(attributeValue2)) {
                        fn fnVar = new fn();
                        fnVar.l(attributeValue2);
                        fnVar.b(true);
                        fnVar.n(attributeValue4);
                        fnVar.m(attributeValue5);
                        fnVar.k(attributeValue3);
                        fnVar.f(attributeValue6);
                        fl flVar = new fl(com.umeng.analytics.pro.bh.aE, null, null, null);
                        flVar.m429a(text);
                        fnVar.a(flVar);
                        return fnVar;
                    }
                    a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(bVarA.f13351h, attributeValue3), text));
                    f12899a.next();
                    foVarA = a(f12899a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (foVarA != null) {
                return foVarA;
            }
            throw new fi("error while receiving a encrypted message with wrong format");
        }
        fn fnVar2 = new fn();
        String attributeValue7 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue7 == null) {
            attributeValue7 = "ID_NOT_AVAILABLE";
        }
        fnVar2.k(attributeValue7);
        fnVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fnVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fnVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fnVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            attributeValue = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            attributeValue = null;
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fnVar2.b(attributeValue8);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fnVar2.c(attributeValue9);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fnVar2.d(attributeValue10);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue11 = xmlPullParser.getAttributeValue("", NotificationCompat.CATEGORY_STATUS);
            if (!TextUtils.isEmpty(attributeValue11)) {
                fnVar2.e(attributeValue11);
            }
        } catch (Exception unused5) {
        }
        fnVar2.a(!TextUtils.isEmpty(attributeValue) && attributeValue.equalsIgnoreCase(a.a.u.a.f1253j));
        fnVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String strB = b(xmlPullParser);
        if (strB == null || "".equals(strB.trim())) {
            fo.q();
        } else {
            fnVar2.j(strB);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    fnVar2.g(m443a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue12 = xmlPullParser.getAttributeValue("", "encode");
                    String strM443a = m443a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue12)) {
                        fnVar2.h(strM443a);
                    } else {
                        fnVar2.a(strM443a, attributeValue12);
                    }
                } else if (name.equals("thread")) {
                    if (strNextText == null) {
                        strNextText = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    fnVar2.a(m442a(xmlPullParser));
                } else {
                    fnVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fnVar2.i(strNextText);
        return fnVar2;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i2)))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }

    private static void a(byte[] bArr) throws XmlPullParserException {
        if (f12899a == null) {
            try {
                f12899a = XmlPullParserFactory.newInstance().newPullParser();
                f12899a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f12899a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m443a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fq m440a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fq.b bVarValueOf = fq.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVarValueOf = fq.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fq fqVar = new fq(bVarValueOf);
        fqVar.m(xmlPullParser.getAttributeValue("", "to"));
        fqVar.n(xmlPullParser.getAttributeValue("", "from"));
        fqVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fqVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(NotificationCompat.CATEGORY_STATUS)) {
                    fqVar.a(xmlPullParser.nextText());
                } else if (name.equals(RemoteMessageConst.Notification.PRIORITY)) {
                    try {
                        fqVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fqVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String strNextText = xmlPullParser.nextText();
                    try {
                        fqVar.a(fq.a.valueOf(strNextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + strNextText);
                    }
                } else if (name.equals("error")) {
                    fqVar.a(m442a(xmlPullParser));
                } else {
                    fqVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fqVar;
    }

    public static fm a(XmlPullParser xmlPullParser, fa faVar) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fm.a aVarA = fm.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap map = new HashMap();
        boolean z = false;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            map.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fm fmVar = null;
        fs fsVarM442a = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    fsVarM442a = m442a(xmlPullParser);
                } else {
                    fmVar = new fm();
                    fmVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fmVar == null) {
            if (fm.a.f12838a != aVarA && fm.a.f12839b != aVarA) {
                fmVar = new fm() { // from class: com.xiaomi.push.fw.2
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
            } else {
                fm fmVar2 = new fm() { // from class: com.xiaomi.push.fw.1
                    @Override // com.xiaomi.push.fm
                    public String b() {
                        return null;
                    }
                };
                fmVar2.k(attributeValue);
                fmVar2.m(attributeValue3);
                fmVar2.n(attributeValue2);
                fmVar2.a(fm.a.f12841d);
                fmVar2.l(attributeValue4);
                fmVar2.a(new fs(fs.a.f12888e));
                faVar.a(fmVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        fmVar.k(attributeValue);
        fmVar.m(attributeValue2);
        fmVar.l(attributeValue4);
        fmVar.n(attributeValue3);
        fmVar.a(aVarA);
        fmVar.a(fsVarM442a);
        fmVar.a(map);
        return fmVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fr m441a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fr frVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                frVar = new fr(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return frVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fs m442a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String attributeValue = null;
        String attributeValue2 = null;
        String attributeValue3 = "-1";
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            if (xmlPullParser.getAttributeName(i2).equals("code")) {
                attributeValue3 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i2).equals("type")) {
                attributeValue = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i2).equals("reason")) {
                attributeValue2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str = null;
        String strNextText = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    strNextText = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                strNextText = xmlPullParser.getText();
            }
        }
        return new fs(Integer.parseInt(attributeValue3), attributeValue == null ? CommonNetImpl.CANCEL : attributeValue, attributeValue2, str, strNextText, arrayList);
    }

    public static fl a(String str, String str2, XmlPullParser xmlPullParser) {
        Object objM438a = fv.a().m438a("all", "xm:chat");
        if (objM438a == null || !(objM438a instanceof com.xiaomi.push.service.i)) {
            return null;
        }
        return ((com.xiaomi.push.service.i) objM438a).b(xmlPullParser);
    }
}
