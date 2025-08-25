package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f9403a;

    /* renamed from: b, reason: collision with root package name */
    private int f9404b;

    public i(StringBuilder sb, int i2) {
        this.f9404b = 0;
        this.f9403a = sb;
        this.f9404b = i2;
    }

    private void a(String str) {
        for (int i2 = 0; i2 < this.f9404b; i2++) {
            this.f9403a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f9403a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public i a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public i a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append((int) b2);
        sb.append('\n');
        return this;
    }

    public i a(char c2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(c2);
        sb.append('\n');
        return this;
    }

    public i a(short s, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public i a(int i2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(i2);
        sb.append('\n');
        return this;
    }

    public i a(long j2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(j2);
        sb.append('\n');
        return this;
    }

    public i a(float f2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(f2);
        sb.append('\n');
        return this;
    }

    public i a(double d2, String str) {
        a(str);
        StringBuilder sb = this.f9403a;
        sb.append(d2);
        sb.append('\n');
        return this;
    }

    public i a(String str, String str2) {
        a(str2);
        if (str == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
        } else {
            StringBuilder sb2 = this.f9403a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    public i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(bArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (byte b2 : bArr) {
            iVar.a(b2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(sArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (short s : sArr) {
            iVar.a(s, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(iArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (int i2 : iArr) {
            iVar.a(i2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(jArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (long j2 : jArr) {
            iVar.a(j2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(fArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (float f2 : fArr) {
            iVar.a(f2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(dArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (double d2 : dArr) {
            iVar.a(d2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(map.size());
        sb3.append(", {");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        i iVar2 = new i(this.f9403a, this.f9404b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iVar.a('(', (String) null);
            iVar2.a((i) entry.getKey(), (String) null);
            iVar2.a((i) entry.getValue(), (String) null);
            iVar.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    public <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f9403a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f9403a;
        sb3.append(tArr.length);
        sb3.append(", [");
        sb3.append('\n');
        i iVar = new i(this.f9403a, this.f9404b + 1);
        for (T t : tArr) {
            iVar.a((i) t, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\t');
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> i a(T t, String str) {
        if (t == 0) {
            StringBuilder sb = this.f9403a;
            sb.append(c.c.a.b.a.a.f3101h);
            sb.append('\n');
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((Collection) t, str);
        } else if (t instanceof m) {
            a((m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((i) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb = this.f9403a;
            sb.append('\t');
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            mVar.a(this.f9403a, this.f9404b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
