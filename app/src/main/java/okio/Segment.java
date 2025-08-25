package okio;

import h.g2.q;
import h.q2.c;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import i.c.a.d;
import i.c.a.e;
import java.util.Arrays;

/* compiled from: Segment.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @c
    @d
    public final byte[] data;

    @c
    public int limit;

    @c
    @e
    public Segment next;

    @c
    public boolean owner;

    @c
    public int pos;

    @c
    @e
    public Segment prev;

    @c
    public boolean shared;

    /* compiled from: Segment.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i2 = 0;
        if (!(this.prev != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        Segment segment = this.prev;
        if (segment == null) {
            i0.f();
        }
        if (segment.owner) {
            int i3 = this.limit - this.pos;
            Segment segment2 = this.prev;
            if (segment2 == null) {
                i0.f();
            }
            int i4 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            if (segment3 == null) {
                i0.f();
            }
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                if (segment4 == null) {
                    i0.f();
                }
                i2 = segment4.pos;
            }
            if (i3 > i4 + i2) {
                return;
            }
            Segment segment5 = this.prev;
            if (segment5 == null) {
                i0.f();
            }
            writeTo(segment5, i3);
            pop();
            SegmentPool.INSTANCE.recycle(this);
        }
    }

    @e
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        if (segment2 == null) {
            i0.f();
        }
        segment2.next = this.next;
        Segment segment3 = this.next;
        if (segment3 == null) {
            i0.f();
        }
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @d
    public final Segment push(@d Segment segment) {
        i0.f(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 == null) {
            i0.f();
        }
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @d
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @d
    public final Segment split(int i2) {
        Segment segmentTake;
        if (!(i2 > 0 && i2 <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i2 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.INSTANCE.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i3 = this.pos;
            q.a(bArr, bArr2, 0, i3, i3 + i2, 2, (Object) null);
        }
        segmentTake.limit = segmentTake.pos + i2;
        this.pos += i2;
        Segment segment = this.prev;
        if (segment == null) {
            i0.f();
        }
        segment.push(segmentTake);
        return segmentTake;
    }

    @d
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@d Segment segment, int i2) {
        i0.f(segment, "sink");
        if (!segment.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i3 = segment.limit;
        if (i3 + i2 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i4 = segment.pos;
            if ((i3 + i2) - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            q.a(bArr, bArr, 0, i4, i3, 2, (Object) null);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i5 = segment.limit;
        int i6 = this.pos;
        q.a(bArr2, bArr3, i5, i6, i6 + i2);
        segment.limit += i2;
        this.pos += i2;
    }

    public Segment(@d byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        i0.f(bArr, "data");
        this.data = bArr;
        this.pos = i2;
        this.limit = i3;
        this.shared = z;
        this.owner = z2;
    }
}
