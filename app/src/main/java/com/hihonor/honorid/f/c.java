package com.hihonor.honorid.f;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: XMLPackUtil.java */
/* loaded from: classes.dex */
public class c {
    public static void a(XmlSerializer xmlSerializer, String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException {
        if (str2 == null || xmlSerializer == null || str == null) {
            return;
        }
        xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
    }
}
