package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cw;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    protected String f9409a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f9410b;

    public l(int i2) {
        this.f9409a = "GBK";
        this.f9410b = ByteBuffer.allocate(i2);
    }

    public ByteBuffer a() {
        return this.f9410b;
    }

    public byte[] b() {
        byte[] bArr = new byte[this.f9410b.position()];
        System.arraycopy(this.f9410b.array(), 0, bArr, 0, this.f9410b.position());
        return bArr;
    }

    public void a(int i2) {
        if (this.f9410b.remaining() < i2) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.f9410b.capacity() + i2) * 2);
            byteBufferAllocate.put(this.f9410b.array(), 0, this.f9410b.position());
            this.f9410b = byteBufferAllocate;
        }
    }

    public void b(byte b2, int i2) {
        a(3);
        if (b2 == 0) {
            a((byte) 12, i2);
        } else {
            a((byte) 0, i2);
            this.f9410b.put(b2);
        }
    }

    public l() {
        this(128);
    }

    public void a(byte b2, int i2) {
        if (i2 < 15) {
            this.f9410b.put((byte) (b2 | (i2 << 4)));
        } else if (i2 < 256) {
            this.f9410b.put((byte) (b2 | 240));
            this.f9410b.put((byte) i2);
        } else {
            throw new j("tag is too large: " + i2);
        }
    }

    public void a(boolean z, int i2) {
        b(z ? (byte) 1 : (byte) 0, i2);
    }

    public void a(short s, int i2) {
        a(4);
        if (s >= -128 && s <= 127) {
            b((byte) s, i2);
        } else {
            a((byte) 1, i2);
            this.f9410b.putShort(s);
        }
    }

    public void a(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            a((short) i2, i3);
        } else {
            a((byte) 2, i3);
            this.f9410b.putInt(i2);
        }
    }

    public void a(long j2, int i2) {
        a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            a((int) j2, i2);
        } else {
            a((byte) 3, i2);
            this.f9410b.putLong(j2);
        }
    }

    public void a(float f2, int i2) {
        a(6);
        a((byte) 4, i2);
        this.f9410b.putFloat(f2);
    }

    public void a(double d2, int i2) {
        a(10);
        a((byte) 5, i2);
        this.f9410b.putDouble(d2);
    }

    public void a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f9409a);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            a((byte) 7, i2);
            this.f9410b.putInt(bytes.length);
            this.f9410b.put(bytes);
        } else {
            a((byte) 6, i2);
            this.f9410b.put((byte) bytes.length);
            this.f9410b.put(bytes);
        }
    }

    public <K, V> void a(Map<K, V> map, int i2) {
        a(8);
        a((byte) 8, i2);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public void a(boolean[] zArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(zArr.length, 0);
        for (boolean z : zArr) {
            a(z, 0);
        }
    }

    public void a(byte[] bArr, int i2) {
        a(bArr.length + 8);
        a(cw.f10301k, i2);
        a((byte) 0, 0);
        a(bArr.length, 0);
        this.f9410b.put(bArr);
    }

    public void a(short[] sArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(sArr.length, 0);
        for (short s : sArr) {
            a(s, 0);
        }
    }

    public void a(int[] iArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(iArr.length, 0);
        for (int i3 : iArr) {
            a(i3, 0);
        }
    }

    public void a(long[] jArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(jArr.length, 0);
        for (long j2 : jArr) {
            a(j2, 0);
        }
    }

    public void a(float[] fArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(fArr.length, 0);
        for (float f2 : fArr) {
            a(f2, 0);
        }
    }

    public void a(double[] dArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(dArr.length, 0);
        for (double d2 : dArr) {
            a(d2, 0);
        }
    }

    private void a(Object[] objArr, int i2) {
        a(8);
        a((byte) 9, i2);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public <T> void a(Collection<T> collection, int i2) {
        a(8);
        a((byte) 9, i2);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public void a(m mVar, int i2) {
        a(2);
        a((byte) 10, i2);
        mVar.a(this);
        a(2);
        a((byte) 11, 0);
    }

    public void a(Object obj, int i2) {
        if (obj instanceof Byte) {
            b(((Byte) obj).byteValue(), i2);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i2);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i2);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i2);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i2);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i2);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i2);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i2);
            return;
        }
        if (obj instanceof m) {
            a((m) obj, i2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i2);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i2);
            return;
        }
        if (obj.getClass().isArray()) {
            a((Object[]) obj, i2);
        } else {
            if (obj instanceof Collection) {
                a((Collection) obj, i2);
                return;
            }
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public int a(String str) {
        this.f9409a = str;
        return 0;
    }
}
