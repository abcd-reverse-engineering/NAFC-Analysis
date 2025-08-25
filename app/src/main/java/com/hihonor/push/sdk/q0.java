package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q0 implements Callable<HonorPushDataMsg> {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f6318a;

    public q0(Intent intent) {
        this.f6318a = intent;
    }

    @Override // java.util.concurrent.Callable
    public HonorPushDataMsg call() throws Exception {
        byte[] byteArrayExtra;
        String string;
        Intent intent = this.f6318a;
        if (intent == null) {
            return null;
        }
        long longExtra = 0;
        try {
            longExtra = intent.getLongExtra("msg_id", 0L);
        } catch (Exception e2) {
            c.a("PassByMsgIntentParser", "parserMsgId", e2);
        }
        try {
            byteArrayExtra = this.f6318a.getByteArrayExtra("msg_content");
        } catch (Exception e3) {
            c.a("PassByMsgIntentParser", "parseMsgContent", e3);
            byteArrayExtra = null;
        }
        if (byteArrayExtra == null || byteArrayExtra.length == 0) {
            string = null;
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayExtra);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i2 = inflaterInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                string = byteArrayOutputStream.toString("UTF-8");
            } catch (IOException e4) {
                c.a("DeflateUtil", "unZipString", e4);
            } finally {
                b.a(byteArrayInputStream);
                b.a(inflaterInputStream);
                b.a(byteArrayOutputStream);
            }
        }
        if (string == null) {
            return null;
        }
        String strOptString = new JSONObject(string).optString("data");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
        honorPushDataMsg.setMsgId(longExtra);
        honorPushDataMsg.setData(strOptString);
        return honorPushDataMsg;
    }
}
