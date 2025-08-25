package okio;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: GzipSource.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", CommonNetImpl.NAME, "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(@d Source source) {
        i0.f(source, "source");
        this.source = new RealBufferedSource(source);
        this.inflater = new Inflater(true);
        this.inflaterSource = new InflaterSource((BufferedSource) this.source, this.inflater);
        this.crc = new CRC32();
    }

    private final void checkEqual(String str, int i2, int i3) throws IOException {
        if (i3 == i2) {
            return;
        }
        Object[] objArr = {str, Integer.valueOf(i3), Integer.valueOf(i2)};
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(objArr, objArr.length));
        i0.a((Object) str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10L);
        byte b2 = this.source.bufferField.getByte(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            updateCrc(this.source.bufferField, 0L, 10L);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.source.require(2L);
            if (z) {
                updateCrc(this.source.bufferField, 0L, 2L);
            }
            long shortLe = this.source.bufferField.readShortLe();
            this.source.require(shortLe);
            if (z) {
                updateCrc(this.source.bufferField, 0L, shortLe);
            }
            this.source.skip(shortLe);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jIndexOf = this.source.indexOf((byte) 0);
            if (jIndexOf == -1) {
                throw new EOFException();
            }
            if (z) {
                updateCrc(this.source.bufferField, 0L, jIndexOf + 1);
            }
            this.source.skip(jIndexOf + 1);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jIndexOf2 = this.source.indexOf((byte) 0);
            if (jIndexOf2 == -1) {
                throw new EOFException();
            }
            if (z) {
                updateCrc(this.source.bufferField, 0L, jIndexOf2 + 1);
            }
            this.source.skip(jIndexOf2 + 1);
        }
        if (z) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j2, long j3) {
        Segment segment = buffer.head;
        if (segment == null) {
            i0.f();
        }
        while (true) {
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
        }
        while (j3 > 0) {
            int iMin = (int) Math.min(segment.limit - r7, j3);
            this.crc.update(segment.data, (int) (segment.pos + j2), iMin);
            j3 -= iMin;
            segment = segment.next;
            if (segment == null) {
                i0.f();
            }
            j2 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(@d Buffer buffer, long j2) throws DataFormatException, IOException {
        i0.f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        if (this.section == 0) {
            consumeHeader();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = buffer.size();
            long j3 = this.inflaterSource.read(buffer, j2);
            if (j3 != -1) {
                updateCrc(buffer, size, j3);
                return j3;
            }
            this.section = (byte) 2;
        }
        if (this.section == 2) {
            consumeTrailer();
            this.section = (byte) 3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // okio.Source
    @d
    public Timeout timeout() {
        return this.source.timeout();
    }
}
