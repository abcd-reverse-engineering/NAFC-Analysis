package com.umeng.analytics.pro;

import androidx.core.app.FrameMetricsAggregator;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: TBaseHelper.java */
/* loaded from: classes2.dex */
public final class br {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f10195a = new a();

    /* compiled from: TBaseHelper.java */
    private static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? br.a((List) obj, (List) obj2) : obj instanceof Set ? br.a((Set) obj, (Set) obj2) : obj instanceof Map ? br.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? br.a((byte[]) obj, (byte[]) obj2) : br.a((Comparable) obj, (Comparable) obj2);
        }
    }

    private br() {
    }

    public static int a(byte b2, byte b3) {
        if (b2 < b3) {
            return -1;
        }
        return b3 < b2 ? 1 : 0;
    }

    public static int a(double d2, double d3) {
        if (d2 < d3) {
            return -1;
        }
        return d3 < d2 ? 1 : 0;
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i3 < i2 ? 1 : 0;
    }

    public static int a(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j3 < j2 ? 1 : 0;
    }

    public static int a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    public static int a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    public static boolean b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(a(byteBuffer));
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBufferWrap.array(), 0, byteBuffer.remaining());
        } else {
            byteBuffer.slice().get(byteBufferWrap.array());
        }
        return byteBufferWrap;
    }

    public static int a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int iA = a(bArr.length, bArr2.length);
        if (iA != 0) {
            return iA;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int iA2 = a(bArr[i2], bArr2[i2]);
            if (iA2 != 0) {
                return iA2;
            }
        }
        return 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(List list, List list2) {
        int iA = a(list.size(), list2.size());
        if (iA != 0) {
            return iA;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int iCompare = f10195a.compare(list.get(i2), list2.get(i2));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int iA = a(set.size(), set2.size());
        if (iA != 0) {
            return iA;
        }
        TreeSet treeSet = new TreeSet(f10195a);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(f10195a);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompare = f10195a.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int iA = a(map.size(), map2.size());
        if (iA != 0) {
            return iA;
        }
        TreeMap treeMap = new TreeMap(f10195a);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(f10195a);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iCompare = f10195a.compare(entry.getKey(), entry2.getKey());
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompare2 = f10195a.compare(entry.getValue(), entry2.getValue());
            if (iCompare2 != 0) {
                return iCompare2;
            }
        }
        return 0;
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        int iPosition = byteBuffer.position() + iArrayOffset;
        int iLimit = iArrayOffset + byteBuffer.limit();
        int i2 = iLimit - iPosition > 128 ? iPosition + 128 : iLimit;
        for (int i3 = iPosition; i3 < i2; i3++) {
            if (i3 > iPosition) {
                sb.append(c.c.a.b.a.a.f3100g);
            }
            sb.append(a(bArrArray[i3]));
        }
        if (iLimit != i2) {
            sb.append("...");
        }
    }

    public static String a(byte b2) {
        return Integer.toHexString((b2 | 256) & FrameMetricsAggregator.EVERY_DURATION).toUpperCase().substring(1);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        if (b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        int iRemaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i2, iRemaining);
        return iRemaining;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
