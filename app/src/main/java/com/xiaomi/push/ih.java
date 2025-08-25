package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class ih extends ik {

    /* renamed from: a, reason: collision with root package name */
    protected InputStream f13244a;

    /* renamed from: a, reason: collision with other field name */
    protected OutputStream f905a;

    protected ih() {
        this.f13244a = null;
        this.f905a = null;
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i2, int i3) throws il, IOException {
        InputStream inputStream = this.f13244a;
        if (inputStream == null) {
            throw new il(1, "Cannot read from null inputStream");
        }
        try {
            int i4 = inputStream.read(bArr, i2, i3);
            if (i4 >= 0) {
                return i4;
            }
            throw new il(4);
        } catch (IOException e2) {
            throw new il(0, e2);
        }
    }

    public ih(OutputStream outputStream) {
        this.f13244a = null;
        this.f905a = null;
        this.f905a = outputStream;
    }

    @Override // com.xiaomi.push.ik
    /* renamed from: a, reason: collision with other method in class */
    public void mo622a(byte[] bArr, int i2, int i3) throws il, IOException {
        OutputStream outputStream = this.f905a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i2, i3);
                return;
            } catch (IOException e2) {
                throw new il(0, e2);
            }
        }
        throw new il(1, "Cannot write to null outputStream");
    }
}
