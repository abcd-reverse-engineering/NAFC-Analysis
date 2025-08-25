package okio.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.g2.n;
import h.g2.q;
import h.q2.t.i0;
import h.y;
import h.y1;
import i.c.a.d;
import i.c.a.e;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;

/* compiled from: SegmentedByteString.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0012*\u00020\bH\u0080\b\u001a%\u0010\u001a\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001aZ\u0010\u001e\u001a\u00020\u001b*\u00020\b2K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0080\b\u001aj\u0010\u001e\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0082\b\u001a\u0014\u0010$\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¨\u0006%"}, d2 = {"binarySearch", "", "", SurveyH5Bean.VALUE, "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", DispatchConstants.OTHER, "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "offset", "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "data", "segment", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@d int[] iArr, int i2, int i3, int i4) {
        i0.f(iArr, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else {
                if (i7 <= i2) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final boolean commonEquals(@d SegmentedByteString segmentedByteString, @e Object obj) {
        i0.f(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@d SegmentedByteString segmentedByteString) {
        i0.f(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@d SegmentedByteString segmentedByteString) {
        i0.f(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            byte[] bArr = segmentedByteString.getSegments$okio()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        segmentedByteString.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@d SegmentedByteString segmentedByteString, int i2) {
        i0.f(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i2, 1L);
        int iSegment = segment(segmentedByteString, i2);
        return segmentedByteString.getSegments$okio()[iSegment][(i2 - (iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(@d SegmentedByteString segmentedByteString, int i2, @d ByteString byteString, int i3, int i4) {
        i0.f(segmentedByteString, "$this$commonRangeEquals");
        i0.f(byteString, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > segmentedByteString.size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i7 = segmentedByteString.getDirectory$okio()[iSegment] - i6;
            int i8 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!byteString.rangeEquals(i3, segmentedByteString.getSegments$okio()[iSegment], i8 + (i2 - i6), iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iSegment++;
        }
        return true;
    }

    @d
    public static final ByteString commonSubstring(@d SegmentedByteString segmentedByteString, int i2, int i3) {
        i0.f(segmentedByteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
        if (!(i3 <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i4 = i3 - i2;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        if (i2 == 0 && i3 == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i2 == i3) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(segmentedByteString, i2);
        int iSegment2 = segment(segmentedByteString, i3 - 1);
        byte[][] bArr = (byte[][]) n.a(segmentedByteString.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i5 = iSegment;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(segmentedByteString.getDirectory$okio()[i5] - i2, i4);
                int i7 = i6 + 1;
                iArr[i6 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i5];
                if (i5 == iSegment2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = iSegment != 0 ? segmentedByteString.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i2 - i8);
        return new SegmentedByteString(bArr, iArr);
    }

    @d
    public static final byte[] commonToByteArray(@d SegmentedByteString segmentedByteString) {
        i0.f(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            int i7 = i6 - i3;
            q.a(segmentedByteString.getSegments$okio()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void commonWrite(@d SegmentedByteString segmentedByteString, @d Buffer buffer, int i2, int i3) {
        i0.f(segmentedByteString, "$this$commonWrite");
        i0.f(buffer, "buffer");
        int i4 = i3 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i2;
            int i8 = i7 + (i2 - i5);
            Segment segment = new Segment(segmentedByteString.getSegments$okio()[iSegment], i8, i8 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment.prev;
                buffer.head = segment.next;
            } else {
                if (segment2 == null) {
                    i0.f();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    i0.f();
                }
                segment3.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + segmentedByteString.size());
    }

    public static final void forEachSegment(@d SegmentedByteString segmentedByteString, @d h.q2.s.q<? super byte[], ? super Integer, ? super Integer, y1> qVar) {
        i0.f(segmentedByteString, "$this$forEachSegment");
        i0.f(qVar, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i2];
            int i5 = segmentedByteString.getDirectory$okio()[i2];
            qVar.invoke(segmentedByteString.getSegments$okio()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int segment(@d SegmentedByteString segmentedByteString, int i2) {
        i0.f(segmentedByteString, "$this$segment");
        int iBinarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i2 + 1, 0, segmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(@d SegmentedByteString segmentedByteString, int i2, int i3, h.q2.s.q<? super byte[], ? super Integer, ? super Integer, y1> qVar) {
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i5 = segmentedByteString.getDirectory$okio()[iSegment] - i4;
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i3, i5 + i4) - i2;
            qVar.invoke(segmentedByteString.getSegments$okio()[iSegment], Integer.valueOf(i6 + (i2 - i4)), Integer.valueOf(iMin));
            i2 += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(@d SegmentedByteString segmentedByteString, int i2, @d byte[] bArr, int i3, int i4) {
        i0.f(segmentedByteString, "$this$commonRangeEquals");
        i0.f(bArr, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > segmentedByteString.size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iSegment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i7 = segmentedByteString.getDirectory$okio()[iSegment] - i6;
            int i8 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[iSegment], i8 + (i2 - i6), bArr, i3, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iSegment++;
        }
        return true;
    }
}
