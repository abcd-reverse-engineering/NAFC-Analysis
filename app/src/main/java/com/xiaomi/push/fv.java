package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class fv {

    /* renamed from: a, reason: collision with root package name */
    private static fv f12897a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Object> f540a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f12898b = new ConcurrentHashMap();

    private fv() throws IOException {
        m439a();
    }

    public static synchronized fv a() {
        if (f12897a == null) {
            f12897a = new fv();
        }
        return f12897a;
    }

    /* renamed from: a, reason: collision with other method in class */
    protected void m439a() throws IOException {
        try {
            for (ClassLoader classLoader : m437a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStreamOpenStream = null;
                    try {
                        inputStreamOpenStream = resources.nextElement().openStream();
                        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        xmlPullParserNewPullParser.setInput(inputStreamOpenStream, "UTF-8");
                        int eventType = xmlPullParserNewPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (xmlPullParserNewPullParser.getName().equals("iqProvider")) {
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText2 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText3 = xmlPullParserNewPullParser.nextText();
                                    String strA = a(strNextText, strNextText2);
                                    if (!this.f12898b.containsKey(strA)) {
                                        try {
                                            Class<?> cls = Class.forName(strNextText3);
                                            if (ft.class.isAssignableFrom(cls)) {
                                                this.f12898b.put(strA, cls.newInstance());
                                            } else if (fm.class.isAssignableFrom(cls)) {
                                                this.f12898b.put(strA, cls);
                                            }
                                        } catch (ClassNotFoundException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                } else if (xmlPullParserNewPullParser.getName().equals("extensionProvider")) {
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText4 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText5 = xmlPullParserNewPullParser.nextText();
                                    xmlPullParserNewPullParser.next();
                                    xmlPullParserNewPullParser.next();
                                    String strNextText6 = xmlPullParserNewPullParser.nextText();
                                    String strA2 = a(strNextText4, strNextText5);
                                    if (!this.f540a.containsKey(strA2)) {
                                        try {
                                            Class<?> cls2 = Class.forName(strNextText6);
                                            if (fu.class.isAssignableFrom(cls2)) {
                                                this.f540a.put(strA2, cls2.newInstance());
                                            } else if (fp.class.isAssignableFrom(cls2)) {
                                                this.f540a.put(strA2, cls2);
                                            }
                                        } catch (ClassNotFoundException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                            eventType = xmlPullParserNewPullParser.next();
                        } while (eventType != 1);
                        inputStreamOpenStream.close();
                    } catch (Throwable th) {
                        try {
                            inputStreamOpenStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public Object m438a(String str, String str2) {
        return this.f540a.get(a(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof fu) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f540a.put(a(str, str2), obj);
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m437a() {
        ClassLoader[] classLoaderArr = {fv.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
