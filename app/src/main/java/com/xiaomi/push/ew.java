package com.xiaomi.push;

import com.taobao.accs.utl.BaseMonitor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class ew {

    /* renamed from: a, reason: collision with root package name */
    private XmlPullParser f12794a;

    ew() throws XmlPullParserException {
        try {
            this.f12794a = XmlPullParserFactory.newInstance().newPullParser();
            this.f12794a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    fo a(byte[] bArr, fa faVar) throws XmlPullParserException, fi, IOException {
        this.f12794a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f12794a.next();
        int eventType = this.f12794a.getEventType();
        String name = this.f12794a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fw.a(this.f12794a);
        }
        if (name.equals("iq")) {
            return fw.a(this.f12794a, faVar);
        }
        if (name.equals("presence")) {
            return fw.m440a(this.f12794a);
        }
        if (this.f12794a.getName().equals("stream")) {
            return null;
        }
        if (this.f12794a.getName().equals("error")) {
            throw new fi(fw.m441a(this.f12794a));
        }
        if (!this.f12794a.getName().equals("warning")) {
            this.f12794a.getName().equals(BaseMonitor.ALARM_POINT_BIND);
            return null;
        }
        this.f12794a.next();
        this.f12794a.getName().equals("multi-login");
        return null;
    }
}
